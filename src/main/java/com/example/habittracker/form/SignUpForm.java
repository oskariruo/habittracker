package com.example.habittracker.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignUpForm {

	@NotEmpty
	@Size(min = 4, max = 15)
	private String username = "";

	@NotEmpty
	@Size(min = 4, max = 15)
	private String password = "";

	@NotEmpty
	private String email = "";

	@NotEmpty
	private String role = "USER";

	public SignUpForm() {

	}

	public SignUpForm(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
