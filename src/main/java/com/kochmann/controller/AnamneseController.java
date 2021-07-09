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

import com.kochmann.domain.Anamnese;
import com.kochmann.service.AnamneseService;

@RestController
@RequestMapping("/anamnese")
public class AnamneseController {
	@Autowired
	private AnamneseService service;

	@GetMapping("/{id}")
	public Anamnese anamnese(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Anamnese> anamneses() {
		return service.todos();
		
	}

	@PostMapping
	public Anamnese novo(@RequestBody Anamnese entity) {
		return service.save(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws Exception {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public Anamnese atualiza(@PathVariable Integer id, @RequestBody Anamnese entity) {
		return service.atualiza(id, entity);
	}

}
