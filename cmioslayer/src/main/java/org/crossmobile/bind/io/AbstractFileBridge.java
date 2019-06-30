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
package org.crossmobile.bind.io;

import org.crossmobile.bridge.FileBridge;

import java.io.*;
import java.net.URLDecoder;
import java.util.Random;

import static org.crossmobile.bind.io.FileBridgeConstants.DEFAULTPATHS;

public abstract class AbstractFileBridge implements FileBridge {

    private static final Random random = new Random(System.currentTimeMillis());
    private static final String CACHE_LOCATION = ".cm.cache";

    private String tempLocation;
    private String randomLocation;  // has separator
    private boolean docsCreated;
    private boolean cacheCreated;
    private boolean prefsCreated;
    private boolean syscacheCreated;


    @Override
    public String getTemporaryLocation() {
        if (tempLocation == null) {
            File tempPath = new File(getHomePath(), "temp");
            tempPath.mkdirs();
            tempLocation = tempPath.getAbsolutePath();
        }
        return tempLocation;
    }

    @Override
    public String getHomeLocation() {
        String home = getHomePath();
        if (!docsCreated)
            docsCreated = new File(home, DEFAULTPATHS[crossmobile.ios.foundation.NSSearchPathDirectory.Document]).mkdirs();
        if (!cacheCreated)
            cacheCreated = new File(home, DEFAULTPATHS[crossmobile.ios.foundation.NSSearchPathDirectory.Caches]).mkdirs();
        if (!prefsCreated)
            prefsCreated = new File(home, DEFAULTPATHS[crossmobile.ios.foundation.NSSearchPathDirectory.Library] + File.separator + "Preferences").mkdirs();
        return home;
    }

    @Override
    public String getRandomLocation() {
        if (randomLocation == null) {
            File randomParent = new File(getTemporaryLocation(), CACHE_LOCATION);
            randomParent.mkdirs();
            randomLocation = randomParent.getAbsolutePath() + File.separator;
        }
        return randomLocation + Integer.toHexString(random.nextInt());
    }

    @Override
    public String getSystemCacheLocation() {
        String cache = getHomePath() + DEFAULTPATHS[crossmobile.ios.foundation.NSSearchPathDirectory.Caches] + File.separator + ".cm.syscache";
        if (!syscacheCreated)
            syscacheCreated = new File(cache).mkdirs();
        return cache;
    }

    @Override
    public InputStream getFileStream(String file) throws IOException {
        if (file.startsWith(getApplicationPrefix()))
            return getApplicationFileStream(file.substring(getApplicationPrefix().length() + 1));
        else
            return getAbsoluteFileStream(file);
    }

    protected InputStream getAbsoluteFileStream(String file) throws IOException {
        return new FileInputStream(file);
    }

    protected abstract String getHomePath();

    /**
     * Get a stream from a desired file
     *
     * @param file The filename will not have the application prefix - only the
     *             desired file
     * @return
     * @throws IOException
     */
    public abstract InputStream getApplicationFileStream(String file) throws IOException;

    public static String getFileFromURL(String url) {
        int last = url.lastIndexOf('/');
        if (last < 0 || last == url.length() - 1)
            return "file";
        try {
            return URLDecoder.decode(url.substring(last + 1), "UTF-8");
        } catch (Exception e) {
            return "file";
        }
    }
}
