// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKPreferences definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>

@interface crossmobile_ios_webkit_WKPreferences$Ext : WKPreferences
@end

#define crossmobile_ios_webkit_WKPreferences WKPreferences
@interface WKPreferences (cm_crossmobile_ios_webkit_WKPreferences)
- (instancetype) __init_crossmobile_ios_webkit_WKPreferences__;
- (void) setFraudulentWebsiteWarningEnabled___boolean:(BOOL) fraudulentWebsiteWarningEnabled ;
- (BOOL) isFraudulentWebsiteWarningEnabled__;
- (void) setJavaScriptCanOpenWindowsAutomatically___boolean:(BOOL) javaScriptCanOpenWindowsAutomatically ;
- (BOOL) javaScriptCanOpenWindowsAutomatically__;
- (void) setMinimumFontSize___double:(double) minimumFontSize ;
- (double) minimumFontSize__;
- (void) setTabFocusesLinks___boolean:(BOOL) tabFocusesLinks ;
- (BOOL) tabFocusesLinks__;
@end
