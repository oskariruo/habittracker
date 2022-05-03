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
import com.example.habittracker.model.DifficultyRepository;

@Controller
public class HabitController {
	@Autowired
	private HabitRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@Autowired
	private DifficultyRepository drepository;

	// request mapping to get login
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	//request mapping to get list of habits
	@RequestMapping(value = { "/", "/habitlist" })
	public String bookList(Model model) {
		model.addAttribute("habits", repository.findAll());
		System.out.print(repository);
		return "habitlist";
	}
	
	//request to add habit
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("habit", new Habit());
		model.addAttribute("difficulties", drepository.findAll());
		model.addAttribute("categories", crepository.findAll());
		return "addhabit";
	}
	
	//post request mapping to save habit 
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Habit habit) {
		repository.save(habit);
		return "redirect:/habitlist";
	}
	
	// RESTful service to get all habits
	@RequestMapping(value = "/habits", method = RequestMethod.GET)
	public @ResponseBody List<Habit> habitListRest() {
		return (List<Habit>) repository.findAll();
	}
	
	//RESTful service to get habit by id
	@RequestMapping(value = "/habit/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Habit> findHabitRest(@PathVariable("id") Long habitId) {
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
		model.addAttribute("difficulties", drepository.findAll());
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