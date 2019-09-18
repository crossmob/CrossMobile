# How to compile CrossMobile

## Requirements:
**Please note that in order to use the iOS backend, a macOS machine is required. Likewise for the UWP backend.**

- gradle version 5.x
- maven
- unzip
- nuget

### Ubuntu
Run the followin commands to install the tools and set-up the Java 8 SDK
```sh
sudo apt-get install nuget maven unzip openjdk-8-jdk
sudo update-alternatives --config java
```
and make sure that Java 8 is selected.

You also need to install `gradle` version 5.1.1+. Please install it manually and make sute that it is in your path.

### macOS
- Install Xcode
- Run the following command:
```
brew install gradle nuget maven
brew cask install adoptopenjdk8
```
- Make sure JDK 8 is the default environment.

## Install Android SDK
- Make sure Android SDK is installed and available.
- Either Android Studio or Android SDK command line tools is required.
- Note down the location of Android SDK tools. For example, Android Studio usually installs SDK:
    - in Linux is under `~/Android/Sdk`
    - in macOS is under `~/Library/Android/sdk`
    - in Windows is under `%HOME%\AppData\Local\Android\Sdk`
    - ... or use the location of the command line tools root folder
- Use a command similar to the following to define the location of the Android SDK: `export ANDROID_SDK=~/Android/Sdk/`

## Run the bootstap script
On the root folder of CrossMobile issue the following command:
```sh
./resources/bootstrap/bootstrap.sh
```
The Android SDK tools will ask you to accept the Licenses. You have to accept it for the procedure to continue.

## Compile CrossMobile
Go to the root folder of CrossMobile and issue the following command:
```
mvn install
```
The procedure should finish successfully. If the procedure was not able to succeed, please issue a bug report.

Happy hacking!
