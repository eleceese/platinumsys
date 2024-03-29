/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package platinum;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import java.sql.Connection;
import java.sql.SQLException;
import javax.faces.FacesException;
import javax.servlet.ServletContext;
import py.com.platinum.utils.DateUtils;
import reportes.GetConnection;
import reportes.RptCreate;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Reporte.java
 * @version Created on 07-sep-2009, 16:17:38
 * @author MartinJara
 */

public class LSTEstadisticaDeVenta extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private Calendar uiCalDesde = new Calendar();

    public Calendar getUiCalDesde() {
        return uiCalDesde;
    }

    public void setUiCalDesde(Calendar c) {
        this.uiCalDesde = c;
    }
    private Calendar uiCalHasta = new Calendar();

    public Calendar getUiCalHasta() {
        return uiCalHasta;
    }

    public void setUiCalHasta(Calendar c) {
        this.uiCalHasta = c;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LSTEstadisticaDeVenta() {
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
            log("Reporte Initialization Failure", e);
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
        getSessionBean1().setTituloPagina("Listado de Estadística de Venta");
        getSessionBean1().setDetallePagina("Generar resumen de cantidades vendidas por Producto, por estado de pedido, por marca, por vendedor y en un rango de fecha desde – Hasta");
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
    protected Menu getMenu() {
        return (Menu) getBean("Menu");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public String button1_action() {
        //Variables
        Connection conn = GetConnection.getSimpleConnection();
        ServletContext theApplicationsServletContext = (ServletContext) this.getExternalContext().getContext();

        //Array de Variables
        String[] sparamName = new String[4];
        String[] sparamValue = new String[4];

        //Parametros
        String fechaDesde, fechaHasta, sql = "";

        if (uiCalDesde.getSelectedDate() != null) {
            fechaDesde = DateUtils.toString(uiCalDesde.getSelectedDate(), "dd/MM/yyyy");
            sql = " and c.fecha_factura >= to_date('" + fechaDesde + "','dd/mm/yyyy')";
        } else {
            fechaDesde = "TODOS";
        }

        if (uiCalHasta.getSelectedDate() != null) {
            fechaHasta = DateUtils.toString(uiCalHasta.getSelectedDate(), "dd/MM/yyyy");
            sql = sql + " and c.fecha_factura <= to_date('" + fechaHasta + "','dd/mm/yyyy')";
        } else {
            fechaHasta = "TODOS";
        }

        RptCreate rpt = new RptCreate();

        sparamName[0] = "parametros";
        sparamValue[0] = sql;
        sparamName[1] = "fechaDesde";
        sparamValue[1] = fechaDesde;
        sparamName[2] = "fechaHasta";
        sparamValue[2] = fechaHasta;
        sparamName[3] = "logo_path";
        sparamValue[3] = theApplicationsServletContext.getRealPath("/WEB-INF/classes/reportesFuente/logo_platinum.jpg");

        try {
            rpt.getReport(conn, "EstadisticaVenta.jrxml", sparamName, sparamValue, theApplicationsServletContext);

        } catch (Exception e) {
            error("Error al generar el reporte ");
            error(" " + e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException sqle) {
                error("Error al intentar cerrar la conexion" + sqle);
            }
        }
        return null;
    }

    public String button2_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }
    
}

