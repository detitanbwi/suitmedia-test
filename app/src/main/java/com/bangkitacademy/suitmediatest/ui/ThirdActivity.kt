package com.bangkitacademy.suitmediatest.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkitacademy.suitmediatest.data.adapter.UserListAdapter
import com.bangkitacademy.suitmediatest.databinding.ActivityThirdScreenBinding
import com.bangkitacademy.suitmediatest.viewmodel.ThirdActivityViewModel
import com.bangkitacademy.suitmediatest.viewmodel.ViewModelFactory

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdScreenBinding
    private val thirdActivityViewModel: ThirdActivityViewModel by viewModels {
        ViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvUserList.layoutManager = LinearLayoutManager(this)

        binding.swipeRefreshLayout.setOnRefreshListener {
            getData()
        }
        getData()
    }


    private fun getData() {
        val adapter = UserListAdapter { selectedUser ->
            val resultIntent = Intent()
            resultIntent.putExtra("SELECTED_USER", selectedUser)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        binding.rvUserList.adapter = adapter

        thirdActivityViewModel.user.observe(this) {
            adapter.submitData(lifecycle, it)
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }
}