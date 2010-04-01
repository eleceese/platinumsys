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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.ValueChangeEvent;
import py.com.platinum.controller.DepositoController;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.EntradaSalidaCabeceraController;
import py.com.platinum.controller.EquivalenciaController;
import py.com.platinum.controller.FormulaCabeceraController;
import py.com.platinum.controller.FormulaDetalleController;
import py.com.platinum.controller.FormulaSemiCabeceraController;
import py.com.platinum.controller.OrdenTrabajoDetalleController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.RecursoAsignadoController;
import py.com.platinum.controller.SolicitudInternaController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.EntradaSalidaCabecera;
import py.com.platinum.entity.EntradaSalidaDetalle;
import py.com.platinum.entity.Equivalencia;
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
    private TextField uiCodigoFil = new TextField();

    public TextField getUiCodigoFil() {
        return uiCodigoFil;
    }

    public void setUiCodigoFil(TextField tf) {
        this.uiCodigoFil = tf;
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
        getSessionBean1().setTituloPagina("Fórmulas de Producción");
        getSessionBean1().setDetallePagina("Productos Terminados");
       

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
            getSessionBean1().setTituloPagina("Fórmulas de Producción");
            getSessionBean1().setDetallePagina("Productos Terminados");
            gridPanelBuscar.setRendered(true);
            tablaFormulas.setRendered(true);
//            buttonPanel.setRendered(true);
            addUpdatePanel.setRendered(false);
        }
        // Refresh the users data array in the session bean to to show
    buscar_action2();
    }

    public void cargarCamposUpdate(){
//         if (getFormulasRW().getSelectedRowsCount() > 0){
//          RowKey[] selectedRowKeys = getFormulasRW().getSelectedRowKeys();
//          EntradaSalidaCabecera[] entradaSalidaCabecera = this.listaMovimientosCab;
//          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
//          EntradaSalidaCabecera entradaSalidaCabecera = [rowId];
//
//          getSessionBean1().setId(formulaCabecera.getCodFormula());
//         //// CARGA DE CAMPOS DE LA PAGINA
//         this.uiProductoCodigo.setText(formulaCabecera.getCodProducto().getCodProducto().toString());
//         this.uiProductoNombre.setText(formulaCabecera.getCodProducto().getDescripcion().toString());
//         this.uiDescripcion.setText(formulaCabecera.getDescripcion().toString());
//         this.uiCantidad.setText(formulaCabecera.getCantidad());
//         this.uiFecha.setSelectedDate(formulaCabecera.getFecha());
//
//         detalleEntradaSalidaList = new ArrayList();
//         detalleEntradaSalidaList = formulaCabecera.getFormulaDetalleCollection();
//         detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);
//            }
}



    private String buscar_action2() {

        EntradaSalidaCabecera[] listaEntradaSalidaCabeceras;
        EntradaSalidaCabeceraController entradaSalidaController = new EntradaSalidaCabeceraController();

        String pCodigo=null, pDeposito=null;

        if (this.uiCodigoFil.getText()!=null) {
            pCodigo = this.uiCodigoFil.getText().toString();
        }

        if (this.uiDepositoFil.getSelected()!=null) {
            pDeposito = this.uiDepositoFil.getSelected().toString();
        }


        listaEntradaSalidaCabeceras = (EntradaSalidaCabecera[]) entradaSalidaController.getAllFiltered(
                                        (pCodigo),
                                         (pDeposito),null).toArray(new EntradaSalidaCabecera[0]);

        
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
//        updateRequest = true;
//        validarCampos();
//        ControllerResult controllerResult = new ControllerResult();
//        FormulaCabecera formulaCabecera = new FormulaCabecera();
//        FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();
//
//
//        if (! errorValidacion){
//            formulaCabecera = new FormulaCabeceraController().findById(getSessionBean1().getId());
//                            formulaCabecera = new FormulaCabeceraController().findById(getSessionBean1().getId());
//                            ProductoController productoController = new ProductoController();
//
//                            formulaCabecera.setCodProducto(productoController.findById(Long.valueOf(this.uiProductoCodigo.getText().toString())));
//                            formulaCabecera.setCantidad(new BigInteger( this.uiCantidad.getText().toString()));
//                            formulaCabecera.setDescripcion(this.uiDescripcion.getText().toString());
//                            formulaCabecera.setFecha(this.uiFecha.getSelectedDate());
//                            formulaCabecera.setEstado(this.uiEstado.getSelected().toString());
//                            //formulaCabecera.setEstado("A");
//            FormulaDetalle[] detallesFormulaEliminada = (FormulaDetalle[]) detalleFormulaEliminadaList.toArray(new FormulaDetalle[0]);
//            detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);
//
//            controllerResult = formulaCabeceraController.updateCabDet(formulaCabecera, detallesFormula, detallesFormulaEliminada);
//
//
//
//            if (controllerResult.getCodRetorno() ==-1) {
//                this.pageAlert1.setType("error");
//                this.errorValidacion=true;
//            } else {
//                updateRequest = false;
//                this.pageAlert1.setType("information");
//            }
//
//            this.pageAlert1.setTitle(controllerResult.getMsg());
//            this.pageAlert1.setSummary("");
//            this.pageAlert1.setDetail("");
//            this.pageAlert1.setRendered(true);
//
//
//
//
//    }
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
//                       errorValidacion = true;
//                       this.info(uiDetalleProdDesc, "Debe agregar los detalles de la Entrada Salida");
            }else{

                         /// Recorrido del Detalle previo a la insercion para corroborar las cantidad con sus equivalencias
                         for (int i = 0; i < detallesEntradaSalida.length; i++) {
                                EntradaSalidaDetalle entSal = detallesEntradaSalida[i];
                                Producto p = null;
                                OrdenTrabajoDetalle otDet = null;
                                p = entSal.getCodProducto();

                                Long cantidad = null;
                                cantidad = Long.valueOf(entSal.getCantidadEntSal().toString());
                                if (entSal.getCodOrdenTrabajoDetalle().getCodOrdenTrabajoDet() != null) {
                                    otDet = entSal.getCodOrdenTrabajoDetalle();
                                }

                                if (otDet != null && p != null && cantidad != null) {

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
                    this.uiResponsableCodigo.getText().toString().equals("")){
                        errorValidacion = true;
                       this.info(uiResponsableCodigo, "Debe seleccionar un Responsable");
                }
            if (this.uiResponsable2Codigo.getText() == null ||
                    this.uiResponsable2Codigo.getText().toString() == null ||
                    this.uiResponsable2Codigo.getText().toString().equals("")){
                        errorValidacion = true;
                       this.info(uiResponsable2Codigo, "Debe seleccionar un Responsable de retirar");
                }


             if (this.uiFecha.getSelectedDate() == null ||
                    this.uiFecha.getSelectedDate().toString() == null ||
                    this.uiFecha.getSelectedDate().toString().equals("")){
                        errorValidacion = true;
                       this.info(uiFecha, "Debe seleccionar la fecha");
                }



                  return errorValidacion;

}


////// CARGA DE COMBO BOX Formulas TERMINADOS
//////     import com.sun.webui.jsf.model.Option;

    FormulaCabecera[] listaFormulaCabeceras;
    Option[] listaFormulaCabecerasOp;

    public Option[] getListaFormulaCabecerasOp() {
        return listaFormulaCabecerasOp;
    }

    public void setListaFormulaCabecerasOp(Option[] listaFormulaCabeceraOp) {
        this.listaFormulaCabecerasOp = listaFormulaCabeceraOp;
    }

    public FormulaCabecera[] getListaFormulaCabeceras() {
        return listaFormulaCabeceras;
    }

    public void setListaFormulaCabeceras(FormulaCabecera[] listaFormulaCabeceras) {
        this.listaFormulaCabeceras = listaFormulaCabeceras;
    }

    public void cargarListaTodosFormulaCabeceras(){
        FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();
        listaFormulaCabeceras = (FormulaCabecera[]) formulaCabeceraController.getAll("codProducto.codProducto").toArray(new FormulaCabecera[0]);
        listaFormulaCabecerasOp = new Option [listaFormulaCabeceras.length];
        Option option;
        for (int i = 0; i < listaFormulaCabeceras.length; i++) {
            FormulaCabecera p = listaFormulaCabeceras[i];
            option = new Option();
            option.setLabel(p.getDescripcion());
            option.setValue(p.getCodFormula().toString());
            listaFormulaCabecerasOp[i] = option;
        }
    }
//////// FIN CARGA DE COMBO BOX Formulas
////// CARGA DE COMBO BOX Formulas TERMINADOS
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
                            OrdenTrabajoDetalle ordenTDet = new OrdenTrabajoDetalle();

                            SolicitudInternaController solicitudInternaController  = new SolicitudInternaController ();
                            SolicitudInterna solicitud = new SolicitudInterna();
                            
                            
                            if (!uiDetalleOTCod.getText().equals("")) {
                                    ordenTDet = ordenTrabajoDetalleController.findById(Long.valueOf(Long.valueOf(this.uiDetalleOTCod.getText().toString())));
                            }
                            if (!uiDetalleCodSolic.getText().equals("")) {
                                    solicitud = solicitudInternaController.findById(Long.valueOf(Long.valueOf(this.uiDetalleCodSolic.getText().toString())));
                            }
                            

                           detalleEntradaSalida = new EntradaSalidaDetalle();
                           detalleEntradaSalida.setCodProducto(producto);
                           detalleEntradaSalida.setCantidadEntSal(BigInteger.valueOf(Long.valueOf(this.uiDetalleCant.getText().toString())));
                           detalleEntradaSalida.setTipoEntradaSalida(this.uiDetalleTipo.getSelected().toString());
                           detalleEntradaSalida.setCodOrdenTrabajoDetalle(ordenTDet);
                           detalleEntradaSalida.setCodSolicitud(solicitud);
                           detalleEntradaSalida.setFechaAlta(this.uiFecha.getSelectedDate());


                           detalleEntradaSalidaList.add(detalleEntradaSalida);



            }else{

//                            Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetalleProdCod.getText().toString()));
//
//                            FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
//                            FormulaSemiCabecera formulaSemiCabecera = new FormulaSemiCabecera();
//                            formulaSemiCabecera = formulaSemiCabeceraController.findById(Long.valueOf(Long.valueOf(this.uiDetalleCodFormula.getText().toString())));
//
//                //           FormulaSemiCabecera formulaSemiCabecera = new FormulaSemiCabeceraController().findById(Long.valueOf(this.uiDetalleCodFormula.getText().toString()));
//
//
//                           detalleFormula  = detalleFormulaList.get(Integer.valueOf(itemDet).intValue());
//                           detalleFormula.setCodProducto(producto);
//                           detalleFormula.setCodFormulaSemiCabecera(formulaSemiCabecera);
//                           detalleFormula.setCantidad(BigInteger.valueOf(Long.valueOf(this.uiDetalleCant.getText().toString())));
//                           editarDetalle = false;
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
if (uiDetalleProdCod.getText() == null || uiDetalleProdCod.getText().equals("") ) {
        this.errorValidacion= true;
        info(uiDetalleProdDesc, "Verifique el codigo de Producto");
}else{
     p = new ProductoController().findById(Long.valueOf(uiDetalleProdCod.getText().toString()));
     if (p == null) {
         this.errorValidacion= true;
         info(uiDetalleProdDesc, "Verifique el codigo de Producto");
     }
}
Long cantidad = null;
if (uiDetalleCant.getText() == null || uiDetalleCant.getText().equals("") ) {
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

if (uiDetalleOTCod.getText() != null ){
    otDet = new OrdenTrabajoDetalleController().findById(Long.valueOf(uiDetalleOTCod.getText().toString()));
    if (otDet == null) {
         this.errorValidacion= true;
         info(uiDetalleProdDesc, "Verifique el codigo de OT");
    }else{
        if (uiDetalleTipo.getSelected().toString().equals("E")) {
            this.errorValidacion= true;
            info(uiDetalleProdDesc, "El tipo de movimiento debe ser Salida");
        }

    }

}


    if (otDet != null && p != null && cantidad != null) {

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


public String detailRemove() {
//    // esta bandera se usa para determinar el comportamiento del boton guardar detalle
//    editarDetalle = false;
//
//    //// agrego la formula eliminada a la lista de formulas Eliminadas
//    //// se utiliza luego al actualizar el registro
//
//    if (updateRequest) {
//       FormulaDetalle fDetEliminada  = detalleFormulaList.get(Integer.valueOf(itemDet).intValue());
//       detalleFormulaEliminadaList.add(fDetEliminada);
//
//    }
//
//    detalleFormulaList.remove(Integer.valueOf(itemDet).intValue());
//    detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);
//    return null;
//}
//
//public String detailEdit() {
//    // esta bandera se usa para determinar el comportamiento del boton guardar detalle
//    editarDetalle = true;
//
//    FormulaDetalle formulaDetalle = new FormulaDetalle();
//    formulaDetalle = detalleFormulaList.get(Integer.valueOf(itemDet).intValue());
//
//    this.uiDetalleCodFormula.setText(formulaDetalle.getCodFormulaSemiCabecera().getCodFormulaSemiCabecera().toString());
//    this.uiDetalleFormula.setText(formulaDetalle.getCodFormulaSemiCabecera().getDescripcion().toString());
//    this.uiDetalleProdCod.setText(formulaDetalle.getCodProducto().getCodProducto().toString());
//    this.uiDetalleProdDesc.setText(formulaDetalle.getCodProducto().getDescripcion());
//    this.uiDetalleCant.setText(formulaDetalle.getCantidad().toString());
//
    return null;
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
        return null;
    }

    public String todosButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.uiDepositoFil.setSelected("");
        this.uiCodigoFil.setText("");

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

        this.addRecordButton.setRendered(true);
        this.updateRecordButton.setRendered(false);


        return null;


    }

    public String updateButton1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

            detalleEntradaSalidaList = new ArrayList();
        getSessionBean1().setTituloPagina("Editar Fórmula de Producción");
        getSessionBean1().setDetallePagina("Editar una fórmula de producción, " +
                "con su detalle correspondiente de Semiterminados");
        this.pageAlert1.setRendered(false);
        this.updateRequest=true;
        this.addRecordButton.setRendered(false);
        this.updateRecordButton.setRendered(true);


        cargarCamposUpdate();
        limpiarDetalle();


        return null;
    }

    public String deleteButton1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

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

  


}



