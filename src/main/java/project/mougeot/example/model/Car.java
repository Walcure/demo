package project.mougeot.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Define the model of the car
 */
@Entity
public class Car {

    /**
     * Identifier of the car
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * Brand of the car
     */
    private String brand;

    /**
     * Model of the car
     */
    private String model;

    /**
     * Price to buy the car
     */
    private Integer price;

    /**
     * Build a default Car
     * brand: Volkswagen
     * model: Golf
     * price: 50000
     */
    public Car() {
        this.brand = "Volkwagen";
        this.model = "Golf 7 GTI";
        this.price = 50000;
    }

    /**
     * Create a specific car
     * @param brand
     * @param model
     * @param price
     */
    public Car(String brand, String model, Integer price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
