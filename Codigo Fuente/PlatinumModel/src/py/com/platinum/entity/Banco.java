/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "BANCO")
@NamedQueries({@NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"), @NamedQuery(name = "Banco.findByCodBanco", query = "SELECT b FROM Banco b WHERE b.codBanco = :codBanco"), @NamedQuery(name = "Banco.findByNombreBanco", query = "SELECT b FROM Banco b WHERE b.nombreBanco = :nombreBanco"), @NamedQuery(name = "Banco.findByUsuarioAlta", query = "SELECT b FROM Banco b WHERE b.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "Banco.findByUsuarioModif", query = "SELECT b FROM Banco b WHERE b.usuarioModif = :usuarioModif"), @NamedQuery(name = "Banco.findByFechaAlta", query = "SELECT b FROM Banco b WHERE b.fechaAlta = :fechaAlta"), @NamedQuery(name = "Banco.findByFechaModif", query = "SELECT b FROM Banco b WHERE b.fechaModif = :fechaModif")})
public class Banco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_BANCO")
    private Long codBanco;
    @Basic(optional = false)
    @Column(name = "NOMBRE_BANCO")
    private String nombreBanco;
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
    @OneToMany(mappedBy = "codBanco")
    private List<FormaPago> formaPagoCollection;

    public Banco() {
    }

    public Banco(Long codBanco) {
        this.codBanco = codBanco;
    }

    public Banco(Long codBanco, String nombreBanco) {
        this.codBanco = codBanco;
        this.nombreBanco = nombreBanco;
    }

    public Long getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(Long codBanco) {
        this.codBanco = codBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
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

    public List<FormaPago> getFormaPagoCollection() {
        return formaPagoCollection;
    }

    public void setFormaPagoCollection(List<FormaPago> formaPagoCollection) {
        this.formaPagoCollection = formaPagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBanco != null ? codBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.codBanco == null && other.codBanco != null) || (this.codBanco != null && !this.codBanco.equals(other.codBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Banco[codBanco=" + codBanco + "]";
    }

}