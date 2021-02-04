# Changelog

Click on the version header to go to the actual commits for each release.

## [v3.4.0]
###### 2021-2-2

### Added
- Algorithmic theme support
- Support VS Code/Codium as an IDE target, including a plugin
- Support for Arrays methods in iOS
- Create iOS bindings even on non-macOS platforms
- Create packages of all targets on all supported operating systems

### Fixed
- Fix packaging of ARM32 and ARM64 targets
- Wrong caching of metrics for UILabel
- Improve support of font metrics
- Font is now handled properly by its PS name
- Various graphics bugfixes
- Support snap executables and IntelliJ deep nesting toolkits
- Interface Builder parser updates
- Fix HiDPI on Linux, even when called from the command line
- Inform user for SDK Manager issue when JDK != 8
- Fix ADB launcher on Linux. 
- Improve debug info when crashing
- Fix UIResponder.nextResponder

### Removed
- Deprecated class UIWebView removed to be compatible with AppStore 
- Obsolete styled theme

## [v3.3.0]
###### 2020-10-26

### Added
- Introduce WebKit support
- iOS target support maskView
- Added more methods to CGContext and CGPath
- Support clipping shapes
- In UILabel, support textRectForBounds and drawTextInRect
- In NSString, support support stringByReplacingCharactersInRange

### Fixed
- Nullability in native code is tested for nil objects, not only for JAVA_NULL
- Locations of native widgets are correctly placed when the device is not portrait mode
- Text delegates under Swing properly fire events
- iOS mapping of Map object is now an interface, not a protocol
- Equality method for Class object
- Equality methods for Number object
- Updates in Double object
- Fix Android text widget null pointer exception
- UIViewContentMode affects only UIImageView, not every widget
- Interface Builder can now define aspect ratio and support separatorStyle
- Fix fileURLWithPath to return null when no file exists or if null is provided

### Changed
- UIWebView now is in WebKit package and needs to be imported as a plugin

### Removed
- Obsolete OpenGL framework for iOS

## [v3.2.0]
###### 2020-09-18

### Added
- Custom iOS deployment target
- Support ViewController-based status bar visibility properties
- Support of non-deprecated version of UIApplication.openURL

### Fixed
- Update Android target to 30
- Optimizations on UIImageView animations
- Support UIActivityIndicatorView animation in Interface Builder XML file
- Soft navigation bar color follows status bar color
- Math.random() under iOS is really random

### Changed
- Using native methods for animation synchronization & event scheduling
- Parse XIB files only if required
- Improved Android installing logging
- Update minimum Java version to 15

## [v3.1.0]
###### 2020-08-01

### Added
- Create transferable plugin packages
- Installing plugin packages
- Allow deployment of cmioslayer artifact, to make it easier to create custom plugins with full potentiality.
- Added URL-based NSBundle methods
- Initial support JavaFX WebView plugin

### Fixed
- Smoother drag & scroll on Java targets
- On macOS 10.12 & 10.13, default target is iOS 10.0
- Improved emulator launch
- Support of String.split & regular expressions
- Improve NSURL initialization

### Changed
- Plugin registry is based on installed plugins
- Missing configuration options are less intrusive
- Bootstrapping is not required any more

### Removed
- Remove obsolete builddep artifact

## [v3.0.0]
###### 2020-07-07

### Added
- Create Linux Arm 32 & 64 bit targets
- Create Application packages for Windows, Linux and macOS
- Create redistribution packages and installers for Windows 32 bit, Windows 64 bit, macOS, Linux, Linux Arm 32 bit and
 Linux Arm 64 bit operating systems, alongside Android APK files. These packages do not have any external dependencies.
- Plugins could now be created and manipulated from Manager, alongside regular CrossMobile project
- Standardise Plugin mechanism. Now all plugins are of equal quality and features.
- New plugin archetype, to make easier to create custom plugins
- It is possible to resolve external Android build-time requirements from AAR files automatically from inside the Manager
- Full screen display for desktop targets. Also support of various window sizes and orientations.
- Support of user-provided automatically created NSUserDefaults. This feature provides feedback from plugins to the runtime. 
- Definition of vendor, description and URL per project
- Support UIUserInterfaceStyle for iOS targets
- Basic support of sharing URLs with Twitter & Facebook app

### Fixed
- Support JDKs from 1.8 to 14; only JDK with the correct version could be selected
- Properly support scaling for all skins and targets
- Enable HiDPI support on Linux
- Speed up launching of all targets
- Speed up building of external plugins
- Android emulation is now detachable
- Display application name on macOS and fix about dialog
- More than one plugin can now be built on the same Maven project
- Thinner iOS build dependency
- Fix UIScrollView behaviour and visuals
- Various API fixes

### Changed
- To build projects, no more acceptance of the Android SDK License; use Open Source Android Rebuilds instead
- Improved drawing and relayout speed on Java targets, while increasing thread safety
- Simplify plugin creation and definition
- Improved feedback when building Android projects
- Improved font management on desktop clients
- Faster bootstrapping of CrossMobile; no gradle required any more
- General updates to the Manager UI
- Use Docker for package creation
- Renamed the Maven plugin required when creating plugins to follow Maven naming scheme 

### Removed
- Interface Builder files do not require recompilation any more 
- Drop obsolete swift binaries; now iOS runtime is significantly smaller
- Drop support of dedicated ant and older XMLVM based projects

## [v2.9.0]
###### 2020-06-06

### Added
- Support of attach to debugger for Android and Desktop projects
- Display Android and Desktop PID
- Support file chooser under WebView for Android
- Create source artifacts for plugins

### Fixed
- Escape non-URI characters in Android WebView
- Support SDKMAN! repositories

### Changed
- Simplify Manager output panels
- Manager now supports system dark theme on macOS
- Improve plugin creation

## [v2.8.2]
###### 2020-05-05

### Fixed
- Bypass Xcode bug to force using latest (11.4) version
- iOS pipeline does not require any more to clean & build project
- Android SDK build updates
- Fix Android issue not to build APK under certain conditions
- String.format under Android doesn't support back references; use a workaround for this
- Table support archetype
- Materials are properly put into place now
- Improve Manager visuals
- Support of Android SDK on Windows 32 machines

### Changed
- Bump iOS SDK version to 13.0
- Update Manager launchers

## [v2.8]
###### 2020-04-04

### Added
- Dark theme support on macOS
- SPDX headers: more clear license between modules

### Fixed
- Android SDK issues
- Application States are now supported
- Memory leak in initialization String with bytes
- Improved array management
- varargs work now
- Launcher under macOS and Linux

### Changed
- Improved Manager visuals to follow required and non-required elements
- Better Table archetype
- Gradle is downloaded through github and not as a maven dependency

## [v2.7]
###### 2019-10-1

### Added
- First-class support of obfuscation in Android & Desktop by ProGuard
- Launch Android emulator in CrossMobile management application
- Added Android Log level filters
- Added `accessibilityIdentifier` to be able to support UI testing

### Fixed
- UITableView behaviour better matches the iOS devices
- Update visuals when changing signing key in android target
- Able to override `loadView` when loading a view from a StoryBoard
- Use junidecode to handle non-ASCII characters when creating project
- NSLog output in Desktop resembles more the NSLog output of iOS

### Changed
- Move location of `NSLog` from `NSLog.log` to `Foundation.NSLog`
- In macOS all file selection dialogs are native

### Removed
- Optimization of the overridable super call methods in native objects
- Properly remove empty spaces from POM files

## [v2.6.1]
###### 2019-9-15
### Fixed
- Support of bitcode projects

## [v2.6]
###### 2019-9-9
### Added
- Support Adaptive icons under Android
- Bootstrap mechanism to install required Android libraries for compilation
- hidesBackButton functionality
- Launch options under Android gather Intent data
- Display Android log even when application is not running in Manager
- Support UIApplicationState
- Support onNewIntent callbacks on Android
- Support callback methods in ObjectiveC, even with block parameter types (i.e. for notification callbacks)
- libffi for varargs under iOS
- Support of prepareForReuse for UITableViewCell

### Fixed
- Notifications under Android updated and fixed
- Permissions dialog follows theme
- UIView event callbacks properly invoked
- UITableView correctly handles cell height lazily
- I18n fixes on plural handling
- Safer handling of plugins
- Null pointer exception in UITextView
- Android KitKat issues with launcher and application
- UIStepper auto-repeat always ends
- Unregistering Android application
- Backwards compatible up to macOS 10.12

### Changed
- More archetypes added
- Embed JRE 11 instead of 8
- UIApplicationLaunchOptions renamed to UIApplicationLaunchOptionsKey
- Update to latest Android libraries
- New mechanism to inject Android build elements in gradle.build script
- Request storage permission if Foundation object is referenced

### Removed
- Obsolete JavaFX build dependency
- Swift as dependency for varargs

## [v2.5]
###### 2019-7-1
### Added
- First public binary stable release
- Animation API updates
- Ability to force localization under Java
- More Collection methods under iOS
- loadViewIfNeeded and viewIfLoaded

### Fixed
- Translucent menu bar in Android
- Improved Antialiasing
- ScrollView is less sensitive to finger movement
- Fix positional parameters in NSString with iOS notation
- Dark theme is usable

### Changed
- Embed JRE to Manager
- Use stock retrolambda library
- Permissions are asked only once per session 

### Removed
- Application exit parameter
- Debug project
- XRay plugin

## [v2.5.pre1.cm]
###### 2019-5-1
### Added
- First public source release

[v3.4.0]: https://github.com/crossmob/CrossMobile/compare/v3.3.0...v3.4.0
[v3.3.0]: https://github.com/crossmob/CrossMobile/compare/v3.2.0...v3.3.0
[v3.2.0]: https://github.com/crossmob/CrossMobile/compare/v3.1.0...v3.2.0
[v3.1.0]: https://github.com/crossmob/CrossMobile/compare/v3.0.0...v3.1.0
[v3.0.0]: https://github.com/crossmob/CrossMobile/compare/v2.9.0...v3.0.0
[v2.9.0]: https://github.com/crossmob/CrossMobile/compare/v2.8.2...v2.9.0
[v2.8.2]: https://github.com/crossmob/CrossMobile/compare/v2.8.0...v2.8.2
[v2.8]: https://github.com/crossmob/CrossMobile/compare/v2.7...v2.8.0
[v2.7]: https://github.com/crossmob/CrossMobile/compare/v2.6.1...v2.7
[v2.6.1]: https://github.com/crossmob/CrossMobile/compare/v2.6...v2.6.1
[v2.6]: https://github.com/crossmob/CrossMobile/compare/v2.5...v2.6
[v2.5]: https://github.com/crossmob/CrossMobile/compare/v2.5.pre1.cm...v2.5
[v2.5.pre1.cm]: https://github.com/crossmob/CrossMobile/tree/v2.5.pre1.cm
