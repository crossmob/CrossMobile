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
package org.crossmobile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Version {

    public static final String VERSION;
    public static final int RELEASE;

    static {
        Properties props = new Properties();
        try {
            props.load(new InputStreamReader(Version.class.getClassLoader().getResourceAsStream("org/crossmobile/version.properties"), StandardCharsets.UTF_8));
        } catch (IOException ex) {
        }
        VERSION = props.getProperty("current.version", "-unknown-");
        int rel = Integer.MAX_VALUE;
        try {
            rel = Integer.parseInt(props.getProperty("current.release"));
        } catch (NumberFormatException ex) {
        }
        RELEASE = rel;
    }
}
