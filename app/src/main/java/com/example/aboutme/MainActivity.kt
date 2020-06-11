package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager

import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Instance of MyName data class.
    private val myName: MyName = MyName("George Diepiriye")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        // val button : Button = findViewById(R.id.nickname_button)
        binding.nicknameButton.setOnClickListener {
            addNickname(it)
            binding.nicknameButton.visibility = View.GONE
        }


    }

    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = nicknameEditText.text.toString()
            //  binding.nicknameTextView.text = binding.nicknameEditText.text
            binding.nicknameEditText.visibility = View.GONE
            binding.nicknameTextView.visibility = View.VISIBLE
            invalidateAll()
        }

        //hides the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}