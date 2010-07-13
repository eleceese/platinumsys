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
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.DepositoController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Deposito;

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
public class ABMDeposito extends AbstractPageBean {
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
    private StaticText datosDeposito = new StaticText();

    public StaticText getDatosDeposito() {
        return datosDeposito;
    }

    public void setDatosDeposito(StaticText st) {
        this.datosDeposito = st;
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
    private TextField uiNombreDeposito = new TextField();

    public TextField getUiNombreDeposito() {
        return uiNombreDeposito;
    }

    public void setUiNombreDeposito(TextField tf) {
        this.uiNombreDeposito = tf;
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
    private TextField uiNombreFIl = new TextField();

    public TextField getUiNombreFIl() {
        return uiNombreFIl;
    }

    public void setUiNombreFIl(TextField tf) {
        this.uiNombreFIl = tf;
    }
    private Table tableDepositos = new Table();

    public Table getTableDepositos() {
        return tableDepositos;
    }

    public void setTableDepositos(Table t) {
        this.tableDepositos = t;
    }
    private Checkbox uiActivoChek = new Checkbox();

    public Checkbox getUiActivoChek() {
        return uiActivoChek;
    }

    public void setUiActivoChek(Checkbox c) {
        this.uiActivoChek = c;
    }
    private TableRowGroup uiTablaDepositos = new TableRowGroup();

    public TableRowGroup getUiTablaDepositos() {
        return uiTablaDepositos;
    }

    public void setUiTablaDepositos(TableRowGroup trg) {
        this.uiTablaDepositos = trg;
    }
    private Calendar uiFechaAltaCalendar = new Calendar();

    public Calendar getUiFechaAltaCalendar() {
        return uiFechaAltaCalendar;
    }

    public void setUiFechaAltaCalendar(Calendar c) {
        this.uiFechaAltaCalendar = c;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TableColumn tableColumn3 = new TableColumn();

    public TableColumn getTableColumn3() {
        return tableColumn3;
    }

    public void setTableColumn3(TableColumn tc) {
        this.tableColumn3 = tc;
    }
    private HtmlPanelGrid gridPanelDeposito1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDeposito1() {
        return gridPanelDeposito1;
    }

    public void setGridPanelDeposito1(HtmlPanelGrid hpg) {
        this.gridPanelDeposito1 = hpg;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMDeposito() {
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

    getSessionBean1().setTituloPagina("Registro de Depositos");
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


        if (getSessionBean1().getUsuarioLogueado() == null)
        {
            HttpServletResponse response = (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
                    try {
                        response.sendRedirect("/Platinum/faces/Acceso.jsp");
                        getFacesContext().responseComplete();
                    } catch (IOException ex) {
                        Logger.getLogger(cabecera.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }else if(!getSessionBean1().getUsuarioLogueado().getRol().toString().equals("DEPOSITO")
                 &&!getSessionBean1().getUsuarioLogueado().getRol().toString().equals("ADMINISTRADOR")){
            HttpServletResponse response = (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
                    try {
                        response.sendRedirect("/Platinum/faces/PermisoDenegado.jsp");
                        getFacesContext().responseComplete();
                    } catch (IOException ex) {
                        Logger.getLogger(cabecera.class.getName()).log(Level.SEVERE, null, ex);
                    }


        }

        if (addRequest) {
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosDeposito.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosDeposito.setRendered(true);
            limpiarCamposNew();


        } else if (updateRequest) {

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosDeposito.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosDeposito.setRendered(true);
            cargarCamposUpdate();

        } else if (errorValidacion) {
            
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosDeposito.setRendered(true);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosDeposito.setRendered(true);


        } else {

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosDeposito.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosDeposito.setRendered(false);

        }
    buscar_action2();
    }

 public void limpiarCamposNew(){

            this.uiNombreDeposito.setText("");
            this.uiFechaAltaCalendar.setSelectedDate(new Date());
            this.uiActivoChek.setSelected(false);
    }

  public void cargarCamposUpdate(){

         if (getUiTablaDepositos().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getUiTablaDepositos().getSelectedRowKeys();
          Deposito[] depositos = getSessionBean1().getListaDepositos();
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          Deposito deposito = depositos[rowId];
      

         //// CARGAMOS EN UNA VARIABLE ID EL CODIGO DEL TIPO RECUPERADO DESDE LA GRILLA PARA
          /// LUEGO HACER LA BUSQUEDA DEL OBJETO POR ID
          getSessionBean1().setId(deposito.getCodDeposito());
         //// CARGA DE CAMPOS DE LA PAGINA
         this.uiNombreDeposito.setText(deposito.getNombre());
         this.uiFechaAltaCalendar.setSelectedDate(deposito.getFechaAlta());

         if (deposito.getEstado().equals("ABIERTO")) {
                this.uiActivoChek.setSelected(true);
            } else {
                this.uiActivoChek.setSelected(false);
            }



         }
}
    
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
        this.pageAlert1.setRendered(false);
        this.buttonGuardarEdicion.setRendered(true);
        this.buttonGuardarNuevo.setRendered(false);
        return null;
    }

    public String eliminar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        if (getUiTablaDepositos().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getUiTablaDepositos().getSelectedRowKeys();
          Deposito[] depositos = getSessionBean1().getListaDepositos();
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          Deposito deposito = depositos[rowId];
          // Remove the Entity from the database using UserController
          DepositoController depositoController = new DepositoController();
          ControllerResult controllerResult = depositoController.delete(deposito);

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
            Deposito deposito = new Deposito();
            deposito.setNombre(this.uiNombreDeposito.getText().toString());
            deposito.setFechaAlta(this.uiFechaAltaCalendar.getSelectedDate());

            if (this.uiActivoChek.isChecked()) {
                    deposito.setEstado("ABIERTO");
            } else {
                    deposito.setEstado("CERRADO");
            }
            DepositoController depositoController = new DepositoController();

            ControllerResult controllerResult = new ControllerResult();
            controllerResult = depositoController.create(deposito);

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
            if (this.uiNombreDeposito.getText() == null ||
                this.uiNombreDeposito.getText().toString() == null ||
                this.uiNombreDeposito.getText().toString().equals("")){
                   errorValidacion = true;
                   this.info(uiNombreDeposito, "El nombre no puede ser nulo");
            }
//            else if (new DepositoController().existe(this.uiNombreDeposito.getText().toString()))  {
//                         errorValidacion = true;
//                          this.info(uiNombreDeposito, "El nombre de Deposito ya existe");
//            }
}
    private String buscar_action2() {

        Deposito[] listaDepositos;
        DepositoController depositoController = new DepositoController();

        String pCodigo=null, pNombre=null;

        if (this.uiCodigoFil.getText()!=null) {
            pCodigo = this.uiCodigoFil.getText().toString();
        }

        if (this.uiNombreFIl.getText()!=null) {
            pNombre = this.uiNombreFIl.getText().toString();
        }

        listaDepositos = (Deposito[])  depositoController.getAllFiltered
                                        (pCodigo,
                                         pNombre).toArray(new Deposito[0]);

        getSessionBean1().setListaDepositos(listaDepositos);
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
//        getSessionBean1().cargarListaTodosDepositos();
        this.uiCodigoFil.setText("");
        this.uiNombreFIl.setText("");
        this.uiFechaAltaCalendar.setSelectedDate(new Date());
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

    public String buttonGuardarEdicion_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        updateRequest = true;
        validarCampos();
         
        if (! errorValidacion){

          Deposito deposito = new DepositoController().findById(getSessionBean1().getId());

                            deposito.setNombre(this.uiNombreDeposito.getText().toString());
                            deposito.setFechaAlta(this.uiFechaAltaCalendar.getSelectedDate());

                            if (this.uiActivoChek.isChecked()) {
                                deposito.setEstado("ABIERTO");
                            } else {
                                deposito.setEstado("CERRADO");
                            }
                            
                            DepositoController depositoController = new DepositoController();

                            ControllerResult controllerResult = new ControllerResult();
                            controllerResult = depositoController.update(deposito);


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
}

