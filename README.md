# MultiThreading
by default, programming languages are sequential means they execute 
the commands one by one.

I  a single threaded application these operations are executed 
one after the other.

Time consuming operations may freeze the entire application.

multithreading is the ability of the CPU to execute multiple Process
or threads concurrently.

Both threads and processes are independent sequence of execution.


Process:
A process is instance of program execution.

for example when you open a software (Paint, Excel , WebBrowser etc) - these are distinct process

The Operating system assigns distinct registers, stack memory, code segment, data segment and heap memory to every single process.

In java we can create process with the ProcessBuilder class.


tasklist (command in cmd)

Thread is essentially light weight process.


A thread in a process shares the memory and resources and this is why programmers have to deal with
concurrent programming.


Creating new threads require Fewer resources than creating new process.


Time Slicing algorithm.

synchroniztion is not that straight-forward.

not easy to design and test Multithreaded app.

context switching  ... --- expensive (overhead)

Optimal no of threads.

running time v/s # of Threads



Thread Lifecycle

    1. New State.
    2. 



Thread Communication
wait()
notify()



























