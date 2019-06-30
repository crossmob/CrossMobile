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
