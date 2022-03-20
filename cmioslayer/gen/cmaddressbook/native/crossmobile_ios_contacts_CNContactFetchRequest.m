// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNContactFetchRequest implementation

#import "crossmobile_ios_contacts_CNContactFetchRequest.h"
#import "java_util_List.h"

@implementation crossmobile_ios_contacts_CNContactFetchRequest$Ext

@end

@implementation CNContactFetchRequest (cm_crossmobile_ios_contacts_CNContactFetchRequest)

// - (instancetype)initWithKeysToFetch:(NSArray<id<CNKeyDescriptor>> *)keysToFetch;
- (instancetype) __init_crossmobile_ios_contacts_CNContactFetchRequest___java_util_List:(NSArray*) keysToFetch 
{
    return [self initWithKeysToFetch:(keysToFetch == JAVA_NULL ? nil : keysToFetch)];
}

// @property(copy, nonatomic) NSArray<id<CNKeyDescriptor>> *keysToFetch;
- (void) setKeysToFetch___java_util_List:(NSArray*) keysToFetch 
{
    [self setKeysToFetch:(keysToFetch == JAVA_NULL ? nil : keysToFetch)];
}

// @property(copy, nonatomic) NSArray<id<CNKeyDescriptor>> *keysToFetch;
- (NSArray*) keysToFetch__
{
    NSArray* re$ult = [self keysToFetch];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL mutableObjects;
- (void) setMutableObjects___boolean:(BOOL) mutableObjects 
{
    [self setMutableObjects:mutableObjects];
}

// @property(nonatomic) BOOL mutableObjects;
- (BOOL) mutableObjects__
{
    return [self mutableObjects];
}

// @property(nonatomic) CNContactSortOrder sortOrder;
- (void) setSortOrder___int:(int) sortOrder 
{
    [self setSortOrder:sortOrder];
}

// @property(nonatomic) CNContactSortOrder sortOrder;
- (int) sortOrder__
{
    return [self sortOrder];
}

// @property(nonatomic) BOOL unifyResults;
- (void) setUnifyResults___boolean:(BOOL) unifyResults 
{
    [self setUnifyResults:unifyResults];
}

// @property(nonatomic) BOOL unifyResults;
- (BOOL) unifyResults__
{
    return [self unifyResults];
}

@end
