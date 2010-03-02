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
        uiEstadoFIlDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "En Progreso"), new com.sun.webui.jsf.model.Option("2", "Parada"), new com.sun.webui.jsf.model.Option("3", "Terminado"), new com.sun.webui.jsf.model.Option("4", "Cancelado")});
        uiEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "En Proceso"), new com.sun.webui.jsf.model.Option("2", "Terminado"), new com.sun.webui.jsf.model.Option("3", "En Espera")});
    }
    private DefaultTableDataProvider defaultTableDataProvider = new DefaultTableDataProvider();

    public DefaultTableDataProvider getDefaultTableDataProvider() {
        return defaultTableDataProvider;
    }

    public void setDefaultTableDataProvider(DefaultTableDataProvider dtdp) {
        this.defaultTableDataProvider = dtdp;
    }
    private HtmlPanelGrid gridPanelCabecera1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelCabecera1() {
        return gridPanelCabecera1;
    }

    public void setGridPanelCabecera1(HtmlPanelGrid hpg) {
        this.gridPanelCabecera1 = hpg;
    }
    private HtmlPanelGrid gridPanelTabla = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelTabla() {
        return gridPanelTabla;
    }

    public void setGridPanelTabla(HtmlPanelGrid hpg) {
        this.gridPanelTabla = hpg;
    }
    private HtmlPanelGrid gridPanelAddUpdate = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelAddUpdate() {
        return gridPanelAddUpdate;
    }

    public void setGridPanelAddUpdate(HtmlPanelGrid hpg) {
        this.gridPanelAddUpdate = hpg;
    }
    private HtmlPanelGrid buttonsPanelAddUpdate = new HtmlPanelGrid();

    public HtmlPanelGrid getButtonsPanelAddUpdate() {
        return buttonsPanelAddUpdate;
    }

    public void setButtonsPanelAddUpdate(HtmlPanelGrid hpg) {
        this.buttonsPanelAddUpdate = hpg;
    }
    private Button addRecordButton = new Button();

    public Button getAddRecordButton() {
        return addRecordButton;
    }

    public void setAddRecordButton(Button b) {
        this.addRecordButton = b;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
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
    private TableColumn selec = new TableColumn();

    public TableColumn getSelec() {
        return selec;
    }

    public void setSelec(TableColumn tc) {
        this.selec = tc;
    }
    private SingleSelectOptionsList uiEstadoFIlDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiEstadoFIlDefaultOptions() {
        return uiEstadoFIlDefaultOptions;
    }

    public void setUiEstadoFIlDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiEstadoFIlDefaultOptions = ssol;
    }
    private SingleSelectOptionsList uiEstadoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiEstadoDefaultOptions() {
        return uiEstadoDefaultOptions;
    }

    public void setUiEstadoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiEstadoDefaultOptions = ssol;
    }
    private HtmlPanelGrid gridPanelBuscar = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBuscar() {
        return gridPanelBuscar;
    }

    public void setGridPanelBuscar(HtmlPanelGrid hpg) {
        this.gridPanelBuscar = hpg;
    }
    private HtmlPanelGrid gridPanelCabecera = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelCabecera() {
        return gridPanelCabecera;
    }

    public void setGridPanelCabecera(HtmlPanelGrid hpg) {
        this.gridPanelCabecera = hpg;
    }
    private HtmlPanelGrid gridPanelDetalleOT = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDetalleOT() {
        return gridPanelDetalleOT;
    }

    public void setGridPanelDetalleOT(HtmlPanelGrid hpg) {
        this.gridPanelDetalleOT = hpg;
    }
    private HtmlPanelGrid gridPanelDetalleSemiTerminados = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDetalleSemiTerminados() {
        return gridPanelDetalleSemiTerminados;
    }

    public void setGridPanelDetalleSemiTerminados(HtmlPanelGrid hpg) {
        this.gridPanelDetalleSemiTerminados = hpg;
    }
    private Button botonDeFormula = new Button();

    public Button getBotonDeFormula() {
        return botonDeFormula;
    }

    public void setBotonDeFormula(Button b) {
        this.botonDeFormula = b;
    }
    private DropDown uiProductoFil = new DropDown();

    public DropDown getUiProductoFil() {
        return uiProductoFil;
    }

    public void setUiProductoFil(DropDown dd) {
        this.uiProductoFil = dd;
    }
    private DropDown uiEstadoFIl = new DropDown();

    public DropDown getUiEstadoFIl() {
        return uiEstadoFIl;
    }

    public void setUiEstadoFIl(DropDown dd) {
        this.uiEstadoFIl = dd;
    }
    private Calendar uiFechaDesdeFil = new Calendar();

    public Calendar getUiFechaDesdeFil() {
        return uiFechaDesdeFil;
    }

    public void setUiFechaDesdeFil(Calendar c) {
        this.uiFechaDesdeFil = c;
    }
    private Calendar uiFechaHastaFil = new Calendar();

    public Calendar getUiFechaHastaFil() {
        return uiFechaHastaFil;
    }

    public void setUiFechaHastaFil(Calendar c) {
        this.uiFechaHastaFil = c;
    }
    private TextField uiNumOtFil = new TextField();

    public TextField getUiNumOtFil() {
        return uiNumOtFil;
    }

    public void setUiNumOtFil(TextField tf) {
        this.uiNumOtFil = tf;
    }
    private TextField uiCostoReal = new TextField();

    public TextField getUiCostoReal() {
        return uiCostoReal;
    }

    public void setUiCostoReal(TextField tf) {
        this.uiCostoReal = tf;
    }
    private TextField uiCostoPrevisto = new TextField();

    public TextField getUiCostoPrevisto() {
        return uiCostoPrevisto;
    }

    public void setUiCostoPrevisto(TextField tf) {
        this.uiCostoPrevisto = tf;
    }
    private TextField uiCantidadProducida = new TextField();

    public TextField getUiCantidadProducida() {
        return uiCantidadProducida;
    }

    public void setUiCantidadProducida(TextField tf) {
        this.uiCantidadProducida = tf;
    }
    private DropDown uiEstado = new DropDown();

    public DropDown getUiEstado() {
        return uiEstado;
    }

    public void setUiEstado(DropDown dd) {
        this.uiEstado = dd;
    }
    private Calendar uiFechaFin = new Calendar();

    public Calendar getUiFechaFin() {
        return uiFechaFin;
    }

    public void setUiFechaFin(Calendar c) {
        this.uiFechaFin = c;
    }
    private Calendar uiFechaIni = new Calendar();

    public Calendar getUiFechaIni() {
        return uiFechaIni;
    }

    public void setUiFechaIni(Calendar c) {
        this.uiFechaIni = c;
    }
    private TextField uiCantidad = new TextField();

    public TextField getUiCantidad() {
        return uiCantidad;
    }

    public void setUiCantidad(TextField tf) {
        this.uiCantidad = tf;
    }
    private TextArea uiDescripcionOt = new TextArea();

    public TextArea getUiDescripcionOt() {
        return uiDescripcionOt;
    }

    public void setUiDescripcionOt(TextArea ta) {
        this.uiDescripcionOt = ta;
    }
    private TextField uiFormulaCodigo = new TextField();

    public TextField getUiFormulaCodigo() {
        return uiFormulaCodigo;
    }

    public void setUiFormulaCodigo(TextField tf) {
        this.uiFormulaCodigo = tf;
    }
    private TextField uiFormulaNombre = new TextField();

    public TextField getUiFormulaNombre() {
        return uiFormulaNombre;
    }

    public void setUiFormulaNombre(TextField tf) {
        this.uiFormulaNombre = tf;
    }
    private DropDown uiProducto = new DropDown();

    public DropDown getUiProducto() {
        return uiProducto;
    }

    public void setUiProducto(DropDown dd) {
        this.uiProducto = dd;
    }
    private TextField uiResponsableNombre = new TextField();

    public TextField getUiResponsableNombre() {
        return uiResponsableNombre;
    }

    public void setUiResponsableNombre(TextField tf) {
        this.uiResponsableNombre = tf;
    }
    private TextField uiResponsableCodigo = new TextField();

    public TextField getUiResponsableCodigo() {
        return uiResponsableCodigo;
    }

    public void setUiResponsableCodigo(TextField tf) {
        this.uiResponsableCodigo = tf;
    }
    private TextField uiNroOT = new TextField();

    public TextField getUiNroOT() {
        return uiNroOT;
    }

    public void setUiNroOT(TextField tf) {
        this.uiNroOT = tf;
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

        if (addRequestOT) {
     
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelCabecera.setRendered(true);
            this.gridPanelDetalleOT.setRendered(true);
            this.gridPanelDetalleSemiTerminados.setRendered(false);

        } else if (updateRequestOT) {

            this.gridPanelBuscar.setRendered(false);
            this.gridPanelCabecera.setRendered(true);
            this.gridPanelDetalleOT.setRendered(true);
            this.gridPanelDetalleSemiTerminados.setRendered(false);

        } else if (addDetalleOt) {

            this.gridPanelBuscar.setRendered(false);
            this.gridPanelCabecera.setRendered(false);
            this.gridPanelDetalleOT.setRendered(false);
            this.gridPanelDetalleSemiTerminados.setRendered(true);

        } else {

            this.gridPanelBuscar.setRendered(true);
            this.gridPanelCabecera.setRendered(false);
            this.gridPanelDetalleOT.setRendered(false);
            this.gridPanelDetalleSemiTerminados.setRendered(false);
        }

buscar_action2();

    }

    private String buscar_action2() {

        OrdenTrabajo[] listaOrdenTrabajos;
        OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();

        String pNumeroOrdenTrabajo=null, pCodProducto=null, pEstado=null;
        Date pFechaOt=null;

        if (this.uiNumOtFil.getText()!=null) {
            pNumeroOrdenTrabajo = this.uiNumOtFil.getText().toString();
        }

        if (this.uiProductoFil.getSelected()!=null) {
            pCodProducto = this.uiProductoFil.getSelected().toString();
        }

        if (this.uiFechaDesdeFil.getSelectedDate()!=null) {
            pFechaOt= this.uiFechaDesdeFil.getSelectedDate();
        }

        if (this.uiEstadoFIl.getSelected()!=null) {
//            pEstado= this.uiEstadoFIl.getSelected().toString();
            pEstado= "A";
        }

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
        if (! errorValidacion){

            //// CARGA DE LA CABECERA
          OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
          ProductoController productoController = new ProductoController();
          EmpleadoController empleadoController = new EmpleadoController();
          FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();


          ordenTrabajo.setNumeroOrdenTrabajo(new Long( this.uiNroOT.getText().toString()));
          ordenTrabajo.setCodEmpleado1(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
          ordenTrabajo.setCodEmpleado2(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
          ordenTrabajo.setCodProductoOt(productoController.findById(Long.valueOf(this.uiProducto.getSelected().toString())));
          ordenTrabajo.setCantidadOt(new BigInteger(this.uiCantidad.getText().toString()));
          ordenTrabajo.setCantidadProducidaOt(new BigInteger(this.uiCantidadProducida.getText().toString()));
          ordenTrabajo.setFechaInicialOt(this.uiFechaIni.getSelectedDate());
          ordenTrabajo.setFechaFinOt(this.uiFechaFin.getSelectedDate());
          ordenTrabajo.setCostoEstimadoOt(new BigInteger(this.uiCostoPrevisto.getText().toString()));
          ordenTrabajo.setCostoRealOt(new BigInteger(this.uiCostoReal.getText().toString()));
          ordenTrabajo.setEstadoOt("A");

          OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();
          ControllerResult controllerResult = new ControllerResult();

          controllerResult = ordenTrabajoCabeceraController.createCabDet(ordenTrabajo, detallesOrdenTrabajo);

          if (controllerResult.getCodRetorno() != -1) {
                addRequestOT = false;
                this.pageAlert1.setType("information");
        }else{

        this.pageAlert1.setType("error");
        this.errorValidacion=true;

        }

            this.pageAlert1.setTitle(controllerResult.getMsg());
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
          
       }
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

        if (uiResponsableCodigo.getText().toString() == null || uiResponsableCodigo.getText().equals("") ) {
//            info(uiProductoCodigo, "Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }

        if (uiResponsableNombre.getText().toString() == null || uiResponsableNombre.getText().equals("") ) {
//            info(uiProductoCodigo, "Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }

        if (uiProducto.getSelected() == null || uiProducto.getSelected().equals("") ) {
//            info(uiProductoCodigo, "Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }

        if (uiFormulaCodigo.getText().toString() == null || uiFormulaCodigo.getText().equals("") ) {
//            info(uiProductoCodigo, "Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }

        if (uiFormulaNombre.getText().toString() == null || uiFormulaNombre.getText().equals("") ) {
//            info(uiProductoCodigo, "Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }

        if (uiFormulaNombre.getText().toString() == null || uiFormulaNombre.getText().equals("") ) {
//            info(uiProductoCodigo, "Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }

        if (!StringUtils.esNumero(this.uiCantidad.getText().toString()))
            {   r = true;
//                this.info(uiCantidad, "La cantidad debe ser campo numerico");
            }

         if (uiFechaIni.getSelectedDate() == null || uiFechaIni.getSelectedDate().equals("") ) {
//            info(uiProductoCodigo, "Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }


         if (uiFechaFin.getSelectedDate() == null || uiFechaFin.getSelectedDate().equals("") ) {
//            info(uiProductoCodigo, "Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }


        if (!StringUtils.esNumero(this.uiCostoPrevisto.getText().toString()))
            {   r = true;
//                this.info(uiCantidad, "La cantidad debe ser campo numerico");
            }


        if (!StringUtils.esNumero(this.uiCostoReal.getText().toString()))
            {   r = true;
//                this.info(uiCantidad, "La cantidad debe ser campo numerico");
            }


        if (uiEstado.getSelected().toString() == null || uiEstado.getSelected().toString().equals("") ) {
//            info(uiEstado, "Campo obligatorio, favor ingrese el estado de la formula");
            r = true;
        }
        //result

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

        this.uiNroOT.setText("");
        this.uiResponsableCodigo.setText("");
        this.uiResponsableNombre.setText("");
        this.pageAlert1.setRendered(false);
        this.uiProducto.setSelected("");
        this.uiFormulaCodigo.setText("");
        this.uiFormulaNombre.setText("");
        this.uiCantidad.setText("");
        this.uiFechaDesdeFil.setSelectedDate(null);
        this.uiFechaHastaFil.setSelectedDate(null);
        this.uiCantidadProducida.setText("");
        this.uiCostoReal.setText("");
        this.uiCostoPrevisto.setText("");

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
        if (! errorValidacion){

            //// CARGA DE LA CABECERA
          OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
          ProductoController productoController = new ProductoController();
          EmpleadoController empleadoController = new EmpleadoController();
          FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();


          ordenTrabajo.setNumeroOrdenTrabajo(new Long( this.uiNroOT.getText().toString()));
          ordenTrabajo.setCodEmpleado1(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
          ordenTrabajo.setCodEmpleado2(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
          ordenTrabajo.setCodProductoOt(productoController.findById(Long.valueOf(this.uiProducto.getSelected().toString())));
          ordenTrabajo.setCantidadOt(new BigInteger(this.uiCantidad.getText().toString()));
          ordenTrabajo.setCantidadProducidaOt(new BigInteger(this.uiCantidadProducida.getText().toString()));
          ordenTrabajo.setFechaInicialOt(this.uiFechaIni.getSelectedDate());
          ordenTrabajo.setFechaFinOt(this.uiFechaFin.getSelectedDate());
          ordenTrabajo.setCostoEstimadoOt(new BigInteger(this.uiCostoPrevisto.getText().toString()));
          ordenTrabajo.setCostoRealOt(new BigInteger(this.uiCostoReal.getText().toString()));
          ordenTrabajo.setEstadoOt("A");

          OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();
          ControllerResult controllerResult = new ControllerResult();

          controllerResult = ordenTrabajoCabeceraController.createCabDet(ordenTrabajo, detallesOrdenTrabajo);

          if (controllerResult.getCodRetorno() != -1) {
                addRequestOT = false;
                this.pageAlert1.setType("information");
        }else{

        this.pageAlert1.setType("error");
        this.errorValidacion=true;

        }

            this.pageAlert1.setTitle(controllerResult.getMsg());
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);

       }

        return null;
    }





}

