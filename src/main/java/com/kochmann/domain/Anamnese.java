package com.kochmann.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Anamnese implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message= "Sim/Não - O campo é obrigatório.")
	private String problemaSistemaDigestivo;
	
	@NotBlank(message= "Sim/Não - O campo é obrigatório.")
	private String problemaSistemaUroGenital;
	
	@NotBlank(message= "Sim/Não - O campo é obrigatório.")
	private String problemaSistemaCardioRespiratorio;
	
	@NotBlank(message= "Sim/Não - O campo é obrigatório.")
	private String problemaSistemaNeurologico;
	
	@NotBlank(message= "Sim/Não - O campo é obrigatório.")
	private String problemaSistemaLocomotor;
	
	@NotBlank(message= "Sim/Não - O campo é obrigatório.")
	private String problemaPele;
	
	@NotBlank(message= "Sim/Não - O campo é obrigatório.")
	private String problemaOlhos;
	
	@NotBlank(message= "Sim/Não - O campo é obrigatório.")
	private String problemaOuvido;
	
	@ManyToMany
	private List<Doenca> doenca = new ArrayList<Doenca>();

}
