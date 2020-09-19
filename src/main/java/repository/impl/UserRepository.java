package repository.impl;

import model.User;
import org.springframework.stereotype.Repository;
import repository.abs.AbstractRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository implements AbstractRepository<User, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }

    public User get(String username) {
        return (User) entityManager.createQuery("SELECT user FROM User user WHERE user.name LIKE :username")
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public List<User> getAll() {
        return entityManager
                .createQuery("SELECT user FROM User user", User.class)
                .getResultList();
    }

    @Override
    public void add(User entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("DELETE FROM User user WHERE user.id = " + id).executeUpdate();
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM User").executeUpdate();
    }

    @Override
    public void update(User entity) {
        entityManager.merge(entity);
    }
}