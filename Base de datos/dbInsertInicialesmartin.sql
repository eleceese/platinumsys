--Cerar tablas
delete from saldo_cliente;
delete from factura_detalle;
delete from factura_cabecera;
delete from pedido_detalle;
delete from pedido_cabecera;
delete from nota_credito_prov_det;
delete from nota_credito_prov_cab;
delete from factura_compra_det;
delete from factura_compra_cab;
delete from factura_detalle;
delete from factura_cabecera;
delete from solicitud_interna;
delete from comision;
delete from existencia;
delete from producto;
delete from tipo_producto;
delete from unidad_medida;
delete from presentacion;
delete from marca;
delete from deposito;
delete from cliente;
delete from proveedor;
delete from tipo_comprobante;
delete from ciudad;

--Tipo Producto
insert into tipo_producto (COD_TIPO_PRODUCTO, DESCRIPCION, TAREAS, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (1, 'Generico', 'N', '', '', null, null);
insert into tipo_producto (COD_TIPO_PRODUCTO, DESCRIPCION, TAREAS, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (2, 'Terminado', 'N', '', '', null, null);
insert into tipo_producto (COD_TIPO_PRODUCTO, DESCRIPCION, TAREAS, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (3, 'SemiTerminado', 'N', '', '', null, null);
insert into tipo_producto (COD_TIPO_PRODUCTO, DESCRIPCION, TAREAS, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (4, 'Insumo', 'N', '', '', null, null);

--Unidad Medida
insert into unidad_medida (COD_UNIDAD_MEDIDA, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (1, 'Unidad', '', '', null, null);
insert into unidad_medida (COD_UNIDAD_MEDIDA, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (2, 'Metros', '', '', null, null);
insert into unidad_medida (COD_UNIDAD_MEDIDA, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (3, 'Kilos', '', '', null, null);
insert into unidad_medida (COD_UNIDAD_MEDIDA, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (4, 'Litros', '', '', null, null);

--Presentacion
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (1, 'Caja', '', '', null, null);
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (2, 'Botella', '', '', null, null);
insert into presentacion (COD_PRESENTACION, DESCRIPCION, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (3, 'Bolsa', '', '', null, null);

--Marcas
insert into marca (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (1, 'SIN MARCA', '', '', null, null);
insert into marca (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (2, 'Opal', '', '', null, null);
insert into marca (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (3, 'Cascolar', '', '', null, null);
insert into marca (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (5, 'Erichkrause', '', '', null, null);
insert into marca (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (6, 'Dello', '', '', null, null);
insert into marca (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (7, 'Valoro', '', '', null, null);
insert into marca (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (8, 'Nedo', '', '', null, null);
insert into marca (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (9, 'Lamy', '', '', null, null);
insert into marca (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (10, 'UHU', '', '', null, null);
insert into marca (COD_MARCA, NOMBRE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (11, 'Caran d''ache', '', '', null, null);

--Tipos de Comprobantes
insert into tipo_comprobante values (1, 'Factura Contado - Compra', 0, 'COMPRA', 0);
insert into tipo_comprobante values (2, 'Factura Crédito 30 días - Compra', 30, 'COMPRA', 1);
insert into tipo_comprobante values (3, 'Factura Crédito 30 días/2 Cuotas - Compra', 30, 'COMPRA', 2);
insert into tipo_comprobante values (4, 'Factura Crédito 30 días/3 Cuotas - Compra', 30, 'COMPRA', 3);
insert into tipo_comprobante values (5, 'Factura Crédito 30 días/4 Cuotas - Compra', 30, 'COMPRA', 4);
insert into tipo_comprobante values (6, 'Factura Crédito 30 días/5 Cuotas - Compra', 30, 'COMPRA', 5);
insert into tipo_comprobante values (7, 'Factura Crédito 30 días/6 Cuotas - Compra', 30, 'COMPRA', 6);
insert into tipo_comprobante values (8, 'Factura Contado - Venta', 0, 'VENTA', 0);
insert into tipo_comprobante values (9, 'Factura Crédito 30 días - Venta', 30, 'VENTA', 1);
insert into tipo_comprobante values (10, 'Factura Crédito 30 días/2 Cuotas - Venta', 30, 'VENTA', 2);
insert into tipo_comprobante values (11, 'Factura Crédito 30 días/3 Cuotas - Venta', 30, 'VENTA', 3);
insert into tipo_comprobante values (12, 'Factura Crédito 30 días/4 Cuotas - Venta', 30, 'VENTA', 4);
insert into tipo_comprobante values (13, 'Factura Crédito 30 días/5 Cuotas - Venta', 30, 'VENTA', 5);
insert into tipo_comprobante values (14, 'Factura Crédito 30 días/6 Cuotas - Venta', 30, 'VENTA', 6);

insert into tipo_comprobante values (15, 'Nota de Crédito - Proveedor', 0, 'PAGO PROVEEDOR', 0);
insert into tipo_comprobante values (16, 'Nota de Crédito - Cliente', 0, 'PAGO CLIENTE', 0);
insert into tipo_comprobante values (17, 'Recibo de Dinero - Cobranza', 0, 'COBRANZA', 0);
insert into tipo_comprobante values (18, 'Movimiento de Caja - Cobranza', 0, 'COBRANZA', 0);
insert into tipo_comprobante values (19, 'Pedido - Cliente', 0, 'PEDIDO CLIENTE', 0);

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
insert into cliente (COD_CLIENTE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE, RUC_CLIENTE, DIRECCION_CLIENTE, TELEFONO1_CLIENTE, TELEFONO2_CLIENTE, MAIL_CLIENTE, CONTACTO1_CLIENTE, CONTACTO2_CLIENTE, ESTADO_CLIENTE, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF, COD_CIUDAD) values (1, 'Cliente', 'Demo', '12345', '1', '1', '1', '1', '1', '1', '1', '1', 'A', '', '', to_date('24-02-2010', 'dd-mm-yyyy'), null, 1);

--Proveedor
insert into proveedor (COD_PROVEEDOR, NOMBRE_PROVEEDOR, RUC_PROVEEDOR, TELEFONO1_PROVEEDOR, TELEFONO2_PROVEEDOR, DIRECCION_PROVEEDOR, MAIL_PROVEEDOR, CONTACTO_PROVEEDOR, ESTADO_PROVEEDOR, USUARIO_ALTA, USUARIO_MODIF, FECHA_ALTA, FECHA_MODIF) values (1, 'Proveedor  Demo', '123456', '12345', '8514693', 'Azara 352', 'demo@prov.com.py', 'Contacto Demo', 'A', 'Admin', '', to_date('18-02-2010', 'dd-mm-yyyy'), null);

commit;