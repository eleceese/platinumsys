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
@Table(name = "PRODUCCION_DIARIA")
@NamedQueries({@NamedQuery(name = "ProduccionDiaria.findAll", query = "SELECT p FROM ProduccionDiaria p"), @NamedQuery(name = "ProduccionDiaria.findByCodProduccionDiaria", query = "SELECT p FROM ProduccionDiaria p WHERE p.codProduccionDiaria = :codProduccionDiaria"), @NamedQuery(name = "ProduccionDiaria.findByCantidad", query = "SELECT p FROM ProduccionDiaria p WHERE p.cantidad = :cantidad"), @NamedQuery(name = "ProduccionDiaria.findByFecha", query = "SELECT p FROM ProduccionDiaria p WHERE p.fecha = :fecha"), @NamedQuery(name = "ProduccionDiaria.findByTiempoInvertido", query = "SELECT p FROM ProduccionDiaria p WHERE p.tiempoInvertido = :tiempoInvertido"), @NamedQuery(name = "ProduccionDiaria.findByUsuarioAlta", query = "SELECT p FROM ProduccionDiaria p WHERE p.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "ProduccionDiaria.findByUsuarioModif", query = "SELECT p FROM ProduccionDiaria p WHERE p.usuarioModif = :usuarioModif"), @NamedQuery(name = "ProduccionDiaria.findByFechaAlta", query = "SELECT p FROM ProduccionDiaria p WHERE p.fechaAlta = :fechaAlta"), @NamedQuery(name = "ProduccionDiaria.findByFechaModif", query = "SELECT p FROM ProduccionDiaria p WHERE p.fechaModif = :fechaModif")})
public class ProduccionDiaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_PRODUCCION_DIARIA")
    private Long codProduccionDiaria;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private long cantidad;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "TIEMPO_INVERTIDO")
    private long tiempoInvertido;
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
    @JoinColumn(name = "COD_TAREA_ASIGNADA", referencedColumnName = "COD_TAREA_ASIGNADA")
    @ManyToOne(optional = false)
    private TareaAsignada codTareaAsignada;

    public ProduccionDiaria() {
    }

    public ProduccionDiaria(Long codProduccionDiaria) {
        this.codProduccionDiaria = codProduccionDiaria;
    }

    public ProduccionDiaria(Long codProduccionDiaria, long cantidad, Date fecha, long tiempoInvertido) {
        this.codProduccionDiaria = codProduccionDiaria;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tiempoInvertido = tiempoInvertido;
    }

    public Long getCodProduccionDiaria() {
        return codProduccionDiaria;
    }

    public void setCodProduccionDiaria(Long codProduccionDiaria) {
        this.codProduccionDiaria = codProduccionDiaria;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getTiempoInvertido() {
        return tiempoInvertido;
    }

    public void setTiempoInvertido(long tiempoInvertido) {
        this.tiempoInvertido = tiempoInvertido;
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

    public TareaAsignada getCodTareaAsignada() {
        return codTareaAsignada;
    }

    public void setCodTareaAsignada(TareaAsignada codTareaAsignada) {
        this.codTareaAsignada = codTareaAsignada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProduccionDiaria != null ? codProduccionDiaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduccionDiaria)) {
            return false;
        }
        ProduccionDiaria other = (ProduccionDiaria) object;
        if ((this.codProduccionDiaria == null && other.codProduccionDiaria != null) || (this.codProduccionDiaria != null && !this.codProduccionDiaria.equals(other.codProduccionDiaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.ProduccionDiaria[codProduccionDiaria=" + codProduccionDiaria + "]";
    }

}
