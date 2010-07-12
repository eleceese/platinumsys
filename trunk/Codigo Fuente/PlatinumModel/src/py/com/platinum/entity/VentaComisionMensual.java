/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "VENTA_COMISION_MENSUAL")
@SequenceGenerator(name="VENTA_COMISION_MENSUAL_SEQUENCE", sequenceName="SQ_VENTA_COMISION_MENSUAL")
public class VentaComisionMensual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="VENTA_COMISION_MENSUAL_SEQUENCE")
    @Column(name = "COD_COMISION")
    private Long codComision;
    @Column(name = "MES")
    private String mes;
    @Column(name = "ANIO")
    private String anio;
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
    @OneToMany(mappedBy = "codComision")
    private Set<ComisionMensCab> comisionMensCabCollection;


    public VentaComisionMensual() {
    }

    public VentaComisionMensual(Long codComision) {
        this.codComision = codComision;
    }

    public Long getCodComision() {
        return codComision;
    }

    public void setCodComision(Long codComision) {
        this.codComision = codComision;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
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

    public Set<ComisionMensCab> getComisionMensCabCollection() {
        return comisionMensCabCollection;
    }

    public void setComisionMensCabCollection(Set<ComisionMensCab> comisionMensCabCollection) {
        this.comisionMensCabCollection = comisionMensCabCollection;
    }
 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codComision != null ? codComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaComisionMensual)) {
            return false;
        }
        VentaComisionMensual other = (VentaComisionMensual) object;
        if ((this.codComision == null && other.codComision != null) || (this.codComision != null && !this.codComision.equals(other.codComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.VentaComisionMensual[codComision=" + codComision + "]";
    }

}
