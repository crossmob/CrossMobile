![travis status](https://travis-ci.com/crossmob/CrossMobile.svg?branch=master)


# How to compile CrossMobile

### Note! You don't need to recompile CrossMobile yourself to use it! You can use the already created packages from the [download](https://github.com/crossmob/CrossMobile/releases/latest) page

First of all, make sure you have downloaded the full CrossMobile distribution:

```git clone --recursive https://github.com/crossmob/CrossMobile```

or otherwise parts of the code might be missing.

## Requirements:
**Please note that in order to use the iOS backend, a macOS machine is required. Likewise for the UWP backend.**

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

### macOS
- Install Xcode
- Run the following command:
```
brew install nuget maven
brew tap homebrew/cask-versions
brew cask install adoptopenjdk8
```
- Make sure JDK 8 is the default environment.

## Bootstrapping (optional)
Note that this step is **not required** if you want to compile CrossMobile yourself, since the bootstrap dependencies are already in the crossmobile repository.
In the case you want to build them yourself, on the root folder of CrossMobile issue the following command:
```sh
./resources/bin/bootstrap.sh
```

## Compile CrossMobile
Go to the root folder of CrossMobile and issue the following command:
```
mvn install
```
The procedure should finish successfully. If the procedure was not able to succeed, please issue a bug report.


Happy hacking!
