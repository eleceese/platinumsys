/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package platinum;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import py.com.platinum.controller.ParametroController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Parametros;
import py.com.platinum.utils.StringUtils;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ABMParametros.java
 * @version Created on Jul 15, 2010, 5:50:44 PM
 * @author FerBoy
 */



public class ABMParametros extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private TextField uiTexto = new TextField();

    public TextField getUiTexto() {
        return uiTexto;
    }

    public void setUiTexto(TextField tf) {
        this.uiTexto = tf;
    }
    private TextField uiNumero = new TextField();

    public TextField getUiNumero() {
        return uiNumero;
    }

    public void setUiNumero(TextField tf) {
        this.uiNumero = tf;
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
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private HtmlPanelGrid gridPanel2 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel2() {
        return gridPanel2;
    }

    public void setGridPanel2(HtmlPanelGrid hpg) {
        this.gridPanel2 = hpg;
    }
    private HtmlPanelGrid gridPanel5 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel5() {
        return gridPanel5;
    }

    public void setGridPanel5(HtmlPanelGrid hpg) {
        this.gridPanel5 = hpg;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMParametros() {
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
            log("ABMParametros Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
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

    private boolean updateRequest = false;

    public void prerender() {
        
      if (updateRequest) {
           this.gridPanel5.setRendered(true);
        } else {
            this.gridPanel5.setRendered(false);
        }

       ParametroController par = new ParametroController();
        //Buscamos la lista de registros
        Parametros[] l = (Parametros[]) par.getAll("descripcion").toArray(new Parametros[0]);

        //Actualizamos la lista de empleados de la session
        getSessionBean1().setlistaParametros(l);
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

    private String itemDet;

    public String getItemDet() {
        return itemDet;
    }

    public void setItemDet(String itemDet) {
        this.itemDet = itemDet;
    }
  private boolean editarDetalle = false;

    public String imageHyperlink1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
      

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

    public String uiEditar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
           //this.pageAlert1.setRendered(false);

        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
            //Obtenemos la lista de
            Parametros[] l = getSessionBean1().getlistaParametros();

            //Posicion en la grilla del elemento seleccionado
            int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());

            //Elemento seleccionado
            Parametros e = l[rowId];

            //Guardamos el id del Banco en la session
            getSessionBean1().setId(e.getCodParametro());
            this.uiTexto.setText(e.getValorTexto());
            this.uiNumero.setText(e.getValorNumero());
        }
        this.updateRequest=true;


        return null;
    }

    public String button1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
          this.updateRequest = false;

        //Obtenemos el registro seleccionado por medio
        //del id almacenado en la session
        Parametros r = new ParametroController().findById(getSessionBean1().getId());

        //Validamos los campos
        validarCampos();

        //Si no hay error de validacion insertamos el registro
        if (!errorValidacion) {
            //Set de los artributos
            if (this.uiTexto.getText() != null && !uiTexto.getText().toString().equals("")) {
                r.setValorTexto((String) uiTexto.getText());
            }
            if (this.uiNumero.getText() != null && !uiNumero.getText().toString().equals("")
                        && StringUtils.esNumero(uiNumero.getText().toString())) {
                            r.setValorNumero(Long.valueOf(this.uiNumero.getText().toString()));
            }


            //Insertamos el nuevo registro
            ControllerResult cr = new ParametroController().update(r);

            //Verificamos el tipo de mensaje
            if (cr.getCodRetorno() == -1) {
                info("Error");
            } else {
                info("Correcto");
            }

//            this.pageAlert1.setTitle(cr.getMsg());
//            this.pageAlert1.setSummary("");
//            this.pageAlert1.setDetail("");
//            this.pageAlert1.setRendered(true);
        }




        return null;
    }
    private boolean errorValidacion = false;
    private void validarCampos() {
        //Apagamos la bandera de error
        this.errorValidacion = false;

        //Descripcion
//        if (this.uiTexto.getText() == null
//                || this.uiTexto.getText().equals("")
//                || !StringUtils.esNumero(this.uiTexto.getText().toString())) {
//            //info(uiTxtDescripcion, "Descripcion de la Seccion obligatorio, ingrese un valor");
//            errorValidacion = true;
//        }

    }

}

