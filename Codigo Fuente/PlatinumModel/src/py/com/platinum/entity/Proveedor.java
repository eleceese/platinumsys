/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({@NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"), @NamedQuery(name = "Proveedor.findByCodProveedor", query = "SELECT p FROM Proveedor p WHERE p.codProveedor = :codProveedor"), @NamedQuery(name = "Proveedor.findByNombreProveedor", query = "SELECT p FROM Proveedor p WHERE p.nombreProveedor = :nombreProveedor"), @NamedQuery(name = "Proveedor.findByRucProveedor", query = "SELECT p FROM Proveedor p WHERE p.rucProveedor = :rucProveedor"), @NamedQuery(name = "Proveedor.findByTelefono1Proveedor", query = "SELECT p FROM Proveedor p WHERE p.telefono1Proveedor = :telefono1Proveedor"), @NamedQuery(name = "Proveedor.findByTelefono2Proveedor", query = "SELECT p FROM Proveedor p WHERE p.telefono2Proveedor = :telefono2Proveedor"), @NamedQuery(name = "Proveedor.findByDireccionProveedor", query = "SELECT p FROM Proveedor p WHERE p.direccionProveedor = :direccionProveedor"), @NamedQuery(name = "Proveedor.findByMailProveedor", query = "SELECT p FROM Proveedor p WHERE p.mailProveedor = :mailProveedor"), @NamedQuery(name = "Proveedor.findByContactoProveedor", query = "SELECT p FROM Proveedor p WHERE p.contactoProveedor = :contactoProveedor"), @NamedQuery(name = "Proveedor.findByEstadoProveedor", query = "SELECT p FROM Proveedor p WHERE p.estadoProveedor = :estadoProveedor"), @NamedQuery(name = "Proveedor.findByUsuarioAlta", query = "SELECT p FROM Proveedor p WHERE p.usuarioAlta = :usuarioAlta"), @NamedQuery(name = "Proveedor.findByUsuarioModif", query = "SELECT p FROM Proveedor p WHERE p.usuarioModif = :usuarioModif"), @NamedQuery(name = "Proveedor.findByFechaAlta", query = "SELECT p FROM Proveedor p WHERE p.fechaAlta = :fechaAlta"), @NamedQuery(name = "Proveedor.findByFechaModif", query = "SELECT p FROM Proveedor p WHERE p.fechaModif = :fechaModif")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PROVEEDOR_SEQUENCE")
    @Basic(optional = false)
    @Column(name = "COD_PROVEEDOR")
    private Long codProveedor;
    @Basic(optional = false)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProveedor")
    private List<FacturaCompraCab> facturaCompraCabCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProveedor")
    private List<NotaCreditoProvCab> notaCreditoProvCabCollection;

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

    public List<FacturaCompraCab> getFacturaCompraCabCollection() {
        return facturaCompraCabCollection;
    }

    public void setFacturaCompraCabCollection(List<FacturaCompraCab> facturaCompraCabCollection) {
        this.facturaCompraCabCollection = facturaCompraCabCollection;
    }

    public List<NotaCreditoProvCab> getNotaCreditoProvCabCollection() {
        return notaCreditoProvCabCollection;
    }

    public void setNotaCreditoProvCabCollection(List<NotaCreditoProvCab> notaCreditoProvCabCollection) {
        this.notaCreditoProvCabCollection = notaCreditoProvCabCollection;
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
