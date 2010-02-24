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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "NOTA_CREDITO_PROV_DET")
public class NotaCreditoProvDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COD_NOT_CRE_DET")
    private Long codNotCreDet;
    @Column(name = "PRECIO_UNI")
    private long precioUni;
    @Column(name = "CANTIDAD")
    private long cantidad;
    @Column(name = "PORC_IVA")
    private short porcIva;
    @Column(name = "MONTO_IVA")
    private long montoIva;
    @Column(name = "SUB_TOTAL")
    private long subTotal;
    @Column(name = "TOTAL")
    private long total;
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
    @JoinColumn(name = "COD_NOT_CRE_CAB", referencedColumnName = "COD_NOT_CRE_CAB")
    @ManyToOne
    private NotaCreditoProvCab codNotCreCab;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne
    private Producto codProducto;

    public NotaCreditoProvDet() {
    }

    public NotaCreditoProvDet(Long codNotCreDet) {
        this.codNotCreDet = codNotCreDet;
    }

    public NotaCreditoProvDet(Long codNotCreDet, long precioUni, long cantidad, short porcIva, long montoIva, long subTotal, long total) {
        this.codNotCreDet = codNotCreDet;
        this.precioUni = precioUni;
        this.cantidad = cantidad;
        this.porcIva = porcIva;
        this.montoIva = montoIva;
        this.subTotal = subTotal;
        this.total = total;
    }

    public Long getCodNotCreDet() {
        return codNotCreDet;
    }

    public void setCodNotCreDet(Long codNotCreDet) {
        this.codNotCreDet = codNotCreDet;
    }

    public long getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(long precioUni) {
        this.precioUni = precioUni;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public short getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(short porcIva) {
        this.porcIva = porcIva;
    }

    public long getMontoIva() {
        return montoIva;
    }

    public void setMontoIva(long montoIva) {
        this.montoIva = montoIva;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
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

    public NotaCreditoProvCab getCodNotCreCab() {
        return codNotCreCab;
    }

    public void setCodNotCreCab(NotaCreditoProvCab codNotCreCab) {
        this.codNotCreCab = codNotCreCab;
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
        hash += (codNotCreDet != null ? codNotCreDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCreditoProvDet)) {
            return false;
        }
        NotaCreditoProvDet other = (NotaCreditoProvDet) object;
        if ((this.codNotCreDet == null && other.codNotCreDet != null) || (this.codNotCreDet != null && !this.codNotCreDet.equals(other.codNotCreDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.NotaCreditoProvDet[codNotCreDet=" + codNotCreDet + "]";
    }

}
