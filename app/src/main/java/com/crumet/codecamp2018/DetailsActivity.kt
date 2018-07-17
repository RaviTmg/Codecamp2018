package com.crumet.codecamp2018

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.content_details.*
import org.json.JSONException
import org.json.JSONObject

class DetailsActivity : AppCompatActivity() {
    private val teamList = ArrayList<TeamModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val pos = intent.getIntExtra("pos", 0)

                getTeamData("teams.json")
                var teams = teamList.get(pos)
                detail_title.setText(teams.getShortDetail())
                detail_idea.setText(teams.getIdeaDesc())
                detail_name1.setText(teams.getMember1())
                detail_member2.setText(teams.getMember2())
                detail_member3.setText(teams.getMember3())
                supportActionBar?.setTitle(teams.getName())


    }
    fun getTeamData(day: String?) {
        teamList.clear()
        try {
            val jsonUtils = JsonUtils()
            val obj = JSONObject(jsonUtils.loadJSONFromAsset(applicationContext, day))
            val jArray = obj.getJSONArray("teams")
            for (i in 0 until jArray.length()) {
                val jObj = jArray.getJSONObject(i)
                val titleValue = jObj.getString("team")
                val detailsValue = jObj.getString("title")
                val ideaDetails = jObj.getString("idea_detail")
                val member1 = jObj.getString("name_1")
                val member2 = jObj.getString("name_2")
                val member3 = jObj.getString("name_3")
                teamList.add(TeamModel(titleValue, detailsValue,ideaDetails,member1, member2, member3))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
   /* fun getMentorData(day: String?) {
        mDataList.clear()
        try {
            val jsonUtils = JsonUtils()
            val obj = JSONObject(jsonUtils.loadJSONFromAsset(context, day))
            val jArray = obj.getJSONArray("mentors")
            for (i in 0 until jArray.length()) {
                val jObj = jArray.getJSONObject(i)
                val titleValue = jObj.getString("name")
                val detailsValue = jObj.getString("title")
                mDataList.add(TeamModel(titleValue, detailsValue))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
    fun getGuestData(day: String?) {
        mDataList.clear()
        try {
            val jsonUtils = JsonUtils()
            val obj = JSONObject(jsonUtils.loadJSONFromAsset(context, day))
            val jArray = obj.getJSONArray("guests")
            for (i in 0 until jArray.length()) {
                val jObj = jArray.getJSONObject(i)
                val titleValue = jObj.getString("team")
                val detailsValue = jObj.getString("title")
                mDataList.add(TeamModel(titleValue, detailsValue))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }*/

}
