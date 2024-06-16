package project.orgtech.service.type;

import project.orgtech.models.Type;

import java.util.List;

public interface TypeService {
    Type getById(Long id);
    void add(Type type);
    void update(Type type);
    void delete(Long id);
    List<Type> getAll();
}
