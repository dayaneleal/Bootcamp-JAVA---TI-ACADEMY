package br.com.tiacademy.tvshowdb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.tvshowdb.core.crud.CrudController;
import br.com.tiacademy.tvshowdb.entity.Serie;

@RestController
@RequestMapping("/serie")
public class SerieController extends CrudController<Serie, Long>{

}
