package patPerson;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ApiPerson api = new ApiPerson();
        PersonSort.filter(api, new Check<Person>() {
            @Override
            public boolean test(Person person) {
                return LocalDateTime.now().getYear() - person.getDob().getYear() > 40;
            }
        });

        PersonSort.filter(api, person -> {
            return LocalDateTime.now().getYear() - person.getDob().getYear() > 40;
        });

        PersonSort.filter(api, q -> LocalDateTime.now().getYear() - q.getDob().getYear() > 40);
    }
}

