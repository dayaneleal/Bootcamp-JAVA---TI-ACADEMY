package br.com.tiacademy.tvshowdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiacademy.tvshowdb.core.crud.CrudService;
import br.com.tiacademy.tvshowdb.entity.Serie;
import br.com.tiacademy.tvshowdb.repository.SerieRepository;

@Service
public class SerieService extends CrudService<Serie, Long>{
	
	@Autowired
	SerieRepository repository;

	@Override
	protected Serie editarEntidade(Serie recuperado, Serie entidade) {
		
		recuperado.setTitulo(entidade.getTitulo());
		recuperado.setAnoEstreia(entidade.getAnoEstreia());
		recuperado.setStatus(entidade.getStatus());
		recuperado.setPaisOrigem(entidade.getPaisOrigem());
		recuperado.setNumeroTemporadas(entidade.getNumeroTemporadas());
		
		return recuperado;
	}
	
	public Serie buscarPorNome(String titulo){
		return repository.buscarSeriePorNome(titulo);	
	}
	
	public List<Serie> buscarSerieComGenero(){
		return repository.buscarSerieComGenero();	
	}
	
	public List<Serie> buscarPorStatus(String status){
		return repository.findByStatus(status);	
	}

	
	
}
