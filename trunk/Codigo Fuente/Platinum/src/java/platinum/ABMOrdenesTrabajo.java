/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package platinum;



import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.ImageHyperlink;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Tab;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.ValueChangeEvent;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.FormulaCabeceraController;
import py.com.platinum.controller.FormulaDetalleController;
import py.com.platinum.controller.FormulaSemiCabeceraController;
import py.com.platinum.controller.FormulaSemiDetalleController;
import py.com.platinum.controller.OrdenTrabajoCabeceraController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.TareaController;
import py.com.platinum.controller.TareaFormulaController;
import py.com.platinum.controller.TipoProductoController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.FormulaCabecera;
import py.com.platinum.entity.FormulaDetalle;
import py.com.platinum.entity.FormulaSemiCabecera;
import py.com.platinum.entity.FormulaSemiDetalle;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.RecursoAsignado;
import py.com.platinum.entity.Tarea;
import py.com.platinum.entity.TareaAsignada;
import py.com.platinum.entity.TareaFormula;
import py.com.platinum.entity.TipoProducto;
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
public class ABMOrdenesTrabajo extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */

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


    ////// CARGA DE ARRAY ORDENES TRABAJO
//////     import com.sun.webui.jsf.model.Option;

    OrdenTrabajo[] listaOrdenTrabajoCabeceras;


        public OrdenTrabajo[] getlistaOrdenTrabajoCabeceras() {
        return listaOrdenTrabajoCabeceras;
    }

    public void setlistaOrdenTrabajoCabeceras(OrdenTrabajo[] listaOrdenTrabajoCabeceras) {
        this.listaOrdenTrabajoCabeceras = listaOrdenTrabajoCabeceras;
    }

    public void cargarlistaTodosOrdenTrabajoCabeceras(){
        OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();
        listaOrdenTrabajoCabeceras = (OrdenTrabajo[]) ordenTrabajoCabeceraController.getAll("estadoOt").toArray(new OrdenTrabajo[0]);

    }
////// FIN CARGA DE ot cabeceras
    private String buscar_action2() {

        OrdenTrabajo[] listaOrdenTrabajos;
        OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();

        String pNumeroOrdenTrabajo=null, pCodProducto=null, pEstado=null;
        Date pFechaOt=null;

        if (this.uiNumOtFil.getText()!=null) {
            pNumeroOrdenTrabajo = this.uiNumOtFil.getText().toString();
        }

        if (this.uiProductoFil.getSelected()!=null && !this.uiTodosFil.isChecked()) {
            pCodProducto = this.uiProductoFil.getSelected().toString();
        }

        if (this.uiFechaDesdeFil.getSelectedDate()!=null) {
            pFechaOt= this.uiFechaDesdeFil.getSelectedDate();
        }

        if (this.uiEstadoFil.getSelected()!=null) {
            if (!this.uiEstadoFil.getSelected().equals("X")){
                pEstado= this.uiEstadoFil.getSelected().toString();
            }
        }
         

        listaOrdenTrabajoCabeceras = (OrdenTrabajo[]) ordenTrabajoCabeceraController.getAllFiltered
                                        (pNumeroOrdenTrabajo,
                                         pCodProducto,
                                         pEstado,
                                         pFechaOt).toArray(new OrdenTrabajo[0]);

        setlistaOrdenTrabajoCabeceras(listaOrdenTrabajoCabeceras);
        return null;

    }



    public String uiButtonCalcularFormula_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        long multiplicador;

        if (!validarFormula()) {
            FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();
            FormulaDetalleController formulaDetalleController = new FormulaDetalleController();
            FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
            FormulaSemiDetalleController formulaSemiDetalleController = new FormulaSemiDetalleController();
            TareaFormulaController tareaFormulaController = new TareaFormulaController();

            FormulaCabecera formulaSeleccionada = new FormulaCabecera();
            FormulaDetalle formulaDetalleSeleccionada = new FormulaDetalle();
            FormulaSemiCabecera formulaSemiCabeceraSeleccionada = new FormulaSemiCabecera();
            FormulaSemiDetalle formulaSemiDetalleSeleccionado = new FormulaSemiDetalle();
            TareaFormula tareaFormulaSeleccionada = new TareaFormula();

            formulaSeleccionada = formulaCabeceraController.findById(Long.valueOf(this.uiFormulaCodigo.getText().toString()));
            multiplicador = Long.valueOf(this.uiCantidad.getText().toString()) / Long.valueOf(formulaSeleccionada.getCantidad().toString());

            List<FormulaDetalle> formulaDetalleSeleccionadoList = formulaDetalleController.getAllFilteredByCabecera(formulaSeleccionada.getCodFormula());

            for (int i = 0; i < formulaDetalleSeleccionadoList.size(); i++) {
                formulaDetalleSeleccionada = formulaDetalleSeleccionadoList.get(i);
                idAuxiliar ++;
                //// CONSTRUIR MI OBJETO DETALLE OT A PARTIR DE LA FORMULA
                   detalleOrdenTrabajo = new OrdenTrabajoDetalle();

                   Producto producto = new ProductoController().findById(Long.valueOf(formulaDetalleSeleccionada.getCodProducto().getCodProducto()));
                   Empleado empleado = new EmpleadoController().findById(Long.valueOf(this.uiResponsableCodigo.getText().toString()));
                   detalleOrdenTrabajo.setCodProducto(producto);
                   detalleOrdenTrabajo.setCodEmpleado(empleado);
                   detalleOrdenTrabajo.setCantidad(Long.valueOf(formulaDetalleSeleccionada.getCantidad().toString())* multiplicador );
                   detalleOrdenTrabajo.setEstado("A");
                   detalleOrdenTrabajo.setRecursoAsignadoCollection(new HashSet());
                   detalleOrdenTrabajo.setTareaAsignadaCollection(new HashSet());
                   detalleOrdenTrabajoList.add(detalleOrdenTrabajo);
                   detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);

                   //// RECORRER LA LISTA DE DETALLES PARA AGREGAR SUS RECURSOS Y TAREAS
                   formulaSemiCabeceraSeleccionada = formulaSemiCabeceraController.findById(formulaDetalleSeleccionada.getCodFormulaSemiCabecera().getCodFormulaSemiCabecera());

                    for (int j = 0; j < formulaSemiCabeceraSeleccionada.getFormulaSemiDetalleList().size(); j++) {
                                FormulaSemiDetalle formulaSemiDetalle = new FormulaSemiDetalle();
                                formulaSemiDetalle = formulaSemiCabeceraSeleccionada.getFormulaSemiDetalleListList().get(j);
                                    idAuxiliar ++;
                                    RecursoAsignado recursoAsignado = new RecursoAsignado();
                                    recursoAsignado.setCodRecurso(idAuxiliar);
                                    recursoAsignado.setFecha(this.uiFechaIni.getSelectedDate());
                                    recursoAsignado.setCodProducto(formulaSemiDetalle.getCodProducto());
                                    recursoAsignado.setCantidad(Long.valueOf(formulaSemiDetalle.getCantidad().toString())* multiplicador);
                                    detalleOrdenTrabajo.getRecursoAsignadoCollection().add(recursoAsignado);
                    }

                   for (int j = 0; j < formulaSemiCabeceraSeleccionada.getTareaFormulaListList().size(); j++) {
                        TareaFormula tareaFormula = new TareaFormula();
                        tareaFormula = formulaSemiCabeceraSeleccionada.getTareaFormulaListList().get(j);
                        idAuxiliar ++;
                        TareaAsignada tareaAsignada = new TareaAsignada();
                        tareaAsignada.setCodTareaAsignada(idAuxiliar);
                        tareaAsignada.setCodTarea(tareaFormula.getCodTarea());
                        tareaAsignada.setCantidad(Long.valueOf(tareaFormula.getCantidadTarea().toString()) * multiplicador);
                        tareaAsignada.setOrdenTarea(Long.valueOf(tareaFormula.getOrdenTarea().toString()));
                        detalleOrdenTrabajo.getTareaAsignadaCollection().add(tareaAsignada);

                   }


                }
       }

        return null;
    }

    private boolean validarFormula(){
        //Variables
        boolean r = false;


            if (detalleOrdenTrabajoList.size() > 0){
                  info("No se puede calcular mientras la formula posea detalles");
            r = true;
        }

        if (uiNroOT.getText().toString() == null || uiNroOT.getText().equals("") ) {
        info("Campo obligatorio, favor ingrese el Numero de OT");
            r = true;
        }

        if (uiResponsableCodigo.getText().toString() == null || uiResponsableCodigo.getText().equals("") ) {
        info("Campo obligatorio, favor ingrese el Responsable");
            r = true;
        }

        if (uiDescripcionOt.getText() == null) {
        info("Campo obligatorio, favor ingrese la descripcion de la Orden de Trabajo");
            r = true;
        }

        if (uiProducto.getSelected() == null || uiProducto.getSelected().equals("") ) {
        info("Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }

        if (uiFormulaCodigo.getText().toString() == null || uiFormulaCodigo.getText().equals("") ) {
        info("Campo obligatorio, favor ingrese el Codigo de Formula");
            r = true;
        }

        if (!StringUtils.esNumero(this.uiCantidad.getText().toString()))
            {   r = true;
          this.info(uiCantidad, "La cantidad debe ser campo numerico");
            }

        return r;
    }



    //MANEJO DE LOS DETALLES

private OrdenTrabajoDetalle[] detallesOrdenTrabajo;
private OrdenTrabajoDetalle  detalleOrdenTrabajo;
private List<OrdenTrabajoDetalle>  detalleOrdenTrabajoList;

private TareaAsignada[] tareasAsignadasOt;
private TareaAsignada  tareaAsignadaOt;
private List<TareaAsignada>  tareaAsignadaList;
private List<TareaAsignada>  tareaAsignadaMostradaList;

private RecursoAsignado[] recursosAsignadosOt;
private RecursoAsignado  recursoAsignadoOt;
private List<RecursoAsignado>  recursoAsignadoList;
private List<RecursoAsignado>  recursoAsignadoMostradoList;

private List<OrdenTrabajoDetalle>  detalleOrdenTrabajoEliminadaList;
private List<TareaAsignada>  tareaAsignadaEliminadaList;
private List<RecursoAsignado>  recursoAsignadoEliminadoList;



    private boolean validarCampos(){
        //Variables
        boolean r;

        //Inicializar
        r = false;

        if (detalleOrdenTrabajoList.size() < 0){
        info("Debe cargar los detalles de productos de la formula");
            r = true;
        }

        if (uiNroOT.getText().toString() == null || uiNroOT.getText().equals("") ) {
        info("Campo obligatorio, favor ingrese el Numero de OT");
            r = true;
        }
        if (uiResponsableCodigo.getText().toString() == null || uiResponsableCodigo.getText().equals("") ) {
        info("Campo obligatorio, favor ingrese el Responsable");
            r = true;
        }

        if (uiDescripcionOt.getText() == null) {
        info("Campo obligatorio, favor ingrese la descripcion de la Orden de Trabajo");
            r = true;
        }


        if (uiProducto.getSelected() == null || uiProducto.getSelected().equals("") ) {
        info("Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }

//        if (uiFormulaCodigo.getText()== null || uiFormulaCodigo.getText().equals("") ) {
//        info("Campo obligatorio, favor ingrese el Codigo de Formula");
//            r = true;
//        }

        
        
        if (!StringUtils.esNumero(this.uiCantidad.getText().toString()))
            {   r = true;
          this.info(uiCantidad, "La cantidad debe ser campo numerico");
            }

         if (uiFechaIni.getSelectedDate() == null || uiFechaIni.getSelectedDate().equals("") ) {
        info("Campo obligatorio, favor seleccione la fecha de Inicio");
            r = true;
        }


         if (uiFechaFin.getSelectedDate() == null || uiFechaFin.getSelectedDate().equals("") ) {
        info("Campo obligatorio, la fecha de Finalizacion estimada");
            r = true;
        }


        if (!StringUtils.esNumero(this.uiCostoPrevisto.getText().toString()))
            {   r = true;
        this.info(uiCantidad, "La cantidad debe ser campo numerico");
            }


        if (!StringUtils.esNumero(this.uiCostoReal.getText().toString()))
            {   r = true;
        this.info(uiCantidad, "El costo debe ser campo numerico");
            }


        if (uiEstado.getSelected() == null ) {
        info(uiEstado, "Campo obligatorio, favor seleccione el estado de la OT");
            r = true;
        }
        //result

        return r;
    }


    private void _init() throws Exception {

    }
    private PageAlert pageAlert1 = new PageAlert();

    public PageAlert getPageAlert1() {
        return pageAlert1;
    }

    public void setPageAlert1(PageAlert pa) {
        this.pageAlert1 = pa;
    }
    private TextField uiNumOtFil = new TextField();

    public TextField getUiNumOtFil() {
        return uiNumOtFil;
    }

    public void setUiNumOtFil(TextField tf) {
        this.uiNumOtFil = tf;
    }
    private DropDown uiProductoFil = new DropDown();

    public DropDown getUiProductoFil() {
        return uiProductoFil;
    }

    public void setUiProductoFil(DropDown dd) {
        this.uiProductoFil = dd;
    }
    private Calendar uiFechaDesdeFil = new Calendar();

    public Calendar getUiFechaDesdeFil() {
        return uiFechaDesdeFil;
    }

    public void setUiFechaDesdeFil(Calendar c) {
        this.uiFechaDesdeFil = c;
    }
    private Calendar uiFechaHastaFil = new Calendar();

    public Calendar getUiFechaHastaFil() {
        return uiFechaHastaFil;
    }

    public void setUiFechaHastaFil(Calendar c) {
        this.uiFechaHastaFil = c;
    }
    private Table tableOrdenesTrabajo1 = new Table();

    public Table getTableOrdenesTrabajo1() {
        return tableOrdenesTrabajo1;
    }

    public void setTableOrdenesTrabajo1(Table t) {
        this.tableOrdenesTrabajo1 = t;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private TextField uiNroOT = new TextField();

    public TextField getUiNroOT() {
        return uiNroOT;
    }

    public void setUiNroOT(TextField tf) {
        this.uiNroOT = tf;
    }
    private TextField uiResponsableCodigo = new TextField();

    public TextField getUiResponsableCodigo() {
        return uiResponsableCodigo;
    }

    public void setUiResponsableCodigo(TextField tf) {
        this.uiResponsableCodigo = tf;
    }
    private TextField uiResponsableNombre = new TextField();

    public TextField getUiResponsableNombre() {
        return uiResponsableNombre;
    }

    public void setUiResponsableNombre(TextField tf) {
        this.uiResponsableNombre = tf;
    }
    private DropDown uiProducto = new DropDown();

    public DropDown getUiProducto() {
        return uiProducto;
    }

    public void setUiProducto(DropDown dd) {
        this.uiProducto = dd;
    }
    private TextField uiFormulaCodigo = new TextField();

    public TextField getUiFormulaCodigo() {
        return uiFormulaCodigo;
    }

    public void setUiFormulaCodigo(TextField tf) {
        this.uiFormulaCodigo = tf;
    }
    private TextField uiFormulaNombre = new TextField();

    public TextField getUiFormulaNombre() {
        return uiFormulaNombre;
    }

    public void setUiFormulaNombre(TextField tf) {
        this.uiFormulaNombre = tf;
    }
    private TextArea uiDescripcionOt = new TextArea();

    public TextArea getUiDescripcionOt() {
        return uiDescripcionOt;
    }

    public void setUiDescripcionOt(TextArea ta) {
        this.uiDescripcionOt = ta;
    }
    private TextField uiCantidad = new TextField();

    public TextField getUiCantidad() {
        return uiCantidad;
    }

    public void setUiCantidad(TextField tf) {
        this.uiCantidad = tf;
    }
    private TextField uiCostoPrevisto = new TextField();

    public TextField getUiCostoPrevisto() {
        return uiCostoPrevisto;
    }

    public void setUiCostoPrevisto(TextField tf) {
        this.uiCostoPrevisto = tf;
    }
    private TextField uiCostoReal = new TextField();

    public TextField getUiCostoReal() {
        return uiCostoReal;
    }

    public void setUiCostoReal(TextField tf) {
        this.uiCostoReal = tf;
    }
    private TextField uiCantidadProducida = new TextField();

    public TextField getUiCantidadProducida() {
        return uiCantidadProducida;
    }

    public void setUiCantidadProducida(TextField tf) {
        this.uiCantidadProducida = tf;
    }
    private Calendar uiFechaIni = new Calendar();

    public Calendar getUiFechaIni() {
        return uiFechaIni;
    }

    public void setUiFechaIni(Calendar c) {
        this.uiFechaIni = c;
    }
    private Calendar uiFechaFin = new Calendar();

    public Calendar getUiFechaFin() {
        return uiFechaFin;
    }

    public void setUiFechaFin(Calendar c) {
        this.uiFechaFin = c;
    }
    private SingleSelectOptionsList uiEstadoFilDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiEstadoFilDefaultOptions() {
        return uiEstadoFilDefaultOptions;
    }

    public void setUiEstadoFilDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiEstadoFilDefaultOptions = ssol;
    }
    private HtmlPanelGrid gridPanelBuscar = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBuscar() {
        return gridPanelBuscar;
    }

    public void setGridPanelBuscar(HtmlPanelGrid hpg) {
        this.gridPanelBuscar = hpg;
    }
    private HtmlPanelGrid gridPanelDatosCabecera = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDatosCabecera() {
        return gridPanelDatosCabecera;
    }

    public void setGridPanelDatosCabecera(HtmlPanelGrid hpg) {
        this.gridPanelDatosCabecera = hpg;
    }
    private TabSet tabSet2 = new TabSet();

    public TabSet getTabSet2() {
        return tabSet2;
    }

    public void setTabSet2(TabSet ts) {
        this.tabSet2 = ts;
    }
    private Tab tab1 = new Tab();

    public Tab getTab1() {
        return tab1;
    }

    public void setTab1(Tab t) {
        this.tab1 = t;
    }
    private SingleSelectOptionsList uiEstadoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiEstadoDefaultOptions() {
        return uiEstadoDefaultOptions;
    }

    public void setUiEstadoDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiEstadoDefaultOptions = ssol;
    }
    private DropDown uiEstado = new DropDown();

    public DropDown getUiEstado() {
        return uiEstado;
    }

    public void setUiEstado(DropDown dd) {
        this.uiEstado = dd;
    }
    private SingleSelectOptionsList dropDown1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDropDown1DefaultOptions() {
        return dropDown1DefaultOptions;
    }

    public void setDropDown1DefaultOptions(SingleSelectOptionsList ssol) {
        this.dropDown1DefaultOptions = ssol;
    }
    private DropDown uiEstadoFil = new DropDown();

    public DropDown getUiEstadoFil() {
        return uiEstadoFil;
    }

    public void setUiEstadoFil(DropDown dd) {
        this.uiEstadoFil = dd;
    }
    private Checkbox uiTodosFil = new Checkbox();

    public Checkbox getUiTodosFil() {
        return uiTodosFil;
    }

    public void setUiTodosFil(Checkbox c) {
        this.uiTodosFil = c;
    }
    private HtmlPanelGrid gridPanelDetalleOT = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDetalleOT() {
        return gridPanelDetalleOT;
    }

    public void setGridPanelDetalleOT(HtmlPanelGrid hpg) {
        this.gridPanelDetalleOT = hpg;
    }
    private Table tableSemiterminados1 = new Table();

    public Table getTableSemiterminados1() {
        return tableSemiterminados1;
    }

    public void setTableSemiterminados1(Table t) {
        this.tableSemiterminados1 = t;
    }
    private TableRowGroup tablaSemiterminadosRW = new TableRowGroup();

    public TableRowGroup getTablaSemiterminadosRW() {
        return tablaSemiterminadosRW;
    }

    public void setTablaSemiterminadosRW(TableRowGroup trg) {
        this.tablaSemiterminadosRW = trg;
    }
    private TextField uiDetSemiTerCodProd = new TextField();

    public TextField getUiDetSemiTerCodProd() {
        return uiDetSemiTerCodProd;
    }

    public void setUiDetSemiTerCodProd(TextField tf) {
        this.uiDetSemiTerCodProd = tf;
    }
    private TextField uiDetSemiTerProdDesc = new TextField();

    public TextField getUiDetSemiTerProdDesc() {
        return uiDetSemiTerProdDesc;
    }

    public void setUiDetSemiTerProdDesc(TextField tf) {
        this.uiDetSemiTerProdDesc = tf;
    }
    private TextField uiDetSemiTerCant = new TextField();

    public TextField getUiDetSemiTerCant() {
        return uiDetSemiTerCant;
    }

    public void setUiDetSemiTerCant(TextField tf) {
        this.uiDetSemiTerCant = tf;
    }
    private ImageHyperlink uiEditDetLynk = new ImageHyperlink();

    public ImageHyperlink getUiEditDetLynk() {
        return uiEditDetLynk;
    }

    public void setUiEditDetLynk(ImageHyperlink ih) {
        this.uiEditDetLynk = ih;
    }
    private ImageHyperlink uiRemoDetLynk = new ImageHyperlink();

    public ImageHyperlink getUiRemoDetLynk() {
        return uiRemoDetLynk;
    }

    public void setUiRemoDetLynk(ImageHyperlink ih) {
        this.uiRemoDetLynk = ih;
    }
    private HtmlPanelGrid gridPanelDetalleSemiter = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDetalleSemiter() {
        return gridPanelDetalleSemiter;
    }

    public void setGridPanelDetalleSemiter(HtmlPanelGrid hpg) {
        this.gridPanelDetalleSemiter = hpg;
    }
    private TextField uiSemiTerCabProductoCod = new TextField();

    public TextField getUiSemiTerCabProductoCod() {
        return uiSemiTerCabProductoCod;
    }

    public void setUiSemiTerCabProductoCod(TextField tf) {
        this.uiSemiTerCabProductoCod = tf;
    }
    private TextField uiSemiTerCabFormulaCodigo = new TextField();

    public TextField getUiSemiTerCabFormulaCodigo() {
        return uiSemiTerCabFormulaCodigo;
    }

    public void setUiSemiTerCabFormulaCodigo(TextField tf) {
        this.uiSemiTerCabFormulaCodigo = tf;
    }
    private TextArea uiSemiTerCabDesc = new TextArea();

    public TextArea getUiSemiTerCabDesc() {
        return uiSemiTerCabDesc;
    }

    public void setUiSemiTerCabDesc(TextArea ta) {
        this.uiSemiTerCabDesc = ta;
    }
    private TextField uiSemiTerCabCant = new TextField();

    public TextField getUiSemiTerCabCant() {
        return uiSemiTerCabCant;
    }

    public void setUiSemiTerCabCant(TextField tf) {
        this.uiSemiTerCabCant = tf;
    }
    private Checkbox uiSemiTerCabActivoCheck = new Checkbox();

    public Checkbox getUiSemiTerCabActivoCheck() {
        return uiSemiTerCabActivoCheck;
    }

    public void setUiSemiTerCabActivoCheck(Checkbox c) {
        this.uiSemiTerCabActivoCheck = c;
    }
    private TextField uiSemiTerCabCantProd = new TextField();

    public TextField getUiSemiTerCabCantProd() {
        return uiSemiTerCabCantProd;
    }

    public void setUiSemiTerCabCantProd(TextField tf) {
        this.uiSemiTerCabCantProd = tf;
    }
    private TextField uiSemiTerDetCodTarea = new TextField();

    public TextField getUiSemiTerDetCodTarea() {
        return uiSemiTerDetCodTarea;
    }

    public void setUiSemiTerDetCodTarea(TextField tf) {
        this.uiSemiTerDetCodTarea = tf;
    }
    private TextField uiSemiTerDetCantTarea = new TextField();

    public TextField getUiSemiTerDetCantTarea() {
        return uiSemiTerDetCantTarea;
    }

    public void setUiSemiTerDetCantTarea(TextField tf) {
        this.uiSemiTerDetCantTarea = tf;
    }
    private TextField uiSemiTerDetCodRecurso = new TextField();

    public TextField getUiSemiTerDetCodRecurso() {
        return uiSemiTerDetCodRecurso;
    }

    public void setUiSemiTerDetCodRecurso(TextField tf) {
        this.uiSemiTerDetCodRecurso = tf;
    }
    private TextField uiSemiTerDetDescRecurso = new TextField();

    public TextField getUiSemiTerDetDescRecurso() {
        return uiSemiTerDetDescRecurso;
    }

    public void setUiSemiTerDetDescRecurso(TextField tf) {
        this.uiSemiTerDetDescRecurso = tf;
    }
    private TextField uiSemiTerDetCantRecurso = new TextField();

    public TextField getUiSemiTerDetCantRecurso() {
        return uiSemiTerDetCantRecurso;
    }

    public void setUiSemiTerDetCantRecurso(TextField tf) {
        this.uiSemiTerDetCantRecurso = tf;
    }
    private TextField uiSemiTerDetDescTarea = new TextField();

    public TextField getUiSemiTerDetDescTarea() {
        return uiSemiTerDetDescTarea;
    }

    public void setUiSemiTerDetDescTarea(TextField tf) {
        this.uiSemiTerDetDescTarea = tf;
    }
    private ImageHyperlink uiSemiTerDetEditTareaLink = new ImageHyperlink();

    public ImageHyperlink getUiSemiTerDetEditTareaLink() {
        return uiSemiTerDetEditTareaLink;
    }

    public void setUiSemiTerDetEditTareaLink(ImageHyperlink ih) {
        this.uiSemiTerDetEditTareaLink = ih;
    }
    private ImageHyperlink uiSemiTerDetRemoveTareaLink = new ImageHyperlink();

    public ImageHyperlink getUiSemiTerDetRemoveTareaLink() {
        return uiSemiTerDetRemoveTareaLink;
    }

    public void setUiSemiTerDetRemoveTareaLink(ImageHyperlink ih) {
        this.uiSemiTerDetRemoveTareaLink = ih;
    }
    private ImageHyperlink uiSemiTerDetEditRecursoLink = new ImageHyperlink();

    public ImageHyperlink getUiSemiTerDetEditRecursoLink() {
        return uiSemiTerDetEditRecursoLink;
    }

    public void setUiSemiTerDetEditRecursoLink(ImageHyperlink ih) {
        this.uiSemiTerDetEditRecursoLink = ih;
    }
    private ImageHyperlink uiSemiTerRemoveRecursoLink = new ImageHyperlink();

    public ImageHyperlink getUiSemiTerRemoveRecursoLink() {
        return uiSemiTerRemoveRecursoLink;
    }

    public void setUiSemiTerRemoveRecursoLink(ImageHyperlink ih) {
        this.uiSemiTerRemoveRecursoLink = ih;
    }
    private TextField uiSemiTerCabProductoDesc = new TextField();

    public TextField getUiSemiTerCabProductoDesc() {
        return uiSemiTerCabProductoDesc;
    }

    public void setUiSemiTerCabProductoDesc(TextField tf) {
        this.uiSemiTerCabProductoDesc = tf;
    }
    private TextField uiSemiTerCabFormulaDesc = new TextField();

    public TextField getUiSemiTerCabFormulaDesc() {
        return uiSemiTerCabFormulaDesc;
    }

    public void setUiSemiTerCabFormulaDesc(TextField tf) {
        this.uiSemiTerCabFormulaDesc = tf;
    }
    private Button uiButtonGuardarRegistro = new Button();

    public Button getUiButtonGuardarRegistro() {
        return uiButtonGuardarRegistro;
    }

    public void setUiButtonGuardarRegistro(Button b) {
        this.uiButtonGuardarRegistro = b;
    }
    private Button uibuttonGuardarEdicion = new Button();

    public Button getUibuttonGuardarEdicion() {
        return uibuttonGuardarEdicion;
    }

    public void setUibuttonGuardarEdicion(Button b) {
        this.uibuttonGuardarEdicion = b;
    }
    private TableColumn tableColumn1 = new TableColumn();

    public TableColumn getTableColumn1() {
        return tableColumn1;
    }

    public void setTableColumn1(TableColumn tc) {
        this.tableColumn1 = tc;
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
    public ABMOrdenesTrabajo() {
    uiEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("A", "Abierto"), new com.sun.webui.jsf.model.Option("P", "En Proceso"), new com.sun.webui.jsf.model.Option("C", "Cerrado"), new com.sun.webui.jsf.model.Option("T", "Terminado")});
    dropDown1DefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("A", "Abierto"), new com.sun.webui.jsf.model.Option("P", "En Proceso"), new com.sun.webui.jsf.model.Option("C", "Cerrado"), new com.sun.webui.jsf.model.Option("T", "Terminado"), new com.sun.webui.jsf.model.Option("X", "Todos")});


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

    getSessionBean1().setTituloPagina("Registro de Ordenes de Trabajo");
    getSessionBean1().setDetallePagina("Seleccione la OT deseada");


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
    private boolean addRequestOT = false;
    private boolean updateRequestOT = false;
    private boolean verDetalleSemiter = false;

    private boolean errorValidacion = false;
    private boolean addDetalleOt = false;
    private boolean editarDetalleOt = false;

    private boolean  editarDetalleSemiterRecurso = false;
    private boolean editarDetalleSemiterTarea = false;

    private long idAuxiliar = 0;



    @Override
    public void prerender() {

        if (addRequestOT) {

            this.gridPanelBuscar.setRendered(false);
            this.gridPanelDatosCabecera.setRendered(true);
            this.gridPanelDetalleOT.setRendered(true);
            this.gridPanelDetalleSemiter.setRendered(false);
            //               this.gridPanelDetalleSemiTerminados.setRendered(false);

        } else if (updateRequestOT) {

            this.gridPanelBuscar.setRendered(false);
            this.gridPanelDatosCabecera.setRendered(true);
            this.gridPanelDetalleOT.setRendered(true);
            this.gridPanelDetalleSemiter.setRendered(false);
          //     this.gridPanelDetalleSemiTerminados.setRendered(false);

        } else if (addDetalleOt) {


            this.gridPanelBuscar.setRendered(false);
            this.gridPanelDatosCabecera.setRendered(false);
            this.gridPanelDetalleOT.setRendered(false);
            this.gridPanelDetalleSemiter.setRendered(false);
//               this.gridPanelDetalleSemiTerminados.setRendered(true);

        } else if (verDetalleSemiter) {

           this.gridPanelBuscar.setRendered(false);
           this.gridPanelDatosCabecera.setRendered(false);
           this.gridPanelDetalleOT.setRendered(false);
           this.gridPanelDetalleSemiter.setRendered(true);
           
        } else {

            this.gridPanelBuscar.setRendered(true);
            this.gridPanelDatosCabecera.setRendered(false);
            this.gridPanelDetalleOT.setRendered(false);
            this.gridPanelDetalleSemiter.setRendered(false);
 //              this.gridPanelDetalleSemiTerminados.setRendered(false);
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


    public String uiCancelButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

    getSessionBean1().setTituloPagina("Registro de Ordenes de Trabajo");
    getSessionBean1().setDetallePagina("Seleccione la OT deseada");
    
        this.addRequestOT=false;
        this.updateRequestOT=false;
        this.addDetalleOt=false;
        this.errorValidacion =false;
        this.verDetalleSemiter = false;

        return null;
    }

    public String uiButtonNuevoRegistro_action() {
        // TODO: Replace with your code
            this.uiNroOT.setText("");
        this.uiResponsableCodigo.setText("");
        this.uiResponsableNombre.setText("");
        this.pageAlert1.setRendered(false);
        this.uiProducto.setSelected("");
        this.uiFormulaCodigo.setText("");
        this.uiFormulaNombre.setText("");
        this.uiCantidad.setText("");
        this.uiFechaDesdeFil.setSelectedDate(null);
        this.uiFechaHastaFil.setSelectedDate(null);
        this.uiCantidadProducida.setText("");
        this.uiCostoReal.setText("");
        this.uiCostoPrevisto.setText("");

        this.uiButtonGuardarRegistro.setRendered(true);
        this.uibuttonGuardarEdicion.setRendered(false);


        detalleOrdenTrabajoList = new ArrayList();
        detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);


        tareaAsignadaList = new ArrayList();
        tareaAsignadaMostradaList = new ArrayList();
        tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaList.toArray(new TareaAsignada[0]);

        recursoAsignadoList = new ArrayList();
        recursoAsignadoMostradoList = new ArrayList();
        recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoList.toArray(new RecursoAsignado[0]);


    getSessionBean1().setTituloPagina("Registro de Ordenes de Trabajo");
    getSessionBean1().setDetallePagina("Apertura de nueva OT");


        this.addRequestOT=true;
        this.updateRequestOT=false;
        this.addDetalleOt=false;
        this.errorValidacion =false;
        this.verDetalleSemiter = false;
        return null;

    }


    public String button3_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
//            errorValidacion = validarCampos();

        detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);
        recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoList.toArray(new RecursoAsignado[0]);
        tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaList.toArray(new TareaAsignada[0]);

        //Si no hay error de validacion
        if (! errorValidacion){

            //// CARGA DE LA CABECERA
          OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
          ProductoController productoController = new ProductoController();
          EmpleadoController empleadoController = new EmpleadoController();
          FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();


          ordenTrabajo.setNumeroOrdenTrabajo(new Long( this.uiNroOT.getText().toString()));
          ordenTrabajo.setCodEmpleado1(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
          ordenTrabajo.setCodEmpleado2(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
          ordenTrabajo.setCodProductoOt(productoController.findById(Long.valueOf(this.uiProducto.getSelected().toString())));
          ordenTrabajo.setCantidadOt(new BigInteger(this.uiCantidad.getText().toString()));
          ordenTrabajo.setCantidadProducidaOt(new BigInteger(this.uiCantidadProducida.getText().toString()));
          ordenTrabajo.setFechaInicialOt(this.uiFechaIni.getSelectedDate());
          ordenTrabajo.setFechaFinOt(this.uiFechaFin.getSelectedDate());
          ordenTrabajo.setCostoEstimadoOt(new BigInteger(this.uiCostoPrevisto.getText().toString()));
          ordenTrabajo.setCostoRealOt(new BigInteger(this.uiCostoReal.getText().toString()));
          ordenTrabajo.setEstadoOt("A");

          OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();
          ControllerResult controllerResult = new ControllerResult();

          controllerResult = ordenTrabajoCabeceraController.createCabDet(ordenTrabajo, detallesOrdenTrabajo);

          if (controllerResult.getCodRetorno() != -1) {
                addRequestOT = false;
                this.pageAlert1.setType("information");
        }else{

        this.pageAlert1.setType("error");
        this.errorValidacion=true;

        }

            this.pageAlert1.setTitle(controllerResult.getMsg());
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);

       }
           return null;
    }

    public String uiButtonGuardarRegistro_action() {
        // TODO: Replace with your code\
        errorValidacion = validarCampos();
//        detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);
        recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoList.toArray(new RecursoAsignado[0]);
        tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaList.toArray(new TareaAsignada[0]);

        //Si no hay error de validacion
        if (! errorValidacion){

            //// CARGA DE LA CABECERA
          OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
          ProductoController productoController = new ProductoController();
          EmpleadoController empleadoController = new EmpleadoController();
          FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();


          ordenTrabajo.setNumeroOrdenTrabajo(new Long( this.uiNroOT.getText().toString()));
          ordenTrabajo.setCodEmpleado1(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
          ordenTrabajo.setCodEmpleado2(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
          ordenTrabajo.setCodProductoOt(productoController.findById(Long.valueOf(this.uiProducto.getSelected().toString())));
          ordenTrabajo.setCantidadOt(new BigInteger(this.uiCantidad.getText().toString()));
          ordenTrabajo.setCantidadProducidaOt(new BigInteger(this.uiCantidadProducida.getText().toString()));
          ordenTrabajo.setFechaOt(this.uiFechaIni.getSelectedDate());
          ordenTrabajo.setFechaInicialOt(this.uiFechaIni.getSelectedDate());
          ordenTrabajo.setFechaFinOt(this.uiFechaFin.getSelectedDate());
          ordenTrabajo.setCostoEstimadoOt(new BigInteger(this.uiCostoPrevisto.getText().toString()));
          ordenTrabajo.setCostoRealOt(new BigInteger(this.uiCostoReal.getText().toString()));
          ordenTrabajo.setDescripcion(this.uiDescripcionOt.getText().toString());
          ordenTrabajo.setEstadoOt(this.uiEstado.getSelected().toString());

        
          //// FIN DE CARGA DE CABECERA
          OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();
          ControllerResult controllerResult = new ControllerResult();
          controllerResult = ordenTrabajoCabeceraController.createCabDet(ordenTrabajo, detallesOrdenTrabajo);

          if (controllerResult.getCodRetorno() != -1) {
                addRequestOT = false;
                this.pageAlert1.setType("information");

                getSessionBean1().setTituloPagina("Registro de Ordenes de Trabajo");
                getSessionBean1().setDetallePagina("Seleccione la OT deseada");



        }else{

        this.pageAlert1.setType("error");
        this.errorValidacion=true;

        }

            this.pageAlert1.setTitle(controllerResult.getMsg());
            this.pageAlert1.setSummary("");
            this.pageAlert1.setDetail("");
            this.pageAlert1.setRendered(true);

       }
           
        return null;
    }

    public String uiButtonBuscarFiltro_action() {
        // TODO: Replace with your code
        return null;
    }

    public String buttonAgregar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarDetalleOt();

        if (!errorValidacion) {

            if (!editarDetalleOt){

                   Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetSemiTerCodProd.getText().toString()));
                   Empleado empleado = new EmpleadoController().findById(Long.valueOf(this.uiResponsableCodigo.getText().toString()));
                   detalleOrdenTrabajo = new OrdenTrabajoDetalle();
                   detalleOrdenTrabajo.setCodProducto(producto);
                   detalleOrdenTrabajo.setCantidad(BigInteger.valueOf(Long.valueOf(this.uiDetSemiTerCant.getText().toString())).longValue());
                   detalleOrdenTrabajo.setEstado("A");
                   detalleOrdenTrabajo.setCodEmpleado(empleado);
                   detalleOrdenTrabajo.setRecursoAsignadoCollection(new HashSet());
                   detalleOrdenTrabajo.setTareaAsignadaCollection(new HashSet());
                   detalleOrdenTrabajoList.add(detalleOrdenTrabajo);

            }else{
//                   Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetProductoCodigo.getText().toString()));

//                   detalleFormulaSemi  = detalleFormulaSemiList.get(Integer.valueOf(itemDet).intValue());
//                   detalleFormulaSemi.setCodProducto(producto);
//                   detalleFormulaSemi.setCantidad(BigInteger.valueOf(Long.valueOf(this.uiDetProductoCantidad.getText().toString())));
//                   editarDetalleRecurso = false;

            }
           detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);
           limpiarDetalleOt();

        }


        return null;
    }

    public void limpiarDetalleOt(){

this.uiDetSemiTerCant.setText("");
this.uiDetSemiTerCodProd.setText("");
this.uiDetSemiTerProdDesc.setText("");

}

    public void limpiarDetalleSemiTer(){

this.uiSemiTerCabDesc.setText("");
this.uiSemiTerCabProductoCod.setText("");
this.uiSemiTerCabFormulaCodigo.setText("");
this.uiSemiTerCabCant.setText("");
this.uiSemiTerCabCantProd.setText("");

}

    public void validarDetalleOt(){
        this.errorValidacion= false;
        if (uiDetSemiTerCodProd.getText() == null || uiDetSemiTerCodProd.getText().equals("") ) {
        this.errorValidacion= true;
        info("Verifique el detalle, debe ingresar el Codigo de Producto");
        }

        if (uiResponsableCodigo.getText() == null || uiResponsableCodigo.getText().equals("") ) {
        this.errorValidacion= true;
        info("Seleccione el empleado Responsable");
        }

        if (uiDetSemiTerCant.getText() == null || uiDetSemiTerCant.getText().equals("") ) {
     //   if (!StringUtils.esNumero(this.uiDet.getText().toString())){
        this.errorValidacion= true;
        info("Verifique el detalle, debe ingresar correctamente la Cantidad");
        }

    }

     public String uiEditDetLynk_action() {

             editarDetalleOt = true;

            OrdenTrabajoDetalle ordenTrabajoDetalle = new OrdenTrabajoDetalle();
            ordenTrabajoDetalle = detalleOrdenTrabajoList.get(Integer.valueOf(itemDet).intValue());

            this.uiDetSemiTerCodProd.setText(ordenTrabajoDetalle.getCodProducto().getCodProducto().toString());
            this.uiDetSemiTerProdDesc.setText(ordenTrabajoDetalle.getCodProducto().getDescripcion().toString());
            this.uiDetSemiTerCant.setText(String.valueOf(ordenTrabajoDetalle.getCantidad()));

        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String uiRemoDetLynk_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

    editarDetalleOt = false;

    //// agrego la formula eliminada a la lista de formulas Eliminadas
    //// se utiliza luego al actualizar el registro
    if (updateRequestOT) {
//        OrdenTrabajo ordenTrabaj  = tareaFormulaList.get(Integer.valueOf(itemDet).intValue());
//        tareaFormulaEliminadaList.add(tarForEliminada);
    }
    detalleOrdenTrabajoList.remove(Integer.valueOf(itemDet).intValue());
    detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);


        return null;
    }


     public String uiButtonSemiterVolver_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        this.addRequestOT=true;
        this.updateRequestOT=false;
        this.addDetalleOt=false;
        this.errorValidacion =false;
        this.verDetalleSemiter = false;

        return null;
        

    }

    public String uiSemiTerDetLynkRecusos_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        limpiarDetalleSemiTer();
        
        this.addRequestOT=false;
        this.updateRequestOT=false;
        this.addDetalleOt=false;
        this.errorValidacion =false;
        this.verDetalleSemiter = true;

        RecursoAsignado recursoAsignado;
        TareaAsignada tareaAsignada;

        detalleOrdenTrabajo = detalleOrdenTrabajoList.get(Integer.valueOf(itemDetalleOt).intValue());

        this.uiSemiTerCabProductoCod.setText(detalleOrdenTrabajo.getCodProducto().getCodProducto().toString());
        this.uiSemiTerCabProductoDesc.setText(detalleOrdenTrabajo.getCodProducto().getDescripcion().toString());
        
        this.uiSemiTerCabDesc.setText(detalleOrdenTrabajo.getCodProducto().getDescripcion().toString());
        this.uiSemiTerCabCant.setText(String.valueOf(detalleOrdenTrabajo.getCantidad()));
    
        recursoAsignadoMostradoList = detalleOrdenTrabajo.getRecursoAsignadoListList();
        recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoMostradoList.toArray(new RecursoAsignado[0]);

        tareaAsignadaMostradaList = detalleOrdenTrabajo.getTareaAsignadaListList();
        tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaMostradaList.toArray(new TareaAsignada[0]);
        
        return null;
    }



    public void validarDetalleProducto(){
        this.errorValidacion= false;
        if (uiSemiTerDetCodRecurso.getText() == null || uiSemiTerDetCodRecurso.getText().equals("") ) {
        this.errorValidacion= true;
        info("Verifique el detalle");
        }

        if (uiSemiTerDetCantRecurso.getText() == null || uiSemiTerDetCantRecurso.getText().equals("") ) {
        this.errorValidacion= true;
        info("Verifique el detalle");
        }
    }

    public void validarDetalleTarea(){
        this.errorValidacion= false;
        if (uiSemiTerDetCodTarea.getText() == null || uiSemiTerDetCodTarea.getText().equals("") ) {
        this.errorValidacion= true;
        info("Verifique el detalle");
        }

        if (uiSemiTerDetCantTarea.getText() == null || uiSemiTerDetCantTarea.getText().equals("") ) {
        this.errorValidacion= true;
        info("Verifique el detalle");
        }
    }



    public String uiButtonSemiTerAddDetalleRecurso_action() {

        validarDetalleProducto();

        if (!errorValidacion) {

            if (!editarDetalleSemiterRecurso){

                   Producto producto = new ProductoController().findById(Long.valueOf(this.uiSemiTerDetCodRecurso.getText().toString()));
                   idAuxiliar ++;
                   recursoAsignadoOt = new RecursoAsignado();
                   recursoAsignadoOt.setCodProducto(producto);
                   detalleOrdenTrabajo.setCantidad(Long.valueOf(this.uiSemiTerDetCantRecurso.getText().toString()));
                   recursoAsignadoOt.setCantidad(Long.valueOf(this.uiSemiTerDetCantRecurso.getText().toString()));
                   recursoAsignadoOt.setCodRecurso(idAuxiliar);
                   recursoAsignadoOt.setFecha(this.uiFechaIni.getSelectedDate());
                   recursoAsignadoMostradoList.add(recursoAsignadoOt);
//                   detalleOrdenTrabajo.getRecursoAsignadoCollection().add(recursoAsignadoOt);

//         detalleOrdenTrabajo.setTareaAsignadaCollection(new HashSet(tareaAsignadaMostradaList));
//        detalleOrdenTrabajo.setRecursoAsignadoCollection(new HashSet(recursoAsignadoMostradoList));

            }else{

//                Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetProductoCodigo.getText().toString()));
//
//                   detalleFormulaSemi  = detalleFormulaSemiList.get(Integer.valueOf(itemDet).intValue());
//                   detalleFormulaSemi.setCodProducto(producto);
//                   detalleFormulaSemi.setCantidad(BigInteger.valueOf(Long.valueOf(this.uiDetProductoCantidad.getText().toString())));
//                   editarDetalleRecurso = false;

            }



            detalleOrdenTrabajo.setRecursoAsignadoCollectionFromList(recursoAsignadoMostradoList);
            recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoMostradoList.toArray(new RecursoAsignado[0]);
//           limpiarDetalleProducto();

        }

        return null;
    }

  public String uiButtonSemiTerAddDetalleTarea_action() {
        // TODO: Replace with your code

        validarDetalleTarea();

        if (!errorValidacion) {
            if (!editarDetalleSemiterTarea){
                   Tarea tarea = new TareaController().findById(Long.valueOf(this.uiSemiTerDetCodTarea.getText().toString()));
                   idAuxiliar ++;
                   tareaAsignadaOt = new TareaAsignada();
                   tareaAsignadaOt.setCodTarea(tarea);
                   tareaAsignadaOt.setCantidad(Long.valueOf(this.uiSemiTerDetCantTarea.getText().toString()));
                   tareaAsignadaOt.setCodTareaAsignada(idAuxiliar);
                   tareaAsignadaMostradaList.add(tareaAsignadaOt);
                   

//                   detalleOrdenTrabajo.getTareaAsignadaCollection().add(tareaAsignadaOt);

                 
            }else{
//                  Tarea tarea = new TareaController().findById(Long.valueOf(this.uiDetTareaCodigo.getText().toString()));

//                  tareaFormula  = tareaFormulaList.get(Integer.valueOf(itemDet).intValue());
//                  tareaFormula.setCodTarea(tarea);
//                  tareaFormula.setCantidadTarea(BigInteger.valueOf(Long.valueOf(this.uiDetTareaCantidad.getText().toString())));
//                  tareaFormula.setOrdenTarea(BigInteger.valueOf(Long.valueOf(this.uiDetTareaOrden.getText().toString())));
//            }
//            tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaMostradaList.toArray(new TareaAsignada[0]);
//            limpiarDetalleTarea();
//         }

            }
            detalleOrdenTrabajo.setTareaAsignadaCollectionFromList(tareaAsignadaMostradaList);
            tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaMostradaList.toArray(new TareaAsignada[0]);
            Integer numero = detalleOrdenTrabajo.getTareaAsignadaCollection().size();
            Integer numero2 = detalleOrdenTrabajo.getTareaAsignadaCollection().size();
       }

        return null;
}

    public String uiSemiTerDetEditTareaLink_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

         editarDetalleSemiterTarea = true;

         TareaAsignada tareaAsignada = new TareaAsignada();
         tareaAsignada = tareaAsignadaMostradaList.get(Integer.valueOf(itemDetalleOt).intValue());

         this.uiSemiTerDetCodTarea.setText(tareaAsignada.getCodTarea().getCodTarea().toString());
//         this.uiSemiTerDet.setText(tareaAsignada.getCodTarea().getNombreTarea().toString());
         this.uiSemiTerDetCantTarea.setText(String.valueOf(tareaAsignada.getCantidad()));
        return null;
    }

    public String uiSemiTerDetRemoveTareaLink_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        tareaAsignadaMostradaList.remove(Integer.valueOf(itemDetalleOt).intValue());
        tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaMostradaList.toArray(new TareaAsignada[0]);

        return null;
    }

    public String uiSemiTerEditRecursoLink_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
      

        editarDetalleSemiterRecurso = true;

         RecursoAsignado recursoAsignado = new RecursoAsignado();
         recursoAsignado = recursoAsignadoMostradoList.get(Integer.valueOf(itemDetalleOt).intValue());

         this.uiSemiTerDetCodRecurso.setText(recursoAsignado.getCodProducto().getCodProducto().toString());
         this.uiSemiTerDetDescRecurso.setText(recursoAsignado.getCodProducto().getDescripcion().toString());
         this.uiSemiTerDetCantTarea.setText(String.valueOf(recursoAsignado.getCantidad()));


     return null;
    }

    public String uiSemiTerRemoveRecursoLink_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        recursoAsignadoMostradoList.remove(Integer.valueOf(itemDetalleOt).intValue());
        recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoMostradoList.toArray(new RecursoAsignado[0]);




        return null;
    }




/////////////// GUETERS AND SETTERS



    public String hyperlink1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }


    public boolean isAddDetalleOt() {
        return addDetalleOt;
    }

    public void setAddDetalleOt(boolean addDetalleOt) {
        this.addDetalleOt = addDetalleOt;
    }

    public boolean isAddRequestOT() {
        return addRequestOT;
    }

    public void setAddRequestOT(boolean addRequestOT) {
        this.addRequestOT = addRequestOT;
    }

    public OrdenTrabajoDetalle getDetalleOrdenTrabajo() {
        return detalleOrdenTrabajo;
    }

    public void setDetalleOrdenTrabajo(OrdenTrabajoDetalle detalleOrdenTrabajo) {
        this.detalleOrdenTrabajo = detalleOrdenTrabajo;
    }

    public List<OrdenTrabajoDetalle> getDetalleOrdenTrabajoEliminadaList() {
        return detalleOrdenTrabajoEliminadaList;
    }

    public void setDetalleOrdenTrabajoEliminadaList(List<OrdenTrabajoDetalle> detalleOrdenTrabajoEliminadaList) {
        this.detalleOrdenTrabajoEliminadaList = detalleOrdenTrabajoEliminadaList;
    }

    public List<OrdenTrabajoDetalle> getDetalleOrdenTrabajoList() {
        return detalleOrdenTrabajoList;
    }

    public void setDetalleOrdenTrabajoList(List<OrdenTrabajoDetalle> detalleOrdenTrabajoList) {
        this.detalleOrdenTrabajoList = detalleOrdenTrabajoList;
    }

    public OrdenTrabajoDetalle[] getDetallesOrdenTrabajo() {
        return detallesOrdenTrabajo;
    }

    public void setDetallesOrdenTrabajo(OrdenTrabajoDetalle[] detallesOrdenTrabajo) {
        this.detallesOrdenTrabajo = detallesOrdenTrabajo;
    }

    public boolean isErrorValidacion() {
        return errorValidacion;
    }

    public void setErrorValidacion(boolean errorValidacion) {
        this.errorValidacion = errorValidacion;
    }

    public OrdenTrabajo[] getListaOrdenTrabajoCabeceras() {
        return listaOrdenTrabajoCabeceras;
    }

    public void setListaOrdenTrabajoCabeceras(OrdenTrabajo[] listaOrdenTrabajoCabeceras) {
        this.listaOrdenTrabajoCabeceras = listaOrdenTrabajoCabeceras;
    }

    public List<RecursoAsignado> getRecursoAsignadoEliminadoList() {
        return recursoAsignadoEliminadoList;
    }

    public void setRecursoAsignadoEliminadoList(List<RecursoAsignado> recursoAsignadoEliminadoList) {
        this.recursoAsignadoEliminadoList = recursoAsignadoEliminadoList;
    }

    public List<RecursoAsignado> getRecursoAsignadoList() {
        return recursoAsignadoList;
    }

    public void setRecursoAsignadoList(List<RecursoAsignado> recursoAsignadoList) {
        this.recursoAsignadoList = recursoAsignadoList;
    }

    public RecursoAsignado getRecursoAsignadoOt() {
        return recursoAsignadoOt;
    }

    public void setRecursoAsignadoOt(RecursoAsignado recursoAsignadoOt) {
        this.recursoAsignadoOt = recursoAsignadoOt;
    }

    public RecursoAsignado[] getRecursosAsignadosOt() {
        return recursosAsignadosOt;
    }

    public void setRecursosAsignadosOt(RecursoAsignado[] recursosAsignadosOt) {
        this.recursosAsignadosOt = recursosAsignadosOt;
    }

    public List<TareaAsignada> getTareaAsignadaEliminadaList() {
        return tareaAsignadaEliminadaList;
    }

    public void setTareaAsignadaEliminadaList(List<TareaAsignada> tareaAsignadaEliminadaList) {
        this.tareaAsignadaEliminadaList = tareaAsignadaEliminadaList;
    }

    public List<TareaAsignada> getTareaAsignadaList() {
        return tareaAsignadaList;
    }

    public void setTareaAsignadaList(List<TareaAsignada> tareaAsignadaList) {
        this.tareaAsignadaList = tareaAsignadaList;
    }

    public TareaAsignada getTareaAsignadaOt() {
        return tareaAsignadaOt;
    }

    public void setTareaAsignadaOt(TareaAsignada tareaAsignadaOt) {
        this.tareaAsignadaOt = tareaAsignadaOt;
    }

    public TareaAsignada[] getTareasAsignadasOt() {
        return tareasAsignadasOt;
    }

    public void setTareasAsignadasOt(TareaAsignada[] tareasAsignadasOt) {
        this.tareasAsignadasOt = tareasAsignadasOt;
    }

    public boolean isUpdateRequestOT() {
        return updateRequestOT;
    }

    public void setUpdateRequestOT(boolean updateRequestOT) {
        this.updateRequestOT = updateRequestOT;
    }



    private String itemDet;

    public String getItemDet() {
        return itemDet;
    }

    public void setItemDet(String itemDet) {
        this.itemDet = itemDet;
    }

    private String itemDetalleOt;


    public boolean isEditarDetalleOt() {
        return editarDetalleOt;
    }

    public void setEditarDetalleOt(boolean editarDetalleOt) {
        this.editarDetalleOt = editarDetalleOt;
    }

    public String getItemDetalleOt() {
        return itemDetalleOt;
    }

    public void setItemDetalleOt(String itemDetalleOt) {
        this.itemDetalleOt = itemDetalleOt;
    }

    public boolean isVerDetalleSemiter() {
        return verDetalleSemiter;
    }

    public void setVerDetalleSemiter(boolean verDetalleSemiter) {
        this.verDetalleSemiter = verDetalleSemiter;
    }

    public String uiButtonEditarRegistro_action() {
        // TODO: Replace with your code
     this.pageAlert1.setRendered(false);
     this.uiButtonGuardarRegistro.setRendered(false);
     this.uibuttonGuardarEdicion.setRendered(true);


        detalleOrdenTrabajoEliminadaList = new ArrayList();
        tareaAsignadaEliminadaList = new ArrayList();
        recursoAsignadoEliminadoList = new ArrayList();

        getSessionBean1().setTituloPagina("Ordenes de Trabajo");
        getSessionBean1().setDetallePagina("Ver detalles OT. Recursos y Tareas");
        this.pageAlert1.setRendered(false);
        this.updateRequestOT=true;

        cargarCamposUpdate();
        limpiarDetalleOt();


        this.updateRequestOT=true;



        return null;
    }

private long idEditado;

    public long getIdEditado() {
        return idEditado;
    }

    public void setIdEditado(long idEditado) {
        this.idEditado = idEditado;
    }

    public void cargarCamposUpdate(){
        if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
                OrdenTrabajo[] ordenesDeTrabajoCabeceras = this.listaOrdenTrabajoCabeceras;
                int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
                OrdenTrabajo ordenTrabajo = ordenesDeTrabajoCabeceras[rowId];

                FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();
                idEditado = (ordenTrabajo.getCodOrdenTrabjo());


         //// CARGA DE CAMPOS DE LA PAGINA
         this.uiNroOT.setText(ordenTrabajo.getNumeroOrdenTrabajo().toString() );
         this.uiResponsableCodigo.setText(ordenTrabajo.getCodEmpleado1().getCodEmpleado().toString());
         this.uiResponsableNombre.setText(ordenTrabajo.getCodEmpleado1().getNombreEmpleado()+" "+ ordenTrabajo.getCodEmpleado1().getApellidoEmpleado());
         this.uiProducto.setSelected(ordenTrabajo.getCodProductoOt().getCodProducto());
         this.uiDescripcionOt.setText(ordenTrabajo.getDescripcion().toString());
         this.uiCantidad.setText(ordenTrabajo.getCantidadOt().toString());
         this.uiFechaIni.setSelectedDate(ordenTrabajo.getFechaOt());
         this.uiFechaFin.setSelectedDate(ordenTrabajo.getFechaFinOt());
         this.uiCantidadProducida.setText(ordenTrabajo.getCantidadProducidaOt().toString());
         this.uiCostoPrevisto.setText(ordenTrabajo.getCostoEstimadoOt().toString());
         this.uiCostoReal.setText(ordenTrabajo.getCostoRealOt().toString());


         detalleOrdenTrabajoList = ordenTrabajo.getOrdenTrabajoDetalleListList();
         detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);


      }
}

    public String uibuttonGuardarEdicion_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        errorValidacion = false;
        updateRequestOT = true;
        validarCampos();
        ControllerResult controllerResult = new ControllerResult();

        OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();


         if (! errorValidacion){
                            OrdenTrabajo ordenDeTrabajo = new OrdenTrabajo();
                            ordenDeTrabajo = ordenTrabajoCabeceraController.findById(idEditado);

                             ProductoController productoController = new ProductoController();
                             EmpleadoController empleadoController = new EmpleadoController();
                             FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();


                              ordenDeTrabajo.setNumeroOrdenTrabajo(new Long( this.uiNroOT.getText().toString()));
                              ordenDeTrabajo.setCodEmpleado1(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
                              ordenDeTrabajo.setCodEmpleado2(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
                              ordenDeTrabajo.setCodProductoOt(productoController.findById(Long.valueOf(this.uiProducto.getSelected().toString())));
                              ordenDeTrabajo.setCantidadOt(new BigInteger(this.uiCantidad.getText().toString()));
                              ordenDeTrabajo.setCantidadProducidaOt(new BigInteger(this.uiCantidadProducida.getText().toString()));
                              ordenDeTrabajo.setFechaOt(this.uiFechaIni.getSelectedDate());
                              ordenDeTrabajo.setFechaInicialOt(this.uiFechaIni.getSelectedDate());
                              ordenDeTrabajo.setFechaFinOt(this.uiFechaFin.getSelectedDate());
                              ordenDeTrabajo.setCostoEstimadoOt(new BigInteger(this.uiCostoPrevisto.getText().toString()));
                              ordenDeTrabajo.setCostoRealOt(new BigInteger(this.uiCostoReal.getText().toString()));
                              ordenDeTrabajo.setDescripcion(this.uiDescripcionOt.getText().toString());
                              ordenDeTrabajo.setEstadoOt(this.uiEstado.getSelected().toString());


                              OrdenTrabajoDetalle[] ordenTrabajoDetallesEliminados =(OrdenTrabajoDetalle[]) detalleOrdenTrabajoEliminadaList.toArray(new OrdenTrabajoDetalle[0]);
                              RecursoAsignado[] recursoAsignadosEliminados = (RecursoAsignado[]) recursoAsignadoEliminadoList.toArray(new RecursoAsignado[0]);
                              TareaAsignada[] tareaAsignadasEliminadas = (TareaAsignada[]) tareaAsignadaEliminadaList.toArray(new TareaAsignada[0]);
                             
                              controllerResult = ordenTrabajoCabeceraController.updateCabDet(ordenDeTrabajo, detallesOrdenTrabajo, ordenTrabajoDetallesEliminados, tareaAsignadasEliminadas, recursoAsignadosEliminados);

        }
            return null;

    }
}

