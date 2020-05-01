CAB302 Software Development
===========================

# Week 9 - Threads

The classes for this week are about threads, `Thread` objects, inheriting from the `Thread` class, and implementing the 
`Runnable` interface. Mostly, we are interested in you playing with the code from the lecture (available on Blackboard).

## Exercise - Some Basic ThreadWork

In this exercise, we are going to take some of the code from the lectures and run it. Then we are going to get some 
very necessary, if slightly trivial, practice in implementing some of the examples using the interface `Runnable` 
instead of inheriting from `Thread` and vice versa.

Some tasks:

  - Download the lecture code, compile and run all the demos shown in the class.
  - Change `Packer.java` so that it implements `Runnable` rather than extends `Thread`. Make the necessary changes to 
  `ThreadedFillDemo` so that the program creates a `Thread` from `Packer`.
  - Choose another threaded example which uses `Runnable` and convert it to work by subclassing `Thread` (You can skip 
  this if you get it by now. More important to take a subclassed version and convert it to one which runs on the 
  interface model).
  - Change some of the data and times in `ScheduleTasks` to see the effect of the `Timer` class.
  - Alter the pause times on the messages in `JumbledMessage` to see the effect, in both the unsynchronized and 
  synchronized versions.


## Exercise - Dining Philosophers

Run the code provided in the lecture for the Dining Philosopher's problem, and see what responses appear. Try it 
three or four times so that you get a feel for the program, and some difficulties which emerge. 

Now try to fix this source code. The fix will have to take place in `Philosopher.java`. There are different ways to 
fix this:

  - Flip a coin - Use a random number generator (https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html) to   
return a random Boolean that decides whether to pick up the first fork.
  - Look before you leap - Check if the second fork is available. If not put down the first fork. Does this lead to any other possible 
  problems? 
  
If you are interested in pursuing this problem further, keep track of the number of times that each philosopher gets
 to eat. Is the sharing of the food fair i.e. do they each get to eat about the same number of times?
