/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.view;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */

@Entity

public class MaquinariaCantidadHora implements Serializable {

@Column
@Id
private Long codMaquinaria;
@Column
private Long cantidadMinutos;

    public Long getCantidadMinutos() {
        return cantidadMinutos;
    }

    public void setCantidadMinutos(Long cantidadMinutos) {
        this.cantidadMinutos = cantidadMinutos;
    }

    public Long getCodMaquinaria() {
        return codMaquinaria;
    }

    public void setCodMaquinaria(Long codMaquinaria) {
        this.codMaquinaria = codMaquinaria;
    }



}
