package project.orgtech.service.repair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.repair.RepairDao;
import project.orgtech.models.Repair;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairDao repairDao;

    @Override
    public Repair getById(Long id) {
        return repairDao.getById(id);
    }

    @Override
    @Transactional
    public void add(Repair repair) {
        repairDao.addRepair(repair);
    }

    @Override
    @Transactional
    public void update(Repair repair) {
        repairDao.update(repair);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repairDao.delete(id);
    }

    @Override
    public List<Repair> getAll() {
        return repairDao.getAll();
    }
}
