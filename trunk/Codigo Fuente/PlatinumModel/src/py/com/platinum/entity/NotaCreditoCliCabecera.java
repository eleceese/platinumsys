/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "NOTA_CREDITO_CLI_CABECERA")
@NamedQueries({@NamedQuery(name = "NotaCreditoCliCabecera.findAll", query = "SELECT n FROM NotaCreditoCliCabecera n"), @NamedQuery(name = "NotaCreditoCliCabecera.findByCodNotaCreditoCliente", query = "SELECT n FROM NotaCreditoCliCabecera n WHERE n.codNotaCreditoCliente = :codNotaCreditoCliente"), @NamedQuery(name = "NotaCreditoCliCabecera.findByNumNotaCredtoCliente", query = "SELECT n FROM NotaCreditoCliCabecera n WHERE n.numNotaCredtoCliente = :numNotaCredtoCliente"), @NamedQuery(name = "NotaCreditoCliCabecera.findByTotalNotaCredito", query = "SELECT n FROM NotaCreditoCliCabecera n WHERE n.totalNotaCredito = :totalNotaCredito"), @NamedQuery(name = "NotaCreditoCliCabecera.findByFechaNotaCredito", query = "SELECT n FROM NotaCreditoCliCabecera n WHERE n.fechaNotaCredito = :fechaNotaCredito"), @NamedQuery(name = "NotaCreditoCliCabecera.findByTotalIva", query = "SELECT n FROM NotaCreditoCliCabecera n WHERE n.totalIva = :totalIva"), @NamedQuery(name = "NotaCreditoCliCabecera.findByUsuarioAlta", query = "SELECT n FROM NotaCreditoCliCabecera n WHERE n.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "NotaCreditoCliCabecera.findByUsuarioModif", query = "SELECT n FROM NotaCreditoCliCabecera n WHERE n.usuarioModif = :usuarioModif"), @NamedQuery(name = "NotaCreditoCliCabecera.findByFechaAlta", query = "SELECT n FROM NotaCreditoCliCabecera n WHERE n.fechaAlta = :fechaAlta"), @NamedQuery(name = "NotaCreditoCliCabecera.findByFechaModif", query = "SELECT n FROM NotaCreditoCliCabecera n WHERE n.fechaModif = :fechaModif")})
public class NotaCreditoCliCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_NOTA_CREDITO_CLIENTE")
    private BigDecimal codNotaCreditoCliente;
    @Basic(optional = false)
    @Column(name = "NUM_NOTA_CREDTO_CLIENTE")
    private BigInteger numNotaCredtoCliente;
    @Column(name = "TOTAL_NOTA_CREDITO")
    private BigInteger totalNotaCredito;
    @Basic(optional = false)
    @Column(name = "FECHA_NOTA_CREDITO")
    @Temporal(TemporalType.DATE)
    private Date fechaNotaCredito;
    @Column(name = "TOTAL_IVA")
    private BigInteger totalIva;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codNotaCreditoCliente")
    private List<NotaCreditoCliDetalle> notaCreditoCliDetalleCollection;
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEmpleado;
    @JoinColumn(name = "COD_FACTURA", referencedColumnName = "COD_FACTURA")
    @ManyToOne(optional = false)
    private FacturaCabecera codFactura;
    @OneToMany(mappedBy = "codNotaCreditoCliente")
    private List<ReciboDetalle> reciboDetalleCollection;

    public NotaCreditoCliCabecera() {
    }

    public NotaCreditoCliCabecera(BigDecimal codNotaCreditoCliente) {
        this.codNotaCreditoCliente = codNotaCreditoCliente;
    }

    public NotaCreditoCliCabecera(BigDecimal codNotaCreditoCliente, BigInteger numNotaCredtoCliente, Date fechaNotaCredito) {
        this.codNotaCreditoCliente = codNotaCreditoCliente;
        this.numNotaCredtoCliente = numNotaCredtoCliente;
        this.fechaNotaCredito = fechaNotaCredito;
    }

    public BigDecimal getCodNotaCreditoCliente() {
        return codNotaCreditoCliente;
    }

    public void setCodNotaCreditoCliente(BigDecimal codNotaCreditoCliente) {
        this.codNotaCreditoCliente = codNotaCreditoCliente;
    }

    public BigInteger getNumNotaCredtoCliente() {
        return numNotaCredtoCliente;
    }

    public void setNumNotaCredtoCliente(BigInteger numNotaCredtoCliente) {
        this.numNotaCredtoCliente = numNotaCredtoCliente;
    }

    public BigInteger getTotalNotaCredito() {
        return totalNotaCredito;
    }

    public void setTotalNotaCredito(BigInteger totalNotaCredito) {
        this.totalNotaCredito = totalNotaCredito;
    }

    public Date getFechaNotaCredito() {
        return fechaNotaCredito;
    }

    public void setFechaNotaCredito(Date fechaNotaCredito) {
        this.fechaNotaCredito = fechaNotaCredito;
    }

    public BigInteger getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(BigInteger totalIva) {
        this.totalIva = totalIva;
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

    public List<NotaCreditoCliDetalle> getNotaCreditoCliDetalleCollection() {
        return notaCreditoCliDetalleCollection;
    }

    public void setNotaCreditoCliDetalleCollection(List<NotaCreditoCliDetalle> notaCreditoCliDetalleCollection) {
        this.notaCreditoCliDetalleCollection = notaCreditoCliDetalleCollection;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public FacturaCabecera getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(FacturaCabecera codFactura) {
        this.codFactura = codFactura;
    }

    public List<ReciboDetalle> getReciboDetalleCollection() {
        return reciboDetalleCollection;
    }

    public void setReciboDetalleCollection(List<ReciboDetalle> reciboDetalleCollection) {
        this.reciboDetalleCollection = reciboDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNotaCreditoCliente != null ? codNotaCreditoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCreditoCliCabecera)) {
            return false;
        }
        NotaCreditoCliCabecera other = (NotaCreditoCliCabecera) object;
        if ((this.codNotaCreditoCliente == null && other.codNotaCreditoCliente != null) || (this.codNotaCreditoCliente != null && !this.codNotaCreditoCliente.equals(other.codNotaCreditoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.NotaCreditoCliCabecera[codNotaCreditoCliente=" + codNotaCreditoCliente + "]";
    }

}
