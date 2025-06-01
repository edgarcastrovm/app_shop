package com.shop.controller;

import com.shop.config.http.ApiResponse;
import com.shop.config.http.RC;
import com.shop.service.dominio.UserService;
import com.shop.utils.Constants;
import com.shop.utils.Utils;
import com.shop.utils.dto.dominio.LoginDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API_PUBLIC + "/login")
public class SecurityController {
    private static final Logger log = LogManager.getLogger(SecurityController.class);

    private final UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        ApiResponse<?> response;
        String password = Utils.getMd5(loginDto.getPassword());
        log.info("login usuario: {} password: {}", loginDto.getEmail(), password);
        try {
            response = this.userService.login(loginDto.getEmail(), password);
            return ResponseEntity.status(response.getCode()).body(response);
        } catch (Exception e) {
            log.error("login usuario: {} error: {}", loginDto.getEmail(), e.getMessage());
            response = ApiResponse.error(RC.BAD_REQUEST, "Error en el login");
            return ResponseEntity.status(response.getCode()).body(response);
        }
    }
}
