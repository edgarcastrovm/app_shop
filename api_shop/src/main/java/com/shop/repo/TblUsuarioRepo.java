package com.shop.repo;

import com.shop.utils.entity.TblUsuario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TblUsuarioRepo  extends JpaRepository<TblUsuario, Long> {

    Optional<TblUsuario> findByUsuEmailAndUsuPasswordHash(@Size(max = 255) @NotNull String usuEmail, @Size(max = 255) @NotNull String usuPasswordHash);
}
