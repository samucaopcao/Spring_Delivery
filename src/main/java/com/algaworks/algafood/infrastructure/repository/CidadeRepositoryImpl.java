package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Método que retorna todos as cidades em uma lista
	 */
	@Override
	public List<Cidade> listar() {
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	/**
	 * Método para inserção de uma cidade
	 */
	@Override
	@Transactional
	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);

	}

	/**
	 * Método de busca de cidade por id
	 */
	@Override
	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}

	/**
	 * Método para exlusão de uma cidade
	 */
	@Override
	@Transactional
	public void remover(Cidade cidade) {
		cidade = buscar(cidade.getId());
		manager.remove(cidade);
	}

}
