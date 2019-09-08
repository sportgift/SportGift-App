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
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.activity_splash_screen.*
import java.lang.Exception


class SplashScreenActivity : AppCompatActivity() {

    private var logosportgift: ImageView? = null
    private var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        image_sport.bringToFront()
        logo.bringToFront()

        logosportgift = findViewById<ImageView>(R.id.logo)
        image = findViewById<ImageView>(R.id.image_sport)

        animate1()
        animate2()

        val background = object :Thread(){
            override fun run() {
                try{
                    Thread.sleep(2000)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

    /**
     * Animate the logo
     */
    private fun animate1(){
        val animation = AnimatorSet()
        val sX = ObjectAnimator.ofFloat(logosportgift, View.SCALE_X, 0.2f, 1.0f)
        val sY = ObjectAnimator.ofFloat(logosportgift, View.SCALE_Y, 0.2f, 1.0f)
        val fade = ObjectAnimator.ofFloat(logosportgift, View.ALPHA, 0.2f, 1.0f)

        animation.playTogether(sX, sY, fade)
        animation.duration =2000

        val finalAnim = AnimatorSet()

        finalAnim.play(animation)
        finalAnim.start()
    }

    /**
     * Animate the image
     *
     */
    private fun animate2(){

        val animation = AnimatorSet()
        val ty1 = ObjectAnimator.ofFloat(image, View.TRANSLATION_Y, 0f, 50f)
        ty1.interpolator = BounceInterpolator()
        val fade = ObjectAnimator.ofFloat(image, View.ALPHA, 0.2f, 1.0f)
        animation.playTogether(ty1, fade)
        animation.duration= 3000
        val finalAnim = AnimatorSet()

        finalAnim.play(animation)
        finalAnim.start()
    }
}
