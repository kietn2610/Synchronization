import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Philosopher.java
 *
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 *
 */


public class Philosopher implements Runnable
{
    // we save the fork for the philosopher.
    private DiningServerImpl lFork;
    private DiningServerImpl rFork;
    private int philosopherNumber;
    //creating the philosopher with their respected left and right fork
    public Philosopher(int num, DiningServerImpl leftFork, DiningServerImpl rightFork){
        philosopherNumber = num;
        this.lFork = leftFork;
        this.rFork = rightFork;
    }

    @Override
    public void run() {
        try{
            while(true){
                //assigning correct fork number to each philosopher
                int lForkNum, rForkNum;
                if (philosopherNumber == 0) {
                    lForkNum = 0;
                    rForkNum = 4;
                } else if (philosopherNumber == 1) {
                    lForkNum = 1;
                    rForkNum = 0;
                } else if (philosopherNumber == 2) {
                    lForkNum = 2;
                    rForkNum = 1;
                } else if (philosopherNumber == 3) {
                    lForkNum = 3;
                    rForkNum = 2;
                } else {
                    lForkNum = 4;
                    rForkNum = 3;
                }
                //the full cycle of a philosopher thinking, picking up a fork, and then eating
                thinkTime();
                lFork.takeForks(philosopherNumber);
                System.out.println("Fork #" + lForkNum + " is with " + this.philosopherNumber);
                if (philosopherNumber == 0) {
                    rFork.takeForks(philosopherNumber + 4);
                } else {
                    rFork.takeForks(philosopherNumber - 1);
                }
                System.out.println("Fork #" + rForkNum + " is with " + this.philosopherNumber);
                System.out.println("Forks are with Philosopher #" + this.philosopherNumber);
                eatTime();

                lFork.returnForks(philosopherNumber);

                rFork.returnForks(philosopherNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //randomizes a wait time for each action done by a philosopher
    public void thinkTime() throws InterruptedException {
        int sleepTime = ThreadLocalRandom.current().nextInt(1, 3 + 1) * 1000;
        System.out.println("Philosopher #" + philosopherNumber + " took " + sleepTime + "ms thinking");

        Thread.sleep(sleepTime);
    }

    public void eatTime() throws InterruptedException {
        int sleepTime = ThreadLocalRandom.current().nextInt(1, 3 + 1) * 1000;
        System.out.println("Philosopher #" + philosopherNumber + " took " + sleepTime + "ms eating");

        Thread.sleep(sleepTime);
    }

}