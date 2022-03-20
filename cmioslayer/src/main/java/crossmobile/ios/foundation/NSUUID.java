/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.UUID;

/**
 * NSUUID class defines UUID strings that provide unique identification of items
 * used within the application.
 */
@CMClass
public class NSUUID extends NSObject {

    final byte[] bytes;

    /**
     * Creates and returns a new NSUUID object.
     *
     * @return A new NSUUID object.
     */
    @CMSelector("+ (instancetype)UUID;")
    public static NSUUID UUID() {
        return new NSUUID(UUID.randomUUID().toString());
    }

    /**
     * Creates and returns a new NSUUID for the specified bytes.
     *
     * @param bytes The bytes used for the new NSUUID object.
     */
    @CMConstructor("- (instancetype)initWithUUIDBytes:(const uuid_t)bytes;")
    public NSUUID(byte[] bytes) {
        if (bytes != null && bytes.length == 16)
            this.bytes = bytes;
        else {
            this.bytes = new byte[16];
            if (bytes != null)
                System.arraycopy(bytes, 0, this.bytes, 0, Math.min(bytes.length, this.bytes.length));
        }
    }

    /**
     * Creates and returns a new NSUUID for the specified String.
     *
     * @param id The String used for the new NSUUID object.
     */
    @CMConstructor("- (instancetype)initWithUUIDString:(NSString *)string;")
    public NSUUID(String id) {
        this(stringToBytes(id));
    }

    /**
     * This NSUUID object as a String.
     *
     * @return The String of this NSUUID.
     */
    @CMGetter("@property(readonly, copy) NSString *UUIDString;")
    public String UUIDString() {
        String raw = SystemUtilities.bytesToHex(bytes);
        return raw.substring(0, 8) + "-" + raw.substring(8, 12) + "-" + raw.substring(12, 16) + "-" + raw.substring(16, 20) + "-" + raw.substring(20);
    }

    /**
     * Returns the bytes of this NSUUID.
     *
     * @param buffer The buffer of this NSUUID.
     */
    @CMSelector("- (void)getUUIDBytes:(uuid_t)uuid;")
    public void getUUIDBytes(byte[] buffer) {
        if (buffer != null && buffer.length > 0)
            System.arraycopy(bytes, 0, buffer, 0, Math.min(bytes.length, buffer.length));
    }

    private static byte[] stringToBytes(String id) {
        String cleanid = id.toLowerCase().replaceAll("[-\\s]", "");
        if (!cleanid.replaceAll("[0123456789abcdef]", "").isEmpty())
            throw new RuntimeException("Unable to create an NSUUID from " + id);
        if (cleanid.length() > 32)
            cleanid = cleanid.substring(0, 32);
        else if (cleanid.length() < 32)
            cleanid = cleanid + "00000000000000000000000000000000".substring(0, 32 - cleanid.length());
        return SystemUtilities.hexToBytes(cleanid);
    }
}
