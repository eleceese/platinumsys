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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "FORMA_PAGO")
@NamedQueries({@NamedQuery(name = "FormaPago.findAll", query = "SELECT f FROM FormaPago f"), @NamedQuery(name = "FormaPago.findByCodFormaPago", query = "SELECT f FROM FormaPago f WHERE f.codFormaPago = :codFormaPago"), @NamedQuery(name = "FormaPago.findByNombreFormaPago", query = "SELECT f FROM FormaPago f WHERE f.nombreFormaPago = :nombreFormaPago"), @NamedQuery(name = "FormaPago.findByUsuarioAlta", query = "SELECT f FROM FormaPago f WHERE f.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "FormaPago.findByUsuarioModif", query = "SELECT f FROM FormaPago f WHERE f.usuarioModif = :usuarioModif"), @NamedQuery(name = "FormaPago.findByFechaAlta", query = "SELECT f FROM FormaPago f WHERE f.fechaAlta = :fechaAlta"), @NamedQuery(name = "FormaPago.findByFechaModif", query = "SELECT f FROM FormaPago f WHERE f.fechaModif = :fechaModif")})
public class FormaPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_FORMA_PAGO")
    private Long codFormaPago;
    @Basic(optional = false)
    @Column(name = "NOMBRE_FORMA_PAGO")
    private String nombreFormaPago;
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
    @JoinColumn(name = "COD_BANCO", referencedColumnName = "COD_BANCO")
    @ManyToOne
    private Banco codBanco;
    @OneToMany(mappedBy = "codFormaPago")
    private List<MovimientoCajaDetalle> movimientoCajaDetalleCollection;

    public FormaPago() {
    }

    public FormaPago(Long codFormaPago) {
        this.codFormaPago = codFormaPago;
    }

    public FormaPago(Long codFormaPago, String nombreFormaPago) {
        this.codFormaPago = codFormaPago;
        this.nombreFormaPago = nombreFormaPago;
    }

    public Long getCodFormaPago() {
        return codFormaPago;
    }

    public void setCodFormaPago(Long codFormaPago) {
        this.codFormaPago = codFormaPago;
    }

    public String getNombreFormaPago() {
        return nombreFormaPago;
    }

    public void setNombreFormaPago(String nombreFormaPago) {
        this.nombreFormaPago = nombreFormaPago;
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

    public Banco getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(Banco codBanco) {
        this.codBanco = codBanco;
    }

    public List<MovimientoCajaDetalle> getMovimientoCajaDetalleCollection() {
        return movimientoCajaDetalleCollection;
    }

    public void setMovimientoCajaDetalleCollection(List<MovimientoCajaDetalle> movimientoCajaDetalleCollection) {
        this.movimientoCajaDetalleCollection = movimientoCajaDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFormaPago != null ? codFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.codFormaPago == null && other.codFormaPago != null) || (this.codFormaPago != null && !this.codFormaPago.equals(other.codFormaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.FormaPago[codFormaPago=" + codFormaPago + "]";
    }

}
