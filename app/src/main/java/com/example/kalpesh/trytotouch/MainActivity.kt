package com.example.kalpesh.trytotouch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var points: Int = 0
    var imageArray = ArrayList<ImageView>()
    private var handler: Handler = Handler()
    private var runnable: Runnable = Runnable {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageArray = arrayListOf(imgVw1,imgVw2,imgVw3,imgVw4,imgVw5,imgVw6,imgVw7,imgVw8,imgVw8,imgVw9)

        points = 0;

        hidimg()

        object: CountDownTimer(10000,1000) {
            override fun onFinish() {

                tv1.text = "Times up"
                handler.removeCallbacks(runnable)
                for (i in imageArray) {
                    i.visibility = View.INVISIBLE
                }
            }

            override fun onTick(p0: Long) {
                tv1.text = "Time: " + p0/1000

            }

        }.start()



    }

    fun increaseScore(view: View) {
        points++
        points1.text = "Points: " + points
    }

    fun hidimg() {
        runnable = object : Runnable {
            override fun run() {
                for (i in imageArray) {
                    i.visibility = View.INVISIBLE
                }

                var random = Random()
                var index: Int = random.nextInt(8-0)
                //Log.v("Random var",index.toString())

                imageArray[index].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }
        handler.post(runnable)

    }
}
