package com.examples;


/*  THEORY
Process :
    Instance of program that is getting executed, (cmd Java Test) JVM starts the new process.
    It has its own memory.
    OS allocates multiple resources to process.

Thread :
    lightweight process,
    smallest sequence of instructions are executed by CPU independently.

In Java, when a process is started, it starts with 1 thread, main thread, from there we can create multiple threads.

java -Xms256m -Xmx2g Test

**Thread Creation** :

    1. Runnable interface : functional interface, with method named "run". Normal class, not just thread.

    create class that imp Runnable interface with run method overridden.
    create an object of this class, create thread with this runnable object as argument.
    thread.start(); -> this method will invoke run method
    preferred normally
    used  to imp multiple classes, if our clas is using inheritance,

    2. Thread class : class created by ext Thread class, this class now becomes thread class.
    create obj of this class and execute obj.start() to invoke run method.
    If run method is not overridden in this class, it will call default run method which will do nothing and return.


**Lifecycle of thread:**

New : Thread created but not started, just an object in memory.
Runnable/Running : ready to run or waiting for CPU.
Blocked : thread want to acquire a lock on resource which is locked by other thread, it has to wait.
Releases all Monitor locks

Waiting : when we call wait() method, release monitor lock
notify() method to go back to runnable state

Timed Waiting: waits for specific period of time and comes back to runnable interface, ex sleep(), it do not release monitor lock

Terminated: completed life, can not be started back again.

**Monitor lock:** (only on object, works when only one obj is used)
Help to make sure, only one thread goes to particular section of code.
ex : Create an object, create 3 thread, all three thread work on same object
* call three diff methods, with synchronized method, syn section and without it
* call all thread.start();
* only if shared object not with different resources/object
*
* Producer-Consumer Problem:
* Shared resource class with Queue and buffer size
* sync produce method produce
*
* stop, resume and suspended? deprecated
* stop() : it dies abruptly, no lock release, no release clean up
* suspended() : put thread on hold temporarily, no lock release  : deadlock situation
* resume(): worked with suspended, has to deprecate as of no use without suspend
*
*
* Thread Joining :
*
* JOIN() : current thread will be blocked and wait for specific thread to finish
* ex. main thread will wait for thread to finish its work, will not complete itself.
*
* Thread Priority
* thread.setPriority(1-10); 1 is lowest priority and 10 is highest, suggestion no guarantee to order.
* cannot rely on thread priority, when new thread is created, it inherit parent's priority.
*
* Deamon Thread :
* thread which is running is async mode. thread.setDeamon(true)
deamon thread is only alive only till user thread is alive, ex. garbage collector, autosave in IDE.


Locks and Semaphores: no syncronized block/method, only one thread should be able to access critical section
1. Reentrant lock : get lock object as input for critical method
2. ReadWrite : Shared lock for read, exclusive lock for write
3. StampedLock : read/write lock + optimistic(no lock acquired) read
4. Semaphores : Semaphore lock = new Semaphore(permits: 2), 2 threads can acquire the lock, more than one thread can access, ex. connection pool

Condition :
await() = wait()
signal() =  notify()
signalAll() = notifyAll()

Lock Free Mechanism : (not an alternative to lock based but can also be used for concurrency)
CAS(Compare and Swap) Operation, Low Level Operation, all CPU supports it. Involves 3 main params (Mem loc, exp value, new value)
AtomicInteger : single, all or nothing, thread safe
AtomicBoolean
AtomicLong
AtomicReference

Specific use cases :


Atomic : Thread Safety operations

Volatile :
    volatile fields used with var, that is being consumed by multiple thread, its updated value is visible to all theads
    read or write directly to memory(RAM) ignoring L1 and L2 cache.

ThreadPool :
    Collection of threads aka workers, which are available to perform submitted tasks. Once task is completed.
    Worker thread get back to thread pool and wait for new task.
    Thread can be reused.

Advantages:
    Thread creation time can be saved(stack, heap, memory, counter etc). Reuse threads
    Overhead of thread lifecycle management can be removed, Abstract away this management.
    Increased performance : More thread means more context switching.

#################################################################################################################################

ExecutorService<<INTERFACE>> :

ThreadPoolExecutor :
    helps to create customizable thread pool. (corepoolsize, maxpoolsize, keeplivetime, timeunit, BlockingQueue, ThreadFactory, RejectedExecutionHandler)

Executor states:
    Running(open to accept task and running) -> shutdown(not accept new task, continue existing one) -> terminated
                                        -> stop(forcefully stop everything) -> terminated

corepoolsize??? it depends upon various factors,
no. of cores to avoid context switching again and again.
JVM memory
type of tasks : io intensive task(need more threads) or cpu intensive task(need less thread)

Caller want to know status of thread? Future

CompletableFuture:

Future<<INTERFACE>>: return type of submit() : to know the status/state of thread
    represent the result of async task.
    5 methods :
        boolean cancel(),
        boolean isCancelled(),
        boolean isDone(),
        V get():wait if required, for the completion of task,
        V get(long timeout, TimeUnit unit) : same waiting only for specific time

Three overloaded methods for submit():
    submit(Runnable)
    submit(Runnable, T)
    submit(Callable<T>)

when we do futureObj.submit() : this submit might return something or void.
But we use future obj to know the status of thread.

Callable:
    functional interface exactly similar to Runnable, has one run() method.
    Runnable does not return anything. Callable return certain value.
    Both represent task that need to be executed


CompletableFuture : intro in java8, used in industry but not much use of chaining.
    help in async programming, child of Future
    5 methods:
        supplyAsync() : initiate an async operation, 'supplier' is executed asynchronously in a separated thread, uses ForkJoinPool by default
        thenApply()   : to chain previous complatablefuture with this method and gets executed by same thread, multiple thenApply(): not guarantee of order
        thenApplyAsync() : to chain previous complatablefuture with this method and gets executed by new/different thread
        thenCompose() : multiple dependent operation then use this, to follow ordering,
        thenComposeAsync() : same plus new thread
        thenAccept() and thenAcceptAsync() : end of chain of async operation, does not return anything, consumer()
        thenCombine() and thenCombineAsync() : to combine the result of 2 CompletableFuture


Executor Utility :
    Executors : provide factory method to create
        newFixedThreadPool(5); min and max pool size is constant, to use when you exactly know the size that should be used
        newCachedThreadPool() : new thread dynamically, min is 0, max in max integer, queue size is 0(not even used), keepAlivetime=60sec, good for short lived task
        newSingleThreadExecutor(): min and max=1, queue can be huge, thread alive, when process is sequential, no consurrency
        newWorkStealingPool() : create ForkJoinPool Executor


ForkJoinPool: more parallelism, special thread pool introduced in java7
    designed for tassks that can be broken into smaller subtasks and executed in parallel
    to create Executors.newWorkStealingPool() or // this will create no. of threads as no. of available processors or you can give no . of thread you want to create
    ex. big task divided in small tasks(forking) and then merge the result(join).


    submission queue : common queue to entire pool
    work stealing queue : each thread has its on work stealing queue, free thread can steal task from other thread's workstealing queue(from back not from front) if submission queue is empty.

    Q. How to divide task? and how to put task into work stealing queue?
    Task can be split into multiple small sub tasks. It should extend
        RecursiveTask or RecursiveAction


shutdown() :
    Initiate orderly shutdown of ExecutorService
    After calling shutdown, no new task submission
    Existing task will continue to process(do not impact existing tasks)

AwaitTermination :
    Optional functionality, used after shutdown method, main thread will wait before shutting down, block main thread for that much time
    return true or false

shutdownNow() :
    best effort attempt to stop/interrupt actively executing task
    return the list of tasks which are awaiting execution


ScheduledThreadPoolExecutor :
    help to schedule a task, ex first time delay, or interval, minthread = input, max=Max_INTEGER,
    Methods:
        schedule(Runnable) : schedule this task after specific delay
        schedule(Callable) : same work, but returns a value
        scheduleAtFixedRate() : for repeated execution with fixed rate, use cancel() method to stop this repeated task
        scheduleWithFixedRate() : for repeated execution with fixed delay


ThreadLocal : // not very useful
    class to provide access to Thread-Local variable, each thread has Thread Local variable
    this variable hold value of particular thread
    1 obj of ThreadLocal class and each thread can use it to set and get its own thread-variable.
    automatic store in the thread its .set() method being called from, no need to specify which thread


Virtual Thread : JDK19
    for higher throughput not latency (how many request you can execute per second)
    if any virtual thread needs to run then only it gets connected with OS thread, if virtual thread is waiting, OS thread connection get removed.
    ex. two OS thread, now JVM can create many virtual threads.


Normal(Platform) Thread :
    t1.start() : JVM(ask OS to create) created one native(OS) thread, platform threads are managed by JVM, all thread are attached 1 to 1 with OS threads
                 System call, expensive task


CyclicBarrier :
    used to make threads wait for each other. When different threads process a part of the computation, all thread have completed the execution
    the result need to be combined in the parent thread.
    CyclicBarrier newCB = new CyclicBarrier(numberOfThreads);
    newCB.await(); // in all threads

CountDownLatch :
    used to make sure that a task waits for other threads before it starts
    eg. server where the main git status can only start when all required services have started.


 */


import java.util.*;
import java.util.concurrent.*;

public class MyThread {

    public static void main(String[] args) {

        // Consumer Producer Code
//        SharedResource sharedResource = new SharedResource(3);
//
//        Thread producerThread = new Thread(() -> {
//
//            try{
//                for(int i=0;i<=6;i++){
//                    sharedResource.produce(i);
//                }
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        });
//
//
//        Thread consumerThread = new Thread(() -> {
//
//            try{
//                for(int i=0;i<=6;i++){
//                    sharedResource.consume();
//                }
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        });
//
//        producerThread.start();
//        consumerThread.start();


        // Thread pool executor example
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,
//                4,
//                1,
//                TimeUnit.HOURS,
//                new ArrayBlockingQueue<>(10),
//                new CustomThreadFactory(),
//                new CustomRejectedHandler());
//
//        poolExecutor.allowCoreThreadTimeOut(true);
//
//        for(int i=0; i<10; i++){
//            int finalI = i;
//            poolExecutor.submit(() -> {
//                try{
//                    Thread.sleep(2000);
//                    System.out.println(finalI + " task executed by thread name : " + Thread.currentThread().getName());
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }
//
//        poolExecutor.shutdown();

        //Future example
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,
                1,
                1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // Not returning anything, thus using submit method with Runnable argument
        Future<?> futureObj = poolExecutor.submit(() -> {
            try{
                Thread.sleep(7000);
                System.out.println("This task will get executed by thread");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        try{
            Object runnableReturnObject = futureObj.get();    // this object will always return null
            System.out.println(runnableReturnObject == null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        poolExecutor.shutdown();



        // callable submit method to return integer 5
//        ThreadPoolExecutor poolExecutorC = new ThreadPoolExecutor(1,
//                1,
//                1,
//                TimeUnit.HOURS,
//                new ArrayBlockingQueue<>(10),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());
//        Future<?> futureObj2 = poolExecutorC.submit(() -> {
//            System.out.println("Tast2 with Callable return, Do something");
//            return 5;
//        });
//
//        System.out.println("is Done : "+ futureObj2.isDone());
//
//
//        try{
//            Object callableReturnObject = futureObj2.get();  // this will return whatever the object is
//            System.out.print("Object is null : ");
//            System.out.println(callableReturnObject == null);
//
//            System.out.println("printing object returned by futureObj.get() with callable : "+callableReturnObject);
//        } catch (Exception e) {
//
//        }
//
//
//        System.out.println("isDone : "+futureObj2.isDone());
//        System.out.println("isCancelled : "+futureObj2.isCancelled());
//        poolExecutorC.shutdown();


        //CompletableFuture
//        try{
//            ThreadPoolExecutor poolExecutorCF = new ThreadPoolExecutor(1,1,1,TimeUnit.MINUTES, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory());
//
//            // All methods get executed by single thread, first supplyAsync gets completed and then thenApply will be executed by same thread
//            // currently using chaining
//            CompletableFuture<String> completableFuture = CompletableFuture
//                    .supplyAsync(() -> "Task completed by completeable future", poolExecutorCF)
//                    .thenApply((String val) -> val+" coding");
//
//            System.out.println(completableFuture.get());
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        //Fork Join Pool
//        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
//        Future<Integer> futureObj = forkJoinPool.submit(new ComputeSumTask(0, 100));
//
//        try{
//            System.out.println(futureObj.get());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

    }

}

//class ComputeSumTask extends RecursiveTask<Integer> {
//
//    int start;
//    int end;
//
//    ComputeSumTask(int start, int end){
//        this.start=start;
//        this.end=end;
//    }
//
//    @Override
//    protected Integer compute() {
//
//        if(end-start <= 4){
//            int totalSum = 0;
//            for(int i=start;i<=end;i++){
//                totalSum+=i;
//            }
//            return totalSum;
//        } else {
//            int mid = (start+end)/2;
//
//            ComputeSumTask leftTask = new ComputeSumTask(start, mid);
//            ComputeSumTask rightTask = new ComputeSumTask(mid+1, end);
//
//            leftTask.fork();
//            rightTask.fork();
//
//            int leftResult = leftTask.join();
//            int rightResult = rightTask.join();
//
//            return leftResult + rightResult;
//        }
//    }
//}

//class CustomRejectedHandler implements RejectedExecutionHandler{
//
//    @Override
//    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//        System.out.println("Task denied : "+ r.toString());
//    }
//}
//
//class CustomThreadFactory implements ThreadFactory{
//
//    @Override
//    public Thread newThread(Runnable r) {
//
//        Thread th = new Thread(r);
//        th.setPriority(Thread.NORM_PRIORITY);
//        th.setDaemon(false);
//        return th;
//    }
//}
//
//class SharedResource{
//    private final Queue<Integer> sharedBuffer;
//    private final int bufferSize;
//
//    public SharedResource(int bufferSize){
//        sharedBuffer = new LinkedList<>();
//        this.bufferSize = bufferSize;
//    }
//
//
//    public synchronized void produce(int item) throws Exception{
//
//        while (sharedBuffer.size() == bufferSize){
//            System.out.println("Buffer is full, can not add more. Producer is waiting for consumer");
//            wait();
//        }
//        sharedBuffer.add(item);
//        System.out.println("Produced : "+item);
//        notify(); // notify consumer(thread that are waiting for this resource) that item is now available
//    }
//
//    public synchronized int consume() throws Exception{
//        while (sharedBuffer.isEmpty()){
//            System.out.println("Consumer is waiting for producer to produce");
//            wait(); // release lock
//        }
//        int item = sharedBuffer.poll();
//
//        System.out.println("Item consumed : "+ item);
//        notify(); // notify producer that space is now empty
//
//        return item;
//
//    }
//}
