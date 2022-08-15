package patPerson;

import java.util.Scanner;

public class MainHW {
    public static void main(String[] args) {
        ApiPerson api = new ApiPerson();
        
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter country name");
//        String country = scanner.nextLine();
//
//        PersonSort.filterByCountry(api, person -> country.equals(person.getCountry()));
//
//
//        System.out.println("Enter city name");
//        String city = scanner.nextLine();
//        System.out.println("Enter count");
//        Integer count = scanner.nextInt();
//
//        PersonSort.filterByCityAndCount(api, person -> city.equals(person.getCity()), count);

        System.out.println("Enter age");
        Integer age = scanner.nextInt();

        PersonSort.filterByAge(api, person -> age.equals(person.getAge()));

        System.out.println("Enter age from");
        Integer age1 = scanner.nextInt();
        System.out.println("Enter age to");
        Integer age2 = scanner.nextInt();
        PersonSort.filterByAgeInBetween(api, person -> {
            return person.getAge() >= age1 && person.getAge() <= age2;
        });
    }
}