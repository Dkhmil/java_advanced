package app;


import dao.ShopDao;
import dao.impl.ShopDaoImpl;
import model.Shop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ShopConfiguration {

    @Bean(name = "shopDao")
    @Scope("singleton")
    public ShopDao getShopDao() {
        return new ShopDaoImpl();
    }

    @Bean(name = "shop1")
    public Shop shop() {
        return  new Shop(1, "Shop 1", 200.00, 100);
    }

    @Bean(name = "shop2")
    public Shop shop2() {
        return  new Shop(2, "Shop 2", 300.00, 200);
    }

    @Bean(name = "shop3")
    public Shop shop3() {
        return  new Shop(3, "Shop 3", 4500.00, 10330);
    }


}
