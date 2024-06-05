package project.orgtech.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.client.ClientDao;
import project.orgtech.models.Client;

import javax.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public Client getClientById(Long id) {
        return clientDao.getClientById(id);
    }

    @Override
    @Transactional
    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    @Override
    @Transactional
    public void updateClient(Client client) {
        clientDao.updateClient(client);
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        clientDao.deleteClient(id);
    }
}
