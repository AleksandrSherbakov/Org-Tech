package project.orgtech.service.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.dao.repair.RepairDao;
import project.orgtech.dao.type.TypeDao;
import project.orgtech.models.Repair;
import project.orgtech.models.Type;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public Type getTypeById(Long id) {
        return typeDao.getTypeById(id);
    }

    @Override
    @Transactional
    public void addType(Type type) {
        typeDao.addType(type);
    }

    @Override
    @Transactional
    public void updateType(Type type) {
        typeDao.updateType(type);
    }

    @Override
    @Transactional
    public void deleteType(Long id) {
        typeDao.deleteType(id);
    }

    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }
}
