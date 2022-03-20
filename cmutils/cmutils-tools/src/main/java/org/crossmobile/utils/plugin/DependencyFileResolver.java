/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.plugin;

import java.io.File;

public interface DependencyFileResolver {

    File resolve(String groupID, String artifactID, String version, String type);
}
