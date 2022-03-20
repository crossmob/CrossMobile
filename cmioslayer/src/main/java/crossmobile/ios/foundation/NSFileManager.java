/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.crossmobile.bind.system.AbstractLifecycleBridge.errorFromThrowable;

/**
 * NSFileManager class defines an object that is responsible for processing
 * operations related to the file system such as locating creating,copying and
 * moving files.
 */
@CMClass
public class NSFileManager extends NSObject {

    private static final NSFileManager defaultMngr = new NSFileManager();

    private NSFileManager() {
    }

    /**
     * Constructs and returns the default instance of this class that is a
     * static reference to the singleton NSFileManger.
     *
     * @return The default instance of this class.
     */
    @CMSelector("+ (NSFileManager *)defaultManager;")
    public static NSFileManager defaultManager() {
        return defaultMngr;
    }

    /**
     * Returns a Boolean that shows whether the specified path is valid.
     *
     * @param path The path that is examined.
     * @return TRUE if the path is valid.
     */
    @CMSelector("- (BOOL)fileExistsAtPath:(NSString *)path;")
    public boolean fileExistsAtPath(String path) {
        return Native.file().fileExists(path);
    }

    /**
     * Creates a directory at the specified path with the specified parameters
     * values.
     *
     * @param path                The path of the directory.
     * @param createIntermediates TRUE creates the missing parent directories ,
     *                            FALSE it fails if parent directories are missing.
     * @param attributes          The file attributes of the directory.
     * @param error               The callback error
     * @return TRUE if the directory was successfully created.
     */
    @CMSelector("- (BOOL)createDirectoryAtPath:(NSString *)path \n"
            + "  withIntermediateDirectories:(BOOL)createIntermediates \n"
            + "                   attributes:(NSDictionary<NSString *,id> *)attributes \n"
            + "                        error:(NSError * _Nullable *)error;")
    public boolean createDirectoryAtPath(String path, boolean createIntermediates, Map<String, String> attributes, StrongReference<NSError> error) {
        if (createIntermediates)
            return new File(path).mkdirs();
        else
            return new File(path).mkdir();
    }

    /**
     * Returns a list of contents of the file at the specified path.
     *
     * @param path  The path of the file.
     * @param error The error returned in case of failure.
     * @return The list of contents of the file at the specified path.
     */
    @CMSelector("- (NSArray<NSString *> *)contentsOfDirectoryAtPath:(NSString *)path \n"
            + "                                             error:(NSError * _Nullable *)error;")
    public List<String> contentsOfDirectoryAtPath(String path, StrongReference<NSError> error) {
        File f = new File(path);
        if (!f.exists()) {
            if (error != null)
                error.set(NSError.errorWithDomain(NSError.Domain.NSCocoa, NSError.ErrorCode.NSFileNoSuchFileError, errorFromThrowable(new FileNotFoundException("Unable to locate file " + path))));
            return null;
        }
        if (!f.isDirectory()) {
            if (error != null)
                error.set(NSError.errorWithDomain(NSError.Domain.NSCocoa, NSError.ErrorCode.NSFileReadUnknownError, errorFromThrowable(new FileNotFoundException("Unable to locate file " + path))));
            return null;
        }
        List<String> files = new ArrayList<String>();
        files.addAll(Arrays.asList(new File(path).list()));
        if (error != null)
            error.set(null);
        return files;
    }
}
