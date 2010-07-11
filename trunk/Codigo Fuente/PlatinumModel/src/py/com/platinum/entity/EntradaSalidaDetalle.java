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
@Table(name = "ENTRADA_SALIDA_DETALLE")
@SequenceGenerator(name="ENTRADA_SALIDA_DETALLE_SEQUENCE", sequenceName="SQ_DETALLE_ENTRADA_SALIDA", initialValue=5, allocationSize=1)
public class EntradaSalidaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ENTRADA_SALIDA_DETALLE_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_ENT_SAL_DETALLE")
    private Long codEntSalDetalle;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_ENT_SAL")
    private BigInteger cantidadEntSal;
    @Column(name = "CANTIDAD_EQUIVALENCIA")
    private long cantidadEquivalencia;
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "ESTADO_DETALLE_ENT_SAL")
    private String estadoDetalleEntSal;
    @Basic(optional = false)
    @Column(name = "TIPO_ENTRADA_SALIDA")
    private String tipoEntradaSalida;
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
    @JoinColumn(name = "COD_ENTRADA_SALIDA", referencedColumnName = "COD_ENTRADA_SALIDA")
    @ManyToOne(optional = false)
    private EntradaSalidaCabecera codEntradaSalida;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;
    @JoinColumn(name = "COD_SOLICITUD", referencedColumnName = "COD_SOLICITUD")
    @ManyToOne
    private SolicitudInterna codSolicitud;
    @JoinColumn(name = "COD_ORDEN_TRABAJO_DETALLE", referencedColumnName = "COD_ORDEN_TRABAJO_DET")
    @ManyToOne
    private OrdenTrabajoDetalle codOrdenTrabajoDetalle;
    @Column(name = "EXISTENCIA")
    private BigDecimal existencia;

    public OrdenTrabajoDetalle getCodOrdenTrabajoDetalle() {
        return codOrdenTrabajoDetalle;
    }

    public void setCodOrdenTrabajoDetalle(OrdenTrabajoDetalle codOrdenTrabajoDetalle) {
        this.codOrdenTrabajoDetalle = codOrdenTrabajoDetalle;
    }


    public SolicitudInterna getCodSolicitud() {
        return codSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCodSolicitud(SolicitudInterna codSolicitud) {
        this.codSolicitud = codSolicitud;
    }

    public long getCantidadEquivalencia() {
        return cantidadEquivalencia;
    }

    public void setCantidadEquivalencia(long cantidadEquivalencia) {
        this.cantidadEquivalencia = cantidadEquivalencia;
    }



    public EntradaSalidaDetalle() {
    }

    public EntradaSalidaDetalle(Long codEntSalDetalle) {
        this.codEntSalDetalle = codEntSalDetalle;
    }

    public EntradaSalidaDetalle(Long codEntSalDetalle, BigInteger cantidadEntSal, String tipoEntradaSalida) {
        this.codEntSalDetalle = codEntSalDetalle;
        this.cantidadEntSal = cantidadEntSal;
        this.tipoEntradaSalida = tipoEntradaSalida;
    }

    public Long getCodEntSalDetalle() {
        return codEntSalDetalle;
    }

    public void setCodEntSalDetalle(Long codEntSalDetalle) {
        this.codEntSalDetalle = codEntSalDetalle;
    }

    public BigInteger getCantidadEntSal() {
        return cantidadEntSal;
    }

    public void setCantidadEntSal(BigInteger cantidadEntSal) {
        this.cantidadEntSal = cantidadEntSal;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstadoDetalleEntSal() {
        return estadoDetalleEntSal;
    }

    public void setEstadoDetalleEntSal(String estadoDetalleEntSal) {
        this.estadoDetalleEntSal = estadoDetalleEntSal;
    }

    public String getTipoEntradaSalida() {
        return tipoEntradaSalida;
    }

    public void setTipoEntradaSalida(String tipoEntradaSalida) {
        this.tipoEntradaSalida = tipoEntradaSalida;
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

    public EntradaSalidaCabecera getCodEntradaSalida() {
        return codEntradaSalida;
    }

    public void setCodEntradaSalida(EntradaSalidaCabecera codEntradaSalida) {
        this.codEntradaSalida = codEntradaSalida;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public BigDecimal getExistencia() {
        return existencia;
    }

    public void setExistencia(BigDecimal existencia) {
        this.existencia = existencia;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEntSalDetalle != null ? codEntSalDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaSalidaDetalle)) {
            return false;
        }
        EntradaSalidaDetalle other = (EntradaSalidaDetalle) object;
        if ((this.codEntSalDetalle == null && other.codEntSalDetalle != null) || (this.codEntSalDetalle != null && !this.codEntSalDetalle.equals(other.codEntSalDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.EntradaSalidaDetalle[codEntSalDetalle=" + codEntSalDetalle + "]";
    }

}
