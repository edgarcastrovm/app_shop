package com.shop.repo;

import com.shop.utils.entity.TblCarrito;
import com.shop.utils.entity.TblUsuario;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TblCarritoRepo  extends JpaRepository<TblCarrito, Long> {
    Optional<TblCarrito> findByCarUsu_Id(Long idUsuario);

    Optional<TblCarrito> findByCarUsu(@NotNull TblUsuario carUsu);
}
