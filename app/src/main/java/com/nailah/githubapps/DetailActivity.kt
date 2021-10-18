package com.nailah.githubapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object{
        const val USER_DATA = "user_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()
        arrow_back.setOnClickListener{
            val intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }
        val dataUser = intent.getParcelableExtra<User>(USER_DATA) as User

        //get and set photo
        val dataPhoto = dataUser.photo
        iv_photos_detail.setImageResource(dataPhoto)

        //get and set name
        val dataName = dataUser.name
        tv_name_detail.text = dataName

        //get and set username
        val dataUsername = dataUser.username
        tv_username_detail.text = dataUsername

        //get and set location
        val dataLocation = dataUser.location
        tv_location_detail.text = dataLocation

        //get and set company
        val dataCompany = dataUser.company
        tv_company_detail.text = dataCompany

        //get and set follower
        val dataFollower = dataUser.follower
        tv_follower_number.text = dataFollower

        //get and set following
        val dataFollowing = dataUser.following
        tv_following_number.text = dataFollowing

        //get and set repository
        val dataRepository = dataUser.repository
        tv_repository_number.text = dataRepository
    }
}