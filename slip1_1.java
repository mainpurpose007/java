import java.lang.*;

class alphabets extends Thread{

    @Override
    public void run(){
        for(char c='A'; c<='Z'; c++){
            System.out.println(c + " ");
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class slip1_1{
    public static void main(String [] args){
        alphabets a = new alphabets();
        a.start();
    }
}
