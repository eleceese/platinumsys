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
@SequenceGenerator(name="PRODUCTO_SEQUENCE", sequenceName="SQ_PRODUCTO", initialValue=1, allocationSize=1)
@Table(name = "PRODUCTO", catalog = "", schema = "PLATINUM")
@NamedQueries({@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRODUCTO_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_PRODUCTO")
    private Long codProducto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "PRECIO_ACTUAL")
    private BigInteger precioActual;
    @Column(name = "COSTO_ACTUAL")
    private BigInteger costoActual;
    @Basic(optional = false)
    @Column(name = "CONTROLA_EXISTENCIA")
    private String controlaExistencia;
    @Column(name = "CODIGO_INTERNO")
    private String codigoInterno;
    @JoinColumn(name = "COD_MARCA", referencedColumnName = "COD_MARCA")
    @ManyToOne(optional = false)
    private Marca codMarca;
    @JoinColumn(name = "COD_PRESENTACION", referencedColumnName = "COD_PRESENTACION")
    @ManyToOne(optional = false)
    private Presentacion codPresentacion;
    @JoinColumn(name = "COD_TIPO_PRODUCTO", referencedColumnName = "COD_TIPO_PRODUCTO")
    @ManyToOne(optional = false)
    private TipoProducto codTipoProducto;
    @JoinColumn(name = "COD_UNIDAD_MEDIDA", referencedColumnName = "COD_UNIDAD_MEDIDA")
    @ManyToOne(optional = false)
    private UnidadMedida codUnidadMedida;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "PORCENTAJE_IVA")
    private BigDecimal porcentajeIva;

    public Producto() {
    }

    public Producto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public Producto(Long codProducto, String descripcion, String controlaExistencia) {
        this.codProducto = codProducto;
        this.descripcion = descripcion;
        this.controlaExistencia = controlaExistencia;
    }

    public Long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(BigInteger precioActual) {
        this.precioActual = precioActual;
    }

    public BigInteger getCostoActual() {
        
        if (costoActual == null) {
            return new BigInteger("0");
        }else{
            return costoActual;
        }
        
    }

    public void setCostoActual(BigInteger costoActual) {
        this.costoActual = costoActual;
    }

    public String getControlaExistencia() {
        return controlaExistencia;
    }

    public void setControlaExistencia(String controlaExistencia) {
        this.controlaExistencia = controlaExistencia;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public Marca getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(Marca codMarca) {
        this.codMarca = codMarca;
    }

    public Presentacion getCodPresentacion() {
        return codPresentacion;
    }

    public void setCodPresentacion(Presentacion codPresentacion) {
        this.codPresentacion = codPresentacion;
    }

    public TipoProducto getCodTipoProducto() {
        return codTipoProducto;
    }

    public void setCodTipoProducto(TipoProducto codTipoProducto) {
        this.codTipoProducto = codTipoProducto;
    }

    public UnidadMedida getCodUnidadMedida() {
        return codUnidadMedida;
    }

    public void setCodUnidadMedida(UnidadMedida codUnidadMedida) {
        this.codUnidadMedida = codUnidadMedida;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(BigDecimal porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProducto != null ? codProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
