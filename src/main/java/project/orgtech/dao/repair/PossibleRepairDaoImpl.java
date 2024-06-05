package project.orgtech.dao.repair;

import org.springframework.stereotype.Repository;
import project.orgtech.models.PossibleRepair;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class PossibleRepairDaoImpl implements PossibleRepairDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PossibleRepair getPossibleRepairById(Long id) {
        return entityManager.find(PossibleRepair.class, id);
    }

    @Override
    @Transactional
    public void addPossibleRepair(PossibleRepair possibleRepair) {
        entityManager.persist(possibleRepair);
    }

    @Override
    @Transactional
    public void updatePossibleRepair(PossibleRepair possibleRepair) {
        entityManager.merge(possibleRepair);
    }

    @Override
    @Transactional
    public void deletePossibleRepair(Long id) {
        PossibleRepair possibleRepair = entityManager.find(PossibleRepair.class, id);
        if (possibleRepair != null) {
            entityManager.remove(possibleRepair);
        }
    }
}
