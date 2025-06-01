package com.shop.utils.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "tbl_preferencias")
public class TblPreferencia {
    @Id
    @ColumnDefault("nextval('tbl_preferencias_pre_id_seq')")
    @Column(name = "pre_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pre_usu_id", nullable = false)
    private TblUsuario preUsu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pre_cat_id")
    private TblCategoria preCat;

}