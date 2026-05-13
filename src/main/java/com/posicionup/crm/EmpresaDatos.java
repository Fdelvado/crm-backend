package com.posicionup.crm;

import jakarta.persistence.*;

@Entity
public class EmpresaDatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    private String nombre;
    private String cif;
    private String direccion;
    private String cnae;
    private String iae;
    private String actividad;
    private String fechaInicio;
    private String cuentas;

    private String admin;
    private String dniAdmin;
    private String iban;
    private String rea;

    private String seguroCompania;
    private String seguroPoliza;
    private String seguroCobertura;
    private String seguroVigencia;

    private String seguroExtra;
    private String convenio;
    private String mutua;

    private String email;
    private String telefono;
    private String contacto;
    private String cuota;

    private String notario;
    private String fechaConst;
    private String protocolo;
    private String libro;
    private String tomo;
    private String registro;

    // 🔥 GETTERS Y SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCif() { return cif; }
    public void setCif(String cif) { this.cif = cif; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCnae() { return cnae; }
    public void setCnae(String cnae) { this.cnae = cnae; }

    public String getIae() { return iae; }
    public void setIae(String iae) { this.iae = iae; }

    public String getActividad() { return actividad; }
    public void setActividad(String actividad) { this.actividad = actividad; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getCuentas() { return cuentas; }
    public void setCuentas(String cuentas) { this.cuentas = cuentas; }

    public String getAdmin() { return admin; }
    public void setAdmin(String admin) { this.admin = admin; }

    public String getDniAdmin() { return dniAdmin; }
    public void setDniAdmin(String dniAdmin) { this.dniAdmin = dniAdmin; }

    public String getIban() { return iban; }
    public void setIban(String iban) { this.iban = iban; }

    public String getRea() { return rea; }
    public void setRea(String rea) { this.rea = rea; }

    public String getSeguroCompania() { return seguroCompania; }
    public void setSeguroCompania(String seguroCompania) { this.seguroCompania = seguroCompania; }

    public String getSeguroPoliza() { return seguroPoliza; }
    public void setSeguroPoliza(String seguroPoliza) { this.seguroPoliza = seguroPoliza; }

    public String getSeguroCobertura() { return seguroCobertura; }
    public void setSeguroCobertura(String seguroCobertura) { this.seguroCobertura = seguroCobertura; }

    public String getSeguroVigencia() { return seguroVigencia; }
    public void setSeguroVigencia(String seguroVigencia) { this.seguroVigencia = seguroVigencia; }

    public String getSeguroExtra() { return seguroExtra; }
    public void setSeguroExtra(String seguroExtra) { this.seguroExtra = seguroExtra; }

    public String getConvenio() { return convenio; }
    public void setConvenio(String convenio) { this.convenio = convenio; }

    public String getMutua() { return mutua; }
    public void setMutua(String mutua) { this.mutua = mutua; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getCuota() { return cuota; }
    public void setCuota(String cuota) { this.cuota = cuota; }

    public String getNotario() { return notario; }
    public void setNotario(String notario) { this.notario = notario; }

    public String getFechaConst() { return fechaConst; }
    public void setFechaConst(String fechaConst) { this.fechaConst = fechaConst; }

    public String getProtocolo() { return protocolo; }
    public void setProtocolo(String protocolo) { this.protocolo = protocolo; }

    public String getLibro() { return libro; }
    public void setLibro(String libro) { this.libro = libro; }

    public String getTomo() { return tomo; }
    public void setTomo(String tomo) { this.tomo = tomo; }

    public String getRegistro() { return registro; }
    public void setRegistro(String registro) { this.registro = registro; }
}