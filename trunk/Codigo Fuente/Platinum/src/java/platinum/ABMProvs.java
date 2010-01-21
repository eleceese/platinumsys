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
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Date;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.ValueChangeEvent;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.ProveedorController;
import py.com.platinum.entity.Proveedor;






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
public class ABMProvs extends AbstractPageBean {
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
    private StaticText datosProveedores = new StaticText();

    public StaticText getDatosProveedores() {
        return datosProveedores;
    }

    public void setDatosProveedores(StaticText st) {
        this.datosProveedores = st;
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
    private Button button3 = new Button();

    public Button getButton3() {
        return button3;
    }

    public void setButton3(Button b) {
        this.button3 = b;
    }
    private Button button2 = new Button();

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button b) {
        this.button2 = b;
    }
    private TextField uiNombre = new TextField();

    public TextField getUiNombre() {
        return uiNombre;
    }

    public void setUiNombre(TextField tf) {
        this.uiNombre = tf;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private TextField uiRuc = new TextField();

    public TextField getUiRuc() {
        return uiRuc;
    }

    public void setUiRuc(TextField tf) {
        this.uiRuc = tf;
    }
    private TextField uiNombreFil = new TextField();

    public TextField getUiNombreFil() {
        return uiNombreFil;
    }

    public void setUiNombreFil(TextField tf) {
        this.uiNombreFil = tf;
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
    private TextField uiContacto2 = new TextField();

    public TextField getUiContacto2() {
        return uiContacto2;
    }

    public void setUiContacto2(TextField tf) {
        this.uiContacto2 = tf;
    }
    private TextField uiMail = new TextField();

    public TextField getUiMail() {
        return uiMail;
    }

    public void setUiMail(TextField tf) {
        this.uiMail = tf;
    }
    private TextField uiCiudadFil = new TextField();

    public TextField getUiCiudadFil() {
        return uiCiudadFil;
    }

    public void setUiCiudadFil(TextField tf) {
        this.uiCiudadFil = tf;
    }
    private Calendar uiFechaAlta = new Calendar();

    public Calendar getUiFechaAlta() {
        return uiFechaAlta;
    }

    public void setUiFechaAlta(Calendar c) {
        this.uiFechaAlta = c;
    }
    private TableRowGroup proveedoresRW = new TableRowGroup();

    public TableRowGroup getProveedoresRW() {
        return proveedoresRW;
    }

    public void setProveedoresRW(TableRowGroup trg) {
        this.proveedoresRW = trg;
    }
    private TableColumn tableColumn6 = new TableColumn();

    public TableColumn getTableColumn6() {
        return tableColumn6;
    }

    public void setTableColumn6(TableColumn tc) {
        this.tableColumn6 = tc;
    }
    private TextArea uiDireccion1 = new TextArea();

    public TextArea getUiDireccion1() {
        return uiDireccion1;
    }

    public void setUiDireccion1(TextArea ta) {
        this.uiDireccion1 = ta;
    }
    private TextField uiTelefono1 = new TextField();

    public TextField getUiTelefono1() {
        return uiTelefono1;
    }

    public void setUiTelefono1(TextField tf) {
        this.uiTelefono1 = tf;
    }
    private TextField uiTelefono3 = new TextField();

    public TextField getUiTelefono3() {
        return uiTelefono3;
    }

    public void setUiTelefono3(TextField tf) {
        this.uiTelefono3 = tf;
    }
    private TextField uiContactoProv1 = new TextField();

    public TextField getUiContactoProv1() {
        return uiContactoProv1;
    }

    public void setUiContactoProv1(TextField tf) {
        this.uiContactoProv1 = tf;
    }
    private TextField uiMail2 = new TextField();

    public TextField getUiMail2() {
        return uiMail2;
    }

    public void setUiMail2(TextField tf) {
        this.uiMail2 = tf;
    }
    private TextField uiCiudad = new TextField();

    public TextField getUiCiudad() {
        return uiCiudad;
    }

    public void setUiCiudad(TextField tf) {
        this.uiCiudad = tf;
    }
    private Calendar uiFechaAlta1 = new Calendar();

    public Calendar getUiFechaAlta1() {
        return uiFechaAlta1;
    }

    public void setUiFechaAlta1(Calendar c) {
        this.uiFechaAlta1 = c;
    }
    private TextField uiNombre1 = new TextField();

    public TextField getUiNombre1() {
        return uiNombre1;
    }

    public void setUiNombre1(TextField tf) {
        this.uiNombre1 = tf;
    }
    private TextField uiRuc1 = new TextField();

    public TextField getUiRuc1() {
        return uiRuc1;
    }

    public void setUiRuc1(TextField tf) {
        this.uiRuc1 = tf;
    }
    private Label labelNombreFil = new Label();

    public Label getLabelNombreFil() {
        return labelNombreFil;
    }

    public void setLabelNombreFil(Label l) {
        this.labelNombreFil = l;
    }
    private Label labelRucFil = new Label();

    public Label getLabelRucFil() {
        return labelRucFil;
    }

    public void setLabelRucFil(Label l) {
        this.labelRucFil = l;
    }
    private Label labelCiudadFil = new Label();

    public Label getLabelCiudadFil() {
        return labelCiudadFil;
    }

    public void setLabelCiudadFil(Label l) {
        this.labelCiudadFil = l;
    }
    private TableColumn columnaDelRadio = new TableColumn();

    public TableColumn getColumnaDelRadio() {
        return columnaDelRadio;
    }

    public void setColumnaDelRadio(TableColumn tc) {
        this.columnaDelRadio = tc;
    }
    private Table uiProveedores = new Table();

    public Table getUiProveedores() {
        return uiProveedores;
    }

    public void setUiProveedores(Table t) {
        this.uiProveedores = t;
    }
    private RadioButton radioSeleccionado = new RadioButton();

    public RadioButton getRadioSeleccionado() {
        return radioSeleccionado;
    }

    public void setRadioSeleccionado(RadioButton rb) {
        this.radioSeleccionado = rb;
    }
    

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMProvs() {
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
            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosProveedores.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosProveedores.setRendered(true);
            limpiarCamposNew();

        } else if (updateRequest) {

            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosProveedores.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosProveedores.setRendered(true);
            cargarCamposUpdate();

        } else if (errorValidacion) {
            
            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosProveedores.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosProveedores.setRendered(true);


        } else {
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosProveedores.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosProveedores.setRendered(false);

        }
buscar_action2();
    }

    public String buscar_action2() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        Proveedor[] listaProveedores;
        ProveedorController proveedorController = new ProveedorController();

        String pNombre=null, pRuc=null, pDireccion=null;

        if (this.uiNombreFil.getText()!=null) {
            pNombre = this.uiNombreFil.getText().toString();
        }

        if (this.uiRuc.getText()!=null) {
            pRuc = this.uiRucFil.getText().toString();
        }

        if (this.uiDireccionFil.getText()!=null) {
            pDireccion = this.uiDireccionFil.getText().toString();
        }

        listaProveedores = (Proveedor[])  proveedorController.getAllFiltered(
                                            pNombre,
                                            pRuc,
                                            pDireccion).toArray(new Proveedor[0]);

        getSessionBean1().setListaProveedores(listaProveedores);

        return null;
    }

    public String buscar_action() {
        this.pageAlert1.setRendered(false);
        return buscar_action2();
    }
    public void limpiarCamposNew(){

            this.uiNombre.setText("");
            this.uiDireccion.setText("");
            this.uiRuc.setText("");
            this.uiContacto.setText("");
            this.uiContacto2.setText("");
            this.uiTelefono.setText("");
            this.uiTelefono2.setText("");
            this.uiFechaAlta.setSelectedDate(new Date());
            this.uiMail.setText("");

    }


    public void cargarCamposUpdate(){
         if (getProveedoresRW().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getProveedoresRW().getSelectedRowKeys();
          Proveedor[] proveedores = getSessionBean1().getListaProveedores();
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          Proveedor proveedor = proveedores[rowId];

          getSessionBean1().setId(proveedor.getCodProveedor());
         //// CARGA DE CAMPOS DE LA PAGINA

         this.uiNombre1.setText(proveedor.getNombreProveedor().toString());
         this.uiRuc1.setText(proveedor.getRucProveedor().toString());
         this.uiDireccion1.setText(proveedor.getDireccionProveedor().toString());
         this.uiContactoProv1.setText(proveedor.getContactoProveedor().toString());
         this.uiTelefono1.setText(proveedor.getTelefono1Proveedor().toString());
         this.uiTelefono3.setText(proveedor.getTelefono2Proveedor().toString());
         this.uiMail2.setText(proveedor.getMailProveedor().toString());
         this.uiFechaAlta1.setSelectedDate(proveedor.getFechaAlta());
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
        this.button2.setRendered(true);
        this.button3.setRendered(false);
        return null;
    }

    public String editar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.updateRequest=true;
        this.button3.setRendered(true);
        this.button2.setRendered(false);
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

        return null;
    }

    public String button2_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequest=false;
        this.updateRequest=false;

        info(this.uiNombre, "Favor ingresar Nombre, Campo Obligatorio");
        info(this.uiRuc, "Favor ingresar Nombre, Campo Obligatorio");

        this.errorValidacion=true;
                      

            this.pageAlert1.setType("error");
            this.pageAlert1.setTitle("Error en la Validacion de los Campos, favor verificar y volver a intentar");
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);


        return null;
    }

}

