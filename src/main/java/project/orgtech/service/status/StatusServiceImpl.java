package project.orgtech.service.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.status.StatusDao;
import project.orgtech.models.Status;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusDao statusDao;

    @Override
    public Status getStatusById(Long id) {
        return statusDao.getStatusById(id);
    }

    @Override
    public List<Status> getAllStatuses() {
        return statusDao.getAllStatuses();
    }
}
