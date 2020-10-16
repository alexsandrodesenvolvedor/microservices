package com.arquitetura.aplicacao.repository;

import com.arquitetura.aplicacao.model.Aplicacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AplicacaoRepository extends JpaRepository<Aplicacao, Long> {
}
