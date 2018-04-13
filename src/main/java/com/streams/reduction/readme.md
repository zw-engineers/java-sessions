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
* Suppose the reduction is the max
```java
    BinaryOperation<Integer> max = (i1, i2) ->
        i1 > i2 ? i1 : i2;
```
* The problem here is that the _max_ operation does not have an identity.
* Suppose we use the _max_ operation to find the maximum value in a `List<Integers>` where the list is empty.
```java
    List<Integer> ages = ... ;
    Stream<Integer> stream = ages.stream();
    ... max =
        stream.max(Comparator.naturalOrder());
```
* Here if it is an _int_ the default value would be 0. In the case of the code above, the _type_ is _Integer_
which is an object and the default value would be _null_. This would be messy and painful to maintain
as we would have to have code to constantly check if the value of the _Integer_ is not null.

* To resolve this would could pass in an _Optional_ of type _Integer_ as below:

```java
    List<Integer> ages = ...;
    Stream<Integer> stream = ages.stream();
    Optional<Integer> max = // Here we use the Optional of type Integer
            stream.max(Comparator.naturalOrder());
```
* Here, _Optional_ is an object that represents _There might not be a value_.
* In a _Wrapper_ type it is expected that there is _ALWAYS_ a value.
* In an _Optional_ type it is expected that there might not be a value.