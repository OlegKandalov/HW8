import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        List<Car> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(car.randomCar());
        }

        List<Car> onlyTeslaAndAudi = list.stream()
                .filter(b -> b.getBrand() == Brand.TESLA || b.getBrand() == Brand.AUDI)
                .collect(Collectors.toList());
        System.out.println("List with cars Tesla and Audi: "
                + System.lineSeparator() + onlyTeslaAndAudi);

        List<Car> onlyYoungCar = onlyTeslaAndAudi.stream().filter(y -> y.getYear() >= 2018)
                .collect(Collectors.toList());
        System.out.println("List with cars Tesla and Audi, that after 2018: " +
                System.lineSeparator() + onlyYoungCar);

        List<Car> lessThan40000Mileage = onlyYoungCar.stream().filter(m -> m.getMileage() < 40000)
                .collect(Collectors.toList());
        System.out.println("List with cars Tesla and Audi, that after 2018, less than 40000 mileage: " +
                System.lineSeparator() + lessThan40000Mileage + System.lineSeparator());

        List<Car> bestThreeCars = lessThan40000Mileage.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(3).collect(Collectors.toList());
        System.out.println("Your best cars: " + System.lineSeparator() + bestThreeCars
                + System.lineSeparator());

        Map<UUID, Car> finishedList = bestThreeCars.stream()
                .collect(Collectors.toMap(Car::getId, Function.identity()));

        for (Map.Entry<UUID, Car> map : finishedList.entrySet()) {
            if (bestThreeCars.isEmpty()) {
                System.out.println("You don't have a car. All cars sold out");
            } else {
                System.out.println(map);
            }
        }

    }
}
