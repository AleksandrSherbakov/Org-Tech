package project.orgtech.service.type;

import project.orgtech.models.Repair;

public interface TypeService {
    Repair getRepairById(Long id);
    void addRepair(Repair repair);
    void updateRepair(Repair repair);
    void deleteRepair(Long id);
}
