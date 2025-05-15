package com.Gerenciamento.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Gerenciamento.Entity.cliente;
import com.Gerenciamento.Repository.clienteRepository;

@Service

public class clienteService {
	
private final clienteRepository ClienteRepository;
	
	@Autowired
	public clienteService(clienteRepository ClienteRepository) {
		this.ClienteRepository = ClienteRepository;
	}
	
	public List<cliente> getAlicliente() {
		return ClienteRepository.findAll();
	}
	
	public cliente getclienteByid(Long id) {
		Optional<cliente> Cliente = ClienteRepository.findById(id);
		return Cliente.orElse(null);
	}
	
	public cliente salvarcliente(cliente Cliente) {
		return ClienteRepository.save(Cliente);
	}
	
	public cliente updatecliente (Long id, cliente updatedcliente) {
		Optional<cliente> existingcliente = ClienteRepository.findById(id);
		if (existingcliente.isPresent()) {
			updatedcliente.setId(id);
			return ClienteRepository.save(updatedcliente);
		}
		return null;
	}
	
	public boolean deletecliente (Long id) {
		Optional<cliente> existingcliente = ClienteRepository.findById(id);
		if (existingcliente.isPresent()) {
			ClienteRepository.deleteById(id);
			return true;
		}
		return false;
	}


}
