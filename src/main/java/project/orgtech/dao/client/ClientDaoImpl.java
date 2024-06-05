package project.orgtech.dao.client;

import org.springframework.stereotype.Repository;
import project.orgtech.models.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class ClientDaoImpl implements ClientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Client getClientById(Long id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    @Transactional
    public void addClient(Client client) {
        entityManager.persist(client);
    }

    @Override
    @Transactional
    public void updateClient(Client client) {
        entityManager.merge(client);
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        Client client = entityManager.find(Client.class, id);
        if (client != null) {
            entityManager.remove(client);
        }
    }
}
