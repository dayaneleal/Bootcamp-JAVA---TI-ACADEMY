package br.com.tiacademy.tvshowdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.tvshowdb.core.crud.CrudController;
import br.com.tiacademy.tvshowdb.entity.Serie;
import br.com.tiacademy.tvshowdb.service.SerieService;


@RestController
@RequestMapping("/serie")
public class SerieController extends CrudController<Serie, Long>{
	
	@Autowired
	SerieService service;
	
	
	@GetMapping("/nome/{titulo}")
	public Serie buscarPorNome(@PathVariable("titulo") String titulo) {
		return service.buscarPorNome(titulo);
	}
	
	
	@GetMapping("/status/{status}")
	public List<Serie> buscarPorStatus(@PathVariable(value="status") String status) {
		return service.buscarPorStatus(status);
	}
	
	@GetMapping("/listaSerieEGenero")
	public List<Serie> buscarSerieComGenero(){
		return service.buscarSerieComGenero();
	}
	

}
