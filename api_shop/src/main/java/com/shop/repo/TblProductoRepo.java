package com.shop.repo;

import com.shop.utils.entity.TblProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TblProductoRepo  extends JpaRepository<TblProducto, Long> {
}
