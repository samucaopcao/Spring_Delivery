package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository 
extends JpaRepository<Restaurante, Long>,RestauranteRepositoryQueries {

	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

	// @Query(" From Restaurante Where nome Like %:nome% and cozinha.id = :id ")
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);

	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);

	// Busca apenas o primeiro restaurante que tenha o nome ou contenha o nome X
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);

	// Busca apenas os 2 primeiros restaurante que tenha o nome ou contenha o nome X
	List<Restaurante> findTop2ByNomeContaining(String nome);

	// Retorna quantidade de Restaurantes que uma cozinha específica tem.
	int countByCozinhaId(Long cozinha);

}
