package com.example.lesson611

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson611.databinding.ActivityMain2Binding
class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    companion object{
        const val SEND_DATA = "key"
        const val EXTRA_DATA_NAME = "extra_data_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        oneMethod()
    }
    private fun oneMethod () {
        val Data = intent.getStringExtra(SEND_DATA)
        binding.etTag.setText(Data)

        binding.btnStartt.setOnClickListener {
            val data = binding.etTag.text.toString()

            Intent().apply {
                putExtra(EXTRA_DATA_NAME,data)
                setResult(
                    RESULT_OK,
                    this
                )
                finish()
            }
        }
    }
}