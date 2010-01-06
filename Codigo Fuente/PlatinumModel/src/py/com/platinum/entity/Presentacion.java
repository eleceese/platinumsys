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
@SequenceGenerator(name="PRESENTACION_SEQUENCE", sequenceName="SQ_PRESENTACION", initialValue=1, allocationSize=1)
@Table(name = "PRESENTACION", catalog = "", schema = "PLATINUM")
@NamedQueries({@NamedQuery(name = "Presentacion.findAll", query = "SELECT p FROM Presentacion p")})
public class Presentacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRESENTACION_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_PRESENTACION")
    private Long codPresentacion;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "codPresentacion")
    private List<Producto> productoCollection;

    public Presentacion() {
    }

    public Presentacion(Long codPresentacion) {
        this.codPresentacion = codPresentacion;
    }

    public Presentacion(Long codPresentacion, String descripcion) {
        this.codPresentacion = codPresentacion;
        this.descripcion = descripcion;
    }

    public Long getCodPresentacion() {
        return codPresentacion;
    }

    public void setCodPresentacion(Long codPresentacion) {
        this.codPresentacion = codPresentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(List<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPresentacion != null ? codPresentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presentacion)) {
            return false;
        }
        Presentacion other = (Presentacion) object;
        if ((this.codPresentacion == null && other.codPresentacion != null) || (this.codPresentacion != null && !this.codPresentacion.equals(other.codPresentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
