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
@Table(name = "tbl_facturas")
public class TblFactura {
    @Id
    @ColumnDefault("nextval('tbl_facturas_fac_id_seq')")
    @Column(name = "fac_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fac_ped_id", nullable = false)
    private TblPedido facPed;

    @Size(max = 50)
    @NotNull
    @Column(name = "fac_numero", nullable = false, length = 50)
    private String facNumero;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fac_fecha_emision")
    private Instant facFechaEmision;

    @Column(name = "fac_fecha_vencimiento")
    private Instant facFechaVencimiento;

/*
 TODO [Reverse Engineering] create field to map the 'fac_estado' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @ColumnDefault("'Pendiente'")
    @Column(name = "fac_estado", columnDefinition = "estado_factura")
    private Object facEstado;
*/
}