package com.kochmann.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kochmann.domain.Doenca;
import com.kochmann.repository.DoencaRepository;

@Service
public class DoencaService {
	@Autowired
	private DoencaRepository repository;

	public Doenca findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public List<Doenca> todos() {
		return repository.findAll();
	}

	public Doenca save(Doenca entity) {
		return repository.save(entity);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Doenca atualiza(Integer id, Doenca entity) {
		entity.setId(id);
		return repository.save(entity);
	}

}
