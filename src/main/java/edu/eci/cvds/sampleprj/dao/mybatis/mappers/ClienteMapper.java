package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("idcli") int id); 
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    
    public void agregarItemRentadoACliente(@Param("iditemRen") int id, 
    		@Param("idClient") int idclien,
    		@Param("idItem") int idit,
            @Param("fechain") Date fechainicio,
            @Param("fechaf")  Date fechafin);
     /**
     * Consultar todos los clientes
     * @param i 
     * @return 
     */
   public List<Cliente> consultarClientes(int i);
    
}
