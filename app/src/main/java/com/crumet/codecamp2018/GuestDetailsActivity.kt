package com.crumet.codecamp2018

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_guest_details.*
import kotlinx.android.synthetic.main.content_guest_details.*
import org.json.JSONException
import org.json.JSONObject

class GuestDetailsActivity : AppCompatActivity() {
    private val guestList = ArrayList<GuestModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val tab = intent.getIntExtra("tab", 0)
        val index = intent.getIntExtra("pos", 0)
        var json ="guests.json"
        when {
            tab == 1 ->{
                json = "mentors.json"
            }
            tab == 2->{
                json = "guests.json"
            }
        }
        //guestList.clear()
        try {
            val jsonUtils = JsonUtils()
            val obj = JSONObject(jsonUtils.loadJSONFromAsset(applicationContext, json))
            val jArray = obj.getJSONArray("teams")
            for (i in 0 until jArray.length()) {
                val jObj = jArray.getJSONObject(i)
                val name = jObj.getString("name")
                val title = jObj.getString("title")
                val desc = jObj.getString("desc")
                val profile = jObj.getString("profile")
                guestList.add(GuestModel(name, title, desc, profile))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val guest = guestList.get(index)
        supportActionBar?.setTitle(guest.getName())
        details.setText(guest.getDesc())
        social_link.setText(guest.getProfileLink())
        gu_title.setText(guest.getTitle())
    }
}
