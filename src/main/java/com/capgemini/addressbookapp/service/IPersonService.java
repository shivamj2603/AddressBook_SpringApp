package com.capgemini.addressbookapp.service;
import java.util.List;
import com.capgemini.addressbookapp.dto.PersonDTO;
import com.capgemini.addressbookapp.model.Person;

public interface IPersonService {
	List<Person> getAllContacts();
	Person getContactById(int id);
    void deletePersonById(int id);
    Person updatePersonById(int id, PersonDTO personDTO);
    Person addPerson(PersonDTO personDTO);

}
