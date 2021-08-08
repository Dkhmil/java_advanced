import model.many_to_many.Team;
import model.many_to_many.User;
import model.one_to_many.Cart;
import model.one_to_many.Item;
import model.one_to_one.Customer;
import model.one_to_one.FinancialOperation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryUtil;


import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class App {


    public static void main(String[] args) {
        // manyToManyExample();
        // oneToManyExample();
        oneToOneExample();
    }

    private static void manyToManyExample() {
        Session session = SessionFactoryUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Team team = new Team("Team-1");
        Team team2 = new Team("Team-2");

        User user = new User("123@gmail.com", "123");
        User user2 = new User("1234@gmail.com", "1234");

        team.addUser(user);
        team.addUser(user2);

        team2.addUser(user);
        team2.addUser(user2);

        session.save(team);
        session.save(team2);

        commitAndCloseSession(session, transaction);
    }

    private static void commitAndCloseSession(Session session, Transaction transaction) {
        transaction.commit();
        session.close();
    }

    private static void oneToManyExample() {
        Session session = SessionFactoryUtil.getSession();
        Transaction transaction = session.beginTransaction();


        Cart cart = new Cart("cart-1");
        Cart cart2 = new Cart("cart-2");


        Item item = new Item(10, cart, new Date(System.currentTimeMillis()));
        Item item2 = new Item(20, cart, new Date());
        Item item3 = new Item(30, cart2, new Date());
        Item item4 = new Item(40, cart2, new Date());

        Set<Item> items = new HashSet<>(Arrays.asList(item, item2));
        cart.setItems(items);

        Set<Item> items2 = new HashSet<>(Arrays.asList(item3, item4));
        cart2.setItems(items2);

        session.save(cart);
        session.save(cart2);

        commitAndCloseSession(session, transaction);
    }

    public static void oneToOneExample() {
        Session session = SessionFactoryUtil.getSession();
        Transaction transaction = session.beginTransaction();


        Customer customer = new Customer("Ivan Petrenko", "abc@gmail.com");
        FinancialOperation operation = new FinancialOperation(new Date(), 700);

        customer.setFinancialOperation(operation);
        session.save(customer);

        commitAndCloseSession(session, transaction);
    }
}
