package patPerson;
@FunctionalInterface
interface Check<T> {
    boolean test(T t);
}
