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

import com.kochmann.domain.Doenca;
import com.kochmann.service.DoencaService;

@RestController
@RequestMapping("/doenca")
public class DoencaController {
	@Autowired
	private DoencaService service;

	@GetMapping("/{id}")
	public Doenca doenca(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Doenca> animais() {
		return service.todos();
	}

	@PostMapping
	public Doenca novo(@RequestBody Doenca entity) {
		return service.save(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public Doenca atualiza(@PathVariable Integer id, @RequestBody Doenca entity) {
		return service.atualiza(id, entity);
	}
}
