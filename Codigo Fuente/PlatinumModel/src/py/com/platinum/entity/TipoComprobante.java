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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author mjara
 */
@Entity
@SequenceGenerator(name="TIPO_COMPROBANTE_SEQUENCE", sequenceName="SQ_TIPO_COMPROBANTE")
@Table(name = "TIPO_COMPROBANTE")
public class TipoComprobante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TIPO_COMPROBANTE_SEQUENCE")
    @Column(name = "COD_TIPO", nullable = false)
    private Long codTipo;
    @Column(name = "DESC_TIPO", nullable = false, length = 50)
    private String descTipo;
    @Column(name = "CANT_DIAS", nullable = false)
    private int cantDias;
    @Column(name = "MODULO", length = 30)
    private String modulo;
    @OneToMany(mappedBy = "tipo", fetch = FetchType.EAGER)
    private Set<FacturaCompraCab> facturaCompraCab;

    public TipoComprobante() {
    }

    public TipoComprobante(Long codTipo) {
        this.codTipo = codTipo;
    }

    public TipoComprobante(Long codTipo, String descTipo, int cantDias) {
        this.codTipo = codTipo;
        this.descTipo = descTipo;
        this.cantDias = cantDias;
    }

    public Long getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(Long codTipo) {
        this.codTipo = codTipo;
    }

    public String getDescTipo() {
        return descTipo;
    }

    public void setDescTipo(String descTipo) {
        this.descTipo = descTipo;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public Set<FacturaCompraCab> getFacturaCompraCab() {
        return facturaCompraCab;
    }

    public void setFacturaCompraCab(Set<FacturaCompraCab> facturaCompraCab) {
        this.facturaCompraCab = facturaCompraCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipo != null ? codTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoComprobante)) {
            return false;
        }
        TipoComprobante other = (TipoComprobante) object;
        if ((this.codTipo == null && other.codTipo != null) || (this.codTipo != null && !this.codTipo.equals(other.codTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descTipo;
    }

}
