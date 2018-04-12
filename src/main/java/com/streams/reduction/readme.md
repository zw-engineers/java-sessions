# Reduction Operation

* There are two kinds of reduction in the `Stream API`.
    * 1st: aggregation = _min, max, sum, etc..._

Suppose we wanted to get a sum of all the numbers within a list of _Integers_. We could use 
the `reduce()` method to resolve this as below: 

```java
    List<Integer> numbersList = Arrays.asList(10, 12, 7, 9, 30, 100);
    
    return numbersList.stream()
                    .reduce(0, (number, nextNumber) -> number + nextNumber );
```

* _1st argument_ - identity element of the reduction operation.
* _2nd argument_ - reduction operation, of type BinaryOperator<T>. In our case `T` is the type `Integer`.

* Binary Operator is a special case of a BiFuntion which is below:

```java
    @FunctionalInterface
    public interface BiFunction<T, U, R> {
        
        R apply(T t, U u);
        
        // plus default methods
        
    }
```
* A _BiFunction_ takes two objects of type `T` and `U` and returns an object of type `R`.


```java
    @FunctionalInterface
    public interface BinaryOperator<T> extends BiFunction<T, T, T> {
        
    T apply(T t1, T t2);
    
    // plus static methods
    
    }
```
* The _BinaryOperator_ is just an extension of the _BiFunction_ where all those three types
are all the same.
* So _BinaryOperator_ takes a two types of the same type and returns the same type in this case.
* So e.g. `(int a, int b) -> a + b` will return `c` of type integer.

## Aggregation: Corner Cases

* The _BiFunction_ takes two arguments so....
    * What happens if the _Stream_ is empty?
        * The reduction of an empty stream is the identity element.
    * What happens if the _Stream_ has only one element?
        * If the _Stream_ has only one element, then the reduction is that element.