/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * NSFileHandle class defines an object that is used in order to handle file
 * descriptors.
 */
@CMClass
public class NSFileHandle extends NSObject {

    private final FileChannel channel;

    /**
     * Returns the NSFileHandle of the standard input file.
     *
     * @return The NSFileHandle of the standard input file.
     */
    @CMSelector("+ (NSFileHandle *)fileHandleWithStandardInput;")
    public static NSFileHandle fileHandleWithStandardInput() {
        return new NSFileHandle(null);
    }

    /**
     * Returns the NSFileHandle of the standard output file.
     *
     * @return The NSFileHandle of the standard output file.
     */
    @CMSelector("+ (NSFileHandle *)fileHandleWithStandardOutput;")
    public static NSFileHandle fileHandleWithStandardOutput() {
        return new NSFileHandle(null);
    }

    /**
     * Returns the NSFileHandle of the standard error file.
     *
     * @return The NSFileHandle of the standard error file.
     */
    @CMSelector("+ (NSFileHandle *)fileHandleWithStandardError;")
    public static NSFileHandle fileHandleWithStandardError() {
        return new NSFileHandle(null);
    }

    /**
     * Returns the NSFileHandle of the null device.
     *
     * @return The NSFileHandle of the null device.
     */
    @CMSelector("+ (NSFileHandle *)fileHandleWithNullDevice;")
    public static NSFileHandle fileHandleWithNullDevice() {
        return new NSFileHandle(null);
    }

    /**
     * Returns a NSFileHandle used for reading the data of the object at the
     * specified path.
     *
     * @param path The path of the data object.
     * @return The NSFileHandle used for reading the data of the object at the
     * specified path.
     */
    @CMSelector("+ (instancetype)fileHandleForReadingAtPath:(NSString *)path;")
    public static NSFileHandle fileHandleForReadingAtPath(String path) {
        try {
            return new NSFileHandle(new FileInputStream(path).getChannel());
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    /**
     * Returns a NSFileHandle used for writing the data of the object at the
     * specified path.
     *
     * @param path The path of the data object.
     * @return The NSFileHandle used for writing the data of the object at the
     * specified path.
     */
    @CMSelector("+ (instancetype)fileHandleForWritingAtPath:(NSString *)path;")
    public static NSFileHandle fileHandleForWritingAtPath(String path) {
        try {
            return new NSFileHandle(new FileOutputStream(path).getChannel());
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    /**
     * Returns a NSFileHandle used for reading and writing the data of the
     * object at the specified path.
     *
     * @param path The path of the data object.
     * @return The NSFileHandle used for reading and writing the data of the
     * object at the specified path.
     */
    @CMSelector("+ (instancetype)fileHandleForUpdatingAtPath:(NSString *)path;")
    public static NSFileHandle fileHandleForUpdatingAtPath(String path) {
        try {
            return new NSFileHandle(new RandomAccessFile(path, "rw").getChannel());
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    /**
     * Returns a NSFileHandle used for reading the data of the object at the
     * specified URL.
     *
     * @param url   The URL of the data object.
     * @param error The error returned in case of failure.
     * @return The NSFileHandle used for reading the data of the object at the
     * specified URL.
     */
    @CMSelector("+ (instancetype)fileHandleForReadingFromURL:(NSURL *)url \n"
            + "                                      error:(NSError * _Nullable *)error;")
    public static NSFileHandle fileHandleForReadingFromURL(NSURL url, StrongReference<NSError> error) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns a NSFileHandle used for writing the data of the object at the
     * specified URL.
     *
     * @param url   The URL of the data object.
     * @param error The error returned in case of failure.
     * @return The NSFileHandle used for writing the data of the object at the
     * specified URL.
     */
    @CMSelector("+ (instancetype)fileHandleForWritingToURL:(NSURL *)url \n"
            + "                                    error:(NSError * _Nullable *)error;")
    public static NSFileHandle fileHandleForWritingToURL(NSURL url, StrongReference<NSError> error) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns a NSFileHandle used for reading and writing the data of the
     * object at the specified URL.
     *
     * @param url   The URL of the data object.
     * @param error The error returned in case of failure.
     * @return The NSFileHandle used for reading and writing the data of the
     * object at the specified URL.
     */
    @CMSelector("+ (instancetype)fileHandleForUpdatingURL:(NSURL *)url \n"
            + "                                   error:(NSError * _Nullable *)error;")
    public static NSFileHandle fileHandleForUpdatingURL(NSURL url, StrongReference<NSError> error) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Creates a NSFileHandle object for the specified file descriptor with the
     * option of controlling the closing of it.
     *
     * @param fd       The file descriptor of the NSFileHandle.
     * @param closeopt TRUE, then the NSFileHandle is responsible for closing
     *                 it.
     */
    @CMConstructor("- (instancetype)initWithFileDescriptor:(int)fd \n"
            + "                        closeOnDealloc:(BOOL)closeopt;")
    public NSFileHandle(int fd, boolean closeopt) {
        this(null);
    }

    /**
     * Creates a NSFileHandle object for the specified file descriptor.
     *
     * @param fd The file descriptor of the NSFileHandle.
     */
    @CMConstructor("- (instancetype)initWithFileDescriptor:(int)fd;")
    public NSFileHandle(int fd) {
        this(null);
    }

    NSFileHandle(FileChannel channel) {
        this.channel = channel;
    }

    /**
     * Returns the current data of this NSFileHandle.
     *
     * @return The current data of this NSFileHandle.
     */
    @CMGetter("@property(readonly, copy) NSData *availableData;")
    public NSData availableData() {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Reads the data of this NSFileHandle Synchronously reads the available
     * data up to the end of file or maximum number of bytes.
     *
     * @return The data of the NSFileHandle.
     */
    @CMSelector("- (NSData *)readDataToEndOfFile;")
    public NSData readDataToEndOfFile() {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Reads the specified length of data of this NSFileHandle.
     *
     * @param length The number of bytes to read.
     * @return The data of the NSFileHandle.
     */
    @CMSelector("- (NSData *)readDataOfLength:(NSUInteger)length;")
    public NSData readDataOfLength(int length) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Writes the specified data to this NSFileHandler.
     *
     * @param data The data to be written.
     */
    @CMSelector("- (void)writeData:(NSData *)data;")
    public void writeData(NSData data) {
        try {
            channel.write(ByteBuffer.wrap(data.data));
        } catch (IOException ignore) {
        }
    }

    /**
     * Returns the file pointer's position for the file of this NSFileHandle.
     *
     * @return The file pointer's position for the file of this NSFileHandle.
     */
    @CMGetter("@property(readonly) unsigned long long offsetInFile;")
    public long offsetInFile() {
        Native.system().notImplemented();
        return 0;
    }

    /**
     * Places the file pointer at the end of the file for this NSFileHandle.
     *
     * @return The new file offset.
     */
    @CMSelector("- (unsigned long long)seekToEndOfFile;")
    public long seekToEndOfFile() {
        try {
            long size = channel.size();
            seekToFileOffset(size);
            return size;
        } catch (IOException ex) {
            return 0;
        }
    }

    /**
     * Places the file pointer at the specified offset of the file for this
     * NSFileHandle.
     *
     * @param offset The offset of the file.
     */
    @CMSelector("- (void)seekToFileOffset:(unsigned long long)offset;")
    public void seekToFileOffset(long offset) {
        try {
            channel.position(channel.size() - 1);
        } catch (IOException ignore) {
        }
    }

    /**
     * Trims or extends the file of this NSFileHandle according to the specified
     * offset.
     *
     * @param offset The offset that specifies the new end of file.
     */
    @CMSelector("- (void)truncateFileAtOffset:(unsigned long long)offset;")
    public void truncateFileAtOffset(long offset) {
        Native.system().notImplemented();
    }

    /**
     * Stores permanently all the data of the file of this NSFileHandle.
     */
    @CMSelector("- (void)synchronizeFile;")
    public void synchronizeFile() {
        Native.system().notImplemented();
    }

    /**
     * Changes the permissions of the file of this NSFileHandle to readonly.
     */
    @CMSelector("- (void)closeFile;")
    public void closeFile() {
        try {
            channel.close();
        } catch (IOException ignore) {
        }
    }

    /**
     * Reads the file of this NSFileHandle in the background and notifies when
     * it ends.
     *
     * @param modes The modes of the runloop in which the notification of the
     *              read completion can be posted.
     */
    @CMSelector("- (void)readInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;")
    public void readInBackgroundAndNotifyForModes(List modes) {
        Native.system().notImplemented();
    }

    /**
     * Reads the file of this NSFileHandle in the background and notifies when
     * it ends.
     */
    @CMSelector("- (void)readInBackgroundAndNotify;\n"
            + "")
    public void readInBackgroundAndNotify() {
        Native.system().notImplemented();
    }

    /**
     * Reads the file of this NSFileHandle to the end, in the background and
     * notifies when it ends.
     *
     * @param modes The modes of the runloop in which the notification of the
     *              read completion can be posted.
     */
    @CMSelector("- (void)readToEndOfFileInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;")
    public void readToEndOfFileInBackgroundAndNotifyForModes(List modes) {
        Native.system().notImplemented();
    }

    /**
     * Reads the file of this NSFileHandle to the end, in the background and
     * notifies when it ends.
     */
    @CMSelector("- (void)readToEndOfFileInBackgroundAndNotify;\n"
            + "")
    public void readToEndOfFileInBackgroundAndNotify() {
        Native.system().notImplemented();
    }

    /**
     * Accepts a socket connection in the background.
     *
     * @param modes The modes of the runloop in which the notification of the
     *              connection acceptance notification can be posted.
     */
    @CMSelector("- (void)acceptConnectionInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;")
    public void acceptConnectionInBackgroundAndNotifyForModes(List modes) {
        Native.system().notImplemented();
    }

    /**
     * Accepts a socket connection in the background.
     */
    @CMSelector("- (void)acceptConnectionInBackgroundAndNotify;")
    public void acceptConnectionInBackgroundAndNotify() {
        Native.system().notImplemented();
    }

    /**
     * Checks whether data is available.
     *
     * @param modes The modes of the runloop in which the notification data
     *              availability can be posted.
     */
    @CMSelector("- (void)waitForDataInBackgroundAndNotifyForModes:(NSArray<NSString *> *)modes;")
    public void waitForDataInBackgroundAndNotifyForModes(List modes) {
        Native.system().notImplemented();
    }

    /**
     * Checks asynchronously if data is available.
     */
    @CMSelector("- (void)waitForDataInBackgroundAndNotify;\n"
            + "")
    public void waitForDataInBackgroundAndNotify() {
        Native.system().notImplemented();
    }

    /**
     * Returns the file descriptor of this NSFileHandle.
     *
     * @return The file descriptor of this NSFileHandle.
     */
    @CMGetter("@property(readonly) int fileDescriptor;")
    public int fileDescriptor() {
        Native.system().notImplemented();
        return 0;
    }
}
