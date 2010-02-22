/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
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
    @OneToMany(mappedBy = "codSolicitud", fetch=FetchType.EAGER)
    private Set<EntradaSalidaCabecera> entradaSalidaCabecera;
    @OneToMany(mappedBy = "nroSolicitud", fetch=FetchType.EAGER)
    private Set<FacturaCompraDet> facturaCompraDet;
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

    public Set<EntradaSalidaCabecera> getEntradaSalidaCabecera() {
        return entradaSalidaCabecera;
    }

    public void setEntradaSalidaCabecera(Set<EntradaSalidaCabecera> entradaSalidaCabecera) {
        this.entradaSalidaCabecera = entradaSalidaCabecera;
    }

    public Set<FacturaCompraDet> getFacturaCompraDet() {
        return facturaCompraDet;
    }

    public void setFacturaCompraDet(Set<FacturaCompraDet> facturaCompraDet) {
        this.facturaCompraDet = facturaCompraDet;
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
