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
import javax.persistence.ManyToMany;
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
@SequenceGenerator(name="FORMULA_DETALLE_SEQUENCE", sequenceName="SQ_DETALLE_FORMULA", initialValue=1, allocationSize=1)
@Table(name = "FORMULA_DETALLE")
@NamedQueries({@NamedQuery(name = "FormulaDetalle.findAll", query = "SELECT f FROM FormulaDetalle f"), @NamedQuery(name = "FormulaDetalle.findByCodFormulaDetalle", query = "SELECT f FROM FormulaDetalle f WHERE f.codFormulaDetalle = :codFormulaDetalle"), @NamedQuery(name = "FormulaDetalle.findByCantidad", query = "SELECT f FROM FormulaDetalle f WHERE f.cantidad = :cantidad"), @NamedQuery(name = "FormulaDetalle.findByUsuarioAlta", query = "SELECT f FROM FormulaDetalle f WHERE f.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "FormulaDetalle.findByUsuarioModif", query = "SELECT f FROM FormulaDetalle f WHERE f.usuarioModif = :usuarioModif"), @NamedQuery(name = "FormulaDetalle.findByFechaAlta", query = "SELECT f FROM FormulaDetalle f WHERE f.fechaAlta = :fechaAlta"), @NamedQuery(name = "FormulaDetalle.findByFechaModif", query = "SELECT f FROM FormulaDetalle f WHERE f.fechaModif = :fechaModif")})
public class FormulaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FORMULA_DETALLE_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_FORMULA_DETALLE")
    private Long codFormulaDetalle;
    @Column(name = "SEMI_FIN")
    private String semiFin;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
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
    @JoinColumn(name = "COD_FORMULA", referencedColumnName = "COD_FORMULA")
    @ManyToOne(optional = false)
    private FormulaCabecera codFormula;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;
    @JoinColumn(name = "CODIGO_FORMULA_SEMITER", referencedColumnName = "COD_FORMULA_SEMI_CABECERA")
    @ManyToOne(optional = false)
    private FormulaSemiCabecera codFormulaSemiCabecera;

    public String getSemiFin() {
        return semiFin;
    }

    public void setSemiFin(String semiFin) {
        this.semiFin = semiFin;
    }

    public FormulaSemiCabecera getCodFormulaSemiCabecera() {
        return codFormulaSemiCabecera;
    }

    public void setCodFormulaSemiCabecera(FormulaSemiCabecera codFormulaSemiCabecera) {
        this.codFormulaSemiCabecera = codFormulaSemiCabecera;
    }


    public FormulaDetalle() {
    }

    public FormulaDetalle(Long codFormulaDetalle) {
        this.codFormulaDetalle = codFormulaDetalle;
    }

    public Long getCodFormulaDetalle() {
        return codFormulaDetalle;
    }

    public void setCodFormulaDetalle(Long codFormulaDetalle) {
        this.codFormulaDetalle = codFormulaDetalle;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
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

    public FormulaCabecera getCodFormula() {
        return codFormula;
    }

    public void setCodFormula(FormulaCabecera codFormula) {
        this.codFormula = codFormula;
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
        hash += (codFormulaDetalle != null ? codFormulaDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormulaDetalle)) {
            return false;
        }
        FormulaDetalle other = (FormulaDetalle) object;
        if ((this.codFormulaDetalle == null && other.codFormulaDetalle != null) || (this.codFormulaDetalle != null && !this.codFormulaDetalle.equals(other.codFormulaDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.FormulaDetalle[codFormulaDetalle=" + codFormulaDetalle + "]";
    }

}
