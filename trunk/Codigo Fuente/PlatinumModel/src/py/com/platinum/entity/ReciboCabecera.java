/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "RECIBO_CABECERA")
public class ReciboCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_RECIBO")
    private BigDecimal codRecibo;
    @Basic(optional = false)
    @Column(name = "NUMERO_RECIBO")
    private BigInteger numeroRecibo;
    @Column(name = "MONTO_TOTAL")
    private BigInteger montoTotal;
    @Column(name = "MONTO_NOTA_CREDITO")
    private BigInteger montoNotaCredito;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "SERIE_RECIBO")
    private String serieRecibo;
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
    @OneToMany(mappedBy = "codRecibo", fetch=FetchType.EAGER)
    private Set<MovimientoCajaCabecera> movimientoCajaCabecera;
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @OneToMany(mappedBy = "codRecibo", fetch=FetchType.EAGER)
    private Set<ReciboDetalle> reciboDetalle;

    public ReciboCabecera() {
    }

    public ReciboCabecera(BigDecimal codRecibo) {
        this.codRecibo = codRecibo;
    }

    public ReciboCabecera(BigDecimal codRecibo, BigInteger numeroRecibo) {
        this.codRecibo = codRecibo;
        this.numeroRecibo = numeroRecibo;
    }

    public BigDecimal getCodRecibo() {
        return codRecibo;
    }

    public void setCodRecibo(BigDecimal codRecibo) {
        this.codRecibo = codRecibo;
    }

    public BigInteger getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(BigInteger numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public BigInteger getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigInteger montoTotal) {
        this.montoTotal = montoTotal;
    }

    public BigInteger getMontoNotaCredito() {
        return montoNotaCredito;
    }

    public void setMontoNotaCredito(BigInteger montoNotaCredito) {
        this.montoNotaCredito = montoNotaCredito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSerieRecibo() {
        return serieRecibo;
    }

    public void setSerieRecibo(String serieRecibo) {
        this.serieRecibo = serieRecibo;
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

    public Set<MovimientoCajaCabecera> getMovimientoCajaCabecera() {
        return movimientoCajaCabecera;
    }

    public List<MovimientoCajaCabecera> getMovimientoCajaCabeceraList() {
        return new ArrayList(Arrays.asList(movimientoCajaCabecera.toArray(new MovimientoCajaCabecera[0])));
    }

    public void setMovimientoCajaCabecera(Set<MovimientoCajaCabecera> movimientoCajaCabecera) {
        this.movimientoCajaCabecera = movimientoCajaCabecera;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public Set<ReciboDetalle> getReciboDetalle() {
        return reciboDetalle;
    }

    public List<ReciboDetalle> getReciboDetalleList() {
        return new ArrayList(Arrays.asList(reciboDetalle.toArray(new ReciboDetalle[0])));
    }

    public void setReciboDetalle(Set<ReciboDetalle> reciboDetalle) {
        this.reciboDetalle = reciboDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRecibo != null ? codRecibo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReciboCabecera)) {
            return false;
        }
        ReciboCabecera other = (ReciboCabecera) object;
        if ((this.codRecibo == null && other.codRecibo != null) || (this.codRecibo != null && !this.codRecibo.equals(other.codRecibo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.ReciboCabecera[codRecibo=" + codRecibo + "]";
    }

}
