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
package org.crossmobile.xray;

import com.panayotis.xray.prop.ReflectionPropertyHarvester;

import java.lang.reflect.Method;

import static com.panayotis.xray.utils.ReflectionUtils.getAnnotationRecursively;
import static com.panayotis.xray.utils.TextUtils.getDefaultCapitalizedName;

public class AnnotatedPropertyHarvester extends ReflectionPropertyHarvester {

    private final ReflectionClassSupport rcs;

    public AnnotatedPropertyHarvester(ReflectionClassSupport rcs) {
        this.rcs = rcs;
    }

    @Override
    public boolean isGetter(Method m) {
        return getAnnotationRecursively(m, rcs.getterAnn) != null;
    }

    @Override
    public boolean isSetter(Method m) {
        return getAnnotationRecursively(m, rcs.setterAnn) != null;
    }

    @Override
    public String getNameFromGetter(Method m) {
        return m.getName().startsWith("is")
                ? getDefaultCapitalizedName(m.getName().substring(2))
                : getDefaultCapitalizedName(m.getName());
    }

    @Override
    public String getNameFromSetter(Method m) {
        return getDefaultCapitalizedName(m.getName().substring(3));
    }
}
