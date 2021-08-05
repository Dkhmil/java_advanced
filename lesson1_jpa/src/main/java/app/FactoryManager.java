package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

public class FactoryManager {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    private static EntityManagerFactory getEntityManagerFactory() {
        if (Objects.isNull(entityManagerFactory)) {
            entityManagerFactory = Persistence.createEntityManagerFactory("AppStorePersistence");
        }
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        if (Objects.isNull(entityManager)) {
            entityManager = getEntityManagerFactory().createEntityManager();
        }
        return entityManager;
    }
}
