/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.ProgressBar;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Date;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.convert.NumberConverter;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.VentaComisionMensualController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.VentaComisionMensual;
import py.com.platinum.utilsenum.VentaComisionEstado;






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
public class ABMComisionMensual extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        numberConverter1.setPattern("#,##0");
        uiLstMesDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("01", "Enero"), new com.sun.webui.jsf.model.Option("02", "Febrero"), new com.sun.webui.jsf.model.Option("03", "Marzo"), new com.sun.webui.jsf.model.Option("04", "Abril"), new com.sun.webui.jsf.model.Option("05", "Mayo"), new com.sun.webui.jsf.model.Option("06", "Junio"), new com.sun.webui.jsf.model.Option("07", "Julio"), new com.sun.webui.jsf.model.Option("08", "Agosto"), new com.sun.webui.jsf.model.Option("09", "Setiembre"), new com.sun.webui.jsf.model.Option("10", "Octubre"), new com.sun.webui.jsf.model.Option("11", "Noviembre"), new com.sun.webui.jsf.model.Option("12", "Diciembre")});
        uiLstFilEstadoComisionDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("PENDIENTE", "PENDIENTE"), new com.sun.webui.jsf.model.Option("GENERADO", "GENERADO"), new com.sun.webui.jsf.model.Option("CERRADO", "CERRADO"), new com.sun.webui.jsf.model.Option("ANULADO", "ANULADO"),new com.sun.webui.jsf.model.Option("TODOS", "TODOS")});
        uiLstFilEstadoComisionDefaultOptions.setSelectedValue("TODOS");
        numberConverter1.setMinIntegerDigits(1);
        numberConverter1.setMaxIntegerDigits(40);
        numberConverter1.setMaxFractionDigits(3);
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
    private StaticText datosVentaComisionMensual = new StaticText();

    public StaticText getDatosVentaComisionMensual() {
        return datosVentaComisionMensual;
    }

    public void setDatosVentaComisionMensual(StaticText st) {
        this.datosVentaComisionMensual = st;
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
    private TextField uiTxtAnio = new TextField();

    public TextField getUiTxtAnio() {
        return uiTxtAnio;
    }

    public void setUiTxtAnio(TextField tf) {
        this.uiTxtAnio = tf;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private TextField uiTxtFilMes = new TextField();

    public TextField getUiTxtFilMes() {
        return uiTxtFilMes;
    }

    public void setUiTxtFilMes(TextField tf) {
        this.uiTxtFilMes = tf;
    }
    private TextField uiTxtFilAnio = new TextField();

    public TextField getUiTxtFilAnio() {
        return uiTxtFilAnio;
    }

    public void setUiTxtFilAnio(TextField tf) {
        this.uiTxtFilAnio = tf;
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
    private SingleSelectOptionsList uiLstFilEstadoComisionDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiLstFilEstadoComisionDefaultOptions() {
        return uiLstFilEstadoComisionDefaultOptions;
    }

    public void setUiLstFilEstadoComisionDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiLstFilEstadoComisionDefaultOptions = ssol;
    }
    private DropDown uiLstFilEstadoComision = new DropDown();

    public DropDown getUiLstFilEstadoComision() {
        return uiLstFilEstadoComision;
    }

    public void setUiLstFilEstadoComision(DropDown dd) {
        this.uiLstFilEstadoComision = dd;
    }
    private NumberConverter numberConverter1 = new NumberConverter();

    public NumberConverter getNumberConverter1() {
        return numberConverter1;
    }

    public void setNumberConverter1(NumberConverter nc) {
        this.numberConverter1 = nc;
    }
    private SingleSelectOptionsList uiLstMesDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiLstMesDefaultOptions() {
        return uiLstMesDefaultOptions;
    }

    public void setUiLstMesDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiLstMesDefaultOptions = ssol;
    }
    private DropDown uiLstMes = new DropDown();

    public DropDown getUiLstMes() {
        return uiLstMes;
    }

    public void setUiLstMes(DropDown dd) {
        this.uiLstMes = dd;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMComisionMensual() {
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

    getSessionBean1().setTituloPagina("Registro de Venta Comision Mensual");
    getSessionBean1().setDetallePagina("Seleccione el registro Deseado");


    //Estados de la factura
        VentaComisionEstado[] lstEstado = VentaComisionEstado.values();
        Option[] lstEstadoOp = new Option[lstEstado.length];

        Option o = new Option();
        for (int i = 0; i < lstEstado.length; i++) {
            //Obtenemos el estado
            VentaComisionEstado p = lstEstado[i];

            //Seteamos el value y el label del option
            o.setValue(p.toString());
            o.setLabel(p.toString());

            //Agregamos a la lista
            lstEstadoOp[i] = o;

            //Cerar
            o = new Option();
        }

        uiLstFilEstadoComisionDefaultOptions.setOptions(lstEstadoOp);
        uiLstFilEstadoComisionDefaultOptions.setSelectedValue(VentaComisionEstado.PENDIENTE.toString());

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
            this.datosVentaComisionMensual.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosVentaComisionMensual.setRendered(true);
            this.limpiarCampos();
        } else if (updateRequest) {
            cargarCampos();
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosVentaComisionMensual.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosVentaComisionMensual.setRendered(true);
        } else if (errorValidacion) {
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosVentaComisionMensual.setRendered(true);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosVentaComisionMensual.setRendered(true);
        } else {
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosVentaComisionMensual.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosVentaComisionMensual.setRendered(false);
        }

        //Actualizamos la lista
        buscar();
    }


    /**
     * Limpiar campos
     */
    private void limpiarCampos() {
        uiTxtAnio.setText(null);
    }

    /**
     * Cargar campos, para la edicion del registro seleccionado
     */
    private void cargarCampos() {
        //Obtenemos el registro seleccionado por medio
        //del id almacenado en la session
        VentaComisionMensual e = new VentaComisionMensualController().findById(getSessionBean1().getId());

        uiTxtAnio.setText(e.getAnio());
        uiLstMes.setSelected(e.getMes());
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
            VentaComisionMensual[] l = getSessionBean1().getListaVentaComisionMensual();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            VentaComisionMensual e = l[rowId];

            if (e.getEstado().equals(VentaComisionEstado.PENDIENTE)) {
                //Guardamos el id del VentaComisionMensual en la session
                getSessionBean1().setId(e.getCodComision());
                this.updateRequest=true;
                this.uiBtnGuardarEditar.setRendered(true);
                this.uiBtnGuardarNuevo.setRendered(false);
            }else{
                this.pageAlert1.setType("information");
                this.pageAlert1.setTitle("El Periodo de Comision Seleccionado, Debe estar con Estado " + VentaComisionEstado.PENDIENTE +", para poder ser editado.");
                this.pageAlert1.setSummary("");
                this.pageAlert1.setDetail("");
                this.pageAlert1.setRendered(true);
            }
            
        }
        
        
        //Result
        return null;

    }

    public String generar_Comisiones_action() {
       
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        // Si la cantidad de registros en la grilla es mayor a 0
        // Eliminamos el elemento seleccionado
        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
            //Obtenemos la lista de
            VentaComisionMensual[] l = getSessionBean1().getListaVentaComisionMensual();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            VentaComisionMensual e = l[rowId];

            if (e.getEstado().toString().equals("PENDIENTE")) {

                //Generamos la comision
                VentaComisionMensualController controller = new VentaComisionMensualController();

                if (controller.getVentaComisionMensual(e.getMes(), e.getAnio(), null).size() > 0) {
                    this.pageAlert1.setType("information");
                    this.pageAlert1.setTitle("Para este periodo ya se generaron las comisiones, favor anular dichas comisiones para vovler a generar las comisiones");
                }else{
                    
                    ControllerResult r = controller.generarComisiones(e, getSessionBean1().getUsuario());

                    //Mensaje
                    if (r.getCodRetorno() == -1) {
                        this.pageAlert1.setType("error");
                        this.pageAlert1.setTitle("Error al eliminar el Registro");
                    } else {
                        this.pageAlert1.setType("information");
                        this.pageAlert1.setTitle(r.getMsg());
                        e.setEstado(VentaComisionEstado.GENERADO.toString());
                        controller.update(e);
                    }
                }
            }else{
                    this.pageAlert1.setType("information");
                    this.pageAlert1.setTitle("El Periodo debe estar en estado PENDIENTE, para ser generado");
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
        VentaComisionMensual r;

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Nuevo
            r = new VentaComisionMensual();

            //Set de los artributos
            r.setMes(uiLstMes.getSelected().toString());
            r.setAnio((String) uiTxtAnio.getText());
            r.setEstado(VentaComisionEstado.PENDIENTE.toString());
            r.setFechaAlta(new Date());
            //r.setUsuarioAlta(getSessionBean1().getUsuarioLogueado().getUsuario());
            
            //Insertamos el nuevo registro
            ControllerResult cr = new VentaComisionMensualController().create(r);

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

        //Descripcion
        if (this.uiTxtAnio.getText() == null || this.uiTxtAnio.getText().equals("")) {
            info(uiTxtAnio, "Descripcion de la Seccion obligatorio, ingrese un valor");
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
        VentaComisionMensualController c = new VentaComisionMensualController();
        String pMes = null, pAnio = null;

        //Codigo
        if (this.uiTxtFilMes.getText() != null) {
            pMes = this.uiTxtFilMes.getText().toString();
        }

        //Descripcion
        if (this.uiTxtFilAnio.getText() != null) {
            pAnio = this.uiTxtFilAnio.getText().toString();
        }

        String estado = uiLstFilEstadoComisionDefaultOptions.getSelectedValue().toString();

        if (estado.equals("TODOS")) {
            estado = null;
        }

        //Buscamos la lista de registros
        VentaComisionMensual[] l = (VentaComisionMensual[]) c.getVentaComisionMensual(pMes, pAnio, estado).toArray(new VentaComisionMensual[0]);

        //Actualizamos la lista de empleados de la session
        getSessionBean1().setListaVentaComisionMensual(l);
    }

    public String uiBtnTodos_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        //Ceramos los campos de busqueda
        this.uiTxtFilMes.setText(null);
        this.uiTxtFilAnio.setText(null);

        //Realizamos la busuqueda
        buscar();

        //Result
        return null;
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

    public String uiBtnGuardarEditar_action() {
        // Apagamos la bandera de nuevo registro
        this.updateRequest = false;

        //Obtenemos el registro seleccionado por medio
        //del id almacenado en la session
        VentaComisionMensual r = new VentaComisionMensualController().findById(getSessionBean1().getId());

        //Validamos los campos
        validarCampos();

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Set de los artributos
            r.setMes(uiLstMes.getSelected().toString());
            r.setAnio((String) uiTxtAnio.getText());

            //Insertamos el nuevo registro
            ControllerResult cr = new VentaComisionMensualController().update(r);

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

    public String CerrarPeriodo_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        // Si la cantidad de registros en la grilla es mayor a 0
        // Eliminamos el elemento seleccionado
        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
            //Obtenemos la lista de
            VentaComisionMensual[] l = getSessionBean1().getListaVentaComisionMensual();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            VentaComisionMensual e = l[rowId];

            //Eliminados el registro
            VentaComisionMensualController controller = new VentaComisionMensualController();
            
            if (e.getEstado().toString().equals("GENERADO")) {
                e.setEstado(VentaComisionEstado.CERRADO.toString());
                ControllerResult r = controller.update(e);
                //Mensaje
                if (r.getCodRetorno() == -1) {
                    this.pageAlert1.setType("error");
                    this.pageAlert1.setTitle("Error al Cerrar el Periodo");
                } else {
                    this.pageAlert1.setType("information");
                    this.pageAlert1.setTitle("Periodo cerrado correctamente");
                }
            }else{
                this.pageAlert1.setType("information");
                this.pageAlert1.setTitle("Periodo debe estar con estado igual a GENERADO, para poder cerrar");
            }


            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }

        //Result
        return null;
    }

    public String AnularPeriodo_action() {
        //ocultamos el pageAlert
        this.pageAlert1.setRendered(false);

        // Si la cantidad de registros en la grilla es mayor a 0
        // Eliminamos el elemento seleccionado
        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
            //Obtenemos la lista de
            VentaComisionMensual[] l = getSessionBean1().getListaVentaComisionMensual();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            VentaComisionMensual e = l[rowId];

            //Eliminados el registro
            VentaComisionMensualController controller = new VentaComisionMensualController();

            if (!e.getEstado().toString().equals("CERRADO") && !e.getEstado().toString().equals("ANULADO")) {
                e.setEstado(VentaComisionEstado.ANULADO.toString());
                ControllerResult r = controller.update(e);
                //Mensaje
                if (r.getCodRetorno() == -1) {
                    this.pageAlert1.setType("error");
                    this.pageAlert1.setTitle("Error al Anular el Periodo");
                } else {
                    this.pageAlert1.setType("information");
                    this.pageAlert1.setTitle("Periodo Anulado correctamente");
                }
            }else{
                this.pageAlert1.setType("information");
                this.pageAlert1.setTitle("Periodo debe estar con estado igual a PENDIENTE o GENERADO, para poder cerrar");
            }


            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }

        //Result
        return null;
    }
}

