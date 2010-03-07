/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@SequenceGenerator(name="TAREA_ASIGNADA_SEQUENCE", sequenceName="SQ_TAREA_ASIGNADA", initialValue=1, allocationSize=1)
@Table(name = "TAREA_ASIGNADA")
@NamedQueries({@NamedQuery(name = "TareaAsignada.findAll", query = "SELECT t FROM TareaAsignada t"), @NamedQuery(name = "TareaAsignada.findByCodTareaAsignada", query = "SELECT t FROM TareaAsignada t WHERE t.codTareaAsignada = :codTareaAsignada"), @NamedQuery(name = "TareaAsignada.findByOrdenTarea", query = "SELECT t FROM TareaAsignada t WHERE t.ordenTarea = :ordenTarea"), @NamedQuery(name = "TareaAsignada.findByCantidad", query = "SELECT t FROM TareaAsignada t WHERE t.cantidad = :cantidad"), @NamedQuery(name = "TareaAsignada.findByCantidadReal", query = "SELECT t FROM TareaAsignada t WHERE t.cantidadReal = :cantidadReal"), @NamedQuery(name = "TareaAsignada.findByObservacion", query = "SELECT t FROM TareaAsignada t WHERE t.observacion = :observacion"), @NamedQuery(name = "TareaAsignada.findByUsuarioAlta", query = "SELECT t FROM TareaAsignada t WHERE t.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "TareaAsignada.findByUsuarioModif", query = "SELECT t FROM TareaAsignada t WHERE t.usuarioModif = :usuarioModif"), @NamedQuery(name = "TareaAsignada.findByFechaAlta", query = "SELECT t FROM TareaAsignada t WHERE t.fechaAlta = :fechaAlta"), @NamedQuery(name = "TareaAsignada.findByFechaModif", query = "SELECT t FROM TareaAsignada t WHERE t.fechaModif = :fechaModif")})
public class TareaAsignada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TAREA_ASIGNADA_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_TAREA_ASIGNADA")
    private Long codTareaAsignada;
    @Column(name = "ORDEN_TAREA")
    private Long ordenTarea;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private long cantidad;
    @Column(name = "CANTIDAD_REAL")
    private Long cantidadReal;
    @Column(name = "TAREA_FIN")
    private String tareaFin;
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
    @OneToMany(mappedBy = "codTareaAsignada")
    private List<ProduccionDiaria> produccionDiariaCollection;
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne
    private Empleado codEmpleado;
    @JoinColumn(name = "COD_DET_ORDEN_TRABAJ", referencedColumnName = "COD_ORDEN_TRABAJO_DET")
    @ManyToOne
    private OrdenTrabajoDetalle codDetOrdenTrabaj;
    @JoinColumn(name = "COD_TAREA", referencedColumnName = "COD_TAREA")
    @ManyToOne(optional = false)
    private Tarea codTarea;

    public String getTareaFin() {
        return tareaFin;
    }

    public void setTareaFin(String tareaFin) {
        this.tareaFin = tareaFin;
    }



    public TareaAsignada() {
    }

    public TareaAsignada(Long codTareaAsignada) {
        this.codTareaAsignada = codTareaAsignada;
    }

    public TareaAsignada(Long codTareaAsignada, long cantidad) {
        this.codTareaAsignada = codTareaAsignada;
        this.cantidad = cantidad;
    }

    public Long getCodTareaAsignada() {
        return codTareaAsignada;
    }

    public void setCodTareaAsignada(Long codTareaAsignada) {
        this.codTareaAsignada = codTareaAsignada;
    }

    public Long getOrdenTarea() {
        return ordenTarea;
    }

    public void setOrdenTarea(Long ordenTarea) {
        this.ordenTarea = ordenTarea;
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

    public List<ProduccionDiaria> getProduccionDiariaCollection() {
        return produccionDiariaCollection;
    }

    public void setProduccionDiariaCollection(List<ProduccionDiaria> produccionDiariaCollection) {
        this.produccionDiariaCollection = produccionDiariaCollection;
    }

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public OrdenTrabajoDetalle getCodDetOrdenTrabaj() {
        return codDetOrdenTrabaj;
    }

    public void setCodDetOrdenTrabaj(OrdenTrabajoDetalle codDetOrdenTrabaj) {
        this.codDetOrdenTrabaj = codDetOrdenTrabaj;
    }

    public Tarea getCodTarea() {
        return codTarea;
    }

    public void setCodTarea(Tarea codTarea) {
        this.codTarea = codTarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTareaAsignada != null ? codTareaAsignada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaAsignada)) {
            return false;
        }
        TareaAsignada other = (TareaAsignada) object;
        if ((this.codTareaAsignada == null && other.codTareaAsignada != null) || (this.codTareaAsignada != null && !this.codTareaAsignada.equals(other.codTareaAsignada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.TareaAsignada[codTareaAsignada=" + codTareaAsignada + "]";
    }

}
