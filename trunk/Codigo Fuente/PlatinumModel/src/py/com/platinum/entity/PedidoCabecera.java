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
@Table(name = "PEDIDO_CABECERA")
public class PedidoCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_PEDIDO")
    private BigDecimal codPedido;
    @Basic(optional = false)
    @Column(name = "NUMERO_PEDIDO")
    private String numeroPedido;
    @Basic(optional = false)
    @Column(name = "FECHA_PEDIDO")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Column(name = "TOTAL_PEDIDO")
    private BigInteger totalPedido;
    @Column(name = "ESTADO_PEDIDO")
    private String estadoPedido;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPedido")
    private List<PedidoDetalle> pedidoDetalleCollection;
    @OneToMany(mappedBy = "codPedido")
    private List<FacturaCabecera> facturaCabeceraCollection;

    public PedidoCabecera() {
    }

    public PedidoCabecera(BigDecimal codPedido) {
        this.codPedido = codPedido;
    }

    public PedidoCabecera(BigDecimal codPedido, String numeroPedido, Date fechaPedido) {
        this.codPedido = codPedido;
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
    }

    public BigDecimal getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(BigDecimal codPedido) {
        this.codPedido = codPedido;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public BigInteger getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigInteger totalPedido) {
        this.totalPedido = totalPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
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

    public List<PedidoDetalle> getPedidoDetalleCollection() {
        return pedidoDetalleCollection;
    }

    public void setPedidoDetalleCollection(List<PedidoDetalle> pedidoDetalleCollection) {
        this.pedidoDetalleCollection = pedidoDetalleCollection;
    }

    public List<FacturaCabecera> getFacturaCabeceraCollection() {
        return facturaCabeceraCollection;
    }

    public void setFacturaCabeceraCollection(List<FacturaCabecera> facturaCabeceraCollection) {
        this.facturaCabeceraCollection = facturaCabeceraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPedido != null ? codPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoCabecera)) {
            return false;
        }
        PedidoCabecera other = (PedidoCabecera) object;
        if ((this.codPedido == null && other.codPedido != null) || (this.codPedido != null && !this.codPedido.equals(other.codPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.PedidoCabecera[codPedido=" + codPedido + "]";
    }

}
