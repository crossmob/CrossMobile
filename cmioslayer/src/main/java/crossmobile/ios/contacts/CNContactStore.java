/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSPredicate;
import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;
import org.robovm.objc.block.VoidBlock2;

import java.util.ArrayList;
import java.util.List;

@CMClass
public class CNContactStore extends NSObject {

    @CMSelector("+ (CNAuthorizationStatus)authorizationStatusForEntityType:(CNEntityType)entityType;")
    public static int authorizationStatusForEntityType(int CNEntityType) {
        return CNAuthorizationStatus.Authorized;
    }

    @CMSelector("- (CNContact *)unifiedContactWithIdentifier:(NSString *)identifier \n"
            + "                                keysToFetch:(NSArray<id<CNKeyDescriptor>> *)keys \n"
            + "                                      error:(NSError * _Nullable *)error;")
    public CNContact unifiedContactWithIdentifier(String identifier, List<String> keys, StrongReference<NSError> error) {
        return null;
    }

    @CMSelector("- (NSArray<CNContact *> *)unifiedContactsMatchingPredicate:(NSPredicate *)predicate \n" +
            "                                               keysToFetch:(NSArray<id<CNKeyDescriptor>> *)keys \n" +
            "                                                     error:(NSError * _Nullable *)error;")
    public List<CNContact> unifiedContactsMatchingPredicate(NSPredicate predicate, List<String> keys, StrongReference<NSError> error) {
        return null;
    }

    @CMSelector("- (void)requestAccessForEntityType:(CNEntityType)entityType \n"
            + "                 completionHandler:(void (^)(BOOL granted, NSError *error))completionHandler;")
    public void requestAccessForEntityType(int CNEntityType, VoidBlock2<Boolean, NSError> completionHandler) {
    }

    @CMSelector("- (NSArray<CNGroup *> *)groupsMatchingPredicate:(NSPredicate *)predicate \n" +
            "                                          error:(NSError * _Nullable *)error;")
    public List<CNGroup> groupsMatchingPredicate(NSPredicate predicate, StrongReference<NSError> error) {
        return new ArrayList<>();
    }

    @CMSelector("- (NSArray<CNContainer *> *)containersMatchingPredicate:(NSPredicate *)predicate \n" +
            "                                                  error:(NSError * _Nullable *)error;")
    public List<CNContainer> containersMatchingPredicate(NSPredicate predicate, StrongReference<NSError> error) {
        return new ArrayList<>();
    }

    @CMSelector("- (NSString *)defaultContainerIdentifier;")
    public String defaultContainerIdentifier() {
        return "";
    }

//    @CMSelector("- (BOOL)enumerateContactsWithFetchRequest:(CNContactFetchRequest *)fetchRequest \n" +
//            "                                    error:(NSError * _Nullable *)error \n" +
//            "                               usingBlock:(void (^)(CNContact *contact, BOOL *stop)) block;")
//    public boolean enumerateContactsWithFetchRequest(CNContactFetchRequest fetchRequest, StrongReference<NSError> error, BlockInputInput<CNContact, StrongReference<Boolean>> block) {
//        return true;
//    }

    @CMSelector("- (BOOL)executeSaveRequest:(CNSaveRequest *)saveRequest \n" +
            "                     error:(NSError * _Nullable *)error;")
    public boolean executeSaveRequest(CNSaveRequest saveRequest, StrongReference<NSError> error) {
        return true;
    }
}
