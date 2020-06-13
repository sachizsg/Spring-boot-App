package spring_boot_app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import spring_boot_app.model.Person;

/**
 * Use same name as PersonService
 *
 */
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    
	private static List<Person> DB = new ArrayList<>();
	
	/**
	 * InsertPerson data | id and name
	 */
	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName()));
		return 1;
	}
    
	/**
	 * List of AllPeople Details
	 */
	@Override
	public List<Person> selectAllPeople() {
		return DB;
	}
    /**
     * Search person by Id
     */
	@Override
	public Optional<Person> selectPersonById(UUID id) {
       return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
	}
	
	/**
     * Delete Person By Id
     */
	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> personMaybe = selectPersonById(id);
		if(personMaybe.isPresent()) {
			DB.remove(personMaybe.get());
			return 1;
		}
		
		return 0;
	}
    /**
     * Update Person By Id
     */
	@Override
	public int updatePersonById(UUID id, Person update) {
		return selectPersonById(id).map(person -> {
			int indexOfPersonToUpdate = DB.indexOf(person);
			if(indexOfPersonToUpdate >= 0) {
				DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
				return 1;
			}
			return 0;
			
		}).orElse(0);
	}
	
	
   
	

}
