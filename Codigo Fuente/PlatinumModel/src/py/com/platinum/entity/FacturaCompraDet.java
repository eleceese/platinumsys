/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "FACTURA_COMPRA_DET")
@SequenceGenerator(name="FAC_COMP_DET_SEQUENCE", sequenceName="SQ_FACTURA_COMPRA_DET", initialValue=1, allocationSize=1)
public class FacturaCompraDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FAC_COMP_DET_SEQUENCE")
    @Column(name = "COD_FAC_COM_DET")
    private Long codFacComDet;
    @Column(name = "PRECIO_UNI")
    private long precioUni;
    @Column(name = "CANTIDAD")
    private long cantidad;
    @Column(name = "TOTAL")
    private long total;
    @Column(name = "PORC_IVA")
    private double porcIva;
    @Column(name = "MONTO_IVA")
    private long montoIva;
    @Column(name = "USUARIO_ALTA")
    private String usuarioAlta;
    @Column(name = "USUARIO_MODIF")
    private String usuarioModif;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "FECHA_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModif;
    @JoinColumn(name = "COD_FAC_COM_CAB", referencedColumnName = "COD_FAC_COM_CAB")
    @ManyToOne
    private FacturaCompraCab codFacComCab;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne
    private Producto codProducto;
    @JoinColumn(name = "NRO_SOLICITUD", referencedColumnName = "COD_SOLICITUD")
    @ManyToOne
    private SolicitudInterna nroSolicitud;

    public FacturaCompraDet() {
    }

    public FacturaCompraDet(Long codFacComDet) {
        this.codFacComDet = codFacComDet;
    }

    public FacturaCompraDet(Long codFacComDet, long precioUni, long cantidad, long total, long montoIva) {
        this.codFacComDet = codFacComDet;
        this.precioUni = precioUni;
        this.cantidad = cantidad;
        this.total = total;
        this.montoIva = montoIva;
    }

    public Long getCodFacComDet() {
        return codFacComDet;
    }

    public void setCodFacComDet(Long codFacComDet) {
        this.codFacComDet = codFacComDet;
    }

    public long getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(long precioUni) {
        this.precioUni = precioUni;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    
    public long getMontoIva() {
        return montoIva;
    }

    public void setMontoIva(long montoIva) {
        this.montoIva = montoIva;
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

    public FacturaCompraCab getCodFacComCab() {
        return codFacComCab;
    }

    public void setCodFacComCab(FacturaCompraCab codFacComCab) {
        this.codFacComCab = codFacComCab;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public double getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(double porcIva) {
        this.porcIva = porcIva;
    }

    public SolicitudInterna getNroSolicitud() {
        return nroSolicitud;
    }

    public void setNroSolicitud(SolicitudInterna nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFacComDet != null ? codFacComDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCompraDet)) {
            return false;
        }
        FacturaCompraDet other = (FacturaCompraDet) object;
        if ((this.codFacComDet == null && other.codFacComDet != null) || (this.codFacComDet != null && !this.codFacComDet.equals(other.codFacComDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.codFacComDet.toString();
    }

}
