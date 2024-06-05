package project.orgtech.service.status;

import project.orgtech.models.Status;

import java.util.List;

public interface StatusService {
    Status getStatusById(Long id);
    List<Status> getAllStatuses();
}
