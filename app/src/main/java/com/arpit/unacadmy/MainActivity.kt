package com.arpit.unacadmy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arpit.unacadmy.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import me.tankery.lib.circularseekbar.CircularSeekBar

class MainActivity : AppCompatActivity() {

    private var previousVal = 0
    lateinit var seekBar: CircularSeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel

        seekBar = findViewById(R.id.seek_bar)

        viewModel.progressState.observe(this, Observer {
            hideKeyboard(root_layout)
            if (it > previousVal) {
                for (i in 0 until it) {
                    seekBar.progress = i.toFloat()
                }
            } else {
                for (i in previousVal downTo it) {
                    seekBar.progress = i.toFloat()
                }
            }
            previousVal = it
        })
    }
}
