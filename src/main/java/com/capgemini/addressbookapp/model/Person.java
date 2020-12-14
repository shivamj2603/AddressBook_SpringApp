package com.capgemini.addressbookapp.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.capgemini.addressbookapp.dto.PersonDTO;
import lombok.Data;

@Entity(name="PERSON")
@Table(name = "ADDRESS_BOOK")
public @Data class Person {
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	public Person() {	
	}
	public Person(int id, PersonDTO personDTO){
		this.id = id;
		this.firstName = personDTO.getFirstName();
		this.lastName = personDTO.getLastName();
		this.address = personDTO.getAddress();
		this.city = personDTO.getCity();
		this.state = personDTO.getState();
		this.zipCode = personDTO.getZipCode();
		this.phoneNumber = personDTO.getPhoneNumber();
	}
}
