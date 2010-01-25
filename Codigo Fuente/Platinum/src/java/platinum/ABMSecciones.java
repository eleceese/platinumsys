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
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.MarcaController;
import py.com.platinum.controller.SeccionController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Marca;
import py.com.platinum.entity.Seccion;

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
public class ABMSecciones extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        radioButton1.setLabel(null);
        radioButton2.setLabel(null);
        radioButton3.setLabel(null);
        radioButton4.setLabel(null);
        radioButton5.setLabel(null);
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
    private StaticText datosSeccion = new StaticText();

    public StaticText getDatosSeccion() {
        return datosSeccion;
    }

    public void setDatosSeccion(StaticText st) {
        this.datosSeccion = st;
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
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private RadioButton radioButton2 = new RadioButton();

    public RadioButton getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(RadioButton rb) {
        this.radioButton2 = rb;
    }
    private RadioButton radioButton3 = new RadioButton();

    public RadioButton getRadioButton3() {
        return radioButton3;
    }

    public void setRadioButton3(RadioButton rb) {
        this.radioButton3 = rb;
    }
    private RadioButton radioButton4 = new RadioButton();

    public RadioButton getRadioButton4() {
        return radioButton4;
    }

    public void setRadioButton4(RadioButton rb) {
        this.radioButton4 = rb;
    }
    private RadioButton radioButton5 = new RadioButton();

    public RadioButton getRadioButton5() {
        return radioButton5;
    }

    public void setRadioButton5(RadioButton rb) {
        this.radioButton5 = rb;
    }
    private TextField uiTxtFilCodigo = new TextField();

    public TextField getUiTxtFilCodigo() {
        return uiTxtFilCodigo;
    }

    public void setUiTxtFilCodigo(TextField tf) {
        this.uiTxtFilCodigo = tf;
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
    private RadioButton radioButton7 = new RadioButton();

    public RadioButton getRadioButton7() {
        return radioButton7;
    }

    public void setRadioButton7(RadioButton rb) {
        this.radioButton7 = rb;
    }
    private TableColumn tableColumn1 = new TableColumn();

    public TableColumn getTableColumn1() {
        return tableColumn1;
    }

    public void setTableColumn1(TableColumn tc) {
        this.tableColumn1 = tc;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMSecciones() {
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

        getSessionBean1().setTituloPagina("Registro de Secciones");
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
            this.datosSeccion.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosSeccion.setRendered(true);
            this.limpiarCampos();
        } else if (updateRequest) {
            cargarCampos();
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosSeccion.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosSeccion.setRendered(true);
        } else if (errorValidacion) {
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosSeccion.setRendered(true);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosSeccion.setRendered(true);
        } else {
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosSeccion.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosSeccion.setRendered(false);
        }
        
        //Actualizamos la lista
        buscar();
    }

    /**
     * Buscar los registros que cumplan con la condicion/s de busqueda
     * y actualizar la lista de la session
     */
    public void buscar() {
        //Verificamos el contenido de los campos de busqueda
        SeccionController c = new SeccionController();
        String pCod = null, pDesc = null;

        //Codigo
        if (this.uiTxtFilCodigo.getText() != null) {
            pCod = this.uiTxtFilCodigo.getText().toString();
        }

        //Descripcion
        if (this.uiTxtFilDescripcion.getText() != null) {
            pDesc = this.uiTxtFilDescripcion.getText().toString();
        }

        //Buscamos la lista de registros
        Seccion[] l = (Seccion[]) c.getSeccions(pCod, pDesc).toArray(new Seccion[0]);

        //Actualizamos la lista de empleados de la session
        getSessionBean1().setListaSeccion(l);
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
            Seccion[] l = getSessionBean1().getListaSeccion();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            Seccion e = l[rowId];

            //Guardamos el id del Seccion en la session
            getSessionBean1().setId(e.getCodSeccion());
        }
        this.updateRequest=true;
        this.uiBtnGuardarEditar.setRendered(true);
        this.uiBtnGuardarNuevo.setRendered(false);
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
            Seccion[] l = getSessionBean1().getListaSeccion();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            Seccion e = l[rowId];

            //Eliminados el registro
            SeccionController controller = new SeccionController();
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
        this.addRequest = false;
        this.updateRequest = false;

        return null;
    }

    public String uiBtnGuardarNuevo_action() {
        // Apagamos la bandera de nuevo registro
        this.addRequest = false;

        //Validamos los campos
        validarCampos();
        Seccion r;

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Nuevo Empleado
            r = new Seccion();

            //Set de los artributos
            r.setNombreSeccion((String) uiTxtDescripcion.getText());

            //Insertamos el nuevo registro
            ControllerResult cr = new SeccionController().create(r);

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
        Seccion r = new SeccionController().findById(getSessionBean1().getId());

        //Validamos los campos
        validarCampos();

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Set de los artributos
            r.setNombreSeccion((String) uiTxtDescripcion.getText());

            //Insertamos el nuevo registro
            ControllerResult cr = new SeccionController().update(r);

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

    public String uiBtnBuscar_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Realizamos la busqueda
        buscar();

        //Result
        return null;
    }

    public String uiBtnBuscarTodos_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Ceramos los campos de busqueda
        this.uiTxtFilCodigo.setText(null);
        this.uiTxtFilDescripcion.setText(null);

        //Realizamos la busuqueda
        buscar();

        //Result
        return null;
    }

    /**
     * Limpiar campos
     */
    private void limpiarCampos() {
        uiTxtDescripcion.setText(null);
    }

    /**
     * Cargar campos, para la edicion del registro seleccionado
     */
    private void cargarCampos() {
        //Obtenemos el registro seleccionado por medio
        //del id almacenado en la session
        Seccion e = new SeccionController().findById(getSessionBean1().getId());

        uiTxtDescripcion.setText(e.getNombreSeccion());
    }

    /**
     * Validar los campos de la entidad, para verificar si los datos ingresados
     * por el usuario es correcto y si estan todos los campos obligatorios.
     */
    private void validarCampos() {
        //Apagamos la bandera de error
        this.errorValidacion = false;

        //Descripcion
        if (this.uiTxtDescripcion.getText() == null || this.uiTxtDescripcion.getText().equals("")) {
            info(uiTxtDescripcion, "Descripcion de la Seccion obligatorio, ingrese un valor");
            errorValidacion = true;
        }

    }
}

