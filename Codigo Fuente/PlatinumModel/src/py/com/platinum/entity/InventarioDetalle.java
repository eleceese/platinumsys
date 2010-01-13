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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "INVENTARIO_DETALLE")
@NamedQueries({@NamedQuery(name = "InventarioDetalle.findAll", query = "SELECT i FROM InventarioDetalle i"), @NamedQuery(name = "InventarioDetalle.findByCodInventarioDetalle", query = "SELECT i FROM InventarioDetalle i WHERE i.codInventarioDetalle = :codInventarioDetalle"), @NamedQuery(name = "InventarioDetalle.findByCantidadcontada", query = "SELECT i FROM InventarioDetalle i WHERE i.cantidadcontada = :cantidadcontada"), @NamedQuery(name = "InventarioDetalle.findByCantidadsistema", query = "SELECT i FROM InventarioDetalle i WHERE i.cantidadsistema = :cantidadsistema"), @NamedQuery(name = "InventarioDetalle.findByObservacion", query = "SELECT i FROM InventarioDetalle i WHERE i.observacion = :observacion"), @NamedQuery(name = "InventarioDetalle.findByEstado", query = "SELECT i FROM InventarioDetalle i WHERE i.estado = :estado"), @NamedQuery(name = "InventarioDetalle.findByUsuarioAlta", query = "SELECT i FROM InventarioDetalle i WHERE i.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "InventarioDetalle.findByUsuarioModif", query = "SELECT i FROM InventarioDetalle i WHERE i.usuarioModif = :usuarioModif"), @NamedQuery(name = "InventarioDetalle.findByFechaAlta", query = "SELECT i FROM InventarioDetalle i WHERE i.fechaAlta = :fechaAlta"), @NamedQuery(name = "InventarioDetalle.findByFechaModif", query = "SELECT i FROM InventarioDetalle i WHERE i.fechaModif = :fechaModif")})
public class InventarioDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_INVENTARIO_DETALLE")
    private BigDecimal codInventarioDetalle;
    @Column(name = "CANTIDADCONTADA")
    private BigInteger cantidadcontada;
    @Column(name = "CANTIDADSISTEMA")
    private BigInteger cantidadsistema;
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "ESTADO")
    private String estado;
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
    @JoinColumn(name = "COD_INVENTARIO", referencedColumnName = "COD_INVENTARIO")
    @ManyToOne(optional = false)
    private InventarioCabecera codInventario;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @OneToOne(optional = false)
    private Producto codProducto;

    public InventarioDetalle() {
    }

    public InventarioDetalle(BigDecimal codInventarioDetalle) {
        this.codInventarioDetalle = codInventarioDetalle;
    }

    public BigDecimal getCodInventarioDetalle() {
        return codInventarioDetalle;
    }

    public void setCodInventarioDetalle(BigDecimal codInventarioDetalle) {
        this.codInventarioDetalle = codInventarioDetalle;
    }

    public BigInteger getCantidadcontada() {
        return cantidadcontada;
    }

    public void setCantidadcontada(BigInteger cantidadcontada) {
        this.cantidadcontada = cantidadcontada;
    }

    public BigInteger getCantidadsistema() {
        return cantidadsistema;
    }

    public void setCantidadsistema(BigInteger cantidadsistema) {
        this.cantidadsistema = cantidadsistema;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public InventarioCabecera getCodInventario() {
        return codInventario;
    }

    public void setCodInventario(InventarioCabecera codInventario) {
        this.codInventario = codInventario;
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
        hash += (codInventarioDetalle != null ? codInventarioDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioDetalle)) {
            return false;
        }
        InventarioDetalle other = (InventarioDetalle) object;
        if ((this.codInventarioDetalle == null && other.codInventarioDetalle != null) || (this.codInventarioDetalle != null && !this.codInventarioDetalle.equals(other.codInventarioDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.InventarioDetalle[codInventarioDetalle=" + codInventarioDetalle + "]";
    }

}
