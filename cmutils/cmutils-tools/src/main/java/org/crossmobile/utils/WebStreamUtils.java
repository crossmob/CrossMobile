/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class WebStreamUtils {
    private static final Consumer<String> identity = i -> {
    };

    public static void downloadAsync(WebRequest request, OutputStream os, Consumer<Long> sizeFeedback, Consumer<Double> percentFeedback, Consumer<WebResult> result, Consumer<String> terminated, Supplier<Boolean> interrupted) {
        AtomicLong size = new AtomicLong(-1);
        new Thread(() -> (terminated == null ? identity : terminated).accept(download(request, os, r -> {
            for (String key : r.header.keySet())
                if (key != null && key.toLowerCase().equals("content-length")) {
                    try {
                        size.set(Long.valueOf(r.header.get(key).get(0).trim()));
                        break;
                    } catch (Exception ignored) {
                    }
                }
            if (result != null)
                result.accept(r);
        }, s -> {
            if (sizeFeedback != null)
                sizeFeedback.accept(s);
            if (percentFeedback != null && size.get() > 0)
                percentFeedback.accept(s / size.doubleValue());
        }, interrupted))).start();
    }

    public static SyncWebResult download(WebRequest request) {
        return download(request, null);
    }

    public static SyncWebResult download(WebRequest request, Consumer<Long> sizeFeedback) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        AtomicReference<WebResult> result = new AtomicReference<>();
        String error = download(request, os, result::set, sizeFeedback);
        WebResult wr = result.get();
        return new SyncWebResult(wr == null ? -1 : wr.code, error, wr == null ? null : wr.header, os.toByteArray());
    }

    public static String download(WebRequest request, OutputStream os, Consumer<WebResult> result, Consumer<Long> sizeFeedback) {
        return download(request, os, result, sizeFeedback, null);
    }

    private static String download(WebRequest request, OutputStream os, Consumer<WebResult> result, Consumer<Long> sizeFeedback, Supplier<Boolean> interrupted) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(os);
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(request.URL).openConnection();
            if (request.method != null)
                con.setRequestMethod(request.method);
            if (request.properties != null)
                for (String key : request.properties.keySet())
                    con.setRequestProperty(key, request.properties.get(key));
            if (request.postStream != null) {
                con.setDoOutput(true);
                FileUtils.copyStream(request.postStream, con.getOutputStream());
            }
            if (result != null)
                result.accept(new WebResult(con.getResponseCode(), con.getHeaderFields()));
            return FileUtils.copyStream(con.getInputStream(), os, sizeFeedback, interrupted)
                    ? null : "Unable to download " + request.URL;
        } catch (Exception e) {
            return e.toString();
        }
    }

    public static class WebRequest {
        private final String URL;
        private Map<String, String> properties;
        private String method;
        private InputStream postStream;

        public WebRequest(String URL) {
            this.URL = URL;
        }

        public WebRequest setMethod(String method) {
            this.method = method;
            return this;
        }

        public WebRequest setRequestProperty(String key, String value) {
            Objects.requireNonNull(key);
            Objects.requireNonNull(value);
            if (properties == null)
                properties = new HashMap<>();
            properties.put(key, value);
            return this;
        }

        public WebRequest setPostStream(InputStream postStream) {
            this.postStream = postStream;
            return this;
        }
    }

    public static class WebResult {
        public final int code;
        public final Map<String, List<String>> header;

        private WebResult(int code, Map<String, List<String>> header) {
            this.code = code;
            this.header = header;
        }
    }

    public static class SyncWebResult extends WebResult {
        public final byte[] data;
        public final String error;

        public SyncWebResult(int code, String error, Map<String, List<String>> header, byte[] data) {
            super(code, header);
            this.error = error;
            this.data = data;
        }
    }
}
