# Filter Operation

## Filtering a Stream

Let us focus on the `filter` operation. What is it?

- An Intermediary Operation (So it returns a `Stream<T>`)
- Takes a stream defined on a source of data, and it filters out part of that data given a `Predicate`.

Example:

```java
List<Person> list = ...;
Stream<Person> stream = list.stream();
Stream<Person> filtered =
    stream.filter(person -> person.getAge() > 20);
```

So in the example above we use a `Predicate` which checks whether the `person.getAge()` is 
greater than 20 and if that is the case, then that `Person` is kept otherwise if not, that `Person`
is filtered out.

### How to filter a Stream?

1.Open a stream on a `Collection<T>`
```java
List<Person> list = ...;
Stream<Person> stream = list.stream(); // Open a stream on a List<Person>
```

2.Declare the `filter()` method on the stream created.
```java
Stream<Person> filtered =
    stream.filter(person -> person.getAge() > 20); // You create a filtered Stream<T> by calling the filter()
```

### Takes a Predicate as a parameter

```java
Predicate<Person> p = person -> person.getAge() > 20;
```
In this case the lambda expression returns true or false based on the expression that
a `person's` age is greater than 20. Predicates return boolean result thus `true`:`false` 

* The call to the filter method is _lazy_.
* All the methods of `Stream` that return another `Stream`(Intermediary Operations) are _lazy_.
