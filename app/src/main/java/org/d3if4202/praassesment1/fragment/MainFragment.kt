package org.d3if4202.praassesment1.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if4202.praassesment1.MainActivity

import org.d3if4202.praassesment1.R
import org.d3if4202.praassesment1.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        setHasOptionsMenu(true)
        setActionBar()

        binding.btnPersegiPanjang.setOnClickListener { it.findNavController().navigate(R.id.action_mainFragment_to_persegiPanjangFragment) }

        binding.btnSegitiga.setOnClickListener { it.findNavController().navigate(R.id.action_mainFragment_to_segitigaFragment) }

        return binding.root
    }

    private fun setActionBar(){
        val getActivity = activity as MainActivity
        getActivity.supportActionBar?.title = "Home"
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }


}
