package project.orgtech.dao.application;

import project.orgtech.models.Application;

import java.util.List;

public interface ApplicationDao {
    Application getById(Long id);
    void add(Application application);
    void update(Application application);
    void delete(Long id);
    List<Application> getAll();
}
