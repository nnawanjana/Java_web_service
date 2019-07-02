package pizzaloop;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer cartId;
    private String imageUrl;
    private String pizzaname;
    private String pizzacrust;
    private String pizzasize;
    private String extra;
    private Integer qty;
    private Double totalprice;
    private Integer status;
    @Column(name = "userid")
    private Integer userID;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPizzaname() {
        return pizzaname;
    }

    public void setPizzaname(String pizzaname) {
        this.pizzaname = pizzaname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPizzacrust() {
        return pizzacrust;
    }

    public void setPizzacrust(String pizzacrust) {
        this.pizzacrust = pizzacrust;
    }

    public String getPizzasize() {
        return pizzasize;
    }

    public void setPizzasize(String pizzasize) {
        this.pizzasize = pizzasize;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
