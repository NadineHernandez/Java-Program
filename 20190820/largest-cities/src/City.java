import java.util.*;

public class City {
    private String name;
    private int population;

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        City newYork = new City("New York", 86543321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMoines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);

        Map<String, City> state = new HashMap<>();

        state.put("New York", newYork);
        state.put("California", losAngeles);
        state.put("Illinois", chicago);
        state.put("Colorado", denver);
        state.put("Iowa", desMoines);
        state.put("Georgia", atlanta);

        Set<String> myKeys = state.keySet();
        myKeys = state.keySet();
        for (String key: myKeys) {
            City currentCity = state.get(key);
            System.out.println("State: " + key + " City: " + currentCity.getName() + " Population: " + currentCity.getPopulation());
        }

        int userInput;
        System.out.println("Enter a population minimum as a whole integer.");
        userInput = Integer.parseInt(scan.nextLine());

        for (String key: myKeys) {
            City currentCity = state.get(key);
            if (userInput <= currentCity.getPopulation()) {
                System.out.println("State: " + key + " City: " + currentCity.getName() + " Population: " + currentCity.getPopulation());
            }
        }
    }
}
