package edu.eci.cvds.sampleprj.dao.mybatis;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;

public class MyBATISTipoItemDAO implements TipoItemDAO  {
	
	
	@Inject 
	TipoItemMapper tipoitemMapper;
	
	@Override
	public void save(TipoItem tipoItem) throws PersistenceException{
		
		try {
			tipoitemMapper.AgregarTipoItem(tipoItem);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			
			throw new PersistenceException("Error al registrar el Tipo de Item "+tipoItem.toString(),e);
		}
	}
	
	@Override
	public TipoItem load(int id) throws PersistenceException {
	  try{
	      return tipoitemMapper.getTipoItem(id);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el Tipo de Item "+id,e);
	  }
	}
	
}
