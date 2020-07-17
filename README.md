# Retrofit-Http-Request-Without-MVVM
> Retrofit Http Request Without MVVM Architerture

## build.gradle (Module.app) Implementation

```kotlin
     ...
     
    //Retrofit
    def retrofit_version = "2.6.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"

    //Coroutine
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7"

    //Glide (Picasso Alternative)
    def glide_version = "4.11.0"
    implementation "com.github.bumptech.glide:glide:$glide_version"

    //Recycler View
    def recycler_view_version = "1.1.0"
    implementation "androidx.recyclerview:recyclerview:$recycler_view_version"

    //Card View
    def card_view_version = "1.0.0"
    implementation "androidx.cardview:cardview:$card_view_version"
```

---

> Nasıl implement ederim ?

<img src="/images/implemetation.gif"/> 

***Package Architecture***

<img src="/images/retrofitPackageYapısı.png"/> 

> Sample screen

<img src="/images/retrofitOutput.png" width="400"/> 
