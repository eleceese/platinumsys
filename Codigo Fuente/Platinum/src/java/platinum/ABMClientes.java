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
import com.sun.webui.jsf.component.RadioButtonGroup;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.CiudadController;
import py.com.platinum.controller.ClienteController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Ciudad;
import py.com.platinum.entity.Cliente;

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
public class ABMClientes extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        uiLstSexoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("M", "Masculino"), new com.sun.webui.jsf.model.Option("F", "Femenino"), new com.sun.webui.jsf.model.Option("", "")});
        uiLstTipoDocDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("CI", "Cedula de Identidad"), new com.sun.webui.jsf.model.Option("DNI", "DNI"), new com.sun.webui.jsf.model.Option("PAS", "Pasaporte")});
        uiLstEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("A", "Activo"), new com.sun.webui.jsf.model.Option("I", "Inactivo")});
        uiLstEstadoDefaultOptions.setSelectedValue("A");
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
    private StaticText datosClientes = new StaticText();

    public StaticText getDatosClientes() {
        return datosClientes;
    }

    public void setDatosClientes(StaticText st) {
        this.datosClientes = st;
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
    private SingleSelectOptionsList uiLstSexoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiLstSexoDefaultOptions() {
        return uiLstSexoDefaultOptions;
    }

    public void setUiLstSexoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiLstSexoDefaultOptions = ssol;
    }
    private Button uiBtnGuardarEditar = new Button();

    public Button getUiBtnGuardarEditar() {
        return uiBtnGuardarEditar;
    }

    public void setUiBtnGuardarEditar(Button b) {
        this.uiBtnGuardarEditar = b;
    }
    private Button uiBtnGuardarNuevo = new Button();

    public Button getUiBtnGuardarNuevo() {
        return uiBtnGuardarNuevo;
    }

    public void setUiBtnGuardarNuevo(Button b) {
        this.uiBtnGuardarNuevo = b;
    }
    private TextField uiTxtNombre = new TextField();

    public TextField getUiTxtNombre() {
        return uiTxtNombre;
    }

    public void setUiTxtNombre(TextField tf) {
        this.uiTxtNombre = tf;
    }
    private TextField uiTxtApellido = new TextField();

    public TextField getUiTxtApellido() {
        return uiTxtApellido;
    }

    public void setUiTxtApellido(TextField tf) {
        this.uiTxtApellido = tf;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private TextField uiTxtDocumento = new TextField();

    public TextField getUiTxtDocumento() {
        return uiTxtDocumento;
    }

    public void setUiTxtDocumento(TextField tf) {
        this.uiTxtDocumento = tf;
    }
    private SingleSelectOptionsList uiLstTipoDocDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiLstTipoDocDefaultOptions() {
        return uiLstTipoDocDefaultOptions;
    }

    public void setUiLstTipoDocDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiLstTipoDocDefaultOptions = ssol;
    }
    private DropDown uiLstTipoDoc = new DropDown();

    public DropDown getUiLstTipoDoc() {
        return uiLstTipoDoc;
    }

    public void setUiLstTipoDoc(DropDown dd) {
        this.uiLstTipoDoc = dd;
    }
    private TextField uiTxtFilNombre = new TextField();

    public TextField getUiTxtFilNombre() {
        return uiTxtFilNombre;
    }

    public void setUiTxtFilNombre(TextField tf) {
        this.uiTxtFilNombre = tf;
    }
    private TextField uiTxtFilApellido = new TextField();

    public TextField getUiTxtFilApellido() {
        return uiTxtFilApellido;
    }

    public void setUiTxtFilApellido(TextField tf) {
        this.uiTxtFilApellido = tf;
    }
    private TextField uiTxtFilRUC = new TextField();

    public TextField getUiTxtFilRUC() {
        return uiTxtFilRUC;
    }

    public void setUiTxtFilRUC(TextField tf) {
        this.uiTxtFilRUC = tf;
    }
    private Table table1 = new Table();

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table t) {
        this.table1 = t;
    }
    private TableColumn tableColumn5 = new TableColumn();

    public TableColumn getTableColumn5() {
        return tableColumn5;
    }

    public void setTableColumn5(TableColumn tc) {
        this.tableColumn5 = tc;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private DropDown uiLstSexo = new DropDown();

    public DropDown getUiLstSexo() {
        return uiLstSexo;
    }

    public void setUiLstSexo(DropDown dd) {
        this.uiLstSexo = dd;
    }
    private TextField uiTxtNroRuc = new TextField();

    public TextField getUiTxtNroRuc() {
        return uiTxtNroRuc;
    }

    public void setUiTxtNroRuc(TextField tf) {
        this.uiTxtNroRuc = tf;
    }
    private TextArea uiTxtDireccion = new TextArea();

    public TextArea getUiTxtDireccion() {
        return uiTxtDireccion;
    }

    public void setUiTxtDireccion(TextArea ta) {
        this.uiTxtDireccion = ta;
    }
    private TextField uiTxtTelefono1 = new TextField();

    public TextField getUiTxtTelefono1() {
        return uiTxtTelefono1;
    }

    public void setUiTxtTelefono1(TextField tf) {
        this.uiTxtTelefono1 = tf;
    }
    private TextField uiTxtTelefono2 = new TextField();

    public TextField getUiTxtTelefono2() {
        return uiTxtTelefono2;
    }

    public void setUiTxtTelefono2(TextField tf) {
        this.uiTxtTelefono2 = tf;
    }
    private TextField uiTxtMail = new TextField();

    public TextField getUiTxtMail() {
        return uiTxtMail;
    }

    public void setUiTxtMail(TextField tf) {
        this.uiTxtMail = tf;
    }
    private TextField uiTxtContacto1 = new TextField();

    public TextField getUiTxtContacto1() {
        return uiTxtContacto1;
    }

    public void setUiTxtContacto1(TextField tf) {
        this.uiTxtContacto1 = tf;
    }
    private TextField uiTxtContacto2 = new TextField();

    public TextField getUiTxtContacto2() {
        return uiTxtContacto2;
    }

    public void setUiTxtContacto2(TextField tf) {
        this.uiTxtContacto2 = tf;
    }
    private SingleSelectOptionsList uiLstEstadoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiLstEstadoDefaultOptions() {
        return uiLstEstadoDefaultOptions;
    }

    public void setUiLstEstadoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiLstEstadoDefaultOptions = ssol;
    }
    private RadioButtonGroup uiLstEstado = new RadioButtonGroup();

    public RadioButtonGroup getUiLstEstado() {
        return uiLstEstado;
    }

    public void setUiLstEstado(RadioButtonGroup rbg) {
        this.uiLstEstado = rbg;
    }
    private HtmlPanelGrid gridPanelBtnBuscar = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBtnBuscar() {
        return gridPanelBtnBuscar;
    }

    public void setGridPanelBtnBuscar(HtmlPanelGrid hpg) {
        this.gridPanelBtnBuscar = hpg;
    }
    private DropDown uiLstCiudad = new DropDown();

    public DropDown getUiLstCiudad() {
        return uiLstCiudad;
    }

    public void setUiLstCiudad(DropDown dd) {
        this.uiLstCiudad = dd;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMClientes() {
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

        getSessionBean1().setTituloPagina("Registro de Clientes");
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
            this.datosClientes.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosClientes.setRendered(true);
            this.gridPanelBtnBuscar.setRendered(false);
            this.limpiarCampos();
        } else if (updateRequest) {
            cargarCampos();
            this.gridPanelBtnBuscar.setRendered(false);
            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosClientes.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosClientes.setRendered(true);
        } else if (errorValidacion) {
            this.gridPanelBtnBuscar.setRendered(false);
            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosClientes.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosClientes.setRendered(true);
        } else {
            this.gridPanelBtnBuscar.setRendered(true);
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosClientes.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosClientes.setRendered(false);
        }

        //Actualizamos la lista
        buscar();
    }

    /**
     * Limpiar campos
     */
    private void limpiarCampos() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Ceramos los campos
        uiTxtApellido.setText(null);
        uiTxtContacto1.setText(null);
        uiTxtContacto2.setText(null);
        uiTxtDireccion.setText(null);
        uiTxtDocumento.setText(null);
        uiTxtMail.setText(null);
        uiTxtNombre.setText(null);
        uiTxtNroRuc.setText(null);
        uiTxtTelefono1.setText(null);
        uiTxtTelefono2.setText(null);
    }

    /**
     * Cargar campos, para la edicion del registro seleccionado
     */
    private void cargarCampos() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);
        
        //Obtenemos el registro seleccionado por medio
        //del id almacenado en la session
        Cliente e = new ClienteController().findById(getSessionBean1().getId());

        //Cargamos de los artributos
        uiTxtNombre.setText(e.getNombreCliente());
        uiTxtApellido.setText(e.getApellidoCliente());
        uiLstCiudad.setSelected(e.getCodCiudad());
        uiTxtContacto1.setText(e.getContacto1Cliente());
        uiTxtContacto2.setText(e.getContacto2Cliente());
        uiTxtDireccion.setText(e.getDireccionCliente());
        uiLstTipoDoc.setSelected(e.getTipoDodCliente());
        uiTxtDocumento.setText(e.getNumeroDocCliente());
        uiTxtMail.setText(e.getMailCliente());
        uiTxtNroRuc.setText(e.getRucCliente());
        uiLstEstado.setSelected(e.getEstadoCliente());
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
        this.addRequest = true;
        this.uiBtnGuardarNuevo.setRendered(true);
        this.uiBtnGuardarEditar.setRendered(false);
        return null;
    }

    public String editar_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
            //Obtenemos la lista de
            Cliente[] l = getSessionBean1().getListaCliente();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            Cliente e = l[rowId];

            //Guardamos el id del Cliente en la session
            getSessionBean1().setId(e.getCodCliente());
        }
        this.updateRequest = true;
        this.uiBtnGuardarEditar.setRendered(true);
        this.uiBtnGuardarNuevo.setRendered(false);

        //Result
        return null;
    }

    public String eliminar_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        // Si la cantidad de registros en la grilla es mayor a 0
        // Eliminamos el elemento seleccionado
        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
            //Obtenemos la lista de
            Cliente[] l = getSessionBean1().getListaCliente();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            Cliente e = l[rowId];

            //Eliminados el registro
            ClienteController controller = new ClienteController();
            ControllerResult r = controller.delete(e);

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

    public String uiBtnCancelar_action() {
        this.addRequest = false;
        this.updateRequest = false;

        //Result
        return null;
    }

    public String uiBtnGuardarNuevo_action() {
        // Apagamos la bandera de nuevo registro
        this.addRequest = false;

        //Validamos los campos
        codCliente = null;
        validarCampos();
        Cliente r;

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Nuevo
            r = new Cliente();

            //Set de los artributos
            r.setNombreCliente((String) uiTxtNombre.getText());
            r.setApellidoCliente((String) uiTxtApellido.getText());

            //Obtenemos la ciudad
            Ciudad ciudad = new CiudadController().findById(Long.valueOf(uiLstCiudad.getSelected().toString()));
            r.setCodCiudad(ciudad);

            r.setContacto1Cliente((String) uiTxtContacto1.getText());

            if (uiTxtContacto2.getText() != null) {
                r.setContacto2Cliente((String) uiTxtContacto2.getText());
            }

            r.setDireccionCliente((String) uiTxtDireccion.getText());
            r.setTipoDodCliente(uiLstTipoDoc.getSelected().toString());
            r.setNumeroDocCliente((String) uiTxtDocumento.getText());

            if (uiTxtMail.getText() != null) {
                r.setMailCliente((String) uiTxtMail.getText());
            }

            r.setRucCliente(uiTxtNroRuc.getText().toString());

            r.setEstadoCliente(uiLstEstado.getSelected().toString());

            //Insertamos el nuevo registro
            ControllerResult cr = new ClienteController().create(r);

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

        //apellido
        if (this.uiTxtApellido.getText() == null || this.uiTxtApellido.getText().equals("")) {
            info(uiTxtApellido, "Campo Apellido obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //nombre
        if (this.uiTxtNombre.getText() == null || this.uiTxtNombre.getText().equals("")) {
            info(uiTxtNombre, "Campo Nombre obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Documento
        if (this.uiTxtDocumento.getText() == null || this.uiTxtDocumento.getText().equals("")) {
            info(uiTxtDocumento, "Campo Nro. Documento obligatorio, ingrese un valor");
            errorValidacion = true;
        }else if(new ClienteController().existeDocumento(this.uiLstTipoDoc.getSelected().toString(), this.uiTxtDocumento.getText().toString(), codCliente)){
            info(uiTxtDocumento, "Nro. Documento Ya Existe para otro Clietne, ingrese un Documento que no se repita");
            errorValidacion = true;
        }

        //RUC
        if (this.uiTxtNroRuc.getText() == null || this.uiTxtNroRuc.getText().equals("")) {
            info(uiTxtNroRuc, "Campo Nro. RUC obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Direccion
        if (this.uiTxtDireccion.getText() == null || this.uiTxtDireccion.getText().equals("")) {
            info(uiTxtDireccion, "Campo Direccion obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Telefono 1
        if (this.uiTxtTelefono1.getText() == null || this.uiTxtTelefono1.getText().equals("")) {
            info(uiTxtTelefono1, "Campo Direccion obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Contacto 1
        if (this.uiTxtContacto1.getText() == null || this.uiTxtContacto1.getText().equals("")) {
            info(uiTxtContacto1, "Campo Contacto obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Ciudad
        if (this.uiLstCiudad.getSelected() == null || uiLstCiudad.getSelected().toString().equals("")) {
            info(uiLstCiudad, "Campo Ciudad obligatorio, ingrese un valor");
            errorValidacion = true;
        }

    }

    public String uiBtnBuscar_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Realizamos la busqueda
        buscar();

        //Result
        return null;
    }

    /**
     * Buscar los registros que cumplan con la condicion/s de busqueda
     * y actualizar la lista de la session
     */
    public void buscar() {
        //Verificamos el contenido de los campos de busqueda
        ClienteController c = new ClienteController();
        String pApellido = null, pNombre = null, pRUC = null;

        //Apellido
        if (this.uiTxtFilApellido.getText() != null) {
            pApellido = this.uiTxtFilApellido.getText().toString();
        }

        //Nombre
        if (this.uiTxtFilNombre.getText() != null) {
            pNombre = this.uiTxtFilNombre.getText().toString();
        }

        //Ruc
        if (this.uiTxtFilRUC.getText() != null) {
            pRUC = this.uiTxtFilRUC.getText().toString();
        }

        //Buscamos la lista de registros
        Cliente[] l = (Cliente[]) c.getClientes(pApellido, pNombre, pRUC).toArray(new Cliente[0]);

        //Actualizamos la lista de empleados de la session
        getSessionBean1().setListaCliente(l);
    }

    public String uiBtnTodos_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Ceramos los campos de busqueda
        this.uiTxtFilApellido.setText(null);
        this.uiTxtFilNombre.setText(null);
        this.uiTxtFilRUC.setText(null);

        //Realizamos la busuqueda
        buscar();

        //Result
        return null;
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

    private Long codCliente;

    public String uiBtnGuardarEditar_action() {
        // Apagamos la bandera de nuevo registro
        this.updateRequest = false;

        //Obtenemos el registro seleccionado por medio
        //del id almacenado en la session
        Cliente r = new ClienteController().findById(getSessionBean1().getId());

        //Seteamos el codigo del cliente que esta siendo editado
        codCliente = r.getCodCliente();

        //Validamos los campos
        validarCampos();

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Set de los artributos

            //Set de los artributos
            r.setNombreCliente((String) uiTxtNombre.getText());
            r.setApellidoCliente((String) uiTxtApellido.getText());

            //Ciudad
            Ciudad ciudad = new CiudadController().findById(Long.valueOf(uiLstCiudad.getSelected().toString()));
            r.setCodCiudad(ciudad);
            r.setContacto1Cliente((String) uiTxtContacto1.getText());

            if (uiTxtContacto2.getText() != null) {
                r.setContacto2Cliente((String) uiTxtContacto2.getText());
            }

            r.setDireccionCliente((String) uiTxtDireccion.getText());
            r.setTipoDodCliente(uiLstTipoDoc.getSelected().toString());
            r.setNumeroDocCliente((String) uiTxtDocumento.getText());

            if (uiTxtMail.getText() != null) {
                r.setMailCliente((String) uiTxtMail.getText());
            }

            r.setRucCliente(uiTxtNroRuc.getText().toString());

            r.setEstadoCliente(uiLstEstado.getSelected().toString());

            //Insertamos el nuevo registro
            ControllerResult cr = new ClienteController().update(r);

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

        return null;
    }
}

