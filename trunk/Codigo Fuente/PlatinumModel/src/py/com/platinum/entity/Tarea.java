/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@SequenceGenerator(name="PRODUCTO_SEQUENCE", sequenceName="SQ_TAREA", initialValue=1, allocationSize=1)
@Table(name = "TAREA")
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRODUCTO_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_TAREA")
    private Long codTarea;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TAREA")
    private String nombreTarea;
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
    @JoinColumn(name = "COD_MAQUINARIA", referencedColumnName = "COD_MAQUINARIA")
    @ManyToOne
    private Maquinarias codMaquinaria;

    public Maquinarias getCodMaquinaria() {
        return codMaquinaria;
    }

    public void setCodMaquinaria(Maquinarias codMaquinaria) {
        this.codMaquinaria = codMaquinaria;
    }



    public Tarea() {
    }

    public Tarea(Long codTarea) {
        this.codTarea = codTarea;
    }

    public Tarea(Long codTarea, String nombreTarea) {
        this.codTarea = codTarea;
        this.nombreTarea = nombreTarea;
    }

    public Long getCodTarea() {
        return codTarea;
    }

    public void setCodTarea(Long codTarea) {
        this.codTarea = codTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTarea != null ? codTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.codTarea == null && other.codTarea != null) || (this.codTarea != null && !this.codTarea.equals(other.codTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTarea;
    }

}
