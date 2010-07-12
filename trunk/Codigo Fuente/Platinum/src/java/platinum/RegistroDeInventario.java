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
import com.sun.webui.jsf.component.StaticText;
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
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.DepositoController;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.ExistenciaController;
import py.com.platinum.controller.InventarioCabeceraController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Deposito;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.InventarioCabecera;
import py.com.platinum.entity.InventarioDetalle;
import py.com.platinum.entity.Producto;
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
public class RegistroDeInventario extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        tipoDoc1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "Cedula de Identidad"), new com.sun.webui.jsf.model.Option("2", "DNI"), new com.sun.webui.jsf.model.Option("3", "Pasaporte")});
        radioButtonGroup1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("e", "Entrada"), new com.sun.webui.jsf.model.Option("s", "Salida")});
        referencia1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("1", "Orden de Trabajo"), new com.sun.webui.jsf.model.Option("2", "Venta"), new com.sun.webui.jsf.model.Option("3", "Trabajo Diario")});

   }
    private HtmlPanelGrid gridPanelCabecera = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelCabecera() {
        return gridPanelCabecera;
    }

    public void setGridPanelCabecera(HtmlPanelGrid hpg) {
        this.gridPanelCabecera = hpg;
    }
    private HtmlPanelGrid gridPanelTabla = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelTabla() {
        return gridPanelTabla;
    }

    public void setGridPanelTabla(HtmlPanelGrid hpg) {
        this.gridPanelTabla = hpg;
    }
    private StaticText detalleInventario = new StaticText();

    public StaticText getDetalleInventario() {
        return detalleInventario;
    }

    public void setDetalleInventario(StaticText st) {
        this.detalleInventario = st;
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
    private Button uiGuardarNuevo = new Button();

    public Button getUiGuardarNuevo() {
        return uiGuardarNuevo;
    }

    public void setUiGuardarNuevo(Button b) {
        this.uiGuardarNuevo = b;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private SingleSelectOptionsList tipoDoc1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getTipoDoc1DefaultOptions() {
        return tipoDoc1DefaultOptions;
    }

    public void setTipoDoc1DefaultOptions(SingleSelectOptionsList ssol) {
        this.tipoDoc1DefaultOptions = ssol;
    }
    private SingleSelectOptionsList radioButtonGroup1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getRadioButtonGroup1DefaultOptions() {
        return radioButtonGroup1DefaultOptions;
    }

    public void setRadioButtonGroup1DefaultOptions(SingleSelectOptionsList ssol) {
        this.radioButtonGroup1DefaultOptions = ssol;
    }
    private SingleSelectOptionsList referencia1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getReferencia1DefaultOptions() {
        return referencia1DefaultOptions;
    }

    public void setReferencia1DefaultOptions(SingleSelectOptionsList ssol) {
        this.referencia1DefaultOptions = ssol;
    }
    private HtmlPanelGrid gridPanelbusqueda = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelbusqueda() {
        return gridPanelbusqueda;
    }

    public void setGridPanelbusqueda(HtmlPanelGrid hpg) {
        this.gridPanelbusqueda = hpg;
    }
    private HtmlPanelGrid gridPanelCabecera1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelCabecera1() {
        return gridPanelCabecera1;
    }

    public void setGridPanelCabecera1(HtmlPanelGrid hpg) {
        this.gridPanelCabecera1 = hpg;
    }
    private HtmlPanelGrid gridPanelDetalle = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDetalle() {
        return gridPanelDetalle;
    }

    public void setGridPanelDetalle(HtmlPanelGrid hpg) {
        this.gridPanelDetalle = hpg;
    }
    private DropDown uiDepositoFil = new DropDown();

    public DropDown getUiDepositoFil() {
        return uiDepositoFil;
    }

    public void setUiDepositoFil(DropDown dd) {
        this.uiDepositoFil = dd;
    }
    private Calendar uiFecha1Fil = new Calendar();

    public Calendar getUiFecha1Fil() {
        return uiFecha1Fil;
    }

    public void setUiFecha1Fil(Calendar c) {
        this.uiFecha1Fil = c;
    }
    private Calendar uiFecha2Fil = new Calendar();

    public Calendar getUiFecha2Fil() {
        return uiFecha2Fil;
    }

    public void setUiFecha2Fil(Calendar c) {
        this.uiFecha2Fil = c;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TableColumn tableColumn5 = new TableColumn();

    public TableColumn getTableColumn5() {
        return tableColumn5;
    }

    public void setTableColumn5(TableColumn tc) {
        this.tableColumn5 = tc;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private Table table1 = new Table();

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table t) {
        this.table1 = t;
    }
    private TextField uiNroInventario = new TextField();

    public TextField getUiNroInventario() {
        return uiNroInventario;
    }

    public void setUiNroInventario(TextField tf) {
        this.uiNroInventario = tf;
    }
    private Calendar uiFechaInv = new Calendar();

    public Calendar getUiFechaInv() {
        return uiFechaInv;
    }

    public void setUiFechaInv(Calendar c) {
        this.uiFechaInv = c;
    }
    private DropDown uiDeposito = new DropDown();

    public DropDown getUiDeposito() {
        return uiDeposito;
    }

    public void setUiDeposito(DropDown dd) {
        this.uiDeposito = dd;
    }
    private TextField uiEmpleadoCod = new TextField();

    public TextField getUiEmpleadoCod() {
        return uiEmpleadoCod;
    }

    public void setUiEmpleadoCod(TextField tf) {
        this.uiEmpleadoCod = tf;
    }
    private TextArea uiObservacion = new TextArea();

    public TextArea getUiObservacion() {
        return uiObservacion;
    }

    public void setUiObservacion(TextArea ta) {
        this.uiObservacion = ta;
    }
    private HtmlPanelGrid deposito = new HtmlPanelGrid();

    public HtmlPanelGrid getDeposito() {
        return deposito;
    }

    public void setDeposito(HtmlPanelGrid hpg) {
        this.deposito = hpg;
    }
    private Table tableDetalleInventarios = new Table();

    public Table getTableDetalleInventarios() {
        return tableDetalleInventarios;
    }

    public void setTableDetalleInventarios(Table t) {
        this.tableDetalleInventarios = t;
    }
    private TextField uiProductoDet = new TextField();

    public TextField getUiProductoDet() {
        return uiProductoDet;
    }

    public void setUiProductoDet(TextField tf) {
        this.uiProductoDet = tf;
    }
    private TextField uiCantSistema = new TextField();

    public TextField getUiCantSistema() {
        return uiCantSistema;
    }

    public void setUiCantSistema(TextField tf) {
        this.uiCantSistema = tf;
    }
    private TextField uiCantContada = new TextField();

    public TextField getUiCantContada() {
        return uiCantContada;
    }

    public void setUiCantContada(TextField tf) {
        this.uiCantContada = tf;
    }
    private TextArea uiObservacionDet = new TextArea();

    public TextArea getUiObservacionDet() {
        return uiObservacionDet;
    }

    public void setUiObservacionDet(TextArea ta) {
        this.uiObservacionDet = ta;
    }
    private Button uiButtonCerrar = new Button();

    public Button getUiButtonCerrar() {
        return uiButtonCerrar;
    }

    public void setUiButtonCerrar(Button b) {
        this.uiButtonCerrar = b;
    }
    private Button uiButtonIniciar = new Button();

    public Button getUiButtonIniciar() {
        return uiButtonIniciar;
    }

    public void setUiButtonIniciar(Button b) {
        this.uiButtonIniciar = b;
    }
    private Button uiGuardarEdicion = new Button();

    public Button getUiGuardarEdicion() {
        return uiGuardarEdicion;
    }

    public void setUiGuardarEdicion(Button b) {
        this.uiGuardarEdicion = b;
    }
    private TextField uiEmpleadoNombre = new TextField();

    public TextField getUiEmpleadoNombre() {
        return uiEmpleadoNombre;
    }

    public void setUiEmpleadoNombre(TextField tf) {
        this.uiEmpleadoNombre = tf;
    }
    private Button cancelar = new Button();

    public Button getCancelar() {
        return cancelar;
    }

    public void setCancelar(Button b) {
        this.cancelar = b;
    }
    private TextField uiBuscarProd = new TextField();

    public TextField getUiBuscarProd() {
        return uiBuscarProd;
    }

    public void setUiBuscarProd(TextField tf) {
        this.uiBuscarProd = tf;
    }
    private SingleSelectOptionsList uiEstadoFilDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiEstadoFilDefaultOptions() {
        return uiEstadoFilDefaultOptions;
    }

    public void setUiEstadoFilDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiEstadoFilDefaultOptions = ssol;
    }
    private DropDown uiEstadoFil = new DropDown();

    public DropDown getUiEstadoFil() {
        return uiEstadoFil;
    }

    public void setUiEstadoFil(DropDown dd) {
        this.uiEstadoFil = dd;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RegistroDeInventario() {
    uiEstadoFilDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("T", "Todos"), new com.sun.webui.jsf.model.Option("A", "Activo"), new com.sun.webui.jsf.model.Option("C", "Cerrado"), new com.sun.webui.jsf.model.Option("N", "Anulado")});
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

    getSessionBean1().setTituloPagina("Registro de Inventario");
    getSessionBean1().setDetallePagina("Ingresar los datos de Inventario");
    cargarListaTodosInventariosCab();


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
    private boolean addRequestIniciado = false;
    private boolean updateRequest = false;
    private boolean errorValidacion = false;

    @Override
    public void prerender() {

        if (addRequest) {
            this.gridPanelbusqueda.setRendered(false);
            this.gridPanelCabecera1.setRendered(true);
            if (addRequestIniciado) {
                this.gridPanelDetalle.setRendered(true);
            }

                getSessionBean1().setTituloPagina("Registro de Inventario");
        getSessionBean1().setDetallePagina("Registro de nuevo inventario, previo al cierre y ajuste de Existencias");


        } else if (updateRequest) {

                getSessionBean1().setTituloPagina("Editar Registro de Inventario");
        getSessionBean1().setDetallePagina("Editar el inventario previo al cierre y ajuste de Existencias");
            this.gridPanelbusqueda.setRendered(false);
            this.gridPanelCabecera1.setRendered(true);
            this.gridPanelDetalle.setRendered(true);

        } else if (errorValidacion) {
            
            this.gridPanelbusqueda.setRendered(false);
            this.gridPanelCabecera1.setRendered(true);
            if (addRequestIniciado) {
                this.gridPanelDetalle.setRendered(true);
            }
        } else {

            this.gridPanelbusqueda.setRendered(true);
            this.gridPanelCabecera1.setRendered(false);
            this.gridPanelDetalle.setRendered(false);
        }
buscar_action2();


    }

    private String buscar_action2() {


        InventarioCabecera[] listaInventariosCab;
        InventarioCabeceraController inventarioCabeceraController = new InventarioCabeceraController();

        String pCodDeposito=null;
        String pEstado=null;
        Date pFecha2 = null;
        Date pFecha1= null;

        if (this.uiDepositoFil.getSelected() !=null && !this.uiDepositoFil.getSelected().equals("-1")) {
            pCodDeposito = this.uiDepositoFil.getSelected().toString();
        }

        if (this.uiEstadoFil.getSelected() !=null && !this.uiEstadoFil.getSelected().toString().equals("T")) {
            pEstado= this.uiEstadoFil.getSelected().toString();
        }

        if (this.uiFecha1Fil.getSelectedDate() !=null) {
            pFecha1 = this.uiFecha1Fil.getSelectedDate();
        }


        if (this.uiFecha2Fil.getSelectedDate() !=null) {
            pFecha2 = this.uiFecha2Fil.getSelectedDate();
        }


        listaInventariosCab = (InventarioCabecera[]) inventarioCabeceraController.getAllFiltered(
                null,
                pCodDeposito,
                pFecha1, 
                pFecha2,
                pEstado).toArray(new InventarioCabecera[0]);

        setListaInventariosCab(listaInventariosCab);

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
        this.addRequest=true;
        this.updateRequest=false;
        this.addRequestIniciado=false;

        limpiarDetalle();
        this.uiFechaInv.setSelectedDate(new Date());
        
        return null;
    }

    public String editar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.updateRequest=true;
        this.addRequest=false;

        return null;

    }

    public String eliminar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public String cancelar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequest=false;
        this.updateRequest=false;
        this.errorValidacion=false;

        return null;
    }

    private boolean validarCampos(){


      errorValidacion = false;

      InventarioCabecera[] invCabArray = new InventarioCabeceraController().getAllFiltered(
                null,
                this.uiDeposito.getSelected().toString(),
                null, 
                null,
                "A").toArray(new InventarioCabecera[0]);
        if (!updateRequest && invCabArray != null && invCabArray.length > 0) {
            errorValidacion = true;
            this.info("Imposible Abrir nuevo inventario en el Deposito. Existen Inventarios Abietos Pendientes");
            
        }
      
            if (detallesInventario.length < 1){
                       errorValidacion = true;
                       this.info("Debe Iniciar el registro de los detalles");
            }

      if (this.uiEmpleadoCod.getText() == null ||
                    this.uiEmpleadoCod.getText().toString() == null ||
                    this.uiEmpleadoCod.getText().toString().equals("") ||
                    !StringUtils.esNumero(this.uiEmpleadoCod.getText().toString())){
                        errorValidacion = true;
                       this.info("Debe seleccionar un Empleado");
                }else{
                        Empleado e   = new EmpleadoController().findById(Long.valueOf(uiEmpleadoCod.getText().toString()));
                        if (e == null) {
                            this.errorValidacion= true;
                            info(uiEmpleadoCod, "Verifique el codigo del Empleado Responsable");
                        }
      }

      if (this.uiObservacion.getText() == null ||
                    this.uiObservacion.getText().toString() == null ||
                    this.uiObservacion.getText().toString().equals("")){
                        errorValidacion = true;
                       this.info("Favor ingrese la Descripcion del Inventario");
      }

      if (this.uiFechaInv.getSelectedDate() == null ||
                    this.uiFechaInv.getSelectedDate().toString() == null ||
                    this.uiFechaInv.getSelectedDate().toString().equals("")){
                        errorValidacion = true;
                       this.info("Debe seleccionar la fecha");
                }


    return errorValidacion;
    }

    public String uiGuardarNuevo_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
         errorValidacion = validarCampos();

        //Si no hay error de validacion
        if (! errorValidacion){

            //// CARGA DE LA CABECERA
          InventarioCabecera inventarioCabecera = new InventarioCabecera();
          InventarioCabeceraController inventarioCabeceraController = new InventarioCabeceraController();
          DepositoController depositoController = new DepositoController();
          EmpleadoController empleadoController = new EmpleadoController();

          inventarioCabecera.setCodDeposito(depositoController.findById(Long.valueOf(this.uiDeposito.getSelected().toString())));
          inventarioCabecera.setCodEmpleado(empleadoController.findById(Long.valueOf(this.uiEmpleadoCod.getText().toString())));
          inventarioCabecera.setFecInventario(this.uiFechaInv.getSelectedDate());
          inventarioCabecera.setDescripcion(this.uiObservacion.getText().toString());
          inventarioCabecera.setEstado("A");

         detallesInventario = (InventarioDetalle[]) detalleInvenarioList.toArray(new InventarioDetalle[0]);

          inventarioCabeceraController = new InventarioCabeceraController();
          ControllerResult controllerResult = new ControllerResult();
                            controllerResult = inventarioCabeceraController.createCabDet(inventarioCabecera,detallesInventario);


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

public void limpiarDetalle(){

this.uiProductoDet.setText("");
this.uiCantContada.setText("");
this.uiCantSistema.setText("");
this.uiObservacionDet.setText("");

}

    ////// MANEJO DE DETALLES DE Formulas

private InventarioDetalle[] detallesInventario;
private InventarioDetalle  detInventario;
private List<InventarioDetalle>  detalleInvenarioList;

    public InventarioDetalle getDetInventario() {
        return detInventario;
    }

    public void setDetInventario(InventarioDetalle detInventario) {
        this.detInventario = detInventario;
    }

    public List<InventarioDetalle> getDetalleInvenarioList() {
        return detalleInvenarioList;
    }

    public void setDetalleInvenarioList(List<InventarioDetalle> detalleInvenarioList) {
        this.detalleInvenarioList = detalleInvenarioList;
    }

    public InventarioDetalle[] getDetallesInventario() {
        return detallesInventario;
    }

    public void setDetallesInventario(InventarioDetalle[] detallesInventario) {
        this.detallesInventario = detallesInventario;
    }



    public String button4_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequest=true;
        this.updateRequest=false;
        this.errorValidacion=false;

        this.pageAlert1.setRendered(false);
        this.uiButtonCerrar.setRendered(false);
        this.uiButtonIniciar.setRendered(true);
        this.uiGuardarNuevo.setRendered(true);
        this.uiGuardarEdicion.setRendered(false);
        this.uiNroInventario.setDisabled(true);
        this.uiFechaInv.setReadOnly(false);
        this.uiDeposito.setDisabled(false);
        

        detalleInvenarioList= new ArrayList();
        detallesInventario = (InventarioDetalle[]) detalleInvenarioList.toArray(new InventarioDetalle[0]);
        addRequest = true;
        addRequestIniciado = false;

        getSessionBean1().setTituloPagina("Registro de Inventario en Deposito");
        getSessionBean1().setDetallePagina("Registrar nuevo Inventario");

        uiNroInventario.setText("");
        uiDeposito.setSelected("");
        uiObservacion.setText("");
        uiEmpleadoCod.setText("");
        uiEmpleadoNombre.setText("");
        uiFechaInv.setSelectedDate(new Date());
        limpiarDetalle();
        
        this.itemDet = null;
        this.editarDetalle = false;

        return null;
    }

    ///// CARGA DE COMBO BOX Formulas TERMINADOS
//////     import com.sun.webui.jsf.model.Option;

    InventarioCabecera[] listaInventariosCab;

    public InventarioCabecera[] getListaInventariosCab() {
        return listaInventariosCab;
    }

    public void setListaInventariosCab(InventarioCabecera[] listaInventariosCab) {
        this.listaInventariosCab = listaInventariosCab;
    }

    public void cargarListaTodosInventariosCab(){
        InventarioCabeceraController inventarioCabeceraController = new InventarioCabeceraController();
        listaInventariosCab = (InventarioCabecera[]) inventarioCabeceraController.getAll("codDeposito.codDepodiyo").toArray(new InventarioCabecera[0]);
        }

    public String button1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        buscar_action();
        return null;
    }

    public String uiButtonIniciar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        addRequest = true;
        addRequestIniciado = true;
        updateRequest = false;
        detalleInvenarioList.removeAll(detalleInvenarioList);

        Deposito dep = new Deposito();
        dep = new DepositoController().findById(Long.valueOf(this.uiDeposito.getSelected().toString()));

        Existencia[] existencias = new ExistenciaController().getAllFiltered(null,null ,dep.getCodDeposito()).toArray(new Existencia[0]);

        for (int i = 0; i < existencias.length; i++) {
            Existencia existencia = existencias[i];
            InventarioDetalle invDet = new InventarioDetalle();

            invDet.setCodProducto(existencia.getCodProducto());
            invDet.setCantidadsistema(existencia.getCantidadExistencia());
            invDet.setCantidadcontada(BigInteger.valueOf(Long.valueOf("0")));

            detalleInvenarioList.add(invDet);

        }

        detallesInventario = (InventarioDetalle[]) detalleInvenarioList.toArray(new InventarioDetalle[0]);
         return null;
    }

 private String itemDet;

    public String getItemDet() {
        return itemDet;
    }

    public void setItemDet(String itemDet) {
        this.itemDet = itemDet;
    }

    private boolean editarDetalle;

    public boolean isEditarDetalle() {
        return editarDetalle;
    }

    public void setEditarDetalle(boolean editarDetalle) {
        this.editarDetalle = editarDetalle;
    }



    public String editDetail() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        editarDetalle = true;

        InventarioDetalle inventarioDetalle = new InventarioDetalle();
        inventarioDetalle = detalleInvenarioList.get(Integer.valueOf(itemDet).intValue());

            this.uiProductoDet.setText(inventarioDetalle.getCodProducto().getDescripcion().toString());
            this.uiCantContada.setText(inventarioDetalle.getCantidadcontada().toString());
            this.uiCantSistema.setText(inventarioDetalle.getCantidadsistema().toString());
            
            if (inventarioDetalle.getObservacion() != null && !inventarioDetalle.getObservacion().equals("")) {
                this.uiObservacionDet.setText(inventarioDetalle.getObservacion().toString());
            }


        return null;
    }

    public String buttonActualizar_action() {


        validarDetalle();

        if (!errorValidacion) {

             InventarioDetalle inventarioDetalle = detalleInvenarioList.get(Integer.valueOf(itemDet).intValue());
             inventarioDetalle.setCantidadcontada(BigInteger.valueOf(Long.valueOf(this.uiCantContada.getText().toString())));
             inventarioDetalle.setObservacion(this.uiObservacionDet.getText().toString());

             detallesInventario = (InventarioDetalle[]) detalleInvenarioList.toArray(new InventarioDetalle[0]);
             limpiarDetalle();
             editarDetalle = false;
             
        }

        return null;
    }
  
public void validarDetalle(){


this.errorValidacion = false;

        if (!editarDetalle){
            this.errorValidacion= true;
            info("Seleccione el Producto");
        }
        if (uiCantContada.getText() == null || uiCantContada.getText().equals("") || !StringUtils.esNumero(this.uiCantContada.getText().toString()) ) {
            this.errorValidacion= true;
            info("Verifique la cantidad");
        }
}

    public String uiGuardarEdicion_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
    errorValidacion = false;
    updateRequest = true;

    ControllerResult controllerResult = new ControllerResult();
    InventarioCabecera inventarioCabecera = new InventarioCabecera();
    validarCampos();

        if (!errorValidacion){
                inventarioCabecera = new InventarioCabeceraController().findById(getSessionBean1().getId());
                 //// CARGA DE LA CABECERA
          DepositoController depositoController = new DepositoController();
          EmpleadoController empleadoController = new EmpleadoController();

          inventarioCabecera.setCodDeposito(depositoController.findById(Long.valueOf(this.uiDeposito.getSelected().toString())));
          inventarioCabecera.setCodEmpleado(empleadoController.findById(Long.valueOf(this.uiEmpleadoCod.getText().toString())));
          inventarioCabecera.setFecInventario(this.uiFechaInv.getSelectedDate());
          inventarioCabecera.setDescripcion(this.uiObservacion.getText().toString());
                
          //// Convertilos los List a Array y enviamos

                detallesInventario = (InventarioDetalle[]) detalleInvenarioList.toArray(new InventarioDetalle[0]);
                InventarioCabeceraController inventarioCabeceraController = new InventarioCabeceraController();
                controllerResult = inventarioCabeceraController.updateCabDet(inventarioCabecera, detallesInventario);
          }
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

        return null;
    }

    public String uiButtonCerrar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
         errorValidacion = false;
         updateRequest = true;

        ControllerResult controllerResult = new ControllerResult();
        InventarioCabecera inventarioCabecera = new InventarioCabecera();
        validarCampos();

        if (!errorValidacion){
          inventarioCabecera = new InventarioCabeceraController().findById(getSessionBean1().getId());
                 //// CARGA DE LA CABECERA
          DepositoController depositoController = new DepositoController();
          EmpleadoController empleadoController = new EmpleadoController();

          inventarioCabecera.setCodDeposito(depositoController.findById(Long.valueOf(this.uiDeposito.getSelected().toString())));
          inventarioCabecera.setCodEmpleado(empleadoController.findById(Long.valueOf(this.uiEmpleadoCod.getText().toString())));
          inventarioCabecera.setFecInventario(this.uiFechaInv.getSelectedDate());
          inventarioCabecera.setDescripcion(this.uiObservacion.getText().toString());
                
          //// Convertilos los List a Array y enviamos

                detallesInventario = (InventarioDetalle[]) detalleInvenarioList.toArray(new InventarioDetalle[0]);
                InventarioCabeceraController inventarioCabeceraController = new InventarioCabeceraController();
                controllerResult = inventarioCabeceraController.updateCabDetClose(inventarioCabecera, detallesInventario);
          }

                        if (controllerResult.getCodRetorno() != -1) {
                                    addRequest = false;
                                    updateRequest = false;
                                    
                                    this.pageAlert1.setType("information");
                            }

                                this.pageAlert1.setTitle(controllerResult.getMsg());
                                this.pageAlert1.setSummary("");
                                this.pageAlert1.setDetail("");
                                this.pageAlert1.setRendered(true);






        return null;
    }

    public String button5_action() {
        // TODO: Process the action. Return value is a navigation
//        // case name where null will return to the same page.
        
        getSessionBean1().setTituloPagina("Editar Registro de Inventario");
        getSessionBean1().setDetallePagina("Editar el inventario previo al cierre y ajuste de Existencias");
        this.pageAlert1.setRendered(false);
        this.updateRequest=true;
        
        this.uiButtonIniciar.setRendered(false);
        this.uiButtonCerrar.setRendered(true);
        this.uiGuardarEdicion.setRendered(true);
        this.uiGuardarNuevo.setRendered(false);

        this.uiNroInventario.setReadOnly(true);
        this.uiFechaInv.setReadOnly(true);
        this.uiDeposito.setDisabled(true);
        this.itemDet = null;
        this.editarDetalle = false;

        cargarCamposUpdate();
        limpiarDetalle();



        return null;
    }

public void cargarCamposUpdate(){
         if (getTableRowGroup1().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
          InventarioCabecera[] inventariosCabecera = this.listaInventariosCab;
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          InventarioCabecera inventarioCabecera = inventariosCabecera[rowId];

          getSessionBean1().setId(inventarioCabecera.getCodInventario());
         //// CARGA DE CAMPOS DE LA PAGINA
         this.uiNroInventario.setText(inventarioCabecera.getCodInventario().toString());
         this.uiEmpleadoCod.setText(inventarioCabecera.getCodEmpleado().getCodEmpleado().toString());
         this.uiEmpleadoNombre.setText(inventarioCabecera.getCodEmpleado().getApellidoEmpleado().toString()+", "+inventarioCabecera.getCodEmpleado().getNombreEmpleado().toString());
         this.uiDeposito.setSelected(inventarioCabecera.getCodDeposito().getCodDeposito().toString());
         this.uiFechaInv.setSelectedDate(inventarioCabecera.getFecInventario());
         this.uiObservacion.setText(inventarioCabecera.getDescripcion().toString());

         if(inventarioCabecera.getEstado().toString().equals("C")){
            this.uiButtonCerrar.setRendered(false);
            this.uiGuardarEdicion.setRendered(false);

            this.cancelar.setText("Volver");
         }else{
               this.cancelar.setText("Cancelar");
               this.uiGuardarEdicion.setRendered(true);
         }



         detalleInvenarioList = new ArrayList();
         detalleInvenarioList = inventarioCabecera.getInventarioDetalleCollection();
         detallesInventario = (InventarioDetalle[]) detalleInvenarioList.toArray(new InventarioDetalle[0]);
            }
}

    public String tab1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String uiButtonBuscarProd_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        Producto p = new Producto();
        for (int i = 0; i < detallesInventario.length; i++) {
            InventarioDetalle inventarioDetalle = detallesInventario[i];
            if (inventarioDetalle.getCodProducto().getCodProducto().toString().equals(this.uiBuscarProd.getText().toString())) {

                    Integer e = i;
                    itemDet = e.toString();

                    editarDetalle = true;
                    inventarioDetalle = detalleInvenarioList.get(Integer.valueOf(itemDet).intValue());
                        this.uiProductoDet.setText(inventarioDetalle.getCodProducto().getDescripcion().toString());
                        this.uiCantContada.setText(inventarioDetalle.getCantidadcontada().toString());
                        this.uiCantSistema.setText(inventarioDetalle.getCantidadsistema().toString());

                        if (inventarioDetalle.getObservacion() != null && !inventarioDetalle.getObservacion().equals("")) {
                            this.uiObservacionDet.setText(inventarioDetalle.getObservacion().toString());
                        }
                        this.uiBuscarProd.setText("");
                        break;
            }


        }



        return null;
    }

    public String uiButtonTodosFil_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.uiDepositoFil.setSelected("");
        this.uiFecha1Fil.setSelectedDate(null);
        this.uiFecha2Fil.setSelectedDate(null);
        this.uiEstadoFil.setSelected(null);

        

        return null;
    }

    public String uiButtonAnular_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        if (getTableRowGroup1().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
          InventarioCabecera[] inventariosCabecera = this.listaInventariosCab;
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          InventarioCabecera inventarioCabecera = inventariosCabecera[rowId];
          InventarioCabeceraController invCont = new InventarioCabeceraController();
          ControllerResult controllerResult = new ControllerResult();
          getSessionBean1().setId(inventarioCabecera.getCodInventario());
         //// CARGA DE CAMPOS DE LA PAGINA

                 if(inventarioCabecera.getEstado().toString().equals("C")){
                          this.pageAlert1.setType("error");
                          this.pageAlert1.setTitle("El inventario ya fue ajustado, no es posible anularlo");

                 }else{
                            inventarioCabecera.setEstado("N");
                            InventarioDetalle[] invDet = (InventarioDetalle[]) inventarioCabecera.getInventarioDetalleCollection().toArray(new InventarioDetalle[0]);


                            controllerResult = invCont.anularCabDet(inventarioCabecera,invDet);

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
                  }

                this.pageAlert1.setRendered(true);
        }
        return null;
    }

}
