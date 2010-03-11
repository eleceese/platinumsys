/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author FerBoy
 */
@Entity
@SequenceGenerator(name="EQUIVALENCIA_SEQUENCE", sequenceName="SEQ_EQUIVALENCIA", initialValue=1, allocationSize=1)
@Table(name = "EQUIVALENCIA", catalog = "", schema = "PLATINUM")
@NamedQueries({@NamedQuery(name = "Equivalencia.findAll", query = "SELECT e FROM Equivalencia e"), @NamedQuery(name = "Equivalencia.findByCodEquivalencia", query = "SELECT e FROM Equivalencia e WHERE e.codEquivalencia = :codEquivalencia"), @NamedQuery(name = "Equivalencia.findByRelacion", query = "SELECT e FROM Equivalencia e WHERE e.relacion = :relacion")})
public class Equivalencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EQUIVALENCIA_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_EQUIVALENCIA", nullable = false)
    private Long codEquivalencia;
    @Basic(optional = false)
    @Column(name = "RELACION", nullable = false, precision = 15, scale = 2)
    private BigDecimal relacion;
    @JoinColumn(name = "COD_PRODUCTO_FIN", referencedColumnName = "COD_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto codProductoFin;
    @JoinColumn(name = "COD_PRODUCTO_GEN", referencedColumnName = "COD_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto codProductoGen;

    public Equivalencia() {
    }

    public Equivalencia(Long codEquivalencia) {
        this.codEquivalencia = codEquivalencia;
    }

    public Equivalencia(Long codEquivalencia, BigDecimal relacion) {
        this.codEquivalencia = codEquivalencia;
        this.relacion = relacion;
    }

    public Long getCodEquivalencia() {
        return codEquivalencia;
    }

    public void setCodEquivalencia(Long codEquivalencia) {
        this.codEquivalencia = codEquivalencia;
    }

    public BigDecimal getRelacion() {
        return relacion;
    }

    public void setRelacion(BigDecimal relacion) {
        this.relacion = relacion;
    }

    public Producto getCodProductoFin() {
        return codProductoFin;
    }

    public void setCodProductoFin(Producto codProductoFin) {
        this.codProductoFin = codProductoFin;
    }

    public Producto getCodProductoGen() {
        return codProductoGen;
    }

    public void setCodProductoGen(Producto codProductoGen) {
        this.codProductoGen = codProductoGen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEquivalencia != null ? codEquivalencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equivalencia)) {
            return false;
        }
        Equivalencia other = (Equivalencia) object;
        if ((this.codEquivalencia == null && other.codEquivalencia != null) || (this.codEquivalencia != null && !this.codEquivalencia.equals(other.codEquivalencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Equivalencia[codEquivalencia=" + codEquivalencia + "]";
    }

}
