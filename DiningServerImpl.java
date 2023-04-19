/**
 * DiningServer.java
 *
 * This class contains the methods called by the philosophers.
 *
 */

 import java.util.concurrent.locks.Lock;
 import java.util.concurrent.locks.Condition;
 import java.util.concurrent.locks.ReentrantLock;
 
 public class DiningServerImpl  implements DiningServer
 {
	 // Creat a lock object that can be acquired more than once without deadlocking
	 public Lock lock = new ReentrantLock();
 
	 /**
	  * Philosopher requests the lock by calling lock.lock(). 
	  * This will block the philosopher's thread if another thread already holds the lock.
	  */
	 @Override
	 public void takeForks(int philNumber) {
		 // the fork (either left or right) will lock until it is released
		 try {
			 lock.lock();
		 } catch (Exception e) {
			 e.printStackTrace(System.out);
		 }
	 }
 
	 @Override
	 public void returnForks(int philNumber) {
		 // releases the fork the philosopher is holding
		 lock.unlock();
	 }
 }