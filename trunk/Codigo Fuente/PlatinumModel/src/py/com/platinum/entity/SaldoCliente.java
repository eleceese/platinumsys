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
@Table(name = "SALDO_CLIENTE")
@NamedQueries({@NamedQuery(name = "SaldoCliente.findAll", query = "SELECT s FROM SaldoCliente s"), @NamedQuery(name = "SaldoCliente.findByCodSaldoCliente", query = "SELECT s FROM SaldoCliente s WHERE s.codSaldoCliente = :codSaldoCliente"), @NamedQuery(name = "SaldoCliente.findByNumeroDocumento", query = "SELECT s FROM SaldoCliente s WHERE s.numeroDocumento = :numeroDocumento"), @NamedQuery(name = "SaldoCliente.findByTipoDocumento", query = "SELECT s FROM SaldoCliente s WHERE s.tipoDocumento = :tipoDocumento"), @NamedQuery(name = "SaldoCliente.findBySaldoCliente", query = "SELECT s FROM SaldoCliente s WHERE s.saldoCliente = :saldoCliente"), @NamedQuery(name = "SaldoCliente.findByTotal", query = "SELECT s FROM SaldoCliente s WHERE s.total = :total"), @NamedQuery(name = "SaldoCliente.findByUsuarioAlta", query = "SELECT s FROM SaldoCliente s WHERE s.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "SaldoCliente.findByUsuarioModif", query = "SELECT s FROM SaldoCliente s WHERE s.usuarioModif = :usuarioModif"), @NamedQuery(name = "SaldoCliente.findByFechaAlta", query = "SELECT s FROM SaldoCliente s WHERE s.fechaAlta = :fechaAlta"), @NamedQuery(name = "SaldoCliente.findByFechaModif", query = "SELECT s FROM SaldoCliente s WHERE s.fechaModif = :fechaModif")})
public class SaldoCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_SALDO_CLIENTE")
    private BigDecimal codSaldoCliente;
    @Basic(optional = false)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Column(name = "SALDO_CLIENTE")
    private BigInteger saldoCliente;
    @Column(name = "TOTAL")
    private BigInteger total;
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
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente codCliente;

    public SaldoCliente() {
    }

    public SaldoCliente(BigDecimal codSaldoCliente) {
        this.codSaldoCliente = codSaldoCliente;
    }

    public SaldoCliente(BigDecimal codSaldoCliente, String numeroDocumento, String tipoDocumento) {
        this.codSaldoCliente = codSaldoCliente;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
    }

    public BigDecimal getCodSaldoCliente() {
        return codSaldoCliente;
    }

    public void setCodSaldoCliente(BigDecimal codSaldoCliente) {
        this.codSaldoCliente = codSaldoCliente;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public BigInteger getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(BigInteger saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
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
