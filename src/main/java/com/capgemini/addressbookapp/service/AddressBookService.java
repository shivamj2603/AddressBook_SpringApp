package com.capgemini.addressbookapp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.addressbookapp.dto.PersonDTO;
import com.capgemini.addressbookapp.model.Person;
import com.capgemini.addressbookapp.repositories.IPersonRepository;

@Service
public class AddressBookService implements IPersonService {
	@Autowired 
	private IPersonRepository personRepository;
	@Override
	public List<Person> getAllContacts() {
		return personRepository.findAll();
	}
	@Override
	public Person getContactById(int id) {
		return personRepository.findById(id).get();
	}
	@Override
	public void deletePersonById(int id) {
		personRepository.deleteById(id);
	}
	@Override
	public Person updatePersonById(int id, PersonDTO personDTO) {
		Person person = this.getContactById(id);
		person = new Person(id, personDTO);
		personRepository.save(person);
		return this.getContactById(id);
	}
	@Override
	public Person addPerson(PersonDTO personDTO) {
		int count = (int)personRepository.count();
		Person person = new Person(count + 1, personDTO);
		personRepository.save(person);
		return this.getContactById(count + 1);
	}
}
