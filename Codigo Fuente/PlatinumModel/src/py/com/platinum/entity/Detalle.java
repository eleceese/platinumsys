/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author FerBoy
 */
@Entity
@Table(name = "DETALLE")
@NamedQueries({@NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d")})
public class Detalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DET")
    private Long idDet;
    @Column(name = "NOMBRE_DET")
    private String nombreDet;
    @JoinColumn(name = "ID_CAB", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cabecera idCab;

    public Detalle() {
    }

    public Detalle(Long idDet) {
        this.idDet = idDet;
    }

    public Long getIdDet() {
        return idDet;
    }

    public void setIdDet(Long idDet) {
        this.idDet = idDet;
    }

    public String getNombreDet() {
        return nombreDet;
    }

    public void setNombreDet(String nombreDet) {
        this.nombreDet = nombreDet;
    }

    public Cabecera getIdCab() {
        return idCab;
    }

    public void setIdCab(Cabecera idCab) {
        this.idCab = idCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDet != null ? idDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.idDet == null && other.idDet != null) || (this.idDet != null && !this.idDet.equals(other.idDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Detalle[idDet=" + idDet + "]";
    }

}
