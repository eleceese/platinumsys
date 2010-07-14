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
@Table(name = "MOVIMIENTO_CAJA_DETALLE")
@SequenceGenerator(name="FC_SEQUENCE", sequenceName="SQ_DETALLE_MOVIMIENTO_CAJA", initialValue=1, allocationSize=1)
public class MovimientoCajaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_MOVIMIENTO_CAJA_DET")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FC_SEQUENCE")
    private Long codMovimientoCajaDet;
    @Column(name = "SERIE_CHEQUE")
    private String serieCheque;
    @Column(name = "NUMERO_CHEQUE")
    private String numeroCheque;
    @Column(name = "MONTO")
    private BigInteger monto;
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
    @JoinColumn(name = "COD_FORMA_PAGO", referencedColumnName = "COD_FORMA_PAGO")
    @ManyToOne
    private FormaPago codFormaPago;
    @JoinColumn(name = "COD_RECIBO_CAB", referencedColumnName = "COD_RECIBO")
    @ManyToOne(optional = false)
    private ReciboCabecera codRecibo;

    public MovimientoCajaDetalle() {
    }

    public MovimientoCajaDetalle(Long codMovimientoCajaDet) {
        this.codMovimientoCajaDet = codMovimientoCajaDet;
    }

    public Long getCodMovimientoCajaDet() {
        return codMovimientoCajaDet;
    }

    public void setCodMovimientoCajaDet(Long codMovimientoCajaDet) {
        this.codMovimientoCajaDet = codMovimientoCajaDet;
    }

    public String getSerieCheque() {
        return serieCheque;
    }

    public void setSerieCheque(String serieCheque) {
        this.serieCheque = serieCheque;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public BigInteger getMonto() {
        return monto;
    }

    public void setMonto(BigInteger monto) {
        this.monto = monto;
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

    public FormaPago getCodFormaPago() {
        return codFormaPago;
    }

    public void setCodFormaPago(FormaPago codFormaPago) {
        this.codFormaPago = codFormaPago;
    }

    public ReciboCabecera getCodRecibo() {
        return codRecibo;
    }

    public void setCodRecibo(ReciboCabecera codRecibo) {
        this.codRecibo = codRecibo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMovimientoCajaDet != null ? codMovimientoCajaDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoCajaDetalle)) {
            return false;
        }
        MovimientoCajaDetalle other = (MovimientoCajaDetalle) object;
        if ((this.codMovimientoCajaDet == null && other.codMovimientoCajaDet != null) || (this.codMovimientoCajaDet != null && !this.codMovimientoCajaDet.equals(other.codMovimientoCajaDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.MovimientoCajaDetalle[codMovimientoCajaDet=" + codMovimientoCajaDet + "]";
    }

}
