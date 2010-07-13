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
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.ImageHyperlink;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.convert.NumberConverter;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import py.com.platinum.controller.DepositoController;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.EntradaSalidaCabeceraController;
import py.com.platinum.controller.EquivalenciaController;
import py.com.platinum.controller.ExistenciaController;
import py.com.platinum.controller.FormulaCabeceraController;
import py.com.platinum.controller.FormulaDetalleController;
import py.com.platinum.controller.FormulaSemiCabeceraController;
import py.com.platinum.controller.OrdenTrabajoDetalleController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.RecursoAsignadoController;
import py.com.platinum.controller.SolicitudInternaController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Deposito;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.EntradaSalidaCabecera;
import py.com.platinum.entity.EntradaSalidaDetalle;
import py.com.platinum.entity.Equivalencia;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.FormulaCabecera;
import py.com.platinum.entity.FormulaDetalle;
import py.com.platinum.entity.FormulaSemiCabecera;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.RecursoAsignado;
import py.com.platinum.entity.SolicitudInterna;
import py.com.platinum.utils.StringUtils;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Usuario.java
 * @version Created on 20-ago-2009, 19:25:56
 * @author MartinJara
 */
public class ABMMovimientosDeposito extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    
    
    private boolean addRequest = false;
    private boolean updateRequest = false;
    private boolean errorValidacion = false;
    private boolean editarDetalle = false;

    public boolean isAddRequest() {
        return addRequest;
    }

    public void setAddRequest(boolean addRequest) {
        this.addRequest = addRequest;
    }

    public List<EntradaSalidaDetalle> getDetalleEntradaSalidaList() {
        return detalleEntradaSalidaList;
    }

    public void setDetalleEntradaSalidaList(List<EntradaSalidaDetalle> detalleEntradaSalidaList) {
        this.detalleEntradaSalidaList = detalleEntradaSalidaList;
    }

    public boolean isEditarDetalle() {
        return editarDetalle;
    }

    public void setEditarDetalle(boolean editarDetalle) {
        this.editarDetalle = editarDetalle;
    }

    public boolean isErrorValidacion() {
        return errorValidacion;
    }

    public void setErrorValidacion(boolean errorValidacion) {
        this.errorValidacion = errorValidacion;
    }

    private void _init() throws Exception {
        numberConverter1.setMinIntegerDigits(1);
        numberConverter1.setMaxIntegerDigits(40);
        numberConverter1.setMaxFractionDigits(3);
        numberConverter2.setMinIntegerDigits(1);
        numberConverter2.setMaxIntegerDigits(50);
        numberConverter2.setLocale(new java.util.Locale("es", "", ""));
        numberConverter3.setMinIntegerDigits(1);
        numberConverter3.setMaxIntegerDigits(40);
        numberConverter3.setLocale(new java.util.Locale("es", "", ""));
        numberConverter3.setMaxFractionDigits(3);
        numberConverter4.setMinIntegerDigits(1);
        numberConverter4.setLocale(new java.util.Locale("es", "", ""));
  
       
        //table1.setWidth();
    }
    private HtmlPanelGrid mainContainer = new HtmlPanelGrid();

    public HtmlPanelGrid getMainContainer() {
        return mainContainer;
    }

    public void setMainContainer(HtmlPanelGrid hpg) {
        this.mainContainer = hpg;
    }
    private TableRowGroup formulasRW = new TableRowGroup();

    public TableRowGroup getFormulasRW() {
        return formulasRW;
    }

    public void setFormulasRW(TableRowGroup trg) {
        this.formulasRW = trg;
    }
    private HtmlPanelGrid addUpdatePanel = new HtmlPanelGrid();

    public HtmlPanelGrid getAddUpdatePanel() {
        return addUpdatePanel;
    }

    public void setAddUpdatePanel(HtmlPanelGrid hpg) {
        this.addUpdatePanel = hpg;
    }
    private TextField uiResponsableCodigo = new TextField();

    public TextField getUiResponsableCodigo() {
        return uiResponsableCodigo;
    }

    public void setUiResponsableCodigo(TextField tf) {
        this.uiResponsableCodigo = tf;
    }
    private Button addRecordButton = new Button();

    public Button getAddRecordButton() {
        return addRecordButton;
    }

    public void setAddRecordButton(Button b) {
        this.addRecordButton = b;
    }
    private Button cancelButton = new Button();

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button b) {
        this.cancelButton = b;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private Button buscarButton = new Button();

    public Button getBuscarButton() {
        return buscarButton;
    }

    public void setBuscarButton(Button b) {
        this.buscarButton = b;
    }
    private Button todosButton = new Button();

    public Button getTodosButton() {
        return todosButton;
    }

    public void setTodosButton(Button b) {
        this.todosButton = b;
    }
    private Table tablaFormulas = new Table();

    public Table getTablaFormulas() {
        return tablaFormulas;
    }

    public void setTablaFormulas(Table t) {
        this.tablaFormulas = t;
    }
    private HtmlPanelGrid gridPanelBuscar = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBuscar() {
        return gridPanelBuscar;
    }

    public void setGridPanelBuscar(HtmlPanelGrid hpg) {
        this.gridPanelBuscar = hpg;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TableColumn tableColumn12 = new TableColumn();

    public TableColumn getTableColumn12() {
        return tableColumn12;
    }

    public void setTableColumn12(TableColumn tc) {
        this.tableColumn12 = tc;
    }
    private TableRowGroup tableRowGroupDetalleFormula = new TableRowGroup();

    public TableRowGroup getTableRowGroupDetalleFormula() {
        return tableRowGroupDetalleFormula;
    }

    public void setTableRowGroupDetalleFormula(TableRowGroup trg) {
        this.tableRowGroupDetalleFormula = trg;
    }
    private Table tableDetalleFormula = new Table();

    public Table getTableDetalleFormula() {
        return tableDetalleFormula;
    }

    public void setTableDetalleFormula(Table t) {
        this.tableDetalleFormula = t;
    }
    private TextField uiDetalleCant = new TextField();

    public TextField getUiDetalleCant() {
        return uiDetalleCant;
    }

    public void setUiDetalleCant(TextField tf) {
        this.uiDetalleCant = tf;
    }
    private TextField uiDetalleProdCod = new TextField();

    public TextField getUiDetalleProdCod() {
        return uiDetalleProdCod;
    }

    public void setUiDetalleProdCod(TextField tf) {
        this.uiDetalleProdCod = tf;
    }
    private TextField uiResponsableNombre = new TextField();

    public TextField getUiResponsableNombre() {
        return uiResponsableNombre;
    }

    public void setUiResponsableNombre(TextField tf) {
        this.uiResponsableNombre = tf;
    }
    private TextField uiDetalleProdDesc = new TextField();

    public TextField getUiDetalleProdDesc() {
        return uiDetalleProdDesc;
    }

    public void setUiDetalleProdDesc(TextField tf) {
        this.uiDetalleProdDesc = tf;
    }
    private ImageHyperlink uiImageHyperlinkDel = new ImageHyperlink();

    public ImageHyperlink getUiImageHyperlinkDel() {
        return uiImageHyperlinkDel;
    }

    public void setUiImageHyperlinkDel(ImageHyperlink ih) {
        this.uiImageHyperlinkDel = ih;
    }
    private ImageHyperlink uiImageHyperlinkEdit = new ImageHyperlink();

    public ImageHyperlink getUiImageHyperlinkEdit() {
        return uiImageHyperlinkEdit;
    }

    public void setUiImageHyperlinkEdit(ImageHyperlink ih) {
        this.uiImageHyperlinkEdit = ih;
    }
    private HtmlPanelGrid gridPanelUser = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelUser() {
        return gridPanelUser;
    }

    public void setGridPanelUser(HtmlPanelGrid hpg) {
        this.gridPanelUser = hpg;
    }
    private Hyperlink uiHyperEmpleado1 = new Hyperlink();

    public Hyperlink getUiHyperEmpleado1() {
        return uiHyperEmpleado1;
    }

    public void setUiHyperEmpleado1(Hyperlink h) {
        this.uiHyperEmpleado1 = h;
    }
    private TextArea uiObservacion = new TextArea();

    public TextArea getUiObservacion() {
        return uiObservacion;
    }

    public void setUiObservacion(TextArea ta) {
        this.uiObservacion = ta;
    }
    private Calendar uiFecha = new Calendar();

    public Calendar getUiFecha() {
        return uiFecha;
    }

    public void setUiFecha(Calendar c) {
        this.uiFecha = c;
    }
    private Button updateRecordButton = new Button();

    public Button getUpdateRecordButton() {
        return updateRecordButton;
    }

    public void setUpdateRecordButton(Button b) {
        this.updateRecordButton = b;
    }
    private DropDown uiDepositoFil = new DropDown();

    public DropDown getUiDepositoFil() {
        return uiDepositoFil;
    }

    public void setUiDepositoFil(DropDown dd) {
        this.uiDepositoFil = dd;
    }
    private SingleSelectOptionsList uiDetalleTipoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiDetalleTipoDefaultOptions() {
        return uiDetalleTipoDefaultOptions;
    }

    public void setUiDetalleTipoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiDetalleTipoDefaultOptions = ssol;
    }
    private TextField uiResponsable2Codigo = new TextField();

    public TextField getUiResponsable2Codigo() {
        return uiResponsable2Codigo;
    }

    public void setUiResponsable2Codigo(TextField tf) {
        this.uiResponsable2Codigo = tf;
    }
    private TextField uiResponsableNombre1 = new TextField();

    public TextField getUiResponsableNombre1() {
        return uiResponsableNombre1;
    }

    public void setUiResponsableNombre1(TextField tf) {
        this.uiResponsableNombre1 = tf;
    }
    private DropDown uiDetalleTipo = new DropDown();

    public DropDown getUiDetalleTipo() {
        return uiDetalleTipo;
    }

    public void setUiDetalleTipo(DropDown dd) {
        this.uiDetalleTipo = dd;
    }
    private TextField uiDetalleCodSolic = new TextField();

    public TextField getUiDetalleCodSolic() {
        return uiDetalleCodSolic;
    }

    public void setUiDetalleCodSolic(TextField tf) {
        this.uiDetalleCodSolic = tf;
    }
    private TextField uiDetalleOTCod = new TextField();

    public TextField getUiDetalleOTCod() {
        return uiDetalleOTCod;
    }

    public void setUiDetalleOTCod(TextField tf) {
        this.uiDetalleOTCod = tf;
    }
    private DropDown uiDeposito = new DropDown();

    public DropDown getUiDeposito() {
        return uiDeposito;
    }

    public void setUiDeposito(DropDown dd) {
        this.uiDeposito = dd;
    }
    private TextField uiDetalleOTProducto = new TextField();

    public TextField getUiDetalleOTProducto() {
        return uiDetalleOTProducto;
    }

    public void setUiDetalleOTProducto(TextField tf) {
        this.uiDetalleOTProducto = tf;
    }
    private TextField uiDetalleSolicProduct = new TextField();

    public TextField getUiDetalleSolicProduct() {
        return uiDetalleSolicProduct;
    }

    public void setUiDetalleSolicProduct(TextField tf) {
        this.uiDetalleSolicProduct = tf;
    }
    private TableColumn tableColumn1 = new TableColumn();

    public TableColumn getTableColumn1() {
        return tableColumn1;
    }

    public void setTableColumn1(TableColumn tc) {
        this.tableColumn1 = tc;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private RadioButton radioButton2 = new RadioButton();

    public RadioButton getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(RadioButton rb) {
        this.radioButton2 = rb;
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
    private NumberConverter numberConverter4 = new NumberConverter();

    public NumberConverter getNumberConverter4() {
        return numberConverter4;
    }

    public void setNumberConverter4(NumberConverter nc) {
        this.numberConverter4 = nc;
    }
    private Calendar uiFechaFil = new Calendar();

    public Calendar getUiFechaFil() {
        return uiFechaFil;
    }

    public void setUiFechaFil(Calendar c) {
        this.uiFechaFil = c;
    }
    private DropDown uiEmpleadoFil = new DropDown();

    public DropDown getUiEmpleadoFil() {
        return uiEmpleadoFil;
    }

    public void setUiEmpleadoFil(DropDown dd) {
        this.uiEmpleadoFil = dd;
    }
    private Calendar uiFechaFil2 = new Calendar();

    public Calendar getUiFechaFil2() {
        return uiFechaFil2;
    }

    public void setUiFechaFil2(Calendar c) {
        this.uiFechaFil2 = c;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMMovimientosDeposito() {
          uiDetalleTipoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("E", "Entrada"), new com.sun.webui.jsf.model.Option("S", "Salida")});

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
            log("Usuario Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        getSessionBean1().setTituloPagina("Registro de Movimientos en Deposito");
        getSessionBean1().setDetallePagina("Entradas y salidas de Productos");
        cargarListaTodosMovimientosCab();

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
        }else if(!getSessionBean1().getUsuarioLogueado().getRol().toString().equals("DEPOSITO")
                 &&!getSessionBean1().getUsuarioLogueado().getRol().toString().equals("ADMINISTRADOR")){
            HttpServletResponse response = (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
                    try {
                        response.sendRedirect("/Platinum/faces/PermisoDenegado.jsp");
                        getFacesContext().responseComplete();
                    } catch (IOException ex) {
                        Logger.getLogger(cabecera.class.getName()).log(Level.SEVERE, null, ex);
                    }


        }



        cancelButton.setRendered(true);
        if (addRequest) {
            gridPanelBuscar.setRendered(false);
            tablaFormulas.setRendered(false);
//            buttonPanel.setRendered(false);
            addUpdatePanel.setRendered(true);
            addRecordButton.setRendered(true);
            updateRecordButton.setRendered(false);

//            limpiarCamposNew();


        } else if (updateRequest) {
           
                gridPanelBuscar.setRendered(false);
                tablaFormulas.setRendered(false);
//                buttonPanel.setRendered(false);
                addUpdatePanel.setRendered(true);
                addRecordButton.setRendered(false);
                updateRecordButton.setRendered(true);

        } else if(errorValidacion){
            addUpdatePanel.setRendered(true);
        }else {
            getSessionBean1().setTituloPagina("Registro de Movimientos en Deposito");
            getSessionBean1().setDetallePagina("Seleccione el registro deseado");
            gridPanelBuscar.setRendered(true);
            tablaFormulas.setRendered(true);
//            buttonPanel.setRendered(true);
            addUpdatePanel.setRendered(false);
        }
        // Refresh the users data array in the session bean to to show
    buscar_action2();
    }

    private Long codCabFormulaEditada;

    public Long getCodCabFormulaEditada() {
        return codCabFormulaEditada;
    }

    public void setCodCabFormulaEditada(Long codCabFormulaEditada) {
        this.codCabFormulaEditada = codCabFormulaEditada;
    }

    public void cargarCamposUpdate(){
         if (getTableRowGroup1().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
          EntradaSalidaCabecera[] entradaSalidaCabeceras = this.listaMovimientosCab;
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          EntradaSalidaCabecera entradaSalidaCabecera = entradaSalidaCabeceras[rowId];

          codCabFormulaEditada = entradaSalidaCabecera.getCodEntradaSalida();
         //// CARGA DE CAMPOS DE LA PAGINA

         this.uiResponsableCodigo.setText(entradaSalidaCabecera.getCodEncargado().getCodEmpleado().toString());
         this.uiResponsableNombre.setText(entradaSalidaCabecera.getCodEncargado().getNombreEmpleado().toString()+" "+entradaSalidaCabecera.getCodEncargado().getApellidoEmpleado().toString());
         this.uiResponsable2Codigo.setText(entradaSalidaCabecera.getCodEmpleado().getCodEmpleado().toString());
         this.uiResponsableNombre1.setText(entradaSalidaCabecera.getCodEmpleado().getNombreEmpleado().toString()+" "+entradaSalidaCabecera.getCodEmpleado().getApellidoEmpleado().toString());
         this.uiObservacion.setText(entradaSalidaCabecera.getObservacion().toString());
         this.uiDeposito.setSelected(entradaSalidaCabecera.getCodDeposito().getCodDeposito().toString());
         this.uiFecha.setSelectedDate(entradaSalidaCabecera.getFechaEntradaSalida());

         detalleEntradaSalidaList = new ArrayList();
         detalleEntradaSalidaList = entradaSalidaCabecera.getEntradaSalidaDetalleList();
         detallesEntradaSalida = (EntradaSalidaDetalle[]) detalleEntradaSalidaList.toArray(new EntradaSalidaDetalle[0]);

         this.uiDetalleProdCod.setDisabled(false);
         this.uiDetalleCodSolic.setDisabled(false);
         this.uiDetalleOTCod.setDisabled(false);

         }
}



    private String buscar_action2() {

        EntradaSalidaCabecera[] listaEntradaSalidaCabeceras;
        EntradaSalidaCabeceraController entradaSalidaController = new EntradaSalidaCabeceraController();

        String pEmpleado=null, pDeposito=null;
        Date pFecha1 = null, pFecha2=null;

        if (this.uiFechaFil.getSelectedDate() !=null) {
            pFecha1 = this.uiFechaFil.getSelectedDate();
        }
        if (this.uiFechaFil2.getSelectedDate() !=null) {
            pFecha2 = this.uiFechaFil2.getSelectedDate();
        }
        if (this.uiDepositoFil.getSelected()!=null) {
            pDeposito = this.uiDepositoFil.getSelected().toString();
        }
        if (this.uiEmpleadoFil.getSelected()!=null) {
            pEmpleado = this.uiEmpleadoFil.getSelected().toString();
        }


        listaEntradaSalidaCabeceras = 
                (EntradaSalidaCabecera[]) entradaSalidaController.getAllFiltered(null,pDeposito,pEmpleado,pFecha1,pFecha2).toArray(new EntradaSalidaCabecera[0]);

        
        setListaMovimientosCab(listaEntradaSalidaCabeceras);

        return null;

    }

     public String buscar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.pageAlert1.setRendered(false);
        return null;
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

      protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }
    private TableSelectPhaseListener tablePhaseListener =
            new TableSelectPhaseListener();

    public void setSelected(Object object) {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        if (rowKey != null) {
            tablePhaseListener.setSelected(rowKey, object);
        }
    }

    public Object getSelected() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.getSelected(rowKey);

    }

    public Object getSelectedValue() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return (rowKey != null) ? rowKey.getRowId() : null;

    }

    public boolean getSelectedState() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.isSelected(rowKey);
    }





    public String addRecordButton_action() {

        errorValidacion = validarCampos();

        //Si no hay error de validacion
        if (! errorValidacion){

//// CARGA DE LA CABECERA
          EntradaSalidaCabecera entradaSalidaCabecera = new EntradaSalidaCabecera();
          EntradaSalidaCabeceraController entradaSalidaCabeceraController = new EntradaSalidaCabeceraController();
          DepositoController depositoController = new DepositoController();
          EmpleadoController empleadoController = new EmpleadoController();

          entradaSalidaCabecera.setCodDeposito(depositoController.findById(Long.valueOf(this.uiDeposito.getSelected().toString())));
          entradaSalidaCabecera.setCodEncargado(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
          entradaSalidaCabecera.setCodEmpleado(empleadoController.findById(Long.valueOf(this.uiResponsable2Codigo.getText().toString())));
          entradaSalidaCabecera.setFechaEntradaSalida(this.uiFecha.getSelectedDate());
          entradaSalidaCabecera.setObservacion(this.uiObservacion.getText().toString());
          entradaSalidaCabecera.setFechaAlta(new Date());

         detallesEntradaSalida = (EntradaSalidaDetalle[]) detalleEntradaSalidaList.toArray(new EntradaSalidaDetalle[0]);

          entradaSalidaCabeceraController = new EntradaSalidaCabeceraController();
          ControllerResult controllerResult = new ControllerResult();
                            controllerResult = entradaSalidaCabeceraController.createCabDet(entradaSalidaCabecera,detallesEntradaSalida);
          

                            if (controllerResult.getCodRetorno() != -1) {
                                    addRequest = false;
                                    this.pageAlert1.setType("information");
                            }

                                this.pageAlert1.setTitle(controllerResult.getMsg());
                                this.pageAlert1.setSummary("");
                                this.pageAlert1.setDetail("");
                                this.pageAlert1.setRendered(true);
        }

        return null;
    }

    public String updateRecordButton_action() {
        //errorValidacion = validarCampos();
        errorValidacion = false;
        updateRequest = true;
        validarCampos();
        ControllerResult controllerResult = new ControllerResult();
        EntradaSalidaCabecera entradaSalidaCabecera = new EntradaSalidaCabecera();
        EntradaSalidaCabeceraController entradaSalidaCabeceraController = new EntradaSalidaCabeceraController();


        if (! errorValidacion){
            
                            entradaSalidaCabecera = new EntradaSalidaCabeceraController().findById(codCabFormulaEditada.longValue());
                            ProductoController productoController = new ProductoController();

                            DepositoController depositoController = new DepositoController();
                            EmpleadoController empleadoController = new EmpleadoController();

                            entradaSalidaCabecera.setCodDeposito(depositoController.findById(Long.valueOf(this.uiDeposito.getSelected().toString())));
                            entradaSalidaCabecera.setCodEncargado(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
                            entradaSalidaCabecera.setCodEmpleado(empleadoController.findById(Long.valueOf(this.uiResponsable2Codigo.getText().toString())));
                            entradaSalidaCabecera.setFechaEntradaSalida(this.uiFecha.getSelectedDate());
                            entradaSalidaCabecera.setObservacion(this.uiObservacion.getText().toString());

                            //formulaCabecera.setEstado("A");
                            EntradaSalidaDetalle[] entradaSalidaDetalleEliminada = (EntradaSalidaDetalle[]) detalleEntradaSalidaEliminadaList.toArray(new EntradaSalidaDetalle[0]);
                            detallesEntradaSalida = (EntradaSalidaDetalle[]) detalleEntradaSalidaList.toArray(new EntradaSalidaDetalle[0]);

                            controllerResult = entradaSalidaCabeceraController.updateCabDet(entradaSalidaCabecera, detallesEntradaSalida, entradaSalidaDetalleEliminada);



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




    }
 return null;
}

    public String cancelButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        addRequest = false;
        updateRequest = false;
        errorValidacion = false;
        return null;
    }
private boolean validarCampos(){
         errorValidacion = false;

            if (detallesEntradaSalida.length < 1){
                       errorValidacion = true;
                       this.info(uiDetalleProdDesc, "Debe agregar los detalles de la Entrada Salida");
            }else{

                         /// Recorrido del Detalle previo a la insercion para corroborar las cantidad con sus equivalencias
                         for (int i = 0; i < detallesEntradaSalida.length; i++) {
                                EntradaSalidaDetalle entSal = detallesEntradaSalida[i];
                                Producto p = null;
                                
                                ///VERIFICAMOS LA EXISTENCIA
                                
                                Deposito deposito = new DepositoController().findById(Long.valueOf(uiDeposito.getSelected().toString()));
                                Existencia existencia = new ExistenciaController().getExistencia(null, entSal.getCodProducto().getCodProducto(), deposito.getCodDeposito());
                                    if (existencia != null && entSal.getTipoEntradaSalida().equals("S") && existencia.getCantidadExistencia().longValue() < entSal.getCantidadEntSal().longValue()) {

                                            this.errorValidacion= true;
                                            String mensaje = "La cantidad ingresada del producto "+entSal.getCodProducto().getDescripcion().toString()+" no existe en Deposito";
                                            info(uiDetalleProdDesc, mensaje);
                                            break;
                                    }

                                /////
                                OrdenTrabajoDetalle otDet = null;
                                p = entSal.getCodProducto();

                                Long cantidad = null;
                                cantidad = Long.valueOf(entSal.getCantidadEntSal().toString());
                                if (entSal.getCodOrdenTrabajoDetalle() !=null && entSal.getCodOrdenTrabajoDetalle().getCodOrdenTrabajoDet() != null) {
                                    otDet = entSal.getCodOrdenTrabajoDetalle();
                                }

                                    if (!errorValidacion && otDet != null
                                            && p != null && cantidad != null
                                            && p != null
                                            && !p.getCodTipoProducto().getDescripcion().toString().equals("Terminado")
                                            && !p.getCodTipoProducto().getDescripcion().toString().equals("SemiTerminado")) {

                                        RecursoAsignado rAsignado = new RecursoAsignado();
                                        RecursoAsignadoController rController = new RecursoAsignadoController();
                                        rAsignado = rController.getRecursoPorEquiv(otDet.getCodOrdenTrabajoDet(),p.getCodProducto());
                                        if (rAsignado == null) {
                                            this.errorValidacion= true;
                                            String mensaje = "No está autorizado a retirar el Producto "+otDet.getCodProducto().getDescripcion().toString()+" por la OT seleccionada";
                                            info(uiDetalleProdDesc, mensaje);
                                            break;
                                        }else{
                                            Equivalencia eq = new EquivalenciaController().getEqPorProductos(rAsignado.getCodProducto().getCodProducto(), p.getCodProducto());
                                            double relacion = eq.getRelacion().doubleValue();
                                            double retirado = relacion * cantidad;
                                            if (rAsignado.getCantidadReal() + retirado > rAsignado.getCantidad()) {
                                                this.errorValidacion= true;
                                                String mensaje = "Ya se ha superado la cantidad asignada para la SUB-OT"+ otDet.getCodOrdenTrabajoDet() +" del Producto "+otDet.getCodProducto().getDescripcion().toString();
                                                info(uiDetalleProdDesc, mensaje);
                                                break;
                                            }

                                        }

                            }
                        }

                         //// fin recorrido de los detalles




            }

            if (this.uiResponsableCodigo.getText() == null ||
                    this.uiResponsableCodigo.getText().toString() == null ||
                    this.uiResponsableCodigo.getText().toString().equals("") || !StringUtils.esNumero(this.uiResponsableCodigo.getText().toString())){
                        errorValidacion = true;
                       this.info(uiResponsableCodigo, "Debe seleccionar un Responsable");
                }else{
                        Empleado e   = new EmpleadoController().findById(Long.valueOf(uiResponsableCodigo.getText().toString()));
                        if (e == null) {
                            this.errorValidacion= true;
                            info(uiResponsableCodigo, "Verifique el codigo del Empleado Responsable");
                        }

                }
            if (this.uiResponsable2Codigo.getText() == null ||
                    this.uiResponsable2Codigo.getText().toString() == null ||
                    this.uiResponsable2Codigo.getText().toString().equals("") || !StringUtils.esNumero(this.uiResponsable2Codigo.getText().toString())){
                        errorValidacion = true;
                       this.info(uiResponsable2Codigo, "Debe seleccionar un Responsable de retirar");
                }else{
                        Empleado e2 = new EmpleadoController().findById(Long.valueOf(uiResponsable2Codigo.getText().toString()));
                        if (e2 == null) {
                            this.errorValidacion= true;
                            info(uiResponsable2Codigo, "Verifique el codigo del Empleado Responsable del Retiro");
                        }
                }


             if (this.uiFecha.getSelectedDate() == null ||
                    this.uiFecha.getSelectedDate().toString() == null ||
                    this.uiFecha.getSelectedDate().toString().equals("")){
                        errorValidacion = true;
                       this.info(uiFecha, "Debe seleccionar la fecha");
                }



                  return errorValidacion;

}


///// CARGA DE COMBO BOX Formulas TERMINADOS
//////     import com.sun.webui.jsf.model.Option;

    EntradaSalidaCabecera[] listaMovimientosCab;

    public EntradaSalidaCabecera[] getListaMovimientosCab() {
        return listaMovimientosCab;
    }

    public void setListaMovimientosCab(EntradaSalidaCabecera[] listaMovimientosCab) {
        this.listaMovimientosCab = listaMovimientosCab;
    }

    public void cargarListaTodosMovimientosCab(){
        EntradaSalidaCabeceraController entradaSalidaCabeceraController = new EntradaSalidaCabeceraController();
        listaMovimientosCab = (EntradaSalidaCabecera[]) entradaSalidaCabeceraController.getAll("codOrdenTrabajoDetalle.codOrdenTrabajoDet").toArray(new EntradaSalidaCabecera[0]);
        }
////// FIN CARGA DE COMBO BOX Movimientos

////// MANEJO DE DETALLES DE Formulas

private EntradaSalidaDetalle[] detallesEntradaSalida;
private EntradaSalidaDetalle  detalleEntradaSalida;
private List<EntradaSalidaDetalle>  detalleEntradaSalidaList;
private List<EntradaSalidaDetalle>  detalleEntradaSalidaEliminadaList;

    public List<EntradaSalidaDetalle> getDetalleEntradaSalidaEliminadaList() {
        return detalleEntradaSalidaEliminadaList;
    }

    public void setDetalleEntradaSalidaEliminadaList(List<EntradaSalidaDetalle> detalleEntradaSalidaEliminadaList) {
        this.detalleEntradaSalidaEliminadaList = detalleEntradaSalidaEliminadaList;
    }

private EntradaSalidaCabecera cabeceraEntradaSalida;

    public EntradaSalidaCabecera getCabeceraEntradaSalida() {
        return cabeceraEntradaSalida;
    }

    public void setCabeceraFormula(EntradaSalidaCabecera cabeceraEntradaSalida) {
        this.cabeceraEntradaSalida = cabeceraEntradaSalida;
    }

    public EntradaSalidaDetalle getDetalleEntradaSalida() {
        return detalleEntradaSalida;
    }

    public void setDetalleEntradaSalida(EntradaSalidaDetalle detalleEntradaSalida) {
        this.detalleEntradaSalida = detalleEntradaSalida;
    }

    public EntradaSalidaDetalle[] getDetallesEntradaSalida() {
        return detallesEntradaSalida;
    }

    public void setDetallesEntradaSalida(EntradaSalidaDetalle[] detallesEntradaSalida) {
        this.detallesEntradaSalida = detallesEntradaSalida;
    }

    public String uiButtonAgregarDetalle_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        validarDetalle();

        if (!errorValidacion) {

            if (!editarDetalle){

                            Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetalleProdCod.getText().toString()));

                            OrdenTrabajoDetalleController ordenTrabajoDetalleController  = new OrdenTrabajoDetalleController ();
                            OrdenTrabajoDetalle ordenTDet = null;

                            SolicitudInternaController solicitudInternaController  = new SolicitudInternaController ();
                            SolicitudInterna solicitud = null;
                            
                            
                            if (uiDetalleOTCod.getText() != null  && !uiDetalleOTCod.getText().equals("")) {
                                    ordenTDet = ordenTrabajoDetalleController.findById(Long.valueOf(Long.valueOf(this.uiDetalleOTCod.getText().toString())));
                            }
                            if (uiDetalleCodSolic.getText() != null && !uiDetalleCodSolic.getText().equals("")) {
                                    solicitud = solicitudInternaController.findById(Long.valueOf(Long.valueOf(this.uiDetalleCodSolic.getText().toString())));
                            }
                            

                           detalleEntradaSalida = new EntradaSalidaDetalle();
                           detalleEntradaSalida.setCodProducto(producto);
                           detalleEntradaSalida.setCantidadEntSal(BigInteger.valueOf(Long.valueOf(this.uiDetalleCant.getText().toString())));
                           detalleEntradaSalida.setTipoEntradaSalida(this.uiDetalleTipo.getSelected().toString());

                           if (ordenTDet != null) {
                           detalleEntradaSalida.setCodOrdenTrabajoDetalle(ordenTDet);
                            }

                           if (solicitud != null) {
                            detalleEntradaSalida.setCodSolicitud(solicitud);
                           }
                           detalleEntradaSalida.setFechaAlta(this.uiFecha.getSelectedDate());
                           detalleEntradaSalidaList.add(detalleEntradaSalida);
            }else{

                this.uiDetalleProdCod.setDisabled(false);
                this.uiDetalleCodSolic.setDisabled(false);
                this.uiDetalleOTCod.setDisabled(false);

                 editarDetalle = false;
                 Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetalleProdCod.getText().toString()));

                            OrdenTrabajoDetalleController ordenTrabajoDetalleController  = new OrdenTrabajoDetalleController ();
                            OrdenTrabajoDetalle ordenTDet = null;

                            SolicitudInternaController solicitudInternaController  = new SolicitudInternaController ();
                            SolicitudInterna solicitud = null;


                            if (uiDetalleOTCod.getText() != null  && !uiDetalleOTCod.getText().equals("")) {
                                    ordenTDet = ordenTrabajoDetalleController.findById(Long.valueOf(Long.valueOf(this.uiDetalleOTCod.getText().toString())));
                            }
                            if (uiDetalleCodSolic.getText() != null && !uiDetalleCodSolic.getText().equals("")) {
                                    solicitud = solicitudInternaController.findById(Long.valueOf(Long.valueOf(this.uiDetalleCodSolic.getText().toString())));
                            }
                           EntradaSalidaDetalle entradaSalidaDetalle = detalleEntradaSalidaList.get(Integer.valueOf(itemDet).intValue());
                           entradaSalidaDetalle.setCodProducto(producto);
                           entradaSalidaDetalle.setCantidadEntSal(BigInteger.valueOf(Long.valueOf(this.uiDetalleCant.getText().toString())));
                           entradaSalidaDetalle.setTipoEntradaSalida(this.uiDetalleTipo.getSelected().toString());
                           entradaSalidaDetalle.setFechaAlta(this.uiFecha.getSelectedDate());
                           if (ordenTDet != null) {
                                entradaSalidaDetalle.setCodOrdenTrabajoDetalle(ordenTDet);
                           }
                           if (solicitud != null) {
                            entradaSalidaDetalle.setCodSolicitud(solicitud);
                           }
            
           }
           detallesEntradaSalida = (EntradaSalidaDetalle[]) detalleEntradaSalidaList.toArray(new EntradaSalidaDetalle[0]);
           limpiarDetalle();
        }

        return null;
    }

public void validarDetalle(){

    Producto p = null;
    OrdenTrabajoDetalle otDet = null;

    this.errorValidacion= false;
if (uiDetalleProdCod.getText() == null || uiDetalleProdCod.getText().equals("") || !StringUtils.esNumero(this.uiDetalleProdCod.getText().toString())) {
        this.errorValidacion= true;
        info(uiDetalleProdDesc, "Verifique el codigo de Producto");
}else{
     p = new ProductoController().findById(Long.valueOf(uiDetalleProdCod.getText().toString()));
     if (p == null) {
         this.errorValidacion= true;
         info(uiDetalleProdDesc, "Verifique el codigo de Producto");
     }else{
         if (p.getCodTipoProducto().getDescripcion().toString().equals("ProductoGenerico")) {
             this.errorValidacion= true;
             info(uiDetalleProdDesc, "Verifique el producto, producto generico");
         }else if(p.getCodTipoProducto().getDescripcion().equals("Terminado")
                    && this.uiDetalleTipo.getSelected().toString().equals("S")
                        && this.uiDetalleOTCod.getText() != null){
                this.errorValidacion= true;
                info(uiDetalleProdDesc, "No se puede dar de salida un Producto Final desde una OT");
         }else if(!p.getCodTipoProducto().getDescripcion().equals("Terminado")
             && !p.getCodTipoProducto().getDescripcion().equals("SemiTerminado")
             && !p.getCodTipoProducto().getDescripcion().equals("ProductoGenerico")
             && this.uiDetalleTipo.getSelected().toString().equals("E")
             && this.uiDetalleOTCod.getText() != null
             && !this.uiDetalleOTCod.getText().toString().equals("")){
                        this.errorValidacion= true;
                        info(uiDetalleProdDesc, "No se puede dar de entrada a un Insumo o Materia Prima desde una OT");
         }else if (detalleEntradaSalidaList != null && detalleEntradaSalidaList.size() > 0 && !editarDetalle) {
             for (int i = 0; i < detalleEntradaSalidaList.size(); i++) {
                 EntradaSalidaDetalle entSalDeta = detalleEntradaSalidaList.get(i);
                 if (entSalDeta.getCodProducto().getCodProducto().equals(p.getCodProducto()) ) {
                              this.errorValidacion= true;
                              info(uiDetalleProdDesc, "El codigo de Producto no puede ser repetido");
                              break;
                 }
             }

         }

     }
}
Long cantidad = null;
    if (!errorValidacion) {

                if (uiDetalleCant.getText() == null || uiDetalleCant.getText().equals("") ||!StringUtils.esNumero(this.uiDetalleCant.getText().toString()) ) {
                        this.errorValidacion= true;
                        info(uiDetalleProdDesc, "Verifique la cantidad");
                }else{
                    String cant = uiDetalleCant.getText().toString();
                    if(!StringUtils.esNumero(cant)){
                        this.errorValidacion= true;
                        info(uiDetalleProdDesc, "La Cantidad debe ser numerico");

                //    }else if(StringUtils.esNumeroDecimal(cant)){
                //        this.errorValidacion= true;
                //        info(uiDetalleProdDesc, "La Cantidad debe ser entero");
                    }else{
                        cantidad = Long.valueOf(uiDetalleCant.getText().toString());
                    }
                }

                //
                //        if (uiDetalleCodSolic.getText() != null && !uiDetalleCodSolic.getText().equals("")){
                //              if (StringUtils.esNumero(this.uiDetalleCodSolic.getText().toString())){
                //                        SolicitudInterna sol = new SolicitudInternaController().findById(Long.valueOf(uiDetalleCodSolic.getText().toString()));
                //                        if (sol == null ) {
                //                             this.errorValidacion= true;
                //                             info(uiDetalleProdDesc, "Verifique el codigo se Solicitud");
                //                        }
                //
                //              }else{
                //                             this.errorValidacion= true;
                //                             info(uiDetalleProdDesc, "Verifique el codigo se Solicitud");
                //              }
                //        }

}
        if (!errorValidacion && uiDetalleOTCod.getText() != null && !uiDetalleOTCod.getText().equals("") && p != null){


            if (StringUtils.esNumero(this.uiDetalleOTCod.getText().toString())){
                    otDet = new OrdenTrabajoDetalleController().findById(Long.valueOf(uiDetalleOTCod.getText().toString()));
                    if (otDet == null) {
                         this.errorValidacion= true;
                         info(uiDetalleProdDesc, "Verifique el codigo de OT");
                    }else{
                        if(!otDet.getEstado().toString().equals("P") && uiDetalleTipo.getSelected().toString().equals("S")){
                         this.errorValidacion= true;
                         info(uiDetalleProdDesc, "El codigo de OT no se encuentra en Proceso. No puede retirar ningun Producto");
                        }else if(!otDet.getEstado().toString().equals("P") && uiDetalleTipo.getSelected().toString().equals("S")){


                        }else if(p.getCodTipoProducto().getDescripcion().toString().equals("Terminado") && otDet.getCodOrdenTrabajo().getCodProductoOt().getCodProducto().longValue() != p.getCodProducto().longValue()){
                            this.errorValidacion= true;
                            info(uiDetalleProdDesc, "El codigo de Producto Final no corresponde a al producto en proceso de la OT seleccionada");
                        }
                    }
            }else{

                         this.errorValidacion= true;
                         info(uiDetalleProdDesc, "Verifique el codigo de OT");

            }
        }

    if (!errorValidacion && otDet != null 
            && p != null && cantidad != null
            && p != null && !p.getCodTipoProducto().getDescripcion().toString().equals("ProductoGenerico")
            && !p.getCodTipoProducto().getDescripcion().toString().equals("Terminado")
            && !p.getCodTipoProducto().getDescripcion().toString().equals("SemiTerminado")) {

            RecursoAsignado rAsignado = new RecursoAsignado();
            RecursoAsignadoController rController = new RecursoAsignadoController();
            rAsignado = rController.getRecursoPorEquiv(otDet.getCodOrdenTrabajoDet(),p.getCodProducto());
            if (rAsignado == null) {
                this.errorValidacion= true;
                info(uiDetalleProdDesc, "No está autorizado a retirar el Producto por la OT seleccionada");
            }else{
                Equivalencia eq = new EquivalenciaController().getEqPorProductos(rAsignado.getCodProducto().getCodProducto(), p.getCodProducto());
                double relacion = eq.getRelacion().doubleValue();
                double retirado = relacion * cantidad;
                if (rAsignado.getCantidadReal() + retirado > rAsignado.getCantidad()) {
                    this.errorValidacion= true;
                    info(uiDetalleProdDesc, "Ya se ha superado la cantidad asignada para la SUB-OT");

                }

            }


    }

}
public void limpiarDetalle(){

this.uiDetalleCant.setText("");
this.uiDetalleProdCod.setText("");
this.uiDetalleProdDesc.setText("");
this.uiDetalleCodSolic.setText("");
this.uiDetalleCant.setText("");
this.uiDetalleCodSolic.setText("");
this.uiDetalleTipo.setSelected("E");
//this.uiDetalleFormula.setText("");
//this.uiDetalleCodFormula.setText("");

}





private String itemDet;

    public String getItemDet() {
        return itemDet;
    }

    public void setItemDet(String itemDet) {
        this.itemDet = itemDet;
    }

    public String buscarButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        buscar_action();
        return null;
    }

    public String todosButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.uiDepositoFil.setSelected("");
        this.uiEmpleadoFil.setSelected("");
        this.uiFechaFil.setSelectedDate(null);
        this.uiFechaFil2.setSelectedDate(null);


        return null;
    }

    public String addButton1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        detalleEntradaSalidaList = new ArrayList();
        detallesEntradaSalida = (EntradaSalidaDetalle[]) detalleEntradaSalidaList.toArray(new EntradaSalidaDetalle[0]);
        addRequest = true;
        getSessionBean1().setTituloPagina("Registro de Entradas y Salidas del Deposito");
        getSessionBean1().setDetallePagina("Registrar nuevos movimientos en deposito");
        uiResponsableCodigo.setText("");
        uiResponsableNombre.setText("");
        uiResponsable2Codigo.setText("");
        uiResponsableNombre1.setText("");
        
        uiFecha.setSelectedDate(new Date());
        uiObservacion.setText("");

        limpiarDetalle();

            this.uiDetalleProdCod.setDisabled(false);
            this.uiDetalleCodSolic.setDisabled(false);
            this.uiDetalleOTCod.setDisabled(false);

        this.addRecordButton.setRendered(true);
        this.updateRecordButton.setRendered(false);


        return null;


    }

    public String updateButton1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

            detalleEntradaSalidaList = new ArrayList();
            detalleEntradaSalidaEliminadaList = new ArrayList();
        getSessionBean1().setTituloPagina("Editar un movimiento en deposito");
        getSessionBean1().setDetallePagina("Con sus respectivos detalles de productos y movimientos");
        this.pageAlert1.setRendered(false);
        this.updateRequest=true;
        this.addRecordButton.setRendered(false);
        this.updateRecordButton.setRendered(true);
        this.codCabFormulaEditada = null;

        cargarCamposUpdate();
        limpiarDetalle();


        return null;
    }

    public String deleteButton1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

          if (getTableRowGroup1().getSelectedRowsCount() > 0){
              RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
              EntradaSalidaCabecera[] entradaSalidaCabeceras = this.listaMovimientosCab;
              int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
              EntradaSalidaCabecera entradaSalidaCabecera = entradaSalidaCabeceras[rowId];
              EntradaSalidaCabeceraController entSalCont = new EntradaSalidaCabeceraController();
              codCabFormulaEditada = entradaSalidaCabecera.getCodEntradaSalida();

                detalleEntradaSalidaList = new ArrayList();
                detalleEntradaSalidaList = entradaSalidaCabecera.getEntradaSalidaDetalleList();
                detallesEntradaSalida = (EntradaSalidaDetalle[]) detalleEntradaSalidaList.toArray(new EntradaSalidaDetalle[0]);

                ControllerResult controllerResult = new ControllerResult();
                if (entradaSalidaCabecera.getCodPerdida() != null){
                        controllerResult.setCodRetorno(-1);
                        controllerResult.setMsg("No se puede anular un Movimiento auto generado por una perdida. Debe anular la Perdida");
                }else if(entradaSalidaCabecera.getNroComprobante() != null) {
                        controllerResult.setCodRetorno(-1);
                        controllerResult.setMsg("No se puede anular un Movimiento auto generado por una factura de compra. Debe anular la Factura");
                }else{
                        controllerResult = entSalCont.anularCabDet(entradaSalidaCabecera, detallesEntradaSalida);
                }

            if (controllerResult.getCodRetorno() ==-1) {
                        this.pageAlert1.setType("error");
                    } else {
                        this.pageAlert1.setType("information");
           }

            this.pageAlert1.setTitle(controllerResult.getMsg());
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);



          }
        //          if (getFormulasRW().getSelectedRowsCount() > 0) {
//                RowKey[] selectedRowKeys = getFormulasRW().getSelectedRowKeys();
//                FormulaCabecera[] formulasCabecera = this.listaFormulaCabeceras;
//                int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
//                FormulaCabecera formulaCabecera = formulasCabecera[rowId];
//
//                FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();
//                getSessionBean1().setId(formulaCabecera.getCodFormula());
//
//                //// ELIMINACION DE LOS DETALLES
//                        detalleFormulaList = new ArrayList();
//                        detalleFormulaList = formulaCabecera.getFormulaDetalleCollection();
//                        detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);
//                        ControllerResult controllerResult = new ControllerResult();
//                        controllerResult = formulaCabeceraController.deleteCabDet(formulaCabecera, detallesFormula);
//
//            if (controllerResult.getCodRetorno() ==-1) {
//                        this.pageAlert1.setType("error");
//                    } else {
//                        this.pageAlert1.setType("information");
//           }
//
//            this.pageAlert1.setTitle(controllerResult.getMsg());
//            this.pageAlert1.setSummary("");
//            this.pageAlert1.setDetail("");
//            this.pageAlert1.setRendered(true);
//
//
//      }

        return null;
    }

    public String cancelar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String button2_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }


    public String editDetailButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

    // esta bandera se usa para determinar el comportamiento del boton guardar detalle
    editarDetalle = true;
    this.uiDetalleProdCod.setDisabled(true);
    this.uiDetalleCodSolic.setDisabled(true);
    this.uiDetalleOTCod.setDisabled(true);

    EntradaSalidaDetalle entradaSalidaDetalle = new EntradaSalidaDetalle();
    entradaSalidaDetalle = detalleEntradaSalidaList.get(Integer.valueOf(itemDet).intValue());

    this.uiDetalleProdCod.setText(entradaSalidaDetalle.getCodProducto().getCodProducto().toString());
    this.uiDetalleProdDesc.setText(entradaSalidaDetalle.getCodProducto().getDescripcion().toString());
    this.uiDetalleCant.setText(entradaSalidaDetalle.getCantidadEntSal().toString());
    this.uiDetalleTipo.setSelected(entradaSalidaDetalle.getTipoEntradaSalida().toString());

    if (entradaSalidaDetalle.getCodSolicitud() != null && !entradaSalidaDetalle.getCodSolicitud().equals("")) {
            this.uiDetalleSolicProduct.setText(entradaSalidaDetalle.getCodSolicitud().getCodSolicitud().toString());
    }
    if (entradaSalidaDetalle.getCodOrdenTrabajoDetalle() != null && !entradaSalidaDetalle.getCodOrdenTrabajoDetalle().equals("")) {
            this.uiDetalleOTCod.setText(entradaSalidaDetalle.getCodOrdenTrabajoDetalle().getCodOrdenTrabajoDet().toString());
    }

    return null;
    }

    public String removeDetailButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.


        // esta bandera se usa para determinar el comportamiento del boton guardar detalle
    editarDetalle = false;
    this.uiDetalleProdCod.setDisabled(false);
    this.uiDetalleCodSolic.setDisabled(false);
    this.uiDetalleOTCod.setDisabled(false);

    //// agrego la formula eliminada a la lista de formulas Eliminadas
    //// se utiliza luego al actualizar el registro

    if (updateRequest) {

       EntradaSalidaDetalle entSalEliminada  = detalleEntradaSalidaList.get(Integer.valueOf(itemDet).intValue());
       detalleEntradaSalidaEliminadaList.add(entSalEliminada);

    }

    detalleEntradaSalidaList.remove(Integer.valueOf(itemDet).intValue());
    detallesEntradaSalida= (EntradaSalidaDetalle[]) detalleEntradaSalidaList.toArray(new EntradaSalidaDetalle[0]);
    return null;
    }


}



