/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.data.provider.RowKey;
import com.sun.org.apache.bcel.internal.generic.IFEQ;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.PasswordField;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.ValueChangeEvent;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.DepositoController;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.ProveedorController;
import py.com.platinum.controller.TipoProductoController;
import py.com.platinum.controller.UsuarioController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.Proveedor;
import py.com.platinum.entity.TipoProducto;
import py.com.platinum.entity.Usuarios;






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
public class ABMUsuarios extends AbstractPageBean {
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
    private StaticText datosUsu = new StaticText();

    public StaticText getDatosUsu() {
        return datosUsu;
    }

    public void setDatosUsu(StaticText st) {
        this.datosUsu = st;
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
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private TextField uiUsuarioFil = new TextField();

    public TextField getUiUsuarioFil() {
        return uiUsuarioFil;
    }

    public void setUiUsuarioFil(TextField tf) {
        this.uiUsuarioFil = tf;
    }
    private Table tableProveedores = new Table();

    public Table getTableProveedores() {
        return tableProveedores;
    }

    public void setTableProveedores(Table t) {
        this.tableProveedores = t;
    }
    private TableRowGroup uiTablaProveedoresRW = new TableRowGroup();

    public TableRowGroup getUiTablaProveedoresRW() {
        return uiTablaProveedoresRW;
    }

    public void setUiTablaProveedoresRW(TableRowGroup trg) {
        this.uiTablaProveedoresRW = trg;
    }
    private TextField uiRolFil = new TextField();

    public TextField getUiRolFil() {
        return uiRolFil;
    }

    public void setUiRolFil(TextField tf) {
        this.uiRolFil = tf;
    }
    private TextField uiUsuario = new TextField();

    public TextField getUiUsuario() {
        return uiUsuario;
    }

    public void setUiUsuario(TextField tf) {
        this.uiUsuario = tf;
    }
    private DropDown uiEmpleadoFil = new DropDown();

    public DropDown getUiEmpleadoFil() {
        return uiEmpleadoFil;
    }

    public void setUiEmpleadoFil(DropDown dd) {
        this.uiEmpleadoFil = dd;
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
    private SingleSelectOptionsList uiRolDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiRolDefaultOptions() {
        return uiRolDefaultOptions;
    }

    public void setUiRolDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiRolDefaultOptions = ssol;
    }
    private Checkbox uiActivo = new Checkbox();

    public Checkbox getUiActivo() {
        return uiActivo;
    }

    public void setUiActivo(Checkbox c) {
        this.uiActivo = c;
    }
    private DropDown uiEmpleado = new DropDown();

    public DropDown getUiEmpleado() {
        return uiEmpleado;
    }

    public void setUiEmpleado(DropDown dd) {
        this.uiEmpleado = dd;
    }
    private DropDown uiRol = new DropDown();

    public DropDown getUiRol() {
        return uiRol;
    }

    public void setUiRol(DropDown dd) {
        this.uiRol = dd;
    }
    private PasswordField uiPassword = new PasswordField();

    public PasswordField getUiPassword() {
        return uiPassword;
    }

    public void setUiPassword(PasswordField pf) {
        this.uiPassword = pf;
    }
    private DropDown uiDeposito = new DropDown();

    public DropDown getUiDeposito() {
        return uiDeposito;
    }

    public void setUiDeposito(DropDown dd) {
        this.uiDeposito = dd;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMUsuarios() {
        uiRolDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("ADMINISTRADOR", "ADMINISTRADOR"), new com.sun.webui.jsf.model.Option("CAJERO", "CAJERO"), new com.sun.webui.jsf.model.Option("VENDEDOR", "VENDEDOR"), new com.sun.webui.jsf.model.Option("PRODUCCION", "PRODUCCION"), new com.sun.webui.jsf.model.Option("SUP_PRODUCCION", "SUP_PRODUCCION"), new com.sun.webui.jsf.model.Option("ADMINISTRACION", "ADMINISTRACION"), new com.sun.webui.jsf.model.Option("COMPRAS", "COMPRAS"), new com.sun.webui.jsf.model.Option("GERENCIA", "GERENCIA")});
        uiRolDefaultOptions.setSelectedValue("ADMINISTRADOR");
    
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

    getSessionBean1().setTituloPagina("Registro de Proveedores");
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
            this.datosUsu.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosUsu.setRendered(true);
            


        } else if (updateRequest) {

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosUsu.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosUsu.setRendered(true);
            cargarCamposUpdate();

        } else if (errorValidacion) {
            
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosUsu.setRendered(true);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosUsu.setRendered(true);


        } else {

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosUsu.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosUsu.setRendered(false);

        }
    buscar_action2();
    }

 public void limpiarCamposNew(){

            this.uiUsuario.setText("");
            this.uiPassword.setText("");
            this.uiRol.setSelected("");
            this.uiActivo.setSelected(false);
         

    }

 private String usuarioEditado = null;

    public String getUsuarioEditado() {
        return usuarioEditado;
    }

    public void setUsuarioEditado(String usuarioEditado) {
        this.usuarioEditado = usuarioEditado;
    }


  public void cargarCamposUpdate(){

         if (getUiTablaProveedoresRW().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getUiTablaProveedoresRW().getSelectedRowKeys();
          Usuarios[] listaUsuarios = getSessionBean1().getListaUsuarios();
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          Usuarios usu = listaUsuarios[rowId];
      

         //// CARGAMOS EN UNA VARIABLE ID EL CODIGO DEL TIPO RECUPERADO DESDE LA GRILLA PARA
          /// LUEGO HACER LA BUSQUEDA DEL OBJETO POR ID
         setUsuarioEditado(usu.getUsuario());


         this.uiUsuario.setText(usu.getUsuario().toString());
         this.uiPassword.setText(usu.getPassword().toString());
         this.uiRol.setSelected(usu.getRol().toString());
         this.uiEmpleado.setSelected(usu.getCodEmpleado().getCodEmpleado().toString());
         this.uiDeposito.setSelected(usu.getCodDeposito().getCodDeposito().toString());

         if (usu.getEstado().toString().equals("A")) {
                 this.uiActivo.setSelected(true);
             }else{
                 this.uiActivo.setSelected(true);
             }


         //// CARGA DE CAMPOS DE LA PAGINA
//         this.uiNombre.setText(proveedor.getNombreProveedor().toString());
//         this.uiRuc.setText(proveedor.getRucProveedor().toString());
//         this.uiDireccion.setText(proveedor.getDireccionProveedor().toString());
//         this.uiContacto.setText(proveedor.getContactoProveedor().toString());
//         this.uiTelefono.setText(proveedor.getTelefono1Proveedor().toString());
//         this.uiTelefono2.setText(proveedor.getTelefono2Proveedor().toString());
//         this.uiMail.setText(proveedor.getMailProveedor().toString());
//         this.uiFechaAlta.setSelectedDate(proveedor.getFechaAlta());

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
        limpiarCamposNew();

        this.buttonGuardarNuevo.setRendered(true);
        this.buttonGuardarEdicion.setRendered(false);

        this.uiUsuario.setDisabled(false);
        this.uiEmpleado.setDisabled(false);


        return null;
    }

    public String editar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.pageAlert1.setRendered(false);
        this.updateRequest=true;
        this.buttonGuardarEdicion.setRendered(true);
        this.buttonGuardarNuevo.setRendered(false);

        this.uiUsuario.setDisabled(true);
        this.uiEmpleado.setDisabled(true);

        return null;

    }

    public String eliminar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        if (getUiTablaProveedoresRW().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getUiTablaProveedoresRW().getSelectedRowKeys();
          Proveedor[] proveedores = getSessionBean1().getListaProveedores();
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          Proveedor proveedor = proveedores[rowId];
          // Remove the Entity from the database using UserController
          ProveedorController proveedorController = new ProveedorController();
          ControllerResult controllerResult = proveedorController.delete(proveedor);

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
        this.errorValidacion=false;

        return null;
    }

    public String buttonGuardarNuevo_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarCampos();

        if (! errorValidacion){

        Usuarios usuario = new Usuarios();
        usuario.setUsuario(this.uiUsuario.getText().toString().toUpperCase());
        usuario.setPassword(this.uiPassword.getText().toString());
        usuario.setRol(this.uiRol.getSelected().toString());
        usuario.setCodDeposito(new DepositoController().findById(Long.valueOf(this.uiDeposito.getSelected().toString())));
        usuario.setCodEmpleado(new EmpleadoController().findById(Long.valueOf(this.uiEmpleado.getSelected().toString())));
            if (uiActivo.isChecked()) {
                usuario.setEstado("A");
            }else{
                usuario.setEstado("I");
            }
            
            
        UsuarioController usuController = new UsuarioController();

        ControllerResult controllerResult = new ControllerResult();
        controllerResult = usuController.create(usuario);


             if (controllerResult.getCodRetorno() ==-1) {
                    this.pageAlert1.setType("error");
                    this.errorValidacion=true;


                } else {
                    this.pageAlert1.setType("information");
                    addRequest = false;
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
    if (this.uiUsuario.getText() == null ||
        this.uiUsuario.getText().toString() == null ||
        this.uiUsuario.getText().toString().equals("")){
           errorValidacion = true;
           this.info(uiUsuario, "El usuario no puede ser nulo");
    }else if(addRequest){
        Usuarios us = null;
        us = new UsuarioController().getUsuario(this.uiUsuario.getText().toString());
        if (us != null) {
            errorValidacion = true;
            this.info(uiUsuario, "Ya existe un usuario con el mismo nombre");
        }else{
            Empleado em = new EmpleadoController().findById(Long.valueOf(this.uiEmpleado.getSelected().toString()));
            List<Usuarios> usus = new UsuarioController().getAllFiltered(null, em.getCodEmpleado().longValue(), null);
            if (addRequest && usus != null && usus.size() >0) {
                    errorValidacion = true;
                    this.info(uiUsuario, "El empleado en cuestion ya tiene usuario asignado");
            }
           }
        }

    if ((this.uiPassword.getText()== null ||
        this.uiPassword.getText().toString() == null ||
        this.uiPassword.getText().toString().equals("")) && addRequest){
           errorValidacion = true;
           this.info(uiUsuario, "El password no puede ser nulo");}
}

    private String buscar_action2() {

        Usuarios[] listaUsuarios;
        UsuarioController usuController = new UsuarioController();

        String pUsuario=null,pRol=null;
        Long pCodEmpleado=null;

        if (this.uiUsuarioFil.getText()!=null) {
            pUsuario = this.uiUsuarioFil.getText().toString();
        }

        if (this.uiRolFil.getText()!=null) {
            pRol = this.uiRolFil.getText().toString();
        }
        if (this.uiEmpleadoFil.getSelected() !=null) {
            pCodEmpleado = Long.valueOf(this.uiEmpleadoFil.getSelected().toString());
        }
     

        listaUsuarios= (Usuarios[])  usuController.getAllFiltered(pUsuario, pCodEmpleado,pRol)
                                        .toArray(new Usuarios[0]);

        getSessionBean1().setListaUsuarios(listaUsuarios);
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
        
        this.uiUsuarioFil.setText("");
        this.uiRolFil.setText("");
        this.uiEmpleadoFil.setSelected(null);
        
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
        // TODO: Replace with your code
//
         updateRequest = true;
         validarCampos();

        if (! errorValidacion){


            Usuarios us = new UsuarioController().getUsuario(usuarioEditado);
            us.setCodDeposito(new DepositoController().findById(Long.valueOf(this.uiDeposito.getSelected().toString())));
            us.setRol(this.uiRol.getSelected().toString());
            if (uiActivo.isChecked()) {
                us.setEstado("A");
            }else{
                us.setEstado("I");
            }

            if (this.uiPassword.getText() != null
                    && !this.uiPassword.getText().toString().equals("")){
                    us.setPassword(this.uiPassword.getText().toString());
            }
            UsuarioController usuController = new UsuarioController();
            ControllerResult controllerResult = new ControllerResult();
            controllerResult = usuController.update(us);
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

    public void uiRolFil_processValueChange(ValueChangeEvent event) {
    }

   ///// FIN CODIGO PARA RADIO BUTTON DE LA GRILLA DE BUSQUEDA

//    public String buttonGuardarEdicion_action() {
//        // TODO: Process the action. Return value is a navigation
//        // case name where null will return to the same page.
//        updateRequest = true;
//         validarCampos();
//
//        if (! errorValidacion){
//

//          TipoProducto tipoProducto = new TipoProductoController().findById(getSessionBean1().getId());
//
//                            tipoProducto.setDescripcion(this.uiTipo.getText().toString());
//
//                            if (this.uiExistChek.isChecked()) {
//                                tipoProducto.setTareas("S");
//                            } else {
//                                tipoProducto.setTareas("N");
//                            }
//
//                            TipoProductoController tipoProductoController = new TipoProductoController();
//
//                            ControllerResult controllerResult = new ControllerResult();
//                            controllerResult = tipoProductoController.update(tipoProducto);
//
//
//                             if (controllerResult.getCodRetorno() ==-1) {
//                                    this.pageAlert1.setType("error");
//                                    this.errorValidacion=true;
//                                } else {
//                                    updateRequest = false;
//                                    this.pageAlert1.setType("information");
//                                }
//
//                                this.pageAlert1.setTitle(controllerResult.getMsg());
//                                this.pageAlert1.setSummary("");
//                                this.pageAlert1.setDetail("");
////                                this.pageAlert1.setRendered(true);
////        }
//
//        return null;
//    }

  



}

