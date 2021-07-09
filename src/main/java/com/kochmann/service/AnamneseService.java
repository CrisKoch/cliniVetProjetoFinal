package com.kochmann.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.kochmann.controller.exception.AnimalNaoEncontradoException;
import com.kochmann.domain.Anamnese;
import com.kochmann.domain.Doenca;
import com.kochmann.repository.AnamneseRepository;
import com.kochmann.repository.DoencaRepository;

@Service
public class AnamneseService {

	@Autowired
	private AnamneseRepository repository;
	
	@Autowired
	private DoencaRepository doencaRepository;
	
	public Anamnese findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new AnimalNaoEncontradoException(null));
	}

	public List<Anamnese> todos() {
		return repository.findAll();
	}

	public Anamnese save(Anamnese entity) {
		return repository.save(entity);
	}

	public void delete(Integer id) throws Exception {
	/*	repository.deleteById(id);
	}
	/*public void delete(Integer id) {*/
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception("Id not found " + id);
		
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Integrity violation");
		}
	}

	public Anamnese atualiza(Integer id, Anamnese entity) {
		
		entity.setId(id);
		
		return repository.save(entity);
	}
	
	public Anamnese insereDoencaEmAnamnese(Integer id_doenca, Anamnese entity) {
		
		Doenca d1 = doencaRepository.getById(id_doenca);
		
		entity.getDoenca().add(d1);
		return atualiza(entity.getId(), entity);
		
	}
	
}
