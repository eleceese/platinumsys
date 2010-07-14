/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@SequenceGenerator(name="HABCAJ_SEQUENCE", sequenceName="SQ_CAB_HAB_CAJA", initialValue=1, allocationSize=1)
@Table(name = "HABILITACION_CAJA")
public class HabilitacionCaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_HABILITACION_CAJA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="HABCAJ_SEQUENCE")
    private Long codHabilitacionCaja;
    @Column(name = "FECHA_HAB_CAJA")
    @Temporal(TemporalType.DATE)
    private Date fechaHabCaja;
    @Column(name = "HORA_HAB_CAJA")
    @Temporal(TemporalType.DATE)
    private Date horaHabCaja;
    @Column(name = "MONTO_INICIAL")
    private BigInteger montoInicial;
    @Column(name = "TOTAL_MOVIMIENTO_CAJA")
    private BigInteger totalMovimientoCaja;
    @Column(name = "TOTAL_GASTO")
    private BigInteger totalGasto;
    @Column(name = "MONTO_SALDO")
    private BigInteger montoSaldo;
    @Column(name = "MONTO_RENDIDO")
    private BigInteger montoRendido;
    @Column(name = "FECHA_CIERRE")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @Column(name = "HORA_CIERRE")
    @Temporal(TemporalType.DATE)
    private Date horaCierre;
    @Column(name = "ESTADO")
    private String estado;
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
    @JoinColumn(name = "COD_CAJA", referencedColumnName = "COD_CAJA")
    @ManyToOne(optional = false)
    private Caja codCaja;
    @JoinColumn(name = "COD_REPONSABLE", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codReponsable;
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEmpleado;

    public HabilitacionCaja() {
    }

    public HabilitacionCaja(Long codHabilitacionCaja) {
        this.codHabilitacionCaja = codHabilitacionCaja;
    }

    public Long getCodHabilitacionCaja() {
        return codHabilitacionCaja;
    }

    public void setCodHabilitacionCaja(Long codHabilitacionCaja) {
        this.codHabilitacionCaja = codHabilitacionCaja;
    }

    public Date getFechaHabCaja() {
        return fechaHabCaja;
    }

    public void setFechaHabCaja(Date fechaHabCaja) {
        this.fechaHabCaja = fechaHabCaja;
    }

    public Date getHoraHabCaja() {
        return horaHabCaja;
    }

    public void setHoraHabCaja(Date horaHabCaja) {
        this.horaHabCaja = horaHabCaja;
    }

    public BigInteger getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(BigInteger montoInicial) {
        this.montoInicial = montoInicial;
    }

    public BigInteger getTotalMovimientoCaja() {
        return totalMovimientoCaja;
    }

    public void setTotalMovimientoCaja(BigInteger totalMovimientoCaja) {
        this.totalMovimientoCaja = totalMovimientoCaja;
    }

    public BigInteger getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(BigInteger totalGasto) {
        this.totalGasto = totalGasto;
    }

    public BigInteger getMontoSaldo() {
        return montoSaldo;
    }

    public void setMontoSaldo(BigInteger montoSaldo) {
        this.montoSaldo = montoSaldo;
    }

    public BigInteger getMontoRendido() {
        return montoRendido;
    }

    public void setMontoRendido(BigInteger montoRendido) {
        this.montoRendido = montoRendido;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Caja getCodCaja() {
        return codCaja;
    }

    public void setCodCaja(Caja codCaja) {
        this.codCaja = codCaja;
    }

    public Empleado getCodReponsable() {
        return codReponsable;
    }

    public void setCodReponsable(Empleado codReponsable) {
        this.codReponsable = codReponsable;
    }

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }
    ///////////////
//    public Set<MovimientoCajaCabecera> getMovimientoCajaCabecera() {
//        return movimientoCajaCabecera;
//    }
//
//    public List<MovimientoCajaCabecera> getMovimientoCajaCabeceraList() {
//        return new ArrayList(Arrays.asList(movimientoCajaCabecera.toArray(new MovimientoCajaCabecera[0])));
//    }
//
//    public void setMovimientoCajaCabecera(Set<MovimientoCajaCabecera> movimientoCajaCabecera) {
//        this.movimientoCajaCabecera = movimientoCajaCabecera;
//    }
//
//    public Set<Gasto> getGasto() {
//        return gasto;
//    }
//
//    public List<Gasto> getGastoList() {
//        return new ArrayList(Arrays.asList(gasto.toArray(new Gasto[0])));
//    }
//
//    public void setGasto(Set<Gasto> gasto) {
//        this.gasto = gasto;
///////////////////////////////
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codHabilitacionCaja != null ? codHabilitacionCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HabilitacionCaja)) {
            return false;
        }
        HabilitacionCaja other = (HabilitacionCaja) object;
        if ((this.codHabilitacionCaja == null && other.codHabilitacionCaja != null) || (this.codHabilitacionCaja != null && !this.codHabilitacionCaja.equals(other.codHabilitacionCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.HabilitacionCaja[codHabilitacionCaja=" + codHabilitacionCaja + "]";
    }

}
