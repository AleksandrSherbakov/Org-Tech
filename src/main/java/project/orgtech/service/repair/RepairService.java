package project.orgtech.service.repair;

import project.orgtech.models.Repair;

import java.util.List;

public interface RepairService {
    Repair getById(Long id);
    void add(Repair repair);
    void update(Repair repair);
    void delete(Long id);
    List<Repair> getAll();
}
