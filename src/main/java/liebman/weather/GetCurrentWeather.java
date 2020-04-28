package liebman.weather;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetCurrentWeather {


    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);


        service.getWeather("92122").enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(retrofit2.Call<CurrentWeather> call,
                                   Response<CurrentWeather> response) {
                CurrentWeather currentWeather = response.body();
                System.out.println(currentWeather.name);
                System.out.println(currentWeather.main.temp + " F");
                System.out.println(currentWeather.weather[0].description);
            }

            @Override
            public void onFailure(retrofit2.Call<CurrentWeather> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}