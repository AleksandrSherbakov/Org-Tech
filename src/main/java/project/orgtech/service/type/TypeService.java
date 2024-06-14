package project.orgtech.service.type;

import project.orgtech.models.Type;

import java.util.List;

public interface TypeService {
    Type getTypeById(Long id);
    void addType(Type type);
    void updateType(Type type);
    void deleteType(Long id);
    List<Type> getAllType();
}
