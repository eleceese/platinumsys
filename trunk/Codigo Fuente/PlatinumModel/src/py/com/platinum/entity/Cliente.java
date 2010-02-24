/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CLIENTE")
@SequenceGenerator(name="CLIENTE_SEQUENCE", sequenceName="SEQ_BANCO", initialValue=1, allocationSize=1)
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CLIENTE_SEQUENCE")
    @Column(name = "COD_CLIENTE")
    private Long codCliente;
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;
    @Column(name = "APELLIDO_CLIENTE")
    private String apellidoCliente;
    @Column(name = "NUMERO_DOC_CLIENTE")
    private String numeroDocCliente;
    @Column(name = "TIPO_DOD_CLIENTE")
    private String tipoDodCliente;
    @Column(name = "RUC_CLIENTE")
    private String rucCliente;
    @Column(name = "DIRECCION_CLIENTE")
    private String direccionCliente;
    @Column(name = "TELEFONO1_CLIENTE")
    private String telefono1Cliente;
    @Column(name = "TELEFONO2_CLIENTE")
    private String telefono2Cliente;
    @Column(name = "MAIL_CLIENTE")
    private String mailCliente;
    @Column(name = "CONTACTO1_CLIENTE")
    private String contacto1Cliente;
    @Column(name = "CONTACTO2_CLIENTE")
    private String contacto2Cliente;
    @Column(name = "ESTADO_CLIENTE")
    private String estadoCliente;
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
    @OneToMany(mappedBy = "codCliente", fetch=FetchType.EAGER)
    private Set<PedidoCabecera> pedidoCabecera;
    @OneToMany(mappedBy = "codCliente", fetch=FetchType.EAGER)
    private Set<ReciboCabecera> reciboCabecera;
    @OneToMany(mappedBy = "codCliente", fetch=FetchType.EAGER)
    private Set<FacturaCabecera> facturaCabecera;
    @OneToMany(mappedBy = "codCliente", fetch=FetchType.EAGER)
    private Set<NotaCreditoCliCabecera> notaCreditoCliCabecera;
    @OneToMany(mappedBy = "codCliente", fetch=FetchType.EAGER)
    private Set<SaldoCliente> saldoCliente;
    @JoinColumn(name = "COD_CIUDAD", referencedColumnName = "CODCIUDAD")
    @ManyToOne
    private Ciudad codCiudad;

    public Cliente() {
    }

    public Cliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public Cliente(Long codCliente, String nombreCliente, String apellidoCliente, String numeroDocCliente, String tipoDodCliente) {
        this.codCliente = codCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.numeroDocCliente = numeroDocCliente;
        this.tipoDodCliente = tipoDodCliente;
    }

    public Long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getNumeroDocCliente() {
        return numeroDocCliente;
    }

    public void setNumeroDocCliente(String numeroDocCliente) {
        this.numeroDocCliente = numeroDocCliente;
    }

    public String getTipoDodCliente() {
        return tipoDodCliente;
    }

    public void setTipoDodCliente(String tipoDodCliente) {
        this.tipoDodCliente = tipoDodCliente;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefono1Cliente() {
        return telefono1Cliente;
    }

    public void setTelefono1Cliente(String telefono1Cliente) {
        this.telefono1Cliente = telefono1Cliente;
    }

    public String getTelefono2Cliente() {
        return telefono2Cliente;
    }

    public void setTelefono2Cliente(String telefono2Cliente) {
        this.telefono2Cliente = telefono2Cliente;
    }

    public String getMailCliente() {
        return mailCliente;
    }

    public void setMailCliente(String mailCliente) {
        this.mailCliente = mailCliente;
    }

    public String getContacto1Cliente() {
        return contacto1Cliente;
    }

    public void setContacto1Cliente(String contacto1Cliente) {
        this.contacto1Cliente = contacto1Cliente;
    }

    public String getContacto2Cliente() {
        return contacto2Cliente;
    }

    public void setContacto2Cliente(String contacto2Cliente) {
        this.contacto2Cliente = contacto2Cliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
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

    public Set<PedidoCabecera> getPedidoCabecera() {
        return pedidoCabecera;
    }

    public List<PedidoCabecera> getPedidoCabeceraList() {
        return new ArrayList(Arrays.asList(pedidoCabecera.toArray(new PedidoCabecera[0])));
    }

    public void setPedidoCabecera(Set<PedidoCabecera> pedidoCabecera) {
        this.pedidoCabecera = pedidoCabecera;
    }

    public Set<ReciboCabecera> getReciboCabecera() {
        return reciboCabecera;
    }

    public List<ReciboCabecera> getReciboCabeceraList() {
        return new ArrayList(Arrays.asList(reciboCabecera.toArray(new ReciboCabecera[0])));
    }

    public void setReciboCabecera(Set<ReciboCabecera> reciboCabecera) {
        this.reciboCabecera = reciboCabecera;
    }

    public Set<FacturaCabecera> getFacturaCabecera() {
        return facturaCabecera;
    }

    public List<FacturaCabecera> getFacturaCabeceraList() {
        return new ArrayList(Arrays.asList(facturaCabecera.toArray(new FacturaCabecera[0])));
    }

    public void setFacturaCabecera(Set<FacturaCabecera> facturaCabecera) {
        this.facturaCabecera = facturaCabecera;
    }

    public Set<NotaCreditoCliCabecera> getNotaCreditoCliCabecera() {
        return notaCreditoCliCabecera;
    }

    public List<NotaCreditoCliCabecera> getNotaCreditoCliCabeceraList() {
        return new ArrayList(Arrays.asList(notaCreditoCliCabecera.toArray(new NotaCreditoCliCabecera[0])));
    }

    public void setNotaCreditoCliCabecera(Set<NotaCreditoCliCabecera> notaCreditoCliCabecera) {
        this.notaCreditoCliCabecera = notaCreditoCliCabecera;
    }

    public Set<SaldoCliente> getSaldoCliente() {
        return saldoCliente;
    }

    public List<SaldoCliente> getSaldoClienteList() {
        return new ArrayList(Arrays.asList(saldoCliente.toArray(new SaldoCliente[0])));
    }

    public void setSaldoCliente(Set<SaldoCliente> saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public Ciudad getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Ciudad codCiudad) {
        this.codCiudad = codCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.apellidoCliente + ", " + this.nombreCliente;
    }

}
