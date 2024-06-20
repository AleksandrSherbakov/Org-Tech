package project.orgtech.service.auth;

import project.orgtech.models.Master;

public interface MasterService {
    Master getById(Long id);
    void add(Master master);
    Master findByLogin(String login);
    void update(Master master);

}
