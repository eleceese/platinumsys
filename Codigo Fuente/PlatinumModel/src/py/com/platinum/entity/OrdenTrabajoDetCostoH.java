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
@SequenceGenerator(name="ORDEN_TRAB_DET_COSTO_HOR_SQ", sequenceName="SQ_ORDEN_TRABAJO_DET_COSTO_H", initialValue=1000, allocationSize=1)
@Table(name = "ORDEN_TRABAJO_DET_COSTO_H", catalog = "", schema = "PLATINUM")
public class OrdenTrabajoDetCostoH implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ORDEN_TRAB_DET_COSTO_HOR_SQ")
    @Basic(optional = false)
    @Column(name = "COD_ORDEN_TRAB_DET_HORAS", nullable = false)
    private Long codOrdenTrabDetHoras;
    @Column(name = "CANTIDAD_HORAS")
    private BigDecimal cantidadHoras;
    @Column(name = "COSTO_HORA")
    private BigDecimal costoHora;
    @Column(name = "COSTO_TOTAL")
    private Long costoTotal;
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Empleado codEmpleado;
    @JoinColumn(name = "COD_ORDEN_TRABAJO_DET", referencedColumnName = "COD_ORDEN_TRABAJO_DET")
    @ManyToOne(fetch = FetchType.EAGER)
    private OrdenTrabajoDetalle codOrdenTrabajoDet;

    public OrdenTrabajoDetCostoH() {
    }

    public OrdenTrabajoDetCostoH(Long codOrdenTrabDetHoras) {
        this.codOrdenTrabDetHoras = codOrdenTrabDetHoras;
    }

    public Long getCodOrdenTrabDetHoras() {
        return codOrdenTrabDetHoras;
    }

    public void setCodOrdenTrabDetHoras(Long codOrdenTrabDetHoras) {
        this.codOrdenTrabDetHoras = codOrdenTrabDetHoras;
    }

    public BigDecimal getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(BigDecimal cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public BigDecimal getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(BigDecimal costoHora) {
        this.costoHora = costoHora;
    }

    public Long getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Long costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public OrdenTrabajoDetalle getCodOrdenTrabajoDet() {
        return codOrdenTrabajoDet;
    }

    public void setCodOrdenTrabajoDet(OrdenTrabajoDetalle codOrdenTrabajoDet) {
        this.codOrdenTrabajoDet = codOrdenTrabajoDet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOrdenTrabDetHoras != null ? codOrdenTrabDetHoras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoDetCostoH)) {
            return false;
        }
        OrdenTrabajoDetCostoH other = (OrdenTrabajoDetCostoH) object;
        if ((this.codOrdenTrabDetHoras == null && other.codOrdenTrabDetHoras != null) || (this.codOrdenTrabDetHoras != null && !this.codOrdenTrabDetHoras.equals(other.codOrdenTrabDetHoras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.OrdenTrabajoDetCostoH[codOrdenTrabDetHoras=" + codOrdenTrabDetHoras + "]";
    }

}
