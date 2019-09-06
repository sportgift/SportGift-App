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
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    private val url = "https://www.sportgift.io/app.html"

    private var ball: ImageView? = null
    private var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)

        hlnt_iv_load.bringToFront()
        logo.bringToFront()

        ball = findViewById<ImageView>(R.id.logo);
        image = findViewById<ImageView>(R.id.hlnt_iv_load);

        animate1()
        animate2()

        val intent = Intent(this, LoginActivity::class.java)
        // To pass any data to next activity
        intent.putExtra("keyIdentifier", 1L)
        intent.setFlags(Intent.FLAG_ACTIVITY_TASK_ON_HOME )
        Handler().postDelayed({
            startActivity(intent)
        }, 3000)

        // start your next activity
        //startActivity(intent)

    }

    private fun animate1(){
        val anims1 = AnimatorSet()
        val sX = ObjectAnimator.ofFloat(ball, View.SCALE_X, 0.2f, 1.0f)
        val sY = ObjectAnimator.ofFloat(ball, View.SCALE_Y, 0.2f, 1.0f)
        val fade = ObjectAnimator.ofFloat(ball, View.ALPHA, 0.2f, 1.0f)

        anims1.playTogether(sX, sY, fade)
        anims1.setDuration(2000)

        val finalAnim = AnimatorSet();

        finalAnim.play(anims1)
        finalAnim.start()
    }

    private fun animate2(){

        val anims1 = AnimatorSet()
        val ty1 = ObjectAnimator.ofFloat(image, View.TRANSLATION_Y, 0f, 50f)
        ty1.interpolator = BounceInterpolator()
        val fade = ObjectAnimator.ofFloat(image, View.ALPHA, 0.2f, 1.0f)
        anims1.playTogether(ty1, fade)
        anims1.setDuration(3000)

        val finalAnim = AnimatorSet();

        finalAnim.play(anims1)
        finalAnim.start()
    }
}
