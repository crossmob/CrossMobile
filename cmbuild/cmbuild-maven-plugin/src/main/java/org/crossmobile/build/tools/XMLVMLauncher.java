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
package org.crossmobile.build.tools;

import org.crossmobile.utils.Commander;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.SystemDependent;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.crossmobile.utils.FileUtils.delete;

public class XMLVMLauncher {

    public static void exec(File input, File output, File xmlvm, boolean safe) {
        Log.info("Start XMLVM conversion");
        delete(output);
        output.mkdirs();
        // <!-- Run XMLVM -->
        String[] command = new String[]{SystemDependent.getJavaExec(),
                "-Xmx1G", "-Dfile.encoding=UTF-8", "-jar",
                xmlvm.getAbsolutePath(),
                "--in=" + input.getAbsolutePath(),
                "--out=" + output.getAbsolutePath(),
                "--target=objc",
                safe ? "--safe-inheritance" : "",
                "--debug=warning",
                "--enable-ref-counting"};
        StringBuilder error = new StringBuilder();
        AtomicBoolean castError = new AtomicBoolean(false);
        Commander commander = new Commander(command);
        commander.setErrListener(txt -> {
            error.append(txt).append('\n');
            if (txt.contains("ClassCastException") && txt.contains("InterfaceMethodRef"))
                castError.set(true);
        });
        commander.setOutListener(Log::warning);
        commander.exec();
        commander.waitFor();
        if (commander.exitValue() != 0) {
            Log.error(error.toString());
            throw new RuntimeException(castError.get()
                    ? "The invocation of a call to super method in a default interface implementation is not supported yet"
                    : "Unable to run XMLVM, see debug log for more information");
        }
    }
}
