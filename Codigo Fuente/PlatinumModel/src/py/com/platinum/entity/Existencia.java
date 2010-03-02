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
 * @author FerBoy
 */
@Entity
@SequenceGenerator(name = "SEQ_EXISTENCIA", sequenceName = "SQ_EXISTENCIA", initialValue = 1, allocationSize = 1)
@Table(name = "EXISTENCIA", catalog = "", schema = "PLATINUM")
@NamedQueries({@NamedQuery(name = "Existencia.findAll", query = "SELECT e FROM Existencia e"), @NamedQuery(name = "Existencia.findByCodExistencia", query = "SELECT e FROM Existencia e WHERE e.codExistencia = :codExistencia"), @NamedQuery(name = "Existencia.findByCantidadExistencia", query = "SELECT e FROM Existencia e WHERE e.cantidadExistencia = :cantidadExistencia"), @NamedQuery(name = "Existencia.findByUsuarioAlta", query = "SELECT e FROM Existencia e WHERE e.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "Existencia.findByUsuarioModif", query = "SELECT e FROM Existencia e WHERE e.usuarioModif = :usuarioModif"), @NamedQuery(name = "Existencia.findByFechaAlta", query = "SELECT e FROM Existencia e WHERE e.fechaAlta = :fechaAlta"), @NamedQuery(name = "Existencia.findByFechaModif", query = "SELECT e FROM Existencia e WHERE e.fechaModif = :fechaModif")})
public class Existencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EXISTENCIA")
    @Basic(optional = false)
    @Column(name = "COD_EXISTENCIA", nullable = false, precision = 22)
    private Long codExistencia;
    @Column(name = "CANTIDAD_EXISTENCIA")
    private BigInteger cantidadExistencia;
    @Column(name = "USUARIO_ALTA", length = 15)
    private String usuarioAlta;
    @Column(name = "USUARIO_MODIF", length = 15)
    private String usuarioModif;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "FECHA_MODIF")
    @Temporal(TemporalType.DATE)
    private Date fechaModif;
    @JoinColumn(name = "COD_DEPOSITO", referencedColumnName = "COD_DEPOSITO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Deposito codDeposito;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto codProducto;

    public Existencia() {
    }

    public Existencia(Long codExistencia) {
        this.codExistencia = codExistencia;
    }

    public Long getCodExistencia() {
        return codExistencia;
    }

    public void setCodExistencia(Long codExistencia) {
        this.codExistencia = codExistencia;
    }

    public BigInteger getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(BigInteger cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
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

    public Deposito getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(Deposito codDeposito) {
        this.codDeposito = codDeposito;
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
        hash += (codExistencia != null ? codExistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Existencia)) {
            return false;
        }
        Existencia other = (Existencia) object;
        if ((this.codExistencia == null && other.codExistencia != null) || (this.codExistencia != null && !this.codExistencia.equals(other.codExistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Existencia[codExistencia=" + codExistencia + "]";
    }

}
