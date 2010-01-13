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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "CAJA")
@NamedQueries({@NamedQuery(name = "Caja.findAll", query = "SELECT c FROM Caja c"), @NamedQuery(name = "Caja.findByCodCaja", query = "SELECT c FROM Caja c WHERE c.codCaja = :codCaja"), @NamedQuery(name = "Caja.findByNombreCaja", query = "SELECT c FROM Caja c WHERE c.nombreCaja = :nombreCaja"), @NamedQuery(name = "Caja.findByUsuarioAlta", query = "SELECT c FROM Caja c WHERE c.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "Caja.findByUsuarioModif", query = "SELECT c FROM Caja c WHERE c.usuarioModif = :usuarioModif"), @NamedQuery(name = "Caja.findByFechaAlta", query = "SELECT c FROM Caja c WHERE c.fechaAlta = :fechaAlta"), @NamedQuery(name = "Caja.findByFechaModif", query = "SELECT c FROM Caja c WHERE c.fechaModif = :fechaModif")})
public class Caja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_CAJA")
    private Long codCaja;
    @Basic(optional = false)
    @Column(name = "NOMBRE_CAJA")
    private String nombreCaja;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCaja")
    private List<HabilitacionCaja> habilitacionCajaCollection;

    public Caja() {
    }

    public Caja(Long codCaja) {
        this.codCaja = codCaja;
    }

    public Caja(Long codCaja, String nombreCaja) {
        this.codCaja = codCaja;
        this.nombreCaja = nombreCaja;
    }

    public Long getCodCaja() {
        return codCaja;
    }

    public void setCodCaja(Long codCaja) {
        this.codCaja = codCaja;
    }

    public String getNombreCaja() {
        return nombreCaja;
    }

    public void setNombreCaja(String nombreCaja) {
        this.nombreCaja = nombreCaja;
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

    public List<HabilitacionCaja> getHabilitacionCajaCollection() {
        return habilitacionCajaCollection;
    }

    public void setHabilitacionCajaCollection(List<HabilitacionCaja> habilitacionCajaCollection) {
        this.habilitacionCajaCollection = habilitacionCajaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCaja != null ? codCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caja)) {
            return false;
        }
        Caja other = (Caja) object;
        if ((this.codCaja == null && other.codCaja != null) || (this.codCaja != null && !this.codCaja.equals(other.codCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Caja[codCaja=" + codCaja + "]";
    }

}
