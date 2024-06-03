package project.orgtech.dao;

import project.orgtech.models.Master;

public interface MasterDao {
    Master getMasterById(Long id);
    void addMaster(Master master);
    Master findMasterByLogin(String login);
}
