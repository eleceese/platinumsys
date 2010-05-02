/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author FerBoy
 */
@Entity
@SequenceGenerator(name="COSTOS_FIJOS_SEQUENCE", sequenceName="SQ_COSTOS_FIJOS", initialValue=1000, allocationSize=1)
@Table(name = "COSTOS_FIJOS", catalog = "", schema = "PLATINUM")

public class CostosFijos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="COSTOS_FIJOS_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_COSTO_FIJO", nullable = false)
    private Long codCostoFijo;
    @Column(name = "DESCRIPCION_GASTO", length = 200)
    private String descripcionGasto;
    @Column(name = "MONTO")
    private BigInteger monto;
    @Column(name = "USUARIO_ALTA", length = 15)
    private String usuarioAlta;
    @Column(name = "USUARIO_MODIF", length = 15)
    private String usuarioModif;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "FECHA_MODIF")
    @Temporal(TemporalType.DATE)
    private Date fechaModif;
    @JoinColumn(name = "COD_ORDEN_TRABAJO_DET", referencedColumnName = "COD_ORDEN_TRABAJO_DET")
    @ManyToOne(fetch = FetchType.EAGER)
    private OrdenTrabajoDetalle codOrdenTrabajoDet;

    public CostosFijos() {
    }

    public CostosFijos(Long codCostoFijo) {
        this.codCostoFijo = codCostoFijo;
    }

    public Long getCodCostoFijo() {
        return codCostoFijo;
    }

    public void setCodCostoFijo(Long codCostoFijo) {
        this.codCostoFijo = codCostoFijo;
    }




    public String getDescripcionGasto() {
        return descripcionGasto;
    }

    public void setDescripcionGasto(String descripcionGasto) {
        this.descripcionGasto = descripcionGasto;
    }

    public BigInteger getMonto() {
        return monto;
    }

    public void setMonto(BigInteger monto) {
        this.monto = monto;
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

    public OrdenTrabajoDetalle getCodOrdenTrabajoDet() {
        return codOrdenTrabajoDet;
    }

    public void setCodOrdenTrabajoDet(OrdenTrabajoDetalle codOrdenTrabajoDet) {
        this.codOrdenTrabajoDet = codOrdenTrabajoDet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCostoFijo != null ? codCostoFijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CostosFijos)) {
            return false;
        }
        CostosFijos other = (CostosFijos) object;
        if ((this.codCostoFijo == null && other.codCostoFijo != null) || (this.codCostoFijo != null && !this.codCostoFijo.equals(other.codCostoFijo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.CostosFijos[codCostoFijo=" + codCostoFijo + "]";
    }

}
