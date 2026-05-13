package com.posicionup.crm;

import jakarta.mail.*;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmailReaderService {

    public List<Map<String, String>> leerCorreos() {

        List<Map<String, String>> lista = new ArrayList<>();

        Store store = null;
        Folder folder = null;

        try {

            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");

            // 🔥 SSL (IMPORTANTE)
            props.put("mail.imaps.ssl.enable", "true");
            props.put("mail.imaps.ssl.trust", "*");

            // 🔥 TIMEOUTS (solo una vez y coherente)
            props.put("mail.imaps.connectiontimeout", "8000");
            props.put("mail.imaps.timeout", "8000");
            props.put("mail.imaps.writetimeout", "8000");

            Session session = Session.getInstance(props);
            session.setDebug(true); // 🔥 para ver errores reales

            store = session.getStore("imaps");

            System.out.println("🔌 Conectando a Gmail...");

            store.connect(
                    "imap.gmail.com",
                    "posicionup.agencia@gmail.com",
                    "ywgubypasclyfhxx" // ✅ tu password de app
            );

            folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            int total = folder.getMessageCount();
            System.out.println("📩 TOTAL MENSAJES: " + total);

            if (total == 0) return lista;

            // 🔥 SOLO ÚLTIMOS 5 (evita cuelgues)
            int max = 5;
            int start = Math.max(1, total - max + 1);

            Message[] mensajes = folder.getMessages(start, total);

            FetchProfile fp = new FetchProfile();
            fp.add(FetchProfile.Item.ENVELOPE);
            folder.fetch(mensajes, fp);

            // 🔥 MÁS NUEVOS PRIMERO
            for (int i = mensajes.length - 1; i >= 0; i--) {

                Message m = mensajes[i];

                Map<String, String> correo = new HashMap<>();

                correo.put("asunto",
                        m.getSubject() != null ? m.getSubject() : "(Sin asunto)");

                correo.put("de",
                        (m.getFrom() != null && m.getFrom().length > 0)
                                ? m.getFrom()[0].toString()
                                : "(Desconocido)");

                correo.put("fecha",
                        m.getReceivedDate() != null
                                ? m.getReceivedDate().toString()
                                : "");

                // 🔥 CONTENIDO MEJORADO (soporta HTML y texto)
                correo.put("contenido", obtenerContenido(m));

                lista.add(correo);
            }

            System.out.println("✅ CORREOS CARGADOS: " + lista.size());

        } catch (Exception e) {
            System.out.println("❌ ERROR LEYENDO CORREOS");
            e.printStackTrace();

            // 🔥 fallback para que el front no se quede en "cargando"
            Map<String, String> error = new HashMap<>();
            error.put("asunto", "Error cargando correos");
            error.put("de", "Sistema");
            error.put("fecha", "");
            error.put("contenido", "Revisa Gmail / contraseña / conexión");

            lista.add(error);

        } finally {
            try {
                if (folder != null && folder.isOpen()) folder.close(false);
                if (store != null) store.close();
            } catch (Exception ignored) {}
        }

        return lista;
    }

    // 🔥 EXTRAER CONTENIDO REAL DEL EMAIL
    private String obtenerContenido(Part p) {
        try {

            if (p.isMimeType("text/plain")) {
                return p.getContent().toString();
            }

            if (p.isMimeType("text/html")) {
                String html = p.getContent().toString();
                return html.replaceAll("<[^>]+>", "").trim();
            }

            if (p.isMimeType("multipart/*")) {
                MimeMultipart multipart = (MimeMultipart) p.getContent();

                for (int i = 0; i < multipart.getCount(); i++) {
                    BodyPart bodyPart = multipart.getBodyPart(i);

                    String result = obtenerContenido(bodyPart);

                    if (result != null && !result.trim().isEmpty()) {
                        return result;
                    }
                }
            }

        } catch (Exception e) {
            return "(Error leyendo contenido)";
        }

        return "";
    }
}