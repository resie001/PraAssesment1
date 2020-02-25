package org.d3if4202.praassesment1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.d3if4202.praassesment1.MainActivity

import org.d3if4202.praassesment1.R
/**
 * A simple [Fragment] subclass.
 *
 */
class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setActionBar()
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    private fun setActionBar(){
        val getActivity = activity as MainActivity
        getActivity.supportActionBar?.title = "About"
        getActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
