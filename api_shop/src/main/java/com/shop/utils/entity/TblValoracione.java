package com.shop.utils.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_valoraciones")
public class TblValoracione {
    @Id
    @ColumnDefault("nextval('tbl_valoraciones_val_id_seq')")
    @Column(name = "val_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "val_usu_id", nullable = false)
    private TblUsuario valUsu;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "val_pro_id", nullable = false)
    private TblProducto valPro;

    @NotNull
    @Column(name = "val_puntuacion", nullable = false)
    private Integer valPuntuacion;

    @Column(name = "val_comentario", length = Integer.MAX_VALUE)
    private String valComentario;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "val_fecha")
    private Instant valFecha;

}