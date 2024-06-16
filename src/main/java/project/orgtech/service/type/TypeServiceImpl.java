package project.orgtech.service.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.type.TypeDao;
import project.orgtech.models.Type;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public Type getById(Long id) {
        return typeDao.getById(id);
    }

    @Override
    @Transactional
    public void add(Type type) {
        typeDao.add(type);
    }

    @Override
    @Transactional
    public void update(Type type) {
        typeDao.update(type);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        typeDao.delete(id);
    }

    @Override
    public List<Type> getAll() {
        return typeDao.getAll();
    }
}
