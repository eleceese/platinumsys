----------------------------------------------
-- Export file for user PLATINUM            --
-- Created by mjara on 26/02/2010, 17:43:15 --
----------------------------------------------

spool Tablas.log

prompt
prompt Creating table BANCO
prompt ====================
prompt
create table BANCO
(
  COD_BANCO     NUMBER(15) not null,
  NOMBRE_BANCO  VARCHAR2(40) not null,
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
;
alter table BANCO
  add constraint BANCO_PK primary key (COD_BANCO);

prompt
prompt Creating table CAB
prompt ==================
prompt
create table CAB
(
  ID  NUMBER(10) not null,
  DSC VARCHAR2(10)
)
;
alter table CAB
  add constraint PK_CAB primary key (ID);

prompt
prompt Creating table CABECERA
prompt =======================
prompt
create table CABECERA
(
  ID     NUMBER(5) not null,
  NOMBRE VARCHAR2(10)
)
;
alter table CABECERA
  add primary key (ID);

prompt
prompt Creating table CAJA
prompt ===================
prompt
create table CAJA
(
  COD_CAJA      NUMBER(15) not null,
  NOMBRE_CAJA   VARCHAR2(10) not null,
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
;
alter table CAJA
  add constraint CAJA_PK primary key (COD_CAJA);
alter table CAJA
  add constraint NOMBRE_CAJA_UK1 unique (NOMBRE_CAJA);

prompt
prompt Creating table CARGO
prompt ====================
prompt
create table CARGO
(
  COD_CARGO     NUMBER not null,
  NOMBRE_CARGO  VARCHAR2(300) not null,
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
;
alter table CARGO
  add constraint CARGO_PK primary key (COD_CARGO);
alter table CARGO
  add constraint CARGO_UK1 unique (NOMBRE_CARGO);

prompt
prompt Creating table CIUDAD
prompt =====================
prompt
create table CIUDAD
(
  CODCIUDAD    NUMBER(10) not null,
  NOMBRECIUDAD VARCHAR2(100) not null
)
;
alter table CIUDAD
  add constraint PK_CIUDAD primary key (CODCIUDAD);

prompt
prompt Creating table CLIENTE
prompt ======================
prompt
create table CLIENTE
(
  COD_CLIENTE        NUMBER not null,
  NOMBRE_CLIENTE     VARCHAR2(40) not null,
  APELLIDO_CLIENTE   VARCHAR2(40) not null,
  NUMERO_DOC_CLIENTE VARCHAR2(15) not null,
  TIPO_DOD_CLIENTE   VARCHAR2(3) not null,
  RUC_CLIENTE        VARCHAR2(15),
  DIRECCION_CLIENTE  VARCHAR2(300),
  TELEFONO1_CLIENTE  VARCHAR2(15),
  TELEFONO2_CLIENTE  VARCHAR2(15),
  MAIL_CLIENTE       VARCHAR2(30),
  CONTACTO1_CLIENTE  VARCHAR2(40),
  CONTACTO2_CLIENTE  VARCHAR2(40),
  ESTADO_CLIENTE     VARCHAR2(1),
  USUARIO_ALTA       VARCHAR2(15),
  USUARIO_MODIF      VARCHAR2(15),
  FECHA_ALTA         DATE,
  FECHA_MODIF        DATE,
  COD_CIUDAD         NUMBER(10)
)
;
alter table CLIENTE
  add constraint CLIENTE_PK primary key (COD_CLIENTE);
alter table CLIENTE
  add constraint CLIENTE_UK1 unique (NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE);
alter table CLIENTE
  add constraint CLIENTE_UK2 unique (RUC_CLIENTE);
alter table CLIENTE
  add constraint FK_CLI_CIU foreign key (COD_CIUDAD)
  references CIUDAD (CODCIUDAD);

prompt
prompt Creating table TIPO_PRODUCTO
prompt ============================
prompt
create table TIPO_PRODUCTO
(
  COD_TIPO_PRODUCTO NUMBER(28) not null,
  DESCRIPCION       VARCHAR2(30) not null,
  TAREAS            VARCHAR2(1) default 'S' not null,
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE
)
;
alter table TIPO_PRODUCTO
  add constraint TIPO_PRODUCTO_PK primary key (COD_TIPO_PRODUCTO);

prompt
prompt Creating table UNIDAD_MEDIDA
prompt ============================
prompt
create table UNIDAD_MEDIDA
(
  COD_UNIDAD_MEDIDA NUMBER(28) not null,
  DESCRIPCION       VARCHAR2(30) not null,
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE
)
;
alter table UNIDAD_MEDIDA
  add constraint UNIDAD_MEDIDA_PK primary key (COD_UNIDAD_MEDIDA);

prompt
prompt Creating table MARCA
prompt ====================
prompt
create table MARCA
(
  COD_MARCA     NUMBER(28) not null,
  NOMBRE        VARCHAR2(30) not null,
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
;
alter table MARCA
  add constraint MARCA_PK primary key (COD_MARCA);

prompt
prompt Creating table PRESENTACION
prompt ===========================
prompt
create table PRESENTACION
(
  COD_PRESENTACION NUMBER(28) not null,
  DESCRIPCION      VARCHAR2(30) not null,
  USUARIO_ALTA     VARCHAR2(15),
  USUARIO_MODIF    VARCHAR2(15),
  FECHA_ALTA       DATE,
  FECHA_MODIF      DATE
)
;
alter table PRESENTACION
  add constraint PRESENTACION_PK primary key (COD_PRESENTACION);

prompt
prompt Creating table PRODUCTO
prompt =======================
prompt
create table PRODUCTO
(
  COD_PRODUCTO        NUMBER not null,
  DESCRIPCION         VARCHAR2(60) not null,
  COD_MARCA           NUMBER not null,
  COD_PRESENTACION    NUMBER not null,
  COD_UNIDAD_MEDIDA   NUMBER not null,
  COD_TIPO_PRODUCTO   NUMBER not null,
  ESTADO              VARCHAR2(1) default 'A',
  PRECIO_ACTUAL       NUMBER,
  COSTO_ACTUAL        NUMBER,
  CONTROLA_EXISTENCIA VARCHAR2(1) default 'N' not null,
  CODIGO_INTERNO      VARCHAR2(28),
  FECHA_ALTA          DATE,
  USUARIO_ALTA        VARCHAR2(15),
  USUARIO_MODIF       VARCHAR2(15),
  FECHA_MODIF         DATE
)
;
alter table PRODUCTO
  add constraint PRODUCTO_PK primary key (COD_PRODUCTO);
alter table PRODUCTO
  add constraint PRODUCTO_FK4 foreign key (COD_TIPO_PRODUCTO)
  references TIPO_PRODUCTO (COD_TIPO_PRODUCTO);
alter table PRODUCTO
  add constraint PRODUCTO_MARCA_FK foreign key (COD_MARCA)
  references MARCA (COD_MARCA);
alter table PRODUCTO
  add constraint PRODUCTO_PRESENTACION foreign key (COD_PRESENTACION)
  references PRESENTACION (COD_PRESENTACION);
alter table PRODUCTO
  add constraint PRODUCTO_UNIDAD_MEDIDA foreign key (COD_UNIDAD_MEDIDA)
  references UNIDAD_MEDIDA (COD_UNIDAD_MEDIDA);

prompt
prompt Creating table COMISION
prompt =======================
prompt
create table COMISION
(
  COD_COMISION  NUMBER not null,
  COD_PRODUCTO  NUMBER not null,
  PORCENTAJE    NUMBER(5,2) not null,
  FEC_INICIAL   DATE,
  FEC_FINAL     DATE,
  ESTADO        VARCHAR2(1),
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
;
alter table COMISION
  add constraint COMISION_PK primary key (COD_COMISION);
alter table COMISION
  add constraint FK_COMISION_PRODUCTO foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table COMISION
  add constraint CHK_PORC
  check (PORCENTAJE > 0);
alter table COMISION
  add constraint COMISION_CK1
  check (	FEC_INICIAL <= FEC_FINAL);

prompt
prompt Creating table SECCION
prompt ======================
prompt
create table SECCION
(
  COD_SECCION    NUMBER not null,
  NOMBRE_SECCION VARCHAR2(30) not null,
  USUARIO_ALTA   VARCHAR2(15),
  USUARIO_MODIF  VARCHAR2(15),
  FECHA_ALTA     DATE,
  FECHA_MODIF    DATE
)
;
alter table SECCION
  add constraint SECCION_PK primary key (COD_SECCION);
create unique index SECCION_NOMBRE_UK on SECCION (NOMBRE_SECCION);

prompt
prompt Creating table EMPLEADO
prompt =======================
prompt
create table EMPLEADO
(
  COD_EMPLEADO              NUMBER not null,
  COD_CARGO                 NUMBER not null,
  COD_SECCION               NUMBER not null,
  NOMBRE_EMPLEADO           VARCHAR2(40) not null,
  APELLIDO_EMPLEADO         VARCHAR2(40) not null,
  CIN_EMPLEADO              VARCHAR2(20),
  ESTADO_CIVIL_EMPLEADO     VARCHAR2(1),
  SEXO_EMPLEADO             VARCHAR2(1),
  NACIONALIDAD_EMPLEADO     VARCHAR2(20),
  FECHA_NACIMIENTO_EMPLEADO DATE,
  DIRECCION_EMPLEADO        VARCHAR2(200),
  TELEFONO1_EMPLEADO        VARCHAR2(20),
  TELEFONO2_EMPLEADO        VARCHAR2(20),
  MAIL_EMPLEADO             VARCHAR2(40),
  FECHA_INGRESO_EMPLEADO    DATE,
  IPS_EMPLEADO              VARCHAR2(20),
  HIJOS_EMPLEADO            NUMBER,
  SALARIO_EMPLEADO          NUMBER,
  TIPO_EMPLEADO             VARCHAR2(1),
  ESTADO_EMPLEADO           VARCHAR2(1),
  USUARIO_ALTA              VARCHAR2(15),
  USUARIO_MODIF             VARCHAR2(15),
  FECHA_ALTA                DATE,
  FECHA_MODIF               DATE
)
;
alter table EMPLEADO
  add constraint EMPLEADO_PK primary key (COD_EMPLEADO);
alter table EMPLEADO
  add constraint EMPLEADO_CARGO_FK2 foreign key (COD_CARGO)
  references CARGO (COD_CARGO);
alter table EMPLEADO
  add constraint EMPLEADO_SECCION_FK3 foreign key (COD_SECCION)
  references SECCION (COD_SECCION);

prompt
prompt Creating table COMISION_MENS_CAB
prompt ================================
prompt
create table COMISION_MENS_CAB
(
  COD_COM_MEN_CAB NUMBER(15) not null,
  FECHA           DATE,
  COD_EMPLEADO    NUMBER(15),
  FEC_INICIAL     DATE,
  FEC_FINAL       DATE,
  ESTADO          VARCHAR2(1),
  TOTAL           NUMBER(15),
  USUARIO_ALTA    VARCHAR2(15),
  USUARIO_MODIF   VARCHAR2(15),
  FECHA_ALTA      DATE,
  FECHA_MODIF     DATE
)
;
alter table COMISION_MENS_CAB
  add constraint COMISION_MENS_CAB_PK primary key (COD_COM_MEN_CAB);
alter table COMISION_MENS_CAB
  add constraint COMISION_MENS_CAB_FK foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);
alter table COMISION_MENS_CAB
  add constraint COM_MENS_CAB_CHK_FEC
  check (FEC_INICIAL <= FEC_FINAL);

prompt
prompt Creating table COMISION_MENS_DET
prompt ================================
prompt
create table COMISION_MENS_DET
(
  COD_COM_MEN_DET        NUMBER(15) not null,
  COD_COM_MEN_CAB        NUMBER(15),
  COD_PRODUCTO           NUMBER(15),
  DET_COM_PORC           NUMBER(5,2),
  DET_COM_MONTO_COMISION NUMBER(15),
  DET_COM_MONTO_VENTA    NUMBER(15),
  USUARIO_ALTA           VARCHAR2(15),
  USUARIO_MODIF          VARCHAR2(15),
  FECHA_ALTA             DATE,
  FECHA_MODIF            DATE
)
;
alter table COMISION_MENS_DET
  add constraint COMISION_MENS_DET_PK primary key (COD_COM_MEN_DET);
alter table COMISION_MENS_DET
  add constraint FK_COMISION_MENS_CABDET foreign key (COD_COM_MEN_CAB)
  references COMISION_MENS_CAB (COD_COM_MEN_CAB);
alter table COMISION_MENS_DET
  add constraint FK_COMISION_MENS_DET_PROD foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table ORDEN_TRABAJO
prompt ============================
prompt
create table ORDEN_TRABAJO
(
  NUMERO_ORDEN_TRABAJO  NUMBER not null,
  FECHA_OT              DATE,
  FECHA_INICIAL_OT      DATE,
  FECHA_FIN_OT          DATE,
  COD_PRODUCTO_OT       NUMBER not null,
  CANTIDAD_OT           NUMBER not null,
  CANTIDAD_PRODUCIDA_OT NUMBER,
  ESTADO_OT             NUMBER,
  COSTO_ESTIMADO_OT     NUMBER,
  COSTO_REAL_OT         NUMBER,
  COD_EMPLEADO1         NUMBER not null,
  COD_EMPLEADO2         NUMBER not null,
  PORCENTAJE_TERMINADO  NUMBER(15),
  COD_ORDEN_TRABJO      NUMBER(15) not null,
  USUARIO_ALTA          VARCHAR2(15),
  USUARIO_MODIF         VARCHAR2(15),
  FECHA_ALTA            DATE,
  FECHA_MODIF           DATE
)
;
alter table ORDEN_TRABAJO
  add primary key (COD_ORDEN_TRABJO);
alter table ORDEN_TRABAJO
  add constraint ORDEN_TRABAJO_EMPLEADO_FK2 foreign key (COD_EMPLEADO1)
  references EMPLEADO (COD_EMPLEADO);
alter table ORDEN_TRABAJO
  add constraint ORDEN_TRABAJO_EMPLEADO_FK3 foreign key (COD_EMPLEADO2)
  references EMPLEADO (COD_EMPLEADO);
alter table ORDEN_TRABAJO
  add constraint ORDEN_TRABAJO_PRODUCTO_FK foreign key (COD_PRODUCTO_OT)
  references PRODUCTO (COD_PRODUCTO);
alter table ORDEN_TRABAJO
  add constraint OT_CANT_CK
  check (CANTIDAD_OT > 0);

prompt
prompt Creating table COSTOS_FIJOS
prompt ===========================
prompt
create table COSTOS_FIJOS
(
  COD_COSTO_FIJO    NUMBER(15) not null,
  COD_ORDEN_TRABAJO NUMBER(15),
  DESCRIPCION_GASTO VARCHAR2(200),
  MONTO             NUMBER,
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE
)
;
alter table COSTOS_FIJOS
  add constraint COSTOS_FIJOS_PK primary key (COD_COSTO_FIJO);
alter table COSTOS_FIJOS
  add constraint COSTOS_FIJOS_OT_FK foreign key (COD_ORDEN_TRABAJO)
  references ORDEN_TRABAJO (COD_ORDEN_TRABJO);
alter table COSTOS_FIJOS
  add constraint MONTO_CK
  check (MONTO > 0);

prompt
prompt Creating table DEPOSITO
prompt =======================
prompt
create table DEPOSITO
(
  COD_DEPOSITO  NUMBER not null,
  NOMBRE        VARCHAR2(30) not null,
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE,
  ESTADO        VARCHAR2(15) default 'ABIERTO'
)
;
alter table DEPOSITO
  add constraint DEPOSITO_PK primary key (COD_DEPOSITO);
alter table DEPOSITO
  add constraint DEPOSITO_UK1 unique (NOMBRE);

prompt
prompt Creating table DET
prompt ==================
prompt
create table DET
(
  ID  NUMBER(10) not null,
  DSC VARCHAR2(10),
  CAB NUMBER(10) not null
)
;
alter table DET
  add constraint PK_DET primary key (ID);
alter table DET
  add constraint FK_DET_CAB foreign key (CAB)
  references CAB (ID);

prompt
prompt Creating table DETALLE
prompt ======================
prompt
create table DETALLE
(
  ID_DET     NUMBER(5) not null,
  ID_CAB     NUMBER(5) not null,
  NOMBRE_DET VARCHAR2(10)
)
;
alter table DETALLE
  add primary key (ID_DET);
alter table DETALLE
  add constraint CAB_DET foreign key (ID_CAB)
  references CABECERA (ID);

prompt
prompt Creating table DET2
prompt ===================
prompt
create table DET2
(
  ID  NUMBER(10) not null,
  DSC VARCHAR2(10),
  CAB NUMBER(10) not null
)
;
alter table DET2
  add constraint PK_DET2 primary key (ID);
alter table DET2
  add constraint FK_DET2_CAB foreign key (CAB)
  references CAB (ID);

prompt
prompt Creating table SOLICITUD_INTERNA
prompt ================================
prompt
create table SOLICITUD_INTERNA
(
  COD_SOLICITUD     NUMBER(15) not null,
  FECHA             DATE not null,
  ESTADO            VARCHAR2(1) not null,
  COD_EMPLEADO      NUMBER(15) not null,
  COD_PRODUCTO      NUMBER(15) not null,
  CANTIDAD          NUMBER(10) not null,
  CANTIDAD_APROBADA NUMBER(10) not null,
  CANTIDAD_COMPRA   NUMBER(10) not null,
  OBSERVACION       VARCHAR2(200) not null,
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE
)
;
alter table SOLICITUD_INTERNA
  add constraint SOLICITUD_PK primary key (COD_SOLICITUD);
alter table SOLICITUD_INTERNA
  add constraint FK_SOLICITUD_PRODUCTO foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table SOLICITUD_INTERNA
  add constraint SOLICITUD_EMPLEADO foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);

prompt
prompt Creating table ENTRADA_SALIDA_CABECERA
prompt ======================================
prompt
create table ENTRADA_SALIDA_CABECERA
(
  COD_ENTRADA_SALIDA   NUMBER(15) not null,
  COD_SOLICITUD        NUMBER(15),
  COD_ORDEN_TRABAJO    NUMBER(15),
  COD_EMPLEADO         NUMBER(15) not null,
  COD_ENCARGADO        NUMBER(15) not null,
  COD_DEPOSITO         NUMBER(15) not null,
  FECHA_ENTRADA_SALIDA DATE,
  HORA_ENTRADA_SALIDA  DATE,
  OBSERVACION          VARCHAR2(200),
  USUARIO_ALTA         VARCHAR2(15),
  USUARIO_MODIF        VARCHAR2(15),
  FECHA_ALTA           DATE,
  FECHA_MODIF          DATE
)
;
alter table ENTRADA_SALIDA_CABECERA
  add constraint ENTRADA_SALIDA_CABECERA_PK primary key (COD_ENTRADA_SALIDA);
alter table ENTRADA_SALIDA_CABECERA
  add constraint ENT_SAL_DEPOSITO_FK foreign key (COD_DEPOSITO)
  references DEPOSITO (COD_DEPOSITO);
alter table ENTRADA_SALIDA_CABECERA
  add constraint ENT_SAL_EMPLEADO_FK foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);
alter table ENTRADA_SALIDA_CABECERA
  add constraint ENT_SAL_ENCARGADO_FK foreign key (COD_ENCARGADO)
  references EMPLEADO (COD_EMPLEADO);
alter table ENTRADA_SALIDA_CABECERA
  add constraint FK_ENT_SAL_CABECERA_SOLICITUD foreign key (COD_SOLICITUD)
  references SOLICITUD_INTERNA (COD_SOLICITUD);

prompt
prompt Creating table ENTRADA_SALIDA_DETALLE
prompt =====================================
prompt
create table ENTRADA_SALIDA_DETALLE
(
  COD_ENT_SAL_DETALLE    NUMBER not null,
  COD_ENTRADA_SALIDA     NUMBER not null,
  COD_PRODUCTO           NUMBER not null,
  CANTIDAD_ENT_SAL       NUMBER not null,
  OBSERVACION            VARCHAR2(200),
  ESTADO_DETALLE_ENT_SAL VARCHAR2(1),
  TIPO_ENTRADA_SALIDA    VARCHAR2(1) default 'E' not null,
  USUARIO_ALTA           VARCHAR2(15),
  USUARIO_MODIF          VARCHAR2(15),
  FECHA_ALTA             DATE,
  FECHA_MODIF            DATE
)
;
alter table ENTRADA_SALIDA_DETALLE
  add constraint ENTRADA_SALIDA_DETALLE_PK primary key (COD_ENT_SAL_DETALLE);
alter table ENTRADA_SALIDA_DETALLE
  add constraint CAB_DET_ENT_SAL foreign key (COD_ENTRADA_SALIDA)
  references ENTRADA_SALIDA_CABECERA (COD_ENTRADA_SALIDA);
alter table ENTRADA_SALIDA_DETALLE
  add constraint ENT_SAL_PRODUCTO foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table ENTRADA_SALIDA_DETALLE
  add constraint VALID_CANT_ENT_SAL
  check (cantidad_ent_sal > 0);
alter table ENTRADA_SALIDA_DETALLE
  add constraint VALID_TIPO_ENT_SAL_CHK
  check (TIPO_ENTRADA_SALIDA = 'E' or TIPO_ENTRADA_SALIDA = 'S' );

prompt
prompt Creating table EXISTENCIA
prompt =========================
prompt
create table EXISTENCIA
(
  COD_EXISTENCIA      NUMBER not null,
  COD_DEPOSITO        NUMBER not null,
  COD_PRODUCTO        NUMBER not null,
  CANTIDAD_EXISTENCIA NUMBER,
  USUARIO_ALTA        VARCHAR2(15),
  USUARIO_MODIF       VARCHAR2(15),
  FECHA_ALTA          DATE,
  FECHA_MODIF         DATE
)
;
alter table EXISTENCIA
  add constraint EXISTENCIA_PK primary key (COD_EXISTENCIA, COD_DEPOSITO);
alter table EXISTENCIA
  add constraint EXISTENCIA_UK1 unique (COD_DEPOSITO, COD_PRODUCTO);
alter table EXISTENCIA
  add constraint EXISTENCIA_DEPOSITO_FK foreign key (COD_DEPOSITO)
  references DEPOSITO (COD_DEPOSITO);
alter table EXISTENCIA
  add constraint EXISTENCIA_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table TIPO_COMPROBANTE
prompt ===============================
prompt
create table TIPO_COMPROBANTE
(
  COD_TIPO  NUMBER(10) not null,
  DESC_TIPO VARCHAR2(50) not null,
  CANT_DIAS NUMBER(5) not null,
  MODULO    VARCHAR2(30)
)
;
alter table TIPO_COMPROBANTE
  add constraint PK_TIPO_COMPROBANTE primary key (COD_TIPO);

prompt
prompt Creating table PEDIDO_CABECERA
prompt ==============================
prompt
create table PEDIDO_CABECERA
(
  COD_PEDIDO      NUMBER not null,
  NUMERO_PEDIDO   VARCHAR2(15) not null,
  COD_EMPLEADO    NUMBER not null,
  COD_CLIENTE     NUMBER not null,
  FECHA_PEDIDO    DATE not null,
  ESTADO_PEDIDO   VARCHAR2(15),
  USUARIO_ALTA    VARCHAR2(15),
  USUARIO_MODIF   VARCHAR2(15),
  FECHA_ALTA      DATE,
  FECHA_MODIF     DATE,
  TIPO            NUMBER(10),
  SUB_TOTAL       NUMBER not null,
  TOTAL_IVA       NUMBER not null,
  PORC_DESCUENTO  NUMBER(5,2) not null,
  MONTO_DESCUENTO NUMBER not null,
  TOTAL           NUMBER not null
)
;
alter table PEDIDO_CABECERA
  add constraint PEDIDO_CABECERA_PK primary key (COD_PEDIDO);
alter table PEDIDO_CABECERA
  add constraint FK_PEDIDOCAB_TIPCOMPRO foreign key (TIPO)
  references TIPO_COMPROBANTE (COD_TIPO);
alter table PEDIDO_CABECERA
  add constraint PEDIDO_CLIENTE_FK foreign key (COD_CLIENTE)
  references CLIENTE (COD_CLIENTE);
alter table PEDIDO_CABECERA
  add constraint PEDIDO_EMPLEADO_FK foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);

prompt
prompt Creating table FACTURA_CABECERA
prompt ===============================
prompt
create table FACTURA_CABECERA
(
  COD_FACTURA       NUMBER not null,
  NUMERO_FACTURA    NUMBER not null,
  COD_PEDIDO        NUMBER,
  COD_CLIENTE       NUMBER not null,
  COD_EMPLEADO      NUMBER not null,
  TIPO_FACTURA      NUMBER(10) not null,
  FECHA_FACTURA     DATE not null,
  SUBTOTAL_FACTURA  NUMBER,
  TOTAL_IVA_FACTURA NUMBER,
  TOTAL_FACTURA     NUMBER,
  ESTADO_FACTURA    VARCHAR2(15),
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE,
  PORC_DESCUENTO    NUMBER(5,2) not null,
  MONTO_DESCUENTO   NUMBER not null
)
;
alter table FACTURA_CABECERA
  add constraint FACTURA_CABECERA_PK primary key (COD_FACTURA);
alter table FACTURA_CABECERA
  add constraint FACTURA_CABECERA_FK3 foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);
alter table FACTURA_CABECERA
  add constraint FACTURA_CLIENTE_FK foreign key (COD_CLIENTE)
  references CLIENTE (COD_CLIENTE);
alter table FACTURA_CABECERA
  add constraint FACTURA_PEDIDO_FK foreign key (COD_PEDIDO)
  references PEDIDO_CABECERA (COD_PEDIDO);
alter table FACTURA_CABECERA
  add constraint FK_FACTURACAB_TIPCOMPRO foreign key (TIPO_FACTURA)
  references TIPO_COMPROBANTE (COD_TIPO);

prompt
prompt Creating table PROVEEDOR
prompt ========================
prompt
create table PROVEEDOR
(
  COD_PROVEEDOR       NUMBER not null,
  NOMBRE_PROVEEDOR    VARCHAR2(30) not null,
  RUC_PROVEEDOR       VARCHAR2(20),
  TELEFONO1_PROVEEDOR VARCHAR2(20),
  TELEFONO2_PROVEEDOR VARCHAR2(20),
  DIRECCION_PROVEEDOR VARCHAR2(300),
  MAIL_PROVEEDOR      VARCHAR2(30),
  CONTACTO_PROVEEDOR  VARCHAR2(50),
  ESTADO_PROVEEDOR    VARCHAR2(1),
  USUARIO_ALTA        VARCHAR2(15),
  USUARIO_MODIF       VARCHAR2(15),
  FECHA_ALTA          DATE,
  FECHA_MODIF         DATE
)
;
alter table PROVEEDOR
  add constraint PROVEEDOR_PK primary key (COD_PROVEEDOR);
alter table PROVEEDOR
  add constraint PROVEEDOR_UK1 unique (NOMBRE_PROVEEDOR);

prompt
prompt Creating table FACTURA_COMPRA_CAB
prompt =================================
prompt
create table FACTURA_COMPRA_CAB
(
  COD_FAC_COM_CAB NUMBER(15) not null,
  NRO_FACTURA     VARCHAR2(20) not null,
  NRO_SOLICITUD   NUMBER(15),
  FECHA           DATE not null,
  COD_PROVEEDOR   NUMBER(15) not null,
  TIPO            NUMBER(10),
  COD_ENT_SAL     NUMBER(15),
  ESTADO          VARCHAR2(1) not null,
  SUB_TOTAL       NUMBER(15) not null,
  TOTA_IVA        NUMBER(10) not null,
  TOTAL           NUMBER(15) not null,
  USUARIO_ALTA    VARCHAR2(15),
  USUARIO_MODIF   VARCHAR2(15),
  FECHA_ALTA      DATE,
  FECHA_MODIF     DATE
)
;
alter table FACTURA_COMPRA_CAB
  add constraint FACTURA_COMPRA_CAB_PK primary key (COD_FAC_COM_CAB);
alter table FACTURA_COMPRA_CAB
  add constraint FACTURA_COMPRA_CAB_PROV foreign key (COD_PROVEEDOR)
  references PROVEEDOR (COD_PROVEEDOR);
alter table FACTURA_COMPRA_CAB
  add constraint FK_FACCOMCAB_TIPCOMPRO foreign key (TIPO)
  references TIPO_COMPROBANTE (COD_TIPO);
alter table FACTURA_COMPRA_CAB
  add constraint FK_FACTURA_COMPRA_CAB_ENTSAL foreign key (COD_ENT_SAL)
  references ENTRADA_SALIDA_CABECERA (COD_ENTRADA_SALIDA);
alter table FACTURA_COMPRA_CAB
  add constraint FK_FACTURA_COMPRA_CAB_SOL foreign key (NRO_SOLICITUD)
  references SOLICITUD_INTERNA (COD_SOLICITUD);

prompt
prompt Creating table FACTURA_COMPRA_DET
prompt =================================
prompt
create table FACTURA_COMPRA_DET
(
  COD_FAC_COM_DET NUMBER(15) not null,
  COD_FAC_COM_CAB NUMBER(15) not null,
  COD_PRODUCTO    NUMBER(15) not null,
  PRECIO_UNI      NUMBER(10) not null,
  CANTIDAD        NUMBER(10) not null,
  TOTAL           NUMBER(15) not null,
  MONTO_IVA       NUMBER(15) not null,
  USUARIO_ALTA    VARCHAR2(15),
  USUARIO_MODIF   VARCHAR2(15),
  FECHA_ALTA      DATE,
  FECHA_MODIF     DATE,
  PORC_IVA        NUMBER(4,2),
  NRO_SOLICITUD   NUMBER(15)
)
;
alter table FACTURA_COMPRA_DET
  add constraint FACTURA_COMPRA_DET_PK primary key (COD_FAC_COM_DET);
alter table FACTURA_COMPRA_DET
  add constraint FK_COMPRA_DET_SOLICITUD foreign key (NRO_SOLICITUD)
  references SOLICITUD_INTERNA (COD_SOLICITUD);
alter table FACTURA_COMPRA_DET
  add constraint FK_FACTURA_COMPRA_DET_CAB foreign key (COD_FAC_COM_CAB)
  references FACTURA_COMPRA_CAB (COD_FAC_COM_CAB);
alter table FACTURA_COMPRA_DET
  add constraint FK_FACTURA_COMPRA_DET_PROD foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table FACTURA_COMPRA_DET
  add constraint FAC_COM_DET_CHK_CANT
  check (CANTIDAD > 0);

prompt
prompt Creating table FACTURA_DETALLE
prompt ==============================
prompt
create table FACTURA_DETALLE
(
  COD_FACTURA_DETALLE NUMBER not null,
  COD_FACTURA         NUMBER,
  COD_PRODUCTO        NUMBER,
  PRECIO_UNITARIO     NUMBER,
  CANTIDAD            NUMBER,
  PORCENTAJE_IVA      NUMBER(5,2),
  TOTAL_IVA           NUMBER,
  SUB_TOTAL           NUMBER,
  USUARIO_ALTA        VARCHAR2(15),
  USUARIO_MODIF       VARCHAR2(15),
  FECHA_ALTA          DATE,
  FECHA_MODIF         DATE
)
;
alter table FACTURA_DETALLE
  add constraint FACTURA_DETALLE_PK primary key (COD_FACTURA_DETALLE);
alter table FACTURA_DETALLE
  add constraint FACTURA_DETALLE_FK foreign key (COD_FACTURA)
  references FACTURA_CABECERA (COD_FACTURA);
alter table FACTURA_DETALLE
  add constraint FACTURA_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table FACTURA_DETALLE
  add constraint FACTURA_CANTIDAD_CHK
  check (CANTIDAD > 0);
alter table FACTURA_DETALLE
  add constraint FACTURA_PRECIO_CHK
  check (PRECIO_UNITARIO > 0);

prompt
prompt Creating table FORMA_PAGO
prompt =========================
prompt
create table FORMA_PAGO
(
  COD_FORMA_PAGO    NUMBER(15) not null,
  NOMBRE_FORMA_PAGO VARCHAR2(30) not null,
  COD_BANCO         NUMBER(15),
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE
)
;
alter table FORMA_PAGO
  add constraint FORMA_PAGO_PK primary key (COD_FORMA_PAGO);
alter table FORMA_PAGO
  add constraint FORMA_PAGO_BANCO_UK1 unique (NOMBRE_FORMA_PAGO, COD_BANCO);
alter table FORMA_PAGO
  add constraint FORMA_PAGO_BANCO_FK foreign key (COD_BANCO)
  references BANCO (COD_BANCO);

prompt
prompt Creating table FORMULA_CABECERA
prompt ===============================
prompt
create table FORMULA_CABECERA
(
  COD_FORMULA   NUMBER(28) not null,
  COD_PRODUCTO  NUMBER(28) not null,
  CANTIDAD      NUMBER(28),
  ESTADO        VARCHAR2(1) default 'A' not null,
  FECHA         DATE,
  DESCRIPCION   VARCHAR2(200),
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
;
alter table FORMULA_CABECERA
  add constraint FORMULA_CABECERA_PK primary key (COD_FORMULA);
alter table FORMULA_CABECERA
  add constraint FORMULA_PRODUCTO foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table FORMULA_DETALLE
prompt ==============================
prompt
create table FORMULA_DETALLE
(
  COD_FORMULA_DETALLE NUMBER(28) not null,
  COD_FORMULA         NUMBER(28) not null,
  COD_PRODUCTO        NUMBER(28) not null,
  CANTIDAD            NUMBER(28),
  USUARIO_ALTA        VARCHAR2(15),
  USUARIO_MODIF       VARCHAR2(15),
  FECHA_ALTA          DATE,
  FECHA_MODIF         DATE
)
;
alter table FORMULA_DETALLE
  add constraint FORMULA_DETALLE_PK primary key (COD_FORMULA_DETALLE);
alter table FORMULA_DETALLE
  add constraint FORMULA_CABECERA_DETALLE foreign key (COD_FORMULA)
  references FORMULA_CABECERA (COD_FORMULA);
alter table FORMULA_DETALLE
  add constraint FORMULA_DETALLE_FK2 foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table FORMULA_SEMI_CABECERA
prompt ====================================
prompt
create table FORMULA_SEMI_CABECERA
(
  COD_FORMULA_SEMI_CABECERA NUMBER not null,
  COD_PRODUCTO              NUMBER not null,
  CANTIDAD                  NUMBER not null,
  FECHA                     DATE,
  ESTADO                    VARCHAR2(1),
  USUARIO_ALTA              VARCHAR2(20),
  FECHA_ALTA                DATE,
  DESCRIPCION               VARCHAR2(200) not null
)
;
alter table FORMULA_SEMI_CABECERA
  add constraint FORMULA_SEMI_CABECERA_PK primary key (COD_FORMULA_SEMI_CABECERA);
alter table FORMULA_SEMI_CABECERA
  add constraint FORMULA_SEMI_CAB_PRODUC_FK foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table FORMULA_SEMI_CABECERA
  add constraint FORMULA_SEMI_CANT_CK1
  check (CANTIDAD > 0);

prompt
prompt Creating table FORMULA_SEMI_DETALLE
prompt ===================================
prompt
create table FORMULA_SEMI_DETALLE
(
  COD_FORMULA_SEMI_DETALLE  NUMBER not null,
  COD_FORMULA_SEMI_CABECERA NUMBER not null,
  COD_PRODUCTO              NUMBER not null,
  CANTIDAD                  NUMBER not null
)
;
alter table FORMULA_SEMI_DETALLE
  add constraint FORMULA_SEMI_DETALLE_PK primary key (COD_FORMULA_SEMI_DETALLE);
alter table FORMULA_SEMI_DETALLE
  add constraint FORMULA_SEMI_CAB_DET_FK foreign key (COD_FORMULA_SEMI_CABECERA)
  references FORMULA_SEMI_CABECERA (COD_FORMULA_SEMI_CABECERA);
alter table FORMULA_SEMI_DETALLE
  add constraint FORMULA_SEMI_DET_PROD_FK foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table FORMULA_SEMI_DETALLE
  add constraint FORMULA_SEMI_DETALLE_CANT_CK1
  check (CANTIDAD > 0);

prompt
prompt Creating table HABILITACION_CAJA
prompt ================================
prompt
create table HABILITACION_CAJA
(
  COD_HABILITACION_CAJA NUMBER not null,
  COD_CAJA              NUMBER not null,
  FECHA_HAB_CAJA        DATE,
  HORA_HAB_CAJA         DATE,
  COD_EMPLEADO          NUMBER not null,
  COD_REPONSABLE        NUMBER not null,
  MONTO_INICIAL         NUMBER,
  TOTAL_MOVIMIENTO_CAJA NUMBER,
  TOTAL_GASTO           NUMBER,
  MONTO_SALDO           NUMBER,
  MONTO_RENDIDO         NUMBER,
  FECHA_CIERRE          DATE,
  HORA_CIERRE           DATE,
  ESTADO                VARCHAR2(1),
  OBSERVACION           VARCHAR2(200),
  USUARIO_ALTA          VARCHAR2(15),
  USUARIO_MODIF         VARCHAR2(15),
  FECHA_ALTA            DATE,
  FECHA_MODIF           DATE
)
;
alter table HABILITACION_CAJA
  add constraint HABILITACION_CAJA_PK primary key (COD_HABILITACION_CAJA);
alter table HABILITACION_CAJA
  add constraint HABILITACION_CAJA_CAJA_FK foreign key (COD_CAJA)
  references CAJA (COD_CAJA);
alter table HABILITACION_CAJA
  add constraint HABILITACION_CAJA_EMPLEADO_FK foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);
alter table HABILITACION_CAJA
  add constraint HABILITACION_CAJA_RESP_FK foreign key (COD_REPONSABLE)
  references EMPLEADO (COD_EMPLEADO);
alter table HABILITACION_CAJA
  add constraint HABILITACION_CAJA_CK5
  check (TOTAL_GASTO >= 0);
alter table HABILITACION_CAJA
  add constraint MONTO_INICIAL_CK1
  check (MONTO_INICIAL >= 0);
alter table HABILITACION_CAJA
  add constraint MONTO_RENDIDO_CK6
  check (MONTO_RENDIDO >=0);
alter table HABILITACION_CAJA
  add constraint MONTO_SALDO_CK4
  check (MONTO_SALDO >=0);
alter table HABILITACION_CAJA
  add constraint TOTAL_MOVIMIENTO_CAJA_CK2
  check (TOTAL_MOVIMIENTO_CAJA >= 0);
alter table HABILITACION_CAJA
  add constraint VALID_FECHAS_CK
  check (FECHA_CIERRE >= FECHA_HAB_CAJA);

prompt
prompt Creating table GASTO
prompt ====================
prompt
create table GASTO
(
  COD_GASTO             NUMBER(15) not null,
  COD_HABILITACION_CAJA NUMBER(15) not null,
  COD_EMPLEADO          NUMBER(15),
  DESCRIPCION_GASTO     VARCHAR2(100),
  FECHA_GASTO           DATE,
  HORA_GASTO            DATE,
  MONTO_GASTO           NUMBER(15),
  USUARIO_ALTA          VARCHAR2(15),
  USUARIO_MODIF         VARCHAR2(15),
  FECHA_ALTA            DATE,
  FECHA_MODIF           DATE
)
;
alter table GASTO
  add constraint GASTO_PK primary key (COD_GASTO);
alter table GASTO
  add constraint GASTO_EMPLEADO foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);
alter table GASTO
  add constraint GASTO_HAB_CAJA_FK foreign key (COD_HABILITACION_CAJA)
  references HABILITACION_CAJA (COD_HABILITACION_CAJA);
alter table GASTO
  add constraint GASTO_CK1
  check (MONTO_GASTO > 0);

prompt
prompt Creating table HISTORICO_COSTO
prompt ==============================
prompt
create table HISTORICO_COSTO
(
  COD_HISTORICO_COSTO NUMBER not null,
  FEC_HISTORICO_COSTO DATE not null,
  COSTO_HISTORICO     NUMBER not null,
  USUARIO_ALTA        VARCHAR2(15),
  USUARIO_MODIF       VARCHAR2(15),
  FECHA_ALTA          DATE,
  FECHA_MODIF         DATE,
  COD_PRODUCTO        NUMBER(15) not null
)
;
alter table HISTORICO_COSTO
  add constraint HISTORICO_COSTO_PK primary key (COD_HISTORICO_COSTO);
alter table HISTORICO_COSTO
  add constraint HISTORICO_COSTO_UK1 unique (FEC_HISTORICO_COSTO);
alter table HISTORICO_COSTO
  add constraint FK_HISTORICO_COSTO_PRODUCTO foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table HISTORICO_COSTO
  add constraint HISTORICO_COSTO_CK1
  check (Costo_Historico > 0);

prompt
prompt Creating table HISTORICO_PRECIO
prompt ===============================
prompt
create table HISTORICO_PRECIO
(
  COD_HISTORICO_PRECIO NUMBER not null,
  FEC_HISTORICO        DATE not null,
  PRECIO_HISTORICO     NUMBER,
  USUARIO_ALTA         VARCHAR2(15),
  USUARIO_MODIF        VARCHAR2(15),
  FECHA_ALTA           DATE,
  FECHA_MODIF          DATE,
  COD_PRODUCTO         NUMBER(15) not null
)
;
alter table HISTORICO_PRECIO
  add constraint HISTORICO_PRECIO_PK primary key (COD_HISTORICO_PRECIO);
alter table HISTORICO_PRECIO
  add constraint HISTORICO_PRECIO_UK1 unique (FEC_HISTORICO);
alter table HISTORICO_PRECIO
  add constraint FK_HISTORICO_PRECIO_PRODUCTO foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table HISTORICO_PRECIO
  add constraint HISTORICO_PRECIO_CK1
  check (Precio_Historico > 0);

prompt
prompt Creating table HTMLDB_PLAN_TABLE
prompt ================================
prompt
create table HTMLDB_PLAN_TABLE
(
  STATEMENT_ID      VARCHAR2(30),
  PLAN_ID           NUMBER,
  TIMESTAMP         DATE,
  REMARKS           VARCHAR2(4000),
  OPERATION         VARCHAR2(30),
  OPTIONS           VARCHAR2(255),
  OBJECT_NODE       VARCHAR2(128),
  OBJECT_OWNER      VARCHAR2(30),
  OBJECT_NAME       VARCHAR2(30),
  OBJECT_ALIAS      VARCHAR2(65),
  OBJECT_INSTANCE   INTEGER,
  OBJECT_TYPE       VARCHAR2(30),
  OPTIMIZER         VARCHAR2(255),
  SEARCH_COLUMNS    NUMBER,
  ID                INTEGER,
  PARENT_ID         INTEGER,
  DEPTH             INTEGER,
  POSITION          INTEGER,
  COST              INTEGER,
  CARDINALITY       INTEGER,
  BYTES             INTEGER,
  OTHER_TAG         VARCHAR2(255),
  PARTITION_START   VARCHAR2(255),
  PARTITION_STOP    VARCHAR2(255),
  PARTITION_ID      INTEGER,
  OTHER             LONG,
  DISTRIBUTION      VARCHAR2(30),
  CPU_COST          INTEGER,
  IO_COST           INTEGER,
  TEMP_SPACE        INTEGER,
  ACCESS_PREDICATES VARCHAR2(4000),
  FILTER_PREDICATES VARCHAR2(4000),
  PROJECTION        VARCHAR2(4000),
  TIME              INTEGER,
  QBLOCK_NAME       VARCHAR2(30),
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE
)
;

prompt
prompt Creating table INVENTARIO_CABECERA
prompt ==================================
prompt
create table INVENTARIO_CABECERA
(
  COD_INVENTARIO NUMBER not null,
  FEC_INVENTARIO DATE not null,
  COD_DEPOSITO   NUMBER not null,
  DESCRIPCION    VARCHAR2(300),
  ESTADO         VARCHAR2(1),
  USUARIO_ALTA   VARCHAR2(15),
  USUARIO_MODIF  VARCHAR2(15),
  FECHA_ALTA     DATE,
  FECHA_MODIF    DATE
)
;
alter table INVENTARIO_CABECERA
  add constraint INVENTARIO_CABECERA_PK primary key (COD_INVENTARIO);
alter table INVENTARIO_CABECERA
  add constraint INVENTARIO_CABECERA_FK foreign key (COD_DEPOSITO)
  references DEPOSITO (COD_DEPOSITO);

prompt
prompt Creating table INVENTARIO_DETALLE
prompt =================================
prompt
create table INVENTARIO_DETALLE
(
  COD_INVENTARIO_DETALLE NUMBER not null,
  COD_INVENTARIO         NUMBER not null,
  COD_PRODUCTO           NUMBER not null,
  CANTIDADCONTADA        NUMBER,
  CANTIDADSISTEMA        NUMBER,
  OBSERVACION            VARCHAR2(300),
  ESTADO                 VARCHAR2(1),
  USUARIO_ALTA           VARCHAR2(15),
  USUARIO_MODIF          VARCHAR2(15),
  FECHA_ALTA             DATE,
  FECHA_MODIF            DATE
)
;
alter table INVENTARIO_DETALLE
  add constraint INVENTARIO_DETALLE_PK primary key (COD_INVENTARIO_DETALLE);
alter table INVENTARIO_DETALLE
  add constraint INVENTARIO_PRODUCTO_UK unique (COD_PRODUCTO);
alter table INVENTARIO_DETALLE
  add constraint INVENTARIO_ CAB_DETALLE_FK2 foreign key (COD_INVENTARIO)
  references INVENTARIO_CABECERA (COD_INVENTARIO);
alter table INVENTARIO_DETALLE
  add constraint INVENTARIO_DETALLE_PRODUCTO foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table INVENTARIO_DETALLE
  add constraint INVENTARIO_DETALLE_CK1
  check (CANTIDADCONTADA > -1);
alter table INVENTARIO_DETALLE
  add constraint INVENTARIO_DETALLE_CK2
  check (CANTIDADSISTEMA > -1);

prompt
prompt Creating table RECIBO_CABECERA
prompt ==============================
prompt
create table RECIBO_CABECERA
(
  COD_RECIBO         NUMBER not null,
  NUMERO_RECIBO      NUMBER not null,
  COD_CLIENTE        NUMBER not null,
  MONTO_TOTAL        NUMBER,
  MONTO_NOTA_CREDITO NUMBER,
  ESTADO             VARCHAR2(1),
  SERIE_RECIBO       VARCHAR2(1),
  USUARIO_ALTA       VARCHAR2(15),
  USUARIO_MODIF      VARCHAR2(15),
  FECHA_ALTA         DATE,
  FECHA_MODIF        DATE
)
;
alter table RECIBO_CABECERA
  add constraint RECIBO_CABECERA_PK primary key (COD_RECIBO);
alter table RECIBO_CABECERA
  add constraint NUM_SERIE_UK unique (NUMERO_RECIBO, SERIE_RECIBO);
alter table RECIBO_CABECERA
  add constraint RECIBO_CLIENTE_FK foreign key (COD_CLIENTE)
  references CLIENTE (COD_CLIENTE);
alter table RECIBO_CABECERA
  add constraint VALID_MONTO_RECIBO
  check (MONTO_TOTAL > 0);

prompt
prompt Creating table MOVIMIENTO_CAJA_CABECERA
prompt =======================================
prompt
create table MOVIMIENTO_CAJA_CABECERA
(
  COD_MOVIMIENTO_CAJA   NUMBER(15) not null,
  COD_HABILITACION_CAJA NUMBER(15) not null,
  COD_RECIBO            NUMBER(15) not null,
  COD_EMPLEADO          NUMBER(15) not null,
  FECHA_MOVIMIENTO      DATE,
  HORA_MOVIMIENTO       DATE,
  ESTADO_MOVIMIENTO     VARCHAR2(1),
  OBSERVACOIN           VARCHAR2(200),
  USUARIO_ALTA          VARCHAR2(15),
  USUARIO_MODIF         VARCHAR2(15),
  FECHA_ALTA            DATE,
  FECHA_MODIF           DATE
)
;
alter table MOVIMIENTO_CAJA_CABECERA
  add constraint MOVIMIENTO_CAJA_CABECERA_PK primary key (COD_MOVIMIENTO_CAJA);
alter table MOVIMIENTO_CAJA_CABECERA
  add constraint MOVIMIENTO_CAJA_EMPLEADO_FK3 foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);
alter table MOVIMIENTO_CAJA_CABECERA
  add constraint MOVIMIENTO_CAJA_HAB_CAJA_FK foreign key (COD_HABILITACION_CAJA)
  references HABILITACION_CAJA (COD_HABILITACION_CAJA);
alter table MOVIMIENTO_CAJA_CABECERA
  add constraint MOVIMIENTO_CAJA_RECIBO_FK2 foreign key (COD_RECIBO)
  references RECIBO_CABECERA (COD_RECIBO);

prompt
prompt Creating table MOVIMIENTO_CAJA_DETALLE
prompt ======================================
prompt
create table MOVIMIENTO_CAJA_DETALLE
(
  COD_MOVIMIENTO_CAJA_DET NUMBER not null,
  COD_MOVIMIENTO_CAJA     NUMBER,
  COD_FORMA_PAGO          NUMBER,
  SERIE_CHEQUE            VARCHAR2(5),
  NUMERO_CHEQUE           VARCHAR2(15),
  MONTO                   NUMBER,
  USUARIO_ALTA            VARCHAR2(15),
  USUARIO_MODIF           VARCHAR2(15),
  FECHA_ALTA              DATE,
  FECHA_MODIF             DATE
)
;
alter table MOVIMIENTO_CAJA_DETALLE
  add constraint MOVIMIENTO_CAJA_DETALLE_PK primary key (COD_MOVIMIENTO_CAJA_DET);
alter table MOVIMIENTO_CAJA_DETALLE
  add constraint MOV_CAJA_CAB_DET_FK foreign key (COD_MOVIMIENTO_CAJA)
  references MOVIMIENTO_CAJA_CABECERA (COD_MOVIMIENTO_CAJA);
alter table MOVIMIENTO_CAJA_DETALLE
  add constraint MOV_CAJA_FORMA_PAGO_FK foreign key (COD_FORMA_PAGO)
  references FORMA_PAGO (COD_FORMA_PAGO);
alter table MOVIMIENTO_CAJA_DETALLE
  add constraint VALID_MOV_CAJA_MONTO_CK
  check (MONTO >0);

prompt
prompt Creating table NOTA_CREDITO_CLI_CABECERA
prompt ========================================
prompt
create table NOTA_CREDITO_CLI_CABECERA
(
  COD_NOTA_CREDITO_CLIENTE NUMBER not null,
  NUM_NOTA_CREDTO_CLIENTE  NUMBER not null,
  COD_EMPLEADO             NUMBER not null,
  COD_CLIENTE              NUMBER not null,
  COD_FACTURA              NUMBER not null,
  TOTAL_NOTA_CREDITO       NUMBER,
  FECHA_NOTA_CREDITO       DATE not null,
  TOTAL_IVA                NUMBER,
  USUARIO_ALTA             VARCHAR2(15),
  USUARIO_MODIF            VARCHAR2(15),
  FECHA_ALTA               DATE,
  FECHA_MODIF              DATE
)
;
alter table NOTA_CREDITO_CLI_CABECERA
  add constraint NOTA_CREDITO_CLI_CABECERA_PK primary key (COD_NOTA_CREDITO_CLIENTE);
alter table NOTA_CREDITO_CLI_CABECERA
  add constraint NOTA_CREDITO_CLI_CLIENTE foreign key (COD_CLIENTE)
  references CLIENTE (COD_CLIENTE);
alter table NOTA_CREDITO_CLI_CABECERA
  add constraint NOTA_CREDITO_CLI_EMPLEADO foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);
alter table NOTA_CREDITO_CLI_CABECERA
  add constraint NOTA_CREDITO_CLI_FACTURA foreign key (COD_FACTURA)
  references FACTURA_CABECERA (COD_FACTURA);

prompt
prompt Creating table NOTA_CREDITO_CLI_DETALLE
prompt =======================================
prompt
create table NOTA_CREDITO_CLI_DETALLE
(
  COD_NOTA_CREDITO_CLI_DET NUMBER not null,
  COD_NOTA_CREDITO_CLIENTE NUMBER not null,
  COD_PRODUCTO             NUMBER not null,
  PRECIO_UNITARIO          NUMBER not null,
  CANTIDAD                 NUMBER not null,
  MONTO                    NUMBER not null,
  PORCENTAJE_IVA           NUMBER not null,
  TOTAL_IVA                NUMBER not null,
  SUB_TOTAL                NUMBER not null,
  DESCRIPCION              VARCHAR2(100) not null,
  USUARIO_ALTA             VARCHAR2(15),
  USUARIO_MODIF            VARCHAR2(15),
  FECHA_ALTA               DATE,
  FECHA_MODIF              DATE
)
;
alter table NOTA_CREDITO_CLI_DETALLE
  add constraint NOTA_CREDITO_CLI_DETALLE_PK primary key (COD_NOTA_CREDITO_CLI_DET);
alter table NOTA_CREDITO_CLI_DETALLE
  add constraint NOTA_CREDITO_CLI_DETALLE_FK foreign key (COD_NOTA_CREDITO_CLIENTE)
  references NOTA_CREDITO_CLI_CABECERA (COD_NOTA_CREDITO_CLIENTE);
alter table NOTA_CREDITO_CLI_DETALLE
  add constraint NOTA_CREDITO_CLI_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table NOTA_CREDITO_CLI_DETALLE
  add constraint NOTA_CREDITO_CANTIDAD
  check (CANTIDAD > 0);

prompt
prompt Creating table NOTA_CREDITO_PROV_CAB
prompt ====================================
prompt
create table NOTA_CREDITO_PROV_CAB
(
  COD_NOT_CRE_CAB  NUMBER(15) not null,
  FECHA            DATE not null,
  COD_PROVEEDOR    NUMBER(15) not null,
  NRO_NOTA_CREDITO VARCHAR2(20) not null,
  COD_FACTURA_CAB  NUMBER(15) not null,
  ESTADO           VARCHAR2(1) not null,
  TOTAL            NUMBER(15) not null,
  IVA              NUMBER(15) not null,
  SALDO_FAC        NUMBER(15) not null,
  USUARIO_ALTA     VARCHAR2(15),
  USUARIO_MODIF    VARCHAR2(15),
  FECHA_ALTA       DATE,
  FECHA_MODIF      DATE
)
;
alter table NOTA_CREDITO_PROV_CAB
  add constraint NOTA_CREDITO_PROV_CAB_PK primary key (COD_NOT_CRE_CAB);
alter table NOTA_CREDITO_PROV_CAB
  add constraint FK_NOTA_CREDITO_PROV_CAB_FAC foreign key (COD_FACTURA_CAB)
  references FACTURA_COMPRA_CAB (COD_FAC_COM_CAB);
alter table NOTA_CREDITO_PROV_CAB
  add constraint FK_NOT_CRE_PROV_CAB_PROV foreign key (COD_PROVEEDOR)
  references PROVEEDOR (COD_PROVEEDOR);

prompt
prompt Creating table NOTA_CREDITO_PROV_DET
prompt ====================================
prompt
create table NOTA_CREDITO_PROV_DET
(
  COD_NOT_CRE_DET NUMBER(15) not null,
  COD_NOT_CRE_CAB NUMBER(15) not null,
  COD_PRODUCTO    NUMBER(15) not null,
  PRECIO_UNI      NUMBER(10) not null,
  CANTIDAD        NUMBER(10) not null,
  PORC_IVA        NUMBER(3) not null,
  MONTO_IVA       NUMBER(10) not null,
  SUB_TOTAL       NUMBER(10) not null,
  TOTAL           NUMBER(15) not null,
  USUARIO_ALTA    VARCHAR2(15),
  USUARIO_MODIF   VARCHAR2(15),
  FECHA_ALTA      DATE,
  FECHA_MODIF     DATE
)
;
alter table NOTA_CREDITO_PROV_DET
  add constraint NOTA_CREDITO_PROV_DET_PK primary key (COD_NOT_CRE_DET);
alter table NOTA_CREDITO_PROV_DET
  add constraint FK_NOTA_CREDITO_PROV_DETCAB foreign key (COD_NOT_CRE_CAB)
  references NOTA_CREDITO_PROV_CAB (COD_NOT_CRE_CAB);
alter table NOTA_CREDITO_PROV_DET
  add constraint NOTA_CRED_PROV_DET_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table ORDEN_TRABAJO_DETALLE
prompt ====================================
prompt
create table ORDEN_TRABAJO_DETALLE
(
  COD_ORDEN_TRABAJO_DET NUMBER(15) not null,
  COD_ORDEN_TRABAJO     NUMBER(15) not null,
  COD_EMPLEADO          NUMBER(15) not null,
  CANTIDAD              NUMBER(15) not null,
  CANTIDAD_REAL         NUMBER(15),
  COSTO_ESTIMADO        NUMBER(15),
  COSTO_REAL            NUMBER(15),
  OBSERVACION           VARCHAR2(200),
  ESTADO                VARCHAR2(1),
  COD_PRODUCTO          NUMBER,
  USUARIO_ALTA          VARCHAR2(15),
  USUARIO_MODIF         VARCHAR2(15),
  FECHA_ALTA            DATE,
  FECHA_MODIF           DATE
)
;
alter table ORDEN_TRABAJO_DETALLE
  add constraint ORDEN_TRABAJO_DETALLE_PK primary key (COD_ORDEN_TRABAJO_DET);
alter table ORDEN_TRABAJO_DETALLE
  add constraint OT_CAB_DETALLE_FK foreign key (COD_ORDEN_TRABAJO)
  references ORDEN_TRABAJO (COD_ORDEN_TRABJO);
alter table ORDEN_TRABAJO_DETALLE
  add constraint OT_DET_EMPLEADO_FK2 foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);
alter table ORDEN_TRABAJO_DETALLE
  add constraint OT_DET_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table ORDEN_TRABAJO_DETALLE
  add constraint ORDEN_TRABAJO_CANT_CK1
  check (CANTIDAD > 0);

prompt
prompt Creating table PEDIDO_DETALLE
prompt =============================
prompt
create table PEDIDO_DETALLE
(
  COD_PEDIDO_DETALLE NUMBER not null,
  COD_PEDIDO         NUMBER not null,
  COD_PRODUCTO       NUMBER not null,
  CANTIDAD_PEDIDA    NUMBER,
  CANTIDAD_ENTREGADA NUMBER,
  PRECIO_UNITARIO    NUMBER,
  TOTAL              NUMBER,
  USUARIO_ALTA       VARCHAR2(15),
  USUARIO_MODIF      VARCHAR2(15),
  FECHA_ALTA         DATE,
  FECHA_MODIF        DATE,
  PORC_IVA           NUMBER(5,2),
  MONTO_IVA          NUMBER(10)
)
;
alter table PEDIDO_DETALLE
  add constraint PEDIDO_DETALLE_PK primary key (COD_PEDIDO_DETALLE);
alter table PEDIDO_DETALLE
  add constraint PEDIDO_DETALLE_FK foreign key (COD_PEDIDO)
  references PEDIDO_CABECERA (COD_PEDIDO);
alter table PEDIDO_DETALLE
  add constraint PEDIDO_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table PEDIDO_DETALLE
  add constraint PEDIDO_CANTIDAD_PEDIDA
  check (CANTIDAD_PEDIDA > 0);

prompt
prompt Creating table PERDIDA
prompt ======================
prompt
create table PERDIDA
(
  COD_PERDIDA      NUMBER(15) not null,
  COD_EMPLEADO     NUMBER(15) not null,
  FECHA_PERDIDA    DATE not null,
  HORA_PERDIDA     DATE not null,
  COD_PRODUCTO     NUMBER(15) not null,
  CANTIDAD_PERDIDA NUMBER(15) not null,
  OBSERVACION      VARCHAR2(200),
  USUARIO_ALTA     VARCHAR2(15),
  USUARIO_MODIF    VARCHAR2(15),
  FECHA_ALTA       DATE,
  FECHA_MODIF      DATE
)
;
alter table PERDIDA
  add constraint PERDIDA_PK primary key (COD_PERDIDA);
alter table PERDIDA
  add constraint PERDIDA_EMPLEADO_FK foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);
alter table PERDIDA
  add constraint PERDIDA_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);
alter table PERDIDA
  add constraint PERDIDA_CANT_CK1
  check (CANTIDAD_PERDIDA > 0);

prompt
prompt Creating table TAREA
prompt ====================
prompt
create table TAREA
(
  COD_TAREA     NUMBER(15) not null,
  NOMBRE_TAREA  VARCHAR2(40) not null,
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
;
alter table TAREA
  add constraint TAREA_PK primary key (COD_TAREA);
alter table TAREA
  add constraint NOMBRE_TAREA_UK unique (NOMBRE_TAREA);

prompt
prompt Creating table TAREA_ASIGNADA
prompt =============================
prompt
create table TAREA_ASIGNADA
(
  COD_TAREA_ASIGNADA   NUMBER(15) not null,
  COD_EMPLEADO         NUMBER(15),
  COD_TAREA            NUMBER(15) not null,
  ORDEN_TAREA          NUMBER(15),
  CANTIDAD             NUMBER(15) not null,
  CANTIDAD_REAL        NUMBER(15),
  OBSERVACION          VARCHAR2(200),
  COD_DET_ORDEN_TRABAJ NUMBER(15),
  USUARIO_ALTA         VARCHAR2(15),
  USUARIO_MODIF        VARCHAR2(15),
  FECHA_ALTA           DATE,
  FECHA_MODIF          DATE
)
;
alter table TAREA_ASIGNADA
  add constraint TAREA_ASIGNADA_PK primary key (COD_TAREA_ASIGNADA);
alter table TAREA_ASIGNADA
  add constraint FK_TAREA_ASIGNADA foreign key (COD_TAREA)
  references TAREA (COD_TAREA);
alter table TAREA_ASIGNADA
  add constraint FK_TAREA_ASIGNADA_DET_OT foreign key (COD_DET_ORDEN_TRABAJ)
  references ORDEN_TRABAJO_DETALLE (COD_ORDEN_TRABAJO_DET);
alter table TAREA_ASIGNADA
  add constraint FK_TAREA_ASIGNADA_EMP foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);
alter table TAREA_ASIGNADA
  add constraint CK_TAREA_ASIGNADA_CANT
  check (CANTIDAD > 0);

prompt
prompt Creating table PRODUCCION_DIARIA
prompt ================================
prompt
create table PRODUCCION_DIARIA
(
  COD_PRODUCCION_DIARIA NUMBER(15) not null,
  COD_TAREA_ASIGNADA    NUMBER(15) not null,
  COD_EMPLEADO          NUMBER(15) not null,
  CANTIDAD              NUMBER(15) not null,
  FECHA                 DATE not null,
  TIEMPO_INVERTIDO      NUMBER(15) not null,
  USUARIO_ALTA          VARCHAR2(15),
  USUARIO_MODIF         VARCHAR2(15),
  FECHA_ALTA            DATE,
  FECHA_MODIF           DATE
)
;
alter table PRODUCCION_DIARIA
  add constraint PRODUCCION_DIARIA_PK primary key (COD_PRODUCCION_DIARIA);
alter table PRODUCCION_DIARIA
  add constraint FK_PRODUCCION_DIARIA_EMPLEADO foreign key (COD_EMPLEADO)
  references EMPLEADO (COD_EMPLEADO);
alter table PRODUCCION_DIARIA
  add constraint FK_PRODUCCION_DIARIA_TAREA foreign key (COD_TAREA_ASIGNADA)
  references TAREA_ASIGNADA (COD_TAREA_ASIGNADA);
alter table PRODUCCION_DIARIA
  add constraint PRODUCCION_DIARIA_CANTIDAD
  check (CANTIDAD > 0);

prompt
prompt Creating table RECIBO_DETALLE
prompt =============================
prompt
create table RECIBO_DETALLE
(
  COD_RECIBO_DET           NUMBER(15) not null,
  COD_RECIBO               NUMBER(15) not null,
  COD_FACTURA              NUMBER(15) not null,
  MONTO_EFECTIVO           NUMBER(15),
  COD_NOTA_CREDITO_CLIENTE NUMBER(15),
  MONTO_NOTA_CREDITO       NUMBER(15),
  MONTO_TOTAL              NUMBER(15),
  ESTADO_DETALLE_RECIBO    VARCHAR2(1),
  USUARIO_ALTA             VARCHAR2(15),
  USUARIO_MODIF            VARCHAR2(15),
  FECHA_ALTA               DATE,
  FECHA_MODIF              DATE
)
;
alter table RECIBO_DETALLE
  add constraint RECIBO_DETALLE_PK primary key (COD_RECIBO_DET);
alter table RECIBO_DETALLE
  add constraint RECIBO_DETALLE_CAB_FK foreign key (COD_RECIBO)
  references RECIBO_CABECERA (COD_RECIBO);
alter table RECIBO_DETALLE
  add constraint RECIBO_DETALLE_FACTURA_FK foreign key (COD_FACTURA)
  references FACTURA_CABECERA (COD_FACTURA);
alter table RECIBO_DETALLE
  add constraint RECIBO_DETALLE_NOTA_CRED_FK foreign key (COD_NOTA_CREDITO_CLIENTE)
  references NOTA_CREDITO_CLI_CABECERA (COD_NOTA_CREDITO_CLIENTE);
alter table RECIBO_DETALLE
  add constraint MONTO_EFECTIVO_CK1
  check (MONTO_EFECTIVO >=0);
alter table RECIBO_DETALLE
  add constraint MONTO_NOTA_CREDITO_CK2
  check (MONTO_NOTA_CREDITO >=0);
alter table RECIBO_DETALLE
  add constraint MONTO_TOTAL_CK3
  check (MONTO_TOTAL >=0);

prompt
prompt Creating table RECURSO_ASIGNADO
prompt ===============================
prompt
create table RECURSO_ASIGNADO
(
  COD_RECURSO        NUMBER(15) not null,
  COD_ORDEN_TRAB_DET NUMBER(15) not null,
  COD_PRODUCTO       NUMBER(15) not null,
  CANTIDAD           NUMBER(10) not null,
  CANTIDAD_REAL      NUMBER(10) not null,
  FECHA              DATE not null,
  USUARIO_ALTA       VARCHAR2(15),
  USUARIO_MODIF      VARCHAR2(15),
  FECHA_ALTA         DATE,
  FECHA_MODIF        DATE
)
;
alter table RECURSO_ASIGNADO
  add constraint RECURSO_ASIGNADO_PK primary key (COD_RECURSO);
alter table RECURSO_ASIGNADO
  add constraint FK_RECURSO_ASIGNADO_OT_DET foreign key (COD_ORDEN_TRAB_DET)
  references ORDEN_TRABAJO_DETALLE (COD_ORDEN_TRABAJO_DET);
alter table RECURSO_ASIGNADO
  add constraint FK_RECURSO_ASIGNADO_PRODUCTO foreign key (COD_PRODUCTO)
  references PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table SALDO_CLIENTE
prompt ============================
prompt
create table SALDO_CLIENTE
(
  COD_SALDO_CLIENTE NUMBER not null,
  COD_CLIENTE       NUMBER not null,
  NUMERO_DOCUMENTO  VARCHAR2(30) not null,
  TIPO_DOCUMENTO    VARCHAR2(30) not null,
  SALDO_CLIENTE     NUMBER,
  TOTAL             NUMBER,
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE
)
;
alter table SALDO_CLIENTE
  add constraint SALDO_CLIENTE_PK primary key (COD_SALDO_CLIENTE);
alter table SALDO_CLIENTE
  add constraint SALDO_CLIENTE_DOCUMENTO_UK unique (NUMERO_DOCUMENTO, TIPO_DOCUMENTO);
alter table SALDO_CLIENTE
  add constraint SALDO_CLIENTE_FK foreign key (COD_CLIENTE)
  references CLIENTE (COD_CLIENTE);

prompt
prompt Creating table TAREA_FORMULA
prompt ============================
prompt
create table TAREA_FORMULA
(
  COD_TAREA_FORMULA   NUMBER(15) not null,
  COD_FORMULA_DETALLE NUMBER(15) not null,
  COD_TAREA           NUMBER(15) not null,
  CANTIDAD_TAREA      NUMBER(15) not null,
  ORDEN_TAREA         NUMBER(15) not null,
  USUARIO_ALTA        VARCHAR2(15),
  USUARIO_MODIF       VARCHAR2(15),
  FECHA_ALTA          DATE,
  FECHA_MODIF         DATE
)
;
alter table TAREA_FORMULA
  add constraint TAREA_FORMULA_PK primary key (COD_TAREA_FORMULA);
alter table TAREA_FORMULA
  add constraint ORDEN_TAREA_UK1 unique (COD_FORMULA_DETALLE, ORDEN_TAREA);
alter table TAREA_FORMULA
  add constraint TAREA_FORMULA_DET_FK foreign key (COD_FORMULA_DETALLE)
  references FORMULA_DETALLE (COD_FORMULA_DETALLE);
alter table TAREA_FORMULA
  add constraint TAREA_FORMULA_FK foreign key (COD_TAREA)
  references TAREA (COD_TAREA);
alter table TAREA_FORMULA
  add constraint VALID_CANT_TAREA_CHK
  check (CANTIDAD_TAREA > 0);

prompt
prompt Creating sequence PRODUCCION_DIARIA_SEQ
prompt =======================================
prompt
create sequence PRODUCCION_DIARIA_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BANCO
prompt ===========================
prompt
create sequence SEQ_BANCO
minvalue 1
maxvalue 999999999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence seq_existencia
prompt ================================
prompt
create sequence seq_existencia
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_FORMA_PAGO
prompt ================================
prompt
create sequence SEQ_FORMA_PAGO
minvalue 1
maxvalue 999999999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_GASTO
prompt ===========================
prompt
create sequence SEQ_GASTO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_ORDEN_TRABAJO
prompt ===================================
prompt
create sequence SEQ_ORDEN_TRABAJO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_PRODUCCION_DIARIA
prompt =======================================
prompt
create sequence SEQ_PRODUCCION_DIARIA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CABECERA_ENTRADA_SALIDA
prompt ============================================
prompt
create sequence SQ_CABECERA_ENTRADA_SALIDA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SQ_CABECERA_FACTURA
prompt =====================================
prompt
create sequence SQ_CABECERA_FACTURA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1020
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CABECERA_FORMULA
prompt =====================================
prompt
create sequence SQ_CABECERA_FORMULA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence sq_cabecera_inventario
prompt ========================================
prompt
create sequence sq_cabecera_inventario
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CABECERA_MOVIMIENTO_CAJA
prompt =============================================
prompt
create sequence SQ_CABECERA_MOVIMIENTO_CAJA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SQ_CABECERA_ORDEN_TRABAJO
prompt ===========================================
prompt
create sequence SQ_CABECERA_ORDEN_TRABAJO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CABECERA_PEDIDO
prompt ====================================
prompt
create sequence SQ_CABECERA_PEDIDO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1060
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CABECERA_RECIBO
prompt ====================================
prompt
create sequence SQ_CABECERA_RECIBO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence sq_CabEC_HAB_caja
prompt ===================================
prompt
create sequence sq_CabEC_HAB_caja
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence sq_Cab_HAB_caja
prompt =================================
prompt
create sequence sq_Cab_HAB_caja
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CAJA
prompt =========================
prompt
create sequence SQ_CAJA
minvalue 1
maxvalue 999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CARGO
prompt ==========================
prompt
create sequence SQ_CARGO
minvalue 100
maxvalue 999999999999999999999999999
start with 120
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CLIENTE
prompt ============================
prompt
create sequence SQ_CLIENTE
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CLIENTE_SALDO
prompt ==================================
prompt
create sequence SQ_CLIENTE_SALDO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SQ_COMISION
prompt =============================
prompt
create sequence SQ_COMISION
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_COMISION_MENS_CAB
prompt ======================================
prompt
create sequence SQ_COMISION_MENS_CAB
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_COMISION_MENS_DET
prompt ======================================
prompt
create sequence SQ_COMISION_MENS_DET
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_COSTOS_FIJOS
prompt =================================
prompt
create sequence SQ_COSTOS_FIJOS
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_DEPOSITO
prompt =============================
prompt
create sequence SQ_DEPOSITO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SQ_DETALLE_ENTRADA_SALIDA
prompt ===========================================
prompt
create sequence SQ_DETALLE_ENTRADA_SALIDA
minvalue 100
maxvalue 999999999999999999999999999
start with 100
increment by 1
nocache;

prompt
prompt Creating sequence SQ_DETALLE_FACTURA
prompt ====================================
prompt
create sequence SQ_DETALLE_FACTURA
minvalue 1
maxvalue 999999999999999999999999999
start with 11
increment by 1
cache 10;

prompt
prompt Creating sequence SQ_DETALLE_FORMULA
prompt ====================================
prompt
create sequence SQ_DETALLE_FORMULA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SQ_DETALLE_INVENTARIO
prompt =======================================
prompt
create sequence SQ_DETALLE_INVENTARIO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_DETALLE_MOVIMIENTO_CAJA
prompt ============================================
prompt
create sequence SQ_DETALLE_MOVIMIENTO_CAJA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SQ_DETALLE_NOTA_CRED_CLIENTE
prompt ==============================================
prompt
create sequence SQ_DETALLE_NOTA_CRED_CLIENTE
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 10;

prompt
prompt Creating sequence SQ_DETALLE_PEDIDO
prompt ===================================
prompt
create sequence SQ_DETALLE_PEDIDO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1040
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_DETALLE_RECIBO
prompt ===================================
prompt
create sequence SQ_DETALLE_RECIBO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SQ_EMPLEADO
prompt =============================
prompt
create sequence SQ_EMPLEADO
minvalue 100
maxvalue 999999999999999999999999999
start with 100
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_FACTURA_COMPRA_CAB
prompt =======================================
prompt
create sequence SQ_FACTURA_COMPRA_CAB
minvalue 1
maxvalue 999999999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_FACTURA_COMPRA_DET
prompt =======================================
prompt
create sequence SQ_FACTURA_COMPRA_DET
minvalue 1
maxvalue 999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_FORMULA_SEMI_CABECERA
prompt ==========================================
prompt
create sequence SQ_FORMULA_SEMI_CABECERA
minvalue 1
maxvalue 999999999999999999999999999
start with 1012
increment by 1
nocache;

prompt
prompt Creating sequence SQ_FORMULA_SEMI_DETALLE
prompt =========================================
prompt
create sequence SQ_FORMULA_SEMI_DETALLE
minvalue 1
maxvalue 999999999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_HISTORICO_COSTO
prompt ====================================
prompt
create sequence SQ_HISTORICO_COSTO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SQ_HISTORICO_PRECIO
prompt =====================================
prompt
create sequence SQ_HISTORICO_PRECIO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SQ_MARCA
prompt ==========================
prompt
create sequence SQ_MARCA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1009
increment by 1
nocache;

prompt
prompt Creating sequence SQ_NOTA_CREDITO_CLIENTE
prompt =========================================
prompt
create sequence SQ_NOTA_CREDITO_CLIENTE
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_NOTA_CREDITO_PROV_CAB
prompt ==========================================
prompt
create sequence SQ_NOTA_CREDITO_PROV_CAB
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_NOTA_CREDITO_PROV_DET
prompt ==========================================
prompt
create sequence SQ_NOTA_CREDITO_PROV_DET
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_OT_DETALLE
prompt ===============================
prompt
create sequence SQ_OT_DETALLE
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence Sq_OT_DETALLE
prompt ===============================
prompt
create sequence Sq_OT_DETALLE
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence sq_PERDIDA
prompt ============================
prompt
create sequence sq_PERDIDA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_PRESENTACION
prompt =================================
prompt
create sequence SQ_PRESENTACION
minvalue 1000
maxvalue 999999999999999999999999999
start with 1001
increment by 1
nocache;

prompt
prompt Creating sequence SQ_PRODUCTO
prompt =============================
prompt
create sequence SQ_PRODUCTO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1021
increment by 1
nocache;

prompt
prompt Creating sequence SQ_PROVEEDOR
prompt ==============================
prompt
create sequence SQ_PROVEEDOR
minvalue 100
maxvalue 999999999999999999999999999
start with 100
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_RECURSO_ASIGNADO
prompt =====================================
prompt
create sequence SQ_RECURSO_ASIGNADO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence sq_saldo_cliente
prompt ==================================
prompt
create sequence sq_saldo_cliente
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_SECCION
prompt ============================
prompt
create sequence SQ_SECCION
minvalue 100
maxvalue 999999999999999999999999999
start with 120
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_SOLICITUD
prompt ==============================
prompt
create sequence SQ_SOLICITUD
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_TAREA
prompt ==========================
prompt
create sequence SQ_TAREA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SQ_TAREA_ASIGNADA
prompt ===================================
prompt
create sequence SQ_TAREA_ASIGNADA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SQ_TAREA_FORMULA
prompt ==================================
prompt
create sequence SQ_TAREA_FORMULA
minvalue 100
maxvalue 999999999999999999999999999
start with 100
increment by 1
nocache;

prompt
prompt Creating sequence SQ_TIPO_COMPROBANTE
prompt =====================================
prompt
create sequence SQ_TIPO_COMPROBANTE
minvalue 50
maxvalue 99999999999999999999
start with 50
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_TIPO_PRODUCTO
prompt ==================================
prompt
create sequence SQ_TIPO_PRODUCTO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1001
increment by 1
nocache;

prompt
prompt Creating sequence SQ_UNIDAD_MEDIDA
prompt ==================================
prompt
create sequence SQ_UNIDAD_MEDIDA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1001
increment by 1
nocache;


spool off
