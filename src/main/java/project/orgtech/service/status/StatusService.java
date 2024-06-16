package project.orgtech.service.status;

import project.orgtech.models.Gender;
import project.orgtech.models.Status;

import java.util.List;

public interface StatusService {
    Status getById(Long id);
    List<Status> getAll();
    void add(Status status);
}
