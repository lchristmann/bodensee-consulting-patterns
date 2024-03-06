package bodenseeconsulting;

import javax.swing.*;
import java.awt.*;

public class Main2 extends JPanel {
    void draw() {

        Color grey = new Color(153,153,153);
        Color black = new Color( 0, 0, 0);
        Color orange = new Color(245, 132, 031);

        int offset = 0;
        for (int i = 0; i < 1000; i+=4) {       // y-axis: row
            switch(i%12) {
                case 0:
                    offset = 7;
                    break;
                case 4:
                    offset = 14;
                    break;
                case 8:
                    offset = 21;
                    break;
            }
            for (int j = 0; j < 1000; j += 11) {        //x-axis: column
                switch(j%33) {
                    case 0:
                        setColor(grey);
                        break;
                    case 11:
                        setColor(black);
                        break;
                    case 22:
                        setColor(orange);
                        break;
                }
                g2d.drawRect(j+offset, i, 1, 2);
            }
        }
    }

    private static JPanel getThisClassInstance() {
        return new Main2();
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
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2.0f));
        draw();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Area");
        frame.add(getThisClassInstance());
        frame.setSize(26 * SCALING, 30 * SCALING);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}