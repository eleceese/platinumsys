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
@Table(name = "FACTURA_DETALLE")
@NamedQueries({@NamedQuery(name = "FacturaDetalle.findAll", query = "SELECT f FROM FacturaDetalle f"), @NamedQuery(name = "FacturaDetalle.findByCodFacturaDetalle", query = "SELECT f FROM FacturaDetalle f WHERE f.codFacturaDetalle = :codFacturaDetalle"), @NamedQuery(name = "FacturaDetalle.findByPrecioUnitario", query = "SELECT f FROM FacturaDetalle f WHERE f.precioUnitario = :precioUnitario"), @NamedQuery(name = "FacturaDetalle.findByCantidad", query = "SELECT f FROM FacturaDetalle f WHERE f.cantidad = :cantidad"), @NamedQuery(name = "FacturaDetalle.findByPorcentajeIva", query = "SELECT f FROM FacturaDetalle f WHERE f.porcentajeIva = :porcentajeIva"), @NamedQuery(name = "FacturaDetalle.findByTotalIva", query = "SELECT f FROM FacturaDetalle f WHERE f.totalIva = :totalIva"), @NamedQuery(name = "FacturaDetalle.findBySubTotal", query = "SELECT f FROM FacturaDetalle f WHERE f.subTotal = :subTotal"), @NamedQuery(name = "FacturaDetalle.findByPorcentajeDescuento", query = "SELECT f FROM FacturaDetalle f WHERE f.porcentajeDescuento = :porcentajeDescuento"), @NamedQuery(name = "FacturaDetalle.findByMontoDescuento", query = "SELECT f FROM FacturaDetalle f WHERE f.montoDescuento = :montoDescuento"), @NamedQuery(name = "FacturaDetalle.findByDescripcion", query = "SELECT f FROM FacturaDetalle f WHERE f.descripcion = :descripcion"), @NamedQuery(name = "FacturaDetalle.findByUsuarioAlta", query = "SELECT f FROM FacturaDetalle f WHERE f.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "FacturaDetalle.findByUsuarioModif", query = "SELECT f FROM FacturaDetalle f WHERE f.usuarioModif = :usuarioModif"), @NamedQuery(name = "FacturaDetalle.findByFechaAlta", query = "SELECT f FROM FacturaDetalle f WHERE f.fechaAlta = :fechaAlta"), @NamedQuery(name = "FacturaDetalle.findByFechaModif", query = "SELECT f FROM FacturaDetalle f WHERE f.fechaModif = :fechaModif")})
public class FacturaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_FACTURA_DETALLE")
    private BigDecimal codFacturaDetalle;
    @Column(name = "PRECIO_UNITARIO")
    private BigInteger precioUnitario;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "PORCENTAJE_IVA")
    private BigInteger porcentajeIva;
    @Column(name = "TOTAL_IVA")
    private BigInteger totalIva;
    @Column(name = "SUB_TOTAL")
    private BigInteger subTotal;
    @Column(name = "PORCENTAJE_DESCUENTO")
    private BigInteger porcentajeDescuento;
    @Column(name = "MONTO_DESCUENTO")
    private BigInteger montoDescuento;
    @Column(name = "DESCRIPCION")
    private String descripcion;
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
    @ManyToOne
    private FacturaCabecera codFactura;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne
    private Producto codProducto;

    public FacturaDetalle() {
    }

    public FacturaDetalle(BigDecimal codFacturaDetalle) {
        this.codFacturaDetalle = codFacturaDetalle;
    }

    public BigDecimal getCodFacturaDetalle() {
        return codFacturaDetalle;
    }

    public void setCodFacturaDetalle(BigDecimal codFacturaDetalle) {
        this.codFacturaDetalle = codFacturaDetalle;
    }

    public BigInteger getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigInteger precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(BigInteger porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public BigInteger getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(BigInteger totalIva) {
        this.totalIva = totalIva;
    }

    public BigInteger getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigInteger subTotal) {
        this.subTotal = subTotal;
    }

    public BigInteger getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigInteger porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public BigInteger getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(BigInteger montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
