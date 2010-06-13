/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author FerBoy
 */
@Entity
@Table(name = "MAQUINARIAS", catalog = "", schema = "PLATINUM")
@SequenceGenerator(name="MAQUINARIA_SEQUENCE", sequenceName="SQ_MAQUINARIAS", initialValue=1, allocationSize=1)
public class Maquinarias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MAQUINARIA_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_MAQUINARIA", nullable = false)
    private Long codMaquinaria;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 4000)
    private String descripcion;
    @Column(name = "CONSUMO_KWH")
    private Long consumoKwh;
    @Column(name = "COSTO_MANTENIMIENTO")
    private Long costoMantenimiento;
    @Column(name = "HORAS_MANTENIMENTO")
    private Long horasMantenimento;

 
    public Maquinarias() {
    }

    public Maquinarias(Long codMaquinaria) {
        this.codMaquinaria = codMaquinaria;
    }

    public Maquinarias(Long codMaquinaria, String descripcion) {
        this.codMaquinaria = codMaquinaria;
        this.descripcion = descripcion;
    }

    public Long getCodMaquinaria() {
        return codMaquinaria;
    }

    public void setCodMaquinaria(Long codMaquinaria) {
        this.codMaquinaria = codMaquinaria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getConsumoKwh() {
        return consumoKwh;
    }

    public void setConsumoKwh(Long consumoKwh) {
        this.consumoKwh = consumoKwh;
    }

    public Long getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(Long costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }

    public Long getHorasMantenimento() {
        return horasMantenimento;
    }

    public void setHorasMantenimento(Long horasMantenimento) {
        this.horasMantenimento = horasMantenimento;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMaquinaria != null ? codMaquinaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquinarias)) {
            return false;
        }
        Maquinarias other = (Maquinarias) object;
        if ((this.codMaquinaria == null && other.codMaquinaria != null) || (this.codMaquinaria != null && !this.codMaquinaria.equals(other.codMaquinaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
