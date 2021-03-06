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
* Arrays do not help us when it comes to scenarios as this were one would require uniqueness or non duplicate
values.
* This is where _Collections_ come in as they help us solve all of these problems.

---

## Why You Should Use Collections

* Implementing data structures can be hard.
* Collections implement data structures so we do not have to worry about the hard bit
which is implemeneting data structures.
* The reason we call the Java Collections Framework a _framework_ is because it offers
are very diverse, in and of themselves. 
* Some offer _Ordering_, _Pairs_ and _Uniqueness_.
    * Iteration Order: Lists
    * Uniqueness: Sets
    * Modification Order: Queues & Deques
    * Collection of Pairs: Maps

---

## Collection of Collections

* All the collection interfaces within the Java API extend this common parent interface called Java.util Collection, 
and on the collection face itself there is a bunch of common behavior, common methods which they will implement.

<p align="center">
    <img src="https://user-images.githubusercontent.com/29547780/40834103-d1f2ca12-6587-11e8-9bb3-92a55367919f.png">
</p>

### List
* The first type of collection we will come across are _Lists_:
    * The most commonly used collections.
    * They have an order, indexing.
    
### Set and SortedSet
* The second type of collection are _Sets_ and their closely related big sister, the _Sorted Set_
    * A Set is a collection that has distinct elements.
    * So if you have an element, it's only in that _Set_ once.
    * Sorted sets are sets which also have a sort order.
    * They combine the kind of ordering aspect that lists have with the uniqueness of _Sets_. But they are definitely a
    _Set_ and not a _List_.

### Queue and Deque
* _Deque_ is a _double ended Queue_.
* Queues are thing with an order. Not just indexing order, but the order in which elements are added to or removed from them.
* A Queue is a _First In First Out_ meaning that the first element you put into the Queue, will
also be the first element to be removed from Queue.
* Double Ended Queues support both _FIFO_ and _LIFO_ behaviour.

### Map and SortedMap
* _Map_ and _SortedMap_ are interfaces that define pairs. They have keys and they have values.
* The keys are unique and the values are associated to a key.
* A _Sorted Map_ will have the same characteristics of _values_ and _pairs_ but they will
also have the sort order capability to allow sorted within the _Sorted Map_.

### Interfaces vs Implementations

<p align="center">
    <img src="https://user-images.githubusercontent.com/29547780/40834523-fb89a764-6588-11e8-9759-94a5a7d234d4.png">
</p>

* An interface can be backed by multiple implementations.
* Interfaces are usually used as the variable type. 
* Interfaces often have a popular implementation (_e.g. List -> ArrayList() or Map -> HashMap()_).
* Interfaces have more of the functional characteristics where as the implementation will have more of the performance characteristics.
* Each interface defines behaviour and each implementation defined performance characteristics.

### Picking the right Collection

* If you're an application developer, how would you go about picking the right collection?

<p align="center">
    <img src="https://user-images.githubusercontent.com/29547780/40834789-adf840c2-6589-11e8-9334-a18dbd746755.png">
</p>

* Using the flowchart above we could ask ourselves the following:
    * Are the elements keyed?
    * If not we would that ask ourselves if the elements are unique.
    * If they are then we would know that we need to use some kind of Set.
    * The next question would be, the ordering in the Set. If ordering is important we would use the _Sorted Set_ otherwise we would just use the _Set_.
    * If elements are not unique we would either need to use a _List_, _Queue_ or _Deque_. 
    * If the order is _Last in, First out_, then we would use a _Deque_ otherwise we would use a _List_.
    * If the order is _First in, First out_, then we would use a _Queue_ or _Deque_ (since a Deque is double ended :smirk: ).

---

## Collection

* The Collection interface extends the _Iterable_ interface.
* Iterable defines something which can be iterated over.
* An _Iterator_ is like a cursor into that Collection. It lets go through the collection element by element and loop 
over the elements inside.

### Outline of Collection interface

`size()` -> Get the number of elements in the Collection
`isEmpty()` -> True if size() == 0, false otherwise
`add(element)` -> Add the element at the beginning of this collection
`addAll(collection)` -> Add all the elements of the argument collection to this collection
`remove(element)` -> Remove the element from this collection
`removeAll(collection)` -> Remove all the elements of the argument collection to this collection
`retainAll(collection)` -> Remove all the elements of this collection not in the argument collection
`contains(element)` -> True if the element is in this collection, false otherwise
`containsAll(collection)` -> True if all the elements of the argument collection are in this collection
`clear()` -> Remove all elements from this collection

`Collection<Product> products;` -> Every element in the Collection will be of type _Product_.

* If we wanted to add elements into our _Products_ Collection we can add elements as below:

```java
    public class CollectionConcepts {
        public static void main(String[] args) {
            Product door = new Product("Wooden Door", 35);
            Product floorPanel = new Product("Floor Panel", 25);
            Product window = new Product("Glass Window", 10);
    
            Collection<Product> products = new ArrayList<>();
            
            // Add each product into the Products Collection
            products.add(door);
            products.add(floorPanel);
            products.add(window);
    
            System.out.println(products);
    
        }
    }
```
* which would return:

```java
    [Product{name='Wooden Door', weight=35}, Product{name='Floor Panel', weight=25}, Product{name='Glass Window', weight=10}]
```

* Suppose we didn't want to print the elements out on one line but we wanted to print each product in turn. We could 
achieve this by using the iterator.

```java
    public class CollectionConcepts {
        public static void main(String[] args) {
            Product door = new Product("Wooden Door", 35);
            Product floorPanel = new Product("Floor Panel", 25);
            Product window = new Product("Glass Window", 10);
    
            Collection<Product> products = new ArrayList<>();
    
            // Add each product into the Products Collection
            products.add(door);
            products.add(floorPanel);
            products.add(window);
    
            // Build our iterator
            final Iterator<Product> productIterator = products.iterator();
            // hasNext() -> Does it have another element? Returns true is there is an element otherwise false terminating the loop.
            while (productIterator.hasNext()) {
                // Give me the next element and move yourself forward to the next element in the iteration order.
                Product product = productIterator.next();
                System.out.println(product);
            }
    
        }
    }
```

* which would return:

```java
    Product{name='Wooden Door', weight=35}
    Product{name='Floor Panel', weight=25}
    Product{name='Glass Window', weight=10}
```

* Iterators are not the common style that people would use when they want to iterate over elements.
* In Java 5 the _for each_ loop was introduced which allowed us to iterate over elements and perform functions
on each element.
* So instead of building the iterator and using the _while_ loop we would just do the following:

```java
    public class CollectionConcepts {
        public static void main(String[] args) {
            Product door = new Product("Wooden Door", 35);
            Product floorPanel = new Product("Floor Panel", 25);
            Product window = new Product("Glass Window", 10);
    
            Collection<Product> products = new ArrayList<>();
    
            // Add each product into the Products Collection
            products.add(door);
            products.add(floorPanel);
            products.add(window);
            
            for (Product product: products) {
                System.out.println(product);
            }
        }
    }
```

* which would return:

```java
    Product{name='Wooden Door', weight=35}
    Product{name='Floor Panel', weight=25}
    Product{name='Glass Window', weight=10}
```

* So why care about iterators themselves since for loops are much cleaner and easier to implement?
* Suppose we have a new requirement to print out values that have a weight greater than or equal to 20.
* Using the iterator way we would implement:

```java
    public class CollectionConcepts {
        public static void main(String[] args) {
            Product door = new Product("Wooden Door", 35);
            Product floorPanel = new Product("Floor Panel", 25);
            Product window = new Product("Glass Window", 10);
    
            Collection<Product> products = new ArrayList<>();
    
            // Add each product into the Products Collection
            products.add(door);
            products.add(floorPanel);
            products.add(window);
    
            // Build our iterator
            final Iterator<Product> productIterator = products.iterator();
            // hasNext() -> Does it have another element? Returns true is there is an element otherwise false terminating the loop.
            while (productIterator.hasNext()) {
                // Give me the next element and move yourself forward to the next element in the iteration order.
                Product product = productIterator.next();
                if (product.getWeight() >= 20) {
                    System.out.println(product);
                }
            }
    
        }
    }
```

* which would return:

```java
    Product{name='Wooden Door', weight=35}
    Product{name='Floor Panel', weight=25}
```

* But what we can do with an iterator and not a for each loop is to remove elements.

```java
    public class CollectionConcepts {
        public static void main(String[] args) {
            Product door = new Product("Wooden Door", 35);
            Product floorPanel = new Product("Floor Panel", 25);
            Product window = new Product("Glass Window", 10);
    
            Collection<Product> products = new ArrayList<>();
    
            // Add each product into the Products Collection
            products.add(door);
            products.add(floorPanel);
            products.add(window);
    
            // Build our iterator
            final Iterator<Product> productIterator = products.iterator();
            // hasNext() -> Does it have another element? Returns true is there is an element otherwise false terminating the loop.
            while (productIterator.hasNext()) {
                // Give me the next element and move yourself forward to the next element in the iteration order.
                Product product = productIterator.next();
                if (product.getWeight() >= 20) {
                    System.out.println(product);
                } else {
                    productIterator.remove(); // Remove element
                }
            }
    
            System.out.println(products);
    
        }
    }
```

* which would return :

```java
    Product{name='Wooden Door', weight=35}
    Product{name='Floor Panel', weight=25}
    [Product{name='Wooden Door', weight=35}, Product{name='Floor Panel', weight=25}]
```

* Suppose we tried the same thing on a _for each_ loop rather than an iterator:

```java
    public class CollectionConcepts {
        public static void main(String[] args) {
            Product door = new Product("Wooden Door", 35);
            Product floorPanel = new Product("Floor Panel", 25);
            Product window = new Product("Glass Window", 10);
    
            Collection<Product> products = new ArrayList<>();
    
            // Add each product into the Products Collection
            products.add(door);
            products.add(floorPanel);
            products.add(window);
    
            for (Product product: products) {
                if (product.getWeight() >= 20) {
                    System.out.println(product);
                } else {
                    products.remove(product); // Remove element
                }
            }
    
        }
    }
```

* Actually this will throw an exception:

```text
    Exception in thread "main" java.util.ConcurrentModificationException
        at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
        at java.util.ArrayList$Itr.next(ArrayList.java:859)
        at com.collections.CollectionConcepts.main(CollectionConcepts.java:20)
```

* The reason is that we are iterating over our Collection and modifying it at the same time.
* If you're iterating over a _for loop_, *DO NOT* modify the Collection.
* If you want to remove an element, use an iterator.