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
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.ValueChangeEvent;
import py.com.platinum.controller.FormulaCabeceraController;
import py.com.platinum.controller.FormulaDetalleController;
import py.com.platinum.controller.FormulaSemiCabeceraController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.FormulaCabecera;
import py.com.platinum.entity.FormulaDetalle;
import py.com.platinum.entity.FormulaSemiCabecera;
import py.com.platinum.entity.Producto;
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
public class ABMFormulaTerminado extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
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
    private TextField uiCodigoFil = new TextField();

    public TextField getUiCodigoFil() {
        return uiCodigoFil;
    }

    public void setUiCodigoFil(TextField tf) {
        this.uiCodigoFil = tf;
    }
    private TextField uiProductoFil = new TextField();

    public TextField getUiProductoFil() {
        return uiProductoFil;
    }

    public void setUiProductoFil(TextField tf) {
        this.uiProductoFil = tf;
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
    private SingleSelectOptionsList uiEstadoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiEstadoDefaultOptions() {
        return uiEstadoDefaultOptions;
    }

    public void setUiEstadoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiEstadoDefaultOptions = ssol;
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
    private HtmlPanelGrid buttonPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(HtmlPanelGrid hpg) {
        this.buttonPanel = hpg;
    }
    private TextField uiDescripcionFil = new TextField();

    public TextField getUiDescripcionFil() {
        return uiDescripcionFil;
    }

    public void setUiDescripcionFil(TextField tf) {
        this.uiDescripcionFil = tf;
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
    private TextField uiProductoNombre = new TextField();

    public TextField getUiProductoNombre() {
        return uiProductoNombre;
    }

    public void setUiProductoNombre(TextField tf) {
        this.uiProductoNombre = tf;
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
    private TextField uiDetalleCodFormula = new TextField();

    public TextField getUiDetalleCodFormula() {
        return uiDetalleCodFormula;
    }

    public void setUiDetalleCodFormula(TextField tf) {
        this.uiDetalleCodFormula = tf;
    }
    private TextField uiDetalleFormula = new TextField();

    public TextField getUiDetalleFormula() {
        return uiDetalleFormula;
    }

    public void setUiDetalleFormula(TextField tf) {
        this.uiDetalleFormula = tf;
    }
    private HtmlPanelGrid gridPanelUser = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelUser() {
        return gridPanelUser;
    }

    public void setGridPanelUser(HtmlPanelGrid hpg) {
        this.gridPanelUser = hpg;
    }
    private Hyperlink uiHyperProducto = new Hyperlink();

    public Hyperlink getUiHyperProducto() {
        return uiHyperProducto;
    }

    public void setUiHyperProducto(Hyperlink h) {
        this.uiHyperProducto = h;
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMFormulaTerminado() {
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
        uiEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("A", "Activo"), new com.sun.webui.jsf.model.Option("I", "Inactivo")});
        uiEstadoDefaultOptions.setSelectedValue("A");

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
            buttonPanel.setRendered(false);
            addUpdatePanel.setRendered(true);
            addRecordButton.setRendered(true);
            updateRecordButton.setRendered(false);

//            limpiarCamposNew();


        } else if (updateRequest) {
           
                gridPanelBuscar.setRendered(false);
                tablaFormulas.setRendered(false);
                buttonPanel.setRendered(false);
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
            buttonPanel.setRendered(true);
            addUpdatePanel.setRendered(false);
        }
        // Refresh the users data array in the session bean to to show
    buscar_action2();
    }

    public void cargarCamposUpdate(){
         if (getFormulasRW().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getFormulasRW().getSelectedRowKeys();
          FormulaCabecera[] formulasCabecera = this.listaFormulaCabeceras;
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          FormulaCabecera formulaCabecera = formulasCabecera[rowId];

          getSessionBean1().setId(formulaCabecera.getCodFormula());
         //// CARGA DE CAMPOS DE LA PAGINA
         this.uiProductoCodigo.setText(formulaCabecera.getCodProducto().getCodProducto().toString());
         this.uiDescripcion.setText(formulaCabecera.getDescripcion().toString());
         this.uiCantidad.setText(formulaCabecera.getCantidad());
         this.uiFecha.setSelectedDate(formulaCabecera.getFecha());

         detalleFormulaList = new ArrayList();
         detalleFormulaList = formulaCabecera.getFormulaDetalleCollection();
         detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);
            }
}



    private String buscar_action2() {

        FormulaCabecera[] listaFormulaCabeceras;
        FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();

        String pCodigo=null, pDescripcion=null, pCodigoProducto=null;

        if (this.uiCodigoFil.getText()!=null) {
            pCodigo = this.uiCodigoFil.getText().toString();
        }

        if (this.uiProductoFil.getText()!=null) {
            pCodigoProducto = this.uiProductoFil.getText().toString();
        }

        if (this.uiDescripcionFil.getText()!=null) {
            pDescripcion= this.uiDescripcionFil.getText().toString();
        }

        listaFormulaCabeceras = (FormulaCabecera[]) formulaCabeceraController.getAllFiltered
                                        (pCodigo,
                                         pDescripcion,
                                         pCodigoProducto).toArray(new FormulaCabecera[0]);

        setListaFormulaCabeceras(listaFormulaCabeceras);
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
    private boolean addRequest = false;
    private boolean updateRequest = false;
    private boolean errorValidacion = false;

    public String addButton_action() {

        detalleFormulaList = new ArrayList();
        detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);
        addRequest = true;
        getSessionBean1().setTituloPagina("Nueva Fórmula de Producción");
        getSessionBean1().setDetallePagina("Crear una fórmula de producción, " +
                "con su detalle correspondiente de Semiterminados");
        uiProductoCodigo.setText("");
        uiProductoNombre.setText("");
        uiCantidad.setText("");
        uiDescripcion.setText("");

        this.addRecordButton.setRendered(true);
        this.updateRecordButton.setRendered(false);


        return null;
    }

    public String updateButton_action() {

        getSessionBean1().setTituloPagina("Editar Fórmula de Producción");
        getSessionBean1().setDetallePagina("Editar una fórmula de producción, " +
                "con su detalle correspondiente de Semiterminados");
        this.pageAlert1.setRendered(false);
        this.updateRequest=true;
        this.addRecordButton.setRendered(false);
        this.updateRecordButton.setRendered(true);

        cargarCamposUpdate();


        return null;

    }

    public String deleteButton_action() {
          if (getFormulasRW().getSelectedRowsCount() > 0) {
                RowKey[] selectedRowKeys = getFormulasRW().getSelectedRowKeys();
                FormulaCabecera[] formulasCabecera = this.listaFormulaCabeceras;
                int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
                FormulaCabecera formulaCabecera = formulasCabecera[rowId];

                FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();
                getSessionBean1().setId(formulaCabecera.getCodFormula());

                //// ELIMINACION DE LOS DETALLES
                        detalleFormulaList = new ArrayList();
                        detalleFormulaList = formulaCabecera.getFormulaDetalleCollection();
                        detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);

                            for (int i = 0; i < detallesFormula.length; i++) {

                                FormulaDetalle fdet = new FormulaDetalle();
                                fdet = detallesFormula[i];
                                
                                FormulaDetalleController formulaDetalleController = new FormulaDetalleController();
                                ControllerResult controllerResult = formulaDetalleController.delete(fdet);

                                if (controllerResult.getCodRetorno() ==-1) {
                                    this.pageAlert1.setType("error");
                                    break;
                                }
                           }
                //// FIN DE ELIMINACION DE LOS DETALLES



                //// ELIMINACION DE LA CABECERA


                ControllerResult controllerResult = formulaCabeceraController.delete(formulaCabecera);
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
            return null;

    }
    public String addRecordButton_action() {

        errorValidacion = validarCampos();

        //Si no hay error de validacion
        if (! errorValidacion){

//// CARGA DE LA CABECERA
          FormulaCabecera formulaCabecera = new FormulaCabecera();
          ProductoController productoController = new ProductoController();

          formulaCabecera.setCodProducto(productoController.findById(Long.valueOf(this.uiProductoCodigo.getText().toString())));
          formulaCabecera.setCantidad(new BigInteger( this.uiCantidad.getText().toString()));
          formulaCabecera.setDescripcion(this.uiDescripcion.getText().toString());
          formulaCabecera.setFecha(this.uiFecha.getSelectedDate());
//          formulaCabecera.setEstado(this.uiEstado.getSelected().toString());
          formulaCabecera.setEstado("A");

                            FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();
                            ControllerResult controllerResult = new ControllerResult();
                            controllerResult = formulaCabeceraController.create(formulaCabecera);

//// FIN DE LA CARGA DE LA CABECERA
                            if (controllerResult.getCodRetorno() ==-1) {
                                    this.pageAlert1.setType("error");
                                    this.errorValidacion=true;
                                } else {

                                                        //// CARGA DE LOS DETALLES

                                                        detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);
                                                        for (int i = 0; i < detallesFormula.length; i++) {

                                                            FormulaDetalle fdet = new FormulaDetalle();
                                                            fdet = detallesFormula[i];
                                                            fdet.setCodFormula(formulaCabecera);
                                                            FormulaDetalleController formulaDetalleController = new FormulaDetalleController();
                                                            controllerResult = formulaDetalleController.create(fdet);

                                                            if (controllerResult.getCodRetorno() ==-1) {
                                                                this.pageAlert1.setType("error");
                                                                this.errorValidacion=true;
                                                                break;
                                                            }

                                                        }

                                                        //// FIN DE CARGA DE LOS DETALLES
                            }


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

        if (! errorValidacion){


          FormulaCabecera formulaCabecera = new FormulaCabeceraController().findById(getSessionBean1().getId());

          ProductoController productoController = new ProductoController();

          formulaCabecera.setCodProducto(productoController.findById(Long.valueOf(this.uiProductoCodigo.getText().toString())));
          formulaCabecera.setCantidad(new BigInteger( this.uiCantidad.getText().toString()));
          formulaCabecera.setDescripcion(this.uiDescripcion.getText().toString());
          formulaCabecera.setFecha(this.uiFecha.getSelectedDate());
//          formulaCabecera.setEstado(this.uiEstado.getSelected().toString());
          formulaCabecera.setEstado("A");

           FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();
           ControllerResult controllerResult = new ControllerResult();
           controllerResult = formulaCabeceraController.update(formulaCabecera);

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
        return null;
    }

    private boolean validarCampos(){
         errorValidacion = false;

 if (this.uiProductoCodigo.getText() == null ||
        this.uiProductoCodigo.getText().toString() == null ||
        this.uiProductoCodigo.getText().toString().equals("")){
            errorValidacion = true;
           this.info(uiProductoCodigo, "Debe seleccionar un producto");
    }

       if (this.uiDescripcion.getText() == null ||
        this.uiDescripcion.getText().toString() == null ||
        this.uiDescripcion.getText().toString().equals("")){
            errorValidacion = true;
           this.info(uiDescripcion, "La Descripcion no puede ser nula");
    }

      if (!StringUtils.esNumero(this.uiCantidad.getText().toString()))
            {   errorValidacion = true;
                this.info(uiCantidad, "La cantidad debe ser campo numerico");
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
////// FIN CARGA DE COMBO BOX Formulas

////// MANEJO DE DETALLES DE Formulas

private FormulaDetalle[] detallesFormula;
private FormulaDetalle  detalleFormula;
private List<FormulaDetalle>  detalleFormulaList;
private FormulaCabecera cabeceraFormula;

    public FormulaCabecera getCabeceraFormula() {
        return cabeceraFormula;
    }

    public void setCabeceraFormula(FormulaCabecera cabeceraFormula) {
        this.cabeceraFormula = cabeceraFormula;
    }

    public FormulaDetalle getDetalleFormula() {
        return detalleFormula;
    }

    public void setDetalleFormula(FormulaDetalle detalleFormula) {
        this.detalleFormula = detalleFormula;
    }

    public FormulaDetalle[] getDetallesFormula() {
        return detallesFormula;
    }

    public void setDetallesFormula(FormulaDetalle[] detallesFormula) {
        this.detallesFormula = detallesFormula;
    }

    public String uiButtonAgregarDetalle_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        validarDetalle();

        if (!errorValidacion) {
           Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetalleProdCod.getText().toString()));

            FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
            FormulaSemiCabecera formulaSemiCabecera = new FormulaSemiCabecera();
            formulaSemiCabecera = formulaSemiCabeceraController.findById(Long.valueOf(Long.valueOf(this.uiDetalleCodFormula.getText().toString())));

//           FormulaSemiCabecera formulaSemiCabecera = new FormulaSemiCabeceraController().findById(Long.valueOf(this.uiDetalleCodFormula.getText().toString()));
          

           detalleFormula = new FormulaDetalle();
           detalleFormula.setCodProducto(producto);
           detalleFormula.setCodFormulaSemiCabecera(formulaSemiCabecera);
           detalleFormula.setCantidad(BigInteger.valueOf(Long.valueOf(this.uiDetalleCant.getText().toString())));

           detalleFormulaList.add(detalleFormula);
           detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);

           limpiarDetalle();
        }

        return null;
    }

public void validarDetalle(){
    this.errorValidacion= false;
if (uiDetalleProdCod.getText() == null || uiDetalleProdCod.getText().equals("") ) {
        this.errorValidacion= true;
        info(uiDetalleProdDesc, "Verifique el detalle");
}

if (uiDetalleCant.getText() == null || uiDetalleCant.getText().equals("") ) {
        this.errorValidacion= true;
        info(uiDetalleProdDesc, "Verifique el detalle");
}

}
public void limpiarDetalle(){

this.uiDetalleCant.setText("");
this.uiDetalleProdCod.setText("");
this.uiDetalleProdDesc.setText("");
this.uiDetalleFormula.setText("");
this.uiDetalleCodFormula.setText("");

}


public String detail() {
    detalleFormulaList.remove(Integer.valueOf(itemDet).intValue());
    detallesFormula = (FormulaDetalle[]) detalleFormulaList.toArray(new FormulaDetalle[0]);
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
        this.uiDescripcionFil.setText("");
        this.uiCodigoFil.setText("");
        this.uiProductoFil.setText("");

        return null;
    }


}



