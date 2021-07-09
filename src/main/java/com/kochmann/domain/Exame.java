package com.kochmann.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Exame implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "O campo hemograma deve ser preenchido: S/N")
	private Boolean hemograma;

	@NotNull(message = "O campo colesterol deve ser preenchido: S/N")
	private Boolean colesterol;

	@NotNull(message = "O campo fósforo deve ser preenchido: S/N")
	private Boolean fosforo;

	@NotNull(message = "O campo calcio deve ser preenchido: S/N")
	private Boolean calcio;

	@NotNull(message = "O campo hemograma deve ser preenchido: S/N")
	private Boolean glicose;

	@NotNull(message = "O campo magnesio deve ser preenchido: S/N")
	private Boolean magnesio;

	@NotNull(message = "O campo ureia deve ser preenchido: S/N")
	private Boolean ureia;

	@NotNull(message = "O campo potassio deve ser preenchido: S/N")
	private Boolean potassio;

	@NotBlank(message = "O campo ultrassonografia deve ser preenchido: S/N")
	private String ultrassonografia;

	@NotBlank(message = "O campo radiografia deve ser preenchido: S/N")
	private String radiografia;

	@NotNull(message = "A data do exame deve ser informada")
	private Date data;

	@ManyToOne
	@JsonBackReference
	private Animal animal;

}
