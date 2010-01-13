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
@Table(name = "GASTO")
@NamedQueries({@NamedQuery(name = "Gasto.findAll", query = "SELECT g FROM Gasto g"), @NamedQuery(name = "Gasto.findByCodGasto", query = "SELECT g FROM Gasto g WHERE g.codGasto = :codGasto"), @NamedQuery(name = "Gasto.findByDescripcionGasto", query = "SELECT g FROM Gasto g WHERE g.descripcionGasto = :descripcionGasto"), @NamedQuery(name = "Gasto.findByFechaGasto", query = "SELECT g FROM Gasto g WHERE g.fechaGasto = :fechaGasto"), @NamedQuery(name = "Gasto.findByHoraGasto", query = "SELECT g FROM Gasto g WHERE g.horaGasto = :horaGasto"), @NamedQuery(name = "Gasto.findByMontoGasto", query = "SELECT g FROM Gasto g WHERE g.montoGasto = :montoGasto"), @NamedQuery(name = "Gasto.findByUsuarioAlta", query = "SELECT g FROM Gasto g WHERE g.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "Gasto.findByUsuarioModif", query = "SELECT g FROM Gasto g WHERE g.usuarioModif = :usuarioModif"), @NamedQuery(name = "Gasto.findByFechaAlta", query = "SELECT g FROM Gasto g WHERE g.fechaAlta = :fechaAlta"), @NamedQuery(name = "Gasto.findByFechaModif", query = "SELECT g FROM Gasto g WHERE g.fechaModif = :fechaModif")})
public class Gasto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_GASTO")
    private Long codGasto;
    @Column(name = "DESCRIPCION_GASTO")
    private String descripcionGasto;
    @Column(name = "FECHA_GASTO")
    @Temporal(TemporalType.DATE)
    private Date fechaGasto;
    @Column(name = "HORA_GASTO")
    @Temporal(TemporalType.DATE)
    private Date horaGasto;
    @Column(name = "MONTO_GASTO")
    private Long montoGasto;
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
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne
    private Empleado codEmpleado;
    @JoinColumn(name = "COD_HABILITACION_CAJA", referencedColumnName = "COD_HABILITACION_CAJA")
    @ManyToOne(optional = false)
    private HabilitacionCaja codHabilitacionCaja;

    public Gasto() {
    }

    public Gasto(Long codGasto) {
        this.codGasto = codGasto;
    }

    public Long getCodGasto() {
        return codGasto;
    }

    public void setCodGasto(Long codGasto) {
        this.codGasto = codGasto;
    }

    public String getDescripcionGasto() {
        return descripcionGasto;
    }

    public void setDescripcionGasto(String descripcionGasto) {
        this.descripcionGasto = descripcionGasto;
    }

    public Date getFechaGasto() {
        return fechaGasto;
    }

    public void setFechaGasto(Date fechaGasto) {
        this.fechaGasto = fechaGasto;
    }

    public Date getHoraGasto() {
        return horaGasto;
    }

    public void setHoraGasto(Date horaGasto) {
        this.horaGasto = horaGasto;
    }

    public Long getMontoGasto() {
        return montoGasto;
    }

    public void setMontoGasto(Long montoGasto) {
        this.montoGasto = montoGasto;
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

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public HabilitacionCaja getCodHabilitacionCaja() {
        return codHabilitacionCaja;
    }

    public void setCodHabilitacionCaja(HabilitacionCaja codHabilitacionCaja) {
        this.codHabilitacionCaja = codHabilitacionCaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGasto != null ? codGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gasto)) {
            return false;
        }
        Gasto other = (Gasto) object;
        if ((this.codGasto == null && other.codGasto != null) || (this.codGasto != null && !this.codGasto.equals(other.codGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Gasto[codGasto=" + codGasto + "]";
    }

}
