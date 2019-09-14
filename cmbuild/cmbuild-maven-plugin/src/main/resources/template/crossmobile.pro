###################
# Android section #
###################

-keep public interface org.crossmobile.backend.android.ActivityResultListener{ public *; }
-keep public interface org.crossmobile.backend.android.ActivityLifecycleListener{ public *; }

-keep public class com.android.vending.billing.* { public protected *; }

-keep public class org.crossmobile.backend.android.ActivityStateListener{ public *; }
-keep public class org.crossmobile.backend.android.ApplicationStateListener { public *; }
-keep public class org.crossmobile.backend.android.ActivityPermissionListener { public *; }
-keep public class org.crossmobile.backend.android.MainApplication{ public *; }
-keep public class org.crossmobile.backend.android.MainActivity{ public *; }
-keep public class org.crossmobile.backend.android.MainView{ public *; }
-keep public class org.crossmobile.backend.android.notifications.** { public *; }
-keep public class org.crossmobile.build.StoryBoardBinder { public *; }

-keep class **.R
-keep class **.R$* { <fields>; }


###################
# Desktop section #
###################

-dontnote com.panayotis.appenh.**

-keep public class org.crossmobile.backend.desktop.Chassis{ public *; }
-keep public class org.crossmobile.backend.desktop.javazoom.* { public *; }


###################
# Generic section #
###################

-dontnote crossmobile.ios.**
-dontwarn crossmobile.ios.uikit.UIUserNotificationSettings
-dontwarn crossmobile.ios.uikit.UIApplication

-dontwarn org.crossmobile.**
-dontnote org.crossmobile.**

-keep public class org.crossmobile.sys.** { public *; }
-keep public class org.crossmobile.bridge.CrossMobilePlugin { public *; }
-keep public class org.crossmobile.build.StoryBoardBinder { public *; }
-keep public class * implements org.crossmobile.bridge.CrossMobilePlugin { public *; }
-keep public class com.panayotis.** { public *; }

-keepclasseswithmembers public class * { public static void main(java.lang.String[]); }
-keepclasseswithmembernames,includedescriptorclasses class * { native <methods>; }

-keepclassmembernames class * {
      java.lang.Class class$(java.lang.String);
      java.lang.Class class$(java.lang.String, boolean);
}


-keepclassmembers,allowoptimization enum * {
      public static **[] values();
      public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements java.io.Serializable {
      static final long serialVersionUID;
      private static final java.io.ObjectStreamField[] serialPersistentFields;
      private void writeObject(java.io.ObjectOutputStream);
      private void readObject(java.io.ObjectInputStream);
      java.lang.Object writeReplace();
      java.lang.Object readResolve();
}
