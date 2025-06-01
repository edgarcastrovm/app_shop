package com.shop.utils.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "tbl_usuarios")
public class TblUsuario {
    @Id
    @ColumnDefault("nextval('tbl_usuarios_usu_id_seq')")
    @Column(name = "usu_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "usu_email", nullable = false)
    private String usuEmail;

    @Size(max = 255)
    @NotNull
    @Column(name = "usu_password_hash", nullable = false)
    private String usuPasswordHash;

    @Size(max = 100)
    @NotNull
    @Column(name = "usu_nombre", nullable = false, length = 100)
    private String usuNombre;

    @Size(max = 100)
    @NotNull
    @Column(name = "usu_apellido", nullable = false, length = 100)
    private String usuApellido;

    @Size(max = 20)
    @Column(name = "usu_telefono", length = 20)
    private String usuTelefono;

    @Column(name = "usu_direccion", length = Integer.MAX_VALUE)
    private String usuDireccion;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "usu_fecha_registro")
    private java.util.Date usuFechaRegistro;

    @Column(name = "usu_ultimo_login")
    private Instant usuUltimoLogin;

    @Size(max = 100)
    @Column(name = "usu_rol", length = 100)
    private String usuRol;

    @Column(name = "usu_fecha_nacimiento")
    private Date usuFechaNacimiento;

    @Size(max = 100)
    @Column(name = "usu_categoria", length = 100)
    private String usuCategoria;

    public TblUsuario() {
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

    public Date getUsuFechaRegistro() {
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
}