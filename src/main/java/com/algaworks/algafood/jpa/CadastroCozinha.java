package com.algaworks.algafood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CadastroCozinha {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Método que retorna todos as cozinhas em uma lista
	 */
	public List<Cozinha> listar() {
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
	}

	/**
	 * Método para inserção de uma cozinha
	 */
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);

	}

	/**
	 * Método de busca por id
	 */
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}

}
