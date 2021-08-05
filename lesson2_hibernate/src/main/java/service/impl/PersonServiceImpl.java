package service.impl;


import model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.PersonService;
import util.SessionFactoryUtil;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private Session session;
    private Transaction transaction;

    public PersonServiceImpl() {
    }

    @Override
    public Person findById(int id) {
        initializeSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    @Override
    public List<Person> readAll() {
        initializeSession();
        List<Person> personList = session.createCriteria(Person.class).list();
        session.close();
        return personList;
    }

    @Override
    public void create(Person person) {
        initializeSession();
        session.persist(person);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Person person) {
        Person personToUpdate = findById(person.getId());
        personToUpdate.setFirstName(person.getFirstName());
        personToUpdate.setLastName(person.getLastName());
        personToUpdate.setAge(person.getAge());
        initializeSession();
        session.update(personToUpdate);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Person personToDelete = findById(id);
        initializeSession();
        session.delete(personToDelete);
        transaction.commit();

    }

    private void initializeSession() {
        session = SessionFactoryUtil.getSession();
        transaction = session.beginTransaction();
    }
}
