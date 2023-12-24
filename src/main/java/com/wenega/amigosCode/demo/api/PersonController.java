package com.wenega.amigosCode.demo.api;

import com.wenega.amigosCode.demo.model.Person;
import com.wenega.amigosCode.demo.service.PersonService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;


@RequestMapping("api/v1/person")  // aqui é para definir o caminho
@RestController
public class PersonController {

    private  final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    // metodo POST
    @PostMapping
    public  void addPerson(@RequestBody Person person) {

        personService.addPerson(person);
    }

    //metodo GET all
    @GetMapping
    public List<Person> getAllPeople() {

        return personService.getAllPeople();
    }

    //Metodo GET by id
    @GetMapping(path ="{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return  personService.getPersonById(id).stream()
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public int deletePersonById(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }
}
