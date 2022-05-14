package crud.dao;

import crud.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveUser(User user) {
        entityManager.persist(user);
    }


    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    public User findById(int id) {
        return entityManager.find(User.class, id);
    }


    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("select a from User a", User.class);
        return query.getResultList();
    }

}
