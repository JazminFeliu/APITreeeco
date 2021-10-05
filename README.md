# TREEECO Ecosistema Ambiental Fintech

Etapa 1
Armar una app (pagina web responsive) con un sistema CRUD para la empresa TREEECO, con un acceso de RBAC para consumo privado. 
Dependiendo del rol, podrá acceder a:
-cargar, modificar y eliminar productos, servicios y clientes de la DB 
-cargar movimientos del cashflow de la empresa (ingresos y egresos de dinero). 
-en el form de contacto, permitir el registro de usuarios que deseen recibir novedades (opcion casilla suscripcion).
-realizar consultas con diferentes filtros de los productos, servicios y movimientos. 

Asimismo, el sistema tiene que permitir enviar el formulario de contacto para consultas generales o solicitar un servicio o producto, para los accesos públicos al sitio. 

Etapa 2
Consumir otras APIs mas para sumar servicios de georeferenciacion (API google maps), de servicio de pago (API Mercado pago), de divisas(dolar, euro, alguna cripto), etc.
Permitir el registro de nuevos usuarios, que podrán acceder a las prestaciones como clientes (solicitar productos, servicios, pagar, ver por donde se encuentra su pedido, recibir y canjear puntos por las actividades realizadas, etc.)

Entities
Producto / Servicio / Usuario / Movimiento / Puntos

Tablas TREEECO DB:
Productos (id_producto, nombre, descripcion, categoria, stock, precio, unidad, puntos).
Servicios (id_servicio, nombre, descripcion, categoria, profesional, precio, unidad, puntos).
Usuarios (id_usuario, nombre, tipo, token, pass hasheado, emial, puntosxusuario).
Movimientos (id_movimiento, nombre, tipo, fecha, unidad, monto, id_usuario).
movimientosxusuario (id_movimiento, id_usuario, nombre, tipo, fecha, unidad, monto)
movimientosxtipo (id_movimiento, tipo, nombre, fecha, unidad, monto)
puntosxproductos (id_usuario, id_producto, puntos)
puntosxservicios (id_usuario, id_servicio, puntos)


Endpoints:
GET / productos: lista todos los productos
GET / productos/id
GET / productos/nombre/{nombre}: buscar x nombre
GET / productos/categoria/{categoria}: buscar x categoria (ABONO/HUERTA/CULTURAL)
GET / productos/fecha/{fechaDesde}/{fechaHasta}

GET / servicios: lista todos los servicios
GET / servicios/nombre/{nombre}: buscar x nombre
GET / servicios/categoria/{categoria}: buscar x categoria (TRADICIONAL/SIAR/CULTURAL)

GET / movimientos: lista todos los movimientos
GET / movimientos/nombre/{nombre}: buscar x nombre
GET / movimientos/tipo/{tipo}: buscar x tipo (INGRESO/EGRESO)
seguir..
