package com.example.habittracker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.habittracker.model.Habit;
import com.example.habittracker.model.HabitRepository;
import com.example.habittracker.model.Category;
import com.example.habittracker.model.Difficulty;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
//testing habit repository class
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HabitRepositoryTest {
	@Autowired
	private HabitRepository repository;
	//testing finding class
	@Test
	public void findHabit() {
		List<Habit> habits = repository.findByName("Drink water");

		assertThat(habits).hasSize(1);
		assertThat(habits.get(0).getDescription()).isEqualTo("Drink water in the morning ");
	}
	//testing creating new habit
	@Test
	public void createNewHabit() {
		Habit habit = new Habit("Drink tea", "Drink tea in the morning ", new Category("Good"), new Difficulty("Easy"));
		repository.save(habit);
		assertThat(habit.getId()).isNotNull();
	}
	//testing deleting new habit
	@Test
	public void deleteNewHabit() {
		Habit habit = new Habit("Drink milk", "Drink milk in the morning ", new Category("Neutral"), new Difficulty("Very hard"));
		repository.save(habit);
		repository.delete(habit);
		assertThat(habit.getId()).isNull();
	}
}
