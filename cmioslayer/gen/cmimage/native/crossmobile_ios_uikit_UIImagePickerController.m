// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIImagePickerController implementation

#import "crossmobile_ios_coregraphics_CGAffineTransform.h"
#import "crossmobile_ios_uikit_UIImagePickerController.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIImagePickerController$Ext

@end

@implementation UIImagePickerController (cm_crossmobile_ios_uikit_UIImagePickerController)

// + (NSArray<NSNumber *> *)availableCaptureModesForCameraDevice:(UIImagePickerControllerCameraDevice)cameraDevice;
+ (NSArray*) availableCaptureModesForCameraDevice___int:(int) cameraDevice 
{
    NSArray* re$ult = [UIImagePickerController availableCaptureModesForCameraDevice:cameraDevice];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSArray<NSString *> *)availableMediaTypesForSourceType:(UIImagePickerControllerSourceType)sourceType;
+ (NSArray*) availableMediaTypesForSourceType___int:(int) sourceType 
{
    NSArray* re$ult = [UIImagePickerController availableMediaTypesForSourceType:sourceType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (BOOL)isCameraDeviceAvailable:(UIImagePickerControllerCameraDevice)cameraDevice;
+ (BOOL) isCameraDeviceAvailable___int:(int) cameraDevice 
{
    return [UIImagePickerController isCameraDeviceAvailable:cameraDevice];
}

// + (BOOL)isFlashAvailableForCameraDevice:(UIImagePickerControllerCameraDevice)cameraDevice;
+ (BOOL) isFlashAvailableForCameraDevice___int:(int) cameraDevice 
{
    return [UIImagePickerController isFlashAvailableForCameraDevice:cameraDevice];
}

// + (BOOL)isSourceTypeAvailable:(UIImagePickerControllerSourceType)sourceType;
+ (BOOL) isSourceTypeAvailable___int:(int) sourceType 
{
    return [UIImagePickerController isSourceTypeAvailable:sourceType];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIImagePickerController__
{
    return [self init];
}

// @property(nonatomic) BOOL allowsEditing;
- (void) setAllowsEditing___boolean:(BOOL) allowsEditing 
{
    [self setAllowsEditing:allowsEditing];
}

// @property(nonatomic) BOOL allowsEditing;
- (BOOL) allowsEditing__
{
    return [self allowsEditing];
}

// @property(nonatomic) UIImagePickerControllerCameraCaptureMode cameraCaptureMode;
- (void) setCameraCaptureMode___int:(int) cameraCaptureMode 
{
    [self setCameraCaptureMode:cameraCaptureMode];
}

// @property(nonatomic) UIImagePickerControllerCameraCaptureMode cameraCaptureMode;
- (int) cameraCaptureMode__
{
    return [self cameraCaptureMode];
}

// @property(nonatomic) UIImagePickerControllerCameraDevice cameraDevice;
- (void) setCameraDevice___int:(int) cameraDevice 
{
    [self setCameraDevice:cameraDevice];
}

// @property(nonatomic) UIImagePickerControllerCameraDevice cameraDevice;
- (int) cameraDevice__
{
    return [self cameraDevice];
}

// @property(nonatomic) UIImagePickerControllerCameraFlashMode cameraFlashMode;
- (void) setCameraFlashMode___int:(int) cameraFlashMode 
{
    [self setCameraFlashMode:cameraFlashMode];
}

// @property(nonatomic) UIImagePickerControllerCameraFlashMode cameraFlashMode;
- (int) cameraFlashMode__
{
    return [self cameraFlashMode];
}

// @property(nonatomic, strong) __kindof UIView *cameraOverlayView;
- (void) setCameraOverlayView___crossmobile_ios_uikit_UIView:(UIView*) cameraOverlayView 
{
    [self setCameraOverlayView:(cameraOverlayView == JAVA_NULL ? nil : cameraOverlayView)];
}

// @property(nonatomic, strong) __kindof UIView *cameraOverlayView;
- (UIView*) cameraOverlayView__
{
    UIView* re$ult = [self cameraOverlayView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) CGAffineTransform cameraViewTransform;
- (void) setCameraViewTransform___crossmobile_ios_coregraphics_CGAffineTransform:(crossmobile_ios_coregraphics_CGAffineTransform*) cameraViewTransform 
{
    [self setCameraViewTransform:[cameraViewTransform getCGAffineTransform]];
}

// @property(nonatomic) CGAffineTransform cameraViewTransform;
- (crossmobile_ios_coregraphics_CGAffineTransform*) cameraViewTransform__
{
    return [[crossmobile_ios_coregraphics_CGAffineTransform alloc] initWithCGAffineTransform:[self cameraViewTransform]];
}

// @property(nonatomic, copy) NSArray<NSString *> *mediaTypes;
- (void) setMediaTypes___java_util_List:(NSArray*) mediaTypes 
{
    [self setMediaTypes:(mediaTypes == JAVA_NULL ? nil : mediaTypes)];
}

// @property(nonatomic, copy) NSArray<NSString *> *mediaTypes;
- (NSArray*) mediaTypes__
{
    NSArray* re$ult = [self mediaTypes];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL showsCameraControls;
- (void) setShowsCameraControls___boolean:(BOOL) showsCameraControls 
{
    [self setShowsCameraControls:showsCameraControls];
}

// @property(nonatomic) BOOL showsCameraControls;
- (BOOL) showsCameraControls__
{
    return [self showsCameraControls];
}

// @property(nonatomic) UIImagePickerControllerSourceType sourceType;
- (void) setSourceType___int:(int) sourceType 
{
    [self setSourceType:sourceType];
}

// @property(nonatomic) UIImagePickerControllerSourceType sourceType;
- (int) sourceType__
{
    return [self sourceType];
}

// @property(nonatomic) NSTimeInterval videoMaximumDuration;
- (void) setVideoMaximumDuration___double:(double) videoMaximumDuration 
{
    [self setVideoMaximumDuration:videoMaximumDuration];
}

// @property(nonatomic) NSTimeInterval videoMaximumDuration;
- (double) videoMaximumDuration__
{
    return [self videoMaximumDuration];
}

// @property(nonatomic) UIImagePickerControllerQualityType videoQuality;
- (void) setVideoQuality___int:(int) videoQuality 
{
    [self setVideoQuality:videoQuality];
}

// @property(nonatomic) UIImagePickerControllerQualityType videoQuality;
- (int) videoQuality__
{
    return [self videoQuality];
}

// - (BOOL)startVideoCapture;
- (BOOL) startVideoCapture__
{
    return [self startVideoCapture];
}

// - (void)stopVideoCapture;
- (void) stopVideoCapture__
{
    [self stopVideoCapture];
}

// - (void)takePicture;
- (void) takePicture__
{
    [self takePicture];
}

@end
