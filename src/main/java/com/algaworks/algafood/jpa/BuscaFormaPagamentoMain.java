package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class BuscaFormaPagamentoMain {

	public static void main(String[] args) {

		// Tirando o contexto web da aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		FormaPagamentoRepository formaPagamento = applicationContext.getBean(FormaPagamentoRepository.class);

		List<FormaPagamento> formasPagamento = formaPagamento.listar();
		for (FormaPagamento formaPagamento1 : formasPagamento) {
			System.out.println(formaPagamento1.getDescricao());

		}
	}

}
