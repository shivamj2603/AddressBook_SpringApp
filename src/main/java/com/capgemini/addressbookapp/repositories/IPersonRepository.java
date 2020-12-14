package com.capgemini.addressbookapp.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.addressbookapp.model.Person;

public interface IPersonRepository extends JpaRepository<Person,Integer> {

}
