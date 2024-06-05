package project.orgtech.dao.repair;

import project.orgtech.models.PossibleRepair;

public interface PossibleRepairDao {
    PossibleRepair getPossibleRepairById(Long id);
    void addPossibleRepair(PossibleRepair possibleRepair);
    void updatePossibleRepair(PossibleRepair possibleRepair);
    void deletePossibleRepair(Long id);
}
