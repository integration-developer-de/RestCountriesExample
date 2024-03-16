import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestCountriesExample {

    public static void main(String[] args) {
        try {
            // Define the country name and the API URL
            String countryName = "Germany";
            String apiUrl = "https://restcountries.com/v3.1/name/" + countryName;

            // Call the API and retrieve the JSON response
            String apiResponse = getApiResponse(apiUrl);

            // Process the JSON response and display country data
            displayCountryData(apiResponse);
        } catch (IOException | InterruptedException e) {
            // Handle possible exceptions, e.g., network errors
            e.printStackTrace();
        }
    }

    // Method to perform an HTTP request and return the API response as a string
    private static String getApiResponse(String apiUrl) throws IOException, InterruptedException {
        // Initialize an HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Create an HTTP request with the specified URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        // Send the HTTP request and get the API response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the body of the API response as a string
        return response.body();
    }

    // Method to display the complete JSON of the API response
    private static void displayCountryData(String apiResponse) {
        // Display the complete JSON of the response
        System.out.println("Complete JSON of the API response:");
        System.out.println(apiResponse);
    }
}