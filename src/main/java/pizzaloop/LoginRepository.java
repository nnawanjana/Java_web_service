package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface LoginRepository extends CrudRepository<Login, Integer> {

    List<Login> findByUserName(String userName);

//    List<Login> deleteByLoginId(Integer id);
}
