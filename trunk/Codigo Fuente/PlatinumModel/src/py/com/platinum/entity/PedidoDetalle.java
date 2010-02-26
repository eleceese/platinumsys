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
@Table(name = "PEDIDO_DETALLE")
@SequenceGenerator(name="PEDIDO_DETALLE_SEQUENCE", sequenceName="SQ_DETALLE_PEDIDO", initialValue=1, allocationSize=1)
public class PedidoDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PEDIDO_DETALLE_SEQUENCE")
    @Column(name = "COD_PEDIDO_DETALLE")
    private Long codPedidoDetalle;
    @Column(name = "PRECIO_UNITARIO")
    private Long precioUnitario;
    @Column(name = "CANTIDAD_PEDIDA")
    private Long cantidadPedida;
    @Column(name = "CANTIDAD_ENTREGADA")
    private Long cantidadEntregada;
    @Column(name = "PORC_IVA")
    private Double porcIva;
    @Column(name = "MONTO_IVA")
    private Long montoIva;
    @Column(name = "TOTAL")
    private Long total;
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
    @JoinColumn(name = "COD_PEDIDO", referencedColumnName = "COD_PEDIDO")
    @ManyToOne
    private PedidoCabecera codPedidoCab;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne
    private Producto codProducto;

    public PedidoDetalle() {
    }

    public PedidoDetalle(Long codPedidoDetalle) {
        this.codPedidoDetalle = codPedidoDetalle;
    }

    public Long getCodPedidoDetalle() {
        return codPedidoDetalle;
    }

    public void setCodPedidoDetalle(Long codPedidoDetalle) {
        this.codPedidoDetalle = codPedidoDetalle;
    }

    public Long getCantidadPedida() {
        return cantidadPedida;
    }

    public void setCantidadPedida(Long cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }

    public Long getCantidadEntregada() {
        return cantidadEntregada;
    }

    public void setCantidadEntregada(Long cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    public Long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
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

    public PedidoCabecera getCodPedido() {
        return codPedidoCab;
    }

    public void setCodPedido(PedidoCabecera codPedidoCab) {
        this.codPedidoCab = codPedidoCab;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public Long getMontoIva() {
        return montoIva;
    }

    public void setMontoIva(Long montoIva) {
        this.montoIva = montoIva;
    }

    public Double getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(Double porcIva) {
        this.porcIva = porcIva;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPedidoDetalle != null ? codPedidoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoDetalle)) {
            return false;
        }
        PedidoDetalle other = (PedidoDetalle) object;
        if ((this.codPedidoDetalle == null && other.codPedidoDetalle != null) || (this.codPedidoDetalle != null && !this.codPedidoDetalle.equals(other.codPedidoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  codPedidoDetalle.toString();
    }

}
