/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import proyecto.entidades.Cliente;

/**
 *
 * @author Seferick
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    /*Aqui se deben programar las funciones
que se definieron en la interfaz*/
    
    @PersistenceContext(unitName = "PRN315_GRUPO_7-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> buscarTodosAlfabeticamente() {
        try {
            em.getEntityManagerFactory().getCache().evictAll(); //Limpiando la memoria
            String consulta = "SELECT * FROM [Cliente] order by NombreEmpresa"; //Query de consulta
            Query query = em.createNativeQuery(consulta, Cliente.class); //Ejecucion de consulta y convenrsion a entidad
            List<Cliente> listaResultado = query.getResultList(); //Pasando el resultado a lista
            return listaResultado;
        } catch (Exception e) {
            return null;
        }
    }
   
}
