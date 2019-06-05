package pizzaloop;

import javax.persistence.*;

@Entity
@Table(name = "pizza_details")
public class PizzaDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer pizzaId;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Double smallprice;
    private Double mediumprice;
    private Double largeprice;

    public Double getSmallprice() {
        return smallprice;
    }

    public void setSmallprice(Double smallprice) {
        this.smallprice = smallprice;
    }

    public Double getMediumprice() {
        return mediumprice;
    }

    public void setMediumprice(Double mediumprice) {
        this.mediumprice = mediumprice;
    }

    public Double getLargeprice() {
        return largeprice;
    }

    public void setLargeprice(Double largeprice) {
        this.largeprice = largeprice;
    }

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
