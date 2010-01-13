/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "COMISION_MENS_CAB")
@NamedQueries({@NamedQuery(name = "ComisionMensCab.findAll", query = "SELECT c FROM ComisionMensCab c"), @NamedQuery(name = "ComisionMensCab.findByCodComMenCab", query = "SELECT c FROM ComisionMensCab c WHERE c.codComMenCab = :codComMenCab"), @NamedQuery(name = "ComisionMensCab.findByFecha", query = "SELECT c FROM ComisionMensCab c WHERE c.fecha = :fecha"), @NamedQuery(name = "ComisionMensCab.findByFecInicial", query = "SELECT c FROM ComisionMensCab c WHERE c.fecInicial = :fecInicial"), @NamedQuery(name = "ComisionMensCab.findByFecFinal", query = "SELECT c FROM ComisionMensCab c WHERE c.fecFinal = :fecFinal"), @NamedQuery(name = "ComisionMensCab.findByEstado", query = "SELECT c FROM ComisionMensCab c WHERE c.estado = :estado"), @NamedQuery(name = "ComisionMensCab.findByTotal", query = "SELECT c FROM ComisionMensCab c WHERE c.total = :total"), @NamedQuery(name = "ComisionMensCab.findByUsuarioAlta", query = "SELECT c FROM ComisionMensCab c WHERE c.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "ComisionMensCab.findByUsuarioModif", query = "SELECT c FROM ComisionMensCab c WHERE c.usuarioModif = :usuarioModif"), @NamedQuery(name = "ComisionMensCab.findByFechaAlta", query = "SELECT c FROM ComisionMensCab c WHERE c.fechaAlta = :fechaAlta"), @NamedQuery(name = "ComisionMensCab.findByFechaModif", query = "SELECT c FROM ComisionMensCab c WHERE c.fechaModif = :fechaModif")})
public class ComisionMensCab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_COM_MEN_CAB")
    private Long codComMenCab;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "FEC_INICIAL")
    @Temporal(TemporalType.DATE)
    private Date fecInicial;
    @Column(name = "FEC_FINAL")
    @Temporal(TemporalType.DATE)
    private Date fecFinal;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "TOTAL")
    private Long total;
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
    @JoinColumn(name = "COD_EMPLEADO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne
    private Empleado codEmpleado;
    @OneToMany(mappedBy = "codComMenCab")
    private List<ComisionMensDet> comisionMensDetCollection;

    public ComisionMensCab() {
    }

    public ComisionMensCab(Long codComMenCab) {
        this.codComMenCab = codComMenCab;
    }

    public Long getCodComMenCab() {
        return codComMenCab;
    }

    public void setCodComMenCab(Long codComMenCab) {
        this.codComMenCab = codComMenCab;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecInicial() {
        return fecInicial;
    }

    public void setFecInicial(Date fecInicial) {
        this.fecInicial = fecInicial;
    }

    public Date getFecFinal() {
        return fecFinal;
    }

    public void setFecFinal(Date fecFinal) {
        this.fecFinal = fecFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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

    public Empleado getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Empleado codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public List<ComisionMensDet> getComisionMensDetCollection() {
        return comisionMensDetCollection;
    }

    public void setComisionMensDetCollection(List<ComisionMensDet> comisionMensDetCollection) {
        this.comisionMensDetCollection = comisionMensDetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codComMenCab != null ? codComMenCab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComisionMensCab)) {
            return false;
        }
        ComisionMensCab other = (ComisionMensCab) object;
        if ((this.codComMenCab == null && other.codComMenCab != null) || (this.codComMenCab != null && !this.codComMenCab.equals(other.codComMenCab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.ComisionMensCab[codComMenCab=" + codComMenCab + "]";
    }

}
