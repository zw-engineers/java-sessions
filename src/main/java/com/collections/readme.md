# Collections

## Introduction
* A Collection is like a little container that can have 0, 1 or many elements in.
    * _But arrays already exist in Java right? Why not just use an Array?_

## Problems with Arrays

```java
    public class TheArrayProblem {
    
        public static void main(String[] args) {
            Product door = new Product("Wooden Door", 35);
            Product floorPanel = new Product("Floor Panel", 25);
    
            // Create
            Product[] products = {door, floorPanel};
    
            // Print
            System.out.println(products); // returns -> [Lcom.collections.Product;@{SOME-HASH-CODE-HERE}
    
            System.out.println(Arrays.toString(products)); // returns => [Product{name='Wooden Door', weight=35}, Product{name='Floor Panel', weight=25}]
        }
    }
```

* If we tried to print this method here we will get a result like:
`[Lcom.collections.Product;@6aa8ceb6`.
* This is not friendly and also not readabnle or useful.
Should we want to print out the array we would need to use the `Arrays.toString()` method
in order to get a more readable array.

```java
    System.out.println(Arrays.toString(products));
```
* Which would return:
```json
    [Product{name='Wooden Door', weight=35}, Product{name='Floor Panel', weight=25}]
```