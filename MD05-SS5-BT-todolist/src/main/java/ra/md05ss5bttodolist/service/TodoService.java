package ra.md05ss5bttodolist.service;

import ra.md05ss5bttodolist.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAll();
    Todo findById(Integer id);
    Todo save(Todo todo);
    void delete(Integer id);
}
