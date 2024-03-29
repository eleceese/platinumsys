/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package platinum;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.sql.Connection;
import java.sql.SQLException;
import javax.faces.FacesException;
import javax.servlet.ServletContext;
import py.com.platinum.controller.DepositoController;
import py.com.platinum.controller.MarcaController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.controller.TipoProductoController;
import py.com.platinum.entity.Deposito;
import py.com.platinum.entity.Marca;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.TipoProducto;
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
 * @version Reporte.java
 * @version Created on 07-sep-2009, 16:17:38
 * @author MartinJara
 */

public class LSTValoresEnDeposito extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DropDown uiProducto1 = new DropDown();

    public DropDown getUiProducto1() {
        return uiProducto1;
    }

    public void setUiProducto1(DropDown dd) {
        this.uiProducto1 = dd;
    }
    private DropDown uiDeposito1 = new DropDown();

    public DropDown getUiDeposito1() {
        return uiDeposito1;
    }

    public void setUiDeposito1(DropDown dd) {
        this.uiDeposito1 = dd;
    }
    private DropDown uiMarca1 = new DropDown();

    public DropDown getUiMarca1() {
        return uiMarca1;
    }

    public void setUiMarca1(DropDown dd) {
        this.uiMarca1 = dd;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LSTValoresEnDeposito() {
    
    cargarListaTodosDepositos();
    cargarListaTodosMarcas(); 
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
        getSessionBean1().setTituloPagina("Listado Valores en Deposito");
        getSessionBean1().setDetallePagina("");
        this.uiDeposito1.setSelected("-1");
        this.uiMarca1.setSelected("-1");
        this.uiProducto1.setSelected("-1");
        
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
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
                String[] sparamName= new String[5];
                String[] sparamValue= new String[5];
                Connection conn= GetConnection.getSimpleConnection();
                ServletContext theApplicationsServletContext = (ServletContext) this.getExternalContext().getContext();
                
                String sProducto="";
                String sP="";

                String sMarca="";
                String sM="";

                String sDeposito="";
                String sD="";

                String sSql="";
                Formated f= new Formated();
                f.setDatePattern("yyyy/dd/MM");

                Producto p;

                try{

                if (!uiProducto1.getSelected().toString().equals("-1")){
                    sProducto = " and p.cod_Producto = "+uiProducto1.getSelected().toString();
                    sP = new ProductoController().findById(Long.valueOf(this.uiProducto1.getSelected().toString())).getDescripcion();
                }else{
                    sP="Todos";
                }

                if (!uiDeposito1.getSelected().toString().equals("-1")){
                    sDeposito = " and d.cod_deposito = "+uiDeposito1.getSelected().toString();
                    sD = new DepositoController().findById(Long.valueOf(this.uiDeposito1.getSelected().toString())).getNombre();
                }else{
                    sD="Todos";
                }

                if (!uiMarca1.getSelected().toString().equals("-1")){
                    sMarca = " and p.cod_marca = "+uiMarca1.getSelected().toString();
                    sM = new MarcaController().findById(Long.valueOf(this.uiMarca1.getSelected().toString())).getNombre();
                }else{
                    sM="Todos";
                }

//                if (calFecHasta.getValue()!=null)
//                sFecHasta = " and TARJETAS.FECHA_ALTA <= convert(datetime,'"+f.getDateFormat((Date)calFecHasta.getValue())+"') ";

                sSql = sProducto+sMarca+sDeposito;

                RptCreate rpt= new RptCreate();

                sparamName[0]="parametros";
                sparamValue[0]= sSql;
                sparamName[1]="producto";
                sparamValue[1]= sP;
                sparamName[2]="deposito";
                sparamValue[2]= sD;
                sparamName[3]="marca";
                sparamValue[3]= sM;
                sparamName[4] = "logo_path";
                sparamValue[4] = theApplicationsServletContext.getRealPath("/WEB-INF/classes/reportesFuente/logo_platinum.jpg");

                
                rpt.getReport(conn, "ValoresDeposito.jrxml", sparamName, sparamValue, theApplicationsServletContext);

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

    public String button2_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }
  //// CARGA DE COMBO BOX PRODUCTOS
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
        listaProductos = (Producto[]) productoController.getAllFiltered(null,null, null, null).toArray(new Producto[0]);
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
////// CARGA DE COMBO BOX MARCAS
//////     import com.sun.webui.jsf.model.Option;
    Marca[] listaMarcas;
    Option[] listaMarcasOp;

    public Option[] getListaMarcasOp() {
        return listaMarcasOp;
    }

    public void setListaMarcasOp(Option[] listaMarcasOp) {
        this.listaMarcasOp = listaMarcasOp;
    }

    public Marca[] getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(Marca[] listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public void cargarListaTodosMarcas() {
        MarcaController MarcaController = new MarcaController();
        listaMarcas = (Marca[]) MarcaController.getAll("nombre").toArray(new Marca[0]);
        listaMarcasOp = new Option[listaMarcas.length+1];
        Option option;
        for (int i = 0; i < listaMarcas.length; i++) {
            Marca m = listaMarcas[i];
            option = new Option();
            option.setLabel(m.getNombre());
            option.setValue(m.getCodMarca().toString());
            listaMarcasOp[i] = option;
        }
          option = new Option();
            option.setLabel("Todos");
            option.setValue("-1");
            listaMarcasOp[listaMarcas.length] = option;

    }
////// FIN CARGA DE COMBO BOX MARCAS


////// CARGA DE COMBO BOX TipoProductoS
//////     import com.sun.webui.jsf.model.Option;
    TipoProducto[] listaTipoProductos;
    Option[] listaTipoProductosOp;

    public Option[] getListaTipoProductosOp() {
        return listaTipoProductosOp;
    }

    public void setListaTipoProductosOp(Option[] listaTipoProductosOp) {
        this.listaTipoProductosOp = listaTipoProductosOp;
    }

    public TipoProducto[] getListaTipoProductos() {
        return listaTipoProductos;
    }

    public void setListaTipoProductos(TipoProducto[] listaTipoProductos) {
        this.listaTipoProductos = listaTipoProductos;
    }

    public void cargarListaTodosTipoProductos() {
        TipoProductoController TipoProductoController = new TipoProductoController();
        listaTipoProductos = (TipoProducto[]) TipoProductoController.getAll("descripcion").toArray(new TipoProducto[0]);
        listaTipoProductosOp = new Option[listaTipoProductos.length+1];
        Option option;
        for (int i = 0; i < listaTipoProductos.length; i++) {
            TipoProducto tp = listaTipoProductos[i];
            option = new Option();
            option.setLabel(tp.getDescripcion());
            option.setValue(tp.getCodTipoProducto().toString());
            listaTipoProductosOp[i] = option;
        }

            option = new Option();
            option.setLabel("Todos");
            option.setValue("-1");
            listaTipoProductosOp[listaTipoProductos.length] = option;

    }
////// FIN CARGA DE COMBO BOX TipoProductoS

////// CARGA DE COMBO BOX Depositos
//////     import com.sun.webui.jsf.model.Option;
    Deposito[] listaDepositos;
    Option[] listaDepositosOp;

    public Option[] getListaDepositosOp() {
        return listaDepositosOp;
    }

    public void setListaDepositosOp(Option[] listaDepositosOp) {
        this.listaDepositosOp = listaDepositosOp;
    }

    public Deposito[] getListaDepositos() {
        return listaDepositos;
    }

    public void setListaDepositos(Deposito[] listaDepositos) {
        this.listaDepositos = listaDepositos;
    }

    public void cargarListaTodosDepositos() {
        DepositoController depositoController = new DepositoController();
        listaDepositos = (Deposito[]) depositoController.getAll("nombre").toArray(new Deposito[0]);
        listaDepositosOp = new Option[listaDepositos.length+1];
        Option option;
        int i;
        for (i = 0; i < listaDepositos.length; i++) {
            Deposito tp = listaDepositos[i];
            option = new Option();
            option.setLabel(tp.getNombre());
            option.setValue(tp.getCodDeposito().toString());
            listaDepositosOp[i] = option;
        }
            option = new Option();
            option.setLabel("Todos");
            option.setValue("-1");
            listaDepositosOp[listaDepositos.length] = option;

    }
////// FIN CARGA DE COMBO BOX
}

