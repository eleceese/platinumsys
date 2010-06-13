/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author FerBoy
 */
@Entity
@Table(name = "PARAMETROS", catalog = "", schema = "PLATINUM")
@NamedQueries({@NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p"), @NamedQuery(name = "Parametros.findByCodParametro", query = "SELECT p FROM Parametros p WHERE p.codParametro = :codParametro"), @NamedQuery(name = "Parametros.findByDescripcion", query = "SELECT p FROM Parametros p WHERE p.descripcion = :descripcion"), @NamedQuery(name = "Parametros.findByValorNumero", query = "SELECT p FROM Parametros p WHERE p.valorNumero = :valorNumero"), @NamedQuery(name = "Parametros.findByValorTexto", query = "SELECT p FROM Parametros p WHERE p.valorTexto = :valorTexto")})
public class Parametros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_PARAMETRO", nullable = false)
    private Long codParametro;
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;
    @Column(name = "VALOR_NUMERO")
    private Long valorNumero;
    @Column(name = "VALOR_TEXTO", length = 30)
    private String valorTexto;

    public Parametros() {
    }

    public Parametros(Long codParametro) {
        this.codParametro = codParametro;
    }

    public Long getCodParametro() {
        return codParametro;
    }

    public void setCodParametro(Long codParametro) {
        this.codParametro = codParametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getValorNumero() {
        return valorNumero;
    }

    public void setValorNumero(Long valorNumero) {
        this.valorNumero = valorNumero;
    }

    public String getValorTexto() {
        return valorTexto;
    }

    public void setValorTexto(String valorTexto) {
        this.valorTexto = valorTexto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codParametro != null ? codParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.codParametro == null && other.codParametro != null) || (this.codParametro != null && !this.codParametro.equals(other.codParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Parametros[codParametro=" + codParametro + "]";
    }

}
