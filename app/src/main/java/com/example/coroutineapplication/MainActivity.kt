package com.example.coroutineapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//VIDEO 2
//class MainActivity : AppCompatActivity() {
//    private val TAG = "MainActivity"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        GlobalScope.launch{
//            //delay for 3 secs
//            delay(10000L)
//            Log.d(TAG, "Coroutine is running in the thread ${Thread.currentThread().name}")
//
//        }
//        Log.d(TAG, "Outside Coroutine, In the main function, the thread is ${Thread.currentThread().name}")
//    }
//}


//VIDEO 3
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            //not simultaneously, 3000 then ans then 3000 then ans
            val networkCallAnswer = doNetworkCall()
            Log.d(TAG, networkCallAnswer)
            val networkCallAnswer2 = doNetworkCall2()
            Log.d(TAG, networkCallAnswer2)
        }
    }

    //simulate a network cal by delaying
    suspend fun doNetworkCall() : String{
        delay(3000L)
        return "This is a network call."
    }

    suspend fun doNetworkCall2() : String{
        delay(3000L)
        return "This is a network call2."
    }
}

//VIDEO 4 :
//class MainActivity : AppCompatActivity() {
//    private val TAG = "MainActivity"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        //diff dispatchers
//        GlobalScope.launch(Dispatchers.IO){
//            val answer = doNetworkCall()
//            //switch context
//            withContext(Dispatchers.Main){
//                val tvDummy = findViewById<TextView>(R.id.dummy)
//                tvDummy.text = answer
//            }
//        }
//    }
//    suspend fun doNetworkCall() : String{
//        delay(3000L)
//        return "This is a network call."
//    }
//}

//delay vs sleep :
//class MainActivity : AppCompatActivity() {
//    private val TAG = "MainActivity"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        GlobalScope.launch(context = Dispatchers.Main) {
//            Log.d(TAG, "launched coroutine 1")
//            delay(5000)
//            Log.d(TAG, "Here after a delay of 5 seconds")
//        }
//        GlobalScope.launch(context = Dispatchers.Main) {
//            Log.d(TAG, "launched coroutine 2")
//        }
//    }
//}


//VIDEO 5 :
//class MainActivity : AppCompatActivity() {
//    private val TAG = "MainActivity"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
////        delay(1000L)
//        Log.d(TAG, "Before Run Blocking")
//
//        runBlocking{
//            Log.d(TAG, "Start of Run Blocking : ")
//            //will block the main thread, ui will halt
//            delay(5000L)
//            Log.d(TAG, "End of Run Blocking : ")
//        }
//        Log.d(TAG, "After Run Blocking : ")
//    }
//}

//same as
//class MainActivity : AppCompatActivity() {
//    private val TAG = "MainActivity"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        Log.d(TAG, "Before Run Blocking")
//        Log.d(TAG, "Start of Run Blocking : ")
//        Thread.sleep(5000L)
//        Log.d(TAG, "End of Run Blocking : ")
//        Log.d(TAG, "After Run Blocking : ")
//    }
//}


//VIDEO 5 :
//class MainActivity : AppCompatActivity() {
//    private val TAG = "MainActivity"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
////        delay(1000L)
//        Log.d(TAG, "Before Run Blocking")
//
//        runBlocking{
//            launch(Dispatchers.IO){
//                delay(3000L)
//                Log.d(TAG, "Finished IO Coroutine 1 : ")
//            }
//            launch(Dispatchers.IO){
//                delay(3000L)
//                Log.d(TAG, "Finished IO Coroutine 2 : ")
//            }
//            Log.d(TAG, "Start of Run Blocking : ")
//            //will block the main thread, ui will halt
//            delay(5000L)
//            Log.d(TAG, "End of Run Blocking : ")
//        }
//        Log.d(TAG, "After Run Blocking : ")
//    }
//}