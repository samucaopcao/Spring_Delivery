package com.algaworks.algafood.jpa;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class AlteracaoRestauranteMain {

	public static void main(String[] args) {

		// Tirando o contexto web da aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository cozinhaRepository = applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante = new Restaurante();
		BigDecimal taxaFrete = new BigDecimal(18.67);
		restaurante.setId(1L);
		restaurante.setNome("Mc Donalds");
		restaurante.setTaxaFrete(taxaFrete);

		cozinhaRepository.adicionar(restaurante);

		System.out.println("Item alterado com sucesso: ID " + restaurante.getId() + " - Nome: " + restaurante.getNome()
				+ " - Taxa de Frete : R$ " + NumberFormat.getCurrencyInstance().format(taxaFrete));

	}

}
