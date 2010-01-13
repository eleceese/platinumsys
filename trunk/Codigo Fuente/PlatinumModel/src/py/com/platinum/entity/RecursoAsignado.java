/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
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
@Table(name = "RECURSO_ASIGNADO")
@NamedQueries({@NamedQuery(name = "RecursoAsignado.findAll", query = "SELECT r FROM RecursoAsignado r"), @NamedQuery(name = "RecursoAsignado.findByCodRecurso", query = "SELECT r FROM RecursoAsignado r WHERE r.codRecurso = :codRecurso"), @NamedQuery(name = "RecursoAsignado.findByCantidad", query = "SELECT r FROM RecursoAsignado r WHERE r.cantidad = :cantidad"), @NamedQuery(name = "RecursoAsignado.findByCantidadReal", query = "SELECT r FROM RecursoAsignado r WHERE r.cantidadReal = :cantidadReal"), @NamedQuery(name = "RecursoAsignado.findByFecha", query = "SELECT r FROM RecursoAsignado r WHERE r.fecha = :fecha"), @NamedQuery(name = "RecursoAsignado.findByUsuarioAlta", query = "SELECT r FROM RecursoAsignado r WHERE r.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "RecursoAsignado.findByUsuarioModif", query = "SELECT r FROM RecursoAsignado r WHERE r.usuarioModif = :usuarioModif"), @NamedQuery(name = "RecursoAsignado.findByFechaAlta", query = "SELECT r FROM RecursoAsignado r WHERE r.fechaAlta = :fechaAlta"), @NamedQuery(name = "RecursoAsignado.findByFechaModif", query = "SELECT r FROM RecursoAsignado r WHERE r.fechaModif = :fechaModif")})
public class RecursoAsignado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_RECURSO")
    private Long codRecurso;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private long cantidad;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_REAL")
    private long cantidadReal;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
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
    @JoinColumn(name = "COD_ORDEN_TRAB_DET", referencedColumnName = "COD_ORDEN_TRABAJO_DET")
    @ManyToOne(optional = false)
    private OrdenTrabajoDetalle codOrdenTrabDet;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;

    public RecursoAsignado() {
    }

    public RecursoAsignado(Long codRecurso) {
        this.codRecurso = codRecurso;
    }

    public RecursoAsignado(Long codRecurso, long cantidad, long cantidadReal, Date fecha) {
        this.codRecurso = codRecurso;
        this.cantidad = cantidad;
        this.cantidadReal = cantidadReal;
        this.fecha = fecha;
    }

    public Long getCodRecurso() {
        return codRecurso;
    }

    public void setCodRecurso(Long codRecurso) {
        this.codRecurso = codRecurso;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getCantidadReal() {
        return cantidadReal;
    }

    public void setCantidadReal(long cantidadReal) {
        this.cantidadReal = cantidadReal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public OrdenTrabajoDetalle getCodOrdenTrabDet() {
        return codOrdenTrabDet;
    }

    public void setCodOrdenTrabDet(OrdenTrabajoDetalle codOrdenTrabDet) {
        this.codOrdenTrabDet = codOrdenTrabDet;
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
        hash += (codRecurso != null ? codRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursoAsignado)) {
            return false;
        }
        RecursoAsignado other = (RecursoAsignado) object;
        if ((this.codRecurso == null && other.codRecurso != null) || (this.codRecurso != null && !this.codRecurso.equals(other.codRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.RecursoAsignado[codRecurso=" + codRecurso + "]";
    }

}
