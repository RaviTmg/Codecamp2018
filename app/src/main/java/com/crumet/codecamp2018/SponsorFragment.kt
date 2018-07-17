package com.crumet.codecamp2018


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_sponsor.view.*


class SponsorFragment : Fragment() {
    private val mDataList = ArrayList<SponsorModel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_sponsor, container, false)
        mDataList.add(SponsorModel("Genese software solutions","Title Sponsor", "Software company",R.drawable.sp_genese))
        mDataList.add(SponsorModel("AltBlock Pvt. Ltd","Powered by", "Software company",R.drawable.sp_altblock))
        mDataList.add(SponsorModel("Himaus Education consultancy","association with", "Software company",R.drawable.sp_himaus))
        mDataList.add(SponsorModel("IT deurali","Normal Sponsor", "Software company",R.drawable.sp_it_deurali))
        mDataList.add(SponsorModel("Codesastra","Normal Sponsor", "Software company",R.drawable.sp_codesastra))
        mDataList.add(SponsorModel("Jankari technology","Normal Sponsor", "Software company",R.drawable.sp_jankari_tech))
        mDataList.add(SponsorModel("UrjaLabs","Normal Sponsor", "Software company",R.drawable.sp_urja))
        mDataList.add(SponsorModel(" Webpage nepal", "Normal Sponsor", "Software company", R.drawable.sp_webpagenepal))
        mDataList.add(SponsorModel("Midtown Galleria","Normal Sponsor", "Software company",R.drawable.sp_midtown))
        mDataList.add(SponsorModel("Virtual Technology","Normal Sponsor", "Software company",R.drawable.sp_vtech))
        mDataList.add(SponsorModel("Social Development Ministry","Supporter", "Software company",R.drawable.sp_social_dev))
        mDataList.add(SponsorModel("Infomax Pvt Ltd","Supporter", "Software company",R.drawable.sp_infomax))
        mDataList.add(SponsorModel("Metashrine Pvt Ltd","Supporter", "Software company",R.drawable.sp_metashrine))
        mDataList.add(SponsorModel("Lumbini Bank","Banking Partner", "Software company",R.drawable.sp_lumbini))
        mDataList.add(SponsorModel("Hotel Barahi"," Hospitality partner", "Software company",R.drawable.sp_barahi))
        mDataList.add(SponsorModel("Offering Happiness","Happiness partner", "Software company",R.drawable.sp_happiness))
        mDataList.add(SponsorModel("jojiju","sound partner", "Software company",R.drawable.sp_jojiju))
        mDataList.add(SponsorModel("Pokhara Internet","Internet partner", "Software company",R.drawable.sp_pkrnet))
        mDataList.add(SponsorModel("living with ICT","Media partner", "Software company",R.drawable.sp_livingwithict))

        v.list_sponsors.layoutManager = LinearLayoutManager(context)
        v.list_sponsors.adapter = SponsorAdapter(context,mDataList)
        return v
    }


}
