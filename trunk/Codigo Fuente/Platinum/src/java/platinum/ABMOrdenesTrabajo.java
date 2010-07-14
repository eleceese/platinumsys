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
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.ImageHyperlink;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.RadioButton;
import com.sun.webui.jsf.component.Tab;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.convert.NumberConverter;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.EntradaSalidaDetalleController;
import py.com.platinum.controller.FormulaCabeceraController;
import py.com.platinum.controller.FormulaDetalleController;
import py.com.platinum.controller.FormulaSemiCabeceraController;
import py.com.platinum.controller.FormulaSemiDetalleController;
import py.com.platinum.controller.MaquinariaController;
import py.com.platinum.controller.OrdenTrabajoCabeceraController;
import py.com.platinum.controller.ParametroController;
import py.com.platinum.controller.ProduccionDiariaController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.SolicitudInternaController;
import py.com.platinum.controller.TareaController;
import py.com.platinum.controller.TareaFormulaController;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.CostosFijos;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.FormulaCabecera;
import py.com.platinum.entity.FormulaDetalle;
import py.com.platinum.entity.FormulaSemiCabecera;
import py.com.platinum.entity.FormulaSemiDetalle;
import py.com.platinum.entity.Maquinarias;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.OrdenTrabajoDetCostoH;
import py.com.platinum.entity.OrdenTrabajoDetCostoMat;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.Parametros;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.RecursoAsignado;
import py.com.platinum.entity.SolicitudInterna;
import py.com.platinum.entity.Tarea;
import py.com.platinum.entity.TareaAsignada;
import py.com.platinum.entity.TareaFormula;
import py.com.platinum.utils.StringUtils;
import py.com.platinum.view.EntradaSalidaCantidad;
import py.com.platinum.view.MaquinariaCantidadHora;
import py.com.platinum.view.TareaEmpleadoCantidad;






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
        Double multiplicador;

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
            multiplicador = Double.valueOf(this.uiCantidad.getText().toString()) / Long.valueOf(formulaSeleccionada.getCantidad().toString());

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
                   Double redondeado = Math.ceil(Long.valueOf(formulaDetalleSeleccionada.getCantidad().toString())* multiplicador);
                   detalleOrdenTrabajo.setCantidad(redondeado.longValue());
                   if (formulaDetalleSeleccionada.getSemiFin() != null && formulaDetalleSeleccionada.getSemiFin().equals("S")) {detalleOrdenTrabajo.setSemiFin("S");}
                   detalleOrdenTrabajo.setCantidadReal(Long.valueOf("0"));
                   detalleOrdenTrabajo.setEstado("A");
                   detalleOrdenTrabajo.setFechaAlta(new Date());
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
                                    redondeado = Math.ceil(Long.valueOf(formulaSemiDetalle.getCantidad().toString())* multiplicador.doubleValue());
                                    recursoAsignado.setCantidad(redondeado.longValue());
                                    recursoAsignado.setCantidadReal(Long.valueOf("0"));

                                    detalleOrdenTrabajo.getRecursoAsignadoCollection().add(recursoAsignado);
                                    System.out.println(detalleOrdenTrabajo.getRecursoAsignadoCollection().size());
                    }

                   for (int j = 0; j < formulaSemiCabeceraSeleccionada.getTareaFormulaListList().size(); j++) {
                        TareaFormula tareaFormula = new TareaFormula();
                        tareaFormula = formulaSemiCabeceraSeleccionada.getTareaFormulaListList().get(j);
                        idAuxiliar ++;
                        TareaAsignada tareaAsignada = new TareaAsignada();
                        tareaAsignada.setCodTareaAsignada(idAuxiliar);
                        tareaAsignada.setCodTarea(tareaFormula.getCodTarea());
                        redondeado = Math.ceil(Long.valueOf(tareaFormula.getCantidadTarea().toString()) * multiplicador.doubleValue());
                        tareaAsignada.setCantidad(redondeado.longValue());
                        tareaAsignada.setCantidadReal(Long.valueOf("0"));
                        tareaAsignada.setCantidadFallida(Long.valueOf("0"));
                        if (tareaFormula.getTareaFin() != null && tareaFormula.getTareaFin().equals("S")) {tareaAsignada.setTareaFin("S");}
                        tareaAsignada.setOrdenTarea(Long.valueOf(tareaFormula.getOrdenTarea().toString()));
                        detalleOrdenTrabajo.getTareaAsignadaCollection().add(tareaAsignada);
                        System.out.println(detalleOrdenTrabajo.getTareaAsignadaCollection().size());
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

//        if (uiNroOT.getText().toString() == null || uiNroOT.getText().equals("") ) {
//        info("Campo obligatorio, favor ingrese el Numero de OT");
//            r = true;
//        }

       
        if (uiDescripcionOt.getText() == null) {
        info("Campo obligatorio, favor ingrese la descripcion de la Orden de Trabajo");
            r = true;
        }

         if (uiResponsableCodigo.getText().toString() == null
                    || uiResponsableCodigo.getText().equals("")
                    || !StringUtils.esNumero(uiResponsableCodigo.getText().toString())    ) {
                        info("Favor ingrese correctamente el Responsable");
                        r = true;
        }else{
                Empleado em = new Empleado();
                em = new EmpleadoController().findById(Long.valueOf(uiResponsableCodigo.getText().toString()));
                if (em == null) {
                        info("Favor ingrese correctamente el Responsable");
                        r = true;
                }

        }

        if (uiProducto.getSelected() == null 
                    || uiProducto.getSelected().equals("")
                    || !StringUtils.esNumero(uiProducto.getSelected().toString())    ) {
            info("Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }else{
                Producto pr = new Producto();
                pr = new ProductoController().findById(Long.valueOf(uiProducto.getSelected().toString()));
                if (pr == null) {
                    info("Favor ingrese el Codigo de Producto");
                    r = true;
            }
        }

        if (uiFormulaCodigo.getText().toString() == null 
                    || uiFormulaCodigo.getText().equals("")
                    || !StringUtils.esNumero(uiFormulaCodigo.getText().toString())    ) {
            info("Campo obligatorio, favor ingrese el Codigo de Formula");
            r = true;
        }else{
            FormulaCabecera formu = new FormulaCabecera();
            formu = new FormulaCabeceraController().findById(Long.valueOf(uiFormulaCodigo.getText().toString()));
                    if (formu == null) {
                        info("Favor ingrese el Codigo correcto de Formula");
                        r = true;
                    }

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

private CostosFijos[] costosFijosOt;
private CostosFijos costoFijoOt;
private List<CostosFijos>  costosFijosList;
private List<CostosFijos>  costosFijosMostradoList;

private OrdenTrabajoDetCostoH[] costosHoraOt;
private OrdenTrabajoDetCostoH costoHoraOt;
private List<OrdenTrabajoDetCostoH>  costosHoraList;
private List<OrdenTrabajoDetCostoH>  costosHoraMostradoList;

private OrdenTrabajoDetCostoMat[] costosMatOt;
private OrdenTrabajoDetCostoMat costoMatOt;
private List<OrdenTrabajoDetCostoMat>  costosMatList;
private List<OrdenTrabajoDetCostoMat>  costosMatMostradoList;

private List<OrdenTrabajoDetalle>  detalleOrdenTrabajoEliminadaList;
private List<TareaAsignada>  tareaAsignadaEliminadaList;
private List<RecursoAsignado>  recursoAsignadoEliminadoList;

private List<SolicitudInterna> solicitudesList;
private SolicitudInterna[] solicitudesAGenerarse;


    private boolean validarCampos(){
        //Variables
        boolean r;

        //Inicializar
        r = false;

        if (detalleOrdenTrabajoList.size() <= 0){
        info("Debe cargar los detalles de productos de la formula");
            r = true;
        }

//        if (uiNroOT.getText().toString() == null || uiNroOT.getText().equals("") ) {
//        info("Campo obligatorio, favor ingrese el Numero de OT");
//            r = true;
//        }

        if (uiResponsableCodigo.getText().toString() == null
                    || uiResponsableCodigo.getText().equals("")
                    || !StringUtils.esNumero(uiResponsableCodigo.getText().toString())    ) {
                        info("Favor ingrese correctamente el Responsable");
                        r = true;
        }else{
                Empleado em = new Empleado();
                em = new EmpleadoController().findById(Long.valueOf(uiResponsableCodigo.getText().toString()));
                if (em == null) {
                        info("Favor ingrese correctamente el Responsable");
                        r = true;
                }

        }



        if (uiDescripcionOt.getText() == null) {
        info("Campo obligatorio, favor ingrese la descripcion de la Orden de Trabajo");
            r = true;
        }


        if (uiProducto.getSelected() == null
                    || uiProducto.getSelected().equals("")
                    || !StringUtils.esNumero(uiProducto.getSelected().toString())    ) {
            info("Campo obligatorio, favor ingrese el Codigo de Producto");
            r = true;
        }else{
                Producto pr = new Producto();
                pr = new ProductoController().findById(Long.valueOf(uiProducto.getSelected().toString()));
                if (pr == null) {
                    info("Favor ingrese el Codigo de Producto");
                    r = true;
            }
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


               if (!StringUtils.esNumero(this.uiCostoPrevisto.getText().toString()))
            {   r = true;
        this.info(uiCantidad, "La cantidad debe ser campo numerico");
            }


        if (!StringUtils.esNumero(this.uiCostoReal.getText().toString()))
            {   r = true;
        this.info(uiCantidad, "El costo debe ser campo numerico");
            }


//        if (uiEstado.getSelected() == null ) {
//        info(uiEstado, "Campo obligatorio, favor seleccione el estado de la OT");
//            r = true;
//        }
        //result

        return r;
    }


    private void _init() throws Exception {
        dropDown1DefaultOptions.setSelectedValue("X");
       

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



    public SolicitudInterna[] getSolicitudesAGenerarse() {
        return solicitudesAGenerarse;
    }

    public void setSolicitudesAGenerarse(SolicitudInterna[] solicitudesAGenerarse) {
        this.solicitudesAGenerarse = solicitudesAGenerarse;
    }



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
    private HtmlPanelGrid gridPanelDetalleSemiTerRecursos1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDetalleSemiTerRecursos1() {
        return gridPanelDetalleSemiTerRecursos1;
    }

    public void setGridPanelDetalleSemiTerRecursos1(HtmlPanelGrid hpg) {
        this.gridPanelDetalleSemiTerRecursos1 = hpg;
    }
    private HtmlPanelGrid gridPanelDetalleSemiTerTareas1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDetalleSemiTerTareas1() {
        return gridPanelDetalleSemiTerTareas1;
    }

    public void setGridPanelDetalleSemiTerTareas1(HtmlPanelGrid hpg) {
        this.gridPanelDetalleSemiTerTareas1 = hpg;
    }
    private HtmlPanelGrid gridPanelGenerarSolicitudes = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelGenerarSolicitudes() {
        return gridPanelGenerarSolicitudes;
    }

    public void setGridPanelGenerarSolicitudes(HtmlPanelGrid hpg) {
        this.gridPanelGenerarSolicitudes = hpg;
    }
    private Checkbox uiDetSemiTerFin = new Checkbox();

    public Checkbox getUiDetSemiTerFin() {
        return uiDetSemiTerFin;
    }

    public void setUiDetSemiTerFin(Checkbox c) {
        this.uiDetSemiTerFin = c;
    }
    private Checkbox uiSemiTerDetFin = new Checkbox();

    public Checkbox getUiSemiTerDetFin() {
        return uiSemiTerDetFin;
    }

    public void setUiSemiTerDetFin(Checkbox c) {
        this.uiSemiTerDetFin = c;
    }
    private TableColumn tableColumnRecursosEdit = new TableColumn();

    public TableColumn getTableColumnRecursosEdit() {
        return tableColumnRecursosEdit;
    }

    public void setTableColumnRecursosEdit(TableColumn tc) {
        this.tableColumnRecursosEdit = tc;
    }
    private TableColumn tableColumnRecursosDel = new TableColumn();

    public TableColumn getTableColumnRecursosDel() {
        return tableColumnRecursosDel;
    }

    public void setTableColumnRecursosDel(TableColumn tc) {
        this.tableColumnRecursosDel = tc;
    }
    private TableColumn tableColumnEditSemiter = new TableColumn();

    public TableColumn getTableColumnEditSemiter() {
        return tableColumnEditSemiter;
    }

    public void setTableColumnEditSemiter(TableColumn tc) {
        this.tableColumnEditSemiter = tc;
    }
    private TableColumn tableColumnDelSemiTer = new TableColumn();

    public TableColumn getTableColumnDelSemiTer() {
        return tableColumnDelSemiTer;
    }

    public void setTableColumnDelSemiTer(TableColumn tc) {
        this.tableColumnDelSemiTer = tc;
    }
    private TableColumn tableColumnCostoSemi = new TableColumn();

    public TableColumn getTableColumnCostoSemi() {
        return tableColumnCostoSemi;
    }

    public void setTableColumnCostoSemi(TableColumn tc) {
        this.tableColumnCostoSemi = tc;
    }
    private HtmlPanelGrid gridPanelCostos = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelCostos() {
        return gridPanelCostos;
    }

    public void setGridPanelCostos(HtmlPanelGrid hpg) {
        this.gridPanelCostos = hpg;
    }
    private Hyperlink uiSemiTerDetLynkRecusos = new Hyperlink();

    public Hyperlink getUiSemiTerDetLynkRecusos() {
        return uiSemiTerDetLynkRecusos;
    }

    public void setUiSemiTerDetLynkRecusos(Hyperlink h) {
        this.uiSemiTerDetLynkRecusos = h;
    }
    private Button uibuttonGuardarCostos = new Button();

    public Button getUibuttonGuardarCostos() {
        return uibuttonGuardarCostos;
    }

    public void setUibuttonGuardarCostos(Button b) {
        this.uibuttonGuardarCostos = b;
    }
    private Button uibuttonCalcularCostos = new Button();

    public Button getUibuttonCalcularCostos() {
        return uibuttonCalcularCostos;
    }

    public void setUibuttonCalcularCostos(Button b) {
        this.uibuttonCalcularCostos = b;
    }
    private ImageHyperlink uiDetCostoEditarCostoHombre = new ImageHyperlink();

    public ImageHyperlink getUiDetCostoEditarCostoHombre() {
        return uiDetCostoEditarCostoHombre;
    }

    public void setUiDetCostoEditarCostoHombre(ImageHyperlink ih) {
        this.uiDetCostoEditarCostoHombre = ih;
    }
    private TableColumn tableColumn42 = new TableColumn();

    public TableColumn getTableColumn42() {
        return tableColumn42;
    }

    public void setTableColumn42(TableColumn tc) {
        this.tableColumn42 = tc;
    }
    private ImageHyperlink uiDetCostoEditarGastoFijo = new ImageHyperlink();

    public ImageHyperlink getUiDetCostoEditarGastoFijo() {
        return uiDetCostoEditarGastoFijo;
    }

    public void setUiDetCostoEditarGastoFijo(ImageHyperlink ih) {
        this.uiDetCostoEditarGastoFijo = ih;
    }
    private TableColumn tableColumn38 = new TableColumn();

    public TableColumn getTableColumn38() {
        return tableColumn38;
    }

    public void setTableColumn38(TableColumn tc) {
        this.tableColumn38 = tc;
    }
    private TextField uiDetCostoHombreEmpleado = new TextField();

    public TextField getUiDetCostoHombreEmpleado() {
        return uiDetCostoHombreEmpleado;
    }

    public void setUiDetCostoHombreEmpleado(TextField tf) {
        this.uiDetCostoHombreEmpleado = tf;
    }
    private TextField uiDetCostoHombreCosto = new TextField();

    public TextField getUiDetCostoHombreCosto() {
        return uiDetCostoHombreCosto;
    }

    public void setUiDetCostoHombreCosto(TextField tf) {
        this.uiDetCostoHombreCosto = tf;
    }
    private TextArea uiDetCostoFijoDescripcion = new TextArea();

    public TextArea getUiDetCostoFijoDescripcion() {
        return uiDetCostoFijoDescripcion;
    }

    public void setUiDetCostoFijoDescripcion(TextArea ta) {
        this.uiDetCostoFijoDescripcion = ta;
    }
    private TextField uiDetCostoFijoMonto = new TextField();

    public TextField getUiDetCostoFijoMonto() {
        return uiDetCostoFijoMonto;
    }

    public void setUiDetCostoFijoMonto(TextField tf) {
        this.uiDetCostoFijoMonto = tf;
    }
    private TableColumn tableColumnVerDetalles = new TableColumn();

    public TableColumn getTableColumnVerDetalles() {
        return tableColumnVerDetalles;
    }

    public void setTableColumnVerDetalles(TableColumn tc) {
        this.tableColumnVerDetalles = tc;
    }
    private Button uiButtonSemiterVolver = new Button();

    public Button getUiButtonSemiterVolver() {
        return uiButtonSemiterVolver;
    }

    public void setUiButtonSemiterVolver(Button b) {
        this.uiButtonSemiterVolver = b;
    }
    private TextField uiSemiTerCabcod = new TextField();

    public TextField getUiSemiTerCabcod() {
        return uiSemiTerCabcod;
    }

    public void setUiSemiTerCabcod(TextField tf) {
        this.uiSemiTerCabcod = tf;
    }
    private Label uiLabelDetCabCosto = new Label();

    public Label getUiLabelDetCabCosto() {
        return uiLabelDetCabCosto;
    }

    public void setUiLabelDetCabCosto(Label l) {
        this.uiLabelDetCabCosto = l;
    }
    private TextField uiSemiTerCabCostoTotal = new TextField();

    public TextField getUiSemiTerCabCostoTotal() {
        return uiSemiTerCabCostoTotal;
    }

    public void setUiSemiTerCabCostoTotal(TextField tf) {
        this.uiSemiTerCabCostoTotal = tf;
    }
    private TableColumn tableColumTareasEdit = new TableColumn();

    public TableColumn getTableColumTareasEdit() {
        return tableColumTareasEdit;
    }

    public void setTableColumTareasEdit(TableColumn tc) {
        this.tableColumTareasEdit = tc;
    }
    private TableColumn tableColumnTareasDel = new TableColumn();

    public TableColumn getTableColumnTareasDel() {
        return tableColumnTareasDel;
    }

    public void setTableColumnTareasDel(TableColumn tc) {
        this.tableColumnTareasDel = tc;
    }
    private Button uiButtonSemiTerAddDetalleTarea = new Button();

    public Button getUiButtonSemiTerAddDetalleTarea() {
        return uiButtonSemiTerAddDetalleTarea;
    }

    public void setUiButtonSemiTerAddDetalleTarea(Button b) {
        this.uiButtonSemiTerAddDetalleTarea = b;
    }
    private Button uiButtonSemiTerAddDetalleRecurso = new Button();

    public Button getUiButtonSemiTerAddDetalleRecurso() {
        return uiButtonSemiTerAddDetalleRecurso;
    }

    public void setUiButtonSemiTerAddDetalleRecurso(Button b) {
        this.uiButtonSemiTerAddDetalleRecurso = b;
    }
    private Button uiButtonAgregarDetalleOt = new Button();

    public Button getUiButtonAgregarDetalleOt() {
        return uiButtonAgregarDetalleOt;
    }

    public void setUiButtonAgregarDetalleOt(Button b) {
        this.uiButtonAgregarDetalleOt = b;
    }
    private Label activarLabel = new Label();

    public Label getActivarLabel() {
        return activarLabel;
    }

    public void setActivarLabel(Label l) {
        this.activarLabel = l;
    }
    private NumberConverter numberConverter1 = new NumberConverter();

    public NumberConverter getNumberConverter1() {
        return numberConverter1;
    }

    public void setNumberConverter1(NumberConverter nc) {
        this.numberConverter1 = nc;
    }
    private NumberConverter numberConverter2 = new NumberConverter();

    public NumberConverter getNumberConverter2() {
        return numberConverter2;
    }

    public void setNumberConverter2(NumberConverter nc) {
        this.numberConverter2 = nc;
    }
    private TextField uiDetCostoFijoCostoUnit = new TextField();

    public TextField getUiDetCostoFijoCostoUnit() {
        return uiDetCostoFijoCostoUnit;
    }

    public void setUiDetCostoFijoCostoUnit(TextField tf) {
        this.uiDetCostoFijoCostoUnit = tf;
    }
    private TextField uiDetCostoFijoCantidad = new TextField();

    public TextField getUiDetCostoFijoCantidad() {
        return uiDetCostoFijoCantidad;
    }

    public void setUiDetCostoFijoCantidad(TextField tf) {
        this.uiDetCostoFijoCantidad = tf;
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
    public void cargarRelaciones() {
        getSessionBean1().cargarListaTodosProductosTerminados();
        getSessionBean1().cargarListaTodosProductos();
        getSessionBean1().cargarListaTodosProductosSemiterminados();
        getSessionBean1().cargarListaTodosProductosTerSemiInsMat();
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
    private boolean addRequestOT2 = false;
    private boolean updateRequestOT = false;
    private boolean updateRequestOT2 = false;
    private boolean updateCostoOT = false;
    private boolean updateGastoFijo = false;

    private boolean verDetalleSemiter = false;
    private boolean verDetalleCosto = false;

    private boolean errorValidacion = false;
    private boolean addDetalleOt = false;
    private boolean editarDetalleOt = false;
    private boolean generarSolicitudes = false;

    private boolean  editarDetalleSemiterRecurso = false;
    private boolean editarDetalleSemiterTarea = false;

    private long idAuxiliar = 0;



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
                 &&!getSessionBean1().getUsuarioLogueado().getRol().toString().equals("ADMINISTRADOR")){
            HttpServletResponse response = (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
                    try {
                        response.sendRedirect("/Platinum/faces/PermisoDenegado.jsp");
                        getFacesContext().responseComplete();
                    } catch (IOException ex) {
                        Logger.getLogger(cabecera.class.getName()).log(Level.SEVERE, null, ex);
                    }


        }


        if (addRequestOT) {

            this.gridPanelBuscar.setRendered(false);
            this.uiNroOT.setDisabled(true);
            this.gridPanelDatosCabecera.setRendered(true);
            this.gridPanelDetalleOT.setRendered(true);
            this.gridPanelDetalleSemiter.setRendered(false);
            this.gridPanelCostos.setRendered(false);

            this.tableColumnVerDetalles.setRendered(true);
            this.uiSemiTerDetLynkRecusos.setText("Ver Detalles...");

        } else if(generarSolicitudes){

           this.gridPanelBuscar.setRendered(false);
           this.gridPanelDatosCabecera.setRendered(false);
           this.gridPanelDetalleOT.setRendered(false);
           this.gridPanelDetalleSemiter.setRendered(true);
           this.gridPanelCostos.setRendered(false);

                this.gridPanelDetalleSemiTerRecursos1.setRendered(false);
                this.gridPanelDetalleSemiTerTareas1.setRendered(false);
                this.gridPanelGenerarSolicitudes.setRendered(true);



        } else if (updateRequestOT) {

    
            this.gridPanelBuscar.setRendered(false);
            this.gridPanelDatosCabecera.setRendered(true);
            this.gridPanelDetalleOT.setRendered(true);
            this.gridPanelDetalleSemiter.setRendered(false);
            this.gridPanelCostos.setRendered(false);

          //     this.gridPanelDetalleSemiTerminados.setRendered(false);

                this.tableColumnCostoSemi.setRendered(false);
//                this.tableColumnDelSemiTer.setRendered(true);
//                this.tableColumnEditSemiter.setRendered(true);
            
                this.tableColumnVerDetalles.setRendered(true);
                this.uiSemiTerDetLynkRecusos.setText("Ver Detalles...");

        
        } else if (updateCostoOT) {

            this.gridPanelBuscar.setRendered(false);
            this.gridPanelDatosCabecera.setRendered(true);
            this.gridPanelDetalleOT.setRendered(true);
            this.gridPanelDetalleSemiter.setRendered(false);
            this.gridPanelCostos.setRendered(false);

                this.tableColumnCostoSemi.setRendered(true);
                this.tableColumnDelSemiTer.setRendered(false);
                this.tableColumnEditSemiter.setRendered(false);

                this.uiSemiTerDetLynkRecusos.setText("Ver Costos...");
//                this.tableColumnVerDetalles.setRendered(false);

        } else if (addDetalleOt) {


            this.gridPanelBuscar.setRendered(false);
            this.gridPanelDatosCabecera.setRendered(false);
            this.gridPanelDetalleOT.setRendered(false);
            this.gridPanelDetalleSemiter.setRendered(false);
            this.gridPanelCostos.setRendered(false);
//               this.gridPanelDetalleSemiTerminados.setRendered(true);

        } else if (verDetalleSemiter) {

           this.gridPanelBuscar.setRendered(false);
           this.gridPanelDatosCabecera.setRendered(false);
           this.gridPanelDetalleOT.setRendered(false);
           this.gridPanelDetalleSemiter.setRendered(true);

                this.gridPanelDetalleSemiTerRecursos1.setRendered(true);
                this.gridPanelDetalleSemiTerTareas1.setRendered(true);
                this.gridPanelGenerarSolicitudes.setRendered(false);

        } else if (verDetalleCosto) {

           this.gridPanelBuscar.setRendered(false);
           this.gridPanelDatosCabecera.setRendered(false);
           this.gridPanelDetalleOT.setRendered(false);
           this.gridPanelDetalleSemiter.setRendered(true);
           this.gridPanelCostos.setRendered(true);

           this.gridPanelDetalleSemiTerRecursos1.setRendered(false);
                this.gridPanelDetalleSemiTerTareas1.setRendered(false);
                this.gridPanelGenerarSolicitudes.setRendered(false);


        } else {

            this.gridPanelBuscar.setRendered(true);
            this.gridPanelDatosCabecera.setRendered(false);
            this.gridPanelDetalleOT.setRendered(false);
            this.gridPanelDetalleSemiter.setRendered(false);
            this.gridPanelCostos.setRendered(false);
 //              this.gridPanelDetalleSemiTerminados.setRendered(false);
        }

cargarRelaciones();
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
        this.updateCostoOT=false;
        this.addDetalleOt=false;
        this.errorValidacion =false;
        this.verDetalleSemiter = false;


       ////Limpiar los campos de Filtro
           this.uiProductoFil.setSelected("");
           this.uiFechaDesdeFil.setSelectedDate(null);
           this.uiFechaHastaFil.setSelectedDate(null);
           this.uiEstadoFil.setSelected("X");
           this.uiTodosFil.setSelected(true);
       



        return null;
    }

    public String uiButtonNuevoRegistro_action() {
        // TODO: Replace with your code
        this.uiNroOT.setText("");

        this.uiResponsableCodigo.setText("");
        this.uiResponsableCodigo.setDisabled(false);

        this.uiResponsableNombre.setText("");
        
        this.uiProducto.setSelected("");
        this.uiProducto.setDisabled(false);

        this.uiFormulaCodigo.setText("");
        this.uiFormulaCodigo.setDisabled(false);

        this.uiFormulaNombre.setText("");

        this.uiEstado.setDisabled(true);

        this.uiCantidad.setText("");
        this.uiCantidad.setDisabled(false);

        this.uiCantidadProducida.setText("0");
        
        this.uiFechaIni.setSelectedDate(new Date());
        this.uiFechaIni.setDisabled(false);

        this.uiFechaFin.setSelectedDate(new Date());
        this.uiFechaFin.setDisabled(false);
        
        this.uiCostoReal.setText("0");

        this.uiCostoPrevisto.setText("");
        this.uiCostoPrevisto.setDisabled(false);

        this.pageAlert1.setRendered(false);
        this.uiButtonAgregarDetalleOt.setRendered(true);
        this.uiButtonGuardarRegistro.setRendered(true);
        this.uibuttonGuardarCostos.setRendered(false);
        this.uibuttonGuardarEdicion.setRendered(false);
        this.uibuttonCalcularCostos.setRendered(false);

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


//    public String button3_action() {
//        // TODO: Process the action. Return value is a navigation
//        // case name where null will return to the same page.
////            errorValidacion = validarCampos();
//
//        detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);
//        recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoList.toArray(new RecursoAsignado[0]);
//        tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaList.toArray(new TareaAsignada[0]);
//
//        //Si no hay error de validacion
//        if (! errorValidacion){
//
//            //// CARGA DE LA CABECERA
//          OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
//          ProductoController productoController = new ProductoController();
//          EmpleadoController empleadoController = new EmpleadoController();
//          FormulaCabeceraController formulaCabeceraController = new FormulaCabeceraController();
//
//
////          ordenTrabajo.setNumeroOrdenTrabajo(new Long( this.uiNroOT.getText().toString()));
//          ordenTrabajo.setCodEmpleado1(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
//          ordenTrabajo.setCodEmpleado2(empleadoController.findById(Long.valueOf(this.uiResponsableCodigo.getText().toString())));
//          ordenTrabajo.setCodProductoOt(productoController.findById(Long.valueOf(this.uiProducto.getSelected().toString())));
//          ordenTrabajo.setCantidadOt(new BigInteger(this.uiCantidad.getText().toString()));
//          ordenTrabajo.setCantidadProducidaOt(new BigInteger(this.uiCantidadProducida.getText().toString()));
//          ordenTrabajo.setFechaInicialOt(this.uiFechaIni.getSelectedDate());
//          ordenTrabajo.setFechaFinOt(this.uiFechaFin.getSelectedDate());
//          ordenTrabajo.setCostoEstimadoOt(new BigInteger(this.uiCostoPrevisto.getText().toString()));
//          ordenTrabajo.setCostoRealOt(new BigInteger(this.uiCostoReal.getText().toString()));
//          ordenTrabajo.setEstadoOt("A");
//
//          OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();
//          ControllerResult controllerResult = new ControllerResult();
//
//          controllerResult = ordenTrabajoCabeceraController.createCabDet(ordenTrabajo, detallesOrdenTrabajo);
//
//          if (controllerResult.getCodRetorno() != -1) {
//                addRequestOT = false;
//                this.pageAlert1.setType("information");
//        }else{
//
//        this.pageAlert1.setType("error");
//        this.errorValidacion=true;
//
//        }
//
//            this.pageAlert1.setTitle(controllerResult.getMsg());
//            this.pageAlert1.setSummary("");
//            this.pageAlert1.setDetail("");
//            this.pageAlert1.setRendered(true);
//
//       }
//           return null;
//    }

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


//          ordenTrabajo.setNumeroOrdenTrabajo(new Long( this.uiNroOT.getText().toString()));
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
          ordenTrabajo.setEstadoOt("A");

        
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
                   detalleOrdenTrabajo.setCantidadReal(Long.valueOf("0"));
                   detalleOrdenTrabajo.setEstado("A");
                   detalleOrdenTrabajo.setFechaAlta(new Date());
                   detalleOrdenTrabajo.setCodEmpleado(empleado);
                   detalleOrdenTrabajo.setRecursoAsignadoCollection(new HashSet());
                   detalleOrdenTrabajo.setTareaAsignadaCollection(new HashSet());
                   detalleOrdenTrabajoList.add(detalleOrdenTrabajo);

            }else{
//          Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetProductoCodigo.getText().toString()));

                detalleOrdenTrabajo = new OrdenTrabajoDetalle();
                detalleOrdenTrabajo  = detalleOrdenTrabajoList.get(Integer.valueOf(itemDet).intValue());

               if (detalleOrdenTrabajo.getRecursoAsignadoListList().size() > 0 || detalleOrdenTrabajo.getTareaAsignadaListList().size() > 0) {
                            info("La sub-orden tiene detalles. Se debe actualizar desde la vista Detalles");

               }else{

                   Producto producto = new ProductoController().findById(Long.valueOf(this.uiDetSemiTerCodProd.getText().toString()));
                   Empleado empleado = new EmpleadoController().findById(Long.valueOf(this.uiResponsableCodigo.getText().toString()));

                   // Durante la edicion del producto ya no se podra actualizar el producto
                   //detalleOrdenTrabajo.setCodProducto(producto);
                   
                   detalleOrdenTrabajo.setCantidad(BigInteger.valueOf(Long.valueOf(this.uiDetSemiTerCant.getText().toString())).longValue());
                   detalleOrdenTrabajo.setEstado("A");
                   detalleOrdenTrabajo.setCodEmpleado(empleado);

               }

            editarDetalleOt = false;


           }
           this.uiDetSemiTerCodProd.setDisabled(false);
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
        if (uiDetSemiTerCodProd.getText() == null || uiDetSemiTerCodProd.getText().equals("")
                        ||!StringUtils.esNumero(uiDetSemiTerCodProd.getText().toString())) {
                this.errorValidacion= true;
                info("Verifique el detalle, debe ingresar el Codigo de Producto");
        }else{
            Producto prod = new Producto();
                prod = new ProductoController().findById(Long.valueOf(uiDetSemiTerCodProd.getText().toString()));
                if (prod == null || !prod.getCodTipoProducto().getDescripcion().equals("SemiTerminado")) {
                            this.errorValidacion= true;
                            info("Seleccione correctamente el producto");
                } else if(!editarDetalleOt){
                    for (int i = 0; i < detalleOrdenTrabajoList.size(); i++) {
                        OrdenTrabajoDetalle detOt = detalleOrdenTrabajoList.get(i);
                        if (detOt.getCodProducto().getCodProducto().toString().equals(uiDetSemiTerCodProd.getText().toString())) {
                            this.errorValidacion= true;
                            info("El Semiterminado ya fue asignado");
                            break;
                        }
                    }
                }

     }

        if (uiResponsableCodigo.getText() == null || uiResponsableCodigo.getText().equals("") 
                        || !StringUtils.esNumero(uiResponsableCodigo.getText().toString())) {
                this.errorValidacion= true;
                info("Seleccione el empleado Responsable");
        }else{
                Empleado emp = new Empleado();
                emp = new EmpleadoController().findById(Long.valueOf(uiResponsableCodigo.getText().toString()));
                if (emp == null) {
                    this.errorValidacion= true;
                    info("Seleccione el empleado Responsable");
                }
        }

        if (uiDetSemiTerCant.getText() == null || uiDetSemiTerCant.getText().equals("")
                    || (!StringUtils.esNumero(uiDetSemiTerCant.getText().toString()))) {
        this.errorValidacion= true;
        info("Verifique el detalle, debe ingresar correctamente la Cantidad");
        }else if(Long.valueOf(uiDetSemiTerCant.getText().toString())<1){
            this.errorValidacion= true;
            info("Verifique el detalle, debe ingresar correctamente la Cantidad");
        }

    }

     public String uiEditDetLynk_action() {

            editarDetalleOt = true;

            OrdenTrabajoDetalle ordenTrabajoDetalle = new OrdenTrabajoDetalle();
            ordenTrabajoDetalle = detalleOrdenTrabajoList.get(Integer.valueOf(itemDet).intValue());
            this.uiDetSemiTerCodProd.setDisabled(true);
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
    OrdenTrabajoDetalle detalleOrdenTrabajo = detalleOrdenTrabajoList.get(Integer.valueOf(itemDet).intValue());
        if (detalleOrdenTrabajo.getRecursoAsignadoListList().size() > 0 || detalleOrdenTrabajo.getTareaAsignadaListList().size() > 0) {
            info("No se puede eliminar el Detalle de semiterminado porque contiene Recursos y Tareas");

        } else {

                if (updateRequestOT) {
                    detalleOrdenTrabajoEliminadaList.add(detalleOrdenTrabajo);

                }

                detalleOrdenTrabajoList.remove(Integer.valueOf(itemDet).intValue());
                detallesOrdenTrabajo = (OrdenTrabajoDetalle[]) detalleOrdenTrabajoList.toArray(new OrdenTrabajoDetalle[0]);


        }
    return null;
    }


     public String uiButtonSemiterVolver_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        System.out.println(addRequestOT);

         if (updateRequestOT2) {
             updateRequestOT2 = false;
             updateRequestOT=true;
             addRequestOT=false;
         }

         if (addRequestOT2) {
             addRequestOT2 = false;
             updateRequestOT=false;
             addRequestOT=true;
         }


//  this.addRequestOT=true;
//        this.updateRequestOT=false;
        this.updateCostoOT=false;
        this.addDetalleOt=false;
        this.errorValidacion =false;
        this.verDetalleSemiter = false;
        this.verDetalleCosto = false;

        return null;
        

    }

    public String uiSemiTerDetLynkRecusos_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

//        if (updateRequestOT) {
                limpiarDetalleSemiTer();

                /// esta bandera se utiliza para controlar las banderas a la vuelta del detalle
                if (addRequestOT) {
                    addRequestOT2 = true;
                }else{
                    addRequestOT2 = false;
                }

                this.addRequestOT=false;


                /// esta bandera updateRequestOT2 solo se utiliza para el momento de borrado de un detalle de recursos o tareas
                if (updateRequestOT) {
                    this.updateRequestOT2 = true;
                }else{
                     this.updateRequestOT2 = false;
                }

                this.updateRequestOT=false;
               
//                this.updateCostoOT=false;
                this.addDetalleOt=false;
                this.errorValidacion =false;
                

                RecursoAsignado recursoAsignado;
                TareaAsignada tareaAsignada;

                detalleOrdenTrabajo = detalleOrdenTrabajoList.get(Integer.valueOf(itemDetalleOt).intValue());

                if (detalleOrdenTrabajo.getEstado().toString().equals("P") ) {
                    this.uiSemiTerCabActivoCheck.setRendered(true);
//                    this.uiButtonActivarOtDet.setRendered(true);
                    this.activarLabel.setText("Activo");

                    this.uiSemiTerCabActivoCheck.setSelected(true);
//                    this.uiButtonActivarOtDet.setText("Cerrar Sub Ot");
                } else if(detalleOrdenTrabajo.getEstado().toString().equals("A")) {
                    this.uiSemiTerCabActivoCheck.setRendered(true);
//                    this.uiButtonActivarOtDet.setRendered(true);
                    this.activarLabel.setText("Activo");

                    this.uiSemiTerCabActivoCheck.setSelected(false);
//                    this.uiButtonActivarOtDet.setText("Activar Sub Ot");
                } else{
                    this.uiSemiTerCabActivoCheck.setRendered(false);
//                    this.uiButtonActivarOtDet.setRendered(false);
                    this.activarLabel.setText("CERRADO");
                }

                this.uiSemiTerCabProductoCod.setText(detalleOrdenTrabajo.getCodProducto().getCodProducto().toString());
                this.uiSemiTerCabProductoDesc.setText(detalleOrdenTrabajo.getCodProducto().getDescripcion().toString());

                this.uiSemiTerCabDesc.setText(detalleOrdenTrabajo.getCodProducto().getDescripcion().toString());
                this.uiSemiTerCabCant.setText(String.valueOf(detalleOrdenTrabajo.getCantidad()));




                if (detalleOrdenTrabajo.getCantidadReal() != null &&
                        detalleOrdenTrabajo.getCantidadReal() > 0) {
                        this.uiSemiTerCabCantProd.setText(detalleOrdenTrabajo.getCantidadReal().toString());
                }else{
                    this.uiSemiTerCabCantProd.setText("0");
                }

                if (detalleOrdenTrabajo.getCodOrdenTrabajoDet() != null) {
                    this.uiSemiTerCabcod.setText(detalleOrdenTrabajo.getCodOrdenTrabajoDet().toString());
                }else{
                    this.uiSemiTerCabcod.setText("---");
                }

                if (updateCostoOT) {

                            this.uiLabelDetCabCosto.setRendered(true);
                            this.uiSemiTerCabCostoTotal.setRendered(true);
                            this.uiSemiTerCabCostoTotal.setText(detalleOrdenTrabajo.getCostoReal().toString());


                            this.uiButtonSemiterVolver.setRendered(false);
                            this.verDetalleCosto= true;
                            this.verDetalleSemiter= false;
                            costosFijosMostradoList = detalleOrdenTrabajo.getCostosFijosListList();
                            costosFijosOt = (CostosFijos[])  costosFijosMostradoList.toArray(new CostosFijos[0]);

                            costosHoraMostradoList = detalleOrdenTrabajo.getOrdenTrabajoDetCostoListList();
                            costosHoraOt = (OrdenTrabajoDetCostoH[]) costosHoraMostradoList.toArray(new OrdenTrabajoDetCostoH[0]);

                            costosMatMostradoList = detalleOrdenTrabajo.getOrdenTrabajoDetMListList();
                            costosMatOt = (OrdenTrabajoDetCostoMat[]) costosMatMostradoList.toArray(new OrdenTrabajoDetCostoMat[0]);
                            this.updateCostoOT = false;



                }else{
                            this.uiLabelDetCabCosto.setRendered(false);
                            this.uiSemiTerCabCostoTotal.setRendered(false);

                                this.uiButtonSemiterVolver.setRendered(true);
                                this.verDetalleSemiter = true;
                                this.verDetalleCosto = true;
                                recursoAsignadoMostradoList = detalleOrdenTrabajo.getRecursoAsignadoListList();
                                recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoMostradoList.toArray(new RecursoAsignado[0]);

                                tareaAsignadaMostradaList = detalleOrdenTrabajo.getTareaAsignadaListList();
                                tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaMostradaList.toArray(new TareaAsignada[0]);

//                                if (detalleOrdenTrabajo.getCodOrdenTrabajo() != null) {
////                                    this.uiButtonActivarOtDet.setRendered(true);
//
//                                } else {
//                                    this.uiButtonActivarOtDet.setRendered(false);
//
//                                }
                }
                      
        return null;
    }

    public void validarDetalleProducto(){
        this.errorValidacion= false;
        if (uiSemiTerDetCodRecurso.getText() == null 
                || uiSemiTerDetCodRecurso.getText().equals("")
                || !StringUtils.esNumero(uiSemiTerDetCodRecurso.getText().toString()) ) {
                        this.errorValidacion= true;
                        info("Verifique el detalle");
        }else{
              Producto prod = new Producto();
              prod = new ProductoController().findById(Long.valueOf(uiSemiTerDetCodRecurso.getText().toString()));
              if (prod == null
                        || !prod.getCodTipoProducto().getDescripcion().toString().equals("ProductoGenerico")){
                        this.errorValidacion= true;
                        info("El producto debe ser Generico");
              } else if((!editarDetalleSemiterRecurso)){
            /// una vez qe existe el codigo validamos que ya no se haya cargado
                for (int i = 0; i < recursoAsignadoMostradoList.size(); i++) {
                        RecursoAsignado rec = recursoAsignadoMostradoList.get(i);
                        if (rec.getCodProducto().getCodProducto().toString().equals(uiSemiTerDetCodRecurso.getText().toString()) ) {
                           this.errorValidacion= true;
                            info("El Recurso ya fue asignado");
                            break;
                        }
                }
                    
            }
        }

        if (uiSemiTerDetCantRecurso.getText() == null ||
                    uiSemiTerDetCantRecurso.getText().equals("") ||
                        !StringUtils.esNumero(uiSemiTerDetCantRecurso.getText().toString()))
        {
        this.errorValidacion= true;
        info("Verifique la cantidad el detalle");
        }else if(Long.valueOf(uiSemiTerDetCantRecurso.getText().toString())<1) {
            this.errorValidacion= true;
            info("Verifique la cantidad el detalle");
        }
    }

    public void validarDetalleTarea(){
        this.errorValidacion= false;
        if (uiSemiTerDetCodTarea.getText() == null || uiSemiTerDetCodTarea.getText().equals("")
                    || !StringUtils.esNumero(uiSemiTerDetCodTarea.getText().toString())) {
            this.errorValidacion= true;
            info("Verifique el detalle");
        }else{
            Tarea tare = new Tarea();
            tare = new TareaController().findById(Long.valueOf(uiSemiTerDetCodTarea.getText().toString()));
            if (tare == null) {
                            this.errorValidacion= true;
                            info("Verifique el detalle");
            } else if(!editarDetalleSemiterTarea){
                for (int i = 0; i < tareaAsignadaMostradaList.size(); i++) {
                        TareaAsignada tar = tareaAsignadaMostradaList.get(i);
                        if (tar.getCodTarea().getCodTarea().toString().equals(uiSemiTerDetCodTarea.getText().toString()) ) {
                            this.errorValidacion= true;
                            info("La tarea ya fue asignada");
                            break;
                        }
                }
            }

      }
                if (uiSemiTerDetFin.isChecked()) {
                    boolean fin = false;
                        for (int i = 0; i < tareaAsignadaMostradaList.size(); i++) {
                           TareaAsignada tar = tareaAsignadaMostradaList.get(i);
                            if (tar.getTareaFin() != null && tar.getTareaFin().toString().equals("S")) {
                                fin = true;
                                break;
                            }
                       }
                    if (fin) {
                        this.errorValidacion= true;
                        info("Ya existe una Tarea de Finalizacion");
                    }


                }
        

        if (uiSemiTerDetCantTarea.getText() == null || 
                uiSemiTerDetCantTarea.getText().equals("") ||
                      !StringUtils.esNumero(uiSemiTerDetCantTarea.getText().toString())) {
        this.errorValidacion= true;
        info("Verifique la cantidad del Detalle");
        }else if(Long.valueOf(uiSemiTerDetCantTarea.getText().toString())<1){
            this.errorValidacion= true;
            info("Verifique la cantidad el detalle");
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
                   recursoAsignadoOt.setCantidad(Long.valueOf(this.uiSemiTerDetCantRecurso.getText().toString()));
                   recursoAsignadoOt.setCantidadReal(Long.valueOf("0"));
                   recursoAsignadoOt.setCodRecurso(idAuxiliar);
                   recursoAsignadoOt.setFecha(this.uiFechaIni.getSelectedDate());
                   recursoAsignadoMostradoList.add(recursoAsignadoOt);

            }else{
                   recursoAsignadoOt = new RecursoAsignado();
                   recursoAsignadoOt  = recursoAsignadoMostradoList.get(Integer.valueOf(itemDet).intValue());
                   Producto producto = new ProductoController().findById(Long.valueOf(this.uiSemiTerDetCodRecurso.getText().toString()));
                   recursoAsignadoOt.setCantidad(Long.valueOf(this.uiSemiTerDetCantRecurso.getText().toString()));
                   
                   //Durante la edicion ya no se podra editar el  codigo de producto
                   //recursoAsignadoOt.setCodProducto(producto);

                    editarDetalleSemiterRecurso = false;

            }



            detalleOrdenTrabajo.setRecursoAsignadoCollectionFromList(recursoAsignadoMostradoList);
            recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoMostradoList.toArray(new RecursoAsignado[0]);
            limpiarDetalleOtRecurso();
            this.uiSemiTerDetCodRecurso.setDisabled(false);


        }

        return null;
    }

    public void limpiarDetalleOtRecurso(){
        this.uiSemiTerDetCodRecurso.setText("");
        this.uiSemiTerDetDescRecurso.setText("");
        this.uiSemiTerDetCantRecurso.setText("");
    }


    public void limpiarDetalleOtTarea(){
        this.uiSemiTerDetCodTarea.setText("");
        this.uiSemiTerDetDescTarea.setText("");
        this.uiSemiTerDetCantTarea.setText("");

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
                   tareaAsignadaOt.setCantidadReal(Long.valueOf("0"));
                   tareaAsignadaOt.setCantidadFallida(Long.valueOf("0"));
                   tareaAsignadaOt.setCodTareaAsignada(idAuxiliar);
                   if (uiSemiTerDetFin.isChecked()) {
                       tareaAsignadaOt.setTareaFin("S");
                   }
                   tareaAsignadaMostradaList.add(tareaAsignadaOt);
                   editarDetalleSemiterTarea = false;
            }else{
                   Tarea tarea = new TareaController().findById(Long.valueOf(this.uiSemiTerDetCodTarea.getText().toString()));
                   tareaAsignadaOt = new TareaAsignada();
                   tareaAsignadaOt  = tareaAsignadaMostradaList.get(Integer.valueOf(itemDet).intValue());
                   
                   //Durante la edicion ya no se podra editar el codigo de tarea...
                   //tareaAsignadaOt.setCodTarea(tarea);

                   tareaAsignadaOt.setCantidad(Long.valueOf(this.uiSemiTerDetCantTarea.getText().toString()));
                   editarDetalleSemiterTarea = false;
            }
            detalleOrdenTrabajo.setTareaAsignadaCollectionFromList(tareaAsignadaMostradaList);
            tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaMostradaList.toArray(new TareaAsignada[0]);
            limpiarDetalleOtTarea();
            this.uiSemiTerDetCodTarea.setDisabled(false);

        }

        return null;
}

    public String uiSemiTerDetEditTareaLink_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

         editarDetalleSemiterTarea = true;
        this.uiSemiTerDetCodTarea.setDisabled(true);


         TareaAsignada tareaAsignada = new TareaAsignada();
         tareaAsignada = tareaAsignadaMostradaList.get(Integer.valueOf(itemDet).intValue());

         this.uiSemiTerDetCodTarea.setText(tareaAsignada.getCodTarea().getCodTarea().toString());
         this.uiSemiTerDetDescTarea.setText(tareaAsignada.getCodTarea().getNombreTarea().toString());
         this.uiSemiTerDetCantTarea.setText(String.valueOf(tareaAsignada.getCantidad()));
         if (tareaAsignada.getTareaFin() != null && tareaAsignada.getTareaFin().toString().equals("S")) {
           uiSemiTerDetFin.setSelected(true);
        }

         return null;
    }

    public String uiSemiTerDetRemoveTareaLink_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        TareaAsignada tareaAsignada = tareaAsignadaMostradaList.get(Integer.valueOf(itemDet).intValue());

        if (updateRequestOT2) {

            if (tareaAsignada.getCantidadReal() > 0) {
                 info("No se puede eliminar la tarea porque ya se han Efectuado");
            }else{
                tareaAsignadaEliminadaList.add(tareaAsignada);
                tareaAsignadaMostradaList.remove(Integer.valueOf(itemDet).intValue());
            }
        }else{
            tareaAsignadaMostradaList.remove(Integer.valueOf(itemDet).intValue());
        }

        detalleOrdenTrabajo.setTareaAsignadaCollectionFromList(tareaAsignadaMostradaList);
        tareasAsignadasOt = (TareaAsignada[]) tareaAsignadaMostradaList.toArray(new TareaAsignada[0]);

        return null;
    }

    public String uiSemiTerEditRecursoLink_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
      

        editarDetalleSemiterRecurso = true;
        this.uiSemiTerDetCodRecurso.setDisabled(true);

         RecursoAsignado recursoAsignado = new RecursoAsignado();
         recursoAsignado = recursoAsignadoMostradoList.get(Integer.valueOf(itemDet).intValue());

         this.uiSemiTerDetCodRecurso.setText(recursoAsignado.getCodProducto().getCodProducto().toString());
         this.uiSemiTerDetDescRecurso.setText(recursoAsignado.getCodProducto().getDescripcion().toString());
         this.uiSemiTerDetCantRecurso.setText(String.valueOf(recursoAsignado.getCantidad()));


     return null;
    }

    public String uiSemiTerRemoveRecursoLink_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        if (updateRequestOT2) {
        RecursoAsignado recursoAsignado = recursoAsignadoMostradoList.get(Integer.valueOf(itemDet).intValue());
            if (recursoAsignado.getCantidadReal() > 0) {
                info("El registro no puede ser eliminado porque ya se han realizado retiros del deposito");

            }else{
                recursoAsignadoEliminadoList.add(recursoAsignado);
                recursoAsignadoMostradoList.remove(Integer.valueOf(itemDet).intValue());
            }
        }else{
            recursoAsignadoMostradoList.remove(Integer.valueOf(itemDet).intValue());
        }
        detalleOrdenTrabajo.setRecursoAsignadoCollectionFromList(recursoAsignadoMostradoList);
        recursosAsignadosOt = (RecursoAsignado[]) recursoAsignadoMostradoList.toArray(new RecursoAsignado[0]);
        return null;
    }


public String uiButtonActivarOtDet_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
     
   //////LA ACTIVACION DE LAS OTS SE HARA DESDE OTRO FORMULARIO
//
//    if (recursoAsignadoMostradoList.size() > 0 && tareaAsignadaMostradaList.size()> 0) {
//
//        if (detalleOrdenTrabajo.getEstado() != null &&
//                        detalleOrdenTrabajo.getEstado().toString().equals("A")) {
//
//             this.uiSemiTerCabActivoCheck.setSelected(true);
//             detalleOrdenTrabajo.setEstado("P");
//
//            solicitudesList = new ArrayList();
//            SolicitudInternaController solicitudInternaController = new SolicitudInternaController();
//
//            EquivalenciaController equivalenciaController = new EquivalenciaController();
//            List<RecursoAsignado> recursos = recursoAsignadoMostradoList;
//            for (int i = 0; i < recursos.size(); i++) {
//                RecursoAsignado recursoAsignado = recursos.get(i);
//                Producto productoAsignado = recursoAsignado.getCodProducto();
//                BigDecimal existencia = equivalenciaController.getCantExistPorProducto(productoAsignado.getCodProducto(), null);
//                if (existencia == null) {
//                    existencia = BigDecimal.valueOf(Long.valueOf("0"));
//                }
//
//                BigDecimal cantidadRec = BigDecimal.valueOf(recursoAsignado.getCantidad());
//
//                if (cantidadRec.doubleValue() > existencia.doubleValue() ) {
//
//                    SolicitudInterna solicitud = new SolicitudInterna();
//                    solicitud.setCodProducto(productoAsignado);
//                    Long cantidadComprar = Double.valueOf(Math.ceil(cantidadRec.doubleValue() - existencia.doubleValue())).longValue();
//                    solicitud.setCantidad(cantidadComprar);
//                    solicitud.setCodEmpleado(recursoAsignado.getCodOrdenTrabDet().getCodEmpleado());
//                    solicitud.setEstado("P");
//                    solicitud.setFecha(new Date());
//                    solicitud.setObservacion(recursoAsignado.getCodOrdenTrabDet().getCodOrdenTrabajo().getDescripcion().toString());
//                    solicitudesList.add(solicitud);
//                }
//
//            }
//
//            if (solicitudesList.size() > 0) {
//                    solicitudesAGenerarse = (SolicitudInterna[]) solicitudesList.toArray(new SolicitudInterna[0]);
//                    generarSolicitudes = true;
//           }
//
//        } else if (detalleOrdenTrabajo.getEstado() != null &&
//                        detalleOrdenTrabajo.getEstado().toString().equals("P")) {
//                this.uiSemiTerCabActivoCheck.setSelected(true);
//                detalleOrdenTrabajo.setEstado("C");
//                detalleOrdenTrabajo.setFechaModif(new Date());
//                this.activarLabel.setText("CERRADO");
//        }
//
//
//
//
//    } else {
//
//
//    }
//
//

    return null;
    }


    private boolean validarActivacion(){
        boolean r = true;
        if (this.uiSemiTerCabActivoCheck.isChecked()) {
            r = false;
        }
        return r;
    }

    public CostosFijos getCostoFijoOt() {
        return costoFijoOt;
    }

    public void setCostoFijoOt(CostosFijos costoFijoOt) {
        this.costoFijoOt = costoFijoOt;
    }

    public OrdenTrabajoDetCostoH getCostoHoraOt() {
        return costoHoraOt;
    }

    public void setCostoHoraOt(OrdenTrabajoDetCostoH costoHoraOt) {
        this.costoHoraOt = costoHoraOt;
    }

    public List<CostosFijos> getCostosFijosList() {
        return costosFijosList;
    }

    public void setCostosFijosList(List<CostosFijos> costosFijosList) {
        this.costosFijosList = costosFijosList;
    }

    public List<CostosFijos> getCostosFijosMostradoList() {
        return costosFijosMostradoList;
    }

    public void setCostosFijosMostradoList(List<CostosFijos> costosFijosMostradoList) {
        this.costosFijosMostradoList = costosFijosMostradoList;
    }

    public CostosFijos[] getCostosFijosOt() {
        return costosFijosOt;
    }

    public void setCostosFijosOt(CostosFijos[] costosFijosOt) {
        this.costosFijosOt = costosFijosOt;
    }

    public List<OrdenTrabajoDetCostoH> getCostosHoraList() {
        return costosHoraList;
    }

    public void setCostosHoraList(List<OrdenTrabajoDetCostoH> costosHoraList) {
        this.costosHoraList = costosHoraList;
    }

    public List<OrdenTrabajoDetCostoH> getCostosHoraMostradoList() {
        return costosHoraMostradoList;
    }

    public void setCostosHoraMostradoList(List<OrdenTrabajoDetCostoH> costosHoraMostradoList) {
        this.costosHoraMostradoList = costosHoraMostradoList;
    }

    public OrdenTrabajoDetCostoH[] getCostosHoraOt() {
        return costosHoraOt;
    }

    public void setCostosHoraOt(OrdenTrabajoDetCostoH[] costosHoraOt) {
        this.costosHoraOt = costosHoraOt;
    }

    public List<OrdenTrabajoDetCostoMat> getCostosMatList() {
        return costosMatList;
    }

    public void setCostosMatList(List<OrdenTrabajoDetCostoMat> costosMatList) {
        this.costosMatList = costosMatList;
    }

    public List<OrdenTrabajoDetCostoMat> getCostosMatMostradoList() {
        return costosMatMostradoList;
    }

    public void setCostosMatMostradoList(List<OrdenTrabajoDetCostoMat> costosMatMostradoList) {
        this.costosMatMostradoList = costosMatMostradoList;
    }

    public OrdenTrabajoDetCostoMat[] getCostosMatOt() {
        return costosMatOt;
    }

    public void setCostosMatOt(OrdenTrabajoDetCostoMat[] costosMatOt) {
        this.costosMatOt = costosMatOt;
    }

    public boolean isEditarDetalleSemiterRecurso() {
        return editarDetalleSemiterRecurso;
    }

    public void setEditarDetalleSemiterRecurso(boolean editarDetalleSemiterRecurso) {
        this.editarDetalleSemiterRecurso = editarDetalleSemiterRecurso;
    }

    public boolean isEditarDetalleSemiterTarea() {
        return editarDetalleSemiterTarea;
    }

    public void setEditarDetalleSemiterTarea(boolean editarDetalleSemiterTarea) {
        this.editarDetalleSemiterTarea = editarDetalleSemiterTarea;
    }

    public boolean isGenerarSolicitudes() {
        return generarSolicitudes;
    }

    public void setGenerarSolicitudes(boolean generarSolicitudes) {
        this.generarSolicitudes = generarSolicitudes;
    }

    public long getIdAuxiliar() {
        return idAuxiliar;
    }

    public void setIdAuxiliar(long idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }

    public List<RecursoAsignado> getRecursoAsignadoMostradoList() {
        return recursoAsignadoMostradoList;
    }

    public void setRecursoAsignadoMostradoList(List<RecursoAsignado> recursoAsignadoMostradoList) {
        this.recursoAsignadoMostradoList = recursoAsignadoMostradoList;
    }

    public List<SolicitudInterna> getSolicitudesList() {
        return solicitudesList;
    }

    public void setSolicitudesList(List<SolicitudInterna> solicitudesList) {
        this.solicitudesList = solicitudesList;
    }

    public boolean isAddRequestOT2() {
        return addRequestOT2;
    }

    public void setAddRequestOT2(boolean addRequestOT2) {
        this.addRequestOT2 = addRequestOT2;
    }

    public boolean isUpdateRequestOT2() {
        return updateRequestOT2;
    }

    public void setUpdateRequestOT2(boolean updateRequestOT2) {
        this.updateRequestOT2 = updateRequestOT2;
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

    private String itemSolicitud;

    public String getItemSolicitud() {
        return itemSolicitud;
    }

    public void setItemSolicitud(String itemSolicitud) {
        this.itemSolicitud = itemSolicitud;
    }


    private String itemDet;

    public String getItemDet() {
        return itemDet;
    }

    public void setItemDet(String itemDet) {
        this.itemDet = itemDet;
    }
    private String itemDetGastoFijo;

    public String getItemDetGastoFijo() {
        return itemDetGastoFijo;
    }

    public void setItemDetGastoFijo(String itemDetGastoFijo) {
        this.itemDetGastoFijo = itemDetGastoFijo;
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
     this.uibuttonGuardarCostos.setRendered(false);
     this.uibuttonCalcularCostos.setRendered(false);

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
                 this.uiNroOT.setText(ordenTrabajo.getCodOrdenTrabjo().toString() );
                 this.uiNroOT.setDisabled(true);

                 this.uiResponsableCodigo.setText(ordenTrabajo.getCodEmpleado1().getCodEmpleado().toString());
                 this.uiResponsableCodigo.setDisabled(true);

                 this.uiResponsableNombre.setText(ordenTrabajo.getCodEmpleado1().getNombreEmpleado()+" "+ ordenTrabajo.getCodEmpleado1().getApellidoEmpleado());
                 this.uiResponsableNombre.setDisabled(true);

                 this.uiProducto.setSelected(ordenTrabajo.getCodProductoOt().getCodProducto().toString());
                 this.uiProducto.setDisabled(true);

                 this.uiEstado.setSelected(ordenTrabajo.getEstadoOt().toString());
                 this.uiEstado.setDisabled(true);

                 this.uiDescripcionOt.setText(ordenTrabajo.getDescripcion().toString());

                 this.uiCantidad.setText(ordenTrabajo.getCantidadOt().toString());
                 this.uiCantidad.setDisabled(true);

                 this.uiFechaIni.setSelectedDate(ordenTrabajo.getFechaOt());
                 this.uiFechaIni.setDisabled(true);

                 this.uiFechaFin.setSelectedDate(ordenTrabajo.getFechaFinOt());
                 this.uiFechaFin.setDisabled(true);

                 this.uiCantidadProducida.setText(ordenTrabajo.getCantidadProducidaOt().toString());
                 this.uiCantidadProducida.setDisabled(true);

                 this.uiCostoReal.setText(ordenTrabajo.getCostoRealOt().toString());

                 if (ordenTrabajo.getCostoRealOt().longValue() > 0) {
                        this.tableColumnVerDetalles.setRendered(true);
                 }else{
                        this.tableColumnVerDetalles.setRendered(false);
                 }
                 this.uiCostoPrevisto.setText(ordenTrabajo.getCostoEstimadoOt().toString());

                 this.uiCostoReal.setText(ordenTrabajo.getCostoRealOt().toString());
                 this.uiCostoReal.setDisabled(true);

                 this.uiEstado.setDisabled(true);

                 if (ordenTrabajo.getEstadoOt().toString().equals("T") ||ordenTrabajo.getEstadoOt().toString().equals("C")) {
                        this.tableColumnDelSemiTer.setRendered(false);
                        this.tableColumnEditSemiter.setRendered(false);
                        this.uiButtonAgregarDetalleOt.setRendered(false);
                        this.tableColumnTareasDel.setRendered(false);
                        this.tableColumTareasEdit.setRendered(false);
                        this.tableColumnRecursosEdit.setRendered(false);
                        this.tableColumnRecursosDel.setRendered(false);
                        this.uiButtonSemiTerAddDetalleRecurso.setRendered(false);
                        this.uiButtonSemiTerAddDetalleTarea.setRendered(false);
                        if (updateRequestOT) {
                            this.uibuttonGuardarEdicion.setRendered(false);
                        }
                        
                 }else{

                        this.tableColumnDelSemiTer.setRendered(true);
                        this.tableColumnEditSemiter.setRendered(true);
                        this.uiButtonAgregarDetalleOt.setRendered(true);
                        this.tableColumnTareasDel.setRendered(true);
                        this.tableColumTareasEdit.setRendered(true);
                        this.tableColumnRecursosEdit.setRendered(true);
                        this.tableColumnRecursosDel.setRendered(true);
                        this.uiButtonSemiTerAddDetalleRecurso.setRendered(true);
                        this.uiButtonSemiTerAddDetalleTarea.setRendered(true);

                 }


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


//                              ordenDeTrabajo.setNumeroOrdenTrabajo(new Long( this.uiNroOT.getText().toString()));
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
////                              ordenDeTrabajo.setEstadoOt(this.uiEstado.getSelected().toString());


                              OrdenTrabajoDetalle[] ordenTrabajoDetallesEliminados =(OrdenTrabajoDetalle[]) detalleOrdenTrabajoEliminadaList.toArray(new OrdenTrabajoDetalle[0]);
                              RecursoAsignado[] recursoAsignadosEliminados = (RecursoAsignado[]) recursoAsignadoEliminadoList.toArray(new RecursoAsignado[0]);
                              TareaAsignada[] tareaAsignadasEliminadas = (TareaAsignada[]) tareaAsignadaEliminadaList.toArray(new TareaAsignada[0]);
                             
                              controllerResult = ordenTrabajoCabeceraController.updateCabDet(ordenDeTrabajo, detallesOrdenTrabajo, ordenTrabajoDetallesEliminados, tareaAsignadasEliminadas, recursoAsignadosEliminados);

        }

        if (controllerResult.getCodRetorno() != -1) {
                addRequestOT = false;
                updateRequestOT = false;
                verDetalleSemiter = false;
                generarSolicitudes = false;
                
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

        return null;

    }

    public String uiLinkGenerarSolicitud_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        ControllerResult controllerResult = new ControllerResult();

        SolicitudInterna solicitudInternaAGenerarse = new SolicitudInterna();
        solicitudInternaAGenerarse = solicitudesList.get(Integer.valueOf(itemSolicitud).intValue());

        SolicitudInternaController solicitudInternaController = new SolicitudInternaController();
        controllerResult = solicitudInternaController.create(solicitudInternaAGenerarse);

        if (controllerResult.getCodRetorno() != -1) {
            solicitudesList.remove(Integer.valueOf(itemSolicitud).intValue());
            solicitudesAGenerarse = (SolicitudInterna[]) solicitudesList.toArray(new SolicitudInterna[0]);

        }else{

        }
        return null;
    }

    public String uiButtonSolicitudVolver_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.


        this.addRequestOT=false;
        this.updateRequestOT=false;
        this.addDetalleOt=false;
        this.errorValidacion =false;
        this.verDetalleSemiter = true;
        this.generarSolicitudes = false;
        return null;
    }

    public void uiDetSemiTerCant_processValueChange(ValueChangeEvent event) {
    }

    public String calcularCosto_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

          if (getTableRowGroup1().getSelectedRowsCount() > 0) {
                RowKey[] selectedRowKeys = getTableRowGroup1().getSelectedRowKeys();
                OrdenTrabajo[] ordenesDeTrabajoCabeceras = this.listaOrdenTrabajoCabeceras;
                int rowId = Integer.parseInt(selectedRowKeys[0].getRowId());
                OrdenTrabajo ordenTrabajo = ordenesDeTrabajoCabeceras[rowId];
                if (!ordenTrabajo.getEstadoOt().toString().equals("T")) {
                    this.pageAlert1.setType("error");
                    this.pageAlert1.setTitle("Para calcular los costos la OT debe estar Terminada");
                    this.pageAlert1.setSummary("");
                    this.pageAlert1.setDetail("");
                    this.pageAlert1.setRendered(true);
                    this.updateCostoOT = false;

                }else{
                    this.pageAlert1.setRendered(false);
                    this.uiButtonGuardarRegistro.setRendered(false);
                    this.uibuttonGuardarEdicion.setRendered(false);

                    if (ordenTrabajo.getCostoRealOt().longValue() > 0) {
                          this.uibuttonGuardarCostos.setRendered(true);
                          this.uibuttonCalcularCostos.setRendered(false);
                    }else{
                          this.uibuttonGuardarCostos.setRendered(false);
                          this.uibuttonCalcularCostos.setRendered(true);
                    }
                  
                    getSessionBean1().setTituloPagina("Ordenes de Trabajo");
                    getSessionBean1().setDetallePagina("Calculo de Costos Finales de OT");
                    this.pageAlert1.setRendered(false);
                    this.updateCostoOT=true;


                    cargarCamposUpdate();
                    limpiarDetalleOt();

                    this.updateCostoOT=true;
//                    this.tableColumnVerDetalles.setRendered(false);
                }
          }
        return null;
    }

        public boolean isUpdateCostoOT() {
        return updateCostoOT;
    }

    public void setUpdateCostoOT(boolean updateCostoOT) {
        this.updateCostoOT = updateCostoOT;
    }

    

    public String uibuttonCalcularCostos_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.uibuttonGuardarCostos.setRendered(true);
        this.uibuttonCalcularCostos.setRendered(false);
        Long costoSemiTer = Long.valueOf("0");
        Long costoTotalOt = Long.valueOf("0");

            costosFijosList = new ArrayList();
            costosFijosMostradoList = new ArrayList();

            costosHoraList = new ArrayList();
            costosFijosMostradoList = new ArrayList();

            costosMatList = new ArrayList();
            costosMatMostradoList = new ArrayList();

                   


            /// EJEMPLO DE AGREGAR A A COLLECTION
            /// detalleOrdenTrabajo.getRecursoAsignadoCollection().add(recursoAsignado);

            ///// CALCULAR UTILIZACIONES DE MATERIAS PRIMAS
            for (int i = 0; i < detallesOrdenTrabajo.length; i++) {
                OrdenTrabajoDetalle ordenTrabajoDetalle = detallesOrdenTrabajo[i];

                ordenTrabajoDetalle.setCostosFijosCollection(new HashSet());
                ordenTrabajoDetalle.setOrdenTrabajoDetCostoCollection(new HashSet());
                ordenTrabajoDetalle.setOrdenTrabajoDetMCollection(new HashSet());


                costoSemiTer = Long.valueOf("0");

                List<EntradaSalidaCantidad> entSalDetList = new ArrayList();
                entSalDetList = new EntradaSalidaDetalleController().getProductoCantidad(ordenTrabajoDetalle.getCodOrdenTrabajoDet());
//                entSalDetList = new EntradaSalidaDetalleController().getAllFiltered(null, null, null, ordenTrabajoDetalle.getCodOrdenTrabajoDet(), null);

                if (entSalDetList.size() > 0) {
                    for (int j = 0; j < entSalDetList.size(); j++) {
                        EntradaSalidaCantidad entradaSalidaCantidad = entSalDetList.get(j);
                        OrdenTrabajoDetCostoMat otDetCostoMat = new OrdenTrabajoDetCostoMat();
                        idAuxiliar ++;
                        Producto productoSal = new ProductoController().findById(entradaSalidaCantidad.getCodProducto());
                        otDetCostoMat.setCodOrdenTrabDetMat(idAuxiliar);
                        otDetCostoMat.setCodProducto(productoSal);
                        otDetCostoMat.setCodOrdenTrabajoDet(ordenTrabajoDetalle);
                        otDetCostoMat.setCantidad(entradaSalidaCantidad.getCantidad());
                        otDetCostoMat.setCostoUnitario(Long.valueOf(productoSal.getCostoActual().toString()));
                        otDetCostoMat.setCostoTotal(Long.valueOf(productoSal.getCostoActual().toString()) * entradaSalidaCantidad.getCantidad());
                        costosMatList.add(otDetCostoMat);
                        costoSemiTer = costoSemiTer + otDetCostoMat.getCostoTotal().longValue();
                        ordenTrabajoDetalle.getOrdenTrabajoDetMCollection().add(otDetCostoMat);
//                        System.out.println(otDetCostoMat.getCodProducto().getDescripcion());
//                        System.out.println("***********LIST LIST***********************");
//                        System.out.println(ordenTrabajoDetalle.getOrdenTrabajoDetMListList().size());


                    }
                }

                    ///// CALCULAR COSTOS HORAS HOMBRE
                List<TareaEmpleadoCantidad> tarEmpList = new ArrayList();
                tarEmpList = new ProduccionDiariaController().getTareaEmpleado(ordenTrabajoDetalle.getCodOrdenTrabajoDet());
                if (tarEmpList.size() > 0) {
                    for (int j = 0; j < tarEmpList.size(); j++) {
                        idAuxiliar ++;
                        TareaEmpleadoCantidad tarEmp = tarEmpList.get(j);
                        OrdenTrabajoDetCostoH otDetCostoH = new OrdenTrabajoDetCostoH();

                        Empleado empleado = new EmpleadoController().findById(tarEmp.getCodEmpleado());

                        otDetCostoH.setCodOrdenTrabDetHoras(idAuxiliar);
                        otDetCostoH.setCodEmpleado(empleado);
                        otDetCostoH.setCodOrdenTrabajoDet(ordenTrabajoDetalle);
                        
                        BigDecimal cantidadMin = BigDecimal.valueOf(tarEmp.getCantidadTiempo());
//                        BigDecimal cantHoras =cantidadMin.divide(BigDecimal.valueOf(60));
                        Double cantHorasDouble =Double.valueOf(cantidadMin.doubleValue()/60);
                        BigDecimal cantHoras = BigDecimal.valueOf(cantHorasDouble);
                        otDetCostoH.setCantidadHoras(cantHoras);

//                        BigDecimal costoHoras = BigDecimal.valueOf(1);
                        BigDecimal costoHoras = BigDecimal.valueOf(empleado.getCostoHora().longValue());
                        otDetCostoH.setCostoHora(costoHoras);


                        Double totalCostoHorasDouble = Math.ceil(cantHorasDouble.doubleValue() * costoHoras.doubleValue());
                        Long totalCostosHoras = totalCostoHorasDouble.longValue();

                        otDetCostoH.setCostoTotal(totalCostosHoras);
                        costosHoraList.add(otDetCostoH);
                        costoSemiTer = costoSemiTer + otDetCostoH.getCostoTotal().longValue();
                        ordenTrabajoDetalle.getOrdenTrabajoDetCostoCollection().add(otDetCostoH);
                    }
                }


               /////


                ///// CALCULAR COSTOS MAQUINARIAS Y COSTOS DE MANTENIMIENTO POR MAQUINARIAS
                List<MaquinariaCantidadHora> maqCantHorasList = new ArrayList();
                maqCantHorasList = new ProduccionDiariaController().getMaquinariaCantida(ordenTrabajoDetalle.getCodOrdenTrabajoDet());
                Long costoKWH = Long.valueOf("1");
                if (maqCantHorasList.size()>0) {
                    for (int j = 0; j < maqCantHorasList.size(); j++) {
                        MaquinariaCantidadHora maquinariaCantidadHora = maqCantHorasList.get(j);
                        idAuxiliar ++;
                        Maquinarias maq = new MaquinariaController().findById(Long.valueOf(maquinariaCantidadHora.getCodMaquinaria().longValue()));

                        

                        CostosFijos costoF = new CostosFijos();
                        CostosFijos costoF2 = new CostosFijos();

                        costoF.setCodCostoFijo(idAuxiliar);

                        BigDecimal cantHorasMaq = BigDecimal.valueOf(maquinariaCantidadHora.getCantidadMinutos().doubleValue() / 60);
                        Double cantHorasRedondeado = Math.ceil(cantHorasMaq.doubleValue());
                        costoF.setCantidad(BigInteger.valueOf(cantHorasRedondeado.longValue()));
                        costoF.setCostoUnitario(BigInteger.valueOf(maq.getConsumoKwh().longValue()));
                        
                        ParametroController parCont= new ParametroController();
                        costoKWH = parCont.findById(Long.valueOf("1000")).getValorNumero().longValue();
 
                        costoF.setCostoUnitario(costoF.getCostoUnitario().multiply(BigInteger.valueOf(costoKWH)));

                        costoF.setMonto(costoF.getCostoUnitario().multiply(costoF.getCantidad()));
                        costoF.setCodOrdenTrabajoDet(ordenTrabajoDetalle);

                        String costoTexto ="Luz: Utilizacion de Maquinaria ";
                        costoTexto = costoTexto + maq.getDescripcion().toString();
                        //costoTexto = costoTexto + " Minutos: "+ maquinariaCantidadHora.getCantidadMinutos().toString();
                        costoTexto = costoTexto + " Horas: "+costoF.getCantidad().toString();
                        costoTexto = costoTexto + " Consumo KW/H Maq: " + maq.getConsumoKwh().toString();
                        costoTexto = costoTexto + " Costo Hora KW/H ANDE: " + costoKWH.toString();


                        costoF.setDescripcionGasto(costoTexto);

                        idAuxiliar ++;
                        costoF2.setCodCostoFijo(idAuxiliar);

                        String costoTexto2 ="Mantenimiento de Maquinarias: costo de mantenimento de ";
                        costoTexto2 = costoTexto2 + maq.getDescripcion().toString();
                        costoTexto2 = costoTexto2 + " por utilización en Horas: "+costoF.getCantidad().toString();
                        costoF2.setDescripcionGasto(costoTexto2);

                        BigDecimal costoHoraMant = BigDecimal.valueOf(maq.getCostoMantenimiento() / maq.getHorasMantenimento());
                        Double costoHoraMantRedondeado = Math.ceil(costoHoraMant.doubleValue());
                        costoF2.setCostoUnitario(BigInteger.valueOf(costoHoraMantRedondeado.longValue()));
                        costoF2.setCantidad(costoF.getCantidad());
                        costoF2.setMonto(costoF2.getCostoUnitario().multiply(costoF2.getCantidad()));

                        costosFijosList.add(costoF);
                        costosFijosList.add(costoF2);
                        costoSemiTer = costoSemiTer + costoF.getMonto().longValue();
                        costoSemiTer = costoSemiTer + costoF2.getMonto().longValue();

                        ordenTrabajoDetalle.getCostosFijosCollection().add(costoF);
                        ordenTrabajoDetalle.getCostosFijosCollection().add(costoF2);

                        System.out.println("************************");
                        System.out.println(maquinariaCantidadHora.getCodMaquinaria().toString());
                        System.out.println(maquinariaCantidadHora.getCantidadMinutos().toString());

                    }
                }


             ordenTrabajoDetalle.setCostoReal(costoSemiTer);
             costoTotalOt = costoTotalOt + ordenTrabajoDetalle.getCostoReal();
            
            }
                                        //
                                        //            for (int i = 0; i < costosMatList.size(); i++) {
                                        //                        OrdenTrabajoDetCostoMat costosMat = costosMatList.get(i);
                                        //                          System.out.println("******************Costos Mat********************************");
                                        //                          System.out.println(costosMat.getCodProducto().getCodProducto().toString());
                                        //                          System.out.println(costosMat.getCodProducto().getDescripcion().toString());
                                        //                          System.out.println(costosMat.getCodOrdenTrabajoDet().toString());
                                        //                          System.out.println(costosMat.getCantidad().toString());
                                        //                          System.out.println(costosMat.getCostoUnitario().toString());
                                        //                          System.out.println(costosMat.getCostoTotal().toString());
                                        //            }
                                        //
                                        //
                                        //            for (int i = 0; i < costosHoraList.size(); i++) {
                                        //                        OrdenTrabajoDetCostoH costosH = costosHoraList.get(i);
                                        //                          System.out.println("****************Costos Horas**********************************");
                                        //                          System.out.println(costosH.getCodEmpleado().getCodEmpleado().toString());
                                        //                          System.out.println(costosH.getCodEmpleado().getNombreEmpleado().toString());
                                        //                          System.out.println(costosH.getCodOrdenTrabajoDet().getCodOrdenTrabajoDet().toString());
                                        //                          System.out.println(costosH.getCantidadHoras().toString());
                                        //                          System.out.println(costosH.getCostoHora().toString());
                                        //                          System.out.println(costosH.getCostoTotal().toString());
                                        //            }
            ///// FIN CALCULAR UTILIZACIONES DE MATERIAS PRIMAS/////////////////////////////////////////////////////////////////////////



            ////// FIN CALCULAR UTILIZACIONES DE MATERIAS PRIMAS ///////////////////////////////////////////////////////////////////////////

          this.tableColumnVerDetalles.setRendered(true);
          this.uiCostoReal.setText(costoTotalOt);
          return null;
    }

    public String uiButtonVolverCostos_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.addRequestOT=false;
        this.updateRequestOT=false;
        this.updateCostoOT=true;
        this.addDetalleOt=false;
        this.errorValidacion =false;
        this.verDetalleSemiter = false;
        this.verDetalleCosto = false;



        return null;
    }

    public String tab5_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String uiDetCostoEditarCostoHombre() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
       
          OrdenTrabajoDetCostoH costoHombre = new OrdenTrabajoDetCostoH();
          costoHombre = costosHoraMostradoList.get(Integer.valueOf(itemDet).intValue());
 
          this.uiDetCostoHombreEmpleado.setText(costoHombre.getCodEmpleado().getApellidoEmpleado().toString()+" "+costoHombre.getCodEmpleado().getNombreEmpleado().toString());
          this.uiDetCostoHombreCosto.setText(costoHombre.getCostoHora().toString());

        return null;
    }

    public String uiDetCostoEditarGastoFijo() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.


        updateGastoFijo = true;
        CostosFijos costoFijo = new CostosFijos();
        costoFijo = costosFijosMostradoList.get(Integer.valueOf(itemDetGastoFijo).intValue());

        this.uiDetCostoFijoDescripcion.setText(costoFijo.getDescripcionGasto().toString());
        this.uiDetCostoFijoCantidad.setText(costoFijo.getCantidad().toString());
        this.uiDetCostoFijoCostoUnit.setText(costoFijo.getCostoUnitario().toString());
        this.uiDetCostoFijoMonto.setText(costoFijo.getMonto().toString());

        return null;
    }

      public String uiButtonInsertarGasto_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        if (!updateGastoFijo) {

                        errorValidacion = false;
                        CostosFijos costo = new CostosFijos();
                        if (this.uiDetCostoFijoDescripcion.getText() != null &&
                                !this.uiDetCostoFijoDescripcion.getText().toString().equals("")   ){

                            costo.setDescripcionGasto(this.uiDetCostoFijoDescripcion.getText().toString());
                        }else{

                            errorValidacion = true;
                        }

                        if (this.uiDetCostoFijoCantidad.getText() != null &&
                                !this.uiDetCostoFijoCantidad.getText().toString().equals("")
                                    && StringUtils.esNumero(this.uiDetCostoFijoCantidad.getText().toString())) {

                            costo.setCantidad(BigInteger.valueOf(Long.valueOf(this.uiDetCostoFijoCantidad.getText().toString())));
                        }else{
                            errorValidacion = true;

                        }
                        if (this.uiDetCostoFijoCostoUnit.getText() != null &&
                                !this.uiDetCostoFijoCostoUnit.getText().toString().equals("")
                                    && StringUtils.esNumero(this.uiDetCostoFijoCostoUnit.getText().toString())) {

                            costo.setCostoUnitario(BigInteger.valueOf(Long.valueOf(this.uiDetCostoFijoCostoUnit.getText().toString())));
                        }else{
                            errorValidacion = true;

                        }

                        if (!errorValidacion) {
                                    idAuxiliar++;
                                    costo.setCodCostoFijo(idAuxiliar);
                                    costo.setMonto(costo.getCostoUnitario().multiply(costo.getCantidad()));
                                    costosFijosMostradoList.add(costo);

                                    // ACTUALIZAR EL COSTO DE LA SUB OT
                                    Long costoActual = detalleOrdenTrabajo.getCostoReal();
                                    detalleOrdenTrabajo.setCostoReal(costoActual + costo.getMonto().longValue());
                                    this.uiSemiTerCabCostoTotal.setText(detalleOrdenTrabajo.getCostoReal().toString());
                                    /////////
                                    //ACTUALIZAR EL COSTO TOTAL DE LA OT
                                    Long costoRealAnterior = Long.valueOf(this.uiCostoReal.getText().toString());
                                    Long costoRealNuevo = costoRealAnterior +  costo.getMonto().longValue();
                                    this.uiCostoReal.setText(costoRealNuevo.toString());
                                    //////////
                                    detalleOrdenTrabajo.setCostosFijosCollectionFromList(costosFijosMostradoList);
                                    costosFijosOt = (CostosFijos[])  costosFijosMostradoList.toArray(new CostosFijos[0]);

                                    this.uiDetCostoFijoDescripcion.setText("");
                                    this.uiDetCostoFijoMonto.setText("");


                        }else{
                            info("Verifique los datos del Gasto Fijo");
                        }
       }else{
                        updateGastoFijo = false;
                        CostosFijos costo = new CostosFijos();
                        costo = costosFijosMostradoList.get(Integer.valueOf(itemDetGastoFijo).intValue());

                        if (this.uiDetCostoFijoDescripcion.getText() != null &&
                                !this.uiDetCostoFijoDescripcion.getText().toString().equals("")   ){

                            costo.setDescripcionGasto(this.uiDetCostoFijoDescripcion.getText().toString());
                        }else{

                            errorValidacion = true;
                        }

                        if (this.uiDetCostoFijoCantidad.getText() != null &&
                                !this.uiDetCostoFijoCantidad.getText().toString().equals("")
                                    && StringUtils.esNumero(this.uiDetCostoFijoCantidad.getText().toString())) {

                            costo.setCantidad(BigInteger.valueOf(Long.valueOf(this.uiDetCostoFijoCantidad.getText().toString())));
                        }else{
                            errorValidacion = true;

                        }
                        if (this.uiDetCostoFijoCostoUnit.getText() != null &&
                                !this.uiDetCostoFijoCostoUnit.getText().toString().equals("")
                                    && StringUtils.esNumero(this.uiDetCostoFijoCostoUnit.getText().toString())) {

                            costo.setCostoUnitario(BigInteger.valueOf(Long.valueOf(this.uiDetCostoFijoCostoUnit.getText().toString())));
                        }else{
                            errorValidacion = true;
                        }

                            long montoAnterior = costo.getMonto().longValue();
                            long nuevoMonto = (costo.getCostoUnitario().multiply(costo.getCantidad()).longValue());
                            costo.setMonto(BigInteger.valueOf(nuevoMonto));

                                    Long costoActual = detalleOrdenTrabajo.getCostoReal();
                                    if (nuevoMonto > montoAnterior) {
                                        long diferencia = nuevoMonto - montoAnterior;

                                    // ACTUALIZAR EL COSTO DE LA SUB OT
                                    detalleOrdenTrabajo.setCostoReal(costoActual + diferencia);
                                    this.uiSemiTerCabCostoTotal.setText(detalleOrdenTrabajo.getCostoReal().toString());
                                    /////////
                                    //ACTUALIZAR EL COSTO TOTAL DE LA OT
                                    Long costoRealAnterior = Long.valueOf(this.uiCostoReal.getText().toString());
                                    Long costoRealNuevo = costoRealAnterior +  diferencia;
                                    this.uiCostoReal.setText(costoRealNuevo.toString());
                                    //////////

                                    }else if(montoAnterior > nuevoMonto ){
                                        long diferencia = montoAnterior - nuevoMonto;

                                    // ACTUALIZAR EL COSTO DE LA SUB OT
                                    detalleOrdenTrabajo.setCostoReal(costoActual - diferencia);
                                    this.uiSemiTerCabCostoTotal.setText(detalleOrdenTrabajo.getCostoReal().toString());
                                    /////////
                                    //ACTUALIZAR EL COSTO TOTAL DE LA OT
                                    Long costoRealAnterior = Long.valueOf(this.uiCostoReal.getText().toString());
                                    Long costoRealNuevo = costoRealAnterior -  diferencia;
                                    this.uiCostoReal.setText(costoRealNuevo.toString());
                                    //////////


                                    }
                                    detalleOrdenTrabajo.setCostosFijosCollectionFromList(costosFijosMostradoList);
                                    costosFijosOt = (CostosFijos[])  costosFijosMostradoList.toArray(new CostosFijos[0]);

                                    this.uiDetCostoFijoDescripcion.setText("");
                                    this.uiDetCostoFijoMonto.setText("");

       }
        return null;
    }



    public String uiButtonActualizarCostoHombre_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
          OrdenTrabajoDetCostoH costoHombre = new OrdenTrabajoDetCostoH();
          costoHombre = costosHoraMostradoList.get(Integer.valueOf(itemDet).intValue());
          Long costoTotalAnterior = costoHombre.getCostoTotal();
          if (this.uiDetCostoHombreCosto.getText() != null &&
                   StringUtils.esNumero(this.uiDetCostoHombreCosto.getText().toString())) {
                   BigDecimal costoHoraBig = BigDecimal.valueOf(Long.valueOf(uiDetCostoHombreCosto.getText().toString()));
                   costoHombre.setCostoHora(costoHoraBig);
                   Double totalCostoHorasDouble = Math.ceil(costoHombre.getCantidadHoras().doubleValue() * costoHoraBig.doubleValue());
                   costoHombre.setCostoTotal(totalCostoHorasDouble.longValue());

                   // ACTUALIZAR EL COSTO DE LA SUB OT
                    Long costoActual = detalleOrdenTrabajo.getCostoReal();
                    detalleOrdenTrabajo.setCostoReal((costoActual + costoHombre.getCostoTotal())-costoTotalAnterior);
                    this.uiSemiTerCabCostoTotal.setText(detalleOrdenTrabajo.getCostoReal().toString());

                    //ACTUALIZAR EL COSTO TOTAL DE LA OT
                        Long costoRealAnterior = Long.valueOf(this.uiCostoReal.getText().toString());
                        Long costoRealNuevo = costoRealAnterior +  costoHombre.getCostoTotal() - costoTotalAnterior;
                        this.uiCostoReal.setText(costoRealNuevo.toString()); 
                    //////////

                   this.uiDetCostoHombreCosto.setText("");
                   this.uiDetCostoHombreEmpleado.setText("");
          }

        return null;
    }

  

public String uibuttonGuardarCostos_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        errorValidacion = false;
        updateCostoOT = true;
        validarCamposCostos();
        ControllerResult controllerResult = new ControllerResult();

        OrdenTrabajoCabeceraController ordenTrabajoCabeceraController = new OrdenTrabajoCabeceraController();


         if (! errorValidacion){
                            OrdenTrabajo ordenDeTrabajo = new OrdenTrabajo();
                            ordenDeTrabajo = ordenTrabajoCabeceraController.findById(idEditado);

                            ordenDeTrabajo.setCostoRealOt(BigInteger.valueOf(Long.valueOf(this.uiCostoReal.getText().toString())));

                            controllerResult = ordenTrabajoCabeceraController.updateCostosFinales(ordenDeTrabajo, detallesOrdenTrabajo);

        }

        if (controllerResult.getCodRetorno() != -1) {
                addRequestOT = false;
                updateRequestOT = false;
                updateCostoOT = false;
                verDetalleSemiter = false;
                generarSolicitudes = false;

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

        return null;
    }


 private boolean validarCamposCostos(){
        //Variables
        boolean r;

        //Inicializar
        r = false;


        if (this.uiCostoReal.getText() == null ||
                   Long.valueOf(this.uiCostoReal.getText().toString()) <= 0)
            {   r = true;
        this.info(uiCantidad, "El costo no se ha calculado correctamente");
            }

        return r;
    }

    public String uiButtonTodosFiltro_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.uiNumOtFil.setText("");
        this.uiFechaDesdeFil.setSelectedDate(null);
        this.uiFechaHastaFil.setSelectedDate(null);
        this.uiTodosFil.setSelected(true);
        this.uiEstadoFil.setSelected("X");

        return null;
    }

    public String imageHyperlink2_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }


}

