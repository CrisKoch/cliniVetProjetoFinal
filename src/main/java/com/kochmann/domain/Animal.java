package com.kochmann.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
@Data
@Entity
public class Animal implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message= "O campo nome é obrigatório")
	private String nome;
	
	private String foto;
	
	@NotBlank(message= "O campo raça é obrigatório")
	private String raca;
	
	@NotBlank(message= "O campo pelagem é obrigatório")
	private String pelagem;
	
	private Integer peso;
	
	@NotNull(message= "O campo tipo é obrigatório")
	@Range(min=1,max=2, message="Digite 1 para cachorro ou 2 para gato")
	private Integer tipo;
	
	@NotNull(message= "O campo data de nascimento é obrigatório")
	private Date dataNascimento;
	
	@NotNull(message = "O campo data do cadastro é obrigatório")
	private Date dataCadastro;
	
	@Range(min=1,max=2, message="Digite 1 para ativo ou 2 para inativo")
	private Integer estado;
	
	@OneToMany(mappedBy="animal")
	@JsonManagedReference
	private List<Exame> exames = new ArrayList<Exame>();
	
	@OneToMany(mappedBy="animal")
	@JsonManagedReference
	private List<Consulta> consultas = new ArrayList<Consulta>();
	
	
}
