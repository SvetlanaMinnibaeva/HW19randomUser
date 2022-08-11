package patPerson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApiPerson api = new ApiPerson();
        List<Person> persons = new ArrayList<>();
        try {
            persons = api.getApiPersonFromRequest(20);
            System.out.println(persons);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        PersonSort.filter(persons, new Check<Person>() {
            @Override
            public boolean test(Person person) {
                return LocalDateTime.now().getYear() - person.getDob().getYear() > 40;
            }
        });
        PersonSort.filter(persons, person -> {
            return LocalDateTime.now().getYear() - person.getDob().getYear() > 40;
        });

        PersonSort.filter(persons, q -> LocalDateTime.now().getYear() - q.getDob().getYear() > 40);
    }
}

