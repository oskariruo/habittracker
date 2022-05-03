package com.example.habittracker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.habittracker.model.Category;
import com.example.habittracker.model.CategoryRepository;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//testing CategoryRepository class
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository repository;
	//testing finding category
	@Test
	public void findCategory() {
		List<Category> category = repository.findByName("Good");
		assertThat(category.get(0).getName()).isEqualTo("Good");
	}
	//testing creating new category
	@Test
	public void createCategory() {
		Category category = new Category("Terrific");
		repository.save(category);
		assertThat(!category.getName().isEmpty());
	}
	//testing deleting category
	@Test
	public void deleteCategory() {
		Category category = new Category("Awful");
		repository.deleteById(category.getCategoryid());
		assertThat(category.getHabits().isEmpty());
	}
}

