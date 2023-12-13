package ra.md05ss5bttodolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.md05ss5bttodolist.entity.Todo;
import ra.md05ss5bttodolist.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Override
    public List<Todo> findAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    @Override
    public Todo findById(Integer id) {
        Optional<Todo> todoList = todoRepository.findById(id);
        return todoList.orElse(null);
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void delete(Integer id) {
        todoRepository.deleteById(id);
    }
}
