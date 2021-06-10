package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class BuscaRestauranteMain {

	public static void main(String[] args) {

		// Tirando o contexto web da aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

		List<Restaurante> restaurantes = restauranteRepository.todos();
		for (Restaurante restaurante : restaurantes) {
			System.out.println(restaurante.getNome() + " com taxa de frete de R$ " + restaurante.getTaxaFrete()
					+ " com a Cozinha: " + restaurante.getCozinha().getNome());

		}
	}

}