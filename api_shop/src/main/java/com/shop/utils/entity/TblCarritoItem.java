package com.shop.utils.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbl_carrito_items")
public class TblCarritoItem {
    @Id
//    @ColumnDefault("nextval('tbl_carrito_items_cai_id_seq')")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_cai_id_gen")
    @SequenceGenerator(name = "tbl_cai_id_gen", sequenceName = "tbl_carrito_items_cai_id_seq", allocationSize = 1)
    @Column(name = "cai_id", nullable = false)
    private Integer id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cai_car_id", nullable = false)
    private TblCarrito caiCar;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cai_pro_id", nullable = false)
    private TblProducto caiProd;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "cai_cantidad", nullable = false)
    private Integer caiCantidad;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "cai_fecha_agregado")
    private Instant caiFechaAgregado;

    public TblCarritoItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TblCarrito getCaiCar() {
        return caiCar;
    }

    public void setCaiCar(TblCarrito caiCar) {
        this.caiCar = caiCar;
    }

    public TblProducto getCaiProd() {
        return caiProd;
    }

    public void setCaiProd(TblProducto caiProd) {
        this.caiProd = caiProd;
    }

    public Integer getCaiCantidad() {
        return caiCantidad;
    }

    public void setCaiCantidad(Integer caiCantidad) {
        this.caiCantidad = caiCantidad;
    }

    public Instant getCaiFechaAgregado() {
        return caiFechaAgregado;
    }

    public void setCaiFechaAgregado(Instant caiFechaAgregado) {
        this.caiFechaAgregado = caiFechaAgregado;
    }
}