package com.kochmann.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kochmann.domain.Doenca;

@Repository
public interface DoencaRepository extends JpaRepository<Doenca, Integer>{

}
