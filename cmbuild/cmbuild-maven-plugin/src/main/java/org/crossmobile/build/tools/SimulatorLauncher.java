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

import org.crossmobile.build.utils.FifoFile;
import org.crossmobile.utils.Commander;
import org.crossmobile.utils.Log;

import java.io.File;

public class SimulatorLauncher {

    public void execute(String ios_sim, String app, String device, String basedir) {
        final FifoFile out = new FifoFile("cm_out");
        final FifoFile err = new FifoFile("cm_in");
        out.setConsumer(Log::info);
        err.setConsumer(Log::error);

        app = new File(basedir, app).getAbsolutePath();
        Commander cmd = new Commander(ios_sim,
                "launch", app, "--devicetypeid", device, "--timeout", "60", "--unbuffered",
                "--stdout", out.getPath(), "--stderr", err.getPath()
        );
        cmd.setOutListener((String data) -> {
            Log.info("[IOS-SIM] " + data);
        });
        cmd.setErrListener((String data) -> {
            Log.error("[IOS-SIM] " + data);
        });
        cmd.exec();
        cmd.waitFor();
        out.close();
        err.close();
    }

}
