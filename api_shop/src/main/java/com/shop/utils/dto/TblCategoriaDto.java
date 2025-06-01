package com.shop.utils.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link com.shop.utils.entity.TblCategoria}
 */

@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TblCategoriaDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 100)
    private String catNombre;
    private String catDescripcion;
    @Size(max = 255)
    private String catImagenUrl;
    public TblCategoriaDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public String getCatDescripcion() {
        return catDescripcion;
    }

    public void setCatDescripcion(String catDescripcion) {
        this.catDescripcion = catDescripcion;
    }

    public String getCatImagenUrl() {
        return catImagenUrl;
    }

    public void setCatImagenUrl(String catImagenUrl) {
        this.catImagenUrl = catImagenUrl;
    }
}