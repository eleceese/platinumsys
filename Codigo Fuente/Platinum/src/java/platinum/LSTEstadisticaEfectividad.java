/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package platinum;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.RadioButtonGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.sql.Connection;
import java.sql.SQLException;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletContext;
import py.com.platinum.controller.EmpleadoController;
import py.com.platinum.controller.OrdenTrabajoCabeceraController;
import py.com.platinum.controller.TareaController;
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.Tarea;
import py.com.platinum.utils.DateUtils;
import py.com.platinum.utils.StringUtils;
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

public class LSTEstadisticaEfectividad extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        uiRadioAnalisisDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("G", "General"), new com.sun.webui.jsf.model.Option("E", "Empleado"), new com.sun.webui.jsf.model.Option("T", "Tarea")});
        uiRadioAnalisisDefaultOptions.setSelectedValue("G");
    }
    private DropDown uiEmpleado = new DropDown();

    public DropDown getUiEmpleado() {
        return uiEmpleado;
    }

    public void setUiEmpleado(DropDown dd) {
        this.uiEmpleado = dd;
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
    private SingleSelectOptionsList uiRadioAnalisisDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getUiRadioAnalisisDefaultOptions() {
        return uiRadioAnalisisDefaultOptions;
    }

    public void setUiRadioAnalisisDefaultOptions(SingleSelectOptionsList ssol) {
        this.uiRadioAnalisisDefaultOptions = ssol;
    }
    private RadioButtonGroup uiRadioAnalisis = new RadioButtonGroup();

    public RadioButtonGroup getUiRadioAnalisis() {
        return uiRadioAnalisis;
    }

    public void setUiRadioAnalisis(RadioButtonGroup rbg) {
        this.uiRadioAnalisis = rbg;
    }
    private TextField uiAnio = new TextField();

    public TextField getUiAnio() {
        return uiAnio;
    }

    public void setUiAnio(TextField tf) {
        this.uiAnio = tf;
    }
    private Checkbox uiCheckAnual = new Checkbox();

    public Checkbox getUiCheckAnual() {
        return uiCheckAnual;
    }

    public void setUiCheckAnual(Checkbox c) {
        this.uiCheckAnual = c;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LSTEstadisticaEfectividad() {
    cargarListaTodosEmpleados();
    cargarListaTodosOTCab();
    cargarListaTodosTareas();

            getSessionBean1().setTituloPagina("Analisis de Efectividad y Tiempos Utiles");
        getSessionBean1().setDetallePagina("Dtpto. de Produccion.");


//        this.uiEmpleado.setSelected("-1");
//        this.uiFechaDesde.setSelectedDate(null);
//        this.uiFechaHasta.setSelectedDate(null);
//        this.uiRadioAnalisis.setSelected(false);
//        this.uiAnio.setDisabled(true);
//        this.uiFechaDesde.setDisabled(false);
//        this.uiFechaHasta.setDisabled(false);






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

                String[] sparamName= new String[6];
                String[] sparamValue= new String[6];
                Connection conn= GetConnection.getSimpleConnection();
                ServletContext theApplicationsServletContext = (ServletContext) this.getExternalContext().getContext();


                String sEmpleado="";
                String sE="";

                String sFecha="";
                String sF="";

                String sFechaF="";
                String sFF="";

                String sAno="";
                String sAF="";

                String sSql="";

                Formated f= new Formated();
                f.setDatePattern("yyyy/dd/MM");

                try{

               
                if (!uiEmpleado.getSelected().toString().equals("-1")){
                    sEmpleado = " and te.cod_empleado = "+uiEmpleado.getSelected().toString();
                    sE = new EmpleadoController().findById(Long.valueOf(this.uiEmpleado.getSelected().toString())).getApellidoEmpleado().toString();
                }else{
                    sE="Todos";
                }

                            
                    if (this.uiCheckAnual.isChecked()) {
                        if (this.uiAnio.getText() == null
                                ||this.uiAnio.getText().toString().equals("")||
                                !StringUtils.esNumero(this.uiAnio.getText().toString())) {
                            info("Favor ingrese correctamente el ano");
                        }else if(Long.valueOf(this.uiAnio.getText().toString()).longValue() < 2000){
                            info("Favor ingrese correctamente el ano");
                        }else{
                            String ano = this.uiAnio.getText().toString();
                            sAno = " and to_char(tt.fecha,'YYYY') = '"+ano;
                            sAF = ano;

                       }
                    }else{


                                  if (uiFechaDesde.getSelectedDate() != null){

                                    String simpleFecha = DateUtils.toString(uiFechaDesde.getSelectedDate(), "dd/MM/yyyy");
                                    sFecha = " and te.fecha >= to_date('"+simpleFecha+"','dd/mm/yyyy')";
                                    sF = simpleFecha;
                                }else{
                                    sF="Todos";
                                }

                                if (uiFechaHasta.getSelectedDate() != null){
                                    String simpleFechaF = DateUtils.toString(uiFechaHasta.getSelectedDate(), "dd/MM/yyyy");
                                    sFechaF = " and te.fecha <= to_date('"+simpleFechaF+"','dd/mm/yyyy')";
                                    sFF = simpleFechaF;
                                }else{
                                    sFF="Todos";
                                }

                                if (uiRadioAnalisis.getSelected().toString().equals("E")) {


                                }else if(uiRadioAnalisis.getSelected().toString().equals("T")){


                                }else if(uiRadioAnalisis.getSelected().toString().equals("G")){


                                }
                    }
                sSql = sEmpleado+sFecha+sFechaF+sAno;

                RptCreate rpt= new RptCreate();


                sparamName[0]="parametros";
                sparamValue[0]= sSql;
                sparamName[1]="codEmpleado";
                sparamValue[1]= sE;
                sparamName[2]="fechaIni";
                sparamValue[2]= sF;
                sparamName[3]="fechaFin";
                sparamValue[3]= sFF;
                sparamName[4]="ano";
                sparamValue[4]= sAF;
                sparamName[5] = "logo_path";
                sparamValue[5] = theApplicationsServletContext.getRealPath("/WEB-INF/classes/reportesFuente/logo_platinum.jpg");

                    if (this.uiCheckAnual.isChecked()) {
                            rpt.getReport(conn, "EfectividadEstadisticaAnual.jrxml", sparamName, sparamValue, theApplicationsServletContext);

                    }

//                rpt.getReport(conn, "EfectividadTareas.jrxml", sparamName, sparamValue, theApplicationsServletContext);

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

    public void uiRadioAnalisis_processValueChange(ValueChangeEvent vce) {
    }

    public void uiCheckAnual_validate(FacesContext context, UIComponent component, Object value) {
        String b = value.toString();


        if (Boolean.valueOf(value.toString())) {
            
            this.uiAnio.setDisabled(false);
            this.uiFechaDesde.setDisabled(true);
            this.uiFechaHasta.setDisabled(true);
            this.uiRadioAnalisis.setDisabled(true);
            
        }else{
            this.uiAnio.setDisabled(true);
            this.uiFechaDesde.setDisabled(false);
            this.uiFechaHasta.setDisabled(false);
            this.uiRadioAnalisis.setDisabled(false);

        }




    }

    public void uiCheckAnual_processValueChange(ValueChangeEvent event) {
    }


}

