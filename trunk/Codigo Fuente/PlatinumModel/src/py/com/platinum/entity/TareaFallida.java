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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author FerBoy
 */
@Entity
@SequenceGenerator(name="TAREA_FALLIDA_SEQUENCE", sequenceName="SQ_TAREA_FALLIDA", initialValue=1, allocationSize=1)
@Table(name = "TAREA_FALLIDA", catalog = "", schema = "PLATINUM")
public class TareaFallida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TAREA_FALLIDA_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_TAREA_FALLIDA")
    private Long codTareaFallida;
    @Column(name = "CANTIDAD")
    private Long cantidad;
    @Column(name = "REHACER")
    private Long rehacer;
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEmpleado;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "FECHA_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModif;
    @Column(name = "USUARIO_ALTA")
    private String usuarioAlta;
    @Column(name = "USUARIO_MODIF")
    private String usuarioModif;
    @JoinColumn(name = "COD_TAREA_ASIGNADA", referencedColumnName = "COD_TAREA_ASIGNADA")
    @ManyToOne(optional = false)
    private TareaAsignada codTareaAsignada;
    @Column(name = "TIEMPO_INVERTIDO")
    private long tiempoInvertido;



    public TareaFallida() {
    }

    public TareaFallida(Long codTareaFallida) {
        this.codTareaFallida = codTareaFallida;
    }

  

    public Long getCodTareaFallida() {
        return codTareaFallida;
    }

    public void setCodTareaFallida(Long codTareaFallida) {
        this.codTareaFallida = codTareaFallida;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getRehacer() {
        return rehacer;
    }

    public void setRehacer(Long rehacer) {
        this.rehacer = rehacer;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTareaFallida != null ? codTareaFallida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaFallida)) {
            return false;
        }
        TareaFallida other = (TareaFallida) object;
        if ((this.codTareaFallida == null && other.codTareaFallida != null) || (this.codTareaFallida != null && !this.codTareaFallida.equals(other.codTareaFallida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codTareaFallida.toString();
    }

    public long getTiempoInvertido() {
        return tiempoInvertido;
    }

    public void setTiempoInvertido(long tiempoInvertido) {
        this.tiempoInvertido = tiempoInvertido;
    }

}
