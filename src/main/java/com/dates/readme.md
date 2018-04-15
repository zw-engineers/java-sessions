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