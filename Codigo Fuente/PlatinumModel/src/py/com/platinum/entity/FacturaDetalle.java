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
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import py.com.platinum.listener.FacturaVentaDetalleListener;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "FACTURA_DETALLE")
@EntityListeners(value=FacturaVentaDetalleListener.class)
@SequenceGenerator(name = "FACTURA_DETALLE_SEQUENCE", sequenceName = "SQ_DETALLE_FACTURA", initialValue = 1, allocationSize = 1)
public class FacturaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACTURA_DETALLE_SEQUENCE")
    @Column(name = "COD_FACTURA_DETALLE", nullable=false)
    private Long codFacturaDetalle;
    @Column(name = "PRECIO_UNITARIO", nullable=false)
    private Long precioUnitario;
    @Column(name = "CANTIDAD", nullable=false)
    private Long cantidad;
    @Column(name = "PORCENTAJE_IVA", nullable=false)
    private Double porcentajeIva;
    @Column(name = "TOTAL_IVA", nullable=false)
    private Long totalIva;
    @Column(name = "SUB_TOTAL", nullable=false)
    private Long subTotal;
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
    @JoinColumn(name = "COD_FACTURA", referencedColumnName = "COD_FACTURA", nullable=false)
    @ManyToOne(fetch=FetchType.EAGER)
    private FacturaCabecera codFactura;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO", nullable=false)
    @ManyToOne(fetch=FetchType.EAGER)
    private Producto codProducto;
    @JoinColumn(name = "COD_PEDIDO_DETALLE", referencedColumnName = "COD_PEDIDO_DETALLE", nullable=true)
    @OneToOne(fetch=FetchType.EAGER)
    private PedidoDetalle codPedidoDetalle;

    public FacturaDetalle() {
    }

    public FacturaDetalle(Long codFacturaDetalle) {
        this.codFacturaDetalle = codFacturaDetalle;
    }

    public Long getCodFacturaDetalle() {
        return codFacturaDetalle;
    }

    public void setCodFacturaDetalle(Long codFacturaDetalle) {
        this.codFacturaDetalle = codFacturaDetalle;
    }

    public Long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(Double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public Long getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Long totalIva) {
        this.totalIva = totalIva;
    }

    public Long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Long subTotal) {
        this.subTotal = subTotal;
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

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public PedidoDetalle getCodPedidoDetalle() {
        return codPedidoDetalle;
    }

    public void setCodPedidoDetalle(PedidoDetalle codPedidoDetalle) {
        this.codPedidoDetalle = codPedidoDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFacturaDetalle != null ? codFacturaDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaDetalle)) {
            return false;
        }
        FacturaDetalle other = (FacturaDetalle) object;
        if ((this.codFacturaDetalle == null && other.codFacturaDetalle != null) || (this.codFacturaDetalle != null && !this.codFacturaDetalle.equals(other.codFacturaDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.FacturaDetalle[codFacturaDetalle=" + codFacturaDetalle + "]";
    }

}
