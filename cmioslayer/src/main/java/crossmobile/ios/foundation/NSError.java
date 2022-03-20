/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.*;

import java.util.HashMap;
import java.util.Map;

/**
 * NSError class incorporates all the information related to errors.
 */
@CMClass(typeAlias = "CFError")
public class NSError extends NSObject implements NSSecureCoding {

    private final String domain;
    private final int code;
    private final Map<String, Object> userInfo;

    /**
     * Constructs and returns an NSError object for the specified error domain
     * and code.
     *
     * @param NSErrorDomain The error domain of the NSError.
     * @param code          The error code of the new NSError.
     * @param dict          The userInfo dictionary for the NSError.
     * @return An NSError object for domain with the specified error code and
     * the dictionary of arbitrary data userInfo.
     */
    @CMSelector("+ (instancetype)errorWithDomain:(NSString *)domain code:(NSInteger)code userInfo:(NSDictionary *)dict;")
    public static NSError errorWithDomain(String NSErrorDomain, int code, Map<String, Object> dict) {
        return new NSError(NSErrorDomain, code, dict);
    }

    /**
     * Constructs an NSError object with the specified error domain and code
     * with the given userInfo dictionary.
     *
     * @param NSErrorDomain The error domain of the NSError.
     * @param code          The error code of the new NSError.
     * @param dict          The userInfo dictionary for the NSError.
     */
    @CMConstructor("- (instancetype)initWithDomain:(NSString *)domain \n"
            + "                          code:(NSInteger)code \n"
            + "                      userInfo:(NSDictionary *)dict;")
    public NSError(String NSErrorDomain, int code, Map<String, Object> dict) {
        this.domain = NSErrorDomain;
        this.code = code;
        this.userInfo = dict == null ? new HashMap<>() : dict;
    }

    /**
     * Returns the error domain of this NSError object.
     *
     * @return The error domain of this NSError object.
     */
    @CMGetter("@property (readonly, copy) NSString *domain;")
    public String domain() {
        return domain;
    }

    /**
     * Returns the error code of this NSError object.
     *
     * @return The error code of this NSError object.
     */
    @CMGetter("@property(readonly) NSInteger code;")
    public int code() {
        return code;
    }

    /**
     * Returns the user info dictionary of this NSError object.
     *
     * @return The user info dictionary of this NSError object.
     */
    @CMGetter("@property(readonly, copy) NSDictionary *userInfo;")
    public Map<String, Object> userInfo() {
        return userInfo;
    }

    /**
     * Returns the localized description of this NSError.
     *
     * @return The localized description of this NSError.
     */
    @CMGetter("@property(readonly, copy) NSString *localizedDescription;")
    public String localizedDescription() {
        Object descr = userInfo.get(NSError.Key.NSLocalizedDescription);
        return descr == null ? "Error in domain " + domain : descr.toString();
    }

    @Override
    public String toString() {
        return localizedDescription();
    }

    /**
     * The error domains.
     */
    @CMEnum
    public final static class Domain {

        /**
         * Errors related to Application Kit and Foundation Kit.
         */
        public static final String NSCocoa = "NSCocoaErrorDomain";

        /**
         * URL loading system errors.
         */
        public static final String NSURL = "NSURLErrorDomain";

        /**
         * POSIX/BSD errors.
         */
        public static final String NSPOSIX = "NSPOSIXErrorDomain";

        /**
         * Mac OS 9/Carbon errors.
         */
        public static final String NSOSStatus = "NSOSStatusErrorDomain";

        /**
         * Mach errors.
         */
        public static final String NSMach = "NSMachErrorDomain";

        /**
         * Store Kit errors.
         */
        public static final String SKError = "SKErrorDomain";

        /**
         * Local Authentication errors
         */
        public static final String LAErrorDomain = "com.apple.LocalAuthentication";

        private Domain() {
        }
    }

    /**
     * Keys of the user info dictionary.
     */
    @CMEnum
    public final static class Key {

        /**
         * A localized string representation of the error.
         */
        public static final String NSLocalizedDescription = "NSLocalizedDescription";

        /**
         * The file path of the error.
         */
        public static final String NSFilePathError = "NSFilePath";

        /**
         * The associated value is an NSNumber object that contains the
         * NSStringEncoding value.
         */
        public static final String NSStringEncodingError = "NSStringEncoding";

        /**
         * The associated value is an error that was encountered in an
         * underlying implementation and caused this error.
         */
        public static final String NSUnderlyingError = "NSUnderlyingError";

        /**
         * The associated value is an NSURL object.
         */
        public static final String NSURLError = "NSURL";

        /**
         * The associated value is a localized string that contains the reason
         * of the failure.
         */
        public static final String NSLocalizedFailureReason = "NSLocalizedFailureReason";

        /**
         * The associated value is a string that contains the localized
         * suggestion to recover from the error.
         */
        public static final String NSLocalizedRecoverySuggestion = "NSLocalizedRecoverySuggestion";

        /**
         * The associated value is an array that contains the localized titles
         * for the buttons displayed in an alert panel.
         */
        public static final String NSLocalizedRecoveryOptions = "NSLocalizedRecoveryOptions";

        /**
         * The associated value is an object that corresponds to the
         * NSErrorRecoveryAttempting informal protocol.
         */
        public static final String NSRecoveryAttempter = "NSRecoveryAttempter";

        /**
         * The associated value is an NSString that contains localized help.
         */
        public static final String NSHelpAnchor = "NSHelpAnchor";

        /**
         * The associated value is an NSURL containing the URL of the load
         * failure.
         */
        public static final String NSURLErrorFailingURL = "NSErrorFailingURLKey";

        /**
         * The associated value is an NSString object for the URL of the load
         * failure.
         */
        public static final String NSURLErrorFailingURLString = "NSErrorFailingURLStringKey";

        /**
         * Represents the state of a failed SSL handshake.
         */
        public static final String NSURLErrorFailingURLPeerTrust = "NSURLErrorFailingURLPeerTrustErrorKey";

        private Key() {
        }
    }

    /**
     * Different types of error codes.
     */
    @CMEnum
    public final static class ErrorCode {

        private ErrorCode() {
        }

        /**
         * It is returned after a file-system operation attempted on a file that
         * does not exist.
         */
        public static final int NSFileNoSuchFileError = 4;

        /**
         * It is returned after a failure to get a lock on file.
         */
        public static final int NSFileLockingError = 255;

        /**
         * It is returned after a failure to read a file due to unknown reason.
         */
        public static final int NSFileReadUnknownError = 256;

        /**
         * It is returned after a failure to read a file due to permission
         * problem.
         */
        public static final int NSFileReadNoPermissionError = 257;

        /**
         * It is returned after a failure to read a file with an invalid name.
         */
        public static final int NSFileReadInvalidFileNameError = 258;

        /**
         * It is returned after a failure to read a file that was corrupted.
         */
        public static final int NSFileReadCorruptFileError = 259;

        /**
         * It is returned after a failure to read a file that could not be
         * found.
         */
        public static final int NSFileReadNoSuchFileError = 260;

        /**
         * It is returned after a failure to read due to not applicable string
         * encoding.
         */
        public static final int NSFileReadInapplicableStringEncodingError = 261;

        /**
         * It is returned after a failure to read due to unsupported URL scheme.
         */
        public static final int NSFileReadUnsupportedSchemeError = 262;

        /**
         * It is returned after an attempt to read a file that was too large.
         */
        public static final int NSFileReadTooLargeError = 263;

        /**
         * It is returned after attempt to read a file with a undetermined
         * string coding.
         */
        public static final int NSFileReadUnknownStringEncodingError = 264;

        /**
         * It is returned after a failure to write caused by unknown reason.
         */
        public static final int NSFileWriteUnknownError = 512;

        /**
         * It is returned after an attempt to write while there is a permission
         * problem.
         */
        public static final int NSFileWriteNoPermissionError = 513;

        /**
         * It is returned after an attempt to write using an invalid file name.
         */
        public static final int NSFileWriteInvalidFileNameError = 514;

        /**
         * It is returned after an attempt to write while the string encoding is
         * not applicable.
         */
        public static final int NSFileWriteInapplicableStringEncodingError = 517;

        /**
         * It is returned after an attempt to write while the URL scheme is
         * unsupported.
         */
        public static final int NSFileWriteUnsupportedSchemeError = 518;

        /**
         * It is returned after an attempt to write to the disk while there is
         * no free space.
         */
        public static final int NSFileWriteOutOfSpaceError = 640;

        /**
         * It is returned after an attempt to write to a read only volume.
         */
        public static final int NSFileWriteVolumeReadOnlyError = 642;

        /**
         * It is returned after a key-value coding validation error.
         */
        public static final int NSKeyValueValidationError = 1024;

        /**
         * It is returned after a formatting error.
         */
        public static final int NSFormattingError = 2048;

        /**
         * It is returned after the cancellation of an operation by the user.
         */
        public static final int NSUserCancelledError = 3072;

        /**
         * It is returned to mark the beginning of a sequence of errors related
         * to files.
         */
        public static final int NSFileErrorMinimum = 0;

        /**
         * It is returned to mark the end of a sequence of errors related to
         * files.
         */
        public static final int NSFileErrorMaximum = 1023;

        /**
         * It is returned to mark the beginning of a sequence of errors related
         * to validation.
         */
        public static final int NSValidationErrorMinimum = 1024;

        /**
         * It is returned to mark the end of a sequence of errors related to
         * validation.
         */
        public static final int NSValidationErrorMaximum = 2047;

        /**
         * It is returned to mark the beginning of a sequence of errors related
         * to formatting.
         */
        public static final int NSFormattingErrorMinimum = 2048;

        /**
         * It is returned to mark the end of a sequence of errors related to
         * formatting.
         */
        public static final int NSFormattingErrorMaximum = 2559;

        /**
         * It is returned after a failure during property list parsing.
         */
        public static final int NSPropertyListReadCorruptError = 3840;

        /**
         * It is returned when the version number of the property list cannot be
         * determined.
         */
        public static final int NSPropertyListReadUnknownVersionError = 3841;

        /**
         * It is returned after a stream error occurred while reading the
         * property list.
         */
        public static final int NSPropertyListReadStreamError = 3842;

        /**
         * It is returned after a stream error occurred while writing to the
         * property list.
         */
        public static final int NSPropertyListWriteStreamError = 3851;

        /**
         * It is returned to mark the beginning of a sequence of errors related
         * to property list.
         */
        public static final int NSPropertyListErrorMinimum = 3840;

        /**
         * It is returned to mark the end of a sequence of errors related to
         * property list.
         */
        public static final int NSPropertyListErrorMaximum = 4095;

        /**
         * It is returned to mark the beginning of a sequence of errors related
         * to executable files.
         */
        public static final int NSExecutableErrorMinimum = 3584;

        /**
         * It is returned when the executable is not loadable.
         */
        public static final int NSExecutableNotLoadableError = 3584;

        /**
         * It is returned after a failure of the executable due to
         * incompatibility of the architecture.
         */
        public static final int NSExecutableArchitectureMismatchError = 3585;

        /**
         * It is returned after a failure of the executable due to
         * incompatibility with the current process.
         */
        public static final int NSExecutableRuntimeMismatchError = 3586;

        /**
         * It is returned after failure to load an executable.
         */
        public static final int NSExecutableLoadError = 3587;

        /**
         * It is returned after an executable failure due to linking issues.
         */
        public static final int NSExecutableLinkError = 3588;

        /**
         * It is returned after a sequence of errors related to executable
         * files.
         */
        public static final int NSExecutableErrorMaximum = 3839;

        /**
         * It is returned after an unknown error of the URL Loading System.
         */
        public static final int Unknown = -1;

        /**
         * It is returned after an asynchronous load cancellation.
         */
        public static final int Cancelled = -999;

        /**
         * It is returned when a URL request cannot be initiated due to
         * malformed URL.
         */
        public static final int BadURL = -1000;

        /**
         * It is returned after an asynchronous operation times out.
         */
        public static final int TimedOut = -1001;

        /**
         * It is returned when a properly formed URL cannot be handled by the
         * network.
         */
        public static final int UnsupportedURL = -1002;

        /**
         * It is returned after a failure to resolve the host name of a URL.
         */
        public static final int CannotFindHost = -1003;

        /**
         * It is returned after a host connection failure.
         */
        public static final int CannotConnectToHost = -1004;

        /**
         * It is returned when the maximum allowed length of the resource data
         * has been exceeded.
         */
        public static final int DataLengthExceedsMaximum = -1103;

        /**
         * It is returned when client/server connection is being served in the
         * middle of an loading progress.
         */
        public static final int NetworkConnectionLost = -1005;

        /**
         *
         */
        public static final int DNSLookupFailed = -1006;

        /**
         * It is returned after the threshold of the allowable redirects has
         * been exceeded.
         */
        public static final int HTTPTooManyRedirects = -1007;

        /**
         * It is returned after a failure to retrieve a requested resource.
         */
        public static final int ResourceUnavailable = -1008;

        /**
         * It is returned after a network resource request when there is no
         * internet connection.
         */
        public static final int NotConnectedToInternet = -1009;

        /**
         * It is returned when a redirect is specified by server's response code
         * but this code is not accompanied with a redirect URL.
         */
        public static final int RedirectToNonExistentLocation = -1010;

        /**
         * It is returned when bad data is received by URL Loading system.
         */
        public static final int BadServerResponse = -1011;

        /**
         * It is returned after user's cancellation to an asynchronous request
         * for authentication.
         */
        public static final int UserCancelledAuthentication = -1012;

        /**
         * It is returned when a authentication is a prerequisite before
         * accessing a resource.
         */
        public static final int UserAuthenticationRequired = -1013;

        /**
         * It is returned after a network connection termination although the
         * URL does not have zero content length.
         */
        public static final int ZeroByteResource = -1014;

        /**
         * It is returned when received content data of a NSURLConnection cannot
         * be decoded.
         */
        public static final int CannotDecodeRawData = -1015;

        /**
         * It is returned when received content data of a NSURLConnection
         * request has unknown content encoding.
         */
        public static final int CannotDecodeContentData = -1016;

        /**
         * It is returned after a failed parsing of a response to a connection
         * request.
         */
        public static final int CannotParseResponse = -1017;

        /**
         * It is returned after connection failure due to disabled international
         * roaming.
         */
        public static final int InternationalRoamingOff = -1018;

        /**
         * It is returned after a failed connection on a network that does not
         * support phone and data communication simultaneously.
         */
        public static final int CallIsActive = -1019;

        /**
         * It is returned after the cellular network disallows a connection
         * request.
         */
        public static final int DataNotAllowed = -1020;

        /**
         * It is returned when a body stream is needed and the client does not
         * provide it.
         */
        public static final int RequestBodyStreamExhausted = -1021;

        /**
         * It is returned after a request for a file that does not exist.
         */
        public static final int FileDoesNotExist = -1100;

        /**
         * It is returned after a request for an FTP file is actually a
         * directory.
         */
        public static final int FileIsDirectory = -1101;

        /**
         * It is returned after resource cannot be read due to insufficient
         * permissions.
         */
        public static final int NoPermissionsToReadFile = -1102;

        /**
         * It is returned after a failed secure connection establishment for
         * unknown reasons.
         */
        public static final int SecureConnectionFailed = -1200;

        /**
         * It is returned when the server certification has expired.
         */
        public static final int ServerCertificateHasBadDate = -1201;

        /**
         * It is returned when a server certification is signed by an untrusted
         * root server.
         */
        public static final int ServerCertificateUntrusted = -1202;

        /**
         * It is returned when a server certification is not signed by any root
         * server.
         */
        public static final int ServerCertificateHasUnknownRoot = -1203;

        /**
         * It is returned when a server certification is not valid.
         */
        public static final int ServerCertificateNotYetValid = -1204;

        /**
         * It is returned after a server certification rejection.
         */
        public static final int ClientCertificateRejected = -1205;

        /**
         * It is returned after SSL connection authentication failure.
         */
        public static final int ClientCertificateRequired = -1206;

        /**
         * It is returned after a load request from cache fails.
         */
        public static final int CannotLoadFromNetwork = -2000;

        /**
         * It is returned when a downloaded file fails to be created on disk due
         * to I/O failure.
         */
        public static final int CannotCreateFile = -3000;

        /**
         * It is returned when a downloaded file fails to be opened.
         */
        public static final int CannotOpenFile = -3001;

        /**
         * It is returned when a downloaded file fails to be closed.
         */
        public static final int CannotCloseFile = -3002;

        /**
         * It is returned when a downloaded file fails to be written to the
         * disk.
         */
        public static final int CannotWriteToFile = -3003;

        /**
         * It is returned when a downloaded file fails to be removed from disk.
         */
        public static final int CannotRemoveFile = -3004;

        /**
         * It is returned when a downloaded file fails to be moved on disk.
         */
        public static final int CannotMoveFile = -3005;

        /**
         * It is returned after a failure on decoding an encoded file during the
         * download.
         */
        public static final int DownloadDecodingFailedMidStream = -3006;

        /**
         * It is returned after a failure on decoding an encoded file after
         * downloading.
         */
        public static final int DownloadDecodingFailedToComplete = -3007;
    }
}
