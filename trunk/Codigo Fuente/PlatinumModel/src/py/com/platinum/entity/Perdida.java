/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@SequenceGenerator(name="PERDIDA_SEQUENCE", sequenceName="SQ_PERDIDAPROD", initialValue=1, allocationSize=1)
@Table(name = "PERDIDA")
@NamedQueries({@NamedQuery(name = "Perdida.findAll", query = "SELECT p FROM Perdida p"), @NamedQuery(name = "Perdida.findByCodPerdida", query = "SELECT p FROM Perdida p WHERE p.codPerdida = :codPerdida"), @NamedQuery(name = "Perdida.findByFechaPerdida", query = "SELECT p FROM Perdida p WHERE p.fechaPerdida = :fechaPerdida"), @NamedQuery(name = "Perdida.findByCantidadPerdida", query = "SELECT p FROM Perdida p WHERE p.cantidadPerdida = :cantidadPerdida"), @NamedQuery(name = "Perdida.findByObservacion", query = "SELECT p FROM Perdida p WHERE p.observacion = :observacion"), @NamedQuery(name = "Perdida.findByUsuarioAlta", query = "SELECT p FROM Perdida p WHERE p.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "Perdida.findByUsuarioModif", query = "SELECT p FROM Perdida p WHERE p.usuarioModif = :usuarioModif"), @NamedQuery(name = "Perdida.findByFechaAlta", query = "SELECT p FROM Perdida p WHERE p.fechaAlta = :fechaAlta"), @NamedQuery(name = "Perdida.findByFechaModif", query = "SELECT p FROM Perdida p WHERE p.fechaModif = :fechaModif")})
public class Perdida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PERDIDA_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_PERDIDA")
    private Long codPerdida;
    @Basic(optional = false)
    @Column(name = "FECHA_PERDIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaPerdida;
    @Column(name = "COD_TAREA_FALLIDA")
    private Long codTareaFallida;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_PERDIDA")
    private long cantidadPerdida;
    @Column(name = "PRECIO_UNIT")
    private BigInteger precioUnit;
    @Column(name = "TOTAL")
    private BigInteger total;
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "TALLER")
    private String taller;
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
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;
    @JoinColumn(name = "COD_ORDEN_TRABAJO", referencedColumnName = "COD_ORDEN_TRABJO")
    @ManyToOne(fetch = FetchType.EAGER)
    private OrdenTrabajo codOrdenTrabjo;
    @JoinColumn(name = "COD_DEPOSITO", referencedColumnName = "COD_DEPOSITO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Deposito codDeposito;

    public OrdenTrabajo getCodOrdenTrabjo() {
        return codOrdenTrabjo;
    }

    public void setCodOrdenTrabjo(OrdenTrabajo codOrdenTrabjo) {
        this.codOrdenTrabjo = codOrdenTrabjo;
    }



    public Perdida() {
    }

    public Perdida(Long codPerdida) {
        this.codPerdida = codPerdida;
    }

    public Perdida(Long codPerdida, Date fechaPerdida,  long cantidadPerdida) {
        this.codPerdida = codPerdida;
        this.fechaPerdida = fechaPerdida;
      
        this.cantidadPerdida = cantidadPerdida;
    }

    public Deposito getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(Deposito codDeposito) {
        this.codDeposito = codDeposito;
    }

   

    public Long getCodPerdida() {
        return codPerdida;
    }

    public void setCodPerdida(Long codPerdida) {
        this.codPerdida = codPerdida;
    }

    public Date getFechaPerdida() {
        return fechaPerdida;
    }

    public BigInteger getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(BigInteger precioUnit) {
        this.precioUnit = precioUnit;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public void setFechaPerdida(Date fechaPerdida) {
        this.fechaPerdida = fechaPerdida;
    }

    public long getCantidadPerdida() {
        return cantidadPerdida;
    }

    public void setCantidadPerdida(long cantidadPerdida) {
        this.cantidadPerdida = cantidadPerdida;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public Long getCodTareaFallida() {
        return codTareaFallida;
    }

    public void setCodTareaFallida(Long codTareaFallida) {
        this.codTareaFallida = codTareaFallida;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPerdida != null ? codPerdida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perdida)) {
            return false;
        }
        Perdida other = (Perdida) object;
        if ((this.codPerdida == null && other.codPerdida != null) || (this.codPerdida != null && !this.codPerdida.equals(other.codPerdida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return observacion;
    }

}
