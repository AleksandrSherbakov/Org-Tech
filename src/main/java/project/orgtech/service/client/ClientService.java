package project.orgtech.service.client;

import project.orgtech.models.Client;

import java.util.List;

public interface ClientService {
    Client getById(Long id);
    void add(Client client);
    void update(Client client);
    void delete(Long id);
    List<Client> getAll();
}
