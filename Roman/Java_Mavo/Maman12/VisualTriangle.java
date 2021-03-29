//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VisualTriangle extends JPanel {
    private Vector<Triangle> triangles;
    private ArrayList<Color> colors;
    private final int INTERVAL = 20;
    private JFrame frame;
    private final Color BG_COLOR = new Color(246, 246, 246);
    private final Color AXIS_COLOR = new Color(65, 60, 105);
    private final Color TEXT_COLOR = new Color(0, 128, 128);
    private final int SIZE = 500;
    private final int ZERO = 250;
    private boolean showPointVal = false;
    private final Font FONT = new Font("David", 0, 20);
    private int midX;
    private int midY;

    public VisualTriangle(String textTitle) {
        this.triangles = new Vector();
        this.frame = new JFrame("Visual Triangle " + textTitle);
        this.frame.setSize(500, 500);
        this.frame.setResizable(false);
        this.setBackground(this.BG_COLOR);
        this.frame.add(this);
        this.frame.setVisible(true);
        this.setFont(this.FONT);
        this.colors = new ArrayList();
        this.colors.add(new Color(235, 94, 11));
        this.colors.add(new Color(78, 61, 83));
        this.colors.add(new Color(228, 0, 16));
        this.colors.add(new Color(240, 165, 0));
        this.colors.add(new Color(73, 163, 1));
    }

    public VisualTriangle(String textTitle, boolean showVal) {
        this.showPointVal = showVal;
        this.triangles = new Vector();
        this.frame = new JFrame("Visual Triangle " + textTitle);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setSize(500, 500);
        this.frame.setResizable(false);
        this.setBackground(this.BG_COLOR);
        this.frame.add(this);
        this.frame.setVisible(true);
        this.setFont(this.FONT);
        this.colors = new ArrayList();
        this.colors.add(new Color(235, 94, 11));
        this.colors.add(new Color(78, 61, 83));
        this.colors.add(new Color(228, 0, 23));
        this.colors.add(new Color(240, 165, 0));
        this.colors.add(new Color(74, 71, 163));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.midX = this.getWidth() / 2;
        this.midY = this.getHeight() / 2;
        Graphics2D g1 = (Graphics2D)g;
        g1.setStroke(new BasicStroke(1.0F));
        g1.setColor(this.AXIS_COLOR);
        g1.drawLine(this.midX, 0, this.midX, this.getHeight());
        g1.drawLine(0, this.midY, this.getWidth(), this.midY);
        this.drawAxisScale(g1);

        for(int i = 0; i < this.triangles.size(); ++i) {
            this.drawTriangle((Triangle)this.triangles.get(i), g, this.midX, this.midY, (Color)this.colors.get(i % this.colors.size()));
        }

    }

    private void drawAxisScale(Graphics2D g1) {
        int count = 0;
        FontMetrics fontMetrics = g1.getFontMetrics(this.FONT);

        int i;
        int len;
        for(i = this.midX; i < 500; i += 20) {
            g1.drawLine(i, this.midY + 3, i, this.midY - 3);
            g1.drawLine(i - this.midX, this.midY + 3, i - this.midX, this.midY - 3);
            if (count % 5 == 0 && count != 0) {
                len = fontMetrics.stringWidth("" + count);
                g1.drawString("" + count, i - len / 2, this.midY - 10);
                g1.drawString("-" + count, this.midX - 20 * count - len, this.midY - 10);
            }

            ++count;
        }

        count = 0;

        for(i = this.midY; i < 500; i += 20) {
            g1.drawLine(this.midX - 3, this.midY - count * 20, this.midX + 3, this.midY - count * 20);
            g1.drawLine(this.midX - 3, i, this.midX + 3, i);
            if (count % 5 == 0 && count != 0) {
                len = fontMetrics.stringWidth("" + count);
                g1.drawString("" + count, this.midX - len - 10, this.midY - count * 20 + 5);
                g1.drawString("-" + count, this.midX - len - 15, i + 5);
            }

            ++count;
        }

    }

    private void drawTriangle(Triangle t, Graphics g, int midX, int midY, Color color) {
        int x1 = (int)(t.getPoint1().getX() * 20.0D + (double)midX);
        int y1 = (int)((double)midY - t.getPoint1().getY() * 20.0D);
        int x2 = (int)(t.getPoint2().getX() * 20.0D + (double)midX);
        int y2 = (int)((double)midY - t.getPoint2().getY() * 20.0D);
        int x3 = (int)(t.getPoint3().getX() * 20.0D + (double)midX);
        int y3 = (int)((double)midY - t.getPoint3().getY() * 20.0D);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(3.0F));
        g2.drawLine(x1, y1, x2, y2);
        g2.drawLine(x2, y2, x3, y3);
        g2.drawLine(x3, y3, x1, y1);
        if (this.showPointVal) {
            g2.setColor(this.TEXT_COLOR);
            g2.drawString(t.getPoint1().toString(), x1, y1 + 20);
            g2.drawString(t.getPoint2().toString(), x2, y2);
            g2.drawString(t.getPoint3().toString(), x3, y3 + 20);
        }

    }

    public void add(Triangle t) {
        this.triangles.add(new Triangle(t));
        this.repaint();
    }

    public void clear() {
        this.triangles.removeAllElements();
        this.repaint();
    }
}
