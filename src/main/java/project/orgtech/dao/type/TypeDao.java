package project.orgtech.dao.type;

import project.orgtech.models.Type;

import java.util.List;

public interface TypeDao {
    Type getById(Long id);
    void add(Type type);
    void update(Type type);
    void delete(Long id);
    List<Type> getAll();
}
