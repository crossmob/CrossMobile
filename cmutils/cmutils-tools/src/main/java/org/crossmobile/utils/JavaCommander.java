/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.util.ArrayList;
import java.util.Collection;

public class JavaCommander extends Commander {

    private final String mainjar;
    private final Collection<String> params = new ArrayList<>();
    private final Collection<String> args = new ArrayList<>();

    public JavaCommander(String mainjar) {
        super(SystemDependent.getJavaExec());
        this.mainjar = mainjar;
    }

    public JavaCommander addJavaParam(String param) {
        params.add(param);
        return this;
    }

    @Override
    public JavaCommander addArgument(String arg) {
        args.add(arg);
        return this;
    }

    @Override
    public synchronized Commander exec() {
        for (String param : params)
            super.addArgument(param);
        super.addArgument("-jar");
        super.addArgument(mainjar);
        for (String arg : args)
            super.addArgument(arg);
        return super.exec();
    }

}
