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
@Table(name = "COSTOS_FIJOS")
@NamedQueries({@NamedQuery(name = "CostosFijos.findAll", query = "SELECT c FROM CostosFijos c"), @NamedQuery(name = "CostosFijos.findByCodCostoFijo", query = "SELECT c FROM CostosFijos c WHERE c.codCostoFijo = :codCostoFijo"), @NamedQuery(name = "CostosFijos.findByDescripcionGasto", query = "SELECT c FROM CostosFijos c WHERE c.descripcionGasto = :descripcionGasto"), @NamedQuery(name = "CostosFijos.findByMonto", query = "SELECT c FROM CostosFijos c WHERE c.monto = :monto"), @NamedQuery(name = "CostosFijos.findByUsuarioAlta", query = "SELECT c FROM CostosFijos c WHERE c.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "CostosFijos.findByUsuarioModif", query = "SELECT c FROM CostosFijos c WHERE c.usuarioModif = :usuarioModif"), @NamedQuery(name = "CostosFijos.findByFechaAlta", query = "SELECT c FROM CostosFijos c WHERE c.fechaAlta = :fechaAlta"), @NamedQuery(name = "CostosFijos.findByFechaModif", query = "SELECT c FROM CostosFijos c WHERE c.fechaModif = :fechaModif")})
public class CostosFijos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_COSTO_FIJO")
    private Long codCostoFijo;
    @Column(name = "DESCRIPCION_GASTO")
    private String descripcionGasto;
    @Column(name = "MONTO")
    private BigInteger monto;
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
    @JoinColumn(name = "COD_ORDEN_TRABAJO", referencedColumnName = "COD_ORDEN_TRABJO")
    @ManyToOne
    private OrdenTrabajo codOrdenTrabajo;

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

    public OrdenTrabajo getCodOrdenTrabajo() {
        return codOrdenTrabajo;
    }

    public void setCodOrdenTrabajo(OrdenTrabajo codOrdenTrabajo) {
        this.codOrdenTrabajo = codOrdenTrabajo;
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
