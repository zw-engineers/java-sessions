# Strings, IO and other bits and pieces

## String Joiner

* Concatenation of String is not that simple.

### Using the `+`
```java
    public String usePlusSymbol(String str1, String str2) {
        return str1 + " " + str2;
    }
``` 
* Some people will tell you:
    * It's not that efficient and should not be used!
* Why is it not efficient?
    * because of multiple creations/deletions of intermediary strings.

### Using the _StringBuffer_

```java
    public String useStringBuffer(String str1, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello");
        stringBuffer.append(" ").append("World");
        return stringBuffer.toString();
    }
```

* Better but _StringBuffer_ is synchronized.

### Using the _StringBuilder_

```java
// The JDK 5 way
    public String useStringBuilder(String str1, String str2) {
        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append(" ").append("World");
        return builder.toString();
    }
```
* But this is the way the JDK 7 compiles String concatenations. 

### Using the _String Joiner_
* Much simpler in JDK 8 with the _String Joiner_.
* A String Joiner is built with a separator.
```java
    public String useStringJoiner(String str1, String str2) {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        joiner.add(str1).add(str2);
        return joiner.toString();
    }
```

* We can also use the `StringJoiner` directly from the String object.

```java
    public String useStringJoiner(String[] strings) {
        return String.join(", ", strings);
    }
```

---

## Reading Text Files

* A `lines()` method has been added on the `BufferedReader` class.

```java
        // Java 7 : try with resources
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(new File("src/main/resources/example.txt"))
                     )
        ) {
            Stream<String> stream = reader.lines();
            stream.filter(line -> line.contains("ERROR"))
                    .findFirst().ifPresent(System.out::println);
        } catch (IOException e) {
            e.getMessage();
        }
```

* There is also a new `Path` interface in Java 7 that we could also use to read text files.

```java

```