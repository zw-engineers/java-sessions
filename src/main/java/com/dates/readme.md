# Date and Time API

* The old API package is in the `java.util.Date` and `java.sql.Date`.
* This is a new Java 8 API in `java.time`.
* There is interoperation with the legacy API.

## Instant

* An _Instant_ is a point on the timeline.
* An _Instant_ is immutable.
* How can we use an _Instant_?
```java
    Instant start = Instant.now();
    
    // Some long computations
    
    Instant end = Instant.now();
```

## Duration

* The amount of time between two Instants

## LocalDate

* This is just a Date with a _Date_ precision and not a time/nanosecond precision.
* How can we create a Date?
```java
    LocalDate date = LocalDate.now();

    LocalDate birthDate = LocalDate.of(1564, Month.APRIL, 23);
```

## Period

* The amount of time between two _LocalDate_.
* It has the same concept as _Duration_ with the same kind of methods.
* So how can we use it?
```java
    Period p = birthDate.until(date);
```

## DateAdjuster

* Useful to add or subtract an amount of time to an _Instant_ or a _LocalDate_.
* Uses the method _with()_
```java
    LocalDate now = LocalDate.now();
    LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
```

## LocalTime
* A LocalTime is a time of the day
* E.g. _10:20_
```java
    LocalTime time = LocalTime.of(10, 20); // 10:20 ->  10 Hours and 20 Minutes
```
* Includes a set of methods to manipulate the time:
```java
    LocalTime bedTime = LocalTime.of(23, 0);
    LocalTime wakeUpTime = bedTime.plusHours(8); // 7:00
```