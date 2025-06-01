package com.shop.service.dominio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.config.http.ApiResponse;
import com.shop.config.http.RC;
import com.shop.config.security.JwtUtil;
import com.shop.repo.TblUsuarioRepo;
import com.shop.utils.dto.TblUsuarioDto;
import com.shop.utils.entity.TblUsuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final Logger log = LogManager.getLogger(UserService.class);

    private ObjectMapper mapper = new ObjectMapper();

    private final TblUsuarioRepo tblUsuarioRepo;
    private final JwtUtil jwtUtil;

    public UserService(TblUsuarioRepo tblUsuarioRepo, JwtUtil jwtUtil) {
        this.tblUsuarioRepo = tblUsuarioRepo;
        this.jwtUtil = jwtUtil;
    }

    public ApiResponse<TblUsuarioDto> login(String email, String password) {
        Optional<TblUsuario> item = tblUsuarioRepo.findByUsuEmailAndUsuPasswordHash(email,password);
        if(item.isPresent()){
            TblUsuarioDto user = mapper.convertValue(item.get(), TblUsuarioDto.class);
            log.info("Login successful {}", user.getUsuEmail());
            String token = jwtUtil.generarToken(user.getId().toString());
            user.setToken(token);
            log.info("Login successful token {}", user.getToken());
            return ApiResponse.success(user);
        }else{
            log.error("Login failed");
            return ApiResponse.error(RC.NOT_FOUND,"Usuario o cantraseña invalida");
        }
    }
}
