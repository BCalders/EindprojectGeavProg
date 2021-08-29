package be.uantwerpen.fti.ei.bc.Graphics.GameState;

import be.uantwerpen.fti.ei.bc.Graphics.Audio.AudioPlayer;
import be.uantwerpen.fti.ei.bc.Game.GameState.GameStateManager;
import be.uantwerpen.fti.ei.bc.Game.GameState.WinState;
import be.uantwerpen.fti.ei.bc.Graphics.Main.J2dGraph;

import java.awt.*;

/**
 * winstate rendering class
 *
 * @author Bas Calders
 */
public class J2dWinState extends WinState {

    //graph
    private final J2dGraph gr;

    //colors and fonts
    private Color titleColor, selectColor, winColor, winColorDarker;
    private Font titleFont, font;

    //graphic vars and booleans
    private boolean linesVisible, isBlinking;
    private int linesVisibleCount, blinkingCounter;

    //audioplayer
    private static final AudioPlayer victory = new AudioPlayer("src/be/uantwerpen/fti/ei/bc/Resources/SFX/Player/victory.wav", J2dGraph.SFXVOL);

    /**
     * j2dwinstate constructor
     *
     * @param graph graphics class
     * @param gsm   gamestatemanager
     */
    public J2dWinState(J2dGraph graph, GameStateManager gsm) {
        super(gsm);
        this.gr = graph;
    }

    @Override
    public void init() {
        super.init();

        linesVisible = true;
        linesVisibleCount = 0;

        J2dGraph.bg.setVector(0, 0.2);

        titleColor = new Color(0, 255, 180);
        winColor = new Color(255, 128, 180);
        titleFont = new Font("Century Gothic", Font.BOLD, 60);

        selectColor = titleColor.darker().darker();
        winColorDarker = winColor.darker().darker();

        font = new Font("Arial", Font.PLAIN, 30);

        J2dGraph.bgMusic.stop();
        victory.play();
    }

    @Override
    public void update() {
        super.update();
        J2dGraph.bg.update();

        linesVisibleCount++;
        blinkingCounter++;

        if (linesVisibleCount > 30) {
            linesVisible = !linesVisible;
            linesVisibleCount = 0;
        }
        if (blinkingCounter > 20) {
            isBlinking = !isBlinking;
            blinkingCounter = 0;
        }
    }

    /**
     * draw winstate to screen
     */
    @Override
    public void draw() {
        Graphics2D g2d = gr.getG2d();
        int titleXLocation, titleYLocation;
        String title = "YOU WIN!";
        String hiscore = "You Have Scored A HIGHSCORE!";

        //draw Background
        J2dGraph.bg.draw();

        //draw highscore
        if (isHighscore) {
            if (isBlinking) g2d.setColor(winColor);
            else g2d.setColor(winColorDarker);
            g2d.setFont(font);
            g2d.drawString(hiscore, (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(hiscore)) / 2, J2dGraph.HEIGHT / 8);
        }


        //draw Title
        g2d.setColor(titleColor);
        g2d.setFont(titleFont);
        titleXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(title)) / 2;
        titleYLocation = J2dGraph.HEIGHT / 4;
        g2d.drawString(title, titleXLocation, titleYLocation);

        //draw scores
        int scoreSpacing = 50;
        int scoreYLocation;
        int scoreXLocation = J2dGraph.WIDTH / 2;

        for (int i = 0; i < scoreNames.length; i++) {
            scoreYLocation = J2dGraph.HEIGHT / 2 + ((i - 1) * scoreSpacing);
            g2d.setFont(font);

            g2d.drawString(scoreNames[i], titleXLocation, scoreYLocation);
            g2d.drawString(getScoreCalc()[i], scoreXLocation, scoreYLocation);
        }
        g2d.drawLine(
                titleXLocation,
                J2dGraph.HEIGHT / 2 + (scoreSpacing) + 10,
                scoreXLocation + g2d.getFontMetrics(g2d.getFont()).stringWidth(getScoreCalc()[1]),
                J2dGraph.HEIGHT / 2 + (scoreSpacing) + 10
        );

        //draw return
        String returnString = "Press ENTER to continue";
        if (linesVisible)
            returnString = "-- Press ENTER to continue --";
        int returnXLocation = (J2dGraph.WIDTH - g2d.getFontMetrics(g2d.getFont()).stringWidth(returnString)) / 2;
        int returnYLocation = (J2dGraph.HEIGHT / 4) * 3;
        g2d.drawString(returnString, returnXLocation, returnYLocation);

    }
}