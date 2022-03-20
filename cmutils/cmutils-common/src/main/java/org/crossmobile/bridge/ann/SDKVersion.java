/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.ann;

public @interface SDKVersion {

    IOSSDK from() default IOSSDK.ANY;

    IOSSDK to() default IOSSDK.LATEST;
}
