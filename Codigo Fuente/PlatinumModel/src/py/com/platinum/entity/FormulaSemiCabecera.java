/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author FerBoy
 */
@Entity
@SequenceGenerator(name="FORMULA_SEMI_CABECERA_SEQUENCE", sequenceName="SQ_FORMULA_SEMI_CABECERA", initialValue=1, allocationSize=1)
@Table(name = "FORMULA_SEMI_CABECERA")
@NamedQueries({@NamedQuery(name = "FormulaSemiCabecera.findAll", query = "SELECT f FROM FormulaSemiCabecera f")})
public class FormulaSemiCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FORMULA_SEMI_CABECERA_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_FORMULA_SEMI_CABECERA")
    private Long codFormulaSemiCabecera;
    @Column(name = "DESCRIPCION")
    private String descripcion;
   
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "USUARIO_ALTA")
    private String usuarioAlta;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFormulaSemiCabecera")
    private Collection<FormulaSemiDetalle> formulaSemiDetalleCollection;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFormulaSemiCabecera")
    private List<TareaFormula> tareaFormulaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFormulaSemiCabecera")
    private List<FormulaDetalle> formulaDetalleObject;

    public FormulaSemiCabecera() {
    }

public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<FormulaDetalle> getFormulaDetalleObject() {
        return formulaDetalleObject;
    }

    public void setFormulaDetalleObject(List<FormulaDetalle> formulaDetalleObject) {
        this.formulaDetalleObject = formulaDetalleObject;
    }




    public FormulaSemiCabecera(Long codFormulaSemiCabecera) {
        this.codFormulaSemiCabecera = codFormulaSemiCabecera;
    }

    public FormulaSemiCabecera(Long codFormulaSemiCabecera, BigInteger cantidad) {
        this.codFormulaSemiCabecera = codFormulaSemiCabecera;
        this.cantidad = cantidad;
    }

    public Long getCodFormulaSemiCabecera() {
        return codFormulaSemiCabecera;
    }

    public void setCodFormulaSemiCabecera(Long codFormulaSemiCabecera) {
        this.codFormulaSemiCabecera = codFormulaSemiCabecera;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Collection<FormulaSemiDetalle> getFormulaSemiDetalleCollection() {
        return formulaSemiDetalleCollection;
    }

    public void setFormulaSemiDetalleCollection(Collection<FormulaSemiDetalle> formulaSemiDetalleCollection) {
        this.formulaSemiDetalleCollection = formulaSemiDetalleCollection;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public Collection<TareaFormula> getTareaFormulaCollection() {
        return tareaFormulaCollection;
    }

    public void setTareaFormulaCollection(List<TareaFormula> tareaFormulaCollection) {
        this.tareaFormulaCollection = tareaFormulaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFormulaSemiCabecera != null ? codFormulaSemiCabecera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormulaSemiCabecera)) {
            return false;
        }
        FormulaSemiCabecera other = (FormulaSemiCabecera) object;
        if ((this.codFormulaSemiCabecera == null && other.codFormulaSemiCabecera != null) || (this.codFormulaSemiCabecera != null && !this.codFormulaSemiCabecera.equals(other.codFormulaSemiCabecera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
