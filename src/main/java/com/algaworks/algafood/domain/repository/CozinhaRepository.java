package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository {

	List<Cozinha> todas();

	Cozinha porId(Long id);

	Cozinha adicionar(Cozinha cozinha);

	void remover(Cozinha cozinha);
}
