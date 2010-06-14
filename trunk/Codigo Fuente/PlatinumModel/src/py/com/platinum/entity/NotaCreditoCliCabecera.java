/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import py.com.platinum.listener.NotaCreditoClienteCabeceraListener;
import py.com.platinum.utils.StringUtils;
import py.com.platinum.utilsenum.NotaCreditoEstado;

/**
 *
 * @author Martin
 */
@Entity
@EntityListeners(value=NotaCreditoClienteCabeceraListener.class)
@SequenceGenerator(name="NC_CLIENTE__SEQUENCE", sequenceName="SQ_NOTA_CREDITO_CLIENTE")
@Table(name = "NOTA_CREDITO_CLI_CABECERA")
public class NotaCreditoCliCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="NC_CLIENTE__SEQUENCE")
    @Column(name = "COD_NOTA_CREDITO_CLIENTE")
    private Long codNotaCreditoCliente;
    @Basic(optional = false)
    @Column(name = "NUM_NOTA_CREDTO_CLIENTE")
    private BigInteger numNotaCredtoCliente;
    @Column(name = "TOTAL_NOTA_CREDITO")
    private BigInteger totalNotaCredito;
    @Column(name = "SUB_TOTAL")
    private BigInteger subTotal;
    @Column(name = "SALDO_FAC")
    private BigInteger saldoFac;
    @Column(name = "ESTADO")
    @Enumerated(EnumType.STRING)
    private NotaCreditoEstado estado;
    @Column(name = "ESTABLECIMIENTO")
    private String establecimiento;
    @Column(name = "BOCA_EXPENDIO")
    private String bocaExpendio;
    @JoinColumn(name = "COD_DEPOSITO", referencedColumnName = "COD_DEPOSITO", nullable=false)
    @ManyToOne(fetch=FetchType.EAGER)
    private Deposito codDeposito;
    @JoinColumn(name = "TIPO", referencedColumnName = "COD_TIPO", nullable=false)
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoComprobante tipoFactura;
    @Basic(optional = false)
    @Column(name = "FECHA_NOTA_CREDITO")
    @Temporal(TemporalType.DATE)
    private Date fechaNotaCredito;
    @Column(name = "TOTAL_IVA")
    private BigInteger totalIva;
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
    @OneToMany(mappedBy = "codNotaCreditoCliente", fetch=FetchType.EAGER)
    private Set<NotaCreditoCliDetalle> notaCreditoCliDetalle;
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "COD_FACTURA", referencedColumnName = "COD_FACTURA")
    @ManyToOne(optional = false)
    private FacturaCabecera codFactura;
//    @OneToMany(mappedBy = "codNotaCreditoCliente", fetch=FetchType.EAGER)
//    private Set<ReciboDetalle> reciboDetalle;

    public NotaCreditoCliCabecera() {
    }

    public NotaCreditoCliCabecera(Long codNotaCreditoCliente, BigInteger numNotaCredtoCliente, Date fechaNotaCredito) {
        this.codNotaCreditoCliente = codNotaCreditoCliente;
        this.numNotaCredtoCliente = numNotaCredtoCliente;
        this.fechaNotaCredito = fechaNotaCredito;
    }

    public Long getCodNotaCreditoCliente() {
        return codNotaCreditoCliente;
    }

    public void setCodNotaCreditoCliente(Long codNotaCreditoCliente) {
        this.codNotaCreditoCliente = codNotaCreditoCliente;
    }

    public BigInteger getNumNotaCredtoCliente() {
        return numNotaCredtoCliente;
    }

    public void setNumNotaCredtoCliente(BigInteger numNotaCredtoCliente) {
        this.numNotaCredtoCliente = numNotaCredtoCliente;
    }

    public BigInteger getTotalNotaCredito() {
        return totalNotaCredito;
    }

    public void setTotalNotaCredito(BigInteger totalNotaCredito) {
        this.totalNotaCredito = totalNotaCredito;
    }

    public Date getFechaNotaCredito() {
        return fechaNotaCredito;
    }

    public void setFechaNotaCredito(Date fechaNotaCredito) {
        this.fechaNotaCredito = fechaNotaCredito;
    }

    public BigInteger getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(BigInteger totalIva) {
        this.totalIva = totalIva;
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

    public Set<NotaCreditoCliDetalle> getNotaCreditoCliDetalle() {
        return notaCreditoCliDetalle;
    }

    public List<NotaCreditoCliDetalle> getNotaCreditoCliDetalleList() {
        return new ArrayList(Arrays.asList(notaCreditoCliDetalle.toArray(new NotaCreditoCliDetalle[0])));
    }

    public void setNotaCreditoCliDetalle(Set<NotaCreditoCliDetalle> notaCreditoCliDetalle) {
        this.notaCreditoCliDetalle = notaCreditoCliDetalle;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public FacturaCabecera getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(FacturaCabecera codFactura) {
        this.codFactura = codFactura;
    }

    //////////
//    public Set<ReciboDetalle> getReciboDetalle() {
//        return reciboDetalle;
//    }
//
//    public List<ReciboDetalle> getReciboDetalleList() {
//        return new ArrayList(Arrays.asList(reciboDetalle.toArray(new ReciboDetalle[0])));
//    }
//
//    public void setReciboDetalle(Set<ReciboDetalle> reciboDetalle) {
//        this.reciboDetalle = reciboDetalle;
//    }

    public String getBocaExpendio() {
        return bocaExpendio;
    }

    public void setBocaExpendio(String bocaExpendio) {
        this.bocaExpendio = bocaExpendio;
    }

    public Deposito getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(Deposito codDeposito) {
        this.codDeposito = codDeposito;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public NotaCreditoEstado getEstado() {
        return estado;
    }

    @Transient
    private String estadoString;

    public String getEstadoString() {
        estadoString = estado.toString();
        return estadoString;
    }

    @Transient
    private String nroFactura;

    public String getNroFactura() {
        nroFactura = "";
        
        if (codFactura != null) {
            nroFactura = codFactura.toString();
        }

        return nroFactura;
    }

//    public void setEstadoString(String x) {
//        estadoString = x;
//    }

    public void setEstado(NotaCreditoEstado estado) {
        this.estado = estado;
    }

    public BigInteger getSaldoFac() {
        return saldoFac;
    }

    public void setSaldoFac(BigInteger saldoFac) {
        this.saldoFac = saldoFac;
    }

    public BigInteger getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigInteger subTotal) {
        this.subTotal = subTotal;
    }

    public TipoComprobante getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(TipoComprobante tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public String getNumeroNota() {
        return StringUtils.lpad(numNotaCredtoCliente.toString(), 8, "0");
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNotaCreditoCliente != null ? codNotaCreditoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCreditoCliCabecera)) {
            return false;
        }
        NotaCreditoCliCabecera other = (NotaCreditoCliCabecera) object;
        if ((this.codNotaCreditoCliente == null && other.codNotaCreditoCliente != null) || (this.codNotaCreditoCliente != null && !this.codNotaCreditoCliente.equals(other.codNotaCreditoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.NotaCreditoCliCabecera[codNotaCreditoCliente=" + codNotaCreditoCliente + "]";
    }

}
