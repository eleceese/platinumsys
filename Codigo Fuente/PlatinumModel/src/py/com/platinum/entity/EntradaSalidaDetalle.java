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
@Table(name = "ENTRADA_SALIDA_DETALLE")
@NamedQueries({@NamedQuery(name = "EntradaSalidaDetalle.findAll", query = "SELECT e FROM EntradaSalidaDetalle e"), @NamedQuery(name = "EntradaSalidaDetalle.findByCodEntSalDetalle", query = "SELECT e FROM EntradaSalidaDetalle e WHERE e.codEntSalDetalle = :codEntSalDetalle"), @NamedQuery(name = "EntradaSalidaDetalle.findByCantidadEntSal", query = "SELECT e FROM EntradaSalidaDetalle e WHERE e.cantidadEntSal = :cantidadEntSal"), @NamedQuery(name = "EntradaSalidaDetalle.findByObservacion", query = "SELECT e FROM EntradaSalidaDetalle e WHERE e.observacion = :observacion"), @NamedQuery(name = "EntradaSalidaDetalle.findByEstadoDetalleEntSal", query = "SELECT e FROM EntradaSalidaDetalle e WHERE e.estadoDetalleEntSal = :estadoDetalleEntSal"), @NamedQuery(name = "EntradaSalidaDetalle.findByTipoEntradaSalida", query = "SELECT e FROM EntradaSalidaDetalle e WHERE e.tipoEntradaSalida = :tipoEntradaSalida"), @NamedQuery(name = "EntradaSalidaDetalle.findByUsuarioAlta", query = "SELECT e FROM EntradaSalidaDetalle e WHERE e.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "EntradaSalidaDetalle.findByUsuarioModif", query = "SELECT e FROM EntradaSalidaDetalle e WHERE e.usuarioModif = :usuarioModif"), @NamedQuery(name = "EntradaSalidaDetalle.findByFechaAlta", query = "SELECT e FROM EntradaSalidaDetalle e WHERE e.fechaAlta = :fechaAlta"), @NamedQuery(name = "EntradaSalidaDetalle.findByFechaModif", query = "SELECT e FROM EntradaSalidaDetalle e WHERE e.fechaModif = :fechaModif")})
public class EntradaSalidaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_ENT_SAL_DETALLE")
    private BigDecimal codEntSalDetalle;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_ENT_SAL")
    private BigInteger cantidadEntSal;
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "ESTADO_DETALLE_ENT_SAL")
    private String estadoDetalleEntSal;
    @Basic(optional = false)
    @Column(name = "TIPO_ENTRADA_SALIDA")
    private String tipoEntradaSalida;
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
    @JoinColumn(name = "COD_ENTRADA_SALIDA", referencedColumnName = "COD_ENTRADA_SALIDA")
    @ManyToOne(optional = false)
    private EntradaSalidaCabecera codEntradaSalida;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;

    public EntradaSalidaDetalle() {
    }

    public EntradaSalidaDetalle(BigDecimal codEntSalDetalle) {
        this.codEntSalDetalle = codEntSalDetalle;
    }

    public EntradaSalidaDetalle(BigDecimal codEntSalDetalle, BigInteger cantidadEntSal, String tipoEntradaSalida) {
        this.codEntSalDetalle = codEntSalDetalle;
        this.cantidadEntSal = cantidadEntSal;
        this.tipoEntradaSalida = tipoEntradaSalida;
    }

    public BigDecimal getCodEntSalDetalle() {
        return codEntSalDetalle;
    }

    public void setCodEntSalDetalle(BigDecimal codEntSalDetalle) {
        this.codEntSalDetalle = codEntSalDetalle;
    }

    public BigInteger getCantidadEntSal() {
        return cantidadEntSal;
    }

    public void setCantidadEntSal(BigInteger cantidadEntSal) {
        this.cantidadEntSal = cantidadEntSal;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstadoDetalleEntSal() {
        return estadoDetalleEntSal;
    }

    public void setEstadoDetalleEntSal(String estadoDetalleEntSal) {
        this.estadoDetalleEntSal = estadoDetalleEntSal;
    }

    public String getTipoEntradaSalida() {
        return tipoEntradaSalida;
    }

    public void setTipoEntradaSalida(String tipoEntradaSalida) {
        this.tipoEntradaSalida = tipoEntradaSalida;
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

    public EntradaSalidaCabecera getCodEntradaSalida() {
        return codEntradaSalida;
    }

    public void setCodEntradaSalida(EntradaSalidaCabecera codEntradaSalida) {
        this.codEntradaSalida = codEntradaSalida;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEntSalDetalle != null ? codEntSalDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaSalidaDetalle)) {
            return false;
        }
        EntradaSalidaDetalle other = (EntradaSalidaDetalle) object;
        if ((this.codEntSalDetalle == null && other.codEntSalDetalle != null) || (this.codEntSalDetalle != null && !this.codEntSalDetalle.equals(other.codEntSalDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.EntradaSalidaDetalle[codEntSalDetalle=" + codEntSalDetalle + "]";
    }

}
