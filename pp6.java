import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class pp6 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
// Create a set to store integers
Set<Integer> numbers = new TreeSet<>();
// Accept n integers from the user and add them to the set
System.out.print("Enter the number of integers: ");
int n = sc.nextInt();
System.out.print("Enter " + n + " integers: ");
for (int i = 0; i < n; i++) {
int num = sc.nextInt();
numbers.add(num);
}
// Display the sorted integers
System.out.println("Sorted Integers: " + numbers);
// Search for a particular element
System.out.print("Enter a number to search for: ");
int searchNum = sc.nextInt();
if (numbers.contains(searchNum)) {
System.out.println(searchNum + " is present in the set.");
} else {
System.out.println(searchNum + " is not present in the set.");
}
}
}



program 2
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficSignalSimulation extends JPanel implements ActionListener {
    private final Color red = Color.RED;
    private final Color yellow = Color.YELLOW;
    private final Color green = Color.GREEN;
    private int currentColorIndex = 0;
    private final Timer timer;

    public TrafficSignalSimulation() {
        timer = new Timer(2000, this); // Change the color every 2 seconds
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTrafficSignal(g);
    }

    private void drawTrafficSignal(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 4;

        // Draw red light
        g.setColor(currentColorIndex == 0 ? red : Color.LIGHT_GRAY);
        g.fillOval(width / 2 - radius, height / 8 - radius, 2 * radius, 2 * radius);

        // Draw yellow light
        g.setColor(currentColorIndex == 1 ? yellow : Color.LIGHT_GRAY);
        g.fillOval(width / 2 - radius, height / 2 - radius, 2 * radius, 2 * radius);

        // Draw green light
        g.setColor(currentColorIndex == 2 ? green : Color.LIGHT_GRAY);
        g.fillOval(width / 2 - radius, 3 * height / 4 - radius, 2 * radius, 2 * radius);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentColorIndex = (currentColorIndex + 1) % 3; // Rotate between 0, 1, 2
        repaint(); // Redraw the traffic signal
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Traffic Signal Simulation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new TrafficSignalSimulation());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
