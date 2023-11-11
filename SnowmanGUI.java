
package javaapplication59;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnowmanGUI extends JFrame {

    private int x = 250; // initial x position
    private int y = 250; // initial y position

    public SnowmanGUI() {
        setTitle("Snowman Mover");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawSnowman(g);
            }
        };
        panel.setLayout(null);

        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");
        JButton upButton = new JButton("Up");
        JButton downButton = new JButton("Down");

        leftButton.setBounds(50, 400, 100, 30);
        rightButton.setBounds(160, 400, 100, 30);
        upButton.setBounds(270, 400, 100, 30);
        downButton.setBounds(380, 400, 100, 30);

        leftButton.addActionListener((ActionEvent e) -> {
            x -= 10;
            panel.repaint();
        });

        rightButton.addActionListener((ActionEvent e) -> {
            x += 10;
            panel.repaint();
        });

        upButton.addActionListener((ActionEvent e) -> {
            y -= 10;
            panel.repaint();
        });

        downButton.addActionListener((ActionEvent e) -> {
            y += 10;
            panel.repaint();
        });

        panel.add(leftButton);
        panel.add(rightButton);
        panel.add(upButton);
        panel.add(downButton);

        add(panel);
    }

    private void drawSnowman(Graphics g) {
        // Body
       
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 50, 50);
        g.fillOval(x - 10, y + 60, 70, 70);
        g.fillOval(x - 20, y + 140, 90, 90);

        // Cone Cap
        g.setColor(Color.red);
        int[] xPointsCap = {x + 25, x - 10, x + 60};
        int[] yPointsCap = {y - 20, y + 5, y + 5};
        g.fillPolygon(xPointsCap, yPointsCap, 3);

        // Eyes
        g.setColor(Color.BLACK);
        g.fillOval(x + 15, y + 25, 5, 5);
        g.fillOval(x + 30, y + 25, 5, 5);

        // Nose
        g.setColor(Color.ORANGE);
        int[] xPointsNose = {x + 25, x + 30, x + 20};
        int[] yPointsNose = {y + 30, y + 40, y + 40};
        g.fillPolygon(xPointsNose, yPointsNose, 3);

        // Mouth
        g.setColor(Color.BLACK);
        g.drawArc(x + 20, y + 40, 10, 5, 0, -180);

        // Traditional Hands
        Graphics2D g2d=(Graphics2D)g;
        g2d.setStroke(new BasicStroke(5));
        g.setColor(new Color(139,69,19));
        g.drawLine(x - 15, y + 65, x - 65, y + 30);
        g.drawLine(x + 65, y + 65, x + 100, y + 30);

        // Buttons
        g.setColor(Color.BLACK);
        g.fillOval(x + 22, y + 70, 5, 5);
        g.fillOval(x + 22, y + 90, 5, 5);
        g.fillOval(x + 22, y + 110, 5, 5);

        // Legs
        g.drawLine(x + 25, y + 230, x + 25, y + 280);
        g.drawLine(x + 25, y + 280, x + 10, y + 310);
        g.drawLine(x + 25, y + 280, x + 40, y + 310);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SnowmanGUI().setVisible(true);
        });
    }
}
