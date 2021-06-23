package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

	List<Cozinha> findTodasByNomeContaining(String nome);

	// Tras apenas uma cozinha, se não existir retorna null
	Optional<Cozinha> findByNome(String nome);

	// Busca a cozinha pelo nome , se trouxer algum retorna TRUE.
	boolean existsByNome(String nome);

}
