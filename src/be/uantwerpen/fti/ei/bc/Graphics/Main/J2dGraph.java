package be.uantwerpen.fti.ei.bc.Graphics.Main;

import be.uantwerpen.fti.ei.bc.Graphics.Audio.AudioPlayer;
import be.uantwerpen.fti.ei.bc.Game.Main.GraphicsClass;
import be.uantwerpen.fti.ei.bc.Graphics.GameState.Background;
import be.uantwerpen.fti.ei.bc.Graphics.Handlers.TextureHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * j2d graphics class, used to render the game
 *
 * @author Bas Calders
 */
public class J2dGraph extends GraphicsClass {

    //config vars
    public static int WIDTH, HEIGHT;
    public static float SFXVOL, MVOL;

    // rendering vars
    public BufferedImage image;
    private final Graphics2D g2d;
    private final JFrame frame;
    private final JPanel panel;

    //bg music and background
    public static Background bg;
    public static AudioPlayer bgMusic;

    /**
     * j2dGraph constructor
     */
    public J2dGraph() {
        //Loading ConfigFile
        Config config = ConfigLoader.getConfig();
        setConfig(config);

        frame = new JFrame("Initializing");
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
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setTitle("Space Invaders");

        image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = image.createGraphics();

        //load textures into handler
        new TextureHandler();

        //init background
        try {
            bg = new Background(this);
            bg.setVector(0, 0.2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        bgMusic = new AudioPlayer("src/be/uantwerpen/fti/ei/bc/Resources/SFX/Music/Background.wav", MVOL);
    }

    /**
     * config setter
     *
     * @param config set config
     */
    private void setConfig(Config config) {
        WIDTH = config.getWIDTH();
        HEIGHT = config.getHEIGHT();
        SFXVOL = config.getSFXVOL();
        MVOL = config.getMVOL();
    }

    /**
     * calculate x pos
     *
     * @param x x cartesian
     * @return x absolute
     */
    @Override
    public double calculateX(double x) {
        return ((x + 3) / 6) * WIDTH;
    }

    /**
     * calculate y pos
     *
     * @param y y cartesian
     * @return y absolute
     */
    @Override
    public double calculateY(double y) {
        return (-(y - 4) / 8) * HEIGHT;
    }

    /**
     * reform x pos
     *
     * @param x x cartesian
     * @return x absolute
     */
    @Override
    public double reformX(double x) {
        return (x / 6) * WIDTH;
    }

    /**
     * reform y pos
     *
     * @param y y cartesian
     * @returny absolute
     */
    @Override
    public double reformY(double y) {
        return (y / 8) * HEIGHT;
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

    /**
     * render panel
     */
    public void render() {
        panel.repaint();
    }

    /**
     * draw graphics
     *
     * @param g graphics class
     */
    private void doDrawing(Graphics g) {
        Graphics2D graph2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        graph2d.drawImage(image, 0, 0, null);
        graph2d.dispose();
        if (g2d != null)
            g2d.drawImage(image, 0, 0, null);
    }
}
