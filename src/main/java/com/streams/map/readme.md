# Map Operation

```java
List<Person> list = ... ;
Stream<Person> stream = list.stream();
Stream<String> names = 
    stream.map(person -> person.getName());
```

* `map()` returns a Stream so it's an intermediary operation.
* A mapper is modelled by the _Function_ interface as below:

```java
@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);
}
```
* The `apply()` method takes an object and return another object.
* In our example we could pass an object of type _Person_ and then return an _Integer_,

```java
@FunctionalInterface
public interface Function<T, R> {
    
    R apply(T t);
    
    default <V> Function<V, R> compose(Function<V, T> before);
    
    default <V> Function<T, V> andThen(Function<R, V> after);
}
```
* We also have a set of `default` methods to chain and compose mappings which are the `andThen` and `compose` methods.

```java
@FunctionalInterface
public interface Function<T, R> {
    
    R apply(T t);
    
    // default methods
    
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
```

* We also have one static method called `identity` which takes an _objects_ and returns that same object.
