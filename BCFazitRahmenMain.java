package bodenseeconsulting;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {
    void draw() {
        Color grey = new Color(153,153,153);
        Color black = new Color( 0, 0, 0);
        Color orange = new Color(245, 132, 031);

        for (float i = 1; i < 84; i++) {
            if (i % 3 == 1) {
                setColor(grey);
            } else if (i % 3 == 2) {
                setColor(black);
            } else {
                setColor(orange);
            }
            // here the density of the lines can be changed: i/2 means half the distance between lines, 2*i means double the distance between lines
            drawLine(0, i/2, i/2, 0);
        }
    }

    // return an instance of this class
    private static JPanel getThisClassInstance() {
        return new Main();
    }

    private Graphics2D g2d;

    private static final int SCALING = 40;

    private void drawCircle(float x, float y, float r) {
        g2d.drawOval(Math.round((x - r) * SCALING), Math.round((y - r) * SCALING),
                Math.round(2 * r * SCALING), Math.round(2 * r * SCALING));
    }

    private void drawLine(float xFrom, float yFrom, float xDest, float yDest) {
        g2d.drawLine(Math.round(xFrom * SCALING), Math.round(yFrom * SCALING),
                Math.round(xDest * SCALING), Math.round(yDest * SCALING));
    }

    private void setColor(Color color) {
        g2d.setColor(color);
    }

    @Override
    public void paint(Graphics g) {
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(2.0f));
        draw();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Area");
        frame.add(getThisClassInstance());
        frame.setSize(21 * SCALING, 22 * SCALING);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
