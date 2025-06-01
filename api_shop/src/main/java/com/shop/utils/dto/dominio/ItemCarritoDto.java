package com.shop.utils.dto.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shop.utils.entity.TblCarritoItem;

import java.math.BigDecimal;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemCarritoDto {
    private Integer id;
    private Long carId;
    private Long proId;
    private Integer catidad;
    private String nombre;
    private BigDecimal precio;
    private BigDecimal precioTotal;

    public ItemCarritoDto() {
    }

    public ItemCarritoDto(TblCarritoItem tblCarritoItem) {
        this.id = tblCarritoItem.getId();
        this.carId = tblCarritoItem.getCaiCar().getId().longValue();
        this.proId = tblCarritoItem.getCaiProd().getId().longValue();
        this.catidad = tblCarritoItem.getCaiCantidad();
        this.precio = tblCarritoItem.getCaiProd().getProPrecio();
        this.precioTotal = tblCarritoItem.getCaiProd().getProPrecio().multiply(BigDecimal.valueOf(this.catidad));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public Integer getCatidad() {
        return catidad;
    }

    public void setCatidad(Integer catidad) {
        this.catidad = catidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }
}
