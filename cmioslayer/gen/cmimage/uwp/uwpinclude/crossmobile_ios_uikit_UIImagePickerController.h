// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIImagePickerController definition

#import "xmlvm.h"
#import <CoreImage/CoreImage.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGAffineTransform;
@class crossmobile_ios_uikit_UIView;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIImagePickerController$Ext : UIImagePickerController
@end

#define crossmobile_ios_uikit_UIImagePickerController UIImagePickerController
@interface UIImagePickerController (cm_crossmobile_ios_uikit_UIImagePickerController)
+ (NSArray*) availableCaptureModesForCameraDevice___int:(int) cameraDevice ;
+ (NSArray*) availableMediaTypesForSourceType___int:(int) sourceType ;
+ (BOOL) isCameraDeviceAvailable___int:(int) cameraDevice ;
+ (BOOL) isFlashAvailableForCameraDevice___int:(int) cameraDevice ;
+ (BOOL) isSourceTypeAvailable___int:(int) sourceType ;
- (instancetype) __init_crossmobile_ios_uikit_UIImagePickerController__;
- (void) setAllowsEditing___boolean:(BOOL) allowsEditing ;
- (BOOL) allowsEditing__;
- (void) setCameraCaptureMode___int:(int) cameraCaptureMode ;
- (int) cameraCaptureMode__;
- (void) setCameraDevice___int:(int) cameraDevice ;
- (int) cameraDevice__;
- (void) setCameraFlashMode___int:(int) cameraFlashMode ;
- (int) cameraFlashMode__;
- (void) setCameraOverlayView___crossmobile_ios_uikit_UIView:(UIView*) cameraOverlayView ;
- (UIView*) cameraOverlayView__;
- (void) setCameraViewTransform___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) cameraViewTransform ;
- (crossmobile_ios_coregraphics_CGAffineTransform*) cameraViewTransform__;
- (void) setMediaTypes___java_util_List:(NSArray*) mediaTypes ;
- (NSArray*) mediaTypes__;
- (void) setShowsCameraControls___boolean:(BOOL) showsCameraControls ;
- (BOOL) showsCameraControls__;
- (void) setSourceType___int:(int) sourceType ;
- (int) sourceType__;
- (void) setVideoMaximumDuration___double:(double) videoMaximumDuration ;
- (double) videoMaximumDuration__;
- (void) setVideoQuality___int:(int) videoQuality ;
- (int) videoQuality__;
- (BOOL) startVideoCapture__;
- (void) stopVideoCapture__;
- (void) takePicture__;
@end
