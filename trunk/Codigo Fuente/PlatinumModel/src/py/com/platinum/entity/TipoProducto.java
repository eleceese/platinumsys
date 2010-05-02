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
@SequenceGenerator(name="TIPO_PRODUCTO_SEQUENCE", sequenceName="SQ_TIPO_PRODUCTO", initialValue=1, allocationSize=1)
@Table(name = "TIPO_PRODUCTO", catalog = "", schema = "PLATINUM")
@NamedQueries({@NamedQuery(name = "TipoProducto.findAll", query = "SELECT t FROM TipoProducto t")})
public class TipoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TIPO_PRODUCTO_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_TIPO_PRODUCTO")
    private Long codTipoProducto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "TAREAS")
    private String tareas;
   
    public TipoProducto() {
    }

    public TipoProducto(Long codTipoProducto) {
        this.codTipoProducto = codTipoProducto;
    }

    public TipoProducto(Long codTipoProducto, String descripcion, String tareas) {
        this.codTipoProducto = codTipoProducto;
        this.descripcion = descripcion;
        this.tareas = tareas;
    }

    public Long getCodTipoProducto() {
        return codTipoProducto;
    }

    public void setCodTipoProducto(Long codTipoProducto) {
        this.codTipoProducto = codTipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoProducto != null ? codTipoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.codTipoProducto == null && other.codTipoProducto != null) || (this.codTipoProducto != null && !this.codTipoProducto.equals(other.codTipoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
