package br.com.tiacademy.catalogo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.catalogo.entity.Artista;
import br.com.tiacademy.catalogo.repository.ArtistaRepository;

@RestController
@RequestMapping("/artista")
public class ArtistaController extends ControllerCatalogo<Artista, Long>{
	

	public ArtistaRepository getRepository() {
		return (ArtistaRepository)this.repository;
	}
	
	@GetMapping("/nome")
	public Artista artistPorNome() {
		return this.getRepository().consultarPeloNome("Djavan");
	}
	

}
