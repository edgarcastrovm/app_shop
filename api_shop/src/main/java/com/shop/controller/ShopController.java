package com.shop.controller;

import com.shop.config.http.ApiResponse;
import com.shop.config.http.RC;
import com.shop.service.dominio.ShopService;
import com.shop.utils.Constants;
import com.shop.utils.dto.dominio.ItemCarritoDto;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.API_V1 + "/shop")
public class ShopController {
    private final Logger log = LogManager.getLogger(ShopController.class);
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/productos")
    public ResponseEntity<?> listarProductos() {
        ApiResponse<?> response;
        try {
            response = shopService.listarProductos();
            return ResponseEntity.status(response.getCode()).body(response);
        } catch (Exception e) {
            log.error("Error al listar productos", e.getMessage());
            response = ApiResponse.error(RC.BAD_REQUEST, "Error al listar productos");
            return ResponseEntity.status(response.getCode()).body(response);
        }
    }

    @GetMapping("/getItemCart")
    public ResponseEntity<?> obtenerCart(HttpServletRequest request) {
        ApiResponse<?> response;
        String usuario = (String) request.getAttribute("userId");
        try {
            response = shopService.listarItemsCarrito(Long.parseLong(usuario));
            return ResponseEntity.status(response.getCode()).body(response);
        } catch (Exception e) {
            log.error("Error al agregar al carrito", e.getMessage());
            response = ApiResponse.error(RC.BAD_REQUEST, "Error al agregar al carrito");
            return ResponseEntity.status(response.getCode()).body(response);
        }
    }

    @PostMapping("/addItemCart")
    public ResponseEntity<?> agregarCart(HttpServletRequest request, @RequestBody ItemCarritoDto item) {
        ApiResponse<?> response;
        String usuario = (String) request.getAttribute("userId");
        try {
            response = shopService.agregarItemCart(item, Long.parseLong(usuario));
            return ResponseEntity.status(response.getCode()).body(response);
        } catch (Exception e) {
            log.error("Error al agregar al carrito", e.getMessage());
            response = ApiResponse.error(RC.BAD_REQUEST, "Error al agregar al carrito");
            return ResponseEntity.status(response.getCode()).body(response);
        }
    }
}
