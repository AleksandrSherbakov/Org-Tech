package project.orgtech.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.client.ClientDao;
import project.orgtech.models.Client;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public Client getById(Long id) {
        return clientDao.getClientById(id);
    }

    @Override
    @Transactional
    public void add(Client client) {
        clientDao.addClient(client);
    }

    @Override
    @Transactional
    public void update(Client client) {
        clientDao.updateClient(client);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientDao.deleteClient(id);
    }

    @Override
    public List<Client> getAll() {
        return clientDao.getAllClient();
    }
}
