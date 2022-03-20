/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.List;
import java.util.Map;

@CMClass
public class NSPredicate extends NSObject implements NSSecureCoding {

    private String predicateFormat;

//    @CMSelector("+ (NSPredicate *)predicateWithFormat:(NSString *)predicateFormat, ...;")
//    public static NSPredicate predicateWithFormat(String predicateFormat, Object... args){
//        return new NSPredicate();
//    }

    @CMSelector("+ (NSPredicate *)predicateWithFormat:(NSString *)predicateFormat \n" +
            "                       argumentArray:(NSArray *)arguments;")
    public static NSPredicate predicateWithFormat(String predicateFormat, List arguments) {
        return new NSPredicate();
    }

    @CMSelector("- (instancetype)predicateWithSubstitutionVariables:(NSDictionary<NSString *,id> *)variables;")
    public NSPredicate predicateWithSubstitutionVariables(Map<String, Object> variables) {
        try {
            return (NSPredicate) clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @CMSelector("+ (NSPredicate *)predicateWithValue:(BOOL)value;")
    public static NSPredicate predicateWithValue(boolean value) {
        return new NSPredicate();
    }
//
//    @CMSelector("+ (NSPredicate *)predicateWithBlock:(BOOL (^)(id evaluatedObject, NSDictionary<NSString *,id> *bindings))block;")
//    public static NSPredicate predicateWithBlock(BlockInputInputOutput<Object ,Map<String,Object>, Boolean> block){
//        return new NSPredicate();
//    }

    @CMSelector("- (BOOL)evaluateWithObject:(id)object;")
    public boolean evaluateWithObject(Object object) {
        return true;
    }

    @CMSelector("- (BOOL)evaluateWithObject:(id)object \n" +
            "     substitutionVariables:(NSDictionary<NSString *,id> *)bindings;")
    public boolean evaluateWithObject(Object object, Map<String, Object> bindings) {
        return true;
    }

    @CMSelector("- (void)allowEvaluation;")
    public void allowEvaluation() {
    }

    @CMGetter("@property(readonly, copy) NSString *predicateFormat;")
    public String predicateFormat() {
        return predicateFormat;
    }

}
