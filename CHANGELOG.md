# Changelog

Click on the version header to go to the actual commits for each release.

## [HEAD]
###### now

### Added
- First-class support of obfuscation in Android & Desktop by ProGuard
- Launch Android emulator in CrossMobile management application
- Added Android Log level filters
- Added `accessibilityIdentifier` to be able to support UI testing

### Fixed
- UITableView behaviour better matches the iOS devices
- Update visuals when changing signing key in android target
- Able to override `loadView` when loading a view from a StoryBoard

### Changed
- Move location of `NSLog` from `NSLog.log` to `Foundation.NSLog`

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

[HEAD]: https://github.com/crossmob/CrossMobile/compare/v2.6.1...HEAD
[v2.6.1]: https://github.com/crossmob/CrossMobile/compare/v2.6...v2.6.1
[v2.6]: https://github.com/crossmob/CrossMobile/compare/v2.5...v2.6
[v2.5]: https://github.com/crossmob/CrossMobile/compare/v2.5.pre1.cm...v2.5
[v2.5.pre1.cm]: https://github.com/crossmob/CrossMobile/tree/v2.5.pre1.cm
