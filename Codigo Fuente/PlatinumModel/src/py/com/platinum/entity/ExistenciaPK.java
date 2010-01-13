/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Martin
 */
@Embeddable
public class ExistenciaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_EXISTENCIA")
    private BigInteger codExistencia;
    @Basic(optional = false)
    @Column(name = "COD_DEPOSITO")
    private BigInteger codDeposito;

    public ExistenciaPK(BigInteger codExistencia, BigInteger codDeposito) {
        this.codExistencia = codExistencia;
        this.codDeposito = codDeposito;
    }

    public BigInteger getCodExistencia() {
        return codExistencia;
    }

    public void setCodExistencia(BigInteger codExistencia) {
        this.codExistencia = codExistencia;
    }

    public BigInteger getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(BigInteger codDeposito) {
        this.codDeposito = codDeposito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codExistencia != null ? codExistencia.hashCode() : 0);
        hash += (codDeposito != null ? codDeposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExistenciaPK)) {
            return false;
        }
        ExistenciaPK other = (ExistenciaPK) object;
        if ((this.codExistencia == null && other.codExistencia != null) || (this.codExistencia != null && !this.codExistencia.equals(other.codExistencia))) {
            return false;
        }
        if ((this.codDeposito == null && other.codDeposito != null) || (this.codDeposito != null && !this.codDeposito.equals(other.codDeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.ExistenciaPK[codExistencia=" + codExistencia + ", codDeposito=" + codDeposito + "]";
    }

}
