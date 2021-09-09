package service;

import dao.Person;
import exception.NoSuchUserException;

import java.util.List;

public interface PersonService {

    boolean isAuthorized(Person person) throws NoSuchUserException;
}
