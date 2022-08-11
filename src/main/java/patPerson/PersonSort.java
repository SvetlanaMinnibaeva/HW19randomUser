package patPerson;

import java.util.ArrayList;
import java.util.List;

public class PersonSort {
    public static void filter(ApiPerson api, Check<Person> check) {
        List<Person> personList = new ArrayList<>();
        for (Person p : personList) {
            if (check.test(p)) {
                System.out.println(p);
            }
        }
    }

    public static void filterByCountry(ApiPerson api, CheckByCountry<Person> check) {
        List<Person> personList = api.getApiPersonFromRequest();
        for (Person p : personList) {
            if (check.checkByCountry(p)) {
                System.out.println(p);
            }
        }
    }

    public static void filterByCityAndCount(
            ApiPerson api,
            CheckByCityAndCount<Person> check,
            int count
    ) throws InterruptedException {
        List<Person> personsList = new ArrayList<>();

        while (personsList.size() < count) {
            Thread.sleep(2000);
            List<Person> personsFromJSON = api.getApiPersonFromRequest();

            for (Person p : personsFromJSON) {
                if (check.checkByCityAndCount(p)) {
                    personsList.add(p);
                    System.out.println(p);
                }
            }
        }
    }
}

