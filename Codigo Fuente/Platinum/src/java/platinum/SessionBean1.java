
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.convert.DateTimeConverter;
import py.com.platinum.controller.BancoController;
import py.com.platinum.controller.CajaController;
import py.com.platinum.controller.CargoController;
import py.com.platinum.controller.CiudadController;
import py.com.platinum.controller.ClienteController;
import py.com.platinum.controller.ComisionController;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.FormaPagoController;
import py.com.platinum.controller.DepositoController;
import py.com.platinum.controller.FacturaCabeceraController;
import py.com.platinum.controller.FacturaCompraCabController;
import py.com.platinum.controller.FormulaCabeceraController;
import py.com.platinum.controller.FormulaSemiCabeceraController;
import py.com.platinum.controller.MaquinariaController;
import py.com.platinum.controller.MarcaController;
import py.com.platinum.controller.OrdenTrabajoCabeceraController;
import py.com.platinum.controller.OrdenTrabajoDetalleController;
import py.com.platinum.controller.PedidoCabeceraController;
import py.com.platinum.controller.PresentacionController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.SeccionController;
import py.com.platinum.controller.ProveedorController;
import py.com.platinum.controller.SolicitudInternaController;
import py.com.platinum.controller.TareaAsignadaController;
import py.com.platinum.controller.TareaController;
import py.com.platinum.controller.TareaFallidaController;
import py.com.platinum.controller.TipoComprobanteController;
import py.com.platinum.controller.TipoProductoController;
import py.com.platinum.controller.UnidadMedidaController;
import py.com.platinum.controller.VentaComisionMensualController;
import py.com.platinum.controller.UsuarioController;
import py.com.platinum.entity.Banco;
import py.com.platinum.entity.Caja;
import py.com.platinum.entity.Cargo;
import py.com.platinum.entity.Ciudad;
import py.com.platinum.entity.Cliente;
import py.com.platinum.entity.Comision;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.FormaPago;
import py.com.platinum.entity.Deposito;
import py.com.platinum.entity.FacturaCabecera;
import py.com.platinum.entity.FacturaCompraCab;
import py.com.platinum.entity.FormulaCabecera;
import py.com.platinum.entity.FormulaSemiCabecera;
import py.com.platinum.entity.Maquinarias;
import py.com.platinum.entity.Marca;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.PedidoCabecera;
import py.com.platinum.entity.Presentacion;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.Seccion;
import py.com.platinum.entity.Proveedor;
import py.com.platinum.entity.SolicitudInterna;
import py.com.platinum.entity.Tarea;
import py.com.platinum.entity.TareaAsignada;
import py.com.platinum.entity.TareaFallida;
import py.com.platinum.entity.TipoComprobante;
import py.com.platinum.entity.TipoProducto;
import py.com.platinum.entity.UnidadMedida;
import py.com.platinum.entity.VentaComisionMensual;
import py.com.platinum.entity.Usuarios;
import py.com.platinum.utilsenum.FacturaCompraEstado;
import py.com.platinum.utilsenum.ModuloEnum;
import py.com.platinum.utilsenum.PedidoVentaEstado;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version SessionBean1.java
 * @version Created on 17-oct-2009, 15:17:26
 * @author MartinJara
 */
public class SessionBean1 extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SessionBean1() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     * 
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("SessionBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here

        this.tituloPagina = "Bienvenidos al Sistema";
        usuario = "Admin";
        dateTimeConverter.setPattern("dd/MM/yyyy");
        dateTimeConverter.setTimeZone(null);
        dateTimeConverterFull.setPattern("dd/MM/yyyy HH:mm:ss");
        dateTimeConverterFull.setTimeZone(null);

        codDeposito = new DepositoController().findById(Long.valueOf("1"));

        //El siguiente Metodo Carga la Grilla De Productos al cargar la pagina de productos.
        cargarListaTodosUsuarios();
        cargarListaTodosProductosSemiterminadosAcabados();
        cargarListaTodosProductosTerSemiInsMat();
        cargarListaTodosMaquinarias();
        cargarListaTodosDepositos();
        cargarListaTodasTareasAsignadasProdDiaria();
        cargarListaTodosOrdenTrabajoDetallesProdDiaria();
        cargarListaTodosProductos();
        cargarListaVentaComisionMensual();
        cargarListaTodosOTCab();
        cargarListaTodosTareas();
        cargarListaTodosTareasFallidas();
        cargarListaTodosFormulaCabecerasTer();
        cargarListaTodosEmpleados();
        cargarListaTodosFormulaCabecerasSemiTer();
        cargarListaTodosProductosSemiterminados();
        cargarListaTodosGenericos();
        cargarListaTodosInsumosMaterias();
        cargarListaTodosMarcas();
        cargarListaTodosTipoProductos();
        cargarListaTodosPresentacions();
        cargarListaTodosUnidadMedidas();
        cargarListaCiudad();
        cargarListaCargo();
        cargarListaSeccion();
        cargarListaBanco();
        cargarListaFormaPago();
        cargarListaCaja();
        cargarListaComision();
        cargarListaCliente();
        cargarListaSolictud();
        cargarListaTipoComprobante();
        cargarListaPedidoVenta(null, PedidoVentaEstado.PENDIENTE);
        cargarListaFacturaCompra(null, FacturaCompraEstado.RECIBIDO);
        cargarListaFacturaVenta(null);
        cargarListaTodosProductosTerminados();
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     * 
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    @Override
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     * 
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    @Override
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }
    private String tituloPagina;
    private String detallePagina;
    private String establecimiento = "001";
    private String bocaExpendio = "001";
    private Deposito codDeposito;
    private String codEmpleado = "1";
    private String usuario = "Admin";

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }



    public Deposito getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(Deposito codDeposito) {
        this.codDeposito = codDeposito;
    }

    public String getBocaExpendio() {
        return bocaExpendio;
    }

    public void setBocaExpendio(String bocaExpendio) {
        this.bocaExpendio = bocaExpendio;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getDetallePagina() {
        return detallePagina;
    }

    public String getTituloPagina() {
        return tituloPagina;
    }

    public void setDetallePagina(String detallePagina) {
        this.detallePagina = detallePagina;
    }

    public void setTituloPagina(String tituloPagina) {
        this.tituloPagina = tituloPagina;
    }
////// CARGA DE COMBO BOX PRODUCTOS
    Producto[] listaProductos;
    Option[] listaProductosOp;

    public Option[] getListaProductosOp() {
        return listaProductosOp;
    }

    public void setListaProductosOp(Option[] listaProductosOp) {
        this.listaProductosOp = listaProductosOp;
    }

    public Producto[] getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(Producto[] listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void cargarListaTodosProductos() {
        ProductoController productoController = new ProductoController();
        listaProductos = (Producto[]) productoController.getAll("descripcion").toArray(new Producto[0]);
        listaProductosOp = new Option[listaProductos.length];
        Option option;
        for (int i = 0; i < listaProductos.length; i++) {
            Producto p = listaProductos[i];
            option = new Option();
            option.setLabel(p.getDescripcion());
            option.setValue(p.getCodProducto().toString());
            listaProductosOp[i] = option;
        }

    }




    ////// CARGA DE COMBO BOX PRODUCTOS TERMINADOS
    Producto[] listaProductosTerminados;
    Option [] listaProductosTerminadosOp;

    public Option[] getListaProductosTerminadosOp() {
        return listaProductosTerminadosOp;
    }

    public void setListaProductosTerminadosOp(Option[] listaProductosTerminadosOp) {
        this.listaProductosTerminadosOp = listaProductosTerminadosOp;
    }

    public Producto[] getListaProductosTerminados() {
        return listaProductosTerminados;
    }

    public void setListaProductosTerminados(Producto[] listaProductosTerminados) {
        this.listaProductosTerminados = listaProductosTerminados;
    }

    public void cargarListaTodosProductosTerminados() {
        ProductoController productoController = new ProductoController();
        listaProductosTerminados = (Producto[]) productoController.getAllFiltered(null,null,"Terminado",null).toArray(new Producto[0]);
        listaProductosTerminadosOp = new Option[listaProductosTerminados.length];
        Option option;
        for (int i = 0; i < listaProductosTerminados.length; i++) {
            Producto p = listaProductosTerminados[i];
            option = new Option();
            option.setLabel(p.getDescripcion());
            option.setValue(p.getCodProducto().toString());
            listaProductosTerminadosOp[i] = option;
        }

    }

 ////// CARGA DE COMBO BOX PRODUCTOS TERMINADOS
    Producto[] listaProductosTerSemiInsMat;
    Option [] listaProductosTerSemiInsMatOp;

    public Producto[] getListaProductosTerSemiInsMat() {
        return listaProductosTerSemiInsMat;
    }

    public void setListaProductosTerSemiInsMat(Producto[] listaProductosTerSemiInsMat) {
        this.listaProductosTerSemiInsMat = listaProductosTerSemiInsMat;
    }

    public Option[] getListaProductosTerSemiInsMatOp() {
        return listaProductosTerSemiInsMatOp;
    }

    public void setListaProductosTerSemiInsMatOp(Option[] listaProductosTerSemiInsMatOp) {
        this.listaProductosTerSemiInsMatOp = listaProductosTerSemiInsMatOp;
    }


    public void cargarListaTodosProductosTerSemiInsMat() {
        ProductoController productoController = new ProductoController();
        listaProductosTerSemiInsMat = (Producto[]) productoController.getInsumosMateriasFinalesSemiter(null,null,null).toArray(new Producto[0]);
        listaProductosTerSemiInsMatOp = new Option[listaProductosTerSemiInsMat.length];
        Option option;
        for (int i = 0; i < listaProductosTerSemiInsMat.length; i++) {
            Producto p = listaProductosTerSemiInsMat[i];
            option = new Option();
            option.setLabel(p.getDescripcion());
            option.setValue(p.getCodProducto().toString());
            listaProductosTerSemiInsMatOp[i] = option;
        }

    }


////// CARGA DE COMBO BOX PRODUCTOS SEMITERMINADOS
    Producto[] listaProductosSemiterminadosAcabados;

    public Producto[] getListaProductosSemiterminadosAcabados() {
        return listaProductosSemiterminadosAcabados;
    }

    public void setListaProductosSemiterminadosAcabados(Producto[] listaProductosSemiterminadosAcabados) {
        this.listaProductosSemiterminadosAcabados = listaProductosSemiterminadosAcabados;
    }

    public void cargarListaTodosProductosSemiterminadosAcabados() {
        ProductoController productoController = new ProductoController();
        listaProductosSemiterminadosAcabados = (Producto[]) productoController.getSemiAcabado(null, null, null).toArray(new Producto[0]);

    }
////// CARGA DE COMBO BOX PRODUCTOS SEMITERMINADOS
    Producto[] listaProductosSemiterminados;

    public Producto[] getListaProductosSemiterminados() {
        return listaProductosSemiterminados;
    }

    public void setListaProductosSemiterminados(Producto[] listaProductosSemiterminados) {
        this.listaProductosSemiterminados = listaProductosSemiterminados;
    }

    public void cargarListaTodosProductosSemiterminados() {
        ProductoController productoController = new ProductoController();
        listaProductosSemiterminados = (Producto[]) productoController.getAllFiltered(null, null, "SemiTerminado", null).toArray(new Producto[0]);


    }

    ////// CARGA DE COMBO BOX Insumos Y materias Primas
    Producto[] listaInsumosMaterias;

    public Producto[] getListaInsumosMaterias() {
        return listaInsumosMaterias;
    }

    public void setListaInsumosMaterias(Producto[] listaInsumosMaterias) {
        this.listaInsumosMaterias = listaInsumosMaterias;
    }

    public void cargarListaTodosInsumosMaterias() {
        ProductoController productoController = new ProductoController();
        listaInsumosMaterias = (Producto[]) productoController.getInsumosMaterias(null, null, null).toArray(new Producto[0]);
    }
////// CARGA DE COMBO BOX MARCAS
    ////// CARGA DE COMBO BOX Insumos Y materias Primas
    Producto[] listaGenericos;

    public Producto[] getListaGenericos() {
        return listaGenericos;
    }

    public void setListaGenericos(Producto[] listaGenericos) {
        this.listaGenericos = listaGenericos;
    }

    public void cargarListaTodosGenericos() {
        ProductoController productoController = new ProductoController();
        listaGenericos= (Producto[]) productoController.getAllFiltered(null, null, "ProductoGenerico", null).toArray(new Producto[0]);
    }
////// CARGA DE COMBO BOX MARCAS
//////     import com.sun.webui.jsf.model.Option;
    Marca[] listaMarcas;
    Option[] listaMarcasOp;

    public Option[] getListaMarcasOp() {
        return listaMarcasOp;
    }

    public void setListaMarcasOp(Option[] listaMarcasOp) {
        this.listaMarcasOp = listaMarcasOp;
    }

    public Marca[] getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(Marca[] listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public void cargarListaTodosMarcas() {
        MarcaController MarcaController = new MarcaController();
        listaMarcas = (Marca[]) MarcaController.getAll("nombre").toArray(new Marca[0]);
        listaMarcasOp = new Option[listaMarcas.length];
        Option option;
        for (int i = 0; i < listaMarcas.length; i++) {
            Marca m = listaMarcas[i];
            option = new Option();
            option.setLabel(m.getNombre());
            option.setValue(m.getCodMarca().toString());
            listaMarcasOp[i] = option;
        }
    }
////// FIN CARGA DE COMBO BOX MARCAS
    ////// CARGA DE COMBO BOX TipoProductoS
//////     import com.sun.webui.jsf.model.Option;
    TipoProducto[] listaTipoProductos;
    Option[] listaTipoProductosOp;

    public Option[] getListaTipoProductosOp() {
        return listaTipoProductosOp;
    }

    public void setListaTipoProductosOp(Option[] listaTipoProductosOp) {
        this.listaTipoProductosOp = listaTipoProductosOp;
    }

    public TipoProducto[] getListaTipoProductos() {
        return listaTipoProductos;
    }

    public void setListaTipoProductos(TipoProducto[] listaTipoProductos) {
        this.listaTipoProductos = listaTipoProductos;
    }

    public void cargarListaTodosTipoProductos() {
        TipoProductoController TipoProductoController = new TipoProductoController();
        listaTipoProductos = (TipoProducto[]) TipoProductoController.getAll("descripcion").toArray(new TipoProducto[0]);
        listaTipoProductosOp = new Option[listaTipoProductos.length];
        Option option;
        for (int i = 0; i < listaTipoProductos.length; i++) {
            TipoProducto tp = listaTipoProductos[i];
            option = new Option();
            option.setLabel(tp.getDescripcion());
            option.setValue(tp.getCodTipoProducto().toString());
            listaTipoProductosOp[i] = option;
        }
    }
////// FIN CARGA DE COMBO BOX TipoProductoS

////// CARGA DE COMBO BOX UnidadMedida
//////     import com.sun.webui.jsf.model.Option;
    UnidadMedida[] listaUnidadMedidas;
    Option[] listaUnidadMedidasOp;

    public Option[] getListaUnidadMedidasOp() {
        return listaUnidadMedidasOp;
    }

    public void setListaUnidadMedidasOp(Option[] listaUnidadMedidasOp) {
        this.listaUnidadMedidasOp = listaUnidadMedidasOp;
    }

    public UnidadMedida[] getListaUnidadMedidas() {
        return listaUnidadMedidas;
    }

    public void setListaUnidadMedidas(UnidadMedida[] listaUnidadMedidas) {
        this.listaUnidadMedidas = listaUnidadMedidas;
    }

    public void cargarListaTodosUnidadMedidas() {
        UnidadMedidaController UnidadMedidaController = new UnidadMedidaController();
        listaUnidadMedidas = (UnidadMedida[]) UnidadMedidaController.getAll("descripcion").toArray(new UnidadMedida[0]);
        listaUnidadMedidasOp = new Option[listaUnidadMedidas.length];
        Option option;
        for (int i = 0; i < listaUnidadMedidas.length; i++) {
            UnidadMedida tp = listaUnidadMedidas[i];
            option = new Option();
            option.setLabel(tp.getDescripcion());
            option.setValue(tp.getCodUnidadMedida().toString());
            listaUnidadMedidasOp[i] = option;
        }
    }
////// FIN CARGA DE COMBO BOX UnidadMedidaS
////// CARGA DE COMBO BOX Presentacion
//////     import com.sun.webui.jsf.model.Option;
    Presentacion[] listaPresentacions;
    Option[] listaPresentacionsOp;

    public Option[] getListaPresentacionsOp() {
        return listaPresentacionsOp;
    }

    public void setListaPresentacionsOp(Option[] listaPresentacionsOp) {
        this.listaPresentacionsOp = listaPresentacionsOp;
    }

    public Presentacion[] getListaPresentacions() {
        return listaPresentacions;
    }

    public void setListaPresentacions(Presentacion[] listaPresentacions) {
        this.listaPresentacions = listaPresentacions;
    }

    public void cargarListaTodosPresentacions() {
        PresentacionController PresentacionController = new PresentacionController();
        listaPresentacions = (Presentacion[]) PresentacionController.getAll("descripcion").toArray(new Presentacion[0]);
        listaPresentacionsOp = new Option[listaPresentacions.length];
        Option option;
        for (int i = 0; i < listaPresentacions.length; i++) {
            Presentacion tp = listaPresentacions[i];
            option = new Option();
            option.setLabel(tp.getDescripcion());
            option.setValue(tp.getCodPresentacion().toString());
            listaPresentacionsOp[i] = option;
        }
    }
    private Long id;

    public Long getId() {
        return id;
    }

    /// Se define esta variable ID para hacer la busqueda del objeto a actualizar en la actualizacion de los abm
    public void setId(Long id) {
        this.id = id;
    }
    //Cargar lista Seccion
    Seccion[] listaSeccion;
    Option[] listaSeccionOption;

    public Seccion[] getListaSeccion() {
        return listaSeccion;
    }

    public void setListaSeccion(Seccion[] listaSeccion) {
        this.listaSeccion = listaSeccion;
    }

    public Option[] getListaSeccionOption() {
        return listaSeccionOption;
    }

    public void setListaSeccionOption(Option[] listaSeccionOption) {
        this.listaSeccionOption = listaSeccionOption;
    }

    /**
     * Obtenemos la lista de Seccion de la base de datos
     */
    public void cargarListaSeccion() {
        //Variables
        SeccionController SeccionController = new SeccionController();
        Option o;

        //Obtenemos la lista de Seccion ordenado por nombre del Seccion
        listaSeccion = (Seccion[]) SeccionController.getAll("nombreSeccion").toArray(new Seccion[0]);

        //Dimensionamos el array de options para la lista de Seccions
        listaSeccionOption = new Option[listaSeccion.length];

        //Recorremos la lista de Seccions
        for (int i = 0; i < listaSeccion.length; i++) {
            //Optenemos el Seccion
            Seccion e = listaSeccion[i];

            //Creamos nuevo options
            o = new Option();
            o.setValue(e.getCodSeccion().toString());
            o.setLabel(e.getNombreSeccion());

            //agregamos option al array de option - Seccion
            listaSeccionOption[i] = o;
        }
    }

    //Cargar lista Cargo
    Cargo[] listaCargo;
    Option[] listaCargoOption;

    public Cargo[] getListaCargo() {
        return listaCargo;
    }

    public void setListaCargo(Cargo[] listaCargo) {
        this.listaCargo = listaCargo;
    }

    public Option[] getListaCargoOption() {
        return listaCargoOption;
    }

    public void setListaCargoOption(Option[] listaCargoOption) {
        this.listaCargoOption = listaCargoOption;
    }

    /**
     * Obtenemos la lista de Cargo de la base de datos
     */
    public void cargarListaCargo() {
        //Variables
        CargoController CargoController = new CargoController();
        Option o;

        //Obtenemos la lista de Cargo ordenado por nombre del Cargo
        listaCargo = (Cargo[]) CargoController.getAll("nombreCargo").toArray(new Cargo[0]);

        //Dimensionamos el array de options para la lista de Cargos
        listaCargoOption = new Option[listaCargo.length];

        //Recorremos la lista de Cargos
        for (int i = 0; i < listaCargo.length; i++) {
            //Optenemos el Cargo
            Cargo e = listaCargo[i];

            //Creamos nuevo options
            o = new Option();
            o.setValue(e.getCodCargo().toString());
            o.setLabel(e.getNombreCargo());

            //agregamos option al array de option - Cargo
            listaCargoOption[i] = o;
        }
    }

    //Cargar lista Banco
    Banco[] listaBanco;

    public Banco[] getListaBanco() {
        return listaBanco;
    }

    public void setListaBanco(Banco[] listaBanco) {
        this.listaBanco = listaBanco;
    }

    /**
     * Obtenemos la lista de Banco de la base de datos
     */
    public void cargarListaBanco() {
        //Variables
        BancoController BancoController = new BancoController();

        //Obtenemos la lista de Banco ordenado por nombre del Banco
        listaBanco = (Banco[]) BancoController.getAll("nombreBanco").toArray(new Banco[0]);
    }

    //Cargar lista VentaComisionMensual
    VentaComisionMensual[] listaVentaComisionMensual;

    public VentaComisionMensual[] getListaVentaComisionMensual() {
        return listaVentaComisionMensual;
    }

    public void setListaVentaComisionMensual(VentaComisionMensual[] listaVentaComisionMensual) {
        this.listaVentaComisionMensual = listaVentaComisionMensual;
    }


    /**
     * Obtenemos la lista de VentaComisionMensual de la base de datos
     */
    public void cargarListaVentaComisionMensual() {
        //Variables
        VentaComisionMensualController VentaComisionMensualController = new VentaComisionMensualController();

        //Obtenemos la lista de VentaComisionMensual ordenado por nombre del VentaComisionMensual
        listaVentaComisionMensual = (VentaComisionMensual[]) VentaComisionMensualController.getAll("anio").toArray(new VentaComisionMensual[0]);
    }

    //Cargar lista FormaPago
    FormaPago[] listaFormaPago;

    public FormaPago[] getListaFormaPago() {
        return listaFormaPago;
    }

    public void setListaFormaPago(FormaPago[] listaFormaPago) {
        this.listaFormaPago = listaFormaPago;
    }

    /**
     * Obtenemos la lista de FormaPago de la base de datos
     */
    public void cargarListaFormaPago() {
        //Variables
        FormaPagoController FormaPagoController = new FormaPagoController();

        //Obtenemos la lista de FormaPago ordenado por nombre del FormaPago
        listaFormaPago = (FormaPago[]) FormaPagoController.getAll("nombreFormaPago").toArray(new FormaPago[0]);
    }

    //Cargar lista Caja
    Caja[] listaCaja;

    public Caja[] getListaCaja() {
        return listaCaja;
    }

    public void setListaCaja(Caja[] listaCaja) {
        this.listaCaja = listaCaja;
    }

    /**
     * Obtenemos la lista de Caja de la base de datos
     */
    public void cargarListaCaja() {
        //Variables
        CajaController CajaController = new CajaController();

        //Obtenemos la lista de Caja ordenado por nombre del Caja
        listaCaja = (Caja[]) CajaController.getAll("nombreCaja").toArray(new Caja[0]);
    }

    //Cargar lista Comision
    Comision[] listaComision;

    public Comision[] getListaComision() {
        return listaComision;
    }

    public void setListaComision(Comision[] listaComision) {
        this.listaComision = listaComision;
    }

    /**
     * Obtenemos la lista de Comision de la base de datos
     */
    public void cargarListaComision() {
        //Variables
        ComisionController ComisionController = new ComisionController();

        //Obtenemos la lista de Comision ordenado por nombre del Comision
        listaComision = (Comision[]) ComisionController.getAll("codProducto.descripcion").toArray(new Comision[0]);
    }

    private DateTimeConverter dateTimeConverter = new DateTimeConverter();
    private DateTimeConverter dateTimeConverterFull = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverterFull() {
        return dateTimeConverterFull;
    }

    public void setDateTimeConverterFull(DateTimeConverter dateTimeConverterFull) {
        this.dateTimeConverterFull = dateTimeConverterFull;
    }

    public DateTimeConverter getDateTimeConverter() {
        return dateTimeConverter;
    }

    public void setDateTimeConverter1(DateTimeConverter dtc) {
        this.dateTimeConverter = dtc;
    }

    //Cargar lista Cliente
    Cliente[] listaCliente;

    public Cliente[] getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(Cliente[] listaCliente) {
        this.listaCliente = listaCliente;
    }

    /**
     * Obtenemos la lista de Cliente de la base de datos
     */
    public void cargarListaCliente() {
        //Variables
        ClienteController ClienteController = new ClienteController();

        //Obtenemos la lista de Cliente ordenado por nombre del Cliente
        listaCliente = (Cliente[]) ClienteController.getAll("apellidoCliente, o.nombreCliente").toArray(new Cliente[0]);
    }
    Empleado[] listaEmpleados;
    Option[] listaEmpleadosOp;

    public Option[] getListaEmpleadosOp() {
        return listaEmpleadosOp;
    }

    public void setListaEmpleadosOp(Option[] listaEmpleadosOp) {
        this.listaEmpleadosOp = listaEmpleadosOp;
    }


    public Empleado[] getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(Empleado[] listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void cargarListaTodosEmpleados() {
        EmpleadoController EmpleadoController = new EmpleadoController();
        listaEmpleados = (Empleado[]) EmpleadoController.getAll("apellidoEmpleado").toArray(new Empleado[0]);

        listaEmpleadosOp = new Option[listaEmpleados.length];
        Option option;
        for (int i = 0; i < listaEmpleados.length; i++) {
            Empleado em = listaEmpleados[i];
            option = new Option();
            option.setLabel(em.getNombreEmpleado()+" "+em.getApellidoEmpleado());
            option.setValue(em.getCodEmpleado().toString());
            listaEmpleadosOp[i] = option;
        }
    }
    ////// CARGA DE COMBO BOX Tareas
//////     import com.sun.webui.jsf.model.Option;
    Tarea[] listaTareas;
    Option[] listaTareasOp;

    public Option[] getListaTareasOp() {
        return listaUnidadMedidasOp;
    }

    public void setListaTareasOp(Option[] listaTareasOp) {
        this.listaTareasOp = listaTareasOp;
    }

    public Tarea[] getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(Tarea[] listaTareas) {
        this.listaTareas = listaTareas;
    }

    public void cargarListaTodosTareas() {
        TareaController tareaController = new TareaController();
        listaTareas = (Tarea[]) tareaController.getAll("nombreTarea").toArray(new Tarea[0]);
        listaTareasOp = new Option[listaTareas.length];
        Option option;
        for (int i = 0; i < listaTareas.length; i++) {
            Tarea tp = listaTareas[i];
            option = new Option();
            option.setLabel(tp.getNombreTarea());
            option.setValue(tp.getCodTarea().toString());
            listaTareasOp[i] = option;
        }
    }
////// FIN CARGA DE COMBO BOX Tareas

    ////// CARGA DE COMBO BOX Depositos
//////     import com.sun.webui.jsf.model.Option;
    Deposito[] listaDepositos;
    Option[] listaDepositosOp;

    public Option[] getListaDepositosOp() {
        return listaDepositosOp;
    }

    public void setListaDepositosOp(Option[] listaDepositosOp) {
        this.listaDepositosOp = listaDepositosOp;
    }

    public Deposito[] getListaDepositos() {
        return listaDepositos;
    }

    public void setListaDepositos(Deposito[] listaDepositos) {
        this.listaDepositos = listaDepositos;
    }

    public void cargarListaTodosDepositos() {
        DepositoController depositoController = new DepositoController();
        listaDepositos = (Deposito[]) depositoController.getAll("nombre").toArray(new Deposito[0]);
        listaDepositosOp = new Option[listaDepositos.length];
        Option option;
        int i;
        for (i = 0; i < listaDepositos.length; i++) {
            Deposito tp = listaDepositos[i];
            option = new Option();
            option.setLabel(tp.getNombre());
            option.setValue(tp.getCodDeposito().toString());
            listaDepositosOp[i] = option;
        }
    }
////// FIN CARGA DE COMBO BOX 
    ////// CARGA DE COMBO BOX Proveedores
//////     import com.sun.webui.jsf.model.Option;
    Proveedor[] listaProveedores;
    Option[] listaProveedoresOp;

    public Option[] getListaProveedoresOp() {
        return listaMarcasOp;
    }

    public void setListaProveedoresOp(Option[] listaProveedoresOp) {
        this.listaProveedoresOp = listaProveedoresOp;
    }

    public Proveedor[] getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(Proveedor[] listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public void cargarListaTodosProveedores() {
        ProveedorController proveedorController = new ProveedorController();
        listaProveedores = (Proveedor[]) proveedorController.getAll("nombreProveedor").toArray(new Proveedor[0]);
        listaProveedoresOp = new Option[listaProveedores.length];
        Option option;
        for (int i = 0; i < listaProveedores.length; i++) {
            Proveedor p = listaProveedores[i];
            option = new Option();
            option.setLabel(p.getNombreProveedor());
            option.setValue(p.getCodProveedor().toString());
            listaProveedoresOp[i] = option;
        }
    }
////// FIN CARGA DE COMBO BOX Proveedores
    ////// CARGA DE COMBO BOX Proveedores
//////     import com.sun.webui.jsf.model.Option;
    Usuarios[] listaUsuarios;
    Option[] listaPUsuariosOp;


    public Usuarios[] getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(Usuarios[] listaUsuarios) {
        this.listaUsuarios= listaUsuarios;
    }

    public void cargarListaTodosUsuarios() {
        UsuarioController usuController = new UsuarioController();
        listaUsuarios = (Usuarios[]) usuController.getAll("usuario").toArray(new Usuarios[0]);
        
    }
////// FIN CARGA DE COMBO BOX Proveedores
////// CARGA DE COMBO BOX Formulas SEMITERMINADOS
//////     import com.sun.webui.jsf.model.Option;
    FormulaSemiCabecera[] listaFormulaCabecerasSemiTer;
    Option[] listaFormulaCabecerasSemiTerOp;

    public Option[] getListaFormulaCabecerasSemiTerOp() {
        return listaFormulaCabecerasSemiTerOp;
    }

    public void setListaFormulaCabecerasSemiTerOp(Option[] listaFormulaCabeceraSemiTerOp) {
        this.listaFormulaCabecerasSemiTerOp = listaFormulaCabeceraSemiTerOp;
    }

    public FormulaSemiCabecera[] getListaFormulaCabecerasSemiTer() {
        return listaFormulaCabecerasSemiTer;
    }

    public void setListaFormulaCabecerasSemiTer(FormulaSemiCabecera[] listaFormulaCabecerasSemiTer) {
        this.listaFormulaCabecerasSemiTer = listaFormulaCabecerasSemiTer;
    }

    public void cargarListaTodosFormulaCabecerasSemiTer() {
        FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
        listaFormulaCabecerasSemiTer = (FormulaSemiCabecera[]) formulaSemiCabeceraController.getAll("descripcion").toArray(new FormulaSemiCabecera[0]);
        listaFormulaCabecerasSemiTerOp = new Option[listaFormulaCabecerasSemiTer.length];
        Option option;
        for (int i = 0; i < listaFormulaCabecerasSemiTer.length; i++) {
            FormulaSemiCabecera p = listaFormulaCabecerasSemiTer[i];
            option = new Option();
            option.setLabel(p.getDescripcion());
            option.setValue(p.getCodFormulaSemiCabecera().toString());
            listaFormulaCabecerasSemiTerOp[i] = option;
        }
    }
////// FIN CARGA DE COMBO BOX DE FORMULAS
////// CARGA DE COMBO BOX Formulas TERMINADOS
//////     import com.sun.webui.jsf.model.Option;

    FormulaCabecera[] listaFormulaCabecerasTer;
    Option[] listaFormulaCabecerasTerOp;

    public Option[] getListaFormulaCabecerasTerOp() {
        return listaFormulaCabecerasSemiTerOp;
    }

    public void setListaFormulaCabecerasTerOp(Option[] listaFormulaCabecerasTerOp) {
        this.listaFormulaCabecerasTerOp = listaFormulaCabecerasTerOp;
    }

    public FormulaCabecera[] getListaFormulaCabecerasTer() {
        return listaFormulaCabecerasTer;
    }

    public void setListaFormulaCabecerasTer(FormulaCabecera[] listaFormulaCabecerasTer) {
        this.listaFormulaCabecerasTer = listaFormulaCabecerasTer;
    }

    public void cargarListaTodosFormulaCabecerasTer(){
        FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();
        listaFormulaCabecerasTer = (FormulaCabecera[]) formulaCabeceraController.getAll("descripcion").toArray(new FormulaCabecera[0]);
        listaFormulaCabecerasTerOp = new Option [listaFormulaCabecerasTer.length];
        Option option;
        for (int i = 0; i < listaFormulaCabecerasTer.length; i++) {
            FormulaCabecera p = listaFormulaCabecerasTer[i];
            option = new Option();
            option.setLabel(p.getDescripcion());
            option.setValue(p.getCodFormula().toString());
            listaFormulaCabecerasTerOp[i] = option;
        }
    }
//////  CARGA DE COMBO BOX DE ORDENES DE TRABAJO

    OrdenTrabajo[] listaOtCab;
    Option[] listaOtCabOp;

    public OrdenTrabajo[] getListaOtCab() {
        return listaOtCab;
    }

    public void setListaOtCab(OrdenTrabajo[] listaOtCab) {
        this.listaOtCab = listaOtCab;
    }

    public Option[] getListaOtCabOp() {
        return listaOtCabOp;
    }

    public void setListaOtCabOp(Option[] listaOtCabOp) {
        this.listaOtCabOp = listaOtCabOp;
    }

        public void cargarListaTodosOTCab() {
        OrdenTrabajoCabeceraController c = new OrdenTrabajoCabeceraController();
        listaOtCab = (OrdenTrabajo[]) c.getAllFiltered(null,null, null, null).toArray(new OrdenTrabajo[0]);

    }







    private SolicitudInterna[] listaSolicitud;

    public SolicitudInterna[] getListaSolicitud() {
        return listaSolicitud;
    }

    public void setListaSolicitud(SolicitudInterna[] listaSolicitud) {
        this.listaSolicitud = listaSolicitud;
    }

    public void cargarListaSolictud() {
        SolicitudInternaController c = new SolicitudInternaController();
        listaSolicitud = (SolicitudInterna[]) c.getAll("fecha").toArray(new SolicitudInterna[0]);
    }

    public void cargarListaSolictud(String estado) {
        SolicitudInternaController c = new SolicitudInternaController();
        listaSolicitud = (SolicitudInterna[]) c.getSolicitudInternas(null, null, null, estado).toArray(new SolicitudInterna[0]);
    }

    TipoComprobante[] listaTipoComprobante;
    Option[] listaTipoComprobanteOption;

    public TipoComprobante[] getListaTipoComprobante() {
        return listaTipoComprobante;
    }

    public void setListaTipoComprobante(TipoComprobante[] listaTipoComprobante) {
        this.listaTipoComprobante = listaTipoComprobante;
    }

    public Option[] getListaTipoComprobanteOption() {
        return listaTipoComprobanteOption;
    }

    public void setListaTipoComprobanteOption(Option[] listaTipoComprobanteOption) {
        this.listaTipoComprobanteOption = listaTipoComprobanteOption;
    }

    public void cargarListaTipoComprobante() {
        //Variables
        Option o;
        TipoComprobanteController TipoComprobanteController = new TipoComprobanteController();

        //Obtenemos la lista de TipoComprobante ordenado por nombre del TipoComprobante
        listaTipoComprobante = (TipoComprobante[]) TipoComprobanteController.getAll("descTipo").toArray(new TipoComprobante[0]);
        
        //Dimensionamos el array de options para la lista de TipoComprobantes
        listaTipoComprobanteOption = new Option[listaTipoComprobante.length];

        //Recorremos la lista de TipoComprobantes
        for (int i = 0; i < listaTipoComprobante.length; i++) {
            //Optenemos el TipoComprobante
            TipoComprobante e = listaTipoComprobante[i];

            //Creamos nuevo options
            o = new Option();
            o.setValue(e.getCodTipo().toString());
            o.setLabel(e.getDescTipo());

            //agregamos option al array de option - TipoComprobante
            listaTipoComprobanteOption[i] = o;
        }
    }

    /**
     * Consultamos los tipo de comprobante por Modulo
     * @param modulo
     */
    public void cargarListaTipoComprobantePorModulo(ModuloEnum modulo) {
        //Variables
        TipoComprobanteController TipoComprobanteController = new TipoComprobanteController();
        Option o;

        //Obtenemos la lista de TipoComprobante ordenado por nombre del TipoComprobante
        listaTipoComprobante = (TipoComprobante[]) TipoComprobanteController.getTipoComprobantesPorModulo(modulo).toArray(new TipoComprobante[0]);

        //Dimensionamos el array de options para la lista de TipoComprobantes
        listaTipoComprobanteOption = new Option[listaTipoComprobante.length];

        //Recorremos la lista de TipoComprobantes
        for (int i = 0; i < listaTipoComprobante.length; i++) {
            //Optenemos el TipoComprobante
            TipoComprobante e = listaTipoComprobante[i];

            //Creamos nuevo options
            o = new Option();
            o.setValue(e.getCodTipo().toString());
            o.setLabel(e.getDescTipo());

            //agregamos option al array de option - TipoComprobante
            listaTipoComprobanteOption[i] = o;
        }
    }

    //Cargar lista Ciudad
    Ciudad[] listaCiudad;
    Option[] listaCiudadOption;

    public Ciudad[] getListaCiudad() {
        return listaCiudad;
    }

    public void setListaCiudad(Ciudad[] listaCiudad) {
        this.listaCiudad = listaCiudad;
    }

    public Option[] getListaCiudadOption() {
        return listaCiudadOption;
    }

    public void setListaCiudadOption(Option[] listaCiudadOption) {
        this.listaCiudadOption = listaCiudadOption;
    }

    /**
     * Obtenemos la lista de Ciudad de la base de datos
     */
    public void cargarListaCiudad() {
        //Variables
        CiudadController CiudadController = new CiudadController();
        Option o;

        //Obtenemos la lista de Ciudad ordenado por nombre del Ciudad
        listaCiudad = (Ciudad[]) CiudadController.getAll("nombreciudad").toArray(new Ciudad[0]);

        //Dimensionamos el array de options para la lista de Ciudads
        listaCiudadOption = new Option[listaCiudad.length];

        //Recorremos la lista de Ciudads
        for (int i = 0; i < listaCiudad.length; i++) {
            //Optenemos el Ciudad
            Ciudad e = listaCiudad[i];

            //Creamos nuevo options
            o = new Option();
            o.setValue(e.getCodciudad().toString());
            o.setLabel(e.getNombreciudad());

            //agregamos option al array de option - Ciudad
            listaCiudadOption[i] = o;
        }
    }

    PedidoCabecera[] listaPedidoVenta;

    public PedidoCabecera[] getListaPedidoVenta() {
        return listaPedidoVenta;
    }

    public void setListaPedidoVenta(PedidoCabecera[] listaPedidoVenta) {
        this.listaPedidoVenta = listaPedidoVenta;
    }

    public void cargarListaPedidoVenta() {
        PedidoCabeceraController pedidoCabeceraController = new PedidoCabeceraController();
        listaPedidoVenta = (PedidoCabecera[]) pedidoCabeceraController.getAll("fechaPedido").toArray(new PedidoCabecera[0]);
    }

    public void cargarListaPedidoVenta(String cliente, PedidoVentaEstado estado) {
        PedidoCabeceraController c = new PedidoCabeceraController();
        listaPedidoVenta = (PedidoCabecera[]) c.getPedidoCabecera(cliente, estado).toArray(new PedidoCabecera[0]);
    }

////////////////////// UTILIZADOS EN LA GESTION DE PRODUCCION DIARIA ////////////////////

    List<OrdenTrabajoDetalle>  ordenTrabajoDetallesProdDiaria = new ArrayList();
    OrdenTrabajoDetalle[]  ordenTrabajoDetalleArray = new OrdenTrabajoDetalle[0];

    public OrdenTrabajoDetalle[] getOrdenTrabajoDetalleArray() {
        return ordenTrabajoDetalleArray;
    }

    public void setOrdenTrabajoDetalleArray(OrdenTrabajoDetalle[] ordenTrabajoDetalleArray) {
        this.ordenTrabajoDetalleArray = ordenTrabajoDetalleArray;
    }

    public List<OrdenTrabajoDetalle> getOrdenTrabajoDetallesProdDiaria() {
        return ordenTrabajoDetallesProdDiaria;
    }

    public void setOrdenTrabajoDetalles(List<OrdenTrabajoDetalle> ordenTrabajoDetallesProdDiaria) {
        this.ordenTrabajoDetallesProdDiaria = ordenTrabajoDetallesProdDiaria;
    }

    public void cargarListaTodosOrdenTrabajoDetallesProdDiaria(){

    ordenTrabajoDetallesProdDiaria = new OrdenTrabajoDetalleController().getAllFiltered(null, null,null);

    }

     List<TareaAsignada>  tareasAsignadasProDiaria = new ArrayList();
    TareaAsignada[]  tareasAsignadasArray = new TareaAsignada[0];

    public List<TareaAsignada> getTareasAsignadasProDiaria() {
        return tareasAsignadasProDiaria;
    }

    public void setTareasAsignadasProDiaria(List<TareaAsignada> tareasAsignadasProDiaria) {
        this.tareasAsignadasProDiaria = tareasAsignadasProDiaria;
    }

    public TareaAsignada[] getTareasAsignadasArray() {
        return tareasAsignadasArray;
    }

    public void setTareasAsignadasArray(TareaAsignada[] tareasAsignadasArray) {
        this.tareasAsignadasArray = tareasAsignadasArray;
    }

   public void cargarListaTodasTareasAsignadasProdDiaria(){

    tareasAsignadasProDiaria = new TareaAsignadaController().getAllFiltered(null, null,null);

    }

 private Long idOTProdDiaria;
 private Long idOTDetProdDiaria;

    public Long getIdOTDetProdDiaria() {
        return idOTDetProdDiaria;
    }

    public void setIdOTDetProdDiaria(Long idOTDetProdDiaria) {
        this.idOTDetProdDiaria = idOTDetProdDiaria;
    }
 
    public Long getIdOTProdDiaria() {
        return idOTProdDiaria;
    }

    public void setIdOTProdDiaria(Long idOTProdDiaria) {
        this.idOTProdDiaria = idOTProdDiaria;
    }



//////////////////////////////////


    FacturaCompraCab[] listaFacturaCompra;

    public FacturaCompraCab[] getListaFacturaCompra() {
        return listaFacturaCompra;
    }

    public void setListaFacturaCompra(FacturaCompraCab[] listaFacturaCompra) {
        this.listaFacturaCompra = listaFacturaCompra;
    }

    public void cargarListaFacturaCompra() {
        FacturaCompraCabController FacturaCompraCabController = new FacturaCompraCabController();
        listaFacturaCompra = (FacturaCompraCab[]) FacturaCompraCabController.getAll("fechaPedido").toArray(new FacturaCompraCab[0]);
    }

    public void cargarListaFacturaCompra(String cliente, FacturaCompraEstado estado) {
        FacturaCompraCabController c = new FacturaCompraCabController();
        listaFacturaCompra = (FacturaCompraCab[]) c.getFacturaCompraCab(cliente, estado).toArray(new FacturaCompraCab[0]);
    }



        ////// CARGA DE COMBO BOX MAQUINARIAS
//////     import com.sun.webui.jsf.model.Option;
    Maquinarias[] listaMaquinarias;
    Option[] listaMaquinariasOp;

    public Maquinarias[] getListaMaquinarias() {
        return listaMaquinarias;
    }

    public void setListaMaquinarias(Maquinarias[] listaMaquinarias) {
        this.listaMaquinarias = listaMaquinarias;
    }

    public Option[] getListaMaquinariasOp() {
        return listaMaquinariasOp;
    }

    public void setListaMaquinariasOp(Option[] listaMaquinariasOp) {
        this.listaMaquinariasOp = listaMaquinariasOp;
    }

    public void cargarListaTodosMaquinarias() {
        MaquinariaController maqController = new MaquinariaController();
        listaMaquinarias = (Maquinarias[]) maqController.getAll("descripcion").toArray(new Maquinarias[0]);
        listaMaquinariasOp = new Option[listaMaquinarias.length];
        Option option;
        int i;
        for (i = 0; i < listaMaquinarias.length; i++) {
            Maquinarias tp = listaMaquinarias[i];
            option = new Option();
            option.setLabel(tp.getCodMaquinaria().toString()+" "+tp.getDescripcion());
            option.setValue(tp.getCodMaquinaria().toString());
            listaMaquinariasOp[i] = option;
        }
      }
    FacturaCabecera[] listaFacturaVenta;

    public FacturaCabecera[] getListaFacturaVenta() {
        return listaFacturaVenta;
    }

    public void setListaFacturaVenta(FacturaCabecera[] listaFacturaVenta) {
        this.listaFacturaVenta = listaFacturaVenta;
    }

    public void cargarListaFacturaVenta(String cliente) {
        FacturaCabeceraController c = new FacturaCabeceraController();
        listaFacturaVenta = (FacturaCabecera[]) c.getFacturaConSaldo(cliente).toArray(new FacturaCabecera[0]);
    }

        ////// CARGA DE COMBO BOX Tareas Fallidas
//////     import com.sun.webui.jsf.model.Option;
    TareaFallida[] listaTareasFallidas;
    Option[] listaTareasFallidasOp;

    public Option[] getListaTareasFallidasOp() {
        return listaTareasFallidasOp;
    }

    public void setListaTareasFallidasOp(Option[] listaTareasFallidasOp) {
        this.listaTareasFallidasOp = listaTareasFallidasOp;
    }

    public TareaFallida[] getListaTareasFallidas() {
        return listaTareasFallidas;
    }

    public void setListaTareasFallidas(TareaFallida[] listaTareasFallidas) {
        this.listaTareasFallidas = listaTareasFallidas;
    }

    public void cargarListaTodosTareasFallidas() {
        TareaFallidaController tareaFallidaController = new TareaFallidaController();
        listaTareasFallidas = (TareaFallida[]) tareaFallidaController.getAll("codTareaFallida").toArray(new TareaFallida[0]);
        listaTareasFallidasOp = new Option[listaTareasFallidas.length];
        Option option;
        for (int i = 0; i < listaTareasFallidas.length; i++) {
            TareaFallida tp = listaTareasFallidas[i];
            option = new Option();
            option.setLabel(tp.getCodTareaAsignada().getCodTarea().getNombreTarea());
            option.setValue(tp.getCodTareaFallida().toString());
            listaTareasFallidasOp[i] = option;
        }
    }
////// FIN CARGA DE COMBO BOX Tareas Fallidas




    
    private Usuarios usuarioLogueado;

    public Usuarios getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuarios usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }


    private Producto[] listaProductosCompra;

    public Option[] getListaPUsuariosOp() {
        return listaPUsuariosOp;
    }

    public void setListaPUsuariosOp(Option[] listaPUsuariosOp) {
        this.listaPUsuariosOp = listaPUsuariosOp;
    }

    public Producto[] getListaProductosCompra() {
        return listaProductosCompra;
    }

    public void setListaProductosCompra(Producto[] listaProductosCompra) {
        this.listaProductosCompra = listaProductosCompra;
    }

  }
