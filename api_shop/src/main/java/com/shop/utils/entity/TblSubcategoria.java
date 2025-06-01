package com.shop.utils.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "tbl_subcategorias")
public class TblSubcategoria {
    @Id
    @ColumnDefault("nextval('tbl_subcategorias_subcat_id_seq')")
    @Column(name = "subcat_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "subcat_nombre", nullable = false, length = 100)
    private String subcatNombre;

    @Column(name = "subcat_descripcion", length = Integer.MAX_VALUE)
    private String subcatDescripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_padre_id")
    private TblCategoria catPadre;

}