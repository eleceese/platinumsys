/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.data.provider.RowKey;
import com.sun.rave.faces.converter.CalendarConverter;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.convert.CharacterConverter;
import javax.faces.convert.NumberConverter;
import py.com.platinum.controller.EquivalenciaController;
import py.com.platinum.controller.FacturaCompraCabController;
import py.com.platinum.controller.ParametroController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.ProveedorController;
import py.com.platinum.controller.SolicitudInternaController;
import py.com.platinum.controller.TipoComprobanteController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Equivalencia;
import py.com.platinum.entity.FacturaCompraCab;
import py.com.platinum.entity.FacturaCompraDet;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.Proveedor;
import py.com.platinum.entity.SolicitudInterna;
import py.com.platinum.entity.TipoComprobante;
import py.com.platinum.utils.StringUtils;
import py.com.platinum.utilsenum.ModelUtil;
import py.com.platinum.utilsenum.ModuloEnum;
import py.com.platinum.utilsenum.ParametroEnum;

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
public class ABMComprasProveedor extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
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
    private HtmlPanelGrid addUpdatePanel = new HtmlPanelGrid();

    public HtmlPanelGrid getAddUpdatePanel() {
        return addUpdatePanel;
    }

    public void setAddUpdatePanel(HtmlPanelGrid hpg) {
        this.addUpdatePanel = hpg;
    }
    private TextField uiTxtNombreProveedor = new TextField();

    public TextField getUiTxtNombreProveedor() {
        return uiTxtNombreProveedor;
    }

    public void setUiTxtNombreProveedor(TextField tf) {
        this.uiTxtNombreProveedor = tf;
    }
    private TextField emailAddressField = new TextField();

    public TextField getEmailAddressField() {
        return emailAddressField;
    }

    public void setEmailAddressField(TextField tf) {
        this.emailAddressField = tf;
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
    private TextField userNameFiltro = new TextField();

    public TextField getUserNameFiltro() {
        return userNameFiltro;
    }

    public void setUserNameFiltro(TextField tf) {
        this.userNameFiltro = tf;
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
    private SingleSelectOptionsList uiLstEstadoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiLstEstadoDefaultOptions() {
        return uiLstEstadoDefaultOptions;
    }

    public void setUiLstEstadoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiLstEstadoDefaultOptions = ssol;
    }
    private TextField uiFilTxtNroFactura = new TextField();

    public TextField getUiFilTxtNroFactura() {
        return uiFilTxtNroFactura;
    }

    public void setUiFilTxtNroFactura(TextField tf) {
        this.uiFilTxtNroFactura = tf;
    }
    private Calendar uiFilCalFechaFactura = new Calendar();

    public Calendar getUiFilCalFechaFactura() {
        return uiFilCalFechaFactura;
    }

    public void setUiFilCalFechaFactura(Calendar c) {
        this.uiFilCalFechaFactura = c;
    }
    private TextField uiFilTxtProveedor = new TextField();

    public TextField getUiFilTxtProveedor() {
        return uiFilTxtProveedor;
    }

    public void setUiFilTxtProveedor(TextField tf) {
        this.uiFilTxtProveedor = tf;
    }
    private TableColumn tableColumn11 = new TableColumn();

    public TableColumn getTableColumn11() {
        return tableColumn11;
    }

    public void setTableColumn11(TableColumn tc) {
        this.tableColumn11 = tc;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TextField uiTxtNroFac = new TextField();

    public TextField getUiTxtNroFac() {
        return uiTxtNroFac;
    }

    public void setUiTxtNroFac(TextField tf) {
        this.uiTxtNroFac = tf;
    }
    private DropDown uiLstTipoComprobante = new DropDown();

    public DropDown getUiLstTipoComprobante() {
        return uiLstTipoComprobante;
    }

    public void setUiLstTipoComprobante(DropDown dd) {
        this.uiLstTipoComprobante = dd;
    }
    private DropDown uiLstEstado = new DropDown();

    public DropDown getUiLstEstado() {
        return uiLstEstado;
    }

    public void setUiLstEstado(DropDown dd) {
        this.uiLstEstado = dd;
    }
    private TextField uiTxtCodProveedor = new TextField();

    public TextField getUiTxtCodProveedor() {
        return uiTxtCodProveedor;
    }

    public void setUiTxtCodProveedor(TextField tf) {
        this.uiTxtCodProveedor = tf;
    }
    private TextField uiTxtTotalIva = new TextField();

    public TextField getUiTxtTotalIva() {
        return uiTxtTotalIva;
    }

    public void setUiTxtTotalIva(TextField tf) {
        this.uiTxtTotalIva = tf;
    }
    private TextField uiTxtCantidad = new TextField();

    public TextField getUiTxtCantidad() {
        return uiTxtCantidad;
    }

    public void setUiTxtCantidad(TextField tf) {
        this.uiTxtCantidad = tf;
    }
    private TextField uiTxtPrecioUnitario = new TextField();

    public TextField getUiTxtPrecioUnitario() {
        return uiTxtPrecioUnitario;
    }

    public void setUiTxtPrecioUnitario(TextField tf) {
        this.uiTxtPrecioUnitario = tf;
    }
    private TextField uiTxtDescProducto = new TextField();

    public TextField getUiTxtDescProducto() {
        return uiTxtDescProducto;
    }

    public void setUiTxtDescProducto(TextField tf) {
        this.uiTxtDescProducto = tf;
    }
    private TextField uiTxtCodProducto = new TextField();

    public TextField getUiTxtCodProducto() {
        return uiTxtCodProducto;
    }

    public void setUiTxtCodProducto(TextField tf) {
        this.uiTxtCodProducto = tf;
    }
    private TextField uiTxtSubTotal = new TextField();

    public TextField getUiTxtSubTotal() {
        return uiTxtSubTotal;
    }

    public void setUiTxtSubTotal(TextField tf) {
        this.uiTxtSubTotal = tf;
    }
    private TextField uiTxtTotal = new TextField();

    public TextField getUiTxtTotal() {
        return uiTxtTotal;
    }

    public void setUiTxtTotal(TextField tf) {
        this.uiTxtTotal = tf;
    }
    private Calendar uiCalFecha = new Calendar();

    public Calendar getUiCalFecha() {
        return uiCalFecha;
    }

    public void setUiCalFecha(Calendar c) {
        this.uiCalFecha = c;
    }
    private HtmlPanelGrid gridPanelBtnBuscar = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBtnBuscar() {
        return gridPanelBtnBuscar;
    }

    public void setGridPanelBtnBuscar(HtmlPanelGrid hpg) {
        this.gridPanelBtnBuscar = hpg;
    }
    private SingleSelectOptionsList uiLstIvaDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiLstIvaDefaultOptions() {
        return uiLstIvaDefaultOptions;
    }

    public void setUiLstIvaDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiLstIvaDefaultOptions = ssol;
    }
    private TextField uiTxtMontoIva = new TextField();

    public TextField getUiTxtMontoIva() {
        return uiTxtMontoIva;
    }

    public void setUiTxtMontoIva(TextField tf) {
        this.uiTxtMontoIva = tf;
    }
    private TextField uiTxtMontoTotal = new TextField();

    public TextField getUiTxtMontoTotal() {
        return uiTxtMontoTotal;
    }

    public void setUiTxtMontoTotal(TextField tf) {
        this.uiTxtMontoTotal = tf;
    }
    private DropDown uiLstIva = new DropDown();

    public DropDown getUiLstIva() {
        return uiLstIva;
    }

    public void setUiLstIva(DropDown dd) {
        this.uiLstIva = dd;
    }
    private DropDown uiLstUnidadMedida = new DropDown();

    public DropDown getUiLstUnidadMedida() {
        return uiLstUnidadMedida;
    }

    public void setUiLstUnidadMedida(DropDown dd) {
        this.uiLstUnidadMedida = dd;
    }
    private CharacterConverter characterConverter1 = new CharacterConverter();

    public CharacterConverter getCharacterConverter1() {
        return characterConverter1;
    }

    public void setCharacterConverter1(CharacterConverter cc) {
        this.characterConverter1 = cc;
    }
    private TextField uiTxtNroSolicitud = new TextField();

    public TextField getUiTxtNroSolicitud() {
        return uiTxtNroSolicitud;
    }

    public void setUiTxtNroSolicitud(TextField tf) {
        this.uiTxtNroSolicitud = tf;
    }
    private HtmlPanelGrid gridPanelDetLin1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDetLin1() {
        return gridPanelDetLin1;
    }

    public void setGridPanelDetLin1(HtmlPanelGrid hpg) {
        this.gridPanelDetLin1 = hpg;
    }
    private HtmlPanelGrid gridPanelDetLin2 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDetLin2() {
        return gridPanelDetLin2;
    }

    public void setGridPanelDetLin2(HtmlPanelGrid hpg) {
        this.gridPanelDetLin2 = hpg;
    }
    private TableColumn tableColumnEditarDet = new TableColumn();

    public TableColumn getTableColumnEditarDet() {
        return tableColumnEditarDet;
    }

    public void setTableColumnEditarDet(TableColumn tc) {
        this.tableColumnEditarDet = tc;
    }
    private TableColumn tableColumnEliminarDet = new TableColumn();

    public TableColumn getTableColumnEliminarDet() {
        return tableColumnEliminarDet;
    }

    public void setTableColumnEliminarDet(TableColumn tc) {
        this.tableColumnEliminarDet = tc;
    }
    private Button btnConfirmar = new Button();

    public Button getBtnConfirmar() {
        return btnConfirmar;
    }

    public void setBtnConfirmar(Button b) {
        this.btnConfirmar = b;
    }
    private NumberConverter numberConverter1 = new NumberConverter();

    public NumberConverter getNumberConverter1() {
        return numberConverter1;
    }

    public void setNumberConverter1(NumberConverter nc) {
        this.numberConverter1 = nc;
    }
    private CalendarConverter calendarConverter1 = new CalendarConverter();

    public CalendarConverter getCalendarConverter1() {
        return calendarConverter1;
    }

    public void setCalendarConverter1(CalendarConverter cc) {
        this.calendarConverter1 = cc;
    }
    private SingleSelectOptionsList uiLstFilEstadoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiLstFilEstadoDefaultOptions() {
        return uiLstFilEstadoDefaultOptions;
    }

    public void setUiLstFilEstadoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiLstFilEstadoDefaultOptions = ssol;
    }
    private DropDown uiLstFilEstado = new DropDown();

    public DropDown getUiLstFilEstado() {
        return uiLstFilEstado;
    }

    public void setUiLstFilEstado(DropDown dd) {
        this.uiLstFilEstado = dd;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMComprasProveedor() {

        numberConverter1.setPattern("#,##0");
        numberConverter1.setMinIntegerDigits(1);
        numberConverter1.setMaxIntegerDigits(40);
        numberConverter1.setMaxFractionDigits(3);
        calendarConverter1.setTimeZone(null);
        calendarConverter1.setPattern("dd/MM/yyyy");
        uiLstFilEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("N", "PENDIENTE"), new com.sun.webui.jsf.model.Option("C", "CONFIRMADO"), new com.sun.webui.jsf.model.Option("A", "ANULADO"), new com.sun.webui.jsf.model.Option("T", "TODOS")});
        uiLstFilEstadoDefaultOptions.setSelectedValue("T");

        //Tipos de IVa
        uiLstIvaDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("0", "Exento"), new com.sun.webui.jsf.model.Option("5", "IVA 5%"), new com.sun.webui.jsf.model.Option("10", "IVA 10%")});
        uiLstIvaDefaultOptions.setSelectedValue("0");

        //Estados de la factura
        uiLstEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("C", "Confirmado"), new com.sun.webui.jsf.model.Option("A", "Anulado"), new com.sun.webui.jsf.model.Option("N", "Nuevo")});
        uiLstEstadoDefaultOptions.setSelectedValue("N");

        //Cargamos a las tablas relacionadas
        cargarRelaciones();
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
        getSessionBean1().setTituloPagina("Facturas Compras");
        getSessionBean1().setDetallePagina("Registro de Facturas - Proveedor");
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
        if (addRequest) {
            gridPanelBuscar.setRendered(false);
            table1.setRendered(false);
            buttonPanel.setRendered(false);
            addUpdatePanel.setRendered(true);
            uiBtnGuardarNuevo.setRendered(true);
            uiBtnGuardarEditar.setRendered(false);
            gridPanelBtnBuscar.setRendered(false);
            uiBtnCancelar.setRendered(true);
            gridPanelBtnBuscar.setRendered(false);
            limpiarCamposCabecera();
            addRequest = false;
        } else if (updateRequest) {
            if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                gridPanelBuscar.setRendered(false);
                table1.setRendered(false);
                buttonPanel.setRendered(false);
                addUpdatePanel.setRendered(true);
                uiBtnGuardarNuevo.setRendered(false);
                uiBtnGuardarEditar.setRendered(true);
                uiBtnCancelar.setRendered(true);
                gridPanelBtnBuscar.setRendered(false);

            }
        } else if (errorValidacion) {
            addUpdatePanel.setRendered(true);
        } else if (!updateDetRequest) {
            getSessionBean1().setTituloPagina("Facturas Compras");
            getSessionBean1().setDetallePagina("Registro de Facturas - Proveedor");
            gridPanelBuscar.setRendered(true);
            table1.setRendered(true);
            buttonPanel.setRendered(true);
            gridPanelBtnBuscar.setRendered(true);
            addUpdatePanel.setRendered(false);
        }

        //Actualizamos la lista
        if (!updateDetRequest) {
            buscar();
        }

    }

    /**
     * Limpiar campos
     */
    private void limpiarCamposCabecera() {
        //Limpiamos los campos de la cabecera
        uiTxtCodProveedor.setText(null);
        uiTxtNombreProveedor.setText(null);
        uiTxtNroFac.setText(null);
        uiTxtTotalIva.setText("0");
        uiTxtSubTotal.setText("0");
        uiTxtTotal.setText("0");
        uiCalFecha.setSelectedDate(null);

        //Limpiamos los campos del detalle
        limpiarCamposDetalle();
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
    private boolean updateDetRequest = false;
    private boolean errorValidacion = false;

    /**
     * Action de agregar nuevo registro, prepara los campos para la inserción del
     * nuevo registro.
     *
     * @return refrescamos la pagina
     */
    public String addButton_action() {

        if (!ModelUtil.periodoAbierto()) {
            this.pageAlert1.setType("information");
            this.pageAlert1.setTitle("Periodo Actual esta cerrado no se puede realizar movimeintos");
            ParametroController dao = new ParametroController();
            String fDesde = dao.getParametro(ParametroEnum.PERIODO_ABIERTO_DESDE.toString()).getValorTexto();
            String fHasta = dao.getParametro(ParametroEnum.PERIODO_ABIERTO_HASTA.toString()).getValorTexto();
            this.pageAlert1.setSummary("Periodo Actual " + fDesde + " - " + fHasta);
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);

        } else {
            this.pageAlert1.setRendered(false);
            //Inicializamos las variables
            lstDetalleLIST = new ArrayList();
            lstDetalle = (FacturaCompraDet[]) lstDetalleLIST.toArray(new FacturaCompraDet[0]);

            addRequest = true;
            updateDetRequest = true;
            itemDet = null;


            this.btnConfirmar.setRendered(false);
            gridPanelDetLin1.setRendered(true);
            gridPanelDetLin2.setRendered(true);
            tableColumnEditarDet.setRendered(true);
            tableColumnEliminarDet.setRendered(true);
            uiLstEstado.setReadOnly(true);

            //Cargar tablas realcionadas
            cargarRelaciones();

            //Actualizamos le titulo de la pagina
            getSessionBean1().setTituloPagina("Nueva Factura Compra");
            getSessionBean1().setDetallePagina("Registro de Facturas - Proveedor");
        }



        //result
        return null;
    }

    /**
     * Action de agregar nuevo registro, prepara los campos para la inserción del
     * nuevo registro.
     *
     * @return regrescamos la pagina
     */
    public String updateButton_action() {
        //Inicializamos la variables
        updateRequest = true;
        updateDetRequest = true;
        itemDet = null;

        gridPanelDetLin1.setRendered(false);
        gridPanelDetLin2.setRendered(false);
        tableColumnEditarDet.setRendered(false);
        tableColumnEliminarDet.setRendered(false);

        //Cargamos los datos de las relaciones con esta entidad
        cargarRelaciones();

        //Actualizamos le titulo de la pagina
        getSessionBean1().setTituloPagina("Editar Factura Compra");
        getSessionBean1().setDetallePagina("Registro de Facturas - Proveedor");

        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            cabecera = lstCabecera[rowId];

            //Obetenemos el detalle
            lstDetalleLIST = cabecera.getFacturaCompraDetList();
            lstDetalle = (FacturaCompraDet[]) lstDetalleLIST.toArray(new FacturaCompraDet[0]);

            //Detalles a eliminar
            lstDetalleEliminar = new ArrayList();

            //Obetenemos los atributos de la cabecera
            uiTxtNroFac.setText(cabecera.getNroFactura());
            uiTxtCodProveedor.setText(cabecera.getCodProveedor().getCodProveedor());
            uiTxtNombreProveedor.setText(cabecera.getCodProveedor().getNombreProveedor());
            uiLstEstado.setSelected(cabecera.getEstado());
            if (cabecera.getEstado().equals("N")) {
                this.btnConfirmar.setRendered(true);
            } else {
                this.btnConfirmar.setRendered(false);
            }

            uiLstTipoComprobante.setSelected(cabecera.getTipo().getCodTipo().toString());
            uiCalFecha.setSelectedDate(cabecera.getFecha());
            uiTxtSubTotal.setText(String.valueOf(cabecera.getSubTotal()));
            uiTxtTotal.setText(String.valueOf(cabecera.getTotal()));
            uiTxtTotalIva.setText(String.valueOf(cabecera.getTotaIva()));
        }


        //result
        return null;
    }

    public String deleteButton_action() {
        //Ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        // Si la cantidad de registros en la grilla es mayor a 0
        // Eliminamos el elemento seleccionado
        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            FacturaCompraCab e = lstCabecera[rowId];

            //Eliminados el registro
            FacturaCompraCabController controller = new FacturaCompraCabController();
            ControllerResult r = controller.eliminar(e, e.getFacturaCompraDetList());

            //Mensaje
            if (r.getCodRetorno() == -1) {
                this.pageAlert1.setType("error");
                this.pageAlert1.setTitle("Error al eliminar el Registro");
            } else {
                this.pageAlert1.setType("information");
                this.pageAlert1.setTitle("El Registro se a Eliminado correctamente");
            }

            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }

        //Result
        return null;
    }

    public String uiBtnGuardarNuevo_action() {
        //Validamos los campos
        validarCabecera();

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Nuevo
            cabecera = new FacturaCompraCab();

            //Set de los artributos
            cabecera.setCodProveedor(proveedor);
            cabecera.setEstado("N");
            cabecera.setFecha(uiCalFecha.getSelectedDate());
            cabecera.setNroFactura(uiTxtNroFac.getText().toString());
            cabecera.setCodDeposito(getSessionBean1().getCodDeposito());
            //Tipo de comprobante
            cabecera.setTipo(tipoComprobante);
            cabecera.setTotaIva(Long.valueOf(uiTxtTotalIva.getText().toString()));
            cabecera.setSubTotal(Long.valueOf(uiTxtSubTotal.getText().toString()));
            cabecera.setTotal(Long.valueOf(uiTxtTotal.getText().toString()));
            cabecera.setUsuarioAlta(getSessionBean1().getUsuarioLogueado().getUsuario());
            cabecera.setFechaAlta(new Date());

            //Insertamos la cebecera y del detalle
            ControllerResult cr = new FacturaCompraCabController().crear(cabecera, lstDetalleLIST);

            //Verificamos el tipo de mensaje
            if (cr.getCodRetorno() == -1) {
                this.pageAlert1.setType("error");
                errorValidacion = true;
            } else {
                // Apagamos la bandera de nuevo registro
                this.addRequest = false;
                this.updateDetRequest = false;
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

    /**
     * Validar los campos de la entidad, para verificar si los datos ingresados
     * por el usuario es correcto y si estan todos los campos obligatorios.
     */
    private void validarCabecera() {
        //Apagamos la bandera de error
        this.errorValidacion = false;

        //Nro. Factura
        if (this.uiTxtNroFac.getText() == null) {
            info("Nro. de factura, campo obligatorio");
            this.errorValidacion = true;
        }

        //Proveedor
        if (this.uiTxtCodProveedor.getText() == null) {
            info("Proveedor, campo obligatorio");
            this.errorValidacion = true;
        } else {
            //Validamos el codigo del proveedor ingresado
            proveedor = new ProveedorController().findById(Long.valueOf(uiTxtCodProveedor.getText().toString()));

            if (proveedor == null) {
                info("Codigo de Proveedor ingresado no es encontrado, campo obligatorio favor ingrese un codigo correcto");
                this.errorValidacion = true;
            }
        }

        //Verificamos si el numero de factura ya existe
        if (this.uiTxtNroFac.getText() != null && proveedor != null) {
            FacturaCompraCabController c = new FacturaCompraCabController();
            //Realizamos la busqueda
            boolean existe = c.existeNumeroFactura(this.uiTxtNroFac.getText().toString(), proveedor.getCodProveedor());

            if (existe) {
                info("Numero de Factura ya existe para el proveedor ingresado, favor verifique");
                this.errorValidacion = true;
            }

        }

        //Tipo de Comprobante
        if (this.uiLstTipoComprobante.getSelected() == null) {
            info("Tipo de Comprobante, campo obligatorio");
            this.errorValidacion = true;
        } else {
            //Validamos el codigo del proveedor ingresado
            tipoComprobante = new TipoComprobanteController().findById(Long.valueOf(this.uiLstTipoComprobante.getSelected().toString()));

            if (tipoComprobante == null) {
                info("Tipo de Comprobante ingresado no es encontrado, campo obligatorio");
                this.errorValidacion = true;
            }
        }

        //Fecha
        if (this.uiCalFecha.getSelectedDate() == null) {
            info("Fecha Pedido, campo obligatorio");
            this.errorValidacion = true;
        }

    }

    public String uiBtnGuardarEditar_action() {

        if (!ModelUtil.periodoAbierto()) {
            this.pageAlert1.setType("information");
            this.pageAlert1.setTitle("Periodo Actual esta cerrado no se puede realizar movimeintos");
            ParametroController dao = new ParametroController();
            String fDesde = dao.getParametro(ParametroEnum.PERIODO_ABIERTO_DESDE.toString()).getValorTexto();
            String fHasta = dao.getParametro(ParametroEnum.PERIODO_ABIERTO_HASTA.toString()).getValorTexto();
            this.pageAlert1.setSummary("Periodo Actual " + fDesde + " - " + fHasta);
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);

        } else {
            this.pageAlert1.setRendered(false);
            if (!errorValidacion) {
                //Validamos los campos
                //validarCabecera();

                //Si no hay error de validacion insertamos el registro
                //Set de los artributos
                cabecera.setEstado("A");
                cabecera.setUsuarioModif(getSessionBean1().getUsuarioLogueado().getUsuario());
                cabecera.setFechaModif(new Date());

                //Insertamos la cebecera y del detalle
                ControllerResult cr = new FacturaCompraCabController().actualizar(cabecera, lstDetalleLIST, lstDetalleEliminar);

                //Verificamos el tipo de mensaje
                if (cr.getCodRetorno() == -1) {
                    this.pageAlert1.setType("error");
                    errorValidacion = true;
                } else {
                    // Apagamos la bandera de Editar registro
                    this.updateRequest = false;
                    this.updateDetRequest = false;
                    this.pageAlert1.setType("information");
                }

                this.pageAlert1.setTitle(cr.getMsg());
                this.pageAlert1.setSummary("");
                this.pageAlert1.setDetail("");
                this.pageAlert1.setRendered(true);
            }
        }

        //result
        return null;
    }

    public String uiBtnCancelar_action() {
        //Apagamos las banderas
        addRequest = false;
        updateRequest = false;
        updateDetRequest = false;
        errorValidacion = false;
        this.pageAlert1.setRendered(false);

        //result
        return null;
    }

    public String uiBtnBuscar_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Realizamos la busqueda
        buscar();

        //Result
        return null;
    }
    private FacturaCompraCab cabecera;
    private FacturaCompraCab[] lstCabecera;
    private FacturaCompraDet detalle;
    private FacturaCompraDet[] lstDetalle;
    private List<FacturaCompraDet> lstDetalleLIST;
    private List<FacturaCompraDet> lstDetalleEliminar;
    private SolicitudInterna solicitud;
    private Producto producto;
    private Proveedor proveedor;
    private TipoComprobante tipoComprobante;

    public FacturaCompraCab getCabecera() {
        return cabecera;
    }

    public void setCabecera(FacturaCompraCab cabecera) {
        this.cabecera = cabecera;
    }

    public FacturaCompraDet getDetalle() {
        return detalle;
    }

    public void setDetalle(FacturaCompraDet detalle) {
        this.detalle = detalle;
    }

    public FacturaCompraCab[] getLstCabecera() {
        return lstCabecera;
    }

    public void setLstCabecera(FacturaCompraCab[] lstCabecera) {
        this.lstCabecera = lstCabecera;
    }

    public FacturaCompraDet[] getLstDetalle() {
        return lstDetalle;
    }

    public void setLstDetalle(FacturaCompraDet[] lstDetalle) {
        this.lstDetalle = lstDetalle;
    }

    public List<FacturaCompraDet> getLstDetalleLIST() {
        return lstDetalleLIST;
    }

    public void setLstDetalleLIST(List<FacturaCompraDet> lstDetalleLIST) {
        this.lstDetalleLIST = lstDetalleLIST;
    }

    /**
     * Buscar los registros que cumplan con la condicion/s de busqueda
     * y actualizar la lista de la session
     */
    public void buscar() {
        //Verificamos el contenido de los campos de busqueda
        FacturaCompraCabController c = new FacturaCompraCabController();
        Date pFechaFactura = null;
        String pNroFactura = null, pProveedor = null, pEstado = null;


        //Nro. Factura
        if (this.uiFilTxtNroFactura.getText() != null) {
            pNroFactura = this.uiFilTxtNroFactura.getText().toString();
        }

        //Proveedor
        if (this.uiFilTxtProveedor.getText() != null) {
            pProveedor = this.uiFilTxtProveedor.getText().toString();
        }

        //Fecha
        if (this.uiFilCalFechaFactura.getSelectedDate() != null) {
            pFechaFactura = this.uiFilCalFechaFactura.getSelectedDate();
        }

        //Estado
        if (this.uiLstEstado.getSelected() != null) {
            pEstado = this.uiLstEstado.getSelected().toString();
        }

        //Buscamos la lista de registros
        lstCabecera = (FacturaCompraCab[]) c.getFacturaCompraCab(pNroFactura, pProveedor, pFechaFactura, pEstado).toArray(new FacturaCompraCab[0]);

    }

    public String uiBtnTodos_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Ceramos los campos de busqueda
        this.uiFilTxtNroFactura.setText(null);
        this.uiFilTxtProveedor.setText(null);
        this.uiFilCalFechaFactura.setSelectedDate(null);

        //Realizamos la busuqueda
        buscar();

        //Result
        return null;
    }

    public String uiBtnAgregarDet_action() {
        //Validamos el detalle
        validarDetalle();

        //Sino hubo error de validacion
        if (!errorValidacion) {

            /* Si itemDet es null, en ese caso es un nuevo detalle */

            //Controlamos si es Nuevo Detalle
            if (itemDet == null) {
                detalle = new FacturaCompraDet();
            }

            //Obtenemos los datos ingresados
            detalle.setCodProducto(producto);
            detalle.setCantidad(Long.valueOf(uiTxtCantidad.getText().toString()));
            detalle.setPrecioUni(Long.valueOf(uiTxtPrecioUnitario.getText().toString()));
            detalle.setPorcIva(Double.valueOf(uiLstIva.getSelected().toString()));
            detalle.setMontoIva(Long.valueOf(uiTxtMontoIva.getText().toString()));
            detalle.setTotal(Long.valueOf(uiTxtMontoTotal.getText().toString()));

            //Nro de solicitud
            if (uiTxtNroSolicitud.getText() != null) {
                detalle.setNroSolicitud(solicitud);
            }

            //Agregamos a la lista
            if (itemDet == null) {
                lstDetalleLIST.add(detalle);
            }

            //Actualizamos la grilla
            lstDetalle = (FacturaCompraDet[]) lstDetalleLIST.toArray(new FacturaCompraDet[0]);

            //Ceramos el item seleccionado
            itemDet = null;

            //Ceramos los campos del detalle
            limpiarCamposDetalle();

            //Calculamos los totales
            calcularTotales();

        }

        //result
        return null;
    }

    /**
     * Validar detalle antes de ingresar al detalle
     */
    private void validarDetalle() {
        //Apagamos la bandera de error
        this.errorValidacion = false;
        Producto p = null;
        //Producto
        if (this.uiTxtCodProducto.getText() == null || this.uiTxtCodProducto.getText().equals("")) {
            info("Codigo Producto obligatorio, ingrese un valor");
            errorValidacion = true;
        } else {
            //Obtenemos el producto
            producto = new ProductoController().findById(Long.valueOf(uiTxtCodProducto.getText().toString()));
            if (producto == null) {
                info("Producto no existe, ingrese un codigo de producto correcto");
                errorValidacion = true;
            } else {
                p = new ProductoController().findById(Long.valueOf(uiTxtCodProducto.getText().toString()));
            }
        }

        //Cantidad
        Long cant = null;
        if (this.uiTxtCantidad.getText() == null || this.uiTxtCantidad.getText().equals("")) {
            info("Cantidad del Producto obligatorio, ingrese un valor");
            errorValidacion = true;
        } else {
            //Verificamos si la cantidad es un numero
            String cantidad = this.uiTxtCantidad.getText().toString();

            if (!StringUtils.esNumero(cantidad) || !StringUtils.esNumeroDecimal(cantidad)) {
                info("Cantidad del Producto,debe se Numero");
                errorValidacion = true;
            } else {
                cant = Long.valueOf(cantidad);
            }
        }

        //Precio
        if (this.uiTxtPrecioUnitario.getText() == null || this.uiTxtPrecioUnitario.getText().equals("")) {
            info("Precio del Producto obligatorio, ingrese un valor");
            errorValidacion = true;
        } else {
            //Verificamos si la precio es un numero
            String cantidad = this.uiTxtPrecioUnitario.getText().toString();

            if (!StringUtils.esNumero(cantidad)) {
                info("Precio del Producto, debe se Numero");
                errorValidacion = true;
            }
        }

        //Unidad medida
        if (this.uiLstUnidadMedida.getSelected() == null) {
            info("Unidad de medida, Campo obligatorio favor ingrese un valor");
            errorValidacion = true;
        }

        //Iva
        if (this.uiLstIva.getSelected() == null) {
            info("Tipo de IVA, Campo obligatorio favor ingrese un valor");
            errorValidacion = true;
        }

        //Solicitud interna
        if (uiTxtNroSolicitud.getText() != null) {
            solicitud = new SolicitudInternaController().findById(Long.valueOf(uiTxtNroSolicitud.getText().toString()));

            if (solicitud == null) {
                info("Nro. de Solicitud Interna ingresado es incorrecto, favor ingrese un valor correcto");
                errorValidacion = true;
            } else {
                SolicitudInterna sol = new SolicitudInternaController().findById(Long.valueOf(uiTxtNroSolicitud.getText().toString()));
                if (sol.getEstado().equals("A")) {
                    ////// VALIDACION DEL PRODUCTO ELEGIDO Y LA CANTIDAD

                    if (sol != null && p != null && cant != null) {

                        SolicitudInterna solIn = new SolicitudInterna();
                        SolicitudInternaController sController = new SolicitudInternaController();
                        solIn = sController.getSolicitudPorEquiv(sol.getCodSolicitud(), p.getCodProducto());
                        if (solIn == null) {
                            this.errorValidacion = true;
                            info("El producto ingresado no corresponde a la Solicitud");
                        } else {
                            Equivalencia eq = new EquivalenciaController().getEqPorProductos(solIn.getCodProducto().getCodProducto(), p.getCodProducto());
                            double relacion = eq.getRelacion().doubleValue();
                            double retirado = relacion * cant;
                            if (solIn.getCantidadCompra() + retirado > solIn.getCantidadAprobada()) {
                                this.errorValidacion = true;
                                info("Se ha superado la cantidad aprobada para la Solicitud");
                            }
                        }
                        ////// FIN VALIDACION DEL PRODUCTO ELEGIDO Y LA CANTIDAD
                    }
                } else {
                    this.errorValidacion = true;
                    info("La solicitud no ha sido aprobada");

                }
            }

        }
    }
    //Detalle selecciondo de la Grilla
    private String itemDet;

    public String getItemDet() {
        return itemDet;
    }

    public void setItemDet(String itemDet) {
        this.itemDet = itemDet;
    }

    /**
     * Actualizamos el detalle seleccionado
     *
     * @return
     */
    public String updateDetAction() {
        //Obtenemos el detalle seleccionado
        this.detalle = lstDetalleLIST.get(Integer.valueOf(itemDet).intValue());

        //Obtenemos los valores del detalle q ha sido seleccionado
        uiTxtCodProducto.setText(detalle.getCodProducto().getCodProducto());
        uiTxtDescProducto.setText(detalle.getCodProducto().getDescripcion());
        uiTxtNroSolicitud.setText(detalle.getNroSolicitud().getCodSolicitud());
        uiLstUnidadMedida.setSelected(detalle.getCodProducto().getCodUnidadMedida().getCodUnidadMedida().toString());
        uiTxtPrecioUnitario.setText(detalle.getPrecioUni());
        uiTxtCantidad.setText(detalle.getCantidad());
        uiLstIva.setSelected(String.valueOf(Double.valueOf(detalle.getPorcIva()).longValue()));
        uiTxtMontoIva.setText(detalle.getMontoIva());
        uiTxtMontoTotal.setText(detalle.getTotal());

        //result
        return null;
    }

    /**
     * Eliminamos el detalle seleccionado
     *
     * @return
     */
    public String deleteDetAction() {
        //Obtenemos el detalle seleccionado
        detalle = lstDetalleLIST.get(Integer.valueOf(itemDet).intValue());

        //Argegamos el detalle, a la lista de detalle para eliminar
        if (updateRequest) {
            lstDetalleEliminar.add(detalle);
        }

        //Eliminamos de la lista temporal el detalle
        lstDetalleLIST.remove(Integer.valueOf(itemDet).intValue());

        //Actualizamos la grilla
        lstDetalle = (FacturaCompraDet[]) lstDetalleLIST.toArray(new FacturaCompraDet[0]);

        //Calculamos los totales
        calcularTotales();

        //Ceramos el item seleccionado
        itemDet = null;

        //result
        return null;
    }

    /**
     * Recorremos la lista de detalle y actualizamos los totales
     */
    private void calcularTotales() {
        //Variables
        long total, totalIva;

        //Inicializamos
        total = 0;
        totalIva = 0;

        //Recorremos el detalle para recalcular los totales
        for (int i = 0; i < lstDetalleLIST.size(); i++) {
            //Obetenemos el detalle
            FacturaCompraDet det = lstDetalleLIST.get(i);

            //Sumamos el monto iva
            totalIva += det.getMontoIva();

            //Sumamos el monto total
            total += det.getTotal();

        }

        //Actualizamos los totales de la cabecera
        uiTxtSubTotal.setText(String.valueOf(total - totalIva));
        uiTxtTotal.setText(String.valueOf(total));
        uiTxtTotalIva.setText(String.valueOf(totalIva));
    }

    /**
     * Limpiamos los campos del detalle
     */
    private void limpiarCamposDetalle() {
        //Limpiamos los campos
        uiTxtCodProducto.setText(null);
        uiTxtDescProducto.setText(null);
        uiTxtPrecioUnitario.setText(null);
        uiTxtCantidad.setText(null);
        uiTxtMontoIva.setText(null);
        uiTxtMontoTotal.setText(null);
        uiTxtNroSolicitud.setText(null);
        itemDet = null;
    }

    /**
     * Limpiamos los campos del detalle
     * 
     * @return refrescamos la pagina
     */
    public String uiBtnCancelarDetalle_action() {

        //Limpiar campos
        limpiarCamposDetalle();

        //result
        return null;
    }

    /**
     * Carga los datos de las tablas relacionadas a esta entidad
     */
    private void cargarRelaciones() {
        //Cargamos la lista de unidades de medida
        getSessionBean1().cargarListaTodosUnidadMedidas();

        //Cargamos la lista de Productos
        getSessionBean1().cargarListaTodosProductos();

        //Cargamos la lista de Proveedores
        getSessionBean1().cargarListaTodosProveedores();

        //Cargamos la lista de tipos de comprobantes
        getSessionBean1().cargarListaTipoComprobantePorModulo(ModuloEnum.COMPRA);


    }

    public String btnConfirmar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        cabecera.setEstado("C");
        cabecera.setUsuarioModif(getSessionBean1().getUsuarioLogueado().getUsuario());
        cabecera.setFechaModif(new Date());
        FacturaCompraCabController c = new FacturaCompraCabController();
        c.actualizar(cabecera, lstDetalleLIST, lstDetalleEliminar);

        info("Factura Confirmada");

        return null;
    }
}
