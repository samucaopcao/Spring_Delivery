package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.model.CozinhasXmlWrapper;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@RestController
@ResponseBody

@RequestMapping(value = "/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	/*
	 * (produces = { MediaType.APPLICATION_JSON_VALUE,
	 * MediaType.APPLICATION_XML_VALUE }) O trecho acima permite que a resposta da
	 * requisição neste método, retorne em formato XML ou JSON
	 */

	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
		Cozinha cozinha = cozinhaRepository.buscar(id);
		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml() {
		return new CozinhasXmlWrapper(cozinhaRepository.listar());
	}
}
