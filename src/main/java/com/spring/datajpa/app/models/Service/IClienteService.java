package com.spring.datajpa.app.models.Service;

import java.util.List;

import com.spring.datajpa.app.models.entity.Cliente;

public interface IClienteService {
	
	
	public List<Cliente> findAll();
	
	public void save (Cliente cliente);
	
	public 	Cliente findOne(Long id);
	
	public void delete (Long id);

}
