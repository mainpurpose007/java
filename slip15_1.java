import java.lang.*;
public class slip15_1 {
    public static void main(String[] args) {
        Thread t = new Thread(new RunnableThread());
        t.setName("Thread 1");
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
        System.out.println("Your Thread is " + t.getName() + " and the priority is " + t.getPriority());
    }

}
class RunnableThread implements Runnable {
    @Override
    public void run(){
            for (int i = 0; i < 5; i++){
                System.out.println("Your Task " + i + " and Thread is " + Thread.currentThread().getName());
            }
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
        }
    }
}
