package com.deliveryhero.whetstone.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deliveryhero.whetstone.viewmodel.injectedViewModel

public class MainActivity : AppCompatActivity() {

    private val viewModel by injectedViewModel<MainViewModel>()
    private val serviceIntent by lazy { Intent(this, MainService::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, viewModel.getHelloWorld(), Toast.LENGTH_SHORT).show()
        startService(serviceIntent)
    }

    override fun onDestroy() {
        stopService(serviceIntent)
        super.onDestroy()
    }
}