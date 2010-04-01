/*
 * To change this template, choose Tools | Templates
 * and open the template in the editodescripcionr.
 */
package platinum;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.MarcaController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.TipoProductoController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Presentacion;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.TipoProducto;
import py.com.platinum.entity.UnidadMedida;
import py.com.platinum.utils.StringUtils;






/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ABMCliente.java
 * @version Created on Oct 18, 2009, 8:11:57 PM
 * @author FerBoy
 */
public class ABMProductos extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        
    }
    private HtmlPanelGrid gridPanelBuscar = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBuscar() {
        return gridPanelBuscar;
    }

    public void setGridPanelBuscar(HtmlPanelGrid hpg) {
        this.gridPanelBuscar = hpg;
    }
    private HtmlPanelGrid gridPanelTabla = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelTabla() {
        return gridPanelTabla;
    }

    public void setGridPanelTabla(HtmlPanelGrid hpg) {
        this.gridPanelTabla = hpg;
    }
    private HtmlPanelGrid gridPanelBotones = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBotones() {
        return gridPanelBotones;
    }

    public void setGridPanelBotones(HtmlPanelGrid hpg) {
        this.gridPanelBotones = hpg;
    }
    private StaticText datosProducto = new StaticText();

    public StaticText getDatosProducto() {
        return datosProducto;
    }

    public void setDatosProducto(StaticText st) {
        this.datosProducto = st;
    }
    private HtmlPanelGrid gridPanelAddUpdate = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelAddUpdate() {
        return gridPanelAddUpdate;
    }

    public void setGridPanelAddUpdate(HtmlPanelGrid hpg) {
        this.gridPanelAddUpdate = hpg;
    }
    private HtmlPanelGrid buttonsPanelAddUpdate = new HtmlPanelGrid();

    public HtmlPanelGrid getButtonsPanelAddUpdate() {
        return buttonsPanelAddUpdate;
    }

    public void setButtonsPanelAddUpdate(HtmlPanelGrid hpg) {
        this.buttonsPanelAddUpdate = hpg;
    }
    private Button buttonGuardarEdicion = new Button();

    public Button getButtonGuardarEdicion() {
        return buttonGuardarEdicion;
    }

    public void setButtonGuardarEdicion(Button b) {
        this.buttonGuardarEdicion = b;
    }
    private Button buttonGuardarNuevo = new Button();

    public Button getButtonGuardarNuevo() {
        return buttonGuardarNuevo;
    }

    public void setButtonGuardarNuevo(Button b) {
        this.buttonGuardarNuevo = b;
    }
    private TextField uiCodInterno = new TextField();

    public TextField getUiCodInterno() {
        return uiCodInterno;
    }

    public void setUiCodInterno(TextField tf) {
        this.uiCodInterno = tf;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private SingleSelectOptionsList tipoProducto1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getTipoProducto1DefaultOptions() {
        return tipoProducto1DefaultOptions;
    }

    public void setTipoProducto1DefaultOptions(SingleSelectOptionsList ssol) {
        this.tipoProducto1DefaultOptions = ssol;
    }
    private SingleSelectOptionsList tipo2DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getTipo2DefaultOptions() {
        return tipo2DefaultOptions;
    }

    public void setTipo2DefaultOptions(SingleSelectOptionsList ssol) {
        this.tipo2DefaultOptions = ssol;
    }
    private TextArea uiDescripcionFil = new TextArea();

    public TextArea getUiDescripcionFil() {
        return uiDescripcionFil;
    }

    public void setUiDescripcionFil(TextArea ta) {
        this.uiDescripcionFil = ta;
    }
    private SingleSelectOptionsList uiTipoProductoFilDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiTipoProductoFilDefaultOptions() {
        return uiTipoProductoFilDefaultOptions;
    }

    public void setUiTipoProductoFilDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiTipoProductoFilDefaultOptions = ssol;
    }
    private DropDown uiTipoProductoFil = new DropDown();

    public DropDown getUiTipoProductoFil() {
        return uiTipoProductoFil;
    }

    public void setUiTipoProductoFil(DropDown dd) {
        this.uiTipoProductoFil = dd;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TableColumn tableColumn6 = new TableColumn();

    public TableColumn getTableColumn6() {
        return tableColumn6;
    }

    public void setTableColumn6(TableColumn tc) {
        this.tableColumn6 = tc;
    }
    private TableRowGroup proveedores = new TableRowGroup();

    public TableRowGroup getProveedores() {
        return proveedores;
    }

    public void setProveedores(TableRowGroup trg) {
        this.proveedores = trg;
    }
    private SingleSelectOptionsList uiMarcaDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiMarcaDefaultOptions() {
        return uiMarcaDefaultOptions;
    }

    public void setUiMarcaDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiMarcaDefaultOptions = ssol;
    }
    private TextField uiPrecioActual = new TextField();

    public TextField getUiPrecioActual() {
        return uiPrecioActual;
    }

    public void setUiPrecioActual(TextField tf) {
        this.uiPrecioActual = tf;
    }
    private TextField uiCostoActual = new TextField();

    public TextField getUiCostoActual() {
        return uiCostoActual;
    }

    public void setUiCostoActual(TextField tf) {
        this.uiCostoActual = tf;
    }
    private Checkbox uiControlExistencia = new Checkbox();

    public Checkbox getUiControlExistencia() {
        return uiControlExistencia;
    }

    public void setUiControlExistencia(Checkbox c) {
        this.uiControlExistencia = c;
    }
    private DropDown uiLstMarca = new DropDown();

    public DropDown getUiLstMarca() {
        return uiLstMarca;
    }

    public void setUiLstMarca(DropDown dd) {
        this.uiLstMarca = dd;
    }
    private DropDown uiLstTipoProducto = new DropDown();

    public DropDown getUiLstTipoProducto() {
        return uiLstTipoProducto;
    }

    public void setUiLstTipoProducto(DropDown dd) {
        this.uiLstTipoProducto = dd;
    }
    private TextArea uiDescripcion = new TextArea();

    public TextArea getUiDescripcion() {
        return uiDescripcion;
    }

    public void setUiDescripcion(TextArea ta) {
        this.uiDescripcion = ta;
    }
    private DropDown uiUnidadMedida = new DropDown();

    public DropDown getUiUnidadMedida() {
        return uiUnidadMedida;
    }

    public void setUiUnidadMedida(DropDown dd) {
        this.uiUnidadMedida = dd;
    }
    private DropDown uiPresentacion = new DropDown();

    public DropDown getUiPresentacion() {
        return uiPresentacion;
    }

    public void setUiPresentacion(DropDown dd) {
        this.uiPresentacion = dd;
    }
    private Calendar uiFechaAlta = new Calendar();

    public Calendar getUiFechaAlta() {
        return uiFechaAlta;
    }

    public void setUiFechaAlta(Calendar c) {
        this.uiFechaAlta = c;
    }
    private DropDown uiMarcaFil = new DropDown();

    public DropDown getUiMarcaFil() {
        return uiMarcaFil;
    }

    public void setUiMarcaFil(DropDown dd) {
        this.uiMarcaFil = dd;
    }
    private DropDown uiPresentacionFil = new DropDown();

    public DropDown getUiPresentacionFil() {
        return uiPresentacionFil;
    }

    public void setUiPresentacionFil(DropDown dd) {
        this.uiPresentacionFil = dd;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMProductos() {
        tipoProducto1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("t", "Terminado"), new com.sun.webui.jsf.model.Option("s", "SemiTerminado"), new com.sun.webui.jsf.model.Option("i", "Insumo"), new com.sun.webui.jsf.model.Option("g", "ProductoGenerico"),new com.sun.webui.jsf.model.Option("m", "Materias Primas")});
        tipo2DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("t", "Terminado"), new com.sun.webui.jsf.model.Option("s", "SemiTerminado"), new com.sun.webui.jsf.model.Option("m", "MateriaPrima"), new com.sun.webui.jsf.model.Option("g", "ProductoGenerico"), new com.sun.webui.jsf.model.Option("I", "Insumo")});
        uiTipoProductoFilDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("Terminado", "Terminado"), new com.sun.webui.jsf.model.Option("SemiTerminado", "SemiTerminado"), new com.sun.webui.jsf.model.Option("Insumo", "Insumo"), new com.sun.webui.jsf.model.Option("MateriaPrima", "MateriaPrima"), new com.sun.webui.jsf.model.Option("Todos", "Todos")});
        uiTipoProductoFilDefaultOptions.setSelectedValue("Todos");
        uiMarcaFil.setSelected("99999");
        uiPresentacionFil.setSelected("99999");

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
            log("ABMCliente Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here

    getSessionBean1().setTituloPagina("Registro de Productos");
    getSessionBean1().setDetallePagina("Seleccione el Registro");


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
    private boolean addRequest = false;
    private boolean updateRequest = false;
    private boolean errorValidacion = false;

    @Override
    public void prerender() {

        if (addRequest) {
                getSessionBean1().setTituloPagina("Productos");
                getSessionBean1().setDetallePagina("Insertar nuevo Registro");


            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosProducto.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosProducto.setRendered(true);
            this.uiCodInterno.setReadOnly(false);
            limpiarCamposNew();
            



        } else if (updateRequest) {

            getSessionBean1().setTituloPagina("Productos");
            getSessionBean1().setDetallePagina("Edicion de Registro");


            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosProducto.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosProducto.setRendered(true);
            this.uiCodInterno.setReadOnly(true);
            cargarCamposUpdate();

        } else if (errorValidacion) {
            
            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosProducto.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosProducto.setRendered(true);

        } else {

                getSessionBean1().setTituloPagina("Registro de Productos");
                getSessionBean1().setDetallePagina("Seleccione el Registro");

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosProducto.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosProducto.setRendered(false);

        }


        buscar_action2();
        
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

   
    public void limpiarCamposNew(){

            this.uiCodInterno.setText("");
            this.uiDescripcion.setText("");
            this.uiCostoActual.setText("");
            this.uiPrecioActual.setText("");
            this.uiFechaAlta.setSelectedDate(new Date());
                   
    }

    public void cargarCamposUpdate(){
         if (getProveedores().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getProveedores().getSelectedRowKeys();
          Producto[] productos = getSessionBean1().getListaProductos();
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          Producto producto = productos[rowId];

          getSessionBean1().setId(producto.getCodProducto());
         //// CARGA DE CAMPOS DE LA PAGINA
         this.uiCodInterno.setText(producto.getCodigoInterno());
         this.uiLstTipoProducto.setSelected(producto.getCodTipoProducto().getCodTipoProducto().toString());
         this.uiDescripcion.setText(producto.getDescripcion());
         this.uiUnidadMedida.setSelected(producto.getCodUnidadMedida().getCodUnidadMedida().toString());
         this.uiPresentacion.setSelected(producto.getCodPresentacion().getCodPresentacion().toString());
         this.uiLstMarca.setSelected(producto.getCodMarca().getCodMarca().toString());
         this.uiCostoActual.setText(producto.getCostoActual().toString());
         this.uiPrecioActual.setText(producto.getPrecioActual().toString());
         this.uiFechaAlta.setSelectedDate(producto.getFechaAlta());
         }
         
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public String nuevo_action() {
        // TODO: Process the action. Return value is a navigation

        // case name where null will return to the same page.
        this.pageAlert1.setRendered(false);
        this.addRequest=true;
        this.buttonGuardarNuevo.setRendered(true);
        this.buttonGuardarEdicion.setRendered(false);

        return null;
    }

    public String buttonEditar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.pageAlert1.setRendered(false);
        this.updateRequest=true;
        this.buttonGuardarEdicion.setRendered(true);
        this.buttonGuardarNuevo.setRendered(false);

        return null;

    }

   

    public String cancelar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequest=false;
        this.updateRequest=false;

        return null;
    }


     public String eliminar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        if (getProveedores().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getProveedores().getSelectedRowKeys();
          Producto[] productos = getSessionBean1().getListaProductos();
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          Producto producto = productos[rowId];
          // Remove the Entity from the database using UserController
          ProductoController productoController = new ProductoController();
          ControllerResult controllerResult = productoController.delete(producto);

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



    public String buttonGuardarNuevo_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarCampos();
        if (! errorValidacion){
                            Producto producto = new Producto();

                            MarcaController marcaController = new MarcaController();
                            producto.setCodMarca(marcaController.findById(Long.valueOf(this.uiLstMarca.getSelected().toString())));

                            producto.setDescripcion(this.uiDescripcion.getText().toString());

                            UnidadMedida uni = new UnidadMedida();
                            uni.setCodUnidadMedida(Long.valueOf(this.uiUnidadMedida.getSelected().toString()));
                            producto.setCodUnidadMedida(uni);

                            TipoProductoController tipoProductoController = new TipoProductoController();
                            producto.setCodTipoProducto(tipoProductoController.findById(Long.valueOf(this.uiLstTipoProducto.getSelected().toString())));


                            Presentacion pres = new Presentacion();
                            pres.setCodPresentacion(Long.valueOf(this.uiPresentacion.getSelected().toString()));
                            producto.setCodPresentacion(pres);

                            producto.setEstado("A");
                            producto.setPrecioActual(new BigInteger( this.uiPrecioActual.getText().toString()));
                            producto.setCostoActual(new BigInteger( this.uiCostoActual.getText().toString()));


                            if (this.uiControlExistencia.isChecked()) {
                                producto.setControlaExistencia("S");
                            } else {
                                producto.setControlaExistencia("N");
                            }
                            producto.setCodigoInterno(this.uiCodInterno.getText().toString());

                            producto.setFechaAlta(this.uiFechaAlta.getSelectedDate());

                    //       info(this.uiCodInterno, "Favor ingresar Nombre, Campo Obligatorio");


                            // Create a new User Entity

                            // Add the new Entity to the database using UserController
                            ProductoController productoController = new ProductoController();

                            ControllerResult controllerResult = new ControllerResult();
                            controllerResult = productoController.create(producto);


                             if (controllerResult.getCodRetorno() ==-1) {
                                    this.pageAlert1.setType("error");
                                    this.errorValidacion=true;
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


    public String todos_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.pageAlert1.setRendered(false);
        getSessionBean1().cargarListaTodosProductos();
        this.uiDescripcionFil.setText("");
        this.uiMarcaFil.setSelected("99999");
        this.uiPresentacionFil.setSelected("99999");
        this.uiTipoProductoFil.setSelected("");

        return null;
    }

    public String buscar_action() {
        this.pageAlert1.setRendered(false);
        return buscar_action2();
    }

    public String buscar_action2() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        Producto[] listaProductos;
        ProductoController productoController = new ProductoController();

        String pMarca=null, pDesc=null, pPres=null, pTipo=null;

        if (this.uiMarcaFil.getSelected()!=null) {
            pMarca = this.uiMarcaFil.getSelected().toString();
        }

        if (this.uiDescripcionFil.getText()!=null) {
            pDesc = this.uiDescripcionFil.getText().toString();
        }

        if (this.uiPresentacionFil.getSelected()!=null) {
            pPres = this.uiPresentacionFil.getSelected().toString();
        }

        if (this.uiTipoProductoFil.getSelected()!=null) {
            pTipo = this.uiTipoProductoFil.getSelected().toString();
        }

        listaProductos = (Producto[])  productoController.getAllFiltered(pMarca,
                                          pDesc,
                                          pTipo,
                                          pPres).toArray(new Producto[0]);

        getSessionBean1().setListaProductos(listaProductos);
                 
        return null;
    }


///// CODIGO PARA RADIO BUTTON DE LA GRILLA DE BUSQUEDA
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

   ///// FIN CODIGO PARA RADIO BUTTON DE LA GRILLA DE BUSQUEDA

 public void validarCampos() {
    errorValidacion = false;


    if (updateRequest == false){

                    if (this.uiCodInterno.getText() == null ||
                        this.uiCodInterno.getText().toString() == null ||
                        this.uiCodInterno.getText().toString().equals("")){
                            errorValidacion = true;
                           this.info(uiCodInterno, "El codigo interno no puede ser nulo");
                    }else if (new ProductoController().existe(this.uiCodInterno.getText().toString()))  {
                         errorValidacion = true;
                          this.info(uiCodInterno, "El codigo interno ya Existe");
                    }
    }
//      if (this.uiFechaAlta.getSelectedDate() == null ||
//        this.uiFechaAlta.getSelectedDate().before(new Date())){
//            errorValidacion = true;}


    if (this.uiDescripcion.getText() == null ||
        this.uiDescripcion.getText().toString() == null ||
        this.uiDescripcion.getText().toString().equals("")){
            errorValidacion = true;
           this.info(uiDescripcion, "La Descripcion no puede ser nula");
    }

     if (!StringUtils.esNumero(this.uiCostoActual.getText().toString()))
     {
        errorValidacion = true;
        this.info(uiCostoActual, "El costo debe ser numerico");}

     if (!StringUtils.esNumero(this.uiPrecioActual.getText().toString()))
     {
        errorValidacion = true;
        this.info(uiPrecioActual, "El precio debe ser numerico");}
 

 }

    public String buttonGuardarEdicion_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        updateRequest = true;
        validarCampos();
        if (! errorValidacion){
          
          
          Producto producto = new ProductoController().findById(getSessionBean1().getId());

                            MarcaController marcaController = new MarcaController();
                            producto.setCodMarca(marcaController.findById(Long.valueOf(this.uiLstMarca.getSelected().toString())));

                            producto.setDescripcion(this.uiDescripcion.getText().toString());

                            UnidadMedida uni = new UnidadMedida();
                            uni.setCodUnidadMedida(Long.valueOf(this.uiUnidadMedida.getSelected().toString()));
                            producto.setCodUnidadMedida(uni);

                            TipoProductoController tipoProductoController = new TipoProductoController();
                            producto.setCodTipoProducto(tipoProductoController.findById(Long.valueOf(this.uiLstTipoProducto.getSelected().toString())));


                            Presentacion pres = new Presentacion();
                            pres.setCodPresentacion(Long.valueOf(this.uiPresentacion.getSelected().toString()));
                            producto.setCodPresentacion(pres);

                            producto.setEstado("A");
                            producto.setPrecioActual(new BigInteger( this.uiPrecioActual.getText().toString()));
                            producto.setCostoActual(new BigInteger( this.uiCostoActual.getText().toString()));


                            if (this.uiControlExistencia.isChecked()) {
                                producto.setControlaExistencia("S");
                            } else {
                                producto.setControlaExistencia("N");
                            }
                            producto.setCodigoInterno(this.uiCodInterno.getText().toString());

                    //       info(this.uiCodInterno, "Favor ingresar Nombre, Campo Obligatorio");


                            // Create a new User Entity

                            // Add the new Entity to the database using UserController
                            ProductoController productoController = new ProductoController();

                            ControllerResult controllerResult = new ControllerResult();
                            controllerResult = productoController.update(producto);


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

    public void uiLstTipoProducto_processValueChange(ValueChangeEvent event) {


    }

    public void uiLstTipoProducto_validate(FacesContext context, UIComponent component, Object value) {
            TipoProducto tipoProducto = new TipoProducto();
            tipoProducto = new TipoProductoController().findById(Long.valueOf(value.toString()));
            if (tipoProducto.getDescripcion() != null && tipoProducto.getDescripcion().toString().equals("ProductoGenerico")) {
                    this.uiLstMarca.setDisabled(true);
                    this.uiLstMarca.setSelected("1");

                    this.uiCostoActual.setDisabled(true);
                    this.uiCostoActual.setText("0");

                    this.uiPrecioActual.setDisabled(true);
                    this.uiPrecioActual.setText("0");

                    this.uiControlExistencia.setSelected(false);
                    this.uiControlExistencia.setDisabled(true);

                
        } else {

                if (tipoProducto.getDescripcion() != null && (tipoProducto.getDescripcion().toString().equals("Terminado")|| tipoProducto.getDescripcion().toString().equals("SemiTerminado"))) {

                    this.uiControlExistencia.setSelected(true);
                    this.uiControlExistencia.setDisabled(true);
                }else{
                        this.uiControlExistencia.setDisabled(false);

                }

                this.uiLstMarca.setDisabled(false);
                this.uiCostoActual.setDisabled(false);
                this.uiPrecioActual.setDisabled(false);
                
        }


    }

   

   


}

