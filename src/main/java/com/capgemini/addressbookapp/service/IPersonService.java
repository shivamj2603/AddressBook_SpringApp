package com.capgemini.addressbookapp.service;
import java.util.List;
import com.capgemini.addressbookapp.dto.PersonDTO;
import com.capgemini.addressbookapp.exceptions.InvalidContactDetailsException;
import com.capgemini.addressbookapp.model.Person;

public interface IPersonService {
	List<Person> getAllContacts();
	Person getContactById(int id) throws InvalidContactDetailsException;
    void deletePersonById(int id) throws InvalidContactDetailsException;
    Person updatePersonById(int id, PersonDTO personDTO) throws InvalidContactDetailsException;
    Person addPerson(PersonDTO personDTO) throws InvalidContactDetailsException;

}
