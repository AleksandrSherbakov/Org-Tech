package project.orgtech.dao.repair;

import org.springframework.stereotype.Repository;
import project.orgtech.models.Repair;
import project.orgtech.models.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RepairDaoImpl implements RepairDao {

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

    @Override
    public List<Repair> getAllRepair() {
        return entityManager.createQuery("SELECT s FROM Repair s", Repair.class)
                .getResultList();
    }
}
