package com.nailah.githubapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity(), View.OnClickListener {
    companion object{
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        supportActionBar?.hide()
        btn_send.setOnClickListener (this)
    }

    override fun onClick(p0: View?) {
        val inputName : String = et_intro_name.text.toString().trim()
        val intentMain = Intent(this, MainActivity::class.java)
        intentMain.putExtra(EXTRA_NAME, inputName)
        startActivity(intentMain)
    }
}