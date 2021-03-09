package com.pulse.spring.files.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pulse.spring.files.csv.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
