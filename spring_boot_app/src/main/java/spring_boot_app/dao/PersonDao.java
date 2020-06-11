package spring_boot_app.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import spring_boot_app.model.Person;

/**
 * Create Database
 * @author Sachithra
 *
 */
public interface PersonDao {
	
	int insertPerson(UUID id, Person person);
	/**
	 * Create a method addPerson
	 * @param person
	 * @return personData
	 */
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	/**
	 * Create List for selectAllPeople
	 * @return
	 */
	List<Person> selectAllPeople();
	
	Optional<Person> selectPersonById(UUID id);
	
	

}
