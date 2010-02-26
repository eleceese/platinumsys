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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
import py.com.platinum.controller.ClienteController;
import py.com.platinum.controller.PedidoDetalleController;
import py.com.platinum.controller.ProductoController;
import py.com.platinum.utilsenum.PedidoVentaEstado;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "PEDIDO_CABECERA")
@SequenceGenerator(name = "PEDIDO_CABECERA_SEQUENCE", sequenceName = "SQ_CABECERA_PEDIDO", initialValue = 1, allocationSize = 1)
public class PedidoCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEDIDO_CABECERA_SEQUENCE")
    @Column(name = "COD_PEDIDO")
    private Long codPedido;
    @JoinColumn(name = "TIPO", referencedColumnName = "COD_TIPO")
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoComprobante tipo;
    @Column(name = "NUMERO_PEDIDO")
    private String numeroPedido;
    @Column(name = "FECHA_PEDIDO")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Column(name = "SUB_TOTAL")
    private Long subTotal;
    @Column(name = "TOTAL_IVA")
    private Long totalIva;
    @Column(name = "PORC_DESCUENTO")
    private Long porcDescuento;
    @Column(name = "MONTO_DESCUENTO")
    private Long montoDescuento;
    @Column(name = "TOTAL")
    private Long total;
    @Column(name = "ESTADO_PEDIDO")
    @Enumerated(EnumType.STRING)
    private PedidoVentaEstado estadoPedido;
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
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE", nullable=false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente codCliente;
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO", nullable=false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Empleado codEmpleado;
    @OneToMany(mappedBy = "codPedidoCab", fetch = FetchType.EAGER)
    private Set<PedidoDetalle> pedidoDetalle;
    @OneToMany(mappedBy = "codPedido", fetch = FetchType.EAGER)
    private Set<FacturaCabecera> facturaCabecera;

    public PedidoCabecera() {
    }

    public PedidoCabecera(Long codPedido) {
        this.codPedido = codPedido;
    }

    public PedidoCabecera(Long codPedido, String numeroPedido, Date fechaPedido) {
        this.codPedido = codPedido;
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
    }

    public Long getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(Long codPedido) {
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

    public Long getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(Long montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public Long getPorcDescuento() {
        return porcDescuento;
    }

    public void setPorcDescuento(Long porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public Long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Long subTotal) {
        this.subTotal = subTotal;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Long totalIva) {
        this.totalIva = totalIva;
    }

    public PedidoVentaEstado getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(PedidoVentaEstado estadoPedido) {
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

    public Set<PedidoDetalle> getPedidoDetalle() {
        return pedidoDetalle;
    }

    public List<PedidoDetalle> getPedidoDetalleList() {
        return new ArrayList(Arrays.asList(pedidoDetalle.toArray(new PedidoDetalle[0])));
    }
    public void setPedidoDetalle(Set<PedidoDetalle> pedidoDetalle) {
        this.pedidoDetalle = pedidoDetalle;
    }

    public Set<FacturaCabecera> getFacturaCabecera() {
        return facturaCabecera;
    }

    public List<FacturaCabecera> getFacturaCabeceraList() {
        return new ArrayList(Arrays.asList(facturaCabecera.toArray(new FacturaCabecera[0])));
    }

    public void setFacturaCabecera(Set<FacturaCabecera> facturaCabecera) {
        this.facturaCabecera = facturaCabecera;
    }

    public TipoComprobante getTipo() {
        return tipo;
    }

    public void setTipo(TipoComprobante tipo) {
        this.tipo = tipo;
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
        return numeroPedido;
    }
}
