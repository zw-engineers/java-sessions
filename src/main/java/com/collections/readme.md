# Collections

## Introduction
* A Collection is like a little container that can have 0, 1 or many elements in.
    * _But arrays already exist in Java right? Why not just use an Array?_

## Problems with Arrays

### Print
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
```text
    [Product{name='Wooden Door', weight=35}, Product{name='Floor Panel', weight=25}]
```

### Add

* Suppose we wanted to add another value in the array as below:

```java
    public class TheArrayProblem {
    
        public static void main(String[] args) {
            Product door = new Product("Wooden Door", 35);
            Product floorPanel = new Product("Floor Panel", 25);
    
            // Create
            Product[] products = {door, floorPanel};
    
            // Add
            products[2] = new Product("Window Panel", 10);
        }
    }
```
* This will throw an exception:

```java
    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
```
* The reason is that Arrays do not resize.
* So if you want to add another element in the array, you need to go and write your own
implementation that edits the array and performs the appropriate resizing operation.

```java
    public class TheArrayProblem {
    
        public static Product[] add(Product product, Product[] array) {
            int length = array.length;
            Product[] newArray = Arrays.copyOf(array, length + 1);
            newArray[length] = product;
            return newArray;
        }
    }
```

* To use this we would need to change our code to look like :point_down:

```java
    public class TheArrayProblem {
    
        public static void main(String[] args) {
            Product door = new Product("Wooden Door", 35);
            Product floorPanel = new Product("Floor Panel", 25);
            Product window = new Product("Window", 10);
        
            // Create
            Product[] products = {door, floorPanel};
        
            // Add
            products = add(window, products);
            System.out.println(Arrays.toString(products));
        }
    }
```

* Now we've had to do so many operations in order to just add an element into an array.
* Suppose we wanted to also remove an element from the array. Unfortunately you would also
need to have another implementation to do this as well.
* Arrays are very low level constructs and they do not give us many features.
* Collections give us these features.

### Duplicates

* Another issue is that Arrays are not able to enforce constraints on our code.
* Suppose we did not want to have duplicates in our array, this would be very hard to achieve with arrays
as they allow you to add more of the same element in your array.

```java
    public class TheArrayProblem {
    
        public static void main(String[] args) {
            Product door = new Product("Wooden Door", 35);
            Product floorPanel = new Product("Floor Panel", 25);
            Product window = new Product("Window", 10);
        
            // Create
            Product[] products = {door, floorPanel};
        
            // Add
            products = add(window, products);
            System.out.println(Arrays.toString(products));
            
            // Duplicate
            products = add(window, products);
            // returns two window products...
            System.out.println(Arrays.toString(products));
        }
    }
```
* Also if we wanted to have uniqueness in our array, this would also be a challenge as we do not have that feature
by default. We would need to implement that.