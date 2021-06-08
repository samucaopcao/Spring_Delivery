package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data // Anotação do Lombok que representa o @Getter @Setter e @EqualsAndHashCode
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@Column(name = "taxa_frete")
	private BigDecimal taxaFrete;
	
	@ManyToOne
	//Quando temos a anotação @Many... para renomear a coluna o correto é usar @JoinClumn
	@JoinColumn(name ="cozinha_codigo")
	private Cozinha cozinha;

}
