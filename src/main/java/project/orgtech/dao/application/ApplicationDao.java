package project.orgtech.dao.application;

import project.orgtech.models.Application;

import java.util.List;

public interface ApplicationDao {
    Application getApplicationById(Long id);
    void addApplication(Application application);
    void updateApplication(Application application);
    void deleteApplication(Long id);
    List<Application> getAllApplication();
}
