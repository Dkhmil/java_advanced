import model.User;
import service.UserService;
import service.imp.UserServiceImpl;

public class App {

    private static UserService userService = new UserServiceImpl();


    public static void main(String[] args) {
        //userService.delete(1);
      /*  userService.createUser(new User("test2@gmail.com", "12345", "Andrii", "Tymchenko", "user"));
        userService.createUser(new User("test2@gmail.com", "12345", "Andrii1", "Tymchenko1", "user"));
        userService.createUser(new User("test3@gmail.com", "12345", "Andrii2", "Tymchenko2", "user"));
        userService.createUser(new User("test4@gmail.com", "12345", "Andrii3", "Tymchenko3", "user"));*/

/*        User userById = userService.getUserById(3);
        System.out.println(userById);*/

        // userService.readAll().forEach(System.out::println);


/*        User userByEmail = userService.getUserByEmail("test2@gmail.com");
        System.out.println(userByEmail);*/

       // userService.updateUser(new User(2, "test2@gmail.com", "0000", "Petro", "Tymchenko", "user"));
    }
}
