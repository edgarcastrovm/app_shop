package com.shop.utils.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "tbl_categorias")
public class TblCategoria {
    @Id
    @ColumnDefault("nextval('tbl_categorias_cat_id_seq')")
    @Column(name = "cat_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "cat_nombre", nullable = false, length = 100)
    private String catNombre;

    @Column(name = "cat_descripcion", length = Integer.MAX_VALUE)
    private String catDescripcion;

    @Size(max = 255)
    @Column(name = "cat_imagen_url")
    private String catImagenUrl;

}