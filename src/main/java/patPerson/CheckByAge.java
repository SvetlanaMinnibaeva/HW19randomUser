package patPerson;

@FunctionalInterface
interface CheckByAge<T> {
    boolean checkByAge(T t);
}
