package be.uantwerpen.fti.ei.bc.Graphics.Handlers;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.IOException;;
import java.util.ArrayList;
import java.util.Objects;

/**
 * class to load al textures in advance
 *
 * @author Bas Calders
 */
public class TextureHandler {

    //sprites and background
    public static BufferedImage backgroundTexture, spriteSheet;

    /**
     * texturehandler constructor
     */
    public TextureHandler() {
        try {
            backgroundTexture = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Backgrounds/background.png")));
            spriteSheet = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Entities/sprites.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * return playership textures
     *
     * @return playership textures array
     */
    public static BufferedImage[] getPlayershipTextures() {
        BufferedImage[] b = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            b[i] = spriteSheet.getSubimage(64, 8 * i, 16, 8);
        }
        return b;
    }

    /**
     * return bonus textures
     *
     * @return bonus texture array
     */
    public static BufferedImage[] getBonusTextures() {
        BufferedImage[] b = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            b[i] = spriteSheet.getSubimage(16 * i, 16, 16, 16);
        }
        return b;
    }

    /**
     * returns enemy animations in list of arrays
     *
     * @return list of enemy animation arrays
     */
    public static ArrayList<BufferedImage[]> getEnemyTextures() {
        ArrayList<BufferedImage[]> eSprites = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            BufferedImage[] b = new BufferedImage[2];
            for (int j = 0; j < 2; j++) {
                b[j] = spriteSheet.getSubimage(16 * i, 8 * j, 16, 8);
            }
            eSprites.add(b);
        }

        return eSprites;
    }
}
