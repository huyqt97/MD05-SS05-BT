package ra.md05ss5bttodolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.md05ss5bttodolist.entity.Todo;
import ra.md05ss5bttodolist.service.TodoService;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/todolist")
public class TodoListController {
    @Autowired
    private TodoService todoService;

    @GetMapping("")
    public ResponseEntity<List<Todo>> view() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable("id") Integer id) {
        Todo todo = todoService.findById(id);
        if (todo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<Todo> add(@RequestBody Todo todo) {
        Todo todoNew = todoService.save(todo);
        if (todoNew == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(todoNew, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Integer id, @RequestBody Todo todo) {
        Todo todo1 = todoService.findById(id);
        if (todo1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Todo todoUpdate = todoService.save(todo);
            return new ResponseEntity<>(todoUpdate, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> delete(@PathVariable("id") Integer id) {
        if (todoService.findById(id) != null) {
            todoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
