/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.convert.DoubleConverter;
import javax.faces.convert.LongConverter;
import javax.faces.convert.NumberConverter;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.EquivalenciaController;
import py.com.platinum.controller.ExistenciaController;
import py.com.platinum.controller.OrdenTrabajoCabeceraController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.SolicitudInternaController;
import py.com.platinum.controller.UnidadMedidaController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.RecursoAsignado;
import py.com.platinum.entity.SolicitudInterna;
import py.com.platinum.entity.TareaAsignada;
import py.com.platinum.entity.UnidadMedida;
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
public class RegistroEstadosOT extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        numberConverter1.setPattern("#,##0");
        numberConverter1.setMinIntegerDigits(1);
        numberConverter1.setMaxIntegerDigits(40);
        numberConverter1.setMaxFractionDigits(3);
        numberConverter2.setPattern("#,##0");
        numberConverter3.setPattern("#,##0");
        numberConverter3.setMinIntegerDigits(1);
        numberConverter3.setMaxIntegerDigits(40);
        numberConverter3.setMaxFractionDigits(3);
        numberConverter4.setPattern("#,##0");
        numberConverter5.setMinIntegerDigits(1);
        numberConverter5.setMaxIntegerDigits(40);
        numberConverter5.setLocale(new java.util.Locale("es", "AR", ""));
    }
    private HtmlPanelGrid gridPanelBuscar = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBuscar() {
        return gridPanelBuscar;
    }

    public void setGridPanelBuscar(HtmlPanelGrid hpg) {
        this.gridPanelBuscar = hpg;
    }
    private HtmlPanelGrid gridPanelTabla = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelTabla() {
        return gridPanelTabla;
    }

    public void setGridPanelTabla(HtmlPanelGrid hpg) {
        this.gridPanelTabla = hpg;
    }
    private HtmlPanelGrid gridPanelBotones = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBotones() {
        return gridPanelBotones;
    }

    public void setGridPanelBotones(HtmlPanelGrid hpg) {
        this.gridPanelBotones = hpg;
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
    private Button buttonGuardarEdicion = new Button();

    public Button getButtonGuardarEdicion() {
        return buttonGuardarEdicion;
    }

    public void setButtonGuardarEdicion(Button b) {
        this.buttonGuardarEdicion = b;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private TextField uiCodigoFil = new TextField();

    public TextField getUiCodigoFil() {
        return uiCodigoFil;
    }

    public void setUiCodigoFil(TextField tf) {
        this.uiCodigoFil = tf;
    }
    private TableRowGroup ordenTrabajoRW = new TableRowGroup();

    public TableRowGroup getOrdenTrabajoRW() {
        return ordenTrabajoRW;
    }

    public void setOrdenTrabajoRW(TableRowGroup trg) {
        this.ordenTrabajoRW = trg;
    }
    private Table tableOrdenesTrabajo = new Table();

    public Table getTableOrdenesTrabajo() {
        return tableOrdenesTrabajo;
    }

    public void setTableOrdenesTrabajo(Table t) {
        this.tableOrdenesTrabajo = t;
    }
    private TextField uiProductoCod = new TextField();

    public TextField getUiProductoCod() {
        return uiProductoCod;
    }

    public void setUiProductoCod(TextField tf) {
        this.uiProductoCod = tf;
    }
    private TextField uiProductoNombre = new TextField();

    public TextField getUiProductoNombre() {
        return uiProductoNombre;
    }

    public void setUiProductoNombre(TextField tf) {
        this.uiProductoNombre = tf;
    }
    private TextArea uiDescripcionOt1 = new TextArea();

    public TextArea getUiDescripcionOt1() {
        return uiDescripcionOt1;
    }

    public void setUiDescripcionOt1(TextArea ta) {
        this.uiDescripcionOt1 = ta;
    }
    private Calendar uiFechaIni1 = new Calendar();

    public Calendar getUiFechaIni1() {
        return uiFechaIni1;
    }

    public void setUiFechaIni1(Calendar c) {
        this.uiFechaIni1 = c;
    }
    private Calendar uiFechaFin1 = new Calendar();

    public Calendar getUiFechaFin1() {
        return uiFechaFin1;
    }

    public void setUiFechaFin1(Calendar c) {
        this.uiFechaFin1 = c;
    }
    private TextField uiCantidadProducida1 = new TextField();

    public TextField getUiCantidadProducida1() {
        return uiCantidadProducida1;
    }

    public void setUiCantidadProducida1(TextField tf) {
        this.uiCantidadProducida1 = tf;
    }
    private TextField uiEstado = new TextField();

    public TextField getUiEstado() {
        return uiEstado;
    }

    public void setUiEstado(TextField tf) {
        this.uiEstado = tf;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TableColumn tableColumn3 = new TableColumn();

    public TableColumn getTableColumn3() {
        return tableColumn3;
    }

    public void setTableColumn3(TableColumn tc) {
        this.tableColumn3 = tc;
    }
    private TextField uiNroOt = new TextField();

    public TextField getUiNroOt() {
        return uiNroOt;
    }

    public void setUiNroOt(TextField tf) {
        this.uiNroOt = tf;
    }
    private TextField uiCantidad1 = new TextField();

    public TextField getUiCantidad1() {
        return uiCantidad1;
    }

    public void setUiCantidad1(TextField tf) {
        this.uiCantidad1 = tf;
    }
    private HtmlPanelGrid gridPanelGenerarSolicitudes1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelGenerarSolicitudes1() {
        return gridPanelGenerarSolicitudes1;
    }

    public void setGridPanelGenerarSolicitudes1(HtmlPanelGrid hpg) {
        this.gridPanelGenerarSolicitudes1 = hpg;
    }
    private TextField uiCierreCostoActual = new TextField();

    public TextField getUiCierreCostoActual() {
        return uiCierreCostoActual;
    }

    public void setUiCierreCostoActual(TextField tf) {
        this.uiCierreCostoActual = tf;
    }
    private TextField uiCierreCantExistencia = new TextField();

    public TextField getUiCierreCantExistencia() {
        return uiCierreCantExistencia;
    }

    public void setUiCierreCantExistencia(TextField tf) {
        this.uiCierreCantExistencia = tf;
    }
    private TextField uiCierreCostoProduccion = new TextField();

    public TextField getUiCierreCostoProduccion() {
        return uiCierreCostoProduccion;
    }

    public void setUiCierreCostoProduccion(TextField tf) {
        this.uiCierreCostoProduccion = tf;
    }
    private TextField uiCierreCantidadProducida = new TextField();

    public TextField getUiCierreCantidadProducida() {
        return uiCierreCantidadProducida;
    }

    public void setUiCierreCantidadProducida(TextField tf) {
        this.uiCierreCantidadProducida = tf;
    }
    private TextField uiCierreCostoProduccionUnitario = new TextField();

    public TextField getUiCierreCostoProduccionUnitario() {
        return uiCierreCostoProduccionUnitario;
    }

    public void setUiCierreCostoProduccionUnitario(TextField tf) {
        this.uiCierreCostoProduccionUnitario = tf;
    }
    private TextField uiCierreCostoNuevo = new TextField();

    public TextField getUiCierreCostoNuevo() {
        return uiCierreCostoNuevo;
    }

    public void setUiCierreCostoNuevo(TextField tf) {
        this.uiCierreCostoNuevo = tf;
    }
    private HtmlPanelGrid gridPanelCierreOT = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelCierreOT() {
        return gridPanelCierreOT;
    }

    public void setGridPanelCierreOT(HtmlPanelGrid hpg) {
        this.gridPanelCierreOT = hpg;
    }
    private LongConverter longConverter1 = new LongConverter();

    public LongConverter getLongConverter1() {
        return longConverter1;
    }

    public void setLongConverter1(LongConverter lc) {
        this.longConverter1 = lc;
    }
    private LongConverter longConverter2 = new LongConverter();

    public LongConverter getLongConverter2() {
        return longConverter2;
    }

    public void setLongConverter2(LongConverter lc) {
        this.longConverter2 = lc;
    }
    private LongConverter longConverter3 = new LongConverter();

    public LongConverter getLongConverter3() {
        return longConverter3;
    }

    public void setLongConverter3(LongConverter lc) {
        this.longConverter3 = lc;
    }
    private DoubleConverter doubleConverter1 = new DoubleConverter();

    public DoubleConverter getDoubleConverter1() {
        return doubleConverter1;
    }

    public void setDoubleConverter1(DoubleConverter dc) {
        this.doubleConverter1 = dc;
    }
    private NumberConverter numberConverter1 = new NumberConverter();

    public NumberConverter getNumberConverter1() {
        return numberConverter1;
    }

    public void setNumberConverter1(NumberConverter nc) {
        this.numberConverter1 = nc;
    }
    private NumberConverter numberConverter2 = new NumberConverter();

    public NumberConverter getNumberConverter2() {
        return numberConverter2;
    }

    public void setNumberConverter2(NumberConverter nc) {
        this.numberConverter2 = nc;
    }
    private NumberConverter numberConverter3 = new NumberConverter();

    public NumberConverter getNumberConverter3() {
        return numberConverter3;
    }

    public void setNumberConverter3(NumberConverter nc) {
        this.numberConverter3 = nc;
    }
    private TextField uiCierrePrecioActual = new TextField();

    public TextField getUiCierrePrecioActual() {
        return uiCierrePrecioActual;
    }

    public void setUiCierrePrecioActual(TextField tf) {
        this.uiCierrePrecioActual = tf;
    }
    private TextField uiCierreCostoActualPrecio = new TextField();

    public TextField getUiCierreCostoActualPrecio() {
        return uiCierreCostoActualPrecio;
    }

    public void setUiCierreCostoActualPrecio(TextField tf) {
        this.uiCierreCostoActualPrecio = tf;
    }
    private TextField uiCierreMargen = new TextField();

    public TextField getUiCierreMargen() {
        return uiCierreMargen;
    }

    public void setUiCierreMargen(TextField tf) {
        this.uiCierreMargen = tf;
    }
    private TextField uiCierrePrecioNuevo = new TextField();

    public TextField getUiCierrePrecioNuevo() {
        return uiCierrePrecioNuevo;
    }

    public void setUiCierrePrecioNuevo(TextField tf) {
        this.uiCierrePrecioNuevo = tf;
    }
    private TableColumn tableColumn14 = new TableColumn();

    public TableColumn getTableColumn14() {
        return tableColumn14;
    }

    public void setTableColumn14(TableColumn tc) {
        this.tableColumn14 = tc;
    }
    private TableColumn tableColumn15 = new TableColumn();

    public TableColumn getTableColumn15() {
        return tableColumn15;
    }

    public void setTableColumn15(TableColumn tc) {
        this.tableColumn15 = tc;
    }
    private Checkbox uiChekActualizarCosto = new Checkbox();

    public Checkbox getUiChekActualizarCosto() {
        return uiChekActualizarCosto;
    }

    public void setUiChekActualizarCosto(Checkbox c) {
        this.uiChekActualizarCosto = c;
    }
    private Checkbox uiCheckActualizarPrecio = new Checkbox();

    public Checkbox getUiCheckActualizarPrecio() {
        return uiCheckActualizarPrecio;
    }

    public void setUiCheckActualizarPrecio(Checkbox c) {
        this.uiCheckActualizarPrecio = c;
    }
    private NumberConverter numberConverter4 = new NumberConverter();

    public NumberConverter getNumberConverter4() {
        return numberConverter4;
    }

    public void setNumberConverter4(NumberConverter nc) {
        this.numberConverter4 = nc;
    }
    private NumberConverter numberConverter5 = new NumberConverter();

    public NumberConverter getNumberConverter5() {
        return numberConverter5;
    }

    public void setNumberConverter5(NumberConverter nc) {
        this.numberConverter5 = nc;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RegistroEstadosOT() {
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

    getSessionBean1().setTituloPagina("Registro de Cambio de Estados de OT y SUBOT");
    getSessionBean1().setDetallePagina("Activacion, Terminado y Cierre");
    cargarlistaTodosOrdenTrabajoCabeceras();

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
    private boolean addRequest = false;
    private boolean updateRequest = false;
    private boolean cierreRequest = false;
    private boolean errorValidacion = false;
    private boolean generarSolicitudes = false;

  //MANEJO DE LOS DETALLES

private OrdenTrabajo ordenTrabajoEditada;
private OrdenTrabajoDetalle[] detallesOrdenTrabajo;
private OrdenTrabajoDetalle  detalleOrdenTrabajo;
private List<OrdenTrabajoDetalle>  detalleOrdenTrabajoList;

private List<SolicitudInterna> solicitudesList;
private SolicitudInterna[] solicitudesAGenerarse;

private List<RecursoAsignado>  recursoAsignadoMostradoList;


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


    @Override
    public void prerender() {
 if (getSessionBean1().getUsuarioLogueado() == null)
        {
            HttpServletResponse response = (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
                    try {
                        response.sendRedirect("/Platinum/faces/Acceso.jsp");
                        getFacesContext().responseComplete();
                    } catch (IOException ex) {
                        Logger.getLogger(cabecera.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }else if(!getSessionBean1().getUsuarioLogueado().getRol().toString().equals("SUP_PRODUCCION")
                &&!getSessionBean1().getUsuarioLogueado().getRol().toString().equals("ADMINISTRADOR")){
            HttpServletResponse response = (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
                    try {
                        response.sendRedirect("/Platinum/faces/PermisoDenegado.jsp");
                        getFacesContext().responseComplete();
                    } catch (IOException ex) {
                        Logger.getLogger(cabecera.class.getName()).log(Level.SEVERE, null, ex);
                    }


        }

         if (generarSolicitudes) {
            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.gridPanelCierreOT.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(true);

            this.gridPanelGenerarSolicitudes1.setRendered(true);


         }else if (updateRequest) {
            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.gridPanelCierreOT.setRendered(false);
            this.gridPanelGenerarSolicitudes1.setRendered(false);
            this.pageAlert1.setRendered(false);

         } else if (cierreRequest) {
            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.gridPanelCierreOT.setRendered(true);
            this.gridPanelGenerarSolicitudes1.setRendered(false);

        } else if (errorValidacion) {
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.gridPanelCierreOT.setRendered(false);

            this.gridPanelGenerarSolicitudes1.setRendered(false);

        } else {

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.gridPanelCierreOT.setRendered(false);
            this.gridPanelGenerarSolicitudes1.setRendered(false);

                getSessionBean1().setTituloPagina("Registro de Cambio de Estados de OT y SUBOT");
                getSessionBean1().setDetallePagina("Activacion, Terminado y Cierre");
        }
 buscar_action2();
    }
 public void limpiarCamposNew(){

      }
 private long idEditado;

    public long getIdEditado() {
        return idEditado;
    }

    public void setIdEditado(long idEditado) {
        this.idEditado = idEditado;
    }


  public void cargarCamposUpdate(){

         if (getOrdenTrabajoRW().getSelectedRowsCount() > 0) {
                RowKey[] selectedRowKeys = getOrdenTrabajoRW().getSelectedRowKeys();
                OrdenTrabajo[] ordenesDeTrabajoCabeceras = this.listaOrdenTrabajoCabeceras;
                int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
                OrdenTrabajo ordenTrabajo = ordenesDeTrabajoCabeceras[rowId];
                ordenTrabajoEditada =ordenesDeTrabajoCabeceras[rowId];
                idEditado = (ordenTrabajo.getCodOrdenTrabjo());


                 //// CARGA DE CAMPOS DE LA PAGINA
                 this.uiNroOt.setText(ordenTrabajo.getCodOrdenTrabjo().toString() );
                 this.uiProductoCod.setText(ordenTrabajo.getCodProductoOt().getCodProducto().toString());
                 this.uiProductoNombre.setText(ordenTrabajo.getCodProductoOt().getDescripcion().toString());

                 if (ordenTrabajo.getEstadoOt().toString().equals("A")) {
                    this.uiEstado.setText("Abierto");
                 } else if (ordenTrabajo.getEstadoOt().toString().equals("P")){
                    this.uiEstado.setText("En Proceso");
                 } else if (ordenTrabajo.getEstadoOt().toString().equals("T")){
                    this.uiEstado.setText("Terminado");
                 } else if (ordenTrabajo.getEstadoOt().toString().equals("C")){
                    this.uiEstado.setText("Cerrado");
                 }
                 
                 this.uiDescripcionOt1.setText(ordenTrabajo.getDescripcion().toString());
                 this.uiCantidad1.setText(ordenTrabajo.getCantidadOt().toString());
                 this.uiCantidadProducida1.setText(ordenTrabajo.getCantidadProducidaOt().toString());
                 this.uiFechaIni1.setSelectedDate(ordenTrabajo.getFechaOt());
                 this.uiFechaFin1.setSelectedDate(ordenTrabajo.getFechaFinOt());


                 detalleOrdenTrabajoList = ordenTrabajo.getOrdenTrabajoDetalleListList();
                 detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);



    }
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
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

   
    public String editar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.updateRequest=true;
        this.buttonGuardarEdicion.setRendered(true);
        recursoAsignadoMostradoList = new ArrayList();

 getSessionBean1().setTituloPagina("Registro de Cambio de Estados de OT y SUBOT");
    getSessionBean1().setDetallePagina("Activacion, Terminado y Cierre");
        this.pageAlert1.setRendered(false);
        cargarCamposUpdate();
        limpiarDetalleOt();
    
        return null;

    }
 public void limpiarDetalleOt(){

}
  

    public String cancelar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequest=false;
        this.updateRequest=false;
        this.cierreRequest=false;

        return null;
    }

    public void validarCampos() {
    errorValidacion = false;

}



private String buscar_action2() {

        OrdenTrabajo[] listaOrdenTrabajos;
        OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();

        String pNumeroOrdenTrabajo=null;
        if (this.uiCodigoFil.getText() != null &&
                            StringUtils.esNumero(this.uiCodigoFil.getText().toString())) {
                            pNumeroOrdenTrabajo = this.uiCodigoFil.getText().toString();
        }

        listaOrdenTrabajoCabeceras = (OrdenTrabajo[]) ordenTrabajoCabeceraController.getAllFiltered
                                        (pNumeroOrdenTrabajo,
                                         null,
                                         null,
                                         null).toArray(new OrdenTrabajo[0]);

        setlistaOrdenTrabajoCabeceras(listaOrdenTrabajoCabeceras);
        return null;

    }


        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
    public String buscar_action() {
        this.pageAlert1.setRendered(false);
        return null;
    }

    public String todos_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.pageAlert1.setRendered(false);
        getSessionBean1().cargarListaTodosUnidadMedidas();
        this.uiCodigoFil.setText("");
        
        return null;
    }


 ///// CODIGO PARA RADIO BUTTON DE LA GRILLA DE BUSQUEDA
   private TableSelectPhaseListener tablePhaseListener =
                                  new TableSelectPhaseListener();

    public void setSelected(Object object) {
        RowKey rowKey = (RowKey)getValue("#{currentRow.tableRow}");
        if (rowKey != null) {
            tablePhaseListener.setSelected(rowKey, object);
        }
    }

    public Object getSelected(){
        RowKey rowKey = (RowKey)getValue("#{currentRow.tableRow}");
        return tablePhaseListener.getSelected(rowKey);

    }

    public Object getSelectedValue() {
        RowKey rowKey = (RowKey)getValue("#{currentRow.tableRow}");
        return (rowKey != null) ? rowKey.getRowId() : null;

    }

    public boolean getSelectedState() {
        RowKey rowKey = (RowKey)getValue("#{currentRow.tableRow}");
        return tablePhaseListener.isSelected(rowKey);
    }

    public String buttonGuardarEdicion1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        ControllerResult controllerResult = new ControllerResult();

        OrdenTrabajoCabeceraController otControler = new  OrdenTrabajoCabeceraController();
        controllerResult = otControler.updateCabDet(ordenTrabajoEditada, detallesOrdenTrabajo, new OrdenTrabajoDetalle[0], new TareaAsignada[0], new RecursoAsignado[0]);




             if (controllerResult.getCodRetorno() ==-1) {
                    this.pageAlert1.setType("error");
                    this.errorValidacion=true;
                } else {
                    updateRequest = false;
                    this.pageAlert1.setType("information");
                }

                this.pageAlert1.setTitle(controllerResult.getMsg());
                this.pageAlert1.setSummary("");
                this.pageAlert1.setDetail("");
                this.pageAlert1.setRendered(true);
        
        return null;
    }

    public void uiProducto_processValueChange(ValueChangeEvent event) {
    }

    public boolean isAddRequest() {
        return addRequest;
    }

    public void setAddRequest(boolean addRequest) {
        this.addRequest = addRequest;
    }

    public OrdenTrabajoDetalle getDetalleOrdenTrabajo() {
        return detalleOrdenTrabajo;
    }

    public void setDetalleOrdenTrabajo(OrdenTrabajoDetalle detalleOrdenTrabajo) {
        this.detalleOrdenTrabajo = detalleOrdenTrabajo;
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

    public boolean isErrorValidacion() {
        return errorValidacion;
    }

    public void setErrorValidacion(boolean errorValidacion) {
        this.errorValidacion = errorValidacion;
    }

    public OrdenTrabajo[] getListaOrdenTrabajoCabeceras() {
        return listaOrdenTrabajoCabeceras;
    }

    public void setListaOrdenTrabajoCabeceras(OrdenTrabajo[] listaOrdenTrabajoCabeceras) {
        this.listaOrdenTrabajoCabeceras = listaOrdenTrabajoCabeceras;
    }

    public OrdenTrabajo getOrdenTrabajoEditada() {
        return ordenTrabajoEditada;
    }

    public void setOrdenTrabajoEditada(OrdenTrabajo ordenTrabajoEditada) {
        this.ordenTrabajoEditada = ordenTrabajoEditada;
    }

    public SolicitudInterna[] getSolicitudesAGenerarse() {
        return solicitudesAGenerarse;
    }

    public void setSolicitudesAGenerarse(SolicitudInterna[] solicitudesAGenerarse) {
        this.solicitudesAGenerarse = solicitudesAGenerarse;
    }

    public List<SolicitudInterna> getSolicitudesList() {
        return solicitudesList;
    }

    public void setSolicitudesList(List<SolicitudInterna> solicitudesList) {
        this.solicitudesList = solicitudesList;
    }

    public TableSelectPhaseListener getTablePhaseListener() {
        return tablePhaseListener;
    }

    public void setTablePhaseListener(TableSelectPhaseListener tablePhaseListener) {
        this.tablePhaseListener = tablePhaseListener;
    }

    public boolean isUpdateRequest() {
        return updateRequest;
    }

    public void setUpdateRequest(boolean updateRequest) {
        this.updateRequest = updateRequest;
    }

      private String itemSolicitud;

    public String getItemSolicitud() {
        return itemSolicitud;
    }

    public void setItemSolicitud(String itemSolicitud) {
        this.itemSolicitud = itemSolicitud;
    }

    public boolean isCierreRequest() {
        return cierreRequest;
    }

    public void setCierreRequest(boolean cierreRequest) {
        this.cierreRequest = cierreRequest;
    }

    public boolean isGenerarSolicitudes() {
        return generarSolicitudes;
    }

    public void setGenerarSolicitudes(boolean generarSolicitudes) {
        this.generarSolicitudes = generarSolicitudes;
    }



 ///// FIN CODIGO PARA RADIO BUTTON DE LA GRILLA DE BUSQUEDA
 private String itemDetalleOt;

    public String getItemDetalleOt() {
        return itemDetalleOt;
    }

    public void setItemDetalleOt(String itemDetalleOt) {
        this.itemDetalleOt = itemDetalleOt;
    }

    public String uiActivarLynk_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
          detalleOrdenTrabajo = detalleOrdenTrabajoList.get(Integer.valueOf(itemDetalleOt).intValue());
          recursoAsignadoMostradoList = detalleOrdenTrabajo.getRecursoAsignadoListList();

          if (detalleOrdenTrabajo.getEstado().toString().equals("C")) {
            info("La SubOT no se puede Activar porque se ya encuentra cerrada");
          }else if (detalleOrdenTrabajo.getEstado().toString().equals("T")) {
                detalleOrdenTrabajo.setEstado("P");
                detalleOrdenTrabajo.setFechaAlta(new Date());
          }else if (detalleOrdenTrabajo.getEstado().toString().equals("P")){
            info("La SubOT ya se encuentra Activa");
          }else{
            detalleOrdenTrabajo.setEstado("P");
            ordenTrabajoEditada.setEstadoOt("P");
            this.uiEstado.setText("En Proceso");
            detalleOrdenTrabajo.setFechaAlta(new Date());


            ////// Verificacion de las existencias en deposito
            ////// para generar las solicitudes de Compra
            solicitudesList = new ArrayList();
            SolicitudInternaController solicitudInternaController = new SolicitudInternaController();

            EquivalenciaController equivalenciaController = new EquivalenciaController();
            List<RecursoAsignado> recursos = recursoAsignadoMostradoList;
            for (int i = 0; i < recursos.size(); i++) {
                RecursoAsignado recursoAsignado = recursos.get(i);
                Producto productoAsignado = recursoAsignado.getCodProducto();


                BigDecimal existencia = equivalenciaController.getCantExistPorProducto(productoAsignado.getCodProducto(), null);
                if (existencia == null) {
                    existencia = BigDecimal.valueOf(Long.valueOf("0"));
                }

                BigDecimal cantidadRec = BigDecimal.valueOf(recursoAsignado.getCantidad());

                if (cantidadRec.doubleValue() > existencia.doubleValue() ) {

                    SolicitudInterna solicitud = new SolicitudInterna();
                    solicitud.setCodProducto(productoAsignado);
                    Long cantidadComprar = Double.valueOf(Math.ceil(cantidadRec.doubleValue() - existencia.doubleValue())).longValue();
                    solicitud.setCantidad(cantidadComprar);
                    solicitud.setCodEmpleado(recursoAsignado.getCodOrdenTrabDet().getCodEmpleado());
                    solicitud.setEstado("P");
                    solicitud.setFecha(new Date());
                    
                    String observacion;
                    observacion = "Solicitud de Compra generada por Orden de Trabajo ";
                    observacion = observacion + detalleOrdenTrabajo.getCodOrdenTrabajo().getCodOrdenTrabjo().toString();
                    observacion = observacion + " SubOT: " + detalleOrdenTrabajo.getCodOrdenTrabajoDet().toString();
                    observacion = observacion + " Producto: " + productoAsignado.getDescripcion().toString();
                    
                    solicitud.setObservacion(observacion);
                    solicitudesList.add(solicitud);
                }

            }

            if (solicitudesList.size() > 0) {
                    solicitudesAGenerarse = (SolicitudInterna[]) solicitudesList.toArray(new SolicitudInterna[0]);
                    generarSolicitudes = true;
           }

        }


    return null;
    }

    public String uiCerrarLynk_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        detalleOrdenTrabajo = detalleOrdenTrabajoList.get(Integer.valueOf(itemDetalleOt).intValue());
          if (detalleOrdenTrabajo.getEstado().toString().equals("C")) {
            info("La SubOT no se puede Terminar porque se ya encuentra cerrada");
          }else if (detalleOrdenTrabajo.getEstado().toString().equals("T")) {
            info("La SubOT ya se encuentra Terminada");
          }else if (detalleOrdenTrabajo.getEstado().toString().equals("P")){
            detalleOrdenTrabajo.setEstado("T");
            detalleOrdenTrabajo.setFechaModif(new Date());
          }else{
            info("Antes de cerrar la Sub OT debe estar en Proceso");
          }


        return null;
    }

    public String uiLinkGenerarSolicitud_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
         ControllerResult controllerResult = new ControllerResult();

        SolicitudInterna solicitudInternaAGenerarse = new SolicitudInterna();
        solicitudInternaAGenerarse = solicitudesList.get(Integer.valueOf(itemSolicitud).intValue());

        SolicitudInternaController solicitudInternaController = new SolicitudInternaController();
        controllerResult = solicitudInternaController.create(solicitudInternaAGenerarse);

        if (controllerResult.getCodRetorno() != -1) {
            solicitudesList.remove(Integer.valueOf(itemSolicitud).intValue());
            solicitudesAGenerarse = (SolicitudInterna[]) solicitudesList.toArray(new SolicitudInterna[0]);

        }else{

        }
        return null;
    }

    public String uiButtonSolicitudVolver_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.generarSolicitudes = false;
        
        return null;
    }

    public String uiButtonTerminar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        boolean t = true;
        for (int i = 0; i < detallesOrdenTrabajo.length; i++) {
            OrdenTrabajoDetalle ordenTDet = detallesOrdenTrabajo[i];
            if (!ordenTDet.getEstado().toString().equals("T")) {
                    t = false;
                    break;
            }
        }


        if (t) {
            ordenTrabajoEditada.setEstadoOt("T");
            ordenTrabajoEditada.setFechaFinOt(new Date());
            ordenTrabajoEditada.setFechaModif(new Date());
            
            this.uiEstado.setText("Terminado");
            for (int i = 0; i < detallesOrdenTrabajo.length; i++) {
                OrdenTrabajoDetalle otDet = detallesOrdenTrabajo[i];
                otDet.setEstado("T");
                otDet.setFechaModif(new Date());
                otDet.setFechaFin(new Date());

            }
            

        }else{
            info("Para Terminar una OT todos las SubOT deben estar en estado Terminado");
            
        }
        return null;
    }

    public String uiBtnCierreOT_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
            // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        boolean t = true;
      
            if (!ordenTrabajoEditada.getEstadoOt().toString().equals("T")) {
                    t = false;
            }


        if (t) {

       
            Producto productoActual = new ProductoController().findById(ordenTrabajoEditada.getCodProductoOt().getCodProducto());

            this.uiCierreCostoActual.setText(productoActual.getCostoActual().toString());

            long exist = 0;
            exist = new ExistenciaController().getCantidadExistencia(Long.valueOf(productoActual.getCodProducto().toString())).longValue();
            this.uiCierreCantExistencia.setText(exist);

            this.uiCierreCantidadProducida.setText(ordenTrabajoEditada.getCantidadProducidaOt().toString());

            this.uiCierreCostoProduccion.setText(ordenTrabajoEditada.getCostoRealOt().toString());

      //      Long cantidadComprar = Double.valueOf(Math.ceil(cantidadRec.doubleValue() - existencia.doubleValue())).longValue();
            double costoRealOTVar = ordenTrabajoEditada.getCostoRealOt().doubleValue(); 
            double CantidadProducidaOtVar = ordenTrabajoEditada.getCantidadProducidaOt().doubleValue();
            
            if (costoRealOTVar == 0 || CantidadProducidaOtVar == 0) {
                if (costoRealOTVar == 0){
                    info("No se puede costear debido a que los costos de produccion son 0");
                } else{
                        info("No se puede costear debido a que la cantidad producida es 0");
                }
                
                  
            }else{
            
                    updateRequest = false;
                    cierreRequest = true;
                    this.buttonsPanelAddUpdate.setRendered(false);
                    this.tableColumn14.setRendered(false);
                    this.tableColumn15.setRendered(false);

                    
                    Double costoUnit = Math.ceil(Double.valueOf(ordenTrabajoEditada.getCostoRealOt().doubleValue() / ordenTrabajoEditada.getCantidadProducidaOt().doubleValue()));
                    this.uiCierreCostoProduccionUnitario.setText(costoUnit.longValue());


                    Double costoNuevo = Math.ceil(Double.valueOf((ordenTrabajoEditada.getCostoRealOt().doubleValue() + (productoActual.getCostoActual().doubleValue()*exist))/(exist+ordenTrabajoEditada.getCantidadProducidaOt().longValue())));
                    this.uiCierreCostoNuevo.setText(costoNuevo.longValue());
                    this.uiCierreCostoActualPrecio.setText(costoNuevo.longValue());

                    this.uiCierrePrecioActual.setText(productoActual.getPrecioActual().toString());
                    this.uiCierreMargen.setText("30");
                    Double nuevoPrecio = Math.ceil(costoNuevo * 130 / 100);
                    this.uiCierrePrecioNuevo.setText(nuevoPrecio.longValue());

            
            }




        }else{
            info("Para Cerrar la OT debe estar marcada como Terminada");
        }
        return null;
    }

    public String uiBtnCalcular_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        if (this.uiCierreMargen.getText() == null || this.uiCierreMargen.getText().toString().equals("")) {
                this.info("Favor ingrese el Margen Deseado");
        }else if (!StringUtils.esNumero(this.uiCierreMargen.getText().toString())){   errorValidacion = true;
                this.info("La cantidad debe ser campo numerico");
        }else{
            Double nuevoPrecio = Math.ceil(Double.valueOf(this.uiCierreCostoNuevo.getText().toString()) * (100+(Double.valueOf(this.uiCierreMargen.getText().toString()))) / 100);
            this.uiCierrePrecioNuevo.setText(nuevoPrecio.toString());

        }

        return null;
    }

    public String uiBtnCerrarGuardar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
           ControllerResult controllerResult = new ControllerResult();
           boolean actualizarCosto = false;
           if (uiChekActualizarCosto.isChecked()) {
             actualizarCosto = true;
           }

           boolean actualizarPrecio = false;
           if (uiCheckActualizarPrecio.isChecked()) {
             actualizarPrecio = true;
           }

           Double precioD = Double.valueOf(this.uiCierrePrecioNuevo.getText().toString());
           Double costoD = Double.valueOf(this.uiCierreCostoNuevo.getText().toString());

        OrdenTrabajoCabeceraController otControler = new  OrdenTrabajoCabeceraController();
        controllerResult = otControler.updateCierre(ordenTrabajoEditada, detallesOrdenTrabajo,BigInteger.valueOf(precioD.longValue()),BigInteger.valueOf(costoD.longValue()),actualizarCosto,actualizarPrecio);

             if (controllerResult.getCodRetorno() ==-1) {
                    this.pageAlert1.setType("error");

             } else {
                    cierreRequest = false;
                    updateRequest = false;
                    this.pageAlert1.setType("information");
                    this.buttonsPanelAddUpdate.setRendered(true);
                    this.tableColumn14.setRendered(true);
                    this.tableColumn15.setRendered(true);
                }

                this.pageAlert1.setTitle(controllerResult.getMsg());
                this.pageAlert1.setSummary("");
                this.pageAlert1.setDetail("");
                this.pageAlert1.setRendered(true);



        return null;
    }

    public String uiBtnCancelarCierre_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.buttonsPanelAddUpdate.setRendered(true);
        this.tableColumn14.setRendered(true);
        this.tableColumn15.setRendered(true);
        this.updateRequest = true;
        this.cierreRequest = false;


        return null;
    }

}

