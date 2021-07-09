package com.kochmann.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kochmann.domain.Animal;
import com.kochmann.domain.Exame;
import com.kochmann.repository.ExameRepository;

@Service
public class ExameService {
	@Autowired
	private ExameRepository repository;
	
	@Autowired
	private AnimalService animalService;

	public Exame findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public List<Exame> todos() {
		return repository.findAll();
	}

	public Exame save(Exame entity, Integer id) {
		Animal animal = animalService.findById(id);
		entity.setAnimal(animal);
		return repository.save(entity);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Exame atualiza(Integer id, Exame entity) {
		entity.setId(id);
		return repository.save(entity);
	}

}
