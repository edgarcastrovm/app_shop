CREATE TABLE tbl_usuarios (
    usu_id SERIAL PRIMARY KEY,
    usu_email VARCHAR(255) UNIQUE NOT NULL,
    usu_password_hash VARCHAR(255) NOT NULL,
    usu_nombre VARCHAR(100) NOT NULL,
    usu_apellido VARCHAR(100) NOT NULL,
    usu_telefono VARCHAR(20),
    usu_direccion TEXT,
    usu_fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usu_ultimo_login TIMESTAMP,
    usu_rol VARCHAR(100),
    usu_fecha_nacimiento DATE,
    usu_categoria VARCHAR(100)
);

CREATE TABLE tbl_tokens (
    tok_id SERIAL PRIMARY KEY,
    tok_usu_id INT NOT NULL,
    tok_token VARCHAR(255) NOT NULL,
    tok_fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tok_fecha_expiracion TIMESTAMP NOT NULL,
    tok_valido BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (tok_usu_id) REFERENCES tbl_usuarios(usu_id)
);

-- Administración de productos y categorías
 

CREATE TABLE tbl_categorias (
    cat_id SERIAL PRIMARY KEY,
    cat_nombre VARCHAR(100) NOT NULL,
    cat_descripcion TEXT,
    cat_imagen_url VARCHAR(255)    
);

CREATE TABLE tbl_subcategorias (
    subcat_id SERIAL PRIMARY KEY,
    subcat_nombre VARCHAR(100) NOT NULL,
    subcat_descripcion TEXT,
    cat_padre_id INT,
    FOREIGN KEY (cat_padre_id) REFERENCES tbl_categorias(cat_id)
);

CREATE TABLE tbl_productos (
    pro_id SERIAL PRIMARY KEY,
    pro_codigo VARCHAR(50) UNIQUE NOT NULL,
    pro_nombre VARCHAR(255) NOT NULL,
    pro_descripcion TEXT,
    pro_precio DECIMAL(10,2) NOT NULL,
    pro_marca VARCHAR(100),
    pro_color VARCHAR(100),
    pro_talla VARCHAR(100),
    pro_cat_id INT NOT NULL,
    pro_stock INT NOT NULL,
    pro_fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    pro_activo BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (pro_cat_id) REFERENCES tbl_categorias(cat_id)
);

CREATE TABLE tbl_producto_imagenes (
    pri_id SERIAL PRIMARY KEY,
    pri_pro_id INT NOT NULL,
    pri_url_imagen VARCHAR(255) NOT NULL,
    pri_orden INT DEFAULT 0,
    pri_principal BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (pri_pro_id) REFERENCES tbl_productos(pro_id)
);

-- gestión de pedidos y ventas


CREATE TABLE tbl_carritos (
    car_id SERIAL PRIMARY KEY,
    car_usu_id INT NOT NULL,
    car_fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    car_fecha_actualizacion TIMESTAMP,
    FOREIGN KEY (car_usu_id) REFERENCES tbl_usuarios(usu_id)
);

CREATE TABLE tbl_carrito_items (
    cai_id SERIAL PRIMARY KEY,
    cai_car_id INT NOT NULL,
    cai_cantidad INT NOT NULL DEFAULT 1,
    cai_fecha_agregado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cai_car_id) REFERENCES tbl_carritos(car_id),
    UNIQUE (cai_car_id)
);

CREATE TYPE estado_pedido AS ENUM ('Pendiente', 'Procesando', 'Enviado', 'Entregado', 'Cancelado');
CREATE TYPE metodo_pago AS ENUM ('Tarjeta', 'PayPal', 'Transferencia', 'Efectivo');

CREATE TABLE tbl_pedidos (
    ped_id SERIAL PRIMARY KEY,
    ped_usu_id INT NOT NULL,
    ped_fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ped_estado estado_pedido DEFAULT 'Pendiente',
    ped_subtotal DECIMAL(10,2) NOT NULL,
    ped_descuento DECIMAL(10,2) DEFAULT 0.00,
    ped_impuestos DECIMAL(10,2) NOT NULL,
    ped_total DECIMAL(10,2) NOT NULL,
    ped_direccion_envio TEXT NOT NULL,
    ped_metodo_pago metodo_pago NOT NULL,
    ped_transaccion_id VARCHAR(255),
    FOREIGN KEY (ped_usu_id) REFERENCES tbl_usuarios(usu_id)
);

CREATE TABLE tbl_pedido_items (
    pei_id SERIAL PRIMARY KEY,
    pei_ped_id INT NOT NULL,
    pei_cantidad INT NOT NULL,
    pei_precio_unitario DECIMAL(10,2) NOT NULL,
    pei_total_linea DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (pei_ped_id) REFERENCES tbl_pedidos(ped_id)
);

CREATE TYPE estado_factura AS ENUM ('Pendiente', 'Pagada', 'Vencida', 'Cancelada');

CREATE TABLE tbl_facturas (
    fac_id SERIAL PRIMARY KEY,
    fac_ped_id INT NOT NULL,
    fac_numero VARCHAR(50) UNIQUE NOT NULL,
    fac_fecha_emision TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fac_fecha_vencimiento TIMESTAMP,
    fac_estado estado_factura DEFAULT 'Pendiente',
    FOREIGN KEY (fac_ped_id) REFERENCES tbl_pedidos(ped_id)
);

--Personalización y recomendaciones

CREATE TABLE tbl_historial_navegacion (
    hna_id SERIAL PRIMARY KEY,
    hna_usu_id INT NOT NULL,
    hna_pro_id INT NOT NULL,
    hna_fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    hna_duracion_segundos INT,
    FOREIGN KEY (hna_usu_id) REFERENCES tbl_usuarios(usu_id),
    FOREIGN KEY (hna_pro_id) REFERENCES tbl_productos(pro_id)
);

CREATE TABLE tbl_valoraciones (
    val_id SERIAL PRIMARY KEY,
    val_usu_id INT NOT NULL,
    val_pro_id INT NOT NULL,
    val_puntuacion INT NOT NULL CHECK (val_puntuacion BETWEEN 1 AND 5),
    val_comentario TEXT,
    val_fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (val_usu_id) REFERENCES tbl_usuarios(usu_id),
    FOREIGN KEY (val_pro_id) REFERENCES tbl_productos(pro_id),
    UNIQUE (val_usu_id, val_pro_id)
);

CREATE TYPE motivo_descarte AS ENUM ('No me gusta', 'No es mi estilo', 'Precio', 'Otro');

CREATE TABLE tbl_descartes (
    des_id SERIAL PRIMARY KEY,
    des_usu_id INT NOT NULL,
    des_pro_id INT NOT NULL,
    des_fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    des_motivo motivo_descarte,
    FOREIGN KEY (des_usu_id) REFERENCES tbl_usuarios(usu_id),
    FOREIGN KEY (des_pro_id) REFERENCES tbl_productos(pro_id),
    UNIQUE (des_usu_id, des_pro_id)
);

CREATE TABLE tbl_preferencias (
    pre_id SERIAL PRIMARY KEY,
    pre_usu_id INT NOT NULL,
    pre_cat_id INT,
    FOREIGN KEY (pre_usu_id) REFERENCES tbl_usuarios(usu_id),
    FOREIGN KEY (pre_cat_id) REFERENCES tbl_categorias(cat_id)
);

-- Optimización base de datos

-- Índices para búsqueda de productos
CREATE INDEX idx_pro_nombre ON tbl_productos(pro_nombre);
CREATE INDEX idx_pro_categoria ON tbl_productos(pro_cat_id);
CREATE INDEX idx_pro_activos ON tbl_productos(pro_activo);

-- Índices para gestión de pedidos
CREATE INDEX idx_ped_usuario ON tbl_pedidos(ped_usu_id);
CREATE INDEX idx_ped_fecha ON tbl_pedidos(ped_fecha);
CREATE INDEX idx_ped_estado ON tbl_pedidos(ped_estado);

-- Índices para personalización
CREATE INDEX idx_hna_usuario_producto ON tbl_historial_navegacion(hna_usu_id, hna_pro_id);
CREATE INDEX idx_val_usuario_producto ON tbl_valoraciones(val_usu_id, val_pro_id);
CREATE INDEX idx_des_usuario_producto ON tbl_descartes(des_usu_id, des_pro_id);

DROP TABLE IF EXISTS tbl_carrito_items;

--Crear la nueva versión:
CREATE TABLE tbl_carrito_items (
    cai_id SERIAL PRIMARY KEY,
    cai_car_id INT NOT NULL,
    cai_pro_id INT NOT NULL,
    cai_cantidad INT NOT NULL DEFAULT 1,
    cai_fecha_agregado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cai_car_id) REFERENCES tbl_carritos(car_id),
    FOREIGN KEY (cai_pro_id) REFERENCES tbl_productos(pro_id),
    UNIQUE (cai_car_id, cai_pro_id)
);