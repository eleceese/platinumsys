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
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.math.BigDecimal;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.ValueChangeEvent;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.EquivalenciaController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.TareaController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Equivalencia;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.Tarea;
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
public class ABMEquivalencia extends AbstractPageBean {
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
    private StaticText datosTareas = new StaticText();

    public StaticText getDatosTareas() {
        return datosTareas;
    }

    public void setDatosTareas(StaticText st) {
        this.datosTareas = st;
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
    private Table tableTareas = new Table();

    public Table getTableTareas() {
        return tableTareas;
    }

    public void setTableTareas(Table t) {
        this.tableTareas = t;
    }
    private TableRowGroup tareasRW = new TableRowGroup();

    public TableRowGroup getTareasRW() {
        return tareasRW;
    }

    public void setTareasRW(TableRowGroup trg) {
        this.tareasRW = trg;
    }
    private DropDown uiProductoGenFil = new DropDown();

    public DropDown getUiProductoGenFil() {
        return uiProductoGenFil;
    }

    public void setUiProductoGenFil(DropDown dd) {
        this.uiProductoGenFil = dd;
    }
    private DropDown uiProductoFinFil = new DropDown();

    public DropDown getUiProductoFinFil() {
        return uiProductoFinFil;
    }

    public void setUiProductoFinFil(DropDown dd) {
        this.uiProductoFinFil = dd;
    }
    private DropDown uiProductoGen = new DropDown();

    public DropDown getUiProductoGen() {
        return uiProductoGen;
    }

    public void setUiProductoGen(DropDown dd) {
        this.uiProductoGen = dd;
    }
    private DropDown uiProductoFin = new DropDown();

    public DropDown getUiProductoFin() {
        return uiProductoFin;
    }

    public void setUiProductoFin(DropDown dd) {
        this.uiProductoFin = dd;
    }
    private TextField uiRelacion = new TextField();

    public TextField getUiRelacion() {
        return uiRelacion;
    }

    public void setUiRelacion(TextField tf) {
        this.uiRelacion = tf;
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMEquivalencia() {

        cargarListaTodosProductosFin();
        cargarListaTodosProductosGen();
        cargarListaTodosEquivalencias();

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

    getSessionBean1().setTituloPagina("Registro de Tareas");
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
            this.datosTareas.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosTareas.setRendered(true);
             limpiarCamposNew();


        } else if (updateRequest) {

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelBotones.setRendered(false);
            this.datosTareas.setRendered(false);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosTareas.setRendered(true);
            cargarCamposUpdate();

        } else if (errorValidacion) {
            
            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosTareas.setRendered(true);
            this.gridPanelAddUpdate.setRendered(true);
            this.buttonsPanelAddUpdate.setRendered(true);
            this.datosTareas.setRendered(true);


        } else {

            this.gridPanelTabla.setRendered(true);
            this.gridPanelBuscar.setRendered(true);
            this.gridPanelBotones.setRendered(true);
            this.datosTareas.setRendered(true);
            this.gridPanelAddUpdate.setRendered(false);
            this.buttonsPanelAddUpdate.setRendered(false);
            this.datosTareas.setRendered(false);

        }
buscar_action2();
    }

    public void cargarCamposUpdate(){

         if (getTareasRW().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getTareasRW().getSelectedRowKeys();
          Equivalencia[] equivalencias = listaEquivalencias;
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          Equivalencia eq = equivalencias[rowId];


         //// CARGAMOS EN UNA VARIABLE ID EL CODIGO DEL TIPO RECUPERADO DESDE LA GRILLA PARA
          /// LUEGO HACER LA BUSQUEDA DEL OBJETO POR ID
          getSessionBean1().setId(eq.getCodEquivalencia());
         //// CARGA DE CAMPOS DE LA PAGINA

            this.uiProductoFin.setSelected(eq.getCodProductoFin().getCodProducto().toString());
            this.uiProductoGen.setSelected(eq.getCodProductoGen().getCodProducto().toString());
            this.uiRelacion.setText(eq.getRelacion().toString());

         }
    }

public void limpiarCamposNew(){

        this.uiProductoFin.setSelected("");
        this.uiProductoGen.setSelected("");
        this.uiRelacion.setText("");
            

    }

     private String buscar_action2() {

        Tarea[] listaTareas;
        TareaController tareaController = new TareaController();

        String pCodigo=null, pNombre=null;

        

        listaTareas = (Tarea[]) tareaController.getAllFiltered
                                        (pCodigo,
                                         pNombre).toArray(new Tarea[0]);

        getSessionBean1().setListaTareas(listaTareas);
        return null;

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
        this.updateRequest=true;
        this.buttonGuardarEdicion.setRendered(true);
        this.buttonGuardarNuevo.setRendered(false);
        return null;

    }

    public String eliminar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

         if (getTareasRW().getSelectedRowsCount() > 0){
          RowKey[] selectedRowKeys = getTareasRW().getSelectedRowKeys();
          Tarea[] tareas = getSessionBean1().getListaTareas();
          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
          Tarea tarea = tareas[rowId];
          // Remove the Entity from the database using UserController
          TareaController tareaController = new TareaController();
          ControllerResult controllerResult = tareaController.delete(tarea);

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
        validarCampos();

        if (! errorValidacion){

            ProductoController productoController = new ProductoController();
            Producto productoGen = new Producto();
            Producto productoFin = new Producto();

            productoFin = productoController.findById(Long.valueOf(this.uiProductoFin.getSelected().toString()));
            productoGen = productoController.findById(Long.valueOf(this.uiProductoGen.getSelected().toString()));


            Equivalencia equivalencia = new Equivalencia();

            equivalencia.setCodProductoFin(productoFin);
            equivalencia.setCodProductoGen(productoGen);

            BigDecimal rel;
            rel = BigDecimal.valueOf(Double.valueOf(this.uiRelacion.getText().toString()));
//            rel = BigDecimal.valueOf(Long.valueOf(this.uiRelacion.getText().toString()));
            equivalencia.setRelacion(rel);

            
            EquivalenciaController equivalenciaController = new EquivalenciaController();

            ControllerResult controllerResult = new ControllerResult();
            controllerResult = equivalenciaController.create(equivalencia);


             if (controllerResult.getCodRetorno() ==-1) {
                    this.pageAlert1.setType("error");
                    this.errorValidacion=true;
                } else {
                    this.pageAlert1.setType("information");
                     cargarListaTodosProductosFin();
                     cargarListaTodosProductosGen();
                     cargarListaTodosEquivalencias();
                     this.errorValidacion=false;
                     this.updateRequest = false;
                     this.addRequest = false;
                     


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
            
            if (this.uiProductoGen.getSelected() == null)
                {
                   errorValidacion = true;
                   this.info(uiProductoFin, "Favor Seleccione el Producto Generico");
            } 

            if (this.uiProductoFin.getSelected() == null)
                {
                   errorValidacion = true;
                   this.info(uiProductoFin, "Favor Seleccione el Producto");
            }

            if (this.uiRelacion.getText() == null ||
                    this.uiRelacion.getText().equals(""))
            {
                   errorValidacion = true;
                   this.info(uiProductoFin, "Favor Ingrese la relacion");
            }else if(!StringUtils.esNumeroDecimal(this.uiRelacion.getText().toString())){
                   errorValidacion = true;
                   this.info(uiProductoFin, "Verifique la relacion");
            
            }


}

    public String buscar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.pageAlert1.setRendered(false);
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

    public String todos_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.pageAlert1.setRendered(false);
//        getSessionBean1().cargarListaTodosTipoProductos();
//        this.uiCodigoFil.setText("");
//        this.uiNombreFil.setText("");

        return null;
    }

    public String buttonGuardarEdicion_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
         updateRequest = true;
         validarCampos();

        if (! errorValidacion){


          Equivalencia eq = new EquivalenciaController().findById(getSessionBean1().getId());


           ProductoController productoController = new ProductoController();
            Producto productoGen = new Producto();
            Producto productoFin = new Producto();

            productoFin = productoController.findById(Long.valueOf(this.uiProductoFin.getSelected().toString()));
            productoGen = productoController.findById(Long.valueOf(this.uiProductoGen.getSelected().toString()));

            eq.setCodProductoFin(productoFin);
            eq.setCodProductoGen(productoGen);

            BigDecimal rel;
            rel = BigDecimal.valueOf(Long.valueOf(this.uiRelacion.getText().toString()));
            eq.setRelacion(rel);

          
            EquivalenciaController equivalenciaController = new EquivalenciaController();

            ControllerResult controllerResult = new ControllerResult();
            controllerResult = equivalenciaController.update(eq);


                             if (controllerResult.getCodRetorno() ==-1) {
                                    this.pageAlert1.setType("error");
                                    this.errorValidacion=true;
                                } else {
                                    updateRequest = false;
                                    this.pageAlert1.setType("information");
                                    cargarListaTodosProductosFin();
                                    cargarListaTodosProductosGen();
                                    cargarListaTodosEquivalencias();

                                }

                                this.pageAlert1.setTitle(controllerResult.getMsg());
                                this.pageAlert1.setSummary("");
                                this.pageAlert1.setDetail("");
                                this.pageAlert1.setRendered(true);
        }

        return null;
    }


////// CARGA DE COMBO BOX PRODUCTOS
    Producto[] listaProductosGen;
    Option[] listaProductosGenOp;

    public Producto[] getListaProductosGen() {
        return listaProductosGen;
    }
    public void setListaProductosGen(Producto[] listaProductosGen) {
        this.listaProductosGen = listaProductosGen;
    }
    public Option[] getListaProductosGenOp() {
        return listaProductosGenOp;
    }
    public void setListaProductosGenOp(Option[] listaProductosGenOp) {
        this.listaProductosGenOp = listaProductosGenOp;
    }
    public void cargarListaTodosProductosGen() {
        ProductoController productoController = new ProductoController();
        listaProductosGen = (Producto[]) productoController.getAllFiltered(null, null, "ProductoGenerico", null).toArray(new Producto[0]);
        listaProductosGenOp = new Option[listaProductosGen.length];
        Option option;
        for (int i = 0; i < listaProductosGen.length; i++) {
            Producto p = listaProductosGen[i];
            option = new Option();
            option.setLabel(p.getDescripcion());
            option.setValue(p.getCodProducto().toString());
            listaProductosGenOp[i] = option;
        }

    }


    ////// CARGA DE COMBO BOX PRODUCTOS
    Producto[] listaProductosFin;
    Option[] listaProductosFinOp;

    public Producto[] getListaProductosFin() {
        return listaProductosFin;
    }
    public void setListaProductosFin(Producto[] listaProductosFin) {
        this.listaProductosFin = listaProductosFin;
    }
    public Option[] getListaProductosFinOp() {
        return listaProductosFinOp;
    }
    public void setListaProductosFinOp(Option[] listaProductosFinOp) {
        this.listaProductosFinOp = listaProductosFinOp;
    }
    public void cargarListaTodosProductosFin() {
        ProductoController productoController = new ProductoController();
        listaProductosFin = (Producto[]) productoController.getInsumosMaterias(null, null, null).toArray(new Producto[0]);
        listaProductosFinOp = new Option[listaProductosFin.length];
        Option option;
        for (int i = 0; i < listaProductosFin.length; i++) {
            Producto p = listaProductosFin[i];
            option = new Option();
            option.setLabel(p.getDescripcion());
            option.setValue(p.getCodProducto().toString());
            listaProductosFinOp[i] = option;
        }

    }



    ////// FIN CARGA DE EQUIVALENCIAS

   private  Equivalencia[] listaEquivalencias;

    public Equivalencia[] getListaEquivalencias() {
        return listaEquivalencias;
    }

    public void setListaEquivalencias(Equivalencia[] listaEquivalencias) {
        this.listaEquivalencias = listaEquivalencias;
    }


        public void cargarListaTodosEquivalencias() {
        EquivalenciaController c = new EquivalenciaController();
        listaEquivalencias = (Equivalencia[]) c.getAllFiltered(null, null, null).toArray(new Equivalencia[0]);
        }









}





