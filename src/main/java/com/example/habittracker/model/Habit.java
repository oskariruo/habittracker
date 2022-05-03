package com.example.habittracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Habit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String description;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	@JsonManagedReference
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "difficultyid")
	@JsonManagedReference
	private Difficulty difficulty;
	
	public Habit() {
		super();
	}

	public Habit(String name, String description, Category category, Difficulty difficulty) {
		this.name = name;
		this.description = description;
		this.category= category;
		this.difficulty = difficulty;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public String toString() {
		return "Habit [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", difficulty=" + difficulty + "]";
	}


}