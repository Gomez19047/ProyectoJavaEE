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
import proyecto.entidades.TipoCliente;

/**
 *
 * @author Seferick
 */
@Stateless
public class TipoClienteFacade extends AbstractFacade<TipoCliente> implements TipoClienteFacadeLocal {

    @PersistenceContext(unitName = "PRN315_GRUPO_7-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoClienteFacade() {
        super(TipoCliente.class);
    }

    @Override
    public List<TipoCliente> buscarTodosAlfabeticamente() {
        try {
            em.getEntityManagerFactory().getCache().evictAll(); //Limpiando la memoria
            String consulta = "SELECT * FROM [TipoCliente] order by NombreEmpresa"; //Query de consulta
            Query query = em.createNativeQuery(consulta, TipoCliente.class); //Ejecucion de consulta y convenrsion a entidad
            List<TipoCliente> listaResultado = query.getResultList(); //Pasando el resultado a lista
            return listaResultado;
        } catch (Exception e) {
            return null;
        }
    }
    
}
