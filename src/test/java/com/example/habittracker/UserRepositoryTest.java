package com.example.habittracker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.habittracker.model.User;
import com.example.habittracker.model.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
//testing UserRepository class with user
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;
	//testing finding User
	@Test
	public void findUser() {
		User users = repository.findByUsername("user");
		assertThat(users.getEmail()).isEqualTo("user@haaga-helia.fi");
	}
	//testing creating new User
	@Test
	public void createNewUser() {
		User user = new User("tested", "$2a$10$i/AfvSt.ZDf8QpaGvZj7iePh1EdLRs10dK6qMplzRP/vsIExLuAhO",
				"tested@haaga-helia.fi", "USER");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	//testing deleting User
	@Test
	public void deleteNewUser() {
		User user = repository.findByUsername("testi");
		repository.delete(user);
		assertThat(user.getId()).isNull();
	}
}
