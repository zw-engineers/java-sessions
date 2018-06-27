# List

## What is a List?

* Lists are a collection with an iteration order.
* Each element has an _index_.
    * An _index_ is an _int_ representing its position in the list.
* We can modify lists using indicies.

## Key Features

```text
void add(int index, E e);
E get(int index);
E remove(int index);
E set(int index, E element);
boolean addAll(int index, Collection<? extends E> c);
```

`void add(int index, E e);`
* Add the new element `E` and at that `index` and shuffle everything
after it, if there is anything along by one.

`E get(int index);`
* Move to that `index` and extract that `element`.

`E remove(int index);`
* Move to that `index` and remove that `element` and shuffle everything
after it, if any, down by one.

`E set(int index, E element);`
* Replaces an `element` at a given `index`.

`int indexOf(Object o)`
* We can also lookup values in a list.
* This will lookup an object's position in the list.
* If the object does not exist in the list then it'll return -1.

`int lastIndexOf(Object o)`
* Suppose there are multiple values of the same value you are 
looking for in an list (_since list don't enforce unique elements_),
we can use the `lastIndexOf(Object o)` method to return the first 
index of the value we are looking for.