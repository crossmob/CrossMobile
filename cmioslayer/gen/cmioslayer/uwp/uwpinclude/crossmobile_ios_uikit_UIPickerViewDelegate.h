// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UIPickerViewDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIPickerView;
@class crossmobile_ios_uikit_UIView;
@class java_lang_String;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UIPickerViewDelegate
- (void) didSelectRow___crossmobile_ios_uikit_UIPickerView_int_int:(UIPickerView*) pickerView :(int) row :(int) component ;
- (double) rowHeightForComponent___crossmobile_ios_uikit_UIPickerView_int:(UIPickerView*) pickerView :(int) component ;
- (NSString*) titleForRow___crossmobile_ios_uikit_UIPickerView_int_int:(UIPickerView*) pickerView :(int) row :(int) component ;
- (UIView*) viewForRow___crossmobile_ios_uikit_UIPickerView_int_int_crossmobile_ios_uikit_UIView:(UIPickerView*) pickerView :(int) row :(int) component :(UIView*) view ;
- (double) widthForComponent___crossmobile_ios_uikit_UIPickerView_int:(UIPickerView*) pickerView :(int) component ;
@end
