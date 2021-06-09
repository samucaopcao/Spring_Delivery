package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Método que retorna todas as permissões em uma lista
	 */
	@Override
	public List<Permissao> listar() {
		return manager.createQuery("from Permissao", Permissao.class).getResultList();
	}

	/**
	 * Método para inserção de uma permissão
	 */
	@Override
	@Transactional
	public Permissao salvar(Permissao permissao) {
		return manager.merge(permissao);

	}

	/**
	 * Método de busca de permissão por id
	 */
	@Override
	public Permissao buscar(Long id) {
		return manager.find(Permissao.class, id);
	}

	/**
	 * Método para exlusão de uma permissão
	 */
	@Override
	@Transactional
	public void remover(Permissao permissao) {
		permissao = buscar(permissao.getId());
		manager.remove(permissao);
	}

}
