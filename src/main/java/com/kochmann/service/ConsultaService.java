package com.kochmann.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kochmann.domain.Animal;
import com.kochmann.domain.Consulta;
import com.kochmann.repository.ConsultaRepository;

@Service
public class ConsultaService {
	@Autowired
	private ConsultaRepository repository;
	
	/*@Autowired
	private AnamneseService anamneseService;*/
	
	@Autowired
	private AnimalService animalService;

	public Consulta findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public List<Consulta> todos() {
		return repository.findAll();
	}

	/* criar
	public List<Consulta> maisConsultasPeriodo(Date data1, Date data2) {
		List<Consulta> total = repository.findAll();
		List<Consulta> selecionadas = new ArrayList<Consulta>();
		if (total.forEach(item -> item.getData().after(data1) && item.getData().before(data2)) {
			selecionadas.add();
		}
		;
		return selecionadas;
		
	}*/

	public Consulta save(Consulta entity, Integer id) {
		Animal animal = animalService.findById(id);
		entity.setAnimal(animal);
		return repository.save(entity);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Consulta atualiza(Integer id, Consulta entity) {
		entity.setId(id);
		return repository.save(entity);
	}

}
