package com.pulse.spring.files.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pulse.spring.files.csv.model.PrevisaoInventario;

public interface PrevisaoInventarioRepository extends JpaRepository<PrevisaoInventario, Long> {
}
