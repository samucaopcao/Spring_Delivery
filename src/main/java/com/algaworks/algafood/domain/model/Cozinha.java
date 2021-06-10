package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName("Teste_Cozinha")
@Data // Anotação do Lombok que representa o @Getter @Setter e @EqualsAndHashCode
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cozinha {

	@EqualsAndHashCode.Include // Cria um Equals and HashCode usando apenas o ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @JsonIgnore - Não mostra esse atributo na Resposta (no Postman)
	// @JsonProperty("Título") - Altera a visualização do atributo nome para titulo
	// ao ser mostrado na resposta
	@Column(nullable = false)
	private String nome;

}
