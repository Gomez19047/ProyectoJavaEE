/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.forms;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import proyecto.entidades.Cliente;

/**
 *
 * @author Seferick
 */
@Named(value = "clienteForm")
@SessionScoped
public class ClienteForm implements Serializable {

    @PostConstruct
 public void init() {
    try {

    //Codigo de inicializacion de formulario
    } catch (Exception e) {
    }
 }
 
 private Cliente cliente;
 public Cliente getCliente() {
 return cliente;
 }
 public void setTransportista(Cliente cliente) {
 this.cliente= cliente;
 }
    
    public ClienteForm() {
    }
    
}
