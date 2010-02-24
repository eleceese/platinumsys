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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@SequenceGenerator(name="PROVEEDOR_SEQUENCE", sequenceName="SQ_PROVEEDOR", initialValue=1, allocationSize=1)
@Table(name = "PROVEEDOR")
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PROVEEDOR_SEQUENCE")
    @Column(name = "COD_PROVEEDOR")
    private Long codProveedor;
    @Column(name = "NOMBRE_PROVEEDOR")
    private String nombreProveedor;
    @Column(name = "RUC_PROVEEDOR")
    private String rucProveedor;
    @Column(name = "TELEFONO1_PROVEEDOR")
    private String telefono1Proveedor;
    @Column(name = "TELEFONO2_PROVEEDOR")
    private String telefono2Proveedor;
    @Column(name = "DIRECCION_PROVEEDOR")
    private String direccionProveedor;
    @Column(name = "MAIL_PROVEEDOR")
    private String mailProveedor;
    @Column(name = "CONTACTO_PROVEEDOR")
    private String contactoProveedor;
    @Column(name = "ESTADO_PROVEEDOR")
    private String estadoProveedor;
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
    @OneToMany(mappedBy = "codProveedor", fetch=FetchType.EAGER)
    private Set<FacturaCompraCab> facturaCompraCab;
    @OneToMany(mappedBy = "codProveedor", fetch=FetchType.EAGER)
    private Set<NotaCreditoProvCab> notaCreditoProvCab;


    public Proveedor() {
    }

    public Proveedor(Long codProveedor) {
        this.codProveedor = codProveedor;
    }

    public Proveedor(Long codProveedor, String nombreProveedor) {
        this.codProveedor = codProveedor;
        this.nombreProveedor = nombreProveedor;
    }

    public Long getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Long codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getRucProveedor() {
        return rucProveedor;
    }

    public void setRucProveedor(String rucProveedor) {
        this.rucProveedor = rucProveedor;
    }

    public String getTelefono1Proveedor() {
        return telefono1Proveedor;
    }

    public void setTelefono1Proveedor(String telefono1Proveedor) {
        this.telefono1Proveedor = telefono1Proveedor;
    }

    public String getTelefono2Proveedor() {
        return telefono2Proveedor;
    }

    public void setTelefono2Proveedor(String telefono2Proveedor) {
        this.telefono2Proveedor = telefono2Proveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getMailProveedor() {
        return mailProveedor;
    }

    public void setMailProveedor(String mailProveedor) {
        this.mailProveedor = mailProveedor;
    }

    public String getContactoProveedor() {
        return contactoProveedor;
    }

    public void setContactoProveedor(String contactoProveedor) {
        this.contactoProveedor = contactoProveedor;
    }

    public String getEstadoProveedor() {
        return estadoProveedor;
    }

    public void setEstadoProveedor(String estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
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

    public Set<FacturaCompraCab> getFacturaCompraCab() {
        return facturaCompraCab;
    }

    public List<FacturaCompraCab> getFacturaCompraCabList() {
        return new ArrayList(Arrays.asList(facturaCompraCab.toArray(new FacturaCompraCab[0])));
    }

    public void setFacturaCompraCab(Set<FacturaCompraCab> facturaCompraCab) {
        this.facturaCompraCab = facturaCompraCab;
    }

    public Set<NotaCreditoProvCab> getNotaCreditoProvCab() {
        return notaCreditoProvCab;
    }

    public List<NotaCreditoProvCab> getNotaCreditoProvCabList() {
        return new ArrayList(Arrays.asList(notaCreditoProvCab.toArray(new NotaCreditoProvCab[0])));
    }

    public void setNotaCreditoProvCab(Set<NotaCreditoProvCab> notaCreditoProvCab) {
        this.notaCreditoProvCab = notaCreditoProvCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProveedor != null ? codProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.codProveedor == null && other.codProveedor != null) || (this.codProveedor != null && !this.codProveedor.equals(other.codProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreProveedor;
    }

}
