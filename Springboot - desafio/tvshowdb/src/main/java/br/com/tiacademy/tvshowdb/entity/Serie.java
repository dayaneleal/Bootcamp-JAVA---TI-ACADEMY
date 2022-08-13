package br.com.tiacademy.tvshowdb.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="serie")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Serie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String status;
	private Integer anoEstreia;
	private String paisOrigem;
	private Integer numeroTemporadas;
	@ManyToMany
	@JoinTable(name = "genero_serie", 
			  joinColumns = @JoinColumn(name="id_serie"),
			  inverseJoinColumns = @JoinColumn(name = "id_genero"))
	private List<Genero>generos;

	
}
