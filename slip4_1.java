import javax.swing.*;
import java.awt.*;

class TextBlinking extends JFrame implements Runnable{
    private JLabel label;

    public TextBlinking(){
        setTitle("Blinking text");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Hello I am Blinking text");
        label.setFont( new Font("Arial" , Font.PLAIN , 35) );
        add(label , BorderLayout.CENTER);


        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void run(){
        try{
            while(true){
                label.setVisible(!label.isVisible());
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class slip4_1 {
    public static void main(String[] args) {
        TextBlinking b = new TextBlinking();
        Thread t = new Thread(b);
        t.start();
    }
}
