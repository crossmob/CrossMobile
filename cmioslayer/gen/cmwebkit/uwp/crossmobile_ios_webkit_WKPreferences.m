// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKPreferences implementation

#import "crossmobile_ios_webkit_WKPreferences.h"

@implementation crossmobile_ios_webkit_WKPreferences$Ext

@end

@implementation WKPreferences (cm_crossmobile_ios_webkit_WKPreferences)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_webkit_WKPreferences__
{
    return [self init];
}

// @property(nonatomic, getter=isFraudulentWebsiteWarningEnabled) BOOL fraudulentWebsiteWarningEnabled;
- (void) setFraudulentWebsiteWarningEnabled___boolean:(BOOL) fraudulentWebsiteWarningEnabled 
{
    [self setFraudulentWebsiteWarningEnabled:fraudulentWebsiteWarningEnabled];
}

// @property(nonatomic, getter=isFraudulentWebsiteWarningEnabled) BOOL fraudulentWebsiteWarningEnabled;
- (BOOL) isFraudulentWebsiteWarningEnabled__
{
    return [self isFraudulentWebsiteWarningEnabled];
}

// @property(nonatomic) BOOL javaScriptCanOpenWindowsAutomatically;
- (void) setJavaScriptCanOpenWindowsAutomatically___boolean:(BOOL) javaScriptCanOpenWindowsAutomatically 
{
    [self setJavaScriptCanOpenWindowsAutomatically:javaScriptCanOpenWindowsAutomatically];
}

// @property(nonatomic) BOOL javaScriptCanOpenWindowsAutomatically;
- (BOOL) javaScriptCanOpenWindowsAutomatically__
{
    return [self javaScriptCanOpenWindowsAutomatically];
}

// @property(nonatomic) CGFloat minimumFontSize;
- (void) setMinimumFontSize___double:(double) minimumFontSize 
{
    [self setMinimumFontSize:minimumFontSize];
}

// @property(nonatomic) CGFloat minimumFontSize;
- (double) minimumFontSize__
{
    return [self minimumFontSize];
}

// @property(nonatomic) BOOL tabFocusesLinks;
- (void) setTabFocusesLinks___boolean:(BOOL) tabFocusesLinks 
{
    [self setTabFocusesLinks:tabFocusesLinks];
}

// @property(nonatomic) BOOL tabFocusesLinks;
- (BOOL) tabFocusesLinks__
{
    return [self tabFocusesLinks];
}

@end
