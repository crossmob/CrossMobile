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
package org.crossmobile.plugin.objc;

public class Templates {
    public static final String SWIFT_BASE_TEMPLATE = "    static func convArgs(_ values:[Any]) ->  CVaListPointer {\n" +
            "        var args: [CVarArg] = []\n" +
            "        for item in values {\n" +
            "            if let val = item as? NSNumber {\n" +
            "                let numberType = CFNumberGetType(val)\n" +
            "                switch numberType {\n" +
            "                case .sInt8Type:\n" +
            "                    args.append(val.int8Value)\n" +
            "                    break\n" +
            "                case .sInt16Type:\n" +
            "                    args.append(val.int16Value)\n" +
            "                    break\n" +
            "                case .sInt32Type:\n" +
            "                    args.append(val.int32Value)\n" +
            "                    break\n" +
            "                case .sInt64Type:\n" +
            "                    args.append(val.int64Value)\n" +
            "                    break\n" +
            "                case .float32Type:\n" +
            "                    args.append(val.floatValue)\n" +
            "                    break\n" +
            "                case .float64Type:\n" +
            "                    args.append(val.doubleValue)\n" +
            "                    break\n" +
            "                case .charType:\n" +
            "                    args.append(val.intValue)\n" +
            "                    break\n" +
            "                case .shortType:\n" +
            "                    args.append(val.intValue)\n" +
            "                    break\n" +
            "                case .intType:\n" +
            "                    args.append(val.intValue)\n" +
            "                    break\n" +
            "                case .longType:\n" +
            "                    args.append(val.int32Value)\n" +
            "                    break\n" +
            "                case .longLongType:\n" +
            "                    args.append(val.int64Value)\n" +
            "                    break\n" +
            "                case .floatType:\n" +
            "                    args.append(val.floatValue)\n" +
            "                    break\n" +
            "                case .doubleType:\n" +
            "                    args.append(val.doubleValue)\n" +
            "                    break\n" +
            "                case .nsIntegerType:\n" +
            "                    args.append(val.intValue)\n" +
            "                    break\n" +
            "                case .cgFloatType:\n" +
            "                    args.append(val.floatValue)\n" +
            "                    break\n" +
            "                default :\n" +
            "                    args.append(val)\n" +
            "                    break\n" +
            "                }\n" +
            "            } else if let val = item as? NSObject {\n" +
            "                args.append(val)\n" +
            "            }\n" +
            "        }\n" +
            "        return getVaList(args)\n" +
            "    }";
}
