/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.platinum.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import py.com.platinum.listener.NotaCreditoProvCabeceraListener;
import py.com.platinum.utilsenum.NotaCreditoEstado;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "NOTA_CREDITO_PROV_CAB")
@EntityListeners(value=NotaCreditoProvCabeceraListener.class)
@SequenceGenerator(name="NC_PROV_CAB_SEQUENCE", sequenceName="SQ_NOTA_CREDITO_PROV_CAB", initialValue=1, allocationSize=1)
public class NotaCreditoProvCab implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "COD_NOT_CRE_CAB")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="NC_PROV_CAB_SEQUENCE")
    private Long codNotCreCab;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "NRO_NOTA_CREDITO")
    private String nroNotaCredito;
    @JoinColumn(name = "TIPO", referencedColumnName = "COD_TIPO")
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoComprobante tipo;
    @Column(name = "ESTADO")
    @Enumerated(EnumType.STRING)
    private NotaCreditoEstado estado;
    @Column(name = "ESTABLECIMIENTO")
    private String establecimiento;
    @Column(name = "BOCA_EXPENDIO")
    private String bocaExpendio;
    @Column(name = "TOTAL")
    private Long total;
    @Column(name = "SUB_TOTAL")
    private Long subTotal;
    @Column(name = "TOTAL_IVA")
    private Long totalIva;
    @Column(name = "SALDO_FAC")
    private Long saldoFac;
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
    @OneToMany(mappedBy = "codNotCreCab", fetch=FetchType.EAGER)
    private List<NotaCreditoProvDet> notaCreditoProvDet;
    @JoinColumn(name = "COD_FACTURA_CAB", referencedColumnName = "COD_FAC_COM_CAB")
    @ManyToOne
    private FacturaCompraCab codFacturaCab;
    @JoinColumn(name = "COD_PROVEEDOR", referencedColumnName = "COD_PROVEEDOR")
    @ManyToOne
    private Proveedor codProveedor;
    @JoinColumn(name = "COD_DEPOSITO", referencedColumnName = "COD_DEPOSITO", nullable=false)
    @ManyToOne(fetch=FetchType.EAGER)
    private Deposito codDeposito;
    
    public NotaCreditoProvCab() {
    }

    public NotaCreditoProvCab(Long codNotCreCab) {
        this.codNotCreCab = codNotCreCab;
    }

    public NotaCreditoProvCab(Long codNotCreCab, Date fecha, String nroNotaCredito, NotaCreditoEstado estado, Long total, Long totalIva, Long saldoFac) {
        this.codNotCreCab = codNotCreCab;
        this.fecha = fecha;
        this.nroNotaCredito = nroNotaCredito;
        this.estado = estado;
        this.total = total;
        this.totalIva = totalIva;
        this.saldoFac = saldoFac;
    }

    public Long getCodNotCreCab() {
        return codNotCreCab;
    }

    public void setCodNotCreCab(Long codNotCreCab) {
        this.codNotCreCab = codNotCreCab;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNroNotaCredito() {
        return nroNotaCredito;
    }

    public void setNroNotaCredito(String nroNotaCredito) {
        this.nroNotaCredito = nroNotaCredito;
    }

    public TipoComprobante getTipo() {
        return tipo;
    }

    public void setTipo(TipoComprobante tipo) {
        this.tipo = tipo;
    }

    public NotaCreditoEstado getEstado() {
        return estado;
    }

    public void setEstado(NotaCreditoEstado estado) {
        this.estado = estado;
    }

    public String getBocaExpendio() {
        return bocaExpendio;
    }

    public void setBocaExpendio(String bocaExpendio) {
        this.bocaExpendio = bocaExpendio;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Long subTotal) {
        this.subTotal = subTotal;
    }

    public Long getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Long totalIva) {
        this.totalIva = totalIva;
    }

    public Long getSaldoFac() {
        return saldoFac;
    }

    public void setSaldoFac(Long saldoFac) {
        this.saldoFac = saldoFac;
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

    public List<NotaCreditoProvDet> getNotaCreditoProvDet() {
        return notaCreditoProvDet;
    }

    public void setNotaCreditoProvDet(List<NotaCreditoProvDet> notaCreditoProvDet) {
        this.notaCreditoProvDet = notaCreditoProvDet;
    }

    public FacturaCompraCab getCodFacturaCab() {
        return codFacturaCab;
    }

    public void setCodFacturaCab(FacturaCompraCab codFacturaCab) {
        this.codFacturaCab = codFacturaCab;
    }

    public Proveedor getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Proveedor codProveedor) {
        this.codProveedor = codProveedor;
    }

    public Deposito getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(Deposito codDeposito) {
        this.codDeposito = codDeposito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNotCreCab != null ? codNotCreCab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCreditoProvCab)) {
            return false;
        }
        NotaCreditoProvCab other = (NotaCreditoProvCab) object;
        if ((this.codNotCreCab == null && other.codNotCreCab != null) || (this.codNotCreCab != null && !this.codNotCreCab.equals(other.codNotCreCab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.platinum.entity.NotaCreditoProvCab[codNotCreCab=" + codNotCreCab + "]";
    }

}
