package com.shop.service.dominio;

import com.shop.config.http.ApiResponse;
import com.shop.config.http.RC;
import com.shop.controller.ShopController;
import com.shop.repo.TblCarritoItemRepo;
import com.shop.repo.TblCarritoRepo;
import com.shop.repo.TblProductoRepo;
import com.shop.repo.TblUsuarioRepo;
import com.shop.utils.dto.TblCarritoItemDto;
import com.shop.utils.dto.TblProductoDto;
import com.shop.utils.dto.dominio.ItemCarritoDto;
import com.shop.utils.entity.TblCarrito;
import com.shop.utils.entity.TblCarritoItem;
import com.shop.utils.entity.TblProducto;
import com.shop.utils.entity.TblUsuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final Logger log = LogManager.getLogger(ShopController.class);
    private final TblProductoRepo tblProductoRepo;
    private final TblCarritoRepo tblCarritoRepo;
    private final TblUsuarioRepo tblUsuarioRepo;
    private final TblCarritoItemRepo tblCarritoItemRepo;

    public ShopService(TblProductoRepo tblProductoRepo, TblCarritoRepo tblCarritoRepo,  TblUsuarioRepo tblUsuarioRepo, TblCarritoItemRepo tblCarritoItemRepo) {
        this.tblProductoRepo = tblProductoRepo;
        this.tblCarritoRepo = tblCarritoRepo;
        this.tblUsuarioRepo = tblUsuarioRepo;
        this.tblCarritoItemRepo = tblCarritoItemRepo;
    }

    public ApiResponse<List<TblProductoDto>> listarProductos() {
        List<TblProducto> productos = tblProductoRepo.findAll();

        if (productos.isEmpty()) {
            return ApiResponse.error(RC.OK,"No se encontro el producto");
        }
        List<TblProductoDto> items =productos.stream().map(TblProductoDto::new).collect(Collectors.toList());
        return ApiResponse.success(items);
    }

    public ApiResponse<ItemCarritoDto> agregarItemCart(ItemCarritoDto item,Long idUsuario) {

        Optional<TblProducto> producto = tblProductoRepo.findById(item.getProId());
        Optional<TblCarrito> carrito;
        Optional<TblUsuario> usuario = tblUsuarioRepo.findById(idUsuario);
        TblCarrito _carrito;

        if (!producto.isPresent()) {
            log.error("No se encontro el producto");
            return ApiResponse.error(RC.BAD_REQUEST,"No se encontro el producto");
        }

        if(item.getCarId() ==null || item.getCarId()==0) {
            carrito = tblCarritoRepo.findByCarUsu(usuario.get());
            if (!carrito.isPresent()) {
                _carrito = new TblCarrito();
                _carrito.setCarUsu(usuario.get());
                _carrito.setCarFechaCreacion(new Date().toInstant());
                _carrito.setCarFechaActualizacion(new Date().toInstant());
                tblCarritoRepo.save(_carrito);
            }else{
                _carrito = carrito.get();
            }
        }else{
            carrito = tblCarritoRepo.findById(item.getCarId());
            if (!carrito.isPresent()) {
                log.error("No se encontro el carrito");
                return ApiResponse.error(RC.OK,"No se pudo crear el carrito");
            }
            _carrito = carrito.get();
        }


        TblCarritoItem carritoItem = new TblCarritoItem();
        carritoItem.setCaiCantidad(item.getCatidad().intValue());
        carritoItem.setCaiCar(_carrito);
        carritoItem.setCaiProd(producto.get());
        carritoItem.setCaiFechaAgregado(new Date().toInstant());
        tblCarritoItemRepo.save(carritoItem);

        if (carritoItem.getId() == null) {
            log.error("No se pudo agregar el item");
            return ApiResponse.error(RC.OK,"No se pudo agregar el item");
        }
        return ApiResponse.success(item);
    }

    public ApiResponse<List<ItemCarritoDto>> listarItemsCarrito(Long idUsuario) {
        Optional<TblCarrito> carrito = tblCarritoRepo.findByCarUsu_Id(idUsuario);

        if (!carrito.isPresent()) {
            return ApiResponse.error(RC.OK,"No se encontraron items");
        }

        List<TblCarritoItem> items = tblCarritoItemRepo.findAllByCaiCar(carrito.get());

        if (items.isEmpty()) {
            return ApiResponse.error(RC.OK,"No se encontraron items");
        }
        List<ItemCarritoDto> _items =items.stream().map(ItemCarritoDto::new).collect(Collectors.toList());
        return ApiResponse.success(_items);
    }

}
