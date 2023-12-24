package com.wenega.amigosCode.demo.dao;

import com.wenega.amigosCode.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default  int insertPerson(Person person){ // aqui tem 2 construtores
        UUID id = UUID.randomUUID();
        return  insertPerson(id, person);
    }

    List<Person> selectAllPeople(); // é para declarar aqui na interface só e a implementação deve ser feita  na classe Service ou seja FakePersonDataAccessService

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id); // interface para deletar uma pessoa pelo Id

    int updatePersonById(UUID id, Person person); //interface para atualizar uma pessoa pelo Id

}
