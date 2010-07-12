/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.view;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Martin
 */
@Entity
public class VendedorComision {

    @Id
    @Column
    private Long numRow;
    @Column
    private Long codProducto;
    @Column
    private BigDecimal porcentajeComision;
    @Column
    private BigInteger totalVenta;
    @Column
    private BigInteger totalComision;

    public VendedorComision() {
    }

    public Long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public Long getNumRow() {
        return numRow;
    }

    public void setNumRow(Long numRow) {
        this.numRow = numRow;
    }

    public BigDecimal getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(BigDecimal porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public BigInteger getTotalComision() {
        return totalComision;
    }

    public void setTotalComision(BigInteger totalComision) {
        this.totalComision = totalComision;
    }

    public BigInteger getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigInteger totalVenta) {
        this.totalVenta = totalVenta;
    }

    
}
