package liebman.weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;


public class WeatherFrame extends JFrame {

    private JPanel upperPanel;
    private JLabel zipLabel;
    private JTextField answerField;
    private JButton checkButton;

    private JPanel centerPanel;
    private JLabel cityLabel;
    private JLabel tempLabel;
    private JLabel descriptionLabel;
    private CurrentWeather currentWeather;

    private JPanel lowerPanel;
    private JLabel errorLabel;

    public WeatherFrame(){
        setSize(450, 350);
        setTitle("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout());

        zipLabel = new JLabel("Enter zip code");
        zipLabel.setOpaque(true);

        answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(160, 30));

        checkButton = new JButton("Get Weather");
        checkButton.addActionListener(actionEvent -> {
            try {
                getWeather();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        upperPanel.add(zipLabel);
        upperPanel.add(answerField);
        upperPanel.add(checkButton);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1));

        cityLabel = new JLabel("", SwingConstants.CENTER);
        tempLabel = new JLabel("", SwingConstants.CENTER);
        descriptionLabel = new JLabel("", SwingConstants.CENTER);

        centerPanel.add(cityLabel);
        centerPanel.add(tempLabel);
        centerPanel.add(descriptionLabel);

        lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout());

        errorLabel = new JLabel();
        lowerPanel.add(errorLabel);

        add(upperPanel, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(lowerPanel, BorderLayout.PAGE_END);
    }

    public void getWeather() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);
        service.getWeather(answerField.getText()).enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                CurrentWeather currentWeather = response.body();
                if (response.body() == null){
                    errorLabel.setText("An error ocurred");
                    errorLabel.setForeground(Color.RED);
                    cityLabel.setText("");
                    tempLabel.setText("");
                    descriptionLabel.setText("");
                }
                else {
                    cityLabel.setText(currentWeather.name);
                    tempLabel.setText(currentWeather.main.temp + " F");
                    descriptionLabel.setText(currentWeather.weather[0].description);
                    errorLabel.setText("");
                }
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                errorLabel.setText("An error ocurred");
                errorLabel.setForeground(Color.RED);
                cityLabel.setText("");
                tempLabel.setText("");
                descriptionLabel.setText("");
            }
        });
    }

    public static void main(String[] args){
        new WeatherFrame().setVisible(true);
    }
}
