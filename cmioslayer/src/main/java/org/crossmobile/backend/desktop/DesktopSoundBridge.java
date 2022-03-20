/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import crossmobile.ios.foundation.NSURL;
import javazoom.jl.decoder.*;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.JavaSoundAudioDevice;
import org.crossmobile.bind.io.SoundPlayer;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.SoundBridge;

import javax.sound.sampled.*;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Map;

public class DesktopSoundBridge implements SoundBridge {

    private boolean isVibrating = false;

    @Override
    public SoundPlayer getSoundPlayer(NSURL url, SoundPlayer.Delegate delegate) throws Exception {
        InputStream stream = new URL(url.absoluteString()).openStream();
        return url.absoluteString().toLowerCase().endsWith(".mp3")
                ? new MP3SoundPlayer(stream, delegate)
                : new WAVSoundPlayer(stream, delegate);
    }

    @Override
    public void vibrate() {
        if (isVibrating)
            return;
        isVibrating = true;
        new Thread() {
            @Override
            public void run() {
                try {
                    SoundPlayer buzz = new MP3SoundPlayer(((DesktopFileBridge) Native.file()).getSystemFileStream("buzz.mp3"), null);
                    buzz.play();
                    Thread.sleep(50);
                } catch (Exception ex) {
                }
//                callback.shake();
                isVibrating = false;
            }
        }.start();
    }
}

class WAVSoundPlayer implements SoundPlayer {

    private final Clip clip;
    private final int channels;
    private boolean isPlaying = false;
    private long position = 0;

    private boolean pauseWasRequested = false;

    public WAVSoundPlayer(InputStream in, final Delegate delegate) throws Exception {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(in);
        channels = audioIn.getFormat().getChannels();
        clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.addLineListener((LineEvent event) -> {
            isPlaying = false;
            if (!pauseWasRequested && event.getType().equals(LineEvent.Type.STOP))
                delegate.finishSuccessful();
        });
    }

    @Override
    public boolean isPlaying() {
        return isPlaying;
    }

    @Override
    public boolean play() {
        clip.setMicrosecondPosition(position);
        clip.start();
        isPlaying = true;
        return true;
    }

    @Override
    public void pause() {
        pauseWasRequested = true;
        position = clip.getMicrosecondPosition();
        clip.stop();
        pauseWasRequested = false;
    }

    @Override
    public int getChannels() {
        return channels;
    }

    @Override
    public double getDuration() {
        return clip.getMicrosecondLength() / 1000000d;
    }

    @Override
    public void setLocation(double time) {
        clip.setMicrosecondPosition((long) (time * 1000000));
    }

    @Override
    public double getLocation() {
        return clip.getMicrosecondPosition() / 1000000d;
    }

    @Override
    public void setVolume(float volume) {
        ((FloatControl) clip.getControl(FloatControl.Type.VOLUME)).setValue(volume);
    }

    @Override
    public float getVolume() {
        return ((FloatControl) clip.getControl(FloatControl.Type.VOLUME)).getValue();
    }

}

class MP3SoundPlayer implements SoundPlayer {

    private JavaSoundAudioDevice audio;
    private final Bitstream bitstream;
    private final Decoder decoder;
    //
    private final Delegate delegate;
    private boolean isPlaying = false;
    private boolean isClosed = false;
    private final int channels = -1;
    private final long byteslength = -1;
    private final double duration = -1;
    private final double location = -1;

    private static Field sourceField;

    static {
        try {
            sourceField = JavaSoundAudioDevice.class.getDeclaredField("source");
            sourceField.setAccessible(true);
        } catch (Exception ex) {
        }
    }

    MP3SoundPlayer(InputStream in, Delegate delegate) throws Exception {
        this.delegate = delegate;
        bitstream = new Bitstream(in);
        audio = new JavaSoundAudioDevice();
        audio.open(decoder = new Decoder());
    }

    @Override
    public boolean play() {
        new Thread() {
            @Override
            public void run() {
                try {
                    boolean status = true;
                    isPlaying = true;

                    while (status && isPlaying)
                        status = doDecodeFrame();
                    if (audio != null) {
                        audio.flush();
                        synchronized (MP3SoundPlayer.this) {
                            doClose();
                        }
                    }
                    isPlaying = false;

                    if (delegate != null)
                        delegate.finishSuccessful();
                } catch (Exception e) {
                    if (delegate != null)
                        delegate.finishWithError(e);
                }
            }
        }.start();
        return true;
    }

    private boolean doDecodeFrame() throws Exception {
        synchronized (this) {
            if (audio == null)
                return false;
            // TODO: use header to grab stream information (such as total duration) - see BasicPlayer and Java plugin
            Header h = bitstream.readFrame();
            if (h == null)
                return false;
            SampleBuffer output = (SampleBuffer) decoder.decodeFrame(h, bitstream);
            audio.write(output.getBuffer(), 0, output.getBufferLength());
        }
        bitstream.closeFrame();
        return true;
    }

    private synchronized void doClose() {
        AudioDevice out = audio;
        if (out != null) {
            isClosed = true;
            audio = null;
            // this may fail, so ensure object state is set up before
            // calling this method.
            out.close();
            try {
                bitstream.close();
            } catch (BitstreamException ex) {
            }
        }
    }

    @Override
    public boolean isPlaying() {
        return isPlaying;
    }

    @Override
    public void pause() {
        isPlaying = false;
    }

    @Override
    public int getChannels() {
        return channels;
    }

    @Override
    public double getDuration() {
        return duration;
    }

    @Override
    public void setLocation(double time) {
        if (time < 0)
            time = 0;
        if (time > duration)
            time = duration;
//            player.seek((long) (byteslength * time / duration));
    }

    @Override
    public double getLocation() {
        return location;
    }

    @Override
    public void setVolume(float volume) {
        getVolumeControl().setValue(volume);
    }

    @Override
    public float getVolume() {
        return getVolumeControl().getValue();
    }

    private double getTimeLengthEstimation(Map properties) {
        double length = -1;
        int bitspersample = -1;
        float samplerate = -1.0f;
        int framesize = -1;
        // DURATION
        if (properties.containsKey("audio.samplesize.bits"))
            bitspersample = (int) properties.get("audio.samplesize.bits");
        if (properties.containsKey("audio.samplerate.hz"))
            samplerate = (float) properties.get("audio.samplerate.hz");
        if (properties.containsKey("audio.framesize.bytes"))
            framesize = (int) properties.get("audio.framesize.bytes");
        if (bitspersample > 0)
            length = (double) byteslength / (samplerate * channels * (bitspersample / 8));
        else
            length = (double) byteslength / (samplerate * framesize);
        return length;
    }

    private FloatControl getVolumeControl() {
        if (sourceField != null)
            try {
                return (FloatControl) ((SourceDataLine) sourceField.get(audio)).getControl(FloatControl.Type.VOLUME);
            } catch (Exception ex) {
            }
        return null;
    }

}
