package com.capgemini.addressbookapp.service;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.addressbookapp.dto.PersonDTO;
import com.capgemini.addressbookapp.exceptions.InvalidContactDetailsException;
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
	public Person getContactById(int id) throws InvalidContactDetailsException {
		return personRepository.findById(id).orElseThrow(() -> new InvalidContactDetailsException("Contact not found"));
	}
	@Override
	public void deletePersonById(int id) throws InvalidContactDetailsException {
		personRepository.findById(id).orElseThrow(() -> new InvalidContactDetailsException("Contact to be Delete Not found"));
		personRepository.deleteById(id);
	}
	@Override
	public Person updatePersonById(int id, PersonDTO personDTO) throws InvalidContactDetailsException {
		Person person = personRepository.findById(id).orElseThrow(() -> new InvalidContactDetailsException("Contact to be Updated Not found"));
		person = new Person(id, personDTO);
		personRepository.save(person);
		return this.getContactById(id);
	}
	@Override
	public Person addPerson(PersonDTO personDTO) throws InvalidContactDetailsException {
		int count = (int)personRepository.count();
		Person person = new Person(count + 1, personDTO);
		personRepository.save(person);
		return personRepository.findById(count + 1).orElseThrow(() -> new InvalidContactDetailsException("Contact Not Added"));
	}
}
