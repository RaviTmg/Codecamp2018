package com.crumet.codecamp2018


import android.content.ActivityNotFoundException
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_about.view.*
import android.content.Intent
import android.net.Uri
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 *
 */
class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_about, container, false)
        v.location.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:28.2540628,83.9760958?q=Electrical+department,paschimanchal+campus?z=18.5?")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

            startActivity(mapIntent)
        }
        v.play_video.setOnClickListener {
            //Toast.makeText(context,"To be added in next update",Toast.LENGTH_LONG).show()
            val inte = Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("vnd.youtube:-QZEta3wXTM"))
            startActivity(inte)

        }
        v.fb_event.setOnClickListener{
            startActivity(Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/events/467702083699884")))
        }

        return v
    }


}
