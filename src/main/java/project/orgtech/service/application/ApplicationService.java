package project.orgtech.service.application;

import project.orgtech.models.Application;

import java.util.List;

public interface ApplicationService {
    Application getById(Long id);
    void add(Application application);
    void update(Application application);
    void delete(Long id);
    List<Application> getAll();
}
