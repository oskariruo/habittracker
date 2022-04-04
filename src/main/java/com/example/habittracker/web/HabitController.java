package com.example.habittracker.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.habittracker.model.Habit;
import com.example.habittracker.model.HabitRepository;
import com.example.habittracker.model.CategoryRepository;

@Controller
public class HabitController {
	@Autowired
	private HabitRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/", "/habitlist" })
	public String bookList(Model model) {
		model.addAttribute("habits", repository.findAll());
		System.out.print(repository);
		return "habitlist";
	}

	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("habit", new Habit());
		model.addAttribute("categories", crepository.findAll());
		return "addhabit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Habit habit) {
		repository.save(habit);
		return "redirect:/habitlist";
	}

	@RequestMapping(value = "/habits", method = RequestMethod.GET)
	public @ResponseBody List<Habit> habitListRest() {
		return (List<Habit>) repository.findAll();
	}

	@RequestMapping(value = "/habit/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Habit> findStudentRest(@PathVariable("id") Long habitId) {
		return repository.findById(habitId);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteHabit(@PathVariable("id") Long habitId, Model model) {
		repository.deleteById(habitId);
		return "redirect:../habitlist";
	}

	@RequestMapping(value = "/edithabit/{id}", method = RequestMethod.GET)
	public String modifyHabit(@PathVariable("id") Long habitId, Model model) {
		Optional<Habit> habit = repository.findById(habitId);
		model.addAttribute("categories", crepository.findAll());
		model.addAttribute("habit", habit);
		return "edithabit";
	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String editHabit(Habit habit) {
		repository.save(habit);
		return "redirect:/habitlist";
	}
}