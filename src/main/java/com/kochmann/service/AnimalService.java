package com.kochmann.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kochmann.controller.exception.AnimalNaoEncontradoException;
import com.kochmann.domain.Animal;
import com.kochmann.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;

	public Animal findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new AnimalNaoEncontradoException(null));
	}

	public List<Animal> todos() {
		return repository.findAll();
	}

	public Animal save(Animal entity) {
		return repository.save(entity);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Animal atualiza(Integer id, Animal entity) {
		entity.setId(id);
		return repository.save(entity);
	}

}
