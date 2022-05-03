package com.example.habittracker.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DifficultyRepository extends CrudRepository<Difficulty, Long> {

    List<Difficulty> findByName(String name);
    
}
