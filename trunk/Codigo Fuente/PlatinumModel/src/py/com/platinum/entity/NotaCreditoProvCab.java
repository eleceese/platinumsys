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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "NOTA_CREDITO_PROV_CAB")
@NamedQueries({@NamedQuery(name = "NotaCreditoProvCab.findAll", query = "SELECT n FROM NotaCreditoProvCab n"), @NamedQuery(name = "NotaCreditoProvCab.findByCodNotCreCab", query = "SELECT n FROM NotaCreditoProvCab n WHERE n.codNotCreCab = :codNotCreCab"), @NamedQuery(name = "NotaCreditoProvCab.findByFecha", query = "SELECT n FROM NotaCreditoProvCab n WHERE n.fecha = :fecha"), @NamedQuery(name = "NotaCreditoProvCab.findByNroNotaCredito", query = "SELECT n FROM NotaCreditoProvCab n WHERE n.nroNotaCredito = :nroNotaCredito"), @NamedQuery(name = "NotaCreditoProvCab.findByEstado", query = "SELECT n FROM NotaCreditoProvCab n WHERE n.estado = :estado"), @NamedQuery(name = "NotaCreditoProvCab.findByTotal", query = "SELECT n FROM NotaCreditoProvCab n WHERE n.total = :total"), @NamedQuery(name = "NotaCreditoProvCab.findByIva", query = "SELECT n FROM NotaCreditoProvCab n WHERE n.iva = :iva"), @NamedQuery(name = "NotaCreditoProvCab.findBySaldoFac", query = "SELECT n FROM NotaCreditoProvCab n WHERE n.saldoFac = :saldoFac"), @NamedQuery(name = "NotaCreditoProvCab.findByUsuarioAlta", query = "SELECT n FROM NotaCreditoProvCab n WHERE n.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "NotaCreditoProvCab.findByUsuarioModif", query = "SELECT n FROM NotaCreditoProvCab n WHERE n.usuarioModif = :usuarioModif"), @NamedQuery(name = "NotaCreditoProvCab.findByFechaAlta", query = "SELECT n FROM NotaCreditoProvCab n WHERE n.fechaAlta = :fechaAlta"), @NamedQuery(name = "NotaCreditoProvCab.findByFechaModif", query = "SELECT n FROM NotaCreditoProvCab n WHERE n.fechaModif = :fechaModif")})
public class NotaCreditoProvCab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_NOT_CRE_CAB")
    private Long codNotCreCab;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "NRO_NOTA_CREDITO")
    private String nroNotaCredito;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private long total;
    @Basic(optional = false)
    @Column(name = "IVA")
    private long iva;
    @Basic(optional = false)
    @Column(name = "SALDO_FAC")
    private long saldoFac;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codNotCreCab")
    private List<NotaCreditoProvDet> notaCreditoProvDetCollection;
    @JoinColumn(name = "COD_FACTURA_CAB", referencedColumnName = "COD_FAC_COM_CAB")
    @ManyToOne(optional = false)
    private FacturaCompraCab codFacturaCab;
    @JoinColumn(name = "COD_PROVEEDOR", referencedColumnName = "COD_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor codProveedor;

    public NotaCreditoProvCab() {
    }

    public NotaCreditoProvCab(Long codNotCreCab) {
        this.codNotCreCab = codNotCreCab;
    }

    public NotaCreditoProvCab(Long codNotCreCab, Date fecha, String nroNotaCredito, String estado, long total, long iva, long saldoFac) {
        this.codNotCreCab = codNotCreCab;
        this.fecha = fecha;
        this.nroNotaCredito = nroNotaCredito;
        this.estado = estado;
        this.total = total;
        this.iva = iva;
        this.saldoFac = saldoFac;
    }

    public Long getCodNotCreCab() {
        return codNotCreCab;
    }

    public void setCodNotCreCab(Long codNotCreCab) {
        this.codNotCreCab = codNotCreCab;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNroNotaCredito() {
        return nroNotaCredito;
    }

    public void setNroNotaCredito(String nroNotaCredito) {
        this.nroNotaCredito = nroNotaCredito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getIva() {
        return iva;
    }

    public void setIva(long iva) {
        this.iva = iva;
    }

    public long getSaldoFac() {
        return saldoFac;
    }

    public void setSaldoFac(long saldoFac) {
        this.saldoFac = saldoFac;
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

    public List<NotaCreditoProvDet> getNotaCreditoProvDetCollection() {
        return notaCreditoProvDetCollection;
    }

    public void setNotaCreditoProvDetCollection(List<NotaCreditoProvDet> notaCreditoProvDetCollection) {
        this.notaCreditoProvDetCollection = notaCreditoProvDetCollection;
    }

    public FacturaCompraCab getCodFacturaCab() {
        return codFacturaCab;
    }

    public void setCodFacturaCab(FacturaCompraCab codFacturaCab) {
        this.codFacturaCab = codFacturaCab;
    }

    public Proveedor getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Proveedor codProveedor) {
        this.codProveedor = codProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNotCreCab != null ? codNotCreCab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCreditoProvCab)) {
            return false;
        }
        NotaCreditoProvCab other = (NotaCreditoProvCab) object;
        if ((this.codNotCreCab == null && other.codNotCreCab != null) || (this.codNotCreCab != null && !this.codNotCreCab.equals(other.codNotCreCab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.NotaCreditoProvCab[codNotCreCab=" + codNotCreCab + "]";
    }

}
