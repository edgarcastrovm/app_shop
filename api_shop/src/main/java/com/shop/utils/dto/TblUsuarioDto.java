package com.shop.utils.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shop.utils.entity.TblUsuario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
 * DTO for {@link com.shop.utils.entity.TblUsuario}
 */
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class TblUsuarioDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String usuEmail;
    @NotNull
    @Size(max = 255)
    private String usuPasswordHash;
    @NotNull
    @Size(max = 100)
    private String usuNombre;
    @NotNull
    @Size(max = 100)
    private String usuApellido;
    @Size(max = 20)
    private String usuTelefono;
    private String usuDireccion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date usuFechaRegistro;
//    private Instant usuFechaRegistro;
    private Instant usuUltimoLogin;
    @Size(max = 100)
    private String usuRol;
    private Date usuFechaNacimiento;
    @Size(max = 100)
    private String usuCategoria;

    private String token;

    public TblUsuarioDto(){

    }

    public TblUsuarioDto(TblUsuario tblUsuario) {
        this.id = tblUsuario.getId();
        this.usuEmail = tblUsuario.getUsuEmail();
        this.usuPasswordHash = tblUsuario.getUsuPasswordHash();
        this.usuNombre = tblUsuario.getUsuNombre();
        this.usuApellido = tblUsuario.getUsuApellido();
        this.usuTelefono = tblUsuario.getUsuTelefono();
        this.usuDireccion = tblUsuario.getUsuDireccion();
        this.usuFechaRegistro = tblUsuario.getUsuFechaRegistro();
        this.usuRol = tblUsuario.getUsuRol();
        this.usuFechaNacimiento = tblUsuario.getUsuFechaNacimiento();
        this.usuCategoria = tblUsuario.getUsuCategoria();

    }

    public TblUsuarioDto(Integer id, String usuEmail, String usuPasswordHash, String usuNombre, String usuApellido, String usuTelefono, String usuDireccion, Date usuFechaRegistro, Instant usuUltimoLogin, String usuRol, Date usuFechaNacimiento, String usuCategoria) {
        this.id = id;
        this.usuEmail = usuEmail;
        this.usuPasswordHash = usuPasswordHash;
        this.usuNombre = usuNombre;
        this.usuApellido = usuApellido;
        this.usuTelefono = usuTelefono;
        this.usuDireccion = usuDireccion;
        this.usuFechaRegistro = usuFechaRegistro;
        this.usuUltimoLogin = usuUltimoLogin;
        this.usuRol = usuRol;
        this.usuFechaNacimiento = usuFechaNacimiento;
        this.usuCategoria = usuCategoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getUsuPasswordHash() {
        return usuPasswordHash;
    }

    public void setUsuPasswordHash(String usuPasswordHash) {
        this.usuPasswordHash = usuPasswordHash;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuTelefono() {
        return usuTelefono;
    }

    public void setUsuTelefono(String usuTelefono) {
        this.usuTelefono = usuTelefono;
    }

    public String getUsuDireccion() {
        return usuDireccion;
    }

    public void setUsuDireccion(String usuDireccion) {
        this.usuDireccion = usuDireccion;
    }

    public java.util.Date getUsuFechaRegistro() {
        return usuFechaRegistro;
    }

    public void setUsuFechaRegistro(Date usuFechaRegistro) {
        this.usuFechaRegistro = usuFechaRegistro;
    }

    public Instant getUsuUltimoLogin() {
        return usuUltimoLogin;
    }

    public void setUsuUltimoLogin(Instant usuUltimoLogin) {
        this.usuUltimoLogin = usuUltimoLogin;
    }

    public String getUsuRol() {
        return usuRol;
    }

    public void setUsuRol(String usuRol) {
        this.usuRol = usuRol;
    }

    public Date getUsuFechaNacimiento() {
        return usuFechaNacimiento;
    }

    public void setUsuFechaNacimiento(Date usuFechaNacimiento) {
        this.usuFechaNacimiento = usuFechaNacimiento;
    }

    public String getUsuCategoria() {
        return usuCategoria;
    }

    public void setUsuCategoria(String usuCategoria) {
        this.usuCategoria = usuCategoria;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}