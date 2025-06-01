package com.shop.utils.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.shop.utils.entity.TblCarrito}
 */
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TblCarritoDto implements Serializable {
    private Integer id;
    @NotNull
    private TblUsuarioDto carUsu;
    private Instant carFechaCreacion;
    private Instant carFechaActualizacion;

    public TblCarritoDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TblUsuarioDto getCarUsu() {
        return carUsu;
    }

    public void setCarUsu(TblUsuarioDto carUsu) {
        this.carUsu = carUsu;
    }

    public Instant getCarFechaCreacion() {
        return carFechaCreacion;
    }

    public void setCarFechaCreacion(Instant carFechaCreacion) {
        this.carFechaCreacion = carFechaCreacion;
    }

    public Instant getCarFechaActualizacion() {
        return carFechaActualizacion;
    }

    public void setCarFechaActualizacion(Instant carFechaActualizacion) {
        this.carFechaActualizacion = carFechaActualizacion;
    }
}