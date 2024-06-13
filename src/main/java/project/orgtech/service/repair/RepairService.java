package project.orgtech.service.repair;

import project.orgtech.models.Repair;

public interface RepairService {
    Repair getRepairById(Long id);
    void addRepair(Repair repair);
    void updateRepair(Repair repair);
    void deleteRepair(Long id);
}
