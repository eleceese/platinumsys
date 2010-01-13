/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "PEDIDO_DETALLE")
@NamedQueries({@NamedQuery(name = "PedidoDetalle.findAll", query = "SELECT p FROM PedidoDetalle p"), @NamedQuery(name = "PedidoDetalle.findByCodPedidoDetalle", query = "SELECT p FROM PedidoDetalle p WHERE p.codPedidoDetalle = :codPedidoDetalle"), @NamedQuery(name = "PedidoDetalle.findByCantidadPedida", query = "SELECT p FROM PedidoDetalle p WHERE p.cantidadPedida = :cantidadPedida"), @NamedQuery(name = "PedidoDetalle.findByCantidadEntregada", query = "SELECT p FROM PedidoDetalle p WHERE p.cantidadEntregada = :cantidadEntregada"), @NamedQuery(name = "PedidoDetalle.findByPrecioUnitario", query = "SELECT p FROM PedidoDetalle p WHERE p.precioUnitario = :precioUnitario"), @NamedQuery(name = "PedidoDetalle.findByTotal", query = "SELECT p FROM PedidoDetalle p WHERE p.total = :total"), @NamedQuery(name = "PedidoDetalle.findByUsuarioAlta", query = "SELECT p FROM PedidoDetalle p WHERE p.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "PedidoDetalle.findByUsuarioModif", query = "SELECT p FROM PedidoDetalle p WHERE p.usuarioModif = :usuarioModif"), @NamedQuery(name = "PedidoDetalle.findByFechaAlta", query = "SELECT p FROM PedidoDetalle p WHERE p.fechaAlta = :fechaAlta"), @NamedQuery(name = "PedidoDetalle.findByFechaModif", query = "SELECT p FROM PedidoDetalle p WHERE p.fechaModif = :fechaModif")})
public class PedidoDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_PEDIDO_DETALLE")
    private BigDecimal codPedidoDetalle;
    @Column(name = "CANTIDAD_PEDIDA")
    private BigInteger cantidadPedida;
    @Column(name = "CANTIDAD_ENTREGADA")
    private BigInteger cantidadEntregada;
    @Column(name = "PRECIO_UNITARIO")
    private BigInteger precioUnitario;
    @Column(name = "TOTAL")
    private BigInteger total;
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
    @JoinColumn(name = "COD_PEDIDO", referencedColumnName = "COD_PEDIDO")
    @ManyToOne(optional = false)
    private PedidoCabecera codPedido;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;

    public PedidoDetalle() {
    }

    public PedidoDetalle(BigDecimal codPedidoDetalle) {
        this.codPedidoDetalle = codPedidoDetalle;
    }

    public BigDecimal getCodPedidoDetalle() {
        return codPedidoDetalle;
    }

    public void setCodPedidoDetalle(BigDecimal codPedidoDetalle) {
        this.codPedidoDetalle = codPedidoDetalle;
    }

    public BigInteger getCantidadPedida() {
        return cantidadPedida;
    }

    public void setCantidadPedida(BigInteger cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }

    public BigInteger getCantidadEntregada() {
        return cantidadEntregada;
    }

    public void setCantidadEntregada(BigInteger cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    public BigInteger getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigInteger precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
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

    public PedidoCabecera getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(PedidoCabecera codPedido) {
        this.codPedido = codPedido;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPedidoDetalle != null ? codPedidoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoDetalle)) {
            return false;
        }
        PedidoDetalle other = (PedidoDetalle) object;
        if ((this.codPedidoDetalle == null && other.codPedidoDetalle != null) || (this.codPedidoDetalle != null && !this.codPedidoDetalle.equals(other.codPedidoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.PedidoDetalle[codPedidoDetalle=" + codPedidoDetalle + "]";
    }

}
