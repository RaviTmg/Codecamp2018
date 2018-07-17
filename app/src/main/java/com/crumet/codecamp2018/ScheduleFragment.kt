package com.crumet.codecamp2018


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.crumet.codecamp.EventModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_schedule.view.*
import org.json.JSONException
import org.json.JSONObject


/**
 * A simple [Fragment] subclass.
 *
 */
class ScheduleFragment : Fragment() {
    private val mDataList = ArrayList<EventModel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_schedule, container, false)
        getScheduleData("day1.json")
        v.list_schedule.layoutManager = LinearLayoutManager(context)
        v.list_schedule.adapter = ScheduleAdapter(mDataList, context)
        v.tab_schedule.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (v.tab_schedule.selectedTabPosition === 0) {
                    getScheduleData("day1.json")
                    v.list_schedule.adapter = ScheduleAdapter(mDataList, context)
                } else if (v.tab_schedule.selectedTabPosition === 1) {
                    getScheduleData("day2.json")
                    v.list_schedule.adapter = ScheduleAdapter(mDataList, context)
                } else if (v.tab_schedule.selectedTabPosition === 2) {
                    getScheduleData("day3.json")
                    v.list_schedule.adapter = ScheduleAdapter(mDataList, context)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        return v
    }

    fun getScheduleData(day: String?) {
        mDataList.clear()
        try {
            val jsonUtils = JsonUtils()
            val obj = JSONObject(jsonUtils.loadJSONFromAsset(context, day))
            val jArray = obj.getJSONArray("day")
            for (i in 0 until jArray.length()) {
                val jObj = jArray.getJSONObject(i)
                val titleValue = jObj.getString("title")
                val timeValue = jObj.getString("time")
                mDataList.add(EventModel(timeValue, titleValue))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }


}
