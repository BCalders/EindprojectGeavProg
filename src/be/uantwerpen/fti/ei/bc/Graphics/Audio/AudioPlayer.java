package be.uantwerpen.fti.ei.bc.Graphics.Audio;

import javax.sound.sampled.*;
import java.io.File;


public class AudioPlayer {

    private Clip clip;

    public AudioPlayer(String s, float volume) {
        System.out.println(s);
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

    public void play(){
        assert clip != null;
        clip.setFramePosition(0);
        clip.start();
    }

    public void stop() {
        if(clip.isRunning()) clip.stop();
    }

    public void close(){
        stop();
        clip.close();
    }
}
