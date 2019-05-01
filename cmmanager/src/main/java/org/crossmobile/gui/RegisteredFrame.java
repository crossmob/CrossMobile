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
package org.crossmobile.gui;

import com.panayotis.hrgui.HiResFrame;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class RegisteredFrame extends HiResFrame {

    private final static Set<JFrame> FRAMES = new HashSet<>();
    private static Runnable finishCallback;

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        synchronized (FRAMES) {
            if (visible)
                FRAMES.add(this);
            else {
                FRAMES.remove(this);
                if (FRAMES.isEmpty()) {
                    if (finishCallback != null)
                        finishCallback.run();
                    System.exit(0);
                }
            }
        }
    }

    public static int count() {
        return FRAMES.size();
    }

    public static void setFinishCallback(Runnable finishCallback) {
        RegisteredFrame.finishCallback = finishCallback;
    }
}
