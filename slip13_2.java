import java.util.*;
class LifeCycleThread extends Thread{
    private String threadName;

    public LifeCycleThread(String threadName){
        this.threadName = threadName;
    }

    public void run(){
        Random random = new Random();
        int randSeed = random.nextInt(5000);
        try{
            System.out.println("Your Thread name is : " + threadName + " thread is created.");
            Thread.sleep(randSeed);
            System.out.println("Thread sleep time : " + randSeed  + " millisecond");
        }catch(Exception e){
            e.printStackTrace();
        }
            System.out.println("Thread was dead");
    }
}

public class slip13_2 {
    public static void main(String[] args) {
        LifeCycleThread t1 = new LifeCycleThread("thread-1");
        LifeCycleThread t2 = new LifeCycleThread("thread-2");
        LifeCycleThread t3 = new LifeCycleThread("thread-3");

        t1.start();
        t2.start();
        t3.start();

    }
}
