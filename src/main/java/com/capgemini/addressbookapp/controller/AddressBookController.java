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

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@GetMapping(value={"/get", "/", ""})
	public ResponseEntity<String> getAllContacts(){
		return new ResponseEntity<String>("Get call for all contacts succeeded", HttpStatus.OK);
	}
	@GetMapping("/get/{Id}")
	public ResponseEntity<String> getContactById(@PathVariable("Id") int Id){
		return new ResponseEntity<String>("Get call for Id : " + Id , HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<String> addContact(){
		return new ResponseEntity<String>("Post call executed: ", HttpStatus.OK);
	}
	@PutMapping("/update/{Id}")
	public ResponseEntity<String> updateContact(@PathVariable int Id){
		return new ResponseEntity<String>("Update call for Id : " + Id, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> deleteContactById(@PathVariable int Id){
		return new ResponseEntity<String>("Delete call executed for Id : " + Id, HttpStatus.OK);
	}
}
