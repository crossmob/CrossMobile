/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;
import org.crossmobile.support.MiGBase64;

import java.io.IOException;
import java.io.InputStream;

/**
 * NSData class defines a data object that is created using data from a buffer
 * or from files.
 */
@CMClass
public class NSData extends NSObject implements NSSecureCoding {

    private static char[] HEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    byte[] data;

    NSData(byte[] data) {
        this.data = data == null ? new byte[0] : data;
    }

    /**
     * Creates and returns the NSData object of the given base64 encoded String
     * with the specified options.
     *
     * @param base64String                The base64 encoded String.
     * @param NSDataBase64DecodingOptions The options of the encoding.
     */
    @CMConstructor("- (instancetype)initWithBase64EncodedString:(NSString *)base64String \n"
            + "                                    options:(NSDataBase64DecodingOptions)options;")
    public NSData(String base64String, int NSDataBase64DecodingOptions) {
        this(MiGBase64.decode(base64String));
    }

    /**
     * Creates and returns a NSData object using copied data from a buffer.
     *
     * @param data The data of buffer.
     * @return The resulting NSData object.
     */
    @CMSelector("+ (instancetype)dataWithBytes:(const void *)bytes\n"
            + "                       length:(NSUInteger)length")
    public static NSData dataWithBytes(@CMJoinMEM(memory = "bytes", size = "length") byte[] data) {
        return dataWithBytes(data, data == null ? 0 : data.length);
    }

    static NSData dataWithBytes(@CMJoinMEM(memory = "bytes", size = "length") byte[] data, int length) {
        return new NSData(contentsOfCopyBytes(data, length));
    }

    /**
     * Creates and returns a NSData object generated from the bytes of a buffer.
     *
     * @param data The data of buffer.
     * @return The resulting NSData object.
     */
    @CMSelector("+ (instancetype)dataWithBytesNoCopy:(void *)bytes\n"
            + "                             length:(NSUInteger)length")
    public static NSData dataWithBytesNoCopy(@CMJoinMEM(memory = "bytes", size = "length") byte[] data) {
        return new NSData(checkDataSize(data, data == null ? 0 : data.length));
    }

    /**
     * Creates and returns a NSData object from the data of the specified file.
     *
     * @param path The path of the file that is used.
     * @return The NSData object of the specified file.
     */
    @CMSelector("+ (instancetype)dataWithContentsOfFile:(NSString *)path;")
    public static NSData dataWithContentsOfFile(String path) {
        try {
            if (path != null)
                return new NSData(contentsOfStream(Native.file().getFileStream(path)));
        } catch (IOException ex) {
        }
        return null;
    }

    /**
     * Returns a NSData object that contains the data of the given URL.
     *
     * @param url The URL of the requested data.
     * @return The NSData object of the URL.
     */
    @CMSelector("+ (instancetype)dataWithContentsOfURL:(NSURL *)url;")
    public static NSData dataWithContentsOfURL(NSURL url) {
        return url == null
                ? null
                : NSURLConnection.sendSynchronousRequest(NSURLRequest.requestWithURL(url), null, null);
    }

    static byte[] contentsOfStream(InputStream inputstream) {
        DataChunk head = null;
        DataChunk queue = null;
        DataChunk current;
        if (inputstream != null) {
            do {
                current = new DataChunk(inputstream);
                if (current.isValid()) {
                    if (queue != null)
                        queue.next = current;
                    else
                        head = current;
                    queue = current;
                }
            } while (current.isValid());
            if (head != null)
                return head.consumeBytes();
            else
                return null;
        } else
            return null;
    }

    static byte[] contentsOfCopyBytes(byte[] data, int length) {
        data = checkDataSize(data, length);
        byte[] result = new byte[length];
        System.arraycopy(data, 0, result, 0, length);
        return result;
    }

    static byte[] checkDataSize(byte[] data, int length) {
        if (data == null)
            data = new byte[0];
        if (length > data.length || length < 0)
            throw new IllegalArgumentException("Requested to copy " + length + " byte" + (length == 1 ? "" : "s") +
                    " in an array of " + data.length + " byte" + (data.length == 1 ? "" : "s"));
        return data;
    }

    /**
     * Writes the bytes of this NSData to the specified file with the option of
     * writing first to a backup file.
     *
     * @param path       The path of the file to which the bytes will be written.
     * @param atomically TRUE then the bytes are first written to a backup file.
     * @return TRUE the procedure was successful.
     */
    @CMSelector("- (BOOL)writeToFile:(NSString *)path \n"
            + "         atomically:(BOOL)useAuxiliaryFile;")
    public boolean writeToFile(String path, boolean atomically) {
        return SystemUtilities.writeToFile(path, data);
    }

    /**
     * Returns the length of this NSData object.
     *
     * @return The length of this NSData object.
     */
    @CMGetter("@property(readonly) NSUInteger length;")
    public int length() {
        return data.length;
    }

    /**
     * Returns a pointer to this NSData object.
     *
     * @return A pointer to this NSData object.
     */
    @CMGetter(value = "@property(readonly) const void *bytes;", sizeResolver = "[self length]")
    public byte[] bytes() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (i % 8 == 0) {
                if (i != 0)
                    out.append("> ");
                out.append("<");
            } else
                out.append(' ');
            byte a = data[i];
            if ((a & 0xF0) == 0)
                out.append('0');
            else
                out.append(HEX[(a & 0xF0) >>> 4]);
            out.append(HEX[a & 0xF]);
        }
        if (data.length == 0)
            out.append('<');
        out.append('>');
        return out.toString();
    }

    /**
     * Creates a base64 encoded String according to the specified options.
     *
     * @param NSDataBase64EncodingOptions The options for the specified
     *                                    encoding.
     * @return The base64 encoded string.
     */
    @CMSelector("- (NSString *)base64EncodedStringWithOptions:(NSDataBase64EncodingOptions)options;")
    public String base64EncodedStringWithOptions(int NSDataBase64EncodingOptions) {
        return MiGBase64.encodeToString(data, true);
    }

    private static class DataChunk {

        private byte[] chunk = new byte[1000];
        private int size = -1;
        private DataChunk next = null;

        private DataChunk(InputStream in) {
            try {
                size = in.read(chunk);
            } catch (IOException ex) {
            }
        }

        private byte[] consumeBytes() {
            DataChunk current = this;
            int total = 0;
            // Calculate data size
            while (current != null) {
                total += current.size;
                current = current.next;
            }
            if (total < 1)
                return null;

            // reconstruct array
            byte[] res = new byte[total];
            int loc = 0;
            current = this;
            while (current != null) {
                System.arraycopy(current.chunk, 0, res, loc, current.size);
                current.chunk = null;

                loc += current.size;
                current.size = 0;

                DataChunk cnext = current.next;
                current.next = null;
                current = cnext;
            }
            return res;
        }

        private boolean isValid() {
            return size >= 0;
        }
    }
}
