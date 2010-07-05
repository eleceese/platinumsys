/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
@Table(name = "RECIBO_DETALLE")
@SequenceGenerator(name="RECIBO_DET_SEQUENCE", sequenceName="SQ_DETALLE_RECIBO", initialValue=1, allocationSize=1)
public class ReciboDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RECIBO_DET_SEQUENCE")
    @Column(name = "COD_RECIBO_DET")
    private Long codReciboDet;
    @Column(name = "TIPO_COMPROBANTE")
    private Integer tipoComprobante;
    @Column(name = "NRO_COMPROBANTE")
    private Integer nroComprobante;
    @Column(name = "COMPROBANTE")
    private String comprobante;
    @Column(name = "NRO_CUOTA")
    private Integer nroCuota;
    @Column(name = "MONTO_CUOTA")
    private BigInteger montoCuota;
    @Column(name = "SALDO_CUOTA")
    private BigInteger saldoCuota;
    @Column(name = "MONTO_PAGO")
    private BigInteger montoPago;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
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
    @JoinColumn(name = "COD_RECIBO", referencedColumnName = "COD_RECIBO")
    @ManyToOne(optional = false)
    private ReciboCabecera codRecibo;

    public ReciboDetalle() {
    }

    public ReciboDetalle(Long codReciboDet) {
        this.codReciboDet = codReciboDet;
    }

    public Long getCodReciboDet() {
        return codReciboDet;
    }

    public void setCodReciboDet(Long codReciboDet) {
        this.codReciboDet = codReciboDet;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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

    public ReciboCabecera getCodRecibo() {
        return codRecibo;
    }

    public void setCodRecibo(ReciboCabecera codRecibo) {
        this.codRecibo = codRecibo;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public BigInteger getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(BigInteger montoCuota) {
        this.montoCuota = montoCuota;
    }

    public BigInteger getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(BigInteger montoPago) {
        this.montoPago = montoPago;
    }

    public Integer getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(Integer nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public Integer getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(Integer nroCuota) {
        this.nroCuota = nroCuota;
    }

    public BigInteger getSaldoCuota() {
        return saldoCuota;
    }

    public void setSaldoCuota(BigInteger saldoCuota) {
        this.saldoCuota = saldoCuota;
    }

    public Integer getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(Integer tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codReciboDet != null ? codReciboDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReciboDetalle)) {
            return false;
        }
        ReciboDetalle other = (ReciboDetalle) object;
        if ((this.codReciboDet == null && other.codReciboDet != null) || (this.codReciboDet != null && !this.codReciboDet.equals(other.codReciboDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.ReciboDetalle[codReciboDet=" + codReciboDet + "]";
    }

}
