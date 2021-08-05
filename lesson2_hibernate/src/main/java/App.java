
import model.Bucket;
import model.Person;
import model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.PersonService;
import service.impl.PersonServiceImpl;
import util.SessionFactoryUtil;

import java.util.Arrays;
import java.util.HashSet;

public class App {
    private static PersonService service = new PersonServiceImpl();

    public static void main(String[] args) {
/*        service.create(new Person("Petro","Ivanov", 29));
        service.create(new Person("Vasyl","Ivanov", 30));
        service.create(new Person("Andrii","Ivanov", 39));
        service.create(new Person("Ivan","Ivanov", 59));
        service.create(new Person("Natalia","Ivanov", 69));
        service.create(new Person("Stepan","Ivanov", 49));
        service.create(new Person("Petro","Ivanov", 59));
        */

        //       service.readAll().forEach(System.out::println);

        //    Arrays.asList(service.findById(8)).forEach(System.out::println);

        //   service.update(new Person(8, "Ivav", "Ivanov", 52));

        //service.delete(5);

        fillBucketsWithProducts();

    }

    private static void fillBucketsWithProducts() {
        Session session = SessionFactoryUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Bucket bucket = new Bucket("Bucket_1");
        Product product = new Product("Orange", 10);
        Product product2 = new Product("Apple", 30);
        Product product3 = new Product("Banana", 40);

        bucket.setProducts(new HashSet<>(Arrays.asList(product, product2, product3)));


        Bucket bucket2 = new Bucket("Bucket_2");
        Product product4 = new Product("Coffee", 5);
        Product product5 = new Product("Sugar", 15);
        Product product6 = new Product("Milk", 20);

        bucket2.setProducts(new HashSet<>(Arrays.asList(product4, product5, product6)));

        session.persist(bucket);
        session.persist(bucket2);
        transaction.commit();
        session.close();
    }
}
