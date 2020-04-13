package liebman.weather;

import liebman.Shape.ShapesFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

import static java.awt.Color.RED;

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
            } catch (IOException e) {
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

    public void getWeather() throws IOException {
        try {
            String API_KEY = "88469cd7dcf885bcfdb9735e579c742f";
            String ZIP_CODE = answerField.getText();
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + ZIP_CODE + ",US&appid=" + API_KEY + "&units=imperial");
            GetCurrentWeather getWeather = new GetCurrentWeather();
            currentWeather = getWeather.getCurrentWeather(url);
            cityLabel.setText(currentWeather.name);
            tempLabel.setText(currentWeather.main.temp + " F");
            descriptionLabel.setText(String.valueOf(currentWeather.weather[0].description));
            errorLabel.setText("");
        }
        catch(Exception e){
            errorLabel.setText(String.valueOf(e));
            errorLabel.setForeground(Color.RED);
            cityLabel.setText("");
            tempLabel.setText("");
            descriptionLabel.setText("");
        }
    }

    public static void main(String[] args){
        new WeatherFrame().setVisible(true);
    }
}
