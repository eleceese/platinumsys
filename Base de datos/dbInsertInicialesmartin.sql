
--Tipos de Comprobantes
insert into tipo_comprobante values (1, 'Factura Contado - Compra', 0, 'COMPRA');
insert into tipo_comprobante values (2, 'Factura Crédito 15 días - Compra', 15, 'COMPRA');
insert into tipo_comprobante values (3, 'Factura Crédito 30 días - Compra', 30, 'COMPRA');
insert into tipo_comprobante values (4, 'Factura Crédito 60 días - Compra', 60, 'COMPRA');
insert into tipo_comprobante values (5, 'Factura Crédito 90 días - Compra', 90, 'COMPRA');
insert into tipo_comprobante values (6, 'Factura Crédito 120 días - Compra', 120, 'COMPRA');
insert into tipo_comprobante values (7, 'Factura Contado - Venta', 0, 'VENTA');
insert into tipo_comprobante values (8, 'Factura Crédito 15 días - Venta', 15, 'VENTA');
insert into tipo_comprobante values (9, 'Factura Crédito 30 días - Venta', 30, 'VENTA');
insert into tipo_comprobante values (10, 'Factura Crédito 60 días - Venta', 60, 'VENTA');
insert into tipo_comprobante values (11, 'Factura Crédito 90 días - Venta', 90, 'VENTA');
insert into tipo_comprobante values (12, 'Factura Crédito 120 días - Venta', 120, 'VENTA');
insert into tipo_comprobante values (13, 'Nota de Crédito - Proveedor', 0, 'PAGO PROVEEDOR');
insert into tipo_comprobante values (14, 'Nota de Crédito - Cliente', 0, 'COBRANZA');
insert into tipo_comprobante values (15, 'Recibo de Dinero - Cobranza', 0, 'COBRANZA');
insert into tipo_comprobante values (16, 'Movimiento de Caja - Cobranza', 0, 'COBRANZA');
insert into tipo_comprobante values (17, 'Pedido - Cliente', 0, 'PEDIDO CLIENTE');

commit;