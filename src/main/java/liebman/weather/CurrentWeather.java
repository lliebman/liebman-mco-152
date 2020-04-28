package liebman.weather;

public class CurrentWeather {

    String base;
    int visibility;
    Coord coord;
    String name;
    Main main;
    Weather weather[];

    class Coord {
        double lon;
        double lat;
    }

    class Main {
        double temp;
        double feels_like;
    }

    class Weather {
        int ID;
        String description;
        String icon;
    }

}
