package project.orgtech.service.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.orgtech.dao.application.ApplicationDao;
import project.orgtech.models.Application;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationDao applicationDao;
    @Override
    public Application getById(Long id) {
        return applicationDao.getById(id);
    }

    @Override
    @Transactional
    public void add(Application application) {
        applicationDao.add(application);
    }

    @Override
    public void update(Application application) {
    applicationDao.update(application);
    }

    @Override
    public void delete(Long id) {
        applicationDao.delete(id);
    }

    @Override
    public List<Application> getAll() {
        return applicationDao.getAll();
    }
}
