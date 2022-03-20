// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPickerViewDataSource definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIPickerView;

@protocol crossmobile_ios_uikit_UIPickerViewDataSource
- (int) numberOfComponentsInPickerView___crossmobile_ios_uikit_UIPickerView:(UIPickerView*) pickerView ;
- (int) numberOfRowsInComponent___crossmobile_ios_uikit_UIPickerView_int:(UIPickerView*) pickerView :(int) component ;
@end
