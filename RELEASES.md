# Release Information Highlights

Click on the version header to go to the detailed ChangeLog.

## [v2.8.2]

- Use library on older versions of Xcode, bypassing 11.4 Xcode bug.
- Upgrade target iOS SDK version to 13.0, as requested upstream.
- Optimizations on the iOS backend; the system is smart enough to compile only the required files.
- Android backend compilation updates and optimizations.

## [v2.8]

- Dark theme is officialy supported on macOS, thanks to the new [javalauncher], written in `nim`, which is able to better locate JRE and launch the application.
- License of modules is more clear now: all runtime parts are still in permissive LGPL license, while non-redistributable are under AGPL license.
- Fix various Andoid SDK issues. The build system is again more compatible with current Android tools.
- Various memory issues fixed (in String, arrays, and vararg parameters)

## [v2.7]

-  There's a **code breaking** change with NSLog. Now this function lives in Foundation class, instead of it's own arbitrary class. The fix is easy, to replace all calls of `NSLog.log` with `Foundation.NSLog`, but it will not be performed automatically.
- Optimization of the overridable super call methods in native objects. Up to now there was a wrapper for all possible combinations of overriden methods on native objects. This was needed to be possible to call the `super` method on any native method that was overriden in Java. Otherwise it was either impossible or was a runtime infinite loop. This added a huge runtime overhead and made it costly to create new methods in root objects (i.e. on NSObject). With this new method overridable parts are inserted at compile time with custom categories per request, elliminating the overhead and cutting down runtime libraries into half size.
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

[v2.8.2]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v282
[v2.8]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v28
[v2.7]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v27
[v2.6.1]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v261
[v2.6]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v26
[v2.5]: https://github.com/crossmob/CrossMobile/blob/master/CHANGELOG.md#v25
[javalauncher]: https://github.com/teras/javalauncher
