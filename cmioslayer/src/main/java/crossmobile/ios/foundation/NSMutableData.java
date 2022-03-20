/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bind.system.StreamConverter;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMJoinMEM;
import org.crossmobile.bridge.ann.CMSelector;

import java.io.IOException;
import java.net.URL;

/**
 * NSMutableData class defines mutable data objects that are used by the
 * application as data storage.
 */
@CMClass
public class NSMutableData extends NSData {

    private NSMutableData(byte[] data) {
        super(data);
    }

    /**
     * Constructs a NSMutableData object of the specified size.
     *
     * @param size The size of the new NSMutableData object.
     */
    @CMConstructor("- (instancetype)initWithLength:(NSUInteger)length")
    public NSMutableData(int size) {
        super(new byte[size]);
    }

    /**
     * Constructs and returns a NSMutableData object with the specified bytes of
     * data copied from the buffer.
     *
     * @param data The bytes of the buffer.
     * @return The new NSMutableData object, NULL if the object could not be
     * created.
     */
    @CMSelector("+ (instancetype)dataWithBytes:(const void *)bytes\n"
            + "                       length:(NSUInteger)length")
    public static NSMutableData dataWithBytes(@CMJoinMEM(memory = "bytes", size = "length") byte[] data) {
        return new NSMutableData(contentsOfCopyBytes(data, -1));
    }

    /**
     * Constructs and returns an NSMutableData object with the specified bytes
     * of data from the buffer.
     *
     * @param data The bytes of the buffer.
     * @return The new NSMutableData object, NULL if the object could not be
     * created.
     */
    @CMSelector("+ (instancetype)dataWithBytesNoCopy:(void *)bytes\n"
            + "                             length:(NSUInteger)length")
    public static NSMutableData dataWithBytesNoCopy(@CMJoinMEM(memory = "bytes", size = "length") byte[] data) {
        return new NSMutableData(checkDataSize(data, data == null ? 0 : data.length));
    }

    /**
     * Constructs and returns a NSMutableData object with the data of the
     * specified file path.
     *
     * @param path The file that contains the data of the new object.
     * @return The new NSMutableData object, NULL if the object could not be
     * created.
     */
    @CMSelector("+ (instancetype)dataWithContentsOfFile:(NSString *)path")
    public static NSMutableData dataWithContentsOfFile(String path) {
        try {
            if (path != null)
                return new NSMutableData(StreamConverter.toBytes(Native.file().getFileStream(path)));
        } catch (IOException ex) {
        }
        return null;
    }

    /**
     * Constructs and returns a NSMutableData object with the data of the
     * specified URL.
     *
     * @param url The URL that has the data of the new object.
     * @return The new NSMutableData object, NULL if the object could not be
     * created.
     */
    @CMSelector("+ (instancetype)dataWithContentsOfURL:(NSURL *)aURL")
    public static NSMutableData dataWithContentsOfURL(NSURL url) {
        try {
            if (url != null)
                return new NSMutableData(StreamConverter.toBytes(new URL(url.absoluteString()).openStream()));
        } catch (IOException ex) {
        }
        return null;
    }

    /**
     * Attaches the specified data of the buffer to this object.
     *
     * @param bytes The data of the buffer to attach to this object.
     */
    @CMSelector("- (void)appendBytes:(const void *)bytes \n"
            + "             length:(NSUInteger)length;")
    public void appendBytes(@CMJoinMEM(memory = "bytes", size = "length") byte[] bytes) {
        if (bytes == null || bytes.length < 1)
            return;

        byte[] newdata = new byte[data.length + bytes.length];
        System.arraycopy(data, 0, newdata, 0, data.length);
        System.arraycopy(bytes, 0, newdata, data.length, bytes.length);
        data = newdata;
    }

    /**
     * Attaches the specified data to this object.
     *
     * @param data The data to attach to this object.
     */
    @CMSelector("- (void)appendData:(NSData *)other;\n"
            + "")
    public void appendData(NSData data) {
        appendBytes(data.data);
    }

    /**
     * Replaces the data of this object with the given data.
     *
     * @param data The new data of this object.
     */
    @CMSelector("- (void)setData:(NSData *)data;")
    public void setData(NSData data) {
        this.data = new byte[data.data.length];
        System.arraycopy(data.data, 0, this.data, 0, data.data.length);
    }
}
