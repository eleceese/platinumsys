/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "ORDEN_TRABAJO")
@NamedQueries({@NamedQuery(name = "OrdenTrabajo.findAll", query = "SELECT o FROM OrdenTrabajo o"), @NamedQuery(name = "OrdenTrabajo.findByNumeroOrdenTrabajo", query = "SELECT o FROM OrdenTrabajo o WHERE o.numeroOrdenTrabajo = :numeroOrdenTrabajo"), @NamedQuery(name = "OrdenTrabajo.findByFechaOt", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaOt = :fechaOt"), @NamedQuery(name = "OrdenTrabajo.findByFechaInicialOt", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaInicialOt = :fechaInicialOt"), @NamedQuery(name = "OrdenTrabajo.findByFechaFinOt", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaFinOt = :fechaFinOt"), @NamedQuery(name = "OrdenTrabajo.findByCantidadOt", query = "SELECT o FROM OrdenTrabajo o WHERE o.cantidadOt = :cantidadOt"), @NamedQuery(name = "OrdenTrabajo.findByCantidadProducidaOt", query = "SELECT o FROM OrdenTrabajo o WHERE o.cantidadProducidaOt = :cantidadProducidaOt"), @NamedQuery(name = "OrdenTrabajo.findByEstadoOt", query = "SELECT o FROM OrdenTrabajo o WHERE o.estadoOt = :estadoOt"), @NamedQuery(name = "OrdenTrabajo.findByCostoEstimadoOt", query = "SELECT o FROM OrdenTrabajo o WHERE o.costoEstimadoOt = :costoEstimadoOt"), @NamedQuery(name = "OrdenTrabajo.findByCostoRealOt", query = "SELECT o FROM OrdenTrabajo o WHERE o.costoRealOt = :costoRealOt"), @NamedQuery(name = "OrdenTrabajo.findByPorcentajeTerminado", query = "SELECT o FROM OrdenTrabajo o WHERE o.porcentajeTerminado = :porcentajeTerminado"), @NamedQuery(name = "OrdenTrabajo.findByCodOrdenTrabjo", query = "SELECT o FROM OrdenTrabajo o WHERE o.codOrdenTrabjo = :codOrdenTrabjo"), @NamedQuery(name = "OrdenTrabajo.findByUsuarioAlta", query = "SELECT o FROM OrdenTrabajo o WHERE o.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "OrdenTrabajo.findByUsuarioModif", query = "SELECT o FROM OrdenTrabajo o WHERE o.usuarioModif = :usuarioModif"), @NamedQuery(name = "OrdenTrabajo.findByFechaAlta", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaAlta = :fechaAlta"), @NamedQuery(name = "OrdenTrabajo.findByFechaModif", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaModif = :fechaModif")})
public class OrdenTrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NUMERO_ORDEN_TRABAJO")
    private BigInteger numeroOrdenTrabajo;
    @Column(name = "FECHA_OT")
    @Temporal(TemporalType.DATE)
    private Date fechaOt;
    @Column(name = "FECHA_INICIAL_OT")
    @Temporal(TemporalType.DATE)
    private Date fechaInicialOt;
    @Column(name = "FECHA_FIN_OT")
    @Temporal(TemporalType.DATE)
    private Date fechaFinOt;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_OT")
    private BigInteger cantidadOt;
    @Column(name = "CANTIDAD_PRODUCIDA_OT")
    private BigInteger cantidadProducidaOt;
    @Column(name = "ESTADO_OT")
    private BigInteger estadoOt;
    @Column(name = "COSTO_ESTIMADO_OT")
    private BigInteger costoEstimadoOt;
    @Column(name = "COSTO_REAL_OT")
    private BigInteger costoRealOt;
    @Column(name = "PORCENTAJE_TERMINADO")
    private Long porcentajeTerminado;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_ORDEN_TRABJO")
    private Long codOrdenTrabjo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codOrdenTrabajo")
    private List<OrdenTrabajoDetalle> ordenTrabajoDetalleCollection;
    @OneToMany(mappedBy = "codOrdenTrabajo")
    private List<CostosFijos> costosFijosCollection;
    @JoinColumn(name = "COD_EMPLEADO1", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEmpleado1;
    @JoinColumn(name = "COD_EMPLEADO2", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEmpleado2;
    @JoinColumn(name = "COD_PRODUCTO_OT", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProductoOt;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(Long codOrdenTrabjo) {
        this.codOrdenTrabjo = codOrdenTrabjo;
    }

    public OrdenTrabajo(Long codOrdenTrabjo, BigInteger numeroOrdenTrabajo, BigInteger cantidadOt) {
        this.codOrdenTrabjo = codOrdenTrabjo;
        this.numeroOrdenTrabajo = numeroOrdenTrabajo;
        this.cantidadOt = cantidadOt;
    }

    public BigInteger getNumeroOrdenTrabajo() {
        return numeroOrdenTrabajo;
    }

    public void setNumeroOrdenTrabajo(BigInteger numeroOrdenTrabajo) {
        this.numeroOrdenTrabajo = numeroOrdenTrabajo;
    }

    public Date getFechaOt() {
        return fechaOt;
    }

    public void setFechaOt(Date fechaOt) {
        this.fechaOt = fechaOt;
    }

    public Date getFechaInicialOt() {
        return fechaInicialOt;
    }

    public void setFechaInicialOt(Date fechaInicialOt) {
        this.fechaInicialOt = fechaInicialOt;
    }

    public Date getFechaFinOt() {
        return fechaFinOt;
    }

    public void setFechaFinOt(Date fechaFinOt) {
        this.fechaFinOt = fechaFinOt;
    }

    public BigInteger getCantidadOt() {
        return cantidadOt;
    }

    public void setCantidadOt(BigInteger cantidadOt) {
        this.cantidadOt = cantidadOt;
    }

    public BigInteger getCantidadProducidaOt() {
        return cantidadProducidaOt;
    }

    public void setCantidadProducidaOt(BigInteger cantidadProducidaOt) {
        this.cantidadProducidaOt = cantidadProducidaOt;
    }

    public BigInteger getEstadoOt() {
        return estadoOt;
    }

    public void setEstadoOt(BigInteger estadoOt) {
        this.estadoOt = estadoOt;
    }

    public BigInteger getCostoEstimadoOt() {
        return costoEstimadoOt;
    }

    public void setCostoEstimadoOt(BigInteger costoEstimadoOt) {
        this.costoEstimadoOt = costoEstimadoOt;
    }

    public BigInteger getCostoRealOt() {
        return costoRealOt;
    }

    public void setCostoRealOt(BigInteger costoRealOt) {
        this.costoRealOt = costoRealOt;
    }

    public Long getPorcentajeTerminado() {
        return porcentajeTerminado;
    }

    public void setPorcentajeTerminado(Long porcentajeTerminado) {
        this.porcentajeTerminado = porcentajeTerminado;
    }

    public Long getCodOrdenTrabjo() {
        return codOrdenTrabjo;
    }

    public void setCodOrdenTrabjo(Long codOrdenTrabjo) {
        this.codOrdenTrabjo = codOrdenTrabjo;
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

    public List<OrdenTrabajoDetalle> getOrdenTrabajoDetalleCollection() {
        return ordenTrabajoDetalleCollection;
    }

    public void setOrdenTrabajoDetalleCollection(List<OrdenTrabajoDetalle> ordenTrabajoDetalleCollection) {
        this.ordenTrabajoDetalleCollection = ordenTrabajoDetalleCollection;
    }

    public List<CostosFijos> getCostosFijosCollection() {
        return costosFijosCollection;
    }

    public void setCostosFijosCollection(List<CostosFijos> costosFijosCollection) {
        this.costosFijosCollection = costosFijosCollection;
    }

    public Empleado getCodEmpleado1() {
        return codEmpleado1;
    }

    public void setCodEmpleado1(Empleado codEmpleado1) {
        this.codEmpleado1 = codEmpleado1;
    }

    public Empleado getCodEmpleado2() {
        return codEmpleado2;
    }

    public void setCodEmpleado2(Empleado codEmpleado2) {
        this.codEmpleado2 = codEmpleado2;
    }

    public Producto getCodProductoOt() {
        return codProductoOt;
    }

    public void setCodProductoOt(Producto codProductoOt) {
        this.codProductoOt = codProductoOt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOrdenTrabjo != null ? codOrdenTrabjo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajo)) {
            return false;
        }
        OrdenTrabajo other = (OrdenTrabajo) object;
        if ((this.codOrdenTrabjo == null && other.codOrdenTrabjo != null) || (this.codOrdenTrabjo != null && !this.codOrdenTrabjo.equals(other.codOrdenTrabjo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.OrdenTrabajo[codOrdenTrabjo=" + codOrdenTrabjo + "]";
    }

}
