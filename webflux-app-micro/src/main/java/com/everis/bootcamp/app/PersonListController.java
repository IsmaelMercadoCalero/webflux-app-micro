package com.everis.bootcamp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.everis.bootcamp.webfluxserver.web.Person;

import ch.qos.logback.core.model.Model;
import reactor.core.publisher.Flux;

@Controller
public class PersonListController {

	@Autowired
	PersonService personService;

	@GetMapping("/person-list")
	public String personList(final Model model) {
		final Flux<Person> personlist = personService.allPersons();
		model addAttribute("personlist", personlist);
		return "personlist";
		
	}
	

}
