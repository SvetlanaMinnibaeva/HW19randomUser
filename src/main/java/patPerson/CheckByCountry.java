package patPerson;
@FunctionalInterface
interface CheckByCountry<T> {
    boolean checkByCountry(T t);
}
