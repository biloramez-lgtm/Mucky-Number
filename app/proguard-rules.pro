# Keep MainActivity
-keep class com.muckynumber.game.MainActivity { *; }

# Keep all Activities
-keep public class * extends android.app.Activity

# Keep all Application classes
-keep public class * extends android.app.Application

# Keep R classes
-keepclassmembers class **.R$* {
    public static <fields>;
}

# Keep kotlin
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }

# AndroidX
-keep class androidx.** { *; }

# Google Play Services
-keep class com.google.android.gms.** { *; }

# Disable obfuscation
-dontobfuscate
