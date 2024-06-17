package project.orgtech.dao.status;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.orgtech.models.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StatusDaoImpl implements StatusDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Status getById(Long id) {
        return entityManager.find(Status.class, id);
    }

    @Override
    public List<Status> getAll() {
        return entityManager.createQuery("SELECT s FROM Status s", Status.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void add(Status status) {
        entityManager.persist(status);
    }

}
