package com.examples;


/*  THEORY
*Process**: Instance of prgram that is getting executed, (cmd Java Test) JVM starts the new process. It has its own memory. OS allocates multiple resources to process.

**Thread**: lightweight process,  smallest sequence of instructions are executed by CPU independently.

In Java, when a process is started, it starts with 1 thread, main thread, from there we can create multiple threads.

java -Xms256m -Xmx2g Test


**Thread Creation** :

1. Runnable interface : functional interface, with method named "run". Normal class, not just thread.

create class that imp Runnable interface with run method overriden.
create an object of this class, create thread with this runnable object as argument.
thread.start(); -> this method will invoke run method
//preferred normally

used  to imp multiple classes, if our clas is using inheritence,

2. Thread class : class created by ext Thread class, this class now becomes thread class.
create obj of this class and execute obj.start() to invoke run method.
If run method is not overriden in this class, it will call default run method which will do nothing and return.


**Lifecycle of thread:**

New : Thread created but not started, just an object in memory.
Runnable/Running : ready to run or waiting for CPU.
Blocked : thread want to acquire a lock on resource which is locked by other thread, it has to wait.
Releases all Monitor locks

Waiting : when we call wait() method, release monitor lock
notify() method to go back to runnable state

Timed Waiting: waits for specific period of time and comes back to runnable interface, ex sleep(), it do not release monitor lock

Terminated: completed life, can not be started back again.

**Monitor lock:**
Help to make sure, only one thread goes to particular section of code.
ex : Create an object, create 3 thread, all three thread work on same object
* call three diff methods, with synchronized method, syn section and without it
* call all thread.start();
*
*
*
*



 */


public class MyThread {
}
