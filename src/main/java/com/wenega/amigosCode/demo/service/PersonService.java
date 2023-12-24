package com.wenega.amigosCode.demo.service;

import com.wenega.amigosCode.demo.dao.PersonDao;
import com.wenega.amigosCode.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;


@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) { //o Autowired é para injetar a interface PersonaDao aqui
        this.personDao = personDao;
    }

    public int addPerson(Person person){

        return  personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){

        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }
}
