--Cerar tablas
delete from  USUARIOS;
delete from TAREA_FORMULA;
delete from TAREA_FALLIDA;
delete from SALDO_CLIENTE;
delete from RECURSO_ASIGNADO;
delete from RECIBO_DETALLE;
delete from PRODUCCION_DIARIA;
delete from TAREA_ASIGNADA;
delete from TAREA;
delete from PERDIDA;
delete from PARAMETROS;
delete from ORDEN_TRABAJO_DET_COSTO_MAT;
delete from ORDEN_TRABAJO_DET_COSTO_H;
delete from NOTA_CREDITO_PROV_DET;
delete from NOTA_CREDITO_PROV_CAB;
delete from NOTA_CREDITO_CLI_DETALLE;
delete from NOTA_CREDITO_CLI_CABECERA;
delete from MOVIMIENTO_CAJA_DETALLE;
delete from MOVIMIENTO_CAJA_CABECERA;
delete from RECIBO_CABECERA;
delete from MAQUINARIAS;
delete from INVENTARIO_DETALLE;
delete from INVENTARIO_CABECERA;
delete from HISTORICO_PRECIO;
delete from HISTORICO_COSTO;
delete from GASTO;
delete from HABILITACION_CAJA;
delete from FORMULA_SEMI_DETALLE;
delete from FORMULA_DETALLE;
delete from FORMULA_SEMI_CABECERA;
delete from FORMULA_CABECERA;
delete from FORMA_PAGO;
delete from FACTURA_DETALLE;
delete from PEDIDO_DETALLE;
delete from FACTURA_COMPRA_DET;
delete from FACTURA_COMPRA_CAB;
delete from PROVEEDOR;
delete from FACTURA_CABECERA;
delete from PEDIDO_CABECERA;
delete from TIPO_COMPROBANTE;
delete from EXISTENCIA;
delete from EQUIVALENCIA;
delete from ENTRADA_SALIDA_DETALLE;
delete from SOLICITUD_INTERNA;
delete from ENTRADA_SALIDA_CABECERA;
delete from DET2;
delete from DET1;
delete from DEPOSITO;
delete from COSTOS_FIJOS;
delete from ORDEN_TRABAJO_DETALLE;
delete from ORDEN_TRABAJO;
delete from COMISION_MENS_DET;
delete from COMISION_MENS_CAB;
delete from VENTA_COMISION_MENSUAL;
delete from EMPLEADO;
delete from SECCION;
delete from COMISION;
delete from PRODUCTO;
delete from PRESENTACION;
delete from MARCA;
delete from UNIDAD_MEDIDA;
delete from TIPO_PRODUCTO;
delete from CLIENTE;
delete from CIUDAD;
delete from CARGO;
delete from CAJA;
delete from CAB;
delete from BANCO;


-- cargos
insert into CARGO (COD_CARGO, NOMBRE_CARGO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (1, 'Supervision de Taller', null, null, null, null);
insert into CARGO (COD_CARGO, NOMBRE_CARGO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (2, 'Empleado de Taller', null, null, null, null);
insert into CARGO (COD_CARGO, NOMBRE_CARGO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (3, 'Empleado de Compras', null, null, null, null);
insert into CARGO (COD_CARGO, NOMBRE_CARGO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (4, 'Supervision de Compras', null, null, null, null);
insert into CARGO (COD_CARGO, NOMBRE_CARGO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (5, 'Administracion', null, null, null, null);
insert into CARGO (COD_CARGO, NOMBRE_CARGO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (6, 'Cajero', null, null, null, null);
insert into CARGO (COD_CARGO, NOMBRE_CARGO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (7, 'Vendedor', null, null, null, null);
insert into CARGO (COD_CARGO, NOMBRE_CARGO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (8, 'Gerente General', null, null, null, null);

-- secciones
insert into SECCION (COD_SECCION, NOMBRE_SECCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (1, 'Dpto Produccion', null, null, null, null);
insert into SECCION (COD_SECCION, NOMBRE_SECCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (2, 'Compras', null, null, null, null);
insert into SECCION (COD_SECCION, NOMBRE_SECCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (3, 'Cobranzas', null, null, null, null);
insert into SECCION (COD_SECCION, NOMBRE_SECCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (4, 'Ventas', null, null, null, null);
insert into SECCION (COD_SECCION, NOMBRE_SECCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (5, 'Administracion', null, null, null, null);


-- empleados
insert into EMPLEADO (COD_EMPLEADO, COD_CARGO, COD_SECCION, NOMBRE_EMPLEADO, APELLIDO_EMPLEADO, CIN_EMPLEADO, ESTADO_CIVIL_EMPLEADO, SEXO_EMPLEADO, NACIONALIDAD_EMPLEADO, FECHA_NACIMIENTO_EMPLEADO, DIRECCION_EMPLEADO, TELEFONO1_EMPLEADO, TELEFONO2_EMPLEADO, MAIL_EMPLEADO, FECHA_INGRESO_EMPLEADO, IPS_EMPLEADO, HIJOS_EMPLEADO, SALARIO_EMPLEADO, TIPO_EMPLEADO, ESTADO_EMPLEADO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COSTO_HORA)
values (1, 2, 1, 'Fernando', 'Boy', 'CI', 'S', 'M', 'Paraguaya', to_date('28-06-2010', 'dd-mm-yyyy'), 'Montoya 332', '--', '--', '--', to_date('12-07-2010', 'dd-mm-yyyy'), '--', 0, 2500000, 'F', 'A', null, null, null, null, 25000);
insert into EMPLEADO (COD_EMPLEADO, COD_CARGO, COD_SECCION, NOMBRE_EMPLEADO, APELLIDO_EMPLEADO, CIN_EMPLEADO, ESTADO_CIVIL_EMPLEADO, SEXO_EMPLEADO, NACIONALIDAD_EMPLEADO, FECHA_NACIMIENTO_EMPLEADO, DIRECCION_EMPLEADO, TELEFONO1_EMPLEADO, TELEFONO2_EMPLEADO, MAIL_EMPLEADO, FECHA_INGRESO_EMPLEADO, IPS_EMPLEADO, HIJOS_EMPLEADO, SALARIO_EMPLEADO, TIPO_EMPLEADO, ESTADO_EMPLEADO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COSTO_HORA)
values (2, 2, 1, 'Julian', 'Rolon', 'CI', 'C', 'M', 'Paraguaya', to_date('27-06-2010', 'dd-mm-yyyy'), 'Montoya 233', '--', '--', '--', to_date('12-07-2010', 'dd-mm-yyyy'), '--', 0, 1850000, 'F', 'A', null, null, null, null, 30000);
insert into EMPLEADO (COD_EMPLEADO, COD_CARGO, COD_SECCION, NOMBRE_EMPLEADO, APELLIDO_EMPLEADO, CIN_EMPLEADO, ESTADO_CIVIL_EMPLEADO, SEXO_EMPLEADO, NACIONALIDAD_EMPLEADO, FECHA_NACIMIENTO_EMPLEADO, DIRECCION_EMPLEADO, TELEFONO1_EMPLEADO, TELEFONO2_EMPLEADO, MAIL_EMPLEADO, FECHA_INGRESO_EMPLEADO, IPS_EMPLEADO, HIJOS_EMPLEADO, SALARIO_EMPLEADO, TIPO_EMPLEADO, ESTADO_EMPLEADO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COSTO_HORA)
values (3, 2, 1, 'Luis', 'Lopez', 'CI', 'S', 'M', 'Paraguaya', to_date('12-02-2010', 'dd-mm-yyyy'), 'Montoya 332', '--', '--', '--', to_date('12-07-2010', 'dd-mm-yyyy'), '--', 0, 2900000, 'F', 'A', null, null, null, null, 20000);
insert into EMPLEADO (COD_EMPLEADO, COD_CARGO, COD_SECCION, NOMBRE_EMPLEADO, APELLIDO_EMPLEADO, CIN_EMPLEADO, ESTADO_CIVIL_EMPLEADO, SEXO_EMPLEADO, NACIONALIDAD_EMPLEADO, FECHA_NACIMIENTO_EMPLEADO, DIRECCION_EMPLEADO, TELEFONO1_EMPLEADO, TELEFONO2_EMPLEADO, MAIL_EMPLEADO, FECHA_INGRESO_EMPLEADO, IPS_EMPLEADO, HIJOS_EMPLEADO, SALARIO_EMPLEADO, TIPO_EMPLEADO, ESTADO_EMPLEADO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COSTO_HORA)
values (4, 1, 1, 'Jazmin', 'Torres', 'CI', 'C', 'M', 'Paraguaya', to_date('17-05-2010', 'dd-mm-yyyy'), 'Montoya 233', '--', '--', '--', to_date('12-07-2010', 'dd-mm-yyyy'), '--', 0, 1950000, 'F', 'A', null, null, null, null, 21000);
insert into EMPLEADO (COD_EMPLEADO, COD_CARGO, COD_SECCION, NOMBRE_EMPLEADO, APELLIDO_EMPLEADO, CIN_EMPLEADO, ESTADO_CIVIL_EMPLEADO, SEXO_EMPLEADO, NACIONALIDAD_EMPLEADO, FECHA_NACIMIENTO_EMPLEADO, DIRECCION_EMPLEADO, TELEFONO1_EMPLEADO, TELEFONO2_EMPLEADO, MAIL_EMPLEADO, FECHA_INGRESO_EMPLEADO, IPS_EMPLEADO, HIJOS_EMPLEADO, SALARIO_EMPLEADO, TIPO_EMPLEADO, ESTADO_EMPLEADO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COSTO_HORA)
values (5, 5, 2, 'Rossana', 'Melo', 'CI', 'S', 'M', 'Paraguaya', to_date('04-06-2010', 'dd-mm-yyyy'), 'Montoya 332', '--', '--', '--', to_date('12-07-2010', 'dd-mm-yyyy'), '--', 0, 3500000, 'F', 'A', null, null, null, null, 25000);
insert into EMPLEADO (COD_EMPLEADO, COD_CARGO, COD_SECCION, NOMBRE_EMPLEADO, APELLIDO_EMPLEADO, CIN_EMPLEADO, ESTADO_CIVIL_EMPLEADO, SEXO_EMPLEADO, NACIONALIDAD_EMPLEADO, FECHA_NACIMIENTO_EMPLEADO, DIRECCION_EMPLEADO, TELEFONO1_EMPLEADO, TELEFONO2_EMPLEADO, MAIL_EMPLEADO, FECHA_INGRESO_EMPLEADO, IPS_EMPLEADO, HIJOS_EMPLEADO, SALARIO_EMPLEADO, TIPO_EMPLEADO, ESTADO_EMPLEADO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COSTO_HORA)
values (6, 6, 3, 'Martin', 'Jara', 'CI', 'C', 'M', 'Paraguaya', to_date('01-01-2010', 'dd-mm-yyyy'), 'Montoya 233', '--', '--', '--', to_date('12-07-2010', 'dd-mm-yyyy'), '--', 0, 2000000, 'F', 'A', null, null, null, null, 23000);
insert into EMPLEADO (COD_EMPLEADO, COD_CARGO, COD_SECCION, NOMBRE_EMPLEADO, APELLIDO_EMPLEADO, CIN_EMPLEADO, ESTADO_CIVIL_EMPLEADO, SEXO_EMPLEADO, NACIONALIDAD_EMPLEADO, FECHA_NACIMIENTO_EMPLEADO, DIRECCION_EMPLEADO, TELEFONO1_EMPLEADO, TELEFONO2_EMPLEADO, MAIL_EMPLEADO, FECHA_INGRESO_EMPLEADO, IPS_EMPLEADO, HIJOS_EMPLEADO, SALARIO_EMPLEADO, TIPO_EMPLEADO, ESTADO_EMPLEADO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COSTO_HORA)
values (7, 7, 4, 'Lucas', 'Santacruz', 'CI', 'S', 'M', 'Paraguaya', to_date('28-12-2010', 'dd-mm-yyyy'), 'Montoya 332', '--', '--', '--', to_date('12-07-2010', 'dd-mm-yyyy'), '--', 0, 1030000, 'F', 'A', null, null, null, null, 12500);
insert into EMPLEADO (COD_EMPLEADO, COD_CARGO, COD_SECCION, NOMBRE_EMPLEADO, APELLIDO_EMPLEADO, CIN_EMPLEADO, ESTADO_CIVIL_EMPLEADO, SEXO_EMPLEADO, NACIONALIDAD_EMPLEADO, FECHA_NACIMIENTO_EMPLEADO, DIRECCION_EMPLEADO, TELEFONO1_EMPLEADO, TELEFONO2_EMPLEADO, MAIL_EMPLEADO, FECHA_INGRESO_EMPLEADO, IPS_EMPLEADO, HIJOS_EMPLEADO, SALARIO_EMPLEADO, TIPO_EMPLEADO, ESTADO_EMPLEADO, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COSTO_HORA)
values (8, 8, 5, 'Francisco', 'Pereira', 'CI', 'C', 'M', 'Paraguaya', to_date('01-06-2010', 'dd-mm-yyyy'), 'Montoya 233', '--', '--', '--', to_date('12-07-2010', 'dd-mm-yyyy'), '--', 0, 1250000, 'F', 'A', null, null, null, null, 23000);

--Tipo Producto
insert into TIPO_PRODUCTO (COD_TIPO_PRODUCTO, DESCRIPCION, TAREAS, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (1, 'ProductoGenerico', 'S', null, null, null, null);
insert into TIPO_PRODUCTO (COD_TIPO_PRODUCTO, DESCRIPCION, TAREAS, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (2, 'SemiTerminado', 'S', null, null, null, null);
insert into TIPO_PRODUCTO (COD_TIPO_PRODUCTO, DESCRIPCION, TAREAS, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (3, 'Insumo', 'N', null, null, null, null);
insert into TIPO_PRODUCTO (COD_TIPO_PRODUCTO, DESCRIPCION, TAREAS, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (4, 'MateriaPrima', 'N', null, null, null, null);
insert into TIPO_PRODUCTO (COD_TIPO_PRODUCTO, DESCRIPCION, TAREAS, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (5, 'Terminado', 'N', null, null, null, null);
insert into TIPO_PRODUCTO (COD_TIPO_PRODUCTO, DESCRIPCION, TAREAS, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (6, 'Acabado', 'S', null, null, to_date('11-07-2010 10:37:38', 'dd-mm-yyyy hh24:mi:ss'), null);
insert into TIPO_PRODUCTO (COD_TIPO_PRODUCTO, DESCRIPCION, TAREAS, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (7, 'Servicio', 'N', null, null, to_date('11-07-2010 10:37:38', 'dd-mm-yyyy hh24:mi:ss'), null);

/*
		C -- compra
		V -- venta
		A -- Ambos
		N -- Ninguno
*/
update tipo_producto set compra_venta = 'C' where cod_tipo_producto in (2,3,4,7);
update tipo_producto set compra_venta = 'V' where cod_tipo_producto in (5);
update tipo_producto set compra_venta = 'N' where cod_tipo_producto in (1, 6);

--Unidad Medida
insert into UNIDAD_MEDIDA (COD_UNIDAD_MEDIDA, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (1, 'Sin_Medida', null, null, null, null);
insert into UNIDAD_MEDIDA (COD_UNIDAD_MEDIDA, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (2, 'Kilogramos', null, null, null, null);
insert into UNIDAD_MEDIDA (COD_UNIDAD_MEDIDA, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (3, 'Gramos', null, null, null, null);
insert into UNIDAD_MEDIDA (COD_UNIDAD_MEDIDA, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (4, 'Unidades', null, null, null, null);
insert into UNIDAD_MEDIDA (COD_UNIDAD_MEDIDA, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (5, 'Metros', null, null, null, null);
insert into UNIDAD_MEDIDA (COD_UNIDAD_MEDIDA, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (6, 'Metros Cuadros', null, null, null, null);

--Presentacion 
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (1, 'Sin Presentacion', '', '', null, null);
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (2, 'Botella Vidrio', '', '', null, null);
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (3, 'Botella Plastico', '', '', null, null);
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (4, 'Caja Carton', '', '', null, null);
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (5, 'Caja Hierro', '', '', null, null);
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (6, 'Unidades', '', '', null, null);
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (7, 'Sobres', '', '', null, null);
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (8, 'Cajon', '', '', null, null);
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (9, 'Bolsa', '', '', null, null);

--Marcas
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (1, 'Sin_Marca', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (2, 'Platinum', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (3, 'CHAMBRIL', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (4, 'INTERNATIONAL PAPER', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (5, 'YAGUARETE', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (6, 'OPAL', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (7, 'MONICOL', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (8, 'AGFA', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (9, 'IBF', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (10, 'EUROPA', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (11, 'PHENIOM', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (12, 'CIBFEX', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (13, 'COLACRIL', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (14, 'LASSAGNE', null, null, sysdate, null);
insert into MARCA (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF)
values (15, 'PLASTIOFARM', null, null, sysdate, null);

-- maquinarias
insert into MAQUINARIAS (COD_MAQUINARIA, DESCRIPCION, CONSUMO_KWH, COSTO_MANTENIMIENTO, HORAS_MANTENIMENTO)
values (1, 'TROQUEL CAASH 221x2rf', 1200, 2500000, 100);
insert into MAQUINARIAS (COD_MAQUINARIA, DESCRIPCION, CONSUMO_KWH, COSTO_MANTENIMIENTO, HORAS_MANTENIMENTO)
values (2, 'Cortadora XS110 verKA', 1200, 2500000, 100);
insert into MAQUINARIAS (COD_MAQUINARIA, DESCRIPCION, CONSUMO_KWH, COSTO_MANTENIMIENTO, HORAS_MANTENIMENTO)
values (3, 'Impresor offset 221x2', 1200, 2500000, 100);
insert into MAQUINARIAS (COD_MAQUINARIA, DESCRIPCION, CONSUMO_KWH, COSTO_MANTENIMIENTO, HORAS_MANTENIMENTO)
values (5, 'ILUMINADOR ROBX 122S', 1200, 2500000, 100);
insert into MAQUINARIAS (COD_MAQUINARIA, DESCRIPCION, CONSUMO_KWH, COSTO_MANTENIMIENTO, HORAS_MANTENIMENTO)
values (6, 'PRENSA MAYOR PHILIPS XX2S', 1200, 2500000, 100);
insert into MAQUINARIAS (COD_MAQUINARIA, DESCRIPCION, CONSUMO_KWH, COSTO_MANTENIMIENTO, HORAS_MANTENIMENTO)
values (7, 'IMPRESORA LOTX 124', 1200, 2500000, 100);
insert into MAQUINARIAS (COD_MAQUINARIA, DESCRIPCION, CONSUMO_KWH, COSTO_MANTENIMIENTO, HORAS_MANTENIMENTO)
values (8, 'PLANCHA LAMINA OFFSET X332', 1200, 2500000, 100);
insert into MAQUINARIAS (COD_MAQUINARIA, DESCRIPCION, CONSUMO_KWH, COSTO_MANTENIMIENTO, HORAS_MANTENIMENTO)
values (9, 'Prensa Retractil H42', 100000, 350000, 12000);

--Tipos de Comprobantes
insert into tipo_comprobante values (1, 'Factura Contado - Compra', 0, 'COMPRA', 0, 'Factura Contado');
insert into tipo_comprobante values (2, 'Factura Crédito 30 días - Compra', 30, 'COMPRA', 1, 'Factura Crédito');
insert into tipo_comprobante values (3, 'Factura Crédito 30 días/2 Cuotas - Compra', 30, 'COMPRA', 2, 'Factura Crédito');
insert into tipo_comprobante values (4, 'Factura Crédito 30 días/3 Cuotas - Compra', 30, 'COMPRA', 3, 'Factura Crédito');
insert into tipo_comprobante values (5, 'Factura Crédito 30 días/4 Cuotas - Compra', 30, 'COMPRA', 4, 'Factura Crédito');
insert into tipo_comprobante values (6, 'Factura Crédito 30 días/5 Cuotas - Compra', 30, 'COMPRA', 5, 'Factura Crédito');
insert into tipo_comprobante values (7, 'Factura Crédito 30 días/6 Cuotas - Compra', 30, 'COMPRA', 6, 'Factura Crédito');
insert into tipo_comprobante values (8, 'Factura Contado - Venta', 0, 'VENTA', 0, 'Factura Contado');
insert into tipo_comprobante values (9, 'Factura Crédito 30 días - Venta', 30, 'VENTA', 1, 'Factura Crédito');
insert into tipo_comprobante values (10, 'Factura Crédito 30 días/2 Cuotas - Venta', 30, 'VENTA', 2, 'Factura Crédito');
insert into tipo_comprobante values (11, 'Factura Crédito 30 días/3 Cuotas - Venta', 30, 'VENTA', 3, 'Factura Crédito');
insert into tipo_comprobante values (12, 'Factura Crédito 30 días/4 Cuotas - Venta', 30, 'VENTA', 4, 'Factura Crédito');
insert into tipo_comprobante values (13, 'Factura Crédito 30 días/5 Cuotas - Venta', 30, 'VENTA', 5, 'Factura Crédito');
insert into tipo_comprobante values (14, 'Factura Crédito 30 días/6 Cuotas - Venta', 30, 'VENTA', 6, 'Factura Crédito');
insert into tipo_comprobante values (15, 'Nota de Crédito - Proveedor', 0, 'PAGO PROVEEDOR', 0, 'Nota Crédito');
insert into tipo_comprobante values (16, 'Nota de Crédito - Cliente', 0, 'PAGO CLIENTE', 0, 'Nota Crédito');
insert into tipo_comprobante values (17, 'Recibo de Dinero - Cobranza', 0, 'COBRANZA', 0, 'Recibo Dinero');
insert into tipo_comprobante values (18, 'Movimiento de Caja - Cobranza', 0, 'COBRANZA', 0, 'Movimiento Caja');
insert into tipo_comprobante values (19, 'Pedido - Cliente', 0, 'PEDIDO CLIENTE', 0, 'Pedido');

--Parametros - MARTIN
insert into parametros (cod_parametro, descripcion, valor_numero, valor_texto) values (1, 'SERIE_RECIBO', null, 'A');
insert into parametros (cod_parametro, descripcion, valor_numero, valor_texto) values (2, 'COD_ESTABLECIMIENTO', null, '001');
insert into parametros (cod_parametro, descripcion, valor_numero, valor_texto) values (3, 'COD_BOCA_EXPENDIO', null, '001');
insert into parametros (cod_parametro, descripcion, valor_numero, valor_texto) values (4, 'NRO_TIMBRADO', null, '847586345204');
insert into parametros (cod_parametro, descripcion, valor_numero, valor_texto) values (5, 'VENCIMIENTO_TIMBRADO', null, '30 DE OCTUBRE DE 2010');
insert into parametros (cod_parametro, descripcion, valor_numero, valor_texto) values (6, 'PERIODO_ABIERTO_DESDE', null, '01/01/2010');
insert into parametros (cod_parametro, descripcion, valor_numero, valor_texto) values (7, 'PERIODO_ABIERTO_HASTA', null, '31/01/2010');

--Parametros - FERNANDO
insert into PARAMETROS (COD_PARAMETRO, DESCRIPCION, VALOR_NUMERO, VALOR_TEXTO)
values (1001, 'DOLAR', 4780, null);
insert into PARAMETROS (COD_PARAMETRO, DESCRIPCION, VALOR_NUMERO, VALOR_TEXTO)
values (1000, 'Costo KW/H ANDE', 1000, null);


--Ciudad
insert into ciudad (CODCIUDAD, NOMBRECIUDAD) values (1, 'Asunción');
insert into ciudad (CODCIUDAD, NOMBRECIUDAD) values (2, 'Luque');
insert into ciudad (CODCIUDAD, NOMBRECIUDAD) values (3, 'San Lorenzo');
insert into ciudad (CODCIUDAD, NOMBRECIUDAD) values (4, 'Lambare');
insert into ciudad (CODCIUDAD, NOMBRECIUDAD) values (5, 'Fernando de la Mora');

insert into deposito (COD_DEPOSITO, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, ESTADO) values (1, 'Deposito 1', '', '', null, null, 'ABIERTO');

--Producto
insert into producto (COD_PRODUCTO, DESCRIPCION, COD_MARCA, COD_PRESENTACION, COD_UNIDAD_MEDIDA, COD_TIPO_PRODUCTO, ESTADO, PRECIO_ACTUAL, COSTO_ACTUAL, CONTROLA_EXISTENCIA, CODIGO_INTERNO, FECHA_ALTA, USUARIO_ALTA, USUARIO_MODIF, FECHA_MODIF) values (1, 'Producto Demo', 2, 1, 1, 1, 'A', 150000, 100000, 'S', '748484848', to_date('21-01-2010', 'dd-mm-yyyy'), 'ADMIN', '', null);

--Existencia
insert into existencia (COD_EXISTENCIA, COD_DEPOSITO, COD_PRODUCTO, CANTIDAD_EXISTENCIA, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (1, 1, 1, 2500, 'ADMIN', '', to_date('03-03-2010', 'dd-mm-yyyy'), null);

--Cliente
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (1, 'Cliente', 'Demo', '2441719', 'CI', '2441719', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (2, 'Sandra Mabel', 'Calderoli', '4012345', 'CI', '4012345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (3, 'Mathias Gabriel', 'Jara Calderoli', '1782345', 'CI', '1782345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (4, 'Martin Daniel', 'Jara Calderoli', '8912345', 'CI', '8912345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (5, 'Marcos' , 'Perez', '912345', 'CI', '912345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (6, 'Gerardo', 'Figueredo', '312345', 'CI', '312345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (7, 'Juan', 'Diaz', '142345', 'CI', '142345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (8, 'Bruno', 'Leon', '512345', 'CI', '512345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (9, 'Gilberto', 'Caceres', '612345', 'CI', '612345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (10, 'Roberto ', 'Ramirez', '6612345', 'CI', '1', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (11, 'Diana', 'Flor', '12345', 'CI', '12345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (12, 'Marcos', 'Martinez', '7712345', 'CI', '7712345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (13, 'Jorge', 'Gaona', '7212345', 'CI', '7212345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (14, 'Jose', 'Gaona', '34512345', 'CI', '34512345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (15, 'Armando', 'Ferreira', '9012345', 'CI', '9012345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (16, 'Raquel', 'Baez', '1112345', 'CI', '1112345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (17, 'Maria', 'Prieto', '9912345', 'CI', '9912345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (18, 'Ana Isabel', 'Lopez', '93312345', 'CI', '93312345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (19, 'Laura', 'Adonolfii', '99812345', 'CI', '99812345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (20, 'Mirian', 'Almada', '3412345', 'CI', '3412345', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);



--Proveedor
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (1, 'Proveedor  Demo', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (2, 'Serigrafix S.A.', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (3, 'Formicolor S.A.', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (4, 'Limunotecnia', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (5, 'Ramirez & Asociados', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (6, 'Comercial San Martin', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (7, 'Pinturas Alba', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (8, 'Limpieza El Mejor', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (9, 'TECNO SERVICE S.A.', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (10, 'Inverfin', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (11, 'San Piropolos', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (12, 'Impacto S.A.', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (13, 'ABC Color', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (14, 'Radio Venus', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (15, 'Radio Montecarlo', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (16, 'Sistema Nacional de Television', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (17, 'Carlos Almada', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (18, 'Petrobras', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (19, 'Computec', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (20, 'BEKO Electrodomesticos', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);

--Bancos
insert into banco (cod_banco, nombre_banco, fecha_alta, usuario_alta) values (1, 'Interbanco', sysdate, 'Platinum');
insert into banco (cod_banco, nombre_banco, fecha_alta, usuario_alta) values (2, 'Banco Continental', sysdate, 'Platinum');
insert into banco (cod_banco, nombre_banco, fecha_alta, usuario_alta) values (3, 'Banco Do Brasil', sysdate, 'Platinum');
insert into banco (cod_banco, nombre_banco, fecha_alta, usuario_alta) values (4, 'Banco Regional', sysdate, 'Platinum');
insert into banco (cod_banco, nombre_banco, fecha_alta, usuario_alta) values (5, 'ABN ANRO Bank', sysdate, 'Platinum');

--Cajas
insert into caja(cod_caja, nombre_caja, fecha_alta, usuario_alta) values (1, 'CAJA 1', sysdate, 'Platinum');
insert into caja(cod_caja, nombre_caja, fecha_alta, usuario_alta) values (2, 'CAJA 2', sysdate, 'Platinum');
insert into caja(cod_caja, nombre_caja, fecha_alta, usuario_alta) values (3, 'CAJA 3', sysdate, 'Platinum');
insert into caja(cod_caja, nombre_caja, fecha_alta, usuario_alta) values (4, 'CAJA 4', sysdate, 'Platinum');
insert into caja(cod_caja, nombre_caja, fecha_alta, usuario_alta) values (5, 'CAJA 5', sysdate, 'Platinum');


-- USUARIOS
insert into USUARIOS (USUARIO, PASSWORD, ROL, COD_EMPLEADO, COD_DEPOSITO, ESTADO)
values ('FBOY', 'platinum2010', 'ADMINISTRADOR', 1, 1, 'A');
insert into USUARIOS (USUARIO, PASSWORD, ROL, COD_EMPLEADO, COD_DEPOSITO, ESTADO)
values ('JROLON', 'platinum2010', 'EMP_PRODUCCION', 2, 1, 'A');
insert into USUARIOS (USUARIO, PASSWORD, ROL, COD_EMPLEADO, COD_DEPOSITO, ESTADO)
values ('LLOPEZ', 'platinum2010', 'DEPOSITO', 3, 1, 'A');
insert into USUARIOS (USUARIO, PASSWORD, ROL, COD_EMPLEADO, COD_DEPOSITO, ESTADO)
values ('JTORRES', 'platinum2010', 'SUP_PRODUCCION', 4, 1, 'A');
insert into USUARIOS (USUARIO, PASSWORD, ROL, COD_EMPLEADO, COD_DEPOSITO, ESTADO)
values ('RMELLO', 'platinum2010', 'CAJERO', 5, 1, 'A');
insert into USUARIOS (USUARIO, PASSWORD, ROL, COD_EMPLEADO, COD_DEPOSITO, ESTADO)
values ('MJARA', 'platinum2010', 'ADMINISTRADOR', 6, 1, 'A');
insert into USUARIOS (USUARIO, PASSWORD, ROL, COD_EMPLEADO, COD_DEPOSITO, ESTADO)
values ('LSANTACRUZ', 'platinum2010', 'GERENCIA', 7, 1, 'A');
insert into USUARIOS (USUARIO, PASSWORD, ROL, COD_EMPLEADO, COD_DEPOSITO, ESTADO)
values ('FPEREIRA', 'platinum2010', 'COMPRAS', 8, 1, 'A');

--Formas de pago
insert into forma_pago (cod_forma_pago, nombre_forma_pago, cod_banco) values (1, 'Efectivo', null); 
insert into forma_pago (cod_forma_pago, nombre_forma_pago, cod_banco) values (2, 'Cheque', 1); 
insert into forma_pago (cod_forma_pago, nombre_forma_pago, cod_banco) values (3, 'Cheque', 2); 
insert into forma_pago (cod_forma_pago, nombre_forma_pago, cod_banco) values (4, 'Cheque', 3); 
insert into forma_pago (cod_forma_pago, nombre_forma_pago, cod_banco) values (5, 'Cheque', 4);
insert into forma_pago (cod_forma_pago, nombre_forma_pago, cod_banco) values (6, 'Cheque', 5);
