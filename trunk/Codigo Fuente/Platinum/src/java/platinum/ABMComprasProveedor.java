/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.ctc.wstx.util.StringUtil;
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
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.ValueChangeEvent;
import py.com.platinum.controller.FacturaCompraCabController;
import py.com.platinum.controller.FacturaCompraDetController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.FacturaCompraCab;
import py.com.platinum.entity.FacturaCompraDet;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.Proveedor;
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
public class ABMComprasProveedor extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        uiLstTipoComprobanteDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("CON", "Contado"), new com.sun.webui.jsf.model.Option("CRE15", "Crédito 15 Días"), new com.sun.webui.jsf.model.Option("CRE30", "Crédito 30 Días"), new com.sun.webui.jsf.model.Option("CRE60", "Crédito 60 Días"), new com.sun.webui.jsf.model.Option("CRE90", "Crédito 90 Días")});
        uiLstTipoComprobanteDefaultOptions.setSelectedValue("CRE30");
        uiLstEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("P", "Pendiente"), new com.sun.webui.jsf.model.Option("R", "Recibido"), new com.sun.webui.jsf.model.Option("A", "Anulado")});
        uiLstEstadoDefaultOptions.setSelectedValue("R");
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
    private SingleSelectOptionsList uiLstTipoComprobanteDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiLstTipoComprobanteDefaultOptions() {
        return uiLstTipoComprobanteDefaultOptions;
    }

    public void setUiLstTipoComprobanteDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiLstTipoComprobanteDefaultOptions = ssol;
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMComprasProveedor() {
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
            limpiarCampos();
        } else if (updateRequest) {
            if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                gridPanelBuscar.setRendered(false);
                table1.setRendered(false);
                buttonPanel.setRendered(false);
                addUpdatePanel.setRendered(true);
                uiBtnGuardarNuevo.setRendered(false);
                uiBtnGuardarEditar.setRendered(true);
                uiBtnCancelar.setRendered(true);
            }
        } else if(errorValidacion){
            addUpdatePanel.setRendered(true);
        }else {
            getSessionBean1().setTituloPagina("Facturas Compras");
            getSessionBean1().setDetallePagina("Registro de Facturas - Proveedor");
            gridPanelBuscar.setRendered(true);
            table1.setRendered(true);
            buttonPanel.setRendered(true);
            addUpdatePanel.setRendered(false);
        }

        //Actualizamos la lista
        buscar();
        
    }

    /**
     * Limpiar campos
     */
    private void limpiarCampos() {
        uiTxtCantidad.setText(null);
        uiTxtCodEmpleado.setText(null);
        uiTxtCodProducto.setText(null);
        uiTxtCodProveedor.setText(null);
        uiTxtDescProducto.setText(null);
        uiTxtNombreEmpleado.setText(null);
        uiTxtNombreProveedor.setText(null);
        uiTxtNroFac.setText(null);
        uiTxtPrecioUnitario.setText(null);
        uiTxtTotalIva.setText(null);
        uiTxtSubTotal.setText(null);
        uiTxtTotal.setText(null);
        uiCalFecha.setSelectedDate(null);
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

    public String addButton_action() {
        lstDetalleLIST = new ArrayList();
        addRequest = true;
        getSessionBean1().setTituloPagina("Nueva Factura Compra");
        getSessionBean1().setDetallePagina("Registro de Facturas - Proveedor");
        return null;
    }

    public String updateButton_action() {
        updateRequest = true;
        getSessionBean1().setTituloPagina("Editar Factura Compra");
        getSessionBean1().setDetallePagina("Registro de Facturas - Proveedor");
        return null;
    }

    public String deleteButton_action() {
        return null;
    }

    public String uiBtnGuardarNuevo_action() {

        // Apagamos la bandera de nuevo registro
        this.addRequest = false;

        //Validamos los campos
        validarCampos();
        FacturaCompraCab r;

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Nuevo
            r = new FacturaCompraCab();

            //Set de los artributos
            r.setCodProveedor(proveedor);
            r.setEstado(uiLstEstado.getSelected().toString());
            r.setFecha(uiCalFecha.getSelectedDate());
            r.setNroFactura(uiTxtNroFac.getText().toString());
            r.setSubTotal(1);
            r.setTipo(uiLstTipoComprobante.getSelected().toString());
            r.setTotaIva(1);
            r.setTotal(1);

            //Insertamos la cebecera
            ControllerResult cr = new FacturaCompraCabController().create(r);

            if (cr.getCodRetorno() != -1) {
                //Insertamos el detalle
                cr = insertarDetalle(r);
            }

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

    /**
     * Validar los campos de la entidad, para verificar si los datos ingresados
     * por el usuario es correcto y si estan todos los campos obligatorios.
     */
    private void validarCampos() {
        //Apagamos la bandera de error
        this.errorValidacion = false;

    }

    /**
     * Recorremos la lista de los detalles y vamos insertando
     * @param cab
     * @return ControllerResult
     */
    private ControllerResult insertarDetalle(FacturaCompraCab cab) {
        //Result
        ControllerResult r;
        FacturaCompraDetController c;

        //Inicializamos
        r = new ControllerResult();
        c = new FacturaCompraDetController();

        //Recorremos la lista de los detalles
        for (int i = 0; i < lstDetalleLIST.size(); i++) {
            //Obtenemos el detalle
            FacturaCompraDet d = lstDetalleLIST.get(i);

            //Asignamos la cabecera
            d.setCodFacComCab(cab);

            //Insertamos
            r = c.create(d);

            //Verificamos si no hubo error
            if (r.getCodRetorno() == -1) {
                break;
            }
        }

        //Result
        return r;
    }

    
    public String uiBtnGuardarEditar_action() {
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

    public String uiBtnCancelar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        addRequest = false;
        updateRequest = false;
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
    private Producto producto;
    private Proveedor proveedor;

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
        String pNroFactura = null, pProveedor = null;


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

        //Buscamos la lista de registros
        lstCabecera = (FacturaCompraCab[]) c.getFacturaCompraCab(pNroFactura, pProveedor, pFechaFactura).toArray(new FacturaCompraCab[0]);

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
        validarDetalle();

        if (!errorValidacion) {
            //Nuevo Detalle
            detalle = new FacturaCompraDet();
            detalle.setCodProducto(producto);
            detalle.setCantidad(Long.valueOf(uiTxtCantidad.getText().toString()));
            detalle.setPrecioUni(Long.valueOf("1"));
            detalle.setMontoIva(Long.valueOf("1"));
            detalle.setTotal(Long.valueOf("1"));

            //Agregamos a la lista
            lstDetalleLIST.add(detalle);

            //Actualizamos la grilla
            lstDetalle = (FacturaCompraDet[])lstDetalleLIST.toArray(new FacturaCompraDet[0]);
            
        }

        return null;
    }

    /**
     * Validar detalle antes de ingresar al detalle
     */
    private void validarDetalle() {
        //Apagamos la bandera de error
        this.errorValidacion = false;

        //Producto
        if (this.uiTxtCodProducto.getText() == null || this.uiTxtCodProducto.getText().equals("")) {
            info("Codigo Producto obligatorio, ingrese un valor");
            errorValidacion = true;
        }else{
            //Obtenemos el producto
            producto = new ProductoController().findById(Long.valueOf(uiTxtCodProducto.getText().toString()));
            if (producto == null) {
                info("Producto no existe, ingrese un codigo de producto correcto");
                errorValidacion = true;
            }
        }

        //Cantidad
        if (this.uiTxtCantidad.getText() == null || this.uiTxtCantidad.getText().equals("")) {
            info("Cantidad del Producto obligatorio, ingrese un valor");
            errorValidacion = true;
        }else{
            //Verificamos si la cantidad es un numero
            String cantidad = this.uiTxtCantidad.getText().toString();

            if (!StringUtils.esNumero(cantidad) || !StringUtils.esNumeroDecimal(cantidad)) {
                info("Cantidad del Producto,debe se Numero");
                errorValidacion = true;
            }
        }
    }


    private String itemDet;

    public String getItemDet() {
        return itemDet;
    }

    public void setItemDet(String itemDet) {
        this.itemDet = itemDet;
    }

    public String detail() {

        System.out.println("*******************************");
        System.out.println(itemDet);
        System.out.println("*******************************");


        lstDetalleLIST.remove(Integer.valueOf(itemDet).intValue());

        //Actualizamos la grilla
        lstDetalle = (FacturaCompraDet[])lstDetalleLIST.toArray(new FacturaCompraDet[0]);

        return null;
    }

}
