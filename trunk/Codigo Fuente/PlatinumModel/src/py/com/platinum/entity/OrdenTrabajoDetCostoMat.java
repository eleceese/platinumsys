/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author FerBoy
 */
@Entity
@SequenceGenerator(name="ORDEN_TRAB_DET_COSTO_M_SQ", sequenceName="SQ_ORDEN_TRAB_DET_COSTO_M", initialValue=1000, allocationSize=1)
@Table(name = "ORDEN_TRABAJO_DET_COSTO_MAT", catalog = "", schema = "PLATINUM")
public class OrdenTrabajoDetCostoMat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ORDEN_TRAB_DET_COSTO_M_SQ")
    @Basic(optional = false)
    @Column(name = "COD_ORDEN_TRAB_DET_MAT", nullable = false, precision = 22)
    private Long codOrdenTrabDetMat;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "COSTO_UNITARIO")
    private BigInteger costoUnitario;
    @Column(name = "COSTO_TOTAL")
    private BigInteger costoTotal;
    @JoinColumn(name = "COD_ORDEN_TRABAJO_DET", referencedColumnName = "COD_ORDEN_TRABAJO_DET")
    @ManyToOne(fetch = FetchType.EAGER)
    private OrdenTrabajoDetalle codOrdenTrabajoDet;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Producto codProducto;

    public OrdenTrabajoDetCostoMat() {
    }

    public OrdenTrabajoDetCostoMat(Long codOrdenTrabDetMat) {
        this.codOrdenTrabDetMat = codOrdenTrabDetMat;
    }

    public Long getCodOrdenTrabDetMat() {
        return codOrdenTrabDetMat;
    }

    public void setCodOrdenTrabDetMat(Long codOrdenTrabDetMat) {
        this.codOrdenTrabDetMat = codOrdenTrabDetMat;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigInteger costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public BigInteger getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(BigInteger costoTotal) {
        this.costoTotal = costoTotal;
    }

    public OrdenTrabajoDetalle getCodOrdenTrabajoDet() {
        return codOrdenTrabajoDet;
    }

    public void setCodOrdenTrabajoDet(OrdenTrabajoDetalle codOrdenTrabajoDet) {
        this.codOrdenTrabajoDet = codOrdenTrabajoDet;
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
        hash += (codOrdenTrabDetMat != null ? codOrdenTrabDetMat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoDetCostoMat)) {
            return false;
        }
        OrdenTrabajoDetCostoMat other = (OrdenTrabajoDetCostoMat) object;
        if ((this.codOrdenTrabDetMat == null && other.codOrdenTrabDetMat != null) || (this.codOrdenTrabDetMat != null && !this.codOrdenTrabDetMat.equals(other.codOrdenTrabDetMat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.OrdenTrabajoDetCostoMat[codOrdenTrabDetMat=" + codOrdenTrabDetMat + "]";
    }

}
