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

import com.Gerenciamento.Entity.cliente;
import com.Gerenciamento.Service.clienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Modulo Cliente", description = "API de controle de clietes")
@RestController
@RequestMapping("/cliente")

public class clienteController {
	
	private final clienteService ClienteService;

	@Autowired
	public clienteController(clienteService ClienteService) {
		this.ClienteService = ClienteService;
	}
	@Operation(summary = "Localizar clientes por ID")
	@GetMapping("/{id}")
	public ResponseEntity<cliente> getProductById(@PathVariable Long id){
		cliente Cliente = ClienteService.getclienteByid(id);
		if (Cliente != null) {
			return ResponseEntity.ok(Cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@Operation(summary = "Localizar clientes por ID")
	@GetMapping("/")
	public ResponseEntity<List<cliente>> getAllcliente() {
		List<cliente> Cliente = ClienteService.getAlicliente();
		return ResponseEntity.ok(Cliente);
	}
	@Operation(summary = "Localizar clientes por ID")
	@PostMapping("/")
	public ResponseEntity<cliente> criaeCliente(@RequestBody @Valid cliente Cliente){
		cliente criarcliente = ClienteService.salvarcliente(Cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarcliente);
	}
	@Operation(summary = "Localizar clientes por ID")
	@PutMapping("/{id}")
	public ResponseEntity<cliente> updateCliente(@PathVariable Long id, @RequestBody @Valid cliente Cliente){
		cliente updatedcliente = ClienteService.updatecliente(id, Cliente);
		if(updatedcliente != null) {
			return ResponseEntity.ok(updatedcliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@Operation(summary = "Localizar clientes por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<cliente> daleteCliente(@PathVariable Long id){
		boolean deleted = ClienteService.deletecliente(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
