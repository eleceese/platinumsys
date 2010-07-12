/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "COMISION_MENS_DET")
@SequenceGenerator(name="VENTA_COMISION_MENSUALDET_SEQUENCE", sequenceName="SQ_COMISION_MENS_DET")
public class ComisionMensDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="VENTA_COMISION_MENSUALDET_SEQUENCE")
    @Column(name = "COD_COM_MEN_DET")
    private Long codComMenDet;
    @Column(name = "DET_COM_PORC")
    private BigDecimal detComPorc;
    @Column(name = "DET_COM_MONTO_COMISION")
    private Long detComMontoComision;
    @Column(name = "DET_COM_MONTO_VENTA")
    private Long detComMontoVenta;
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
    @JoinColumn(name = "COD_COM_MEN_CAB", referencedColumnName = "COD_COM_MEN_CAB")
    @ManyToOne
    private ComisionMensCab codComMenCab;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne
    private Producto codProducto;

    public ComisionMensDet() {
    }

    public ComisionMensDet(Long codComMenDet) {
        this.codComMenDet = codComMenDet;
    }

    public Long getCodComMenDet() {
        return codComMenDet;
    }

    public void setCodComMenDet(Long codComMenDet) {
        this.codComMenDet = codComMenDet;
    }

    public BigDecimal getDetComPorc() {
        return detComPorc;
    }

    public void setDetComPorc(BigDecimal detComPorc) {
        this.detComPorc = detComPorc;
    }

    public Long getDetComMontoComision() {
        return detComMontoComision;
    }

    public void setDetComMontoComision(Long detComMontoComision) {
        this.detComMontoComision = detComMontoComision;
    }

    public Long getDetComMontoVenta() {
        return detComMontoVenta;
    }

    public void setDetComMontoVenta(Long detComMontoVenta) {
        this.detComMontoVenta = detComMontoVenta;
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

    public ComisionMensCab getCodComMenCab() {
        return codComMenCab;
    }

    public void setCodComMenCab(ComisionMensCab codComMenCab) {
        this.codComMenCab = codComMenCab;
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
        hash += (codComMenDet != null ? codComMenDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionMensDet)) {
            return false;
        }
        ComisionMensDet other = (ComisionMensDet) object;
        if ((this.codComMenDet == null && other.codComMenDet != null) || (this.codComMenDet != null && !this.codComMenDet.equals(other.codComMenDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.ComisionMensDet[codComMenDet=" + codComMenDet + "]";
    }

}
