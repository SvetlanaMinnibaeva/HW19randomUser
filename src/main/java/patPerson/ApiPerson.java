package patPerson;

import org.json.JSONArray;
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
                uri(URI.create("https://randomuser.me/api/?results=5000")).build();
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
        JSONArray fullData = new JSONObject(response).getJSONArray("results");
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < fullData.length(); i++) {
            JSONObject personJSON = fullData.getJSONObject(i);
            Person person = new Person();
            person.setGender(personJSON.getString("gender"));
            person.setFirstName(personJSON.getJSONObject("name").getString("first"));
            person.setLastName(personJSON.getJSONObject("name").getString("last"));
            person.setEmail(personJSON.getString("email"));
            person.setCountry(personJSON.getJSONObject("location").getString("country"));
            person.setCity(personJSON.getJSONObject("location").getString("city"));
            ZonedDateTime zonedDateTime = ZonedDateTime.
                    parse(personJSON.getJSONObject("dob").getString("date"));
            person.setDob(zonedDateTime.toLocalDateTime());
            persons.add(person);
        }
        return persons;
    }
}
