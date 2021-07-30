package com.yubin.memo60.splash

import android.animation.ObjectAnimator
import android.animation.ValueAnimator.INFINITE
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import com.yubin.memo60.BaseActivity
import com.yubin.memo60.R
import com.yubin.memo60.databinding.ActivitySplashBinding
import com.yubin.memo60.main.MainActivity
import com.yubin.memo60.signin.SignInActivity
import java.util.*
import kotlin.concurrent.schedule


class SplashActivity : BaseActivity() {

//    private lateinit var binding: ActivitySplashBinding
    private lateinit var logoAnimation : AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    //        val animationDrawable : AnimationDrawable = logoIv.background as AnimationDrawable
    //        animationDrawable.start()

    //        val animBall : Animation = AnimationUtils.loadAnimation(this@SplashActivity, R.drawable.anim_splash_ball2)
    //        logoIv.startAnimation(animBall)
    }

    override fun onStart() {
        super.onStart()

        val logoIv = findViewById<ImageView>(R.id.splash_logo_iv).apply{
            setBackgroundResource(R.drawable.anim_sticker)
            logoAnimation = background as AnimationDrawable
        }
        logoAnimation.start()
//        val logoIv : ImageView = findViewById(R.id.splash_logo_iv)
////        val animBall : Animation = AnimationUtils.loadAnimation(this@SplashActivity, R.drawable.anim_splash_ball2)
////        logoIv.startAnimation(animBall)
//
//        val animationDrawable : AnimationDrawable = logoIv.background as AnimationDrawable
//        animationDrawable.start()
    }

    override fun onResume() {
        super.onResume()

        Timer().schedule(5000) {
            autoLogin()
        }
    }

    private fun autoLogin(){
        val spf : SharedPreferences = getSharedPreferences("memoapp", MODE_PRIVATE)
        val token = spf.getInt("token", 0)

        Log.d("splash-token", "$token")
        if (token!=0){
            startMainActivity()
            return
        }else{
            startSignInActivity()
        }
    }

    private fun startMainActivity(){
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startSignInActivity(){
        val intent = Intent(this@SplashActivity, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onClick(v: View?) {
        super.onClick(v)
    }
}