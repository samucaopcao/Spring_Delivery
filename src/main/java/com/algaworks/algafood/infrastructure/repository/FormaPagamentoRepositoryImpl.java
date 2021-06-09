package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Método que retorna todos as Formas de Pagamento em uma lista
	 */
	@Override
	public List<FormaPagamento> listar() {
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
	}

	/**
	 * Método para inserção de uma Forma de Pagamento
	 */
	@Override
	@Transactional
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);

	}

	/**
	 * Método de busca de Formas de Pagamento por id
	 */
	@Override
	public FormaPagamento buscar(Long id) {
		return manager.find(FormaPagamento.class, id);
	}

	/**
	 * Método para exlusão de uma Forma de Pagamento
	 */
	@Override
	@Transactional
	public void remover(FormaPagamento formaPagamento) {
		formaPagamento = buscar(formaPagamento.getId());
		manager.remove(formaPagamento);
	}

}
