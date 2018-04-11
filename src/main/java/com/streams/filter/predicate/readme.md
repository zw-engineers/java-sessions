# Predicate as a parameter

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
    
    default Predicate<T> and(Predicate<? super T> other) { ... }
    
    default Predicate<T> or(Predicate<? super T> other) { ... }
    
    default Predicate<T> negate() { ... }
}
```

* This has a method `test()` which takes an object as a parameter and returns a `boolean`.
* There are also other default methods in the Predicate interface. This will allow us to
chain on booleans.

```java
Predicate<Integer> p1 = i -> i > 20;
Predicate<Integer> p2 = i -> i < 30;
Predicate<Integer> p3 = i -> i == 0;

Predicate<Integer> p = p1.and(p2).or(p3); // (p1 AND p2) OR p3
Predicate<Integer> p = p3.or(p1).and(p2); // (p3 OR p1) AND p2
```

* So we can chain our Predicates if we wanted to but the priorities of chaining these is 
not handled by methods.