package com.ec.app.sportgiftapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Bitmap
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Build
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.webkit.*
import android.widget.ImageView
import com.ec.app.sportgiftapp.ui.login.LoginActivity
import java.util.*
import kotlin.concurrent.schedule
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.VideoView
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri


class MainActivity : AppCompatActivity() {

      //private var video : VideoView? = null

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          signin.setOnClickListener {
              val intent = Intent(this, LoginActivity::class.java)
              startActivity(intent)
          }
          signup.setOnClickListener {
              val intent = Intent(this, SignupActivity::class.java)
              startActivity(intent)
          }

       /* video = findViewById<VideoView>(R.id.videoIntro);

        var path = "android.resource://" + packageName + "/" + R.raw.sport1
        video?.setVideoURI(Uri.parse(path))
        video?.start()*/
    }
}
