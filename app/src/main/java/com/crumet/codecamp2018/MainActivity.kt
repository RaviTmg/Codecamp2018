package com.crumet.codecamp2018

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast
import androidx.fragment.app.Fragment

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //startActivity(Intent(this, DetailsActivity::class.java))
        setSupportActionBar(toolbar)
        pushFragment(ScheduleFragment())
        botom_navigation
        .setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.schedule -> {
                    pushFragment(ScheduleFragment())
                }
                R.id.sponsors -> {
                    pushFragment(SponsorFragment())
                }
                R.id.about->{
                    pushFragment(AboutFragment())
                }
                R.id.people ->{
                    pushFragment(PeopleFragment())
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    /**
     * Method to push any fragment into given id.
     *
     * @param fragment An instance of Fragment to show into the given id.
     */
    protected fun pushFragment(fragment: Fragment?) {
        if (fragment == null)
            return

        val fragmentManager = supportFragmentManager
        if (fragmentManager != null) {
            val ft = fragmentManager.beginTransaction()
            ft.replace(R.id.container, fragment)
            ft.commit()
        }
    }

}
