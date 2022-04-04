package com.example.habittracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.habittracker.model.Habit;
import com.example.habittracker.model.HabitRepository;
import com.example.habittracker.model.CategoryRepository;
import com.example.habittracker.model.UserRepository;

@SpringBootApplication
public class HabitTrackerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HabitTrackerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(HabitRepository repository, CategoryRepository crepository,
			UserRepository urepository) {
		return (args) -> {

			System.out.println("save a couple of categories");

			System.out.println("fetch all habitss");
			for (Habit habit : repository.findAll()) {
				System.out.println(habit.toString());
			}

		};
	}
}
