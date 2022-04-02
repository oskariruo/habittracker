package com.example.habittracker.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Service;
@Service
public interface HabitRepository extends CrudRepository <Habit, Long> {
	List<Habit> findByName(String name);
}
