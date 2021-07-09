package com.kochmann.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kochmann.domain.Animal;
import com.kochmann.service.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {
	@Autowired
	private AnimalService service;

	@GetMapping("/{id}")
	public Animal animal(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Animal> animais() {
		return service.todos();
	}

	@PostMapping
	public Animal novo(@RequestBody Animal entity) {
		return service.save(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public Animal atualiza(@PathVariable Integer id, @RequestBody Animal entity) {
		return service.atualiza(id, entity);
	}

}
