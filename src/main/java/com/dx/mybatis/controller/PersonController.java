package com.dx.mybatis.controller;

import com.dx.mybatis.mapper.PersonMapper;
import com.dx.mybatis.pojo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * @author dengx
 * @date 2020/3/26-15:36
 * @for
 */
@RestController
@RequestMapping(value = {"/person"})
public class PersonController {

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    PersonMapper personMapper;

    @GetMapping(value = {"/all"})
    public List<Person> findAll() {
        List<Person> list = personMapper.findAll();
        return list;
    }

    @GetMapping(value = {"/one/{id}"})
    public Person findById(@PathVariable int id) {
        Person person = personMapper.findOne(id);
        return person;
    }

    @GetMapping(value = {"/add"})
    public Person addPerson() {
        Person person = new Person();
        person.setName("testPerson_" + new Random().nextInt(5));
        person.setAge(new Random().nextInt(50));
        person.setSalary(new Random().nextDouble() * 1000);
        personMapper.addPerson(person);
        return person;
    }

    @DeleteMapping(value = {"/delete/{id}"})
    public Person deletePerson(@PathVariable int id) {
        Person person = personMapper.findOne(id);
        logger.info("before deleteperson = {}", person);
        personMapper.deleteOne(id);
        logger.info("after delete person = {}", person);
        return person;
    }
}
