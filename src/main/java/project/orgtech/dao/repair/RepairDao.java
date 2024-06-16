package project.orgtech.dao.repair;

import project.orgtech.models.Repair;

import java.util.List;

public interface RepairDao {
    Repair getById(Long id);
    void addRepair(Repair repair);
    void update(Repair repair);
    void delete(Long id);
    List<Repair> getAll();
}
