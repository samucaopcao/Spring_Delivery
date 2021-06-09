package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Método que retorna todos os estados em uma lista
	 */
	@Override
	public List<Estado> listar() {
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}

	/**
	 * Método para inserção de um estado
	 */
	@Override
	@Transactional
	public Estado salvar(Estado estado) {
		return manager.merge(estado);

	}

	/**
	 * Método de busca de estado por id
	 */
	@Override
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}

	/**
	 * Método para exlusão de um estado
	 */
	@Override
	@Transactional
	public void remover(Estado estado) {
		estado = buscar(estado.getId());
		manager.remove(estado);
	}

}
