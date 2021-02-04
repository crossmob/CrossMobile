# Release Information Highlights

Click on the version header to go to the detailed ChangeLog.

## [v3.4.0]

- The UIWebView is removed completely from the API, to be compatible with Apple's guidelines. Please use WebKit instead.
- Algorithmic theme support
- Support VS Code/Codium as an IDE target, including a plugin
- Create packages of all targets on all supported operating systems
- Various bug fixes and improvements

## [v3.3.0]

- Introduce WebKit support; **it is required to add WebKit plugin now to present any web view (including UIWebView)**
- Improved nullability checks in native code
- Locations of native widgets are correctly placed
- Update CGContext functions and clipping shapes
- Remove obsolete OpenGL framework for iOS
- Various updates and bug fixes, in Java and iOS code

## [v3.2.0]

- Using native methods for animation synchronization & event scheduling, making more smooth and fluid animations
- Update Android SDK version to 30
- Support ViewController-based status bar visibility properties
- Various updates and bug fixes

## [v3.1.0]

- Create transferable and installable plugin packages
- Smoother scrolling when dragging
- Various bug fixes and updates

## [v3.0.0]

- Support Linux Arm (32 & 64 bit) alongside Windows (32 and 64 bit), Linux (x86-64) and macOS
- Create application packages and installers/redistribution self-contained packages for all supported platforms
- Support JDKs 1.8 - 14. The Open Source Android Rebuilds project is now used as
    the core Android SDK 
- Create, manage, fetch dependencies, and compile of user created plugins for CrossMobile, from inside CrossMobile
    manager. Now plugins are first class citizens
- CrossMobile applications can now be used as full desktop applications, including full screen and HiDPI monitors
- Speedups and bug fixes

## [v2.9.0]

- Attach to debugger for Android and Desktop projects
- Support file chooser under WebView for Android
- Create source artifacts for plugins

## [v2.8.2]

- Use library on older versions of Xcode, bypassing 11.4 Xcode bug.
- Upgrade target iOS SDK version to 13.0, as requested upstream.
- Optimizations on the iOS backend; the system is smart enough to compile only the required files.
- Android backend compilation updates and optimizations.

## [v2.8]

- Dark theme is officially supported on macOS, thanks to the new [java launcher], written in `nim`, which is able to better locate JRE and launch the application.
- License of modules is more clear now: all runtime parts are still in permissive LGPL license, while non-redistributable are under AGPL license.
- Fix various Android SDK issues. The build system is again more compatible with current Android tools.
- Various memory issues fixed (in String, arrays, and vararg parameters)

## [v2.7]

-  There's a **code breaking** change with NSLog. Now this function lives in Foundation class, instead of it's own arbitrary class. The fix is easy, to replace all calls of `NSLog.log` with `Foundation.NSLog`, but it will not be performed automatically.
- Optimization of the overridable super call methods in native objects. Up to now there was a wrapper for all possible combinations of overridden methods on native objects. This was needed to be possible to call the `super` method on any native method that was overridden in Java. Otherwise it was either impossible or was a runtime infinite loop. This added a huge runtime overhead and made it costly to create new methods in root objects (i.e. on NSObject). With this new method overridable parts are inserted at compile time with custom categories per request, eliminating the overhead and cutting down runtime libraries into half size.
- Obfuscation is support in application compilation, not in library level. Now it is easier and officially supported to create obfuscated Android applications.
- Launch Android emulator in CrossMobile management application 

## [v2.6.1]
- Fixed support of bitcode projects

## [v2.6]
- Update to latest Android libraries, including `androidx.*`
- Notification fixes for Android
- Adaptive icons under Android
- Make the library backwards compatible to macOS 10.12 build environment
- Use libffi for vararg methods. Up to now the vararg methods were emulated through the Swift backend, since the usual way to call vararg methods was broken when Apple introduced Swift. This made CrossMobile applications depend on Swift runtime, not only making executable bigger, but also more fragile since Swift is still a moving target. From this release onwards libffi is used instead and no more dependency is present for Swift runtime. 

## [v2.5]
- First public binary stable release

[v3.4.0]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v340
[v3.3.0]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v330
[v3.2.0]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v320
[v3.1.0]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v310
[v3.0.0]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v300
[v2.9.0]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v290
[v2.8.2]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v282
[v2.8]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v28
[v2.7]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v27
[v2.6.1]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v261
[v2.6]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v26
[v2.5]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v25
[javalauncher]: https://github.com/teras/javalauncher
