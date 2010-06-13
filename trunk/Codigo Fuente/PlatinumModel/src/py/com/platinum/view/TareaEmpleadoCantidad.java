/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author FerBoy
 */

@Entity
public class TareaEmpleadoCantidad {

@Column
@Id
private Long codEmpleado;
@Column
private Long cantidadTiempo;

    public Long getCantidadTiempo() {
        return cantidadTiempo;
    }

    public void setCantidadTiempo(Long cantidadTiempo) {
        this.cantidadTiempo = cantidadTiempo;
    }

    public Long getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Long codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    
}
