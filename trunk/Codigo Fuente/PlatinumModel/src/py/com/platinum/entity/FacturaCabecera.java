/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
import py.com.platinum.listener.FacturaVentaCabeceraListener;
import py.com.platinum.utils.DateUtils;
import py.com.platinum.utils.StringUtils;
import py.com.platinum.utilsenum.FacturaVentaEstado;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "FACTURA_CABECERA")
@EntityListeners(value=FacturaVentaCabeceraListener.class)
@SequenceGenerator(name = "FACTURA_CABECERA_SEQUENCE", sequenceName = "SQ_CABECERA_FACTURA", initialValue = 1, allocationSize = 1)
public class FacturaCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACTURA_CABECERA_SEQUENCE")
    @Column(name = "COD_FACTURA", nullable=false)
    private Long codFactura;
    @Column(name = "NUMERO_FACTURA", nullable=false)
    private Long numeroFactura;
    @JoinColumn(name = "TIPO_FACTURA", referencedColumnName = "COD_TIPO", nullable=false)
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoComprobante tipoFactura;
    @Column(name = "FECHA_FACTURA", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "SUBTOTAL_FACTURA", nullable=false)
    private Long subtotalFactura;
    @Column(name = "TOTAL_IVA_FACTURA", nullable=false)
    private Long totalIvaFactura;
    @Column(name = "TOTAL_FACTURA", nullable=false)
    private Long totalFactura;
    @Column(name = "PORC_DESCUENTO")
    private Long porcDescuento;
    @Column(name = "MONTO_DESCUENTO")
    private Long montoDescuento;
    @Column(name = "ESTADO_FACTURA")
    @Enumerated(EnumType.STRING)
    private FacturaVentaEstado estadoFactura;
    @Column(name = "ESTABLECIMIENTO")
    private String establecimiento;
    @Column(name = "BOCA_EXPENDIO")
    private String bocaExpendio;
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
    @JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_CLIENTE", nullable=false)
    @ManyToOne(fetch=FetchType.EAGER)
    private Cliente codCliente;
    @JoinColumn(name = "COD_DEPOSITO", referencedColumnName = "COD_DEPOSITO", nullable=false)
    @ManyToOne(fetch=FetchType.EAGER)
    private Deposito codDeposito;
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO", nullable=false)
    @ManyToOne(fetch=FetchType.EAGER)
    private Empleado codEmpleado;
    @JoinColumn(name = "COD_PEDIDO", referencedColumnName = "COD_PEDIDO")
    @ManyToOne(fetch=FetchType.EAGER)
    private PedidoCabecera codPedido;
//    @OneToMany(mappedBy = "codFactura", fetch=FetchType.EAGER)
//    private Set<NotaCreditoCliCabecera> notaCreditoCliCabecera;
//    @OneToMany(mappedBy = "codFactura", fetch=FetchType.EAGER)
//    private Set<ReciboDetalle> reciboDetalle;
    @OneToMany(mappedBy = "codFactura", fetch=FetchType.EAGER)
    private Set<FacturaDetalle> facturaDetalle;

    public FacturaCabecera() {
    }

    public FacturaCabecera(Long codFactura) {
        this.codFactura = codFactura;
    }

    public FacturaCabecera(Long codFactura, Long numeroFactura, TipoComprobante tipoFactura, Date fechaFactura) {
        this.codFactura = codFactura;
        this.numeroFactura = numeroFactura;
        this.tipoFactura = tipoFactura;
        this.fechaFactura = fechaFactura;
    }

    public Long getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(Long codFactura) {
        this.codFactura = codFactura;
    }

    public String getNumeroFactura() {
        return StringUtils.lpad(numeroFactura.toString(), 8, "0");
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public TipoComprobante getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(TipoComprobante tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getSubtotalFactura() {
        return subtotalFactura;
    }

    public void setSubtotalFactura(Long subtotalFactura) {
        this.subtotalFactura = subtotalFactura;
    }

    public Long getTotalIvaFactura() {
        return totalIvaFactura;
    }

    public void setTotalIvaFactura(Long totalIvaFactura) {
        this.totalIvaFactura = totalIvaFactura;
    }

    public Long getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Long totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Long getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(Long montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public Long getPorcDescuento() {
        return porcDescuento;
    }

    public void setPorcDescuento(Long porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public FacturaVentaEstado getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(FacturaVentaEstado estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public String getBocaExpendio() {
        return bocaExpendio;
    }

    public void setBocaExpendio(String boca_expendio) {
        this.bocaExpendio = boca_expendio;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
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

    public Deposito getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(Deposito codDeposito) {
        this.codDeposito = codDeposito;
    }

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public PedidoCabecera getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(PedidoCabecera codPedido) {
        this.codPedido = codPedido;
    }
/////////
//    public Set<NotaCreditoCliCabecera> getNotaCreditoCliCabecera() {
//        return notaCreditoCliCabecera;
//    }
//
//    public List<NotaCreditoCliCabecera> getNotaCreditoCliCabeceraList() {
//        return new ArrayList(Arrays.asList(notaCreditoCliCabecera.toArray(new NotaCreditoCliCabecera[0])));
//    }
//
//    public void setNotaCreditoCliCabecera(Set<NotaCreditoCliCabecera> notaCreditoCliCabecera) {
//        this.notaCreditoCliCabecera = notaCreditoCliCabecera;
//    }
//
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

    //////////////////////

    public Set<FacturaDetalle> getFacturaDetalle() {
        return facturaDetalle;
    }

    public List<FacturaDetalle> getFacturaDetalleList() {
        return new ArrayList(Arrays.asList(facturaDetalle.toArray(new FacturaDetalle[0])));
    }

    public void setFacturaDetalle(Set<FacturaDetalle> facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFactura != null ? codFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCabecera)) {
            return false;
        }
        FacturaCabecera other = (FacturaCabecera) object;
        if ((this.codFactura == null && other.codFactura != null) || (this.codFactura != null && !this.codFactura.equals(other.codFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.establecimiento + "-" + this.bocaExpendio + "-" + StringUtils.lpad(numeroFactura.toString(), 8, "0");
    }

}
