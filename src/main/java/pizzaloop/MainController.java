package pizzaloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * Created by Chathura on 4/8/2019.
 * Edited by Nadeesha Nawanjana
 * CT/2015/038
 * FCT
 * UOK
 */
@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private LoginRepository loginRepository;


    private static final String SUCCESS= "Saved";

    /*
    * READ Operation
    * This method will list all the pizzas in the table
    * URI to access this: http://localhost:8080/demo/all
    */
    @GetMapping(path="/all")
    public @ResponseBody Iterable<PizzaDetails> getPizzaDetails() {

        return pizzaRepository.findAll();

    }

    /*
    * READ Operation based on Pizza ID
    * This method will return the details of a pizza specified by the id
    * URI to access this: http://localhost:8080/demo/findByPizzaId?id=2
    */

    @GetMapping(path="/findByPizzaId")
    public @ResponseBody List<PizzaDetails> getPizzaById(@RequestParam Integer id) {
        return pizzaRepository.findByPizzaId(id);
    }

    /*
     * READ Operation based on Pizza Name
     * This method will return the details of a pizza specified by the name
     * URI to access this: http://localhost:8080/demo/findByName?name=pizza
     */

    @GetMapping(path="/findByName")
    public @ResponseBody List<PizzaDetails> getPizzaByName(@RequestParam String name) {
        return pizzaRepository.findByName(name);
    }

    /*
    * CREATE Operation
    * This method will crate new pizza item in the database table
    * and returns the SUCCESS message
    * URI to access this: http://localhost:8080/demo/add?name=VegiPizza&description=VegiSupreme&price=2500.75
    */
    @GetMapping(path="/add")
    public @ResponseBody String addNewPizza(@RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam Double smallprice, @RequestParam Double mediumprice, @RequestParam Double largeprice) {
        PizzaDetails pizzaDetails = new PizzaDetails();
        pizzaDetails.setName(name);
        pizzaDetails.setDescription(description);
        pizzaDetails.setPrice(price);
        pizzaDetails.setSmallprice(smallprice);
        pizzaDetails.setMediumprice(mediumprice);
        pizzaDetails.setLargeprice(largeprice);
        pizzaRepository.save(pizzaDetails);
        return SUCCESS;
    }

    /*
    * DELETE Operation
    * This method will delete existing pizza item by finding it using the ID
    * and returns the deleted item
    * URI to access this: http://localhost:8080/demo/deleteByPizzaId?id=2
    */
    @GetMapping(path="/deleteByPizzaId")
    public @ResponseBody List<PizzaDetails> deletePizzaById(@RequestParam Integer id) {
        return pizzaRepository.deleteByPizzaId(id);
    }

    /*
    * UPDATE Operation
    * This method will update existing pizza details by finding it using the ID
    * and returns the updated data
    * URI to access this: http://localhost:8080/demo/update?id=1&name=updatedname&description=updated&price=1234.56
    */

    @GetMapping(path="/update")
    public @ResponseBody List<PizzaDetails> updatePizzaDetails(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam Double smallprice, @RequestParam Double mediumprice, @RequestParam Double largeprice) {
        //First get all the pizza details according to the provided ID
        List<PizzaDetails> pizzaDetailsList = pizzaRepository.findByPizzaId(id);
        if(!pizzaDetailsList.isEmpty()) {
            //Iterate through the pizza list
            for(PizzaDetails pizzaDetails: pizzaDetailsList) {
                //Set new values
                pizzaDetails.setName(name);
                pizzaDetails.setDescription(description);
                pizzaDetails.setPrice(price);
                pizzaDetails.setSmallprice(smallprice);
                pizzaDetails.setMediumprice(mediumprice);
                pizzaDetails.setLargeprice(largeprice);
                //Update existing pizza item
                pizzaRepository.save(pizzaDetails);
            }
        }
        return pizzaRepository.findByPizzaId(id);
    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------*/
    /*
     * READ Operation
     * This method will list all the Cart item in the table
     * URI to access this: http://localhost:8080/demo/cart
     */

    @GetMapping(path="/cart")
    public @ResponseBody Iterable<Cart> getCart() {

        return cartRepository.findAll();

    }
    /*
     * READ Operation based on Cart ID
     * This method will return the details of a Cart Item specified by the cart id
     * URI to access this: http://localhost:8080/demo/findByCartId?id=2
     */
    @GetMapping(path="/findByCartId")
    public @ResponseBody List<Cart> getCartById(@RequestParam Integer id) {
        return cartRepository.findByCartId(id);
    }

    /*
     * READ Operation based on User ID
     * This method will return the details of a Cart Item specified by the User id
     * URI to access this: http://localhost:8080/demo/findByUserID?userid=2
     */
    @GetMapping(path="/findByUserID")
    public @ResponseBody List<Cart> getCartById1(@RequestParam Integer userid) {
        return cartRepository.findByUserID(userid);
    }
    /*
     * CREATE Operation
     * This method will crate new Cart Item item in the database table
     * and returns the SUCCESS message
     * URI to access this: http://localhost:8080/demo/addtocart?cartId=1&imageUrl=&pizzaname=&pizzacrust=&pizzasize=&
     * extra=&qty=&totalprice=&userID=&status=
     *
     */
    @GetMapping(path="/addtocart")
    public @ResponseBody String addNewCart(@RequestParam Integer cartId,@RequestParam String imageUrl, @RequestParam String pizzaname, @RequestParam String pizzacrust, @RequestParam String pizzasize, @RequestParam String extra, @RequestParam Integer qty, @RequestParam Double totalprice , @RequestParam Integer userID, @RequestParam Integer status) {
        Cart cart = new Cart();
        cart.setCartId(cartId);
        cart.setImageUrl(imageUrl);
        cart.setPizzaname(pizzaname);
        cart.setPizzacrust(pizzacrust);
        cart.setPizzasize(pizzasize);
        cart.setExtra(extra);
        cart.setQty(qty);
        cart.setTotalprice(totalprice);
        cart.setUserID(userID);
        cart.setStatus(status);
        cartRepository.save(cart);
        return SUCCESS;
    }
    /*
     * DELETE Operation
     * This method will delete existing Cart item by finding it using the ID
     * and returns the deleted item
     * URI to access this: http://localhost:8080/demo/deleteByCartId?id=2
     */
    @GetMapping(path="/deleteByCartId")
    public @ResponseBody List<Cart> deleteCartById(@RequestParam Integer id) {
        return cartRepository.deleteByCartId(id);
    }
    /*
     * DELETE Operation
     * This method will delete existing Cart item by finding it using the status
     * and returns the deleted item
     * URI to access this: http://localhost:8080/demo/deleteByStatus?status=1
     */
    @GetMapping(path="/deleteByStatus")
    public @ResponseBody List<Cart> deleteCartByStatus(@RequestParam Integer status) {
        return cartRepository.deleteByStatus(status);
    }
    /*
     * DELETE Operation
     * This method will delete existing Cart item by finding it using the user Id
     * and returns the deleted item
     * URI to access this: http://localhost:8080/demo/deleteByUserID?userid=1
     */
    @GetMapping(path="/deleteByUserID")
    public @ResponseBody List<Cart> deleteCartByUserID(@RequestParam Integer userid) {
        return cartRepository.deleteByUserID(userid);
    }
    /*
     * UPDATE Operation
     * This method will update existing Cart details by finding it using the ID
     * and returns the updated data
     * URI to access this: http://localhost:8080/demo/updateCart??cartId=1&imageUrl=&pizzaname=&pizzacrust=&pizzasize=&
     * extra=&qty=&totalprice=&userID=&status=
     */

    @GetMapping(path="/updateCart")
    public @ResponseBody List<Cart> updateCart(@RequestParam Integer cartId,@RequestParam String imageUrl, @RequestParam String pizzaname, @RequestParam String pizzacrust, @RequestParam String pizzasize, @RequestParam String extra, @RequestParam Integer qty, @RequestParam Double totalprice, @RequestParam Integer userID, @RequestParam Integer status) {
        //First get all the pizza details according to the provided ID
        List<Cart> cartList = cartRepository.findByCartId(cartId);
        if(!cartList.isEmpty()) {
            //Iterate through the pizza list
            for(Cart cart: cartList) {
                //Set new values
                cart.setImageUrl(imageUrl);
                cart.setPizzaname(pizzaname);
                cart.setPizzacrust(pizzacrust);
                cart.setPizzasize(pizzasize);
                cart.setExtra(extra);
                cart.setQty(qty);
                cart.setTotalprice(totalprice);
                cart.setUserID(userID);
                cart.setStatus(status);
                //Update existing pizza item
                cartRepository.save(cart);
            }
        }
        return cartRepository.findByCartId(cartId);
    }

//    ---------------------------------------------------------------------------------------------
    /*
     * READ Operation
     * This method will list all the Users in the table
     * URI to access this: http://localhost:8080/demo/login
     */
    @GetMapping(path="/login")
    public @ResponseBody Iterable<Login> getLogin() {

        return loginRepository.findAll();

    }
    /*
     * CREATE Operation
     * This method will crate new User Item item in the database table
     * and returns the SUCCESS message
     * URI to access this: http://localhost:8080/demo/adduser?loginId=&firstName=&lastName=&userName=&password=&phoneNumber=
     *
     */
    @GetMapping(path="/adduser")
    public @ResponseBody String addNewUser(@RequestParam Integer loginId,@RequestParam String firstName, @RequestParam String lastName, @RequestParam String userName, @RequestParam String password, @RequestParam String phoneNumber) {
        Login login = new Login();
        login.setLoginId(loginId);
        login.setFirstName(firstName);
        login.setLastName(lastName);
        login.setUserName(userName);
        login.setPassword(password);
        login.setPhoneNumber(phoneNumber);
        loginRepository.save(login);
        return SUCCESS;
    }
    /*
     * READ Operation based on User Name
     * This method will return the details of a User Item specified by the User name
     * URI to access this: http://localhost:8080/demo/findByUserName?username=nadeesha
     */
    @GetMapping(path="/findByUserName")
    public @ResponseBody List<Login> getByUserName(@RequestParam String username) {
        return loginRepository.findByUserName(username);
    }



}
