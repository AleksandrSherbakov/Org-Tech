package project.orgtech.dao.auth;

import org.springframework.stereotype.Repository;
import project.orgtech.models.Master;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MasterDaoImpl implements MasterDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Master getById(Long id) {
        return entityManager.find(Master.class, id);
    }

    @Override
    @Transactional
    public void add(Master master) {
        entityManager.persist(master);
    }

    @Override
    @Transactional
    public void update(Master application) {
        entityManager.merge(application);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Master application = entityManager.find(Master.class, id);
        if (application != null) {
            entityManager.remove(application);
        }
    }

    @Override
    public List<Master> getAll() {
        return entityManager.createQuery("SELECT s FROM Master s", Master.class)
                .getResultList();
    }

    @Override
    public Master findByLogin(String login) {
        String jpql = "SELECT u FROM Master u WHERE u.login = :login";
        List<Master> masters = entityManager.createQuery(jpql, Master.class)
                .setParameter("login", login)
                .getResultList();
        return masters.isEmpty() ? null : masters.get(0);
    }
}
