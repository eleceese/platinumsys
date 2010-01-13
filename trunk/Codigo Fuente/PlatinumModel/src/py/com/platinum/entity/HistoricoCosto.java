/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "HISTORICO_COSTO")
@NamedQueries({@NamedQuery(name = "HistoricoCosto.findAll", query = "SELECT h FROM HistoricoCosto h"), @NamedQuery(name = "HistoricoCosto.findByCodHistoricoCosto", query = "SELECT h FROM HistoricoCosto h WHERE h.codHistoricoCosto = :codHistoricoCosto"), @NamedQuery(name = "HistoricoCosto.findByFecHistoricoCosto", query = "SELECT h FROM HistoricoCosto h WHERE h.fecHistoricoCosto = :fecHistoricoCosto"), @NamedQuery(name = "HistoricoCosto.findByCostoHistorico", query = "SELECT h FROM HistoricoCosto h WHERE h.costoHistorico = :costoHistorico"), @NamedQuery(name = "HistoricoCosto.findByUsuarioAlta", query = "SELECT h FROM HistoricoCosto h WHERE h.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "HistoricoCosto.findByUsuarioModif", query = "SELECT h FROM HistoricoCosto h WHERE h.usuarioModif = :usuarioModif"), @NamedQuery(name = "HistoricoCosto.findByFechaAlta", query = "SELECT h FROM HistoricoCosto h WHERE h.fechaAlta = :fechaAlta"), @NamedQuery(name = "HistoricoCosto.findByFechaModif", query = "SELECT h FROM HistoricoCosto h WHERE h.fechaModif = :fechaModif")})
public class HistoricoCosto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_HISTORICO_COSTO")
    private BigDecimal codHistoricoCosto;
    @Basic(optional = false)
    @Column(name = "FEC_HISTORICO_COSTO")
    @Temporal(TemporalType.DATE)
    private Date fecHistoricoCosto;
    @Basic(optional = false)
    @Column(name = "COSTO_HISTORICO")
    private BigInteger costoHistorico;
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
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;

    public HistoricoCosto() {
    }

    public HistoricoCosto(BigDecimal codHistoricoCosto) {
        this.codHistoricoCosto = codHistoricoCosto;
    }

    public HistoricoCosto(BigDecimal codHistoricoCosto, Date fecHistoricoCosto, BigInteger costoHistorico) {
        this.codHistoricoCosto = codHistoricoCosto;
        this.fecHistoricoCosto = fecHistoricoCosto;
        this.costoHistorico = costoHistorico;
    }

    public BigDecimal getCodHistoricoCosto() {
        return codHistoricoCosto;
    }

    public void setCodHistoricoCosto(BigDecimal codHistoricoCosto) {
        this.codHistoricoCosto = codHistoricoCosto;
    }

    public Date getFecHistoricoCosto() {
        return fecHistoricoCosto;
    }

    public void setFecHistoricoCosto(Date fecHistoricoCosto) {
        this.fecHistoricoCosto = fecHistoricoCosto;
    }

    public BigInteger getCostoHistorico() {
        return costoHistorico;
    }

    public void setCostoHistorico(BigInteger costoHistorico) {
        this.costoHistorico = costoHistorico;
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

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codHistoricoCosto != null ? codHistoricoCosto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoCosto)) {
            return false;
        }
        HistoricoCosto other = (HistoricoCosto) object;
        if ((this.codHistoricoCosto == null && other.codHistoricoCosto != null) || (this.codHistoricoCosto != null && !this.codHistoricoCosto.equals(other.codHistoricoCosto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.HistoricoCosto[codHistoricoCosto=" + codHistoricoCosto + "]";
    }

}
