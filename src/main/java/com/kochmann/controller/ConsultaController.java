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

import com.kochmann.domain.Consulta;
import com.kochmann.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	@Autowired
	private ConsultaService service;

	@GetMapping("/{id}")
	public Consulta consulta(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Consulta> animais() {
		return service.todos();
	}
	/*@GetMapping("/5mais")
	public List<Consulta> maisConsultas(@RequestBody Date data1, Date data2) {
		return service.maisConsultasPeriodo(data1,data2);
	}*/

	@PostMapping("/{id}")
	public Consulta novo(@RequestBody Consulta entity, @PathVariable Integer id) {
		return service.save(entity, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public Consulta atualiza(@PathVariable Integer id, @RequestBody Consulta entity) {
		return service.atualiza(id, entity);
	}
}
