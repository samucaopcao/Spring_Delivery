package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository {

	List<Restaurante> todos();

	Restaurante porId(Long id);

	Restaurante adicionar(Restaurante restaurante);

	void remover(Restaurante restaurante);
}
