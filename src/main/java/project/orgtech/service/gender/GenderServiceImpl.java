package project.orgtech.service.gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.gender.GenderDao;
import project.orgtech.models.Gender;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderDao genderDao;

    @Override
    public Gender getById(Long id) {
        return genderDao.getById(id);
    }

    @Override
    public List<Gender> getAll() {
        return genderDao.getAll();
    }

    @Override
    public void add(Gender gender) {
        genderDao.add(gender);
    }
}
