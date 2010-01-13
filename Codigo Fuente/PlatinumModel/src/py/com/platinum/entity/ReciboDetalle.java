/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "RECIBO_DETALLE")
@NamedQueries({@NamedQuery(name = "ReciboDetalle.findAll", query = "SELECT r FROM ReciboDetalle r"), @NamedQuery(name = "ReciboDetalle.findByCodReciboDet", query = "SELECT r FROM ReciboDetalle r WHERE r.codReciboDet = :codReciboDet"), @NamedQuery(name = "ReciboDetalle.findByMontoEfectivo", query = "SELECT r FROM ReciboDetalle r WHERE r.montoEfectivo = :montoEfectivo"), @NamedQuery(name = "ReciboDetalle.findByMontoNotaCredito", query = "SELECT r FROM ReciboDetalle r WHERE r.montoNotaCredito = :montoNotaCredito"), @NamedQuery(name = "ReciboDetalle.findByMontoTotal", query = "SELECT r FROM ReciboDetalle r WHERE r.montoTotal = :montoTotal"), @NamedQuery(name = "ReciboDetalle.findByEstadoDetalleRecibo", query = "SELECT r FROM ReciboDetalle r WHERE r.estadoDetalleRecibo = :estadoDetalleRecibo"), @NamedQuery(name = "ReciboDetalle.findByUsuarioAlta", query = "SELECT r FROM ReciboDetalle r WHERE r.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "ReciboDetalle.findByUsuarioModif", query = "SELECT r FROM ReciboDetalle r WHERE r.usuarioModif = :usuarioModif"), @NamedQuery(name = "ReciboDetalle.findByFechaAlta", query = "SELECT r FROM ReciboDetalle r WHERE r.fechaAlta = :fechaAlta"), @NamedQuery(name = "ReciboDetalle.findByFechaModif", query = "SELECT r FROM ReciboDetalle r WHERE r.fechaModif = :fechaModif")})
public class ReciboDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_RECIBO_DET")
    private Long codReciboDet;
    @Column(name = "MONTO_EFECTIVO")
    private Long montoEfectivo;
    @Column(name = "MONTO_NOTA_CREDITO")
    private Long montoNotaCredito;
    @Column(name = "MONTO_TOTAL")
    private Long montoTotal;
    @Column(name = "ESTADO_DETALLE_RECIBO")
    private String estadoDetalleRecibo;
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
    @JoinColumn(name = "COD_FACTURA", referencedColumnName = "COD_FACTURA")
    @ManyToOne(optional = false)
    private FacturaCabecera codFactura;
    @JoinColumn(name = "COD_NOTA_CREDITO_CLIENTE", referencedColumnName = "COD_NOTA_CREDITO_CLIENTE")
    @ManyToOne
    private NotaCreditoCliCabecera codNotaCreditoCliente;
    @JoinColumn(name = "COD_RECIBO", referencedColumnName = "COD_RECIBO")
    @ManyToOne(optional = false)
    private ReciboCabecera codRecibo;

    public ReciboDetalle() {
    }

    public ReciboDetalle(Long codReciboDet) {
        this.codReciboDet = codReciboDet;
    }

    public Long getCodReciboDet() {
        return codReciboDet;
    }

    public void setCodReciboDet(Long codReciboDet) {
        this.codReciboDet = codReciboDet;
    }

    public Long getMontoEfectivo() {
        return montoEfectivo;
    }

    public void setMontoEfectivo(Long montoEfectivo) {
        this.montoEfectivo = montoEfectivo;
    }

    public Long getMontoNotaCredito() {
        return montoNotaCredito;
    }

    public void setMontoNotaCredito(Long montoNotaCredito) {
        this.montoNotaCredito = montoNotaCredito;
    }

    public Long getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Long montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getEstadoDetalleRecibo() {
        return estadoDetalleRecibo;
    }

    public void setEstadoDetalleRecibo(String estadoDetalleRecibo) {
        this.estadoDetalleRecibo = estadoDetalleRecibo;
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

    public FacturaCabecera getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(FacturaCabecera codFactura) {
        this.codFactura = codFactura;
    }

    public NotaCreditoCliCabecera getCodNotaCreditoCliente() {
        return codNotaCreditoCliente;
    }

    public void setCodNotaCreditoCliente(NotaCreditoCliCabecera codNotaCreditoCliente) {
        this.codNotaCreditoCliente = codNotaCreditoCliente;
    }

    public ReciboCabecera getCodRecibo() {
        return codRecibo;
    }

    public void setCodRecibo(ReciboCabecera codRecibo) {
        this.codRecibo = codRecibo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codReciboDet != null ? codReciboDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReciboDetalle)) {
            return false;
        }
        ReciboDetalle other = (ReciboDetalle) object;
        if ((this.codReciboDet == null && other.codReciboDet != null) || (this.codReciboDet != null && !this.codReciboDet.equals(other.codReciboDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.ReciboDetalle[codReciboDet=" + codReciboDet + "]";
    }

}
