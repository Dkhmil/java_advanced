package service;

import model.Person;

import java.util.List;

public interface PersonService {

    Person findById(int id);

    List<Person> readAll();

    void create(Person person);

    void update(Person person);

    void delete(int id);
}