package project.orgtech.service.gender;

import project.orgtech.models.Gender;

import java.util.List;

public interface GenderService {
    Gender getGenderById(Long id);
    List<Gender> getAllGenders();
}
