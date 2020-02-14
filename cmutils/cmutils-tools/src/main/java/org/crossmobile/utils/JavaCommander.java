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
