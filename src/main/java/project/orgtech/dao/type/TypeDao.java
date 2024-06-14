package project.orgtech.dao.type;

import project.orgtech.models.Type;

import java.util.List;

public interface TypeDao {
    Type getTypeById(Long id);
    void addType(Type type);
    void updateType(Type type);
    void deleteType(Long id);
    List<Type> getAllType();
}
