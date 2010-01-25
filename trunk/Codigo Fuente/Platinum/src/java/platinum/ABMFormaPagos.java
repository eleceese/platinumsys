/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.Script;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.BancoController;
import py.com.platinum.controller.FormaPagoController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Banco;
import py.com.platinum.entity.FormaPago;

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
public class ABMFormaPagos extends AbstractPageBean {
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
    private StaticText datosFormaPago = new StaticText();

    public StaticText getDatosFormaPago() {
        return datosFormaPago;
    }

    public void setDatosFormaPago(StaticText st) {
        this.datosFormaPago = st;
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
    private TextField uiTxtDescripcion = new TextField();

    public TextField getUiTxtDescripcion() {
        return uiTxtDescripcion;
    }

    public void setUiTxtDescripcion(TextField tf) {
        this.uiTxtDescripcion = tf;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private TextField uiTxtFilBanco = new TextField();

    public TextField getUiTxtFilBanco() {
        return uiTxtFilBanco;
    }

    public void setUiTxtFilBanco(TextField tf) {
        this.uiTxtFilBanco = tf;
    }
    private TextField uiTxtFilDescripcion = new TextField();

    public TextField getUiTxtFilDescripcion() {
        return uiTxtFilDescripcion;
    }

    public void setUiTxtFilDescripcion(TextField tf) {
        this.uiTxtFilDescripcion = tf;
    }
    private Table table1 = new Table();

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table t) {
        this.table1 = t;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private TableColumn tableColumn3 = new TableColumn();

    public TableColumn getTableColumn3() {
        return tableColumn3;
    }

    public void setTableColumn3(TableColumn tc) {
        this.tableColumn3 = tc;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TextField uiTxtCodigoBanco = new TextField();

    public TextField getUiTxtCodigoBanco() {
        return uiTxtCodigoBanco;
    }

    public void setUiTxtCodigoBanco(TextField tf) {
        this.uiTxtCodigoBanco = tf;
    }
    private TextField uiTxtDescripcionBanco = new TextField();

    public TextField getUiTxtDescripcionBanco() {
        return uiTxtDescripcionBanco;
    }

    public void setUiTxtDescripcionBanco(TextField tf) {
        this.uiTxtDescripcionBanco = tf;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMFormaPagos() {
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

        getSessionBean1().setTituloPagina("Registro de formas de pago Cobranzas");
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
            this.datosFormaPago.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosFormaPago.setRendered(true);
            this.limpiarCampos();
        } else if (updateRequest) {
            cargarCampos();
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosFormaPago.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosFormaPago.setRendered(true);
        } else if (errorValidacion) {
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosFormaPago.setRendered(true);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosFormaPago.setRendered(true);
        } else {
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosFormaPago.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosFormaPago.setRendered(false);
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
            FormaPago[] l = getSessionBean1().getListaFormaPago();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            FormaPago e = l[rowId];

            //Guardamos el id del FormaPago en la session
            getSessionBean1().setId(e.getCodFormaPago());
        }
        this.updateRequest=true;
        this.uiBtnGuardarEditar.setRendered(true);
        this.uiBtnGuardarNuevo.setRendered(false);

        //return
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
            FormaPago[] l = getSessionBean1().getListaFormaPago();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            FormaPago e = l[rowId];

            //Eliminados el registro
            FormaPagoController controller = new FormaPagoController();
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
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequest = false;
        this.updateRequest = false;

        return null;
    }

    public String uiBtnGuardarNuevo_action() {
        // Apagamos la bandera de nuevo registro
        this.addRequest = false;

        //Validamos los campos
        validarCampos();
        FormaPago r;

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Nuevo
            r = new FormaPago();

            //Set de los artributos
            r.setNombreFormaPago((String) uiTxtDescripcion.getText());
            r.setCodBanco(banco);

            //Insertamos el nuevo registro
            ControllerResult cr = new FormaPagoController().create(r);

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

    private Banco banco;

    /**
     * Validar los campos de la entidad, para verificar si los datos ingresados
     * por el usuario es correcto y si estan todos los campos obligatorios.
     */
    private void validarCampos() {
        //Apagamos la bandera de error
        this.errorValidacion = false;

        //Descripcion
        if (this.uiTxtDescripcion.getText() == null || this.uiTxtDescripcion.getText().equals("")) {
            info(uiTxtDescripcion, "Descripcion de la Forma de Pago obligatorio, ingrese un valor");
            errorValidacion = true;
        }

        //Banco, validamos solo en caso de que se haya ingresado algun valor,
        //el campo no es obligatorio

        //Inicializamos
        banco = null;
        if (this.uiTxtCodigoBanco.getText() != null ) {
            //Buscamos el Banco
            banco = new BancoController().findById(Long.valueOf(uiTxtCodigoBanco.getText().toString()));

            //Si no se encontro el banco
            if (banco == null) {
                info(uiTxtDescripcionBanco, "Banco incorrecto, verificar el codigo ingresado, ingrese un valor valido.");
                errorValidacion = true;
            }
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
        FormaPagoController c = new FormaPagoController();
        String pBanco = null, pDesc = null;

        //Codigo
        if (this.uiTxtFilBanco.getText() != null) {
            pBanco = this.uiTxtFilBanco.getText().toString();
        }

        //Descripcion
        if (this.uiTxtFilDescripcion.getText() != null) {
            pDesc = this.uiTxtFilDescripcion.getText().toString();
        }

        //Buscamos la lista de registros
        FormaPago[] l = (FormaPago[]) c.getFormaPagos(pBanco, pDesc).toArray(new FormaPago[0]);

        //Actualizamos la lista de empleados de la session
        getSessionBean1().setListaFormaPago(l);
    }

    public String uiBtnTodos_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Ceramos los campos de busqueda
        this.uiTxtFilBanco.setText(null);
        this.uiTxtFilDescripcion.setText(null);

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

    public String uiBtnGuardarEditar_action() {
        // Apagamos la bandera de nuevo registro
        this.updateRequest = false;

        //Obtenemos el registro seleccionado por medio
        //del id almacenado en la session
        FormaPago r = new FormaPagoController().findById(getSessionBean1().getId());

        //Validamos los campos
        validarCampos();

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Set de los artributos
            r.setNombreFormaPago((String) uiTxtDescripcion.getText());
            r.setCodBanco(banco);
            
            //Insertamos el nuevo registro
            ControllerResult cr = new FormaPagoController().update(r);

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

        //Result
        return null;
    }

    /**
     * Limpiar campos
     */
    private void limpiarCampos() {
        uiTxtDescripcion.setText(null);
        uiTxtCodigoBanco.setText(null);
        uiTxtDescripcionBanco.setText(null);
    }

    /**
     * Cargar campos, para la edicion del registro seleccionado
     */
    private void cargarCampos() {
        //Obtenemos el registro seleccionado por medio
        //del id almacenado en la session
        FormaPago e = new FormaPagoController().findById(getSessionBean1().getId());
        uiTxtDescripcion.setText(e.getNombreFormaPago());

        //Banco
        if (e.getCodBanco() != null) {
            uiTxtCodigoBanco.setText(e.getCodBanco().getCodBanco().toString());
            uiTxtDescripcionBanco.setText(e.getCodBanco().getNombreBanco());
        }

    }
}