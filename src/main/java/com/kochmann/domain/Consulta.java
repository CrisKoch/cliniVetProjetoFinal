package com.kochmann.domain;

import java.io.Serializable;
//import java.util.Date;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Consulta implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message= "O campo data é obrigatório")
	private Date data;
	
	private String observacoes;
	
	@NotBlank(message= "O campo queixa é obrigatório")
	private String queixa;
	
	@NotBlank(message= "O campo histórico é obrigatório")
	private String historico;
	
	@OneToOne
	private Anamnese anamnese;
	
	@ManyToOne
	@JsonBackReference
	private Animal animal;

}
