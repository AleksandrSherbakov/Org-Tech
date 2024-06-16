package project.orgtech.dao.type;

import org.springframework.stereotype.Repository;
import project.orgtech.models.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TypeDaoImpl implements TypeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Type getById(Long id) {
        return entityManager.find(Type.class, id);
    }

    @Override
    @Transactional
    public void add(Type type) {
        entityManager.persist(type);
    }

    @Override
    @Transactional
    public void update(Type type) {
        entityManager.merge(type);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Type type = entityManager.find(Type.class, id);
        if (type != null) {
            entityManager.remove(type);
        }
    }

    @Override
    public List<Type> getAll() {
        return entityManager.createQuery("SELECT s FROM Type s", Type.class)
                .getResultList();
    }
}
