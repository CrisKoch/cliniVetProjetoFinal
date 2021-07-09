package com.kochmann.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kochmann.domain.Anamnese;

@Repository
public interface AnamneseRepository extends JpaRepository<Anamnese, Integer>{

}
