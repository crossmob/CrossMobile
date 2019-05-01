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
package org.crossmobile.build.tools;

import org.crossmobile.utils.Log;
import org.crossmobile.utils.ParamList;
import org.crossmobile.utils.ProjectException;
import org.crossmobile.utils.TemplateUtils;

import java.io.File;

public class LocalPropertiesManager {

    public static void createIfNotExist(File basedir) {
        File localfile = new File(basedir, "local.properties");
        if (!localfile.exists())
            try {
                TemplateUtils.updateProperties("local.properties", new File(basedir, "local.properties"), new ParamList(), null);
            } catch (ProjectException ex) {
                Log.error(ex);
            }
    }
}
