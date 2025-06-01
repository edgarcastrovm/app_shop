package com.shop.utils.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shop.utils.entity.TblCategoria;
import com.shop.utils.entity.TblProducto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.shop.utils.entity.TblProducto}
 */
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class TblProductoDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 50)
    private String proCodigo;
    @NotNull
    @Size(max = 255)
    private String proNombre;
    private String proDescripcion;
    @NotNull
    private BigDecimal proPrecio;
    @Size(max = 100)
    private String proMarca;
    @Size(max = 100)
    private String proColor;
    @Size(max = 100)
    private String proTalla;
    @NotNull
    private TblCategoria proCat;
    @NotNull
    private Integer proStock;
    private Instant proFechaCreacion;
    private Boolean proActivo;

    public TblProductoDto() {
    }

    public TblProductoDto(TblProducto tblProducto) {
        this.id = tblProducto.getId();
        this.proCodigo = tblProducto.getProCodigo();
        this.proNombre = tblProducto.getProNombre();
        this.proDescripcion = tblProducto.getProDescripcion();
        this.proPrecio = tblProducto.getProPrecio();
        this.proMarca = tblProducto.getProMarca();
        this.proColor = tblProducto.getProColor();
        this.proTalla = tblProducto.getProTalla();
        this.proCat = tblProducto.getProCat();
        this.proStock = tblProducto.getProStock();
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