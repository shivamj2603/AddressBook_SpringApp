package com.capgemini.addressbookapp.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.addressbookapp.dto.PersonDTO;
import com.capgemini.addressbookapp.dto.ResponseDTO;
import com.capgemini.addressbookapp.exceptions.InvalidContactDetailsException;
import com.capgemini.addressbookapp.model.Person;
import com.capgemini.addressbookapp.service.IPersonService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	@Autowired
	private IPersonService personService;
	
	@GetMapping(value={"/get", "/", ""})
	public ResponseEntity<ResponseDTO> getAllContacts() {
		List<Person> contactList = personService.getAllContacts();
		ResponseDTO respDTO = new ResponseDTO("List of all Contacts : ", contactList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable("id") int id) throws InvalidContactDetailsException{
		Person person = personService.getContactById(id);
		ResponseDTO respDTO = new ResponseDTO("Contact id : " + id, person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody PersonDTO personDTO) throws InvalidContactDetailsException{
		Person person = personService.addPerson(personDTO);
		ResponseDTO respDTO = new ResponseDTO("Contact added with id : " + person.getId(), person);
		
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateContact(@PathVariable int id, @Valid @RequestBody PersonDTO personDTO) throws InvalidContactDetailsException{
		Person person = personService.updatePersonById(id, personDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Contact with id : " + id, person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteContactById(@PathVariable int id) throws InvalidContactDetailsException{
		personService.deletePersonById(id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Contact with id : ", id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
