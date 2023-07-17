
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

