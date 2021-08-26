package be.uantwerpen.fti.ei.bc.Graphics.Handlers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Image;
import java.awt.image.*;
import java.io.IOException;;
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

    public static Image colorSprite(BufferedImage tile, Color intFrontColor){
        int markerRGB = new Color(0xff,0xff,0xff).getRGB() | 0xFF000000;
        ImageFilter imageFilter = new RGBImageFilter()
        {
            @Override
            public int filterRGB(int x, int y, int rgb)
            {
                if ((rgb | 0xFF000000) == markerRGB)
                {
                    return rgb;
                }
                return 0xFF000000 | intFrontColor.getRGB();
            }
        };
        ImageProducer ip = new FilteredImageSource(tile.getSource(), imageFilter);
        Image image = Toolkit.getDefaultToolkit().createImage(ip);
        return image;
    }
}
