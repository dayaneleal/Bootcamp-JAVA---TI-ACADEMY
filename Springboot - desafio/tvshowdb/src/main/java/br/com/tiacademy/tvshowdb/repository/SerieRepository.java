package br.com.tiacademy.tvshowdb.repository;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.tvshowdb.core.crud.CrudRepository;
import br.com.tiacademy.tvshowdb.entity.Serie;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Long> {

}
