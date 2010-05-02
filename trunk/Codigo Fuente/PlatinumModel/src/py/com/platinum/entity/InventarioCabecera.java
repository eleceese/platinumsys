/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@SequenceGenerator(name="INVENTARIO_CABECERA_SEQUENCE", sequenceName="sq_cabecera_inventario", initialValue=1, allocationSize=1)
@Table(name = "INVENTARIO_CABECERA")
@NamedQueries({@NamedQuery(name = "InventarioCabecera.findAll", query = "SELECT i FROM InventarioCabecera i"), @NamedQuery(name = "InventarioCabecera.findByCodInventario", query = "SELECT i FROM InventarioCabecera i WHERE i.codInventario = :codInventario"), @NamedQuery(name = "InventarioCabecera.findByFecInventario", query = "SELECT i FROM InventarioCabecera i WHERE i.fecInventario = :fecInventario"), @NamedQuery(name = "InventarioCabecera.findByDescripcion", query = "SELECT i FROM InventarioCabecera i WHERE i.descripcion = :descripcion"), @NamedQuery(name = "InventarioCabecera.findByEstado", query = "SELECT i FROM InventarioCabecera i WHERE i.estado = :estado"), @NamedQuery(name = "InventarioCabecera.findByUsuarioAlta", query = "SELECT i FROM InventarioCabecera i WHERE i.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "InventarioCabecera.findByUsuarioModif", query = "SELECT i FROM InventarioCabecera i WHERE i.usuarioModif = :usuarioModif"), @NamedQuery(name = "InventarioCabecera.findByFechaAlta", query = "SELECT i FROM InventarioCabecera i WHERE i.fechaAlta = :fechaAlta"), @NamedQuery(name = "InventarioCabecera.findByFechaModif", query = "SELECT i FROM InventarioCabecera i WHERE i.fechaModif = :fechaModif")})
public class InventarioCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="INVENTARIO_CABECERA_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_INVENTARIO")
    private Long codInventario;
    @Basic(optional = false)
    @Column(name = "FEC_INVENTARIO")
    @Temporal(TemporalType.DATE)
    private Date fecInventario;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADO")
    private String estado;
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
    @OneToMany(mappedBy = "codInventario",fetch=FetchType.EAGER)
    private Set<InventarioDetalle> inventarioDetalleSetCollection;
    @JoinColumn(name = "COD_DEPOSITO", referencedColumnName = "COD_DEPOSITO")
    @ManyToOne(optional = false)
    private Deposito codDeposito;
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado codEmpleado;

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }


    public InventarioCabecera() {
    }

    public InventarioCabecera(Long codInventario) {
        this.codInventario = codInventario;
    }

    public InventarioCabecera(Long codInventario, Date fecInventario) {
        this.codInventario = codInventario;
        this.fecInventario = fecInventario;
    }

    public Long getCodInventario() {
        return codInventario;
    }

    public void setCodInventario(Long codInventario) {
        this.codInventario = codInventario;
    }

    public Date getFecInventario() {
        return fecInventario;
    }

    public void setFecInventario(Date fecInventario) {
        this.fecInventario = fecInventario;
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

    public Set<InventarioDetalle> getInventarioDetalleSetCollection() {
        return inventarioDetalleSetCollection;
    }


    public List<InventarioDetalle> getInventarioDetalleCollection() {
        return new ArrayList(Arrays.asList(inventarioDetalleSetCollection.toArray(new InventarioDetalle[0])));
    }

    


    public void setInventarioDetalleSetCollection(Set<InventarioDetalle> inventarioDetalleSetCollection) {
        this.inventarioDetalleSetCollection = inventarioDetalleSetCollection;
    }

    public Deposito getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(Deposito codDeposito) {
        this.codDeposito = codDeposito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInventario != null ? codInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioCabecera)) {
            return false;
        }
        InventarioCabecera other = (InventarioCabecera) object;
        if ((this.codInventario == null && other.codInventario != null) || (this.codInventario != null && !this.codInventario.equals(other.codInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.InventarioCabecera[codInventario=" + codInventario + "]";
    }

}
