import java.util.*;

class CityWeather {
    private String cityName;
    private double temperature;
    private int humidity;
    private String condition;

    public CityWeather(String cityName, double temperature, int humidity, String condition) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.condition = condition;
    }

    public String getCityName() {
        return cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "City: " + cityName + "\n" +
               "Temperature: " + temperature + "°C\n" +
               "Humidity: " + humidity + "%\n" +
               "Condition: " + condition + "\n";
    }
}

public class WeatherForecastingSystem {
    private static Map<String, CityWeather> weatherData = new HashMap<>();

    public static void main(String[] args) {
        initializeWeatherData();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Weather Forecasting System!");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Get Weather Information");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter city name: ");
                    String city = scanner.nextLine();
                    displayWeatherInfo(city);
                    break;
                case 2:
                    System.out.println("Thank you for using the Weather Forecasting System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeWeatherData() {
        weatherData.put("New York", new CityWeather("New York", 22.0, 60, "Sunny"));
        weatherData.put("London", new CityWeather("London", 16.5, 80, "Cloudy"));
        weatherData.put("Mumbai", new CityWeather("Mumbai", 30.0, 70, "Rainy"));
        weatherData.put("Tokyo", new CityWeather("Tokyo", 18.5, 65, "Windy"));
        weatherData.put("Sydney", new CityWeather("Sydney", 25.0, 55, "Clear"));
    }

    private static void displayWeatherInfo(String city) {
        CityWeather weather = weatherData.get(city);
        if (weather != null) {
            System.out.println("\nWeather Information:");
            System.out.println(weather);
        } else {
            System.out.println("Weather data for " + city + " is not available.");
        }
    }
}
