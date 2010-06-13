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
import py.com.platinum.controller.OrdenTrabajoCabeceraController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.entity.OrdenTrabajo;
import py.com.platinum.entity.Producto;
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
 * @version LSTOrdenesDeTrabajoRecursos.java
 * @version Created on Jun 13, 2010, 2:49:39 PM
 * @author FerBoy
 */

public class LSTOrdenesDeTrabajoRecursos extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        uiEstadoDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[]{new com.sun.webui.jsf.model.Option("-1", "Todos"), new com.sun.webui.jsf.model.Option("A", "Abierto"), new com.sun.webui.jsf.model.Option("P", "En proceso"), new com.sun.webui.jsf.model.Option("T", "Termnado"), new com.sun.webui.jsf.model.Option("C", "Cerrado")});
        uiEstadoDefaultOptions.setSelectedValue("-1");
    }
    private DropDown uiNroOt = new DropDown();

    public DropDown getUiNroOt() {
        return uiNroOt;
    }

    public void setUiNroOt(DropDown dd) {
        this.uiNroOt = dd;
    }
    private DropDown uiProducto = new DropDown();

    public DropDown getUiProducto() {
        return uiProducto;
    }

    public void setUiProducto(DropDown dd) {
        this.uiProducto = dd;
    }
    private Calendar uiFechaDesde = new Calendar();

    public Calendar getUiFechaDesde() {
        return uiFechaDesde;
    }

    public void setUiFechaDesde(Calendar c) {
        this.uiFechaDesde = c;
    }
    private Calendar uiFechaHasta = new Calendar();

    public Calendar getUiFechaHasta() {
        return uiFechaHasta;
    }

    public void setUiFechaHasta(Calendar c) {
        this.uiFechaHasta = c;
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

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LSTOrdenesDeTrabajoRecursos() {
    cargarListaTodosOTCab();
    cargarListaTodosProductos();

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
            log("LSTOrdenesDeTrabajoRecursos Initialization Failure", e);
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
        getSessionBean1().setTituloPagina("Detalle de Ordenes de Trabajo - Recursos");
        getSessionBean1().setDetallePagina("Se ingresa los parámetros para generar el informe.");

        this.uiNroOt.setSelected("-1");
        this.uiEstado.setSelected("-1");
        this.uiProducto.setSelected("-1");

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

    public String uiButtonEjecutar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
 String[] sparamName= new String[5];
                String[] sparamValue= new String[5];
                Connection conn= GetConnection.getSimpleConnection();
                ServletContext theApplicationsServletContext = (ServletContext) this.getExternalContext().getContext();

                String sProd="";
                String sP="";

                String sCodOt="";
                String sC="";

                String sEstado="";
                String sE="";

                String sSql="";
                Formated f= new Formated();
                f.setDatePattern("yyyy/dd/MM");

                try{


                if (!uiProducto.getSelected().toString().equals("-1")){
                    sProd = " and ot.cod_Producto_ot = "+uiProducto.getSelected().toString();
                    sP = new ProductoController().findById(Long.valueOf(this.uiProducto.getSelected().toString())).getDescripcion();
                }else{
                    sP="Todos";
                }

                if (!uiNroOt.getSelected().toString().equals("-1")){
                    sCodOt = " and ot.Cod_Orden_Trabjo = "+uiNroOt.getSelected().toString();
                    sC = new OrdenTrabajoCabeceraController().findById(Long.valueOf(this.uiNroOt.getSelected().toString())).getDescripcion().toString();
                }else{
                    sC="Todos";
                }

                if (!uiEstado.getSelected().toString().equals("-1")){
                    sEstado = " and ot.estado_ot = "+"'"+uiEstado.getSelected().toString()+"'";
                    sE = uiEstado.getSelected().toString();
                }else{
                    sE="Todos";
                }

//                if (calFecHasta.getValue()!=null)
//                sFecHasta = " and TARJETAS.FECHA_ALTA <= convert(datetime,'"+f.getDateFormat((Date)calFecHasta.getValue())+"') ";

                sSql = sProd+sCodOt+sEstado;

                RptCreate rpt= new RptCreate();

                sparamName[0]="parametros";
                sparamValue[0]= sSql;
                sparamName[1]="codProd";
                sparamValue[1]= sP;
                sparamName[2]="codOt";
                sparamValue[2]= sC;
                sparamName[3]="estado";
                sparamValue[3]= sE;

                rpt.getReport(conn, "OrdenesDeTrabajoRecursos.jrxml", sparamName, sparamValue, theApplicationsServletContext);

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

 ////// CARGA DE COMBO BOX PRODUCTOS
    Producto[] listaProductos;
    Option[] listaProductosOp;

    public Option[] getListaProductosOp() {
        return listaProductosOp;
    }

    public void setListaProductosOp(Option[] listaProductosOp) {
        this.listaProductosOp = listaProductosOp;
    }

    public Producto[] getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(Producto[] listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void cargarListaTodosProductos() {
        ProductoController productoController = new ProductoController();
        listaProductos = (Producto[]) productoController.getInsumosMateriasFinalesSemiter(null, null, null).toArray(new Producto[0]);
        listaProductosOp = new Option[listaProductos.length+1];
        Option option;
        for (int i = 0; i < listaProductos.length; i++) {
            Producto p = listaProductos[i];
            option = new Option();
            option.setLabel(p.getDescripcion()+" "+p.getCodMarca().getNombre().toString());
            option.setValue(p.getCodProducto().toString());
            listaProductosOp[i] = option;
        }


        option = new Option();
        option.setLabel("Todos...");
        option.setValue("-1");
        listaProductosOp[listaProductos.length] = option;
    }


}

