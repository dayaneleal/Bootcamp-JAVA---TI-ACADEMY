package br.com.tiacademy.tvshowdb.core.crud;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;


public  abstract class CrudService<T,ID> {
	
	
	@Autowired
	protected CrudRepository<T,ID> repository;
	
	public List<T>listar(){
		return repository.findAll();
	}
	
	public T buscarPorId(ID id) {
		return repository.findById(id).orElse(null);
	}

	public T criar(T entidade) {
		return repository.save(entidade);
	}
	
	public void deletar(ID id) {
		repository.deleteById(id);
	}
	
	public T editar(ID id, T entidade) {
		var recuperado = buscarPorId(id);
		
		if(Objects.isNull(recuperado)) {
			throw new RuntimeException("Não foi encontrado");
		}
		
		var entidadeSalvar = editarEntidade(recuperado, entidade);
		
		return repository.save(entidadeSalvar);
	}
	
	protected abstract T editarEntidade(T recuperado, T entidade);
	//criar
	//ler
	//editar 
	//excluir
}
