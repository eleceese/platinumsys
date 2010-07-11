/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "CIUDAD")
@SequenceGenerator(name="CIUDAD_SEQUENCE", sequenceName="SQ_CIUDAD", initialValue=1, allocationSize=1)
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CIUDAD_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "CODCIUDAD")
    private Long codciudad;
    @Basic(optional = false)
    @Column(name = "NOMBRECIUDAD")
    private String nombreciudad;
    

    public Ciudad() {
    }

    public Ciudad(Long codciudad) {
        this.codciudad = codciudad;
    }

    public Ciudad(Long codciudad, String nombreciudad) {
        this.codciudad = codciudad;
        this.nombreciudad = nombreciudad;
    }

    public Long getCodciudad() {
        return codciudad;
    }

    public void setCodciudad(Long codciudad) {
        this.codciudad = codciudad;
    }

    public String getNombreciudad() {
        return nombreciudad;
    }

    public void setNombreciudad(String nombreciudad) {
        this.nombreciudad = nombreciudad;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codciudad != null ? codciudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.codciudad == null && other.codciudad != null) || (this.codciudad != null && !this.codciudad.equals(other.codciudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Ciudad[codciudad=" + codciudad + "]";
    }

}
