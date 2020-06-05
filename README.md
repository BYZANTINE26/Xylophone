# Xylophone

Learn Kotlin with Google's 30DaysOfKotlin 

This is a simple fun app (Xylophone) that plays different sounds in a musical order each time a bar is tapped . 

# Playing Sounds

The method to play sound is mainly using MediaPlayer class and SoundPool .

In general, the MediaPlayer class is used to play sound files. This class can play both music and video files .


The MediaPlayer class is generally useful for playing long duration sounds and that too only once, like for a song or background music .

However, the SoundPool class is more useful when the xylophone needs to produce small sounds continuously . Therefore, I have used SoundPool in my project .

- To check android version for SoundPool constructor :-
'''kotlin
private val soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        SoundPool.Builder().setMaxStreams(7).build()
    } else {
        SoundPool(7, AudioManager.STREAM_MUSIC, 0)
    }
'''    
