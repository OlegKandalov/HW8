import java.util.UUID;

public class Car extends GenerateCar {
    private UUID id;
    private Brand brand;
    private int year;
    private int mileage;
    private int price;

    public Car() {
        this.id = getRandomId();
        this.brand = getRandomBrand();
        this.year = getRandomYear();
        this.mileage = getRandomMileage();
        this.price = getRandomPrice();
    }

    public UUID getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand=" + brand +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
