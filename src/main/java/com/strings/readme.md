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