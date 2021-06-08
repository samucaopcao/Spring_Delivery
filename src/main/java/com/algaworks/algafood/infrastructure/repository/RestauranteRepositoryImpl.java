package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Método que retorna todos restaurantes em uma lista
	 */
	@Override
	public List<Restaurante> todos() {
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	/**
	 * Método para inserção de um restaurante
	 */
	@Override
	@Transactional
	public Restaurante adicionar(Restaurante restaurante) {
		return manager.merge(restaurante);

	}

	/**
	 * Método de busca de um restaurante por id
	 */
	@Override
	public Restaurante porId(Long id) {
		return manager.find(Restaurante.class, id);
	}

	/**
	 * Método para exlusão de um restaurante
	 */
	@Override
	@Transactional
	public void remover(Restaurante cozinha) {
		cozinha = porId(cozinha.getId());
		manager.remove(cozinha);
	}

}
