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

import com.kochmann.domain.Exame;
import com.kochmann.service.ExameService;

@RestController
@RequestMapping("/exame")
public class ExameController {
	@Autowired
	private ExameService service;

	@GetMapping("/{id}")
	public Exame exame(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Exame> animais() {
		return service.todos();
	}

	@PostMapping("/{id}")
	public Exame novo(@RequestBody Exame entity,@PathVariable Integer id ) {
		return service.save(entity, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public Exame atualiza(@PathVariable Integer id, @RequestBody Exame entity) {
		return service.atualiza(id, entity);
	}
}
