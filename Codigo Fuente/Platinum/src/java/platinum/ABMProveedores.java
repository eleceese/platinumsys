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
import com.sun.webui.jsf.component.TextArea;
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
import py.com.platinum.controller.ProveedorController;
import py.com.platinum.controller.TipoProductoController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Proveedor;
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
public class ABMProveedores extends AbstractPageBean {
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
    private StaticText datosProveedor = new StaticText();

    public StaticText getDatosProveedor() {
        return datosProveedor;
    }

    public void setDatosProveedor(StaticText st) {
        this.datosProveedor = st;
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
    private TextField uiNombreFil = new TextField();

    public TextField getUiNombreFil() {
        return uiNombreFil;
    }

    public void setUiNombreFil(TextField tf) {
        this.uiNombreFil = tf;
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
    private TextField uiRucFil = new TextField();

    public TextField getUiRucFil() {
        return uiRucFil;
    }

    public void setUiRucFil(TextField tf) {
        this.uiRucFil = tf;
    }
    private TextField uiDireccionFil = new TextField();

    public TextField getUiDireccionFil() {
        return uiDireccionFil;
    }

    public void setUiDireccionFil(TextField tf) {
        this.uiDireccionFil = tf;
    }
    private TextField uiNombre = new TextField();

    public TextField getUiNombre() {
        return uiNombre;
    }

    public void setUiNombre(TextField tf) {
        this.uiNombre = tf;
    }
    private TextField uiRuc = new TextField();

    public TextField getUiRuc() {
        return uiRuc;
    }

    public void setUiRuc(TextField tf) {
        this.uiRuc = tf;
    }
    private TextArea uiDireccion = new TextArea();

    public TextArea getUiDireccion() {
        return uiDireccion;
    }

    public void setUiDireccion(TextArea ta) {
        this.uiDireccion = ta;
    }
    private TextField uiTelefono = new TextField();

    public TextField getUiTelefono() {
        return uiTelefono;
    }

    public void setUiTelefono(TextField tf) {
        this.uiTelefono = tf;
    }
    private TextField uiTelefono2 = new TextField();

    public TextField getUiTelefono2() {
        return uiTelefono2;
    }

    public void setUiTelefono2(TextField tf) {
        this.uiTelefono2 = tf;
    }
    private TextField uiContacto = new TextField();

    public TextField getUiContacto() {
        return uiContacto;
    }

    public void setUiContacto(TextField tf) {
        this.uiContacto = tf;
    }
    private TextField uiMail = new TextField();

    public TextField getUiMail() {
        return uiMail;
    }

    public void setUiMail(TextField tf) {
        this.uiMail = tf;
    }
    private TextField uiCiudad1 = new TextField();

    public TextField getUiCiudad1() {
        return uiCiudad1;
    }

    public void setUiCiudad1(TextField tf) {
        this.uiCiudad1 = tf;
    }
    private Calendar uiFechaAlta = new Calendar();

    public Calendar getUiFechaAlta() {
        return uiFechaAlta;
    }

    public void setUiFechaAlta(Calendar c) {
        this.uiFechaAlta = c;
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMProveedores() {
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
         if (getSessionBean1().getUsuarioLogueado() == null)
        {
            HttpServletResponse response = (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
                    try {
                        response.sendRedirect("/Platinum/faces/Acceso.jsp");
                        getFacesContext().responseComplete();
                    } catch (IOException ex) {
                        Logger.getLogger(cabecera.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }else if(!getSessionBean1().getUsuarioLogueado().getRol().toString().equals("SUP_PRODUCCION")
                 &&!getSessionBean1().getUsuarioLogueado().getRol().toString().equals("EMP_PRODUCCION")
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
            this.datosProveedor.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosProveedor.setRendered(true);
            limpiarCamposNew();


        } else if (updateRequest) {

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosProveedor.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosProveedor.setRendered(true);
            cargarCamposUpdate();

        } else if (errorValidacion) {
            
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosProveedor.setRendered(true);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosProveedor.setRendered(true);


        } else {

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosProveedor.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosProveedor.setRendered(false);

        }
    buscar_action2();
    }

 public void limpiarCamposNew(){

            this.uiNombre.setText("");
            this.uiDireccion.setText("");
            this.uiRuc.setText("");
            this.uiContacto.setText("");
            this.uiContacto.setText("");
            this.uiTelefono.setText("");
            this.uiTelefono2.setText("");
            this.uiFechaAlta.setSelectedDate(new Date());
            this.uiMail.setText("");

    }

  public void cargarCamposUpdate(){

         if (getUiTablaProveedoresRW().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getUiTablaProveedoresRW().getSelectedRowKeys();
          Proveedor[] proveedores = getSessionBean1().getListaProveedores();
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          Proveedor proveedor = proveedores[rowId];
      

         //// CARGAMOS EN UNA VARIABLE ID EL CODIGO DEL TIPO RECUPERADO DESDE LA GRILLA PARA
          /// LUEGO HACER LA BUSQUEDA DEL OBJETO POR ID
          getSessionBean1().setId(proveedor.getCodProveedor());
         //// CARGA DE CAMPOS DE LA PAGINA
         this.uiNombre.setText(proveedor.getNombreProveedor().toString());
         this.uiRuc.setText(proveedor.getRucProveedor().toString());
         this.uiDireccion.setText(proveedor.getDireccionProveedor().toString());
         this.uiContacto.setText(proveedor.getContactoProveedor().toString());
         this.uiTelefono.setText(proveedor.getTelefono1Proveedor().toString());
         this.uiTelefono2.setText(proveedor.getTelefono2Proveedor().toString());
         this.uiMail.setText(proveedor.getMailProveedor().toString());
         this.uiFechaAlta.setSelectedDate(proveedor.getFechaAlta());

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
        this.pageAlert1.setRendered(false);
        this.updateRequest=true;
        this.buttonGuardarEdicion.setRendered(true);
        this.buttonGuardarNuevo.setRendered(false);

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

        return null;
    }

    public String buttonGuardarNuevo_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarCampos();

        if (! errorValidacion){
            Proveedor proveedor = new Proveedor();
            proveedor.setNombreProveedor(this.uiNombre.getText().toString());
            proveedor.setRucProveedor(this.uiRuc.getText().toString());
            proveedor.setDireccionProveedor(this.uiDireccion.getText().toString());
            proveedor.setContactoProveedor(this.uiContacto.getText().toString());
            proveedor.setTelefono1Proveedor(this.uiTelefono.getText().toString());
            proveedor.setTelefono2Proveedor(this.uiTelefono2.getText().toString());
            proveedor.setMailProveedor(this.uiMail.getText().toString());
            proveedor.setFechaAlta(this.uiFechaAlta.getSelectedDate());

            
            
            
            ProveedorController proveedorController = new ProveedorController();

            ControllerResult controllerResult = new ControllerResult();
            controllerResult = proveedorController.create(proveedor);


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
    if (this.uiNombre.getText() == null ||
        this.uiNombre.getText().toString() == null ||
        this.uiNombre.getText().toString().equals("")){
           errorValidacion = true;
           this.info(uiNombre, "El nombre no puede ser nulo");}



//            } else if (new TipoProductoController().existe(this.uiTipo.getText().toString()))  {
//                         errorValidacion = true;
//                          this.info(uiTipo, "El tipo de producto ya Existe");
//
   
    if (this.uiRuc.getText() == null ||
        this.uiRuc.getText().toString() == null ||
        this.uiRuc.getText().toString().equals("")){
           errorValidacion = true;
           this.info(uiRuc, "El RUC no puede ser nulo");}

    if (this.uiContacto.getText() == null ||
        this.uiContacto.getText().toString() == null ||
        this.uiContacto.getText().toString().equals("")){
           errorValidacion = true;
           this.info(uiContacto, "El Contacto no puede ser nulo");}


    if (this.uiTelefono.getText() == null ||
        this.uiTelefono.getText().toString() == null ||
        this.uiTelefono.getText().toString().equals("")){
           errorValidacion = true;
           this.info(uiTelefono, "El Telefono no puede ser nulo");}

}

    private String buscar_action2() {

        Proveedor[] listaProveedores;
        ProveedorController proveedorController = new ProveedorController();

        String pNombre=null,pRuc=null, pDireccion=null;

        if (this.uiNombreFil.getText()!=null) {
            pNombre = this.uiNombreFil.getText().toString();
        }

        if (this.uiRucFil.getText()!=null) {
            pRuc = this.uiRucFil.getText().toString();
        }
        if (this.uiDireccionFil.getText()!=null) {
            pDireccion = this.uiDireccionFil.getText().toString();
        }

        listaProveedores = (Proveedor[])  proveedorController.getAllFiltered
                                        (pNombre,
                                         pRuc,
                                         pDireccion).toArray(new Proveedor[0]);

        getSessionBean1().setListaProveedores(listaProveedores);
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
        
        this.uiNombreFil.setText("");
        this.uiRucFil.setText("");
        this.uiDireccionFil.setText("");

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

         updateRequest = true;
         validarCampos();

        if (! errorValidacion){


          Proveedor proveedor = new ProveedorController().findById(getSessionBean1().getId());

                            proveedor.setNombreProveedor(this.uiNombre.getText().toString());
                            proveedor.setRucProveedor(this.uiRuc.getText().toString());
                            proveedor.setContactoProveedor(this.uiContacto.getText().toString());
                            proveedor.setTelefono1Proveedor(this.uiTelefono.getText().toString());
                            proveedor.setTelefono2Proveedor(this.uiTelefono2.getText().toString());
                            proveedor.setDireccionProveedor(this.uiDireccion.getText().toString());
                            proveedor.setMailProveedor(this.uiMail.getText().toString());
                            proveedor.setFechaAlta(this.uiFechaAlta.getSelectedDate());



                            ProveedorController proveedorController = new ProveedorController();

                            ControllerResult controllerResult = new ControllerResult();
                            controllerResult = proveedorController.update(proveedor);


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

