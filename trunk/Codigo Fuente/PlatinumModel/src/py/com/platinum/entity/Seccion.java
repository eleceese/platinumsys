/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author FerBoy
 */
@Entity
@Table(name = "SECCION", catalog = "", schema = "PLATINUM")
@NamedQueries({@NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s")})
public class Seccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_SECCION")
    private BigDecimal codSeccion;
    @Basic(optional = false)
    @Column(name = "NOMBRE_SECCION")
    private String nombreSeccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSeccion")
    private List<Empleado> empleadoCollection;

    public Seccion() {
    }

    public Seccion(BigDecimal codSeccion) {
        this.codSeccion = codSeccion;
    }

    public Seccion(BigDecimal codSeccion, String nombreSeccion) {
        this.codSeccion = codSeccion;
        this.nombreSeccion = nombreSeccion;
    }

    public BigDecimal getCodSeccion() {
        return codSeccion;
    }

    public void setCodSeccion(BigDecimal codSeccion) {
        this.codSeccion = codSeccion;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public List<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(List<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSeccion != null ? codSeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.codSeccion == null && other.codSeccion != null) || (this.codSeccion != null && !this.codSeccion.equals(other.codSeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Seccion[codSeccion=" + codSeccion + "]";
    }

}
