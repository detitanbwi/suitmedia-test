package com.bangkitacademy.suitmediatest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkitacademy.suitmediatest.databinding.ActivitySecondScreenBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondScreenBinding

    private val REQ_PICK_USER = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvName.text = intent.getStringExtra("name")

        binding.btnChooseUser.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(intent, REQ_PICK_USER)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_PICK_USER && resultCode == RESULT_OK) {
            data?.let {
                val selectedUser = it.getStringExtra("SELECTED_USER")
                binding.tvSelectedUsername.text = selectedUser
            }
        }
    }
}