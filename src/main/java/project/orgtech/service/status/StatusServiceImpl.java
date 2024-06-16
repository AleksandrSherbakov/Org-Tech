package project.orgtech.service.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.status.StatusDao;
import project.orgtech.models.Status;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusDao statusDao;

    @Override
    public Status getById(Long id) {
        return statusDao.getById(id);
    }

    @Override
    public List<Status> getAll() {
        return statusDao.getAll();
    }

    @Override
    public void add(Status status) {
        statusDao.add(status);
    }
}
