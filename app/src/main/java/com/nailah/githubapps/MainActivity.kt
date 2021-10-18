package com.nailah.githubapps

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //dummy
    private lateinit var dataName : Array<String>
    private lateinit var dataUsername : Array<String>
    private lateinit var dataLocation : Array<String>
    private lateinit var dataCompany : Array<String>
    private lateinit var dataFollower : Array<String>
    private lateinit var dataFollowing : Array<String>
    private lateinit var dataRepository : Array<String>
    private lateinit var dataPhoto : TypedArray
    //model
    private var users = arrayListOf<User>()
    //adapter
    private lateinit var adapter : UserAdapter

    companion object{
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val receiver = intent.getStringExtra(EXTRA_NAME)
        tv_name_main.text = receiver
        adapter = UserAdapter(this)
        lv_main.adapter = adapter
        attachData()
        addItem()
        lv_main.onItemClickListener = AdapterView.OnItemClickListener{_, _, position, _ ->
            val dataSend = User(
                name = users[position].name,
                username = users[position].username,
                location = users[position].location,
                company = users[position].company,
                follower = users[position].follower,
                following = users[position].following,
                repository = users[position].repository,
                photo = users[position].photo
            )
            val intentDetail = Intent(this, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.USER_DATA, dataSend)
            startActivity(intentDetail)
        }
    }

    private fun addItem() {
//        var photo : Int,
//        var name : String?,
//        var username : String?,
//        var location : String?,
//        var company : String?,
//        var follower : String?,
//        var following : String?,
//        var repository : String?
        for (position in dataName.indices){
            val user = User(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataUsername[position],
                dataLocation[position],
                dataCompany[position],
                dataFollower[position],
                dataFollowing[position],
                dataRepository[position]
            )
            users.add(user)
        }
        adapter.users = users
    }

    private fun attachData() {
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataCompany = resources.getStringArray(R.array.company)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
    }
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_NAME, tv_name_main.text.toString())
    }
}