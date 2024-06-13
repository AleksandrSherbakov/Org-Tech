package project.orgtech.dao.type;

import project.orgtech.models.Repair;

public interface TypeDao {
    Repair getRepairById(Long id);
    void addRepair(Repair repair);
    void updateRepair(Repair repair);
    void deleteRepair(Long id);
}
