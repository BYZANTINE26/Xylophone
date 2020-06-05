# Xylophone

Learn Kotlin with Google's 30DaysOfKotlin 

This is a simple fun app (Xylophone) that plays different sounds in a musical order each time a bar is tapped and shows a toast . 

# Playing Sounds

The method to play sound is mainly using MediaPlayer class and SoundPool .

In general, the MediaPlayer class is used to play sound files. This class can play both music and video files .


The MediaPlayer class is generally useful for playing long duration sounds and that too only once, like for a song or background music .

However, the SoundPool class is more useful when the xylophone needs to produce small sounds continuously . Therefore, I have used SoundPool in my project .

- First import :-
```kotlin
import android.media.AudioManager
import android.media.SoundPool
```

- To build :-
```kotlin
SoundPool.Builder().setMaxStreams(7).build()
```
   OR
```kotlin
SoundPool(7, AudioManager.STREAM_MUSIC, 0)
```
   Depending upon android version

- To check android version :-
```kotlin
private val soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        SoundPool.Builder().setMaxStreams(7).build()
    } else {
        SoundPool(7, AudioManager.STREAM_MUSIC, 0)
    }
```   

- To load :-
```kotlin
soundPool.load(this, pitch.second, 1)
```

- To play :-
```kotlin
soundPool.play(soundId, 1.0F, 1.0F, 0, 0, 1.0F)
```

# Displaying Toast

Toasts are kind of pop-up messages . Toasts can be displayed using toast library or toasty library for some custom toasts . I have incorporated toasty in my project .

To use toasty into your project :-

- add this under `allprojects { repositories {` inside build.gradle(project: )
```
maven { url "https://jitpack.io" }
```

- add this under `dependencies {` inside build.gradle(module: )
```
compile 'com.github.GrenderG:Toasty:1.2.5'
```

- Then sync it .

- import :-
```
import android.widget.Toast
import es.dmoral.toasty.Toasty
```

- To display :-
```kotlin
Toasty.normal(this, "", Toast.LENGTH_SHORT, ContextCompat.getDrawable(this, R.drawable.music_note)).show()
```

# Define click events

Check [MainActivity.kt](https://github.com/BYZANTINE26/Xylophone/blob/master/app/src/main/java/com/example/xylophone/MainActivity.kt)

# Clone

[clone](https://github.com/BYZANTINE26/Xylophone.git)

# Screenshot
<img src="https://user-images.githubusercontent.com/62672863/83907260-c58a8c80-a782-11ea-8160-3277b6e23bc7.jpg" width="299" height="600" />     <img src="https://user-images.githubusercontent.com/62672863/83907498-1f8b5200-a783-11ea-8630-8a8aee157ef6.jpg" width="299" height="600" />

             Xylophone                                 On Click   
