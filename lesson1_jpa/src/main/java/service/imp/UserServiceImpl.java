package service.imp;

import app.FactoryManager;
import model.User;
import service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserServiceImpl implements UserService {

    private EntityManager entityManager = FactoryManager.getEntityManager();

    @Override
    public User createUser(User user) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public User updateUser(User user) {
        User userToUpdate = getUserById(user.getId());
        if (userToUpdate != null) {
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setRole(user.getRole());
        }
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.merge(userToUpdate);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return userToUpdate;
    }

    @Override
    public User getUserByEmail(String email) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        query.select(from);
        query.where(builder.equal(from.get("email"), email));
        return entityManager.createQuery(query).getResultList().get(0);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> readAll() {
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return (List<User>) query.getResultList();
    }

    @Override
    public void delete(int id) {
        User user = getUserById(id);
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }
}
