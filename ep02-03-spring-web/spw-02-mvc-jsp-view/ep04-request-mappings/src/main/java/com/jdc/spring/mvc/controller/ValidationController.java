package com.jdc.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdc.spring.mvc.controller.input.PersonForm;
import com.jdc.spring.mvc.controller.output.PersonInfo;
import com.jdc.spring.mvc.model.entity.Person.Gender;
import com.jdc.spring.mvc.model.repo.PersonRepo;

@Controller
@RequestMapping("validation")
public class ValidationController {
	
	@Autowired
	private PersonRepo repo;

	@GetMapping
	public String index() {
		return "validation";
	}
	
	@GetMapping("{id}")
	public String edit(@PathVariable Integer id) {
		return "validation";
	}
	
	@PostMapping
	public String save(
			@Validated @ModelAttribute("personForm") PersonForm form, BindingResult result, 
			RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return "validation";
		}
		
		repo.save(form.entity());
		
		redirectAttributes.addFlashAttribute("message", "%s is %s successfully.".formatted(form.getName(), 
				form.getId() != null ? "Updated" : "Created"));
		
		return "redirect:/validation";
	}
	
	@ModelAttribute(name = "personForm")
	PersonForm personForm(@PathVariable(required = false) Integer id) {
		return id == null ? new PersonForm() : repo.findById(id)
				.map(PersonForm::from).orElse(new PersonForm());
	}
	
	@ModelAttribute(name = "genders")
	Gender[] genders() {
		return Gender.values();
	}
	
	@Transactional(readOnly = true)
	@ModelAttribute(name = "persons")
	List<PersonInfo> persons() {
		return repo.findAll().stream().map(PersonInfo::new).toList();
	}
}
