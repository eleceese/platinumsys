/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
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
@Table(name = "SALDO_CLIENTE")
@SequenceGenerator(name = "SALDO_CLIENTE_SEQUENCE", sequenceName = "SQ_SALDO_CLIENTE", initialValue = 1, allocationSize = 1)
public class SaldoCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALDO_CLIENTE_SEQUENCE")
    @Column(name = "COD_SALDO_CLIENTE", nullable=false)
    private Long codSaldoCliente;
    @Column(name = "TIPO_COMPROBANTE", nullable=false)
    private Long tipoComprobante;
    @Column(name = "NRO_COMPROBANTE", nullable=false)
    private Long nroComprobante;
    @Column(name = "FECHA_COMPROBANTE")
    @Temporal(TemporalType.DATE)
    private Date fechaComprobante;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "SALDO")
    private Long saldo;
    @Column(name = "TOTAL")
    private Long total;
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
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente codCliente;

    public SaldoCliente() {
    }

    public SaldoCliente(Long codSaldoCliente) {
        this.codSaldoCliente = codSaldoCliente;
    }

    public Long getCodSaldoCliente() {
        return codSaldoCliente;
    }

    public void setCodSaldoCliente(Long codSaldoCliente) {
        this.codSaldoCliente = codSaldoCliente;
    }

    public Long getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(Long nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public Long getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(Long tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(Date fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSaldoCliente != null ? codSaldoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaldoCliente)) {
            return false;
        }
        SaldoCliente other = (SaldoCliente) object;
        if ((this.codSaldoCliente == null && other.codSaldoCliente != null) || (this.codSaldoCliente != null && !this.codSaldoCliente.equals(other.codSaldoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.SaldoCliente[codSaldoCliente=" + codSaldoCliente + "]";
    }

}
