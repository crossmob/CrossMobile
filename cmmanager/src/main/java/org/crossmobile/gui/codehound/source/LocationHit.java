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
package org.crossmobile.gui.codehound.source;

public class LocationHit {

    private final String line;
    private final int linenumber;
    private final int column;

    LocationHit(String line, int lineID, int column) {
        this.line = lineID < 0 ? "" : line;
        this.linenumber = lineID;
        this.column = column;
    }

    public void dump() {
        if (linenumber >= 0)
            System.out.println("    [" + linenumber + "," + column + "] " + line.trim());
    }

    public int getColumn() {
        return column;
    }

    public String getLine() {
        return line;
    }

    public int getLineNumber() {
        return linenumber;
    }
}
