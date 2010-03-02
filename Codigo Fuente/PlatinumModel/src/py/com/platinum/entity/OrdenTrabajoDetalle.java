/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@SequenceGenerator(name="OT_DET_SEQUENCE", sequenceName="SQ_OT_DETALLE", initialValue=1000, allocationSize=1)
@Table(name = "ORDEN_TRABAJO_DETALLE")
public class OrdenTrabajoDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OT_DET_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_ORDEN_TRABAJO_DET")
    private Long codOrdenTrabajoDet;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private long cantidad;
    @Column(name = "CANTIDAD_REAL")
    private Long cantidadReal;
    @Column(name = "COSTO_ESTIMADO")
    private Long costoEstimado;
    @Column(name = "COSTO_REAL")
    private Long costoReal;
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
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEmpleado;
    @JoinColumn(name = "COD_ORDEN_TRABAJO", referencedColumnName = "COD_ORDEN_TRABJO")
    @ManyToOne(optional = false)
    private OrdenTrabajo codOrdenTrabajo;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne
    private Producto codProducto;
    @OneToMany(mappedBy = "codOrdenTrabDet",fetch=FetchType.EAGER)
    private Set<RecursoAsignado> recursoAsignadoCollection;
    @OneToMany(mappedBy = "codDetOrdenTrabaj",fetch=FetchType.EAGER)
    private Set<TareaAsignada> tareaAsignadaCollection;

    public OrdenTrabajoDetalle() {
    }

    public OrdenTrabajoDetalle(Long codOrdenTrabajoDet) {
        this.codOrdenTrabajoDet = codOrdenTrabajoDet;
    }

    public OrdenTrabajoDetalle(Long codOrdenTrabajoDet, long cantidad) {
        this.codOrdenTrabajoDet = codOrdenTrabajoDet;
        this.cantidad = cantidad;
    }

    public Long getCodOrdenTrabajoDet() {
        return codOrdenTrabajoDet;
    }

    public void setCodOrdenTrabajoDet(Long codOrdenTrabajoDet) {
        this.codOrdenTrabajoDet = codOrdenTrabajoDet;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getCantidadReal() {
        return cantidadReal;
    }

    public void setCantidadReal(Long cantidadReal) {
        this.cantidadReal = cantidadReal;
    }

    public Long getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(Long costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    public Long getCostoReal() {
        return costoReal;
    }

    public void setCostoReal(Long costoReal) {
        this.costoReal = costoReal;
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

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public OrdenTrabajo getCodOrdenTrabajo() {
        return codOrdenTrabajo;
    }

    public void setCodOrdenTrabajo(OrdenTrabajo codOrdenTrabajo) {
        this.codOrdenTrabajo = codOrdenTrabajo;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public Set<RecursoAsignado> getRecursoAsignadoCollection() {
        return recursoAsignadoCollection;
    }

    public List<RecursoAsignado> getRecursoAsignadoListList() {

       return new ArrayList(Arrays.asList(recursoAsignadoCollection.toArray(new RecursoAsignado[0])));

    }

    public void setRecursoAsignadoCollection(Set<RecursoAsignado> recursoAsignadoCollection) {
        this.recursoAsignadoCollection = recursoAsignadoCollection;
    }

    public void setRecursoAsignadoCollectionFromList(List<RecursoAsignado> recursoAsignadoList) {
        
        this.recursoAsignadoCollection = new HashSet(recursoAsignadoList);
        
        
    }




    public Set<TareaAsignada> getTareaAsignadaCollection() {
        return tareaAsignadaCollection;
    }

    public List<TareaAsignada> getTareaAsignadaListList() {
       return new ArrayList(Arrays.asList(tareaAsignadaCollection.toArray(new TareaAsignada[0])));
}

    public void setTareaAsignadaCollection(Set<TareaAsignada> tareaAsignadaCollection) {
        this.tareaAsignadaCollection = tareaAsignadaCollection;
    }


    public void setTareaAsignadaCollectionFromList(List<TareaAsignada> tareaAsignadaList) {
        this.tareaAsignadaCollection = new HashSet<TareaAsignada>(tareaAsignadaList);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOrdenTrabajoDet != null ? codOrdenTrabajoDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoDetalle)) {
            return false;
        }
        OrdenTrabajoDetalle other = (OrdenTrabajoDetalle) object;
        if ((this.codOrdenTrabajoDet == null && other.codOrdenTrabajoDet != null) || (this.codOrdenTrabajoDet != null && !this.codOrdenTrabajoDet.equals(other.codOrdenTrabajoDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.OrdenTrabajoDetalle[codOrdenTrabajoDet=" + codOrdenTrabajoDet + "]";
    }

}
