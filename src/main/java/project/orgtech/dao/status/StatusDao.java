package project.orgtech.dao.status;

import project.orgtech.models.Status;

import java.util.List;

public interface StatusDao {
    Status getStatusById(Long id);
    List<Status> getAllStatuses();
}
