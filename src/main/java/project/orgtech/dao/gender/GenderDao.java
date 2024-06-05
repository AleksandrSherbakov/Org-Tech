package project.orgtech.dao.gender;

import project.orgtech.models.Gender;

import java.util.List;

public interface GenderDao {
    Gender getGenderById(Long id);
    List<Gender> getAllGenders();
}
