package br.com.tiacademy.tvshowdb.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.tvshowdb.core.crud.CrudService;
import br.com.tiacademy.tvshowdb.entity.Serie;

@Service
public class SerieService extends CrudService<Serie, Long>{

	@Override
	protected Serie editarEntidade(Serie recuperado, Serie entidade) {
		
		recuperado.setTitulo(entidade.getTitulo());
		recuperado.setAnoEstreia(entidade.getAnoEstreia());
		recuperado.setStatus(entidade.getStatus());
		recuperado.setPaisOrigem(entidade.getPaisOrigem());
		recuperado.setNumeroTemporadas(entidade.getNumeroTemporadas());
		
		return recuperado;
	}

	
	
}
