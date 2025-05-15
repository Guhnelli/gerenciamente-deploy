package com.Gerenciamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gerenciamento.Entity.cliente;

public interface clienteRepository extends JpaRepository<cliente, Long> {

}
