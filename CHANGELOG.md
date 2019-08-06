# Changelog
This is the CrossMobile change log.

## [HEAD] - now

### Added
- Support Adaptive icons under Android
- Bootstrap mechanism to install required Android libraries for compailation
- hidesBackButton functionality
- Launch options under Android gather Intent data
- Display Android log even when application is not running in Manager

### Fixed
- Notifications under Android updated and fixed
- Permissions dialog follows theme
- UIView event callbacks properly invoked
- Safer handling of plugins
- Null pointer exception in UITextView

### Changed
- Embed JRE 11 instead of 8
- UIApplicationLaunchOptions renamed to UIApplicationLaunchOptionsKey
- Update to latest Android libraries
- New mechanism to inject Android build elements in gradle.build script
- Request storage permission if Foundation object is referenced

### Removed
- Obsolete JavaFX build dependency

## [v2.5] - 2019-7-1

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

## [v2.5.pre1.cm] - 2019-5-1
### Added
- First public source release

[HEAD]: https://github.com/crossmob/CrossMobile/compare/v2.5...HEAD
[v2.5]: https://github.com/crossmob/CrossMobile/compare/v2.5.pre1.cm...v2.5
[v2.5.pre1.cm]: https://github.com/crossmob/CrossMobile/tree/v2.5.pre1.cm
