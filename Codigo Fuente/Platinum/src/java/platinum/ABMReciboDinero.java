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
import com.sun.webui.jsf.component.ImageHyperlink;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.convert.CharacterConverter;
import javax.faces.convert.NumberConverter;
import javax.faces.event.ValueChangeEvent;
import py.com.platinum.controller.ReciboCabeceraController;
import py.com.platinum.controller.ClienteController;
import py.com.platinum.controller.FormaPagoController;
import py.com.platinum.controller.ParametroController;
import py.com.platinum.controller.SaldoClienteController;
import py.com.platinum.controller.TipoComprobanteController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.Parametros;
import py.com.platinum.entity.ReciboCabecera;
import py.com.platinum.entity.ReciboDetalle;
import py.com.platinum.entity.Cliente;
import py.com.platinum.entity.FormaPago;
import py.com.platinum.entity.MovimientoCajaDetalle;
import py.com.platinum.entity.SaldoCliente;
import py.com.platinum.utils.StringUtils;
import py.com.platinum.utilsenum.ModelUtil;
import py.com.platinum.utilsenum.ParametroEnum;
import py.com.platinum.utilsenum.ReciboEstado;
import py.com.platinum.view.VClientesSaldos;

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
        numberConverter1.setPattern("#,##0");
        numberConverter1.setMinIntegerDigits(1);
        numberConverter1.setMaxIntegerDigits(40);
        numberConverter1.setMaxFractionDigits(3);
        calendarConverter1.setTimeZone(null);
        calendarConverter1.setPattern("dd/MM/yyyy");
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
    private TextField uiTxtTotalCabecera = new TextField();

    public TextField getUiTxtTotalCabecera() {
        return uiTxtTotalCabecera;
    }

    public void setUiTxtTotalCabecera(TextField tf) {
        this.uiTxtTotalCabecera = tf;
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
    private NumberConverter numberConverter1 = new NumberConverter();

    public NumberConverter getNumberConverter1() {
        return numberConverter1;
    }

    public void setNumberConverter1(NumberConverter nc) {
        this.numberConverter1 = nc;
    }
    private TextField uiTxtSerie = new TextField();

    public TextField getUiTxtSerie() {
        return uiTxtSerie;
    }

    public void setUiTxtSerie(TextField tf) {
        this.uiTxtSerie = tf;
    }
    private TextField uiTxtDescComprobante = new TextField();

    public TextField getUiTxtDescComprobante() {
        return uiTxtDescComprobante;
    }

    public void setUiTxtDescComprobante(TextField tf) {
        this.uiTxtDescComprobante = tf;
    }
    private TextField uiTxtFecVencimiento = new TextField();

    public TextField getUiTxtFecVencimiento() {
        return uiTxtFecVencimiento;
    }

    public void setUiTxtFecVencimiento(TextField tf) {
        this.uiTxtFecVencimiento = tf;
    }
    private TextField uiTxtNroCuota = new TextField();

    public TextField getUiTxtNroCuota() {
        return uiTxtNroCuota;
    }

    public void setUiTxtNroCuota(TextField tf) {
        this.uiTxtNroCuota = tf;
    }
    private TextField uiTxtMontoCuota = new TextField();

    public TextField getUiTxtMontoCuota() {
        return uiTxtMontoCuota;
    }

    public void setUiTxtMontoCuota(TextField tf) {
        this.uiTxtMontoCuota = tf;
    }
    private CalendarConverter calendarConverter1 = new CalendarConverter();

    public CalendarConverter getCalendarConverter1() {
        return calendarConverter1;
    }

    public void setCalendarConverter1(CalendarConverter cc) {
        this.calendarConverter1 = cc;
    }
    private Calendar uiFilCalFecha = new Calendar();

    public Calendar getUiFilCalFecha() {
        return uiFilCalFecha;
    }

    public void setUiFilCalFecha(Calendar c) {
        this.uiFilCalFecha = c;
    }
    private TextField uiTxtTotal1 = new TextField();

    public TextField getUiTxtTotal1() {
        return uiTxtTotal1;
    }

    public void setUiTxtTotal1(TextField tf) {
        this.uiTxtTotal1 = tf;
    }
    private Button uiBtnImprimir = new Button();

    public Button getUiBtnImprimir() {
        return uiBtnImprimir;
    }

    public void setUiBtnImprimir(Button b) {
        this.uiBtnImprimir = b;
    }
    private Label uiLblTituloDetalle = new Label();

    public Label getUiLblTituloDetalle() {
        return uiLblTituloDetalle;
    }

    public void setUiLblTituloDetalle(Label l) {
        this.uiLblTituloDetalle = l;
    }
    private TextField uiTxtTotalComprobantes = new TextField();

    public TextField getUiTxtTotalComprobantes() {
        return uiTxtTotalComprobantes;
    }

    public void setUiTxtTotalComprobantes(TextField tf) {
        this.uiTxtTotalComprobantes = tf;
    }
    private Button uiBtnAgregarDetFC = new Button();

    public Button getUiBtnAgregarDetFC() {
        return uiBtnAgregarDetFC;
    }

    public void setUiBtnAgregarDetFC(Button b) {
        this.uiBtnAgregarDetFC = b;
    }
    private TextField uiTxtNroFormaCobro = new TextField();

    public TextField getUiTxtNroFormaCobro() {
        return uiTxtNroFormaCobro;
    }

    public void setUiTxtNroFormaCobro(TextField tf) {
        this.uiTxtNroFormaCobro = tf;
    }
    private TextField uiTxtDescFormaCobro = new TextField();

    public TextField getUiTxtDescFormaCobro() {
        return uiTxtDescFormaCobro;
    }

    public void setUiTxtDescFormaCobro(TextField tf) {
        this.uiTxtDescFormaCobro = tf;
    }
    private TextField uiTxtCodFormaCobro = new TextField();

    public TextField getUiTxtCodFormaCobro() {
        return uiTxtCodFormaCobro;
    }

    public void setUiTxtCodFormaCobro(TextField tf) {
        this.uiTxtCodFormaCobro = tf;
    }
    private ImageHyperlink uilnkEditardetalleFC = new ImageHyperlink();

    public ImageHyperlink getUilnkEditardetalleFC() {
        return uilnkEditardetalleFC;
    }

    public void setUilnkEditardetalleFC(ImageHyperlink ih) {
        this.uilnkEditardetalleFC = ih;
    }
    private ImageHyperlink uilnkEliminardetalleFC = new ImageHyperlink();

    public ImageHyperlink getUilnkEliminardetalleFC() {
        return uilnkEliminardetalleFC;
    }

    public void setUilnkEliminardetalleFC(ImageHyperlink ih) {
        this.uilnkEliminardetalleFC = ih;
    }
    private TextField uiTxtSerieFormaCobro = new TextField();

    public TextField getUiTxtSerieFormaCobro() {
        return uiTxtSerieFormaCobro;
    }

    public void setUiTxtSerieFormaCobro(TextField tf) {
        this.uiTxtSerieFormaCobro = tf;
    }
    private TextField uiTxtBanco = new TextField();

    public TextField getUiTxtBanco() {
        return uiTxtBanco;
    }

    public void setUiTxtBanco(TextField tf) {
        this.uiTxtBanco = tf;
    }
    private TextField uiTxtMontoFormaCobro = new TextField();

    public TextField getUiTxtMontoFormaCobro() {
        return uiTxtMontoFormaCobro;
    }

    public void setUiTxtMontoFormaCobro(TextField tf) {
        this.uiTxtMontoFormaCobro = tf;
    }
    private TextField uiTxtTotalComprobantesFC = new TextField();

    public TextField getUiTxtTotalComprobantesFC() {
        return uiTxtTotalComprobantesFC;
    }

    public void setUiTxtTotalComprobantesFC(TextField tf) {
        this.uiTxtTotalComprobantesFC = tf;
    }
    private ImageHyperlink uilnkEliminarDetalleFC = new ImageHyperlink();

    public ImageHyperlink getUilnkEliminarDetalleFC() {
        return uilnkEliminarDetalleFC;
    }

    public void setUilnkEliminarDetalleFC(ImageHyperlink ih) {
        this.uilnkEliminarDetalleFC = ih;
    }
    private ImageHyperlink uilnkEditarDetalleFC = new ImageHyperlink();

    public ImageHyperlink getUilnkEditarDetalleFC() {
        return uilnkEditarDetalleFC;
    }

    public void setUilnkEditarDetalleFC(ImageHyperlink ih) {
        this.uilnkEditarDetalleFC = ih;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMReciboDinero() {

        //Estados de la factura
        ReciboEstado[] lstEstado = ReciboEstado.values();
        Option[] lstEstadoOp = new Option[lstEstado.length];

        Option o = new Option();
        for (int i = 0; i < lstEstado.length; i++) {
            //Obtenemos el estado
            ReciboEstado p = lstEstado[i];

            //Seteamos el value y el label del option
            o.setValue(p.toString());
            o.setLabel(p.toString());

            //Agregamos a la lista
            lstEstadoOp[i] = o;

            //Cerar
            o = new Option();
        }

        uiLstEstadoDefaultOptions.setOptions(lstEstadoOp);
        uiLstEstadoDefaultOptions.setSelectedValue(ReciboEstado.PENDIENTE.toString());

        formaPagoController = new FormaPagoController();
        controller = new ReciboCabeceraController();
        saldoController = new SaldoClienteController();

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
            getSessionBean1().setTituloPagina("Recibo Dinero");
            getSessionBean1().setDetallePagina("Cobranzas");
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

    private void actualizarListaComprobantes() {
        String s = uiTxtCodCliente.getText().toString();

        String notIN = getNotINComprobantes();

        //Obetenmos la lista
        List<VClientesSaldos> l = new SaldoClienteController().getComprobantesConSaldos(null, Long.valueOf(s), notIN);

        //Actualizamos la lista de la session
        lstSaldosList = l;
        lstSaldos = (VClientesSaldos[]) lstSaldosList.toArray(new VClientesSaldos[0]);
    }

    /**
     * Limpiar campos
     */
    private void limpiarCamposCabecera() {
        //Limpiamos los campos de la cabecera
        uiTxtCodCliente.setText(null);
        uiTxtNombreCliente.setText(null);
        uiTxtTotal1.setText("0");
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
            //Inicializamos las variables
            this.pageAlert1.setRendered(false);
            lstDetalleLIST = new ArrayList();
            lstDetalle = (ReciboDetalle[]) lstDetalleLIST.toArray(new ReciboDetalle[0]);
            lstDetalleLISTFC = new ArrayList();
            lstDetalleFC = (MovimientoCajaDetalle[]) lstDetalleLISTFC.toArray(new MovimientoCajaDetalle[0]);
            addRequest = true;
            updateDetRequest = true;
            itemDet = null;
            cliente = null;

            //Cargar tablas realcionadas
            cargarRelaciones();

            //Actualizamos le titulo de la pagina
            getSessionBean1().setTituloPagina("Nuevo Recibo de Dinero");
            getSessionBean1().setDetallePagina("Cobro a Cliente - Cobranza");
            gridPanelDetLin1.setRendered(true);
            gridPanelDetLin2.setRendered(true);
            tableColumnEditarDet.setRendered(true);
            tableColumnEliminarDet.setRendered(true);

            //Obtenemos la serie del recibo
            String ser = "A";
            Parametros p = new ParametroController().getParametro(ParametroEnum.SERIE_RECIBO.toString());

            if (p != null) {
                ser = p.getValorTexto();
            }

            uiTxtSerie.setText(ser);
            uiTxtNroRecibo.setText(controller.getNroRecibo(ser));
            uiBtnImprimir.setDisabled(true);
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
        lstDetalleEliminar = new ArrayList<ReciboDetalle>();
        lstDetalleEliminarFC = new ArrayList<MovimientoCajaDetalle>();

        //Cargamos los datos de las relaciones con esta entidad
        cargarRelaciones();

        //Actualizamos le titulo de la pagina
        getSessionBean1().setTituloPagina("Ver Detalle Recibo Dinero");
        getSessionBean1().setDetallePagina("Cobranza Comprobantes a Clientes");
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

            //Obetenemos el detall
            lstDetalleLIST = cabecera.getReciboDetalleList();
            lstDetalle = (ReciboDetalle[]) lstDetalleLIST.toArray(new ReciboDetalle[0]);

            //Detalles a eliminar
            lstDetalleEliminar = new ArrayList();
            lstDetalleEliminarFC = new ArrayList();

            //Obetenemos los atributos de la cabecera
            uiTxtNroRecibo.setText(cabecera.getNumeroRecibo());
            uiTxtCodCliente.setText(cabecera.getCodCliente().getCodCliente());
            uiTxtNombreCliente.setText(cabecera.getCodCliente().getNombreCliente());
            uiTxtSerie.setText(cabecera.getSerieRecibo());
            uiLstEstado.setSelected(cabecera.getEstado().toString());
            uiCalFecha.setSelectedDate(cabecera.getFecha());
            uiTxtSubTotal.setText(cabecera.getMontoTotal());
            uiTxtTotal1.setText(cabecera.getMontoTotal());
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
            ReciboCabecera e = lstCabecera[rowId];

            //Eliminados el registro
            ControllerResult r = controller.eliminar(e, e.getReciboDetalleList());

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
            cabecera = new ReciboCabecera();

            //Set de los artributos
            cabecera.setSerieRecibo(uiTxtSerie.getText().toString());
            cabecera.setCodCliente(cliente);
            cabecera.setFecha(uiCalFecha.getSelectedDate());
            cabecera.setEstado(ReciboEstado.PAGADO);
            cabecera.setFechaAlta(new Date());
            cabecera.setMontoTotal(BigInteger.valueOf(Long.valueOf(uiTxtTotal1.getText().toString())));

            //Insertamos la cebecera y del detalle
            ControllerResult cr = controller.crear(cabecera, lstDetalleLIST, lstDetalleLISTFC);

            //Verificamos el tipo de mensaje
            if (cr.getCodRetorno() == -1) {
                this.pageAlert1.setType("error");
                errorValidacion = true;
            } else {
                // Apagamos la bandera de nuevo registro
                //this.addRequest = false;
                //this.updateDetRequest = false;
                this.pageAlert1.setType("information");
                uiTxtNroRecibo.setText(cabecera.getNumeroRecibo());
                uiBtnImprimir.setDisabled(false);
            }

            this.pageAlert1.setTitle(cr.getMsg());
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }

        //result
        return null;
    }

    private VClientesSaldos mapReciboDetTOVClienteSaldo(ReciboDetalle get) {
        //Variables
        VClientesSaldos r = new VClientesSaldos();

        if (get != null) {
            r.setCodComprobante(BigInteger.valueOf(get.getNroComprobante()));
            r.setCodSaldoCliente(BigInteger.valueOf(get.getCodSaldoCliente()));

            //Desc. comprobante
            String desc = new TipoComprobanteController().findById(get.getTipoComprobante().longValue()).getDescTipoAbreviado();
            r.setDescTipoComprobante(desc);
            r.setFecVencimiento(get.getFechaVencimiento());
            r.setNroComprobante(get.getComprobante());
            r.setNroCuota(get.getNroCuota());
            r.setOrden(BigInteger.valueOf(Long.valueOf("0")));
            r.setSaldoComprobante(get.getSaldoCuota());
            r.setTotalComprobante(get.getMontoCuota());
        }

        return r;
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
        } else {
            //Validamos el codigo del Cliente ingresado
            cliente = new ClienteController().findById(Long.valueOf(uiTxtCodCliente.getText().toString()));

            if (cliente == null) {
                info("Codigo de Cliente ingresado no es encontrado, campo obligatorio favor ingrese un codigo correcto");
                this.errorValidacion = true;
            }
        }

        //Fecha
        if (this.uiCalFecha.getSelectedDate() == null) {
            info("Fecha, campo obligatorio");
            this.errorValidacion = true;
        }

        //Fecha
        if (this.uiTxtTotal1.getText() == null || this.uiTxtTotal1.getText().equals("") ) {
            info("Monto Recibo no puede ser igual a Cero");
            this.errorValidacion = true;
        }else{
            //Verificamos si la precio es un numero
            String totRecibo = this.uiTxtTotal1.getText().toString();
            String totFormaCobro = this.uiTxtTotalComprobantesFC.getText().toString();

            if (!StringUtils.esNumero(totRecibo)) {
                info("Total Recibo, debe se Numero");
                errorValidacion = true;
            }else if (!StringUtils.esNumero(totFormaCobro)) {
                info("Total Forma Cobro, debe se Numero");
                errorValidacion = true;
            }else if (!totRecibo.equals(totFormaCobro)) {
                info("Total Forma Cobro, debe ser igual al Importe total de los recibos");
                errorValidacion = true;
            }
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
            //Inicializamos
            errorValidacion = false;

            //Verificamos el estado del comprobante
            if (cabecera.getEstado().toString().equals(ReciboEstado.ANULADO.toString())) {
                info("El Recibo ya fue Anulada");
                errorValidacion = true;
            }

            //Si no hay error de validacion insertamos el registro
            if (!errorValidacion) {

                cabecera.setEstado(ReciboEstado.ANULADO);

                //Insertamos la cebecera y del detalle
                ControllerResult cr = new ReciboCabeceraController().update(cabecera);

                //Verificamos el tipo de mensaje
                if (cr.getCodRetorno() == -1) {
                    this.pageAlert1.setType("error");
                    errorValidacion = true;
                } else {
                    // Apagamos la bandera de Editar registro
                    this.updateRequest = false;
                    this.updateDetRequest = false;
                    this.addRequest = false;
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
    private ReciboCabeceraController controller;
    private ReciboCabecera cabecera;
    private ReciboCabecera[] lstCabecera;
    private ReciboDetalle detalle;
    private ReciboDetalle[] lstDetalle;
    private FormaPago formaPago;
    private FormaPagoController formaPagoController;
    private MovimientoCajaDetalle detalleFC;
    private MovimientoCajaDetalle[] lstDetalleFC;
    private List<MovimientoCajaDetalle> lstDetalleEliminarFC;
    private List<MovimientoCajaDetalle> lstDetalleLISTFC;
    private List<ReciboDetalle> lstDetalleLIST;
    private List<ReciboDetalle> lstDetalleEliminar;
    private Cliente cliente;
    private SaldoCliente saldo;
    private SaldoClienteController saldoController;
    private Empleado codEmpleado = new Empleado();
    private VClientesSaldos[] lstSaldos;
    private List<VClientesSaldos> lstSaldosList = null;

    public ReciboCabecera getCabecera() {
        return cabecera;
    }

    public void setCabecera(ReciboCabecera cabecera) {
        this.cabecera = cabecera;
    }

    public ReciboDetalle getDetalle() {
        return detalle;
    }

    public void setDetalle(ReciboDetalle detalle) {
        this.detalle = detalle;
    }

    public ReciboCabecera[] getLstCabecera() {
        return lstCabecera;
    }

    public void setLstCabecera(ReciboCabecera[] lstCabecera) {
        this.lstCabecera = lstCabecera;
    }

    public ReciboDetalle[] getLstDetalle() {
        return lstDetalle;
    }

    public void setLstDetalle(ReciboDetalle[] lstDetalle) {
        this.lstDetalle = lstDetalle;
    }

    public List<ReciboDetalle> getLstDetalleLIST() {
        return lstDetalleLIST;
    }

    public void setLstDetalleLIST(List<ReciboDetalle> lstDetalleLIST) {
        this.lstDetalleLIST = lstDetalleLIST;
    }

    /**
     * Buscar los registros que cumplan con la condicion/s de busqueda
     * y actualizar la lista de la session
     */
    public void buscar() {
        //Verificamos el contenido de los campos de busqueda
        ReciboCabeceraController c = new ReciboCabeceraController();
        Date pFechaFactura = null;
        String pNroRecibo = null, pCliente = null;

        //Nro. Pendido
        if (this.uiFilTxtNroRecibo.getText() != null) {
            pNroRecibo = this.uiFilTxtNroRecibo.getText().toString();
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
        lstCabecera = (ReciboCabecera[]) c.getReciboCabeceras(pNroRecibo, pCliente, pFechaFactura).toArray(new ReciboCabecera[0]);

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
                detalle = new ReciboDetalle();
            }

            //Obtenemos los datos ingresados
            detalle.setCodRecibo(cabecera);
            detalle.setComprobante(uiTxtNroComprobante.getText().toString());
            detalle.setFechaAlta(new Date());
            detalle.setFechaVencimiento(saldo.getFechaVencimiento());
            detalle.setMontoCuota(BigInteger.valueOf(saldo.getMontoCuota()));
            detalle.setMontoPago(BigInteger.valueOf(Long.valueOf(uiTxtMontoCobro.getText().toString())));
            detalle.setNroComprobante(saldo.getNroComprobante().intValue());
            detalle.setNroCuota(saldo.getNroCuota().intValue());
            detalle.setSaldoCuota(BigInteger.valueOf(saldo.getSaldoCuota()));
            detalle.setTipoComprobante(saldo.getTipoComprobante().intValue());
            detalle.setCodSaldoCliente(saldo.getCodSaldoCliente());

            //Agregamos a la lista
            if (itemDet == null) {
                lstDetalleLIST.add(detalle);
            }

            //Actualizamos la grilla
            lstDetalle = (ReciboDetalle[]) lstDetalleLIST.toArray(new ReciboDetalle[0]);

            //Ceramos el item seleccionado
            itemDet = null;

            //Ceramos los campos del detalle
            limpiarCamposDetalle();

            //Calculamos los totales
            calcularTotales();

            actualizarListaComprobantes();
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

        //Comprobante
        if (this.uiTxtDescComprobante.getText() == null || this.uiTxtDescComprobante.getText().equals("")) {
            info("Seleccione un comprobante, Obligatrio");
            errorValidacion = true;
        } else {
            String c = this.uiTxtDescComprobante.getText().toString();
            c = c.substring(c.indexOf("-") + 1);
            Long cod = Long.valueOf(c);
            saldo = saldoController.findById(cod);

            if (saldo == null) {
                info("Comprobante ingresado no es valido, Obligatrio");
                errorValidacion = true;
            }
        }

        //Monto Pago
        if (this.uiTxtMontoCobro.getText() == null || this.uiTxtMontoCobro.getText().equals("")) {
            info("Monto Pago  obligatorio, ingrese un valor");
            errorValidacion = true;
        } else {
            //Verificamos si la precio es un numero
            String cantidad = this.uiTxtMontoCobro.getText().toString();

            if (!StringUtils.esNumero(cantidad)) {
                info("Monto Pago, debe se Numero");
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

        VClientesSaldos s = mapReciboDetTOVClienteSaldo(detalle);

        //Obtenemos los valores del detalle q ha sido seleccionado
        uiTxtDescComprobante.setText(s.getDescTipoComprobante());
        uiTxtNroComprobante.setText(s.getNroComprobante());
        uiTxtCodComprobante.setText(s.getCodComprobante());
        uiTxtFecVencimiento.setText(s.getFecVencimiento());
        uiTxtNroCuota.setText(s.getNroCuota());
        uiTxtMontoCuota.setText(s.getTotalComprobante());
        uiTxtSaldoCuota.setText(s.getSaldoComprobante());
        uiTxtMontoCobro.setText(detalle.getMontoPago());

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
        lstDetalle = (ReciboDetalle[]) lstDetalleLIST.toArray(new ReciboDetalle[0]);

        //Calculamos los totales
        calcularTotales();

        //Ceramos el item seleccionado
        itemDet = null;

        actualizarListaComprobantes();

        //result
        return null;
    }

    /**
     * Recorremos la lista de detalle y actualizamos los totales
     */
    private void calcularTotales() {
        //Variables
        long total;

        //Inicializamos
        total = 0;

        //Recorremos el detalle para recalcular los totales
        for (int i = 0; i < lstDetalleLIST.size(); i++) {
            //Obetenemos el detalle
            ReciboDetalle det = lstDetalleLIST.get(i);

            //Sumamos el monto total
            total += det.getMontoPago().longValue();

        }

        //Aplicamos el descuento

        uiTxtTotal1.setText(String.valueOf(total));
        uiTxtTotalComprobantes.setText(String.valueOf(total));
    }

    /**
     * Recorremos la lista de detalle y actualizamos los totales
     */
    private void calcularTotalesFC() {
        //Variables
        long total;

        //Inicializamos
        total = 0;

        //Recorremos el detalle para recalcular los totales
        for (int i = 0; i < lstDetalleLISTFC.size(); i++) {
            //Obetenemos el detalle
            MovimientoCajaDetalle det = lstDetalleLISTFC.get(i);

            //Sumamos el monto total
            total += det.getMonto().longValue();

        }

        //Aplicamos el descuent
        uiTxtTotalComprobantesFC.setText(String.valueOf(total));
    }

    /**
     * Limpiamos los campos del detalle
     */
    private void limpiarCamposDetalle() {
        //Limpiamos los campos
        uiTxtDescComprobante.setText(null);
        uiTxtCodComprobante.setText(null);
        uiTxtNroComprobante.setText(null);
        uiTxtNroCuota.setText(null);
        uiTxtFecVencimiento.setText(null);
        uiTxtNroCuota.setText(null);
        uiTxtSaldoCuota.setText(null);
        uiTxtMontoCuota.setText(null);
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
        //Cargamos la lista de Clientees
        getSessionBean1().cargarListaCliente();

    }
    private Long codClienteSeleccionado;

    public Long getCodClienteSeleccionado() {
        return codClienteSeleccionado;
    }

    public void setCodClienteSeleccionado(Long codClienteSeleccionado) {
        this.codClienteSeleccionado = codClienteSeleccionado;
    }

    public VClientesSaldos[] getLstSaldos() {
        return lstSaldos;
    }

    public void setLstSaldos(VClientesSaldos[] lstSaldos) {
        this.lstSaldos = lstSaldos;
    }

    public List<VClientesSaldos> getLstSaldosList() {
        return lstSaldosList;
    }

    public void setLstSaldosList(List<VClientesSaldos> lstSaldosList) {
        this.lstSaldosList = lstSaldosList;
        lstSaldos = (VClientesSaldos[]) lstSaldosList.toArray(new VClientesSaldos[0]);
    }

    public String hyperlink2_action() {


        return null;

    }

    public void uiTxtCodCliente_processValueChange(ValueChangeEvent event) {

        if (uiTxtCodCliente.getText() != null) {
            actualizarListaComprobantes();
        }

    }

    public String getNotINComprobantes() {
        //Variables
        String s;
        StringBuilder sb = new StringBuilder("");
        if (lstDetalle != null) {

            for (int i = 0; i < lstDetalle.length; i++) {
                ReciboDetalle d = lstDetalle[i];
                if (i == (lstDetalle.length - 1)) {
                    sb.append(d.getCodSaldoCliente().toString());
                } else {
                    sb.append(d.getCodSaldoCliente().toString() + ", ");
                }
            }
        }

        //Result
        if (lstDetalle == null || lstDetalle.length == 0) {
            s = null;
        } else {
            s = "( " + sb.toString() + " )";
        }

        //result
        return s;

    }

    public MovimientoCajaDetalle[] getLstDetalleFC() {
        return lstDetalleFC;
    }

    public void setLstDetalleFC(MovimientoCajaDetalle[] lstDetalleFC) {
        this.lstDetalleFC = lstDetalleFC;
    }

    public List<MovimientoCajaDetalle> getLstDetalleLISTFC() {
        return lstDetalleLISTFC;
    }

    public void setLstDetalleLISTFC(List<MovimientoCajaDetalle> lstDetalleLISTFC) {
        this.lstDetalleLISTFC = lstDetalleLISTFC;
    }

    public String uilnkEditardetalleFC_action() {
        //Obtenemos el detalle seleccionado
        this.detalleFC = lstDetalleLISTFC.get(Integer.valueOf(itemDet).intValue());

        //Obtenemos los valores del detalle q ha sido seleccionado
        uiTxtCodFormaCobro.setText(this.detalleFC.getCodFormaPago().getCodFormaPago());
        uiTxtDescFormaCobro.setText(this.detalleFC.getCodFormaPago().getNombreFormaPago());

        if (this.detalleFC.getCodFormaPago().getCodBanco() != null) {
            uiTxtBanco.setText(this.detalleFC.getCodFormaPago().getCodBanco().getNombreBanco());
        }
        
        uiTxtSerieFormaCobro.setText(this.detalleFC.getSerieCheque());
        uiTxtNroFormaCobro.setText(this.detalleFC.getNumeroCheque());
        uiTxtMontoCobro.setText(this.detalleFC.getMonto());

        //result
        return null;
    }

    public String uilnkEliminardetalleFC_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String uiBtnAgregarDetFC_action() {
        //Validamos el detalle
        validardetalleFC();

        //Sino hubo error de validacion
        if (!errorValidacion) {

            /* Si itemDet es null, en ese caso es un nuevo detalle */

            //Controlamos si es Nuevo Detalle
            if (itemDet == null) {
                detalleFC = new MovimientoCajaDetalle();
            }

            //Obtenemos los datos ingresados
            detalleFC.setCodFormaPago(formaPago);
            detalleFC.setCodRecibo(cabecera);
            detalleFC.setFechaAlta(new Date());
            detalleFC.setMonto(BigInteger.valueOf(Long.valueOf(uiTxtMontoFormaCobro.getText().toString())));
            
            if (uiTxtBanco.getText()!= null) {
                detalleFC.setNumeroCheque(uiTxtNroFormaCobro.getText().toString());
                detalleFC.setSerieCheque(uiTxtSerieFormaCobro.getText().toString());    
            }


            detalleFC.setUsuarioAlta(getSessionBean1().getUsuarioLogueado().getUsuario());


            //Agregamos a la lista
            if (itemDet == null) {
                lstDetalleLISTFC.add(detalleFC);
            }

            //Actualizamos la grilla
            lstDetalleFC = (MovimientoCajaDetalle[]) lstDetalleLISTFC.toArray(new MovimientoCajaDetalle[0]);

            //Ceramos el item seleccionado
            itemDet = null;

            //Ceramos los campos del detalle
            limpiarCamposDetalleFC();

            //Calculamos los totales
            calcularTotalesFC();

        }

        //result
        return null;
    }


    private void limpiarCamposDetalleFC(){
        uiTxtCodFormaCobro.setText(null);
        uiTxtDescFormaCobro.setText(null);
        uiTxtBanco.setText(null);
        uiTxtSerieFormaCobro.setText(null);
        uiTxtNroFormaCobro.setText(null);
        uiTxtMontoFormaCobro.setText(null);
    }

    public String uiBtnCancelardetalleFC_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    private void validardetalleFC() {
        //Apagamos la bandera de error
        this.errorValidacion = false;

        //Comprobante
        if (this.uiTxtCodFormaCobro.getText() == null || this.uiTxtCodFormaCobro.getText().equals("")) {
            info("Seleccione una Forma de cobro, Obligatrio");
            errorValidacion = true;
        } else {
            String c = this.uiTxtCodFormaCobro.getText().toString();
            Long cod = Long.valueOf(c);
            formaPago = formaPagoController.findById(cod);

            if (formaPago == null) {
                info("Forma de pago ingresado no es valido, Obligatrio");
                errorValidacion = true;
            }else if (formaPago.getCodBanco() != null) {

                if (uiTxtSerieFormaCobro.getText() == null || uiTxtSerieFormaCobro.getText().equals("")) {
                    info("Forma de pago tiene un Banco Relacionado, debe ingreser Serie del cheque");
                    errorValidacion = true;
                }

                if (uiTxtNroFormaCobro.getText() == null || uiTxtNroFormaCobro.getText().equals("")) {
                    info("Forma de pago tiene un Banco Relacionado, debe ingreser Numero del cheque");
                    errorValidacion = true;
                }
            }
        }

        //Monto Pago
        if (this.uiTxtMontoFormaCobro.getText() == null || this.uiTxtMontoFormaCobro.getText().equals("")) {
            info("Monto Forma Cobro  obligatorio, ingrese un valor");
            errorValidacion = true;
        } else {
            //Verificamos si la precio es un numero
            String cantidad = this.uiTxtMontoFormaCobro.getText().toString();

            if (!StringUtils.esNumero(cantidad)) {
                info("Monto Forma Cobro, debe se Numero");
                errorValidacion = true;
            }
        }
    }

    public String uiBtnCancelarDetalleFC_action() {
        //Limpiar campos
        limpiarCamposDetalle();

        //Result
        return null;
    }

    public String uilnkEditarDetalleFC_action() {
        //Obtenemos el detalle seleccionado
        this.detalleFC = lstDetalleLISTFC.get(Integer.valueOf(itemDet).intValue());
        
        //Obtenemos los valores del detalle q ha sido seleccionado
        uiTxtCodFormaCobro.setText(detalleFC.getCodFormaPago().getCodFormaPago());
        uiTxtDescFormaCobro.setText(detalleFC.getCodFormaPago().getNombreFormaPago());
        uiTxtBanco.setText(detalleFC.getCodFormaPago().getCodBanco().getNombreBanco());
        uiTxtSerieFormaCobro.setText(detalleFC.getSerieCheque());
        uiTxtNroFormaCobro.setText(detalleFC.getNumeroCheque());
        uiTxtMontoFormaCobro.setText(detalleFC.getMonto());

        //result
        return null;
    }

    public String uilnkEliminarDetalleFC_action() {
        //Obtenemos el detalle seleccionado
        detalleFC = lstDetalleLISTFC.get(Integer.valueOf(itemDet).intValue());

        //Argegamos el detalle, a la lista de detalle para eliminar
        if (updateRequest) {
            lstDetalleEliminarFC.add(detalleFC);
        }

        //Eliminamos de la lista temporal el detalle
        lstDetalleLISTFC.remove(Integer.valueOf(itemDet).intValue());

        //Actualizamos la grilla
        lstDetalleFC = (MovimientoCajaDetalle[]) lstDetalleLISTFC.toArray(new MovimientoCajaDetalle[0]);

        //Calculamos los totales
        calcularTotalesFC();

        //Ceramos el item seleccionado
        itemDet = null;

        //result
        return null;
    }
}
