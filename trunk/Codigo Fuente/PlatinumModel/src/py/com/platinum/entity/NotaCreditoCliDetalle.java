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
@Table(name = "NOTA_CREDITO_CLI_DETALLE")
@NamedQueries({@NamedQuery(name = "NotaCreditoCliDetalle.findAll", query = "SELECT n FROM NotaCreditoCliDetalle n"), @NamedQuery(name = "NotaCreditoCliDetalle.findByCodNotaCreditoCliDet", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.codNotaCreditoCliDet = :codNotaCreditoCliDet"), @NamedQuery(name = "NotaCreditoCliDetalle.findByPrecioUnitario", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.precioUnitario = :precioUnitario"), @NamedQuery(name = "NotaCreditoCliDetalle.findByCantidad", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.cantidad = :cantidad"), @NamedQuery(name = "NotaCreditoCliDetalle.findByMonto", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.monto = :monto"), @NamedQuery(name = "NotaCreditoCliDetalle.findByPorcentajeIva", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.porcentajeIva = :porcentajeIva"), @NamedQuery(name = "NotaCreditoCliDetalle.findByTotalIva", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.totalIva = :totalIva"), @NamedQuery(name = "NotaCreditoCliDetalle.findBySubTotal", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.subTotal = :subTotal"), @NamedQuery(name = "NotaCreditoCliDetalle.findByDescripcion", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.descripcion = :descripcion"), @NamedQuery(name = "NotaCreditoCliDetalle.findByUsuarioAlta", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "NotaCreditoCliDetalle.findByUsuarioModif", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.usuarioModif = :usuarioModif"), @NamedQuery(name = "NotaCreditoCliDetalle.findByFechaAlta", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.fechaAlta = :fechaAlta"), @NamedQuery(name = "NotaCreditoCliDetalle.findByFechaModif", query = "SELECT n FROM NotaCreditoCliDetalle n WHERE n.fechaModif = :fechaModif")})
public class NotaCreditoCliDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_NOTA_CREDITO_CLI_DET")
    private BigDecimal codNotaCreditoCliDet;
    @Basic(optional = false)
    @Column(name = "PRECIO_UNITARIO")
    private BigInteger precioUnitario;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @Column(name = "MONTO")
    private BigInteger monto;
    @Basic(optional = false)
    @Column(name = "PORCENTAJE_IVA")
    private BigInteger porcentajeIva;
    @Basic(optional = false)
    @Column(name = "TOTAL_IVA")
    private BigInteger totalIva;
    @Basic(optional = false)
    @Column(name = "SUB_TOTAL")
    private BigInteger subTotal;
    @Basic(optional = false)
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
    @JoinColumn(name = "COD_NOTA_CREDITO_CLIENTE", referencedColumnName = "COD_NOTA_CREDITO_CLIENTE")
    @ManyToOne(optional = false)
    private NotaCreditoCliCabecera codNotaCreditoCliente;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;

    public NotaCreditoCliDetalle() {
    }

    public NotaCreditoCliDetalle(BigDecimal codNotaCreditoCliDet) {
        this.codNotaCreditoCliDet = codNotaCreditoCliDet;
    }

    public NotaCreditoCliDetalle(BigDecimal codNotaCreditoCliDet, BigInteger precioUnitario, BigInteger cantidad, BigInteger monto, BigInteger porcentajeIva, BigInteger totalIva, BigInteger subTotal, String descripcion) {
        this.codNotaCreditoCliDet = codNotaCreditoCliDet;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.monto = monto;
        this.porcentajeIva = porcentajeIva;
        this.totalIva = totalIva;
        this.subTotal = subTotal;
        this.descripcion = descripcion;
    }

    public BigDecimal getCodNotaCreditoCliDet() {
        return codNotaCreditoCliDet;
    }

    public void setCodNotaCreditoCliDet(BigDecimal codNotaCreditoCliDet) {
        this.codNotaCreditoCliDet = codNotaCreditoCliDet;
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

    public BigInteger getMonto() {
        return monto;
    }

    public void setMonto(BigInteger monto) {
        this.monto = monto;
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

    public NotaCreditoCliCabecera getCodNotaCreditoCliente() {
        return codNotaCreditoCliente;
    }

    public void setCodNotaCreditoCliente(NotaCreditoCliCabecera codNotaCreditoCliente) {
        this.codNotaCreditoCliente = codNotaCreditoCliente;
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
        hash += (codNotaCreditoCliDet != null ? codNotaCreditoCliDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCreditoCliDetalle)) {
            return false;
        }
        NotaCreditoCliDetalle other = (NotaCreditoCliDetalle) object;
        if ((this.codNotaCreditoCliDet == null && other.codNotaCreditoCliDet != null) || (this.codNotaCreditoCliDet != null && !this.codNotaCreditoCliDet.equals(other.codNotaCreditoCliDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.NotaCreditoCliDetalle[codNotaCreditoCliDet=" + codNotaCreditoCliDet + "]";
    }

}
