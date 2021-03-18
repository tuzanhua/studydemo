package com.tzh.studydemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class DemoAc : AppCompatActivity() {
    private var livedata: MutableLiveData<String> = MutableLiveData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        livedata.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
            }

        })

        livedata.observe(this, Observer {

        })

    }
}