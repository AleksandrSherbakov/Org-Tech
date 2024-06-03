package project.orgtech.dao;

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
    public Master getMasterById(Long id) {
        return entityManager.find(Master.class, id);
    }

    @Override
    @Transactional
    public void addMaster(Master master) {
        entityManager.persist(master);
    }

    @Override
    public Master findMasterByLogin(String login) {
        String jpql = "SELECT u FROM Master u WHERE u.login = :login";
        List<Master> masters = entityManager.createQuery(jpql, Master.class)
                .setParameter("login", login)
                .getResultList();
        return masters.isEmpty() ? null : masters.get(0);
    }
}
