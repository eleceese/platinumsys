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
import java.math.BigInteger;
import java.util.Date;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.convert.BigIntegerConverter;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.CargoController;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.SeccionController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Cargo;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.Seccion;
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
public class ABMEmpleados extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        uiLstSexoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("M", "Masculino"), new com.sun.webui.jsf.model.Option("F", "Femenino")});
        uiRadEstadoCivilDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("S", "Soltero"), new com.sun.webui.jsf.model.Option("C", "Casado"), new com.sun.webui.jsf.model.Option("D", "Divorciado"), new com.sun.webui.jsf.model.Option("V", "Viudo")});
        uiRadEstadoCivilDefaultOptions.setSelectedValue("S");
        uiRadTipoEmpleadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("F", "Funcionario"), new com.sun.webui.jsf.model.Option("V", "Vendedor"), new com.sun.webui.jsf.model.Option("C", "Cobrador")});
        uiRadTipoEmpleadoDefaultOptions.setSelectedValue("F");
        uiLstEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("A", "Activo"), new com.sun.webui.jsf.model.Option("I", "Inactivo")});
        uiLstEstadoDefaultOptions.setSelectedValue("A");
        uiLstSexoDefaultOptions.setSelectedValue("M");
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
    private StaticText datosEmpleado1 = new StaticText();

    public StaticText getDatosEmpleado1() {
        return datosEmpleado1;
    }

    public void setDatosEmpleado1(StaticText st) {
        this.datosEmpleado1 = st;
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
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TableColumn tableColumn4 = new TableColumn();

    public TableColumn getTableColumn4() {
        return tableColumn4;
    }

    public void setTableColumn4(TableColumn tc) {
        this.tableColumn4 = tc;
    }
    private TextField uiTxtNroCedula = new TextField();

    public TextField getUiTxtNroCedula() {
        return uiTxtNroCedula;
    }

    public void setUiTxtNroCedula(TextField tf) {
        this.uiTxtNroCedula = tf;
    }
    private DropDown uiLstSexo = new DropDown();

    public DropDown getUiLstSexo() {
        return uiLstSexo;
    }

    public void setUiLstSexo(DropDown dd) {
        this.uiLstSexo = dd;
    }
    private TextField uiTxtSalario = new TextField();

    public TextField getUiTxtSalario() {
        return uiTxtSalario;
    }

    public void setUiTxtSalario(TextField tf) {
        this.uiTxtSalario = tf;
    }
    private TextField uiTxtCantHijos = new TextField();

    public TextField getUiTxtCantHijos() {
        return uiTxtCantHijos;
    }

    public void setUiTxtCantHijos(TextField tf) {
        this.uiTxtCantHijos = tf;
    }
    private TextField uiTxtNroIPS = new TextField();

    public TextField getUiTxtNroIPS() {
        return uiTxtNroIPS;
    }

    public void setUiTxtNroIPS(TextField tf) {
        this.uiTxtNroIPS = tf;
    }
    private TextField uiTxtMail = new TextField();

    public TextField getUiTxtMail() {
        return uiTxtMail;
    }

    public void setUiTxtMail(TextField tf) {
        this.uiTxtMail = tf;
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
    private TextField uiTxtFilCedula = new TextField();

    public TextField getUiTxtFilCedula() {
        return uiTxtFilCedula;
    }

    public void setUiTxtFilCedula(TextField tf) {
        this.uiTxtFilCedula = tf;
    }
    private TextField uiTxtNacionalidad = new TextField();

    public TextField getUiTxtNacionalidad() {
        return uiTxtNacionalidad;
    }

    public void setUiTxtNacionalidad(TextField tf) {
        this.uiTxtNacionalidad = tf;
    }
    private Calendar uiCalFechaNacimiento = new Calendar();

    public Calendar getUiCalFechaNacimiento() {
        return uiCalFechaNacimiento;
    }

    public void setUiCalFechaNacimiento(Calendar c) {
        this.uiCalFechaNacimiento = c;
    }
    private TextArea uiTxtDireccion = new TextArea();

    public TextArea getUiTxtDireccion() {
        return uiTxtDireccion;
    }

    public void setUiTxtDireccion(TextArea ta) {
        this.uiTxtDireccion = ta;
    }
    private SingleSelectOptionsList uiRadEstadoCivilDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiRadEstadoCivilDefaultOptions() {
        return uiRadEstadoCivilDefaultOptions;
    }

    public void setUiRadEstadoCivilDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiRadEstadoCivilDefaultOptions = ssol;
    }
    private SingleSelectOptionsList uiRadTipoEmpleadoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiRadTipoEmpleadoDefaultOptions() {
        return uiRadTipoEmpleadoDefaultOptions;
    }

    public void setUiRadTipoEmpleadoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiRadTipoEmpleadoDefaultOptions = ssol;
    }
    private SingleSelectOptionsList uiLstEstadoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiLstEstadoDefaultOptions() {
        return uiLstEstadoDefaultOptions;
    }

    public void setUiLstEstadoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiLstEstadoDefaultOptions = ssol;
    }
    private BigIntegerConverter bigIntegerConverter1 = new BigIntegerConverter();

    public BigIntegerConverter getBigIntegerConverter1() {
        return bigIntegerConverter1;
    }

    public void setBigIntegerConverter1(BigIntegerConverter bic) {
        this.bigIntegerConverter1 = bic;
    }
    private BigIntegerConverter bigIntegerConverter2 = new BigIntegerConverter();

    public BigIntegerConverter getBigIntegerConverter2() {
        return bigIntegerConverter2;
    }

    public void setBigIntegerConverter2(BigIntegerConverter bic) {
        this.bigIntegerConverter2 = bic;
    }
    private DropDown uiLstCargo = new DropDown();

    public DropDown getUiLstCargo() {
        return uiLstCargo;
    }

    public void setUiLstCargo(DropDown dd) {
        this.uiLstCargo = dd;
    }
    private DropDown uiLstSeccion = new DropDown();

    public DropDown getUiLstSeccion() {
        return uiLstSeccion;
    }

    public void setUiLstSeccion(DropDown dd) {
        this.uiLstSeccion = dd;
    }
    private RadioButtonGroup uiRadTipoEmpleado = new RadioButtonGroup();

    public RadioButtonGroup getUiRadTipoEmpleado() {
        return uiRadTipoEmpleado;
    }

    public void setUiRadTipoEmpleado(RadioButtonGroup rbg) {
        this.uiRadTipoEmpleado = rbg;
    }
    private RadioButtonGroup uiRadEstadoCivil = new RadioButtonGroup();

    public RadioButtonGroup getUiRadEstadoCivil() {
        return uiRadEstadoCivil;
    }

    public void setUiRadEstadoCivil(RadioButtonGroup rbg) {
        this.uiRadEstadoCivil = rbg;
    }
    private DropDown uiLstEstado = new DropDown();

    public DropDown getUiLstEstado() {
        return uiLstEstado;
    }

    public void setUiLstEstado(DropDown dd) {
        this.uiLstEstado = dd;
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
    private TextField uiTxtCostoHoraProd = new TextField();

    public TextField getUiTxtCostoHoraProd() {
        return uiTxtCostoHoraProd;
    }

    public void setUiTxtCostoHoraProd(TextField tf) {
        this.uiTxtCostoHoraProd = tf;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMEmpleados() {
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

        getSessionBean1().setTituloPagina("Registro de Empleados");
        getSessionBean1().setDetallePagina("Seleccione los datos");


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

        //Nuevo Registro
        if (addRequest) {
            limpiarCampos();
            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosEmpleado1.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosEmpleado1.setRendered(true);
        //Editar un registro
        } else if (updateRequest) {
            cargarCampos();
            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosEmpleado1.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosEmpleado1.setRendered(true);
        //Error detectado
        } else if (errorValidacion) {
            this.gridPanelTabla.setRendered(false);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosEmpleado1.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosEmpleado1.setRendered(true);
        //Motrar grilla
        } else {
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosEmpleado1.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosEmpleado1.setRendered(false);
        }

        //Actualizamos la lista
        buscar();
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

    public String nuevo_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

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
            Empleado[] l = getSessionBean1().getListaEmpleados();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            Empleado e = l[rowId];

            //Guardamos el id del empleado en la session
            getSessionBean1().setId(e.getCodEmpleado());
        }


        this.updateRequest = true;
        this.uiBtnGuardarEditar.setRendered(true);
        this.uiBtnGuardarNuevo.setRendered(false);
        return null;

    }

    /**
     * Eliminar elemento seleccionado de la lista
     * 
     * @return
     */
    public String eliminar_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        // Si la cantidad de registros en la grilla es mayor a 0
        // Eliminamos el elemento seleccionado
        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
            //Obtenemos la lista de
            Empleado[] l = getSessionBean1().getListaEmpleados();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            Empleado e = l[rowId];

            //Eliminados el registro
            EmpleadoController controller = new EmpleadoController();
            ControllerResult r = controller.delete(e);

            //Mensaje
            if (r.getCodRetorno() == -1) {
                this.pageAlert1.setType("error");
                this.pageAlert1.setTitle("Error al eliminar el Empleado");
            } else {
                this.pageAlert1.setType("information");
                this.pageAlert1.setTitle("El Empleado se a Eliminado correctamente");
            }

            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }

        //Result
        return null;
    }

    public String uiBtnCancelar_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        this.addRequest = false;
        this.updateRequest = false;

        return null;
    }

    public String uiBtnGuardarNuevo_action() {
        // Apagamos la bandera de nuevo registro
        this.addRequest = false;

        //Validamos los campos
        validarCampos();
        Cargo cargo;
        Empleado r;
        Seccion seccion;

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Nuevo Empleado
            r = new Empleado();

            //Set de los artributos
            r.setApellidoEmpleado((String) uiTxtApellido.getText());
            r.setCinEmpleado((String) uiTxtNroCedula.getText());

            //Obtenemos el objeto Cargo
            cargo = new CargoController().findById(Long.valueOf((String) uiLstCargo.getSelected()));
            r.setCodCargo(cargo);

            //Obtenemos el objeto Seccion
            seccion = new SeccionController().findById(Long.valueOf((String) uiLstSeccion.getSelected()));
            r.setCodSeccion(seccion);

            r.setDireccionEmpleado((String) uiTxtDireccion.getText());
            r.setEstadoCivilEmpleado((String) uiRadEstadoCivil.getSelected());
            r.setEstadoEmpleado((String) uiLstEstado.getSelected());
            r.setFechaIngresoEmpleado(new Date());
            r.setFechaNacimientoEmpleado(uiCalFechaNacimiento.getSelectedDate());
            r.setHijosEmpleado(new BigInteger(uiTxtCantHijos.getText().toString()));
            r.setIpsEmpleado((String) uiTxtNroIPS.getText());
            r.setMailEmpleado((String) uiTxtMail.getText());
            r.setNacionalidadEmpleado((String) uiTxtNacionalidad.getText());
            r.setNombreEmpleado((String) uiTxtNombre.getText());
            r.setSalarioEmpleado(new BigInteger(uiTxtSalario.getText().toString()));
            r.setSexoEmpleado(uiLstSexo.getSelected().toString());
            r.setTelefono1Empleado((String) uiTxtTelefono1.getText());
            r.setTelefono2Empleado((String) uiTxtTelefono2.getText());
            r.setTipoEmpleado(uiRadTipoEmpleado.getSelected().toString());
            r.setCostoHora(Long.valueOf(uiTxtCostoHoraProd.getText().toString()));
            //Insertamos el nuevo registro
            ControllerResult cr = new EmpleadoController().create(r);

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

    public String uiBtnGuardarEditar_action() {
        // Apagamos la bandera de nuevo registro
        this.updateRequest = false;

        //Obtenemos el registro seleccionado por medio
        //del id almacenado en la session
        Empleado r = new EmpleadoController().findById(getSessionBean1().getId());

        //Validamos los campos
        validarCampos();
        Cargo cargo;
        Seccion seccion;

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Set de los artributos
            r.setApellidoEmpleado((String) uiTxtApellido.getText());
            r.setCinEmpleado((String) uiTxtNroCedula.getText());

            //Obtenemos el objeto Cargo
            cargo = new CargoController().findById(Long.valueOf((String) uiLstCargo.getSelected()));
            r.setCodCargo(cargo);

            //Obtenemos el objeto Seccion
            seccion = new SeccionController().findById(Long.valueOf((String) uiLstSeccion.getSelected()));
            r.setCodSeccion(seccion);

            r.setDireccionEmpleado((String) uiTxtDireccion.getText());
            r.setEstadoCivilEmpleado((String) uiRadEstadoCivil.getSelected());
            r.setEstadoEmpleado((String) uiLstEstado.getSelected());
            r.setFechaIngresoEmpleado(new Date());
            r.setFechaNacimientoEmpleado(uiCalFechaNacimiento.getSelectedDate());
            r.setHijosEmpleado(new BigInteger(uiTxtCantHijos.getText().toString()));
            r.setIpsEmpleado((String) uiTxtNroIPS.getText());
            r.setMailEmpleado((String) uiTxtMail.getText());
            r.setNacionalidadEmpleado((String) uiTxtNacionalidad.getText());
            r.setNombreEmpleado((String) uiTxtNombre.getText());
            r.setSalarioEmpleado(new BigInteger(uiTxtSalario.getText().toString()));
            r.setSexoEmpleado(uiLstSexo.getSelected().toString());
            r.setTelefono1Empleado((String) uiTxtTelefono1.getText());
            r.setTelefono2Empleado((String) uiTxtTelefono2.getText());
            r.setTipoEmpleado(uiRadTipoEmpleado.getSelected().toString());
            r.setCostoHora(Long.valueOf(uiTxtCostoHoraProd.getText().toString()));
            //Insertamos el nuevo registro
            ControllerResult cr = new EmpleadoController().update(r);

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

    /**
     * Buscar los registros que cumplan con el criterios de busqueda
     * 
     * @return
     */
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
        EmpleadoController c = new EmpleadoController();
        String pNombre = null, pApellido = null, pNroCedula = null;

        //Nombre
        if (this.uiTxtFilNombre.getText() != null) {
            pNombre = this.uiTxtFilNombre.getText().toString();
        }

        //Apellido
        if (this.uiTxtFilApellido.getText() != null) {
            pApellido = this.uiTxtFilApellido.getText().toString();
        }

        //Nro. de cedula
        if (this.uiTxtFilCedula.getText() != null) {
            pNroCedula = this.uiTxtFilCedula.getText().toString();
        }

        //Buscamos la lista de registros
        Empleado[] l = (Empleado[]) c.getEmeplados(pNombre, pApellido, pNroCedula).toArray(new Empleado[0]);

        //Actualizamos la lista de empleados de la session
        getSessionBean1().setListaEmpleados(l);
    }

    /**
     * Recuparar todos los registros de la tabla
     * @return
     */
    public String uiBtnBuscarTodos_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Ceramos los campos de busqueda
        this.uiTxtFilNombre.setText(null);
        this.uiTxtFilApellido.setText(null);
        this.uiTxtFilCedula.setText(null);

        //Realizamos la busuqueda
        buscar();

        //Result
        return null;
    }

    /**
     * Validar los campos de la entidad, para verificar si los datos ingresados
     * por el usuario es correcto y si estan todos los campos obligatorios.
     */
    private void validarCampos() {
        //Apagamos la bandera de error
        this.errorValidacion = false;

        //Nombre
        if (this.uiTxtNombre.getText() == null) {
            info(uiTxtNombre, "Nombre del empleado obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Apellido
        if (this.uiTxtApellido.getText() == null) {
            info(uiTxtApellido, "Apellido del empleado obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Nro. Cedula
        if (this.uiTxtNroCedula.getText() == null) {
            info(uiTxtNroCedula, "Nro. Cedula del empleado obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Nacionalidad
        if (this.uiTxtNacionalidad.getText() == null) {
            info(uiTxtNacionalidad, "Nacionalidad del empleado obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Fecha del empledao
        if (this.uiCalFechaNacimiento.getValue() == null) {
            info(uiCalFechaNacimiento, "Fecha de Nacimiento del empleado obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Direccion
        if (this.uiTxtDireccion.getText() == null) {
            info(uiTxtDireccion, "Direccion del empleado obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Salario
        if (this.uiTxtSalario.getText() == null) {
            info(uiTxtSalario, "Salario del empleado obligatorio, ingrese un valor");
            errorValidacion = true;
        } else if (!StringUtils.esNumero(this.uiTxtSalario.getText().toString())) {
            info(uiTxtSalario, "Valor incorrecto para Salario, debe ser un numero");
            errorValidacion = true;
        }
        //Costo Hora Produccion
        if (this.uiTxtCostoHoraProd.getText() == null) {
            info(uiTxtCostoHoraProd, "Costo Hora Produccion del empleado obligatorio, ingrese un valor");
            errorValidacion = true;
        } else if (!StringUtils.esNumero(this.uiTxtCostoHoraProd.getText().toString())) {
            info(uiTxtCostoHoraProd, "Valor incorrecto para Costo Hora Produccion, debe ser un numero");
            errorValidacion = true;
        }

        //Cantidad hijos
        if (this.uiTxtCantHijos.getText() != null) {
            if (!StringUtils.esNumero(this.uiTxtCantHijos.getText().toString())) {
                info(uiTxtCantHijos, "Valor incorrecto para Cantidad Hijos, debe ser un numero");
                errorValidacion = true;
            }
        }
    }

    /**
     * Limpiar campos
     */
    private void limpiarCampos() {
        uiTxtApellido.setText(null);
        uiTxtNroCedula.setText(null);
        uiTxtDireccion.setText(null);
        uiTxtCantHijos.setText(null);
        uiTxtNroIPS.setText(null);
        uiTxtMail.setText(null);
        uiTxtNacionalidad.setText(null);
        uiTxtNombre.setText(null);
        uiTxtSalario.setText(null);
        uiTxtTelefono1.setText(null);
        uiTxtTelefono2.setText(null);
    }

    /**
     *
     */
    private void cargarCampos() {
        //Obtenemos el registro seleccionado por medio
        //del id almacenado en la session
        Empleado e = new EmpleadoController().findById(getSessionBean1().getId());

        uiTxtApellido.setText(e.getApellidoEmpleado());
        uiTxtNroCedula.setText(e.getCinEmpleado());
        uiTxtDireccion.setText(e.getDireccionEmpleado());
        uiTxtCantHijos.setText(e.getHijosEmpleado());
        uiTxtNroIPS.setText(e.getIpsEmpleado());
        uiTxtMail.setText(e.getMailEmpleado());
        uiTxtNacionalidad.setText(e.getNacionalidadEmpleado());
        uiTxtNombre.setText(e.getNombreEmpleado());
        uiTxtSalario.setText(e.getSalarioEmpleado());
        uiTxtTelefono1.setText(e.getTelefono1Empleado());
        uiTxtTelefono2.setText(e.getTelefono2Empleado());
        uiCalFechaNacimiento.setSelectedDate(e.getFechaNacimientoEmpleado());
        uiLstCargo.setSelected(e.getCodCargo().getCodCargo().toString());
        uiLstSeccion.setSelected(e.getCodSeccion().getCodSeccion().toString());
        uiLstEstado.setSelected(e.getEstadoEmpleado());
        uiLstSexo.setSelected(e.getSexoEmpleado());
        uiRadEstadoCivil.setSelected(e.getEstadoCivilEmpleado());
        uiRadTipoEmpleado.setSelected(e.getTipoEmpleado());
        uiTxtCostoHoraProd.setText(e.getCostoHora().toString());

    }
}

