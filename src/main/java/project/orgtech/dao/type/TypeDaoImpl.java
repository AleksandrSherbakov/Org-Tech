package project.orgtech.dao.type;

import org.springframework.stereotype.Repository;
import project.orgtech.models.Repair;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class TypeDaoImpl implements TypeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Repair getRepairById(Long id) {
        return entityManager.find(Repair.class, id);
    }

    @Override
    @Transactional
    public void addRepair(Repair repair) {
        entityManager.persist(repair);
    }

    @Override
    @Transactional
    public void updateRepair(Repair repair) {
        entityManager.merge(repair);
    }

    @Override
    @Transactional
    public void deleteRepair(Long id) {
        Repair repair = entityManager.find(Repair.class, id);
        if (repair != null) {
            entityManager.remove(repair);
        }
    }
}
