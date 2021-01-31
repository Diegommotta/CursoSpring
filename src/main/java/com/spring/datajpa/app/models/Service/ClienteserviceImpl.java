package com.spring.datajpa.app.models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.datajpa.app.models.dao.IClienteDao;
import com.spring.datajpa.app.models.entity.Cliente;

@Service
public class ClienteserviceImpl implements IClienteService {

	@Autowired 
	private IClienteDao clienteDao;
	
	
	@Override
	public List<Cliente> findAll() {

		return clienteDao.findAll();
	}

	@Override
	public void save(Cliente cliente) {
	
		clienteDao.save(cliente);
		
	}

	@Override
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findOne(id);
	}

	@Override
	public void delete(Long id) {
		
		clienteDao.delete(id);
		
	}

}
