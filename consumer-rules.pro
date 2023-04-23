-keepclassmembers class * implements java.io.Serializable {
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
}

-keepclassmembers class com.afterroot.tmdbapi.model.** {
  *;
}

-keepclassmembers class info.movito.themoviedbapi.model.** {
  *;
}

-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
