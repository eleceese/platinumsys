/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "FACTURA_COMPRA_CAB")
@SequenceGenerator(name="FAC_COMP_CAB_SEQUENCE", sequenceName="SQ_FACTURA_COMPRA_CAB", initialValue=1, allocationSize=1)
public class FacturaCompraCab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FAC_COMP_CAB_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_FAC_COM_CAB")
    private Long codFacComCab;
    @Basic(optional = false)
    @Column(name = "NRO_FACTURA")
    private String nroFactura;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "SUB_TOTAL")
    private long subTotal;
    @Basic(optional = false)
    @Column(name = "TOTA_IVA")
    private long totaIva;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private long total;
    @Column(name = "USUARIO_ALTA")
    private String usuarioAlta;
    @Column(name = "USUARIO_MODIF")
    private String usuarioModif;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "FECHA_MODIF")
    @Temporal(TemporalType.DATE)
    private Date fechaModif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFacComCab")
    private List<FacturaCompraDet> facturaCompraDetCollection;
    @JoinColumn(name = "COD_ENT_SAL", referencedColumnName = "COD_ENTRADA_SALIDA")
    @ManyToOne
    private EntradaSalidaCabecera codEntSal;
    @JoinColumn(name = "COD_PROVEEDOR", referencedColumnName = "COD_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor codProveedor;
    @JoinColumn(name = "NRO_SOLICITUD", referencedColumnName = "COD_SOLICITUD")
    @ManyToOne
    private SolicitudInterna nroSolicitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFacturaCab")
    private List<NotaCreditoProvCab> notaCreditoProvCabCollection;

    public FacturaCompraCab() {
    }

    public FacturaCompraCab(Long codFacComCab) {
        this.codFacComCab = codFacComCab;
    }

    public FacturaCompraCab(Long codFacComCab, String nroFactura, Date fecha, String estado, long subTotal, long totaIva, long total) {
        this.codFacComCab = codFacComCab;
        this.nroFactura = nroFactura;
        this.fecha = fecha;
        this.estado = estado;
        this.subTotal = subTotal;
        this.totaIva = totaIva;
        this.total = total;
    }

    public Long getCodFacComCab() {
        return codFacComCab;
    }

    public void setCodFacComCab(Long codFacComCab) {
        this.codFacComCab = codFacComCab;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }

    public long getTotaIva() {
        return totaIva;
    }

    public void setTotaIva(long totaIva) {
        this.totaIva = totaIva;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public String getUsuarioModif() {
        return usuarioModif;
    }

    public void setUsuarioModif(String usuarioModif) {
        this.usuarioModif = usuarioModif;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModif() {
        return fechaModif;
    }

    public void setFechaModif(Date fechaModif) {
        this.fechaModif = fechaModif;
    }

    public List<FacturaCompraDet> getFacturaCompraDetCollection() {
        return facturaCompraDetCollection;
    }

    public void setFacturaCompraDetCollection(List<FacturaCompraDet> facturaCompraDetCollection) {
        this.facturaCompraDetCollection = facturaCompraDetCollection;
    }

    public EntradaSalidaCabecera getCodEntSal() {
        return codEntSal;
    }

    public void setCodEntSal(EntradaSalidaCabecera codEntSal) {
        this.codEntSal = codEntSal;
    }

    public Proveedor getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Proveedor codProveedor) {
        this.codProveedor = codProveedor;
    }

    public SolicitudInterna getNroSolicitud() {
        return nroSolicitud;
    }

    public void setNroSolicitud(SolicitudInterna nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
    }

    public List<NotaCreditoProvCab> getNotaCreditoProvCabCollection() {
        return notaCreditoProvCabCollection;
    }

    public void setNotaCreditoProvCabCollection(List<NotaCreditoProvCab> notaCreditoProvCabCollection) {
        this.notaCreditoProvCabCollection = notaCreditoProvCabCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFacComCab != null ? codFacComCab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCompraCab)) {
            return false;
        }
        FacturaCompraCab other = (FacturaCompraCab) object;
        if ((this.codFacComCab == null && other.codFacComCab != null) || (this.codFacComCab != null && !this.codFacComCab.equals(other.codFacComCab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nroFactura;
    }

}
