package com.Gerenciamento.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gerenciamento.Entity.vendas;
import com.Gerenciamento.Repository.vendasRepository;

@Service

public class vendasService {
	
private final vendasRepository VendasRepository;
	
	@Autowired
	public vendasService(vendasRepository VendasRepository) {
		this.VendasRepository = VendasRepository;
	}
	
	public List<vendas> getAlivendas() {
		return VendasRepository.findAll();
	}
	
	public vendas getvendasByid(Long id) {
		Optional<vendas> Vendas = VendasRepository.findById(id);
		return Vendas.orElse(null);
	}
	
	public vendas salvarvendas(vendas Vendas) {
		return VendasRepository.save(Vendas);
	}
	
	public vendas updatevendas (Long id, vendas updatedvendas) {
		Optional<vendas> existingvendas = VendasRepository.findById(id);
		if (existingvendas.isPresent()) {
			updatedvendas.setId(id);
			return VendasRepository.save(updatedvendas);
		}
		return null;
	}
	
	public boolean deletevendas (Long id) {
		Optional<vendas> existingvendas = VendasRepository.findById(id);
		if (existingvendas.isPresent()) {
			VendasRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
