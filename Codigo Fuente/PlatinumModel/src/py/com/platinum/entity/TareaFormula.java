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
@Table(name = "TAREA_FORMULA")
@NamedQueries({@NamedQuery(name = "TareaFormula.findAll", query = "SELECT t FROM TareaFormula t"), @NamedQuery(name = "TareaFormula.findByCodTareaFormula", query = "SELECT t FROM TareaFormula t WHERE t.codTareaFormula = :codTareaFormula"), @NamedQuery(name = "TareaFormula.findByCantidadTarea", query = "SELECT t FROM TareaFormula t WHERE t.cantidadTarea = :cantidadTarea"), @NamedQuery(name = "TareaFormula.findByOrdenTarea", query = "SELECT t FROM TareaFormula t WHERE t.ordenTarea = :ordenTarea"), @NamedQuery(name = "TareaFormula.findByUsuarioAlta", query = "SELECT t FROM TareaFormula t WHERE t.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "TareaFormula.findByUsuarioModif", query = "SELECT t FROM TareaFormula t WHERE t.usuarioModif = :usuarioModif"), @NamedQuery(name = "TareaFormula.findByFechaAlta", query = "SELECT t FROM TareaFormula t WHERE t.fechaAlta = :fechaAlta"), @NamedQuery(name = "TareaFormula.findByFechaModif", query = "SELECT t FROM TareaFormula t WHERE t.fechaModif = :fechaModif")})
public class TareaFormula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_TAREA_FORMULA")
    private Long codTareaFormula;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_TAREA")
    private long cantidadTarea;
    @Basic(optional = false)
    @Column(name = "ORDEN_TAREA")
    private long ordenTarea;
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
    @JoinColumn(name = "COD_FORMULA_DETALLE", referencedColumnName = "COD_FORMULA_DETALLE")
    @ManyToOne(optional = false)
    private FormulaDetalle codFormulaDetalle;
    @JoinColumn(name = "COD_TAREA", referencedColumnName = "COD_TAREA")
    @ManyToOne(optional = false)
    private Tarea codTarea;

    public TareaFormula() {
    }

    public TareaFormula(Long codTareaFormula) {
        this.codTareaFormula = codTareaFormula;
    }

    public TareaFormula(Long codTareaFormula, long cantidadTarea, long ordenTarea) {
        this.codTareaFormula = codTareaFormula;
        this.cantidadTarea = cantidadTarea;
        this.ordenTarea = ordenTarea;
    }

    public Long getCodTareaFormula() {
        return codTareaFormula;
    }

    public void setCodTareaFormula(Long codTareaFormula) {
        this.codTareaFormula = codTareaFormula;
    }

    public long getCantidadTarea() {
        return cantidadTarea;
    }

    public void setCantidadTarea(long cantidadTarea) {
        this.cantidadTarea = cantidadTarea;
    }

    public long getOrdenTarea() {
        return ordenTarea;
    }

    public void setOrdenTarea(long ordenTarea) {
        this.ordenTarea = ordenTarea;
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

    public FormulaDetalle getCodFormulaDetalle() {
        return codFormulaDetalle;
    }

    public void setCodFormulaDetalle(FormulaDetalle codFormulaDetalle) {
        this.codFormulaDetalle = codFormulaDetalle;
    }

    public Tarea getCodTarea() {
        return codTarea;
    }

    public void setCodTarea(Tarea codTarea) {
        this.codTarea = codTarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTareaFormula != null ? codTareaFormula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaFormula)) {
            return false;
        }
        TareaFormula other = (TareaFormula) object;
        if ((this.codTareaFormula == null && other.codTareaFormula != null) || (this.codTareaFormula != null && !this.codTareaFormula.equals(other.codTareaFormula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.TareaFormula[codTareaFormula=" + codTareaFormula + "]";
    }

}
