package com.example.habittracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.habittracker.model.Habit;
import com.example.habittracker.model.HabitRepository;
import com.example.habittracker.model.User;
import com.example.habittracker.model.Category;
import com.example.habittracker.model.CategoryRepository;
import com.example.habittracker.model.Difficulty;
import com.example.habittracker.model.DifficultyRepository;
import com.example.habittracker.model.UserRepository;

@SpringBootApplication
public class HabitTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabitTrackerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(HabitRepository repository, CategoryRepository crepository, DifficultyRepository drepository,
			UserRepository urepository) {
		return (args) -> {

			System.out.println("save categories");
			
			crepository.save(new Category("Good"));
			crepository.save(new Category("Bad"));
			crepository.save(new Category("Neutral"));
			
			System.out.println("save difficulties");
			
			drepository.save(new Difficulty("Easy"));
			drepository.save(new Difficulty("Medium"));
			drepository.save(new Difficulty("Hard"));
			
			System.out.println("fetch all habits");
			
			repository.save(new Habit("Drink water", "Drink water in the morning ", crepository.findByName("Good").get(0), drepository.findByName("Easy").get(0)));
			repository.save(new Habit("Read book", "Read 10 pages of a book ", crepository.findByName("Good").get(0), drepository.findByName("Medium").get(0)));
			repository.save(new Habit("Don't watch YouTube", "Avoid watching YouTube ", crepository.findByName("Bad").get(0), drepository.findByName("Hard").get(0)));
			repository.save(new Habit("Wash", "Wash face every morning ", crepository.findByName("Neutral").get(0), drepository.findByName("Easy").get(0)));
			
			urepository.save(new User("user", "$2a$10$DWd4hErwldrNxwp..HyEUOm7TjU8VJCoP4uCOtHKSymgNwHb4wfoy", "user@gmail.com", "USER"));
			urepository.save(new User("admin", "$2a$10$VD.Liq33rHMpTxWqHUvjFuYiC11UTuOVLayI9qqo.nT/w86Z1AkYW", "admin@gmail.com", "ADMIN"));

			
			for (Habit habit : repository.findAll()) {
				System.out.println(habit.toString());
			}

		};
	}
}
