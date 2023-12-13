package ra.md05ss5bttodolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ra.md05ss5bttodolist.entity.Todo;
@Repository
public interface TodoRepository extends CrudRepository<Todo,Integer> {
}
