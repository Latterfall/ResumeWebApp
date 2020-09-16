package repository.abs;

import java.util.List;

public interface AbstractRepository<T, Long> {
    T get(Long id);
    List<T> getAll();
    void add(T entity);
    void delete(Long id);
    void deleteAll();
    void update(T entity);
}
