package com.shop.repo;

import com.shop.utils.entity.TblCarrito;
import com.shop.utils.entity.TblCarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TblCarritoItemRepo extends JpaRepository<TblCarritoItem, Long> {
    List<TblCarritoItem> findAllByCaiCar(TblCarrito tblCarrito);
}
