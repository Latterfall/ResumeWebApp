package repository.impl;

import model.Message;
import org.springframework.stereotype.Repository;
import repository.abs.AbstractRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MessageRepository implements AbstractRepository<Message, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Message get(Long id) {
        return entityManager.find(Message.class, id);
    }

    @Override
    public List<Message> getAll() {
        return entityManager
                .createQuery("SELECT message FROM Message message", Message.class)
                .getResultList();
    }

    @Override
    public void add(Message entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("DELETE FROM Message message WHERE message.id = " + id).executeUpdate();
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Message").executeUpdate();
    }

    @Override
    public void update(Message entity) {
        entityManager.merge(entity);
    }
}
