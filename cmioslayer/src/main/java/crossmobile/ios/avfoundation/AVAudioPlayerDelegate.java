/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package crossmobile.ios.avfoundation;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * AVAudioPlayerDelegate interface is the delegate that cooperates with the
 * AVAudioPlayer objects.
 */
@CMClass
public interface AVAudioPlayerDelegate {

    /**
     * It is called when the AVAudioPlayer finished playing.
     *
     * @param avap The AVAudioPlayer that corresponds to this delegate.
     * @param bln  TRUE then the operation was successful.
     */
    @CMSelector("- (void)audioPlayerDidFinishPlaying:(AVAudioPlayer *)player \n"
            + "                       successfully:(BOOL)flag;")
    void didFinishPlaying(AVAudioPlayer avap, boolean bln);

    /**
     * It is called when the AVAudioPlayer encounters an error.
     *
     * @param avap  The AVAudioPlayer that corresponds to this delegate.
     * @param error The error that occurred.
     */
    @CMSelector("- (void)audioPlayerDecodeErrorDidOccur:(AVAudioPlayer *)player \n"
            + "                                 error:(NSError *)error;")
    void decodeErrorDidOccur(AVAudioPlayer avap, NSError error);

    /**
     * It is called when the AVAudioPlayer is interrupted.
     *
     * @param avap The AVAudioPlayer that corresponds to this delegate.
     */
    @CMSelector("- (void)audioPlayerBeginInterruption:(AVAudioPlayer *)player;")
    void beginInterruption(AVAudioPlayer avap);

    /**
     * It is called after the audio session interruption ends.
     *
     * @param avap The AVAudioPlayer that corresponds to this delegate.
     */
    @CMSelector("- (void)audioPlayerEndInterruption:(AVAudioPlayer *)player;")
    void endInterruption(AVAudioPlayer avap);
}
