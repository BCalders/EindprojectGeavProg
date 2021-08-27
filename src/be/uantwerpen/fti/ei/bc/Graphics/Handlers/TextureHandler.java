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

    public static BufferedImage[] getPlayershipTextures() {
        BufferedImage[] b = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            b[i] = spriteSheet.getSubimage(64, 8 * i, 16, 8);
        }
        return b;
    }

    public static BufferedImage[] getBonusTextures() {
        BufferedImage[] b = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            b[i] = spriteSheet.getSubimage(16 * i, 16, 16, 16);
        }
        return b;
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

//    public static Image colorSprite(BufferedImage img, Color color) {
//        System.out.println(color);
//        int marker = new Color(255, 255, 255).getRGB() | 0xFF000000;
//        ImageFilter imageFilter = new RGBImageFilter() {
//            @Override
//            public int filterRGB(int x, int y, int rgb) {
//                if ((rgb | 0xFF000000) == marker) {
//                    return rgb;
//                }
//                return 0xFF000000 | color.getRGB();
//            }
//        };
//        ImageProducer ip = new FilteredImageSource(img.getSource(), imageFilter);
//        return Toolkit.getDefaultToolkit().createImage(ip);
//    }

}
