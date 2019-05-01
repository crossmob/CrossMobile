/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.build.utils;

import org.crossmobile.utils.JavaCommander;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.TextUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import static org.crossmobile.build.utils.DependencyJarResolver.ERROR;
import static org.crossmobile.utils.CollectionUtils.asList;

public class JavaVersionDowngrader {

    public static void convertToJava7(File retrolambda, File classes, Collection<File> libjars, boolean portDefaultMethods) {
        Collection<String> classpath = new ArrayList<>(asList(libjars, File::getAbsolutePath));
        classpath.add(classes.getAbsolutePath());
        JavaCommander cmd = new JavaCommander(retrolambda.getAbsolutePath()).
                addJavaParam("-Dretrolambda.bytecodeVersion=51").
                addJavaParam("-Dretrolambda.inputDir=" + classes.getAbsolutePath()).
                addJavaParam("-Dretrolambda.classpath=" + TextUtils.iterableToString(classpath, File.pathSeparator)).
                addJavaParam("-javaagent:" + retrolambda.getAbsolutePath());
        if (portDefaultMethods)
            cmd.addJavaParam("-Dretrolambda.defaultMethods=true");
        cmd.setOutListener(Log::debug);
        cmd.setErrListener(ERROR);
        Log.info("Downgrade Java to 7");
        cmd.exec();
        cmd.waitFor();
        if (cmd.exitValue() != 0)
            throw new RuntimeException("Unable to execute retrolambda with command:\n" + cmd.toString());
    }
}
