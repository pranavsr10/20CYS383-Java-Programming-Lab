
# GeolocationToolGUI

The GeolocationToolGUI is a Java application that allows you to retrieve the location information (address) based on latitude and longitude coordinates using the Nominatim API provided by OpenStreetMap. This tool provides a graphical user interface (GUI) for entering the latitude and longitude values and displays the corresponding location information.

## Project Description

The GeolocationToolGUI project utilizes the following components and libraries:

- Java Swing: The GUI framework used to create the graphical interface.
- Google Gson: A Java library for parsing JSON data.

The project follows a simple flow:

1. The user launches the application.
2. The GUI window titled "Geolocation Tool" appears.
3. The user enters the latitude and longitude values in the respective text fields.
4. After entering the values, the user clicks the "Geocode" button.
5. The application sends a request to the Nominatim API to retrieve the location information.
6. The API response is received and parsed.
7. The extracted location information (display name) is displayed in a label below the button.

## Code
 GeolocationTool.java
   
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

## How to Use

To use the GeolocationToolGUI, follow these steps:

1. Ensure you have Java installed on your system.
2. Compile and run the Java code provided in your preferred development environment or using the command line.
3. The GUI window titled "Geolocation Tool" will appear.
4. Enter the latitude and longitude values in the respective text fields.
5. Click the "Geocode" button.
6. Wait for the application to retrieve the location information.
7. The location information will be displayed in the label below the button.

Please note that an internet connection is required to access the Nominatim API and retrieve the location information.

## Additional Notes

- The Nominatim API URL used in the code is set to retrieve the location data in JSON format and with the English language preference. You can modify the URL if you require a different format or language.
- The code assumes valid latitude and longitude values will be entered by the user. Error handling and validation can be added for a more robust application.
- Make sure to import the necessary libraries (`com.google.gson.JsonObject`, `com.google.gson.JsonParser`, `javax.swing.*`, `java.awt.*`, `java.awt.event.ActionEvent`, `java.awt.event.ActionListener`, `java.io.BufferedReader`, `java.io.IOException`, `java.io.InputStreamReader`, `java.net.HttpURLConnection`, `java.net.URL`) to compile and run the code successfully.

## Conclusion

The GeolocationToolGUI provides a convenient way to retrieve location information based on latitude and longitude coordinates. By leveraging the Nominatim API and a user-friendly GUI, this tool simplifies the process of reverse geocoding. Feel free to enhance the application further to suit your specific requirements.

