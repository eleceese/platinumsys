/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
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
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;

import py.com.platinum.controller.FormulaSemiCabeceraController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.TareaController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.FormulaSemiCabecera;
import py.com.platinum.entity.FormulaSemiDetalle;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.Tarea;
import py.com.platinum.entity.TareaFormula;

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
public class ABMFormulaSemiTerminado extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        uiEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("A", "ACTIVO"), new com.sun.webui.jsf.model.Option("I", "INACTIVO")});
        uiEstadoDefaultOptions.setSelectedValue("A");
        //table1.setWidth();
    }
    private HtmlPanelGrid mainContainer = new HtmlPanelGrid();

    public HtmlPanelGrid getMainContainer() {
        return mainContainer;
    }

    public void setMainContainer(HtmlPanelGrid hpg) {
        this.mainContainer = hpg;
    }
    private TableRowGroup tableFormulasRW = new TableRowGroup();

    public TableRowGroup getTableFormulasRW() {
        return tableFormulasRW;
    }

    public void setTableFormulasRW(TableRowGroup trg) {
        this.tableFormulasRW = trg;
    }
    private Button addButton = new Button();

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button b) {
        this.addButton = b;
    }
    private Button updateButton = new Button();

    public Button getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(Button b) {
        this.updateButton = b;
    }
    private Button deleteButton = new Button();

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button b) {
        this.deleteButton = b;
    }
    private HtmlPanelGrid addUpdatePanel = new HtmlPanelGrid();

    public HtmlPanelGrid getAddUpdatePanel() {
        return addUpdatePanel;
    }

    public void setAddUpdatePanel(HtmlPanelGrid hpg) {
        this.addUpdatePanel = hpg;
    }
    private TextField uiProductoCodigo = new TextField();

    public TextField getUiProductoCodigo() {
        return uiProductoCodigo;
    }

    public void setUiProductoCodigo(TextField tf) {
        this.uiProductoCodigo = tf;
    }
    private TextField uiCantidad = new TextField();

    public TextField getUiCantidad() {
        return uiCantidad;
    }

    public void setUiCantidad(TextField tf) {
        this.uiCantidad = tf;
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
    private SingleSelectOptionsList uiEstadoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiEstadoDefaultOptions() {
        return uiEstadoDefaultOptions;
    }

    public void setUiEstadoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiEstadoDefaultOptions = ssol;
    }
    private Table tableFormulas = new Table();

    public Table getTableFormulas() {
        return tableFormulas;
    }

    public void setTableFormulas(Table t) {
        this.tableFormulas = t;
    }
    private HtmlPanelGrid gridPanelBuscar = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBuscar() {
        return gridPanelBuscar;
    }

    public void setGridPanelBuscar(HtmlPanelGrid hpg) {
        this.gridPanelBuscar = hpg;
    }
    private HtmlPanelGrid buttonPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(HtmlPanelGrid hpg) {
        this.buttonPanel = hpg;
    }
    private HtmlPanelGrid gridPanelTareas = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelTareas() {
        return gridPanelTareas;
    }

    public void setGridPanelTareas(HtmlPanelGrid hpg) {
        this.gridPanelTareas = hpg;
    }
    private TextField uiCodigoFil1 = new TextField();

    public TextField getUiCodigoFil1() {
        return uiCodigoFil1;
    }

    public void setUiCodigoFil1(TextField tf) {
        this.uiCodigoFil1 = tf;
    }
    private TextField uiProductoFil1 = new TextField();

    public TextField getUiProductoFil1() {
        return uiProductoFil1;
    }

    public void setUiProductoFil1(TextField tf) {
        this.uiProductoFil1 = tf;
    }
    private TextField uiDescripcionFil1 = new TextField();

    public TextField getUiDescripcionFil1() {
        return uiDescripcionFil1;
    }

    public void setUiDescripcionFil1(TextField tf) {
        this.uiDescripcionFil1 = tf;
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
    private TextField uiProductoNombre = new TextField();

    public TextField getUiProductoNombre() {
        return uiProductoNombre;
    }

    public void setUiProductoNombre(TextField tf) {
        this.uiProductoNombre = tf;
    }
    private TextArea uiDescripcion = new TextArea();

    public TextArea getUiDescripcion() {
        return uiDescripcion;
    }

    public void setUiDescripcion(TextArea ta) {
        this.uiDescripcion = ta;
    }
    private Calendar uiFecha = new Calendar();

    public Calendar getUiFecha() {
        return uiFecha;
    }

    public void setUiFecha(Calendar c) {
        this.uiFecha = c;
    }
    private DropDown uiEstado = new DropDown();

    public DropDown getUiEstado() {
        return uiEstado;
    }

    public void setUiEstado(DropDown dd) {
        this.uiEstado = dd;
    }
    private Button updateRecordButton = new Button();

    public Button getUpdateRecordButton() {
        return updateRecordButton;
    }

    public void setUpdateRecordButton(Button b) {
        this.updateRecordButton = b;
    }
    private TextField uiDetTareaCantidad = new TextField();

    public TextField getUiDetTareaCantidad() {
        return uiDetTareaCantidad;
    }

    public void setUiDetTareaCantidad(TextField tf) {
        this.uiDetTareaCantidad = tf;
    }
    private TextField uiDetTareaCodigo = new TextField();

    public TextField getUiDetTareaCodigo() {
        return uiDetTareaCodigo;
    }

    public void setUiDetTareaCodigo(TextField tf) {
        this.uiDetTareaCodigo = tf;
    }
    private TextField uiDetTareaOrden = new TextField();

    public TextField getUiDetTareaOrden() {
        return uiDetTareaOrden;
    }

    public void setUiDetTareaOrden(TextField tf) {
        this.uiDetTareaOrden = tf;
    }
    private TextField uiDetProductoCodigo = new TextField();

    public TextField getUiDetProductoCodigo() {
        return uiDetProductoCodigo;
    }

    public void setUiDetProductoCodigo(TextField tf) {
        this.uiDetProductoCodigo = tf;
    }
    private TextField uiDetProductoCantidad = new TextField();

    public TextField getUiDetProductoCantidad() {
        return uiDetProductoCantidad;
    }

    public void setUiDetProductoCantidad(TextField tf) {
        this.uiDetProductoCantidad = tf;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMFormulaSemiTerminado() {
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
        getSessionBean1().setDetallePagina("Productos Semiterminados");

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
            tableFormulas.setRendered(false);
            buttonPanel.setRendered(false);
            addUpdatePanel.setRendered(true);
            addRecordButton.setRendered(true);
            updateRecordButton.setRendered(false);
            uiProductoCodigo.setText("");
            uiCantidad.setText("");
        } else if (updateRequest) {
            //if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                gridPanelBuscar.setRendered(false);
                tableFormulas.setRendered(false);
                buttonPanel.setRendered(false);
                addUpdatePanel.setRendered(true);
                gridPanelTareas.setRendered(true);
                addRecordButton.setRendered(false);
                updateRecordButton.setRendered(true);
            //}
        } else if(errorValidacion){
            addUpdatePanel.setRendered(true);
        }else {
            getSessionBean1().setTituloPagina("Fórmulas de Producción");
            getSessionBean1().setDetallePagina("Productos Semiterminados");
            gridPanelBuscar.setRendered(true);
            tableFormulas.setRendered(true);
            buttonPanel.setRendered(true);
            addUpdatePanel.setRendered(false);
        }
         buscar_action2();
        // Refresh the users data array in the session bean to to show
    }


     private String buscar_action2() {

        FormulaSemiCabecera[] listaFormulaSemiCabeceras;
        FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();

        String pCodigo=null, pDescripcion=null, pCodigoProducto=null;

        if (this.uiCodigoFil1.getText()!=null) {
            pCodigo = this.uiCodigoFil1.getText().toString();
        }

        if (this.uiProductoFil1.getText()!=null) {
            pCodigoProducto = this.uiProductoFil1.getText().toString();
        }

        if (this.uiDescripcionFil1.getText()!=null) {
            pDescripcion= this.uiDescripcionFil1.getText().toString();
        }

        listaFormulaSemiCabeceras = (FormulaSemiCabecera[]) formulaSemiCabeceraController.getAllFiltered
                                        (pCodigo,
                                         pDescripcion,
                                         pCodigoProducto).toArray(new FormulaSemiCabecera[0]);

        setListaFormulaSemiCabeceras(listaFormulaSemiCabeceras);
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
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
    private boolean addRequest = false;
    private boolean updateRequest = false;
    private boolean errorValidacion = false;

    ////// CARGA DE ARRAY Formulas SEMITERMINADOS
//////     import com.sun.webui.jsf.model.Option;

    FormulaSemiCabecera[] listaFormulaSemiCabeceras;
    Option[] listaFormulaSemiCabecerasOp;

    public Option[] getListaFormulaCabecerasOp() {
        return listaFormulaSemiCabecerasOp;
    }

    public void setListaFormulaCabecerasOp(Option[] listaFormulaSemiCabeceraOp) {
        this.listaFormulaSemiCabecerasOp = listaFormulaSemiCabeceraOp;
    }

    public FormulaSemiCabecera[] getListaFormulaSemiCabeceras() {
        return listaFormulaSemiCabeceras;
    }

    public void setListaFormulaSemiCabeceras(FormulaSemiCabecera[] listaFormulaSemiCabeceras) {
        this.listaFormulaSemiCabeceras = listaFormulaSemiCabeceras;
    }

    public void cargarListaTodosFormulaSemiCabeceras(){
        FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
        listaFormulaSemiCabeceras = (FormulaSemiCabecera[]) formulaSemiCabeceraController.getAll("codProducto.codProducto").toArray(new FormulaSemiCabecera[0]);
        listaFormulaSemiCabecerasOp = new Option [listaFormulaSemiCabeceras.length];
        Option option;
        for (int i = 0; i < listaFormulaSemiCabeceras.length; i++) {
            FormulaSemiCabecera p = listaFormulaSemiCabeceras[i];
            option = new Option();
            option.setLabel(p.getDescripcion());
            option.setValue(p.getCodFormulaSemiCabecera().toString());
            listaFormulaSemiCabecerasOp[i] = option;
        }
    }
////// FIN CARGA DE COMBO BOX Formulas






    public String addButton_action() {
            
        this.pageAlert1.setRendered(false);
        detalleFormulaSemiList = new ArrayList();
        detallesFormulaSemi = (FormulaSemiDetalle[]) detalleFormulaSemiList.toArray(new FormulaSemiDetalle[0]);

        tareaFormulaList = new ArrayList();
        tareasFormula = (TareaFormula[]) tareaFormulaList.toArray(new TareaFormula[0]);


        addRequest = true;
        getSessionBean1().setTituloPagina("Nueva Fórmula de Producción");
        getSessionBean1().setDetallePagina("Crear una fórmula de producción de un Producto Semiterminado, " +
                "con su detalle correspondiente de Recursos y Tareas");


//
//        detalleFormulaList = new ArrayList();
//        detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);
//        addRequest = true;

        getSessionBean1().setTituloPagina("Nueva Fórmula de Producción");
        getSessionBean1().setDetallePagina("Crear una fórmula de producción, " +
                "con su detalle correspondiente de Semiterminados");
        uiProductoCodigo.setText("");
        uiProductoNombre.setText("");
        uiCantidad.setText("");
        uiDescripcion.setText("");

        this.addRecordButton.setRendered(true);
//        this.updateRecordButton.setRendered(false);




        return null;
    }

    public String updateButton_action() {

        this.pageAlert1.setRendered(true);
        updateRequest = true;
        getSessionBean1().setTituloPagina("Editar Fórmula de Producción");
        getSessionBean1().setDetallePagina("Crear una fórmula de producción de un Producto Semiterminado, " +
                "con su detalle correspondiente de Recursos y Tareas");
        return null;
    }

    public String deleteButton_action() {
        return null;
    }

    public String addRecordButton_action() {


        errorValidacion = validarCampos();

        //Si no hay error de validacion
        if (! errorValidacion){

//// CARGA DE LA CABECERA
          FormulaSemiCabecera formulaSemiCabecera = new FormulaSemiCabecera();
          ProductoController productoController = new ProductoController();

          formulaSemiCabecera.setCodProducto(productoController.findById(Long.valueOf(this.uiProductoCodigo.getText().toString())));
          formulaSemiCabecera.setCantidad(new BigInteger( this.uiCantidad.getText().toString()));
          formulaSemiCabecera.setDescripcion(this.uiDescripcion.getText().toString());
          formulaSemiCabecera.setFecha(this.uiFecha.getSelectedDate());
//          formulaCabecera.setEstado(this.uiEstado.getSelected().toString());
          formulaSemiCabecera.setEstado("A");

                            FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
                            ControllerResult controllerResult = new ControllerResult();
                            controllerResult = formulaSemiCabeceraController.create(formulaSemiCabecera);

//// FIN DE LA CARGA DE LA CABECERA
//                            if (controllerResult.getCodRetorno() ==-1) {
//                                    this.pageAlert1.setType("error");
//                                    this.errorValidacion=true;
//                                } else {
//
//                                                        // CARGA DE LOS DETALLES
//
//                                                        detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);
//                                                        for (int i = 0; i < detallesFormula.length; i++) {
//
//                                                            FormulaDetalle fdet = new FormulaDetalle();
//                                                            fdet = detallesFormula[i];
//                                                            fdet.setCodFormula(formulaCabecera);
//                                                            FormulaDetalleController formulaDetalleController = new FormulaDetalleController();
//                                                            controllerResult = formulaDetalleController.create(fdet);
//
//                                                            if (controllerResult.getCodRetorno() ==-1) {
//                                                                this.pageAlert1.setType("error");
//                                                                this.errorValidacion=true;
//                                                                break;
//                                                            }
//
//                                                        }
//
//                                                        // FIN DE CARGA DE LOS DETALLES
//                            }
//
//
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


//MANEJO DE LOS DETALLES


private FormulaSemiDetalle[] detallesFormulaSemi;
private FormulaSemiDetalle  detalleFormulaSemi;
private List<FormulaSemiDetalle>  detalleFormulaSemiList;

private TareaFormula[] tareasFormula;
private TareaFormula  tareaFormula;
private List<TareaFormula>  tareaFormulaList;


    public TareaFormula getTareaFormula() {
        return tareaFormula;
    }

    public void setTareaFormula(TareaFormula tareaFormula) {
        this.tareaFormula = tareaFormula;
    }

    public List<TareaFormula> getTareaFormulaList() {
        return tareaFormulaList;
    }

    public void setTareaFormulaList(List<TareaFormula> tareaFormulaList) {
        this.tareaFormulaList = tareaFormulaList;
    }

    public TareaFormula[] getTareasFormula() {
        return tareasFormula;
    }

    public void setTareasFormula(TareaFormula[] tareasFormula) {
        this.tareasFormula = tareasFormula;
    }




private FormulaSemiCabecera cabeceraFormulaSemi;

    public FormulaSemiCabecera getCabeceraFormulaSemi() {
        return cabeceraFormulaSemi;
    }

    public FormulaSemiDetalle getDetalleFormulaSemi() {
        return detalleFormulaSemi;
    }

    public List<FormulaSemiDetalle> getDetalleFormulaSemiList() {
        return detalleFormulaSemiList;
    }

    public FormulaSemiDetalle[] getDetallesFormulaSemi() {
        return detallesFormulaSemi;
    }

    public Option[] getListaFormulaSemiCabecerasOp() {
        return listaFormulaSemiCabecerasOp;
    }





    public String updateRecordButton_action() {
        //errorValidacion = validarCampos();
        errorValidacion = false;

        if (!errorValidacion) {
            // TODO: Process the action. Return value is a navigation
            // case name where null will return to the same page.
            // Create a new Users Entity
            // Update the database table data using UserController
            addRequest = false;
            this.pageAlert1.setType("information");
            this.pageAlert1.setTitle("Registro Editado correctamente!!!");
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }else{
            this.pageAlert1.setType("error");
            this.pageAlert1.setTitle("Error en la Validacion de los Campos, favor verificar y volver a intentar");
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
        return null;
    }

    private boolean validarCampos(){
        //Variables
        boolean r;

        //Inicializar
        r = false;

        if (uiProductoCodigo.getText() == null || uiProductoCodigo.getText().equals("") ) {
            info(uiProductoCodigo, "Campo obligatorio, favor ingrese el Nombre del Usuario");
            r = true;
        }

        if (uiProductoCodigo.getText() == null || uiProductoCodigo.getText().equals("") ) {
            info(uiProductoCodigo, "Campo obligatorio, favor ingrese el e-mail del Usuario");
            r = true;
        }
        //result
        return r;
    }

    public String imageHyperlink2_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String buscarButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String todosButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
           this.uiDescripcionFil1.setText("");
           this.uiCodigoFil1.setText("");
           this.uiProductoFil1.setText("");

           return null;
    }

    public void validarDetalleProducto(){
        this.errorValidacion= false;
        if (uiDetProductoCodigo.getText() == null || uiDetProductoCodigo.getText().equals("") ) {
        this.errorValidacion= true;
        info(uiDetProductoCodigo, "Verifique el detalle");
        }

        if (uiDetProductoCantidad.getText() == null || uiDetProductoCantidad.getText().equals("") ) {
        this.errorValidacion= true;
        info(uiDetProductoCodigo, "Verifique el detalle");
        }
    }
    public void validarDetalleTarea(){
        this.errorValidacion= false;
        if (uiDetTareaCodigo.getText() == null || uiDetTareaCodigo.getText().equals("") ) {
        this.errorValidacion= true;
        info(uiDetTareaCodigo, "Verifique el detalle");
        }

        if (uiDetTareaCantidad.getText() == null || uiDetTareaCantidad.getText().equals("") ) {
        this.errorValidacion= true;
        info(uiDetTareaCodigo, "Verifique el detalle");
        }

        if (uiDetTareaOrden.getText() == null || uiDetTareaOrden.getText().equals("") ) {
        this.errorValidacion= true;
        info(uiDetTareaCodigo, "Verifique el detalle");
        }
    }

public void limpiarDetalleProducto(){

this.uiDetProductoCodigo.setText("");
this.uiDetProductoCantidad.setText("");

}

public void limpiarDetalleTarea(){

this.uiDetTareaCodigo.setText("");
this.uiDetTareaCantidad.setText("");
this.uiDetTareaOrden.setText("");

}


    public String buttonAddDetProd_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        validarDetalleProducto();

        if (!errorValidacion) {
           Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetProductoCodigo.getText().toString()));

           detalleFormulaSemi = new FormulaSemiDetalle();
           detalleFormulaSemi.setCodProducto(producto);
           detalleFormulaSemi.setCantidad(BigInteger.valueOf(Long.valueOf(this.uiDetProductoCantidad.getText().toString())));

           detalleFormulaSemiList.add(detalleFormulaSemi);
           detallesFormulaSemi = (FormulaSemiDetalle[]) detalleFormulaSemiList.toArray(new FormulaSemiDetalle[0]);

           limpiarDetalleProducto();
        }

        return null;
    }

    public String buttonAddDetTar_action() {
        // TODO: Replace with your code
        
        validarDetalleTarea();

        if (!errorValidacion) {
           Tarea tarea = new TareaController().findById(Long.valueOf(this.uiDetTareaCodigo.getText().toString()));

           tareaFormula = new TareaFormula();
           tareaFormula.setCodTarea(tarea);
           tareaFormula.setCantidadTarea(BigInteger.valueOf(Long.valueOf(this.uiDetTareaCantidad.getText().toString())));
           tareaFormula.setOrdenTarea(BigInteger.valueOf(Long.valueOf(this.uiDetTareaOrden.getText().toString())));

           tareaFormulaList.add(tareaFormula);
           tareasFormula = (TareaFormula[]) tareaFormulaList.toArray(new TareaFormula[0]);

           limpiarDetalleProducto();
         }
        return null;
        
    }
      
}



   

