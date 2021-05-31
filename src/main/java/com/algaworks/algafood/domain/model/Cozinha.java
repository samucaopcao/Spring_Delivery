package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data // Anotação do Lombok que representa o @Getter @Setter e @EqualsAndHashCode
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cozinha {

	@EqualsAndHashCode.Include // Cria um Equals and HashCode usando apenas o ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

}
