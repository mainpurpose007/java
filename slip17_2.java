import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class slip17_2 extends JFrame {
    private JTextField textField;
    private JButton startButton;
    private volatile boolean running;

    public slip17_2() {
        super("Number Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLayout(new FlowLayout());

        textField = new JTextField(10);
        startButton = new JButton("Start");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running = true;
                new Thread(new slip17_2Task()).start();
                startButton.setEnabled(false); // Disable the button after clicking
            }
        });

        add(textField);
        add(startButton);
    }

    private class slip17_2Task implements Runnable {
        public void run() {
            try {
                for (int i = 1; i <= 100; i++) {
                    if (!running) return; // Stop if not running
                    int finalI = i;
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            textField.setText(Integer.toString(finalI));
                        }
                    });
                    Thread.sleep(1000); // Sleep for 1 second
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        startButton.setEnabled(true); // Enable the button after completion
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                slip17_2 numberDisplay = new slip17_2();
                numberDisplay.setVisible(true);
            }
        });
    }
}

