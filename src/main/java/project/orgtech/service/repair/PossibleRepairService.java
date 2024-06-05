package project.orgtech.service.repair;

import project.orgtech.models.PossibleRepair;

public interface PossibleRepairService {
    PossibleRepair getPossibleRepairById(Long id);
    void addPossibleRepair(PossibleRepair possibleRepair);
    void updatePossibleRepair(PossibleRepair possibleRepair);
    void deletePossibleRepair(Long id);
}
