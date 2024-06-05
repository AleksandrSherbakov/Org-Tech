package project.orgtech.service.repair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.repair.PossibleRepairDao;
import project.orgtech.models.PossibleRepair;

import javax.transaction.Transactional;

@Service
public class PossibleRepairServiceImpl implements PossibleRepairService {

    @Autowired
    private PossibleRepairDao possibleRepairDao;

    @Override
    public PossibleRepair getPossibleRepairById(Long id) {
        return possibleRepairDao.getPossibleRepairById(id);
    }

    @Override
    @Transactional
    public void addPossibleRepair(PossibleRepair possibleRepair) {
        possibleRepairDao.addPossibleRepair(possibleRepair);
    }

    @Override
    @Transactional
    public void updatePossibleRepair(PossibleRepair possibleRepair) {
        possibleRepairDao.updatePossibleRepair(possibleRepair);
    }

    @Override
    @Transactional
    public void deletePossibleRepair(Long id) {
        possibleRepairDao.deletePossibleRepair(id);
    }
}
