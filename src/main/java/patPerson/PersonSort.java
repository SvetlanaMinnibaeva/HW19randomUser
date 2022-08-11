package patPerson;


import java.util.List;
import java.util.Scanner;

public class PersonSort {
    public static void filter(List<Person> personList, Check<Person> check) {
        for (Person p : personList) {
            if (check.test(p)) {
                System.out.println(p);
            }
        }
    }

    public static void filterByCountry(List<Person> persons, CheckByCountry<Person> check) {
        for (Person p : persons) {
            if (check.checkByCountry(p)) {
                System.out.println(p);
            }
        }
    }

    public static void filterByCityAndCount(List<Person> persons, CheckByCityAndCount<Person> check, int count) {
        int i = 0;
        while (i <= count)
            for (Person p : persons) {
                if (check.checkByCityAndCount(p)) {
                    System.out.println(p);
                }
                i++;

            }
    }
}