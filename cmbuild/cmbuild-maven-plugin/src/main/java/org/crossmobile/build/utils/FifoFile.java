/*
 * (c) 2020 by Panayotis Katsaloulis
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
package org.crossmobile.build.utils;

import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.utils.Commander;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class FifoFile {

    private File fifo;
    private Reader in;
    private Writer out;
    private Thread tcons;

    public FifoFile(String prefix) {
        try {
            fifo = File.createTempFile(prefix + ".", ".fifo");
            fifo.delete();
            Commander cmd = new Commander("mkfifo", fifo.getAbsolutePath());
            cmd.exec();
            cmd.waitFor();
            if (cmd.exitValue() != 0)
                throw new RuntimeException("Unable to create FIFO file");
        } catch (IOException ex) {
            BaseUtils.throwException(ex);
        }
    }

    public synchronized Writer getWriter() {
        if (fifo == null)
            throw new RuntimeException("Unable to get Writer on a closed stream");
        if (out == null)
            try {
                out = new OutputStreamWriter(new FileOutputStream(fifo), StandardCharsets.UTF_8);
            } catch (IOException ex) {
                return BaseUtils.throwException(ex);
            }
        return out;
    }

    public synchronized Reader getReader() {
        if (fifo == null)
            throw new RuntimeException("Unable to get Reader on a closed stream");
        if (in == null)
            try {
                in = new InputStreamReader(new FileInputStream(fifo), StandardCharsets.UTF_8);
            } catch (IOException ex) {
                return BaseUtils.throwException(ex);
            }
        return in;
    }

    public synchronized void setConsumer(final Consumer<String> consumer) {
        if (fifo == null)
            throw new RuntimeException("Unable to set consumer on a closed stream");
        if (tcons != null)
            throw new RuntimeException("A consumer has already been defined");
        tcons = new Thread() {
            @Override
            @SuppressWarnings("UseSpecificCatch")
            public void run() {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(getReader());
                    String line;
                    while (!isInterrupted() && (line = reader.readLine()) != null)
                        consumer.accept(line);
                } catch (Exception ex) {
                } finally {
                    if (reader != null)
                        try {
                            reader.close();
                        } catch (IOException ex) {
                        }
                    tcons = null;
                }
            }
        };
        tcons.start();
    }

    public String getPath() {
        File f = fifo;  // to make it thread safe
        return f == null ? null : f.getAbsolutePath();
    }

    public synchronized void close() {
        if (fifo == null)
            return;
        if (tcons != null)
            tcons.interrupt();
        if (in != null)
            try {
                in.close();
            } catch (IOException ex) {
                BaseUtils.throwException(ex);
            }
        if (out != null)
            try {
                out.close();
            } catch (IOException ex) {
                BaseUtils.throwException(ex);
            }
        fifo.delete();
        fifo = null;
    }
}
