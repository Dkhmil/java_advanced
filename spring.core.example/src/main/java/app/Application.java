package app;


import dao.impl.ShopDaoImpl;
import model.Shop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        ShopDaoImpl shopDao = (ShopDaoImpl) context.getBean("shopDao");

        Shop shop1 = (Shop) context.getBean("shop1");
        Shop shop2 = (Shop) context.getBean("shop2");
        Shop shop3 = (Shop) context.getBean("shop3");


        shopDao.create(shop1);
        shopDao.create(shop2);
        shopDao.create(shop3);


        shopDao.readAll().forEach(System.out::println);
    }
}
