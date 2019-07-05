package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CartRepository extends CrudRepository<Cart, Integer>{
    /*
     * Find Cart Item by ID
     */
    List<Cart> findByCartId(Integer id);
    /*
     * Find Cart item by user ID
     */
    List<Cart> findByUserID(Integer userid);
    /*
     * Delete Cart Item by Cart Id
     */
    List<Cart> deleteByCartId(Integer id);
    /*
     * Delete Cart Item by status
     */
    List<Cart> deleteByStatus(Integer status);
    /*
     * Find Cart Item by user ID
     */
    List<Cart> deleteByUserID(Integer userid);

}
