package com.Gerenciamento.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // gerador altmatico de geter e seter |
@NoArgsConstructor // sem argumentos } lombok
@AllArgsConstructor // todos os argumentos |
@Entity
@Table(name = "vendas")

public class vendas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private Date data_vendas;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private cliente Cliente;
	

}
