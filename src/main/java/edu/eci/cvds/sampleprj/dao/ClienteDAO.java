package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Cliente;


public interface ClienteDAO {

	public void save(Cliente client) throws PersistenceException;

	public Cliente load(int id) throws PersistenceException;
	
	public List<Cliente> loads() throws PersistenceException;
}
