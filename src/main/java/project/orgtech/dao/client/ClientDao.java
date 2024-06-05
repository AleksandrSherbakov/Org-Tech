package project.orgtech.dao.client;

import project.orgtech.models.Client;

public interface ClientDao {
    Client getClientById(Long id);
    void addClient(Client client);
    void updateClient(Client client);
    void deleteClient(Long id);
}
