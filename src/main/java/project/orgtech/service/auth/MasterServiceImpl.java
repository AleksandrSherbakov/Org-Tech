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
    public Master getById(Long id) {
        return masterDao.getById(id);
    }

    @Override
    @Transactional
    public void add(Master master) {
        masterDao.add(master);
    }

    @Override
    public Master findByLogin(String login) {
        return masterDao.findByLogin(login);
    }
}
