package com.shop.utils.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tbl_productos")
public class TblProducto {
    @Id
    @ColumnDefault("nextval('tbl_productos_pro_id_seq')")
    @Column(name = "pro_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "pro_codigo", nullable = false, length = 50)
    private String proCodigo;

    @Size(max = 255)
    @NotNull
    @Column(name = "pro_nombre", nullable = false)
    private String proNombre;

    @Column(name = "pro_descripcion", length = Integer.MAX_VALUE)
    private String proDescripcion;

    @NotNull
    @Column(name = "pro_precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal proPrecio;

    @Size(max = 100)
    @Column(name = "pro_marca", length = 100)
    private String proMarca;

    @Size(max = 100)
    @Column(name = "pro_color", length = 100)
    private String proColor;

    @Size(max = 100)
    @Column(name = "pro_talla", length = 100)
    private String proTalla;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pro_cat_id", nullable = false)
    private TblCategoria proCat;

    @NotNull
    @Column(name = "pro_stock", nullable = false)
    private Integer proStock;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "pro_fecha_creacion")
    private Instant proFechaCreacion;

    @ColumnDefault("true")
    @Column(name = "pro_activo")
    private Boolean proActivo;

    public TblProducto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public BigDecimal getProPrecio() {
        return proPrecio;
    }

    public void setProPrecio(BigDecimal proPrecio) {
        this.proPrecio = proPrecio;
    }

    public String getProMarca() {
        return proMarca;
    }

    public void setProMarca(String proMarca) {
        this.proMarca = proMarca;
    }

    public String getProColor() {
        return proColor;
    }

    public void setProColor(String proColor) {
        this.proColor = proColor;
    }

    public String getProTalla() {
        return proTalla;
    }

    public void setProTalla(String proTalla) {
        this.proTalla = proTalla;
    }

    public TblCategoria getProCat() {
        return proCat;
    }

    public void setProCat(TblCategoria proCat) {
        this.proCat = proCat;
    }

    public Integer getProStock() {
        return proStock;
    }

    public void setProStock(Integer proStock) {
        this.proStock = proStock;
    }

    public Instant getProFechaCreacion() {
        return proFechaCreacion;
    }

    public void setProFechaCreacion(Instant proFechaCreacion) {
        this.proFechaCreacion = proFechaCreacion;
    }

    public Boolean getProActivo() {
        return proActivo;
    }

    public void setProActivo(Boolean proActivo) {
        this.proActivo = proActivo;
    }
}