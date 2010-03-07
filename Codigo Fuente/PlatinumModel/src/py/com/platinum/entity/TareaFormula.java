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
@SequenceGenerator(name="TAREA_FORMULA_SEQUENCE", sequenceName="SQ_TAREA_FORMULA", initialValue=1, allocationSize=1)
@Table(name = "TAREA_FORMULA")
@NamedQueries({@NamedQuery(name = "TareaFormula.findAll", query = "SELECT t FROM TareaFormula t")})
public class TareaFormula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TAREA_FORMULA_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_TAREA_FORMULA")
    private Long codTareaFormula;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_TAREA")
    private BigInteger cantidadTarea;
    @Basic(optional = false)
    @Column(name = "ORDEN_TAREA")
    private BigInteger ordenTarea;
    @Basic(optional = true)
    @Column(name = "TAREA_FIN")
    private String tareaFin;
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
    @JoinColumn(name = "COD_FORMULA_SEMI_CABECERA", referencedColumnName = "COD_FORMULA_SEMI_CABECERA")
    @ManyToOne(optional = false)
    private FormulaSemiCabecera codFormulaSemiCabecera;
    @JoinColumn(name = "COD_TAREA", referencedColumnName = "COD_TAREA")
    @ManyToOne(optional = false)
    private Tarea codTarea;

    public String getTareaFin() {
        return tareaFin;
    }

    public void setTareaFin(String tareaFin) {
        this.tareaFin = tareaFin;
    }



    public void setCodFormulaSemiCabecera(FormulaSemiCabecera codFormulaSemiCabecera) {
        this.codFormulaSemiCabecera = codFormulaSemiCabecera;
    }

    public TareaFormula() {
    }


    public TareaFormula(Long codTareaFormula) {
        this.codTareaFormula = codTareaFormula;
    }

    public TareaFormula(Long codTareaFormula, BigInteger cantidadTarea, BigInteger ordenTarea) {
        this.codTareaFormula = codTareaFormula;
        this.cantidadTarea = cantidadTarea;
        this.ordenTarea = ordenTarea;
    }


    public FormulaSemiCabecera getCodFormulaSemiCabecera() {
        return codFormulaSemiCabecera;
    }
    
    public Long getCodTareaFormula() {
        return codTareaFormula;
    }

    public void setCodTareaFormula(Long codTareaFormula) {
        this.codTareaFormula = codTareaFormula;
    }

    public BigInteger getCantidadTarea() {
        return cantidadTarea;
    }

    public void setCantidadTarea(BigInteger cantidadTarea) {
        this.cantidadTarea = cantidadTarea;
    }

    public BigInteger getOrdenTarea() {
        return ordenTarea;
    }

    public void setOrdenTarea(BigInteger ordenTarea) {
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
