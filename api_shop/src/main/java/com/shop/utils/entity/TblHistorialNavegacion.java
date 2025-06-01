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
@Table(name = "tbl_historial_navegacion")
public class TblHistorialNavegacion {
    @Id
    @ColumnDefault("nextval('tbl_historial_navegacion_hna_id_seq')")
    @Column(name = "hna_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hna_usu_id", nullable = false)
    private TblUsuario hnaUsu;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hna_pro_id", nullable = false)
    private TblProducto hnaPro;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "hna_fecha_hora")
    private Instant hnaFechaHora;

    @Column(name = "hna_duracion_segundos")
    private Integer hnaDuracionSegundos;

}