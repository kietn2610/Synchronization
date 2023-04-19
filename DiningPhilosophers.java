/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */


public class DiningPhilosophers
{  
   public static void main(String args[])
   {
      DiningServerImpl leftFork = null;
      DiningServerImpl rightFork = null;

      // create 5 philosophers and forks for the problem
      Philosopher[] philosophers = new Philosopher[5];
      DiningServerImpl[] forks = new DiningServerImpl[philosophers.length];
      
      forks[0] = new DiningServerImpl();
      forks[1] = new DiningServerImpl();
      forks[2] = new DiningServerImpl();
      forks[3] = new DiningServerImpl();
      forks[4] = new DiningServerImpl();

     // assigning forks to philosophers based on their seating.
     leftFork = forks[0];
     rightFork = forks[4];
     philosophers[0] = new Philosopher(0, leftFork, rightFork);

     leftFork = forks[1];
     rightFork = forks[0];
     philosophers[1] = new Philosopher(1, leftFork, rightFork);

     leftFork = forks[2];
     rightFork = forks[1];
     philosophers[2] = new Philosopher(2, leftFork, rightFork);

     leftFork = forks[3];
     rightFork = forks[2];
     philosophers[3] = new Philosopher(3, leftFork, rightFork);

     leftFork = forks[4];
     rightFork = forks[3];
     philosophers[4] = new Philosopher(4, rightFork, leftFork);

     // creating threads and running each of them
     for (int i = 0; i < 5; i++){
        Thread philosopher = new Thread(philosophers[i]);
        philosopher.start();
     }
   }
}