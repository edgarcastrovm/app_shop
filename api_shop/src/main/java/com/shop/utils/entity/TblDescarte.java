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
@Table(name = "tbl_descartes")
public class TblDescarte {
    @Id
    @ColumnDefault("nextval('tbl_descartes_des_id_seq')")
    @Column(name = "des_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "des_usu_id", nullable = false)
    private TblUsuario desUsu;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "des_pro_id", nullable = false)
    private TblProducto desPro;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "des_fecha")
    private Instant desFecha;

/*
 TODO [Reverse Engineering] create field to map the 'des_motivo' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "des_motivo", columnDefinition = "motivo_descarte")
    private Object desMotivo;
*/
}