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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock3;

import java.util.Map;

@CMTarget
public interface NSItemProviderLoadHandler extends VoidBlock3<NSItemProviderCompletionHandler, Class, Map<String, Object>> {

    @CMBlock("void (^NSItemProviderLoadHandler)(NSItemProviderCompletionHandler completionHandler, Class expectedValueClass, NSDictionary *options);")
    @Override
    void invoke(NSItemProviderCompletionHandler completionHandler, Class expectedValueClass, Map<String, Object> options);
}
