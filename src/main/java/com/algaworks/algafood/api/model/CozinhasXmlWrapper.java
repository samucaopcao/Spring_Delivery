package com.algaworks.algafood.api.model;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.Data;
import lombok.NonNull;

@JsonRootName("listar_cozinhas")
@Data
public class CozinhasXmlWrapper {

	@JsonProperty("cozinhas")
	@JacksonXmlElementWrapper(useWrapping = false)
	@NonNull // Essa anotação cria automáticamente um construtor passando esse atributo como
				// parâmetro
	private List<Cozinha> cozinhas;

}
