/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "CARGO", catalog = "", schema = "PLATINUM")
@SequenceGenerator(name="CARGO_SEQUENCE", sequenceName="SQ_CARGO", initialValue=1, allocationSize=1)
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CARGO_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_CARGO")
    private Long codCargo;
    @Basic(optional = false)
    @Column(name = "NOMBRE_CARGO")
    private String nombreCargo;
  
    public Cargo() {
    }

    public Cargo(Long codCargo) {
        this.codCargo = codCargo;
    }

    public Cargo(Long codCargo, String nombreCargo) {
        this.codCargo = codCargo;
        this.nombreCargo = nombreCargo;
    }

    public Long getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(Long codCargo) {
        this.codCargo = codCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCargo != null ? codCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.codCargo == null && other.codCargo != null) || (this.codCargo != null && !this.codCargo.equals(other.codCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Cargo[codCargo=" + codCargo + "]";
    }

}
