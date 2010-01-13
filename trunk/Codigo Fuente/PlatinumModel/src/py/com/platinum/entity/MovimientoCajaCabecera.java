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
@Table(name = "MOVIMIENTO_CAJA_CABECERA")
@NamedQueries({@NamedQuery(name = "MovimientoCajaCabecera.findAll", query = "SELECT m FROM MovimientoCajaCabecera m"), @NamedQuery(name = "MovimientoCajaCabecera.findByCodMovimientoCaja", query = "SELECT m FROM MovimientoCajaCabecera m WHERE m.codMovimientoCaja = :codMovimientoCaja"), @NamedQuery(name = "MovimientoCajaCabecera.findByFechaMovimiento", query = "SELECT m FROM MovimientoCajaCabecera m WHERE m.fechaMovimiento = :fechaMovimiento"), @NamedQuery(name = "MovimientoCajaCabecera.findByHoraMovimiento", query = "SELECT m FROM MovimientoCajaCabecera m WHERE m.horaMovimiento = :horaMovimiento"), @NamedQuery(name = "MovimientoCajaCabecera.findByEstadoMovimiento", query = "SELECT m FROM MovimientoCajaCabecera m WHERE m.estadoMovimiento = :estadoMovimiento"), @NamedQuery(name = "MovimientoCajaCabecera.findByObservacoin", query = "SELECT m FROM MovimientoCajaCabecera m WHERE m.observacoin = :observacoin"), @NamedQuery(name = "MovimientoCajaCabecera.findByUsuarioAlta", query = "SELECT m FROM MovimientoCajaCabecera m WHERE m.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "MovimientoCajaCabecera.findByUsuarioModif", query = "SELECT m FROM MovimientoCajaCabecera m WHERE m.usuarioModif = :usuarioModif"), @NamedQuery(name = "MovimientoCajaCabecera.findByFechaAlta", query = "SELECT m FROM MovimientoCajaCabecera m WHERE m.fechaAlta = :fechaAlta"), @NamedQuery(name = "MovimientoCajaCabecera.findByFechaModif", query = "SELECT m FROM MovimientoCajaCabecera m WHERE m.fechaModif = :fechaModif")})
public class MovimientoCajaCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_MOVIMIENTO_CAJA")
    private Long codMovimientoCaja;
    @Column(name = "FECHA_MOVIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaMovimiento;
    @Column(name = "HORA_MOVIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date horaMovimiento;
    @Column(name = "ESTADO_MOVIMIENTO")
    private String estadoMovimiento;
    @Column(name = "OBSERVACOIN")
    private String observacoin;
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
    @JoinColumn(name = "COD_HABILITACION_CAJA", referencedColumnName = "COD_HABILITACION_CAJA")
    @ManyToOne(optional = false)
    private HabilitacionCaja codHabilitacionCaja;
    @JoinColumn(name = "COD_RECIBO", referencedColumnName = "COD_RECIBO")
    @ManyToOne(optional = false)
    private ReciboCabecera codRecibo;
    @OneToMany(mappedBy = "codMovimientoCaja")
    private List<MovimientoCajaDetalle> movimientoCajaDetalleCollection;

    public MovimientoCajaCabecera() {
    }

    public MovimientoCajaCabecera(Long codMovimientoCaja) {
        this.codMovimientoCaja = codMovimientoCaja;
    }

    public Long getCodMovimientoCaja() {
        return codMovimientoCaja;
    }

    public void setCodMovimientoCaja(Long codMovimientoCaja) {
        this.codMovimientoCaja = codMovimientoCaja;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Date getHoraMovimiento() {
        return horaMovimiento;
    }

    public void setHoraMovimiento(Date horaMovimiento) {
        this.horaMovimiento = horaMovimiento;
    }

    public String getEstadoMovimiento() {
        return estadoMovimiento;
    }

    public void setEstadoMovimiento(String estadoMovimiento) {
        this.estadoMovimiento = estadoMovimiento;
    }

    public String getObservacoin() {
        return observacoin;
    }

    public void setObservacoin(String observacoin) {
        this.observacoin = observacoin;
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

    public HabilitacionCaja getCodHabilitacionCaja() {
        return codHabilitacionCaja;
    }

    public void setCodHabilitacionCaja(HabilitacionCaja codHabilitacionCaja) {
        this.codHabilitacionCaja = codHabilitacionCaja;
    }

    public ReciboCabecera getCodRecibo() {
        return codRecibo;
    }

    public void setCodRecibo(ReciboCabecera codRecibo) {
        this.codRecibo = codRecibo;
    }

    public List<MovimientoCajaDetalle> getMovimientoCajaDetalleCollection() {
        return movimientoCajaDetalleCollection;
    }

    public void setMovimientoCajaDetalleCollection(List<MovimientoCajaDetalle> movimientoCajaDetalleCollection) {
        this.movimientoCajaDetalleCollection = movimientoCajaDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMovimientoCaja != null ? codMovimientoCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoCajaCabecera)) {
            return false;
        }
        MovimientoCajaCabecera other = (MovimientoCajaCabecera) object;
        if ((this.codMovimientoCaja == null && other.codMovimientoCaja != null) || (this.codMovimientoCaja != null && !this.codMovimientoCaja.equals(other.codMovimientoCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.MovimientoCajaCabecera[codMovimientoCaja=" + codMovimientoCaja + "]";
    }

}
