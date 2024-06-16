package project.orgtech.dao.gender;

import project.orgtech.models.Gender;

import java.util.List;

public interface GenderDao {
    Gender getById(Long id);
    List<Gender> getAll();
    void add(Gender gender);
}
