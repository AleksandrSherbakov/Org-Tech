package project.orgtech.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.auth.MasterDao;
import project.orgtech.models.Master;

import javax.transaction.Transactional;

@Service
public class MasterServiceImpl implements MasterService{

    @Autowired
    private MasterDao masterDao;
    @Override
    public Master getMasterById(Long id) {
        return masterDao.getMasterById(id);
    }

    @Override
    @Transactional
    public void addMaster(Master master) {
        masterDao.addMaster(master);
    }

    @Override
    public Master findMasterByLogin(String login) {
        return masterDao.findMasterByLogin(login);
    }
}
