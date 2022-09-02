/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.bridge.system.BaseUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static java.util.stream.Collectors.toList;
import static org.crossmobile.bridge.system.BaseUtils.listFiles;
import static org.crossmobile.utils.TextUtils.NL;

public final class FileUtils {

    private static final SimpleDateFormat dateformat = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
    private static final int BUFFER_SIZE = 4096;

    private FileUtils() {
    }

    public static List<URL> filesToURL(Collection<File> files) {
        if (files == null)
            return null;
        List<URL> urls = new ArrayList<>();
        for (File file : files)
            try {
                urls.add(file.toURI().toURL());
            } catch (MalformedURLException ignored) {
            }
        return urls;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public static boolean isWritable(File path) {
        if (path.isFile())
            return SystemDependent.canWrite(path);
        while (path != null && !path.exists())
            path = path.getParentFile();
        return SystemDependent.canWrite(path);
    }

    public static String isReadable(File test, String type) {
        if (type == null)
            type = "File";
        if (test == null)
            return type + " should not be null";
        if (!test.isFile())
            return type + " '" + test.getPath() + "' is not a file";
        if (!test.canRead())
            return type + " '" + test.getPath() + "' is not readable";
        return null;
    }

    private static String normalizeResource(String resource) {
        return resource.startsWith("/") ? resource.substring(1) : resource;
    }

    public static String readResourceSafe(String resource) {
        return readSafe(Thread.currentThread().getContextClassLoader().getResourceAsStream(normalizeResource(resource)), "resource " + resource);
    }

    public static String read(File input) {
        try {
            return readSafe(new FileInputStream(input), null);
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    public static String readSafe(InputStream input, String sourceDescription, String deflt) {
        String result = readSafe(input, sourceDescription);
        return result == null ? deflt : result;
    }

    public static String readSafe(InputStream input, String sourceDescription) {
        final StringBuilder out = new StringBuilder();
        try {
            read(input, sourceDescription, (String data) -> out.append(data).append(NL));
        } catch (ProjectException ex) {
            return null;
        }
        return out.toString();
    }

    @SuppressWarnings("UseSpecificCatch")
    public static void read(InputStream input, String sourceDescription, Consumer<String> linereader) throws ProjectException {
        if (linereader == null || input == null)
            return;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));) {
            String line;
            while ((line = in.readLine()) != null)
                linereader.accept(line);
        } catch (Exception ex) {
            if (ex instanceof ProjectException)
                //noinspection ConstantConditions
                throw (ProjectException) ex;
            else
                throw new ProjectException("Unable to read " + sourceDescription, ex);
        }
    }

    public static String removeExtension(String filename) {
        if (filename == null)
            return null;
        String extension = getExtension(filename);
        return extension.isEmpty()
                ? filename
                : filename.substring(0, filename.lastIndexOf(extension) - 1);
    }

    /**
     * @param fileout the file to write to
     * @param data    the data to write to this file
     * @return Provided fileout if everything went OK
     */
    @SuppressWarnings("UseSpecificCatch")
    public static File write(File fileout, String data) {
        if (data == null)
            throw new IllegalArgumentException("Cowardly refused to save null data to " + fileout.getAbsolutePath());
        BufferedWriter out = null;
        try {
            fileout.getParentFile().mkdirs();
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileout), StandardCharsets.UTF_8));
            out.write(data);
            out.flush();
            return fileout;
        } catch (Exception ex) {
            Log.error("Unable to write file " + fileout.getAbsolutePath(), ex);
            return null;
        } finally {
            if (out != null)
                try {
                    out.close();
                } catch (IOException ignored) {
                }
        }
    }

    public static File writeIfDiffers(File out, String data) {
        String oldData = read(out);
        if (data == null)
            return null;
        return data.equals(oldData)
                ? out
                : write(out, data);

    }

    public static boolean copyResource(String resource, File dest) {
        try {
            copyResource(resource, dest.getAbsolutePath());
            return true;
        } catch (ProjectException e) {
            return false;
        }
    }

    public static void copyResource(String resource, String dest) throws ProjectException {
        File fout = new File(dest);
        fout.getParentFile().mkdirs();

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(normalizeResource(resource));
        if (inputStream == null)
            throw new ProjectException("Unable to find resource " + resource);

        BufferedInputStream in = new BufferedInputStream(inputStream);
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(fout));
        } catch (FileNotFoundException ignored) {
        }
        if (!copyStream(in, out))
            throw new ProjectException("Unable to copy resource " + resource);
    }

    public static long copyReaders(Reader in, Writer out) throws IOException {
        long countBytes = 0;
        char buffer[] = new char[1024];
        int length;
        while ((length = in.read(buffer)) >= 0) {
            countBytes += length;
            out.write(buffer, 0, length);
        }
        out.flush();
        return countBytes;
    }

    public static boolean copyStream(InputStream in, OutputStream out) {
        return copyStream(in, out, null, null);
    }

    public static boolean copyStream(InputStream in, OutputStream out, Consumer<Long> transferredFeedback, Supplier<Boolean> interrupted) {
        if (in == null || out == null)
            return false;
        long upToNow = 0;
        if (interrupted == null)
            interrupted = () -> false;
        try {
            byte[] buffer = new byte[0x4000];
            int howmany;
            while ((howmany = in.read(buffer)) >= 0) {
                if (howmany > 0) {
                    out.write(buffer, 0, howmany);
                    upToNow += howmany;
                    if (transferredFeedback != null)
                        transferredFeedback.accept(upToNow);
                }
                if (interrupted.get()) {
                    out.flush();
                    return false;
                }
            }
            out.flush();
            return true;
        } catch (IOException ex) {
            return false;
        } finally {
            try {
                in.close();
            } catch (IOException ignored) {
            }
            try {
                out.close();
            } catch (IOException ignored) {
            }
        }
    }

    public static void move(File from, File to, File backupDir) {
        if (from.exists()) {        // If from does not exist, do nothing
            backup(to, backupDir, false);
            to.delete();
            to.getParentFile().mkdirs();
            from.renameTo(to);
        }
    }

    public static void delete(File file, File backupDir) {
        if (backupDir != null)
            backup(file, backupDir, false);
        for (File child : listFiles(file))
            delete(child, null);
        file.delete();
    }

    public static File mkdirs(File dir) {
        if (!dir.isDirectory()) {
            if (dir.isFile())
                throw new FileUtilsException("Unable to create a folder where a file exits at " + dir.getAbsolutePath());
            dir.mkdirs();
            if (!dir.isDirectory())
                throw new FileUtilsException("Tried to create folder under " + dir.getAbsolutePath() + " but failed");
        }
        return dir;
    }

    public static void backup(File file, File backupDir, boolean keepOriginal) {
        if (file.exists() && backupDir != null) {
            backupDir.mkdirs();
            File backup;
            int counter = 2;
            backup = new File(backupDir, file.getName());
            if (backup.exists())
                while ((backup = new File(backupDir, file.getName() + "." + (counter++))).exists()) {
                }
            if (keepOriginal)
                copy(file, backup);
            else
                file.renameTo(backup);
        }
    }

    public static File getBackupDir(File projectDir) throws ProjectException {
        File baseDir = new File(projectDir, "backup");
        projectDir.mkdirs(); // In case it is a new project
        if ((baseDir.exists() && (!baseDir.isDirectory() || !baseDir.canWrite()))
                || (!baseDir.exists() && (!projectDir.isDirectory() || !projectDir.canWrite())))
            throw new ProjectException("Unable to setup bacj up directory " + baseDir.getPath());
        return new File(baseDir, dateformat.format(new Date()));
    }

    public static File getNewProjectDir(File dir) {
        int counter = 1;
        File current;
        while ((current = new File(dir, "NewProject" + counter)).exists())
            counter++;
        return new File(current.getParentFile(), current.getName());
    }

    public static String getAbs(File file) {
        try {
            return file.getCanonicalFile().getAbsolutePath();
        } catch (IOException e) {
            BaseUtils.throwException(e);
            return null;
        }
    }

    public static String getAbs(File base, String filename) {
        return getAbsFile(base, filename).getPath();
    }

    public static File getAbsFile(File base, String filename) {
        File file = new File(filename);
        if (!file.isAbsolute())
            file = new File(base, filename).getAbsoluteFile();
        try {
            file = file.getCanonicalFile();
        } catch (IOException ex) {
        }
        return file;
    }

    public static List<String> getFileItemList(String items) {
        List<String> result = new ArrayList<>();
        StringTokenizer tk = new StringTokenizer(items, ":");
        String mightBeVolume = null;
        while (tk.hasMoreTokens()) {
            String item = tk.nextToken();
            if (item.length() == 1 && mightBeVolume == null)
                // Handle windows volumes
                mightBeVolume = item;
            else {
                if (mightBeVolume != null) {
                    item = mightBeVolume + ":" + item;
                    mightBeVolume = null;
                }
                result.add(item);
            }
        }
        if (mightBeVolume != null)
            result.add(mightBeVolume);
        return result;
    }

    public static String getRelative(File base, File target) {
        return new File(base.getAbsolutePath()).toURI().relativize(new File(target.getAbsolutePath()).toURI()).getPath();
    }

    public static String getRelativePath(String destpath, String basepath) {
        // Use canonical paths
        try {
            destpath = new File(destpath).getCanonicalPath();
        } catch (IOException ex) {
        }
        destpath = destpath.replace('\\', '/');
        try {
            basepath = new File(basepath).getCanonicalPath();
        } catch (IOException ex) {
        }
        basepath = basepath.replace('\\', '/');

        // Return name if both paths are the same
        if (destpath.equals(basepath))
            return new File(destpath).getName();

        // Split path into parts
        String[] destparts = destpath.split("\\/");
        String[] baseparts = basepath.split("\\/");
        int minpath = Math.min(destparts.length, baseparts.length);
        if (minpath == 0)
            return destpath;    // wrong number of paths

        // Return absolute path if they don't have the same root
        if (!destparts[0].equals(baseparts[0]))
            return destpath;

        int commonPathSize = 0;
        while (commonPathSize < minpath && destparts[commonPathSize].equals(baseparts[commonPathSize]))
            commonPathSize++;

        StringBuilder path = new StringBuilder();
        // Construct upwards path
        for (int i = commonPathSize; i < baseparts.length; i++)
            path.append("/..");
        // Construct downwards path
        for (int i = commonPathSize; i < destparts.length; i++)
            path.append("/").append(destparts[i]);
        return path.substring(1);
    }

    public static List<File> matchFiles(Collection<File> existing, String... patterns) {
        List<File> result = new ArrayList<>();
        for (String request : patterns)
            for (File item : existing) {
                String name = item.getName();
                if (name.equals(request))
                    result.add(item);
            }
        return result;
    }

    public static List<File> filesWithPrefix(Collection<File> existing, boolean ignoreCase, String... prefix) {
        List<File> result = new ArrayList<>();
        for (String request : prefix)
            for (File item : existing) {
                String name = item.getName();
                if ((ignoreCase ? name.toLowerCase() : name).startsWith(ignoreCase ? request.toLowerCase() : request))
                    result.add(item);
            }
        return result;
    }

    /**
     * @param current
     * @return How many *files*, not folders, have changed
     */
    public static int delete(File current) {
        int hm = 0;
        if (current.isDirectory())
            for (File child : listFiles(current))
                hm += delete(child);
        if (current.exists())
            if (!current.delete())
                throw new FileUtilsException("Unable to delete file " + current.getAbsolutePath());
            else
                hm++;
        return hm;
    }

    public static int copy(File source, File target) {
        return copy(source, target, pTRUE);
    }

    public static int copy(File source, File target, Predicate<File> predicate) {
        if (source == null || target == null)
            return 0;
        int files = 0;
        if (!source.exists())
            return 0;
        if (!predicate.test(source))
            return 0;

        if (target.exists() && source.isDirectory() != target.isDirectory())
            FileUtils.delete(target);

        if (source.isDirectory()) {
            if ((!target.exists()) && (!target.mkdirs()))
                throw new FileUtilsException("Unable to create directory " + target.getPath());
            for (File item : listFiles(source))
                files += copy(item, new File(target, item.getName()), predicate);
        } else {
            //noinspection ResultOfMethodCallIgnored
            target.delete();
            BufferedInputStream in;
            try {
                in = new BufferedInputStream(new FileInputStream(source));
            } catch (FileNotFoundException ex) {
                throw new FileUtilsException("FileNotFoundException: " + ex.getMessage());
            }

            //noinspection ResultOfMethodCallIgnored
            target.getParentFile().mkdirs();
            BufferedOutputStream out;
            try {
                out = new BufferedOutputStream(new FileOutputStream(target));
            } catch (FileNotFoundException ex) {
                throw new FileUtilsException("FileNotFoundException: " + ex.getMessage());
            }

            if (copyStream(in, out)) {
                //noinspection ResultOfMethodCallIgnored
                target.setLastModified(source.lastModified());
                files++;
            } else
                throw new FileUtilsException("Unable to copy file from " + source.getAbsolutePath() + " to " + target.getAbsolutePath());
        }
        return files;
    }

    public static String getFullPath(String basePath, String... morePaths) {
        if (morePaths == null || morePaths.length < 1)
            return getFullPath(new String[]{basePath});
        String[] allPaths = new String[1 + morePaths.length];
        allPaths[0] = basePath;
        System.arraycopy(morePaths, 0, allPaths, 1, morePaths.length);
        return getFullPath(allPaths);
    }

    public static String getFullPath(String... paths) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < paths.length; i++) {
            if (i != 0)
                out.append(File.separator);
            out.append(paths[i]);
        }
        return out.toString();
    }

    /**
     * @param file1
     * @param file2
     * @return true if file1 i newer than file2
     */
    public static boolean isNewer(File file1, File file2) {
        if (file1 == null || !file1.isFile())
            return false;
        if (file2 == null || !file2.isFile())
            return true;
        return getLastModified(file1) >= getLastModified(file2);
    }

    public static long getLastModified(File dir) {
        long mod = dir.lastModified();
        if (dir.isDirectory())
            for (File child : listFiles(dir)) {
                long cmod = getLastModified(child);
                if (cmod > mod)
                    mod = cmod;
            }
        return mod;
    }

    public static long fixLastModified(File path) {
        long mod = path.lastModified();
        long old = mod;
        if (path.isDirectory()) {
            for (File child : listFiles(path))
                mod = Math.max(mod, fixLastModified(child));
            if (old != mod) {
                path.setLastModified(mod);
                if (mod != path.lastModified())
                    Log.error("Unable to set modification time of " + path.getPath() + " - project might not build correctly.");
            }
        }
        return mod;
    }

    public static int trimEmptyDirs(File dir) {
        int changed = 0;
        for (File child : listFiles(dir)) {
            if (child.isDirectory()) {
                trimEmptyDirs(child);
                if (listFiles(child).isEmpty()) {
                    //noinspection ResultOfMethodCallIgnored
                    child.delete();
                    changed++;
                }
            }
        }
        return changed;
    }

    public static boolean filesDiffer(File file1, File file2) {
        if (!file1.isFile() || !file2.isFile() || file1.length() != file2.length())
            return true;
        try (InputStream in1 = new FileInputStream(file1); InputStream in2 = new FileInputStream(file2)) {
            int v1;
            while ((v1 = in1.read()) >= 0)
                if (v1 != in2.read())
                    return true;
            return false;
        } catch (IOException e) {
            return true;
        }
    }

    private static int copyDual(File from, File to, File alsoTo, Predicate<File> predicate) {
        if (alsoTo != null)
            copy(from, alsoTo, predicate);
        return copy(from, to, predicate);
    }

    private static final Predicate<File> pTRUE = f -> true;

    /**
     * Sync directories
     *
     * @param from               The source directory to check upon
     * @param to                 The destination directory to check
     * @param diff               Where added changes should be stored; could be null
     * @param removeMissingFiles If missing files found in destination (to) directory but not in source (from) directory should be deleted
     * @param acceptPredicate    A predicate mechanism to accept specific files
     * @return how many files have changed
     */
    public static int sync(File from, File to, File diff, boolean removeMissingFiles, Predicate<File> acceptPredicate) {
        if (acceptPredicate == null)
            acceptPredicate = pTRUE;
        if (!from.exists())
            throw new FileUtilsException("Unable to synchronize folder " + from.getAbsolutePath() + " to " + to.getAbsolutePath());
        if (!to.exists())
            return copyDual(from, to, diff, acceptPredicate);

        // Both file paths exist
        int files = 0;
        if (from.isFile() && to.isFile()) {
            if (acceptPredicate.test(from) && filesDiffer(from, to))
                if (copyDual(from, to, diff, acceptPredicate) > 0)
                    files++;
                else
                    throw new FileUtilsException("Unable to synchronize file " + from.getAbsolutePath());
        } else if (from.isDirectory() && to.isDirectory()) {    // try to merge: the only reason this part exists, is because we might want to merge the contents of both directories (i.e. when removeMissingFiles is false)
            Collection<String> toFileNames = listFiles(to).stream().filter(acceptPredicate).map(File::getName).collect(toList());
            for (File fromFile : listFiles(from)) {
                String fromName = fromFile.getName();
                File diffFile = diff == null ? null : new File(diff, fromName);
                File toFile = new File(to, fromName);
                if (toFileNames.remove(fromName))  // if file exists in both places
                    files += sync(fromFile, toFile, diffFile, removeMissingFiles, acceptPredicate);
                else
                    files += copyDual(fromFile, toFile, diffFile, acceptPredicate);
            }
            if (removeMissingFiles)
                for (String obsoleteName : toFileNames) {
                    if (diff != null)
                        delete(new File(diff, obsoleteName));
                    files += delete(new File(to, obsoleteName));
                }
        } else {
            delete(to);
            files += copyDual(from, diff, to, acceptPredicate);
        }
        return files;
    }

    public static String getExtension(String filename) {
        if (filename == null)
            return null;
        int dot = filename.lastIndexOf('.');
        return dot < 0 ? "" : filename.substring(dot + 1);
    }

    public static String getBasename(String filename) {
        if (filename == null)
            return null;
        int dot = filename.lastIndexOf('.');
        return dot < 0 ? filename : filename.substring(0, dot);
    }

    public static void forAllFiles(File file, Predicate<File> predicate, BiConsumer<String, File> consumer) {
        forAllFiles(file, (p, f) -> predicate.test(f), consumer);
    }

    public static void forAllFiles(File file, BiConsumer<String, File> consumer) {
        forAllFiles(file, (BiPredicate<String, File>) null, consumer);
    }

    public static void forAllFiles(File file, BiPredicate<String, File> predicate, BiConsumer<String, File> consumer) {
        if (file == null || consumer == null)
            return;
        if (file.isFile()) {
            if (predicate.test("", file))
                consumer.accept("", file);
        } else
            forAllFiles(file, predicate == null ? (p, f) -> true : predicate, consumer, "");
    }

    private static void forAllFiles(File folder, BiPredicate<String, File> predicate, BiConsumer<String, File> consumer, String pathUpToNow) {
        for (File file : listFiles(folder))
            if (file.isFile()) {
                if (predicate.test(pathUpToNow, file))
                    consumer.accept(pathUpToNow, file);
            } else if (file.isDirectory())
                forAllFiles(file, predicate, consumer, pathUpToNow + (pathUpToNow.isEmpty() ? "" : File.separator) + file.getName());
    }

    public static URL toURL(File f) {
        try {
            return f.toURI().toURL();
        } catch (MalformedURLException ex) {
            return null;
        }
    }

    public static boolean endsWithPathSeparator(String path) {
        return path.endsWith("/") || path.endsWith("\\");
    }

    public static boolean zip(File sourceDir, File destZip) {

        try (ZipOutputStream zs = new ZipOutputStream(new FileOutputStream(destZip))) {
            Path pp = Paths.get(sourceDir.getPath());
            Files.walk(pp)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
                        try {
                            zs.putNextEntry(zipEntry);
                            Files.copy(path, zs);
                            zs.closeEntry();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Throwable th) {
            if (th instanceof RuntimeException && th.getMessage().isEmpty() && th.getCause() != null)
                th = th.getCause();
            Log.error(th);
            return false;
        }
        return true;
    }

    public static boolean unzip(File zipFilePath, File destDir) {
        if (zipFilePath == null)
            return false;
        try {
            return unzip(new FileInputStream(zipFilePath), destDir);
        } catch (FileNotFoundException e) {
            Log.error(e);
            return false;
        }
    }

    public static boolean unzip(InputStream inputStream, File destDir) {
        if (inputStream == null || destDir == null)
            return false;
        destDir.mkdirs();
        try (ZipInputStream zipIn = new ZipInputStream(inputStream)) {
            ZipEntry entry = zipIn.getNextEntry();
            // iterates over entries in the zip file
            while (entry != null) {
                String filePath = destDir.getPath() + File.separator + entry.getName();
                if (!entry.isDirectory())
                    // if the entry is a file, extracts it
                    extractFile(zipIn, filePath);
                else {
                    // if the entry is a directory, make the directory
                    File dir = new File(filePath);
                    dir.mkdir();
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
            return true;
        } catch (IOException e) {
            Log.error(e);
            return false;
        }
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read;
        while ((read = zipIn.read(bytesIn)) != -1)
            bos.write(bytesIn, 0, read);
        bos.close();
    }

    public static String getClassVersion(File file) {
        try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
            if (in.readInt() == 0xcafebabe) {
                in.readUnsignedShort(); // Minor version
                int major = in.readUnsignedShort();
                switch (major) {
                    case 45:
                        return "1.0";
                    case 46:
                        return "1.2";
                    case 47:
                        return "1.3";
                    case 48:
                        return "1.4";
                    case 49:
                        return "1.5";
                    case 50:
                        return "1.6";
                    case 51:
                        return "1.7";
                    case 52:
                        return "8";
                    case 53:
                        return "9";
                    case 54:
                        return "10";
                    case 55:
                        return "11";
                    case 56:
                        return "12";
                    case 57:
                        return "13";
                    case 58:
                        return "14";
                    case 59:
                        return "15";
                    case 60:
                        return "16";
                    case 61:
                        return "17";
                    default:
                        throw new RuntimeException("Unknown java version with ID " + major);
                }
            }
        } catch (IOException ignored) {
        }
        return "<unknown>";
    }

    public static File createTempDir() {
        try {
            File tempFile = File.createTempFile("cmtemp-", "");
            if (!tempFile.delete())
                return null;
            if (!tempFile.mkdirs())
                return null;
            return tempFile;
        } catch (IOException e) {
            return null;
        }
    }

    public static class Predicates {
        public static Predicate<File> noHidden() {
            return f -> {
                if (f.getName().startsWith(".")) {
                    Log.debug("Hidden file ignored: " + f.getAbsolutePath());
                    return false;
                } else
                    return true;
            };
        }

        public static Predicate<File> extensions(String... extensions) {
            Collection<String> extensionLookup = new ArrayList<>();
            if (extensions != null && extensions.length > 0)
                for (String ext : extensions)
                    if (ext != null)
                        extensionLookup.add(ext.toLowerCase());
            return extensionLookup.isEmpty() ? a -> false : file -> {
                String name = file.getName();
                for (String ext : extensionLookup)
                    if (name.endsWith(ext))
                        return true;
                return false;
            };
        }
    }
}
