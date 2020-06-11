package spring_boot_app.app;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_boot_app.model.Person;
import spring_boot_app.service.PersonService;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
 
	private final PersonService personService;
    
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	/**
	 * Add Person 
	 * @param person
	 */
	@PostMapping
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	/**
	 * GetAllPeople details
	 * @return personList | id and name
	 */
	@GetMapping
	public List<Person> getAllPeople(){
		return personService.getAllPerson();
	}
	/**
	 * Get person by id
	 * @param id
	 * @return
	 */
	@GetMapping(path = "{id}")
	public Person getPersonbyId(@PathVariable("id") UUID id){
		return personService.getPersonById(id).orElse(null);
	}
	

}
