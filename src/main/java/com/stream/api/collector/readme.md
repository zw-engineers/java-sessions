# Collectors

* This is another type of _reduction_ called a _mutable_ reduction.
* Instead of aggregating elements, this reduction puts them in a _container_.
* Suppose we had an `String[]` of names but we wanted to put those elements into a `List<String>`.
```java
    String[] names = names = new String[]{"Artemas", "Lebron", "Kobe", "Michael"};
    
    return Arrays.stream(names) // Here we create a Stream of the Arrays.
            .collect(Collectors.toList()); // Here we perform our reduction to put it into a List<String> container.
```