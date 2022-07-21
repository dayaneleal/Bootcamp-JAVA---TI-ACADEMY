package br.com.tiacademy.catalogo.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.catalogo.entity.Artista;

@Repository
public interface ArtistaRepository extends RepositoryCatalogo<Artista, Long>{

	@Query("Select a FROM Artista a WHERE a.nome =:nome")
	Artista consultarPeloNome(@Param("nome")String nome);
}
