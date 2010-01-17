/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package platinum;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import javax.faces.FacesException;
import py.com.platinum.controller.MarcaController;
import py.com.platinum.controller.PresentacionController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.TareaController;
import py.com.platinum.controller.TipoProductoController;
import py.com.platinum.controller.UnidadMedidaController;
import py.com.platinum.entity.Marca;
import py.com.platinum.entity.Presentacion;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.Tarea;
import py.com.platinum.entity.TipoProducto;
import py.com.platinum.entity.UnidadMedida;

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
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here

    this.tituloPagina = "Bienvenidos al Sistema";

    //El siguiente Metodo Carga la Grilla De Productos al cargar la pagina de productos.
    cargarListaTodosProductos();
    cargarListaTodosMarcas();
    cargarListaTodosTipoProductos();
    cargarListaTodosPresentacions();
    cargarListaTodosUnidadMedidas();

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




    Producto[] listaProductos;

    public Producto[] getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(Producto[] listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public void cargarListaTodosProductos(){
        ProductoController productoController = new ProductoController();
        listaProductos = (Producto[]) productoController.getAll("descripcion").toArray(new Producto[0]);
                
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

    public void cargarListaTodosMarcas(){
        MarcaController MarcaController = new MarcaController();
        listaMarcas = (Marca[]) MarcaController.getAll("nombre").toArray(new Marca[0]);
        listaMarcasOp = new Option [listaMarcas.length];
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

    public void cargarListaTodosTipoProductos(){
        TipoProductoController TipoProductoController = new TipoProductoController();
        listaTipoProductos = (TipoProducto[]) TipoProductoController.getAll("descripcion").toArray(new TipoProducto[0]);
        listaTipoProductosOp = new Option [listaTipoProductos.length];
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

    public void cargarListaTodosUnidadMedidas(){
        UnidadMedidaController UnidadMedidaController = new UnidadMedidaController();
        listaUnidadMedidas = (UnidadMedida[]) UnidadMedidaController.getAll("descripcion").toArray(new UnidadMedida[0]);
        listaUnidadMedidasOp = new Option [listaUnidadMedidas.length];
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

    public void cargarListaTodosPresentacions(){
        PresentacionController PresentacionController = new PresentacionController();
        listaPresentacions = (Presentacion[]) PresentacionController.getAll("descripcion").toArray(new Presentacion[0]);
        listaPresentacionsOp = new Option [listaPresentacions.length];
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
    

////// FIN CARGA DE COMBO BOX PresentacionS

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

    public void cargarListaTodosTareas(){
        TareaController TareaController = new TareaController();
        listaTareas = (Tarea[])TareaController.getAll("nombreTarea").toArray(new Tarea[0]);
        listaTareasOp = new Option [listaTareas.length];
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



}
