package com.tisu.about_me

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.tisu.about_me.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Tisanthan Panchadsaram")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContenView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName= myName
//        findViewById<Button>(R.id.done_button).setOnClickListener{
//            addNickName(it)
//        }
        binding.doneButton.setOnClickListener{
            addNickName(it)
        }
    }
    private fun addNickName(view: View){

        binding.apply {
            //binding.nickNameText.text = binding.nameEditText.text
            myName?.nickname = nameEditText.text.toString()
            invalidateAll()
            binding.doneButton.visibility = View.GONE
            binding.nameEditText.visibility = View.GONE
            binding.nickNameText.visibility = View.VISIBLE
        }

        //KEYBOARD outo hide
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
