package patPerson;

import java.util.Scanner;

public class MainHW {
    public static void main(String[] args) throws InterruptedException {
        ApiPerson api = new ApiPerson();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter country name");
        String country = scanner.nextLine();

        PersonSort.filterByCountry(api, person -> country.equals(person.getCountry()));


        System.out.println("Enter city name");
        String city = scanner.nextLine();
        System.out.println("Enter count");
        int count = scanner.nextInt();

        PersonSort.filterByCityAndCount(api, person -> city.equals(person.getCity()), count);

    }
}