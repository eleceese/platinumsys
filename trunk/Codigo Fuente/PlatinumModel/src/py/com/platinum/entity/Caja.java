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
@Table(name = "CAJA")
@SequenceGenerator(name="CAJA_SEQUENCE", sequenceName="SQ_CAJA", initialValue=1, allocationSize=1)
public class Caja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CAJA_SEQUENCE")
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
        return nombreCaja;
    }

}
