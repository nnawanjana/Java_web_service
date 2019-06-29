package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface PizzaRepository extends CrudRepository<PizzaDetails, Integer>{
    /*
    * Find pizza by Id
    */
    List<PizzaDetails> findByPizzaId(Integer id);

    List<PizzaDetails> findByName(String name);

    /*
    * Delete pizza by Id
    */
    List<PizzaDetails> deleteByPizzaId(Integer id);
}
