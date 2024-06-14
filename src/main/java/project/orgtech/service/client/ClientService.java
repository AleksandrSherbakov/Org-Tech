package project.orgtech.service.client;

import project.orgtech.models.Client;
import project.orgtech.models.Repair;

import java.util.List;

public interface ClientService {
    Client getClientById(Long id);
    void addClient(Client client);
    void updateClient(Client client);
    void deleteClient(Long id);
    List<Client> getAllClient();
}
