/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@SequenceGenerator(name="FORMULA_CABECERA_SEQUENCE", sequenceName="SQ_CABECERA_FORMULA", initialValue=1, allocationSize=1)
@Table(name = "FORMULA_CABECERA")
@NamedQueries({@NamedQuery(name = "FormulaCabecera.findAll", query = "SELECT f FROM FormulaCabecera f"), @NamedQuery(name = "FormulaCabecera.findByCodFormula", query = "SELECT f FROM FormulaCabecera f WHERE f.codFormula = :codFormula"), @NamedQuery(name = "FormulaCabecera.findByCantidad", query = "SELECT f FROM FormulaCabecera f WHERE f.cantidad = :cantidad"), @NamedQuery(name = "FormulaCabecera.findByEstado", query = "SELECT f FROM FormulaCabecera f WHERE f.estado = :estado"), @NamedQuery(name = "FormulaCabecera.findByFecha", query = "SELECT f FROM FormulaCabecera f WHERE f.fecha = :fecha"), @NamedQuery(name = "FormulaCabecera.findByDescripcion", query = "SELECT f FROM FormulaCabecera f WHERE f.descripcion = :descripcion"), @NamedQuery(name = "FormulaCabecera.findByUsuarioAlta", query = "SELECT f FROM FormulaCabecera f WHERE f.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "FormulaCabecera.findByUsuarioModif", query = "SELECT f FROM FormulaCabecera f WHERE f.usuarioModif = :usuarioModif"), @NamedQuery(name = "FormulaCabecera.findByFechaAlta", query = "SELECT f FROM FormulaCabecera f WHERE f.fechaAlta = :fechaAlta"), @NamedQuery(name = "FormulaCabecera.findByFechaModif", query = "SELECT f FROM FormulaCabecera f WHERE f.fechaModif = :fechaModif")})
public class FormulaCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FORMULA_CABECERA_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_FORMULA")
    private Long codFormula;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "DESCRIPCION")
    private String descripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFormula")
    private List<FormulaDetalle> formulaDetalleCollection;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;

    public FormulaCabecera() {
    }

    public FormulaCabecera(Long codFormula) {
        this.codFormula = codFormula;
    }

    public FormulaCabecera(Long codFormula, String estado) {
        this.codFormula = codFormula;
        this.estado = estado;
    }

    public Long getCodFormula() {
        return codFormula;
    }

    public void setCodFormula(Long codFormula) {
        this.codFormula = codFormula;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public List<FormulaDetalle> getFormulaDetalleCollection() {
        return formulaDetalleCollection;
    }

    public void setFormulaDetalleCollection(List<FormulaDetalle> formulaDetalleCollection) {
        this.formulaDetalleCollection = formulaDetalleCollection;
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
        hash += (codFormula != null ? codFormula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormulaCabecera)) {
            return false;
        }
        FormulaCabecera other = (FormulaCabecera) object;
        if ((this.codFormula == null && other.codFormula != null) || (this.codFormula != null && !this.codFormula.equals(other.codFormula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
