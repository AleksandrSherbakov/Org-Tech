package project.orgtech.dao.auth;

import project.orgtech.models.Master;

import java.util.List;

public interface MasterDao {
    Master getById(Long id);
    void add(Master master);
    void update(Master master);
    void delete(Long id);
    List<Master> getAll();
    Master findByLogin(String login);
}
