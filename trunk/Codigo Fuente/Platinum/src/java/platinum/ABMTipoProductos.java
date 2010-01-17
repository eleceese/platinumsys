/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.ValueChangeEvent;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.TipoProductoController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.TipoProducto;






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
public class ABMTipoProductos extends AbstractPageBean {
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
    private StaticText datosTipo = new StaticText();

    public StaticText getDatosTipo() {
        return datosTipo;
    }

    public void setDatosTipo(StaticText st) {
        this.datosTipo = st;
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
    private TextField uiTipo = new TextField();

    public TextField getUiTipo() {
        return uiTipo;
    }

    public void setUiTipo(TextField tf) {
        this.uiTipo = tf;
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
    private TextField uiTipoFIl = new TextField();

    public TextField getUiTipoFIl() {
        return uiTipoFIl;
    }

    public void setUiTipoFIl(TextField tf) {
        this.uiTipoFIl = tf;
    }
    private TableColumn tableColumnRadio = new TableColumn();

    public TableColumn getTableColumnRadio() {
        return tableColumnRadio;
    }

    public void setTableColumnRadio(TableColumn tc) {
        this.tableColumnRadio = tc;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private Table tableTipo = new Table();

    public Table getTableTipo() {
        return tableTipo;
    }

    public void setTableTipo(Table t) {
        this.tableTipo = t;
    }
    private Checkbox uiExistChek = new Checkbox();

    public Checkbox getUiExistChek() {
        return uiExistChek;
    }

    public void setUiExistChek(Checkbox c) {
        this.uiExistChek = c;
    }
    private TableRowGroup uiTablaTipos = new TableRowGroup();

    public TableRowGroup getUiTablaTipos() {
        return uiTablaTipos;
    }

    public void setUiTablaTipos(TableRowGroup trg) {
        this.uiTablaTipos = trg;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMTipoProductos() {
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

    getSessionBean1().setTituloPagina("Registro de tipos de Producto");
    getSessionBean1().setDetallePagina("Seleccione el registro Deseado");


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
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosTipo.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosTipo.setRendered(true);
            limpiarCamposNew();


        } else if (updateRequest) {

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosTipo.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosTipo.setRendered(true);
            cargarCamposUpdate();

        } else if (errorValidacion) {
            
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosTipo.setRendered(true);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosTipo.setRendered(true);


        } else {

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosTipo.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosTipo.setRendered(false);

        }
    buscar_action2();
    }

 public void limpiarCamposNew(){

            this.uiTipo.setText("");
            this.uiExistChek.setSelected(false);

    }

  public void cargarCamposUpdate(){

         if (getUiTablaTipos().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getUiTablaTipos().getSelectedRowKeys();
          TipoProducto[] tipoProductos = getSessionBean1().getListaTipoProductos();
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          TipoProducto tipoProducto = tipoProductos[rowId];
      

         //// CARGAMOS EN UNA VARIABLE ID EL CODIGO DEL TIPO RECUPERADO DESDE LA GRILLA PARA
          /// LUEGO HACER LA BUSQUEDA DEL OBJETO POR ID
          getSessionBean1().setId(tipoProducto.getCodTipoProducto());
         //// CARGA DE CAMPOS DE LA PAGINA
         this.uiTipo.setText(tipoProducto.getDescripcion());
             if (tipoProducto.getTareas().equals("S")) {
                    this.uiExistChek.setSelected(true);
             } else {
             this.uiExistChek.setSelected(false);
             }
         }

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
        this.pageAlert1.setRendered(false);

        this.buttonGuardarNuevo.setRendered(true);
        this.buttonGuardarEdicion.setRendered(false);
        return null;
    }

    public String editar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.updateRequest=true;
        this.buttonGuardarEdicion.setRendered(true);
        this.buttonGuardarNuevo.setRendered(false);
        return null;

    }

    public String eliminar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        if (getUiTablaTipos().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getUiTablaTipos().getSelectedRowKeys();
          TipoProducto[] tiposProducto = getSessionBean1().getListaTipoProductos();
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          TipoProducto tipoProducto = tiposProducto[rowId];
          // Remove the Entity from the database using UserController
          TipoProductoController tipoProductoController = new TipoProductoController();
          ControllerResult controllerResult = tipoProductoController.delete(tipoProducto);

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

    public String cancelar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequest=false;
        this.updateRequest=false;

        return null;
    }

    public String buttonGuardarNuevo_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarCampos();

        if (! errorValidacion){
            TipoProducto tipoProducto = new TipoProducto();
            tipoProducto.setDescripcion(this.uiTipo.getText().toString());

//                        producto.setFechaAlta(this.uiFechaAlta.getSelectedDate());
            if (this.uiExistChek.isChecked()) {
                    tipoProducto.setTareas("S");
            } else {
                    tipoProducto.setTareas("N");
            }
            TipoProductoController tipoProductoController = new TipoProductoController();

            ControllerResult controllerResult = new ControllerResult();
            controllerResult = tipoProductoController.create(tipoProducto);


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

public void validarCampos() {
    errorValidacion = false;
   

            if (this.uiTipo.getText() == null ||
                this.uiTipo.getText().toString() == null ||
                this.uiTipo.getText().toString().equals("")){
                   errorValidacion = true;
                   this.info(uiTipo, "La Descripcion no puede ser nula");
            } else if (new TipoProductoController().existe(this.uiTipo.getText().toString()))  {
                         errorValidacion = true;
                          this.info(uiTipo, "El tipo de producto ya Existe");
            }
   
}

    private String buscar_action2() {

        TipoProducto[] listaTiposProducto;
        TipoProductoController tipoProductoController = new TipoProductoController();

        String pCodigo=null, pDesc=null;

        if (this.uiCodigoFil.getText()!=null) {
            pDesc = this.uiCodigoFil.getText().toString();
        }

        if (this.uiTipoFIl.getText()!=null) {
            pDesc = this.uiTipoFIl.getText().toString();
        }

        listaTiposProducto = (TipoProducto[])  tipoProductoController.getAllFiltered
                                        (pCodigo,
                                         pDesc).toArray(new TipoProducto[0]);

        getSessionBean1().setListaTipoProductos(listaTiposProducto);
        return null;

    }

        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
    public String buscar_action() {
        this.pageAlert1.setRendered(false);
        return null;
    }

    public String todos_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.pageAlert1.setRendered(false);
        getSessionBean1().cargarListaTodosTipoProductos();
        this.uiCodigoFil.setText("");
        this.uiTipoFIl.setText("");
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

    public String buttonGuardarEdicion_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        updateRequest = true;
         validarCampos();
         
        if (! errorValidacion){


          TipoProducto tipoProducto = new TipoProductoController().findById(getSessionBean1().getId());

                            tipoProducto.setDescripcion(this.uiTipo.getText().toString());

                            if (this.uiExistChek.isChecked()) {
                                tipoProducto.setTareas("S");
                            } else {
                                tipoProducto.setTareas("N");
                            }
                            
                            TipoProductoController tipoProductoController = new TipoProductoController();

                            ControllerResult controllerResult = new ControllerResult();
                            controllerResult = tipoProductoController.update(tipoProducto);


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



   ///// FIN CODIGO PARA RADIO BUTTON DE LA GRILLA DE BUSQUEDA



}

