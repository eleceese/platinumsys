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
@Table(name = "CARGO", catalog = "", schema = "PLATINUM")
@NamedQueries({@NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")})
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_CARGO")
    private BigDecimal codCargo;
    @Basic(optional = false)
    @Column(name = "NOMBRE_CARGO")
    private String nombreCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCargo")
    private List<Empleado> empleadoCollection;

    public Cargo() {
    }

    public Cargo(BigDecimal codCargo) {
        this.codCargo = codCargo;
    }

    public Cargo(BigDecimal codCargo, String nombreCargo) {
        this.codCargo = codCargo;
        this.nombreCargo = nombreCargo;
    }

    public BigDecimal getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(BigDecimal codCargo) {
        this.codCargo = codCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
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
