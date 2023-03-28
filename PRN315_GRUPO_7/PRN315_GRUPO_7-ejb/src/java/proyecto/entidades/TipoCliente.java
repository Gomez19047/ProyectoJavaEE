/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Seferick
 */
@Entity
@Table(name = "TipoCliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCliente.findAll", query = "SELECT t FROM TipoCliente t")
    , @NamedQuery(name = "TipoCliente.findByClienteTipoID", query = "SELECT t FROM TipoCliente t WHERE t.clienteTipoID = :clienteTipoID")
    , @NamedQuery(name = "TipoCliente.findByDescripcionCliente", query = "SELECT t FROM TipoCliente t WHERE t.descripcionCliente = :descripcionCliente")})
public class TipoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ClienteTipoID")
    private String clienteTipoID;
    @Size(max = 1073741823)
    @Column(name = "DescripcionCliente")
    private String descripcionCliente;
    @JoinTable(name = "ClienteTipoCliente", joinColumns = {
        @JoinColumn(name = "ClienteTipoID", referencedColumnName = "ClienteTipoID")}, inverseJoinColumns = {
        @JoinColumn(name = "ClienteID", referencedColumnName = "ClienteID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Cliente> clienteList;

    public TipoCliente() {
    }

    public TipoCliente(String clienteTipoID) {
        this.clienteTipoID = clienteTipoID;
    }

    public String getClienteTipoID() {
        return clienteTipoID;
    }

    public void setClienteTipoID(String clienteTipoID) {
        this.clienteTipoID = clienteTipoID;
    }

    public String getDescripcionCliente() {
        return descripcionCliente;
    }

    public void setDescripcionCliente(String descripcionCliente) {
        this.descripcionCliente = descripcionCliente;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteTipoID != null ? clienteTipoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCliente)) {
            return false;
        }
        TipoCliente other = (TipoCliente) object;
        if ((this.clienteTipoID == null && other.clienteTipoID != null) || (this.clienteTipoID != null && !this.clienteTipoID.equals(other.clienteTipoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto.entidades.TipoCliente[ clienteTipoID=" + clienteTipoID + " ]";
    }
    
}
