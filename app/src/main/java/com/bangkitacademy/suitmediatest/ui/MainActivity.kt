package com.bangkitacademy.suitmediatest.ui

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bangkitacademy.suitmediatest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var textPal: String

        binding.btnNext.setOnClickListener {
            val name = binding.edName.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }

        binding.btnCheck.setOnClickListener {
            textPal = binding.edPalindrome.text.toString()
            Log.d("Click button", "true")
            showAlertDialog(this,"Palindrome Check", if (isPalindrome(textPal)) "isPalindrome" else "not palindrome")
        }

    }

    private fun isPalindrome(str: String): Boolean {
        val cleanStr = str.lowercase().replace(Regex("[^a-zA-Z0-9]"), "")
        return cleanStr == cleanStr.reversed()
    }

    private fun showAlertDialog(
        context: Context,
        title: String,
        message: String,
        positiveButtonText: String = "OK",
        positiveButtonClickListener: (() -> Unit)? = null
    ) {
        Log.d("Function Called", "true")
        val builder = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)

        if (positiveButtonText.isNotEmpty()) {
            builder.setPositiveButton(positiveButtonText) { _, _ ->
                positiveButtonClickListener?.invoke()
            }
        }

        val dialog = builder.create()
        dialog.show()
    }

}