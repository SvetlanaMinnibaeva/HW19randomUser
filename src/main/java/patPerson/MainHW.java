package patPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHW {
    public static void main(String[] args) {
        ApiPerson api = new ApiPerson();
        List<Person> persons = new ArrayList<>();
        try {
            persons = api.getApiPersonFromRequest(50);
            System.out.println(persons);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter country name");
        String country = scanner.nextLine();

        PersonSort.filterByCountry(persons, person -> country.equals(person.getCountry()));


        System.out.println("Enter city name");
        String city = scanner.nextLine();
        System.out.println("Enter count");
        int count = scanner.nextInt();

        PersonSort.filterByCityAndCount(persons, person -> city.equals(person.getCity()), count);
    }
}