package fi.jamk.weatherapp.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import fi.jamk.weatherapp.MainActivity


class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
        // A new placeholder fragment
        return PlaceholderFragment.newInstance(position)
    }

    override fun getCount(): Int {
        // Size of the forecast in MainActivity
        return MainActivity.forecasts.size
    }
}