package com.shop.utils.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.shop.utils.entity.TblCarritoItem}
 */
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TblCarritoItemDto implements Serializable {
    private Integer id;
    @NotNull
    private TblCarritoDto caiCar;
    @NotNull
    private TblProductoDto caiProd;
    @NotNull
    private Integer caiCantidad;
    private Instant caiFechaAgregado;

    public TblCarritoItemDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TblCarritoDto getCaiCar() {
        return caiCar;
    }

    public void setCaiCar(TblCarritoDto caiCar) {
        this.caiCar = caiCar;
    }

    public TblProductoDto getCaiProd() {
        return caiProd;
    }

    public void setCaiProd(TblProductoDto caiProd) {
        this.caiProd = caiProd;
    }

    public Integer getCaiCantidad() {
        return caiCantidad;
    }

    public void setCaiCantidad(Integer caiCantidad) {
        this.caiCantidad = caiCantidad;
    }

    public Instant getCaiFechaAgregado() {
        return caiFechaAgregado;
    }

    public void setCaiFechaAgregado(Instant caiFechaAgregado) {
        this.caiFechaAgregado = caiFechaAgregado;
    }
}