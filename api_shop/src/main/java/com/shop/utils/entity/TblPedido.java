package com.shop.utils.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_pedidos")
public class TblPedido {
    @Id
    @ColumnDefault("nextval('tbl_pedidos_ped_id_seq')")
    @Column(name = "ped_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ped_usu_id", nullable = false)
    private TblUsuario pedUsu;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "ped_fecha")
    private Instant pedFecha;

    @NotNull
    @Column(name = "ped_subtotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal pedSubtotal;

    @ColumnDefault("0.00")
    @Column(name = "ped_descuento", precision = 10, scale = 2)
    private BigDecimal pedDescuento;

    @NotNull
    @Column(name = "ped_impuestos", nullable = false, precision = 10, scale = 2)
    private BigDecimal pedImpuestos;

    @NotNull
    @Column(name = "ped_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal pedTotal;

    @NotNull
    @Column(name = "ped_direccion_envio", nullable = false, length = Integer.MAX_VALUE)
    private String pedDireccionEnvio;
    @Size(max = 255)
    @Column(name = "ped_transaccion_id")
    private String pedTransaccionId;

/*
 TODO [Reverse Engineering] create field to map the 'ped_estado' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @ColumnDefault("'Pendiente'")
    @Column(name = "ped_estado", columnDefinition = "estado_pedido")
    private Object pedEstado;
*/
/*
 TODO [Reverse Engineering] create field to map the 'ped_metodo_pago' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "ped_metodo_pago", columnDefinition = "metodo_pago not null")
    private Object pedMetodoPago;
*/
}