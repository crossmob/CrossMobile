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
package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

@CMClass
public class CNLabeledValue<ValueType> extends NSObject implements Cloneable {

    private final String label;
    private final ValueType value;

    private final static String identifier = "";
    private final static String CNLabelHome = "";
    private final static String CNLabelWork = "";
    private final String CNLabelOther = "";

    private final String CNLabelEmailiCloud = "";
    private final String CNLabelURLAddressHomePage = "";
    private final String CNLabelDateAnniversary = "";

    @CMConstructor("- (instancetype)initWithLabel:(NSString *)label value:(ValueType)value;")
    public CNLabeledValue(String label, ValueType value) {
        this.label = label;
        this.value = value;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *label;")
    public String label() {
        return label;
    }

    @CMGetter("@property(readonly, copy, nonatomic) ValueType value;")
    public ValueType value() {
        return value;
    }

    @CMSelector("+ (NSString *)localizedStringForLabel:(NSString *)label;")
    public static String localizedStringForLabel(String label) {
        return label;
    }

    @CMSelector("- (instancetype)labeledValueBySettingLabel:(NSString *)label;")
    public CNLabeledValue labeledValueBySettingLabel(String label) {
        CNLabeledValue xs = new CNLabeledValue(this.label, value);
        return xs;
    }
}
