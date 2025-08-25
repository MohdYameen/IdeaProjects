package com.examples;

/*
Collections : <<>INTERFACE> in java.util, introduced in Java 1.2
    Iterable (added later in 1.5) : parent interface of all collections, all collections with common method names
            used to traverse the collection. Iterator was present in all collections, added Iterable interface in java1.5
                    method()    : 1.5, hasNext(), next(), .remove()
                    forEach()   : 1.8, arrayList.forEach((Integer i) -> sout(i));

Collections :
        utility class, all methods in this class are static methods to operate on Collection like
        sorting, searching, reverse, copy, min, max

Queue : FIFO DS  <<INTERFACE>>
    add()       : add new element, true if added, Exception if insertion fails (NPE)
    remove()    : retrieves and removes the head dof the queue, Exception if empty
    offer()     : insert, true if success, false if failed
    poll()      : retrieves and removes the head dof the queue, return null if empty
    element()   : value at head, exception if empty, does not remove
    peek()      : value present at head, null if empty. Does not remove it

PriorityQueue : <<Implemented Class>>, min heap and max heap imp using priority queue in java
         by default : min heap implementation, natural order
         new PriorityQueue((Integer a, Integer b) -> b-a); to change from default to max heap
         PriorityBlockingQueue : Thread safe version

Comparable : (java.lang)Both helps in sorting collection of objects
        obj1.carName.compareTo(obj2.carName)
        sorting can be done for single field type
        better to use lambda expression

Comparator : (java.util) <<FUNCTIONAL INTERFACE>>, many options
            compare(T o1, T o2)  >> swap only if method return 1, o1 > o2 return 1
                use merge sort internally, swap only if val1-val2 is greater than 0. for descedning order (val2-val1)
                better to use lambda expression or by implementing Comparator<Car> class


Dequeue<<Interface>> :
        Double ended queue, add and remove from both sides
        collection method + addFirst(), removeFirst(), offerFirst(), offerLast(), getFirst()
        can be used to implement Stack(addFirst and removeFirst) push and pop.
        ArrayDequeue implementing class
            : ConcurrentLinkedDequeue : thread safe imp of array dequeue

List <<Interface>> : imp. ArrayList, Vector and LinkedList
        unlike queue, u can access any element(uses array internally)
        methods:  add(index, element), addAll(index, Collection c), indexOf(Object o), lastIndexOf(Object o)
        Special Iterator called ListIterator
        ArrayList:
        LinkedList:
        Vector: thread safe, same are arraylist, put lock
            Stack : child of Vector, thread safe as it extends threadsafe class vector.

Map <<Interface>> : not child collection bcz in map we've key value mapping <<parent of all key value data structure, other than hashtable(legacy).
        a whole lot of new methods, size(), isEmpty(), containsKey(), containsValue(), get(), put(key, value)

HashMap : , default capacity:16(0-15)
    Array of Nodes/Bucket(4 components : hash, key, val, next)
    EntrySet is used to iterate hashmap with method hmap.entrySet()
       // similarly we have .keySet(), .values()
    ConcurrentHashMap : thread safe version

    load factor : 0.75f default, percentage of buckets to be filled before increasing size of hashmap
    Treefy : threashold is 8, convert it into red black tree, if hashmap size is 64, else rehash
    Entry<K, V> interface : sub interface of Map interface
    re-hashing :
    performance :
    hashcode and equal : 2 contracts
            if o1 and o2 are same, their hash should be same
            if hash is same for 2 objects, does not always mean objects are same

    How operations are O(1) in hashmap? worst is O(n)
        //If hashcode return same hash for all/many keys,
        Load factor help us with it, making O(1) comp for operations. If will do rehash once LF*size(0.75 * 16 =12), it will rehash
        After reaching treefy threshold, it gets converted into red black tree

LinkedHashMap : maintains order(2 types) insertion order and access order(LRU at last of map, to do it set accessOrder to true)
            uses DoubleLinkedList, it contains before and after component in every Node
            extends, HashMap and implements Map as well, all values on HashMap plus 2 more before and after.
            Not threadsafe, not thread safe version available
            Collections.sychronizedMap(linkedHashMap)


TreeMap : maintain sort this will do 


 */

import java.util.HashMap;

public class MyCollections {

    public static void main(String[] args) {

//        HashMap
    }
}
