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
import com.sun.webui.jsf.component.RadioButton;
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

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Usuario.java
 * @version Created on 20-ago-2009, 19:25:56
 * @author MartinJara
 */
public class ABMReciboCobro extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        dropDown2DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("PE", "Pendiente"), new com.sun.webui.jsf.model.Option("CO", "Cobrado"), new com.sun.webui.jsf.model.Option("AN", "Anulado")});
        dropDown2DefaultOptions.setSelectedValue("CO");
    }
    private HtmlPanelGrid mainContainer = new HtmlPanelGrid();

    public HtmlPanelGrid getMainContainer() {
        return mainContainer;
    }

    public void setMainContainer(HtmlPanelGrid hpg) {
        this.mainContainer = hpg;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private Button addButton = new Button();

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button b) {
        this.addButton = b;
    }
    private Button updateButton = new Button();

    public Button getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(Button b) {
        this.updateButton = b;
    }
    private Button deleteButton = new Button();

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button b) {
        this.deleteButton = b;
    }
    private HtmlPanelGrid addUpdatePanel = new HtmlPanelGrid();

    public HtmlPanelGrid getAddUpdatePanel() {
        return addUpdatePanel;
    }

    public void setAddUpdatePanel(HtmlPanelGrid hpg) {
        this.addUpdatePanel = hpg;
    }
    private TextField userNameField = new TextField();

    public TextField getUserNameField() {
        return userNameField;
    }

    public void setUserNameField(TextField tf) {
        this.userNameField = tf;
    }
    private TextField emailAddressField = new TextField();

    public TextField getEmailAddressField() {
        return emailAddressField;
    }

    public void setEmailAddressField(TextField tf) {
        this.emailAddressField = tf;
    }
    private Button addRecordButton = new Button();

    public Button getAddRecordButton() {
        return addRecordButton;
    }

    public void setAddRecordButton(Button b) {
        this.addRecordButton = b;
    }
    private Button updateRecordButton = new Button();

    public Button getUpdateRecordButton() {
        return updateRecordButton;
    }

    public void setUpdateRecordButton(Button b) {
        this.updateRecordButton = b;
    }
    private Button cancelButton = new Button();

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button b) {
        this.cancelButton = b;
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private TextField userNameFiltro = new TextField();

    public TextField getUserNameFiltro() {
        return userNameFiltro;
    }

    public void setUserNameFiltro(TextField tf) {
        this.userNameFiltro = tf;
    }
    private Button buscarButton = new Button();

    public Button getBuscarButton() {
        return buscarButton;
    }

    public void setBuscarButton(Button b) {
        this.buscarButton = b;
    }
    private Button todosButton = new Button();

    public Button getTodosButton() {
        return todosButton;
    }

    public void setTodosButton(Button b) {
        this.todosButton = b;
    }
    private DefaultTableDataProvider defaultTableDataProvider = new DefaultTableDataProvider();

    public DefaultTableDataProvider getDefaultTableDataProvider() {
        return defaultTableDataProvider;
    }

    public void setDefaultTableDataProvider(DefaultTableDataProvider dtdp) {
        this.defaultTableDataProvider = dtdp;
    }
    
    private Table table1 = new Table();

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table t) {
        this.table1 = t;
    }
    private HtmlPanelGrid gridPanelBuscar = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBuscar() {
        return gridPanelBuscar;
    }

    public void setGridPanelBuscar(HtmlPanelGrid hpg) {
        this.gridPanelBuscar = hpg;
    }
    private HtmlPanelGrid buttonPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(HtmlPanelGrid hpg) {
        this.buttonPanel = hpg;
    }
    private SingleSelectOptionsList dropDown2DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDropDown2DefaultOptions() {
        return dropDown2DefaultOptions;
    }

    public void setDropDown2DefaultOptions(SingleSelectOptionsList ssol) {
        this.dropDown2DefaultOptions = ssol;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMReciboCobro() {
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
            log("Usuario Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        getSessionBean1().setTituloPagina("Recibo de Dinero");
        getSessionBean1().setDetallePagina("Registro de Recibo de Dinero - Cobranza");

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
    @Override
    public void prerender() {
        cancelButton.setRendered(true);
        if (addRequest) {
            gridPanelBuscar.setRendered(false);
            table1.setRendered(false);
            buttonPanel.setRendered(false);
            addUpdatePanel.setRendered(true);
            addRecordButton.setRendered(true);
            updateRecordButton.setRendered(false);
            userNameField.setText("");
            emailAddressField.setText("");
        } else if (updateRequest) {
            //if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                gridPanelBuscar.setRendered(false);
                table1.setRendered(false);
                buttonPanel.setRendered(false);
                addUpdatePanel.setRendered(true);
                addRecordButton.setRendered(false);
                updateRecordButton.setRendered(true);
            //}
        } else if(errorValidacion){
            addUpdatePanel.setRendered(true);
        }else {
            getSessionBean1().setTituloPagina("Recibo de Dinero");
            getSessionBean1().setDetallePagina("Registro de Recibo de Dinero - Cobranza");
            gridPanelBuscar.setRendered(true);
            table1.setRendered(true);
            buttonPanel.setRendered(true);
            addUpdatePanel.setRendered(false);
        }
        // Refresh the users data array in the session bean to to show
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
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
    private boolean addRequest = false;
    private boolean updateRequest = false;
    private boolean errorValidacion = false;

    public String addButton_action() {
        addRequest = true;
        getSessionBean1().setTituloPagina("Nuevo Recibo de Dinero");
        getSessionBean1().setDetallePagina("Registro Recibo de Dinero - Cobranza");
        return null;
    }

    public String updateButton_action() {
        updateRequest = true;
        getSessionBean1().setTituloPagina("Editar Recibo de Dinero");
        getSessionBean1().setDetallePagina("Edición Recibo de Dinero - Cobranza");
        return null;
    }

    public String deleteButton_action() {
        return null;
    }

    public String addRecordButton_action() {

        errorValidacion = validarCampos();

        //Si no hay error de validacion
        if (!errorValidacion) {
            updateRequest = false;
            this.pageAlert1.setType("information");
            this.pageAlert1.setTitle("Registro Creado correctamente!!!");
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }else{
            this.pageAlert1.setType("error");
            this.pageAlert1.setTitle("Error en la Validacion de los Campos, favor verificar y volver a intentar");
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }
        
        return null;
    }

    public String updateRecordButton_action() {
        //errorValidacion = validarCampos();
        errorValidacion = false;

        if (!errorValidacion) {
            // TODO: Process the action. Return value is a navigation
            // case name where null will return to the same page.
            // Create a new Users Entity
            // Update the database table data using UserController
            addRequest = false;
            this.pageAlert1.setType("information");
            this.pageAlert1.setTitle("Registro Editado correctamente!!!");
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }else{
            this.pageAlert1.setType("error");
            this.pageAlert1.setTitle("Error en la Validacion de los Campos, favor verificar y volver a intentar");
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);
        }
        
        return null;
    }

    public String cancelButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        addRequest = false;
        updateRequest = false;
        return null;
    }

    private boolean validarCampos(){
        //Variables
        boolean r;

        //Inicializar
        r = false;

        if (userNameField.getText() == null || userNameField.getText().equals("") ) {
            info(userNameField, "Campo obligatorio, favor ingrese el Nombre del Usuario");
            r = true;
        }

        if (userNameField.getText() == null || userNameField.getText().equals("") ) {
            info(userNameField, "Campo obligatorio, favor ingrese el e-mail del Usuario");
            r = true;
        }
        //result
        return r;
    }

    public void userNameField_processValueChange(ValueChangeEvent event) {
    }

    public void dropDown2_processValueChange(ValueChangeEvent event) {
    }
}

