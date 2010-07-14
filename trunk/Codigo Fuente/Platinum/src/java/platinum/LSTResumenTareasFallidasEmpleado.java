/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package platinum;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.sql.Connection;
import java.sql.SQLException;
import javax.faces.FacesException;
import javax.servlet.ServletContext;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.OrdenTrabajoCabeceraController;
import py.com.platinum.controller.TareaController;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.Tarea;
import py.com.platinum.utils.DateUtils;
import reportes.Formated;
import reportes.GetConnection;
import reportes.RptCreate;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version LSTResumenTareasEmpleado.java
 * @version Created on Jun 13, 2010, 10:26:29 AM
 * @author FerBoy
 */

public class LSTResumenTareasFallidasEmpleado extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DropDown uiNroOt = new DropDown();

    public DropDown getUiNroOt() {
        return uiNroOt;
    }

    public void setUiNroOt(DropDown dd) {
        this.uiNroOt = dd;
    }
    private DropDown uiEmpleado = new DropDown();

    public DropDown getUiEmpleado() {
        return uiEmpleado;
    }

    public void setUiEmpleado(DropDown dd) {
        this.uiEmpleado = dd;
    }
    private DropDown uiTarea = new DropDown();

    public DropDown getUiTarea() {
        return uiTarea;
    }

    public void setUiTarea(DropDown dd) {
        this.uiTarea = dd;
    }
    private Calendar uiFechaHasta = new Calendar();

    public Calendar getUiFechaHasta() {
        return uiFechaHasta;
    }

    public void setUiFechaHasta(Calendar c) {
        this.uiFechaHasta = c;
    }
    private Calendar uiFechaDesde = new Calendar();

    public Calendar getUiFechaDesde() {
        return uiFechaDesde;
    }

    public void setUiFechaDesde(Calendar c) {
        this.uiFechaDesde = c;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LSTResumenTareasFallidasEmpleado() {
    cargarListaTodosEmpleados();
    cargarListaTodosOTCab();
    cargarListaTodosTareas();
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
            log("LSTResumenTareasEmpleado Initialization Failure", e);
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
    @Override
    public void prerender() {
        getSessionBean1().setTituloPagina("Resumen de Tareas Fallidas por Empleado");
        getSessionBean1().setDetallePagina("Se ingresa los parámetros para generar el informe de tareas.");

        this.uiNroOt.setSelected("-1");
        this.uiEmpleado.setSelected("-1");
        this.uiTarea.setSelected("-1");


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
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
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
    
 //////  CARGA DE COMBO BOX DE ORDENES DE TRABAJO

    OrdenTrabajo[] listaOtCab;
    Option[] listaOtCabOp;

    public OrdenTrabajo[] getListaOtCab() {
        return listaOtCab;
    }

    public void setListaOtCab(OrdenTrabajo[] listaOtCab) {
        this.listaOtCab = listaOtCab;
    }

    public Option[] getListaOtCabOp() {
        return listaOtCabOp;
    }

    public void setListaOtCabOp(Option[] listaOtCabOp) {
        this.listaOtCabOp = listaOtCabOp;
    }

        public void cargarListaTodosOTCab() {
        OrdenTrabajoCabeceraController c = new OrdenTrabajoCabeceraController();
        listaOtCab = (OrdenTrabajo[]) c.getAllFiltered(null,null, null, null).toArray(new OrdenTrabajo[0]);
        listaOtCabOp = new Option[listaOtCab.length+1];
        Option option;
        for (int i = 0; i < listaOtCab.length; i++) {
            OrdenTrabajo p = listaOtCab[i];
            option = new Option();
            option.setLabel(p.getCodOrdenTrabjo().toString()+" "+p.getCodProductoOt().getDescripcion().toString()+" x "+p.getCantidadOt().toString());
            option.setValue(p.getCodOrdenTrabjo().toString());
            listaOtCabOp[i] = option;
        }
        option = new Option();
        option.setLabel("Todos...");
        option.setValue("-1");
        listaOtCabOp[listaOtCab.length] = option;
}

    Empleado[] listaEmpleados;
    Option[] listaEmpleadosOp;

    public Option[] getListaEmpleadosOp() {
        return listaEmpleadosOp;
    }

    public void setListaEmpleadosOp(Option[] listaEmpleadosOp) {
        this.listaEmpleadosOp = listaEmpleadosOp;
    }


    public Empleado[] getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(Empleado[] listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void cargarListaTodosEmpleados() {
        EmpleadoController EmpleadoController = new EmpleadoController();
        listaEmpleados = (Empleado[]) EmpleadoController.getAll("apellidoEmpleado").toArray(new Empleado[0]);

        listaEmpleadosOp = new Option[listaEmpleados.length+1];
        Option option;
        for (int i = 0; i < listaEmpleados.length; i++) {
            Empleado em = listaEmpleados[i];
            option = new Option();
            option.setLabel(em.getNombreEmpleado()+" "+em.getApellidoEmpleado());
            option.setValue(em.getCodEmpleado().toString());
            listaEmpleadosOp[i] = option;
        }
        option = new Option();
        option.setLabel("Todos...");
        option.setValue("-1");
        listaEmpleadosOp[listaEmpleados.length] = option;

    }

    Tarea[] listaTareas;
    Option[] listaTareasOp;

    public Option[] getListaTareasOp() {
        return listaTareasOp;
    }

    public void setListaTareasOp(Option[] listaTareasOp) {
        this.listaTareasOp = listaTareasOp;
    }

    public Tarea[] getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(Tarea[] listaTareas) {
        this.listaTareas = listaTareas;
    }

    public void cargarListaTodosTareas() {
        TareaController tareaController = new TareaController();
        listaTareas = (Tarea[]) tareaController.getAll("nombreTarea").toArray(new Tarea[0]);
        listaTareasOp = new Option[listaTareas.length+1];
        Option option;
        for (int i = 0; i < listaTareas.length; i++) {
            Tarea tp = listaTareas[i];
            option = new Option();
            option.setLabel(tp.getNombreTarea());
            option.setValue(tp.getCodTarea().toString());
            listaTareasOp[i] = option;
        }
         option = new Option();
        option.setLabel("Todos...");
        option.setValue("-1");
        listaTareasOp[listaTareas.length] = option;

    }

    public String uiButtonEjecutar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

                String[] sparamName= new String[7];
                String[] sparamValue= new String[7];
                Connection conn= GetConnection.getSimpleConnection();
                ServletContext theApplicationsServletContext = (ServletContext) this.getExternalContext().getContext();


                String sOt="";
                String sO="";

                String sEmpleado="";
                String sE="";

                String sTarea="";
                String sT="";

                String sFecha="";
                String sF="";

                String sFechaF="";
                String sFF="";

                String sSql="";

                Formated f= new Formated();
                f.setDatePattern("yyyy/dd/MM");

                try{

               

                if (!uiEmpleado.getSelected().toString().equals("-1")){
                    sEmpleado = " and e.cod_empleado = "+uiEmpleado.getSelected().toString();
                    sE = new EmpleadoController().findById(Long.valueOf(this.uiEmpleado.getSelected().toString())).getApellidoEmpleado().toString();
                }else{
                    sE="Todos";
                }

                if (!uiTarea.getSelected().toString().equals("-1")){
                    sTarea = " and t.cod_tarea = "+uiTarea.getSelected().toString();
                    sT = new TareaController().findById(Long.valueOf(this.uiTarea.getSelected().toString())).getNombreTarea();
                }else{
                    sT="Todos";
                }

                if (uiFechaDesde.getSelectedDate() != null){

                    String simpleFecha = DateUtils.toString(uiFechaDesde.getSelectedDate(), "dd/MM/yyyy");
                    sFecha = " and tf.fecha >= to_date('"+simpleFecha+"','dd/mm/yyyy')";
                    sF = simpleFecha;
                }else{
                    sF="Todos";
                }

                if (uiFechaHasta.getSelectedDate() != null){
                    String simpleFechaF = DateUtils.toString(uiFechaHasta.getSelectedDate(), "dd/MM/yyyy");
                    sFechaF = " and tf.fecha <= to_date('"+simpleFechaF+"','dd/mm/yyyy')";
                    sFF = simpleFechaF;
                }else{
                    sFF="Todos";
                }

//                if (calFecHasta.getValue()!=null)
//                sFecHasta = " and TARJETAS.FECHA_ALTA <= convert(datetime,'"+f.getDateFormat((Date)calFecHasta.getValue())+"') ";

                sSql = sEmpleado+sOt+sTarea+sFecha+sFechaF;

                RptCreate rpt= new RptCreate();

                sparamName[0]="parametros";
                sparamValue[0]= sSql;
                sparamName[1]="codOt";
                sparamValue[1]= sO;
                sparamName[2]="codEmpleado";
                sparamValue[2]= sE;
                sparamName[3]="tarea";
                sparamValue[3]= sT;
                sparamName[4]="fechaIni";
                sparamValue[4]= sF;
                sparamName[5]="fechaFin";
                sparamValue[5]= sFF;
                sparamName[6] = "logo_path";
                sparamValue[6] = theApplicationsServletContext.getRealPath("/WEB-INF/classes/reportesFuente/logo_platinum.jpg");


                rpt.getReport(conn, "ResumenTareasFallidas.jrxml", sparamName, sparamValue, theApplicationsServletContext);

                }catch(Exception e){
                error("Error al generar el reporte ");
                error(" " + e);
                }finally{
                try{
                if(conn != null && !conn.isClosed())
                conn.close();
                }catch(SQLException sqle){
                error("Error al intentar cerrar la conexion"+ sqle);
                }
                }

        return null;
    }


}

