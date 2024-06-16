package project.orgtech.dao.status;

import project.orgtech.models.Status;

import java.util.List;

public interface StatusDao {
    Status getById(Long id);
    List<Status> getAll();
    void add(Status status);

}
