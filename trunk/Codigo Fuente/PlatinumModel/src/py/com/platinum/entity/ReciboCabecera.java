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
import py.com.platinum.utils.StringUtils;
import py.com.platinum.utilsenum.ReciboEstado;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "RECIBO_CABECERA")
@SequenceGenerator(name="RECIBO_CAB_SEQUENCE", sequenceName="SQ_CABECERA_RECIBO", initialValue=1, allocationSize=1)
public class ReciboCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RECIBO_CAB_SEQUENCE")
    @Column(name = "COD_RECIBO")
    private Long codRecibo;
    @Basic(optional = false)
    @Column(name = "NUMERO_RECIBO")
    private BigInteger numeroRecibo;
    @Column(name = "MONTO_TOTAL")
    private BigInteger montoTotal;
    @Column(name = "ESTADO")
    @Enumerated(EnumType.STRING)
    private ReciboEstado estado;
    @Column(name = "SERIE_RECIBO")
    private String serieRecibo;
    @Column(name = "USUARIO_ALTA")
    private String usuarioAlta;
    @Column(name = "USUARIO_MODIF")
    private String usuarioModif;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "FECHA_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModif;
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @OneToMany(mappedBy = "codRecibo", fetch=FetchType.EAGER)
    private Set<ReciboDetalle> reciboDetalle;

    public ReciboCabecera() {
    }

    public ReciboCabecera(Long codRecibo) {
        this.codRecibo = codRecibo;
    }

    public ReciboCabecera(Long codRecibo, BigInteger numeroRecibo) {
        this.codRecibo = codRecibo;
        this.numeroRecibo = numeroRecibo;
    }

    public Long getCodRecibo() {
        return codRecibo;
    }

    public void setCodRecibo(Long codRecibo) {
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
    
    public ReciboEstado getEstado() {
        return estado;
    }

    public void setEstado(ReciboEstado estado) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getNumero() {
        return StringUtils.lpad(numeroRecibo.toString(), 8, "0");
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
