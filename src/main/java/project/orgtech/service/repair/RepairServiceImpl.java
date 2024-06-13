package project.orgtech.service.repair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.repair.RepairDao;
import project.orgtech.models.Repair;

import javax.transaction.Transactional;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairDao repairDao;

    @Override
    public Repair getRepairById(Long id) {
        return repairDao.getRepairById(id);
    }

    @Override
    @Transactional
    public void addRepair(Repair repair) {
        repairDao.addRepair(repair);
    }

    @Override
    @Transactional
    public void updateRepair(Repair repair) {
        repairDao.updateRepair(repair);
    }

    @Override
    @Transactional
    public void deleteRepair(Long id) {
        repairDao.deleteRepair(id);
    }
}
