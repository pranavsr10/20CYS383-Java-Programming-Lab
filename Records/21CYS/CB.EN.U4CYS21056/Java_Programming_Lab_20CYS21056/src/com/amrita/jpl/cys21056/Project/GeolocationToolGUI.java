import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeolocationToolGUI {
    private static final String NOMINATIM_API_URL = "https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=";

    private JFrame frame;
    private JLabel latitudeLabel;
    private JTextField latitudeTextField;
    private JLabel longitudeLabel;
    private JTextField longitudeTextField;
    private JButton geocodeButton;
    private JLabel resultLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GeolocationToolGUI().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Geolocation Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        latitudeLabel = new JLabel("Latitude:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(latitudeLabel, constraints);

        latitudeTextField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(latitudeTextField, constraints);

        longitudeLabel = new JLabel("Longitude:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(longitudeLabel, constraints);

        longitudeTextField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(longitudeTextField, constraints);

        geocodeButton = new JButton("Geocode");
        geocodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double latitude = Double.parseDouble(latitudeTextField.getText());
                double longitude = Double.parseDouble(longitudeTextField.getText());

                String location = reverseGeocode(latitude, longitude);
                resultLabel.setText("Location: " + location);
            }
        });
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(geocodeButton, constraints);

        resultLabel = new JLabel();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(resultLabel, constraints);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private String reverseGeocode(double latitude, double longitude) {
        try {
            String apiUrl = NOMINATIM_API_URL + latitude + "&lon=" + longitude + "&accept-language=en";
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            // Parse the JSON response and extract the location data
            JsonParser jsonParser = new JsonParser();
            JsonObject responseObject = jsonParser.parse(response.toString()).getAsJsonObject();

            String displayName = responseObject.get("display_name").getAsString();
            return displayName;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
