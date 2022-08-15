package patPerson;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person {
    private String gender;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String email;
    private LocalDateTime dob;

    private Integer age;

    public Person() {
    }

    public Person(
            String gender,
            String firstName,
            String lastName,
            String country,
            String city,
            String email,
            LocalDateTime dob,
            Integer age
    ) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.email = email;
        this.dob = dob;
        this.city = city;
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (gender != null ? !gender.equals(person.gender) : person.gender != null) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (country != null ? !country.equals(person.country) : person.country != null) return false;
        if (city != null ? !city.equals(person.city) : person.city != null) return false;
        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        if (dob != null ? !dob.equals(person.dob) : person.dob != null) return false;
        return age != null ? age.equals(person.age) : person.age == null;
    }

    @Override
    public int hashCode() {
        int result = gender != null ? gender.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.getGender().equals("male")
                ?
                "Мистер " +
                        lastName + '.' +
                        " Pодом из " + country + '.' + " " +
                        dob.getYear() + " года рождения." +
                        " Связаться по email " + email + '.'
                :

                "Мисcис " +
                        lastName + '.' +
                        " Pодом из " + country + '.' + " " +
                        dob.getYear() + " года рождения." +
                        " Связаться по email " + email + '.';

    }
}
