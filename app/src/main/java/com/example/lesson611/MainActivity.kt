package com.example.lesson611

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson611.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    companion object{
        const val SEND_DATA = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        oneMethod()
    }

    private fun oneMethod() {
        val launcherData = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK)
                Toast.makeText(this, getString(R.string.mega), Toast.LENGTH_SHORT).show()
            if (result.data!= null) {
                val data = result.data?.getStringExtra(MainActivity2.EXTRA_DATA_NAME)
                binding.etTeg.setText(data)
            }

        }
    binding.btnStart.setOnClickListener {


        if (binding.etTeg.text.trim().isEmpty()) {
            Toast.makeText(this,getString(R.string.text),Toast.LENGTH_SHORT).show()
        } else {
            Intent(this, MainActivity2::class.java).apply {
                putExtra(SEND_DATA, binding.etTeg.text.toString())
                launcherData.launch(this)
            }
        }

    }
    }

}