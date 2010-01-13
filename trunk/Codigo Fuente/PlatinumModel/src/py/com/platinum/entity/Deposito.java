/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "DEPOSITO")
@NamedQueries({@NamedQuery(name = "Deposito.findAll", query = "SELECT d FROM Deposito d"), @NamedQuery(name = "Deposito.findByCodDeposito", query = "SELECT d FROM Deposito d WHERE d.codDeposito = :codDeposito"), @NamedQuery(name = "Deposito.findByNombre", query = "SELECT d FROM Deposito d WHERE d.nombre = :nombre"), @NamedQuery(name = "Deposito.findByUsuarioAlta", query = "SELECT d FROM Deposito d WHERE d.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "Deposito.findByUsuarioModif", query = "SELECT d FROM Deposito d WHERE d.usuarioModif = :usuarioModif"), @NamedQuery(name = "Deposito.findByFechaAlta", query = "SELECT d FROM Deposito d WHERE d.fechaAlta = :fechaAlta"), @NamedQuery(name = "Deposito.findByFechaModif", query = "SELECT d FROM Deposito d WHERE d.fechaModif = :fechaModif")})
public class Deposito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_DEPOSITO")
    private BigDecimal codDeposito;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDeposito")
    private List<EntradaSalidaCabecera> entradaSalidaCabeceraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDeposito")
    private List<InventarioCabecera> inventarioCabeceraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deposito")
    private List<Existencia> existenciaCollection;

    public Deposito() {
    }

    public Deposito(BigDecimal codDeposito) {
        this.codDeposito = codDeposito;
    }

    public Deposito(BigDecimal codDeposito, String nombre) {
        this.codDeposito = codDeposito;
        this.nombre = nombre;
    }

    public BigDecimal getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(BigDecimal codDeposito) {
        this.codDeposito = codDeposito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<EntradaSalidaCabecera> getEntradaSalidaCabeceraCollection() {
        return entradaSalidaCabeceraCollection;
    }

    public void setEntradaSalidaCabeceraCollection(List<EntradaSalidaCabecera> entradaSalidaCabeceraCollection) {
        this.entradaSalidaCabeceraCollection = entradaSalidaCabeceraCollection;
    }

    public List<InventarioCabecera> getInventarioCabeceraCollection() {
        return inventarioCabeceraCollection;
    }

    public void setInventarioCabeceraCollection(List<InventarioCabecera> inventarioCabeceraCollection) {
        this.inventarioCabeceraCollection = inventarioCabeceraCollection;
    }

    public List<Existencia> getExistenciaCollection() {
        return existenciaCollection;
    }

    public void setExistenciaCollection(List<Existencia> existenciaCollection) {
        this.existenciaCollection = existenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDeposito != null ? codDeposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deposito)) {
            return false;
        }
        Deposito other = (Deposito) object;
        if ((this.codDeposito == null && other.codDeposito != null) || (this.codDeposito != null && !this.codDeposito.equals(other.codDeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Deposito[codDeposito=" + codDeposito + "]";
    }

}
