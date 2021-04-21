//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Graphics;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.geom.AffineTransform;
//import java.awt.image.AffineTransformOp;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.imageio.ImageIO;
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.filechooser.FileNameExtensionFilter;
//
//public class RGBPanel extends JPanel implements ActionListener {
//    private final int MARGIN = 50;
//    private RGBImage img = new RGBImage(100, 100);
//    private int x;
//    private int y;
//    private JButton cmdInvert = new JButton("Invert Colors");
//    private JButton cmdShiftRows = new JButton("Shift Rows");
//    private JButton cmdShiftCols = new JButton("Shift Cols");
//    private JButton cmdFlipVer = new JButton("Flip Vertical");
//    private JButton cmdFlipHor = new JButton("Flip Horizontal");
//    private JButton cmdRotClock = new JButton("Rotate Clockwise");
//    private JButton cmdRotCounter = new JButton("Rotate Counter Clockwise");
//    private JButton cmdLoadImage = new JButton("Load Image");
//    private JButton cmdToGray = new JButton("Convert to Gray");
//    private final int IMAGE_MAX_WIDTH = 800;
//    private final int IMAGE_MAX_HEIGHT = 600;
//    private JFileChooser fc;
//
//    public RGBPanel() {
//        this.cmdInvert.addActionListener(this);
//        this.cmdShiftRows.addActionListener(this);
//        this.cmdShiftCols.addActionListener(this);
//        this.cmdFlipVer.addActionListener(this);
//        this.cmdFlipHor.addActionListener(this);
//        this.cmdRotClock.addActionListener(this);
//        this.cmdRotCounter.addActionListener(this);
//        this.cmdLoadImage.addActionListener(this);
//        this.cmdToGray.addActionListener(this);
//        this.cmdInvert.setEnabled(false);
//        this.cmdShiftRows.setEnabled(false);
//        this.cmdShiftCols.setEnabled(false);
//        this.cmdFlipVer.setEnabled(false);
//        this.cmdFlipHor.setEnabled(false);
//        this.cmdRotClock.setEnabled(false);
//        this.cmdRotCounter.setEnabled(false);
//        this.cmdToGray.setEnabled(false);
//        JPanel controls = new JPanel();
//        controls.setLayout(new GridLayout(2, 5, 15, 15));
//        controls.add(this.cmdLoadImage);
//        controls.add(this.cmdInvert);
//        controls.add(this.cmdShiftRows);
//        controls.add(this.cmdShiftCols);
//        controls.add(this.cmdToGray);
//        controls.add(this.cmdFlipVer);
//        controls.add(this.cmdFlipHor);
//        controls.add(this.cmdRotClock);
//        controls.add(this.cmdRotCounter);
//        this.setLayout(new BorderLayout());
//        this.add(controls, "South");
//        this.fc = new JFileChooser();
//        this.fc.setCurrentDirectory(new File("."));
//    }
//
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        int w = this.getWidth();
//        int h = this.getHeight();
//        int imgW = this.img.getWidth();
//        int imgH = this.img.getHeight();
//        this.x = (w - imgW) / 2;
//        this.y = (h - imgH) / 2;
//        g.drawRect(this.x - 1, this.y - 1, imgW + 2, imgH + 2);
//        this.drawImage(g);
//    }
//
//    public void drawImage(Graphics g) {
//        RGBColor[][] rgb = this.img.toRGBColorArray();
//
//        for(int i = 0; i < rgb.length; ++i) {
//            for(int j = 0; j < rgb[i].length; ++j) {
//                Color c = new Color(rgb[i][j].getRed(), rgb[i][j].getGreen(), rgb[i][j].getBlue());
//                g.setColor(c);
//                g.fillRect(this.x + j, this.y + i, 2, 2);
//            }
//        }
//
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == this.cmdLoadImage) {
//            this.img = this.loadImage();
//            this.cmdInvert.setEnabled(true);
//            this.cmdShiftRows.setEnabled(true);
//            this.cmdShiftCols.setEnabled(true);
//            this.cmdFlipVer.setEnabled(true);
//            this.cmdFlipHor.setEnabled(true);
//            this.cmdRotClock.setEnabled(true);
//            this.cmdRotCounter.setEnabled(true);
//            this.cmdToGray.setEnabled(true);
//        } else if (e.getSource() == this.cmdInvert) {
//            this.img.invertColors();
//        } else {
//            String res;
//            int i;
//            if (e.getSource() == this.cmdShiftRows) {
//                res = JOptionPane.showInputDialog((Component)null, "Enter number of pixels to shift:");
//
//                try {
//                    i = Integer.parseInt(res);
//                    this.img.shiftRow(i);
//                } catch (NumberFormatException var7) {
//                    JOptionPane.showMessageDialog((Component)null, "Invalid Number", "Error", 0);
//                }
//            } else if (e.getSource() == this.cmdShiftCols) {
//                res = JOptionPane.showInputDialog((Component)null, "Enter number of pixels to shift:");
//
//                try {
//                    i = Integer.parseInt(res);
//                    this.img.shiftCol(i);
//                } catch (NumberFormatException var6) {
//                    JOptionPane.showMessageDialog((Component)null, "Invalid Number", "Error", 0);
//                }
//            } else if (e.getSource() == this.cmdFlipVer) {
//                this.img.flipVertical();
//            } else if (e.getSource() == this.cmdFlipHor) {
//                this.img.flipHorizontal();
//            } else if (e.getSource() == this.cmdRotClock) {
//                this.img.rotateClockwise();
//            } else if (e.getSource() == this.cmdRotCounter) {
//                this.img.rotateCounterClockwise();
//            } else if (e.getSource() == this.cmdToGray) {
//                double[][] grayScaleArray = this.img.toGrayscaleArray();
//
//                for(i = 0; i < grayScaleArray.length; ++i) {
//                    for(int j = 0; j < grayScaleArray[0].length; ++j) {
//                        int val = (int)grayScaleArray[i][j];
//                        this.img.setPixel(i, j, new RGBColor(val, val, val));
//                    }
//                }
//            }
//        }
//
//        this.repaint();
//    }
//
//    private RGBImage loadImagePPM(File f) {
//        try {
//            int[] rgb = new int[3];
//            Scanner scan = new Scanner(f);
//            scan.nextLine();
//            scan.nextLine();
//            String s = scan.next();
//            int cols = Integer.parseInt(s);
//            s = scan.next();
//            int rows = Integer.parseInt(s);
//            RGBColor[][] arr = new RGBColor[rows][cols];
//            s = scan.next();
//
//            for(int i = 0; i < rows; ++i) {
//                for(int j = 0; j < cols; ++j) {
//                    for(int k = 0; k < 3; ++k) {
//                        rgb[k] = Integer.parseInt(scan.next());
//                    }
//
//                    arr[i][j] = new RGBColor(rgb[0], rgb[1], rgb[2]);
//                }
//            }
//
//            return new RGBImage(arr);
//        } catch (FileNotFoundException var11) {
//            Logger.getLogger(RGBPanel.class.getName()).log(Level.SEVERE, (String)null, var11);
//            return null;
//        }
//    }
//
//    private BufferedImage resizeImage(BufferedImage before, int maxWidthAfter, int maxHeightAfter) {
//        int widthBefore = before.getWidth();
//        int heightBefore = before.getHeight();
//        if (widthBefore <= maxWidthAfter && heightBefore <= maxHeightAfter) {
//            return before;
//        } else {
//            int widthAfter = widthBefore;
//            int heightAfter = heightBefore;
//            double scale = 1.0D;
//            double aspectRatio = (double)widthBefore / (double)heightBefore;
//            if (widthBefore > maxWidthAfter) {
//                scale = (double)maxWidthAfter / (double)widthBefore;
//                widthAfter = maxWidthAfter;
//                heightAfter = (int)((double)maxWidthAfter / aspectRatio);
//            } else if (heightBefore > maxHeightAfter) {
//                scale = (double)maxHeightAfter / (double)heightBefore;
//                heightAfter = maxHeightAfter;
//                widthAfter = (int)((double)maxHeightAfter * aspectRatio);
//            }
//
//            BufferedImage after = new BufferedImage(widthAfter, heightAfter, 2);
//            AffineTransform at = new AffineTransform();
//            at.scale(scale, scale);
//            AffineTransformOp scaleOp = new AffineTransformOp(at, 2);
//            after = scaleOp.filter(before, after);
//            return after;
//        }
//    }
//
//    private RGBImage loadImageOther(File f) {
//        BufferedImage image;
//        try {
//            image = ImageIO.read(f);
//        } catch (IOException var12) {
//            Logger.getLogger(RGBPanel.class.getName()).log(Level.SEVERE, (String)null, var12);
//            return null;
//        }
//
//        image = this.resizeImage(image, 800, 600);
//        int rows = image.getHeight();
//        int cols = image.getWidth();
//        RGBColor[][] arr = new RGBColor[rows][cols];
//
//        for(int i = 0; i < rows; ++i) {
//            for(int j = 0; j < cols; ++j) {
//                int argb = image.getRGB(j, i);
//                int r = (argb & 16711680) >> 16;
//                int g = (argb & '\uff00') >> 8;
//                int b = argb & 255;
//                arr[i][j] = new RGBColor(r, g, b);
//            }
//        }
//
//        return new RGBImage(arr);
//    }
//
//    private String getFileExtension(File file) {
//        String name = file.getName();
//        int lastIndexOf = name.lastIndexOf(".");
//        return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
//    }
//
//    private RGBImage loadImage() {
//        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Files", new String[]{"ppm", "jpg", "png", "bmp", "gif"});
//        this.fc.addChoosableFileFilter(imageFilter);
//        this.fc.setFileFilter(imageFilter);
//        this.fc.showOpenDialog((Component)null);
//        File file = this.fc.getSelectedFile();
//        String ext = this.getFileExtension(file).toLowerCase();
//        if (ext.equals("ppm")) {
//            return this.loadImagePPM(file);
//        } else {
//            return !ext.equals("jpg") && !ext.equals("jpeg") && !ext.equals("png") && !ext.equals("bmp") && !ext.equals("gif") ? null : this.loadImageOther(file);
//        }
//    }
//}
