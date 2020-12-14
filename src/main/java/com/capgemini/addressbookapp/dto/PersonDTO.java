package com.capgemini.addressbookapp.dto;
import lombok.Data;

public @Data class PersonDTO {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
}
