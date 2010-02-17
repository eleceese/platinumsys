/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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

/**
 *
 * @author FerBoy
 */
@Entity
@SequenceGenerator(name="FORMULA_SEMI_DETALLE_SEQUENCE", sequenceName="SQ_FORMULA_SEMI_DETALLE", initialValue=1, allocationSize=1)
@Table(name = "FORMULA_SEMI_DETALLE")
@NamedQueries({@NamedQuery(name = "FormulaSemiDetalle.findAll", query = "SELECT f FROM FormulaSemiDetalle f")})
public class FormulaSemiDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FORMULA_SEMI_DETALLE_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_FORMULA_SEMI_DETALLE")
    private Long codFormulaSemiDetalle;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinColumn(name = "COD_FORMULA_SEMI_CABECERA", referencedColumnName = "COD_FORMULA_SEMI_CABECERA")
    @ManyToOne(optional = false)
    private FormulaSemiCabecera codFormulaSemiCabecera;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;

    public FormulaSemiDetalle() {
    }

    public FormulaSemiDetalle(Long codFormulaSemiDetalle) {
        this.codFormulaSemiDetalle = codFormulaSemiDetalle;
    }

    public FormulaSemiDetalle(Long codFormulaSemiDetalle, BigInteger cantidad) {
        this.codFormulaSemiDetalle = codFormulaSemiDetalle;
        this.cantidad = cantidad;
    }

    public Long getCodFormulaSemiDetalle() {
        return codFormulaSemiDetalle;
    }

    public void setCodFormulaSemiDetalle(Long codFormulaSemiDetalle) {
        this.codFormulaSemiDetalle = codFormulaSemiDetalle;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public FormulaSemiCabecera getCodFormulaSemiCabecera() {
        return codFormulaSemiCabecera;
    }

    public void setCodFormulaSemiCabecera(FormulaSemiCabecera codFormulaSemiCabecera) {
        this.codFormulaSemiCabecera = codFormulaSemiCabecera;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFormulaSemiDetalle != null ? codFormulaSemiDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormulaSemiDetalle)) {
            return false;
        }
        FormulaSemiDetalle other = (FormulaSemiDetalle) object;
        if ((this.codFormulaSemiDetalle == null && other.codFormulaSemiDetalle != null) || (this.codFormulaSemiDetalle != null && !this.codFormulaSemiDetalle.equals(other.codFormulaSemiDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.FormulaSemiDetalle[codFormulaSemiDetalle=" + codFormulaSemiDetalle + "]";
    }

}
