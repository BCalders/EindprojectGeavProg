package be.uantwerpen.fti.ei.bc.Graphics.Audio;

import javax.sound.sampled.*;
import java.io.File;

/**
 * class responsible for playing audio cues
 *
 * @author Bas Calders
 */
public class AudioPlayer {

    //clip
    private Clip clip;

    /**
     * audioplayer constructor
     *
     * @param s      audio file location
     * @param volume volume of player
     */
    public AudioPlayer(String s, float volume) {
        try {
            File file = new File(s);
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );
            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
            clip = AudioSystem.getClip();
            clip.open(dais);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert clip != null;
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }

    /**
     * play audioplayer
     */
    public void play() {
        assert clip != null;
        clip.setFramePosition(0);
        clip.start();
    }

    /**
     * stop playing audioplayer
     */
    public void stop() {
        if (clip.isRunning()) clip.stop();
    }

    /**
     * close audioplayer
     */
    public void close() {
        stop();
        clip.close();
    }
}
