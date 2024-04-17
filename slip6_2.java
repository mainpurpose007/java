import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TrafficSignal extends JFrame {
    private JLabel signalLabel;

    private Color greenColor = Color.GREEN;
    private Color yellowColor = Color.YELLOW;
    private Color redColor = Color.RED;

    private boolean isStop = false;
    private boolean isProceed = false;
    private boolean isReady = true;

    public TrafficSignal() {
        setTitle("Traffic Signal");
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        signalLabel = new JLabel();
        signalLabel.setPreferredSize(new Dimension(150, 300));
        signalLabel.setOpaque(true);
        signalLabel.setBackground(redColor);

        JButton stopButton = new JButton("STOP");
        JButton proceedButton = new JButton("PROCEED");

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                isStop = true;
                isProceed = false;
                isReady = false;
            }
        });

        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                isStop = false;
                isProceed = true;
                isReady = false;
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(stopButton);
        buttonPanel.add(proceedButton);

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(signalLabel);
        getContentPane().add(buttonPanel);
    }

    public void startSignal() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        if (isStop) {
                            signalLabel.setBackground(redColor);
                            Thread.sleep(3000);
                        } else if (isProceed) {
                            signalLabel.setBackground(greenColor);
                            Thread.sleep(3000);
                        } else {
                            signalLabel.setBackground(yellowColor);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}



public class slip6_2 {
    public static void main(String[] args) {
        TrafficSignal signal = new TrafficSignal();
        signal.setVisible(true);
        signal.startSignal();
    }
}
