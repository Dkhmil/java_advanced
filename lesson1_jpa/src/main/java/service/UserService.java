package service;

import model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(User user);

    User getUserByEmail(String email);

    User getUserById(int id);

    List<User> readAll();

    void delete(int id);

}
