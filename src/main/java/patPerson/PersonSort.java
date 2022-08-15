package patPerson;

import java.util.ArrayList;
import java.util.List;

public class PersonSort {
    public static void filter(ApiPerson api, Check<Person> check) {
        List<Person> personsFromJSON = api.getApiPersonFromRequest();
        personsFromJSON.stream()
                .filter(check::test)
                .forEach(System.out::println);

    }

    public static void filterByCountry(ApiPerson api, CheckByCountry<Person> check) {
        List<Person> personsFromJSON = api.getApiPersonFromRequest();
        personsFromJSON.stream()
                .filter(check::checkByCountry)
                .forEach(System.out::println);
    }

    public static void filterByCityAndCount(
            ApiPerson api,
            CheckByCityAndCount<Person> check,
            Integer count
    ) throws InterruptedException {
        List<Person> personsList = new ArrayList<>();
        while (personsList.size() < count) {
            List<Person> personsFromJSON = api.getApiPersonFromRequest();
            personsFromJSON.stream()
                    .filter(check::checkByCityAndCount)
                    .forEach(p -> {
                        personsList.add(p);
                        System.out.println(p);
                    });
        }
    }

    public static void filterByAge(ApiPerson api, CheckByAge<Person> check) {
        List<Person> personsFromJSON = api.getApiPersonFromRequest();
        personsFromJSON.stream()
                .filter(check::checkByAge)
                .forEach(System.out::println);
    }

    public static void filterByAgeInBetween(ApiPerson api, CheckAgeInBetweenCount<Person> check) {
        List<Person> personsFromJSON = api.getApiPersonFromRequest();
        long count = personsFromJSON.stream()
                .filter(check::checkAgeInBetweenCount)
                .count();
        System.out.println(count);
    }
}








