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
@Table(name = "NOTA_CREDITO_CLI_CABECERA")
public class NotaCreditoCliCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_NOTA_CREDITO_CLIENTE")
    private BigDecimal codNotaCreditoCliente;
    @Basic(optional = false)
    @Column(name = "NUM_NOTA_CREDTO_CLIENTE")
    private BigInteger numNotaCredtoCliente;
    @Column(name = "TOTAL_NOTA_CREDITO")
    private BigInteger totalNotaCredito;
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
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEmpleado;
    @JoinColumn(name = "COD_FACTURA", referencedColumnName = "COD_FACTURA")
    @ManyToOne(optional = false)
    private FacturaCabecera codFactura;
//    @OneToMany(mappedBy = "codNotaCreditoCliente", fetch=FetchType.EAGER)
//    private Set<ReciboDetalle> reciboDetalle;

    public NotaCreditoCliCabecera() {
    }

    public NotaCreditoCliCabecera(BigDecimal codNotaCreditoCliente) {
        this.codNotaCreditoCliente = codNotaCreditoCliente;
    }

    public NotaCreditoCliCabecera(BigDecimal codNotaCreditoCliente, BigInteger numNotaCredtoCliente, Date fechaNotaCredito) {
        this.codNotaCreditoCliente = codNotaCreditoCliente;
        this.numNotaCredtoCliente = numNotaCredtoCliente;
        this.fechaNotaCredito = fechaNotaCredito;
    }

    public BigDecimal getCodNotaCreditoCliente() {
        return codNotaCreditoCliente;
    }

    public void setCodNotaCreditoCliente(BigDecimal codNotaCreditoCliente) {
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

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
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
