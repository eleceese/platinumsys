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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "HISTORICO_COSTO")
@SequenceGenerator(name="HISCOSTO_SEQUENCE", sequenceName="SQ_HISTORICO_COSTO", initialValue=1, allocationSize=1)
public class HistoricoCosto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_HISTORICO_COSTO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="HISCOSTO_SEQUENCE")
    private Long codHistoricoCosto;
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
    @Column(name = "COSTO_COMPRA")
    private BigInteger costoCompra;
    @Column(name = "COSTO_ACTUAL")
    private BigInteger costoActual;
    @Column(name = "EXISTENCIA_ACTUAL")
    private BigDecimal existenciaActual;
    @Column(name = "EXISTENCIA_COMPRA")
    private BigDecimal existenciaCompra;

    public HistoricoCosto() {
    }

    public HistoricoCosto(Long codHistoricoCosto) {
        this.codHistoricoCosto = codHistoricoCosto;
    }

    public HistoricoCosto(Long codHistoricoCosto, Date fecHistoricoCosto, BigInteger costoHistorico) {
        this.codHistoricoCosto = codHistoricoCosto;
        this.fecHistoricoCosto = fecHistoricoCosto;
        this.costoHistorico = costoHistorico;
    }

    public Long getCodHistoricoCosto() {
        return codHistoricoCosto;
    }

    public void setCodHistoricoCosto(Long codHistoricoCosto) {
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

    public BigInteger getCostoActual() {
        return costoActual;
    }

    public void setCostoActual(BigInteger costoActual) {
        this.costoActual = costoActual;
    }

    public BigInteger getCostoCompra() {
        return costoCompra;
    }

    public void setCostoCompra(BigInteger costoCompra) {
        this.costoCompra = costoCompra;
    }

    public BigDecimal getExistenciaActual() {
        return existenciaActual;
    }

    public void setExistenciaActual(BigDecimal existenciaActual) {
        this.existenciaActual = existenciaActual;
    }

    public BigDecimal getExistenciaCompra() {
        return existenciaCompra;
    }

    public void setExistenciaCompra(BigDecimal existenciaCompra) {
        this.existenciaCompra = existenciaCompra;
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
