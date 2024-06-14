package project.orgtech.service.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.orgtech.dao.application.ApplicationDao;
import project.orgtech.dao.type.TypeDao;
import project.orgtech.models.Application;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationDao applicationDao;
    @Override
    public Application getApplicationById(Long id) {
        return applicationDao.getApplicationById(id);
    }

    @Override
    @Transactional
    public void addApplication(Application application) {
        applicationDao.addApplication(application);
    }

    @Override
    public void updateApplication(Application application) {
    applicationDao.updateApplication(application);
    }

    @Override
    public void deleteApplication(Long id) {
        applicationDao.deleteApplication(id);
    }

    @Override
    public List<Application> getAllApplication() {
        return applicationDao.getAllApplication();
    }
}
