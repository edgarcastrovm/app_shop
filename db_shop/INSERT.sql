INSERT INTO tbl_usuarios 
(usu_email, usu_password_hash, usu_nombre, usu_apellido, usu_telefono, usu_direccion, usu_rol, usu_fecha_nacimiento, usu_categoria)
VALUES
('user1@example.com', 'hash1', 'Juan', 'Pérez', '0991234567', 'Calle 1', 'vendedor', '1990-01-01',''),
('user2@example.com', 'hash2', 'Ana', 'Gómez', '0991234568', 'Calle 2', 'vendedor', '1988-02-02',''),
('user3@example.com', 'hash3', 'Luis', 'Martínez', '0991234569', 'Calle 3', 'administrador', '1985-03-03',''),
('user4@example.com', 'hash4', 'Sofía', 'Ramírez', '0991234570', 'Calle 4', 'vendedor', '1992-04-04',''),
('user5@example.com', 'hash5', 'Carlos', 'López', '0991234571', 'Calle 5', 'vendedor', '1991-05-05',''),
('user6@example.com', 'hash6', 'Lucía', 'Hernández', '0991234572', 'Calle 6', 'vendedor', '1993-06-06',''),
('user7@example.com', 'hash7', 'Miguel', 'Torres', '0991234573', 'Calle 7', 'cliente', '1994-07-07', 'cobre'),
('user8@example.com', 'hash8', 'Laura', 'Flores', '0991234574', 'Calle 8', 'cliente', '1987-08-08', 'oro'),
('user9@example.com', 'hash9', 'José', 'Vega', '0991234575', 'Calle 9', 'cliente', '1989-09-09', 'cobre'),
('user10@example.com', 'hash10', 'Paula', 'Navarro', '0991234576', 'Calle 10', 'cliente', '1990-10-10', 'cobre'),

('user11@example.com', 'hash11', 'Mario', 'Jiménez', '0991234577', 'Calle 11', 'cliente', '1991-11-11', 'oro'),
('user12@example.com', 'hash12', 'Valeria', 'Ríos', '0991234578', 'Calle 12', 'cliente', '1992-12-12', 'oro'),
('user13@example.com', 'hash13', 'Andrés', 'Campos', '0991234579', 'Calle 13', 'cliente', '1980-01-13', 'cobre'),
('user14@example.com', 'hash14', 'Camila', 'Delgado', '0991234580', 'Calle 14', 'cliente', '1982-02-14', 'oro'),
('user15@example.com', 'hash15', 'Diego', 'Guerrero', '0991234581', 'Calle 15', 'cliente', '1983-03-15', 'plata'),
('user16@example.com', 'hash16', 'Fernanda', 'Cruz', '0991234582', 'Calle 16', 'cliente', '1984-04-16', 'oro'),
('user17@example.com', 'hash17', 'Jorge', 'Santos', '0991234583', 'Calle 17', 'cliente', '1985-05-17', 'plata'),
('user18@example.com', 'hash18', 'Isabel', 'Arias', '0991234584', 'Calle 18', 'cliente', '1986-06-18', 'oro'),
('user19@example.com', 'hash19', 'Pedro', 'Mendoza', '0991234585', 'Calle 19', 'cliente', '1987-07-19', 'plata'),
('user20@example.com', 'hash20', 'Natalia', 'Moreno', '0991234586', 'Calle 20', 'cliente', '1988-08-20', 'oro'),

('user21@example.com', 'hash21', 'Sebastián', 'Peña', '0991234587', 'Calle 21', 'cliente', '1989-09-21', 'plata'),
('user22@example.com', 'hash22', 'Daniela', 'Silva', '0991234588', 'Calle 22', 'cliente', '1990-10-22', 'oro'),
('user23@example.com', 'hash23', 'Francisco', 'Ortega', '0991234589', 'Calle 23', 'cliente', '1991-11-23', 'plata'),
('user24@example.com', 'hash24', 'Elena', 'Cordero', '0991234590', 'Calle 24', 'cliente', '1992-12-24', 'oro'),
('user25@example.com', 'hash25', 'Héctor', 'Blanco', '0991234591', 'Calle 25', 'cliente', '1993-01-25', 'plata'),
('user26@example.com', 'hash26', 'Julia', 'Figueroa', '0991234592', 'Calle 26', 'cliente', '1994-02-26', 'oro'),
('user27@example.com', 'hash27', 'Ricardo', 'Salazar', '0991234593', 'Calle 27', 'cliente', '1995-03-27', 'plata'),
('user28@example.com', 'hash28', 'Martina', 'Castillo', '0991234594', 'Calle 28', 'cliente', '1996-04-28', 'oro'),
('user29@example.com', 'hash29', 'Tomás', 'Lara', '0991234595', 'Calle 29', 'cliente', '1997-05-29', 'plata'),
('user30@example.com', 'hash30', 'Alejandra', 'Reyes', '0991234596', 'Calle 30', 'cliente', '1998-06-30', 'oro');

INSERT INTO tbl_categorias (cat_nombre, cat_descripcion, cat_imagen_url) VALUES
('Electrónica', 'Dispositivos electrónicos como teléfonos, laptops y tablets', 'https://example.com/img/electronica.jpg'),
('Ropa', 'Ropa para hombres, mujeres y niños', 'https://example.com/img/ropa.jpg'),
('Hogar', 'Productos para el hogar como muebles y electrodomésticos', 'https://example.com/img/hogar.jpg'),
('Deportes', 'Artículos deportivos y equipamiento', 'https://example.com/img/deportes.jpg'),
('Libros', 'Libros de diferentes géneros y autores', 'https://example.com/img/libros.jpg'),
('Juguetes', 'Juguetes y juegos para niños', 'https://example.com/img/juguetes.jpg'),
('Belleza', 'Productos de cuidado personal y belleza', 'https://example.com/img/belleza.jpg'),
('Alimentos', 'Comida, snacks y bebidas', 'https://example.com/img/alimentos.jpg'),
('Mascotas', 'Productos para el cuidado de mascotas', 'https://example.com/img/mascotas.jpg'),
('Herramientas', 'Herramientas para construcción, reparación y bricolaje', 'https://example.com/img/herramientas.jpg');

INSERT INTO tbl_subcategorias (subcat_nombre, subcat_descripcion, cat_padre_id) VALUES
('Camisetas', 'Camisetas para hombres, mujeres y niños', 2),
('Pantalones', 'Jeans, pantalones de vestir y casuales', 2),
('Chaquetas', 'Chaquetas de cuero, abrigos y rompevientos', 2),
('Vestidos', 'Vestidos casuales, formales y de fiesta', 2),
('Faldas', 'Faldas largas, cortas y de mezclilla', 2),
('Ropa interior', 'Ropa interior para todas las edades', 2),
('Ropa deportiva', 'Conjuntos deportivos y ropa para hacer ejercicio', 2),
('Accesorios', 'Sombreros, bufandas, guantes y más', 2),
('Zapatos', 'Zapatos deportivos, casuales y elegantes', 2),
('Ropa de dormir', 'Pijamas y ropa cómoda para dormir', 2);

INSERT INTO tbl_productos (pro_codigo, pro_nombre, pro_descripcion, pro_precio, pro_marca, pro_color, pro_talla, pro_cat_id, pro_stock) VALUES
('RPA-001', 'Camiseta básica blanca', 'Camiseta de algodón, cuello redondo, unisex.', 12.99, 'H&M', 'Blanco', 'M', 2, 50),
('RPA-002', 'Jeans slim fit', 'Pantalón de mezclilla ', 35.00, 'Levis', 'Azul', '32', 2, 40),
('RPA-003', 'Chaqueta rompevientos', 'Chaqueta ligera resistente al viento, ideal para clima templado.', 45.90, 'Nike', 'Negro', 'L', 2, 25),
('RPA-004', 'Vestido floral', 'Vestido casual con estampado floral, manga corta.', 29.99, 'Zara', 'Multicolor', 'S', 2, 30),
('RPA-005', 'Falda de mezclilla', 'Falda corta de mezclilla azul, con bolsillos frontales.', 24.50, 'Forever 21', 'Azul', 'M', 2, 35),
('RPA-006', 'Conjunto deportivo', 'Conjunto de dos piezas para entrenamiento, transpirable.', 39.99, 'Adidas', 'Gris', 'M', 2, 20),
('RPA-007', 'Pijama polar', 'Pijama de dos piezas, suave y abrigada para invierno.', 19.99, 'Uniqlo', 'Rosa', 'L', 2, 45),
('RPA-008', 'Boxers algodón x3', 'Pack de 3 boxers de algodón en colores surtidos.', 15.00, 'Fruit of the Loom', 'Surtido', 'L', 2, 60),
('RPA-009', 'Zapatos deportivos', 'Zapatos cómodos para correr y caminar.', 59.95, 'Puma', 'Negro', '42', 2, 18),
('RPA-010', 'Bufanda tejida', 'Bufanda de lana, ideal para invierno.', 10.00, 'Old Navy', 'Gris oscuro', 'Única', 2, 75);


INSERT INTO tbl_producto_imagenes (pri_pro_id, pri_url_imagen, pri_orden, pri_principal) VALUES
(1, 'https://koaj.ec/274197-big_default/camiseta-blanca-manga-corta-en-algodon-con-cuello-redondo.jpg', 1, TRUE),
(10, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.deprati.com.ec%2Fbufanda-tejida-comfort-u%2Fp%2F633060205409029001&psig=AOvVaw3NhqQYGe4W0ce6gzXzUKP-&ust=1748880163359000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCNiWsrjM0I0DFQAAAAAdAAAAABAM', 1, TRUE),
(2, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fleonisa.ec%2Fproducts%2Fjean-silueta-slim-para-hombre&psig=AOvVaw0s88Gft8pC8XC71XY2J8an&ust=1748880394481000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCOCtjqfN0I0DFQAAAAAdAAAAABAE', 1, TRUE),
(3, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.adidas.com%2Fec%2Fes%2FHZ1319.html&psig=AOvVaw29f5yRlJYoPdAVLqTlHReR&ust=1748880439714000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCNiimbzN0I0DFQAAAAAdAAAAABAL', 1, TRUE),
(4, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fmx.pinterest.com%2Fpin%2F433541901641214589%2F&psig=AOvVaw3Cj7_sdbC3iT1HvSj48IB5&ust=1748880035679000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCPjQ3f3L0I0DFQAAAAAdAAAAABAE', 1, TRUE),
(5, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fmx.pinterest.com%2Fpin%2F382313455887296665%2F&psig=AOvVaw3Uer-m7xrzE7Wpz4szF8kf&ust=1748880528579000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCLDewObN0I0DFQAAAAAdAAAAABBM', 1, TRUE),
(6, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fsprintsportwear.com%2Fproducto%2Fconjunto-deportivo-de-3-piezas-2%2F&psig=AOvVaw1g81YCuPtAfVkKcElNSK-C&ust=1748880586266000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCPiKgILO0I0DFQAAAAAdAAAAABAh', 1, TRUE),
(7, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.laredoute.es%2Fppdp%2Fprod-350349783.aspx&psig=AOvVaw0MrUvtCVbvN5ETa16MbTig&ust=1748880648828000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMCalqDO0I0DFQAAAAAdAAAAABBc', 1, TRUE),
(8, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fhormiguitabebe.com%2Fproducto%2Ftripack-de-boxers-algodon%2F&psig=AOvVaw1qa7RBm2C6M6TLhy_3rtC9&ust=1748880131685000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCIiegarM0I0DFQAAAAAdAAAAABAE', 1, TRUE),
(9, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fangelicablancogil%2Fzapatos-deportivos%2F&psig=AOvVaw3tQdkNug4IolPYoS63y-M-&ust=1748880147864000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMjUwrHM0I0DFQAAAAAdAAAAABAE', 1, TRUE),


INSERT INTO tbl_valoraciones (val_usu_id, val_pro_id, val_puntuacion, val_comentario) VALUES
(1, 1, 5, 'Excelente calidad y muy cómoda.'),
(1, 2, 4, 'Buena prenda, aunque la talla vino un poco justa.'),
(2, 3, 3, 'Está bien, pero esperaba mejor tela.'),
(2, 4, 5, 'El vestido es precioso, mi esposa está feliz.'),
(3, 5, 4, 'Buen producto, llegó a tiempo.'),
(3, 6, 5, 'Ideal para entrenar, súper cómodo.'),
(4, 7, 2, 'No abriga tanto como esperaba.'),
(4, 8, 4, 'Buena relación calidad/precio.'),
(5, 9, 5, 'Los mejores zapatos deportivos que he comprado.'),
(5, 10, 3, 'Está bien, pero esperaba que fuera más gruesa.');


INSERT INTO tbl_descartes (des_usu_id, des_pro_id, des_motivo) VALUES
(1, 3, 'No me gusta'),
(1, 5, 'Precio'),
(2, 2, 'No es mi estilo'),
(2, 6, 'Otro'),
(3, 1, 'No me gusta'),
(3, 8, 'No es mi estilo'),
(4, 4, 'Precio'),
(4, 9, 'Otro'),
(5, 7, 'No me gusta'),
(5, 10, 'No es mi estilo');

INSERT INTO tbl_carritos (car_usu_id) VALUES
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19);


INSERT INTO tbl_carrito_items (cai_car_id, cai_pro_id, cai_cantidad) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 3, 1),
(1, 4, 1),
(2, 1, 3),
(3, 8, 3),
(4, 10, 5),
(5, 4, 1),
(5, 5, 1),
(6, 1, 2),
(6, 9, 2),
(6, 10, 1);