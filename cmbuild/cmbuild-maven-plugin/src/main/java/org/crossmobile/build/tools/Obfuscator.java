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

import org.crossmobile.utils.JavaCommander;
import org.crossmobile.utils.Log;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

import static org.crossmobile.build.utils.DependencyJarResolver.ERROR;

public class Obfuscator {

    private static final String[] JAVA_SYS = {"lib/rt.jar", "lib/jce.jar"};

    public static void obfuscate(File proguardLib, File proguardMap, File inputJar, File outputJar, Collection<File> proguardConfig) {
        if (!inputJar.getName().toLowerCase().endsWith(".jar"))
            throw new RuntimeException("Obfuscated file output should have a 'jar' extension");
        JavaCommander cmd = new JavaCommander(proguardLib.getAbsolutePath());
        //noinspection ResultOfMethodCallIgnored
        outputJar.getParentFile().mkdirs();
        //noinspection ResultOfMethodCallIgnored
        proguardMap.getParentFile().mkdirs();

        for (File conf : proguardConfig)
            cmd.addArgument("@").addArgument(conf.getAbsolutePath());

        for (String sysjar : JAVA_SYS)
            cmd.addArgument("-libraryjars").addArgument(new File(System.getProperty("java.home"), sysjar).getAbsolutePath());

        cmd.addArgument("-injars").addArgument(inputJar.getAbsolutePath());
        cmd.addArgument("-outjars").addArgument(outputJar.getAbsolutePath());
        cmd.addArgument("-printmapping").addArgument(proguardMap.getAbsolutePath());

        cmd.setOutListener(Log::info);
        cmd.setErrListener(ERROR);
        cmd.exec();
        cmd.waitFor();
        if (cmd.exitValue() != 0)
            throw new RuntimeException("Unable to execute proguard with command: " + cmd.toString());
    }
}
