package project.orgtech.service.gender;

import project.orgtech.models.Gender;

import java.util.List;

public interface GenderService {
    Gender getById(Long id);
    List<Gender> getAll();
    void add(Gender gender);
}
