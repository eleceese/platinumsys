----------------------------------------------
-- Export file for user PLATINUM            --
-- Created by Martin on 13/07/2010, 0:41:00 --
----------------------------------------------

spool Platinum_dbMARTIN.log

prompt
prompt Creating table BANCO
prompt ====================
prompt

create table PLATINUM.BANCO
(
  COD_BANCO     NUMBER(15) not null,
  NOMBRE_BANCO  VARCHAR2(40) not null,
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.BANCO
  add constraint BANCO_PK primary key (COD_BANCO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CAB
prompt ==================
prompt
create table PLATINUM.CAB
(
  ID  NUMBER(10) not null,
  DSC VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.CAB
  add constraint PK_CAB primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CAJA
prompt ===================
prompt
create table PLATINUM.CAJA
(
  COD_CAJA      NUMBER(15) not null,
  NOMBRE_CAJA   VARCHAR2(10) not null,
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.CAJA
  add constraint CAJA_PK primary key (COD_CAJA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.CAJA
  add constraint NOMBRE_CAJA_UK1 unique (NOMBRE_CAJA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CARGO
prompt ====================
prompt
create table PLATINUM.CARGO
(
  COD_CARGO     NUMBER not null,
  NOMBRE_CARGO  VARCHAR2(300) not null,
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.CARGO
  add constraint CARGO_PK primary key (COD_CARGO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.CARGO
  add constraint CARGO_UK1 unique (NOMBRE_CARGO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CIUDAD
prompt =====================
prompt
create table PLATINUM.CIUDAD
(
  CODCIUDAD    NUMBER(10) not null,
  NOMBRECIUDAD VARCHAR2(100) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.CIUDAD
  add constraint PK_CIUDAD primary key (CODCIUDAD)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CLIENTE
prompt ======================
prompt
create table PLATINUM.CLIENTE
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.CLIENTE
  add constraint CLIENTE_PK primary key (COD_CLIENTE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.CLIENTE
  add constraint CLIENTE_UK1 unique (NUMERO_DOC_CLIENTE, TIPO_DOD_CLIENTE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.CLIENTE
  add constraint CLIENTE_UK2 unique (RUC_CLIENTE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.CLIENTE
  add constraint FK_CLI_CIU foreign key (COD_CIUDAD)
  references PLATINUM.CIUDAD (CODCIUDAD);

prompt
prompt Creating table TIPO_PRODUCTO
prompt ============================
prompt
create table PLATINUM.TIPO_PRODUCTO
(
  COD_TIPO_PRODUCTO NUMBER(28) not null,
  DESCRIPCION       VARCHAR2(30) not null,
  TAREAS            VARCHAR2(1) default 'S' not null,
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.TIPO_PRODUCTO
  add constraint TIPO_PRODUCTO_PK primary key (COD_TIPO_PRODUCTO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table UNIDAD_MEDIDA
prompt ============================
prompt
create table PLATINUM.UNIDAD_MEDIDA
(
  COD_UNIDAD_MEDIDA NUMBER(28) not null,
  DESCRIPCION       VARCHAR2(30) not null,
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.UNIDAD_MEDIDA
  add constraint UNIDAD_MEDIDA_PK primary key (COD_UNIDAD_MEDIDA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table MARCA
prompt ====================
prompt
create table PLATINUM.MARCA
(
  COD_MARCA     NUMBER(28) not null,
  NOMBRE        VARCHAR2(30) not null,
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.MARCA
  add constraint MARCA_PK primary key (COD_MARCA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PRESENTACION
prompt ===========================
prompt
create table PLATINUM.PRESENTACION
(
  COD_PRESENTACION NUMBER(28) not null,
  DESCRIPCION      VARCHAR2(30) not null,
  USUARIO_ALTA     VARCHAR2(15),
  USUARIO_MODIF    VARCHAR2(15),
  FECHA_ALTA       DATE,
  FECHA_MODIF      DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PRESENTACION
  add constraint PRESENTACION_PK primary key (COD_PRESENTACION)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PRODUCTO
prompt =======================
prompt
create table PLATINUM.PRODUCTO
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
  FECHA_MODIF         DATE,
  STOCK_MINIMO        NUMBER default 0,
  PORCENTAJE_IVA      NUMBER(5,2),
  CONTENIDO           NUMBER,
  COMISION            NUMBER(15,2)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PRODUCTO
  add constraint PRODUCTO_PK primary key (COD_PRODUCTO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PRODUCTO
  add constraint PRODUCTO_FK4 foreign key (COD_TIPO_PRODUCTO)
  references PLATINUM.TIPO_PRODUCTO (COD_TIPO_PRODUCTO);
alter table PLATINUM.PRODUCTO
  add constraint PRODUCTO_MARCA_FK foreign key (COD_MARCA)
  references PLATINUM.MARCA (COD_MARCA);
alter table PLATINUM.PRODUCTO
  add constraint PRODUCTO_PRESENTACION foreign key (COD_PRESENTACION)
  references PLATINUM.PRESENTACION (COD_PRESENTACION);
alter table PLATINUM.PRODUCTO
  add constraint PRODUCTO_UNIDAD_MEDIDA foreign key (COD_UNIDAD_MEDIDA)
  references PLATINUM.UNIDAD_MEDIDA (COD_UNIDAD_MEDIDA);

prompt
prompt Creating table COMISION
prompt =======================
prompt
create table PLATINUM.COMISION
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.COMISION
  add constraint COMISION_PK primary key (COD_COMISION)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.COMISION
  add constraint FK_COMISION_PRODUCTO foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.COMISION
  add constraint CHK_PORC
  check (PORCENTAJE > 0);
alter table PLATINUM.COMISION
  add constraint COMISION_CK1
  check (	FEC_INICIAL <= FEC_FINAL);

prompt
prompt Creating table SECCION
prompt ======================
prompt
create table PLATINUM.SECCION
(
  COD_SECCION    NUMBER not null,
  NOMBRE_SECCION VARCHAR2(30) not null,
  USUARIO_ALTA   VARCHAR2(15),
  USUARIO_MODIF  VARCHAR2(15),
  FECHA_ALTA     DATE,
  FECHA_MODIF    DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.SECCION
  add constraint SECCION_PK primary key (COD_SECCION)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
create unique index PLATINUM.SECCION_NOMBRE_UK on PLATINUM.SECCION (NOMBRE_SECCION)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table EMPLEADO
prompt =======================
prompt
create table PLATINUM.EMPLEADO
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
  FECHA_MODIF               DATE,
  COSTO_HORA                NUMBER(15)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.EMPLEADO
  add constraint EMPLEADO_PK primary key (COD_EMPLEADO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.EMPLEADO
  add constraint EMPLEADO_CARGO_FK2 foreign key (COD_CARGO)
  references PLATINUM.CARGO (COD_CARGO);
alter table PLATINUM.EMPLEADO
  add constraint EMPLEADO_SECCION_FK3 foreign key (COD_SECCION)
  references PLATINUM.SECCION (COD_SECCION);

prompt
prompt Creating table VENTA_COMISION_MENSUAL
prompt =====================================
prompt
create table PLATINUM.VENTA_COMISION_MENSUAL
(
  COD_COMISION  NUMBER(15) not null,
  MES           VARCHAR2(2),
  ANIO          VARCHAR2(4),
  ESTADO        VARCHAR2(15),
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.VENTA_COMISION_MENSUAL
  add constraint PK_VENTA_COMISION_MENSUAL primary key (COD_COMISION)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table COMISION_MENS_CAB
prompt ================================
prompt
create table PLATINUM.COMISION_MENS_CAB
(
  COD_COM_MEN_CAB NUMBER(15) not null,
  FECHA           DATE,
  COD_EMPLEADO    NUMBER(15),
  FEC_INICIAL     DATE,
  FEC_FINAL       DATE,
  ESTADO          VARCHAR2(15),
  TOTAL           NUMBER(15),
  USUARIO_ALTA    VARCHAR2(15),
  USUARIO_MODIF   VARCHAR2(15),
  FECHA_ALTA      DATE,
  FECHA_MODIF     DATE,
  COD_COMISION    NUMBER(15)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.COMISION_MENS_CAB
  add constraint COMISION_MENS_CAB_PK primary key (COD_COM_MEN_CAB)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.COMISION_MENS_CAB
  add constraint COMISION_MENS_CAB_FK foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.COMISION_MENS_CAB
  add constraint FK_COMISION_MENS_CAB foreign key (COD_COMISION)
  references PLATINUM.VENTA_COMISION_MENSUAL (COD_COMISION);
alter table PLATINUM.COMISION_MENS_CAB
  add constraint COM_MENS_CAB_CHK_FEC
  check (FEC_INICIAL <= FEC_FINAL);

prompt
prompt Creating table COMISION_MENS_DET
prompt ================================
prompt
create table PLATINUM.COMISION_MENS_DET
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.COMISION_MENS_DET
  add constraint COMISION_MENS_DET_PK primary key (COD_COM_MEN_DET)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.COMISION_MENS_DET
  add constraint FK_COMISION_MENS_CABDET foreign key (COD_COM_MEN_CAB)
  references PLATINUM.COMISION_MENS_CAB (COD_COM_MEN_CAB);
alter table PLATINUM.COMISION_MENS_DET
  add constraint FK_COMISION_MENS_DET_PROD foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table ORDEN_TRABAJO
prompt ============================
prompt
create table PLATINUM.ORDEN_TRABAJO
(
  NUMERO_ORDEN_TRABAJO  NUMBER,
  FECHA_OT              DATE,
  FECHA_INICIAL_OT      DATE,
  FECHA_FIN_OT          DATE,
  COD_PRODUCTO_OT       NUMBER not null,
  CANTIDAD_OT           NUMBER not null,
  CANTIDAD_PRODUCIDA_OT NUMBER,
  ESTADO_OT             VARCHAR2(1),
  COSTO_ESTIMADO_OT     NUMBER,
  COSTO_REAL_OT         NUMBER,
  COD_EMPLEADO1         NUMBER not null,
  COD_EMPLEADO2         NUMBER not null,
  PORCENTAJE_TERMINADO  NUMBER(15),
  COD_ORDEN_TRABJO      NUMBER(15) not null,
  USUARIO_ALTA          VARCHAR2(15),
  USUARIO_MODIF         VARCHAR2(15),
  FECHA_ALTA            DATE,
  FECHA_MODIF           DATE,
  DESCRIPCION           VARCHAR2(500)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ORDEN_TRABAJO
  add primary key (COD_ORDEN_TRABJO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ORDEN_TRABAJO
  add constraint ORDEN_TRABAJO_EMPLEADO_FK2 foreign key (COD_EMPLEADO1)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.ORDEN_TRABAJO
  add constraint ORDEN_TRABAJO_EMPLEADO_FK3 foreign key (COD_EMPLEADO2)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.ORDEN_TRABAJO
  add constraint ORDEN_TRABAJO_PRODUCTO_FK foreign key (COD_PRODUCTO_OT)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.ORDEN_TRABAJO
  add constraint OT_CANT_CK
  check (CANTIDAD_OT > 0);

prompt
prompt Creating table ORDEN_TRABAJO_DETALLE
prompt ====================================
prompt
create table PLATINUM.ORDEN_TRABAJO_DETALLE
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
  FECHA_MODIF           DATE,
  SEMI_FIN              VARCHAR2(1),
  FECHA_FIN             DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ORDEN_TRABAJO_DETALLE
  add constraint ORDEN_TRABAJO_DETALLE_PK primary key (COD_ORDEN_TRABAJO_DET)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ORDEN_TRABAJO_DETALLE
  add constraint OT_CAB_DETALLE_FK foreign key (COD_ORDEN_TRABAJO)
  references PLATINUM.ORDEN_TRABAJO (COD_ORDEN_TRABJO);
alter table PLATINUM.ORDEN_TRABAJO_DETALLE
  add constraint OT_DET_EMPLEADO_FK2 foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.ORDEN_TRABAJO_DETALLE
  add constraint OT_DET_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.ORDEN_TRABAJO_DETALLE
  add constraint ORDEN_TRABAJO_CANT_CK1
  check (CANTIDAD > 0);

prompt
prompt Creating table COSTOS_FIJOS
prompt ===========================
prompt
create table PLATINUM.COSTOS_FIJOS
(
  COD_COSTO_FIJO        NUMBER(15) not null,
  DESCRIPCION_GASTO     VARCHAR2(200),
  MONTO                 NUMBER,
  USUARIO_ALTA          VARCHAR2(15),
  USUARIO_MODIF         VARCHAR2(15),
  FECHA_ALTA            DATE,
  FECHA_MODIF           DATE,
  COD_ORDEN_TRABAJO_DET NUMBER,
  COSTO_UNITARIO        NUMBER(15),
  CANTIDAD              NUMBER(15)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.COSTOS_FIJOS
  add constraint COSTOS_FIJOS_PK primary key (COD_COSTO_FIJO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.COSTOS_FIJOS
  add constraint COSTOS_FIJOS_OT_DET_FK foreign key (COD_ORDEN_TRABAJO_DET)
  references PLATINUM.ORDEN_TRABAJO_DETALLE (COD_ORDEN_TRABAJO_DET);
alter table PLATINUM.COSTOS_FIJOS
  add constraint MONTO_CK
  check (MONTO > 0);

prompt
prompt Creating table DEPOSITO
prompt =======================
prompt
create table PLATINUM.DEPOSITO
(
  COD_DEPOSITO  NUMBER not null,
  NOMBRE        VARCHAR2(30) not null,
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE,
  ESTADO        VARCHAR2(15) default 'ABIERTO'
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.DEPOSITO
  add constraint DEPOSITO_PK primary key (COD_DEPOSITO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.DEPOSITO
  add constraint DEPOSITO_UK1 unique (NOMBRE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table DET1
prompt ===================
prompt
create table PLATINUM.DET1
(
  ID  NUMBER(10) not null,
  DSC VARCHAR2(10),
  CAB NUMBER(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.DET1
  add constraint PK_DET primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.DET1
  add constraint FK_CAB_DET foreign key (CAB)
  references PLATINUM.CAB (ID);

prompt
prompt Creating table DET2
prompt ===================
prompt
create table PLATINUM.DET2
(
  ID  NUMBER(10) not null,
  DSC VARCHAR2(10),
  CAB NUMBER(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.DET2
  add constraint PK_DET2 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.DET2
  add constraint FK_CAB_DET2 foreign key (CAB)
  references PLATINUM.CAB (ID);

prompt
prompt Creating table ENTRADA_SALIDA_CABECERA
prompt ======================================
prompt
create table PLATINUM.ENTRADA_SALIDA_CABECERA
(
  COD_ENTRADA_SALIDA   NUMBER(15) not null,
  COD_EMPLEADO         NUMBER(15) not null,
  COD_ENCARGADO        NUMBER(15) not null,
  COD_DEPOSITO         NUMBER(15) not null,
  FECHA_ENTRADA_SALIDA DATE,
  HORA_ENTRADA_SALIDA  DATE,
  OBSERVACION          VARCHAR2(200),
  USUARIO_ALTA         VARCHAR2(15),
  USUARIO_MODIF        VARCHAR2(15),
  FECHA_ALTA           DATE,
  FECHA_MODIF          DATE,
  TIPO_COMPROBANTE     NUMBER(10),
  NRO_COMPROBANTE      NUMBER(15),
  COD_PERDIDA          NUMBER(15),
  ESTADO               VARCHAR2(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ENTRADA_SALIDA_CABECERA
  add constraint ENTRADA_SALIDA_CABECERA_PK primary key (COD_ENTRADA_SALIDA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ENTRADA_SALIDA_CABECERA
  add constraint ENT_SAL_DEPOSITO_FK foreign key (COD_DEPOSITO)
  references PLATINUM.DEPOSITO (COD_DEPOSITO);
alter table PLATINUM.ENTRADA_SALIDA_CABECERA
  add constraint ENT_SAL_EMPLEADO_FK foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.ENTRADA_SALIDA_CABECERA
  add constraint ENT_SAL_ENCARGADO_FK foreign key (COD_ENCARGADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);

prompt
prompt Creating table SOLICITUD_INTERNA
prompt ================================
prompt
create table PLATINUM.SOLICITUD_INTERNA
(
  COD_SOLICITUD          NUMBER(15) not null,
  FECHA                  DATE not null,
  ESTADO                 VARCHAR2(1) not null,
  COD_EMPLEADO           NUMBER(15) not null,
  COD_PRODUCTO           NUMBER(15) not null,
  CANTIDAD               NUMBER(10) not null,
  CANTIDAD_APROBADA      NUMBER(10) not null,
  CANTIDAD_COMPRA        NUMBER(10) not null,
  OBSERVACION            VARCHAR2(200) not null,
  USUARIO_ALTA           VARCHAR2(15),
  USUARIO_MODIF          VARCHAR2(15),
  FECHA_ALTA             DATE,
  FECHA_MODIF            DATE,
  FECHA_APROBACION       DATE,
  USUARIO_APROBACION     VARCHAR2(15),
  COD_EMPLEADO_APROBADOR NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.SOLICITUD_INTERNA
  add constraint SOLICITUD_PK primary key (COD_SOLICITUD)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.SOLICITUD_INTERNA
  add constraint FK_SOLICITUD_PRODUCTO foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.SOLICITUD_INTERNA
  add constraint SOLICITUD_APROBADOR foreign key (COD_EMPLEADO_APROBADOR)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.SOLICITUD_INTERNA
  add constraint SOLICITUD_EMPLEADO foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);

prompt
prompt Creating table ENTRADA_SALIDA_DETALLE
prompt =====================================
prompt
create table PLATINUM.ENTRADA_SALIDA_DETALLE
(
  COD_ENT_SAL_DETALLE       NUMBER not null,
  COD_ENTRADA_SALIDA        NUMBER not null,
  COD_PRODUCTO              NUMBER not null,
  CANTIDAD_ENT_SAL          NUMBER not null,
  OBSERVACION               VARCHAR2(200),
  ESTADO_DETALLE_ENT_SAL    VARCHAR2(1),
  TIPO_ENTRADA_SALIDA       VARCHAR2(1) default 'E' not null,
  USUARIO_ALTA              VARCHAR2(15),
  USUARIO_MODIF             VARCHAR2(15),
  FECHA_ALTA                DATE,
  FECHA_MODIF               DATE,
  COD_ORDEN_TRABAJO_DETALLE NUMBER,
  COD_SOLICITUD             NUMBER,
  EXISTENCIA                NUMBER,
  CANTIDAD_EQUIVALENCIA     NUMBER(15),
  ESTADO                    VARCHAR2(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ENTRADA_SALIDA_DETALLE
  add constraint ENTRADA_SALIDA_DETALLE_PK primary key (COD_ENT_SAL_DETALLE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ENTRADA_SALIDA_DETALLE
  add constraint CAB_DET_ENT_SAL foreign key (COD_ENTRADA_SALIDA)
  references PLATINUM.ENTRADA_SALIDA_CABECERA (COD_ENTRADA_SALIDA);
alter table PLATINUM.ENTRADA_SALIDA_DETALLE
  add constraint ENTSAL_DETALLE_OT foreign key (COD_ORDEN_TRABAJO_DETALLE)
  references PLATINUM.ORDEN_TRABAJO_DETALLE (COD_ORDEN_TRABAJO_DET);
alter table PLATINUM.ENTRADA_SALIDA_DETALLE
  add constraint ENT_SAL_PRODUCTO foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.ENTRADA_SALIDA_DETALLE
  add constraint ENTSAL_SOLICITUD foreign key (COD_SOLICITUD)
  references PLATINUM.SOLICITUD_INTERNA (COD_SOLICITUD);
alter table PLATINUM.ENTRADA_SALIDA_DETALLE
  add constraint VALID_CANT_ENT_SAL
  check (cantidad_ent_sal > 0);
alter table PLATINUM.ENTRADA_SALIDA_DETALLE
  add constraint VALID_TIPO_ENT_SAL_CHK
  check (TIPO_ENTRADA_SALIDA = 'E' or TIPO_ENTRADA_SALIDA = 'S' );

prompt
prompt Creating table EQUIVALENCIA
prompt ===========================
prompt
create table PLATINUM.EQUIVALENCIA
(
  COD_PRODUCTO_GEN NUMBER(15) not null,
  COD_EQUIVALENCIA NUMBER(15) not null,
  COD_PRODUCTO_FIN NUMBER(15) not null,
  RELACION         NUMBER(15,2) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.EQUIVALENCIA
  add constraint EQUIVALENCIA_PK primary key (COD_EQUIVALENCIA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.EQUIVALENCIA
  add constraint EQUIVALENCIA_PROD_FIN foreign key (COD_PRODUCTO_FIN)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.EQUIVALENCIA
  add constraint EQUIVALENCIA_PROD_GEN foreign key (COD_PRODUCTO_GEN)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table EXISTENCIA
prompt =========================
prompt
create table PLATINUM.EXISTENCIA
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.EXISTENCIA
  add constraint EXISTENCIA_PK primary key (COD_EXISTENCIA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.EXISTENCIA
  add constraint EXISTENCIA_DEPOSITO_FK foreign key (COD_DEPOSITO)
  references PLATINUM.DEPOSITO (COD_DEPOSITO);
alter table PLATINUM.EXISTENCIA
  add constraint EXISTENCIA_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table TIPO_COMPROBANTE
prompt ===============================
prompt
create table PLATINUM.TIPO_COMPROBANTE
(
  COD_TIPO            NUMBER(10) not null,
  DESC_TIPO           VARCHAR2(50) not null,
  CANT_DIAS           NUMBER(5) not null,
  MODULO              VARCHAR2(30) not null,
  CANT_CUOTA          NUMBER(5) default 0,
  DESC_TIPO_ABREVIADO VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.TIPO_COMPROBANTE
  add constraint PK_TIPO_COMPROBANTE primary key (COD_TIPO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PEDIDO_CABECERA
prompt ==============================
prompt
create table PLATINUM.PEDIDO_CABECERA
(
  COD_PEDIDO      NUMBER not null,
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PEDIDO_CABECERA
  add constraint PEDIDO_CABECERA_PK primary key (COD_PEDIDO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PEDIDO_CABECERA
  add constraint FK_PEDIDOCAB_TIPCOMPRO foreign key (TIPO)
  references PLATINUM.TIPO_COMPROBANTE (COD_TIPO);
alter table PLATINUM.PEDIDO_CABECERA
  add constraint PEDIDO_CLIENTE_FK foreign key (COD_CLIENTE)
  references PLATINUM.CLIENTE (COD_CLIENTE);
alter table PLATINUM.PEDIDO_CABECERA
  add constraint PEDIDO_EMPLEADO_FK foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);

prompt
prompt Creating table FACTURA_CABECERA
prompt ===============================
prompt
create table PLATINUM.FACTURA_CABECERA
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
  MONTO_DESCUENTO   NUMBER not null,
  ESTABLECIMIENTO   VARCHAR2(3) default '001' not null,
  BOCA_EXPENDIO     VARCHAR2(3) default '001' not null,
  FECHA_VENCIMIENTO DATE,
  COD_DEPOSITO      NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FACTURA_CABECERA
  add constraint FACTURA_CABECERA_PK primary key (COD_FACTURA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FACTURA_CABECERA
  add constraint FACTURA_CABECERA_FK3 foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.FACTURA_CABECERA
  add constraint FACTURA_CLIENTE_FK foreign key (COD_CLIENTE)
  references PLATINUM.CLIENTE (COD_CLIENTE);
alter table PLATINUM.FACTURA_CABECERA
  add constraint FACTURA_PEDIDO_FK foreign key (COD_PEDIDO)
  references PLATINUM.PEDIDO_CABECERA (COD_PEDIDO);
alter table PLATINUM.FACTURA_CABECERA
  add constraint FK_FACTURACAB_DEPOSITO foreign key (COD_DEPOSITO)
  references PLATINUM.DEPOSITO (COD_DEPOSITO);
alter table PLATINUM.FACTURA_CABECERA
  add constraint FK_FACTURACAB_TIPCOMPRO foreign key (TIPO_FACTURA)
  references PLATINUM.TIPO_COMPROBANTE (COD_TIPO);

prompt
prompt Creating table PROVEEDOR
prompt ========================
prompt
create table PLATINUM.PROVEEDOR
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PROVEEDOR
  add constraint PROVEEDOR_PK primary key (COD_PROVEEDOR)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PROVEEDOR
  add constraint PROVEEDOR_UK1 unique (NOMBRE_PROVEEDOR)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table FACTURA_COMPRA_CAB
prompt =================================
prompt
create table PLATINUM.FACTURA_COMPRA_CAB
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
  FECHA_MODIF     DATE,
  COD_DEPOSITO    NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FACTURA_COMPRA_CAB
  add constraint FACTURA_COMPRA_CAB_PK primary key (COD_FAC_COM_CAB)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FACTURA_COMPRA_CAB
  add constraint FACTURA_COMPRA_CAB_PROV foreign key (COD_PROVEEDOR)
  references PLATINUM.PROVEEDOR (COD_PROVEEDOR);
alter table PLATINUM.FACTURA_COMPRA_CAB
  add constraint FK_FACCOMCAB_TIPCOMPRO foreign key (TIPO)
  references PLATINUM.TIPO_COMPROBANTE (COD_TIPO);
alter table PLATINUM.FACTURA_COMPRA_CAB
  add constraint FK_FACTURA_COMPRACAB_DEPOSITO foreign key (COD_DEPOSITO)
  references PLATINUM.DEPOSITO (COD_DEPOSITO);
alter table PLATINUM.FACTURA_COMPRA_CAB
  add constraint FK_FACTURA_COMPRA_CAB_ENTSAL foreign key (COD_ENT_SAL)
  references PLATINUM.ENTRADA_SALIDA_CABECERA (COD_ENTRADA_SALIDA);
alter table PLATINUM.FACTURA_COMPRA_CAB
  add constraint FK_FACTURA_COMPRA_CAB_SOL foreign key (NRO_SOLICITUD)
  references PLATINUM.SOLICITUD_INTERNA (COD_SOLICITUD);

prompt
prompt Creating table FACTURA_COMPRA_DET
prompt =================================
prompt
create table PLATINUM.FACTURA_COMPRA_DET
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FACTURA_COMPRA_DET
  add constraint FACTURA_COMPRA_DET_PK primary key (COD_FAC_COM_DET)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FACTURA_COMPRA_DET
  add constraint FK_COMPRA_DET_SOLICITUD foreign key (NRO_SOLICITUD)
  references PLATINUM.SOLICITUD_INTERNA (COD_SOLICITUD);
alter table PLATINUM.FACTURA_COMPRA_DET
  add constraint FK_FACTURA_COMPRA_DET_CAB foreign key (COD_FAC_COM_CAB)
  references PLATINUM.FACTURA_COMPRA_CAB (COD_FAC_COM_CAB);
alter table PLATINUM.FACTURA_COMPRA_DET
  add constraint FK_FACTURA_COMPRA_DET_PROD foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.FACTURA_COMPRA_DET
  add constraint FAC_COM_DET_CHK_CANT
  check (CANTIDAD > 0);

prompt
prompt Creating table PEDIDO_DETALLE
prompt =============================
prompt
create table PLATINUM.PEDIDO_DETALLE
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PEDIDO_DETALLE
  add constraint PEDIDO_DETALLE_PK primary key (COD_PEDIDO_DETALLE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PEDIDO_DETALLE
  add constraint PEDIDO_DETALLE_FK foreign key (COD_PEDIDO)
  references PLATINUM.PEDIDO_CABECERA (COD_PEDIDO);
alter table PLATINUM.PEDIDO_DETALLE
  add constraint PEDIDO_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.PEDIDO_DETALLE
  add constraint PEDIDO_CANTIDAD_PEDIDA
  check (CANTIDAD_PEDIDA > 0);

prompt
prompt Creating table FACTURA_DETALLE
prompt ==============================
prompt
create table PLATINUM.FACTURA_DETALLE
(
  COD_FACTURA_DETALLE  NUMBER not null,
  COD_FACTURA          NUMBER,
  COD_PRODUCTO         NUMBER,
  PRECIO_UNITARIO      NUMBER,
  CANTIDAD             NUMBER,
  PORCENTAJE_IVA       NUMBER(5,2),
  TOTAL_IVA            NUMBER,
  SUB_TOTAL            NUMBER,
  PORCENTAJE_DESCUENTO NUMBER,
  MONTO_DESCUENTO      NUMBER,
  USUARIO_ALTA         VARCHAR2(15),
  USUARIO_MODIF        VARCHAR2(15),
  FECHA_ALTA           DATE,
  FECHA_MODIF          DATE,
  COD_PEDIDO_DETALLE   NUMBER,
  PORC_COMISION        NUMBER(15,2)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FACTURA_DETALLE
  add constraint FACTURA_DETALLE_PK primary key (COD_FACTURA_DETALLE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FACTURA_DETALLE
  add constraint FACTURA_DETALLE_FK foreign key (COD_FACTURA)
  references PLATINUM.FACTURA_CABECERA (COD_FACTURA);
alter table PLATINUM.FACTURA_DETALLE
  add constraint FACTURA_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.FACTURA_DETALLE
  add constraint FK_FACTURA_PEDIDO_DET foreign key (COD_PEDIDO_DETALLE)
  references PLATINUM.PEDIDO_DETALLE (COD_PEDIDO_DETALLE);
alter table PLATINUM.FACTURA_DETALLE
  add constraint FACTURA_CANTIDAD_CHK
  check (CANTIDAD > 0);
alter table PLATINUM.FACTURA_DETALLE
  add constraint FACTURA_PRECIO_CHK
  check (PRECIO_UNITARIO > 0);

prompt
prompt Creating table FORMA_PAGO
prompt =========================
prompt
create table PLATINUM.FORMA_PAGO
(
  COD_FORMA_PAGO    NUMBER(15) not null,
  NOMBRE_FORMA_PAGO VARCHAR2(30) not null,
  COD_BANCO         NUMBER(15),
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FORMA_PAGO
  add constraint FORMA_PAGO_PK primary key (COD_FORMA_PAGO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FORMA_PAGO
  add constraint FORMA_PAGO_BANCO_UK1 unique (NOMBRE_FORMA_PAGO, COD_BANCO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FORMA_PAGO
  add constraint FORMA_PAGO_BANCO_FK foreign key (COD_BANCO)
  references PLATINUM.BANCO (COD_BANCO);

prompt
prompt Creating table FORMULA_CABECERA
prompt ===============================
prompt
create table PLATINUM.FORMULA_CABECERA
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FORMULA_CABECERA
  add constraint FORMULA_CABECERA_PK primary key (COD_FORMULA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FORMULA_CABECERA
  add constraint FORMULA_PRODUCTO foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table FORMULA_SEMI_CABECERA
prompt ====================================
prompt
create table PLATINUM.FORMULA_SEMI_CABECERA
(
  COD_FORMULA_SEMI_CABECERA NUMBER not null,
  COD_PRODUCTO              NUMBER not null,
  CANTIDAD                  NUMBER not null,
  FECHA                     DATE,
  ESTADO                    VARCHAR2(1),
  USUARIO_ALTA              VARCHAR2(20),
  FECHA_ALTA                DATE,
  DESCRIPCION               VARCHAR2(200) not null,
  FORMULA_FIN               VARCHAR2(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FORMULA_SEMI_CABECERA
  add constraint FORMULA_SEMI_CABECERA_PK primary key (COD_FORMULA_SEMI_CABECERA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FORMULA_SEMI_CABECERA
  add constraint FORMULA_SEMI_CAB_PRODUC_FK foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.FORMULA_SEMI_CABECERA
  add constraint FORMULA_SEMI_CANT_CK1
  check (CANTIDAD > 0);

prompt
prompt Creating table FORMULA_DETALLE
prompt ==============================
prompt
create table PLATINUM.FORMULA_DETALLE
(
  COD_FORMULA_DETALLE    NUMBER(28) not null,
  COD_FORMULA            NUMBER(28) not null,
  COD_PRODUCTO           NUMBER(28) not null,
  CANTIDAD               NUMBER(28),
  USUARIO_ALTA           VARCHAR2(15),
  USUARIO_MODIF          VARCHAR2(15),
  FECHA_ALTA             DATE,
  FECHA_MODIF            DATE,
  CODIGO_FORMULA_SEMITER NUMBER not null,
  SEMI_FIN               VARCHAR2(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FORMULA_DETALLE
  add constraint FORMULA_DETALLE_PK primary key (COD_FORMULA_DETALLE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FORMULA_DETALLE
  add constraint FORMULA_CABECERA_DETALLE foreign key (COD_FORMULA)
  references PLATINUM.FORMULA_CABECERA (COD_FORMULA);
alter table PLATINUM.FORMULA_DETALLE
  add constraint FORMULA_DETALLE_FK2 foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.FORMULA_DETALLE
  add constraint FORMULA_DETALLE_FORM_SEMTIER foreign key (CODIGO_FORMULA_SEMITER)
  references PLATINUM.FORMULA_SEMI_CABECERA (COD_FORMULA_SEMI_CABECERA);

prompt
prompt Creating table FORMULA_SEMI_DETALLE
prompt ===================================
prompt
create table PLATINUM.FORMULA_SEMI_DETALLE
(
  COD_FORMULA_SEMI_DETALLE  NUMBER not null,
  COD_FORMULA_SEMI_CABECERA NUMBER not null,
  COD_PRODUCTO              NUMBER not null,
  CANTIDAD                  NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FORMULA_SEMI_DETALLE
  add constraint FORMULA_SEMI_DETALLE_PK primary key (COD_FORMULA_SEMI_DETALLE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.FORMULA_SEMI_DETALLE
  add constraint FORMULA_SEMI_CAB_DET_FK foreign key (COD_FORMULA_SEMI_CABECERA)
  references PLATINUM.FORMULA_SEMI_CABECERA (COD_FORMULA_SEMI_CABECERA);
alter table PLATINUM.FORMULA_SEMI_DETALLE
  add constraint FORMULA_SEMI_DET_PROD_FK foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.FORMULA_SEMI_DETALLE
  add constraint FORMULA_SEMI_DETALLE_CANT_CK1
  check (CANTIDAD > 0);

prompt
prompt Creating table HABILITACION_CAJA
prompt ================================
prompt
create table PLATINUM.HABILITACION_CAJA
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.HABILITACION_CAJA
  add constraint HABILITACION_CAJA_PK primary key (COD_HABILITACION_CAJA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.HABILITACION_CAJA
  add constraint HABILITACION_CAJA_CAJA_FK foreign key (COD_CAJA)
  references PLATINUM.CAJA (COD_CAJA);
alter table PLATINUM.HABILITACION_CAJA
  add constraint HABILITACION_CAJA_EMPLEADO_FK foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.HABILITACION_CAJA
  add constraint HABILITACION_CAJA_RESP_FK foreign key (COD_REPONSABLE)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.HABILITACION_CAJA
  add constraint HABILITACION_CAJA_CK5
  check (TOTAL_GASTO >= 0);
alter table PLATINUM.HABILITACION_CAJA
  add constraint MONTO_INICIAL_CK1
  check (MONTO_INICIAL >= 0);
alter table PLATINUM.HABILITACION_CAJA
  add constraint MONTO_RENDIDO_CK6
  check (MONTO_RENDIDO >=0);
alter table PLATINUM.HABILITACION_CAJA
  add constraint MONTO_SALDO_CK4
  check (MONTO_SALDO >=0);
alter table PLATINUM.HABILITACION_CAJA
  add constraint TOTAL_MOVIMIENTO_CAJA_CK2
  check (TOTAL_MOVIMIENTO_CAJA >= 0);
alter table PLATINUM.HABILITACION_CAJA
  add constraint VALID_FECHAS_CK
  check (FECHA_CIERRE >= FECHA_HAB_CAJA);

prompt
prompt Creating table GASTO
prompt ====================
prompt
create table PLATINUM.GASTO
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.GASTO
  add constraint GASTO_PK primary key (COD_GASTO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.GASTO
  add constraint GASTO_EMPLEADO foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.GASTO
  add constraint GASTO_HAB_CAJA_FK foreign key (COD_HABILITACION_CAJA)
  references PLATINUM.HABILITACION_CAJA (COD_HABILITACION_CAJA);
alter table PLATINUM.GASTO
  add constraint GASTO_CK1
  check (MONTO_GASTO > 0);

prompt
prompt Creating table HISTORICO_COSTO
prompt ==============================
prompt
create table PLATINUM.HISTORICO_COSTO
(
  COD_HISTORICO_COSTO NUMBER not null,
  FEC_HISTORICO_COSTO DATE not null,
  COSTO_HISTORICO     NUMBER not null,
  USUARIO_ALTA        VARCHAR2(15),
  USUARIO_MODIF       VARCHAR2(15),
  FECHA_ALTA          DATE,
  FECHA_MODIF         DATE,
  COD_PRODUCTO        NUMBER(15) not null,
  COSTO_COMPRA        NUMBER,
  COSTO_ACTUAL        NUMBER,
  EXISTENCIA_ACTUAL   NUMBER(15,2),
  EXISTENCIA_COMPRA   NUMBER(15,2)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.HISTORICO_COSTO
  add constraint HISTORICO_COSTO_PK primary key (COD_HISTORICO_COSTO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.HISTORICO_COSTO
  add constraint FK_HISTORICO_COSTO_PRODUCTO foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.HISTORICO_COSTO
  add constraint HISTORICO_COSTO_CK1
  check (Costo_Historico > 0);

prompt
prompt Creating table HISTORICO_PRECIO
prompt ===============================
prompt
create table PLATINUM.HISTORICO_PRECIO
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.HISTORICO_PRECIO
  add constraint HISTORICO_PRECIO_PK primary key (COD_HISTORICO_PRECIO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.HISTORICO_PRECIO
  add constraint FK_HISTORICO_PRECIO_PRODUCTO foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.HISTORICO_PRECIO
  add constraint HISTORICO_PRECIO_CK1
  check (Precio_Historico > 0);

prompt
prompt Creating table INVENTARIO_CABECERA
prompt ==================================
prompt
create table PLATINUM.INVENTARIO_CABECERA
(
  COD_INVENTARIO NUMBER not null,
  FEC_INVENTARIO DATE not null,
  COD_DEPOSITO   NUMBER not null,
  DESCRIPCION    VARCHAR2(300),
  ESTADO         VARCHAR2(1),
  USUARIO_ALTA   VARCHAR2(15),
  USUARIO_MODIF  VARCHAR2(15),
  FECHA_ALTA     DATE,
  FECHA_MODIF    DATE,
  COD_EMPLEADO   NUMBER(7)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.INVENTARIO_CABECERA
  add constraint INVENTARIO_CABECERA_PK primary key (COD_INVENTARIO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.INVENTARIO_CABECERA
  add constraint INVENTARIO_CABECERA_EMPLEADO foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.INVENTARIO_CABECERA
  add constraint INVENTARIO_CABECERA_FK foreign key (COD_DEPOSITO)
  references PLATINUM.DEPOSITO (COD_DEPOSITO);

prompt
prompt Creating table INVENTARIO_DETALLE
prompt =================================
prompt
create table PLATINUM.INVENTARIO_DETALLE
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.INVENTARIO_DETALLE
  add constraint INVENTARIO_DETALLE_PK primary key (COD_INVENTARIO_DETALLE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.INVENTARIO_DETALLE
  add constraint INVENTARIO_ CAB_DETALLE_FK2 foreign key (COD_INVENTARIO)
  references PLATINUM.INVENTARIO_CABECERA (COD_INVENTARIO);
alter table PLATINUM.INVENTARIO_DETALLE
  add constraint INVENTARIO_DETALLE_PRODUCTO foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.INVENTARIO_DETALLE
  add constraint INVENTARIO_DETALLE_CK1
  check (CANTIDADCONTADA > -1);
alter table PLATINUM.INVENTARIO_DETALLE
  add constraint INVENTARIO_DETALLE_CK2
  check (CANTIDADSISTEMA > -1);

prompt
prompt Creating table MAQUINARIAS
prompt ==========================
prompt
create table PLATINUM.MAQUINARIAS
(
  COD_MAQUINARIA      NUMBER(15) not null,
  DESCRIPCION         VARCHAR2(4000) not null,
  CONSUMO_KWH         NUMBER(15),
  COSTO_MANTENIMIENTO NUMBER(15),
  HORAS_MANTENIMENTO  NUMBER(15)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.MAQUINARIAS
  add constraint MAQUINARIAS_PK primary key (COD_MAQUINARIA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table RECIBO_CABECERA
prompt ==============================
prompt
create table PLATINUM.RECIBO_CABECERA
(
  COD_RECIBO    NUMBER not null,
  NUMERO_RECIBO NUMBER not null,
  COD_CLIENTE   NUMBER not null,
  MONTO_TOTAL   NUMBER,
  ESTADO        VARCHAR2(15),
  SERIE_RECIBO  VARCHAR2(1),
  USUARIO_ALTA  VARCHAR2(15),
  USUARIO_MODIF VARCHAR2(15),
  FECHA_ALTA    DATE,
  FECHA_MODIF   DATE,
  FECHA         DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.RECIBO_CABECERA
  add constraint RECIBO_CABECERA_PK primary key (COD_RECIBO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.RECIBO_CABECERA
  add constraint NUM_SERIE_UK unique (NUMERO_RECIBO, SERIE_RECIBO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.RECIBO_CABECERA
  add constraint RECIBO_CLIENTE_FK foreign key (COD_CLIENTE)
  references PLATINUM.CLIENTE (COD_CLIENTE);
alter table PLATINUM.RECIBO_CABECERA
  add constraint VALID_MONTO_RECIBO
  check (MONTO_TOTAL > 0);

prompt
prompt Creating table MOVIMIENTO_CAJA_CABECERA
prompt =======================================
prompt
create table PLATINUM.MOVIMIENTO_CAJA_CABECERA
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.MOVIMIENTO_CAJA_CABECERA
  add constraint MOVIMIENTO_CAJA_CABECERA_PK primary key (COD_MOVIMIENTO_CAJA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.MOVIMIENTO_CAJA_CABECERA
  add constraint MOVIMIENTO_CAJA_EMPLEADO_FK3 foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.MOVIMIENTO_CAJA_CABECERA
  add constraint MOVIMIENTO_CAJA_HAB_CAJA_FK foreign key (COD_HABILITACION_CAJA)
  references PLATINUM.HABILITACION_CAJA (COD_HABILITACION_CAJA);
alter table PLATINUM.MOVIMIENTO_CAJA_CABECERA
  add constraint MOVIMIENTO_CAJA_RECIBO_FK2 foreign key (COD_RECIBO)
  references PLATINUM.RECIBO_CABECERA (COD_RECIBO);

prompt
prompt Creating table MOVIMIENTO_CAJA_DETALLE
prompt ======================================
prompt
create table PLATINUM.MOVIMIENTO_CAJA_DETALLE
(
  COD_MOVIMIENTO_CAJA_DET NUMBER not null,
  COD_RECIBO_CAB          NUMBER,
  COD_FORMA_PAGO          NUMBER,
  SERIE_CHEQUE            VARCHAR2(5),
  NUMERO_CHEQUE           VARCHAR2(15),
  MONTO                   NUMBER,
  USUARIO_ALTA            VARCHAR2(15),
  USUARIO_MODIF           VARCHAR2(15),
  FECHA_ALTA              DATE,
  FECHA_MODIF             DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.MOVIMIENTO_CAJA_DETALLE
  add constraint MOVIMIENTO_CAJA_DETALLE_PK primary key (COD_MOVIMIENTO_CAJA_DET)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.MOVIMIENTO_CAJA_DETALLE
  add constraint MOV_CAJA_FORMA_PAGO_FK foreign key (COD_FORMA_PAGO)
  references PLATINUM.FORMA_PAGO (COD_FORMA_PAGO);
alter table PLATINUM.MOVIMIENTO_CAJA_DETALLE
  add constraint MOVCAJA_RECIBO foreign key (COD_RECIBO_CAB)
  references PLATINUM.RECIBO_CABECERA (COD_RECIBO);
alter table PLATINUM.MOVIMIENTO_CAJA_DETALLE
  add constraint VALID_MOV_CAJA_MONTO_CK
  check (MONTO >0);

prompt
prompt Creating table NOTA_CREDITO_CLI_CABECERA
prompt ========================================
prompt
create table PLATINUM.NOTA_CREDITO_CLI_CABECERA
(
  COD_NOTA_CREDITO_CLIENTE NUMBER not null,
  NUM_NOTA_CREDTO_CLIENTE  NUMBER not null,
  COD_CLIENTE              NUMBER not null,
  COD_FACTURA              NUMBER not null,
  TOTAL_NOTA_CREDITO       NUMBER,
  FECHA_NOTA_CREDITO       DATE not null,
  TOTAL_IVA                NUMBER,
  USUARIO_ALTA             VARCHAR2(15),
  USUARIO_MODIF            VARCHAR2(15),
  FECHA_ALTA               DATE,
  FECHA_MODIF              DATE,
  ESTADO                   VARCHAR2(15),
  SALDO_FAC                NUMBER(15),
  SUB_TOTAL                NUMBER(15),
  COD_DEPOSITO             NUMBER,
  TIPO                     NUMBER(10),
  ESTABLECIMIENTO          VARCHAR2(3) default '001',
  BOCA_EXPENDIO            VARCHAR2(3) default '001'
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.NOTA_CREDITO_CLI_CABECERA
  add constraint NOTA_CREDITO_CLI_CABECERA_PK primary key (COD_NOTA_CREDITO_CLIENTE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.NOTA_CREDITO_CLI_CABECERA
  add constraint FK_NOTCRECLICAB_DEPOSITO foreign key (COD_DEPOSITO)
  references PLATINUM.DEPOSITO (COD_DEPOSITO);
alter table PLATINUM.NOTA_CREDITO_CLI_CABECERA
  add constraint FK_NOT_CRE_CLI_TIPOCOMP foreign key (TIPO)
  references PLATINUM.TIPO_COMPROBANTE (COD_TIPO);
alter table PLATINUM.NOTA_CREDITO_CLI_CABECERA
  add constraint NOTA_CREDITO_CLI_CLIENTE foreign key (COD_CLIENTE)
  references PLATINUM.CLIENTE (COD_CLIENTE);
alter table PLATINUM.NOTA_CREDITO_CLI_CABECERA
  add constraint NOTA_CREDITO_CLI_FACTURA foreign key (COD_FACTURA)
  references PLATINUM.FACTURA_CABECERA (COD_FACTURA);

prompt
prompt Creating table NOTA_CREDITO_CLI_DETALLE
prompt =======================================
prompt
create table PLATINUM.NOTA_CREDITO_CLI_DETALLE
(
  COD_NOTA_CREDITO_CLI_DET NUMBER not null,
  COD_NOTA_CREDITO_CLIENTE NUMBER not null,
  COD_PRODUCTO             NUMBER not null,
  PRECIO_UNITARIO          NUMBER not null,
  CANTIDAD                 NUMBER not null,
  MONTO                    NUMBER not null,
  PORCENTAJE_IVA           NUMBER not null,
  TOTAL_IVA                NUMBER not null,
  USUARIO_ALTA             VARCHAR2(15),
  USUARIO_MODIF            VARCHAR2(15),
  FECHA_ALTA               DATE,
  FECHA_MODIF              DATE,
  COD_FACTURA_DET_CLIENTE  NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.NOTA_CREDITO_CLI_DETALLE
  add constraint NOTA_CREDITO_CLI_DETALLE_PK primary key (COD_NOTA_CREDITO_CLI_DET)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.NOTA_CREDITO_CLI_DETALLE
  add constraint FK_FACCRECLICAB_NOTCRECLI foreign key (COD_FACTURA_DET_CLIENTE)
  references PLATINUM.FACTURA_DETALLE (COD_FACTURA_DETALLE);
alter table PLATINUM.NOTA_CREDITO_CLI_DETALLE
  add constraint NOTA_CREDITO_CLI_DETALLE_FK foreign key (COD_NOTA_CREDITO_CLIENTE)
  references PLATINUM.NOTA_CREDITO_CLI_CABECERA (COD_NOTA_CREDITO_CLIENTE);
alter table PLATINUM.NOTA_CREDITO_CLI_DETALLE
  add constraint NOTA_CREDITO_CLI_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.NOTA_CREDITO_CLI_DETALLE
  add constraint NOTA_CREDITO_CANTIDAD
  check (CANTIDAD > 0);

prompt
prompt Creating table NOTA_CREDITO_PROV_CAB
prompt ====================================
prompt
create table PLATINUM.NOTA_CREDITO_PROV_CAB
(
  COD_NOT_CRE_CAB  NUMBER(15) not null,
  FECHA            DATE not null,
  COD_PROVEEDOR    NUMBER(15) not null,
  NRO_NOTA_CREDITO VARCHAR2(20) not null,
  COD_FACTURA_CAB  NUMBER(15) not null,
  ESTADO           VARCHAR2(15) not null,
  TOTAL            NUMBER(15) not null,
  TOTAL_IVA        NUMBER(15) not null,
  SALDO_FAC        NUMBER(15) not null,
  USUARIO_ALTA     VARCHAR2(15),
  USUARIO_MODIF    VARCHAR2(15),
  FECHA_ALTA       DATE,
  FECHA_MODIF      DATE,
  SUB_TOTAL        NUMBER(15),
  COD_DEPOSITO     NUMBER,
  ESTABLECIMIENTO  VARCHAR2(3) default '001' not null,
  BOCA_EXPENDIO    VARCHAR2(3) default '001' not null,
  TIPO             NUMBER(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.NOTA_CREDITO_PROV_CAB
  add constraint NOTA_CREDITO_PROV_CAB_PK primary key (COD_NOT_CRE_CAB)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.NOTA_CREDITO_PROV_CAB
  add constraint FK_NOTA_CREDITO_PROV_CAB_FAC foreign key (COD_FACTURA_CAB)
  references PLATINUM.FACTURA_COMPRA_CAB (COD_FAC_COM_CAB);
alter table PLATINUM.NOTA_CREDITO_PROV_CAB
  add constraint FK_NOTACREDPROVCAB_TIPCOMPRO foreign key (TIPO)
  references PLATINUM.TIPO_COMPROBANTE (COD_TIPO);
alter table PLATINUM.NOTA_CREDITO_PROV_CAB
  add constraint FK_NOTACREPROVCAB_DEPOSITO foreign key (COD_DEPOSITO)
  references PLATINUM.DEPOSITO (COD_DEPOSITO);
alter table PLATINUM.NOTA_CREDITO_PROV_CAB
  add constraint FK_NOT_CRE_PROV_CAB_PROV foreign key (COD_PROVEEDOR)
  references PLATINUM.PROVEEDOR (COD_PROVEEDOR);

prompt
prompt Creating table NOTA_CREDITO_PROV_DET
prompt ====================================
prompt
create table PLATINUM.NOTA_CREDITO_PROV_DET
(
  COD_NOT_CRE_DET NUMBER(15) not null,
  COD_NOT_CRE_CAB NUMBER(15) not null,
  COD_PRODUCTO    NUMBER(15) not null,
  PRECIO_UNI      NUMBER(10) not null,
  CANTIDAD        NUMBER(10) not null,
  PORC_IVA        NUMBER(5,2) not null,
  MONTO_IVA       NUMBER(10) not null,
  TOTAL           NUMBER(15) not null,
  USUARIO_ALTA    VARCHAR2(15),
  USUARIO_MODIF   VARCHAR2(15),
  FECHA_ALTA      DATE,
  FECHA_MODIF     DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.NOTA_CREDITO_PROV_DET
  add constraint NOTA_CREDITO_PROV_DET_PK primary key (COD_NOT_CRE_DET)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.NOTA_CREDITO_PROV_DET
  add constraint FK_NOTA_CREDITO_PROV_DETCAB foreign key (COD_NOT_CRE_CAB)
  references PLATINUM.NOTA_CREDITO_PROV_CAB (COD_NOT_CRE_CAB);
alter table PLATINUM.NOTA_CREDITO_PROV_DET
  add constraint NOTA_CRED_PROV_DET_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table ORDEN_TRABAJO_DET_COSTO_H
prompt ========================================
prompt
create table PLATINUM.ORDEN_TRABAJO_DET_COSTO_H
(
  COD_ORDEN_TRAB_DET_HORAS NUMBER not null,
  COD_ORDEN_TRABAJO_DET    NUMBER,
  COD_EMPLEADO             NUMBER,
  CANTIDAD_HORAS           NUMBER,
  COSTO_HORA               NUMBER,
  COSTO_TOTAL              NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ORDEN_TRABAJO_DET_COSTO_H
  add constraint ORDEN_TRABAJO_DET_COSTO_H_PK primary key (COD_ORDEN_TRAB_DET_HORAS)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ORDEN_TRABAJO_DET_COSTO_H
  add constraint ORDEN_TRABAJO_DET_HORA_DET foreign key (COD_ORDEN_TRABAJO_DET)
  references PLATINUM.ORDEN_TRABAJO_DETALLE (COD_ORDEN_TRABAJO_DET);
alter table PLATINUM.ORDEN_TRABAJO_DET_COSTO_H
  add constraint ORDEN_TRABAJO_DET_HORA_EMP foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);

prompt
prompt Creating table ORDEN_TRABAJO_DET_COSTO_MAT
prompt ==========================================
prompt
create table PLATINUM.ORDEN_TRABAJO_DET_COSTO_MAT
(
  COD_ORDEN_TRAB_DET_MAT NUMBER not null,
  COD_ORDEN_TRABAJO_DET  NUMBER,
  COD_PRODUCTO           NUMBER,
  CANTIDAD               NUMBER,
  COSTO_UNITARIO         NUMBER,
  COSTO_TOTAL            NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ORDEN_TRABAJO_DET_COSTO_MAT
  add constraint ORDEN_TRABAJO_DET_COSTO_MAT_PK primary key (COD_ORDEN_TRAB_DET_MAT)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.ORDEN_TRABAJO_DET_COSTO_MAT
  add constraint ORDEN_TRAB_DET_COSTO_DET foreign key (COD_ORDEN_TRABAJO_DET)
  references PLATINUM.ORDEN_TRABAJO_DETALLE (COD_ORDEN_TRABAJO_DET);
alter table PLATINUM.ORDEN_TRABAJO_DET_COSTO_MAT
  add constraint ORDEN_TRAB_DET_COSTO_PROD foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table PARAMETROS
prompt =========================
prompt
create table PLATINUM.PARAMETROS
(
  COD_PARAMETRO NUMBER(15) not null,
  DESCRIPCION   VARCHAR2(200),
  VALOR_NUMERO  NUMBER(15),
  VALOR_TEXTO   VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PARAMETROS
  add constraint PARAMETROS_PK primary key (COD_PARAMETRO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PERDIDA
prompt ======================
prompt
create table PLATINUM.PERDIDA
(
  COD_PERDIDA       NUMBER(15) not null,
  COD_EMPLEADO      NUMBER(15) not null,
  FECHA_PERDIDA     DATE not null,
  COD_PRODUCTO      NUMBER(15) not null,
  CANTIDAD_PERDIDA  NUMBER(15) not null,
  OBSERVACION       VARCHAR2(200),
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE,
  COD_ORDEN_TRABAJO NUMBER,
  COD_TAREA_FALLIDA NUMBER(15),
  TALLER            VARCHAR2(1),
  COD_DEPOSITO      NUMBER(15),
  ESTADO            VARCHAR2(1),
  PRECIO_UNIT       NUMBER(15),
  TOTAL             NUMBER(15)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PERDIDA
  add constraint PERDIDA_PK primary key (COD_PERDIDA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PERDIDA
  add constraint PERDIDA_DEPOSITO_FK foreign key (COD_DEPOSITO)
  references PLATINUM.DEPOSITO (COD_DEPOSITO);
alter table PLATINUM.PERDIDA
  add constraint PERDIDA_EMPLEADO_FK foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.PERDIDA
  add constraint PERDIDA_PRODUCCION foreign key (COD_ORDEN_TRABAJO)
  references PLATINUM.ORDEN_TRABAJO (COD_ORDEN_TRABJO);
alter table PLATINUM.PERDIDA
  add constraint PERDIDA_PRODUCTO_FK foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);
alter table PLATINUM.PERDIDA
  add constraint PERDIDA_CANT_CK1
  check (CANTIDAD_PERDIDA > 0);

prompt
prompt Creating table TAREA
prompt ====================
prompt
create table PLATINUM.TAREA
(
  COD_TAREA      NUMBER(15) not null,
  NOMBRE_TAREA   VARCHAR2(40) not null,
  USUARIO_ALTA   VARCHAR2(15),
  USUARIO_MODIF  VARCHAR2(15),
  FECHA_ALTA     DATE,
  FECHA_MODIF    DATE,
  COD_MAQUINARIA NUMBER(15)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.TAREA
  add constraint TAREA_PK primary key (COD_TAREA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.TAREA
  add constraint NOMBRE_TAREA_UK unique (NOMBRE_TAREA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.TAREA
  add constraint FK_TAREA_MAQUINARIA foreign key (COD_MAQUINARIA)
  references PLATINUM.MAQUINARIAS (COD_MAQUINARIA);

prompt
prompt Creating table TAREA_ASIGNADA
prompt =============================
prompt
create table PLATINUM.TAREA_ASIGNADA
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
  FECHA_MODIF          DATE,
  TAREA_FIN            VARCHAR2(1),
  CANTIDAD_FALLIDA     NUMBER(15)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.TAREA_ASIGNADA
  add constraint TAREA_ASIGNADA_PK primary key (COD_TAREA_ASIGNADA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.TAREA_ASIGNADA
  add constraint FK_TAREA_ASIGNADA foreign key (COD_TAREA)
  references PLATINUM.TAREA (COD_TAREA);
alter table PLATINUM.TAREA_ASIGNADA
  add constraint FK_TAREA_ASIGNADA_DET_OT foreign key (COD_DET_ORDEN_TRABAJ)
  references PLATINUM.ORDEN_TRABAJO_DETALLE (COD_ORDEN_TRABAJO_DET);
alter table PLATINUM.TAREA_ASIGNADA
  add constraint FK_TAREA_ASIGNADA_EMP foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.TAREA_ASIGNADA
  add constraint CK_TAREA_ASIGNADA_CANT
  check (CANTIDAD > 0);

prompt
prompt Creating table PRODUCCION_DIARIA
prompt ================================
prompt
create table PLATINUM.PRODUCCION_DIARIA
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PRODUCCION_DIARIA
  add constraint PRODUCCION_DIARIA_PK primary key (COD_PRODUCCION_DIARIA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.PRODUCCION_DIARIA
  add constraint FK_PRODUCCION_DIARIA_EMPLEADO foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);
alter table PLATINUM.PRODUCCION_DIARIA
  add constraint FK_PRODUCCION_DIARIA_TAREA foreign key (COD_TAREA_ASIGNADA)
  references PLATINUM.TAREA_ASIGNADA (COD_TAREA_ASIGNADA);
alter table PLATINUM.PRODUCCION_DIARIA
  add constraint PRODUCCION_DIARIA_CANTIDAD
  check (CANTIDAD > 0);

prompt
prompt Creating table RECIBO_DETALLE
prompt =============================
prompt
create table PLATINUM.RECIBO_DETALLE
(
  COD_RECIBO_DET    NUMBER(15) not null,
  COD_RECIBO        NUMBER(15) not null,
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE,
  TIPO_COMPROBANTE  NUMBER(10),
  NRO_COMPROBANTE   NUMBER,
  NRO_CUOTA         NUMBER(5),
  SALDO_CUOTA       NUMBER,
  MONTO_PAGO        NUMBER,
  COMPROBANTE       VARCHAR2(30),
  MONTO_CUOTA       NUMBER,
  FECHA_VENCIMIENTO DATE,
  COD_SALDO_CLIENTE NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.RECIBO_DETALLE
  add constraint RECIBO_DETALLE_PK primary key (COD_RECIBO_DET)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.RECIBO_DETALLE
  add constraint RECIBO_DETALLE_CAB_FK foreign key (COD_RECIBO)
  references PLATINUM.RECIBO_CABECERA (COD_RECIBO);

prompt
prompt Creating table RECURSO_ASIGNADO
prompt ===============================
prompt
create table PLATINUM.RECURSO_ASIGNADO
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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.RECURSO_ASIGNADO
  add constraint RECURSO_ASIGNADO_PK primary key (COD_RECURSO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.RECURSO_ASIGNADO
  add constraint FK_RECURSO_ASIGNADO_OT_DET foreign key (COD_ORDEN_TRAB_DET)
  references PLATINUM.ORDEN_TRABAJO_DETALLE (COD_ORDEN_TRABAJO_DET);
alter table PLATINUM.RECURSO_ASIGNADO
  add constraint FK_RECURSO_ASIGNADO_PRODUCTO foreign key (COD_PRODUCTO)
  references PLATINUM.PRODUCTO (COD_PRODUCTO);

prompt
prompt Creating table SALDO_CLIENTE
prompt ============================
prompt
create table PLATINUM.SALDO_CLIENTE
(
  COD_SALDO_CLIENTE NUMBER not null,
  COD_CLIENTE       NUMBER not null,
  SALDO_COMPROBANTE NUMBER,
  TOTAL_COMPROBANTE NUMBER,
  USUARIO_ALTA      VARCHAR2(15),
  USUARIO_MODIF     VARCHAR2(15),
  FECHA_ALTA        DATE,
  FECHA_MODIF       DATE,
  TIPO_COMPROBANTE  NUMBER(10),
  NRO_COMPROBANTE   NUMBER,
  FECHA_COMPROBANTE DATE,
  FECHA_VENCIMIENTO DATE,
  NRO_CUOTA         NUMBER(5),
  MONTO_CUOTA       NUMBER,
  SALDO_CUOTA       NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.SALDO_CLIENTE
  add constraint SALDO_CLIENTE_PK primary key (COD_SALDO_CLIENTE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.SALDO_CLIENTE
  add constraint SALDO_CLIENTE_FK foreign key (COD_CLIENTE)
  references PLATINUM.CLIENTE (COD_CLIENTE);

prompt
prompt Creating table TAREA_FALLIDA
prompt ============================
prompt
create table PLATINUM.TAREA_FALLIDA
(
  COD_TAREA_FALLIDA  NUMBER(15) not null,
  COD_TAREA_ASIGNADA NUMBER(15) not null,
  CANTIDAD           NUMBER(15),
  REHACER            NUMBER(15),
  COD_EMPLEADO       NUMBER(15) not null,
  FECHA              DATE,
  FECHA_ALTA         DATE,
  FECHA_MODIF        DATE,
  USUARIO_ALTA       VARCHAR2(15),
  USUARIO_MODIF      VARCHAR2(15)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.TAREA_FALLIDA
  add constraint TAREA_FALLIDA_PK primary key (COD_TAREA_FALLIDA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.TAREA_FALLIDA
  add constraint TAREA_FALLIDA_ASIGNADA foreign key (COD_TAREA_ASIGNADA)
  references PLATINUM.TAREA_ASIGNADA (COD_TAREA_ASIGNADA);
alter table PLATINUM.TAREA_FALLIDA
  add constraint TAREA_FALLIDA_EMPLEADO foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);

prompt
prompt Creating table TAREA_FORMULA
prompt ============================
prompt
create table PLATINUM.TAREA_FORMULA
(
  COD_TAREA_FORMULA         NUMBER(15) not null,
  COD_TAREA                 NUMBER(15) not null,
  CANTIDAD_TAREA            NUMBER(15) not null,
  ORDEN_TAREA               NUMBER(15) not null,
  USUARIO_ALTA              VARCHAR2(15),
  USUARIO_MODIF             VARCHAR2(15),
  FECHA_ALTA                DATE,
  FECHA_MODIF               DATE,
  COD_FORMULA_SEMI_CABECERA NUMBER,
  TAREA_FIN                 VARCHAR2(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.TAREA_FORMULA
  add constraint TAREA_FORMULA_PK primary key (COD_TAREA_FORMULA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.TAREA_FORMULA
  add constraint TAREA_FORMULA_FK foreign key (COD_TAREA)
  references PLATINUM.TAREA (COD_TAREA);
alter table PLATINUM.TAREA_FORMULA
  add constraint TAR_FORM_CAB_FORMULA_SEMI foreign key (COD_FORMULA_SEMI_CABECERA)
  references PLATINUM.FORMULA_SEMI_CABECERA (COD_FORMULA_SEMI_CABECERA);
alter table PLATINUM.TAREA_FORMULA
  add constraint VALID_CANT_TAREA_CHK
  check (CANTIDAD_TAREA > 0);

prompt
prompt Creating table USUARIOS
prompt =======================
prompt
create table PLATINUM.USUARIOS
(
  USUARIO      VARCHAR2(15) not null,
  PASSWORD     VARCHAR2(50) not null,
  ROL          VARCHAR2(20) not null,
  COD_EMPLEADO NUMBER not null,
  COD_DEPOSITO NUMBER not null,
  ESTADO       VARCHAR2(1) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.USUARIOS
  add constraint USUARIOS_PK primary key (USUARIO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PLATINUM.USUARIOS
  add constraint USUARIO_DEPOSITO_FK foreign key (COD_DEPOSITO)
  references PLATINUM.DEPOSITO (COD_DEPOSITO);
alter table PLATINUM.USUARIOS
  add constraint USUARIOS_EMPLEADO_FK foreign key (COD_EMPLEADO)
  references PLATINUM.EMPLEADO (COD_EMPLEADO);

prompt
prompt Creating sequence ORDEN_TRABAJO_DET_COSTO_H_SEQ
prompt ===============================================
prompt
create sequence PLATINUM.ORDEN_TRABAJO_DET_COSTO_H_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence PRODUCCION_DIARIA_SEQ
prompt =======================================
prompt
create sequence PLATINUM.PRODUCCION_DIARIA_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SE_FORMULA_SEMI_CABECERA
prompt ==========================================
prompt
create sequence PLATINUM.SE_FORMULA_SEMI_CABECERA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_BANCO
prompt ===========================
prompt
create sequence PLATINUM.SEQ_BANCO
minvalue 1
maxvalue 999999999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_EQUIVALENCIA
prompt ==================================
prompt
create sequence PLATINUM.SEQ_EQUIVALENCIA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence seq_existencia
prompt ================================
prompt
create sequence PLATINUM.seq_existencia
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_FORMA_PAGO
prompt ================================
prompt
create sequence PLATINUM.SEQ_FORMA_PAGO
minvalue 1
maxvalue 999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_GASTO
prompt ===========================
prompt
create sequence PLATINUM.SEQ_GASTO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_ORDEN_TRABAJO
prompt ===================================
prompt
create sequence PLATINUM.SEQ_ORDEN_TRABAJO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_PRODUCCION_DIARIA
prompt =======================================
prompt
create sequence PLATINUM.SEQ_PRODUCCION_DIARIA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CABECERA_ENTRADA_SALIDA
prompt ============================================
prompt
create sequence PLATINUM.SQ_CABECERA_ENTRADA_SALIDA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1001
increment by 1
nocache;

prompt
prompt Creating sequence SQ_CABECERA_FACTURA
prompt =====================================
prompt
create sequence PLATINUM.SQ_CABECERA_FACTURA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1080
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CABECERA_FORMULA
prompt =====================================
prompt
create sequence PLATINUM.SQ_CABECERA_FORMULA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SQ_CABECERA_INVENTARIO
prompt ========================================
prompt
create sequence PLATINUM.SQ_CABECERA_INVENTARIO
minvalue 1
maxvalue 999999999999999999999999999
start with 121
increment by 1
cache 20;

prompt
prompt Creating sequence sq_cabecera_inventario
prompt ========================================
prompt
create sequence PLATINUM.sq_cabecera_inventario
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CABECERA_MOVIMIENTO_CAJA
prompt =============================================
prompt
create sequence PLATINUM.SQ_CABECERA_MOVIMIENTO_CAJA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SQ_CABECERA_ORDEN_TRABAJO
prompt ===========================================
prompt
create sequence PLATINUM.SQ_CABECERA_ORDEN_TRABAJO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CABECERA_PEDIDO
prompt ====================================
prompt
create sequence PLATINUM.SQ_CABECERA_PEDIDO
minvalue 0
maxvalue 999999999999999999999999999
start with 1121
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CABECERA_RECIBO
prompt ====================================
prompt
create sequence PLATINUM.SQ_CABECERA_RECIBO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1005
increment by 1
nocache;

prompt
prompt Creating sequence sq_CabEC_HAB_caja
prompt ===================================
prompt
create sequence PLATINUM.sq_CabEC_HAB_caja
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence sq_Cab_HAB_caja
prompt =================================
prompt
create sequence PLATINUM.sq_Cab_HAB_caja
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CAJA
prompt =========================
prompt
create sequence PLATINUM.SQ_CAJA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CARGO
prompt ==========================
prompt
create sequence PLATINUM.SQ_CARGO
minvalue 100
maxvalue 999999999999999999999999999
start with 129
increment by 1
nocache;

prompt
prompt Creating sequence SQ_CIUDAD
prompt ===========================
prompt
create sequence PLATINUM.SQ_CIUDAD
minvalue 1
maxvalue 999999999999999999999999999
start with 1002
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CLIENTE
prompt ============================
prompt
create sequence PLATINUM.SQ_CLIENTE
minvalue 1000
maxvalue 999999999999999999999999999
start with 1040
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_CLIENTE_SALDO
prompt ==================================
prompt
create sequence PLATINUM.SQ_CLIENTE_SALDO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SQ_COMISION
prompt =============================
prompt
create sequence PLATINUM.SQ_COMISION
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_COMISION_MENS_CAB
prompt ======================================
prompt
create sequence PLATINUM.SQ_COMISION_MENS_CAB
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_COMISION_MENS_DET
prompt ======================================
prompt
create sequence PLATINUM.SQ_COMISION_MENS_DET
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_COSTOS_FIJOS
prompt =================================
prompt
create sequence PLATINUM.SQ_COSTOS_FIJOS
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_DEPOSITO
prompt =============================
prompt
create sequence PLATINUM.SQ_DEPOSITO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SQ_DETALLE_ENTRADA_SALIDA
prompt ===========================================
prompt
create sequence PLATINUM.SQ_DETALLE_ENTRADA_SALIDA
minvalue 100
maxvalue 999999999999999999999999999
start with 101
increment by 1
nocache;

prompt
prompt Creating sequence SQ_DETALLE_FACTURA
prompt ====================================
prompt
create sequence PLATINUM.SQ_DETALLE_FACTURA
minvalue 1
maxvalue 999999999999999999999999999
start with 41
increment by 1
cache 10;

prompt
prompt Creating sequence SQ_DETALLE_FORMULA
prompt ====================================
prompt
create sequence PLATINUM.SQ_DETALLE_FORMULA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SQ_DETALLE_INVENTARIO
prompt =======================================
prompt
create sequence PLATINUM.SQ_DETALLE_INVENTARIO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_DETALLE_MOVIMIENTO_CAJA
prompt ============================================
prompt
create sequence PLATINUM.SQ_DETALLE_MOVIMIENTO_CAJA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SQ_DETALLE_NOTA_CRED_CLIENTE
prompt ==============================================
prompt
create sequence PLATINUM.SQ_DETALLE_NOTA_CRED_CLIENTE
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 10;

prompt
prompt Creating sequence SQ_DETALLE_PEDIDO
prompt ===================================
prompt
create sequence PLATINUM.SQ_DETALLE_PEDIDO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1100
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_DETALLE_RECIBO
prompt ===================================
prompt
create sequence PLATINUM.SQ_DETALLE_RECIBO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1006
increment by 1
nocache;

prompt
prompt Creating sequence SQ_EMPLEADO
prompt =============================
prompt
create sequence PLATINUM.SQ_EMPLEADO
minvalue 100
maxvalue 999999999999999999999999999
start with 120
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_EXISTENCIA
prompt ===============================
prompt
create sequence PLATINUM.SQ_EXISTENCIA
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_FACTURA_COMPRA_CAB
prompt =======================================
prompt
create sequence PLATINUM.SQ_FACTURA_COMPRA_CAB
minvalue 1
maxvalue 999999999999999999999999999
start with 101
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_FACTURA_COMPRA_DET
prompt =======================================
prompt
create sequence PLATINUM.SQ_FACTURA_COMPRA_DET
minvalue 1
maxvalue 999999999999999999999999999
start with 101
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_FORMULA_SEMI_DETALLE
prompt =========================================
prompt
create sequence PLATINUM.SQ_FORMULA_SEMI_DETALLE
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_HISTORICO_COSTO
prompt ====================================
prompt
create sequence PLATINUM.SQ_HISTORICO_COSTO
minvalue 1
maxvalue 999999999999999999999999999
start with 4
increment by 1
nocache;

prompt
prompt Creating sequence SQ_HISTORICO_PRECIO
prompt =====================================
prompt
create sequence PLATINUM.SQ_HISTORICO_PRECIO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SQ_MARCA
prompt ==========================
prompt
create sequence PLATINUM.SQ_MARCA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1009
increment by 1
nocache;

prompt
prompt Creating sequence SQ_NOTA_CREDITO_CLIENTE
prompt =========================================
prompt
create sequence PLATINUM.SQ_NOTA_CREDITO_CLIENTE
minvalue 1000
maxvalue 999999999999999999999999999
start with 1040
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_NOTA_CREDITO_PROV_CAB
prompt ==========================================
prompt
create sequence PLATINUM.SQ_NOTA_CREDITO_PROV_CAB
minvalue 1
maxvalue 999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_NOTA_CREDITO_PROV_DET
prompt ==========================================
prompt
create sequence PLATINUM.SQ_NOTA_CREDITO_PROV_DET
minvalue 1
maxvalue 999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_ORDEN_TRABAJO_DET_COSTO_H
prompt ==============================================
prompt
create sequence PLATINUM.SQ_ORDEN_TRABAJO_DET_COSTO_H
minvalue 1
maxvalue 999999999999999999999999999
start with 114
increment by 1
nocache;

prompt
prompt Creating sequence SQ_ORDEN_TRABAJO_DET_COSTO_M
prompt ==============================================
prompt
create sequence PLATINUM.SQ_ORDEN_TRABAJO_DET_COSTO_M
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_ORDEN_TRAB_DET_COSTO_HOR
prompt =============================================
prompt
create sequence PLATINUM.SQ_ORDEN_TRAB_DET_COSTO_HOR
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_OT_DETALLE
prompt ===============================
prompt
create sequence PLATINUM.SQ_OT_DETALLE
minvalue 1
maxvalue 999999999999999999999999999
start with 434
increment by 1
cache 20;

prompt
prompt Creating sequence Sq_OT_DETALLE
prompt ===============================
prompt
create sequence PLATINUM.Sq_OT_DETALLE
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_PARAMETROS
prompt ===============================
prompt
create sequence PLATINUM.SQ_PARAMETROS
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence sq_PERDIDA
prompt ============================
prompt
create sequence PLATINUM.sq_PERDIDA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_PERDIDAPROD
prompt ================================
prompt
create sequence PLATINUM.SQ_PERDIDAPROD
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SQ_PRESENTACION
prompt =================================
prompt
create sequence PLATINUM.SQ_PRESENTACION
minvalue 1000
maxvalue 999999999999999999999999999
start with 1001
increment by 1
nocache;

prompt
prompt Creating sequence SQ_PRODUCTO
prompt =============================
prompt
create sequence PLATINUM.SQ_PRODUCTO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1024
increment by 1
nocache;

prompt
prompt Creating sequence SQ_PROVEEDOR
prompt ==============================
prompt
create sequence PLATINUM.SQ_PROVEEDOR
minvalue 100
maxvalue 999999999999999999999999999
start with 120
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_RECURSO_ASIGNADO
prompt =====================================
prompt
create sequence PLATINUM.SQ_RECURSO_ASIGNADO
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_SALDO_CLIENTE
prompt ==================================
prompt
create sequence PLATINUM.SQ_SALDO_CLIENTE
minvalue 1
maxvalue 999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_SECCION
prompt ============================
prompt
create sequence PLATINUM.SQ_SECCION
minvalue 100
maxvalue 999999999999999999999999999
start with 120
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_SOLICITUD
prompt ==============================
prompt
create sequence PLATINUM.SQ_SOLICITUD
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_TAREA
prompt ==========================
prompt
create sequence PLATINUM.SQ_TAREA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1000
increment by 1
nocache;

prompt
prompt Creating sequence SQ_TAREA_ASIGNADA
prompt ===================================
prompt
create sequence PLATINUM.SQ_TAREA_ASIGNADA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SQ_TAREA_FALLIDA
prompt ==================================
prompt
create sequence PLATINUM.SQ_TAREA_FALLIDA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_TAREA_FORMULA
prompt ==================================
prompt
create sequence PLATINUM.SQ_TAREA_FORMULA
minvalue 100
maxvalue 999999999999999999999999999
start with 100
increment by 1
nocache;

prompt
prompt Creating sequence SQ_TIPO_COMPROBANTE
prompt =====================================
prompt
create sequence PLATINUM.SQ_TIPO_COMPROBANTE
minvalue 50
maxvalue 99999999999999999999
start with 50
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_TIPO_PRODUCTO
prompt ==================================
prompt
create sequence PLATINUM.SQ_TIPO_PRODUCTO
minvalue 1000
maxvalue 999999999999999999999999999
start with 1001
increment by 1
nocache;

prompt
prompt Creating sequence SQ_UNIDAD_MEDIDA
prompt ==================================
prompt
create sequence PLATINUM.SQ_UNIDAD_MEDIDA
minvalue 1000
maxvalue 999999999999999999999999999
start with 1001
increment by 1
nocache;

prompt
prompt Creating sequence SQ_VENTA_COMISION_MENSUAL
prompt ===========================================
prompt
create sequence PLATINUM.SQ_VENTA_COMISION_MENSUAL
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating view V_CLIENTES_SALDOS
prompt ===============================
prompt
create or replace view platinum.v_clientes_saldos as
select "ORDEN","COD_CLIENTE","DESC_TIPO_COMPROBANTE","NRO_COMPROBANTE","COD_COMPROBANTE","NRO_CUOTA","FEC_VENCIMIENTO","TOTAL_COMPROBANTE","SALDO_COMPROBANTE", "COD_SALDO_CLIENTE"
from (
 /*Facturas*/
select 0 as orden,
     c.cod_cliente as cod_cliente,
     t.desc_tipo_abreviado  as desc_tipo_comprobante,
     f.establecimiento      ||'-'||
     f.boca_expendio        ||'-'||
     lpad(to_char(f.numero_factura), 10, '0') as nro_comprobante,
     f.numero_factura    as cod_comprobante,
     s.nro_cuota         as nro_cuota,
     s.fecha_vencimiento as fec_vencimiento,
     s.monto_cuota       as total_comprobante,
     s.saldo_cuota       as saldo_comprobante,
     s.cod_saldo_cliente as cod_saldo_cliente
 from saldo_cliente s, factura_cabecera f, cliente c, tipo_comprobante t
where f.tipo_factura = s.tipo_comprobante
 and f.estado_factura != 'ANULADO'
 and s.saldo_cuota > 0
 and f.cod_factura  = s.nro_comprobante
 and c.cod_cliente = s.cod_cliente
 and t.cod_tipo = s.tipo_comprobante
group by 0,
       c.cod_cliente,
       t.desc_tipo_abreviado,
       f.establecimiento||'-'||f.boca_expendio||'-'||lpad(to_char(f.numero_factura), 10, '0'),
       f.numero_factura,
       s.nro_cuota,
       s.fecha_vencimiento,
       s.monto_cuota,
       s.saldo_cuota,
     s.cod_saldo_cliente
 union all
 /*Notas de credito aun no aplicadas a ninguna factura o aplicadas parcialmente*/
select 1 as orden,
     c.cod_cliente,
     t.desc_tipo_abreviado as desc_tipo_comprobante,
     n.establecimiento||'-'||n.boca_expendio||'-'||lpad(to_char(n.num_nota_credto_cliente), 10, '0') as nro_comprobante,
     n.num_nota_credto_cliente,
     s.nro_cuota,
     s.fecha_vencimiento,
     s.monto_cuota,
     s.saldo_cuota,
     s.cod_saldo_cliente as cod_saldo_cliente
 from saldo_cliente s, nota_credito_cli_cabecera n, cliente c, tipo_comprobante t
where s.saldo_cuota < 0
 and n.estado != 'ANULADO'
 and n.tipo = s.tipo_comprobante
 and n.cod_nota_credito_cliente  = s.nro_comprobante
 and c.cod_cliente = s.cod_cliente
 and t.cod_tipo = s.tipo_comprobante
group by 1,
       c.cod_cliente,
       t.desc_tipo_abreviado,
       n.establecimiento||'-'||n.boca_expendio||'-'||lpad(to_char(n.num_nota_credto_cliente), 10, '0'),
       n.num_nota_credto_cliente,
       s.nro_cuota,
       s.fecha_vencimiento,
       s.monto_cuota,
       s.saldo_cuota,
     s.cod_saldo_cliente
 ) aux

order by aux.cod_cliente,
         aux.orden,
        aux.desc_tipo_comprobante,
        aux.nro_comprobante,
        aux.nro_cuota,
        aux.fec_vencimiento,
        aux.nro_comprobante,
        aux.orden asc
/

prompt
prompt Creating view V_TAREAS_EMPLEADO
prompt ===============================
prompt
create or replace view platinum.v_tareas_empleado as
select p.cod_empleado as cod_empleado, t.cod_tarea as cod_tarea, p.cantidad as cantidad, p.fecha as fecha from produccion_diaria p
join tarea_asignada ta on p.cod_tarea_asignada = ta.cod_tarea_asignada
join tarea t on t.cod_tarea = ta.cod_tarea
/

prompt
prompt Creating view V_TAREAS_FALLIDAS_EMPLEADO
prompt ========================================
prompt
create or replace view platinum.v_tareas_fallidas_empleado as
select tf.cod_empleado as cod_empleado, t.cod_tarea as cod_tarea, tf.cantidad as cantidad, tf.fecha as fecha
from
tarea_fallida tf
join tarea_asignada ta on tf.cod_tarea_asignada = ta.cod_tarea_asignada
join tarea t on t.cod_tarea = ta.cod_tarea
/

prompt
prompt Creating function NUMTOLETRAS
prompt =============================
prompt
CREATE OR REPLACE FUNCTION PLATINUM.NUMTOLETRAS(Numero Number) RETURN Varchar2 IS
  TYPE Textos IS TABLE OF Varchar2(20) INDEX BY BINARY_INTEGER;
  Texto         Textos;
  Letras        Varchar2(255) := '';
  I             BINARY_INTEGER := 0;
  EnTexto       Varchar2(255);
  Unidad        Varchar2(255);
  Grupo         Varchar2(255);
  TextoCentena  Varchar2(255);
  TextoDecena   Varchar2(255);
  TextoUnidad   Varchar2(255);
  Y             Varchar2(255);
  Decimales     Varchar2(255);
  DigitoCentena Number;
  DigitoDecena  Number;
  DigitoUnidad  Number;

BEGIN
  Texto(0) := 'UN ';
  Texto(1) := 'UNO ';
  Texto(2) := 'DOS ';
  Texto(3) := 'TRES ';
  Texto(4) := 'CUATRO ';
  Texto(5) := 'CINCO ';
  Texto(6) := 'SEIS ';
  Texto(7) := 'SIETE ';
  Texto(8) := 'OCHO ';
  Texto(9) := 'NUEVE ';
  Texto(10) := 'DIEZ ';
  Texto(11) := 'VEINTE ';
  Texto(12) := 'TREINTA ';
  Texto(13) := 'CUARENTA ';
  Texto(14) := 'CINCUENTA ';
  Texto(15) := 'SESENTA ';
  Texto(16) := 'SETENTA ';
  Texto(17) := 'OCHENTA ';
  Texto(18) := 'NOVENTA ';
  Texto(19) := 'ONCE ';
  Texto(20) := 'DOCE ';
  Texto(21) := 'TRECE ';
  Texto(22) := 'CATORCE ';
  Texto(23) := 'QUINCE ';
  Texto(24) := 'CIEN ';
  Texto(25) := 'CIENTO ';
  Texto(26) := 'DOSCIENTOS ';
  Texto(27) := 'TRESCIENTOS ';
  Texto(28) := 'CUATROCIENTOS ';
  Texto(29) := 'QUINIENTOS ';
  Texto(30) := 'SEISCIENTOS ';
  Texto(31) := 'SETECIENTOS ';
  Texto(32) := 'OCHOCIENTOS ';
  Texto(33) := 'NOVECIENTOS ';
  Texto(34) := 'MIL ';
  Texto(35) := 'MILLON ';
  Texto(36) := 'MILLONES ';

  EnTexto := ltrim(rtrim(TO_CHAR(TRUNC(Numero), '99999999999'))); -- Convirtiendo el numero a un string de 12 posiciones.
  EnTexto := lpad(EnTexto, 12, '0'); --Rellena de 0's

  -- Este ciclo recorre el numero de tres en tres posiciones. 
  FOR I IN 1 .. 4 LOOP Grupo := SUBSTR(EnTexto,
  I * 3 - 2,
  3); -- Obtiene el grupo de tres digitos segun el contador del ciclo.

  -- Establece las unidades a usar: “mil'' o “millon''
  IF I = 1 or I = 3 THEN
    Unidad := Texto(34);
  ELSE
    If I = 2 THEN
      IF TO_NUMBER(Grupo) = 1 THEN
        Unidad := Texto(35);
      ELSE
        Unidad := Texto(36);
      END IF;
    ELSE
      Unidad := '';
    END IF;
  END IF;

  -- Si hay un numero el grupo lo evalua, sino sigue con el siguiente grupo.
  If TO_NUMBER(Grupo) > 0 Then
    If TO_NUMBER(Grupo) = 1 Then
      -- Por los casos de “mil'' o “un millon'' se evalua cuando el valor sea 1.
      IF I = 2 THEN
        TextoUnidad := Texto(0);
      ELSE
        IF I = 4 THEN
          TextoUnidad := Texto(1);
        ELSE
          TextoUnidad := '';
        END IF;
      END IF;
      Letras := Letras || TextoUnidad || Unidad;
    ELSE
      --                        ' Los demas casos que no son 1.
      -- Se asignan a variables cada digito del grupo de tres.
      DigitoCentena := TO_NUMBER(SUBSTR(Grupo, 1, 1));
      DigitoDecena  := TO_NUMBER(SUBSTR(Grupo, 2, 1));
      DigitoUnidad  := TO_NUMBER(SUBSTR(Grupo, 3, 1));
    
      -- Si hay algo en los cientos lo analiza sino lo deja pasar.
      If DigitoCentena <> 0 Then
        -- En el caso que sea 100 le asigna de una vez, sino el texto que le corresponde segun la
        -- posicion en el vector.
        IF Grupo = '100' THEN
          TextoCentena := Texto(24);
        ELSE
          TextoCentena := Texto(24 + DigitoCentena);
        END IF;
      End If;
    
      -- Analiza sino se encuentra entre el 11 y el 15.
      If DigitoDecena = 1 And DigitoUnidad >= 1 And DigitoUnidad <= 5 Then
        TextoDecena := Texto(18 + DigitoUnidad);
        TextoUnidad := NULL;
        Y           := NULL;
      
        -- Evalua Los demas numeros fuera del 11 al 15.
      Else
        -- Si hay numero en las decenas asigna la posicion correspondiente en el vector.
        IF DigitoDecena <> 0 THEN
          TextoDecena := Texto(9 + DigitoDecena);
        ELSE
          TextoDecena := '';
        END IF;
      
        -- Si hay numero en las unidades asigna la posicion correspondiente en el vector.
        IF DigitoUnidad <> 0 THEN
          TextoUnidad := Texto(DigitoUnidad);
        ELSE
          TextoUnidad := '';
        END IF;
      
        -- Evalua si hay que conectar con “y''.
        IF DigitoUnidad > 0 AND DigitoDecena > 0 THEN
          Y := 'Y ';
        ELSE
          Y := '';
        END IF;
      End If;
      -- Une los textos generados en este grupo y los va agregando al resultado
      -- de la funcion letras.
      Letras := Letras || TextoCentena || TextoDecena || Y || TextoUnidad ||
                Unidad;
    
    END IF;
  END IF;

END LOOP;

--Evalua si hay decimales.
IF   TRUNC(Numero) = Numero THEN Decimales := ' ';
ELSE Decimales := 'CON ' ||
                  SUBSTR(TO_CHAR(Numero, '99999999999.99'), 14, 2) || '/00';
END IF;
--Une los decimales al valor de retorno de la funcion.
Letras := Letras || Decimales;

RETURN Letras; EXCEPTION WHEN OTHERS THEN RETURN 'NO CONVERTIDO'; END;
/


spool off
