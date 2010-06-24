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
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.SolicitudInternaController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.Producto;
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
public class ABMSolicitudesInternas extends AbstractPageBean {
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
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
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
    private TextField uiTxtDescProducto = new TextField();

    public TextField getUiTxtDescProducto() {
        return uiTxtDescProducto;
    }

    public void setUiTxtDescProducto(TextField tf) {
        this.uiTxtDescProducto = tf;
    }
    private TextField uiTxtCantidad = new TextField();

    public TextField getUiTxtCantidad() {
        return uiTxtCantidad;
    }

    public void setUiTxtCantidad(TextField tf) {
        this.uiTxtCantidad = tf;
    }
    private Button uiBtnGuardarNuevo = new Button();

    public Button getUiBtnGuardarNuevo() {
        return uiBtnGuardarNuevo;
    }

    public void setUiBtnGuardarNuevo(Button b) {
        this.uiBtnGuardarNuevo = b;
    }
    private Button uiBtnGuardarEditar = new Button();

    public Button getUiBtnGuardarEditar() {
        return uiBtnGuardarEditar;
    }

    public void setUiBtnGuardarEditar(Button b) {
        this.uiBtnGuardarEditar = b;
    }
    private Button uiBtnCancelar = new Button();

    public Button getUiBtnCancelar() {
        return uiBtnCancelar;
    }

    public void setUiBtnCancelar(Button b) {
        this.uiBtnCancelar = b;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private Button uiBtnBuscar = new Button();

    public Button getUiBtnBuscar() {
        return uiBtnBuscar;
    }

    public void setUiBtnBuscar(Button b) {
        this.uiBtnBuscar = b;
    }
    private Button uiBtnTodos = new Button();

    public Button getUiBtnTodos() {
        return uiBtnTodos;
    }

    public void setUiBtnTodos(Button b) {
        this.uiBtnTodos = b;
    }
    private SingleSelectOptionsList uiLstEstadoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiLstEstadoDefaultOptions() {
        return uiLstEstadoDefaultOptions;
    }

    public void setUiLstEstadoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiLstEstadoDefaultOptions = ssol;
    }
    private Table table1 = new Table();

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table t) {
        this.table1 = t;
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
    private HtmlPanelGrid gridPanelButtonDet = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelButtonDet() {
        return gridPanelButtonDet;
    }

    public void setGridPanelButtonDet(HtmlPanelGrid hpg) {
        this.gridPanelButtonDet = hpg;
    }
    private TabSet tabSetDatosAprobacion = new TabSet();

    public TabSet getTabSetDatosAprobacion() {
        return tabSetDatosAprobacion;
    }

    public void setTabSetDatosAprobacion(TabSet ts) {
        this.tabSetDatosAprobacion = ts;
    }
    private Calendar uiCalFechaDesde = new Calendar();

    public Calendar getUiCalFechaDesde() {
        return uiCalFechaDesde;
    }

    public void setUiCalFechaDesde(Calendar c) {
        this.uiCalFechaDesde = c;
    }
    private Calendar uiCalFechaHasta = new Calendar();

    public Calendar getUiCalFechaHasta() {
        return uiCalFechaHasta;
    }

    public void setUiCalFechaHasta(Calendar c) {
        this.uiCalFechaHasta = c;
    }
    private TextField uiTxtCodEmpleado = new TextField();

    public TextField getUiTxtCodEmpleado() {
        return uiTxtCodEmpleado;
    }

    public void setUiTxtCodEmpleado(TextField tf) {
        this.uiTxtCodEmpleado = tf;
    }
    private TextField uiTxtNombreEmpleado = new TextField();

    public TextField getUiTxtNombreEmpleado() {
        return uiTxtNombreEmpleado;
    }

    public void setUiTxtNombreEmpleado(TextField tf) {
        this.uiTxtNombreEmpleado = tf;
    }
    private Calendar uiCalFecha = new Calendar();

    public Calendar getUiCalFecha() {
        return uiCalFecha;
    }

    public void setUiCalFecha(Calendar c) {
        this.uiCalFecha = c;
    }
    private TextField uiTxtCodProducto = new TextField();

    public TextField getUiTxtCodProducto() {
        return uiTxtCodProducto;
    }

    public void setUiTxtCodProducto(TextField tf) {
        this.uiTxtCodProducto = tf;
    }
    private DropDown uiLstEstado = new DropDown();

    public DropDown getUiLstEstado() {
        return uiLstEstado;
    }

    public void setUiLstEstado(DropDown dd) {
        this.uiLstEstado = dd;
    }
    private TextArea uiTxtObservacion = new TextArea();

    public TextArea getUiTxtObservacion() {
        return uiTxtObservacion;
    }

    public void setUiTxtObservacion(TextArea ta) {
        this.uiTxtObservacion = ta;
    }
    private TextField uiTxtFechaAprobacion = new TextField();

    public TextField getUiTxtFechaAprobacion() {
        return uiTxtFechaAprobacion;
    }

    public void setUiTxtFechaAprobacion(TextField tf) {
        this.uiTxtFechaAprobacion = tf;
    }
    private TextField uiTxtCantidadAprobada = new TextField();

    public TextField getUiTxtCantidadAprobada() {
        return uiTxtCantidadAprobada;
    }

    public void setUiTxtCantidadAprobada(TextField tf) {
        this.uiTxtCantidadAprobada = tf;
    }
    private TextField uiTxtUsuarioAprobacion = new TextField();

    public TextField getUiTxtUsuarioAprobacion() {
        return uiTxtUsuarioAprobacion;
    }

    public void setUiTxtUsuarioAprobacion(TextField tf) {
        this.uiTxtUsuarioAprobacion = tf;
    }
    private HtmlPanelGrid gridPanelEstado = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelEstado() {
        return gridPanelEstado;
    }

    public void setGridPanelEstado(HtmlPanelGrid hpg) {
        this.gridPanelEstado = hpg;
    }
    private Label lblEstado = new Label();

    public Label getLblEstado() {
        return lblEstado;
    }

    public void setLblEstado(Label l) {
        this.lblEstado = l;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private DropDown uiEmpleadoFil = new DropDown();

    public DropDown getUiEmpleadoFil() {
        return uiEmpleadoFil;
    }

    public void setUiEmpleadoFil(DropDown dd) {
        this.uiEmpleadoFil = dd;
    }
    private DropDown uiProductoFil = new DropDown();

    public DropDown getUiProductoFil() {
        return uiProductoFil;
    }

    public void setUiProductoFil(DropDown dd) {
        this.uiProductoFil = dd;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMSolicitudesInternas() {
        uiLstEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("P", "PENDIENTE"), new com.sun.webui.jsf.model.Option("A", "APROBADO"),new com.sun.webui.jsf.model.Option("R", "RECHAZADO")});
        uiLstEstadoDefaultOptions.setSelectedValue("P");
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
        getSessionBean1().setTituloPagina("Solicitudes Internas");
        getSessionBean1().setDetallePagina("");

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
        uiBtnCancelar.setRendered(true);
        if (addRequest) {
            gridPanelBuscar.setRendered(false);
            table1.setRendered(false);
            buttonPanel.setRendered(false);
            addUpdatePanel.setRendered(true);
            uiBtnGuardarNuevo.setRendered(true);
            uiBtnGuardarEditar.setRendered(false);
            tabSetDatosAprobacion.setRendered(true);
            gridPanelButtonDet.setRendered(true);
            uiTxtDescProducto.setText("");
            uiTxtCantidad.setText("");
            this.limpiarCampos();
        } else if (updateRequest) {
            //if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            gridPanelBuscar.setRendered(false);
            table1.setRendered(false);
            buttonPanel.setRendered(false);
            addUpdatePanel.setRendered(true);
            uiBtnGuardarNuevo.setRendered(false);
            uiBtnGuardarEditar.setRendered(true);
            tabSetDatosAprobacion.setRendered(true);
            gridPanelButtonDet.setRendered(true);
            cargarCampos();
        } else if (errorValidacion) {
            addUpdatePanel.setRendered(true);
        } else {
            getSessionBean1().setTituloPagina("Solicitudes Internas");
            getSessionBean1().setDetallePagina("");
            gridPanelBuscar.setRendered(true);
            table1.setRendered(true);
            buttonPanel.setRendered(true);
            addUpdatePanel.setRendered(false);
            tabSetDatosAprobacion.setRendered(false);
            gridPanelButtonDet.setRendered(false);
            this.uiEmpleadoFil.setSelected("-1");
            this.uiProductoFil.setSelected("-1");
            cargarListaTodosEmpleados();
            cargarListaTodosProductos();
            
        }
    // Refresh the users data array in the session bean to to show
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

    private boolean addRequest = false;
    private boolean updateRequest = false;
    private boolean errorValidacion = false;
    private Empleado empleado;
    private EmpleadoController empleadoController;
    private Producto producto;
    private ProductoController productoController;
    private SolicitudInterna e;

    public String addButton_action() {
        addRequest = true;
        e = null;
        deshabilitarCampos(false);
        this.lblEstado.setRendered(false);
        this.gridPanelEstado.setRendered(false);
        getSessionBean1().setTituloPagina("Nueva Solicitud Interna");
        return null;
    }

    public String updateButton_action() {
        updateRequest = true;
        e = null;
         if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
            //Obtenemos la lista de
            SolicitudInterna[] l = getSessionBean1().getListaSolicitud();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            SolicitudInterna e = l[rowId];

            //Guardamos el id d la Solicitud en la session
            getSessionBean1().setId(e.getCodSolicitud());
        }
  

        this.lblEstado.setRendered(true);
        this.gridPanelEstado.setRendered(true);
        getSessionBean1().setTituloPagina("Editar Solicitud Interna");
        return null;
    }

    public String deleteButton_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        // Si la cantidad de registros en la grilla es mayor a 0
        // Eliminamos el elemento seleccionado
        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
            //Obtenemos la lista de
            SolicitudInterna[] l = getSessionBean1().getListaSolicitud();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            e = l[rowId];

            //Eliminados el registro
            SolicitudInternaController controller = new SolicitudInternaController();
            ControllerResult r = controller.delete(e);

            //Mensaje
            if (r.getCodRetorno() == -1) {
                this.pageAlert1.setType("error");
                this.pageAlert1.setTitle("Error al eliminar el Registro");
            } else {
                this.pageAlert1.setType("information");
                this.pageAlert1.setTitle("El Registro se a Eliminado correctamente");
            }

            buscar();
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }

        //Result
        return null;
    }

    public String uiBtnGuardarNuevo_action() {
        // Apagamos la bandera de nuevo registro
        this.addRequest = false;

        //Validamos los campos
        validarCampos();
        SolicitudInterna r;

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Nuevo
            r = new SolicitudInterna();

            //Set de los artributos
            r.setCantidad(Long.valueOf(uiTxtCantidad.getText().toString()));
            r.setCodEmpleado(empleado);
            r.setCodProducto(producto);
            r.setEstado("P");
            r.setFecha(uiCalFecha.getSelectedDate());
            r.setFechaAlta(new Date());
            r.setObservacion(uiTxtObservacion.getText().toString());

            //Insertamos el nuevo registro
            ControllerResult cr = new SolicitudInternaController().create(r);

            //Verificamos el tipo de mensaje
            if (cr.getCodRetorno() == -1) {
                this.pageAlert1.setType("error");
            } else {
                this.pageAlert1.setType("information");
            }

            this.pageAlert1.setTitle(cr.getMsg());
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }

        //result
        return null;
    }

    public String uiBtnGuardarEditar_action() {
        //Obtenemos el registro seleccionado por medio
        //del id almacenado en la session
        SolicitudInterna r = new SolicitudInternaController().findById(getSessionBean1().getId());

        //Validamos los campos
        validarCampos();

        // Apagamos la bandera de nuevo registro
        this.updateRequest = false;
        
        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Set de los artributos
            r.setCantidad(Long.valueOf(uiTxtCantidad.getText().toString()));
            r.setCodEmpleado(empleado);
            r.setCodProducto(producto);
            r.setFecha(uiCalFecha.getSelectedDate());
            r.setFechaModif(new Date());
            r.setObservacion(uiTxtObservacion.getText().toString());

            //Insertamos el nuevo registro
            ControllerResult cr = new SolicitudInternaController().update(r);

            //Verificamos el tipo de mensaje
            if (cr.getCodRetorno() == -1) {
                this.pageAlert1.setType("error");
            } else {
                this.pageAlert1.setType("information");
            }

            buscar();
            this.pageAlert1.setTitle(cr.getMsg());
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }

        return null;
    }

    public String uiBtnCancelar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        addRequest = false;
        updateRequest = false;
        return null;
    }

    /**
     * Limpiar campos
     */
    private void limpiarCampos() {
        uiTxtCantidad.setText(null);
        uiTxtCantidadAprobada.setText(null);
        uiTxtCodEmpleado.setText(null);
        uiTxtCodProducto.setText(null);
        uiTxtDescProducto.setText(null);
        uiTxtFechaAprobacion.setText(null);
        uiTxtNombreEmpleado.setText(null);
        uiTxtObservacion.setText(null);
        uiCalFecha.setSelectedDate(null);
    }

    /**
     * Cargar campos, para la edicion del registro seleccionado
     */
    private void cargarCampos() {
        /* Obtenemos el registro seleccionado por medio
        del id almacenado en la session */
        e = new SolicitudInternaController().findById(getSessionBean1().getId());

        uiTxtCantidad.setText(e.getCantidad());
        uiTxtCantidadAprobada.setText(e.getCantidadAprobada());
        uiTxtCodEmpleado.setText(e.getCodEmpleado().getCodEmpleado());
        uiTxtCodProducto.setText(e.getCodProducto().getCodProducto());
        uiTxtDescProducto.setText(e.getCodProducto().getDescripcion());
        uiTxtUsuarioAprobacion.setText(e.getUsuarioAprobacion());
//        uiTxtFechaAprobacion.setText(new SimpleDateFormat("dd/MM/yyyy").format(e.getFechaAprobacion()));
        uiTxtNombreEmpleado.setText(e.getCodEmpleado().getApellidoEmpleado() + ", " + e.getCodEmpleado().getNombreEmpleado());
        uiTxtObservacion.setText(e.getObservacion());
        uiCalFecha.setSelectedDate(e.getFecha());

        if (updateRequest && !e.getEstado().equals("P")) {
            deshabilitarCampos(true);
        }else{
            deshabilitarCampos(false);
        }
    }


    /**
     * deshabilita los campos
     * @param v
     */
    private void deshabilitarCampos(boolean v){
        uiTxtCantidad.setDisabled(v);
        uiTxtCodEmpleado.setDisabled(v);
        uiTxtCodProducto.setDisabled(v);
        uiTxtDescProducto.setDisabled(v);
        uiTxtNombreEmpleado.setDisabled(v);
        uiTxtObservacion.setDisabled(v);
        uiCalFecha.setDisabled(v);
    }

    private boolean validarCampos() {
        //Variables
        boolean r;

        //Inicializar
        r = false;

        if (uiTxtCodEmpleado.getText() == null || uiTxtCodEmpleado.getText().equals("")) {
            info(uiTxtCodEmpleado, "Campo obligatorio, favor ingrese el Solicitante");
            r = true;
        } else {
            empleadoController = new EmpleadoController();
            empleado = empleadoController.findById(Long.valueOf(uiTxtCodEmpleado.getText().toString()));

            if (empleado == null) {
                info(uiTxtCodEmpleado, "Empleado ingresado no existe");
                r = true;
            }
        }

        if (uiTxtCodProducto.getText() == null || uiTxtCodProducto.getText().equals("")) {
            info(uiTxtCodProducto, "Campo obligatorio, favor ingrese un Producto");
            r = true;
        } else {
            productoController = new ProductoController();
            producto = productoController.findById(Long.valueOf(uiTxtCodProducto.getText().toString()));

            if (producto == null) {
                info(uiTxtCodProducto, "Producto ingresado no existe");
                r = true;
            }
        }

        if (uiTxtCantidad.getText() == null || uiTxtCantidad.getText().equals("")) {
            info(uiTxtCantidad, "Campo obligatorio, favor ingrese una cantidad para el Producto");
            r = true;
        } else {
            if (!StringUtils.esNumero(uiTxtCantidad.getText().toString())) {
                info(uiTxtCantidad, "Cantidad ingresada, debe ser un Numero Entero");
                r = true;
            }
        }

        if (uiCalFecha.getSelectedDate()== null) {
            info(uiCalFecha, "Campo obligatorio, favor ingrese una fecha");
            r = true;
        } else {
            if (uiCalFecha.getSelectedDate().after(new Date()) ) {
                info(uiCalFecha, "Fecha ingresada, debe ser menor o igual a la fecha actual");
                r = true;
            }
        }

        //Si la solicitud ya fue aprobada o rechazada, ya no puede Editarse
        if (updateRequest && !e.getEstado().equals("P")) {
            if (uiCalFecha.getSelectedDate().after(new Date()) ) {
                info(uiTxtCodEmpleado, "La Solicitud no puede Editarse ya fue Aprobado / Rechazado");
                r = true;
            }
        }

        errorValidacion = r;

        //result
        return r;
    }

    public String uiBtnBuscar_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Realizamos la busqueda
        buscar();

        //Result
        return null;
    }

    /**
     * Buscar los registros que cumplan con la condicion/s de busqueda
     * y actualizar la lista de la session
     */
    public void buscar() {
        //Verificamos el contenido de los campos de busqueda
        SolicitudInternaController c = new SolicitudInternaController();
        String pSolicitante = null, pProducto = null;
        Date pFechaDesde = null, pFechaHasta = null;

//        Solicitante
        if (!this.uiEmpleadoFil.getSelected().toString().equals("-1")) {
            pSolicitante = this.uiEmpleadoFil.getSelected().toString();
        }

        //Producto
        if (!this.uiProductoFil.getSelected().toString().equals("-1")) {
            pProducto = this.uiProductoFil.getSelected().toString();
        }

        //Fecha desde
        if (this.uiCalFechaDesde.getSelectedDate() != null) {
            pFechaDesde = this.uiCalFechaDesde.getSelectedDate();
        }

        //Fecha hasta
        if (this.uiCalFechaHasta.getSelectedDate() != null) {
            pFechaHasta = this.uiCalFechaHasta.getSelectedDate();
        }

        //Buscamos la lista de registros
        SolicitudInterna[] l = (SolicitudInterna[]) c.getSolicitudInternas(pSolicitante, pProducto, pFechaDesde, pFechaHasta, null).toArray(new SolicitudInterna[0]);

        //Actualizamos la lista de la session
        getSessionBean1().setListaSolicitud(l);
    }

    public String uiBtnTodos_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Ceramos los campos de busqueda
        this.uiEmpleadoFil.setSelected("-1");
        this.uiProductoFil.setSelected("-1");
        this.uiCalFechaDesde.setSelectedDate(null);
        this.uiCalFechaHasta.setSelectedDate(null);

        //Realizamos la busuqueda
        buscar();

        //result
        return null;
    }
///// CARGA DE COMBO BOX EMPLEADOS
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

        listaEmpleadosOp = new Option[listaEmpleados.length+1];
        Option option;
        for (int i = 0; i < listaEmpleados.length; i++) {
            Empleado em = listaEmpleados[i];
            option = new Option();
            option.setLabel(em.getNombreEmpleado()+" "+em.getApellidoEmpleado());
            option.setValue(em.getCodEmpleado().toString());
            listaEmpleadosOp[i] = option;
        }
            option = new Option();
            option.setLabel("Todos");
            option.setValue("-1");
            listaEmpleadosOp[listaEmpleados.length] = option;
        
    }
       
///// FIN CARGA DE COMBO BOX EMPLEADOS


///// CARGA DE LISTA DE PRODUCTOS
    /// CARGA DE COMBO BOX PRODUCTOS
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
        listaProductos = (Producto[]) productoController.getProductosGenericos(null, null,null).toArray(new Producto[0]);
        listaProductosOp = new Option[listaProductos.length+1];
        Option option;
        for (int i = 0; i < listaProductos.length; i++) {
            Producto p = listaProductos[i];
            option = new Option();
            option.setLabel(p.getCodProducto().toString()+" "+p.getDescripcion()+" "+p.getCodMarca().getNombre());
            option.setValue(p.getCodProducto().toString());
            listaProductosOp[i] = option;
        }
            option = new Option();
            option.setLabel("Todos");
            option.setValue("-1");
            listaProductosOp[listaProductos.length] = option;
     }

////// FIN CARGA DE LISTA DE PRODUCTOS

}

