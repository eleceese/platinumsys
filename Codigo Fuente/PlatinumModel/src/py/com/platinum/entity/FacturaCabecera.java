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
@Table(name = "FACTURA_CABECERA")
@NamedQueries({@NamedQuery(name = "FacturaCabecera.findAll", query = "SELECT f FROM FacturaCabecera f"), @NamedQuery(name = "FacturaCabecera.findByCodFactura", query = "SELECT f FROM FacturaCabecera f WHERE f.codFactura = :codFactura"), @NamedQuery(name = "FacturaCabecera.findByNumeroFactura", query = "SELECT f FROM FacturaCabecera f WHERE f.numeroFactura = :numeroFactura"), @NamedQuery(name = "FacturaCabecera.findByTipoFactura", query = "SELECT f FROM FacturaCabecera f WHERE f.tipoFactura = :tipoFactura"), @NamedQuery(name = "FacturaCabecera.findByFechaFactura", query = "SELECT f FROM FacturaCabecera f WHERE f.fechaFactura = :fechaFactura"), @NamedQuery(name = "FacturaCabecera.findByHoraFactura", query = "SELECT f FROM FacturaCabecera f WHERE f.horaFactura = :horaFactura"), @NamedQuery(name = "FacturaCabecera.findBySubtotalFactura", query = "SELECT f FROM FacturaCabecera f WHERE f.subtotalFactura = :subtotalFactura"), @NamedQuery(name = "FacturaCabecera.findByTotalIvaFactura", query = "SELECT f FROM FacturaCabecera f WHERE f.totalIvaFactura = :totalIvaFactura"), @NamedQuery(name = "FacturaCabecera.findByTotalFactura", query = "SELECT f FROM FacturaCabecera f WHERE f.totalFactura = :totalFactura"), @NamedQuery(name = "FacturaCabecera.findByEstadoFactura", query = "SELECT f FROM FacturaCabecera f WHERE f.estadoFactura = :estadoFactura"), @NamedQuery(name = "FacturaCabecera.findByUsuarioAlta", query = "SELECT f FROM FacturaCabecera f WHERE f.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "FacturaCabecera.findByUsuarioModif", query = "SELECT f FROM FacturaCabecera f WHERE f.usuarioModif = :usuarioModif"), @NamedQuery(name = "FacturaCabecera.findByFechaAlta", query = "SELECT f FROM FacturaCabecera f WHERE f.fechaAlta = :fechaAlta"), @NamedQuery(name = "FacturaCabecera.findByFechaModif", query = "SELECT f FROM FacturaCabecera f WHERE f.fechaModif = :fechaModif")})
public class FacturaCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_FACTURA")
    private BigDecimal codFactura;
    @Basic(optional = false)
    @Column(name = "NUMERO_FACTURA")
    private BigInteger numeroFactura;
    @Basic(optional = false)
    @Column(name = "TIPO_FACTURA")
    private String tipoFactura;
    @Basic(optional = false)
    @Column(name = "FECHA_FACTURA")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    @Basic(optional = false)
    @Column(name = "HORA_FACTURA")
    @Temporal(TemporalType.DATE)
    private Date horaFactura;
    @Column(name = "SUBTOTAL_FACTURA")
    private BigInteger subtotalFactura;
    @Column(name = "TOTAL_IVA_FACTURA")
    private BigInteger totalIvaFactura;
    @Column(name = "TOTAL_FACTURA")
    private BigInteger totalFactura;
    @Column(name = "ESTADO_FACTURA")
    private String estadoFactura;
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
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEmpleado;
    @JoinColumn(name = "COD_PEDIDO", referencedColumnName = "COD_PEDIDO")
    @ManyToOne
    private PedidoCabecera codPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFactura")
    private List<NotaCreditoCliCabecera> notaCreditoCliCabeceraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFactura")
    private List<ReciboDetalle> reciboDetalleCollection;
    @OneToMany(mappedBy = "codFactura")
    private List<FacturaDetalle> facturaDetalleCollection;

    public FacturaCabecera() {
    }

    public FacturaCabecera(BigDecimal codFactura) {
        this.codFactura = codFactura;
    }

    public FacturaCabecera(BigDecimal codFactura, BigInteger numeroFactura, String tipoFactura, Date fechaFactura, Date horaFactura) {
        this.codFactura = codFactura;
        this.numeroFactura = numeroFactura;
        this.tipoFactura = tipoFactura;
        this.fechaFactura = fechaFactura;
        this.horaFactura = horaFactura;
    }

    public BigDecimal getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(BigDecimal codFactura) {
        this.codFactura = codFactura;
    }

    public BigInteger getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(BigInteger numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Date getHoraFactura() {
        return horaFactura;
    }

    public void setHoraFactura(Date horaFactura) {
        this.horaFactura = horaFactura;
    }

    public BigInteger getSubtotalFactura() {
        return subtotalFactura;
    }

    public void setSubtotalFactura(BigInteger subtotalFactura) {
        this.subtotalFactura = subtotalFactura;
    }

    public BigInteger getTotalIvaFactura() {
        return totalIvaFactura;
    }

    public void setTotalIvaFactura(BigInteger totalIvaFactura) {
        this.totalIvaFactura = totalIvaFactura;
    }

    public BigInteger getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(BigInteger totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
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

    public PedidoCabecera getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(PedidoCabecera codPedido) {
        this.codPedido = codPedido;
    }

    public List<NotaCreditoCliCabecera> getNotaCreditoCliCabeceraCollection() {
        return notaCreditoCliCabeceraCollection;
    }

    public void setNotaCreditoCliCabeceraCollection(List<NotaCreditoCliCabecera> notaCreditoCliCabeceraCollection) {
        this.notaCreditoCliCabeceraCollection = notaCreditoCliCabeceraCollection;
    }

    public List<ReciboDetalle> getReciboDetalleCollection() {
        return reciboDetalleCollection;
    }

    public void setReciboDetalleCollection(List<ReciboDetalle> reciboDetalleCollection) {
        this.reciboDetalleCollection = reciboDetalleCollection;
    }

    public List<FacturaDetalle> getFacturaDetalleCollection() {
        return facturaDetalleCollection;
    }

    public void setFacturaDetalleCollection(List<FacturaDetalle> facturaDetalleCollection) {
        this.facturaDetalleCollection = facturaDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFactura != null ? codFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCabecera)) {
            return false;
        }
        FacturaCabecera other = (FacturaCabecera) object;
        if ((this.codFactura == null && other.codFactura != null) || (this.codFactura != null && !this.codFactura.equals(other.codFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.FacturaCabecera[codFactura=" + codFactura + "]";
    }

}
