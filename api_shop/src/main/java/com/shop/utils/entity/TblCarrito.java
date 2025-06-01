package com.shop.utils.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "tbl_carritos")
public class TblCarrito {
    @Id
//    @ColumnDefault("nextval('tbl_carritos_car_id_seq')")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_car_id_gen")
    @SequenceGenerator(name = "tbl_car_id_gen", sequenceName = "tbl_carritos_car_id_seq", allocationSize = 1)
    @Column(name = "car_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_usu_id", nullable = false)
    private TblUsuario carUsu;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "car_fecha_creacion")
    private Instant carFechaCreacion;

    @Column(name = "car_fecha_actualizacion")
    private Instant carFechaActualizacion;

    public TblCarrito() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TblUsuario getCarUsu() {
        return carUsu;
    }

    public void setCarUsu(TblUsuario carUsu) {
        this.carUsu = carUsu;
    }

    public Instant getCarFechaCreacion() {
        return carFechaCreacion;
    }

    public void setCarFechaCreacion(Instant carFechaCreacion) {
        this.carFechaCreacion = carFechaCreacion;
    }

    public Instant getCarFechaActualizacion() {
        return carFechaActualizacion;
    }

    public void setCarFechaActualizacion(Instant carFechaActualizacion) {
        this.carFechaActualizacion = carFechaActualizacion;
    }
}