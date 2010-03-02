/*
 * popupcliente.java
 *
 * Created on Jul 23, 2008, 12:49:06 PM
 */
package platinum.popup;

import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.PanelGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Script;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import javax.faces.FacesException;
import org.codehaus.stax2.io.EscapingWriterFactory;
import platinum.ApplicationBean1;
import platinum.RequestBean1;
import platinum.SessionBean1;
import py.com.platinum.controller.PedidoCabeceraController;
import py.com.platinum.entity.PedidoCabecera;
import py.com.platinum.utilsenum.PedidoVentaEstado;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author Martin Jara
 */
public class popupPedidoVenta extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private Script script1 = new Script();

    public Script getScript1() {
        return script1;
    }

    public void setScript1(Script s) {
        this.script1 = s;
    }
    private TextField uiTxtParam = new TextField();

    public TextField getUiTxtParam() {
        return uiTxtParam;
    }

    public void setUiTxtParam(TextField tf) {
        this.uiTxtParam = tf;
    }
    private Button uiBtnBuscar = new Button();

    public Button getUiBtnBuscar() {
        return uiBtnBuscar;
    }

    public void setUiBtnBuscar(Button b) {
        this.uiBtnBuscar = b;
    }
    private Button uiBtnTodos = new Button();

    public Button getUiBtnTodos() {
        return uiBtnTodos;
    }

    public void setUiBtnTodos(Button b) {
        this.uiBtnTodos = b;
    }
    private PanelGroup groupPanel1 = new PanelGroup();

    public PanelGroup getGroupPanel1() {
        return groupPanel1;
    }

    public void setGroupPanel1(PanelGroup pg) {
        this.groupPanel1 = pg;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public popupPedidoVenta() {
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
            log("Popup Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
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

    public String uiBtnBuscar_action() {
        //Variables
        String param = null;

        //controlamos el parametro
        if (uiTxtParam.getText() != null) {
            param = uiTxtParam.getText().toString();
        }

        //Obetenmos la lista
        PedidoCabecera[] l = (PedidoCabecera[]) new PedidoCabeceraController().getPedidoCabecera(param, PedidoVentaEstado.PENDIENTE).toArray(new PedidoCabecera[0]);

        //Actualizamos la lista de la session
        getSessionBean1().setListaPedidoVenta(l);

        //refrescamos la pagina
        return null;
    }

    public String uiBtnTodos_action() {
        //Obetenmos la lista
        PedidoCabecera[] l = (PedidoCabecera[]) new PedidoCabeceraController().getPedidoCabecera(null, PedidoVentaEstado.PENDIENTE).toArray(new PedidoCabecera[0]);

        //actializamos la lista en la session
        getSessionBean1().setListaPedidoVenta(l);

        //refrecamos la pagina
        return null;
    }
}

