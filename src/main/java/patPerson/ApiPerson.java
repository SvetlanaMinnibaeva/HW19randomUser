package patPerson;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApiPerson {
    public List<Person> getApiPersonFromRequest(int count) throws IOException, InterruptedException {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder().GET().
                    uri(URI.create("https://randomuser.me/api")).build();
            HttpResponse<String> httpResponse = httpClient.
                    send(httpRequest, HttpResponse.BodyHandlers.ofString());
            persons.add(parsePersonResponse(httpResponse.body()));
        }
        return persons;
    }

    public Person parsePersonResponse(String response) {
        Person person = new Person();
        JSONObject fullData = new JSONObject(response).
                getJSONArray("results").getJSONObject(0);
        person.setGender(fullData.getString("gender"));
        person.setFirstName(fullData.getJSONObject("name").getString("first"));
        person.setLastName(fullData.getJSONObject("name").getString("last"));
        person.setEmail(fullData.getString("email"));
        person.setCountry(fullData.getJSONObject("location").getString("country"));
        person.setCity(fullData.getJSONObject("location").getString("city"));
        ZonedDateTime zonedDateTime = ZonedDateTime.
                parse(fullData.getJSONObject("dob").getString("date"));
        person.setDob(zonedDateTime.toLocalDateTime());

        return person;
    }
}
