/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author FerBoy
 */
@Entity
@SequenceGenerator(name="UNIDAD_MEDIDA_SEQUENCE", sequenceName="SQ_UNIDAD_MEDIDA", initialValue=1, allocationSize=1)
@Table(name = "UNIDAD_MEDIDA", catalog = "", schema = "PLATINUM")
@NamedQueries({@NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u")})
public class UnidadMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="UNIDAD_MEDIDA_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_UNIDAD_MEDIDA")
    private Long codUnidadMedida;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
   
    public UnidadMedida() {
    }

    public UnidadMedida(Long codUnidadMedida) {
        this.codUnidadMedida = codUnidadMedida;
    }

    public UnidadMedida(Long codUnidadMedida, String descripcion) {
        this.codUnidadMedida = codUnidadMedida;
        this.descripcion = descripcion;
    }

    public Long getCodUnidadMedida() {
        return codUnidadMedida;
    }

    public void setCodUnidadMedida(Long codUnidadMedida) {
        this.codUnidadMedida = codUnidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUnidadMedida != null ? codUnidadMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.codUnidadMedida == null && other.codUnidadMedida != null) || (this.codUnidadMedida != null && !this.codUnidadMedida.equals(other.codUnidadMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
