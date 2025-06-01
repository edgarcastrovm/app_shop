package com.shop.utils.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tbl_pedido_items")
public class TblPedidoItem {
    @Id
    @ColumnDefault("nextval('tbl_pedido_items_pei_id_seq')")
    @Column(name = "pei_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pei_ped_id", nullable = false)
    private TblPedido peiPed;

    @NotNull
    @Column(name = "pei_cantidad", nullable = false)
    private Integer peiCantidad;

    @NotNull
    @Column(name = "pei_precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal peiPrecioUnitario;

    @NotNull
    @Column(name = "pei_total_linea", nullable = false, precision = 10, scale = 2)
    private BigDecimal peiTotalLinea;

}