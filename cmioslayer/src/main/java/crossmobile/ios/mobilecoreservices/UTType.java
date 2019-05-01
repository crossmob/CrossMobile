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
package crossmobile.ios.mobilecoreservices;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UTType class defines different uniform type identifiers for graphic, audio
 * and video content.
 */
@CMEnum
public final class UTType {

    /**
     * The string that is used to identify image data.
     */
    public static final String Image = "public.image";

    /**
     * The string that is used to identify JPEG images.
     */
    public static final String JPEG = "public.jpeg";

    /**
     * The string that is used to identify JPEG-2000 images.
     */
    public static final String JPEG2000 = "public.jpeg-2000";

    /**
     * The string that is used to identify TIFF images.
     */
    public static final String TIFF = "public.tiff";

    /**
     * The string that is used to identify Quickdraw PICT.
     */
    public static final String PICT = "com.apple.pict";

    /**
     * The string that is used to identify GIF images.
     */
    public static final String GIF = "com.compuserve.gif";

    /**
     * The string that is used to identify PNG images.
     */
    public static final String PNG = "public.png";

    /**
     * The string that is used to identify QuickTime images.
     */
    public static final String QuickTimeImage = "com.apple.quicktime-image";

    /**
     * The string that is used to identify Apple's icon data.
     */
    public static final String AppleICNS = "com.apple.icns";

    /**
     * The string that is used to identify Windows bitmap.
     */
    public static final String BMP = "com.microsoft.bmp";

    /**
     * The string that is used to identify Windows icon data.
     */
    public static final String ICO = "com.microsoft.ico";
//
    /**
     * The string that is used to identify audio and/or video content.
     */
    public static final String AudiovisualContent = "public.audiovisual-content";

    /**
     * The string that is used to identify media that contains both video and
     * audio.
     */
    public static final String Movie = "public.movie";

    /**
     * The string that is used to identify pure video data.
     */
    public static final String Video = "public.video";

    /**
     * The string that is used to identify pure audio data.
     */
    public static final String Audio = "public.audio";

    /**
     * The string that is used to identify QuickTime movies.
     */
    public static final String QuickTimeMovie = "com.apple.quicktime-movie";

    /**
     * The string that is used to identify MPEG-1 or MPEG-2 movies.
     */
    public static final String MPEG = "public.mpeg";

    /**
     * The string that is used to identify MPEG-4 movies.
     */
    public static final String MPEG4 = "public.mpeg-4";

    /**
     * The string that is used to identify MP3 audio.
     */
    public static final String MP3 = "public.mp3";

    /**
     * The string that is used to identify MPEG-4 audio layer.
     */
    public static final String MPEG4Audio = "public.mpeg-4-audio";

    /**
     * The string that is used to identify Apple's protected MPEG4 format.
     */
    public static final String AppleProtectedMPEG4Audio = "com.apple.protected-mpeg-4-audio";

    private UTType() {
    }
}
