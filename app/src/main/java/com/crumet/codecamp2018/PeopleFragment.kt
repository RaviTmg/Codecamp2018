package com.crumet.codecamp2018


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_people.view.*
import org.json.JSONException
import org.json.JSONObject


/**
 * A simple [Fragment] subclass.
 *
 */
class PeopleFragment : Fragment() {
    private val mDataList = ArrayList<TeamModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_people, container, false)
        getTeamData("teams.json")
        v.list_people.layoutManager = GridLayoutManager(context,2)
        v.list_people.adapter = PeopleAdapter(context, mDataList)
        v.tab_people.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when {
                    v.tab_people.selectedTabPosition === 0 -> {
                        getTeamData("teams.json")
                        v.list_people.adapter = PeopleAdapter(context, mDataList,0)
                    }
                    v.tab_people.selectedTabPosition === 1 -> {
                        getMentorData("mentors.json")
                        v.list_people.adapter = PeopleAdapter(context, mDataList,1)
                    }
                    v.tab_people.selectedTabPosition === 2 -> {
                        getGuestData("guests.json")
                        v.list_people.adapter = PeopleAdapter(context, mDataList,2)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        return v
    }

    fun getTeamData(day: String?) {
        mDataList.clear()
        try {
            val jsonUtils = JsonUtils()
            val obj = JSONObject(jsonUtils.loadJSONFromAsset(context, day))
            val jArray = obj.getJSONArray("teams")
            for (i in 0 until jArray.length()) {
                val jObj = jArray.getJSONObject(i)
                val titleValue = jObj.getString("team")
                val detailsValue = jObj.getString("title")
                mDataList.add(TeamModel(titleValue, detailsValue))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
    fun getMentorData(day: String?) {
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
                val titleValue = jObj.getString("name")
                val detailsValue = jObj.getString("title")
                mDataList.add(TeamModel(titleValue, detailsValue))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }


}
