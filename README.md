# Proyecto PWA TREEECO    

<img src="https://treeeco.herokuapp.com/images/LOGO2.jpg" alt="TREEECO" width="90" height="90">

#### RAISECAMP OMN1
El proyecto cuenta con las siguientes etapas, donde se priorizará el aprendizaje progresivo de tecnologías y aplicaciones:

#Etapa 1. Armar una web (responsive) con información general de la empresa TREEECO.
Areas: inicio / productos / servicios / blog / contacto.
Funcionalidades:
El cliente puede recorrer la pagina, encontrar distinta info de ofertas y eventos, tanto sobre los productos como los servicios de TREEECO.
Las ofertas y eventos tendrán un botón de consulta que los redireccionará al formulario de contacto.
El formulario de contacto utilizará un servicio de terceros como Formspree para generar la consulta y deberá validar la información de sus campos (nombre, mail, etc.), antes de procesar el envío.
Stack: HTML, CSS, Js, Bootstrap, JQuery

#Etapa 2. El sitio suma una base de datos de consumo interno por medio de una API. Para su consumo, se accede a un area de login (RBAC).

API TREEECO

Objetivo

Desarrollar una API  para consumo interno, que permita acceso a un area personal donde el usuario pueda ingresar y modificar (user), y borrar(admin):
- productos
  -servicios
  -movimiento de dinero
  -agenda de contactos.

###Stack actual:
Front: HTML, CSS, JS, JQuery.
Back: Java
DDBB: postgres.
Utiliza Spring Boot, Spring Security (RBAC).
Deploya en Heroku.

Requerimientos técnicos
1. Modelado de Base de Datos

       • Productos:
           ◦ producto_id
           ◦ nombre
           ◦ descripcion
           ◦ categoria (Huerta / Abonos)
           ◦ cantidad
           ◦ precio
           ◦ puntos
           ◦ unidad (Tonelada, kg, gs, dl)
    
       • Servicios
           ◦ servicio_id
           ◦ nombre
           ◦ descripcion
           ◦ categoria (servicio tradicional, siar)
           ◦ cantidad
           ◦ precio
           ◦ puntos
    
       • Movimientos
           ◦ movimiento_id
           ◦ nombre
           ◦ tipo (ingreso / egreso)
           ◦ fecha
           ◦ unidad (peso, dolar, euro, cripto)
           ◦ monto
           ◦ usuario_id
    
       • Contactos
           ◦ contacto_id
           ◦ nombre
           ◦ telefono
           ◦ email
           ◦ net (web, instagram, face, twitter, tiktok, twitch, reddit, etc.)
           ◦ descripcion
    
           • movimientosxusuario
           • movimientosxtipo
           • puntosxproductos
           • puntosxservicios

2. Autenticación de usuarios
   El usuario podrá ingresar a través de un login del Area Personal, contará con un token que obtendrá al autenticarse. Para ello, deberán desarrollarse los endpoints de registro y login, que permitan obtener el token.
   Endpoints de autenticación:
   • /auth/login
   • /auth/register

Base de datos para Autenticación de usuarios:

    • Usuarios
        ◦ user_id
        ◦ username
        ◦ password
        ◦ enabled
        ◦ credentials_non_expired
        ◦ account_non_expired
        ◦ account_non_locked

    • Autorizaciones
        ◦ authority_id
        ◦ role


3.  Creacion, Edición y eliminación de productos, servicios, movimientos y contactos
    El servicio contará con operaciones básicas de creación, edición y eliminación, dependiendo el rol con el que cuente el usuario.

El rol USER tendrá permisos de lectura y escritura de las cuatro opciones (CREATE, READ), y el rol ADMIN contará tambien con permisos de borrado y habilitará los pedidos de modificaciones realizados por los demas roles antes de que impacten en la base (CREATE, READ, UPDATE, DELETE).

4. Listados
   Los listados deberán mostrar todos los campos de los productos, servicios, movimientos y contactos.
   GET  /api/productos
   GET /api/servicios
   GET /api/movimientos
   GET /api/contactos

5. Endpoints
   
   5.1 Productos
   
       GET /api/productos/producto_id : busca por id
       GET /api/productos/categoria/{categoria}: busca por categoria
       GET /api/productos/nombre/{nombre} : busca por nombre
       GET /api/productos/{puntosdesde}/{puntoshasta} : busca un rango de puntos

       GET /api/productos/nuevo : crea un nuevo producto
       GET /api/productos/editar/{producto_id} : edita el producto y permite modificar
    
       POST /api/productos/guardar : guarda el producto
       DEL /api/productos/borrar/{producto_id}: borra un producto.

   5.2 Servicios
   
       GET /api/servicios/servicio_id : busca por id
       GET /api/servicios/categoria/{categoria}: busca por categoria
       GET /api/servicios/nombre/{nombre} : busca por nombre
       GET /api/servicios/{puntosdesde}/{puntoshasta} : busca un rango de puntos

       GET /api/servicios/nuevo : crea un nuevo servicio
       GET /api/servicios/editar/{servicio_id} : edita el servicio y permite modificar
    
       POST /api/servicios/guardar : guarda el servicio
       DEL /api/servicios/borrar/{servicio_id}: borra un servicio.

   5.3 Movimientos
   
       GET /api/movimientos/movimiento_id : busca por id
       GET /api/movimientos/tipo/{tipo}: busca por tipo
       GET /api/movimientos/usuario_id/usuario_id : busca por usuario.
       GET /api/movimientos/{fechadesde}/{fechahasta} : busca un rango de fechas
    
       GET /api/movimientos/nuevo : crea un nuevo movimiento
       GET /api/movimientos/editar/{movimiento_id} : edita el movimiento y permite modificar
    
       POST /api/movimientos/guardar : guarda el movimiento
       DEL /api/movimientos/borrar/{movimiento_id}: borra un movimiento.

   5.4 Contactos
   
       GET /api/contactos/contacto_id : busca por id
       GET /api/contactos/nombre/{nombre} :busca por nombre
       GET /api/contactos/categoria/{telefono}: busca por telefono
       GET /api/contactos/categoria/{email}: busca por email
       GET /api/contactos/categoria/{net}: busca por red social
    
       GET /api/contactos/nuevo : crea un nuevo contacto
       GET /api/contactos/editar/{contacto_id} : edita el contacto y permite modificar
    
       POST /api/contactos/guardar : guarda el contacto
       DEL /api/contactos/borrar/{contacto_id}: borra un contacto.


#Etapa 3. El sitio migra a otro stack tecnológico que le permite convertirse en PWA.

##PWA TREEECO

Objetivo: migrar a otro stack para convertir el sitio en PWA TREEECO.

Stack propuesto:
Front: HTML, CSS, TypeScript, React
Back: Node.js
DDBB: MongoDB.
Utiliza Fastify
Deploya en ....(definir)

# bonus track: (opcional)
###Posible Etapa 4 Consumir otras APIs 
mas para sumar servicios de georeferenciacion (API google maps), de servicio de pago (API Mercado pago), de divisas(dolar, euro, alguna cripto), etc.
Permitir el registro de nuevos usuarios, que podrán acceder a las prestaciones como clientes (solicitar productos, servicios, pagar, ver por donde se encuentra su pedido, recibir y canjear puntos por las actividades realizadas, etc.)
