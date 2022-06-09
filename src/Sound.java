import javax.sound.sampled.*;
import java.io.*;

public class Sound {
    Clip clip;
    float previousVolumn = 0;
    float curentVolumn = 0;
    FloatControl fc;
    boolean mute = false;

    public void playSound(File url) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(url);
                    clip.open(inputStream);
                    fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    clip.setFramePosition(0);
                    clip.start(); 
                    clip.loop(Clip.LOOP_CONTINUOUSLY);

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }


    public void volumnUp() {
        curentVolumn += 1.0f;
        if (curentVolumn > 6.0f) {
            curentVolumn = 6.0f;
        }
        fc.setValue(curentVolumn);
    }


    public void volumnDown() {
        curentVolumn -= 1.0f;
        if (curentVolumn < -80.0f) {
            curentVolumn = -80.0f;
        }
        fc.setValue(curentVolumn);
    }


    public void mute() {
        if (mute == false) {
            previousVolumn = curentVolumn;
            curentVolumn = 80.0f;
            fc.setValue(curentVolumn);
            mute = true;

        } else if (mute == true) {
            curentVolumn = previousVolumn;
            fc.setValue(curentVolumn);
        }
    }
}
