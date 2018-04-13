# Optional

* In a _Wrapper_ type it is expected that a value exists.
* In an _Optional_ type it is expected that a value might not exist.

* Suppose we wanted to check if the _Optional_ does contain a value. We could do the following:

```java
    Optional<String> opt = ... ; if (opt.isPresent()) {
        String s = opt.get() ;
    } else {
        ... 
    }
```

* Here we can use the `isPresent()` method which returns true if a value exists in the _Optional_.
* The method `get()` returns the value held by this optional.
* The method `orElse()` encapsulates both calls
```java
    String s = opt.orElse(""); // Here the orElse() defines a default value.
```

* Should we wish to throw an exception, we can also use the the `orElseThrow()` method on an _Optional_.
```java
    String s = opt.orElseThrow(MyException::new); // lazy construct.
```