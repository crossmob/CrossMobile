/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

@SuppressWarnings("rawtypes")
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

    @SuppressWarnings("unchecked")
    @CMSelector("- (instancetype)labeledValueBySettingLabel:(NSString *)label;")
    public CNLabeledValue labeledValueBySettingLabel(String label) {
        CNLabeledValue xs = new CNLabeledValue(this.label, value);
        return xs;
    }
}
