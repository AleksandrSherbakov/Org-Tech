package project.orgtech.dao.client;

import project.orgtech.models.Client;

import java.util.List;

public interface ClientDao {
    Client getClientById(Long id);
    void addClient(Client client);
    void updateClient(Client client);
    void deleteClient(Long id);
    List<Client> getAllClient();
}
