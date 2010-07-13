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
import com.sun.webui.jsf.component.ImageHyperlink;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.Option;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.OrdenTrabajoCabeceraController;
import py.com.platinum.controller.OrdenTrabajoDetalleController;
import py.com.platinum.controller.PerdidaController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.TareaAsignadaController;
import py.com.platinum.controller.TareaFallidaController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.Perdida;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.TareaAsignada;
import py.com.platinum.entity.TareaFallida;
import py.com.platinum.utils.StringUtils;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ABMFallos.java
 * @version Created on Jul 7, 2010, 1:22:26 AM
 * @author FerBoy
 */

public class ABMFallos extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private HtmlPanelGrid gridPanelFiltros = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelFiltros() {
        return gridPanelFiltros;
    }

    public void setGridPanelFiltros(HtmlPanelGrid hpg) {
        this.gridPanelFiltros = hpg;
    }
    private HtmlPanelGrid gridPanelTabla = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelTabla() {
        return gridPanelTabla;
    }

    public void setGridPanelTabla(HtmlPanelGrid hpg) {
        this.gridPanelTabla = hpg;
    }
    private HtmlPanelGrid gridPanelAddUpdate = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelAddUpdate() {
        return gridPanelAddUpdate;
    }

    public void setGridPanelAddUpdate(HtmlPanelGrid hpg) {
        this.gridPanelAddUpdate = hpg;
    }
    private HtmlPanelGrid gridPanelPerdidas = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelPerdidas() {
        return gridPanelPerdidas;
    }

    public void setGridPanelPerdidas(HtmlPanelGrid hpg) {
        this.gridPanelPerdidas = hpg;
    }
    private TextField uiResponsableCod = new TextField();

    public TextField getUiResponsableCod() {
        return uiResponsableCod;
    }

    public void setUiResponsableCod(TextField tf) {
        this.uiResponsableCod = tf;
    }
    private TextField uiResponsableNombre = new TextField();

    public TextField getUiResponsableNombre() {
        return uiResponsableNombre;
    }

    public void setUiResponsableNombre(TextField tf) {
        this.uiResponsableNombre = tf;
    }
    private DropDown uiNroOt = new DropDown();

    public DropDown getUiNroOt() {
        return uiNroOt;
    }

    public void setUiNroOt(DropDown dd) {
        this.uiNroOt = dd;
    }
    private Calendar uiFecha = new Calendar();

    public Calendar getUiFecha() {
        return uiFecha;
    }

    public void setUiFecha(Calendar c) {
        this.uiFecha = c;
    }
    private TextField uiTareaAsignada = new TextField();

    public TextField getUiTareaAsignada() {
        return uiTareaAsignada;
    }

    public void setUiTareaAsignada(TextField tf) {
        this.uiTareaAsignada = tf;
    }
    private TextField uiTareaDesc = new TextField();

    public TextField getUiTareaDesc() {
        return uiTareaDesc;
    }

    public void setUiTareaDesc(TextField tf) {
        this.uiTareaDesc = tf;
    }
    private TextField uiCantidad = new TextField();

    public TextField getUiCantidad() {
        return uiCantidad;
    }

    public void setUiCantidad(TextField tf) {
        this.uiCantidad = tf;
    }
    private TextField uiRehacer = new TextField();

    public TextField getUiRehacer() {
        return uiRehacer;
    }

    public void setUiRehacer(TextField tf) {
        this.uiRehacer = tf;
    }
    private Button cancelButton = new Button();

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button b) {
        this.cancelButton = b;
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
    private TextField uiPerdidaCodProd = new TextField();

    public TextField getUiPerdidaCodProd() {
        return uiPerdidaCodProd;
    }

    public void setUiPerdidaCodProd(TextField tf) {
        this.uiPerdidaCodProd = tf;
    }
    private TextField uiPerdidaDescProd = new TextField();

    public TextField getUiPerdidaDescProd() {
        return uiPerdidaDescProd;
    }

    public void setUiPerdidaDescProd(TextField tf) {
        this.uiPerdidaDescProd = tf;
    }
    private TextField uiPerdidaCantidad = new TextField();

    public TextField getUiPerdidaCantidad() {
        return uiPerdidaCantidad;
    }

    public void setUiPerdidaCantidad(TextField tf) {
        this.uiPerdidaCantidad = tf;
    }
    private RadioButton radioButton1 = new RadioButton();

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton rb) {
        this.radioButton1 = rb;
    }
    private TableColumn tableColumn1 = new TableColumn();

    public TableColumn getTableColumn1() {
        return tableColumn1;
    }

    public void setTableColumn1(TableColumn tc) {
        this.tableColumn1 = tc;
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
    private Calendar uiFecha1Fil = new Calendar();

    public Calendar getUiFecha1Fil() {
        return uiFecha1Fil;
    }

    public void setUiFecha1Fil(Calendar c) {
        this.uiFecha1Fil = c;
    }
    private TextField uiCodOtFil = new TextField();

    public TextField getUiCodOtFil() {
        return uiCodOtFil;
    }

    public void setUiCodOtFil(TextField tf) {
        this.uiCodOtFil = tf;
    }
    private DropDown uiResponsableFil = new DropDown();

    public DropDown getUiResponsableFil() {
        return uiResponsableFil;
    }

    public void setUiResponsableFil(DropDown dd) {
        this.uiResponsableFil = dd;
    }
    private Calendar uiFecha2Fil = new Calendar();

    public Calendar getUiFecha2Fil() {
        return uiFecha2Fil;
    }

    public void setUiFecha2Fil(Calendar c) {
        this.uiFecha2Fil = c;
    }
    private ImageHyperlink uiEditDetalle = new ImageHyperlink();

    public ImageHyperlink getUiEditDetalle() {
        return uiEditDetalle;
    }

    public void setUiEditDetalle(ImageHyperlink ih) {
        this.uiEditDetalle = ih;
    }
    private TableColumn tableColumn11 = new TableColumn();

    public TableColumn getTableColumn11() {
        return tableColumn11;
    }

    public void setTableColumn11(TableColumn tc) {
        this.tableColumn11 = tc;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ABMFallos() {
    cargarListaTodosOts();
    cargarListaTodosTareasFallidas();
    
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
            log("ABMFallos Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here

      getSessionBean1().setTituloPagina("Tareas Fallidas");
      getSessionBean1().setDetallePagina("Registro de tareas fallidas y Perdidas");

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
            gridPanelFiltros.setRendered(false);
            gridPanelTabla.setRendered(false);
            gridPanelAddUpdate.setRendered(true);
            gridPanelPerdidas.setRendered(true);

            getSessionBean1().setTituloPagina("Registro de Tareas Fallidas");
            getSessionBean1().setDetallePagina("Insertar nuevo Registro");
          

        } else if (updateRequest) {
            //if (getTableRowGroup1().getSelectedRowsCount() > 0) {
            gridPanelFiltros.setRendered(false);
            gridPanelTabla.setRendered(false);
            gridPanelAddUpdate.setRendered(true);
            gridPanelPerdidas.setRendered(true);

            getSessionBean1().setTituloPagina("Registro de Tareas Fallidas");
            getSessionBean1().setDetallePagina("Edicion de Registro");
           

            
            //}
        } else if(errorValidacion){
            gridPanelFiltros.setRendered(false);
            gridPanelTabla.setRendered(false);
            gridPanelAddUpdate.setRendered(true);
            gridPanelPerdidas.setRendered(true);


        }else {
            gridPanelFiltros.setRendered(true);
            gridPanelTabla.setRendered(true);
            gridPanelAddUpdate.setRendered(false);
            gridPanelPerdidas.setRendered(false);
            
            getSessionBean1().setTituloPagina("Registro de Tareas Fallidas");
            getSessionBean1().setDetallePagina("Seleccionar el registro");
           
        }
        buscar_action2();

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

    public void uiFecha1Fil_processValueChange(ValueChangeEvent event) {
    }


    public String cancelButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        addRequest = false;
        updateRequest = false;

        return null;
    }

    public String addRecordButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
         validarCampos();
        if (! errorValidacion){
                            TareaFallida tareaFallida = new TareaFallida();

                            ProductoController productoController = new ProductoController();
                            EmpleadoController empleadoController = new EmpleadoController();
                            TareaAsignadaController tareaAsignadaController = new TareaAsignadaController();
                            OrdenTrabajoDetalleController otDetController = new OrdenTrabajoDetalleController();

                            tareaFallida.setCodEmpleado(empleadoController.findById(Long.valueOf(this.uiResponsableCod.getText().toString())));
                            tareaFallida.setCodTareaAsignada(tareaAsignadaController.findById(Long.valueOf(this.uiTareaAsignada.getText().toString())));
                            tareaFallida.setCantidad(Long.valueOf(this.uiCantidad.getText().toString()));
                            tareaFallida.setFecha(this.uiFecha.getSelectedDate());
                            tareaFallida.setFechaAlta(this.uiFecha.getSelectedDate());


                            TareaFallidaController tareaFallidaController = new TareaFallidaController();

                            ControllerResult controllerResult = new ControllerResult();
                            controllerResult = tareaFallidaController.createCabDet(tareaFallida, detallesPerdida);


                             if (controllerResult.getCodRetorno() ==-1) {
                                    this.pageAlert1.setType("error");
                                    this.errorValidacion=true;


                                } else {
                                    this.pageAlert1.setType("information");
                                    addRequest = false;
                                    updateRequest = false;

                                }

                                this.pageAlert1.setTitle(controllerResult.getMsg());
                                this.pageAlert1.setSummary("");
                                this.pageAlert1.setDetail("");
                                this.pageAlert1.setRendered(true);

    }

        return null;
    }

    public String updateRecordButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public void uiResponsableNombre_processValueChange(ValueChangeEvent event) {
    }
    

    ////// CARGA DE COMBO BOX DE ORDEN TRABAJO
    OrdenTrabajo[] listaOts;
    Option[] listaOtsOp;

    public Option[] getlistaOtsOp() {
        return listaOtsOp;
    }

    public void setlistaOtsOp(Option[] listaOtsOp) {
        this.listaOtsOp = listaOtsOp;
    }

    public OrdenTrabajo[] listaOts() {
        return listaOts;
    }

    public void setlistaOts(OrdenTrabajo[] listaOts) {
        this.listaOts = listaOts;
    }

    public void cargarListaTodosOts() {
        OrdenTrabajoCabeceraController otController = new OrdenTrabajoCabeceraController();
        listaOts = (OrdenTrabajo[]) otController.getAllFiltered(null,null,"P",null).toArray(new OrdenTrabajo[0]);
        listaOtsOp = new Option[listaOts.length];
        Option option;
        for (int i = 0; i < listaOts.length; i++) {
            OrdenTrabajo p = listaOts[i];
            option = new Option();
            option.setLabel(p.getCodOrdenTrabjo().toString()+" "+p.getCodProductoOt().getDescripcion());
            option.setValue(p.getCodOrdenTrabjo().toString());
            listaOtsOp[i] = option;
        }
    }


//    public void uiNroOt_validate(FacesContext context, UIComponent component, Object value) {
//
//
//        OrdenTrabajoDetalleController ordenTrabajoDetalleController = new OrdenTrabajoDetalleController();
//        OrdenTrabajoDetalle otDet = ordenTrabajoDetalleController.findById(Long.valueOf(value.toString()));
//
//         TareaAsignadaController tareaAsignadaController = new TareaAsignadaController();
//         tareasAsignadas = tareaAsignadaController.getAllFilteredOT(otDet.getCodOrdenTrabajo().getCodOrdenTrabjo().longValue(), null, null);
//         tareasAsignadasArray = (
//         getSessionBean1().setTareasAsignadasArray(tareasAsignadasArray);
//
//    }
////// FIN CARGA DE COMBO BOX OTS
    private Long idPerdidaEditada;

    public Long getIdPerdidaEditada() {
        return idPerdidaEditada;
    }

    /// Se define esta variable ID para hacer la busqueda del objeto a actualizar en la actualizacion de los abm
    public void setIdPerdidaEditada(Long idPerdidaEditada) {
        this.idPerdidaEditada = idPerdidaEditada;
    }
//
    public String uiBuscarButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        this.pageAlert1.setRendered(false);
        return null;

    }

    public String buscar_action2() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        Long pCodOt=null, pCodResponsable=null;
        Date pFecha1=null,pFecha2=null;
        Date pFechaOt=null;

        if (this.uiCodOtFil.getText()!=null && StringUtils.esNumero(uiCodOtFil.getText().toString())) {
            pCodOt = Long.valueOf(this.uiCodOtFil.getText().toString());
        }
        if (this.uiResponsableFil.getSelected()!=null && StringUtils.esNumero(this.uiResponsableFil.getSelected().toString())) {
            pCodResponsable= Long.valueOf(this.uiResponsableFil.getSelected().toString());
        }

        if (this.uiFecha1Fil.getSelectedDate()!=null) {
            pFecha1= this.uiFecha1Fil.getSelectedDate();
        }
        if (this.uiFecha2Fil.getSelectedDate()!=null) {
            pFecha2= this.uiFecha2Fil.getSelectedDate();
        }
           TareaFallidaController tareaFallidaController = new TareaFallidaController();
        listaTareasFallidas = (TareaFallida[]) tareaFallidaController.getAllFilteredFil(pCodOt, null, null, pCodResponsable, pFecha1, pFecha2).toArray(new TareaFallida[0]);


        return null;
    }

       public String uiTodosButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

//
//        listaPerdidas = (Perdida[]) new PerdidaController().getAll("codPerdida").toArray(new Perdida[0]);
//        setlistaPerdidas(listaPerdidas);

        this.uiResponsableFil.setSelected(null);
        this.uiCodOtFil.setText("");
        this.uiFecha1Fil.setSelectedDate(null);
        this.uiFecha2Fil.setSelectedDate(null);

        return null;
    }


      ////// CARGA DE COMBO BOX Tareas Fallidas
//////     import com.sun.webui.jsf.model.Option;
    TareaFallida[] listaTareasFallidas;
    Option[] listaTareasFallidasOp;

    public Option[] getListaTareasFallidasOp() {
        return listaTareasFallidasOp;
    }

    public void setListaTareasFallidasOp(Option[] listaTareasFallidasOp) {
        this.listaTareasFallidasOp = listaTareasFallidasOp;
    }

    public TareaFallida[] getListaTareasFallidas() {
        return listaTareasFallidas;
    }

    public void setListaTareasFallidas(TareaFallida[] listaTareasFallidas) {
        this.listaTareasFallidas = listaTareasFallidas;
    }

    public void cargarListaTodosTareasFallidas() {
        TareaFallidaController tareaFallidaController = new TareaFallidaController();
        listaTareasFallidas = (TareaFallida[]) tareaFallidaController.getAll("codTareaFallida").toArray(new TareaFallida[0]);
        listaTareasFallidasOp = new Option[listaTareasFallidas.length];
        Option option;
        for (int i = 0; i < listaTareasFallidas.length; i++) {
            TareaFallida tp = listaTareasFallidas[i];
            option = new Option();
            option.setLabel(tp.getCodTareaAsignada().getCodTarea().getNombreTarea());
            option.setValue(tp.getCodTareaFallida().toString());
            listaTareasFallidasOp[i] = option;
        }
    }

     private String itemDet;

    public String getItemDet() {
        return itemDet;
    }

    public void setItemDet(String itemDet) {
        this.itemDet = itemDet;
    }
    public String uiBtnNuevo_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        addRequest = true;
        updateRequest = false;
          limpiarCamposNew();
          itemDet = null;
        this.addRecordButton.setRendered(true);
        this.updateRecordButton.setRendered(false);
        this.pageAlert1.setRendered(false);

        detallePerdidaList = new ArrayList();
        detallesPerdida = (Perdida[]) detallePerdidaList.toArray(new Perdida[0]);

        aux = 0;
        


        return null;
    }

    public String uiBtnEditar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        updateRequest = true;
        addRequest = false;

        this.pageAlert1.setRendered(false);

        this.addRecordButton.setRendered(false);
        this.updateRecordButton.setRendered(true);
        cargarCamposUpdate();
        return null;
    }

    public String uiBtnEliminar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
     
        detallePerdidaList = new ArrayList();
        detallesPerdida = (Perdida[]) detallePerdidaList.toArray(new Perdida[0]);

        updateRequest = false;
        addRequest = false;
        

         if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
                TareaFallida[] tareasFallidas = this.listaTareasFallidas;
                int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
                TareaFallida tareaFallida = tareasFallidas[rowId];

                TareaFallidaController tareaFallidaController = new TareaFallidaController();
                getSessionBean1().setId(tareaFallida.getCodTareaFallida());

        /// ELIMINACION DE LOS DETALES
                detallePerdidaList = new ArrayList();
                
                detallePerdidaList = tareaFallidaController.getAllPerdidasTarea(tareaFallida.getCodTareaFallida());
                detallesPerdida = (Perdida[]) detallePerdidaList.toArray(new Perdida[0]);

                ControllerResult controllerResult = new ControllerResult();
                controllerResult = tareaFallidaController.deleteTareaPerdida(tareaFallida,detallesPerdida);



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
    private boolean errorValidacionDetalle = false;


    public void limpiarCamposNew(){


            this.uiResponsableCod.setText("");
            this.uiResponsableNombre.setText("");
            this.uiTareaAsignada.setText("");
            this.uiCantidad.setText("");
            this.uiRehacer.setText("");
            this.uiFecha.setSelectedDate(new Date());

    }

public void cargarCamposUpdate(){
//         if (getTableRowGroup1().getSelectedRowsCount() > 0){
//          RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
//          Perdida[] perdidas = listaPerdidas;
//          int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
//          Perdida perdida = perdidas[rowId];
//
//          this.idPerdidaEditada = perdida.getCodPerdida();
//         //// CARGA DE CAMPOS DE LA PAGINA
//
//
//         this.uiResponsableCod.setText(perdida.getCodEmpleado().getCodEmpleado().toString());
//         this.uiResponsableNombre.setText(perdida.getCodEmpleado().getNombreEmpleado().toString());
//         this.uiFecha.setSelectedDate(perdida.getFechaPerdida());
//         this.uiTareaAsignada.setText(perdida.getCodProducto().getCodProducto().toString());
//         this.uiProductoDesc.setText(perdida.getCodProducto().getDescripcion().toString());
//         this.uiCantidad.setText(String.valueOf(perdida.getCantidadPerdida()));
//
//         if (perdida.getCodOrdenTrabajoDetalle() != null) {
//                     this.uiNroOt.setSelected(perdida.getCodOrdenTrabajoDetalle().getCodOrdenTrabajoDet().toString());
//             }
//
//
//         this.uiResponsableCod.setText(perdida.getCodEmpleado().getCodEmpleado().toString());
//         }

    }
private void validarCampos(){
        //Variables
//        boolean errorValidacion;

        //Inicializar
        errorValidacion = false;

        this.errorValidacion = false;

    if (detallesPerdida.length < 1) {
            info("Debe ingresar los detalles de Perdidas de Materias Primas e Insumos");
            errorValidacion = true;
    }

        if (this.uiResponsableCod.getText() == null) {
            info("Nombre del empleado obligatorio, ingrese un valor");
            errorValidacion = true;
        }else if (!StringUtils.esNumero(this.uiResponsableCod.getText().toString())) {
            info("Valor incorrecto para Codidgo de Responsable, debe ser un numero");
            errorValidacion = true;
        }else{

             Empleado e   = new EmpleadoController().findById(Long.valueOf(uiResponsableCod.getText().toString()));
                        if (e == null) {
                            this.errorValidacion= true;
                            info("Verifique el codigo del Empleado Responsable");
                        }
        }

        if (this.uiTareaAsignada.getText() == null) {
            info("La tarea asignada es un campo obligatorio, ingrese un valor");
            errorValidacion = true;
        } else if (!StringUtils.esNumero(this.uiTareaAsignada.getText().toString())) {
            info("Valor incorrecto para el codigo de tarea, debe ser un numero");
            errorValidacion = true;
        }else{
                TareaAsignada p = new TareaAsignadaController().findById(Long.valueOf(uiTareaAsignada.getText().toString()));
                if (p == null) {
                        this.errorValidacion= true;
                        info("Verifique el codigo de Tarea");
                }else{
                    if (this.uiCantidad.getText() != null && StringUtils.esNumero(this.uiCantidad.getText().toString())) {
                        if (Long.valueOf(p.getCantidadReal().longValue()) < Long.valueOf(this.uiCantidad.getText().toString())) {
                                this.errorValidacion= true;
                                info("La cantidad fallida no puede superar la cantidad efectuada");
                        }
                    }

                }
        }

        if (this.uiCantidad.getText() == null) {
            info("Cantidad es un campo obligatorio, ingrese un valor");
            errorValidacion = true;
        } else if (!StringUtils.esNumero(this.uiCantidad.getText().toString())) {
            info("Valor incorrecto para Cantidad a , debe ser un numero");
            errorValidacion = true;
       }


        if (this.uiRehacer.getText() == null) {
            info("Cantidad a Rehacer es un campo obligatorio, ingrese un valor");
            errorValidacion = true;
        } else if (!StringUtils.esNumero(this.uiRehacer.getText().toString())) {
            info("Valor incorrecto para Cantidad a rehacer, debe ser un numero");
            errorValidacion = true;
        }
        
        if (this.uiRehacer.getText() != null && !StringUtils.esNumero(this.uiRehacer.getText().toString())
            &&(this.uiCantidad.getText() == null && StringUtils.esNumero(this.uiCantidad.getText().toString())) ) {
                if (Long.valueOf(uiRehacer.getText().toString()) > Long.valueOf(uiCantidad.getText().toString())) {
                info("La cantidad a rehacer debe ser menor o igual a la cantidad producida");
                errorValidacion = true;
            }
                
        }



    }

private void validarCamposDetalle(){

errorValidacionDetalle = false;
 if (this.uiResponsableCod.getText() == null) {
            info("Nombre del empleado obligatorio, ingrese un valor");
            errorValidacionDetalle = true;
        }else if (!StringUtils.esNumero(this.uiResponsableCod.getText().toString())) {
            info("Valor incorrecto para Codidgo de Responsable, debe ser un numero");
            errorValidacionDetalle = true;
        }else{

             Empleado e   = new EmpleadoController().findById(Long.valueOf(uiResponsableCod.getText().toString()));
                        if (e == null) {
                            this.errorValidacionDetalle= true;
                            info("Verifique el codigo del Empleado Responsable");
                        }
        }


if (this.uiPerdidaCantidad.getText() == null) {
            info("Cantidad es un campo obligatorio, ingrese un valor");
            errorValidacionDetalle = true;
        } else if (!StringUtils.esNumero(this.uiPerdidaCantidad.getText().toString())) {
            info("Valor incorrecto para Cantidad a , debe ser un numero");
            errorValidacionDetalle = true;
 }
 if (this.uiPerdidaCodProd.getText() == null) {
            info("Ingrese un codigo de Producto");
            errorValidacionDetalle = true;
        } else if (!StringUtils.esNumero(this.uiPerdidaCodProd.getText().toString())) {
            info("Valor incorrecto para el codigo de Producto, debe ser un numero");
            errorValidacionDetalle = true;
        }else{
                Producto p = new ProductoController().findById(Long.valueOf(uiPerdidaCodProd.getText().toString()));
                if (p == null) {
                        this.errorValidacionDetalle= true;
                        info("Verifique el codigo de Producto");
                }else{
                    if (!p.getCodTipoProducto().getDescripcion().equals("Insumo") && !p.getCodTipoProducto().getDescripcion().equals("MateriaPrima")) {
                        this.errorValidacionDetalle= true;
                        info("Favor seleccione un Insumo o Materia Prima");
                    }

                }
        }
}
/// MANEJO DE LOS DETALLES DE PERDIDAS


private Perdida[] detallesPerdida;
private Perdida  detallePerdida;
private List<Perdida>  detallePerdidaList;
private long aux;



    public String uiBtnAgregarDetalle_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarCamposDetalle();
        if (!errorValidacionDetalle) {

                aux ++;

                Perdida perdida = new Perdida();
                Producto prod = new Producto();
                prod = new ProductoController().findById(Long.valueOf(this.uiPerdidaCodProd.getText().toString()));

                perdida.setCodPerdida(Long.valueOf(aux));
                perdida.setCodProducto(prod);
                perdida.setCantidadPerdida(Long.valueOf(this.uiPerdidaCantidad.getText().toString()));
                perdida.setFechaPerdida(new Date());
                perdida.setFechaAlta(new Date());
                perdida.setTaller("D");
                perdida.setCodEmpleado(new EmpleadoController().findById(Long.valueOf(this.uiResponsableCod.getText().toString())));
                perdida.setObservacion("Perdida Generada por fallo de tareas");
                perdida.setPrecioUnit(BigInteger.valueOf(prod.getContenido().longValue()));
                perdida.setTotal(BigInteger.valueOf(perdida.getCantidadPerdida() * perdida.getPrecioUnit().longValue()));



                detallePerdidaList.add(perdida);
                detallesPerdida = (Perdida[]) detallePerdidaList.toArray(new Perdida[0]);

        }

        return null;
    }

    public boolean isAddRequest() {
        return addRequest;
    }

    public void setAddRequest(boolean addRequest) {
        this.addRequest = addRequest;
    }

    public Perdida getDetallePerdida() {
        return detallePerdida;
    }

    public void setDetallePerdida(Perdida detallePerdida) {
        this.detallePerdida = detallePerdida;
    }

    public List<Perdida> getDetallePerdidaList() {
        return detallePerdidaList;
    }

    public void setDetallePerdidaList(List<Perdida> detallePerdidaList) {
        this.detallePerdidaList = detallePerdidaList;
    }

    public Perdida[] getDetallesPerdida() {
        return detallesPerdida;
    }

    public void setDetallesPerdida(Perdida[] detallesPerdida) {
        this.detallesPerdida = detallesPerdida;
    }

    public boolean isErrorValidacion() {
        return errorValidacion;
    }

    public void setErrorValidacion(boolean errorValidacion) {
        this.errorValidacion = errorValidacion;
    }

    public OrdenTrabajo[] getListaOts() {
        return listaOts;
    }

    public void setListaOts(OrdenTrabajo[] listaOts) {
        this.listaOts = listaOts;
    }

    public Option[] getListaOtsOp() {
        return listaOtsOp;
    }

    public void setListaOtsOp(Option[] listaOtsOp) {
        this.listaOtsOp = listaOtsOp;
    }

   
    public TableSelectPhaseListener getTablePhaseListener() {
        return tablePhaseListener;
    }

    public void setTablePhaseListener(TableSelectPhaseListener tablePhaseListener) {
        this.tablePhaseListener = tablePhaseListener;
    }



    public boolean isUpdateRequest() {
        return updateRequest;
    }

    public void setUpdateRequest(boolean updateRequest) {
        this.updateRequest = updateRequest;
    }

    public String uiEditDetalle_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
         //Eliminamos de la lista temporal el detalle
        detallePerdidaList.remove(Integer.valueOf(itemDet).intValue());
        detallesPerdida = (Perdida[]) detallePerdidaList.toArray(new Perdida[0]);
       return null;
    }

    public void uiNroOt_validator(FacesContext context, UIComponent component, Object value) {

        OrdenTrabajoCabeceraController ordenTrabajoController = new OrdenTrabajoCabeceraController();
        OrdenTrabajo otDet = ordenTrabajoController.findById(Long.valueOf(value.toString()));

         getSessionBean1().setIdOTProdDiaria(Long.valueOf(value.toString()));
         TareaAsignadaController tareaAsignadaController = new TareaAsignadaController();
         tareasAsignadas = tareaAsignadaController.getAllFilteredOT(otDet.getCodOrdenTrabjo().longValue(), null, null);
         tareasAsignadasArray = (TareaAsignada[]) tareasAsignadas.toArray(new TareaAsignada[0]);
         getSessionBean1().setTareasAsignadasArray(tareasAsignadasArray);


    }

 List<TareaAsignada>  tareasAsignadas = new ArrayList();
 TareaAsignada[]  tareasAsignadasArray = new TareaAsignada[0];

    public List<TareaAsignada> getTareasAsignadas() {
        return tareasAsignadas;
    }

    public void setTareasAsignadas(List<TareaAsignada> tareasAsignadas) {
        this.tareasAsignadas = tareasAsignadas;
    }

    public TareaAsignada[] getTareasAsignadasArray() {
        return tareasAsignadasArray;
    }

    public void setTareasAsignadasArray(TareaAsignada[] tareasAsignadasArray) {
        this.tareasAsignadasArray = tareasAsignadasArray;
    }

}

