package be.uantwerpen.fti.ei.bc.Graphics.Handlers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class TextureHandler {

    public static BufferedImage backgroundTexture, spriteSheet;

    public TextureHandler() {
        try {
            backgroundTexture = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Backgrounds/background.png")));
            spriteSheet = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Entities/sprites.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getPlayershipTexture() {
        return spriteSheet.getSubimage(48, 8, 16, 8);
    }

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
