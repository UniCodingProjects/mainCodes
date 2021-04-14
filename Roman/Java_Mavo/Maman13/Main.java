

import javax.swing.JFrame;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RGB Tester");
        frame.setDefaultCloseOperation(3);
        frame.setSize(1920, 1080);
        RGBPanel p = new RGBPanel();
        frame.add(p);
        frame.setVisible(true);
    }
}

