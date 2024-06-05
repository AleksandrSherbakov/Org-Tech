package project.orgtech.service.gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.gender.GenderDao;
import project.orgtech.models.Gender;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderDao genderDao;

    @Override
    public Gender getGenderById(Long id) {
        return genderDao.getGenderById(id);
    }

    @Override
    public List<Gender> getAllGenders() {
        return genderDao.getAllGenders();
    }
}
