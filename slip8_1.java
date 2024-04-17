
class Main extends Thread{
    String str;
    int n;

    public Main(String str , int n){
        this.str = str;
        this.n = n;
    }

    public void run(){
        try{
            for(int i = 0; i < n; i++){
                System.out.println(getName() + " : " + str);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

public class slip8_1 {
    public static void main(String[] args) {
        Main m1 = new Main("Covid 19" , 10);
        Main m2 = new Main("LOCKDOWN2020" , 20);
        Main m3 = new Main("VACCINATED2021" , 30);

        m1.start();
        m2.start();
        m3.start();
    }
}
