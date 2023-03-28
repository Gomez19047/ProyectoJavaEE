package proyecto.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import proyecto.entidades.TipoCliente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-23T23:26:38")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> nombreContacto;
    public static volatile SingularAttribute<Cliente, String> codigoPostal;
    public static volatile SingularAttribute<Cliente, String> clienteID;
    public static volatile SingularAttribute<Cliente, String> ciudad;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile SingularAttribute<Cliente, String> puestoContacto;
    public static volatile ListAttribute<Cliente, TipoCliente> tipoClienteList;
    public static volatile SingularAttribute<Cliente, String> region;
    public static volatile SingularAttribute<Cliente, String> telefono;
    public static volatile SingularAttribute<Cliente, String> fax;
    public static volatile SingularAttribute<Cliente, String> nombreEmpresa;
    public static volatile SingularAttribute<Cliente, String> pais;

}