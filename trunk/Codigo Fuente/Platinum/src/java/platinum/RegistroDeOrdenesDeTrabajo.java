/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.ValueChangeEvent;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.FormulaCabeceraController;
import py.com.platinum.controller.FormulaSemiCabeceraController;
import py.com.platinum.controller.OrdenTrabajoCabeceraController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.FormulaCabecera;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.RecursoAsignado;
import py.com.platinum.entity.TareaAsignada;
import py.com.platinum.utils.StringUtils;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ABMCliente.java
 * @version Created on Oct 18, 2009, 8:11:57 PM
 * @author FerBoy
 */
public class RegistroDeOrdenesDeTrabajo extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        tipoDoc1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "Cedula de Identidad"), new com.sun.webui.jsf.model.Option("2", "DNI"), new com.sun.webui.jsf.model.Option("3", "Pasaporte")});
        radioButtonGroup1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("e", "Entrada"), new com.sun.webui.jsf.model.Option("s", "Salida")});
        referencia1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "Orden de Trabajo"), new com.sun.webui.jsf.model.Option("2", "Venta"), new com.sun.webui.jsf.model.Option("3", "Trabajo Diario")});
    }
    private SingleSelectOptionsList tipoDoc1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getTipoDoc1DefaultOptions() {
        return tipoDoc1DefaultOptions;
    }

    public void setTipoDoc1DefaultOptions(SingleSelectOptionsList ssol) {
        this.tipoDoc1DefaultOptions = ssol;
    }
    private SingleSelectOptionsList radioButtonGroup1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getRadioButtonGroup1DefaultOptions() {
        return radioButtonGroup1DefaultOptions;
    }

    public void setRadioButtonGroup1DefaultOptions(SingleSelectOptionsList ssol) {
        this.radioButtonGroup1DefaultOptions = ssol;
    }
    private SingleSelectOptionsList referencia1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getReferencia1DefaultOptions() {
        return referencia1DefaultOptions;
    }

    public void setReferencia1DefaultOptions(SingleSelectOptionsList ssol) {
        this.referencia1DefaultOptions = ssol;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RegistroDeOrdenesDeTrabajo() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
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
            log("ABMCliente Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here

    getSessionBean1().setTituloPagina("Registro de Ordenes de Trabajo");
    getSessionBean1().setDetallePagina("Area de Produccion");


    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }
    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    private boolean addRequestOT = false;
    private boolean updateRequestOT = false;
    private boolean addDetalleOt = false;
    private boolean errorValidacion = false;




    @Override
    public void prerender() {

     

buscar_action2();

    }

    private String buscar_action2() {

        OrdenTrabajo[] listaOrdenTrabajos;
        OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();

        String pNumeroOrdenTrabajo=null, pCodProducto=null, pEstado=null;
        Date pFechaOt=null;

//        if (this.uiNumOtFil.getText()!=null) {
//            pNumeroOrdenTrabajo = this.uiNumOtFil.getText().toString();
//        }
//
//        if (this.uiProductoFil.getSelected()!=null) {
//            pCodProducto = this.uiProductoFil.getSelected().toString();
//        }
//
//        if (this.uiFechaDesdeFil.getSelectedDate()!=null) {
//            pFechaOt= this.uiFechaDesdeFil.getSelectedDate();
//        }
//
//        if (this.uiEstadoFIl.getSelected()!=null) {
////            pEstado= this.uiEstadoFIl.getSelected().toString();
//            pEstado= "A";
//        }

        listaOrdenTrabajoCabeceras = (OrdenTrabajo[]) ordenTrabajoCabeceraController.getAllFiltered
                                        (pNumeroOrdenTrabajo,
                                         pCodProducto,
                                         pEstado,
                                         pFechaOt).toArray(new OrdenTrabajo[0]);

        setlistaOrdenTrabajoCabeceras(listaOrdenTrabajoCabeceras);
        return null;

    }





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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    

    public String addRecordButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        errorValidacion = validarCampos();

        detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);
        recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoList.toArray(new RecursoAsignado[0]);
        tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaList.toArray(new TareaAsignada[0]);

        //Si no hay error de validacion
       

           return null;
 }


        private boolean validarCampos(){
        //Variables
        boolean r;

        //Inicializar
        r = false;

        if (detalleOrdenTrabajoList.size() < 0){
//            info(uiDetProductoCodigo, "Debe cargar los detalles de productos de la formula");
            r = true;
        }

        return r;
    }





    public String buscar1_action() {
        // TODO: Replace with your code

        return null;
    }

    public String todos1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    //MANEJO DE LOS DETALLES

private OrdenTrabajoDetalle[] detallesOrdenTrabajo;
private OrdenTrabajoDetalle  detalleOrdenTrabajo;
private List<OrdenTrabajoDetalle>  detalleOrdenTrabajoList;

private TareaAsignada[] tareasAsignadasOt;
private TareaAsignada  tareaAsignadaOt;
private List<TareaAsignada>  tareaAsignadaList;

private RecursoAsignado[] recursosAsignadosOt;
private RecursoAsignado  recursoAsignadoOt;
private List<RecursoAsignado>  recursoAsignadoList;

private List<OrdenTrabajoDetalle>  detalleOrdenTrabajoEliminadaList;
private List<TareaAsignada>  tareaAsignadaEliminadaList;
private List<RecursoAsignado>  recursoAsignadoEliminadoList;





    public String buttonNuevo_action() {
        // TODO: Replace with your code

        detalleOrdenTrabajoList = new ArrayList();
        detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);


        tareaAsignadaList = new ArrayList();
        tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaList.toArray(new TareaAsignada[0]);

        recursoAsignadoList = new ArrayList();
        recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoList.toArray(new RecursoAsignado[0]);

        this.addRequestOT=true;
        this.updateRequestOT=false;
        this.addDetalleOt=false;
        this.errorValidacion =false;
        return null;
    }

    public String buttonEditar_action() {
        // TODO: Replace with your code
        this.addRequestOT=false;
        this.updateRequestOT=false;
        this.addDetalleOt=true;
        this.errorValidacion =false;

        return null;
    }

    public String hyperlink1_action() {
        // TODO: Replace with your code
        this.addRequestOT=false;
        this.updateRequestOT=false;
        this.addDetalleOt=true;
        this.errorValidacion =false;

        return null;
    }

  

    public String botonDeFormula_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequestOT=false;
        this.updateRequestOT=false;
        this.addDetalleOt=true;
        this.errorValidacion =false;
        return null;
    }


////// CARGA DE ARRAY ORDENES TRABAJO
//////     import com.sun.webui.jsf.model.Option;

    OrdenTrabajo[] listaOrdenTrabajoCabeceras;


        public OrdenTrabajo[] getlistaOrdenTrabajoCabeceras() {
        return listaOrdenTrabajoCabeceras;
    }

    public void setlistaOrdenTrabajoCabeceras(OrdenTrabajo[] listaOrdenTrabajoCabeceras) {
        this.listaOrdenTrabajoCabeceras = listaOrdenTrabajoCabeceras;
    }

    public void cargarlistaTodosOrdenTrabajoCabeceras(){
        OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();
        listaOrdenTrabajoCabeceras = (OrdenTrabajo[]) ordenTrabajoCabeceraController.getAll("estadoOt").toArray(new OrdenTrabajo[0]);

    }
////// FIN CARGA DE ot cabeceras

    public void uiNumOtFil_processValueChange(ValueChangeEvent vce) {
    }

    public boolean isAddDetalleOt() {
        return addDetalleOt;
    }

    public void setAddDetalleOt(boolean addDetalleOt) {
        this.addDetalleOt = addDetalleOt;
    }

    public boolean isAddRequestOT() {
        return addRequestOT;
    }

    public void setAddRequestOT(boolean addRequestOT) {
        this.addRequestOT = addRequestOT;
    }

    public OrdenTrabajoDetalle getDetalleOrdenTrabajo() {
        return detalleOrdenTrabajo;
    }

    public void setDetalleOrdenTrabajo(OrdenTrabajoDetalle detalleOrdenTrabajo) {
        this.detalleOrdenTrabajo = detalleOrdenTrabajo;
    }

    public List<OrdenTrabajoDetalle> getDetalleOrdenTrabajoEliminadaList() {
        return detalleOrdenTrabajoEliminadaList;
    }

    public void setDetalleOrdenTrabajoEliminadaList(List<OrdenTrabajoDetalle> detalleOrdenTrabajoEliminadaList) {
        this.detalleOrdenTrabajoEliminadaList = detalleOrdenTrabajoEliminadaList;
    }

    public List<OrdenTrabajoDetalle> getDetalleOrdenTrabajoList() {
        return detalleOrdenTrabajoList;
    }

    public void setDetalleOrdenTrabajoList(List<OrdenTrabajoDetalle> detalleOrdenTrabajoList) {
        this.detalleOrdenTrabajoList = detalleOrdenTrabajoList;
    }

    public OrdenTrabajoDetalle[] getDetallesOrdenTrabajo() {
        return detallesOrdenTrabajo;
    }

    public void setDetallesOrdenTrabajo(OrdenTrabajoDetalle[] detallesOrdenTrabajo) {
        this.detallesOrdenTrabajo = detallesOrdenTrabajo;
    }

    public OrdenTrabajo[] getListaOrdenTrabajoCabeceras() {
        return listaOrdenTrabajoCabeceras;
    }

    public void setListaOrdenTrabajoCabeceras(OrdenTrabajo[] listaOrdenTrabajoCabeceras) {
        this.listaOrdenTrabajoCabeceras = listaOrdenTrabajoCabeceras;
    }

    public List<RecursoAsignado> getRecursoAsignadoEliminadoList() {
        return recursoAsignadoEliminadoList;
    }

    public void setRecursoAsignadoEliminadoList(List<RecursoAsignado> recursoAsignadoEliminadoList) {
        this.recursoAsignadoEliminadoList = recursoAsignadoEliminadoList;
    }

    public List<RecursoAsignado> getRecursoAsignadoList() {
        return recursoAsignadoList;
    }

    public void setRecursoAsignadoList(List<RecursoAsignado> recursoAsignadoList) {
        this.recursoAsignadoList = recursoAsignadoList;
    }

    public RecursoAsignado getRecursoAsignadoOt() {
        return recursoAsignadoOt;
    }

    public void setRecursoAsignadoOt(RecursoAsignado recursoAsignadoOt) {
        this.recursoAsignadoOt = recursoAsignadoOt;
    }

    public List<TareaAsignada> getTareaAsignadaEliminadaList() {
        return tareaAsignadaEliminadaList;
    }

    public void setTareaAsignadaEliminadaList(List<TareaAsignada> tareaAsignadaEliminadaList) {
        this.tareaAsignadaEliminadaList = tareaAsignadaEliminadaList;
    }

    public List<TareaAsignada> getTareaAsignadaList() {
        return tareaAsignadaList;
    }

    public void setTareaAsignadaList(List<TareaAsignada> tareaAsignadaList) {
        this.tareaAsignadaList = tareaAsignadaList;
    }

    public TareaAsignada getTareaAsignadaOt() {
        return tareaAsignadaOt;
    }

    public void setTareaAsignadaOt(TareaAsignada tareaAsignadaOt) {
        this.tareaAsignadaOt = tareaAsignadaOt;
    }

    public TareaAsignada[] getTareasAsignadasOt() {
        return tareasAsignadasOt;
    }

    public void setTareasAsignadasOt(TareaAsignada[] tareasAsignadasOt) {
        this.tareasAsignadasOt = tareasAsignadasOt;
    }

    public boolean isUpdateRequestOT() {
        return updateRequestOT;
    }

    public void setUpdateRequestOT(boolean updateRequestOT) {
        this.updateRequestOT = updateRequestOT;
    }

    public String uiCancelButton_action() {
        // TODO: Replace with your code
        return null;
    }

    public String button2_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
            // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

//        errorValidacion = validarCampos();

        detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);
        recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoList.toArray(new RecursoAsignado[0]);
        tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaList.toArray(new TareaAsignada[0]);

        //Si no hay error de validacion
   

        return null;
    }





}

