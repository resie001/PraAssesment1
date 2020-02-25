package org.d3if4202.praassesment1.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.d3if4202.praassesment1.MainActivity
import org.d3if4202.praassesment1.R
import org.d3if4202.praassesment1.databinding.FragmentPersegiPanjangBinding
import java.text.DecimalFormat

/**
 * A simple [Fragment] subclass.
 *
 */
class PersegiPanjangFragment : Fragment() {

    private lateinit var binding: FragmentPersegiPanjangBinding
    private var keliling = 0.0
    private var luas = 0.0
    private var panjang = 0.0
    private var lebar = 0.0
    private val df = DecimalFormat("#.##")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        setActionBar()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_persegi_panjang, container, false)

        binding.btnHitung.setOnClickListener { checkInput() }

        binding.btnShare.setOnClickListener { shareWithEmail() }

        return binding.root
    }

    private fun checkInput(){
        if (binding.edPanjang.text.isEmpty() || binding.edLebar.text.isEmpty()){
            Toast.makeText(activity, "Inputan Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show()
        } else {
            calculate()
        }
    }

    private fun calculate(){
        panjang = binding.edPanjang.text.toString().toDouble()
        lebar = binding.edLebar.text.toString().toDouble()

        luas = panjang * lebar
        keliling = 2 * ( panjang + lebar )

        binding.tvResultLuas.visibility = View.VISIBLE
        binding.tvResultLuas.text = df.format(luas).toString()

        binding.tvResultKeliling.visibility = View.VISIBLE
        binding.tvResultKeliling.text = df.format(keliling).toString()
    }

    private fun shareWithEmail(){
        if (binding.tvResultLuas.text.isEmpty()){
            Toast.makeText(activity, "Hasil belum dihitung!", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(Intent.ACTION_SENDTO)
            val subject = "Hasil Perhitungan Persegi Panjang"
            val text = """
                Panjang : $panjang
                Lebar : $lebar
                Keliling : $keliling
                Luas : $luas
            """.trimIndent()
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(intent)
        }
    }

    private fun setActionBar(){
        val getActivity = activity as MainActivity
        getActivity.supportActionBar?.title = "Persegi Panjang"
        getActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("Keliling", keliling)
        outState.putDouble("Luas", luas)
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        if (savedInstanceState != null){
            keliling = savedInstanceState.getDouble("Keliling")
            luas = savedInstanceState.getDouble("Luas")

            binding.tvResultLuas.visibility = View.VISIBLE
            binding.tvResultLuas.text = df.format(luas).toString()

            binding.tvResultKeliling.visibility = View.VISIBLE
            binding.tvResultKeliling.text = df.format(keliling).toString()
        }
        super.onViewStateRestored(savedInstanceState)
    }
}
