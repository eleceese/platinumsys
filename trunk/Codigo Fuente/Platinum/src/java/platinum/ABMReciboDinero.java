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
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.convert.CharacterConverter;
import py.com.platinum.controller.FacturaCabeceraController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.ClienteController;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.PedidoCabeceraController;
import py.com.platinum.controller.TipoComprobanteController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.FacturaCabecera;
import py.com.platinum.entity.FacturaDetalle;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.Cliente;
import py.com.platinum.entity.PedidoCabecera;
import py.com.platinum.entity.PedidoDetalle;
import py.com.platinum.entity.TipoComprobante;
import py.com.platinum.utils.DateUtils;
import py.com.platinum.utils.StringUtils;
import py.com.platinum.utilsenum.FacturaVentaEstado;
import py.com.platinum.utilsenum.ModelUtil;
import py.com.platinum.utilsenum.ModuloEnum;

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
public class ABMReciboDinero extends AbstractPageBean {
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
    private TextField uiTxtNombreCliente = new TextField();

    public TextField getUiTxtNombreCliente() {
        return uiTxtNombreCliente;
    }

    public void setUiTxtNombreCliente(TextField tf) {
        this.uiTxtNombreCliente = tf;
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
    private TextField uiFilTxtNroRecibo = new TextField();

    public TextField getUiFilTxtNroRecibo() {
        return uiFilTxtNroRecibo;
    }

    public void setUiFilTxtNroRecibo(TextField tf) {
        this.uiFilTxtNroRecibo = tf;
    }
    private Calendar uiFilCalFechaFactura = new Calendar();

    public Calendar getUiFilCalFechaFactura() {
        return uiFilCalFechaFactura;
    }

    public void setUiFilCalFechaFactura(Calendar c) {
        this.uiFilCalFechaFactura = c;
    }
    private TextField uiFilTxtCliente = new TextField();

    public TextField getUiFilTxtCliente() {
        return uiFilTxtCliente;
    }

    public void setUiFilTxtCliente(TextField tf) {
        this.uiFilTxtCliente = tf;
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
    private TextField uiTxtNroRecibo = new TextField();

    public TextField getUiTxtNroRecibo() {
        return uiTxtNroRecibo;
    }

    public void setUiTxtNroRecibo(TextField tf) {
        this.uiTxtNroRecibo = tf;
    }
    private DropDown uiLstEstado = new DropDown();

    public DropDown getUiLstEstado() {
        return uiLstEstado;
    }

    public void setUiLstEstado(DropDown dd) {
        this.uiLstEstado = dd;
    }
    private TextField uiTxtCodCliente = new TextField();

    public TextField getUiTxtCodCliente() {
        return uiTxtCodCliente;
    }

    public void setUiTxtCodCliente(TextField tf) {
        this.uiTxtCodCliente = tf;
    }
    private TextField uiTxtTotal1 = new TextField();

    public TextField getUiTxtTotal1() {
        return uiTxtTotal1;
    }

    public void setUiTxtTotal1(TextField tf) {
        this.uiTxtTotal1 = tf;
    }
    private TextField uiTxtSaldoCuota = new TextField();

    public TextField getUiTxtSaldoCuota() {
        return uiTxtSaldoCuota;
    }

    public void setUiTxtSaldoCuota(TextField tf) {
        this.uiTxtSaldoCuota = tf;
    }
    private TextField uiTxtNroComprobante = new TextField();

    public TextField getUiTxtNroComprobante() {
        return uiTxtNroComprobante;
    }

    public void setUiTxtNroComprobante(TextField tf) {
        this.uiTxtNroComprobante = tf;
    }
    private TextField uiTxtCodComprobante = new TextField();

    public TextField getUiTxtCodComprobante() {
        return uiTxtCodComprobante;
    }

    public void setUiTxtCodComprobante(TextField tf) {
        this.uiTxtCodComprobante = tf;
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
    private TextField uiTxtMontoCobro = new TextField();

    public TextField getUiTxtMontoCobro() {
        return uiTxtMontoCobro;
    }

    public void setUiTxtMontoCobro(TextField tf) {
        this.uiTxtMontoCobro = tf;
    }
    private CharacterConverter characterConverter1 = new CharacterConverter();

    public CharacterConverter getCharacterConverter1() {
        return characterConverter1;
    }

    public void setCharacterConverter1(CharacterConverter cc) {
        this.characterConverter1 = cc;
    }
    private TextField uiTxtPorcDescuento = new TextField();

    public TextField getUiTxtPorcDescuento() {
        return uiTxtPorcDescuento;
    }

    public void setUiTxtPorcDescuento(TextField tf) {
        this.uiTxtPorcDescuento = tf;
    }
    private TextField uiTxtMontoDescuento = new TextField();

    public TextField getUiTxtMontoDescuento() {
        return uiTxtMontoDescuento;
    }

    public void setUiTxtMontoDescuento(TextField tf) {
        this.uiTxtMontoDescuento = tf;
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
    private Table tableDetalle = new Table();

    public Table getTableDetalle() {
        return tableDetalle;
    }

    public void setTableDetalle(Table t) {
        this.tableDetalle = t;
    }
    private TableRowGroup tableRowGroup2 = new TableRowGroup();

    public TableRowGroup getTableRowGroup2() {
        return tableRowGroup2;
    }

    public void setTableRowGroup2(TableRowGroup trg) {
        this.tableRowGroup2 = trg;
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
    private TextField uiTxtNroPedido = new TextField();

    public TextField getUiTxtNroPedido() {
        return uiTxtNroPedido;
    }

    public void setUiTxtNroPedido(TextField tf) {
        this.uiTxtNroPedido = tf;
    }
    private Button uiBtnCargarPedido = new Button();

    public Button getUiBtnCargarPedido() {
        return uiBtnCargarPedido;
    }

    public void setUiBtnCargarPedido(Button b) {
        this.uiBtnCargarPedido = b;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMReciboDinero() {

        //Estados de la factura
        FacturaVentaEstado[] lstEstado = FacturaVentaEstado.values();
        Option[] lstEstadoOp = new Option[lstEstado.length];
        
        Option o = new Option();
        for (int i = 0; i < lstEstado.length; i++) {
            //Obtenemos el estado
            FacturaVentaEstado p = lstEstado[i];
            
            //Seteamos el value y el label del option
            o.setValue(p.toString());
            o.setLabel(p.toString());
            
            //Agregamos a la lista
            lstEstadoOp[i] = o;
            
            //Cerar
            o = new Option();
        }

        uiLstEstadoDefaultOptions.setOptions(lstEstadoOp);
        uiLstEstadoDefaultOptions.setSelectedValue(FacturaVentaEstado.PENDIENTE_COBRO.toString());

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
        getSessionBean1().setTituloPagina("Facturas Venta");
        getSessionBean1().setDetallePagina("Factura - Cliente");
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
            getSessionBean1().setTituloPagina("Facturas Venta");
            getSessionBean1().setDetallePagina("Registro de Facturas - Cliente");
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
        uiTxtCodCliente.setText(null);
        uiTxtNombreCliente.setText(null);
        uiTxtNroRecibo.setText(null);
        uiTxtTotal1.setText("0");
        uiTxtSubTotal.setText("0");
        uiTxtTotal.setText("0");
        uiTxtPorcDescuento.setText("0");
        uiTxtMontoDescuento.setText("0");
        uiCalFecha.setSelectedDate(null);
        uiTxtNroPedido.setText(null);

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
        //Inicializamos las variables
        lstDetalleLIST = new ArrayList();
        lstDetalle = (FacturaDetalle[]) lstDetalleLIST.toArray(new FacturaDetalle[0]);
        addRequest = true;
        updateDetRequest = true;
        itemDet = null;
        pedido = null;
        tipoComprobante = null;
        cliente = null;
        producto = null;

        //Cargar tablas realcionadas
        cargarRelaciones();

        //Actualizamos le titulo de la pagina
        getSessionBean1().setTituloPagina("Nueva Factura Venta");
        getSessionBean1().setDetallePagina("Factura - Cliente");
        gridPanelDetLin1.setRendered(true);
        gridPanelDetLin2.setRendered(true);
        tableColumnEditarDet.setRendered(true);
        tableColumnEliminarDet.setRendered(true);


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
        lstDetalleEliminar = new ArrayList<FacturaDetalle>();

        //Cargamos los datos de las relaciones con esta entidad
        cargarRelaciones();

        //Actualizamos le titulo de la pagina
        getSessionBean1().setTituloPagina("Ver Detalle Factura Venta");
        getSessionBean1().setDetallePagina("Facturas - Cliente");
        gridPanelDetLin1.setRendered(false);
        gridPanelDetLin2.setRendered(false);
        tableColumnEditarDet.setRendered(false);
        tableColumnEliminarDet.setRendered(false);
        
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);


        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            cabecera = lstCabecera[rowId];

            //Obetenemos el detalle
            lstDetalleLIST = cabecera.getFacturaDetalleList();
            lstDetalle = (FacturaDetalle[]) lstDetalleLIST.toArray(new FacturaDetalle[0]);

            //Detalles a eliminar
            lstDetalleEliminar = new ArrayList();

            //Obetenemos los atributos de la cabecera
            uiTxtNroRecibo.setText(cabecera.getEstablecimiento() + "-"  + cabecera.getBocaExpendio() + "-" + cabecera.getNumeroFactura());
            uiTxtCodCliente.setText(cabecera.getCodCliente().getCodCliente());
            uiTxtNombreCliente.setText(cabecera.getCodCliente().getNombreCliente());
            uiLstEstado.setSelected(cabecera.getEstadoFactura());
            uiCalFecha.setSelectedDate(cabecera.getFechaFactura());
            uiTxtSubTotal.setText(String.valueOf(cabecera.getSubtotalFactura()));
            uiTxtTotal.setText(String.valueOf(cabecera.getTotalFactura()));
            uiTxtTotal1.setText(String.valueOf(cabecera.getTotalIvaFactura()));
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
            FacturaCabecera e = lstCabecera[rowId];

            //Eliminados el registro
            FacturaCabeceraController controller = new FacturaCabeceraController();
            ControllerResult r = controller.eliminar(e, e.getFacturaDetalleList());

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
            cabecera = new FacturaCabecera();

            //Set de los artributos
            cabecera.setCodCliente(cliente);
            cabecera.setFechaFactura(uiCalFecha.getSelectedDate());
            cabecera.setFechaVencimiento(DateUtils.fechaMas(uiCalFecha.getSelectedDate(), tipoComprobante.getCantDias()));
            cabecera.setCodPedido(pedido);
            cabecera.setEstablecimiento(getSessionBean1().getEstablecimiento());
            cabecera.setBocaExpendio(getSessionBean1().getBocaExpendio());
            codEmpleado = new EmpleadoController().findById(Long.valueOf("1"));
            cabecera.setCodEmpleado(codEmpleado);
            cabecera.setPorcDescuento(Long.valueOf(uiTxtPorcDescuento.getText().toString()));
            cabecera.setMontoDescuento(Long.valueOf(uiTxtMontoDescuento.getText().toString()));
            cabecera.setCodDeposito(getSessionBean1().getCodDeposito());
            
            //Tipo de comprobante
            cabecera.setTipoFactura(tipoComprobante);
            cabecera.setTotalIvaFactura(Long.valueOf(uiTxtTotal1.getText().toString()));
            cabecera.setSubtotalFactura(Long.valueOf(uiTxtSubTotal.getText().toString()));
            cabecera.setTotalFactura(Long.valueOf(uiTxtTotal.getText().toString()));

            //El estado dependiendo del tipo de comprobante
            if (tipoComprobante.getCantCuota() > 0) {
                cabecera.setEstadoFactura(ModelUtil.getFacturaVentaEstado(uiLstEstado.getSelected().toString()));
            } else {
                cabecera.setEstadoFactura(FacturaVentaEstado.COBRADO);
            }

            //Insertamos la cebecera y del detalle
            ControllerResult cr = new FacturaCabeceraController().crear(cabecera, lstDetalleLIST);

            //Verificamos el tipo de mensaje
            if (cr.getCodRetorno() == -1) {
                this.pageAlert1.setType("error");
                errorValidacion = true;
            } else {
                // Apagamos la bandera de nuevo registro
                this.addRequest = false;
                this.updateDetRequest = false;
                this.pageAlert1.setType("information");
                uiTxtNroRecibo.setText(cabecera.getNumeroFactura());
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

        //Cliente
        if (this.uiTxtCodCliente.getText() == null) {
            info("Cliente, campo obligatorio");
            this.errorValidacion = true;
        }else{
            //Validamos el codigo del Cliente ingresado
            cliente = new ClienteController().findById(Long.valueOf(uiTxtCodCliente.getText().toString()));

            if (cliente == null) {
                info("Codigo de Cliente ingresado no es encontrado, campo obligatorio favor ingrese un codigo correcto");
                this.errorValidacion = true;
            }
        }

        //Pedido
        if (this.uiCalFecha.getSelectedDate() == null) {
            info("Fecha Factura, campo obligatorio");
            this.errorValidacion = true;
        }

        if (uiTxtNroPedido.getText()!= null ){
            pedido = pedidoController.findById(Long.valueOf(uiTxtNroPedido.getText().toString()));
            if (pedido == null) {
                errorValidacion = true;
                info("Numero de Pedido ingresado incorrecto, favor verifique");
            }
        }
    }

    public String uiBtnGuardarEditar_action() {
        //Inicializamos
        errorValidacion = false;

        //Verificamos el estado del comprobante
        if (cabecera.getEstadoFactura().toString().equals(FacturaVentaEstado.ANULADO.toString())) {
            info("La Factura ya fue Anulada");
            errorValidacion = true;
        } else if(cabecera.getEstadoFactura().toString().equals(FacturaVentaEstado.COBRADO.toString())){
            info("La Factura no puede ser Anulada, por que ya fue Cobrada al Cliente");
            errorValidacion = true;
        }
        
        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {

            cabecera.setEstadoFactura(FacturaVentaEstado.ANULADO);

            //Insertamos la cebecera y del detalle
            ControllerResult cr = new FacturaCabeceraController().update(cabecera);

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

        //result
        return null;
    }

    public String uiBtnCancelar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        addRequest = false;
        updateRequest = false;
        updateDetRequest = false;
        errorValidacion = false;
        this.pageAlert1.setRendered(false);
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
    private FacturaCabecera cabecera;
    private FacturaCabecera[] lstCabecera;
    private FacturaDetalle detalle;
    private FacturaDetalle[] lstDetalle;
    private List<FacturaDetalle> lstDetalleLIST;
    private List<FacturaDetalle> lstDetalleEliminar;
    private Producto producto;
    private Cliente cliente;
    private TipoComprobante tipoComprobante;
    private Empleado codEmpleado  = new Empleado();
    private PedidoCabecera pedido = new PedidoCabecera();
    private PedidoCabeceraController pedidoController = new PedidoCabeceraController();

    public FacturaCabecera getCabecera() {
        return cabecera;
    }

    public void setCabecera(FacturaCabecera cabecera) {
        this.cabecera = cabecera;
    }

    public FacturaDetalle getDetalle() {
        return detalle;
    }

    public void setDetalle(FacturaDetalle detalle) {
        this.detalle = detalle;
    }

    public FacturaCabecera[] getLstCabecera() {
        return lstCabecera;
    }

    public void setLstCabecera(FacturaCabecera[] lstCabecera) {
        this.lstCabecera = lstCabecera;
    }

    public FacturaDetalle[] getLstDetalle() {
        return lstDetalle;
    }

    public void setLstDetalle(FacturaDetalle[] lstDetalle) {
        this.lstDetalle = lstDetalle;
    }

    public List<FacturaDetalle> getLstDetalleLIST() {
        return lstDetalleLIST;
    }

    public void setLstDetalleLIST(List<FacturaDetalle> lstDetalleLIST) {
        this.lstDetalleLIST = lstDetalleLIST;
    }

    /**
     * Buscar los registros que cumplan con la condicion/s de busqueda
     * y actualizar la lista de la session
     */
    public void buscar() {
        //Verificamos el contenido de los campos de busqueda
        FacturaCabeceraController c = new FacturaCabeceraController();
        Date pFechaFactura = null;
        String pNroFactura = null, pCliente = null;

        //Nro. Pendido
        if (this.uiFilTxtNroRecibo.getText() != null) {
            pNroFactura = this.uiFilTxtNroRecibo.getText().toString();
        }

        //Cliente
        if (this.uiFilTxtCliente.getText() != null) {
            pCliente = this.uiFilTxtCliente.getText().toString();
        }

        //Fecha
        if (this.uiFilCalFechaFactura.getSelectedDate() != null) {
            pFechaFactura = this.uiFilCalFechaFactura.getSelectedDate();
        }

        //Buscamos la lista de registros
        lstCabecera = (FacturaCabecera[]) c.getFacturaCabecera(pNroFactura, pCliente, pFechaFactura).toArray(new FacturaCabecera[0]);

    }

    public String uiBtnTodos_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Ceramos los campos de busqueda
        this.uiFilTxtNroRecibo.setText(null);
        this.uiFilTxtCliente.setText(null);
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
                detalle = new FacturaDetalle();
            }

            //Obtenemos los datos ingresados
            detalle.setCodProducto(producto);
            detalle.setPrecioUnitario(Long.valueOf(uiTxtSaldoCuota.getText().toString()));
           
            detalle.setSubTotal(Long.valueOf(uiTxtMontoCobro.getText().toString()));

            //Agregamos a la lista
            if (itemDet == null) {
                lstDetalleLIST.add(detalle);
            }

            //Actualizamos la grilla
            lstDetalle = (FacturaDetalle[]) lstDetalleLIST.toArray(new FacturaDetalle[0]);

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

        //Producto
        if (this.uiTxtCodComprobante.getText() == null || this.uiTxtCodComprobante.getText().equals("")) {
            info("Codigo Producto obligatorio, ingrese un valor");
            errorValidacion = true;
        } else {
            //Obtenemos el producto
            producto = new ProductoController().findById(Long.valueOf(uiTxtCodComprobante.getText().toString()));
            if (producto == null) {
                info("Producto no existe, ingrese un codigo de producto correcto");
                errorValidacion = true;
            }
        }

        //Precio
        if (this.uiTxtSaldoCuota.getText() == null || this.uiTxtSaldoCuota.getText().equals("")) {
            info("Precio del Producto obligatorio, ingrese un valor");
            errorValidacion = true;
        } else {
            //Verificamos si la precio es un numero
            String cantidad = this.uiTxtSaldoCuota.getText().toString();

            if (!StringUtils.esNumero(cantidad)) {
                info("Precio del Producto, debe se Numero");
                errorValidacion = true;
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
        uiTxtCodComprobante.setText(detalle.getCodProducto().getCodProducto());
        uiTxtNroComprobante.setText(detalle.getCodProducto().getDescripcion());
        uiTxtSaldoCuota.setText(detalle.getPrecioUnitario());
        uiTxtMontoCobro.setText(detalle.getSubTotal());

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
        lstDetalle = (FacturaDetalle[]) lstDetalleLIST.toArray(new FacturaDetalle[0]);

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
        double porcDescuento;
        long total, totalIva, totalDescuento;

        //Inicializamos
        total = 0;
        totalIva = 0;
        totalDescuento = 0;
        porcDescuento  = Double.valueOf(uiTxtPorcDescuento.getText().toString());

        //Recorremos el detalle para recalcular los totales
        for (int i = 0; i < lstDetalleLIST.size(); i++) {
            //Obetenemos el detalle
            FacturaDetalle det = lstDetalleLIST.get(i);

            //Sumamos el monto iva
            totalIva += det.getTotalIva();

            //Sumamos el monto total
            total += det.getSubTotal();

        }

        //Actualizamos los totales de la cabecera
        uiTxtSubTotal.setText(String.valueOf(total - totalIva));
        uiTxtTotal1.setText(String.valueOf(totalIva));

        //Aplicamos el descuento
        totalDescuento = (long) ((total + totalIva) * porcDescuento / 100);
        total = total + totalIva - totalDescuento;
        uiTxtTotal.setText(String.valueOf(total));
        uiTxtMontoDescuento.setText(String.valueOf(totalDescuento));
    }

    /**
     * Limpiamos los campos del detalle
     */
    private void limpiarCamposDetalle() {
        //Limpiamos los campos
        uiTxtCodComprobante.setText(null);
        uiTxtNroComprobante.setText(null);
        uiTxtSaldoCuota.setText(null);
        uiTxtMontoCobro.setText(null);
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
        //Cargamos la lista de Productos
        getSessionBean1().cargarListaTodosProductos();

        //Cargamos la lista de Clientees
        getSessionBean1().cargarListaCliente();

        //Cargamos la lista de unidades de medida
        getSessionBean1().cargarListaTodosUnidadMedidas();

        //Cargamos la lista de tipos de comprobantes
        getSessionBean1().cargarListaTipoComprobantePorModulo(ModuloEnum.VENTA);


    }

    public String uiBtnCargarPedido_action() {
        //Inicializamos
        errorValidacion = false;

        if (uiTxtNroPedido.getText()== null && uiTxtNroPedido.getText().toString().trim().equals("")){
            errorValidacion = true;
            info("Debe Seleccionar un Pedido para poder cargar datos de un Pedido");
        }else{
            

            pedido = pedidoController.findById(Long.valueOf(uiTxtNroPedido.getText().toString()));

            if (pedido == null) {
                errorValidacion = true;
                info("Numero de Pedido ingresado incorrecto, favor verifique");
            }else{
                /* Cargamos los datos del pedido */

                //Cabecera
                uiTxtCodCliente.setText(pedido.getCodCliente().getCodCliente());
                uiTxtNombreCliente.setText(pedido.getCodCliente().getApellidoCliente() + ", " + pedido.getCodCliente().getNombreCliente());
                uiCalFecha.setSelectedDate(new Date());
                uiLstEstado.setSelected(FacturaVentaEstado.PENDIENTE_COBRO.toString());
                uiTxtTotal.setText(pedido.getTotal());
                uiTxtTotal1.setText(pedido.getTotalIva());
                uiTxtSubTotal.setText(pedido.getSubTotal());

                //Detalle
                List<PedidoDetalle> detallePedido = pedido.getPedidoDetalleList();

                lstDetalleLIST = new ArrayList<FacturaDetalle>();
                
                //Recorremos la lista de detalle del pedido
                for (int i = 0; i < detallePedido.size(); i++) {
                    //Obtenemos el detalle
                    PedidoDetalle x = detallePedido.get(i);

                    //Creamos el detalle de la factura
                    detalle = new FacturaDetalle();
                    detalle.setCantidad(x.getCantidadPedida());
                    detalle.setCodPedidoDetalle(x);
                    detalle.setCodProducto(x.getCodProducto());
                    detalle.setFechaAlta(new Date());
                    detalle.setPorcentajeIva(x.getPorcIva());
                    detalle.setPrecioUnitario(x.getPrecioUnitario());
                    detalle.setSubTotal(x.getTotal());
                    detalle.setTotalIva(x.getMontoIva());

                    //Agregamos a la lista
                    lstDetalleLIST.add(detalle);
                }

                //Actualizamos el array detalle
                lstDetalle = (FacturaDetalle[]) lstDetalleLIST.toArray(new FacturaDetalle[0]);
            }
        }

        //result
        return null;
    }
}
