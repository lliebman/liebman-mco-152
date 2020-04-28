package liebman.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("http://api.openweathermap.org/data/2.5/weather?appid=88469cd7dcf885bcfdb9735e579c742f&units=imperial")
    Call<CurrentWeather> getWeather(@Query("zip") String zip);
}
