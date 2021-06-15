package be.uantwerpen.fti.ei.bc.Graphics.Main;

import be.uantwerpen.fti.ei.bc.Game.Main.GraphicsClass;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class J2dGraph extends GraphicsClass {

    public static final int WIDTH = 600, HEIGHT = 800;

    public BufferedImage image;
    private final Graphics2D g2d;

    private final JFrame frame;
    private final JPanel panel;

    public J2dGraph() {
        frame = new JFrame("Project");
        panel = new JPanel(true) {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                doDrawing(g);
            }
        };
        panel.setBackground(Color.MAGENTA);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);

        image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = image.createGraphics();
    }

    public Graphics2D getG2d() {
        return g2d;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void render() {
        panel.repaint();
    }

    private void doDrawing(Graphics g) {
        Graphics2D graph2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        graph2d.drawImage(image, 0, 0, null);
        graph2d.dispose();
        if (g2d != null)
            g2d.drawImage(image, 0, 0, null);
    }


}
