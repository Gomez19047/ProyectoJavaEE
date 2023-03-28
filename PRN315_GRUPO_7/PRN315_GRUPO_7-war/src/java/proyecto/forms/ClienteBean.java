/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.forms;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import proyecto.ejb.ClienteFacadeLocal;
import proyecto.entidades.Cliente;

/**
 *
 * @author Seferick
 */
@Named(value = "clienteBean")//controlador que interactua en archivo xhtml jsp para llamar metodos, variables que programemos en esta clase ClienteBean.java, aqui declaramos toda la logica del negocio, para ir a traer datos de la base de datos, modificar, etc.
@SessionScoped
public class ClienteBean implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteFacade;
    
    private Cliente cliente;
    
    
   /* public ClienteBean() {
    }*/
    
    public ClienteBean() {
        this.cliente = new Cliente();
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<Cliente> findAll() {
        return this.clienteFacade.findAll();
    }
    
    public void saveCliente() {
        if (this.cliente.getClienteID() != null) {
            this.clienteFacade.edit(this.cliente);
        } else {
            this.clienteFacade.create(this.cliente);
        }
        this.cleanCliente();
    }
    
    public Cliente findById(Integer id) {
        return this.clienteFacade.find(id);
    }
    
    public void cleanCliente() {
        this.cliente = new Cliente();
    }
    
    public void deleteCliente() {
        this.clienteFacade.remove(cliente);
        this.cleanCliente();
    }
    
}
