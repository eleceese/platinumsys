/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "SOLICITUD_INTERNA")
@NamedQueries({@NamedQuery(name = "SolicitudInterna.findAll", query = "SELECT s FROM SolicitudInterna s"), @NamedQuery(name = "SolicitudInterna.findByCodSolicitud", query = "SELECT s FROM SolicitudInterna s WHERE s.codSolicitud = :codSolicitud"), @NamedQuery(name = "SolicitudInterna.findByFecha", query = "SELECT s FROM SolicitudInterna s WHERE s.fecha = :fecha"), @NamedQuery(name = "SolicitudInterna.findByEstado", query = "SELECT s FROM SolicitudInterna s WHERE s.estado = :estado"), @NamedQuery(name = "SolicitudInterna.findByCantidad", query = "SELECT s FROM SolicitudInterna s WHERE s.cantidad = :cantidad"), @NamedQuery(name = "SolicitudInterna.findByCantidadAprobada", query = "SELECT s FROM SolicitudInterna s WHERE s.cantidadAprobada = :cantidadAprobada"), @NamedQuery(name = "SolicitudInterna.findByCantidadCompra", query = "SELECT s FROM SolicitudInterna s WHERE s.cantidadCompra = :cantidadCompra"), @NamedQuery(name = "SolicitudInterna.findByObservacion", query = "SELECT s FROM SolicitudInterna s WHERE s.observacion = :observacion"), @NamedQuery(name = "SolicitudInterna.findByUsuarioAlta", query = "SELECT s FROM SolicitudInterna s WHERE s.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "SolicitudInterna.findByUsuarioModif", query = "SELECT s FROM SolicitudInterna s WHERE s.usuarioModif = :usuarioModif"), @NamedQuery(name = "SolicitudInterna.findByFechaAlta", query = "SELECT s FROM SolicitudInterna s WHERE s.fechaAlta = :fechaAlta"), @NamedQuery(name = "SolicitudInterna.findByFechaModif", query = "SELECT s FROM SolicitudInterna s WHERE s.fechaModif = :fechaModif")})
public class SolicitudInterna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_SOLICITUD")
    private Long codSolicitud;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private long cantidad;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_APROBADA")
    private long cantidadAprobada;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_COMPRA")
    private long cantidadCompra;
    @Basic(optional = false)
    @Column(name = "OBSERVACION")
    private String observacion;
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
    @OneToMany(mappedBy = "codSolicitud")
    private List<EntradaSalidaCabecera> entradaSalidaCabeceraCollection;
    @OneToMany(mappedBy = "nroSolicitud")
    private List<FacturaCompraCab> facturaCompraCabCollection;
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEmpleado;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;

    public SolicitudInterna() {
    }

    public SolicitudInterna(Long codSolicitud) {
        this.codSolicitud = codSolicitud;
    }

    public SolicitudInterna(Long codSolicitud, Date fecha, String estado, long cantidad, long cantidadAprobada, long cantidadCompra, String observacion) {
        this.codSolicitud = codSolicitud;
        this.fecha = fecha;
        this.estado = estado;
        this.cantidad = cantidad;
        this.cantidadAprobada = cantidadAprobada;
        this.cantidadCompra = cantidadCompra;
        this.observacion = observacion;
    }

    public Long getCodSolicitud() {
        return codSolicitud;
    }

    public void setCodSolicitud(Long codSolicitud) {
        this.codSolicitud = codSolicitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getCantidadAprobada() {
        return cantidadAprobada;
    }

    public void setCantidadAprobada(long cantidadAprobada) {
        this.cantidadAprobada = cantidadAprobada;
    }

    public long getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(long cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public List<EntradaSalidaCabecera> getEntradaSalidaCabeceraCollection() {
        return entradaSalidaCabeceraCollection;
    }

    public void setEntradaSalidaCabeceraCollection(List<EntradaSalidaCabecera> entradaSalidaCabeceraCollection) {
        this.entradaSalidaCabeceraCollection = entradaSalidaCabeceraCollection;
    }

    public List<FacturaCompraCab> getFacturaCompraCabCollection() {
        return facturaCompraCabCollection;
    }

    public void setFacturaCompraCabCollection(List<FacturaCompraCab> facturaCompraCabCollection) {
        this.facturaCompraCabCollection = facturaCompraCabCollection;
    }

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
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
        hash += (codSolicitud != null ? codSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudInterna)) {
            return false;
        }
        SolicitudInterna other = (SolicitudInterna) object;
        if ((this.codSolicitud == null && other.codSolicitud != null) || (this.codSolicitud != null && !this.codSolicitud.equals(other.codSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.SolicitudInterna[codSolicitud=" + codSolicitud + "]";
    }

}
