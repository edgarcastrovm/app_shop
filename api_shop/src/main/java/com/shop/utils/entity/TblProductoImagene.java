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
@Table(name = "tbl_producto_imagenes")
public class TblProductoImagene {
    @Id
    @ColumnDefault("nextval('tbl_producto_imagenes_pri_id_seq')")
    @Column(name = "pri_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pri_pro_id", nullable = false)
    private TblProducto priPro;

    @Size(max = 255)
    @NotNull
    @Column(name = "pri_url_imagen", nullable = false)
    private String priUrlImagen;

    @ColumnDefault("0")
    @Column(name = "pri_orden")
    private Integer priOrden;

    @ColumnDefault("false")
    @Column(name = "pri_principal")
    private Boolean priPrincipal;

}