/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "EXISTENCIA")
@NamedQueries({@NamedQuery(name = "Existencia.findAll", query = "SELECT e FROM Existencia e"), @NamedQuery(name = "Existencia.findByCodExistencia", query = "SELECT e FROM Existencia e WHERE e.existenciaPK.codExistencia = :codExistencia"), @NamedQuery(name = "Existencia.findByCodDeposito", query = "SELECT e FROM Existencia e WHERE e.existenciaPK.codDeposito = :codDeposito"), @NamedQuery(name = "Existencia.findByCantidadExistencia", query = "SELECT e FROM Existencia e WHERE e.cantidadExistencia = :cantidadExistencia"), @NamedQuery(name = "Existencia.findByUsuarioAlta", query = "SELECT e FROM Existencia e WHERE e.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "Existencia.findByUsuarioModif", query = "SELECT e FROM Existencia e WHERE e.usuarioModif = :usuarioModif"), @NamedQuery(name = "Existencia.findByFechaAlta", query = "SELECT e FROM Existencia e WHERE e.fechaAlta = :fechaAlta"), @NamedQuery(name = "Existencia.findByFechaModif", query = "SELECT e FROM Existencia e WHERE e.fechaModif = :fechaModif")})
public class Existencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExistenciaPK existenciaPK;
    @Column(name = "CANTIDAD_EXISTENCIA")
    private BigInteger cantidadExistencia;
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
    @JoinColumn(name = "COD_DEPOSITO", referencedColumnName = "COD_DEPOSITO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Deposito deposito;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto codProducto;

    public Existencia() {
    }

    public Existencia(ExistenciaPK existenciaPK) {
        this.existenciaPK = existenciaPK;
    }

    public Existencia(BigInteger codExistencia, BigInteger codDeposito) {
        this.existenciaPK = new ExistenciaPK(codExistencia, codDeposito);
    }

    public ExistenciaPK getExistenciaPK() {
        return existenciaPK;
    }

    public void setExistenciaPK(ExistenciaPK existenciaPK) {
        this.existenciaPK = existenciaPK;
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

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
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
        hash += (existenciaPK != null ? existenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Existencia)) {
            return false;
        }
        Existencia other = (Existencia) object;
        if ((this.existenciaPK == null && other.existenciaPK != null) || (this.existenciaPK != null && !this.existenciaPK.equals(other.existenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Existencia[existenciaPK=" + existenciaPK + "]";
    }

}
