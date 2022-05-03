package com.example.habittracker.model;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Difficulty {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long difficultyid;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "difficulty")
	private List<Habit> habits;
	
	public Difficulty() {}
	
	public Difficulty(String name) {
		super();
		this.name = name;
	}

	public Long getDifficultyid() {
		return difficultyid;
	}

	public void setDifficultyid(Long difficultyid) {
		this.difficultyid = difficultyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Habit> getHabits() {
		return habits;
	}

	public void setHabits(List<Habit> habits) {
		this.habits = habits;
	}


	
	
	
}
