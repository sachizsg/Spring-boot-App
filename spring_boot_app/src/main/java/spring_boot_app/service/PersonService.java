package spring_boot_app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import spring_boot_app.dao.PersonDao;
import spring_boot_app.model.Person;

@Service
public class PersonService {
	
	private final PersonDao personDao;
	
	/**
	 * Injecting PersonData interface
	 * @param personDao
	 */
	@Autowired
	public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
		this.personDao = personDao;
	}
	
	/**
	 * Add Person
	 * @param person
	 * @return
	 */
	public int addPerson(Person person) {
		return personDao.insertPerson(person);
	}
	
	/**
	 * AetAllPerson | Person list
	 * @return all people details
	 */
	public List<Person> getAllPerson(){
		return personDao.selectAllPeople();
	}
	
	public Optional<Person> getPersonById(UUID id){
		return personDao.selectPersonById(id);
	}
	
	

}
