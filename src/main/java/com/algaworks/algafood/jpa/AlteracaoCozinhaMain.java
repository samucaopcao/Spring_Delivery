package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;



public class AlteracaoCozinhaMain {

	public static void main(String[] args) {

		//Tirando o contexto web da aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);


		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);
		cozinha.setNome("Russa");
		
		cadastroCozinha.salvar(cozinha);
		
		System.out.printf("Item alterado com sucesso: %d - %s\n", cozinha.getId(),cozinha.getNome());

	}

}
