package com.Gerenciamento.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gerenciamento.Entity.vendas;
import com.Gerenciamento.Service.vendasService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Modulo Vendas", description = "API de controle de vendas")
@RestController
@RequestMapping("/vendas")

public class vendasController {
	
	private final vendasService VendasService;

	@Autowired
	public vendasController(vendasService VendasService) {
		this.VendasService = VendasService;
	}
	
	@Operation(summary = "Localizar vendas por ID")	
	@GetMapping("/{id}")
	public ResponseEntity<vendas> getProductById(@PathVariable Long id){
		vendas Vendas = VendasService.getvendasByid(id);
		if (Vendas != null) {
			return ResponseEntity.ok(Vendas);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@Operation(summary = "Localizar vendas por ID")
	@GetMapping("/")
	public ResponseEntity<List<vendas>> getAllvendas() {
		List<vendas> Vendas = VendasService.getAlivendas();
		return ResponseEntity.ok(Vendas);
	}
	@Operation(summary = "Localizar vendas por ID")
	@PostMapping("/")
	public ResponseEntity<vendas> criaeVendas(@RequestBody @Valid vendas Vendas){
		vendas criarvendas = VendasService.salvarvendas(Vendas);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarvendas);
	}
	@Operation(summary = "Localizar vendas por ID")
	@PutMapping("/{id}")
	public ResponseEntity<vendas> updateVendas(@PathVariable Long id, @RequestBody @Valid vendas Vendas){
		vendas updatedVendas = VendasService.updatevendas(id, Vendas);
		if(updatedVendas != null) {
			return ResponseEntity.ok(updatedVendas);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@Operation(summary = "Localizar vendas por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<vendas> daleteVendas(@PathVariable Long id){
		boolean deleted = VendasService.deletevendas(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
