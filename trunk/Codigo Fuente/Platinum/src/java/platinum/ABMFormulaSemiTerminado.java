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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;

import javax.servlet.http.HttpServletResponse;
import py.com.platinum.controller.FormulaSemiCabeceraController;
import py.com.platinum.controller.FormulaSemiDetalleController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.TareaController;
import py.com.platinum.controller.TareaFormulaController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.FormulaDetalle;
import py.com.platinum.entity.FormulaSemiCabecera;
import py.com.platinum.entity.FormulaSemiDetalle;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.Tarea;
import py.com.platinum.entity.TareaFormula;
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
public class ABMFormulaSemiTerminado extends AbstractPageBean {
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
    private TextField uiDetProductoNombre = new TextField();

    public TextField getUiDetProductoNombre() {
        return uiDetProductoNombre;
    }

    public void setUiDetProductoNombre(TextField tf) {
        this.uiDetProductoNombre = tf;
    }
    private TextField uiDetTareaNombre = new TextField();

    public TextField getUiDetTareaNombre() {
        return uiDetTareaNombre;
    }

    public void setUiDetTareaNombre(TextField tf) {
        this.uiDetTareaNombre = tf;
    }
    private ImageHyperlink imageHyperlink1 = new ImageHyperlink();

    public ImageHyperlink getImageHyperlink1() {
        return imageHyperlink1;
    }

    public void setImageHyperlink1(ImageHyperlink ih) {
        this.imageHyperlink1 = ih;
    }
    private ImageHyperlink imageHyperlink2 = new ImageHyperlink();

    public ImageHyperlink getImageHyperlink2() {
        return imageHyperlink2;
    }

    public void setImageHyperlink2(ImageHyperlink ih) {
        this.imageHyperlink2 = ih;
    }
    private ImageHyperlink imageHyperlink3 = new ImageHyperlink();

    public ImageHyperlink getImageHyperlink3() {
        return imageHyperlink3;
    }

    public void setImageHyperlink3(ImageHyperlink ih) {
        this.imageHyperlink3 = ih;
    }
    private ImageHyperlink imageHyperlink4 = new ImageHyperlink();

    public ImageHyperlink getImageHyperlink4() {
        return imageHyperlink4;
    }

    public void setImageHyperlink4(ImageHyperlink ih) {
        this.imageHyperlink4 = ih;
    }
    private ImageHyperlink imageHyperlink5 = new ImageHyperlink();

    public ImageHyperlink getImageHyperlink5() {
        return imageHyperlink5;
    }

    public void setImageHyperlink5(ImageHyperlink ih) {
        this.imageHyperlink5 = ih;
    }
    private Checkbox uiDetTareaFin = new Checkbox();

    public Checkbox getUiDetTareaFin() {
        return uiDetTareaFin;
    }

    public void setUiDetTareaFin(Checkbox c) {
        this.uiDetTareaFin = c;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMFormulaSemiTerminado() {
    uiEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("A", "ACTIVO"), new com.sun.webui.jsf.model.Option("I", "INACTIVO")});
    uiEstadoDefaultOptions.setSelectedValue("A");
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




        cancelButton.setRendered(true);
        if (addRequest) {
            gridPanelBuscar.setRendered(false);
            tableFormulas.setRendered(false);
            buttonPanel.setRendered(false);
            addUpdatePanel.setRendered(true);
            addRecordButton.setRendered(true);
            updateRecordButton.setRendered(false);
            this.uiProductoCodigo.setDisabled(false);
                getSessionBean1().setTituloPagina("Registro de Fórmulas de Producción");
                getSessionBean1().setDetallePagina("Nueva Formula");


        } else if (updateRequest) {
            //if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                gridPanelBuscar.setRendered(false);
                tableFormulas.setRendered(false);
                buttonPanel.setRendered(false);
                addUpdatePanel.setRendered(true);
                gridPanelTareas.setRendered(true);
                addRecordButton.setRendered(false);
                updateRecordButton.setRendered(true);
                    this.uiProductoCodigo.setDisabled(true);
             getSessionBean1().setTituloPagina("Registro de Fórmulas de Producción");
                getSessionBean1().setDetallePagina("Editar Formula");

                    //}
        } else if(errorValidacion){
            addUpdatePanel.setRendered(true);
        }else {
 getSessionBean1().setTituloPagina("Registro de Fórmulas de Producción");
                getSessionBean1().setDetallePagina("Seleccione un registro");

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
    private boolean editarDetalleRecurso = false;
    private boolean editarDetalleTarea = false;


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
        uiProductoCodigo.setText("");
        uiCantidad.setText("");
        uiProductoNombre.setText("");
        uiDescripcion.setText("");
        this.uiFecha.setSelectedDate(new Date());

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

        
        uiProductoCodigo.setText("");
        uiProductoNombre.setText("");
        uiCantidad.setText("");
        uiDescripcion.setText("");

        this.addRecordButton.setRendered(true);
//        this.updatfeRecordButton.setRendered(false);




        return null;
    }

    public String updateButton_action() {

        detalleFormulaSemiEliminadaList = new ArrayList();
        tareaFormulaEliminadaList = new ArrayList();

        updateRequest = true;
        getSessionBean1().setTituloPagina("Editar Fórmula de Producción");
        getSessionBean1().setDetallePagina("Crear una fórmula de producción de un Producto Semiterminado, " +
                "con su detalle correspondiente de Recursos y Tareas");

        this.pageAlert1.setRendered(false);
        this.updateRequest=true;
        this.addRecordButton.setRendered(false);
        this.updateRecordButton.setRendered(true);

        cargarCamposUpdate();
//        limpiarDetalle();



        return null;
    }

    public void cargarCamposUpdate(){
         if (getTableFormulasRW().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getTableFormulasRW().getSelectedRowKeys();
          FormulaSemiCabecera[] formulasSemiCabecera = this.listaFormulaSemiCabeceras;
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          FormulaSemiCabecera formulaSemiCabecera = formulasSemiCabecera[rowId];

          getSessionBean1().setId(formulaSemiCabecera.getCodFormulaSemiCabecera());

         //// CARGA DE CAMPOS DE LA PAGINA
         this.uiProductoCodigo.setText(formulaSemiCabecera.getCodProducto().getCodProducto().toString());
         this.uiProductoNombre.setText(formulaSemiCabecera.getCodProducto().getDescripcion().toString());
         this.uiDescripcion.setText(formulaSemiCabecera.getDescripcion().toString());
         this.uiCantidad.setText(formulaSemiCabecera.getCantidad());
         this.uiFecha.setSelectedDate(formulaSemiCabecera.getFecha());

         detalleFormulaSemiList = new ArrayList();
         detalleFormulaSemiList = formulaSemiCabecera.getFormulaSemiDetalleListList();
         detallesFormulaSemi = (FormulaSemiDetalle[]) detalleFormulaSemiList.toArray(new FormulaSemiDetalle[0]);

         tareaFormulaList = new ArrayList();
         tareaFormulaList = formulaSemiCabecera.getTareaFormulaListList();
         tareasFormula = (TareaFormula[]) tareaFormulaList.toArray(new TareaFormula[0]);
         
         }
}


    public String deleteButton_action() {
        if (getTableFormulasRW().getSelectedRowsCount() > 0) {
                RowKey[] selectedRowKeys = getTableFormulasRW().getSelectedRowKeys();
                FormulaSemiCabecera[] formulasSemiCabecera = this.listaFormulaSemiCabeceras;
                int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
                FormulaSemiCabecera formulaSemiCabecera = formulasSemiCabecera[rowId];

                FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
                getSessionBean1().setId(formulaSemiCabecera.getCodFormulaSemiCabecera());

        /// ELIMINACION DE LOS DETALES
                detalleFormulaSemiList = new ArrayList();
                detalleFormulaSemiList = formulaSemiCabecera.getFormulaSemiDetalleListList();
                detallesFormulaSemi = (FormulaSemiDetalle[]) detalleFormulaSemiList.toArray(new FormulaSemiDetalle[0]);

                tareaFormulaList = new ArrayList();
                tareaFormulaList = formulaSemiCabecera.getTareaFormulaListList();
                tareasFormula = (TareaFormula[]) tareaFormulaList.toArray(new TareaFormula[0]);

                ControllerResult controllerResult = new ControllerResult();
                controllerResult = formulaSemiCabeceraController.deleteCabDet(formulaSemiCabecera, detallesFormulaSemi, tareasFormula);


//                /// ELIMINACION DE LOS DETALLES DE RECURSOS
//                if (detallesFormulaSemi != null) {
//                    for (int i = 0; i < detallesFormulaSemi.length; i++) {
//
//                                    FormulaSemiDetalle fdet = new FormulaSemiDetalle();
//                                    fdet = detallesFormulaSemi[i];
//
//
//                                    FormulaSemiDetalleController formulaSemiDetalleController = new FormulaSemiDetalleController();
//                                    controllerResult = formulaSemiDetalleController.eliminar(fdet);
//
//                                    if (controllerResult.getCodRetorno() ==-1) {
//                                        this.pageAlert1.setType("error");
//                                        break;
//                                    }
//                      }
//
//                }
//
//                /// FIN ELIMINACION DE LOS DETALLES DE RECURSOS
//
//                /// ELIMINACION DE LOS DETALLES DE TAREAS
//                if (controllerResult.getCodRetorno() !=-1) {
//                    if (tareasFormula != null) {
//                        for (int i = 0; i < tareasFormula.length; i++) {
//
//                                    TareaFormula tfor = new TareaFormula();
//                                    tfor = tareasFormula[i];
//
//                                    TareaFormulaController tareaFormulaController = new TareaFormulaController();
//                                    controllerResult = tareaFormulaController.eliminar(tfor);
//
//                                    if (controllerResult.getCodRetorno() ==-1) {
//                                        this.pageAlert1.setType("error");
//                                        break;
//                                    }
//                        }
//                    }
//                }
//                /// FIN ELIMINACION DE LOS DETALLES DE TAREAS
//
//        /// FIN DE ELIMINACION DE LOS DETALLES
//
//
//       /// ELIMINACION DE LA CABECERA
//
//                if (controllerResult.getCodRetorno() !=-1) {
//                        formulaSemiCabecera = formulaSemiCabeceraController.findById(formulaSemiCabecera.getCodFormulaSemiCabecera());
//                        controllerResult = formulaSemiCabeceraController.delete(formulaSemiCabecera);
//                         if (controllerResult.getCodRetorno() ==-1) {
//                                this.pageAlert1.setType("error");
//                            } else {
//                                this.pageAlert1.setType("information");
//                         }
//                }
//       /// FIN ELIMINACION DE LA CABECERA

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

        detallesFormulaSemi = (FormulaSemiDetalle[]) detalleFormulaSemiList.toArray(new FormulaSemiDetalle[0]);
        tareasFormula = (TareaFormula[]) tareaFormulaList.toArray(new TareaFormula[0]);
        //Si no hay error de validacion
        if (! errorValidacion){

//// CARGA DE LA CABECERA
          FormulaSemiCabecera formulaSemiCabecera = new FormulaSemiCabecera();
          ProductoController productoController = new ProductoController();
          Producto p = productoController.findById(Long.valueOf(this.uiProductoCodigo.getText().toString()));
          formulaSemiCabecera.setCodProducto(productoController.findById(Long.valueOf(this.uiProductoCodigo.getText().toString())));
            if (p.getCodTipoProducto().getDescripcion().toString().equals("Acabado")) {
                formulaSemiCabecera.setFormulaFin("S");
            }
          formulaSemiCabecera.setCantidad(new BigInteger( this.uiCantidad.getText().toString()));
          formulaSemiCabecera.setDescripcion(this.uiDescripcion.getText().toString());
          formulaSemiCabecera.setFecha(this.uiFecha.getSelectedDate());
          formulaSemiCabecera.setFechaAlta(new Date());
          formulaSemiCabecera.setEstado(this.uiEstado.getSelected().toString());
          //formulaSemiCabecera.setEstado("A");

                            FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
                            ControllerResult controllerResult = new ControllerResult();
//                            controllerResult = formulaSemiCabeceraController.create(formulaSemiCabecera);
                            controllerResult = formulaSemiCabeceraController.createCabDet(formulaSemiCabecera, detallesFormulaSemi, tareasFormula);
//controllerResult = formulaSemiCabeceraController.create(formulaSemiCabecera);
//
////// FIN DE LA CARGA DE LA CABECERA
//                            if (controllerResult.getCodRetorno() ==-1) {
//                                    this.pageAlert1.setType("error");
//                                    this.errorValidacion=true;
//                                } else {
//
//                                        // CARGA DE LOS DETALLES DE RECURSOS
//
//                                        detallesFormulaSemi = (FormulaSemiDetalle[]) detalleFormulaSemiList.toArray(new FormulaSemiDetalle[0]);
//                                        for (int i = 0; i < detallesFormulaSemi.length; i++) {
//
//                                            FormulaSemiDetalle fsdet = new FormulaSemiDetalle();
//                                            fsdet = detallesFormulaSemi[i];
//                                            fsdet.setCodFormulaSemiCabecera(formulaSemiCabecera);
//                                            FormulaSemiDetalleController formulaSemiDetalleController = new FormulaSemiDetalleController();
//                                            controllerResult = formulaSemiDetalleController.create(fsdet);
//
//                                            if (controllerResult.getCodRetorno() ==-1) {
//                                                this.pageAlert1.setType("error");
//                                                this.errorValidacion=true;
//                                                break;
//                                            }
//                                        }
//                                        // FIN DE CARGA DE LOS DETALLES DE RECURSOS
//
//                                        if (controllerResult.getCodRetorno() != -1) {
//
//
////                                                                        // CARGA DE LOS DETALLES DE TAREAS
////
//                                                        tareasFormula = (TareaFormula[]) tareaFormulaList.toArray(new TareaFormula[0]);
//                                                        for (int i = 0; i < tareasFormula.length; i++) {
//                                                            TareaFormula tfor = new TareaFormula();
//                                                            tfor = tareasFormula[i];
//                                                            tfor.setCodFormulaSemiCabecera(formulaSemiCabecera);
//                                                            TareaFormulaController tareaFormulaController = new TareaFormulaController();
//                                                            controllerResult = tareaFormulaController.create(tfor);
//
//                                                            if (controllerResult.getCodRetorno() ==-1) {
//                                                                this.pageAlert1.setType("error");
//                                                                this.errorValidacion=true;
//                                                                break;
//                                                            }
//                                                        }
//                                        }
//                                        // FIN DE CARGA DE LOS DETALLES DE TAREAS
//                            }
//
//
//
//                            if (controllerResult.getCodRetorno() != -1) {
//                                    addRequest = false;
//                                    this.pageAlert1.setType("information");
//                            }
//
//                                this.pageAlert1.setTitle(controllerResult.getMsg());
//                                this.pageAlert1.setSummary("");
//                                this.pageAlert1.setDetail("");
//                                this.pageAlert1.setRendered(true);
//        }
        
        if (controllerResult.getCodRetorno() != -1) {
                addRequest = false;
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


//MANEJO DE LOS DETALLES

private FormulaSemiDetalle[] detallesFormulaSemi;
private FormulaSemiDetalle  detalleFormulaSemi;
private List<FormulaSemiDetalle>  detalleFormulaSemiList;

private TareaFormula[] tareasFormula;
private TareaFormula  tareaFormula;
private List<TareaFormula>  tareaFormulaList;

private List<FormulaSemiDetalle>  detalleFormulaSemiEliminadaList;
private List<TareaFormula>  tareaFormulaEliminadaList;

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
        boolean r = false;
        updateRequest = true;

        ControllerResult controllerResult = new ControllerResult();
        FormulaSemiCabecera formulaSemiCabecera = new FormulaSemiCabecera();


        if (!validarCampos()){
                formulaSemiCabecera = new FormulaSemiCabeceraController().findById(getSessionBean1().getId());
                ProductoController productoController = new ProductoController();

                //formulaSemiCabecera.setCodProducto(productoController.findById(Long.valueOf(this.uiProductoCodigo.getText().toString())));
                formulaSemiCabecera.setCantidad(new BigInteger( this.uiCantidad.getText().toString()));
                formulaSemiCabecera.setDescripcion(this.uiDescripcion.getText().toString());
                formulaSemiCabecera.setFecha(this.uiFecha.getSelectedDate());
                formulaSemiCabecera.setEstado(this.uiEstado.getSelected().toString());
                //formulaSemiCabecera.setEstado("A");

                //// Convertilos los List a Array y enviamos

                FormulaSemiDetalle[] detallesFormulaSemiElim = (FormulaSemiDetalle[]) detalleFormulaSemiEliminadaList.toArray(new FormulaSemiDetalle[0]);
                detallesFormulaSemi = (FormulaSemiDetalle[]) detalleFormulaSemiList.toArray(new FormulaSemiDetalle[0]);
                TareaFormula[] tareasFormulaElim = (TareaFormula[]) tareaFormulaEliminadaList.toArray(new TareaFormula[0]);
                tareasFormula = (TareaFormula[]) tareaFormulaList.toArray(new TareaFormula[0]);
                FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
                controllerResult = formulaSemiCabeceraController.updateCabDet(formulaSemiCabecera, detallesFormulaSemi, tareasFormula, detallesFormulaSemiElim, tareasFormulaElim);

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
        //Variables
        boolean r;

        //Inicializar
        r = false;
        long cantidadFinal = 0;
        if (detalleFormulaSemiList.size() < 1){
            info(uiDetProductoCodigo, "Debe cargar los detalles de productos de la formula");
            r = true;
        }else{
                  boolean b = false;
                  for (int i = 0; i < tareaFormulaList.size(); i++) {
                        TareaFormula tare = tareaFormulaList.get(i);
                        if (tare.getTareaFin() != null && tare.getTareaFin().toString().equals("S"))
                        {
                            cantidadFinal = tare.getCantidadTarea().longValue();
                            b = true;
                            break;
                        }
                 }
            if (!b){
                r = true;
                info(uiDetTareaCodigo, "Favor verifique que exista una tarea de finalizacion");
            }
           
        }


        if (tareaFormulaList.size() < 1){
            info(uiDetTareaCodigo, "Debe cargar los detalles de tareas de la formula");
            r = true;
        }

        if (uiProductoCodigo.getText() == null 
                 || uiProductoCodigo.getText().equals("")
                 || !StringUtils.esNumero(uiProductoCodigo.getText().toString())) {
            info(uiProductoCodigo, "Campo obligatorio, favor ingrese el Codigo numerico de Producto");
            r = true;
        }else{
            Producto p = new ProductoController().findById(Long.valueOf(uiProductoCodigo.getText().toString()));
            if (p == null 
                    || (!p.getCodTipoProducto().getDescripcion().toString().equals("SemiTerminado")
                    && !p.getCodTipoProducto().getDescripcion().toString().equals("Acabado"))) {
                info(uiProductoCodigo, "Favor verifique el Codigo de Producto, debe ser un Producto SemiTerminado");
                r = true;
            }

        }

        if (uiDescripcion.getText() == null || uiDescripcion.getText().equals("") ) {
            info(uiDescripcion, "Campo obligatorio, favor ingrese la descripcion de la formula");
            r = true;
        }
        if (!StringUtils.esNumero(this.uiCantidad.getText().toString()))
            {   r = true;
                this.info(uiCantidad, "La cantidad debe ser campo numerico");
            }else if(Long.valueOf(this.uiCantidad.getText().toString()).longValue()<1){
                r = true;
                this.info(uiCantidad, "La cantidad debe ser mayor a 0");
            }else if(cantidadFinal != 0){
                    if(cantidadFinal != Long.valueOf(this.uiCantidad.getText().toString()).longValue()){
                        r = true;
                        this.info(uiCantidad, "La cantidad de la formula debe igual a la cantidad de la tarea de finalizacion");
                    }
            }
        if (uiEstado.getSelected().toString() == null || uiEstado.getSelected().toString().equals("") ) {
            info(uiEstado, "Campo obligatorio, favor ingrese el estado de la formula");
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
        if (uiDetProductoCodigo.getText() == null 
                || uiDetProductoCodigo.getText().equals("")
                || !StringUtils.esNumero(uiDetProductoCodigo.getText().toString())) {
        this.errorValidacion= true;
        info(uiDetProductoCodigo, "Verifique el detalle de Recurso");
        }else{
            Producto p = new ProductoController().findById(Long.valueOf(uiDetProductoCodigo.getText().toString()));
            if (p == null) {
                this.errorValidacion= true;
                info(uiDetProductoCodigo, "Verifique el detalle de Recurso");
            }else if(!p.getCodTipoProducto().getDescripcion().equals("ProductoGenerico")){
                this.errorValidacion= true;
                info(uiDetProductoCodigo, "Favor seleccione un Producto Generico");
            }else {
            // CONTROLAR ACA QUENO SE REPITAN LOS PRODUCTOS GENERICOS

            }
        }

        if (uiDetProductoCantidad.getText() == null 
                || uiDetProductoCantidad.getText().equals("")
                || !StringUtils.esNumero(uiDetProductoCantidad.getText().toString())) {

            this.errorValidacion= true;
            info(uiDetProductoCodigo, "Verifique la cantidad del detalle");
        }else if(Long.valueOf(uiDetProductoCantidad.getText().toString()).longValue()<1){
                    this.errorValidacion= true;
                    info(uiDetProductoCodigo, "La cantidad del detalle debe ser mayor a 0");
        }
    }
    public void validarDetalleTarea(){
        this.errorValidacion= false;
        if (uiDetTareaCodigo.getText() == null 
                    || uiDetTareaCodigo.getText().equals("")
                    || !StringUtils.esNumero(uiDetTareaCodigo.getText().toString())) {
        this.errorValidacion= true;
        info(uiDetTareaCodigo, "Verifique el codigo de tarea");
        }else{
            Tarea t = new TareaController().findById(Long.valueOf(uiDetTareaCodigo.getText().toString()));
            if (t == null) {
                 this.errorValidacion= true;
                info(uiDetTareaCodigo, "Verifique el codigo de tarea");
            }
        }

        if (uiDetTareaCantidad.getText() == null 
                || uiDetTareaCantidad.getText().equals("")
                || !StringUtils.esNumero(uiDetTareaCantidad.getText().toString())) {
        this.errorValidacion= true;
        info(uiDetTareaCodigo, "Verifique el detalle");
        }else if(Long.valueOf(uiDetTareaCantidad.getText().toString()).longValue()<1){
            this.errorValidacion= true;
            info(uiDetTareaCodigo, "Verifique la cantidad del detalle");
        }

        if (uiDetTareaOrden.getText() == null 
                || uiDetTareaOrden.getText().equals("")
                || !StringUtils.esNumero(uiDetTareaOrden.getText().toString())) {
        this.errorValidacion= true;
        info(uiDetTareaCodigo, "Verifique el detalle");
        }


        if (this.uiDetTareaFin.isChecked()) {
            boolean b = false;
                  if (this.uiCantidad.getText() == null
                    ||this.uiCantidad.getText().toString().equals("")
                    ||!StringUtils.esNumero(this.uiCantidad.getText().toString())){
                        this.errorValidacion= true;
                        info(uiDetTareaCodigo, "Para ingresar una tarea de Finalizacion primero Ingrese la cantidad de la Formula");
                  }else if(StringUtils.esNumero(uiDetTareaCantidad.getText().toString())
                    && Long.valueOf(uiDetTareaCantidad.getText().toString()).longValue() != Long.valueOf(this.uiCantidad.getText().toString()).longValue()){
                        this.errorValidacion= true;
                        info(uiDetTareaCodigo, "La cantidad de la tarea de finalizacion debe correspoder a la cantidad de la Formula");
                  }else{
                            for (int i = 0; i < tareaFormulaList.size(); i++) {
                                TareaFormula tare = tareaFormulaList.get(i);
                                if (tare.getTareaFin() != null && tare.getTareaFin().toString().equals("S") && !tare.getCodTarea().getCodTarea().toString().equals(this.uiDetTareaCodigo.getText().toString()))   {
                                    b = true;
                                    break;
                                }
                            }
                            if (b){
                                this.errorValidacion= true;
                                info(uiDetTareaCodigo, "Ya existe una tarea de finalizacion de la Formula");
                            }
                     }
            }
}

public void limpiarDetalleProducto(){

this.uiDetProductoCodigo.setText("");
this.uiDetProductoNombre.setText("");
this.uiDetProductoCantidad.setText("");

}

public void limpiarDetalleTarea(){

this.uiDetTareaCodigo.setText("");
this.uiDetTareaNombre.setText("");
this.uiDetTareaCantidad.setText("");
this.uiDetTareaOrden.setText("");

}


    public String buttonAddDetProd_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        validarDetalleProducto();

        if (!errorValidacion) {
           
            if (!editarDetalleRecurso){

                   Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetProductoCodigo.getText().toString()));

                   detalleFormulaSemi = new FormulaSemiDetalle();
                   detalleFormulaSemi.setCodProducto(producto);
                   detalleFormulaSemi.setCantidad(BigInteger.valueOf(Long.valueOf(this.uiDetProductoCantidad.getText().toString())));

                   detalleFormulaSemiList.add(detalleFormulaSemi);
            }else{
                   Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetProductoCodigo.getText().toString()));

                   detalleFormulaSemi  = detalleFormulaSemiList.get(Integer.valueOf(itemDet).intValue());
                   detalleFormulaSemi.setCodProducto(producto);
                   detalleFormulaSemi.setCantidad(BigInteger.valueOf(Long.valueOf(this.uiDetProductoCantidad.getText().toString())));
                   editarDetalleRecurso = false;

            }
           detallesFormulaSemi = (FormulaSemiDetalle[]) detalleFormulaSemiList.toArray(new FormulaSemiDetalle[0]);
            limpiarDetalleProducto();

        }

        return null;
    }

    public String buttonAddDetTar_action() {
        // TODO: Replace with your code
        
        validarDetalleTarea();

        if (!errorValidacion) {
            if (!editarDetalleTarea){
                   Tarea tarea = new TareaController().findById(Long.valueOf(this.uiDetTareaCodigo.getText().toString()));

                   tareaFormula = new TareaFormula();
                   tareaFormula.setCodTarea(tarea);
                   tareaFormula.setCantidadTarea(BigInteger.valueOf(Long.valueOf(this.uiDetTareaCantidad.getText().toString())));
                   tareaFormula.setOrdenTarea(BigInteger.valueOf(Long.valueOf(this.uiDetTareaOrden.getText().toString())));
                   if (this.uiDetTareaFin.isChecked()) {tareaFormula.setTareaFin("S");}
                   tareaFormulaList.add(tareaFormula);
            }else{
                  Tarea tarea = new TareaController().findById(Long.valueOf(this.uiDetTareaCodigo.getText().toString()));
                  
                  tareaFormula  = tareaFormulaList.get(Integer.valueOf(itemDet).intValue());
                  tareaFormula.setCodTarea(tarea);
                  tareaFormula.setCantidadTarea(BigInteger.valueOf(Long.valueOf(this.uiDetTareaCantidad.getText().toString())));
                  tareaFormula.setOrdenTarea(BigInteger.valueOf(Long.valueOf(this.uiDetTareaOrden.getText().toString())));
                  editarDetalleTarea = false;
            }
            tareasFormula = (TareaFormula[]) tareaFormulaList.toArray(new TareaFormula[0]);
            limpiarDetalleTarea();
         }
        return null;
        
    }


    public String detailRemoveTarea() {

        // esta bandera se usa para determinar el comportamiento del boton guardar detalle
    editarDetalleTarea = false;

    //// agrego la formula eliminada a la lista de formulas Eliminadas
    //// se utiliza luego al actualizar el registro
    if (updateRequest) {
        TareaFormula tarForEliminada  = tareaFormulaList.get(Integer.valueOf(itemDet).intValue());
        if (tarForEliminada.getCodFormulaSemiCabecera() != null) {
            tareaFormulaEliminadaList.add(tarForEliminada);
        }

    }
    tareaFormulaList.remove(Integer.valueOf(itemDet).intValue());
    tareasFormula = (TareaFormula[]) tareaFormulaList.toArray(new TareaFormula[0]);
    return null;

    }

    public String detailRemoveRecurso() {

        // esta bandera se usa para determinar el comportamiento del boton guardar detalle
    editarDetalleRecurso = false;

        //// agrego la formula eliminada a la lista de formulas Eliminadas
        //// se utiliza luego al actualizar el registro
     if (updateRequest) {
        FormulaSemiDetalle fSemiDetEliminada  = detalleFormulaSemiList.get(Integer.valueOf(itemDet).intValue());
         if (fSemiDetEliminada.getCodFormulaSemiCabecera() != null) {
               detalleFormulaSemiEliminadaList.add(fSemiDetEliminada);
         }

    }
   
        detalleFormulaSemiList.remove(Integer.valueOf(itemDet).intValue());
        detallesFormulaSemi = (FormulaSemiDetalle[]) detalleFormulaSemiList.toArray(new FormulaSemiDetalle[0]);
        return null;

    }

    public String detailEditTarea() {
            // esta bandera se usa para determinar el comportamiento del boton guardar detalle
            editarDetalleTarea = true;
        
            TareaFormula tareaFormula = new TareaFormula();
            tareaFormula = tareaFormulaList.get(Integer.valueOf(itemDet).intValue());
        
            
            this.uiDetTareaCodigo.setText(tareaFormula.getCodTarea().getCodTarea().toString());
            this.uiDetTareaNombre.setText(tareaFormula.getCodTarea().getNombreTarea().toString());
            this.uiDetTareaCantidad.setText(tareaFormula.getCantidadTarea().toString());
            this.uiDetTareaOrden.setText(tareaFormula.getOrdenTarea().toString());

    return null;
}

    public String detailEditRecurso() {
            // esta bandera se usa para determinar el comportamiento del boton guardar detalle
            editarDetalleRecurso = true;

            FormulaSemiDetalle formulaSemiDetalle = new FormulaSemiDetalle();
            formulaSemiDetalle = detalleFormulaSemiList.get(Integer.valueOf(itemDet).intValue());

            this.uiDetProductoCodigo.setText(formulaSemiDetalle.getCodProducto().getCodProducto().toString());
            this.uiDetProductoNombre.setText(formulaSemiDetalle.getCodProducto().getDescripcion().toString());
            this.uiDetProductoCantidad.setText(formulaSemiDetalle.getCantidad().toString());

    return null;
}
    private String itemDet;

    public String getItemDet() {
        return itemDet;
    }

    public void setItemDet(String itemDet) {
        this.itemDet = itemDet;
    }





    public boolean isAddRequest() {
        return addRequest;
    }

    public void setAddRequest(boolean addRequest) {
        this.addRequest = addRequest;
    }

    public boolean isErrorValidacion() {
        return errorValidacion;
    }

    public void setErrorValidacion(boolean errorValidacion) {
        this.errorValidacion = errorValidacion;
    }

    public boolean isUpdateRequest() {
        return updateRequest;
    }

    public void setUpdateRequest(boolean updateRequest) {
        this.updateRequest = updateRequest;
    }

    public List<FormulaSemiDetalle> getDetalleFormulaSemiEliminadaList() {
        return detalleFormulaSemiEliminadaList;
    }

    public void setDetalleFormulaSemiEliminadaList(List<FormulaSemiDetalle> detalleFormulaSemiEliminadaList) {
        this.detalleFormulaSemiEliminadaList = detalleFormulaSemiEliminadaList;
    }

    public boolean isEditarDetalleRecurso() {
        return editarDetalleRecurso;
    }

    public void setEditarDetalleRecurso(boolean editarDetalleRecurso) {
        this.editarDetalleRecurso = editarDetalleRecurso;
    }

    public List<TareaFormula> getTareaFormulaEliminadaList() {
        return tareaFormulaEliminadaList;
    }

    public void setTareaFormulaEliminadaList(List<TareaFormula> tareaFormulaEliminadaList) {
        this.tareaFormulaEliminadaList = tareaFormulaEliminadaList;
    }

    public boolean isEditarDetalleTarea() {
        return editarDetalleTarea;
    }

    public void setEditarDetalleTarea(boolean editarDetalleTarea) {
        this.editarDetalleTarea = editarDetalleTarea;
    }




}



   

