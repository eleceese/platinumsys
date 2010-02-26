/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @OneToMany(mappedBy = "codFactura", fetch=FetchType.EAGER)
    private Set<NotaCreditoCliCabecera> notaCreditoCliCabecera;
    @OneToMany(mappedBy = "codFactura", fetch=FetchType.EAGER)
    private Set<ReciboDetalle> reciboDetalle;
    @OneToMany(mappedBy = "codFactura", fetch=FetchType.EAGER)
    private Set<FacturaDetalle> facturaDetalle;

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

    public Set<NotaCreditoCliCabecera> getNotaCreditoCliCabecera() {
        return notaCreditoCliCabecera;
    }

    public List<NotaCreditoCliCabecera> getNotaCreditoCliCabeceraList() {
        return new ArrayList(Arrays.asList(notaCreditoCliCabecera.toArray(new NotaCreditoCliCabecera[0])));
    }

    public void setNotaCreditoCliCabecera(Set<NotaCreditoCliCabecera> notaCreditoCliCabecera) {
        this.notaCreditoCliCabecera = notaCreditoCliCabecera;
    }

    public Set<ReciboDetalle> getReciboDetalle() {
        return reciboDetalle;
    }

    public List<ReciboDetalle> getReciboDetalleList() {
        return new ArrayList(Arrays.asList(reciboDetalle.toArray(new ReciboDetalle[0])));
    }

    public void setReciboDetalle(Set<ReciboDetalle> reciboDetalle) {
        this.reciboDetalle = reciboDetalle;
    }

    public Set<FacturaDetalle> getFacturaDetalle() {
        return facturaDetalle;
    }

    public List<FacturaDetalle> getFacturaDetalleList() {
        return new ArrayList(Arrays.asList(facturaDetalle.toArray(new FacturaDetalle[0])));
    }

    public void setFacturaDetalle(Set<FacturaDetalle> facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
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
