package com.ec.app.sportgiftapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Bitmap
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Build
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.webkit.*
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private val url = "https://www.sportgift.io"

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

        // Get the web view settings instance
        val settings = web_view.settings

        // Enable java script in web view
        settings.javaScriptEnabled = true

        // More web view settings
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settings.safeBrowsingEnabled = true  // api 26
        }
        //settings.pluginState = WebSettings.PluginState.ON
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            settings.mediaPlaybackRequiresUserGesture = false
        }

        web_view.loadUrl(url);

        // Set web view client
        web_view.webViewClient = object: WebViewClient(){
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                // Page loading started
                // Do something
            }

            override fun onPageFinished(view: WebView, url: String) {
                // Page loading finished
            }
        }

        // Set web view chrome client
        web_view.webChromeClient = object: WebChromeClient(){
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                progress_bar.progress = newProgress

                //display web page
                if (newProgress > 99){
                    hlnt_iv_load.visibility = View.GONE
                    logo.visibility = View.GONE
                    web_view.visibility = View.VISIBLE
                    supportActionBar!!.show()
                }
                Log.d("Progress",newProgress.toString())
            }
        }
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
