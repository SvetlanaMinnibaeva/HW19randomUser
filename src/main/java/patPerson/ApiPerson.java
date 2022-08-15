package patPerson;

import org.json.JSONObject;
import java.net.URI;
import java.net.http.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


public class ApiPerson {
    public List<Person> getApiPersonFromRequest() {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().GET().
                uri(URI.create("https://randomuser.me/api/?results=1000")).build();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.
                    send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert httpResponse != null;
        return parsePersonResponse(httpResponse.body());

    }


    public ArrayList<Person> parsePersonResponse(String response) {
        ArrayList<Person> persons = new ArrayList<>();
        int infoCount = new JSONObject(response).getJSONObject("info").getInt("results");

        for (int i = 0; i < infoCount; i++) {
            Person person = new Person();
            JSONObject personJSON = new JSONObject(response).getJSONArray("results").getJSONObject(i);

            person.setGender(personJSON.getString("gender"));
            person.setFirstName(personJSON.getJSONObject("name").getString("first"));
            person.setLastName(personJSON.getJSONObject("name").getString("last"));
            person.setEmail(personJSON.getString("email"));
            person.setCountry(personJSON.getJSONObject("location").getString("country"));
            person.setCity(personJSON.getJSONObject("location").getString("city"));
            ZonedDateTime zonedDateTime = ZonedDateTime.
                    parse(personJSON.getJSONObject("dob").getString("date"));
            person.setDob(zonedDateTime.toLocalDateTime());
            person.setAge(personJSON.getJSONObject("dob").getInt("age"));
            persons.add(person);
        }
        return persons;
    }
}
