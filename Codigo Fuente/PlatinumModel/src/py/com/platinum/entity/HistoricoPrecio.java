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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "HISTORICO_PRECIO")
@SequenceGenerator(name="HISPRECIO_SEQUENCE", sequenceName="SQ_HISTORICO_PRECIO", initialValue=1, allocationSize=1)
public class HistoricoPrecio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_HISTORICO_PRECIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="HISPRECIO_SEQUENCE")
    private Long codHistoricoPrecio;
    @Basic(optional = false)
    @Column(name = "FEC_HISTORICO")
    @Temporal(TemporalType.DATE)
    private Date fecHistorico;
    @Column(name = "PRECIO_HISTORICO")
    private BigInteger precioHistorico;
    @Column(name = "USUARIO_ALTA")
    private String usuarioAlta;
    @Column(name = "USUARIO_MODIF")
    private String usuarioModif;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "FECHA_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModif;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;

    public HistoricoPrecio() {
    }

    public HistoricoPrecio(Long codHistoricoPrecio) {
        this.codHistoricoPrecio = codHistoricoPrecio;
    }

    public HistoricoPrecio(Long codHistoricoPrecio, Date fecHistorico) {
        this.codHistoricoPrecio = codHistoricoPrecio;
        this.fecHistorico = fecHistorico;
    }

    public Long getCodHistoricoPrecio() {
        return codHistoricoPrecio;
    }

    public void setCodHistoricoPrecio(Long codHistoricoPrecio) {
        this.codHistoricoPrecio = codHistoricoPrecio;
    }

    public Date getFecHistorico() {
        return fecHistorico;
    }

    public void setFecHistorico(Date fecHistorico) {
        this.fecHistorico = fecHistorico;
    }

    public BigInteger getPrecioHistorico() {
        return precioHistorico;
    }

    public void setPrecioHistorico(BigInteger precioHistorico) {
        this.precioHistorico = precioHistorico;
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
        hash += (codHistoricoPrecio != null ? codHistoricoPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoPrecio)) {
            return false;
        }
        HistoricoPrecio other = (HistoricoPrecio) object;
        if ((this.codHistoricoPrecio == null && other.codHistoricoPrecio != null) || (this.codHistoricoPrecio != null && !this.codHistoricoPrecio.equals(other.codHistoricoPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.HistoricoPrecio[codHistoricoPrecio=" + codHistoricoPrecio + "]";
    }

}
