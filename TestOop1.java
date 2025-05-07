import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
class Car {
    String model;
    int year;
    long plateno;
    public Car(String model, int year, long plateno) {
    this.model = model;
    this.year = year;
    this.plateno = plateno;

    }
    @Override
    public String toString() {
        return "Model-" + model + " Year-" + year + " Plate No-" + plateno;
    }
}
public class TestOop1 {
    static Car[] cars = new Car[5];

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        while(true) {
            System.out.println("1.Createcars");
            System.out.println("2.listCars");
            System.out.println("3.DeleteCars");
            System.out.println("4.SearchCars");
            System.out.println("5.Exit");
            int choice = userInput.nextInt();
            switch (choice) {
                case 1:
                    createCars();
                    break;
                case 2:
                    listCars();
                    break;
                case 3:
                    deleteCars();
                    break;
                case 4:
                    searchCars();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    static void listCars() {
        for(int i = 0; i < cars.length; ++i) {
            if (cars[i] != null) {
                System.out.println(cars[i]);
            }
        }

        System.out.println();
    }

    static void deleteCars() {
        Scanner userInput2 = new Scanner(System.in);
        System.out.println("Enter Model Name, Year or Plate Number to identify your choice: ");
        int inputToDelete = userInput2.nextInt();

        for(Car car : cars) {
            if (!car.model.equals(inputToDelete) && car.year != inputToDelete && car.plateno != (long)inputToDelete) {
                System.out.println("Invalid Index");
            } else {
                ArrayList<Car> newCars = new ArrayList(Arrays.asList(cars));
                newCars.remove(inputToDelete);
                cars = (Car[])newCars.toArray(new Car[cars.length - 1]);
                System.out.println("Cars Deleted Successfully");
            }
        }

    }

    static void searchCars() {
        Scanner userInput3 = new Scanner(System.in);
        System.out.println("Enter car model, type, or year to search:");
        String input = userInput3.nextLine();
        boolean found = false;

        for(Car car : cars) {
            if (car != null && (car.model.equalsIgnoreCase(input) || String.valueOf(car.year).equals(input) || String.valueOf(car.plateno).equals(input))) {
                System.out.println(car);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Searched Car Not Found");
        }

    }

    static void createCars() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Model :");
        String model = userInput.nextLine();
        System.out.println("Enter Year :");
        int year = userInput.nextInt();
        System.out.println("Enter Plateno :");
        long plateno = userInput.nextLong();
        System.out.println("Confirm Created Car: Model-" + model + " Year- " + year + " Plate No- " + plateno);
        Car car = new Car(model, year, plateno);
        int nextIndex = 0;

        for(int i = 0; i < cars.length; ++i) {
            if (cars[i] == null) {
                nextIndex = i;
                break;
            }
        }

        cars[nextIndex] = car;
    }
}


