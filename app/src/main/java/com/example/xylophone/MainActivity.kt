package com.example.xylophone

import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import es.dmoral.toasty.Toasty

@Suppress("DEPRECATION")

class MainActivity : AppCompatActivity() {

    private val soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        SoundPool.Builder().setMaxStreams(7).build()
    } else {
        SoundPool(7, AudioManager.STREAM_MUSIC, 0)
    }

    private val sounds = listOf(
        Pair(R.id.button1, R.raw.note1),
        Pair(R.id.button2, R.raw.note2),
        Pair(R.id.button3, R.raw.note3),
        Pair(R.id.button4, R.raw.note4),
        Pair(R.id.button5, R.raw.note5),
        Pair(R.id.button6, R.raw.note6),
        Pair(R.id.button7, R.raw.note7)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sounds?.forEach { tune(it) }
    }

    private fun tune(pitch: Pair<Int,Int>){
        val soundId: Int = soundPool.load(this, pitch.second, 1)
        findViewById<Button>(pitch.first).setOnClickListener {
            soundPool.play(soundId, 1.0F, 1.0F, 0, 0, 1.0F)
            Toasty.normal(this, "", Toast.LENGTH_SHORT, ContextCompat.getDrawable(this, R.drawable.music_note)).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }
}
