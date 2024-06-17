package project.orgtech.dao.gender;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.orgtech.models.Gender;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GenderDaoImpl implements GenderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Gender getById(Long id) {
        return entityManager.find(Gender.class, id);
    }

    @Override
    public List<Gender> getAll() {
        return entityManager.createQuery("SELECT g FROM Gender g", Gender.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void add(Gender gender) {
        entityManager.persist(gender);
    }
}
