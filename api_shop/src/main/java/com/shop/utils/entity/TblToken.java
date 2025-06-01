package com.shop.utils.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_tokens")
public class TblToken {
    @Id
    @ColumnDefault("nextval('tbl_tokens_tok_id_seq')")
    @Column(name = "tok_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tok_usu_id", nullable = false)
    private TblUsuario tokUsu;

    @Size(max = 255)
    @NotNull
    @Column(name = "tok_token", nullable = false)
    private String tokToken;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "tok_fecha_creacion")
    private Instant tokFechaCreacion;

    @NotNull
    @Column(name = "tok_fecha_expiracion", nullable = false)
    private Instant tokFechaExpiracion;

    @ColumnDefault("true")
    @Column(name = "tok_valido")
    private Boolean tokValido;

}