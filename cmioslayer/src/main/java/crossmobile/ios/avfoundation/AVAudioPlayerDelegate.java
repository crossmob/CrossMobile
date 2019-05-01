/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
    public void didFinishPlaying(AVAudioPlayer avap, boolean bln);

    /**
     * It is called when the AVAudioPlayer encounters an error.
     *
     * @param avap The AVAudioPlayer that corresponds to this delegate.
     * @param nse  The error that occurred.
     */
    @CMSelector("- (void)audioPlayerDecodeErrorDidOccur:(AVAudioPlayer *)player \n"
            + "                                 error:(NSError *)error;")
    public void decodeErrorDidOccur(AVAudioPlayer avap, NSError nse);

    /**
     * It is called when the AVAudioPlayer is interrupted.
     *
     * @param avap The AVAudioPlayer that corresponds to this delegate.
     */
    @CMSelector("- (void)audioPlayerBeginInterruption:(AVAudioPlayer *)player;")
    public void beginInterruption(AVAudioPlayer avap);

    /**
     * It is called after the audio session interruption ends.
     *
     * @param avap The AVAudioPlayer that corresponds to this delegate.
     */
    @CMSelector("- (void)audioPlayerEndInterruption:(AVAudioPlayer *)player;")
    public void endInterruption(AVAudioPlayer avap);
}
