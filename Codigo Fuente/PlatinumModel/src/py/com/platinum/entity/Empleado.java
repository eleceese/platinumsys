/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author FerBoy
 */
@Entity
@Table(name = "EMPLEADO", catalog = "", schema = "PLATINUM")
@NamedQueries({@NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_EMPLEADO")
    private BigDecimal codEmpleado;
    @Basic(optional = false)
    @Column(name = "NOMBRE_EMPLEADO")
    private String nombreEmpleado;
    @Basic(optional = false)
    @Column(name = "APELLIDO_EMPLEADO")
    private String apellidoEmpleado;
    @Column(name = "CIN_EMPLEADO")
    private String cinEmpleado;
    @Column(name = "ESTADO_CIVIL_EMPLEADO")
    private String estadoCivilEmpleado;
    @Column(name = "SEXO_EMPLEADO")
    private String sexoEmpleado;
    @Column(name = "NACIONALIDAD_EMPLEADO")
    private String nacionalidadEmpleado;
    @Column(name = "FECHA_NACIMIENTO_EMPLEADO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimientoEmpleado;
    @Column(name = "DIRECCION_EMPLEADO")
    private String direccionEmpleado;
    @Column(name = "TELEFONO1_EMPLEADO")
    private String telefono1Empleado;
    @Column(name = "TELEFONO2_EMPLEADO")
    private String telefono2Empleado;
    @Column(name = "MAIL_EMPLEADO")
    private String mailEmpleado;
    @Column(name = "FECHA_INGRESO_EMPLEADO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoEmpleado;
    @Column(name = "IPS_EMPLEADO")
    private String ipsEmpleado;
    @Column(name = "HIJOS_EMPLEADO")
    private BigInteger hijosEmpleado;
    @Column(name = "SALARIO_EMPLEADO")
    private BigInteger salarioEmpleado;
    @Column(name = "TIPO_EMPLEADO")
    private String tipoEmpleado;
    @Column(name = "ESTADO_EMPLEADO")
    private String estadoEmpleado;
    @JoinColumn(name = "COD_CARGO", referencedColumnName = "COD_CARGO")
    @ManyToOne(optional = false)
    private Cargo codCargo;
    @JoinColumn(name = "COD_SECCION", referencedColumnName = "COD_SECCION")
    @ManyToOne(optional = false)
    private Seccion codSeccion;

    public Empleado() {
    }

    public Empleado(BigDecimal codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public Empleado(BigDecimal codEmpleado, String nombreEmpleado, String apellidoEmpleado) {
        this.codEmpleado = codEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public BigDecimal getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(BigDecimal codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getCinEmpleado() {
        return cinEmpleado;
    }

    public void setCinEmpleado(String cinEmpleado) {
        this.cinEmpleado = cinEmpleado;
    }

    public String getEstadoCivilEmpleado() {
        return estadoCivilEmpleado;
    }

    public void setEstadoCivilEmpleado(String estadoCivilEmpleado) {
        this.estadoCivilEmpleado = estadoCivilEmpleado;
    }

    public String getSexoEmpleado() {
        return sexoEmpleado;
    }

    public void setSexoEmpleado(String sexoEmpleado) {
        this.sexoEmpleado = sexoEmpleado;
    }

    public String getNacionalidadEmpleado() {
        return nacionalidadEmpleado;
    }

    public void setNacionalidadEmpleado(String nacionalidadEmpleado) {
        this.nacionalidadEmpleado = nacionalidadEmpleado;
    }

    public Date getFechaNacimientoEmpleado() {
        return fechaNacimientoEmpleado;
    }

    public void setFechaNacimientoEmpleado(Date fechaNacimientoEmpleado) {
        this.fechaNacimientoEmpleado = fechaNacimientoEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public String getTelefono1Empleado() {
        return telefono1Empleado;
    }

    public void setTelefono1Empleado(String telefono1Empleado) {
        this.telefono1Empleado = telefono1Empleado;
    }

    public String getTelefono2Empleado() {
        return telefono2Empleado;
    }

    public void setTelefono2Empleado(String telefono2Empleado) {
        this.telefono2Empleado = telefono2Empleado;
    }

    public String getMailEmpleado() {
        return mailEmpleado;
    }

    public void setMailEmpleado(String mailEmpleado) {
        this.mailEmpleado = mailEmpleado;
    }

    public Date getFechaIngresoEmpleado() {
        return fechaIngresoEmpleado;
    }

    public void setFechaIngresoEmpleado(Date fechaIngresoEmpleado) {
        this.fechaIngresoEmpleado = fechaIngresoEmpleado;
    }

    public String getIpsEmpleado() {
        return ipsEmpleado;
    }

    public void setIpsEmpleado(String ipsEmpleado) {
        this.ipsEmpleado = ipsEmpleado;
    }

    public BigInteger getHijosEmpleado() {
        return hijosEmpleado;
    }

    public void setHijosEmpleado(BigInteger hijosEmpleado) {
        this.hijosEmpleado = hijosEmpleado;
    }

    public BigInteger getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(BigInteger salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public Cargo getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(Cargo codCargo) {
        this.codCargo = codCargo;
    }

    public Seccion getCodSeccion() {
        return codSeccion;
    }

    public void setCodSeccion(Seccion codSeccion) {
        this.codSeccion = codSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpleado != null ? codEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.codEmpleado == null && other.codEmpleado != null) || (this.codEmpleado != null && !this.codEmpleado.equals(other.codEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.Empleado[codEmpleado=" + codEmpleado + "]";
    }

}
