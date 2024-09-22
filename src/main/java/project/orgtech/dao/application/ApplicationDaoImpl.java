package project.orgtech.dao.application;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.orgtech.models.Application;
import project.orgtech.models.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Application getById(Long id) {
        return entityManager.find(Application.class, id);
    }

    @Override
    @Transactional
    public void add(Application application) {
         entityManager.persist(application);
    }

    @Override
    @Transactional
    public void update(Application application) {
        entityManager.merge(application);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Application application = entityManager.find(Application.class, id);
        if (application != null) {
            entityManager.remove(application);
        }
    }

    @Override
    public List<Application> getAll() {
        return entityManager.createQuery("SELECT s FROM Application s", Application.class)
                .getResultList();
    }
}
