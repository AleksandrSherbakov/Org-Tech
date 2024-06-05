package project.orgtech.service.auth;

import project.orgtech.models.Master;

public interface MasterService {
    Master getMasterById(Long id);
    void addMaster(Master master);
    Master findMasterByLogin(String login);



}
