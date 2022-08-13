package br.com.tiacademy.tvshowdb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.tvshowdb.core.crud.CrudRepository;
import br.com.tiacademy.tvshowdb.entity.Serie;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Long> {
	
	//Native Query
	@Query(value = "SELECT s.id, s.titulo, s.status, s.ano_estreia, s.pais_origem, s.numero_temporadas, g.nome FROM serie s "
			+ "JOIN genero_serie gs on s.id = gs.id_serie "
			+ "JOIN genero g on g.id = gs.id_genero ", nativeQuery=true)
	List<Serie>buscarSerieComGenero();
	
	List<Serie> findByStatus(String status);
	
	//HQL
	@Query(value=" SELECT s FROM Serie s WHERE s.titulo=:titulo")
	Serie buscarSeriePorNome(@Param("titulo")String titulo);

}
