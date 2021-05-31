package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Método que retorna todos as cozinhas em uma lista
	 */
	@Override
	public List<Cozinha> todas() {
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
	}

	/**
	 * Método para inserção de uma cozinha
	 */
	@Override
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);

	}

	/**
	 * Método de busca de cozinha por id
	 */
	@Override
	public Cozinha porId(Long id) {
		return manager.find(Cozinha.class, id);
	}

	/**
	 * Método para exlusão de uma cozinha
	 */
	@Override
	@Transactional
	public void remover(Cozinha cozinha) {
		cozinha = porId(cozinha.getId());
		manager.remove(cozinha);
	}

}
