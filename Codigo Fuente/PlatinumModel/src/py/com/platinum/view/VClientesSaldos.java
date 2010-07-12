/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.view;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
public class VClientesSaldos implements Serializable  {
    @Id
    @Column
    private BigInteger codSaldoCliente;
    @Column
    private BigInteger orden;
    @Column
    private String descTipoComprobante;
    @Column
    private String nroComprobante;
    @Column
    private BigInteger codComprobante;
    @Column
    private Integer nroCuota;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fecVencimiento;
    @Column
    private BigInteger totalComprobante;
    @Column
    private BigInteger saldoComprobante;

    

    public VClientesSaldos() {
    }

    public BigInteger getOrden() {
        return orden;
    }

    public void setOrden(BigInteger orden) {
        this.orden = orden;
    }

    public String getDescTipoComprobante() {
        return descTipoComprobante;
    }

    public void setDescTipoComprobante(String descTipoComprobante) {
        this.descTipoComprobante = descTipoComprobante;
    }

    public String getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(String nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public BigInteger getCodComprobante() {
        return codComprobante;
    }

    public void setCodComprobante(BigInteger codComprobante) {
        this.codComprobante = codComprobante;
    }

    public Integer getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(Integer nroCuota) {
        this.nroCuota = nroCuota;
    }

    public Date getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(Date fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    public BigInteger getTotalComprobante() {
        return totalComprobante;
    }

    public void setTotalComprobante(BigInteger totalComprobante) {
        this.totalComprobante = totalComprobante;
    }

    public BigInteger getSaldoComprobante() {
        return saldoComprobante;
    }

    public void setSaldoComprobante(BigInteger saldoComprobante) {
        this.saldoComprobante = saldoComprobante;
    }

    public BigInteger getCodSaldoCliente() {
        return codSaldoCliente;
    }

    public void setCodSaldoCliente(BigInteger codSaldoCliente) {
        this.codSaldoCliente = codSaldoCliente;
    }
    
}
