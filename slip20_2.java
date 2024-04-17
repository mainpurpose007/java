import javax.swing.*;
import java.awt.*;

public class slip20_2 extends JFrame {
    public slip20_2() {
        setTitle("Temple Drawing");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the custom JPanel to the frame
        add(new TemplePanel());
    }

    public static void main(String[] args) {
        // Create and display the frame
        SwingUtilities.invokeLater(() -> {
            slip20_2 templeDrawing = new slip20_2();
            templeDrawing.setVisible(true);
        });
    }
}

class TemplePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the drawing color
        g.setColor(Color.BLACK);

        // Draw the temple
        int width = getWidth();
        int height = getHeight();

        // Draw temple base
        g.fillRect(width/4, height/4, width/2, height/2);

        // Draw temple roof
        int[] xPoints = {width/2, width/4, 3*width/4};
        int[] yPoints = {height/4, height/10, height/10};
        g.fillPolygon(xPoints, yPoints, 3);

        // Draw door
        g.setColor(Color.BLUE);
        g.fillRect(width/2 - width/8, 3*height/4, width/4, height/4);

        // Draw windows
        g.setColor(Color.WHITE);
        g.fillRect(width/3, height/3, width/10, height/6);
        g.fillRect(2*width/3 - width/10, height/3, width/10, height/6);
    }
}
