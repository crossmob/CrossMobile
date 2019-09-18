/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.gui.parameters.impl;

import com.panayotis.hrgui.HiResButton;
import com.panayotis.hrgui.HiResComponent;
import com.panayotis.hrgui.HiResPanel;
import org.crossmobile.gui.codehound.bin.Permissions;
import org.crossmobile.gui.codehound.bin.PermissionsAction;
import org.crossmobile.gui.parameters.MultiButtonParameter;
import org.crossmobile.gui.project.Project;
import org.crossmobile.utils.ParamList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collection;

import static org.crossmobile.gui.codehound.bin.Permissions.*;
import static org.crossmobile.utils.ParamsCommon.USES_PERMISSIONS;

public class AndroidPermissionsParameter extends MultiButtonParameter {

    private final Project proj;
    private static final char SEPARATOR = ':';
    private HiResButton recalculate;

    public AndroidPermissionsParameter(ParamList plist, Project proj) {
        super(plist, USES_PERMISSIONS.tag(), getPermissions(), getNames(), getTooltips(), getIcons(), null, 3, SEPARATOR);
        this.proj = proj;
    }

    @Override
    public String getVisualTag() {
        return "Required Permissions";
    }

    @Override
    protected HiResComponent initVisuals() {
        HiResPanel bottom = new HiResPanel(new FlowLayout(FlowLayout.LEFT));
        bottom.setOpaque(false);
        recalculate = new HiResButton("Try to gather automatically");
        bottom.add(recalculate);
        recalculate.addActionListener((ActionEvent e) -> {
            Collection<Permissions> perms = PermissionsAction.findPermissions(proj);
            if (perms != null)
                for (Permissions perm : perms)
                    activateValue(perm.getPermission());
        });

        HiResPanel visuals = new HiResPanel(new BorderLayout());
        visuals.setOpaque(false);
        visuals.add(super.initVisuals().comp(), BorderLayout.NORTH);
        visuals.add(bottom, BorderLayout.SOUTH);
        return visuals;
    }

}
