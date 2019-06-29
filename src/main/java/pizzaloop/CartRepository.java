package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CartRepository extends CrudRepository<Cart, Integer>{

    List<Cart> findByCartId(Integer id);

    List<Cart> deleteByCartId(Integer id);

    List<Cart> deleteByStatus(Integer status);

}
