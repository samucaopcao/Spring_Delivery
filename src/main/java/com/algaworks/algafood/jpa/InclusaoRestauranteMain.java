package com.algaworks.algafood.jpa;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {

		// Tirando o contexto web da aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante1 = new Restaurante();
		DecimalFormat taxaFrete1 = new DecimalFormat("0.00");
		BigDecimal valor1 = new BigDecimal(11);
		restaurante1.setNome("Fogão Mineiro");
		restaurante1.setTaxaFrete(valor1);

		Restaurante restaurante2 = new Restaurante();
		DecimalFormat taxaFrete2 = new DecimalFormat("0.00");
		BigDecimal valor = new BigDecimal(14.50);
		restaurante2.setNome("Girafas");
		restaurante2.setTaxaFrete(valor);

		restaurante1 = restauranteRepository.salvar(restaurante1);
		restaurante2 = restauranteRepository.salvar(restaurante2);

		System.out.println("Id: " + restaurante1.getId() + " Restaurante: " + restaurante1.getNome() + " e Taxa de Frete R$ " + taxaFrete2.format(valor1));
		System.out.println("Id: " + restaurante2.getId() + " Restaurante: " + restaurante2.getNome() + " e Taxa de Frete R$ " + taxaFrete1.format(valor));

		//System.out.printf("%d - %s e taxa de frete R$ %d\n", restaurante2.getId(), restaurante2.getNome(),restaurante2.getTaxaFrete());

	}

}
