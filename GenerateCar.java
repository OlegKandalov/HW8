import java.util.Random;
import java.util.UUID;

public class GenerateCar {
    Random random = new Random();

    UUID getRandomId() {
        return UUID.randomUUID();
    }

    Brand getRandomBrand() {
        int b = random.nextInt(Brand.values().length);
        return Brand.values()[b];
    }

    int getRandomYear() {
        return random.nextInt(20) + 2000;
    }

    int getRandomMileage() {
        return random.nextInt(50000);
    }

    int getRandomPrice() {
        return random.nextInt(10000) + 10000;
    }
}
